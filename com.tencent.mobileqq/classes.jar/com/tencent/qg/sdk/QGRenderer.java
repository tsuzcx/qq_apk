package com.tencent.qg.sdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qg.sdk.audio.MediaPlayerPool;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class QGRenderer
  implements QGJavaScriptView.Renderer
{
  private static String TAG = "QGRenderer";
  public static AssetManager assetManager;
  public static String dataBundle;
  public static String extResPath;
  private QGRenderer.QGEventListener QGEventListener = null;
  Bitmap inBitmap;
  private Context mContext;
  ByteBuffer mPixelBuf;
  private QGGLSurfaceView parent;
  private int screen_height;
  private int screen_width;
  private int tempFBO = -1;
  
  public QGRenderer(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (dataBundle = "/data/data/" + paramContext.getPackageName() + "/cache";; dataBundle = paramString)
    {
      assetManager = paramContext.getResources().getAssets();
      this.mContext = paramContext;
      this.screen_width = paramInt1;
      this.screen_height = paramInt2;
      return;
    }
  }
  
  private native void nativeChanged(int paramInt1, int paramInt2);
  
  private native void nativeCreated(Context paramContext, AssetManager paramAssetManager, String paramString, int paramInt1, int paramInt2);
  
  public static native int nativeGetQGSubVersion();
  
  public static native int nativeGetQGVersion();
  
  private native void nativeRender();
  
  private void onCanvasCreated()
  {
    if (this.QGEventListener != null) {
      this.QGEventListener.onCanvasCreated();
    }
  }
  
  public void checkTexture(int paramInt)
  {
    this.mPixelBuf.rewind();
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = -1;
    GLES20.glGetIntegerv(36006, arrayOfInt1, 0);
    if (this.tempFBO == -1)
    {
      int[] arrayOfInt2 = new int[1];
      arrayOfInt2[0] = -1;
      GLES20.glGenFramebuffers(1, arrayOfInt2, 0);
      this.tempFBO = arrayOfInt2[0];
    }
    GLES20.glBindFramebuffer(36160, this.tempFBO);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    GLES20.glReadPixels(0, 0, this.screen_width, this.screen_height, 6408, 5121, this.mPixelBuf);
    GLES20.glBindFramebuffer(36160, arrayOfInt1[0]);
    if (GLES20.glGetError() == 0) {
      this.inBitmap.copyPixelsFromBuffer(this.mPixelBuf);
    }
  }
  
  public native void clearCache();
  
  public native void nativeAddJavaScriptFile(String paramString);
  
  public native void nativeAddJavaScriptFileFromSDCard(String paramString);
  
  public native void nativeFinalize();
  
  public native int[] nativeGetFaceCanvasTexture();
  
  public native String nativeGetQGBuildTimeStamp();
  
  public native int nativeGetSharedTexture(String paramString);
  
  public native void nativeLoadJavaScriptFile(String paramString);
  
  public native void nativeLoadJavaScriptFileFromSDCard(String paramString);
  
  public native void nativeLoadOpenDataJavaScriptFile(String paramString);
  
  public native void nativeOnKeyDown(int paramInt);
  
  public native void nativeOnKeyUp(int paramInt);
  
  public native void nativeOnSensorChanged(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public native void nativePause();
  
  public native void nativeReset();
  
  public native void nativeResume();
  
  public native void nativeSetJavaReflection(String paramString1, String paramString2);
  
  public native void nativeTouch(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void onDrawFrame(GL10 paramGL10)
  {
    nativeRender();
    if (this.QGEventListener != null) {
      this.QGEventListener.onDrawFrame();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    nativeChanged(paramInt1, paramInt2);
    this.screen_width = paramInt1;
    this.screen_height = paramInt2;
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    nativeCreated(this.mContext, assetManager, dataBundle, this.screen_width, this.screen_height);
    onCanvasCreated();
  }
  
  public void onSurfaceDestroy(GL10 paramGL10)
  {
    MediaPlayerPool.getInstance().releaseAll();
    nativeFinalize();
  }
  
  public void onSurfacePause(GL10 paramGL10)
  {
    Log.d(TAG, "onSurfacePause");
    MediaPlayerPool.getInstance().releaseAll();
  }
  
  public void presentRenderbuffer()
  {
    this.parent.presentRenderbuffer();
  }
  
  public void reset()
  {
    nativeReset();
  }
  
  public native void setExtResPath(String paramString);
  
  public native void setLimitFrame(int paramInt);
  
  public void setOnCanvasCreatedListener(QGRenderer.QGEventListener paramQGEventListener)
  {
    this.QGEventListener = paramQGEventListener;
  }
  
  public native void setOpenDataJsFile(String paramString);
  
  public void setParent(QGGLSurfaceView paramQGGLSurfaceView)
  {
    this.parent = paramQGGLSurfaceView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.QGRenderer
 * JD-Core Version:    0.7.0.1
 */