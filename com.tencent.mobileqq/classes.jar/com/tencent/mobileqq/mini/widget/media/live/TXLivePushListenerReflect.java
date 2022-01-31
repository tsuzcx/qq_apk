package com.tencent.mobileqq.mini.widget.media.live;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Proxy;

public class TXLivePushListenerReflect
{
  public static final String ITXLIVE_PUSHER_LISTENER_CLASS_NAME = "com.tencent.rtmp.ITXLivePushListener";
  public static final String ITXSNAP_SHOT_LISTENER_CLASS_NAME = "com.tencent.rtmp.TXLivePusher$ITXSnapshotListener";
  public static final String ON_BGM_NOTIFY_CLASS_NAME = "com.tencent.rtmp.TXLivePusher$OnBGMNotify";
  private static final String TAG = "TXLivePushListenerRefle";
  
  public static Object newITXLivePushListener(TXLivePushListenerReflect.ITXLivePushListener paramITXLivePushListener)
  {
    try
    {
      ClassLoader localClassLoader = TXLiveConstantsReflect.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.ITXLivePushListener");
      paramITXLivePushListener = new TXLivePushListenerReflect.TXLivePushListenerInvocationHandler(paramITXLivePushListener);
      paramITXLivePushListener = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, paramITXLivePushListener);
      return paramITXLivePushListener;
    }
    catch (ClassNotFoundException paramITXLivePushListener)
    {
      QLog.e("TXLivePushListenerRefle", 1, "newInstance", paramITXLivePushListener);
    }
    return null;
  }
  
  public static Object newITXSnapshotListener(TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener)
  {
    try
    {
      ClassLoader localClassLoader = TXLiveConstantsReflect.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePusher$ITXSnapshotListener");
      paramITXSnapshotListener = new TXLivePushListenerReflect.ITXSnapshotListenerInvocationHandler(paramITXSnapshotListener);
      paramITXSnapshotListener = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, paramITXSnapshotListener);
      return paramITXSnapshotListener;
    }
    catch (ClassNotFoundException paramITXSnapshotListener)
    {
      QLog.e("TXLivePushListenerRefle", 1, "newInstance", paramITXSnapshotListener);
    }
    return null;
  }
  
  public static Object newOnBGMNotify(TXLivePushListenerReflect.OnBGMNotify paramOnBGMNotify)
  {
    try
    {
      ClassLoader localClassLoader = TXLiveConstantsReflect.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePusher$OnBGMNotify");
      paramOnBGMNotify = new TXLivePushListenerReflect.OnBGMNotifyInvocationHandler(paramOnBGMNotify);
      paramOnBGMNotify = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, paramOnBGMNotify);
      return paramOnBGMNotify;
    }
    catch (ClassNotFoundException paramOnBGMNotify)
    {
      QLog.e("TXLivePushListenerRefle", 1, "newInstance", paramOnBGMNotify);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.live.TXLivePushListenerReflect
 * JD-Core Version:    0.7.0.1
 */