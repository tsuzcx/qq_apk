package com.tencent.mobileqq.vaswebviewplugin;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.aidl.IDownloadListener.Stub;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ThemeJsPlugin$8
  extends IDownloadListener.Stub
{
  private long startTime = SystemClock.uptimeMillis();
  
  ThemeJsPlugin$8(ThemeJsPlugin paramThemeJsPlugin, String paramString) {}
  
  public void onComplete(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (!paramString.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX))) {
      return;
    }
    Object localObject1 = ThemeUtil.getIDFromSCID(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onComplete error scid: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("ThemeJsPlugin", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2 = (ThemeUtil.ThemeInfo)ThemeJsPlugin.access$100(this.this$0).get(localObject1);
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onPushMsg null info Error :");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", scid ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("ThemeJsPlugin", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onComplete :");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", scid ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", themeInfo:");
    localStringBuilder.append(localObject2);
    QLog.d("ThemeJsPlugin", 1, localStringBuilder.toString());
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.startTime;
    paramString = this.this$0;
    paramString.reportTheme("theme_download", 0, ThemeJsPlugin.access$200(paramString), l1 - l2, "VipThemeMallDowned", "ok", "200", 153, ThemeReporter.a, 9, ((ThemeUtil.ThemeInfo)localObject2).version, "");
    if (!((String)localObject1).equals(ThemeJsPlugin.access$200(this.this$0)))
    {
      paramString = new StringBuilder();
      paramString.append("onComplete not currentId: ");
      paramString.append(ThemeJsPlugin.access$200(this.this$0));
      QLog.e("ThemeJsPlugin", 1, paramString.toString());
      return;
    }
    if (paramInt == 0)
    {
      ((ThemeUtil.ThemeInfo)localObject2).status = "3";
      if (((ThemeUtil.ThemeInfo)localObject2).size > 1L) {
        ((ThemeUtil.ThemeInfo)localObject2).downsize = ((ThemeUtil.ThemeInfo)localObject2).size;
      }
      paramString = "ok";
      paramInt = 0;
    }
    else if (paramInt == 8)
    {
      paramInt = 5;
      paramString = "No network access.";
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("download errCode:");
      paramString.append(paramInt);
      paramString = paramString.toString();
      paramInt = -14;
    }
    if ("saveDiyTheme".equals(ThemeJsPlugin.access$000(this.this$0)))
    {
      this.this$0.diyThemeSetup((String)localObject1, "20000000", this.val$callbackId);
      return;
    }
    localObject1 = this.this$0;
    localObject2 = this.val$callbackId;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("{'result':");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", 'message':'");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'}");
    ((ThemeJsPlugin)localObject1).callJs((String)localObject2, new String[] { localStringBuilder.toString() });
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = ThemeUtil.getIDFromSCID(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onProgress error scid: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("ThemeJsPlugin", 1, ((StringBuilder)localObject).toString());
      return;
    }
    paramString = (ThemeUtil.ThemeInfo)ThemeJsPlugin.access$100(this.this$0).get(localObject);
    if (paramString != null)
    {
      paramString.downsize = paramLong1;
      paramString.size = paramLong2;
      paramString.status = "2";
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPushMsg onProgress: themeid=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", readSize:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", size:");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("ThemeJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */