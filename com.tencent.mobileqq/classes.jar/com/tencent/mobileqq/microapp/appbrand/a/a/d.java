package com.tencent.mobileqq.microapp.appbrand.a.a;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public final class d
  extends a
{
  private static final Set b = new e();
  
  public String a(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClipboardJsPlugin", 2, "handleNativeRequest: " + paramString1 + " |jsonParams: " + paramString2 + " |callbackId:" + paramInt);
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = new JSONObject(paramString2);
        if ("getClipboardData".equals(paramString1))
        {
          localObject1 = (ClipboardManager)paramBaseAppBrandWebview.getContext().getSystemService("clipboard");
          localJSONObject = new JSONObject();
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          Object localObject1;
          JSONObject localJSONObject;
          if (((ClipboardManager)localObject1).hasPrimaryClip())
          {
            localObject1 = ((ClipboardManager)localObject1).getPrimaryClip().getItemAt(0).getText();
            localJSONObject.put("data", localObject1);
            this.a.a(paramBaseAppBrandWebview, paramString1, localJSONObject, paramInt);
            return super.a(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
            localThrowable = localThrowable;
            localThrowable.printStackTrace();
            localObject2 = new JSONObject();
            continue;
          }
          localObject2 = "";
          continue;
          if (!"setClipboardData".equals(paramString1)) {
            continue;
          }
        }
        catch (Throwable paramString2)
        {
          paramString2.printStackTrace();
          this.a.b(paramBaseAppBrandWebview, paramString1, null, paramInt);
          return "";
        }
      }
      ((ClipboardManager)paramBaseAppBrandWebview.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, ((JSONObject)localObject2).optString("data")));
      this.a.a(paramBaseAppBrandWebview, paramString1, null, paramInt);
    }
  }
  
  public Set b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a.a.d
 * JD-Core Version:    0.7.0.1
 */