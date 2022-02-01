package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.mobileqq.bigbrother.TeleScreenConfig.Config;
import com.tencent.mobileqq.bigbrother.Utils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import org.json.JSONObject;

public class TeleScreenApiPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  @Nullable
  private ArraySet<Integer> jdField_a_of_type_AndroidSupportV4UtilArraySet;
  
  public TeleScreenApiPlugin()
  {
    this.mPluginNameSpace = "Gdt";
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("businessId");
        String str1 = ((JSONObject)localObject).optString("openlink");
        String str2 = ((JSONObject)localObject).optString("packageName");
        localObject = ((JSONObject)localObject).optString("callback");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label207;
        }
        TeleScreenApiPlugin.1 local1 = new TeleScreenApiPlugin.1(this, (String)localObject);
        i = TeleScreen.a().a(local1);
        if (this.jdField_a_of_type_AndroidSupportV4UtilArraySet == null) {
          this.jdField_a_of_type_AndroidSupportV4UtilArraySet = new ArraySet();
        }
        this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(Integer.valueOf(i));
        try
        {
          if (!TextUtils.isEmpty(str1))
          {
            Utils.a(this.jdField_a_of_type_AndroidAppActivity, str1, paramString, i);
            return;
          }
          if (TextUtils.isEmpty(str2)) {
            break label183;
          }
          PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, str2, null, paramString, i);
          return;
        }
        catch (ActivityNotFoundException paramString)
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
        }
        callJs((String)localObject, new String[] { "{\"openresult\":-3}" });
        return;
      }
      catch (Exception paramString)
      {
        QLog.e(this.TAG, 1, paramString, new Object[0]);
        return;
      }
      label183:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      callJs((String)localObject, new String[] { "{\"openresult\":-3}" });
      return;
      label207:
      int i = 0;
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8L;
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    if ((paramLong == 8L) && (paramString != null)) {
      try
      {
        if (((TeleScreenConfig.Config)QConfigManager.a().a(416)).a(paramString))
        {
          QLog.d(this.TAG, 1, "doInterceptRequest");
          WebResourceResponse localWebResourceResponse = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
          return localWebResourceResponse;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(this.TAG, 1, localThrowable, new Object[0]);
        return super.handleEvent(paramString, paramLong);
      }
    }
    return super.handleEvent(paramString, paramLong);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ("Gdt".equals(paramString2))
    {
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if (("Openlink".equals(paramString3)) && (paramVarArgs.length > 0)) {
        a(paramVarArgs[0]);
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = a();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilArraySet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_AndroidSupportV4UtilArraySet.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        TeleScreen.a().a(i);
      }
      this.jdField_a_of_type_AndroidSupportV4UtilArraySet.clear();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TeleScreenApiPlugin
 * JD-Core Version:    0.7.0.1
 */