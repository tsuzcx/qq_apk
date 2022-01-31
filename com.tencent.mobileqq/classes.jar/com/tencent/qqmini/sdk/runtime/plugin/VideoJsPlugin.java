package com.tencent.qqmini.sdk.runtime.plugin;

import bgho;
import bgkd;
import bgkk;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoJsProxy.Bridge;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.util.ToastMessage;
import com.tencent.qqmini.sdk.runtime.util.ToastMessage.Action;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class VideoJsPlugin
  extends BaseJsPlugin
  implements VideoJsProxy.Bridge
{
  public static final String API_CHOOSE_VIDEO = "chooseVideo";
  public static final String API_SAVE_VIDEO_TO_ALBUM = "saveVideoToPhotosAlbum";
  public static final String TAG = "TabBarJsPlugin";
  private ConcurrentHashMap<Integer, bgkd> bridgeMap;
  private VideoJsProxy mImpl;
  
  public void chooseVideo(bgkd parambgkd)
  {
    try
    {
      this.mImpl.chooseVideo(this.mMiniAppContext.a(), parambgkd.jdField_a_of_type_JavaLangString, parambgkd.jdField_b_of_type_JavaLangString, parambgkd.jdField_b_of_type_Int);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("TabBarJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " error,", localThrowable);
      parambgkd.b();
    }
  }
  
  public void hideLoading()
  {
    ToastMessage localToastMessage = ToastMessage.a();
    localToastMessage.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action = ToastMessage.Action.HIDE;
    bgkk.a(new VideoJsPlugin.3(this, localToastMessage));
  }
  
  public void onCreate(bgho parambgho)
  {
    super.onCreate(parambgho);
    this.mImpl.setResponseListener(this);
    this.bridgeMap = new ConcurrentHashMap();
    this.mImpl.create();
  }
  
  public void onDestroy()
  {
    if (this.mImpl != null) {
      this.mImpl.destroy();
    }
    if (this.bridgeMap != null) {
      this.bridgeMap.clear();
    }
    super.onDestroy();
  }
  
  public boolean onInterceptJsEvent(bgkd parambgkd)
  {
    QMLog.d("TabBarJsPlugin", "onInterceptJsEvent event=" + parambgkd.jdField_a_of_type_JavaLangString + ",jsonParams=" + parambgkd.jdField_b_of_type_JavaLangString + ",callbackId=" + parambgkd.jdField_b_of_type_Int + ",webview=" + parambgkd.jdField_a_of_type_Bghn);
    if (this.bridgeMap != null) {
      this.bridgeMap.put(Integer.valueOf(parambgkd.jdField_b_of_type_Int), parambgkd);
    }
    return super.onInterceptJsEvent(parambgkd);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void responseCancel(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.bridgeMap != null)
    {
      paramString = (bgkd)this.bridgeMap.get(Integer.valueOf(paramInt));
      if (paramString != null) {
        paramString.b(paramJSONObject);
      }
    }
  }
  
  public void responseFail(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.bridgeMap != null)
    {
      paramString1 = (bgkd)this.bridgeMap.get(Integer.valueOf(paramInt));
      if (paramString1 != null) {
        paramString1.a(paramString2);
      }
    }
  }
  
  public void responseOk(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.bridgeMap != null)
    {
      paramString = (bgkd)this.bridgeMap.get(Integer.valueOf(paramInt));
      if (paramString != null) {
        paramString.a(paramJSONObject);
      }
    }
  }
  
  public void saveVideoToPhotosAlbum(bgkd parambgkd)
  {
    try
    {
      this.mImpl.saveVideoToPhotosAlbum(this.mMiniAppContext.a(), parambgkd.jdField_a_of_type_JavaLangString, parambgkd.jdField_b_of_type_JavaLangString, parambgkd.jdField_b_of_type_Int);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("TabBarJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " error,", localThrowable);
      parambgkd.b();
    }
  }
  
  public void sendNativeViewEvent(bgkd parambgkd, int paramInt)
  {
    super.sendNativeViewEvent(parambgkd, paramInt);
  }
  
  public void sendSubscribeEvent(String paramString1, String paramString2)
  {
    super.sendSubscribeEvent(paramString1, paramString2);
  }
  
  public void showLoading(String paramString)
  {
    QMLog.i("TabBarJsPlugin", "showLoading " + paramString);
    ToastMessage localToastMessage = ToastMessage.a();
    localToastMessage.jdField_a_of_type_Int = 1;
    localToastMessage.jdField_a_of_type_JavaLangString = "loading";
    localToastMessage.jdField_b_of_type_JavaLangString = null;
    localToastMessage.c = paramString;
    localToastMessage.jdField_b_of_type_Int = -1;
    localToastMessage.jdField_a_of_type_Boolean = false;
    localToastMessage.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action = ToastMessage.Action.SHOW;
    bgkk.a(new VideoJsPlugin.1(this, localToastMessage));
  }
  
  public void updateLoading(String paramString)
  {
    ToastMessage localToastMessage = ToastMessage.a();
    localToastMessage.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action = ToastMessage.Action.UPDATE;
    localToastMessage.c = paramString;
    bgkk.a(new VideoJsPlugin.2(this, localToastMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.VideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */