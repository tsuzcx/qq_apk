package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class OpenWeiyunVipHelperImpl
  implements IOpenWeiyunVipHelper
{
  private static final String AID_WY_OPEN_QQ_VIP = "mvip.n.a.zcwy_popup";
  private static final int HANDLE_MSG_DELAY_TIME = 1000;
  private static final int MSG_CLOSE_SPACE_OR_FLOW_DIALOG = 3001;
  private static final int MSG_SHOW_SPACE_OR_FLOW_DIALOG = 3000;
  private static final String OPEN_QQ_VIP_STRATEIE_URL = "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&aid=%s";
  private static final String OPEN_WEIYUN_VIP_STRATEIE_URL = "https://jump.weiyun.com?from=3092";
  private static final int SHOW_DIALOG_INTERVAL = 4000;
  private static final String TAG = "OpenWeiyunVipHelper";
  private static final String[] WHITE_ACTIVITY_LIST = { "TroopFileDetailBrowserActivity", "FMActivity", "FileBrowserActivity", "ChatHistoryFileActivity", "FileAssistantActivity" };
  private static OpenWeiyunVipHelperImpl.OpenVipHandler mHandler = new OpenWeiyunVipHelperImpl.OpenVipHandler(Looper.getMainLooper());
  private static volatile long mLastShowDialogTime = 0L;
  private static QQCustomDialog sQQCustomDialog;
  
  private boolean isInWhiteList(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getClass().getName();
      String[] arrayOfString = WHITE_ACTIVITY_LIST;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!TextUtils.isEmpty(paramActivity)) && (paramActivity.contains(str))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private boolean isNeedShowOutOfInterval()
  {
    if (mLastShowDialogTime == 0L) {
      return true;
    }
    long l = SystemClock.uptimeMillis();
    return mLastShowDialogTime + 4000L < l;
  }
  
  private void showLimitDialogInner(Activity paramActivity, int paramInt)
  {
    Object localObject;
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      localObject = paramActivity;
      if (paramActivity == QBaseActivity.sTopActivity) {}
    }
    else
    {
      localObject = QBaseActivity.sTopActivity;
    }
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!isInWhiteList((Activity)localObject)) {
        return;
      }
      paramActivity = sQQCustomDialog;
      if (((paramActivity == null) || (!paramActivity.isShowing())) && (isNeedShowOutOfInterval()))
      {
        if (isNonVipSpaceOverErrorCode(paramInt)) {
          paramActivity = MobileQQ.sMobileQQ.getString(2131692610);
        } else {
          paramActivity = MobileQQ.sMobileQQ.getString(2131692611);
        }
        String str;
        if (isNonVipSpaceOverErrorCode(paramInt)) {
          str = MobileQQ.sMobileQQ.getString(2131692603);
        } else {
          str = MobileQQ.sMobileQQ.getString(2131692606);
        }
        sQQCustomDialog = DialogUtil.a((Context)localObject, 230, paramActivity, str, 2131692608, 2131692609, new OpenWeiyunVipHelperImpl.1(this, paramInt, (Activity)localObject), new OpenWeiyunVipHelperImpl.2(this));
        sQQCustomDialog.setOnDismissListener(new OpenWeiyunVipHelperImpl.3(this));
        sQQCustomDialog.show();
      }
    }
  }
  
  private void showLimitDialogInnerForGP(Activity paramActivity, int paramInt)
  {
    Object localObject;
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      localObject = paramActivity;
      if (paramActivity == QBaseActivity.sTopActivity) {}
    }
    else
    {
      localObject = QBaseActivity.sTopActivity;
    }
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!isInWhiteList((Activity)localObject)) {
        return;
      }
      if (isNonVipSpaceOverErrorCode(paramInt)) {
        paramActivity = MobileQQ.sMobileQQ.getString(2131692604);
      } else {
        paramActivity = MobileQQ.sMobileQQ.getString(2131692607);
      }
      QQToast.a((Context)localObject, 0, paramActivity, 1).a();
    }
  }
  
  public void closeLimitDialog()
  {
    Message localMessage = mHandler.obtainMessage();
    localMessage.what = 3001;
    mHandler.sendMessage(localMessage);
  }
  
  public boolean isNonVipFlowOverErrorCode(int paramInt)
  {
    return (paramInt == 1127) || (paramInt == 22000);
  }
  
  public boolean isNonVipSpaceOverErrorCode(int paramInt)
  {
    return (paramInt == 1053) || (paramInt == 22081);
  }
  
  public boolean needShowLimitDialog(int paramInt)
  {
    return (isNonVipFlowOverErrorCode(paramInt)) || (isNonVipSpaceOverErrorCode(paramInt));
  }
  
  public void showLimitDialog(Activity paramActivity, int paramInt)
  {
    QLog.d("OpenWeiyunVipHelper", 2, "showLimitDialog");
    mHandler.removeMessages(3000);
    Message localMessage = mHandler.obtainMessage();
    localMessage.what = 3000;
    localMessage.obj = paramActivity;
    localMessage.arg1 = paramInt;
    mHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public void showWeiYunSpaceOrFlowLimitDialog(Activity paramActivity, int paramInt)
  {
    if (needShowLimitDialog(paramInt)) {
      showLimitDialog(paramActivity, paramInt);
    }
  }
  
  public void startOpenQQVipH5(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    paramString = String.format("https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&aid=%s", new Object[] { paramString });
    paramActivity = new ActivityURIRequest(paramActivity, "/base/browser");
    paramActivity.extra().putString("url", paramString);
    if (paramBoolean) {
      paramActivity.setRequestCode(2000);
    }
    QRoute.startUri(paramActivity, null);
  }
  
  public void startOpenWeiyunVipCompareH5(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer("https://jump.weiyun.com?from=3092");
    if (paramString != null)
    {
      localStringBuffer.append("&aid=");
      localStringBuffer.append(paramString);
    }
    paramActivity = new ActivityURIRequest(paramActivity, "/base/browser");
    paramActivity.extra().putString("url", localStringBuffer.toString());
    if (paramBoolean) {
      paramActivity.setRequestCode(2000);
    }
    QRoute.startUri(paramActivity, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.OpenWeiyunVipHelperImpl
 * JD-Core Version:    0.7.0.1
 */