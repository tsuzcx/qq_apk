package com.tencent.mobileqq.confess;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;

class ConfessPlugin$5
  implements Runnable
{
  ConfessPlugin$5(ConfessPlugin paramConfessPlugin, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, String paramString4, String paramString5, String paramString6, int paramInt4, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.mRuntime.d();
    Object localObject4 = this.this$0.mRuntime.b();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("activity=");
      ((StringBuilder)localObject1).append(localObject2);
      ((StringBuilder)localObject1).append("  app=");
      ((StringBuilder)localObject1).append(localObject4);
      ((StringBuilder)localObject1).append(" finishing?");
      boolean bool;
      if ((localObject2 != null) && (((Activity)localObject2).isFinishing())) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      QLog.d("ConfessPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    if ((localObject2 != null) && (localObject4 != null) && (!((Activity)localObject2).isFinishing()))
    {
      Bitmap localBitmap = ConfessShareHelper.a((AppInterface)localObject4, (Context)localObject2, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.this$0.d);
      int m = this.b;
      if ((m == 0) && (localBitmap != null)) {
        localObject1 = ConfessShareHelper.b((AppInterface)localObject4, (Context)localObject2, this.a, m, this.c, this.d, this.e, this.f, this.g, this.this$0.d);
      } else {
        localObject1 = null;
      }
      if ((localBitmap != null) && ((this.b != 0) || (localObject1 != null)))
      {
        String str2 = ConfessShareHelper.a((AppInterface)localObject4, (Context)localObject2, localBitmap);
        String str1 = this.f;
        Object localObject3;
        if (this.b == 0)
        {
          localObject3 = ConfessShareHelper.a(str2, this.this$0.mRuntime.b());
          localObject4 = ConfessShareHelper.a(ConfessShareHelper.a((AppInterface)localObject4, (Context)localObject2, (Bitmap)localObject1), this.this$0.mRuntime.b());
          localObject2 = localObject4;
          localObject1 = localObject3;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject1 = ((String)localObject4).replace("http://qqadapt.qpic.cn/qqshare/", "");
            str1 = Uri.parse(this.f).buildUpon().appendQueryParameter("ct", (String)localObject1).build().toString();
            localObject2 = localObject4;
            localObject1 = localObject3;
          }
        }
        else
        {
          localObject2 = null;
          localObject1 = null;
        }
        if ((!TextUtils.isEmpty(str2)) && ((this.b != 0) || ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))))
        {
          localObject2 = this.h;
          localObject3 = this.i;
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("processShare share_url_tmp:");
            ((StringBuilder)localObject4).append(str1);
            ((StringBuilder)localObject4).append(" remoteUrl:");
            ((StringBuilder)localObject4).append((String)localObject1);
            ((StringBuilder)localObject4).append(" srcUrl:");
            ((StringBuilder)localObject4).append(this.h);
            ((StringBuilder)localObject4).append(" srcIconUrl:");
            ((StringBuilder)localObject4).append(this.i);
            QLog.d("ConfessPlugin", 2, ((StringBuilder)localObject4).toString());
          }
          if (this.b == 0)
          {
            localObject4 = new HashMap();
            if ((localObject2 != null) && (((String)localObject2).length() > 30)) {
              ((HashMap)localObject4).put("srcUrl", localObject2);
            }
            if ((localObject3 != null) && (((String)localObject3).length() > 30)) {
              ((HashMap)localObject4).put("srcIconUrl", localObject3);
            }
            if ((localObject1 != null) && (((String)localObject1).length() > 30)) {
              ((HashMap)localObject4).put("remoteUrl", localObject1);
            }
            if (!((HashMap)localObject4).isEmpty())
            {
              HashMap localHashMap = HttpUtil.shortenUrlBatch((HashMap)localObject4);
              localObject4 = (String)localHashMap.get("remoteUrl");
              if (localObject4 != null) {
                localObject1 = localObject4;
              }
              localObject4 = (String)localHashMap.get("srcUrl");
              if (localObject4 != null) {
                localObject2 = localObject4;
              }
              localObject4 = (String)localHashMap.get("srcIconUrl");
              if (localObject4 != null) {
                localObject3 = localObject4;
              }
            }
          }
          ThreadManager.getUIHandler().post(new ConfessPlugin.5.1(this, str1, (String)localObject1, (String)localObject2, (String)localObject3, str2, localBitmap));
          return;
        }
        ConfessPlugin.b(this.this$0);
        ConfessPlugin.a(this.this$0, false);
        ConfessPlugin.a(this.this$0, 1, 2131894251);
        return;
      }
      ConfessPlugin.b(this.this$0);
      ConfessPlugin.a(this.this$0, false);
      ConfessPlugin.a(this.this$0, 0, 2131916544);
      return;
    }
    ConfessPlugin.b(this.this$0);
    ConfessPlugin.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.5
 * JD-Core Version:    0.7.0.1
 */