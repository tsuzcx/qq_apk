package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class Mp4MaterialLoader
  implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener
{
  private static final int MSG_DECODER_NEXT = 0;
  private static final int MSG_DECODER_PAUSE = 3;
  private static final int MSG_DECODER_RESUME = 4;
  private static final int MSG_DECODER_START = 1;
  private static final int MSG_DECODER_STOP = 2;
  private static final String TAG = "Mp4MaterialLoader";
  private boolean mCacheAvailable = false;
  private int mCacheRef = 0;
  private Mp4MaterialLoader.DecodeHandler mDecodeHandler;
  private HWVideoDecoder mDecoder = new HWVideoDecoder();
  private GPUOESBaseFilter mEncodeGPUOESFilter;
  private Mp4MaterialLoader.EglHandlerThreadEx mHandlerThread;
  private int mHeight;
  private boolean mInited = false;
  private RenderBuffer mMaterialCache;
  private boolean mPause = false;
  private boolean mStop;
  private int mTextureID = -1;
  private Object mWaitRelease = new Object();
  private int mWidth;
  
  public int getCurrentTexture()
  {
    synchronized (this.mWaitRelease)
    {
      if ((this.mMaterialCache != null) && (this.mCacheAvailable))
      {
        this.mCacheRef += 1;
        int i = this.mMaterialCache.getTexId();
        return i;
      }
      return -1;
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(17)
  public void init(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 83
    //   3: invokestatic 89	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:createTexture	(I)I
    //   6: putfield 57	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mTextureID	I
    //   9: aload_0
    //   10: new 72	com/tencent/ttpic/openapi/filter/RenderBuffer
    //   13: dup
    //   14: iload_1
    //   15: iload_2
    //   16: ldc 90
    //   18: invokespecial 93	com/tencent/ttpic/openapi/filter/RenderBuffer:<init>	(III)V
    //   21: putfield 70	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mMaterialCache	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   24: aload_0
    //   25: getfield 95	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +9 -> 41
    //   35: aload 4
    //   37: invokevirtual 101	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx:quitSafely	()Z
    //   40: pop
    //   41: aload_0
    //   42: new 97	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx
    //   45: dup
    //   46: ldc 103
    //   48: invokestatic 109	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   51: aload_0
    //   52: invokespecial 112	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx:<init>	(Ljava/lang/String;Landroid/opengl/EGLContext;Ljava/lang/Object;)V
    //   55: putfield 95	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   58: aload_0
    //   59: getfield 95	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   62: invokevirtual 115	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx:start	()V
    //   65: aload_0
    //   66: monitorenter
    //   67: aload_0
    //   68: getfield 95	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   71: invokevirtual 118	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx:isInitSuccess	()Z
    //   74: istore_3
    //   75: iload_3
    //   76: ifne +10 -> 86
    //   79: aload_0
    //   80: ldc2_w 119
    //   83: invokevirtual 124	java/lang/Object:wait	(J)V
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_0
    //   89: new 126	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$DecodeHandler
    //   92: dup
    //   93: aload_0
    //   94: getfield 95	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHandlerThread	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx;
    //   97: invokevirtual 130	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$EglHandlerThreadEx:getLooper	()Landroid/os/Looper;
    //   100: aload_0
    //   101: getfield 55	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder;
    //   104: invokespecial 133	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$DecodeHandler:<init>	(Landroid/os/Looper;Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder;)V
    //   107: putfield 135	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mDecodeHandler	Lcom/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader$DecodeHandler;
    //   110: aload_0
    //   111: iconst_1
    //   112: putfield 50	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mInited	Z
    //   115: return
    //   116: astore 4
    //   118: aload_0
    //   119: monitorexit
    //   120: aload 4
    //   122: athrow
    //   123: astore 4
    //   125: goto -39 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	Mp4MaterialLoader
    //   0	128	1	paramInt1	int
    //   0	128	2	paramInt2	int
    //   74	2	3	bool	boolean
    //   28	8	4	localEglHandlerThreadEx	Mp4MaterialLoader.EglHandlerThreadEx
    //   116	5	4	localObject	Object
    //   123	1	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   67	75	116	finally
    //   79	86	116	finally
    //   86	88	116	finally
    //   118	120	116	finally
    //   79	86	123	java/lang/InterruptedException
  }
  
  public boolean isInited()
  {
    return this.mInited;
  }
  
  public void nextTo(long paramLong)
  {
    if (this.mDecodeHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = Long.valueOf(paramLong);
      localMessage.what = 0;
      this.mDecodeHandler.sendMessage(localMessage);
    }
  }
  
  public void onDecodeCancel() {}
  
  public void onDecodeError(int paramInt, Throwable paramThrowable) {}
  
  public void onDecodeFinish() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2) {}
  
  public void onDecodeRepeat() {}
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart() {}
  
  /* Error */
  public void onFrameAvailable(android.graphics.SurfaceTexture paramSurfaceTexture)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 175	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mStop	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 180	android/graphics/SurfaceTexture:updateTexImage	()V
    //   12: aload_0
    //   13: getfield 63	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mWaitRelease	Ljava/lang/Object;
    //   16: astore_3
    //   17: aload_3
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 59	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mCacheRef	I
    //   23: istore_2
    //   24: iload_2
    //   25: ifle +13 -> 38
    //   28: aload_0
    //   29: getfield 63	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mWaitRelease	Ljava/lang/Object;
    //   32: ldc2_w 119
    //   35: invokevirtual 124	java/lang/Object:wait	(J)V
    //   38: aload_0
    //   39: getfield 59	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mCacheRef	I
    //   42: ifne +88 -> 130
    //   45: bipush 16
    //   47: newarray float
    //   49: astore 4
    //   51: aload_1
    //   52: aload 4
    //   54: invokevirtual 184	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   57: aload_0
    //   58: getfield 186	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   61: ifnonnull +36 -> 97
    //   64: aload_0
    //   65: new 188	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter
    //   68: dup
    //   69: invokespecial 189	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:<init>	()V
    //   72: putfield 186	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   75: aload_0
    //   76: getfield 186	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   79: aload_0
    //   80: getfield 191	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mWidth	I
    //   83: aload_0
    //   84: getfield 193	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mHeight	I
    //   87: invokevirtual 196	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:onOutputSizeChanged	(II)V
    //   90: aload_0
    //   91: getfield 186	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   94: invokevirtual 198	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:init	()V
    //   97: aload_0
    //   98: getfield 70	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mMaterialCache	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   101: invokevirtual 201	com/tencent/ttpic/openapi/filter/RenderBuffer:bind	()V
    //   104: aload_0
    //   105: getfield 186	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mEncodeGPUOESFilter	Lcom/tencent/ttpic/openapi/filter/GPUOESBaseFilter;
    //   108: aload_0
    //   109: getfield 57	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mTextureID	I
    //   112: aload 4
    //   114: aconst_null
    //   115: invokevirtual 205	com/tencent/ttpic/openapi/filter/GPUOESBaseFilter:drawTexture	(I[F[F)V
    //   118: aload_0
    //   119: getfield 70	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mMaterialCache	Lcom/tencent/ttpic/openapi/filter/RenderBuffer;
    //   122: invokevirtual 208	com/tencent/ttpic/openapi/filter/RenderBuffer:unbind	()V
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 61	com/tencent/mobileqq/shortvideo/mtveffects/Mp4MaterialLoader:mCacheAvailable	Z
    //   130: aload_3
    //   131: monitorexit
    //   132: return
    //   133: astore_1
    //   134: aload_3
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: ldc 23
    //   141: ldc 210
    //   143: invokestatic 216	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_1
    //   147: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   150: return
    //   151: astore 4
    //   153: goto -115 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	Mp4MaterialLoader
    //   0	156	1	paramSurfaceTexture	android.graphics.SurfaceTexture
    //   23	2	2	i	int
    //   49	64	4	arrayOfFloat	float[]
    //   151	1	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   19	24	133	finally
    //   28	38	133	finally
    //   38	97	133	finally
    //   97	130	133	finally
    //   130	132	133	finally
    //   134	136	133	finally
    //   8	12	138	java/lang/Exception
    //   28	38	151	java/lang/InterruptedException
  }
  
