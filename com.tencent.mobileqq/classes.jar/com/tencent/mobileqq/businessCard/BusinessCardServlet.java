package com.tencent.mobileqq.businessCard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.CardInfo;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.MobileInfo;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.OCRInfo;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestAdd;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestCardDetail;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestCardList;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestDel;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestModify;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.ResponseAdd;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.ResponseCardDetail;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.ResponseCardList;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.UinInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class BusinessCardServlet
  extends MSFServlet
{
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    boolean bool1;
    if (bool2)
    {
      try
      {
        Object localObject1 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject1).getInt() - 4];
        ((ByteBuffer)localObject1).get(paramFromServiceMsg);
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.get();
        localBundle.putInt("resp_result", i);
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("respAddCard | is success, and result=");
          paramFromServiceMsg.append(i);
          QLog.d("BusinessCard_Servlet", 2, paramFromServiceMsg.toString());
        }
        if ((i == 0) && (((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = (QQAppInterface)getAppRuntime();
          localObject1 = ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get().toByteArray();
          Object localObject2 = new Oidb_0x43c.ResponseAdd();
          ((Oidb_0x43c.ResponseAdd)localObject2).mergeFrom((byte[])localObject1);
          bool1 = bool2;
          if (((Oidb_0x43c.ResponseAdd)localObject2).card_id.has())
          {
            localObject1 = ((Oidb_0x43c.ResponseAdd)localObject2).card_id.get().toStringUtf8();
            localObject2 = (BusinessCard)paramIntent.getExtras().getParcelable("key_card_info");
            boolean bool3 = paramIntent.getBooleanExtra("key_is_mine", false);
            bool1 = bool2;
            if (localObject2 != null)
            {
              ((BusinessCard)localObject2).cardId = ((String)localObject1);
              localBundle.putString("key_card_id", (String)localObject1);
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("respAddCard | is success cardId=");
                ((StringBuilder)localObject2).append((String)localObject1);
                QLog.d("BusinessCard_Servlet", 2, ((StringBuilder)localObject2).toString());
              }
              a(paramFromServiceMsg, (String)localObject1, bool3, 1);
              bool1 = bool2;
            }
          }
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("BusinessCard_Servlet", 2, paramFromServiceMsg.getMessage());
        bool1 = false;
      }
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("BusinessCard_Servlet", 2, "$$respAddCard | is not success");
        bool1 = bool2;
      }
    }
    notifyObserver(paramIntent, 1, bool1, localBundle, BusinessCardObserver.class);
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    BusinessCard localBusinessCard = (BusinessCard)paramIntent.getExtras().getParcelable("key_card_info");
    Oidb_0x43c.CardInfo localCardInfo = new Oidb_0x43c.CardInfo();
    if (!TextUtils.isEmpty(localBusinessCard.picUrl)) {
      localCardInfo.pic_url.set(localBusinessCard.picUrl);
    }
    if (!TextUtils.isEmpty(localBusinessCard.cardName)) {
      localCardInfo.name.set(localBusinessCard.cardName);
    }
    if (!TextUtils.isEmpty(localBusinessCard.company)) {
      localCardInfo.company.set(localBusinessCard.company);
    }
    Object localObject1 = localBusinessCard.qqNum.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localCardInfo.uins.add(Long.valueOf(Long.parseLong((String)localObject2)));
    }
    localObject1 = localBusinessCard.mobilesNum.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localCardInfo.mobiles.add(localObject2);
    }
    localObject1 = localBusinessCard.descs.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localCardInfo.descs.add(localObject2);
    }
    if (!TextUtils.isEmpty(localBusinessCard.bindUin)) {}
    try
    {
      localCardInfo.bind_uin.set(Long.parseLong(localBusinessCard.bindUin));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label272:
      String str;
      boolean bool;
      break label272;
    }
    if (!TextUtils.isEmpty(localBusinessCard.bindMobile)) {
      localCardInfo.bind_mbl.set(localBusinessCard.bindMobile);
    }
    localCardInfo.card_src.set(localBusinessCard.cardSrc);
    if (localBusinessCard.OCRInfo != null)
    {
      localObject1 = new Oidb_0x43c.OCRInfo();
      ((Oidb_0x43c.OCRInfo)localObject1).name.set(localBusinessCard.OCRInfo.jdField_a_of_type_JavaLangString);
      localObject2 = localBusinessCard.OCRInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if ((str != null) && (str.length() > 0)) {
          ((Oidb_0x43c.OCRInfo)localObject1).uins.add(Long.valueOf(Long.parseLong(str)));
        }
      }
      localObject2 = localBusinessCard.OCRInfo.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (str.length() > 0) {
          ((Oidb_0x43c.OCRInfo)localObject1).mobiles.add(str);
        }
      }
      ((Oidb_0x43c.OCRInfo)localObject1).name_dependLevel.set(localBusinessCard.OCRInfo.jdField_a_of_type_Float);
      ((Oidb_0x43c.OCRInfo)localObject1).uins_dependLevel.set(localBusinessCard.OCRInfo.jdField_b_of_type_Float);
      ((Oidb_0x43c.OCRInfo)localObject1).mobiles_dependLevel.set(localBusinessCard.OCRInfo.c);
      localCardInfo.ocr_info.set((MessageMicro)localObject1);
    }
    localObject1 = new Oidb_0x43c.RequestAdd();
    ((Oidb_0x43c.RequestAdd)localObject1).card_info.set(localCardInfo);
    bool = paramIntent.getBooleanExtra("key_is_mine", false);
    if (bool)
    {
      ((Oidb_0x43c.RequestAdd)localObject1).isMine.set(bool);
      localBusinessCard.cardType = 1;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("reqAddCard: card=");
      paramIntent.append(localBusinessCard);
      QLog.d("BusinessCard_Servlet", 2, paramIntent.toString());
    }
    a(((Oidb_0x43c.RequestAdd)localObject1).toByteArray(), 1, "OidbSvc.0x43c_1", paramPacket);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), BusinessCardServlet.class);
    localNewIntent.putExtra("key_cmd_type", 4);
    localNewIntent.putExtra("req_get_list_seq", paramInt1);
    localNewIntent.putExtra("req_get_list_nextFlag", paramInt2);
    localNewIntent.putExtra("req_get_list_first", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    if (paramBusinessCard == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), BusinessCardServlet.class);
    localNewIntent.putExtra("key_cmd_type", 1);
    localNewIntent.putExtra("key_card_info", paramBusinessCard);
    localNewIntent.putExtra("key_is_mine", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), BusinessCardServlet.class);
    localNewIntent.putExtra("key_cmd_type", 5);
    localNewIntent.putExtra("key_card_id", paramString);
    localNewIntent.putExtra("key_is_mine", paramBoolean);
    localNewIntent.putExtra("key_get_detail_type", paramInt);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(BusinessCardManager paramBusinessCardManager, ArrayList<BusinessCard> paramArrayList, Oidb_0x43c.ResponseCardList paramResponseCardList)
  {
    paramResponseCardList = paramResponseCardList.others.get().iterator();
    while (paramResponseCardList.hasNext())
    {
      Oidb_0x43c.CardInfo localCardInfo = (Oidb_0x43c.CardInfo)paramResponseCardList.next();
      BusinessCard localBusinessCard = new BusinessCard();
      a(localBusinessCard, localCardInfo);
      if (localBusinessCard.cardId != null)
      {
        paramArrayList.add(localBusinessCard);
        paramBusinessCardManager.a(localBusinessCard);
      }
    }
  }
  
  public static void a(BusinessCard paramBusinessCard, Oidb_0x43c.CardInfo paramCardInfo)
  {
    if (paramCardInfo == null) {
      return;
    }
    paramBusinessCard.cardId = paramCardInfo.card_id.get().toStringUtf8();
    boolean bool = paramCardInfo.name.has();
    Object localObject2 = null;
    Object localObject1;
    if (bool) {
      localObject1 = paramCardInfo.name.get();
    } else {
      localObject1 = null;
    }
    paramBusinessCard.cardName = ((String)localObject1);
    if (paramCardInfo.company.has()) {
      localObject1 = paramCardInfo.company.get();
    } else {
      localObject1 = null;
    }
    paramBusinessCard.company = ((String)localObject1);
    if (paramCardInfo.pic_url.has()) {
      localObject1 = paramCardInfo.pic_url.get();
    } else {
      localObject1 = null;
    }
    paramBusinessCard.picUrl = ((String)localObject1);
    if (paramCardInfo.bind_uin.has()) {
      localObject1 = String.valueOf(paramCardInfo.bind_uin.get());
    } else {
      localObject1 = null;
    }
    paramBusinessCard.bindUin = ((String)localObject1);
    paramBusinessCard.lastUpdateTime = paramCardInfo.last_update_time.get();
    paramBusinessCard.cardSrc = paramCardInfo.card_src.get();
    long l;
    if ((paramCardInfo.uins.has()) && (paramCardInfo.uins.get() != null))
    {
      localObject1 = paramCardInfo.uins.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        l = ((Long)((Iterator)localObject1).next()).longValue();
        paramBusinessCard.qqNum.add(String.valueOf(l));
      }
    }
    Object localObject4;
    if ((paramCardInfo.uin_info.has()) && (paramCardInfo.uin_info.get() != null))
    {
      localObject1 = paramCardInfo.uin_info.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Oidb_0x43c.UinInfo)((Iterator)localObject1).next();
        localObject4 = new CardUinInfo();
        ((CardUinInfo)localObject4).jdField_a_of_type_JavaLangString = String.valueOf(((Oidb_0x43c.UinInfo)localObject3).uin.get());
        if ((((Oidb_0x43c.UinInfo)localObject3).isFriend.has()) && (((Oidb_0x43c.UinInfo)localObject3).isFriend.get())) {
          bool = true;
        } else {
          bool = false;
        }
        ((CardUinInfo)localObject4).jdField_a_of_type_Boolean = bool;
        if ((((Oidb_0x43c.UinInfo)localObject3).isSearchable.has()) && (((Oidb_0x43c.UinInfo)localObject3).isSearchable.get())) {
          bool = true;
        } else {
          bool = false;
        }
        ((CardUinInfo)localObject4).b = bool;
        paramBusinessCard.uinInfos.add(localObject4);
      }
    }
    if ((paramCardInfo.mobiles.has()) && (paramCardInfo.mobiles.get() != null))
    {
      localObject1 = paramCardInfo.mobiles.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        paramBusinessCard.mobilesNum.add(localObject3);
      }
    }
    if ((paramCardInfo.descs.has()) && (paramCardInfo.descs.get() != null))
    {
      localObject1 = paramCardInfo.descs.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        paramBusinessCard.descs.add(localObject3);
      }
    }
    bool = paramCardInfo.mobile_info.has();
    Object localObject3 = "";
    Object localObject5;
    if ((bool) && (paramCardInfo.mobile_info.get() != null))
    {
      localObject4 = paramCardInfo.mobile_info.get().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Oidb_0x43c.MobileInfo localMobileInfo = (Oidb_0x43c.MobileInfo)((Iterator)localObject4).next();
        localObject5 = new CardMobileInfo();
        if (localMobileInfo.mobile.has()) {
          localObject1 = localMobileInfo.mobile.get();
        } else {
          localObject1 = "";
        }
        ((CardMobileInfo)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject1);
        if ((localMobileInfo.isFriend.has()) && (localMobileInfo.isFriend.get())) {
          bool = true;
        } else {
          bool = false;
        }
        ((CardMobileInfo)localObject5).jdField_a_of_type_Boolean = bool;
        if (((CardMobileInfo)localObject5).jdField_a_of_type_Boolean) {
          ((CardMobileInfo)localObject5).jdField_b_of_type_JavaLangString = String.valueOf(localMobileInfo.bind_uin.get());
        } else {
          ((CardMobileInfo)localObject5).jdField_b_of_type_JavaLangString = "";
        }
        if (localMobileInfo.nick_name.has()) {
          localObject1 = localMobileInfo.nick_name.get();
        } else {
          localObject1 = "";
        }
        ((CardMobileInfo)localObject5).c = ((String)localObject1);
        if (localMobileInfo.format_mobile.has()) {
          localObject1 = localMobileInfo.format_mobile.get();
        } else {
          localObject1 = "";
        }
        ((CardMobileInfo)localObject5).d = ((String)localObject1);
        paramBusinessCard.mobileInfos.add(localObject5);
      }
    }
    if (paramCardInfo.ocr_info.has())
    {
      localObject4 = (Oidb_0x43c.OCRInfo)paramCardInfo.ocr_info.get();
      localObject5 = new CardOCRInfo();
      localObject1 = localObject3;
      if (((Oidb_0x43c.OCRInfo)localObject4).name.has()) {
        localObject1 = ((Oidb_0x43c.OCRInfo)localObject4).name.get();
      }
      ((CardOCRInfo)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject1);
      localObject1 = localObject2;
      if (paramCardInfo.pic_url.has()) {
        localObject1 = paramCardInfo.pic_url.get();
      }
      ((CardOCRInfo)localObject5).jdField_b_of_type_JavaLangString = ((String)localObject1);
      paramCardInfo = ((Oidb_0x43c.OCRInfo)localObject4).uins.get().iterator();
      while (paramCardInfo.hasNext())
      {
        l = ((Long)paramCardInfo.next()).longValue();
        ((CardOCRInfo)localObject5).jdField_a_of_type_JavaUtilList.add(String.valueOf(l));
      }
      paramCardInfo = ((Oidb_0x43c.OCRInfo)localObject4).mobiles.get().iterator();
      while (paramCardInfo.hasNext())
      {
        localObject1 = (String)paramCardInfo.next();
        ((CardOCRInfo)localObject5).jdField_b_of_type_JavaUtilList.add(localObject1);
      }
      ((CardOCRInfo)localObject5).jdField_a_of_type_Float = ((Oidb_0x43c.OCRInfo)localObject4).name_dependLevel.get();
      ((CardOCRInfo)localObject5).jdField_b_of_type_Float = ((Oidb_0x43c.OCRInfo)localObject4).uins_dependLevel.get();
      ((CardOCRInfo)localObject5).c = ((Oidb_0x43c.OCRInfo)localObject4).mobiles_dependLevel.get();
      paramBusinessCard.OCRInfo = ((CardOCRInfo)localObject5);
    }
    else
    {
      paramBusinessCard.OCRInfo = null;
    }
    if (QLog.isColorLevel())
    {
      paramCardInfo = new StringBuilder();
      paramCardInfo.append("decodeBuinessCard card=");
      paramCardInfo.append(paramBusinessCard);
      QLog.d("BusinessCard_Servlet", 2, paramCardInfo.toString());
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt, String paramString, Packet paramPacket)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1084);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).putInt(paramArrayOfByte.length + 4).put(paramArrayOfByte);
    paramPacket.setSSOCommand(paramString);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    paramPacket.setTimeout(30000L);
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    String str = paramIntent.getStringExtra("key_card_id");
    localBundle.putString("key_card_id", str);
    boolean bool1 = bool2;
    if (bool2) {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("respDelCard | del cardId = ");
          paramFromServiceMsg.append(str);
          paramFromServiceMsg.append(",result=");
          paramFromServiceMsg.append(i);
          QLog.d("BusinessCard_Servlet", 2, paramFromServiceMsg.toString());
        }
        if (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() == 0)
        {
          paramFromServiceMsg = (BusinessCardManager)((QQAppInterface)getAppRuntime()).getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
          localObject = paramFromServiceMsg.a(str);
          if ((localObject != null) && (!TextUtils.isEmpty(((BusinessCard)localObject).bindUin))) {
            paramFromServiceMsg.b(((BusinessCard)localObject).bindUin);
          }
          paramFromServiceMsg.a(str);
          bool1 = bool2;
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("BusinessCard_Servlet", 2, paramFromServiceMsg.getMessage());
        bool1 = false;
      }
    }
    notifyObserver(paramIntent, 2, bool1, localBundle, BusinessCardObserver.class);
  }
  
  private void b(Intent paramIntent, Packet paramPacket)
  {
    Oidb_0x43c.RequestDel localRequestDel = new Oidb_0x43c.RequestDel();
    paramIntent = paramIntent.getStringExtra("key_card_id");
    localRequestDel.card_id.set(ByteStringMicro.copyFromUtf8(paramIntent));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reqDelCard: id=");
      localStringBuilder.append(paramIntent);
      QLog.d("BusinessCard_Servlet", 2, localStringBuilder.toString());
    }
    a(localRequestDel.toByteArray(), 2, "OidbSvc.0x43c_2", paramPacket);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    if (paramBusinessCard == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), BusinessCardServlet.class);
    localNewIntent.putExtra("key_cmd_type", 3);
    localNewIntent.putExtra("key_card_info", paramBusinessCard);
    localNewIntent.putExtra("key_is_mine", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    BusinessCard localBusinessCard = (BusinessCard)paramIntent.getParcelableExtra("key_card_info");
    localBundle.putString("key_card_id", localBusinessCard.cardId);
    boolean bool1 = bool2;
    if (bool2) {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("RespModifyCard | is success and result = ");
          paramFromServiceMsg.append(i);
          QLog.d("BusinessCard_Servlet", 2, paramFromServiceMsg.toString());
        }
        if (i == 0)
        {
          paramFromServiceMsg = (QQAppInterface)getAppRuntime();
          bool1 = paramIntent.getBooleanExtra("key_is_mine", false);
          a(paramFromServiceMsg, localBusinessCard.cardId, bool1, 2);
          bool1 = bool2;
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("BusinessCard_Servlet", 2, paramFromServiceMsg.getMessage());
        bool1 = false;
      }
    }
    notifyObserver(paramIntent, 3, bool1, localBundle, BusinessCardObserver.class);
  }
  
  private void c(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = (BusinessCard)paramIntent.getExtras().getParcelable("key_card_info");
    Object localObject1 = new Oidb_0x43c.CardInfo();
    ((Oidb_0x43c.CardInfo)localObject1).card_id.set(ByteStringMicro.copyFromUtf8(paramIntent.cardId));
    if (!TextUtils.isEmpty(paramIntent.picUrl)) {
      ((Oidb_0x43c.CardInfo)localObject1).pic_url.set(paramIntent.picUrl);
    }
    if (!TextUtils.isEmpty(paramIntent.cardName)) {
      ((Oidb_0x43c.CardInfo)localObject1).name.set(paramIntent.cardName);
    }
    if (!TextUtils.isEmpty(paramIntent.company)) {
      ((Oidb_0x43c.CardInfo)localObject1).company.set(paramIntent.company);
    }
    Object localObject2 = paramIntent.qqNum.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      ((Oidb_0x43c.CardInfo)localObject1).uins.add(Long.valueOf(Long.parseLong((String)localObject3)));
    }
    localObject2 = paramIntent.mobilesNum.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      ((Oidb_0x43c.CardInfo)localObject1).mobiles.add(localObject3);
    }
    localObject2 = paramIntent.descs.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      ((Oidb_0x43c.CardInfo)localObject1).descs.add(localObject3);
    }
    if (!TextUtils.isEmpty(paramIntent.bindUin)) {}
    try
    {
      ((Oidb_0x43c.CardInfo)localObject1).bind_uin.set(Long.parseLong(paramIntent.bindUin));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label266:
      String str;
      break label266;
    }
    if (!TextUtils.isEmpty(paramIntent.bindMobile)) {
      ((Oidb_0x43c.CardInfo)localObject1).bind_mbl.set(paramIntent.bindMobile);
    }
    if (paramIntent.OCRInfo != null)
    {
      localObject2 = new Oidb_0x43c.OCRInfo();
      ((Oidb_0x43c.OCRInfo)localObject2).name.set(paramIntent.OCRInfo.jdField_a_of_type_JavaLangString);
      localObject3 = paramIntent.OCRInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        str = (String)((Iterator)localObject3).next();
        if (str.length() > 0) {
          ((Oidb_0x43c.OCRInfo)localObject2).uins.add(Long.valueOf(Long.parseLong(str)));
        }
      }
      localObject3 = paramIntent.OCRInfo.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        str = (String)((Iterator)localObject3).next();
        if (str.length() > 0) {
          ((Oidb_0x43c.OCRInfo)localObject2).mobiles.add(str);
        }
      }
      ((Oidb_0x43c.OCRInfo)localObject2).name_dependLevel.set(paramIntent.OCRInfo.jdField_a_of_type_Float);
      ((Oidb_0x43c.OCRInfo)localObject2).uins_dependLevel.set(paramIntent.OCRInfo.jdField_b_of_type_Float);
      ((Oidb_0x43c.OCRInfo)localObject2).mobiles_dependLevel.set(paramIntent.OCRInfo.c);
      ((Oidb_0x43c.CardInfo)localObject1).ocr_info.set((MessageMicro)localObject2);
    }
    localObject2 = new Oidb_0x43c.RequestModify();
    ((Oidb_0x43c.RequestModify)localObject2).card_info.set((MessageMicro)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reqModifyCard:");
      ((StringBuilder)localObject1).append(paramIntent);
      QLog.d("BusinessCard_Servlet", 2, ((StringBuilder)localObject1).toString());
    }
    a(((Oidb_0x43c.RequestModify)localObject2).toByteArray(), 3, "OidbSvc.0x43c_3", paramPacket);
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    String str = paramIntent.getStringExtra("key_card_id");
    localBundle.putString("key_card_id", str);
    localBundle.putInt("key_get_detail_type", paramIntent.getIntExtra("key_get_detail_type", 3));
    boolean bool3 = false;
    boolean bool1;
    if (bool2)
    {
      try
      {
        Object localObject1 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject1).getInt() - 4];
        ((ByteBuffer)localObject1).get(paramFromServiceMsg);
        Object localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("respGetDetailCardInfo | is success, and result=");
          paramFromServiceMsg.append(i);
          QLog.d("BusinessCard_Servlet", 2, paramFromServiceMsg.toString());
        }
        if ((i == 0) && (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = (QQAppInterface)getAppRuntime();
          localObject1 = (BusinessCardManager)paramFromServiceMsg.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
          Object localObject3 = ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray();
          localObject2 = new Oidb_0x43c.ResponseCardDetail();
          ((Oidb_0x43c.ResponseCardDetail)localObject2).mergeFrom((byte[])localObject3);
          bool1 = bool2;
          if (((Oidb_0x43c.ResponseCardDetail)localObject2).card_id.has())
          {
            bool1 = bool2;
            if (((Oidb_0x43c.ResponseCardDetail)localObject2).card_id.get().toStringUtf8().equals(str))
            {
              localObject3 = new BusinessCard();
              localObject2 = (Oidb_0x43c.CardInfo)((Oidb_0x43c.ResponseCardDetail)localObject2).card_info.get();
              a((BusinessCard)localObject3, (Oidb_0x43c.CardInfo)localObject2);
              if (paramIntent.getBooleanExtra("key_is_mine", false)) {
                ((BusinessCard)localObject3).cardType = 1;
              } else {
                ((BusinessCard)localObject3).cardType = 0;
              }
              if (((Oidb_0x43c.CardInfo)localObject2).ocr_info.has()) {
                ((BusinessCardManager)localObject1).b((BusinessCard)localObject3);
              }
              if (!TextUtils.isEmpty(((BusinessCard)localObject3).bindUin))
              {
                if (((FriendsManager)paramFromServiceMsg.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((BusinessCard)localObject3).bindUin)) {
                  ((BusinessCardManager)localObject1).a(((BusinessCard)localObject3).bindUin, (BusinessCard)localObject3);
                } else {
                  ((BusinessCardManager)localObject1).b(((BusinessCard)localObject3).bindUin);
                }
                if (paramIntent.getIntExtra("key_get_detail_type", 3) == 1) {
                  ((BusinessCardManager)localObject1).a(1, true);
                }
              }
              bool1 = bool2;
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = new StringBuilder();
                paramFromServiceMsg.append("respGetDetailCardInfo | is success, and cardId=");
                paramFromServiceMsg.append(str);
                QLog.d("BusinessCard_Servlet", 2, paramFromServiceMsg.toString());
                bool1 = bool2;
              }
            }
          }
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("BusinessCard_Servlet", 2, paramFromServiceMsg.getMessage());
        bool1 = bool3;
      }
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("BusinessCard_Servlet", 2, "respGetDetailCardInfo | is not success");
        bool1 = bool2;
      }
    }
    notifyObserver(paramIntent, 5, bool1, localBundle, BusinessCardObserver.class);
  }
  
  private void d(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("req_get_list_seq", -1);
    int j = paramIntent.getIntExtra("req_get_list_nextFlag", 0);
    paramIntent = new Oidb_0x43c.RequestCardList();
    paramIntent.req_num.set(i);
    paramIntent.next_flag.set(j);
    paramIntent.req_num.set(10);
    a(paramIntent.toByteArray(), 4, "OidbSvc.0x43c_4", paramPacket);
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = paramIntent.getIntExtra("req_get_list_seq", -1);
    if (bool) {
      try
      {
        Object localObject1 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject1).getInt() - 4];
        ((ByteBuffer)localObject1).get(paramFromServiceMsg);
        Object localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom(paramFromServiceMsg);
        int j = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("respGetCardList | is success, and result=");
          paramFromServiceMsg.append(j);
          QLog.d("BusinessCard_Servlet", 2, paramFromServiceMsg.toString());
        }
        if ((j == 0) && (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = (QQAppInterface)getAppRuntime();
          localObject1 = (BusinessCardManager)paramFromServiceMsg.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
          Object localObject3 = ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.get().toByteArray();
          localObject2 = new Oidb_0x43c.ResponseCardList();
          ((Oidb_0x43c.ResponseCardList)localObject2).mergeFrom((byte[])localObject3);
          j = ((Oidb_0x43c.ResponseCardList)localObject2).seq.get();
          if (j == i)
          {
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("respGetCardList | seq equal ");
              paramFromServiceMsg.append(j);
              QLog.d("BusinessCard_Servlet", 2, paramFromServiceMsg.toString());
            }
            notifyObserver(paramIntent, 4, false, null, BusinessCardObserver.class);
            return;
          }
          bool = paramIntent.getBooleanExtra("req_get_list_first", false);
          localObject3 = new ArrayList();
          if (bool)
          {
            ((BusinessCardManager)localObject1).b();
            if (((Oidb_0x43c.ResponseCardList)localObject2).mine.has())
            {
              BusinessCard localBusinessCard = new BusinessCard();
              a(localBusinessCard, (Oidb_0x43c.CardInfo)((Oidb_0x43c.ResponseCardList)localObject2).mine.get());
              localBusinessCard.cardType = 1;
              ((BusinessCardManager)localObject1).a(localBusinessCard);
              ((ArrayList)localObject3).add(localBusinessCard);
            }
          }
          a((BusinessCardManager)localObject1, (ArrayList)localObject3, (Oidb_0x43c.ResponseCardList)localObject2);
          ((BusinessCardManager)localObject1).a((List)localObject3, false);
          int k = ((Oidb_0x43c.ResponseCardList)localObject2).next_flag.get();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("respGetCardList | nextFlag=");
            ((StringBuilder)localObject2).append(k);
            QLog.d("BusinessCard_Servlet", 2, ((StringBuilder)localObject2).toString());
          }
          if (k == -1)
          {
            ((BusinessCardManager)localObject1).a(j);
            notifyObserver(paramIntent, 4, true, null, BusinessCardObserver.class);
            return;
          }
          a(paramFromServiceMsg, i, k, false);
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        QLog.w("BusinessCard_Servlet", 2, paramFromServiceMsg.getMessage());
      }
    }
    notifyObserver(paramIntent, 4, false, null, BusinessCardObserver.class);
  }
  
  private void e(Intent paramIntent, Packet paramPacket)
  {
    Oidb_0x43c.RequestCardDetail localRequestCardDetail = new Oidb_0x43c.RequestCardDetail();
    paramIntent = paramIntent.getStringExtra("key_card_id");
    localRequestCardDetail.card_id.set(ByteStringMicro.copyFromUtf8(paramIntent));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reqGetDetailCardInfo|cardId=");
      localStringBuilder.append(paramIntent);
      QLog.d("BusinessCard_Servlet", 2, localStringBuilder.toString());
    }
    a(localRequestCardDetail.toByteArray(), 5, "OidbSvc.0x43c_5", paramPacket);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resp:");
      localStringBuilder.append(str2);
      localStringBuilder.append(" is ");
      String str1;
      if (bool) {
        str1 = "";
      } else {
        str1 = "not";
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(" success");
      QLog.d("BusinessCard_Servlet", 2, localStringBuilder.toString());
    }
    if (str2.equals("OidbSvc.0x43c_1"))
    {
      a(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str2.equals("OidbSvc.0x43c_2"))
    {
      b(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str2.equals("OidbSvc.0x43c_3"))
    {
      c(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str2.equals("OidbSvc.0x43c_4"))
    {
      e(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str2.equals("OidbSvc.0x43c_5")) {
      d(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getExtras().getInt("key_cmd_type");
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            e(paramIntent, paramPacket);
            return;
          }
          d(paramIntent, paramPacket);
          return;
        }
        c(paramIntent, paramPacket);
        return;
      }
      b(paramIntent, paramPacket);
      return;
    }
    a(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.BusinessCardServlet
 * JD-Core Version:    0.7.0.1
 */