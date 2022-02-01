package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherControlManager.CacheHolder;
import com.tencent.mobileqq.together.TogetherParser;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.aio.media.aio_media.ResultInfo;
import tencent.aio.media.aio_media.RspLatestPlayingState;
import tencent.aio.media.aio_media.TypeVideo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.VideoChangePushInfo;

public class WatchTogetherParser
  implements TogetherParser
{
  private QQAppInterface a;
  
  public WatchTogetherParser(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt, long paramLong2, long paramLong3, boolean paramBoolean, long paramLong4)
  {
    if ((paramInt == 3) && (paramLong4 > 0L) && (paramLong1 > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherParser", 2, new Object[] { "insertGrayTipsWhenOthersJoin  uin:", Long.valueOf(paramLong1), " isJoin=", Boolean.valueOf(paramBoolean), " operUin=", Long.valueOf(paramLong4) });
      }
      if (paramLong4 == paramQQAppInterface.getLongAccountUin())
      {
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherParser", 2, new Object[] { "insertGrayTipsWhenOthersJoin is curAccountUin:", Long.valueOf(paramLong1) });
        }
        return;
      }
      String str1 = ContactUtils.b(paramQQAppInterface, String.valueOf(paramLong1), String.valueOf(paramLong4));
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      str1 = String.format(paramQQAppInterface.getApp().getString(2131897473), new Object[] { str1 });
      if (paramBoolean)
      {
        a(paramQQAppInterface, paramLong1, 1, str1, paramInt, paramLong2, paramLong3, 131092);
        return;
      }
      String str2 = paramQQAppInterface.getApp().getString(2131897472);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      a(paramQQAppInterface, paramLong1, 1, localStringBuilder.toString(), paramInt, paramLong2, paramLong3, 131092, str1.length(), str2.length());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WatchTogetherParser", 2, new Object[] { "insertGrayTipsWhenOthersJoin  uin:", Long.valueOf(paramLong1), " actionType=", Integer.valueOf(paramInt), " operUin=", Long.valueOf(paramLong4) });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, int paramInt2, long paramLong2, long paramLong3, int paramInt3)
  {
    a(paramQQAppInterface, paramLong1, paramInt1, paramString, paramInt2, paramLong2, paramLong3, paramInt3, -1, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, int paramInt2, long paramLong2, long paramLong3, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("insertGrayTips begin uin:");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" uinType:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" grayTips:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" sub_type:");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(" msgSeq:");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(" msgTime:");
      ((StringBuilder)localObject1).append(paramLong3);
      ((StringBuilder)localObject1).append(" grayId=");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.i("WatchTogetherParser", 2, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong1 <= 0L) {
        return;
      }
      int i;
      if ((paramInt2 != 2) && (paramInt2 != 5) && (paramInt2 != 3)) {
        i = -5020;
      } else {
        i = -5040;
      }
      localObject1 = String.valueOf(paramLong1);
      paramString = new UniteGrayTipParam((String)localObject1, (String)localObject1, paramString, paramInt1, i, paramInt3, MessageCache.c());
      if ((paramInt4 >= 0) && (paramInt5 > 0))
      {
        localObject1 = new Bundle();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramLong1);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(paramInt1);
        localObject2 = ((StringBuilder)localObject2).toString();
        ((Bundle)localObject1).putInt("key_action", 60);
        ((Bundle)localObject1).putString("textColor", "");
        ((Bundle)localObject1).putString("image_resource", null);
        ((Bundle)localObject1).putString("key_action_DATA", (String)localObject2);
        paramString.a(paramInt4, paramInt4 + paramInt5, (Bundle)localObject1);
      }
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).hasRead = 0;
      ((MessageForUniteGrayTip)localObject1).subType = paramInt2;
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, paramString);
      paramString = ((MessageForUniteGrayTip)localObject1).tipParam;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("_watch_together_");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramLong3);
      paramString.p = ((StringBuilder)localObject2).toString();
      boolean bool = UniteGrayTipMsgUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject1);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("insertGrayTips end  res:");
        paramQQAppInterface.append(bool);
        paramQQAppInterface.append(" grayTipKey:");
        paramQQAppInterface.append(((MessageForUniteGrayTip)localObject1).tipParam.p);
        QLog.i("WatchTogetherParser", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    TogetherSession localTogetherSession = ((TogetherControlManager)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(2, 1, paramString);
    if ((localTogetherSession instanceof WatchTogetherSession))
    {
      localTogetherSession.p = 3;
      localTogetherSession.q = 3;
      TogetherUtils.a(this.a, paramString, false);
      a(true, (WatchTogetherSession)localTogetherSession, 1007, "");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, Object paramObject)
  {
    if (!(paramObject instanceof TroopTips0x857.VideoChangePushInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherParser", 2, "handleBusinessTogetherGroupPush, object is error");
      }
      return;
    }
    TroopTips0x857.VideoChangePushInfo localVideoChangePushInfo = (TroopTips0x857.VideoChangePushInfo)paramObject;
    if (localVideoChangePushInfo != null)
    {
      long l1;
      if (localVideoChangePushInfo.uint64_seq.has()) {
        l1 = localVideoChangePushInfo.uint64_seq.get();
      } else {
        l1 = -1L;
      }
      boolean bool = localVideoChangePushInfo.uint32_action_type.has();
      int j = -1;
      int i;
      if (bool) {
        i = localVideoChangePushInfo.uint32_action_type.get();
      } else {
        i = -1;
      }
      long l2;
      if (localVideoChangePushInfo.uint64_group_id.has()) {
        l2 = localVideoChangePushInfo.uint64_group_id.get();
      } else {
        l2 = -1L;
      }
      long l3;
      if (localVideoChangePushInfo.uint64_oper_uin.has()) {
        l3 = localVideoChangePushInfo.uint64_oper_uin.get();
      } else {
        l3 = -1L;
      }
      if (localVideoChangePushInfo.uint32_join_nums.has()) {
        j = localVideoChangePushInfo.uint32_join_nums.get();
      }
      if ((localVideoChangePushInfo.uint32_join_state.has()) && (localVideoChangePushInfo.uint32_join_state.get() == 1)) {
        bool = true;
      } else {
        bool = false;
      }
      if (localVideoChangePushInfo.bytes_gray_tips.has()) {
        paramObject = localVideoChangePushInfo.bytes_gray_tips.get().toStringUtf8();
      } else {
        paramObject = null;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleWatchTogetherGroupPush, seq=");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", actionType=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", groupid=");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(", uin=");
        ((StringBuilder)localObject).append(l3);
        ((StringBuilder)localObject).append(", joinNum=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", tips=");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("WatchTogetherParser", 2, new Object[] { ((StringBuilder)localObject).toString(), " hasJoin=", Boolean.valueOf(bool) });
      }
      long l4 = ((TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(2, 1, l2);
      if (l1 < l4)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("handleWatchTogetherGroupPush, skip pushinfo, old seq=");
          paramQQAppInterface.append(l4);
          QLog.d("WatchTogetherParser", 2, paramQQAppInterface.toString());
        }
        return;
      }
      WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)TogetherUtils.a(2, 1, String.valueOf(l2));
      if (i == 1)
      {
        if (l3 == -1L) {
          localObject = "";
        } else {
          localObject = String.valueOf(l3);
        }
        localWatchTogetherSession.r = ((String)localObject);
      }
      if ((i == 1) || (i == 3) || (i == 4)) {
        localWatchTogetherSession.o = j;
      }
      a(paramQQAppInterface, localWatchTogetherSession, i, l3, paramObject, l1, paramLong1, localVideoChangePushInfo);
      if (((i == 5) || (i == 2)) && (!TextUtils.isEmpty(paramObject)) && (l2 != -1L))
      {
        if (i == 5) {
          j = 131085;
        } else {
          j = 131084;
        }
        a(paramQQAppInterface, l2, 1, paramObject, i, paramLong1, paramLong2, j);
      }
      a(paramQQAppInterface, l2, i, paramLong1, paramLong2, bool, l3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WatchTogetherParser", 2, "handleWatchTogetherGroupPush, pushinfo is null.");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, WatchTogetherSession paramWatchTogetherSession, int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3, TroopTips0x857.VideoChangePushInfo paramVideoChangePushInfo)
  {
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    localTogetherControlManager.a(2, 1, paramWatchTogetherSession.n, paramLong2);
    WatchTogetherSession localWatchTogetherSession2 = (WatchTogetherSession)localTogetherControlManager.a(paramWatchTogetherSession.l, paramWatchTogetherSession.m, paramWatchTogetherSession.n);
    WatchTogetherSession localWatchTogetherSession1;
    if (localWatchTogetherSession2 != null)
    {
      if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4)) {
        localWatchTogetherSession2.o = paramWatchTogetherSession.o;
      }
      localWatchTogetherSession1 = localWatchTogetherSession2;
      if (paramInt == 1)
      {
        localWatchTogetherSession1 = localWatchTogetherSession2;
        if (!TextUtils.isEmpty(paramWatchTogetherSession.r))
        {
          localWatchTogetherSession2.r = paramWatchTogetherSession.r;
          localWatchTogetherSession1 = localWatchTogetherSession2;
        }
      }
    }
    else
    {
      localTogetherControlManager.a(paramWatchTogetherSession.l, paramWatchTogetherSession.m, paramWatchTogetherSession.n, paramWatchTogetherSession);
      localWatchTogetherSession1 = paramWatchTogetherSession;
    }
    if (paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramLong1))) {
      if ((paramInt != 3) && (paramInt != 1) && (paramInt != 4) && (paramInt != 5))
      {
        if (paramInt == 2) {
          TogetherUtils.a(paramQQAppInterface, localWatchTogetherSession1.n, false);
        }
      }
      else {
        TogetherUtils.a(paramQQAppInterface, localWatchTogetherSession1.n, true);
      }
    }
    if (!TextUtils.isEmpty(localWatchTogetherSession1.n))
    {
      paramQQAppInterface = localTogetherControlManager.b(2, 1, localWatchTogetherSession1.n, 1003);
      paramQQAppInterface.a.putInt("action_type", paramInt);
      paramQQAppInterface.a.putString("tips", paramString);
      paramQQAppInterface.a.putLong("seq", paramLong2);
      paramQQAppInterface.a.putLong("msgSeq", paramLong3);
      paramQQAppInterface.b = paramVideoChangePushInfo;
      localTogetherControlManager.a(2, 1, localWatchTogetherSession1.n, 1003);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void a(ToServiceMsg paramToServiceMsg, aio_media.RspLatestPlayingState paramRspLatestPlayingState)
  {
    int k = -1;
    int i;
    if (paramToServiceMsg != null) {
      i = paramToServiceMsg.extraData.getInt("KEY_SESSION_TYPE");
    } else {
      i = -1;
    }
    Object localObject1 = "";
    if (paramToServiceMsg != null) {
      localObject2 = paramToServiceMsg.extraData.getString("KEY_SESSION_UIN");
    } else {
      localObject2 = "";
    }
    int j;
    if (paramToServiceMsg != null) {
      j = paramToServiceMsg.extraData.getInt("KEY_REFRESH_SESSION_BY");
    } else {
      j = -1;
    }
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchTogetherParser", 2, "handleGetWatchPlayingState, req == null || resp == null || data == null");
      }
      return;
    }
    if (i == 2) {
      return;
    }
    Object localObject4 = (TogetherControlManager)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool3 = true;
    paramToServiceMsg = (WatchTogetherSession)((TogetherControlManager)localObject4).a(2, 1, (String)localObject2);
    Object localObject3 = paramToServiceMsg;
    if (paramToServiceMsg == null)
    {
      localObject3 = (WatchTogetherSession)TogetherUtils.a(2, 1, (String)localObject2);
      ((TogetherControlManager)localObject4).a(2, 1, (String)localObject2, (TogetherSession)localObject3);
    }
    boolean bool4 = ((WatchTogetherSession)localObject3).g();
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject2 = localObject1;
    if (bool4)
    {
      localObject2 = localObject1;
      try
      {
        localObject4 = (aio_media.ResultInfo)paramRspLatestPlayingState.msg_result.get();
        i = k;
        if (localObject4 != null)
        {
          localObject2 = localObject1;
          i = ((aio_media.ResultInfo)localObject4).uint32_result.get();
        }
        if (i == 0)
        {
          try
          {
            ((WatchTogetherSession)localObject3).p = paramRspLatestPlayingState.enum_aio_state.get();
            ((WatchTogetherSession)localObject3).q = paramRspLatestPlayingState.enum_user_state.get();
            ((WatchTogetherSession)localObject3).r = String.valueOf(paramRspLatestPlayingState.uint64_create_uin.get());
            ((WatchTogetherSession)localObject3).o = paramRspLatestPlayingState.uint32_joined_num.get();
            ((WatchTogetherSession)localObject3).t = ((aio_media.ResultInfo)localObject4).uint64_svr_time.get();
            ((WatchTogetherSession)localObject3).y = ((WatchTogetherSession)localObject3).x;
            ((WatchTogetherSession)localObject3).x = paramRspLatestPlayingState.uint64_aio_identification.get();
            if (((WatchTogetherSession)localObject3).x != ((WatchTogetherSession)localObject3).y) {
              ((WatchTogetherSession)localObject3).z = 0;
            }
            if ((((WatchTogetherSession)localObject3).q == 2) && (((WatchTogetherSession)localObject3).p == 1)) {
              ((WatchTogetherSession)localObject3).z = 1;
            }
            bool1 = bool3;
            paramToServiceMsg = (ToServiceMsg)localObject1;
            if (!paramRspLatestPlayingState.msg_room_info.has()) {
              break label593;
            }
            ((WatchTogetherSession)localObject3).a = paramRspLatestPlayingState.msg_room_info.uint32_type.get();
            ((WatchTogetherSession)localObject3).c = paramRspLatestPlayingState.msg_room_info.uint64_id.get();
            ((WatchTogetherSession)localObject3).d = paramRspLatestPlayingState.msg_room_info.bytes_name.get().toStringUtf8();
            ((WatchTogetherSession)localObject3).b = paramRspLatestPlayingState.msg_room_info.bytes_jump.get().toStringUtf8();
            ((WatchTogetherSession)localObject3).e = paramRspLatestPlayingState.msg_room_info.bytes_cover.get().toStringUtf8();
            ((WatchTogetherSession)localObject3).u = paramRspLatestPlayingState.msg_room_info.enum_video_type.get();
            ((WatchTogetherSession)localObject3).v = paramRspLatestPlayingState.msg_room_info.enum_video_jump_type.get();
            ((WatchTogetherSession)localObject3).w = paramRspLatestPlayingState.msg_room_info.bytes_video_jump_value.get().toStringUtf8();
            bool1 = bool3;
            paramToServiceMsg = (ToServiceMsg)localObject1;
          }
          catch (Exception paramToServiceMsg)
          {
            bool1 = true;
            break label601;
          }
        }
        else
        {
          paramToServiceMsg = (ToServiceMsg)localObject1;
          if (localObject4 != null)
          {
            paramToServiceMsg = (ToServiceMsg)localObject1;
            localObject2 = localObject1;
            if (((aio_media.ResultInfo)localObject4).bytes_errmsg.get() != null)
            {
              localObject2 = localObject1;
              paramToServiceMsg = ((aio_media.ResultInfo)localObject4).bytes_errmsg.get().toStringUtf8();
            }
          }
          localObject2 = paramToServiceMsg;
          QLog.d("WatchTogetherParser", 1, String.format("handleGetWatchPlayingState, result = %s, errTips = %s", new Object[] { Integer.valueOf(i), paramToServiceMsg }));
          bool1 = false;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        label593:
        localObject1 = localObject2;
        label601:
        QLog.d("WatchTogetherParser", 1, "handleGetWatchPlayingState exception", paramToServiceMsg);
        paramToServiceMsg = (ToServiceMsg)localObject1;
      }
      localObject2 = paramToServiceMsg;
      bool2 = bool1;
      if (!TextUtils.isEmpty(((WatchTogetherSession)localObject3).r))
      {
        ContactUtils.b(this.a, ((WatchTogetherSession)localObject3).n, ((WatchTogetherSession)localObject3).r);
        bool2 = bool1;
        localObject2 = paramToServiceMsg;
      }
    }
    a(bool2, (WatchTogetherSession)localObject3, j, (String)localObject2);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetWatchPlayingState, isSuccess=");
      paramToServiceMsg.append(bool2);
      paramToServiceMsg.append(", session= ");
      paramToServiceMsg.append(localObject3);
      paramToServiceMsg.append(", by=");
      paramToServiceMsg.append(j);
      QLog.d("WatchTogetherParser", 2, paramToServiceMsg.toString());
    }
  }
  
  public void a(Object paramObject) {}
  
  public void a(String paramString, int paramInt)
  {
    TogetherSession localTogetherSession = ((TogetherControlManager)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(2, 1, paramString);
    if ((localTogetherSession instanceof WatchTogetherSession))
    {
      localTogetherSession.p = 3;
      localTogetherSession.q = 3;
      TogetherUtils.a(this.a, paramString, false);
      a(true, (WatchTogetherSession)localTogetherSession, 1007, "");
    }
  }
  
  public void a(boolean paramBoolean, WatchTogetherSession paramWatchTogetherSession, int paramInt, String paramString)
  {
    TogetherControlManager localTogetherControlManager = (TogetherControlManager)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    Object localObject = localTogetherControlManager.b(2, 1, paramWatchTogetherSession.n, paramInt);
    if ((paramBoolean) && (paramInt == 1003) && ((((TogetherControlManager.CacheHolder)localObject).b instanceof TroopTips0x857.VideoChangePushInfo)))
    {
      int i = ((TogetherControlManager.CacheHolder)localObject).a.getInt("action_type");
      String str = ((TogetherControlManager.CacheHolder)localObject).a.getString("tips");
      long l1 = ((TogetherControlManager.CacheHolder)localObject).a.getLong("seq");
      long l2 = ((TogetherControlManager.CacheHolder)localObject).a.getLong("msgSeq");
      localTogetherControlManager.a(paramWatchTogetherSession, i, str, l1, l2, (TroopTips0x857.VideoChangePushInfo)((TogetherControlManager.CacheHolder)localObject).b);
      localTogetherControlManager.b(paramWatchTogetherSession, i, str, l1, l2, (TroopTips0x857.VideoChangePushInfo)((TogetherControlManager.CacheHolder)localObject).b);
    }
    if (paramWatchTogetherSession.p == 3) {
      TogetherUtils.a(this.a, paramWatchTogetherSession.n, false);
    } else {
      TogetherUtils.a(this.a, paramWatchTogetherSession.n, true);
    }
    if ((paramWatchTogetherSession.p == 1) && (paramWatchTogetherSession.q == 2))
    {
      boolean bool1;
      if ((paramWatchTogetherSession.a != 1) && (paramWatchTogetherSession.a != 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((!TextUtils.isEmpty(paramWatchTogetherSession.b)) && (!TextUtils.isEmpty(paramWatchTogetherSession.w))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((bool1) && (bool2) && (TogetherWatchFloatingUtil.b(paramWatchTogetherSession.l, paramWatchTogetherSession.n, paramWatchTogetherSession.m)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WatchTogetherParser", 1, "isSameFloatingInfo");
        }
        localObject = new WatchTogetherFloatingData();
        ((WatchTogetherFloatingData)localObject).setCurUin(paramWatchTogetherSession.n);
        ((WatchTogetherFloatingData)localObject).setCurType(paramWatchTogetherSession.m);
        ((WatchTogetherFloatingData)localObject).setSmallUrl(paramWatchTogetherSession.b);
        ((WatchTogetherFloatingData)localObject).setBigUrl(paramWatchTogetherSession.w);
        if ((!((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramWatchTogetherSession.n).isAdmin()) && (!paramWatchTogetherSession.r.equals(this.a.getCurrentUin()))) {
          ((WatchTogetherFloatingData)localObject).setIsAdm(false);
        } else {
          ((WatchTogetherFloatingData)localObject).setIsAdm(true);
        }
        TogetherWatchFloatingUtil.a(BaseApplicationImpl.context, (WatchTogetherFloatingData)localObject);
      }
      else if (TogetherWatchFloatingUtil.b(paramWatchTogetherSession.l, paramWatchTogetherSession.n, paramWatchTogetherSession.m))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isSameFloatingInfo but param error isSupportRoomType=");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append(" isUrlValid=");
          ((StringBuilder)localObject).append(bool2);
          QLog.d("WatchTogetherParser", 1, ((StringBuilder)localObject).toString());
        }
        TogetherWatchFloatingUtil.a(false, paramWatchTogetherSession.n, paramWatchTogetherSession.m, false);
      }
    }
    if ((paramWatchTogetherSession.p == 3) || (paramWatchTogetherSession.q == 1) || (paramWatchTogetherSession.q == 3))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("session.state=");
        ((StringBuilder)localObject).append(paramWatchTogetherSession.p);
        ((StringBuilder)localObject).append(" session.userState=");
        ((StringBuilder)localObject).append(paramWatchTogetherSession.q);
        ((StringBuilder)localObject).append(" uin=");
        ((StringBuilder)localObject).append(paramWatchTogetherSession.n);
        ((StringBuilder)localObject).append(" type=");
        ((StringBuilder)localObject).append(paramWatchTogetherSession.m);
        QLog.d("WatchTogetherParser", 1, ((StringBuilder)localObject).toString());
      }
      localObject = new WatchTogetherFloatingData();
      ((WatchTogetherFloatingData)localObject).setCurUin(paramWatchTogetherSession.n);
      ((WatchTogetherFloatingData)localObject).setCurType(paramWatchTogetherSession.m);
      TogetherWatchFloatingUtil.b(BaseApplicationImpl.context, (WatchTogetherFloatingData)localObject);
    }
    localTogetherControlManager.a(paramBoolean, paramWatchTogetherSession, paramInt, paramString);
    localTogetherControlManager.c(2, 1, paramWatchTogetherSession.n, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherParser
 * JD-Core Version:    0.7.0.1
 */