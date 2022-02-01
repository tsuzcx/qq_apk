package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.comment.DanmuDataContext;
import com.tencent.mobileqq.comment.DanmuDataHolder;
import com.tencent.mobileqq.comment.DanmuDataHolder.CacheHolder;
import com.tencent.mobileqq.comment.DanmuDataIPCClient.DanmuPullCallback;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend;
import com.tencent.mobileqq.richmediabrowser.api.IDanmuDataIPCServer;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DanmuDataIPCServerImpl
  extends QIPCModule
  implements DanmuDataIPCClient.DanmuPullCallback, IDanmuDataIPCServer
{
  public static final String TAG = "DanmuDataIPCServer";
  private static volatile DanmuDataIPCServerImpl mInstance;
  
  public DanmuDataIPCServerImpl()
  {
    super("DanmuDataIPCServer");
  }
  
  public static DanmuDataIPCServerImpl getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new DanmuDataIPCServerImpl();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  private static long[] toArray(List<Long> paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      arrayOfLong[i] = ((Long)paramList.next()).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public QIPCModule getDanmuIPCServer()
  {
    return getInstance();
  }
  
  public void notifyDanmuSendResult(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3, SpannableString paramSpannableString)
  {
    QLog.d("DanmuDataIPCServer", 1, "notifyDanmuSendResult");
    if (paramSpannableString != null)
    {
      String str = paramSpannableString.toString();
      if ((paramString1.length() > str.length()) && (paramString1.startsWith(str)))
      {
        paramSpannableString = paramString1.substring(paramSpannableString.length());
        if (!TextUtils.isEmpty(paramSpannableString)) {
          paramString1 = paramSpannableString;
        }
      }
    }
    paramSpannableString = ((ICommentDanmakuDepend)QRoute.api(ICommentDanmakuDepend.class)).getTroopMemberName(paramString2);
    paramString1 = new DanmuItemBean(Long.parseLong(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin()), 0L, paramLong1, paramLong2, paramString1, paramSpannableString);
    paramString1.jdField_a_of_type_Boolean = ((ICommentDanmakuDepend)QRoute.api(ICommentDanmakuDepend.class)).getAioAnonymousStatus(paramString2);
    if (paramString1.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataIPCServer", 2, "notifyDanmuSendResult, anonymousFlag true");
      }
      paramString1.c = ((ICommentDanmakuDepend)QRoute.api(ICommentDanmakuDepend.class)).getAnonymousNickName(paramString2);
      paramString1.jdField_a_of_type_Int = ((ICommentDanmakuDepend)QRoute.api(ICommentDanmakuDepend.class)).getAnonymousHeadId(paramString2);
    }
    paramSpannableString = new Bundle();
    paramSpannableString.putParcelable("key_barrage_danmu_msg", paramString1);
    paramSpannableString.putLong("key_barrage_msg_seq", paramLong3);
    paramSpannableString.putString("key_barrage_grp_uin", paramString2);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "DanmuDataIPCClient", "qipc_action_send_barrage", paramSpannableString, null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("qipc_action_get_barrage".equals(paramString))
    {
      long l1 = paramBundle.getLong("key_barrage_msg_seq");
      long l2 = paramBundle.getLong("key_barrage_grp_uin");
      int i = paramBundle.getInt("key_barrage_topic_type");
      boolean bool = paramBundle.getBoolean("key_barrage_is_update");
      QLog.d("DanmuDataIPCServer", 1, new Object[] { "onCall, msgSeq:", Long.valueOf(l1), " groupUin:", Long.valueOf(l2), " topicType:", Integer.valueOf(i), " peakCached:", Boolean.valueOf(bool) });
      Object localObject = DanmuDataHolder.a().a(DanmuDataHolder.a().a(l2, l1));
      if ((localObject != null) && (!((DanmuDataHolder.CacheHolder)localObject).jdField_a_of_type_Boolean))
      {
        QLog.d("DanmuDataIPCServer", 1, "filter duplicate request, continue pull is not completed");
        paramString = new Bundle();
        paramString.putBoolean("key_barrage_is_success", false);
        callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
        return null;
      }
      if (localObject == null) {
        localObject = new DanmuDataContext(l2, l1, i, bool);
      } else {
        localObject = ((DanmuDataHolder.CacheHolder)localObject).jdField_a_of_type_ComTencentMobileqqCommentDanmuDataContext;
      }
      ((DanmuDataContext)localObject).c = paramBundle.getLong("key_barrage_req_time");
      ((DanmuDataContext)localObject).d = System.currentTimeMillis();
      ((DanmuDataContext)localObject).jdField_a_of_type_Boolean = bool;
      DanmuDataHolder.a().a((DanmuDataContext)localObject, this);
      callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
    }
    if ("qipc_action_clear_cache".equals(paramString)) {
      DanmuDataHolder.a().a();
    }
    return null;
  }
  
  public void onDanmuPullResult(DanmuDataContext paramDanmuDataContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, ArrayList<DanmuItemBean> paramArrayList, List<Long> paramList)
  {
    QLog.d("DanmuDataIPCServer", 1, new Object[] { "onDanmuPullResult, isPullEnd:", Boolean.valueOf(paramBoolean2) });
    if (paramDanmuDataContext == null)
    {
      QLog.d("DanmuDataIPCServer", 1, "onDanmuPullResult fail, pullContext is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_barrage_msg_seq", paramDanmuDataContext.jdField_a_of_type_Long);
    localBundle.putLong("key_barrage_grp_uin", paramDanmuDataContext.b);
    localBundle.putInt("key_barrage_topic_type", paramDanmuDataContext.jdField_a_of_type_Int);
    localBundle.putInt("key_barrage_interval_time", paramInt);
    localBundle.putBoolean("key_barrage_is_success", paramBoolean1);
    if (paramDanmuDataContext.c > 0L)
    {
      localBundle.putLong("key_barrage_req_time", paramDanmuDataContext.c);
      localBundle.putLong("key_barrage_net_req_time", paramDanmuDataContext.d);
      localBundle.putLong("key_barrage_net_response_time", System.currentTimeMillis());
      paramDanmuDataContext.c = -1L;
    }
    if (paramArrayList != null) {
      localBundle.putParcelableArrayList("key_barrage_danmu_list", paramArrayList);
    }
    if (paramList != null) {
      localBundle.putLongArray("key_barrage_del_seq_list", toArray(paramList));
    }
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "DanmuDataIPCClient", "qipc_action_get_barrage_result", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.DanmuDataIPCServerImpl
 * JD-Core Version:    0.7.0.1
 */