  public void pause()
  {
    this.mPause = true;
    if (this.mDecodeHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 3;
      this.mDecodeHandler.sendMessage(localMessage);
    }
  }
  
  public void releaseCurrentTexture()
  {
    synchronized (this.mWaitRelease)
    {
      if (this.mMaterialCache == null) {
        return;
      }
      if (this.mCacheRef > 0)
      {
        this.mCacheRef -= 1;
        this.mWaitRelease.notifyAll();
      }
      return;
    }
  }
  
  public void resume()
  {
    if (!this.mPause) {
      return;
    }
    if (this.mDecodeHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      this.mDecodeHandler.sendMessage(localMessage);
    }
  }
  
  public void seekTo(long paramLong) {}
  
  public void start(String paramString)
  {
    this.mStop = false;
    if ((this.mDecodeHandler != null) && (!TextUtils.isEmpty(paramString)))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = new Object[] { Integer.valueOf(this.mTextureID), paramString, this };
      this.mDecodeHandler.sendMessage(localMessage);
    }
  }
  
  public void stop()
  {
    this.mStop = true;
    if (this.mDecodeHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      this.mDecodeHandler.sendMessage(localMessage);
    }
  }
  
  public void unInit()
  {
    stop();
    Object localObject = this.mHandlerThread;
    if (localObject != null)
    {
      ((Mp4MaterialLoader.EglHandlerThreadEx)localObject).quitSafely();
      this.mHandlerThread = null;
    }
    this.mDecodeHandler = null;
    this.mInited = false;
    int i = this.mTextureID;
    if (i >= 0)
    {
      GlUtil.deleteTexture(i);
      this.mTextureID = -1;
    }
    localObject = this.mMaterialCache;
    if ((localObject != null) && (((RenderBuffer)localObject).getTexId() >= 0))
    {
      GlUtil.deleteTexture(this.mMaterialCache.getTexId());
      this.mMaterialCache.destroy();
      this.mMaterialCache = null;
      this.mCacheRef = 0;
      this.mCacheAvailable = false;
    }
    localObject = this.mEncodeGPUOESFilter;
    if (localObject != null)
    {
      ((GPUOESBaseFilter)localObject).destroy();
      this.mEncodeGPUOESFilter = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.Mp4MaterialLoader
 * JD-Core Version:    0.7.0.1
 */