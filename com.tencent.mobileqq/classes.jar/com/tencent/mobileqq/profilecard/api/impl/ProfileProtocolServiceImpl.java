package com.tencent.mobileqq.profilecard.api.impl;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileHandlerApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.profilecard.handler.ProfileCardHandler;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import com.tencent.mobileqq.profilecard.processor.ProfileBusinessProcessorFactory;
import com.tencent.mobileqq.profilecard.servlet.ProfileCardServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ProfileProtocolServiceImpl
  implements IProfileProtocolService
{
  private static final String TAG = "ProfileCardProtocolServiceImpl";
  private AppRuntime appRuntime;
  private ProfileBusinessProcessorFactory processorFactory;
  
  private ProfileCardHandler getProfileCardHandler()
  {
    String str = ((IProfileHandlerApi)QRoute.api(IProfileHandlerApi.class)).getProfileCardHandler();
    return (ProfileCardHandler)((AppInterface)this.appRuntime).getBusinessHandler(str);
  }
  
  public static ProfileProtocolServiceImpl getProfileProtocolService(AppRuntime paramAppRuntime)
  {
    return (ProfileProtocolServiceImpl)paramAppRuntime.getRuntimeService(IProfileProtocolService.class, "all");
  }
  
  private boolean isContactCardResponse(long paramLong, int paramInt)
  {
    return (paramLong <= 0L) && (paramInt != 41) && (paramInt != 6) && (paramInt != 45);
  }
  
  private void notifyUI(int paramInt, boolean paramBoolean, Object paramObject)
  {
    getProfileCardHandler().notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  private ContactCard processContactCard(Bundle paramBundle, RespSummaryCard paramRespSummaryCard)
  {
    boolean bool = true;
    Object localObject = paramBundle.getString("searchName");
    paramBundle = (IProfileDataService)this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
    localObject = paramBundle.getContactCardByMobileNo((String)localObject, true);
    ((ContactCard)localObject).bAge = paramRespSummaryCard.bAge;
    ((ContactCard)localObject).bSex = paramRespSummaryCard.bSex;
    ((ContactCard)localObject).nickName = paramRespSummaryCard.strNick;
    ((ContactCard)localObject).strProvince = paramRespSummaryCard.strProvince;
    ((ContactCard)localObject).strCountry = paramRespSummaryCard.strCountry;
    ((ContactCard)localObject).strCity = paramRespSummaryCard.strCity;
    ((ContactCard)localObject).strContactName = paramRespSummaryCard.strContactName;
    if (paramRespSummaryCard.iContactNotBindQQ != 1)
    {
      ((ContactCard)localObject).bindQQ = bool;
      if (paramRespSummaryCard.lUIN <= 0L) {
        break label151;
      }
    }
    label151:
    for (((ContactCard)localObject).uin = String.valueOf(paramRespSummaryCard.lUIN);; ((ContactCard)localObject).uin = "")
    {
      paramBundle.saveContactCard((ContactCard)localObject);
      return localObject;
      bool = false;
      break;
    }
  }
  
  private Card processProfileCard(Bundle paramBundle, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard)
  {
    long l = paramBundle.getLong("targetUin");
    IProfileDataService localIProfileDataService = (IProfileDataService)this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
    Card localCard = localIProfileDataService.getProfileCard(String.valueOf(l), true);
    Object localObject1 = this.processorFactory.getBusinessProcessors(this.appRuntime);
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((AbsProfileBusinessProcessor)((Iterator)localObject2).next()).onProcessProfileCard(paramBundle, localCard, paramRespHead, paramRespSummaryCard);
    }
    if (paramRespSummaryCard.vvRespServices != null) {
      try
      {
        localObject2 = BusinessRespBuffer.parseBusinessRespBuffer(paramRespSummaryCard.vvRespServices);
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext()) {
          ((AbsProfileBusinessProcessor)localIterator.next()).onProcessProfileService(paramBundle, localCard, paramRespHead, paramRespSummaryCard, (SparseArray)localObject2);
        }
        if (paramRespSummaryCard.vResp0x5ebInfo == null) {
          break label240;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ProfileCardProtocolServiceImpl", 1, "processProfileCard process service fail.", localException);
      }
    } else {
      try
      {
        oidb_0x5eb.UdcUinData localUdcUinData = new oidb_0x5eb.UdcUinData();
        localUdcUinData.mergeFrom(paramRespSummaryCard.vResp0x5ebInfo);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((AbsProfileBusinessProcessor)((Iterator)localObject1).next()).onProcessProfile0x5eb(paramBundle, localCard, paramRespHead, paramRespSummaryCard, localUdcUinData);
        }
        localIProfileDataService.saveProfileCard(localCard);
      }
      catch (Exception paramBundle)
      {
        QLog.e("ProfileCardProtocolServiceImpl", 1, "processProfileCard process 0x5eb fail.", paramBundle);
      }
    }
    label240:
    return localCard;
  }
  
  public <T extends AbsProfileBusinessProcessor> T getBusinessProcessor(Class<? extends AbsProfileBusinessProcessor> paramClass)
  {
    Object localObject = null;
    Iterator localIterator = this.processorFactory.getBusinessProcessors(this.appRuntime).iterator();
    if (localIterator.hasNext())
    {
      AbsProfileBusinessProcessor localAbsProfileBusinessProcessor = (AbsProfileBusinessProcessor)localIterator.next();
      if (!localAbsProfileBusinessProcessor.getClass().equals(paramClass)) {
        break label59;
      }
      localObject = localAbsProfileBusinessProcessor;
    }
    label59:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  public void getProfileDetail(String paramString, List<Short> paramList, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardProtocolServiceImpl", 2, String.format("getProfileDetail targetUin=%s reqFields=%s serviceType=%s params=%s", new Object[] { paramString, Arrays.toString(paramList.toArray()), Integer.valueOf(paramInt), paramBundle }));
    }
    try
    {
      long l = Long.parseLong(paramString);
      short s = (short)paramList.size();
      paramString = paramBundle;
      if (paramBundle == null) {
        paramString = new Bundle();
      }
      paramBundle = ByteBuffer.allocate(s * 2 + 7);
      paramBundle.putInt((int)l);
      paramBundle.put((byte)0);
      paramBundle.putShort(s);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramBundle.putShort(((Short)paramList.next()).shortValue());
      }
      paramList = new oidb_sso.OIDBSSOPkg();
    }
    catch (Exception paramString)
    {
      QLog.e("ProfileCardProtocolServiceImpl", 1, "getProfileDetail fail.", paramString);
      return;
    }
    paramList.uint32_command.set(1152);
    paramList.uint32_service_type.set(paramInt);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramBundle.array()));
    paramBundle = getProfileCardHandler();
    ToServiceMsg localToServiceMsg = paramBundle.createToServiceMsg("OidbSvc.0x480_9_IMCore");
    localToServiceMsg.putWupBuffer(paramList.toByteArray());
    localToServiceMsg.extraData.putAll(paramString);
    paramBundle.sendPbReq(localToServiceMsg);
  }
  
  public void getProfileDetailForEdit()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardProtocolServiceImpl", 2, "getProfileDetailForEdit");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)27037));
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)24008));
    localArrayList.add(Short.valueOf((short)24002));
    localArrayList.add(Short.valueOf((short)20043));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)20011));
    localArrayList.add(Short.valueOf((short)20019));
    localArrayList.add(Short.valueOf((short)20021));
    localArrayList.add(Short.valueOf((short)20037));
    localArrayList.add(Short.valueOf((short)-23408));
    localArrayList.add(Short.valueOf((short)-23213));
    localArrayList.add(Short.valueOf((short)-23196));
    localArrayList.add(Short.valueOf((short)-23180));
    localArrayList.add(Short.valueOf((short)-23175));
    localArrayList.add(Short.valueOf((short)-23169));
    localArrayList.add(Short.valueOf((short)-23159));
    localArrayList.add(Short.valueOf((short)-23364));
    getProfileDetail(this.appRuntime.getCurrentUin(), localArrayList, 9, null);
  }
  
  public void getProfileDetailForLogin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardProtocolServiceImpl", 2, "getProfileDetailForLogin");
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.processorFactory.getBusinessProcessors(this.appRuntime).iterator();
    while (localIterator.hasNext()) {
      ((AbsProfileBusinessProcessor)localIterator.next()).onGetProfileDetailRequestForLogin(localArrayList);
    }
    getProfileDetail(this.appRuntime.getCurrentUin(), localArrayList, 9, null);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
    this.processorFactory = new ProfileBusinessProcessorFactory();
  }
  
  public void onDestroy() {}
  
  public void requestProfileCard(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("selfUin");
    long l2 = paramBundle.getLong("targetUin");
    int i = paramBundle.getInt("comeFromType");
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardProtocolServiceImpl", 2, String.format("requestProfileCard selfUin=%s targetUin=%s comeFromType=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) }));
    }
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.processorFactory.getBusinessProcessors(this.appRuntime).iterator();
    while (localIterator.hasNext()) {
      ((AbsProfileBusinessProcessor)localIterator.next()).onRequestProfileCard(paramBundle, (ArrayList)localObject, localArrayList);
    }
    paramBundle.putParcelableArrayList("reqServiceList", (ArrayList)localObject);
    paramBundle.putIntegerArrayList("req0x5ebList", localArrayList);
    localObject = new NewIntent(this.appRuntime.getApplicationContext(), ProfileCardServlet.class);
    ((NewIntent)localObject).putExtra("cmdID", 1);
    ((NewIntent)localObject).putExtras(paramBundle);
    this.appRuntime.startServlet((NewIntent)localObject);
  }
  
  public void requestProfileCard(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, byte paramByte2)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      paramString1 = new Bundle();
      paramString1.putLong("selfUin", l1);
      paramString1.putLong("targetUin", l2);
      paramString1.putInt("comeFromType", paramInt1);
      paramString1.putLong("qZoneFeedTimeStamp", paramLong1);
      paramString1.putByte("isFriend", paramByte1);
      paramString1.putLong("troopCode", paramLong2);
      paramString1.putLong("troopUin", paramLong3);
      paramString1.putByteArray("qZoneSeed", paramArrayOfByte1);
      paramString1.putString("searchName", paramString3);
      paramString1.putLong("getControl", paramLong4);
      paramString1.putInt("addFriendSource", paramInt2);
      paramString1.putByteArray("secureSig", paramArrayOfByte2);
      paramString1.putByte("reqMedalWall", paramByte2);
      paramString1.putByte("reqExtendFriend", (byte)1);
      requestProfileCard(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("ProfileCardProtocolServiceImpl", 1, "requestProfileCard fail.", paramString1);
    }
  }
  
  public void responseGetProfileDetail(Bundle paramBundle, boolean paramBoolean, int paramInt, Object paramObject)
  {
    IProfileDataService localIProfileDataService = null;
    Iterator localIterator = null;
    List localList = this.processorFactory.getBusinessProcessors(this.appRuntime);
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsProfileBusinessProcessor)((Iterator)localObject).next()).onGetProfileDetailResponseBegin(paramBundle);
    }
    localObject = localIProfileDataService;
    boolean bool = paramBoolean;
    int j = paramInt;
    if (paramBoolean)
    {
      localObject = localIterator;
      j = paramInt;
    }
    ByteBuffer localByteBuffer;
    Long localLong;
    short s1;
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        localObject = localIterator;
        j = paramInt;
        if (!paramObject.uint32_result.has()) {
          break label445;
        }
        localObject = localIterator;
        j = paramInt;
        paramInt = paramObject.uint32_result.get();
        if (paramInt != 0) {
          break label440;
        }
        paramBoolean = true;
      }
      catch (Exception paramObject)
      {
        bool = false;
        QLog.e("ProfileCardProtocolServiceImpl", 1, "responseGetProfileCard fail.", paramObject);
      }
      localObject = localIProfileDataService;
      bool = paramBoolean;
      j = paramInt;
      if (paramBoolean)
      {
        localObject = localIterator;
        j = paramInt;
        localByteBuffer = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray());
        localObject = localIterator;
        j = paramInt;
        localLong = Long.valueOf(Utils.a(localByteBuffer.getInt()));
        localObject = localIterator;
        j = paramInt;
        localByteBuffer.get();
        localObject = localIterator;
        j = paramInt;
        s1 = localByteBuffer.getShort();
        localObject = localIterator;
        j = paramInt;
        if (QLog.isColorLevel())
        {
          localObject = localIterator;
          j = paramInt;
          QLog.i("ProfileCardProtocolServiceImpl", 2, String.format("responseGetProfileCard uin=%s tlvCount=%s", new Object[] { localLong, Short.valueOf(s1) }));
        }
        localObject = localIterator;
        j = paramInt;
        localIProfileDataService = (IProfileDataService)this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
        localObject = localIterator;
        j = paramInt;
        paramObject = localIProfileDataService.getProfileCard(String.valueOf(localLong), true);
        localObject = paramObject;
        j = paramInt;
        localIterator = localList.iterator();
        localObject = paramObject;
        j = paramInt;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = paramObject;
        j = paramInt;
        ((AbsProfileBusinessProcessor)localIterator.next()).onGetProfileDetailTLVBegin(paramBundle, localLong.longValue(), paramObject);
        continue;
      }
      label400:
      paramObject = localList.iterator();
      while (paramObject.hasNext()) {
        ((AbsProfileBusinessProcessor)paramObject.next()).onGetProfileDetailResponseEnd(paramBundle, bool, (Card)localObject);
      }
      label440:
      paramBoolean = false;
      break label898;
      label445:
      paramBoolean = false;
    }
    short s3 = 0;
    localObject = paramObject;
    j = paramInt;
    int m = localByteBuffer.position();
    for (;;)
    {
      localObject = paramObject;
      j = paramInt;
      if ((localByteBuffer.hasRemaining()) && (s3 < s1))
      {
        localObject = paramObject;
        j = paramInt;
        localByteBuffer.position(m);
        localObject = paramObject;
        j = paramInt;
        short s2 = localByteBuffer.getShort();
        localObject = paramObject;
        j = paramInt;
        int i = localByteBuffer.getShort();
        localObject = paramObject;
        j = paramInt;
        m = localByteBuffer.position() + i;
        localObject = paramObject;
        j = paramInt;
        if (QLog.isColorLevel())
        {
          localObject = paramObject;
          j = paramInt;
          QLog.d("ProfileCardProtocolServiceImpl", 2, String.format("responseGetProfileCard K=%s, L=%s, nextTLVPosition=%s", new Object[] { Short.valueOf(s2), Short.valueOf(i), Integer.valueOf(m) }));
        }
        localObject = paramObject;
        j = paramInt;
        localIterator = localList.iterator();
        for (;;)
        {
          localObject = paramObject;
          j = paramInt;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = paramObject;
          j = paramInt;
          ((AbsProfileBusinessProcessor)localIterator.next()).onGetProfileDetailTLV(paramBundle, localLong.longValue(), paramObject, s2, i, localByteBuffer);
        }
      }
      localObject = paramObject;
      j = paramInt;
      localIterator = localList.iterator();
      for (;;)
      {
        localObject = paramObject;
        j = paramInt;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = paramObject;
        j = paramInt;
        ((AbsProfileBusinessProcessor)localIterator.next()).onGetProfileDetailTLVEnd(paramBundle, localLong.longValue(), paramObject);
      }
      localObject = paramObject;
      j = paramInt;
      if (paramBundle.getBoolean("parse_profile_location"))
      {
        localObject = paramObject;
        j = paramInt;
        localIterator = localList.iterator();
        for (;;)
        {
          localObject = paramObject;
          j = paramInt;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = paramObject;
          j = paramInt;
          ((AbsProfileBusinessProcessor)localIterator.next()).requestParseProfileLocation(paramObject);
        }
      }
      localObject = paramObject;
      j = paramInt;
      localIProfileDataService.saveProfileCard(paramObject);
      localObject = paramObject;
      bool = paramBoolean;
      j = paramInt;
      break label400;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardProtocolServiceImpl", 2, String.format("responseGetProfileCard success=%s resultCode=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) }));
      }
      notifyUI(1002, bool, localObject);
      return;
      label898:
      break;
      int k;
      s3 += 1;
    }
  }
  
  public void responseProfileCard(Bundle paramBundle, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard)
  {
    boolean bool;
    if ((paramRespHead != null) && (paramRespSummaryCard != null)) {
      if (paramRespHead.iResult == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      long l1 = paramBundle.getLong("selfUin");
      long l2 = paramBundle.getLong("targetUin");
      int i = paramBundle.getInt("comeFromType");
      String str = paramBundle.getString("searchName");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardProtocolServiceImpl", 2, String.format("responseProfileCard selfUin=%s targetUin=%s comeFromType=%s success=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Boolean.valueOf(bool) }));
      }
      Iterator localIterator = this.processorFactory.getBusinessProcessors(this.appRuntime).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ((AbsProfileBusinessProcessor)localIterator.next()).onResponseProfileCard(bool, paramBundle, paramRespHead, paramRespSummaryCard);
          continue;
          bool = false;
          break;
        }
      }
      if (bool)
      {
        if (isContactCardResponse(l2, i))
        {
          notifyUI(1001, true, processContactCard(paramBundle, paramRespSummaryCard));
          return;
        }
        notifyUI(1001, true, processProfileCard(paramBundle, paramRespHead, paramRespSummaryCard));
        return;
      }
      if (l2 <= 0L) {}
      for (paramBundle = str;; paramBundle = String.valueOf(l2))
      {
        notifyUI(1001, false, paramBundle);
        return;
      }
      bool = false;
    }
  }
  
  public void setProfileDetail(Bundle paramBundle)
  {
    getProfileCardHandler().setProfileDetail(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.impl.ProfileProtocolServiceImpl
 * JD-Core Version:    0.7.0.1
 */