package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.common.util.GCCommon;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.LoginSig;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.ReqBody;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.AnonymousGroupMsg;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ExtParam;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.GPSInfo;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.LoginSig;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ReqBody;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.SendFlowerReq;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ThrowFlowerReq;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.TmpMsgToken;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.LoginSig;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.ReqBody;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ExtParam;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetExtraDataReq;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetStockReq;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.LoginSig;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ReqBody;
import tencent.im.oidb.cmd0x962.oidb_0x962.ClientInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962.ReqBody;
import tencent.im.oidb.cmd0x9e9.cmd0x9e9.ReqBody;
import tencent.im.oidb.cmd0x9e9.cmd0x9e9.User;
import tencent.im.oidb.cmd0xa48.oidb_0xa48.ReqBody;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.GetPackageShopReq;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.ReqBody;
import tencent.im.oidb.cmd0xdad.cmd0xdad.LoginSig;
import tencent.im.oidb.cmd0xdad.cmd0xdad.ReqBody;

public class TroopGiftManager
  extends Observable
  implements Manager
{
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ConcurrentHashMap<String, TroopGiftBagInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopGiftManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
    }
  }
  
  private int a(String paramString, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 7: 
    case 9: 
    case 10: 
    default: 
      return paramInt2;
    case 13: 
      return 1200;
    case 12: 
      return 1300;
    case 11: 
      return 1100;
    case 8: 
      return 508;
    case 6: 
      return 504;
    case 5: 
      return 2;
    }
    paramString = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getHotChatMng(true).a(paramString);
    if (paramString != null)
    {
      if (paramString.isBuLuoHotChat()) {
        return 507;
      }
      return 503;
    }
    return -1;
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, oidb_0x6b6.SendFlowerReq paramSendFlowerReq, oidb_0x6b6.ThrowFlowerReq paramThrowFlowerReq, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if (paramTroopGiftCallback == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("send_oidb_0x6b6. callback=");
        paramString1.append(paramTroopGiftCallback);
        QLog.e(".troop.send_gift", 2, paramString1.toString());
      }
      return;
    }
    Object localObject1 = new oidb_0x6b6.ReqBody();
    int i = 10;
    if (paramString2 != null) {}
    try
    {
      long l = Long.valueOf(paramString2).longValue();
      ((oidb_0x6b6.ReqBody)localObject1).uint64_group.set(l, true);
      if (paramInt2 == 10) {
        ((oidb_0x6b6.ReqBody)localObject1).uint32_group_type.set(2, true);
      } else if (paramInt2 == 11) {
        ((oidb_0x6b6.ReqBody)localObject1).uint32_group_type.set(2, true);
      }
    }
    catch (NumberFormatException paramString1)
    {
      label121:
      Object localObject2;
      break label121;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("send_oidb_0x6b6. NumberFormatException troopUin=");
      paramString1.append(paramString2);
      QLog.e(".troop.send_gift", 2, paramString1.toString());
    }
    return;
    if (paramInt5 > 0)
    {
      ((oidb_0x6b6.ReqBody)localObject1).uint32_c2c_type.set(paramInt5, true);
      ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.set(new oidb_0x6b6.TmpMsgToken(), true);
      ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.c2c_type.set(1, true);
      if (paramInt5 != 512)
      {
        if (paramInt5 == 513) {
          ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.service_type.set(1, true);
        }
      }
      else {
        ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.service_type.set(0, true);
      }
    }
    localObject2 = ((oidb_0x6b6.ReqBody)localObject1).uint32_portal;
    paramInt5 = i;
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      paramInt5 = paramInt4;
    }
    ((PBUInt32Field)localObject2).set(a(paramString2, paramInt3, paramInt5), true);
    if (paramSendFlowerReq != null)
    {
      ((oidb_0x6b6.ReqBody)localObject1).msg_send_flower = paramSendFlowerReq;
    }
    else
    {
      if (paramThrowFlowerReq == null) {
        break label1177;
      }
      ((oidb_0x6b6.ReqBody)localObject1).msg_throw_flower = paramThrowFlowerReq;
    }
    if (AnonymousChatHelper.a().a(paramString2))
    {
      paramThrowFlowerReq = new oidb_0x6b6.AnonymousGroupMsg();
      paramString2 = AnonymousChatHelper.a().a(paramString2);
      paramThrowFlowerReq.uint32_flags.set(2);
      if (!TextUtils.isEmpty(paramString2.jdField_b_of_type_JavaLangString)) {
        paramThrowFlowerReq.str_anon_id.set(ByteStringMicro.copyFrom(paramString2.jdField_b_of_type_JavaLangString.getBytes()));
      }
      if (!TextUtils.isEmpty(paramString2.jdField_a_of_type_JavaLangString)) {
        paramThrowFlowerReq.str_anon_nick.set(ByteStringMicro.copyFrom(paramString2.jdField_a_of_type_JavaLangString.getBytes()));
      }
      paramThrowFlowerReq.uint32_head_portrait.set(paramString2.jdField_a_of_type_Int);
      paramThrowFlowerReq.uint32_expire_time.set(paramString2.jdField_b_of_type_Int);
      paramThrowFlowerReq.uint32_bubble_id.set((int)paramString2.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(paramString2.c)) {
        paramThrowFlowerReq.str_rank_color.set(ByteStringMicro.copyFrom(paramString2.c.getBytes()));
      }
      ((oidb_0x6b6.ReqBody)localObject1).msg_anony.set(paramThrowFlowerReq);
    }
    paramThrowFlowerReq = GCCommon.b();
    paramString2 = paramThrowFlowerReq;
    if (TextUtils.isEmpty(paramThrowFlowerReq)) {
      paramString2 = "0.0.0.0";
    }
    localObject2 = new StringBuilder();
    paramThrowFlowerReq = "";
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(AppSetting.a());
    localObject2 = ((StringBuilder)localObject2).toString();
    paramInt4 = AppSetting.a();
    ((oidb_0x6b6.ReqBody)localObject1).bytes_user_ip.set(ByteStringMicro.copyFrom(paramString2.getBytes()), true);
    ((oidb_0x6b6.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()), true);
    ((oidb_0x6b6.ReqBody)localObject1).uint32_client.set(1, true);
    ((oidb_0x6b6.ReqBody)localObject1).uint32_instance_id.set(paramInt4, true);
    ((oidb_0x6b6.ReqBody)localObject1).setHasFlag(true);
    if (paramInt3 == 6)
    {
      ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.set(new oidb_0x6b6.TmpMsgToken(), true);
      ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.service_type.set(124, true);
      ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.c2c_type.set(1, true);
      if (paramSendFlowerReq != null)
      {
        paramString2 = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMsgCache().m(String.valueOf(paramSendFlowerReq.uint64_to_uin.get()));
        if (paramString2 != null) {
          ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.buf.set(ByteStringMicro.copyFrom(paramString2), true);
        }
      }
    }
    else if (paramInt3 == 8)
    {
      ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.set(new oidb_0x6b6.TmpMsgToken(), true);
      ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.service_type.set(149, true);
      ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.c2c_type.set(1, true);
      if (paramSendFlowerReq != null)
      {
        paramString2 = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMsgCache().j(String.valueOf(paramSendFlowerReq.uint64_to_uin.get()));
        if (paramString2 != null) {
          ((oidb_0x6b6.ReqBody)localObject1).msg_tmp_msg_token.buf.set(ByteStringMicro.copyFrom(paramString2), true);
        }
      }
    }
    if ((paramInt3 >= 4) && (System.currentTimeMillis() - com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog.b[0] < 600000L))
    {
      paramString2 = new oidb_0x6b6.GPSInfo();
      paramString2.int32_gps_type.set(1, true);
      paramString2.int64_longitude.set(com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog.a[0], true);
      paramString2.int64_latitude.set(com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog.a[1], true);
      ((oidb_0x6b6.ReqBody)localObject1).msg_gps_info.set(paramString2, true);
    }
    paramSendFlowerReq = new oidb_0x6b6.ExtParam();
    localObject2 = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    paramString2 = paramThrowFlowerReq;
    if (localObject2 != null) {
      paramString2 = ((TicketManager)localObject2).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    }
    paramThrowFlowerReq = new oidb_0x6b6.LoginSig();
    paramThrowFlowerReq.uint32_type.set(1);
    paramThrowFlowerReq.uint32_appid.set(0);
    if (!TextUtils.isEmpty(paramString2)) {
      paramThrowFlowerReq.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    paramSendFlowerReq.msg_login_sig.set(paramThrowFlowerReq);
    paramSendFlowerReq.uint32_business_id.set(paramInt3);
    ((oidb_0x6b6.ReqBody)localObject1).msg_ext_param.set(paramSendFlowerReq);
    paramString2 = new Bundle();
    paramString2.putInt("subCmd", paramInt2);
    if (QLog.isColorLevel())
    {
      paramSendFlowerReq = new StringBuilder();
      paramSendFlowerReq.append("send_oidb_0x6b6. serviceType=");
      paramSendFlowerReq.append(paramInt2);
      QLog.i(".troop.send_gift", 2, paramSendFlowerReq.toString());
    }
    paramSendFlowerReq = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    paramThrowFlowerReq = new TroopGiftManager.1(this, paramTroopGiftCallback);
    paramTroopGiftCallback = ((oidb_0x6b6.ReqBody)localObject1).toByteArray();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramInt2);
    ProtoUtils.a(paramSendFlowerReq, paramThrowFlowerReq, paramTroopGiftCallback, ((StringBuilder)localObject1).toString(), paramInt1, paramInt2, paramString2, paramLong);
    return;
    label1177:
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("send_oidb_0x6b6. serviceType=");
      paramString1.append(paramInt2);
      QLog.e(".troop.send_gift", 2, paramString1.toString());
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, oidb_0x6c3.GetStockReq paramGetStockReq, oidb_0x6c3.GetExtraDataReq paramGetExtraDataReq, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if (paramTroopGiftCallback == null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("send_oidb_0x6c3. troopUin is null. callback=");
        paramString1.append(paramTroopGiftCallback);
        QLog.e(".troop.send_gift", 2, paramString1.toString());
      }
      return;
    }
    Object localObject1 = new oidb_0x6c3.ReqBody();
    if (paramString2 != null) {}
    try
    {
      long l = Long.valueOf(paramString2).longValue();
      ((oidb_0x6c3.ReqBody)localObject1).uint64_group.set(l, true);
      break label93;
      ((oidb_0x6c3.ReqBody)localObject1).uint64_group.set(0L, true);
      label93:
      ((oidb_0x6c3.ReqBody)localObject1).uint32_portal.set(a(paramString2, paramInt2, paramInt3), true);
      if (paramGetStockReq != null) {
        ((oidb_0x6c3.ReqBody)localObject1).msg_get_stock = paramGetStockReq;
      } else if (paramGetExtraDataReq != null) {
        ((oidb_0x6c3.ReqBody)localObject1).msg_extra_data = paramGetExtraDataReq;
      }
      if (paramInt4 == -1)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("send_oidb_0x6c3. serviceType=");
          paramString1.append(paramInt4);
          QLog.e(".troop.send_gift", 2, paramString1.toString());
        }
        return;
      }
      paramGetExtraDataReq = GCCommon.b();
      paramGetStockReq = paramGetExtraDataReq;
      if (TextUtils.isEmpty(paramGetExtraDataReq)) {
        paramGetStockReq = "0.0.0.0";
      }
      Object localObject2 = new StringBuilder();
      paramGetExtraDataReq = "";
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(AppSetting.a());
      localObject2 = ((StringBuilder)localObject2).toString();
      paramInt3 = AppSetting.a();
      ((oidb_0x6c3.ReqBody)localObject1).bytes_user_ip.set(ByteStringMicro.copyFrom(paramGetStockReq.getBytes()), true);
      ((oidb_0x6c3.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()), true);
      ((oidb_0x6c3.ReqBody)localObject1).uint32_client.set(1, true);
      ((oidb_0x6c3.ReqBody)localObject1).uint32_instance_id.set(paramInt3, true);
      ((oidb_0x6c3.ReqBody)localObject1).uint32_business_id.set(paramInt2, true);
      ((oidb_0x6c3.ReqBody)localObject1).setHasFlag(true);
      localObject2 = new oidb_0x6c3.ExtParam();
      TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
      paramGetStockReq = paramGetExtraDataReq;
      if (localTicketManager != null) {
        paramGetStockReq = localTicketManager.getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      }
      paramGetExtraDataReq = new oidb_0x6c3.LoginSig();
      paramGetExtraDataReq.uint32_type.set(1);
      paramGetExtraDataReq.uint32_appid.set(0);
      if (!TextUtils.isEmpty(paramGetStockReq)) {
        paramGetExtraDataReq.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramGetStockReq));
      }
      ((oidb_0x6c3.ExtParam)localObject2).msg_login_sig.set(paramGetExtraDataReq);
      ((oidb_0x6c3.ReqBody)localObject1).msg_ext_param.set((MessageMicro)localObject2);
      paramGetStockReq = new Bundle();
      paramGetStockReq.putInt("subCmd", paramInt4);
      paramGetStockReq.putString("troopUin", paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("send_oidb_0x6c3. serviceType=");
        paramString2.append(paramInt4);
        QLog.i(".troop.send_gift", 2, paramString2.toString());
      }
      paramString2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      paramGetExtraDataReq = new TroopGiftManager.3(this, paramTroopGiftCallback);
      paramTroopGiftCallback = ((oidb_0x6c3.ReqBody)localObject1).toByteArray();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramInt4);
      ProtoUtils.a(paramString2, paramGetExtraDataReq, paramTroopGiftCallback, ((StringBuilder)localObject1).toString(), paramInt1, paramInt4, paramGetStockReq, paramLong);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      label585:
      break label585;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("send_oidb_0x6c3. NumberFormatException troopUin=");
      paramString1.append(paramString2);
      QLog.e(".troop.send_gift", 2, paramString1.toString());
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    oidb_0x6c2.ReqBody localReqBody;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramTroopGiftCallback != null)) {
      localReqBody = new oidb_0x6c2.ReqBody();
    }
    try
    {
      long l = Long.valueOf(paramString1).longValue();
      localReqBody.uint64_group_id.set(l, true);
      localReqBody.bytes_gift_bagid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
      localReqBody.uint32_channel.set(1, true);
      localReqBody.setHasFlag(true);
      localObject1 = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
      if (localObject1 != null) {
        localObject1 = ((TicketManager)localObject1).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      } else {
        localObject1 = "";
      }
      Object localObject2 = new oidb_0x6c2.LoginSig();
      ((oidb_0x6c2.LoginSig)localObject2).uint32_type.set(1);
      ((oidb_0x6c2.LoginSig)localObject2).uint32_appid.set(0);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((oidb_0x6c2.LoginSig)localObject2).bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      }
      localReqBody.msg_login_sig.set((MessageMicro)localObject2);
      if (paramInt3 == 0)
      {
        localReqBody.int32_page_index.set(paramInt1, true);
        localReqBody.int32_page_size.set(paramInt2, true);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("subCmd", paramInt3);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("send_oidb_0x6c2. serviceType=");
        ((StringBuilder)localObject2).append(paramInt3);
        QLog.i(".troop.send_gift", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      paramString1 = new TroopGiftManager.5(this, paramTroopGiftCallback, paramString1, paramString2);
      paramString2 = localReqBody.toByteArray();
      paramTroopGiftCallback = new StringBuilder();
      paramTroopGiftCallback.append("OidbSvc.0x6c2_");
      paramTroopGiftCallback.append(paramInt3);
      ProtoUtils.a((AppRuntime)localObject2, paramString1, paramString2, paramTroopGiftCallback.toString(), 1730, paramInt3, (Bundle)localObject1, paramLong);
      return;
    }
    catch (NumberFormatException paramString2)
    {
      Object localObject1;
      label345:
      break label345;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("send_oidb_0x6c2. NumberFormatException troopUin=");
      paramString2.append(paramString1);
      QLog.e(".troop.send_gift", 2, paramString2.toString());
    }
    return;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send_oidb_0x6c2. troopUin=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" giftBagID=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" callback=");
      ((StringBuilder)localObject1).append(paramTroopGiftCallback);
      QLog.e(".troop.send_gift", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, TroopGiftCallback paramTroopGiftCallback)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send_oidb_0x962. interactId: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", cmd: ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d(".troop.send_gift", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      long l = Long.parseLong(paramString1);
      localObject = new oidb_0x962.ClientInfo();
      ((oidb_0x962.ClientInfo)localObject).uint32_client_type.set(1, true);
      ((oidb_0x962.ClientInfo)localObject).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.a().getBytes()), true);
      paramString1 = new oidb_0x962.ReqBody();
      paramString1.uint64_group_code.set(l, true);
      paramString1.bytes_id.set(ByteStringMicro.copyFrom(paramString2.getBytes()), true);
      paramString1.uint32_times.set(paramInt1, true);
      paramString1.msg_client_info.set((MessageMicro)localObject, true);
      paramString1.uint32_product_id.set(paramInt2, true);
      paramString1.uint32_cmd.set(paramInt3, true);
      paramString2 = new Bundle();
      paramString2.putInt("subCmd", paramInt3);
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      paramTroopGiftCallback = new TroopGiftManager.6(this, paramTroopGiftCallback);
      paramString1 = paramString1.toByteArray();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OidbSvc.0x962_");
      localStringBuilder.append(paramInt3);
      ProtoUtils.a((AppRuntime)localObject, paramTroopGiftCallback, paramString1, localStringBuilder.toString(), 2402, 1, paramString2, 500L);
      return;
    }
    catch (Exception paramString2)
    {
      label265:
      break label265;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("send_oidb_0x962. troopUin is wrong");
      paramString2.append(paramString1);
      QLog.e(".troop.send_gift", 2, paramString2.toString());
    }
  }
  
  private void b(TroopGiftCallback paramTroopGiftCallback)
  {
    Oidb_0xcd1.ReqBody localReqBody = new Oidb_0xcd1.ReqBody();
    Oidb_0xcd1.GetPackageShopReq localGetPackageShopReq = new Oidb_0xcd1.GetPackageShopReq();
    localGetPackageShopReq.portal_number.set(2);
    localReqBody.get_pack_req.set(localGetPackageShopReq);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new TroopGiftManager.2(this, paramTroopGiftCallback), localReqBody.toByteArray(), "OidbSvc.0xcd1_0", 3281, 0, null, 0L);
  }
  
  private void b(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    oidb_0x6b5.ReqBody localReqBody;
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (paramTroopGiftCallback != null)) {
      localReqBody = new oidb_0x6b5.ReqBody();
    }
    try
    {
      long l = Long.valueOf(paramString2).longValue();
      Object localObject1 = localReqBody.uint64_group_id;
      int j = 1;
      ((PBUInt64Field)localObject1).set(l, true);
      localObject1 = localReqBody.uint32_portal;
      int i;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        i = 7;
      } else {
        i = 10;
      }
      ((PBUInt32Field)localObject1).set(a(paramString2, paramInt2, i));
      localReqBody.uint32_business_id.set(paramInt2, true);
      localReqBody.bytes_gift_bagid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
      localReqBody.uint32_channel.set(1, true);
      localReqBody.setHasFlag(true);
      localObject1 = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
      if (localObject1 != null) {
        localObject1 = ((TicketManager)localObject1).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      } else {
        localObject1 = "";
      }
      Object localObject2 = new oidb_0x6b5.LoginSig();
      ((oidb_0x6b5.LoginSig)localObject2).uint32_type.set(1);
      ((oidb_0x6b5.LoginSig)localObject2).uint32_appid.set(0);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((oidb_0x6b5.LoginSig)localObject2).bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      }
      localReqBody.msg_login_sig.set((MessageMicro)localObject2);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("subCmd", 0);
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b5. serviceType=0");
      }
      if (paramInt2 >= 4) {
        paramInt2 = j;
      } else {
        paramInt2 = 0;
      }
      localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      paramString2 = new TroopGiftManager.4(this, paramTroopGiftCallback, paramString2, paramString3);
      paramString3 = localReqBody.toByteArray();
      paramTroopGiftCallback = new StringBuilder();
      paramTroopGiftCallback.append(paramString1);
      paramTroopGiftCallback.append("_");
      paramTroopGiftCallback.append(paramInt2);
      ProtoUtils.a((AppRuntime)localObject2, paramString2, paramString3, paramTroopGiftCallback.toString(), paramInt1, paramInt2, (Bundle)localObject1, paramLong);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      label372:
      break label372;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("send_oidb_0x6b5. NumberFormatException troopUin=");
      paramString1.append(paramString2);
      QLog.e(".troop.send_gift", 2, paramString1.toString());
    }
    return;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("send_oidb_0x6b5. troopUin=");
      paramString1.append(paramString2);
      paramString1.append(" giftBagID=");
      paramString1.append(paramString3);
      paramString1.append(" callback=");
      paramString1.append(paramTroopGiftCallback);
      QLog.e(".troop.send_gift", 2, paramString1.toString());
    }
  }
  
  public int a(int paramInt)
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_troop_gift_");
    localStringBuilder.append(paramInt);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt("gift_list_version", 0);
  }
  
  public TroopGiftBagInfo a(String paramString1, String paramString2, TroopGiftCallback paramTroopGiftCallback)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject) != null) {
        return (TroopGiftBagInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      }
      TroopGiftBagInfo localTroopGiftBagInfo = (TroopGiftBagInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(TroopGiftBagInfo.class, paramString2);
      if (localTroopGiftBagInfo != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localTroopGiftBagInfo);
        return localTroopGiftBagInfo;
      }
      a(paramString1, paramString2, 0, 0, 1000L, paramTroopGiftCallback);
      return null;
    }
    if (QLog.isColorLevel())
    {
      paramTroopGiftCallback = new StringBuilder();
      paramTroopGiftCallback.append("getGrabBagInfo. troopUin:");
      paramTroopGiftCallback.append(paramString1);
      paramTroopGiftCallback.append(" bagID:");
      paramTroopGiftCallback.append(paramString2);
      QLog.e(".troop.send_gift .troop.send_gift", 2, paramTroopGiftCallback.toString());
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_troop_gift_");
    localStringBuilder.append(paramInt2);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("gift_list_version", paramInt1).commit();
  }
  
  public void a(int paramInt, TroopGiftCallback paramTroopGiftCallback)
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return;
    }
    cmd0x9e9.ReqBody localReqBody = new cmd0x9e9.ReqBody();
    cmd0x9e9.User localUser = new cmd0x9e9.User();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(AppSetting.a());
    localObject = ((StringBuilder)localObject).toString();
    localUser.bytes_version.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()), true);
    localUser.uint32_client.set(1, true);
    localUser.uint32_portal.set(paramInt, true);
    localReqBody.msg_user.set(localUser, true);
    ProtoUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, new TroopGiftManager.8(this, paramTroopGiftCallback), localReqBody.toByteArray(), "OidbSvc.0x9e9_0", 2537, 0);
  }
  
  public void a(TroopGiftAioItemData paramTroopGiftAioItemData, int paramInt, String paramString, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if ((paramTroopGiftAioItemData != null) && (paramTroopGiftCallback != null))
    {
      localObject2 = new cmd0xdad.ReqBody();
      ((cmd0xdad.ReqBody)localObject2).client.set(1L, true);
      ((cmd0xdad.ReqBody)localObject2).product_id.set(paramTroopGiftAioItemData.jdField_a_of_type_Int, true);
      ((cmd0xdad.ReqBody)localObject2).amount.set(paramTroopGiftAioItemData.f, true);
      ((cmd0xdad.ReqBody)localObject2).to_uin.set(paramLong, true);
      if (paramString == null) {}
    }
    try
    {
      paramLong = Long.valueOf(paramString).longValue();
      ((cmd0xdad.ReqBody)localObject2).gc.set(paramLong, true);
    }
    catch (NumberFormatException paramTroopGiftAioItemData)
    {
      label97:
      Object localObject1;
      break label97;
    }
    if (QLog.isColorLevel())
    {
      paramTroopGiftAioItemData = new StringBuilder();
      paramTroopGiftAioItemData.append("send_oidb_0x6b6. NumberFormatException troopUin=");
      paramTroopGiftAioItemData.append(paramString);
      QLog.e(".troop.send_gift", 2, paramTroopGiftAioItemData.toString());
    }
    return;
    paramString = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    localObject1 = new cmd0xdad.LoginSig();
    ((cmd0xdad.LoginSig)localObject1).bytes_sig.set(ByteStringMicro.copyFrom(paramString.getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).getBytes()), true);
    ((cmd0xdad.LoginSig)localObject1).uint32_type.set(1, true);
    ((cmd0xdad.LoginSig)localObject1).uint32_appid.set(0, true);
    ((cmd0xdad.ReqBody)localObject2).sig.set((MessageMicro)localObject1, true);
    localObject1 = GCCommon.b();
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = "0.0.0.0";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(AppSetting.a());
    localObject1 = ((StringBuilder)localObject1).toString();
    ((cmd0xdad.ReqBody)localObject2).ip.set(new String(paramString.getBytes()), true);
    ((cmd0xdad.ReqBody)localObject2).vsersion.set(new String(((String)localObject1).getBytes()), true);
    ((cmd0xdad.ReqBody)localObject2).setHasFlag(true);
    paramString = new Bundle();
    paramString.putInt("subCmd", paramInt);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send_oidb_0xdad. serviceType=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i(".troop.send_gift", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    paramTroopGiftAioItemData = new TroopGiftManager.7(this, paramTroopGiftCallback, paramTroopGiftAioItemData);
    paramTroopGiftCallback = ((cmd0xdad.ReqBody)localObject2).toByteArray();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("OidbSvc.0xdad_");
    ((StringBuilder)localObject2).append(paramInt);
    ProtoUtils.a((AppRuntime)localObject1, paramTroopGiftAioItemData, paramTroopGiftCallback, ((StringBuilder)localObject2).toString(), 3501, paramInt, paramString, 0L);
    return;
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift", 2, "sendAdFreeGift arg err");
    }
  }
  
  public void a(TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchPackageGiftInfo");
    }
    b(paramTroopGiftCallback);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("throwGift. troopUin:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" entranceID:");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(" count:");
      ((StringBuilder)localObject).append(paramInt5);
      ((StringBuilder)localObject).append(" playRule:");
      ((StringBuilder)localObject).append(paramInt6);
      ((StringBuilder)localObject).append(" productID:");
      ((StringBuilder)localObject).append(paramInt7);
      QLog.e(".troop.send_gift .troop.send_gift", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x6b6.ThrowFlowerReq();
    ((oidb_0x6b6.ThrowFlowerReq)localObject).int32_count.set(paramInt5, true);
    ((oidb_0x6b6.ThrowFlowerReq)localObject).uint32_play_rule.set(paramInt6, true);
    ((oidb_0x6b6.ThrowFlowerReq)localObject).uint32_product_id.set(paramInt7, true);
    ((oidb_0x6b6.ThrowFlowerReq)localObject).setHasFlag(true);
    a(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramInt4, 0, null, (oidb_0x6b6.ThrowFlowerReq)localObject, 0L, paramTroopGiftCallback);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8, int paramInt9, TroopGiftCallback paramTroopGiftCallback, int paramInt10)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendGift. troopUin:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" entranceID:");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(" count:");
      ((StringBuilder)localObject).append(paramInt5);
      ((StringBuilder)localObject).append(" toUin:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" playRule:");
      ((StringBuilder)localObject).append(paramInt6);
      ((StringBuilder)localObject).append(" customFlag:");
      ((StringBuilder)localObject).append(paramInt7);
      QLog.e(".troop.send_gift .troop.send_gift", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x6b6.SendFlowerReq();
    ((oidb_0x6b6.SendFlowerReq)localObject).int32_count.set(paramInt5, true);
    ((oidb_0x6b6.SendFlowerReq)localObject).uint64_to_uin.set(paramLong, true);
    ((oidb_0x6b6.SendFlowerReq)localObject).uint32_play_rule.set(paramInt6, true);
    ((oidb_0x6b6.SendFlowerReq)localObject).uint32_custom_flag.set(paramInt7, true);
    ((oidb_0x6b6.SendFlowerReq)localObject).uint32_product_id.set(paramInt8);
    if (paramInt7 == 1) {
      ((oidb_0x6b6.SendFlowerReq)localObject).uint32_gift_id.set(paramInt10);
    }
    ((oidb_0x6b6.SendFlowerReq)localObject).setHasFlag(true);
    a(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramInt4, paramInt9, (oidb_0x6b6.SendFlowerReq)localObject, null, 0L, paramTroopGiftCallback);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchExtraInfo. troopUin:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" entranceID:");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.e(".troop.send_gift .troop.send_gift", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x6c3.GetExtraDataReq();
    ((oidb_0x6c3.GetExtraDataReq)localObject).setHasFlag(true);
    ((oidb_0x6c3.GetExtraDataReq)localObject).int32_config_id.set(paramInt5, true);
    a(paramString1, paramInt1, paramInt2, paramString2, paramInt3, paramInt4, null, (oidb_0x6c3.GetExtraDataReq)localObject, 0L, paramTroopGiftCallback);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, TroopGiftCallback paramTroopGiftCallback)
  {
    a(paramString1, paramInt1, paramInt2, paramString2, paramInt3, paramInt4, false, false, paramTroopGiftCallback);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, TroopGiftCallback paramTroopGiftCallback)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("grabGift. troopUin:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" bagID:");
      localStringBuilder.append(paramString3);
      QLog.e(".troop.send_gift .troop.send_gift", 2, localStringBuilder.toString());
    }
    b(paramString1, paramInt1, paramInt2, paramString2, paramString3, paramLong, paramTroopGiftCallback);
  }
  
  public void a(String paramString, TroopGiftCallback paramTroopGiftCallback)
  {
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new oidb_0xa48.ReqBody();
      paramString.uint64_groupcode.set(l, true);
      ProtoUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, new TroopGiftManager.9(this, paramTroopGiftCallback), paramString.toByteArray(), "OidbSvc.0xa48_1", 2632, 1, new Bundle(), 6000L);
      return;
    }
    catch (Exception paramString)
    {
      label63:
      break label63;
    }
    paramTroopGiftCallback.a(-1, "troop uin error");
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchGrabBagInfo. troopUin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" bagID:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" pageIndex");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" pageSize:");
      localStringBuilder.append(paramInt2);
      QLog.e(".troop.send_gift .troop.send_gift", 2, localStringBuilder.toString());
    }
    a(paramString1, paramString2, paramInt1, paramInt2, 0, paramLong, paramTroopGiftCallback);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportInteract. troopUin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" giftID:");
      localStringBuilder.append(paramString2);
      QLog.d(".troop.send_gift .troop.send_gift", 2, localStringBuilder.toString());
    }
    a(paramString1, paramString2, paramInt2, paramInt1, 3, paramTroopGiftCallback);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("chechInteract. troopUin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" giftID:");
      localStringBuilder.append(paramString2);
      QLog.d(".troop.send_gift .troop.send_gift", 2, localStringBuilder.toString());
    }
    a(paramString1, paramString2, 0, paramInt, 1, paramTroopGiftCallback);
  }
  
  public void a(boolean paramBoolean)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_troop_gift_panel_red_dot");
    localObject = ((StringBuilder)localObject).toString();
    int i;
    if (Build.VERSION.SDK_INT >= 11) {
      i = 4;
    } else {
      i = 0;
    }
    localBaseApplication.getSharedPreferences((String)localObject, i).edit().putBoolean("troop_gift_panel_red_dot", paramBoolean).commit();
  }
  
  public boolean a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_troop_gift_panel_red_dot");
    localObject = ((StringBuilder)localObject).toString();
    int i;
    if (Build.VERSION.SDK_INT >= 11) {
      i = 4;
    } else {
      i = 0;
    }
    return localBaseApplication.getSharedPreferences((String)localObject, i).getBoolean("troop_gift_panel_red_dot", false);
  }
  
  public boolean a(Entity paramEntity)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    boolean bool = false;
    if (localEntityManager != null)
    {
      if (paramEntity == null) {
        return false;
      }
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
        return bool;
      }
      if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
        return false;
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
    }
    return false;
  }
  
  public void b(String paramString1, String paramString2, int paramInt, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startInteract. troopUin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" giftID:");
      localStringBuilder.append(paramString2);
      QLog.d(".troop.send_gift .troop.send_gift", 2, localStringBuilder.toString());
    }
    a(paramString1, paramString2, 0, paramInt, 2, paramTroopGiftCallback);
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clear History. uin:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
      localStringBuilder.append(" app=");
      localStringBuilder.append(String.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface));
      QLog.d(".troop.send_gift", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager
 * JD-Core Version:    0.7.0.1
 */