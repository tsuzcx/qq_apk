package com.tencent.qgplayer.rtmpsdk.b;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.qgplayer.rtmpsdk.QGDynamicBufferConfig;
import com.tencent.qgplayer.rtmpsdk.QGLog;
import com.tencent.qgplayer.rtmpsdk.QGMediaStream;
import com.tencent.qgplayer.rtmpsdk.QGPlayerNativeManager;

public class a
  implements Handler.Callback, TextureView.SurfaceTextureListener, com.tencent.qgplayer.rtmpsdk.a.c
{
  private static volatile boolean l = e();
  private Handler a;
  private String b;
  private TextureView c;
  private com.tencent.qgplayer.rtmpsdk.a d;
  private QGDynamicBufferConfig e;
  private int f = 0;
  private int g = 0;
  private int h = 960;
  private int i = 540;
  private boolean j = false;
  private boolean k = false;
  
  public a()
  {
    QGLog.i("QGPlayer.VideoRender", "construct VideoRender");
    HandlerThread localHandlerThread = new HandlerThread("VideoRenderThread");
    localHandlerThread.start();
    this.a = new Handler(localHandlerThread.getLooper(), this);
  }
  
  private void a(final SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    if ((this.b != null) && (this.a != null))
    {
      if (d())
      {
        a(paramSurfaceTexture, paramInt1, paramInt2);
        QGLog.i("QGPlayer.VideoRender", "set surface success try count " + paramInt4);
      }
    }
    else {
      return;
    }
    if (paramInt4 < 10)
    {
      this.a.postDelayed(new Runnable()
      {
        public void run()
        {
          a.a(a.this, paramSurfaceTexture, paramInt1, paramInt2, paramInt3, paramInt4 + 1);
        }
      }, paramInt3);
      return;
    }
    this.k = true;
    QGLog.i("QGPlayer.VideoRender", "set surface failure");
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.a != null)) {
      Message.obtain(this.a, 3, paramInt1, paramInt2).sendToTarget();
    }
  }
  
  private boolean d()
  {
    return (this.c != null) && (this.c.isAvailable()) && (!TextUtils.isEmpty(this.b));
  }
  
  private static boolean e()
  {
    Object localObject2 = Build.BRAND;
    String str = Build.MODEL;
    Object localObject1 = localObject2;
    if (com.tencent.qgplayer.rtmpsdk.c.c.a((CharSequence)localObject2)) {
      localObject1 = "";
    }
    localObject2 = str;
    if (com.tencent.qgplayer.rtmpsdk.c.c.a(str)) {
      localObject2 = "";
    }
    return ("Meizu".equals(localObject1)) || ("Redmi Note 2".equals(localObject2));
  }
  
  public void a()
  {
    QGLog.i("QGPlayer.VideoRender", "VideoRender release");
    Handler localHandler;
    if (this.a != null)
    {
      localHandler = this.a;
      if (!TextUtils.isEmpty(this.b)) {
        break label59;
      }
    }
    label59:
    for (String str = "";; str = this.b)
    {
      Message.obtain(localHandler, 5, 1, 0, str).sendToTarget();
      this.a = null;
      this.j = false;
      this.k = false;
      return;
    }
  }
  
  public void a(float paramFloat)
  {
    if ((this.b != null) && (this.a != null)) {
      this.a.obtainMessage(11, Float.valueOf(paramFloat)).sendToTarget();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.d != null) {
      this.d.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QGLog.i("QGPlayer.VideoRender", "oldVideoWidth : " + this.h + " , oldVideoHeight : " + this.i + " , newVideoWidth : " + paramInt1 + " , newVideoHeight : " + paramInt2);
    if ((this.h != paramInt1) || (this.i != paramInt2))
    {
      this.h = paramInt1;
      this.i = paramInt2;
      if (this.d != null) {
        this.d.a(this.h, this.i);
      }
      if (this.a != null) {
        Message.obtain(this.a, 6, this.h, this.i).sendToTarget();
      }
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.b != null) && (this.a != null)) {
      Message.obtain(this.a, 2, paramSurfaceTexture).sendToTarget();
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.a != null) && (paramSurfaceTexture != null))
    {
      Message.obtain(this.a, 1, paramInt1, paramInt2, new Surface(paramSurfaceTexture)).sendToTarget();
      return;
    }
    QGLog.i("QGPlayer.VideoRender", "playUrl=" + this.b + ", mHandler=" + this.a + ", texture=" + paramSurfaceTexture);
  }
  
  public void a(TextureView paramTextureView)
  {
    int m = 0;
    if ((this.c == null) || (!this.c.equals(paramTextureView))) {
      m = 1;
    }
    if (m != 0)
    {
      if (this.c != null) {
        this.c.setSurfaceTextureListener(null);
      }
      this.c = paramTextureView;
      this.f = paramTextureView.getWidth();
      this.g = paramTextureView.getHeight();
      this.d = new com.tencent.qgplayer.rtmpsdk.a(this.c);
      this.d.a(this.h, this.i);
      this.d.b(this.f, this.g);
      this.c.setSurfaceTextureListener(this);
      if (d())
      {
        QGLog.i("QGPlayer.VideoRender", "setTextureView setSurface");
        a(this.c.getSurfaceTexture(), this.f, this.g);
      }
    }
  }
  
  public void a(QGDynamicBufferConfig paramQGDynamicBufferConfig)
  {
    this.e = paramQGDynamicBufferConfig;
  }
  
  public void a(String paramString)
  {
    QGLog.i("QGPlayer.VideoRender", "pause");
    this.j = true;
    if (this.a != null) {
      Message.obtain(this.a, 8, paramString).sendToTarget();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Handler localHandler;
    if ((!TextUtils.isEmpty(this.b)) && (this.a != null))
    {
      localHandler = this.a;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int m = 1;; m = 0)
    {
      Message.obtain(localHandler, 12, m, 0, this.b).sendToTarget();
      return;
    }
  }
  
  public void a(QGMediaStream[] paramArrayOfQGMediaStream, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    this.b = paramString1;
    if (this.a != null) {
      Message.obtain(this.a, 4, new a(paramArrayOfQGMediaStream, paramInt1, paramString1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramBoolean3, paramString2)).sendToTarget();
    }
    if (d())
    {
      QGLog.i("QGPlayer.VideoRender", "start setSurface");
      a(this.c.getSurfaceTexture(), this.f, this.g);
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    boolean bool = false;
    if (this.a != null)
    {
      Message.obtain(this.a, 10, paramInt, 0, paramString).sendToTarget();
      bool = true;
    }
    return bool;
  }
  
  public void b(QGDynamicBufferConfig paramQGDynamicBufferConfig)
  {
    this.e = paramQGDynamicBufferConfig;
    if ((this.e != null) && (!TextUtils.isEmpty(this.b))) {
      QGPlayerNativeManager.nativeSetBufferConfigRealTime(this.b, this.e.getFixBufferSize(), this.e.isUseDynamicBuffer(), this.e.getInitDynamicBufferSize(), this.e.getUpAdjustUnit(), this.e.getDownAdjustUnit(), this.e.getMaxDynamicBufferSize(), this.e.getMinDynamicBufferSize(), this.e.getAdjustInterval());
    }
  }
  
  public void b(String paramString)
  {
    QGLog.i("QGPlayer.VideoRender", "resume");
    if (this.a != null) {
      Message.obtain(this.a, 9, paramString).sendToTarget();
    }
    this.j = false;
  }
  
  public boolean b()
  {
    if (!TextUtils.isEmpty(this.b)) {
      return QGPlayerNativeManager.nativeIsPlaying(this.b);
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (this.a != null)
    {
      this.a.removeCallbacksAndMessages(null);
      Message.obtain(this.a, 5, 0, 0, paramString).sendToTarget();
    }
    this.b = "";
    this.j = false;
    this.k = false;
  }
  
  public boolean c()
  {
    return !TextUtils.isEmpty(this.b);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      int m;
      do
      {
        do
        {
          do
          {
            do
            {
              int n;
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        for (;;)
                        {
                          return true;
                          QGLog.i("QGPlayer.VideoRender", "VideoRender MESSAGE_SET_SURFACE");
                          if (!TextUtils.isEmpty(this.b))
                          {
                            localObject = (Surface)paramMessage.obj;
                            m = paramMessage.arg1;
                            n = paramMessage.arg2;
                            QGPlayerNativeManager.nativeSetSurface(this.b, (Surface)localObject, m, n);
                            this.k = true;
                            return true;
                            try
                            {
                              if (!TextUtils.isEmpty(this.b))
                              {
                                ((SurfaceTexture)paramMessage.obj).updateTexImage();
                                if ((!this.j) && (this.k))
                                {
                                  QGPlayerNativeManager.nativeRenderEosTexture(this.b);
                                  return true;
                                }
                              }
                            }
                            catch (Exception paramMessage)
                            {
                              QGLog.e("QGPlayer.VideoRender", "updateTexImage error");
                              QGLog.e("QGPlayer.VideoRender", paramMessage.getMessage());
                              return true;
                            }
                          }
                        }
                      } while (TextUtils.isEmpty(this.b));
                      m = paramMessage.arg1;
                      n = paramMessage.arg2;
                      QGLog.i("QGPlayer.VideoRender", "VideoRender MESSAGE_CHANGE_SURFACE_SIZE , width : " + m + " , height : " + n);
                      QGPlayerNativeManager.nativeSetSurfaceSize(this.b, m, n, l);
                      return true;
                      QGLog.i("QGPlayer.VideoRender", "VideoRender MESSAGE_STOP");
                      localObject = (String)paramMessage.obj;
                      if (!TextUtils.isEmpty((CharSequence)localObject)) {
                        QGPlayerNativeManager.nativeStop((String)localObject);
                      }
                      this.h = 960;
                      this.i = 540;
                    } while (paramMessage.arg1 != 1);
                    QGLog.i("QGPlayer.VideoRender", "VideoRender MESSAGE_STOP quit");
                    if (Build.VERSION.SDK_INT >= 18)
                    {
                      Looper.myLooper().quitSafely();
                      return true;
                    }
                    Looper.myLooper().quit();
                    return true;
                    QGLog.i("QGPlayer.VideoRender", "VideoRender MESSAGE_START");
                    paramMessage = (a)paramMessage.obj;
                  } while (paramMessage == null);
                  if (this.e != null) {
                    QGPlayerNativeManager.nativeSetBufferConfig(paramMessage.a, this.e.getFixBufferSize(), this.e.isUseDynamicBuffer(), this.e.getInitDynamicBufferSize(), this.e.getUpAdjustUnit(), this.e.getDownAdjustUnit(), this.e.getMaxDynamicBufferSize(), this.e.getMinDynamicBufferSize(), this.e.getAdjustInterval());
                  }
                  if ((paramMessage.h == null) || (paramMessage.h.length == 0)) {
                    QGPlayerNativeManager.nativeStartPlay(paramMessage.a, paramMessage.b, paramMessage.c, paramMessage.d, paramMessage.e, paramMessage.f, paramMessage.g, paramMessage.j);
                  }
                  while (this.a != null)
                  {
                    this.a.sendEmptyMessageDelayed(7, 16L);
                    return true;
                    QGPlayerNativeManager.nativeStartPlay(paramMessage.h, paramMessage.i, paramMessage.c, paramMessage.d, paramMessage.e, paramMessage.f, paramMessage.g);
                  }
                } while (TextUtils.isEmpty(this.b));
                QGLog.i("QGPlayer.VideoRender", "VideoRender MESSAGE_SET_VIDEO_SIZE");
                m = paramMessage.arg1;
                n = paramMessage.arg2;
              } while ((m <= 0) || (n <= 0));
              QGPlayerNativeManager.nativeSetVideoSize(this.b, m, n);
              return true;
              if (!this.j) {
                QGPlayerNativeManager.nativeFrameUpdate(this.b);
              }
            } while (this.a == null);
            this.a.sendEmptyMessageDelayed(7, 16L);
            return true;
            paramMessage = (String)paramMessage.obj;
          } while (TextUtils.isEmpty(paramMessage));
          QGPlayerNativeManager.nativePause(paramMessage);
          return true;
          paramMessage = (String)paramMessage.obj;
        } while (TextUtils.isEmpty(paramMessage));
        QGPlayerNativeManager.nativeResume(paramMessage);
        return true;
        localObject = (String)paramMessage.obj;
        m = paramMessage.arg1;
      } while (TextUtils.isEmpty((CharSequence)localObject));
      QGPlayerNativeManager.nativeSeek((String)localObject, m);
      return true;
    case 11: 
      float f1 = ((Float)paramMessage.obj).floatValue();
      QGPlayerNativeManager.nativeSetVolume(this.b, f1);
      return true;
    }
    Object localObject = (String)paramMessage.obj;
    if (paramMessage.arg1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      QGPlayerNativeManager.nativeSetEnableVideoFrameExtraData((String)localObject, bool);
      return true;
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QGLog.i("QGPlayer.VideoRender", "onSurfaceTextureAvailable , width : " + paramInt1 + " , height : " + paramInt2 + " , isAvailableUrlAndTexture() : " + d());
    this.f = paramInt1;
    this.g = paramInt2;
    if (this.d != null) {
      this.d.b(paramInt1, paramInt2);
    }
    if (d())
    {
      a(this.c.getSurfaceTexture(), paramInt1, paramInt2);
      return;
    }
    a(this.c.getSurfaceTexture(), paramInt1, paramInt2, 10, 0);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    QGLog.d("QGPlayer.VideoRender", "onSurfaceTextureDestroyed");
    if ((this.c != null) && (this.c.getSurfaceTexture() == paramSurfaceTexture)) {
      this.k = false;
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QGLog.i("QGPlayer.VideoRender", "onSurfaceTextureSizeChanged, oldSize = [" + this.f + ", " + this.g + "], newSize =  [" + paramInt1 + ", " + paramInt2 + "]");
    this.f = paramInt1;
    this.g = paramInt2;
    if (this.d != null) {
      this.d.b(paramInt1, paramInt2);
    }
    b(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  private static class a
  {
    String a;
    int b;
    int c;
    int d;
    boolean e;
    boolean f;
    boolean g;
    QGMediaStream[] h;
    int i;
    String j;
    
    a(QGMediaStream[] paramArrayOfQGMediaStream, int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
    {
      this.h = paramArrayOfQGMediaStream;
      this.i = paramInt1;
      this.a = paramString1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramBoolean1;
      this.f = paramBoolean2;
      this.g = paramBoolean3;
      this.j = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.b.a
 * JD-Core Version:    0.7.0.1
 */