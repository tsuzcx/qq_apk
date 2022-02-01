package com.tencent.qqmini.sdk.core.proxy.service;

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
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private InvocationHandler jdField_a_of_type_JavaLangReflectInvocationHandler;
  private Object b;
  private Object c;
  
  private void a()
  {
    try
    {
      JarReflectUtil.callSpecifiedStaticMethod("com.tencent.rtmp.TXLiveBase", "setLibraryPath", false, JarReflectUtil.getParamsClass(new Class[] { String.class }), new Object[] { this.jdField_a_of_type_JavaLangString });
      Object localObject = Class.forName("com.tencent.rtmp.ITXLiveBaseListener");
      ClassLoader localClassLoader = getClass().getClassLoader();
      InvocationHandler localInvocationHandler = this.jdField_a_of_type_JavaLangReflectInvocationHandler;
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
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaLangReflectInvocationHandler = paramInvocationHandler;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void init(android.content.Context paramContext, InvocationHandler paramInvocationHandler1, InvocationHandler paramInvocationHandler2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokespecial 82	com/tencent/qqmini/sdk/core/proxy/service/WXLivePlayerDefaultProxy:a	()V
    //   7: ldc 2
    //   9: monitorexit
    //   10: aload_0
    //   11: ldc 84
    //   13: aconst_null
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 88	com/tencent/qqmini/sdk/utils/JarReflectUtil:creatSpecifiedObject	(Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   21: putfield 90	com/tencent/qqmini/sdk/core/proxy/service/WXLivePlayerDefaultProxy:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   24: aload_0
    //   25: ldc 92
    //   27: iconst_1
    //   28: anewarray 28	java/lang/Class
    //   31: dup
    //   32: iconst_0
    //   33: ldc 94
    //   35: aastore
    //   36: invokestatic 36	com/tencent/qqmini/sdk/utils/JarReflectUtil:getParamsClass	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 88	com/tencent/qqmini/sdk/utils/JarReflectUtil:creatSpecifiedObject	(Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   50: putfield 96	com/tencent/qqmini/sdk/core/proxy/service/WXLivePlayerDefaultProxy:b	Ljava/lang/Object;
    //   53: aload_0
    //   54: iconst_1
    //   55: invokestatic 102	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   58: invokevirtual 106	com/tencent/qqmini/sdk/core/proxy/service/WXLivePlayerDefaultProxy:txLivePlayer_enableHardwareDecode	(Ljava/lang/Boolean;)V
    //   61: aload_0
    //   62: getfield 96	com/tencent/qqmini/sdk/core/proxy/service/WXLivePlayerDefaultProxy:b	Ljava/lang/Object;
    //   65: ldc 108
    //   67: iconst_0
    //   68: iconst_1
    //   69: anewarray 28	java/lang/Class
    //   72: dup
    //   73: iconst_0
    //   74: ldc 84
    //   76: invokestatic 48	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   79: aastore
    //   80: invokestatic 36	com/tencent/qqmini/sdk/utils/JarReflectUtil:getParamsClass	([Ljava/lang/Class;)[Ljava/lang/Class;
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_0
    //   90: getfield 90	com/tencent/qqmini/sdk/core/proxy/service/WXLivePlayerDefaultProxy:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   93: aastore
    //   94: invokestatic 112	com/tencent/qqmini/sdk/utils/JarReflectUtil:callSpecifiedMethod	(Ljava/lang/Object;Ljava/lang/String;Z[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: ldc 114
    //   100: invokestatic 48	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   103: astore_1
    //   104: aload_0
    //   105: aload_0
    //   106: invokevirtual 52	java/lang/Object:getClass	()Ljava/lang/Class;
    //   109: invokevirtual 56	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   112: iconst_1
    //   113: anewarray 28	java/lang/Class
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: aastore
    //   120: aload_2
    //   121: invokestatic 64	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   124: invokevirtual 118	com/tencent/qqmini/sdk/core/proxy/service/WXLivePlayerDefaultProxy:txLivePlayer_setPlayListener	(Ljava/lang/Object;)V
    //   127: ldc 120
    //   129: invokestatic 48	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   132: astore_1
    //   133: aload_0
    //   134: aload_0
    //   135: invokevirtual 52	java/lang/Object:getClass	()Ljava/lang/Class;
    //   138: invokevirtual 56	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   141: iconst_1
    //   142: anewarray 28	java/lang/Class
    //   145: dup
    //   146: iconst_0
    //   147: aload_1
    //   148: aastore
    //   149: aload_3
    //   150: invokestatic 64	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   153: invokevirtual 123	com/tencent/qqmini/sdk/core/proxy/service/WXLivePlayerDefaultProxy:txLivePlayer_setAudioVolumeEvaluationListener	(Ljava/lang/Object;)V
    //   156: return
    //   157: astore_1
    //   158: new 125	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   165: astore_2
    //   166: aload_2
    //   167: ldc 128
    //   169: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_2
    //   174: aload_1
    //   175: invokevirtual 136	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   178: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: ldc 68
    //   184: aload_2
    //   185: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 140	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: return
    //   192: astore_1
    //   193: ldc 2
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	WXLivePlayerDefaultProxy
    //   0	198	1	paramContext	android.content.Context
    //   0	198	2	paramInvocationHandler1	InvocationHandler
    //   0	198	3	paramInvocationHandler2	InvocationHandler
    // Exception table:
    //   from	to	target	type
    //   61	156	157	java/lang/ClassNotFoundException
    //   3	10	192	finally
    //   193	196	192	finally
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
    JarReflectUtil.callSpecifiedMethod(this.jdField_a_of_type_JavaLangObject, "setAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public void txLivePlayConfig_setCacheTime(float paramFloat)
  {
    JarReflectUtil.callSpecifiedMethod(this.jdField_a_of_type_JavaLangObject, "setCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  public void txLivePlayConfig_setEnableMetaData(Boolean paramBoolean)
  {
    JarReflectUtil.callSpecifiedMethod(this.jdField_a_of_type_JavaLangObject, "setEnableMetaData", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public void txLivePlayConfig_setMaxAutoAdjustCacheTime(float paramFloat)
  {
    JarReflectUtil.callSpecifiedMethod(this.jdField_a_of_type_JavaLangObject, "setMaxAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  public void txLivePlayConfig_setMinAutoAdjustCacheTime(float paramFloat)
  {
    JarReflectUtil.callSpecifiedMethod(this.jdField_a_of_type_JavaLangObject, "setMinAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
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
      JarReflectUtil.callSpecifiedMethod(this.b, "setConfig", false, JarReflectUtil.getParamsClass(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { this.jdField_a_of_type_JavaLangObject });
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
    JarReflectUtil.callSpecifiedMethod(this.jdField_a_of_type_JavaLangObject, "setEnableMessage", false, JarReflectUtil.getParamsClass(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.WXLivePlayerDefaultProxy
 * JD-Core Version:    0.7.0.1
 */