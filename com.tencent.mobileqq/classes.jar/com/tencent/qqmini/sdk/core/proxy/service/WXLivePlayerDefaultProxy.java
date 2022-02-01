package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.view.Surface;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@ProxyService(proxy=IWXLivePlayerProxy.class)
public class WXLivePlayerDefaultProxy
  implements IWXLivePlayerProxy
{
  private Object a;
  private Object b;
  private Object c;
  private String d;
  private InvocationHandler e;
  
  private void a()
  {
    try
    {
      JarReflectUtil.callSpecifiedStaticMethod("com.tencent.rtmp.TXLiveBase", "setLibraryPath", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { this.d });
      Object localObject = Class.forName("com.tencent.rtmp.ITXLiveBaseListener");
      ClassLoader localClassLoader = getClass().getClassLoader();
      InvocationHandler localInvocationHandler = this.e;
      localObject = Proxy.newProxyInstance(localClassLoader, new Class[] { localObject }, localInvocationHandler);
      JarReflectUtil.callSpecifiedStaticMethod("com.tencent.rtmp.TXLiveBase", "setListener", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ITXLiveBaseListener") }), new Object[] { localObject });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      QMLog.e("TRTCDynamicProxy", "TXLiveBase.setListener failed:", localClassNotFoundException);
    }
  }
  
  public void hookListenerAndGoOn(String paramString, InvocationHandler paramInvocationHandler)
  {
    a();
  }
  
  public void init(Context paramContext, InvocationHandler paramInvocationHandler1, InvocationHandler paramInvocationHandler2)
  {
    this.a = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePlayConfig", null, new Object[0]);
    this.b = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePlayer", JarReflectUtil.getParamsClass(new Class[] { Context.class }), new Object[] { paramContext });
    txLivePlayer_enableHardwareDecode(Boolean.valueOf(true));
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.b, "setConfig", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { this.a });
      paramContext = Class.forName("com.tencent.rtmp.ITXLivePlayListener");
      txLivePlayer_setPlayListener(Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { paramContext }, paramInvocationHandler1));
      paramContext = Class.forName("com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener");
      txLivePlayer_setAudioVolumeEvaluationListener(Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { paramContext }, paramInvocationHandler2));
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramInvocationHandler1 = new StringBuilder();
      paramInvocationHandler1.append("bind InnerTXLivePlayListenerImpl failed, e");
      paramInvocationHandler1.append(paramContext.toString());
      QMLog.e("TRTCDynamicProxy", paramInvocationHandler1.toString());
    }
  }
  
  public void initLivePlayer(Object paramObject)
  {
    this.c = paramObject;
  }
  
  public boolean needLoadAvJar()
  {
    return true;
  }
  
  public void txCloudVideoView_disableLog(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.c, "disableLog", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public void txCloudVideoView_showLog(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.c, "showLog", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public void txLivePlayConfig_setAutoAdjustCacheTime(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public void txLivePlayConfig_setCacheTime(float paramFloat)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  public void txLivePlayConfig_setEnableMetaData(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setEnableMetaData", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public void txLivePlayConfig_setMaxAutoAdjustCacheTime(float paramFloat)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setMaxAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  public void txLivePlayConfig_setMinAutoAdjustCacheTime(float paramFloat)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setMinAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  public void txLivePlay_snapshot(InvocationHandler paramInvocationHandler)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener");
      paramInvocationHandler = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { localClass }, paramInvocationHandler);
      JarReflectUtil.callSpecifiedMethod(this.b, "snapshot", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener") }), new Object[] { paramInvocationHandler });
      return;
    }
    catch (ClassNotFoundException paramInvocationHandler)
    {
      paramInvocationHandler.printStackTrace();
    }
  }
  
  public void txLivePlayer_enableAudioVolumeEvaluation(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "enableAudioVolumeEvaluation", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void txLivePlayer_enableHardwareDecode(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "enableHardwareDecode", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public boolean txLivePlayer_isPlaying()
  {
    Object localObject = JarReflectUtil.callSpecifiedMethod(this.b, "isPlaying", false, null, new Object[0]);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public void txLivePlayer_muteAudio(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "muteAudio", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public void txLivePlayer_muteVideo(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "muteVideo", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public void txLivePlayer_pause()
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "pause", false, null, new Object[0]);
  }
  
  public void txLivePlayer_resume()
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "resume", false, null, new Object[0]);
  }
  
  public void txLivePlayer_setAudioRoute(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setAudioRoute", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void txLivePlayer_setAudioVolumeEvaluationListener(Object paramObject)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.b, "setAudioVolumeEvaluationListener", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public void txLivePlayer_setConfig()
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.b, "setConfig", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { this.a });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
  
  public void txLivePlayer_setPlayListener(Object paramObject)
  {
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.b, "setPlayListener", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ITXLivePlayListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public void txLivePlayer_setPlayerView(Object paramObject)
  {
    this.c = null;
    try
    {
      JarReflectUtil.callSpecifiedMethod(this.b, "setPlayerView", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.ui.TXCloudVideoView") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public void txLivePlayer_setRenderMode(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setRenderMode", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void txLivePlayer_setRenderRotation(int paramInt)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setRenderRotation", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void txLivePlayer_setSurface(Surface paramSurface)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setSurface", false, JarReflectUtil.getParamsClass(new Class[] { Surface.class }), new Object[] { paramSurface });
  }
  
  public void txLivePlayer_setSurfaceSize(int paramInt1, int paramInt2)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "setSurfaceSize", false, JarReflectUtil.getParamsClass(new Class[] { Integer.TYPE, Integer.TYPE }), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void txLivePlayer_showDebugLog(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.b, "showDebugLog", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public int txLivePlayer_startPlay(String paramString, int paramInt)
  {
    paramString = JarReflectUtil.callSpecifiedMethod(this.b, "startPlay", false, JarReflectUtil.getParamsClass(new Class[] { String.class, Integer.TYPE }), new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramString != null) {
      return ((Integer)paramString).intValue();
    }
    return -1;
  }
  
  public int txLivePlayer_stopPlay(Boolean paramBoolean)
  {
    paramBoolean = JarReflectUtil.callSpecifiedMethod(this.b, "stopPlay", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
    if (paramBoolean != null) {
      return ((Integer)paramBoolean).intValue();
    }
    return -1;
  }
  
  public void txPlayConfig_setEnableMessage(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.a, "setEnableMessage", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.WXLivePlayerDefaultProxy
 * JD-Core Version:    0.7.0.1
 */