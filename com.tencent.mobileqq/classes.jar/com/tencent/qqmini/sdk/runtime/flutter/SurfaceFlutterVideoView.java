package com.tencent.qqmini.sdk.runtime.flutter;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import bgnt;
import bgpv;
import bgrq;
import bhhv;
import bhhw;
import bhhx;
import bhhy;
import com.qflutter.video.IQflutterVideoView;
import com.qflutter.video.IQflutterVideoView.StatusCallBack;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProviderProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Map;
import org.json.JSONObject;

public class SurfaceFlutterVideoView
  extends TextureView
  implements TextureView.SurfaceTextureListener, IQflutterVideoView
{
  private final bgrq jdField_a_of_type_Bgrq;
  private IQflutterVideoView.StatusCallBack jdField_a_of_type_ComQflutterVideoIQflutterVideoView$StatusCallBack;
  private final VideoPlayerProviderProxy jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProviderProxy;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public SurfaceFlutterVideoView(Context paramContext, Map<String, Object> paramMap)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProviderProxy = ((VideoPlayerProviderProxy)ProxyManager.get(VideoPlayerProviderProxy.class));
    this.jdField_a_of_type_Bgrq = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProviderProxy.getVideoPlayer();
    this.jdField_a_of_type_Bgrq.setLooping(true);
    this.jdField_a_of_type_JavaLangString = ("" + paramMap.get("data"));
    a(paramMap.get("videoUrl") + "");
    this.jdField_a_of_type_Bgrq.setOnCompletionListener(new bhhv(this));
    this.jdField_a_of_type_Bgrq.setOnBufferingUpdateListener(new bhhw(this));
    this.jdField_a_of_type_Bgrq.setOnErrorListener(new bhhx(this));
    this.jdField_a_of_type_Bgrq.setOnPreparedListener(new bhhy(this));
  }
  
  private void a(String paramString)
  {
    String str;
    if ((!bgpv.a(paramString)) && (!paramString.equals(this.b)))
    {
      this.b = paramString;
      if (!paramString.startsWith("http"))
      {
        str = paramString;
        if (!paramString.startsWith("https")) {}
      }
      else
      {
        str = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProviderProxy.getUrl(bgnt.a().a(paramString));
      }
      QMLog.d("QFV", "handleOperateXWebVideo playUrl : " + str);
    }
    try
    {
      this.jdField_a_of_type_Bgrq.reset();
      this.jdField_a_of_type_Bgrq.setDataSource(str);
      this.jdField_a_of_type_Bgrq.prepareAsync();
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e("QFV", "", paramString);
    }
  }
  
  public void onStatus(IQflutterVideoView.StatusCallBack paramStatusCallBack)
  {
    QMLog.e("QFVideoView", "on setCallback");
    this.jdField_a_of_type_ComQflutterVideoIQflutterVideoView$StatusCallBack = paramStatusCallBack;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QMLog.e("QFV", "surface onSurfaceTextureAvailable");
    this.jdField_a_of_type_Bgrq.setSurface(new Surface(paramSurfaceTexture));
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    QMLog.e("QFV", "surface onSurfaceTextureDestroyed");
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QMLog.e("QFV", "surface onSurfaceTextureSizeChanged");
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void operate(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      QMLog.e("QFVideoView", "operate null map");
    }
    QMLog.e("QFVideoView", "operate" + paramMap.toString());
    String str = "" + paramMap.get("type");
    try
    {
      if ("play".equals(str))
      {
        this.jdField_a_of_type_Bgrq.start();
        return;
      }
      if ("pause".equals(str))
      {
        this.jdField_a_of_type_Bgrq.pause();
        return;
      }
    }
    catch (Throwable paramMap)
    {
      QMLog.e("QFV", "", paramMap);
      return;
    }
    if ("stop".equals(str))
    {
      this.jdField_a_of_type_Bgrq.stop();
      return;
    }
    boolean bool = "seek".equals(str);
    if (bool) {
      try
      {
        int i = (int)(new JSONObject(paramMap).optDouble("time") * 1000.0D);
        this.jdField_a_of_type_Bgrq.seekTo(i);
        return;
      }
      catch (Exception localException)
      {
        QMLog.e("QFV", "wrong seek pram. " + paramMap, localException);
        return;
      }
    }
    if ("playbackRate".equals(localException))
    {
      QMLog.e("QFV", "playbackRate is not support.");
      return;
    }
    if ((!"requestFullScreen".equals(localException)) && (!"exitFullScreen".equals(localException)))
    {
      bool = "sendDanmu".equals(localException);
      if (!bool) {}
    }
  }
  
  public void update(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject = new JSONObject(paramMap);
    QMLog.e("QFVideoView", "update" + paramMap.toString());
    if (!localJSONObject.optBoolean("hide")) {
      setVisibility(0);
    }
    paramMap = localJSONObject.optString("src");
    this.jdField_a_of_type_Boolean = localJSONObject.optBoolean("autoplay", false);
    a(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.flutter.SurfaceFlutterVideoView
 * JD-Core Version:    0.7.0.1
 */