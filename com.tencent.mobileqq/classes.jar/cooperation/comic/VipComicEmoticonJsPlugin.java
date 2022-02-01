package cooperation.comic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipComicEmoticonJsPlugin
  extends VasWebviewJsPlugin
{
  Activity jdField_a_of_type_AndroidAppActivity = null;
  Context jdField_a_of_type_AndroidContentContext = null;
  BrowserAppInterface jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
  
  public VipComicEmoticonJsPlugin()
  {
    this.mPluginNameSpace = "comicFavor";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(", pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", methodName=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("VipComicEmoticonJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && ("comicFavor".equals(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("failed to parse json str,json=");
          paramString1.append(null);
          QLog.d("VipComicEmoticonJsPlugin", 2, paramString1.toString());
        }
        paramJsBridgeListener.printStackTrace();
        paramJsBridgeListener = null;
      }
      if (paramJsBridgeListener == null) {
        return false;
      }
      try
      {
        paramString1 = paramJsBridgeListener.getString("callback");
        try
        {
          if ("getAddComicEmojiList".equals(paramString3))
          {
            super.sendRemoteReq(DataFactory.a("ipc_comic_emoticon_query_info", paramString1, this.mOnRemoteResp.key, null), false, true);
            return true;
          }
          if ("setComicEmoji".equals(paramString3))
          {
            paramString2 = new JSONObject();
            if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
            {
              paramString2.put("code", -2);
              paramString2.put("message", "no network");
              super.callJs(paramString1, new String[] { paramString2.toString() });
              return true;
            }
            if (!"mounted".equals(Environment.getExternalStorageState()))
            {
              paramString2.put("code", -3);
              paramString2.put("message", "no sdcard");
              super.callJs(paramString1, new String[] { paramString2.toString() });
              return true;
            }
            paramJsBridgeListener = paramJsBridgeListener.optJSONArray("list");
            if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() != 0))
            {
              paramString2 = new Bundle();
              paramString2.putString("listArray", paramJsBridgeListener.toString());
              super.sendRemoteReq(DataFactory.a("ipc_comic_emoticon_add_info", paramString1, this.mOnRemoteResp.key, paramString2), false, true);
              return true;
            }
            paramString2.put("code", -4);
            paramString2.put("message", "params error");
            super.callJs(paramString1, new String[] { paramString2.toString() });
            return true;
          }
          if ("syncFavEmoji".equals(paramString3))
          {
            super.sendRemoteReq(DataFactory.a("ipc_sync_fav_emoticon", paramString1, this.mOnRemoteResp.key, null), false, true);
            return true;
          }
        }
        catch (Throwable paramJsBridgeListener) {}
        try
        {
          paramString2 = new JSONObject();
          paramString2.put("code", -1);
          paramString2.put("message", paramJsBridgeListener.getMessage());
          callJs(paramString1, new String[] { paramString2.toString() });
          return true;
        }
        catch (Exception paramString1)
        {
          break label486;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramString1 = null;
      }
      label486:
      if (QLog.isColorLevel()) {
        QLog.e("VipComicEmoticonJsPlugin", 2, paramJsBridgeListener.getMessage());
      }
      return true;
    }
    else
    {
      return false;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a().getApplicationContext();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null) {
      try
      {
        if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
        {
          String str1 = paramBundle.getString("cmd");
          String str2 = paramBundle.getString("callbackid");
          String str3 = paramBundle.getString("result");
          Object localObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onResponse,callback=");
            ((StringBuilder)localObject).append(str2);
            ((StringBuilder)localObject).append(",cmd=");
            ((StringBuilder)localObject).append(str1);
            ((StringBuilder)localObject).append(",result=");
            ((StringBuilder)localObject).append(str3);
            QLog.e("VipComicEmoticonJsPlugin", 2, ((StringBuilder)localObject).toString());
          }
          if (str1 != null)
          {
            localObject = new JSONObject();
            if ((!"ipc_comic_emoticon_add_info".equals(str1)) && (!"ipc_comic_emoticon_query_info".equals(str1)) && (!"ipc_sync_fav_emoticon".equals(str1)))
            {
              super.onResponse(paramBundle);
              return;
            }
            if (TextUtils.isEmpty(str3))
            {
              ((JSONObject)localObject).put("code", -5);
              ((JSONObject)localObject).put("message", "invalid data, response data is null");
              super.callJs(str2, new String[] { ((JSONObject)localObject).toString() });
              return;
            }
            super.callJs(str2, new String[] { str3 });
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.comic.VipComicEmoticonJsPlugin
 * JD-Core Version:    0.7.0.1
 */