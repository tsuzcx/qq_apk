package com.tencent.mobileqq.profilecard.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.impl.ProfileProtocolServiceImpl;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileCodecUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ProfileCardHandler
  extends BusinessHandler
  implements IProfileProtocolConst
{
  private static final String TAG = "ProfileCardHandler";
  
  public ProfileCardHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void handlerSetProfileDetailInner(Bundle paramBundle, Card paramCard)
  {
    Object localObject;
    if (paramBundle.containsKey("nick"))
    {
      localObject = paramBundle.getString("nick");
      paramCard.strNick = ((String)localObject);
      ((IFriendNameService)this.appRuntime.getRuntimeService(IFriendNameService.class, "all")).saveFriendRemark(this.appRuntime.getCurrentUin(), (String)localObject);
    }
    if (paramBundle.containsKey("sex")) {
      paramCard.shGender = ((short)paramBundle.getByte("sex"));
    }
    if (paramBundle.containsKey("birthday"))
    {
      paramCard.lBirthday = paramBundle.getInt("birthday");
      paramCard.age = ((byte)paramBundle.getInt("age"));
      paramCard.constellation = paramBundle.getInt("key_constellation");
    }
    if (paramBundle.containsKey("profession")) {
      paramCard.iProfession = paramBundle.getInt("profession");
    }
    if (paramBundle.containsKey("company")) {
      paramCard.strCompany = paramBundle.getString("company");
    }
    if (paramBundle.containsKey("college")) {
      paramCard.strSchool = paramBundle.getString("college");
    }
    StringBuilder localStringBuilder;
    if (paramBundle.containsKey("location"))
    {
      localObject = paramBundle.getStringArray("location");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject[0]);
      localStringBuilder.append("-");
      localStringBuilder.append(localObject[1]);
      localStringBuilder.append("-");
      localStringBuilder.append(localObject[2]);
      localStringBuilder.append("-");
      localStringBuilder.append(localObject[3]);
      paramCard.strLocationCodes = localStringBuilder.toString();
      paramCard.strLocationDesc = paramBundle.getString("location_desc");
      localObject = paramBundle.getStringArray("location_name");
      if ((localObject != null) && (localObject.length == 4))
      {
        paramCard.strCountry = localObject[0];
        paramCard.strProvince = localObject[1];
        paramCard.strCity = localObject[2];
      }
    }
    if (paramBundle.containsKey("hometown"))
    {
      localObject = paramBundle.getStringArray("hometown");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject[0]);
      localStringBuilder.append("-");
      localStringBuilder.append(localObject[1]);
      localStringBuilder.append("-");
      localStringBuilder.append(localObject[2]);
      localStringBuilder.append("-");
      localStringBuilder.append(localObject[3]);
      paramCard.strHometownCodes = localStringBuilder.toString();
      paramCard.strHometownDesc = paramBundle.getString("hometown_desc");
    }
    if (paramBundle.containsKey("email")) {
      paramCard.strEmail = paramBundle.getString("email");
    }
    if (paramBundle.containsKey("personalNote")) {
      paramCard.strPersonalNote = paramBundle.getString("personalNote");
    }
  }
  
  private void processProfileDetail1(ProfileCardHandler.ProfileDetailRecord paramProfileDetailRecord, Bundle paramBundle)
  {
    Object localObject;
    short s;
    if (paramBundle.containsKey("nick"))
    {
      localObject = paramBundle.getString("nick");
      byte[] arrayOfByte = ((String)localObject).getBytes();
      s = (short)arrayOfByte.length;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("processProfileDetail1 nick=%s", new Object[] { localObject }));
      }
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += s + 4;
      paramProfileDetailRecord.contentBuffer.putShort((short)20002);
      paramProfileDetailRecord.contentBuffer.putShort(s);
      paramProfileDetailRecord.contentBuffer.put(arrayOfByte);
    }
    if (paramBundle.containsKey("sex"))
    {
      byte b = (byte)(paramBundle.getByte("sex") + 1);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("processProfileDetail1 sex=%s", new Object[] { Byte.valueOf(b) }));
      }
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += 5;
      paramProfileDetailRecord.contentBuffer.putShort((short)20009);
      paramProfileDetailRecord.contentBuffer.putShort((short)1);
      paramProfileDetailRecord.contentBuffer.put(b);
    }
    int i;
    if (paramBundle.containsKey("birthday"))
    {
      i = paramBundle.getInt("birthday");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("processProfileDetail1 birthday=%s", new Object[] { Integer.valueOf(i) }));
      }
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += 8;
      paramProfileDetailRecord.contentBuffer.putShort((short)26003);
      paramProfileDetailRecord.contentBuffer.putShort((short)4);
      paramProfileDetailRecord.contentBuffer.putInt(i);
    }
    if (paramBundle.containsKey("profession"))
    {
      i = paramBundle.getInt("profession");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("processProfileDetail1 jobId=%s", new Object[] { Integer.valueOf(i) }));
      }
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += 8;
      paramProfileDetailRecord.contentBuffer.putShort((short)27037);
      paramProfileDetailRecord.contentBuffer.putShort((short)4);
      paramProfileDetailRecord.contentBuffer.putInt(i);
    }
    if (paramBundle.containsKey("company"))
    {
      paramBundle = paramBundle.getString("company");
      localObject = paramBundle.getBytes();
      s = (short)localObject.length;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("processProfileDetail1 company=%s", new Object[] { paramBundle }));
      }
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += s + 4;
      paramProfileDetailRecord.contentBuffer.putShort((short)24008);
      paramProfileDetailRecord.contentBuffer.putShort(s);
      paramProfileDetailRecord.contentBuffer.put((byte[])localObject);
    }
  }
  
  private void processProfileDetail2(ProfileCardHandler.ProfileDetailRecord paramProfileDetailRecord, Bundle paramBundle)
  {
    Object localObject;
    byte[] arrayOfByte;
    short s;
    if (paramBundle.containsKey("college"))
    {
      localObject = paramBundle.getString("college");
      arrayOfByte = ((String)localObject).getBytes();
      s = (short)arrayOfByte.length;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("processProfileDetail1 college=%s", new Object[] { localObject }));
      }
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += s + 4;
      paramProfileDetailRecord.contentBuffer.putShort((short)20021);
      paramProfileDetailRecord.contentBuffer.putShort(s);
      paramProfileDetailRecord.contentBuffer.put(arrayOfByte);
    }
    if (paramBundle.containsKey("location"))
    {
      localObject = paramBundle.getStringArray("location");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("processProfileDetail1 locationCodes=%s", new Object[] { Arrays.toString((Object[])localObject) }));
      }
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += 16;
      paramProfileDetailRecord.contentBuffer.putShort((short)20032).putShort((short)12).putInt(ProfileCodecUtils.encodeLocCode(localObject[0])).putInt(ProfileCodecUtils.encodeLocCode(localObject[1])).putInt(ProfileCodecUtils.encodeLocCode(localObject[2]));
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += 8;
      paramProfileDetailRecord.contentBuffer.putShort((short)20041).putShort((short)4).putInt(ProfileCodecUtils.encodeLocCode(localObject[3]));
    }
    if (paramBundle.containsKey("hometown"))
    {
      localObject = paramBundle.getStringArray("hometown");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("processProfileDetail1 hometownCodes=%s", new Object[] { Arrays.toString((Object[])localObject) }));
      }
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += 16;
      paramProfileDetailRecord.contentBuffer.putShort((short)24002).putShort((short)12).putInt(ProfileCodecUtils.encodeLocCode(localObject[0])).putInt(ProfileCodecUtils.encodeLocCode(localObject[1])).putInt(ProfileCodecUtils.encodeLocCode(localObject[2]));
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += 8;
      paramProfileDetailRecord.contentBuffer.putShort((short)20043).putShort((short)4).putInt(ProfileCodecUtils.encodeLocCode(localObject[3]));
    }
    if (paramBundle.containsKey("email"))
    {
      localObject = paramBundle.getString("email");
      arrayOfByte = ((String)localObject).getBytes();
      s = (short)arrayOfByte.length;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("processProfileDetail1 email=%s", new Object[] { localObject }));
      }
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += s + 4;
      paramProfileDetailRecord.contentBuffer.putShort((short)20011).putShort(s).put(arrayOfByte);
    }
    if (paramBundle.containsKey("personalNote"))
    {
      paramBundle = paramBundle.getString("personalNote");
      localObject = paramBundle.getBytes();
      s = (short)localObject.length;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("processProfileDetail1 note=%s", new Object[] { paramBundle }));
      }
      paramProfileDetailRecord.fieldCount += 1;
      paramProfileDetailRecord.contentSize += s + 4;
      paramProfileDetailRecord.contentBuffer.putShort((short)20019).putShort(s).put((byte[])localObject);
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x4ff_9_IMCore");
      this.allowCmdSet.add("OidbSvc.0x480_9_IMCore");
    }
    return this.allowCmdSet;
  }
  
  protected void handlerGetProfileDetail(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    boolean bool = paramFromServiceMsg.isSuccess();
    ProfileProtocolServiceImpl.getProfileProtocolService(this.appRuntime).responseGetProfileDetail(paramToServiceMsg.extraData, bool, i, paramObject);
  }
  
  protected void handlerSetProfileDetail(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    boolean bool2 = paramFromServiceMsg.isSuccess();
    IProfileDataService localIProfileDataService = null;
    Object localObject = null;
    int j = i;
    paramFromServiceMsg = localIProfileDataService;
    boolean bool1 = bool2;
    if (bool2)
    {
      j = i;
      paramFromServiceMsg = localObject;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        j = i;
        paramFromServiceMsg = localObject;
        if (!paramObject.uint32_result.has()) {
          break label300;
        }
        j = i;
        paramFromServiceMsg = localObject;
        i = paramObject.uint32_result.get();
        if (i != 0) {
          break label290;
        }
        bool1 = true;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("ProfileCardHandler", 1, "handlerSetProfileDetail fail.", paramToServiceMsg);
        bool1 = false;
      }
      j = i;
      paramFromServiceMsg = localIProfileDataService;
      bool1 = bool2;
      if (bool2)
      {
        j = i;
        paramFromServiceMsg = localObject;
        localIProfileDataService = (IProfileDataService)this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
        j = i;
        paramFromServiceMsg = localObject;
        paramObject = localIProfileDataService.getProfileCard(this.appRuntime.getCurrentUin(), true);
        j = i;
        paramFromServiceMsg = paramObject;
        handlerSetProfileDetailInner(paramToServiceMsg.extraData, paramObject);
        j = i;
        paramFromServiceMsg = paramObject;
        localIProfileDataService.saveProfileCard(paramObject);
        j = i;
        paramFromServiceMsg = paramObject;
        bool1 = bool2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardHandler", 2, String.format("handlerSetProfileDetail success=%s resultCode=%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j) }));
      }
      notifyUI(1003, bool1, new Object[] { Integer.valueOf(j), paramFromServiceMsg });
      return;
      label290:
      bool1 = false;
      bool2 = bool1;
      continue;
      label300:
      bool2 = false;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ProfileCardObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      return;
    }
    if ("OidbSvc.0x4ff_9_IMCore".equals(str))
    {
      handlerSetProfileDetail(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x480_9_IMCore".equals(str)) {
      handlerGetProfileDetail(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void setProfileDetail(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardHandler", 2, String.format("setProfileDetail params=%s", new Object[] { paramBundle }));
    }
    Object localObject2 = this.appRuntime.getCurrentUin();
    ProfileCardHandler.ProfileDetailRecord localProfileDetailRecord = new ProfileCardHandler.ProfileDetailRecord(null);
    processProfileDetail1(localProfileDetailRecord, paramBundle);
    processProfileDetail2(localProfileDetailRecord, paramBundle);
    if (localProfileDetailRecord.fieldCount == 0)
    {
      notifyUI(1003, true, new Object[] { Integer.valueOf(0), ((IProfileDataService)this.appRuntime.getRuntimeService(IProfileDataService.class, "all")).getProfileCard((String)localObject2, true) });
      return;
    }
    Object localObject1 = ByteBuffer.allocate(localProfileDetailRecord.contentSize + 7);
    ((ByteBuffer)localObject1).putInt((int)Long.parseLong((String)localObject2));
    ((ByteBuffer)localObject1).put((byte)0);
    ((ByteBuffer)localObject1).putShort((short)localProfileDetailRecord.fieldCount);
    ((ByteBuffer)localObject1).put(localProfileDetailRecord.contentBuffer.array(), 0, localProfileDetailRecord.contentSize);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1279);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(9);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject1).array()));
    localObject1 = createToServiceMsg("OidbSvc.0x4ff_9_IMCore");
    ((ToServiceMsg)localObject1).extraData.putAll(paramBundle);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.handler.ProfileCardHandler
 * JD-Core Version:    0.7.0.1
 */