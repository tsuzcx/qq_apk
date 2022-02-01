package com.tencent.mobileqq.troop.recommend.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.mobileqq.troop.recommend.api.TroopRecommendObserver;
import com.tencent.mobileqq.troop.recommend.data.NotificationRecommendTroopItem;
import com.tencent.mobileqq.troop.recommend.data.RecommendMember;
import com.tencent.mobileqq.troop.recommend.utils.TroopRecommendTransUtils;
import com.tencent.mobileqq.utils.TroopRecommendUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;
import tencent.im.oidb.cmd0x935.oidb_0x935.RecommendInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.ReqBody;
import tencent.im.oidb.cmd0x935.oidb_0x935.RgroupInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.RspBody;
import tencent.im.oidb.cmd0xded.oidb_0xded.ReqBody;
import tencent.im.oidb.cmd0xded.oidb_0xded.RspBody;
import tencent.im.oidb.cmd0xe3a.oidb_0xe3a.ReqBody;
import tencent.im.oidb.cmd0xe3a.oidb_0xe3a.RspBody;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.GroupInfo;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.RecommendPerson;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.ReqBody;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopRecommendHandler
  extends TroopBaseHandler
  implements ITroopRecommendHandler
{
  protected Set<String> a;
  
  public TroopRecommendHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    oidb_0xded.RspBody localRspBody = new oidb_0xded.RspBody();
    int i = -1;
    boolean bool2 = bool1;
    if (bool1)
    {
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      bool2 = bool1;
      i = j;
      if (j != 0)
      {
        bool2 = false;
        i = j;
      }
    }
    paramToServiceMsg = null;
    if (bool2) {
      paramToServiceMsg = localRspBody.rpt_classify_info.get();
    } else {
      bool2 = false;
    }
    notifyUI(TroopRecommendObserver.e, bool2, new Object[] { paramToServiceMsg });
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle_oidb_0xded_1_response, isSuc=");
      paramFromServiceMsg.append(bool2);
      paramFromServiceMsg.append(",oidbesult=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",dataList.size() = ");
      if (paramToServiceMsg == null) {
        paramToServiceMsg = "null";
      } else {
        paramToServiceMsg = Integer.valueOf(paramToServiceMsg.size());
      }
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.i("TroopRecommendHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  protected String a()
  {
    return "TroopRecommendHandler";
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.TroopRecommendHandler", 2, "send_oidb_0xded_1");
    }
    Object localObject = new oidb_0xded.ReqBody();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3565);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xded.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0xded_1");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, oidb_0x935.GPS paramGPS)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send_oidb_0x935_20  itemType = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",curPage = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",troopCount = ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",gps = ");
      ((StringBuilder)localObject).append(paramGPS);
      QLog.d("ac_ft.TroopRecommendHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x935.ReqBody();
    ((oidb_0x935.ReqBody)localObject).uint32_appid.set(1);
    ((oidb_0x935.ReqBody)localObject).uint32_pos.set(paramInt2);
    if (paramGPS != null) {
      ((oidb_0x935.ReqBody)localObject).msg_gps.set(paramGPS);
    }
    ((oidb_0x935.ReqBody)localObject).uint32_max_pos_count.set(paramInt3);
    paramGPS = new oidb_sso.OIDBSSOPkg();
    paramGPS.uint32_command.set(2357);
    paramGPS.uint32_result.set(0);
    paramGPS.uint32_service_type.set(20);
    paramGPS.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x935.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x935_20");
    ((ToServiceMsg)localObject).putWupBuffer(paramGPS.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("add_contact_find_troop_item_type", paramInt1);
    ((ToServiceMsg)localObject).extraData.putBoolean("key_load_more", paramBoolean);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send_oidb_0x935_10  itemType = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",keyWord = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",curPage = ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(",loadMore = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(",troopCount = ");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.d("ac_ft.TroopRecommendHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x935.ReqBody();
    ((oidb_0x935.ReqBody)localObject2).uint32_appid.set(1);
    ((oidb_0x935.ReqBody)localObject2).uint32_pos.set(paramInt2);
    ((oidb_0x935.ReqBody)localObject2).uint32_max_pos_count.set(paramInt3);
    PBBytesField localPBBytesField = ((oidb_0x935.ReqBody)localObject2).bytes_class_param;
    if (!TextUtils.isEmpty(paramString)) {
      localObject1 = paramString;
    } else {
      localObject1 = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2357);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(10);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x935.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x935_10");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putInt("add_contact_find_troop_item_type", paramInt1);
    ((ToServiceMsg)localObject2).extraData.putBoolean("key_load_more", paramBoolean);
    ((ToServiceMsg)localObject2).extraData.putString("add_contact_find_troop_item_key_word", paramString);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send_oidb_0x935_9  troopUin = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(",curPage = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",troopCount = ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("TroopRecommendHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x935.ReqBody();
    ((oidb_0x935.ReqBody)localObject2).uint32_appid.set(1);
    ((oidb_0x935.ReqBody)localObject2).uint64_join_gc.set(paramLong);
    ((oidb_0x935.ReqBody)localObject2).uint32_pos.set(paramInt1);
    ((oidb_0x935.ReqBody)localObject2).uint32_max_pos_count.set(paramInt2);
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2357);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x935.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x935_9");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = new oidb_0x935.RspBody();
    int j = -1;
    int k;
    int i;
    if (bool1)
    {
      k = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      i = k;
      if (k != 0)
      {
        bool1 = false;
        i = k;
      }
    }
    else
    {
      i = -1;
    }
    paramFromServiceMsg = new ArrayList();
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    if (bool1)
    {
      k = ((oidb_0x935.RspBody)localObject).is_end.get();
      int m = ((oidb_0x935.RspBody)localObject).cur_pos.get();
      paramToServiceMsg = ((oidb_0x935.RspBody)localObject).recommend_info.get();
      paramFromServiceMsg = new ArrayList();
      localObject = paramToServiceMsg.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramToServiceMsg = ((oidb_0x935.RecommendInfo)((Iterator)localObject).next()).msg_groups.get();
        if (paramToServiceMsg == null) {
          return;
        }
        Iterator localIterator = paramToServiceMsg.iterator();
        while (localIterator.hasNext())
        {
          oidb_0x935.RgroupInfo localRgroupInfo = (oidb_0x935.RgroupInfo)localIterator.next();
          if (localRgroupInfo.uint64_group_code.has())
          {
            NotificationRecommendTroopItem localNotificationRecommendTroopItem = new NotificationRecommendTroopItem();
            localNotificationRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
            if (localRgroupInfo.bytes_group_name.has()) {
              localNotificationRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
            }
            if (localRgroupInfo.bytes_group_memo.has()) {
              localNotificationRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
            }
            localNotificationRecommendTroopItem.labelList = TroopRecommendTransUtils.a(localRgroupInfo.rpt_group_label.get());
            localNotificationRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
            localNotificationRecommendTroopItem.x935RgroupInfo = localRgroupInfo.toByteArray();
            boolean bool2 = localRgroupInfo.bytes_algorithm.has();
            paramObject = "";
            if (bool2) {
              paramToServiceMsg = localRgroupInfo.bytes_algorithm.get().toStringUtf8();
            } else {
              paramToServiceMsg = "";
            }
            localNotificationRecommendTroopItem.recomAlgol = paramToServiceMsg;
            paramToServiceMsg = paramObject;
            if (localRgroupInfo.bytes_join_group_auth.has()) {
              paramToServiceMsg = localRgroupInfo.bytes_join_group_auth.get().toStringUtf8();
            }
            localNotificationRecommendTroopItem.authSig = paramToServiceMsg;
            if (localRgroupInfo.uint32_activity.has()) {
              j = localRgroupInfo.uint32_activity.get();
            } else {
              j = 0;
            }
            localNotificationRecommendTroopItem.activity = j;
            if (localRgroupInfo.int32_uin_privilege.has()) {
              j = localRgroupInfo.int32_uin_privilege.get();
            } else {
              j = -1;
            }
            localNotificationRecommendTroopItem.privilege = j;
            paramFromServiceMsg.add(localNotificationRecommendTroopItem);
          }
        }
      }
      j = m;
      paramToServiceMsg = paramFromServiceMsg;
    }
    else
    {
      paramToServiceMsg = paramFromServiceMsg;
      bool1 = false;
      k = -1;
    }
    notifyUI(TroopRecommendObserver.c, bool1, new Object[] { Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), paramToServiceMsg });
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle_oidb_0x935_9_response, isSuc=");
      paramFromServiceMsg.append(bool1);
      paramFromServiceMsg.append(",oidbesult=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",troopUin = ");
      paramFromServiceMsg.append(l);
      paramFromServiceMsg.append(",isEnd = ");
      paramFromServiceMsg.append(k);
      paramFromServiceMsg.append(",dataList.size() = ");
      paramFromServiceMsg.append(paramToServiceMsg.size());
      QLog.i("TroopRecommendHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendReportForTroopRecommendGrayTips ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.i("TroopRecommendHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopRecommendHandler", 2, "sendReportForTroopRecommendGrayTips no info");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendReportForTroopRecommendGrayTips troopInfo:");
      ((StringBuilder)localObject2).append(((TroopInfo)localObject1).dwGroupClassExt);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(((TroopInfo)localObject1).wMemberNum);
      QLog.i("TroopRecommendHandler", 2, ((StringBuilder)localObject2).toString());
    }
    long l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      long l2;
      label197:
      long l3;
      break label197;
    }
    Object localObject2 = new oidb_0xe3a.ReqBody();
    ((oidb_0xe3a.ReqBody)localObject2).uint64_uin.set(this.appRuntime.getLongAccountUin());
    ((oidb_0xe3a.ReqBody)localObject2).uint64_group_id.set(l1);
    ((oidb_0xe3a.ReqBody)localObject2).uint32_group_type.set((int)((TroopInfo)localObject1).dwGroupClassExt);
    ((oidb_0xe3a.ReqBody)localObject2).uint32_group_total_person.set(((TroopInfo)localObject1).wMemberNum);
    if (paramInt1 == 2)
    {
      ((oidb_0xe3a.ReqBody)localObject2).uint32_graybar_type.set(paramInt2);
      paramInt2 = 2;
    }
    else if (paramInt1 == 1)
    {
      l1 = TroopRecommendUtils.a(this.appRuntime, paramString);
      l2 = ((TroopInfo)localObject1).dwLastInsertBAFTipTime;
      l3 = TroopRecommendUtils.b(this.appRuntime, paramString);
      ((oidb_0xe3a.ReqBody)localObject2).uint64_last_graybar_insert_time.set(Math.max(Math.max(l3, l2), l1));
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendReportForTroopRecommendGrayTips last time:");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(l3);
        QLog.i("TroopRecommendHandler", 2, ((StringBuilder)localObject1).toString());
      }
      paramInt2 = 1;
    }
    else
    {
      paramInt2 = 0;
    }
    localObject1 = makeOIDBPkg("oidbSvc.0xe3a", 3642, paramInt2, ((oidb_0xe3a.ReqBody)localObject2).toByteArray(), 30000L);
    ((ToServiceMsg)localObject1).addAttribute("troopUin", paramString);
    ((ToServiceMsg)localObject1).addAttribute("type", Integer.valueOf(paramInt1));
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    a(paramString, paramInt1, paramInt2, paramArrayOfByte, paramInt3, null);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3, ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTroopRecommendGrayTipsData ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramArrayOfByte);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramArrayList);
      QLog.i("TroopRecommendHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopRecommendHandler", 2, "getTroopRecommendGrayTipsData no info");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getTroopRecommendGrayTipsData troopInfo:");
      ((StringBuilder)localObject2).append(((TroopInfo)localObject1).dwGroupClassExt);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(((TroopInfo)localObject1).wMemberNum);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(((TroopInfo)localObject1).troopowneruin);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(((TroopInfo)localObject1).Administrator);
      QLog.i("TroopRecommendHandler", 2, ((StringBuilder)localObject2).toString());
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception localException1)
    {
      label288:
      oidb_0xe3b.GroupInfo localGroupInfo;
      break label288;
    }
    Object localObject2 = new oidb_0xe3b.ReqBody();
    localGroupInfo = new oidb_0xe3b.GroupInfo();
    ((oidb_0xe3b.ReqBody)localObject2).uint32_req_type.set(paramInt1);
    localGroupInfo.uint64_group_id.set(l1);
    localGroupInfo.uint32_group_type.set((int)((TroopInfo)localObject1).dwGroupClassExt);
    localGroupInfo.uint32_group_total_person.set(((TroopInfo)localObject1).wMemberNum);
    if (!TextUtils.isEmpty(((TroopInfo)localObject1).troopowneruin)) {}
    try
    {
      l1 = Long.parseLong(((TroopInfo)localObject1).troopowneruin);
      localGroupInfo.rpt_uint64_group_manager.add(Long.valueOf(l1));
    }
    catch (Exception localException2)
    {
      label389:
      String[] arrayOfString;
      break label389;
    }
    if (!TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))
    {
      arrayOfString = ((TroopInfo)localObject1).Administrator.split("\\|");
      if (arrayOfString == null) {}
    }
    try
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        l1 = Long.parseLong(arrayOfString[i]);
        localGroupInfo.rpt_uint64_group_manager.add(Long.valueOf(l1));
        i += 1;
      }
    }
    catch (Exception localException3)
    {
      label465:
      break label465;
    }
    ((oidb_0xe3b.ReqBody)localObject2).msg_group_info.set(localGroupInfo);
    if (paramInt1 == 1)
    {
      paramArrayOfByte = TroopRecommendUtils.a(this.appRuntime, String.valueOf(paramString));
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        ((oidb_0xe3b.ReqBody)localObject2).bytes_cookie_for_req_type_1.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
    }
    else if (paramInt1 == 2)
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        ((oidb_0xe3b.ReqBody)localObject2).bytes_cookie_for_req_type_2.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      if (paramInt3 > 0) {
        ((oidb_0xe3b.ReqBody)localObject2).uint32_want.set(paramInt3);
      }
      ((oidb_0xe3b.ReqBody)localObject2).uint32_graybar_type.set(paramInt2);
      if (paramArrayList != null)
      {
        paramArrayOfByte = paramArrayList.iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramArrayList = (Long)paramArrayOfByte.next();
          ((oidb_0xe3b.ReqBody)localObject2).rpt_uint64_uin_show_ahead.add(paramArrayList);
        }
      }
    }
    paramArrayOfByte = makeOIDBPkg("oidbSvc.0xe3b", 3643, 1, ((oidb_0xe3b.ReqBody)localObject2).toByteArray(), 30000L);
    paramArrayOfByte.addAttribute("troopUin", paramString);
    paramArrayOfByte.addAttribute("type", Integer.valueOf(paramInt1));
    paramArrayOfByte.addAttribute("groupClass", Long.valueOf(((TroopInfo)localObject1).dwGroupClassExt));
    sendPbReq(paramArrayOfByte);
  }
  
  public void b(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send_oidb_0x935_23  itemType = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",keyWord = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",curPage = ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(",loadMore = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(",troopCount = ");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.d("ac_ft.TroopRecommendHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x935.ReqBody();
    ((oidb_0x935.ReqBody)localObject2).uint32_appid.set(1);
    ((oidb_0x935.ReqBody)localObject2).uint32_pos.set(paramInt2);
    ((oidb_0x935.ReqBody)localObject2).uint32_max_pos_count.set(paramInt3);
    PBBytesField localPBBytesField = ((oidb_0x935.ReqBody)localObject2).bytes_class_param;
    if (!TextUtils.isEmpty(paramString)) {
      localObject1 = paramString;
    } else {
      localObject1 = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2357);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(23);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x935.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x935_23");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putInt("add_contact_find_troop_item_type", paramInt1);
    ((ToServiceMsg)localObject2).extraData.putBoolean("key_load_more", paramBoolean);
    ((ToServiceMsg)localObject2).extraData.putString("add_contact_find_troop_item_key_word", paramString);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = new oidb_0x935.RspBody();
    int i;
    if (bool1)
    {
      j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      i = j;
      if (j != 0)
      {
        bool1 = false;
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    paramFromServiceMsg = new ArrayList();
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    if (bool1)
    {
      m = ((oidb_0x935.RspBody)localObject).is_end.get();
      int n = ((oidb_0x935.RspBody)localObject).cur_pos.get();
      paramFromServiceMsg = ((oidb_0x935.RspBody)localObject).recommend_info.get();
      paramObject = new ArrayList();
      localObject = paramFromServiceMsg.iterator();
      for (;;)
      {
        bool2 = bool1;
        k = m;
        j = n;
        paramFromServiceMsg = paramObject;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramFromServiceMsg = ((oidb_0x935.RecommendInfo)((Iterator)localObject).next()).msg_groups.get();
        if (paramFromServiceMsg == null) {
          return;
        }
        Iterator localIterator = paramFromServiceMsg.iterator();
        while (localIterator.hasNext())
        {
          oidb_0x935.RgroupInfo localRgroupInfo = (oidb_0x935.RgroupInfo)localIterator.next();
          if (localRgroupInfo.uint64_group_code.has())
          {
            NotificationRecommendTroopItem localNotificationRecommendTroopItem = new NotificationRecommendTroopItem();
            localNotificationRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
            if (localRgroupInfo.bytes_group_name.has()) {
              localNotificationRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
            }
            if (localRgroupInfo.bytes_group_memo.has()) {
              localNotificationRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
            }
            localNotificationRecommendTroopItem.labelList = TroopRecommendTransUtils.a(localRgroupInfo.rpt_group_label.get());
            localNotificationRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
            localNotificationRecommendTroopItem.x935RgroupInfo = localRgroupInfo.toByteArray();
            if (localRgroupInfo.bytes_algorithm.has()) {
              paramFromServiceMsg = localRgroupInfo.bytes_algorithm.get().toStringUtf8();
            } else {
              paramFromServiceMsg = "";
            }
            localNotificationRecommendTroopItem.recomAlgol = paramFromServiceMsg;
            if (localRgroupInfo.bytes_join_group_auth.has()) {
              paramFromServiceMsg = localRgroupInfo.bytes_join_group_auth.get().toStringUtf8();
            } else {
              paramFromServiceMsg = "";
            }
            localNotificationRecommendTroopItem.authSig = paramFromServiceMsg;
            if (localRgroupInfo.uint32_activity.has()) {
              j = localRgroupInfo.uint32_activity.get();
            } else {
              j = 0;
            }
            localNotificationRecommendTroopItem.activity = j;
            if (localRgroupInfo.int32_uin_privilege.has()) {
              j = localRgroupInfo.int32_uin_privilege.get();
            } else {
              j = -1;
            }
            localNotificationRecommendTroopItem.privilege = j;
            paramObject.add(localNotificationRecommendTroopItem);
          }
        }
      }
    }
    boolean bool2 = false;
    int k = -1;
    int j = -1;
    int m = paramToServiceMsg.extraData.getInt("add_contact_find_troop_item_type", -1);
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("key_load_more", false);
    paramToServiceMsg = paramToServiceMsg.extraData.getString("add_contact_find_troop_item_key_word", "");
    notifyUI(TroopRecommendObserver.b, bool2, new Object[] { Integer.valueOf(m), paramToServiceMsg, Integer.valueOf(j), Integer.valueOf(k), paramFromServiceMsg, Boolean.valueOf(bool1) });
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle_oidb_0x935_10_response, isSuc=");
      paramToServiceMsg.append(bool2);
      paramToServiceMsg.append(",oidbesult=");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",troopUin = ");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(",isEnd = ");
      paramToServiceMsg.append(k);
      paramToServiceMsg.append(",dataList.size() = ");
      paramToServiceMsg.append(paramFromServiceMsg.size());
      QLog.i("ac_ft.TroopRecommendHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = new oidb_0x935.RspBody();
    int i;
    if (bool1)
    {
      j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      i = j;
      if (j != 0)
      {
        bool1 = false;
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    paramObject = new ArrayList();
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    if (bool1)
    {
      m = ((oidb_0x935.RspBody)localObject).is_end.get();
      int n = ((oidb_0x935.RspBody)localObject).cur_pos.get();
      localObject = ((oidb_0x935.RspBody)localObject).recommend_info.get().iterator();
      for (;;)
      {
        bool2 = bool1;
        k = m;
        j = n;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramFromServiceMsg = ((oidb_0x935.RecommendInfo)((Iterator)localObject).next()).msg_groups.get();
        if (paramFromServiceMsg == null) {
          return;
        }
        Iterator localIterator = paramFromServiceMsg.iterator();
        while (localIterator.hasNext())
        {
          oidb_0x935.RgroupInfo localRgroupInfo = (oidb_0x935.RgroupInfo)localIterator.next();
          if (localRgroupInfo.uint64_group_code.has())
          {
            NotificationRecommendTroopItem localNotificationRecommendTroopItem = new NotificationRecommendTroopItem();
            localNotificationRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
            if (localRgroupInfo.bytes_group_name.has()) {
              localNotificationRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
            }
            if (localRgroupInfo.bytes_group_memo.has()) {
              localNotificationRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
            }
            localNotificationRecommendTroopItem.labelList = TroopRecommendTransUtils.a(localRgroupInfo.rpt_group_label.get());
            localNotificationRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
            localNotificationRecommendTroopItem.x935RgroupInfo = localRgroupInfo.toByteArray();
            if (localRgroupInfo.bytes_algorithm.has()) {
              paramFromServiceMsg = localRgroupInfo.bytes_algorithm.get().toStringUtf8();
            } else {
              paramFromServiceMsg = "";
            }
            localNotificationRecommendTroopItem.recomAlgol = paramFromServiceMsg;
            if (localRgroupInfo.bytes_join_group_auth.has()) {
              paramFromServiceMsg = localRgroupInfo.bytes_join_group_auth.get().toStringUtf8();
            } else {
              paramFromServiceMsg = "";
            }
            localNotificationRecommendTroopItem.authSig = paramFromServiceMsg;
            if (localRgroupInfo.uint32_activity.has()) {
              j = localRgroupInfo.uint32_activity.get();
            } else {
              j = 0;
            }
            localNotificationRecommendTroopItem.activity = j;
            if (localRgroupInfo.int32_uin_privilege.has()) {
              j = localRgroupInfo.int32_uin_privilege.get();
            } else {
              j = -1;
            }
            localNotificationRecommendTroopItem.privilege = j;
            paramObject.add(localNotificationRecommendTroopItem);
          }
        }
      }
    }
    boolean bool2 = false;
    int k = -1;
    int j = -1;
    int m = paramToServiceMsg.extraData.getInt("add_contact_find_troop_item_type", -1);
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("key_load_more", false);
    paramToServiceMsg = paramToServiceMsg.extraData.getString("add_contact_find_troop_item_key_word", "");
    notifyUI(TroopRecommendObserver.b, bool2, new Object[] { Integer.valueOf(m), paramToServiceMsg, Integer.valueOf(j), Integer.valueOf(k), paramObject, Boolean.valueOf(bool1) });
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle_oidb_0x935_23_response, isSuc=");
      paramToServiceMsg.append(bool2);
      paramToServiceMsg.append(",oidbesult=");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",troopUin = ");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(",isEnd = ");
      paramToServiceMsg.append(k);
      paramToServiceMsg.append(",dataList.size() = ");
      paramToServiceMsg.append(paramObject.size());
      QLog.i("ac_ft.TroopRecommendHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = new oidb_0x935.RspBody();
    int i;
    if (bool1)
    {
      j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      i = j;
      if (j != 0)
      {
        bool1 = false;
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    paramFromServiceMsg = new ArrayList();
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    if (bool1)
    {
      m = ((oidb_0x935.RspBody)localObject).is_end.get();
      int n = ((oidb_0x935.RspBody)localObject).cur_pos.get();
      paramFromServiceMsg = ((oidb_0x935.RspBody)localObject).recommend_info.get();
      paramObject = new ArrayList();
      Iterator localIterator1 = paramFromServiceMsg.iterator();
      for (;;)
      {
        bool2 = bool1;
        k = m;
        j = n;
        paramFromServiceMsg = paramObject;
        if (!localIterator1.hasNext()) {
          break;
        }
        paramFromServiceMsg = ((oidb_0x935.RecommendInfo)localIterator1.next()).msg_groups.get();
        if (paramFromServiceMsg == null) {
          return;
        }
        Iterator localIterator2 = paramFromServiceMsg.iterator();
        while (localIterator2.hasNext())
        {
          oidb_0x935.RgroupInfo localRgroupInfo = (oidb_0x935.RgroupInfo)localIterator2.next();
          if (localRgroupInfo.uint64_group_code.has())
          {
            NotificationRecommendTroopItem localNotificationRecommendTroopItem = new NotificationRecommendTroopItem();
            localNotificationRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
            if (localRgroupInfo.bytes_group_name.has()) {
              localNotificationRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
            }
            if (localRgroupInfo.bytes_group_memo.has()) {
              localNotificationRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
            }
            localNotificationRecommendTroopItem.labelList = TroopRecommendTransUtils.a(localRgroupInfo.rpt_group_label.get());
            localNotificationRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
            localNotificationRecommendTroopItem.x935RgroupInfo = localRgroupInfo.toByteArray();
            bool2 = localRgroupInfo.bytes_algorithm.has();
            localObject = "";
            if (bool2) {
              paramFromServiceMsg = localRgroupInfo.bytes_algorithm.get().toStringUtf8();
            } else {
              paramFromServiceMsg = "";
            }
            localNotificationRecommendTroopItem.recomAlgol = paramFromServiceMsg;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            if (localRgroupInfo.bytes_join_group_auth.has()) {
              paramFromServiceMsg = localRgroupInfo.bytes_join_group_auth.get().toStringUtf8();
            }
            localNotificationRecommendTroopItem.authSig = paramFromServiceMsg;
            if (localRgroupInfo.uint32_activity.has()) {
              j = localRgroupInfo.uint32_activity.get();
            } else {
              j = 0;
            }
            localNotificationRecommendTroopItem.activity = j;
            if (localRgroupInfo.int32_uin_privilege.has()) {
              j = localRgroupInfo.int32_uin_privilege.get();
            } else {
              j = -1;
            }
            localNotificationRecommendTroopItem.privilege = j;
            paramObject.add(localNotificationRecommendTroopItem);
          }
        }
      }
    }
    boolean bool2 = false;
    int k = -1;
    int j = -1;
    int m = paramToServiceMsg.extraData.getInt("add_contact_find_troop_item_type", -1);
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("key_load_more", false);
    notifyUI(TroopRecommendObserver.a, bool2, new Object[] { Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k), paramFromServiceMsg, Boolean.valueOf(bool1) });
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle_oidb_0x935_20_response, isSuc=");
      paramToServiceMsg.append(bool2);
      paramToServiceMsg.append(",oidbesult=");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",troopUin = ");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(",isEnd = ");
      paramToServiceMsg.append(k);
      paramToServiceMsg.append(",dataList.size() = ");
      paramToServiceMsg.append(paramFromServiceMsg.size());
      QLog.i("ac_ft.TroopRecommendHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = (String)paramToServiceMsg.getAttribute("troopUin", "");
      int i = ((Integer)paramToServiceMsg.getAttribute("type", Integer.valueOf(0))).intValue();
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleSendReportForTroopRecommendGrayTips troopuin:");
        paramToServiceMsg.append(str);
        paramToServiceMsg.append(" type:");
        paramToServiceMsg.append(i);
        QLog.i("TroopRecommendHandler", 2, paramToServiceMsg.toString());
      }
      paramToServiceMsg = new oidb_0xe3a.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if ((j == 0) && (i == 1))
      {
        long l = paramToServiceMsg.uint64_next_time_for_aio_report.get();
        if (l > 0L) {
          TroopRecommendUtils.b(this.appRuntime, str, l);
        }
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleSendReportForTroopRecommendGrayTips result:");
        paramToServiceMsg.append(j);
        QLog.i("TroopRecommendHandler", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = (String)paramToServiceMsg.getAttribute("troopUin", "");
      boolean bool = false;
      int j = ((Integer)paramToServiceMsg.getAttribute("type", Integer.valueOf(0))).intValue();
      long l = ((Long)paramToServiceMsg.getAttribute("groupClass", Long.valueOf(0L))).longValue();
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleTroopRecommendGrayTipsData troopuin:");
        paramToServiceMsg.append(str);
        paramToServiceMsg.append(" type:");
        paramToServiceMsg.append(j);
        QLog.i("TroopRecommendHandler", 2, paramToServiceMsg.toString());
      }
      oidb_0xe3b.RspBody localRspBody = new oidb_0xe3b.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      paramObject = null;
      paramFromServiceMsg = null;
      if (i == 0)
      {
        if (j == 1)
        {
          if (localRspBody.bytes_graybar_title.has()) {
            paramToServiceMsg = localRspBody.bytes_graybar_title.get().toStringUtf8();
          } else {
            paramToServiceMsg = null;
          }
          j = localRspBody.uint32_graybar_type.get();
          if (localRspBody.rpt_msg_highlight_title.has()) {
            paramFromServiceMsg = localRspBody.rpt_msg_highlight_title.get();
          }
          int k = localRspBody.uint32_sub_id.get();
          TroopRecommendUtils.a(this.appRuntime, str, paramToServiceMsg, j, paramFromServiceMsg, k, l);
          if (localRspBody.bytes_cookie_for_req_type_1.has()) {
            paramToServiceMsg = localRspBody.bytes_cookie_for_req_type_1.get().toByteArray();
          } else {
            paramToServiceMsg = new byte[0];
          }
          TroopRecommendUtils.a(this.appRuntime, str, paramToServiceMsg);
        }
        else if (j == 2)
        {
          if (localRspBody.rpt_msg_person.has()) {
            paramFromServiceMsg = localRspBody.rpt_msg_person.get();
          } else {
            paramFromServiceMsg = null;
          }
          if (localRspBody.bytes_cookie_for_req_type_2.has()) {
            paramToServiceMsg = localRspBody.bytes_cookie_for_req_type_2.get().toByteArray();
          } else {
            paramToServiceMsg = null;
          }
          if (paramFromServiceMsg != null)
          {
            ArrayList localArrayList = new ArrayList(paramFromServiceMsg.size());
            Iterator localIterator = paramFromServiceMsg.iterator();
            for (;;)
            {
              paramFromServiceMsg = localArrayList;
              if (!localIterator.hasNext()) {
                break;
              }
              localArrayList.add(RecommendMember.a((oidb_0xe3b.RecommendPerson)localIterator.next()));
            }
          }
          paramFromServiceMsg = null;
          if (localRspBody.bytes_wording_for_empty_data.has()) {
            paramObject = localRspBody.bytes_wording_for_empty_data.get().toStringUtf8();
          }
          j = TroopRecommendObserver.d;
          if (paramToServiceMsg == null) {
            bool = true;
          }
          notifyUI(j, true, new Object[] { str, paramFromServiceMsg, paramToServiceMsg, Boolean.valueOf(bool), paramObject });
        }
      }
      else if (j == 2) {
        notifyUI(TroopRecommendObserver.d, false, new Object[] { str, null, null, Boolean.valueOf(true), null });
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleTroopRecommendGrayTipsData result:");
        paramToServiceMsg.append(i);
        QLog.i("TroopRecommendHandler", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0x935_9");
      this.a.add("OidbSvc.0x935_10");
      this.a.add("OidbSvc.0x935_20");
      this.a.add("OidbSvc.0x935_23");
      this.a.add("oidbSvc.0xe3a");
      this.a.add("oidbSvc.0xe3b");
      this.a.add("OidbSvc.0xded_1");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopRecommendObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopRecommendHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopRecommendHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x935_9".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x935_10".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x935_23".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x935_20".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("oidbSvc.0xe3a".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("oidbSvc.0xe3b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xded_1".equals(paramFromServiceMsg.getServiceCmd())) {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopRecommendHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.handler.TroopRecommendHandler
 * JD-Core Version:    0.7.0.1
 */