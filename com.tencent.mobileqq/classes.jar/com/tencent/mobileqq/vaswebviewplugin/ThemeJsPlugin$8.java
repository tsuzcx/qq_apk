package com.tencent.mobileqq.vaswebviewplugin;

import android.os.SystemClock;
import android.text.TextUtils;
import aylm;
import aymi;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ThemeJsPlugin$8
  extends aylm
{
  private long startTime = SystemClock.uptimeMillis();
  
  ThemeJsPlugin$8(ThemeJsPlugin paramThemeJsPlugin, String paramString) {}
  
  public void onComplete(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (!paramString.startsWith("theme.android."))) {
      return;
    }
    String str2 = ThemeUtil.getIDFromSCID(paramString);
    if (TextUtils.isEmpty(str2))
    {
      QLog.e("ThemeJsPlugin", 1, "onComplete error scid: " + paramString);
      return;
    }
    ThemeUtil.ThemeInfo localThemeInfo = (ThemeUtil.ThemeInfo)ThemeJsPlugin.access$100(this.this$0).get(str2);
    if (localThemeInfo == null)
    {
      QLog.d("ThemeJsPlugin", 1, "onPushMsg null info Error :" + paramInt + ", scid " + paramString);
      return;
    }
    QLog.d("ThemeJsPlugin", 1, "onComplete :" + paramInt + ", scid " + paramString + ", themeInfo:" + localThemeInfo);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.startTime;
    this.this$0.reportTheme("theme_download", 0, ThemeJsPlugin.access$200(this.this$0), l1 - l2, "VipThemeMallDowned", "ok", "200", 153, aymi.a, 9, localThemeInfo.version, "");
    if (!str2.equals(ThemeJsPlugin.access$200(this.this$0)))
    {
      QLog.e("ThemeJsPlugin", 1, "onComplete not currentId: " + ThemeJsPlugin.access$200(this.this$0));
      return;
    }
    int i = 0;
    String str1 = "ok";
    if (paramInt == 0)
    {
      localThemeInfo.status = "3";
      paramString = str1;
      paramInt = i;
      if (localThemeInfo.size > 1L)
      {
        localThemeInfo.downsize = localThemeInfo.size;
        paramInt = i;
        paramString = str1;
      }
    }
    while ("saveDiyTheme".equals(ThemeJsPlugin.access$000(this.this$0)))
    {
      this.this$0.diyThemeSetup(str2, "20000000", this.val$callbackId);
      return;
      if (paramInt == 8)
      {
        paramInt = 5;
        paramString = "No network access.";
      }
      else
      {
        i = -14;
        paramString = "download errCode:" + paramInt;
        paramInt = i;
      }
    }
    this.this$0.callJs(this.val$callbackId, new String[] { "{'result':" + paramInt + ", 'message':'" + paramString + "'}" });
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    String str = ThemeUtil.getIDFromSCID(paramString);
    if (TextUtils.isEmpty(str)) {
      QLog.e("ThemeJsPlugin", 1, "onProgress error scid: " + paramString);
    }
    do
    {
      return;
      paramString = (ThemeUtil.ThemeInfo)ThemeJsPlugin.access$100(this.this$0).get(str);
      if (paramString != null)
      {
        paramString.downsize = paramLong1;
        paramString.size = paramLong2;
        paramString.status = "2";
      }
    } while (!QLog.isColorLevel());
    QLog.d("ThemeJsPlugin", 2, "onPushMsg onProgress: themeid=" + paramString + ", readSize:" + paramLong1 + ", size:" + paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */