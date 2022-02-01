package com.tencent.mobileqq.relationx.batchAdd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopAddFrd.Scene;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import tencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;
import tencent.im.oidb.cmd0x777.cmd0x777.ReqBody;
import tencent.im.oidb.cmd0x777.cmd0x777.RspBody;

public class BatchAddFriendData
{
  private final ArrayList<Long> a = new ArrayList();
  private final ArrayList<cmd0x777.AddFrdInfo> b = new ArrayList();
  private final long[] c = new long[30];
  private String d = null;
  private String e;
  private int f = 0;
  private String g = null;
  private int h = 0;
  private int i = 0;
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramContext != null) && (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BatchAddFriendData", 2, String.format("onBAFTipClick troopUin_type_recUin %s_%d_%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3 }));
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("param_from", 30);
        localIntent.putExtra("group_uin", paramString1);
        localIntent.putExtra("param_groupcode", paramString2);
        localIntent.putExtra("param_from", 30);
        localIntent.putExtra("param_subtype", 4);
        localIntent.putExtra("param_entrance", 30);
        localIntent.putExtra("param_max", 30);
        localIntent.putExtra("param_exit_animation", 3);
        localIntent.putExtra("batch_addfrd_scene_type", paramInt);
        if (!TextUtils.isEmpty(paramString3)) {
          localIntent.putExtra("batch_addfrd_recommand_uin", paramString3);
        }
        ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(paramContext, localIntent);
        ((Activity)paramContext).overridePendingTransition(2130772014, 0);
      }
      ThreadManager.post(new BatchAddFriendData.1(paramInt, paramQQAppInterface, paramString1), 8, null, true);
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "onBAFTipClick troopUin: %s", new Object[] { paramString1 }));
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, List<cmd0x777.AddFrdInfo> paramList)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "showResult not in ui thread !");
      }
      return;
    }
    if ((paramActivity != null) && (paramList != null) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = paramList.iterator();
      int i1 = 0;
      int n = 0;
      int k = 0;
      int m = 0;
      int j = 0;
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cmd0x777.AddFrdInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_flag.get() == 1)
          {
            if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_result.get() == 0) {
              i1 += 1;
            } else {
              n += 1;
            }
          }
          else if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_flag.get() == 2)
          {
            int i2 = k + 1;
            if (((cmd0x777.AddFrdInfo)localObject2).uint32_allow_type.get() == 1)
            {
              j += 1;
              k = i2;
            }
            else
            {
              k = i2;
              if (((cmd0x777.AddFrdInfo)localObject2).uint32_allow_type.get() == 2)
              {
                localArrayList.add(localObject2);
                k = i2;
              }
            }
          }
          else
          {
            m += 1;
          }
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "showResult total: %s, sendOk: %s, sendFail: %s, notSend: %s, clientFail: %s, refuseAdd: %s, answerQuestion: %s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(localArrayList.size()) }));
      }
      if (i1 > 0) {
        QQToast.makeText(BaseApplication.getContext(), 0, HardCodeUtil.a(2131899293), 0).show();
      } else if ((n > 0) || (m > 0)) {
        QQToast.makeText(BaseApplication.getContext(), 0, HardCodeUtil.a(2131899296), 0).show();
      }
      if (localArrayList.size() > 0)
      {
        Iterator localIterator = localArrayList.iterator();
        Object localObject3 = null;
        localObject1 = null;
        localObject2 = localObject1;
        while (localIterator.hasNext())
        {
          paramList = (cmd0x777.AddFrdInfo)localIterator.next();
          if ((localObject1 != null) && (paramList.uint32_send_req_result.get() <= ((cmd0x777.AddFrdInfo)localObject1).uint32_send_req_result.get()))
          {
            if ((localObject2 == null) || (paramList.uint32_send_req_result.get() > ((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_result.get())) {
              localObject2 = paramList;
            }
          }
          else
          {
            localObject2 = localObject1;
            localObject1 = paramList;
          }
        }
        if ((localArrayList.size() == 1) && (localObject1 != null))
        {
          paramList = ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get();
        }
        else if ((localArrayList.size() == 2) && (localObject1 != null) && (localObject2 != null))
        {
          paramList = String.format(Locale.getDefault(), "%s、%s", new Object[] { ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get(), ((cmd0x777.AddFrdInfo)localObject2).bytes_remark.get() });
        }
        else
        {
          paramList = localObject3;
          if (localObject1 != null)
          {
            paramList = localObject3;
            if (localObject2 != null) {
              paramList = String.format(Locale.getDefault(), "%s、%s等%s位好友", new Object[] { ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get(), ((cmd0x777.AddFrdInfo)localObject2).bytes_remark.get(), Integer.valueOf(localArrayList.size()) });
            }
          }
        }
        paramList = DialogUtil.a(paramActivity, String.format(Locale.getDefault(), HardCodeUtil.a(2131899300), new Object[] { paramList }), 0, 0, null, null);
        paramList.setPositiveButton(2131892267, new BatchAddFriendData.2());
        if ((paramActivity != null) && (!paramActivity.isFinishing())) {
          paramList.show();
        }
        ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", "notAdd_exp", 0, 0, paramString, String.valueOf(k), "", "");
      }
      return;
    }
    if (QLog.isDevelopLevel())
    {
      if (paramActivity == null) {
        paramQQAppInterface = "showResult context is null !";
      } else {
        paramQQAppInterface = "showResult list is null or size is zero !";
      }
      QLog.d("BatchAddFriendData", 4, paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      Object localObject2 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      TroopInfo localTroopInfo = ((TroopManager)localObject2).f(paramString1);
      if (localTroopInfo == null) {
        return;
      }
      Scene.a(paramQQAppInterface, true, localTroopInfo);
      Object localObject1 = paramQQAppInterface.getMessageFacade().o(paramString1, 1);
      long l1;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        l1 = ((ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq;
      } else {
        l1 = Math.abs(new Random().nextInt());
      }
      long l2 = MessageCache.c();
      if (!TextUtils.isEmpty(paramString3))
      {
        localObject1 = String.format(Locale.getDefault(), HardCodeUtil.a(2131899294), new Object[] { paramString3, Integer.valueOf(paramInt2) });
        if (paramInt2 == 1) {
          localObject1 = String.format(Locale.getDefault(), HardCodeUtil.a(2131899297), new Object[] { paramString3 });
        }
        paramInt2 = 1;
        paramString3 = (String)localObject1;
      }
      else
      {
        localObject1 = String.format(Locale.getDefault(), HardCodeUtil.a(2131899299), new Object[] { Integer.valueOf(paramInt2) });
        paramString3 = (String)localObject1;
        if (paramInt2 == 1)
        {
          paramString3 = (String)localObject1;
          if (!TextUtils.isEmpty(paramString2)) {
            paramString3 = String.format(Locale.getDefault(), HardCodeUtil.a(2131899295), new Object[] { paramString2 });
          }
        }
        paramInt2 = 0;
      }
      if (paramInt1 == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString3);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899301));
        paramString3 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString3);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899292));
        paramString3 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = HardCodeUtil.a(2131899298);
      int j = paramString3.indexOf((String)localObject1);
      int k = ((String)localObject1).length();
      localObject1 = new UniteGrayTipParam(paramString1, paramString1, paramString3, 1, -5020, 135178, l2);
      ((UniteGrayTipParam)localObject1).g = paramString3;
      paramString3 = new Bundle();
      paramString3.putInt("key_action", 24);
      paramString3.putString("key_action_DATA", paramString1);
      paramString3.putString("key_a_action_DATA", localTroopInfo.troopcode);
      ((UniteGrayTipParam)localObject1).a(j, j + k, paramString3);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("newJoin-");
      if (paramInt2 != 0) {
        paramString3 = paramString2;
      } else {
        paramString3 = "";
      }
      ((StringBuilder)localObject3).append(paramString3);
      ((UniteGrayTipParam)localObject1).p = ((StringBuilder)localObject3).toString();
      localObject3 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
      ((MessageForUniteGrayTip)localObject3).isread = true;
      ((MessageForUniteGrayTip)localObject3).shmsgseq = l1;
      ((MessageForUniteGrayTip)localObject3).mNeedTimeStamp = true;
      ((MessageForUniteGrayTip)localObject3).updateUniteGrayTipMsgData(paramQQAppInterface);
      paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject3, paramQQAppInterface.getCurrentAccountUin());
      localTroopInfo.dwLastInsertBAFTipTime = NetConnInfoCenter.getServerTime();
      localTroopInfo.wInsertBAFTipCount += 1;
      localTroopInfo.dwLastBAFTipMsgUniSeq = ((MessageForUniteGrayTip)localObject3).uniseq;
      ((TroopManager)localObject2).b(localTroopInfo);
      if (paramInt1 > 0) {
        paramString3 = "0";
      } else {
        paramString3 = "1";
      }
      localObject2 = Scene.b(true, 1);
      if (localTroopInfo.wInsertBAFTipCount == 1) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", (String)localObject2, 0, 0, paramString1, (String)localObject1, "", paramString3);
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, String.format("doAddBAFGrayTip time: %s count: %s uniseq: %s, msgSeq: %s, shmsgseq: %s, recmmendUin=%s", new Object[] { Long.valueOf(localTroopInfo.dwLastInsertBAFTipTime), Integer.valueOf(localTroopInfo.wInsertBAFTipCount), Long.valueOf(localTroopInfo.dwLastBAFTipMsgUniSeq), Long.valueOf(l1), Long.valueOf(((MessageForUniteGrayTip)localObject3).shmsgseq), paramString2 }));
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("BatchAddFriendData", 4, "doAddBAFGrayTip invalidate params!");
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong2 * 1000L);
    int j = localCalendar.get(6);
    boolean bool = true;
    int k = localCalendar.get(1);
    localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong1 * 1000L);
    int m = localCalendar.get(6);
    int n = localCalendar.get(1);
    if ((k != n) || (j <= m))
    {
      if (k > n) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void b(FriendListHandler paramFriendListHandler)
  {
    if (paramFriendListHandler == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "sendResult friendListHandler is null ");
      }
      return;
    }
    TroopManager localTroopManager = (TroopManager)paramFriendListHandler.app.getManager(QQManagerFactory.TROOP_MANAGER);
    FriendsManager localFriendsManager = (FriendsManager)paramFriendListHandler.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ArrayList localArrayList = (ArrayList)this.b.clone();
    int j = 0;
    boolean bool = false;
    while (j < localArrayList.size())
    {
      cmd0x777.AddFrdInfo localAddFrdInfo = (cmd0x777.AddFrdInfo)localArrayList.get(j);
      if (localAddFrdInfo != null)
      {
        if (localAddFrdInfo.uint32_send_req_flag.get() == 2)
        {
          TroopMemberInfo localTroopMemberInfo = localTroopManager.h(this.d, String.valueOf(localAddFrdInfo.uint64_uin.get()));
          if (localTroopMemberInfo != null)
          {
            if (!TextUtils.isEmpty(localTroopMemberInfo.troopremark)) {
              localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.troopremark);
            } else if (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)) {
              localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.troopnick);
            } else if (!TextUtils.isEmpty(localTroopMemberInfo.friendnick)) {
              localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.friendnick);
            }
            PBUInt32Field localPBUInt32Field = localAddFrdInfo.uint32_send_req_result;
            int k;
            if (localTroopMemberInfo.commonFrdCnt == -2147483648) {
              k = 0;
            } else {
              k = localTroopMemberInfo.commonFrdCnt;
            }
            localPBUInt32Field.set(k);
          }
          else if (QLog.isDevelopLevel())
          {
            QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "sendResult TroopMemberInfo is null [troopUin: %s, memberUin: %s] ", new Object[] { this.d, Long.valueOf(localAddFrdInfo.uint64_uin.get()) }));
          }
        }
        if (localAddFrdInfo.uint32_send_req_flag.get() != -2147483648) {
          bool = true;
        }
        if (localAddFrdInfo.uint32_send_req_flag.get() == 1)
        {
          if (localAddFrdInfo.uint32_send_req_result.get() != 0) {
            localFriendsManager.c(Long.toString(localAddFrdInfo.uint64_uin.get()), false);
          }
        }
        else {
          localFriendsManager.c(Long.toString(localAddFrdInfo.uint64_uin.get()), false);
        }
      }
      j += 1;
    }
    this.b.clear();
    paramFriendListHandler.notifyUI(109, bool, new Object[] { this.d, localArrayList });
    if (QLog.isDevelopLevel()) {
      QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "sendResult isSuc: %s, troop: %s, size: %s", new Object[] { Boolean.valueOf(bool), this.d, Integer.valueOf(localArrayList.size()) }));
    }
  }
  
  public void a(FriendListHandler paramFriendListHandler)
  {
    if (paramFriendListHandler == null) {}
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "doSendBatchAddFriendForTroopMember friendListHandler is null ");
      }
      return;
    }
    finally
    {
      Object localObject;
      int j;
      long l1;
      cmd0x777.ReqBody localReqBody;
      break label313;
    }
    localObject = (FriendsManager)paramFriendListHandler.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    this.f = Math.min(this.a.size(), this.c.length);
    j = this.f;
    if (j > 0)
    {
      l1 = 0L;
      try
      {
        long l2 = Long.parseLong(this.e);
        l1 = l2;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      localReqBody = new cmd0x777.ReqBody();
      localReqBody.uint64_group_uin.set(l1);
      localReqBody.bytes_msg.set(this.g);
      localReqBody.uint32_source_id.set(this.h);
      localReqBody.uint32_sub_source_id.set(this.i);
      j = this.f - 1;
      while (j >= 0)
      {
        l1 = ((Long)this.a.remove(j)).longValue();
        this.c[j] = l1;
        localReqBody.rpt_uint64_uin.add(Long.valueOf(l1));
        ((FriendsManager)localObject).c(Long.toString(l1), true);
        j -= 1;
      }
      localObject = paramFriendListHandler.makeOIDBPkg("OidbSvc.0x777", 1911, 1, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).extraData.putLongArray("send_uin_array", this.c);
      paramFriendListHandler.sendPbReq((ToServiceMsg)localObject);
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "doSendBatchAddFriendForTroopMember sending: %s pending: %s", new Object[] { Integer.valueOf(this.f), Integer.valueOf(this.a.size()) }));
      }
    }
    else
    {
      b(paramFriendListHandler);
    }
    return;
    label313:
    for (;;)
    {
      throw paramFriendListHandler;
    }
  }
  
  public void a(FriendListHandler paramFriendListHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFriendListHandler == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "handleAddBatchTroopMembers friendListHandler is null ");
      }
      return;
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getLongArray("send_uin_array");
    int j = this.f;
    int k = 0;
    if (j <= 0) {}
    while ((paramToServiceMsg == null) || (paramToServiceMsg.length < j))
    {
      j = 0;
      break;
    }
    j = 0;
    for (;;)
    {
      if (j >= this.f) {
        break label104;
      }
      if (paramToServiceMsg[j] != this.c[j]) {
        break;
      }
      j += 1;
    }
    label104:
    j = 1;
    if (j == 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "handleAddBatchTroopMembers is not cur sending resp!");
      }
      return;
    }
    int m = this.f;
    paramToServiceMsg = new cmd0x777.RspBody();
    int n = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (n == 0)
    {
      paramToServiceMsg = paramToServiceMsg.rpt_add_frd_info.get();
    }
    else
    {
      paramFromServiceMsg = new ArrayList();
      j = 0;
      for (;;)
      {
        paramToServiceMsg = paramFromServiceMsg;
        if (j >= m) {
          break;
        }
        paramToServiceMsg = new cmd0x777.AddFrdInfo();
        paramToServiceMsg.uint64_uin.set(this.c[j]);
        paramToServiceMsg.uint32_send_req_flag.set(-2147483648);
        paramFromServiceMsg.add(paramToServiceMsg);
        j += 1;
      }
    }
    this.f = 0;
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
      this.b.addAll(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel())
    {
      paramFromServiceMsg = Locale.getDefault();
      if (paramToServiceMsg == null) {
        j = k;
      } else {
        j = paramToServiceMsg.size();
      }
      QLog.d("BatchAddFriendData", 4, String.format(paramFromServiceMsg, "handleAddBatchTroopMembers result: %s sending: %s, cur:%s  total: %s pending: %s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(this.b.size()), Integer.valueOf(this.a.size()) }));
    }
    if (this.a.size() > 0)
    {
      a(paramFriendListHandler);
      return;
    }
    b(paramFriendListHandler);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, List<String> paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramBoolean)
      {
        this.a.clear();
        this.b.clear();
        this.f = 0;
      }
      int j;
      if ((this.a.size() <= 0) && (this.b.size() <= 0) && (this.f <= 0)) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "init isSending pending: %s result: %s curSending: ", new Object[] { Integer.valueOf(this.a.size()), Integer.valueOf(this.b.size()), Integer.valueOf(this.f) }));
        }
        return false;
      }
      this.d = paramString1;
      this.e = paramString2;
      this.g = paramString3;
      this.h = paramInt1;
      this.i = paramInt2;
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        if ((paramString2 != null) && (!paramString2.isEmpty())) {
          try
          {
            long l = Long.parseLong(paramString2);
            this.a.add(Long.valueOf(l));
          }
          catch (Throwable paramString2)
          {
            paramString2.printStackTrace();
          }
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "init pending: %s, troopuin: %s, troopcode: %s, sourceId: %s, subSourceId: %s, msg: %s", new Object[] { Integer.valueOf(this.a.size()), this.d, this.e, Integer.valueOf(this.h), Integer.valueOf(this.i), this.g }));
      }
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("BatchAddFriendData", 4, "init uinList is null or empty!");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendData
 * JD-Core Version:    0.7.0.1
 */