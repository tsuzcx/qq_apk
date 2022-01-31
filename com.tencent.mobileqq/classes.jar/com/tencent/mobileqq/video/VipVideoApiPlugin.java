package com.tencent.mobileqq.video;

import akkp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class VipVideoApiPlugin
  extends WebViewPlugin
{
  public Client.onRemoteRespObserver a;
  public final String a;
  public String b;
  
  public VipVideoApiPlugin()
  {
    this.jdField_a_of_type_JavaLangString = "VideoApiPlugin";
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new akkp(this);
    this.mPluginNameSpace = "video";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("VideoApiPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    boolean bool1;
    if ((!"video".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      bool1 = false;
    }
    label154:
    do
    {
      do
      {
        do
        {
          return bool1;
          for (;;)
          {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              if (paramString1.has("callback"))
              {
                paramJsBridgeListener = paramString1.getString("callback");
                if (!"isInstalled".equals(paramString3)) {
                  break label154;
                }
                bool1 = bool2;
                if (!WebIPCOperator.a().a()) {
                  break;
                }
                paramString1 = new Bundle();
                paramJsBridgeListener = DataFactory.a("ipc_video_isinstalled", paramJsBridgeListener, this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, paramString1);
                WebIPCOperator.a().a(paramJsBridgeListener);
                return true;
              }
            }
            catch (Exception paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
              return true;
            }
            paramJsBridgeListener = "";
          }
          if (!"installPlugin".equals(paramString3)) {
            break;
          }
          bool1 = bool2;
        } while (!WebIPCOperator.a().a());
        paramString1 = new Bundle();
        paramJsBridgeListener = DataFactory.a("ipc_video_install_plugin", paramJsBridgeListener, this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, paramString1);
        WebIPCOperator.a().a(paramJsBridgeListener);
        return true;
        bool1 = bool2;
      } while (!"playVideo".equals(paramString3));
      paramString2 = paramString1.optString("vid", "");
      paramString3 = paramString1.optString("format", "");
      int i = paramString1.optInt("playType", 0);
      paramString1 = paramString1.optString("screenOrientation", "landscape");
      if (!TextUtils.isEmpty(paramJsBridgeListener)) {
        this.b = paramJsBridgeListener;
      }
      if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (i > 0))
      {
        paramJsBridgeListener = new Intent(this.mRuntime.a(), VipVideoPlayActivity.class);
        paramJsBridgeListener.putExtra("vid", paramString2);
        paramJsBridgeListener.putExtra("videoFormat", paramString3);
        paramJsBridgeListener.putExtra("vtype", i);
        paramJsBridgeListener.putExtra("screenOrientation", paramString1);
        startActivityForResult(paramJsBridgeListener, (byte)100);
        return true;
      }
      bool1 = bool2;
    } while (TextUtils.isEmpty(this.b));
    callJs(this.b, new String[] { String.valueOf(4) });
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoApiPlugin", 2, "vip video api plugin on activity result requestCode=" + paramByte + ",resultCode=" + paramInt);
    }
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if ((paramByte == 100) && (!TextUtils.isEmpty(this.b))) {
      callJs(this.b, new String[] { String.valueOf(paramInt) });
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoApiPlugin
 * JD-Core Version:    0.7.0.1
 */