package com.tencent.ttpic.videoshelf.model;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.baseutils.thread.HandlerThreadTag;
import com.tencent.ttpic.video.AECoderFactory;
import com.tencent.ttpic.video.AEEncoder;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor;
import com.tencent.ttpic.videoshelf.model.processor.PagVideoShelfProcessor;
import com.tencent.ttpic.videoshelf.model.processor.WeSeeVideoShelfProcessor;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import com.tencent.view.FilterContext;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class VideoShelfEngine
{
  private static final int DECODE = 102;
  private static final int DESTROY_GLCONTEXT = 106;
  private static final int DRAW = 103;
  private static final int ENCODE = 104;
  private static final int ERR_DECODE = -1;
  private static final int INIT_GLCONTEXT = 100;
  private static final int QUIT = 107;
  private static final int REQUEST_CANCEL_SAVE = 108;
  private static final int START_SAVE = 101;
  private static final int STOP = 105;
  private static final String TAG = "VideoShelfEngine";
  public static final int VIDEO_SHELF_VERSION_PAG = 1;
  public static final int VIDEO_SHELF_VERSION_WESEE = 0;
  private int canvasH;
  private int canvasW;
  private int decodeTexture;
  private boolean enableWatermark = false;
  private Frame encodeFrame;
  private int encodeTexture;
  private ReentrantLock lock = new ReentrantLock();
  private VideoShelfEngine.Callback mCallback;
  private FilterContext mFilterContext;
  private Handler mHandler;
  private boolean mIsNotNeedFile = false;
  private Handler.Callback mMessageCallback = new VideoShelfEngine.1(this);
  private List<NodeGroup> mNodeGroupList = new ArrayList();
  private String mOutputVideo;
  private boolean mRequestCancel;
  private AEEncoder mVideoEncoder;
  private List<VideoFrameItem> mVideoFrameItemList = new ArrayList();
  private IVideoShelfProcessor mVideoShelfProcessor;
  private Bitmap watermarkBmp = null;
  private BaseFilter watermarkFilter;
  private String watermarkPath;
  private float[] watermarkPosition = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  private float[] watermarkRect = null;
  
  @Deprecated
  public VideoShelfEngine()
  {
    this(0);
  }
  
  public VideoShelfEngine(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.mVideoShelfProcessor = new PagVideoShelfProcessor();
      return;
    }
    this.mVideoShelfProcessor = new WeSeeVideoShelfProcessor();
  }
  
  public VideoShelfEngine(boolean paramBoolean)
  {
    this(1);
    this.mIsNotNeedFile = paramBoolean;
  }
  
  private float[] calcWatermarkPosition(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (!BitmapUtils.isLegal(this.watermarkBmp))
    {
      Log.e(TAG, "watermark bitmap illeagal.");
      return this.watermarkPosition;
    }
    float f8 = this.watermarkBmp.getWidth();
    float f7 = this.watermarkBmp.getHeight();
    float f4 = 0.0F;
    if (((paramArrayOfFloat != null) && (paramArrayOfFloat.length == 0)) || (paramArrayOfFloat == null))
    {
      f4 = paramInt1 / 2 - this.watermarkBmp.getWidth() / 2;
      f5 = paramInt2 - 30.0F - this.watermarkBmp.getHeight();
    }
    else
    {
      f5 = 0.0F;
    }
    float f3 = f8;
    float f6 = f7;
    float f1 = f4;
    float f2 = f5;
    if (paramArrayOfFloat != null) {
      if (paramArrayOfFloat.length == 1)
      {
        f1 = paramInt1 / 2 - this.watermarkBmp.getWidth() / 2;
        f2 = paramArrayOfFloat[0];
        f3 = f8;
        f6 = f7;
      }
      else if (paramArrayOfFloat.length == 2)
      {
        f1 = paramArrayOfFloat[0];
        f2 = paramArrayOfFloat[1];
        f3 = f8;
        f6 = f7;
      }
      else if (paramArrayOfFloat.length == 3)
      {
        f1 = paramArrayOfFloat[0];
        f2 = paramArrayOfFloat[1];
        f3 = paramArrayOfFloat[2];
        f6 = f7;
      }
      else
      {
        f3 = f8;
        f6 = f7;
        f1 = f4;
        f2 = f5;
        if (paramArrayOfFloat.length >= 4)
        {
          f1 = paramArrayOfFloat[0];
          f2 = paramArrayOfFloat[1];
          f3 = paramArrayOfFloat[2];
          f6 = paramArrayOfFloat[3];
        }
      }
    }
    paramArrayOfFloat = this.watermarkPosition;
    float f5 = paramInt1;
    f7 = f1 / f5 * 2.0F - 1.0F;
    paramArrayOfFloat[0] = f7;
    f8 = paramInt2;
    f4 = f2 / f8 * 2.0F - 1.0F;
    paramArrayOfFloat[1] = f4;
    paramArrayOfFloat[2] = f7;
    f2 = (f2 + f6) / f8 * 2.0F - 1.0F;
    paramArrayOfFloat[3] = f2;
    f1 = (f1 + f3) / f5 * 2.0F - 1.0F;
    paramArrayOfFloat[4] = f1;
    paramArrayOfFloat[5] = f2;
    paramArrayOfFloat[6] = f1;
    paramArrayOfFloat[7] = f4;
    return paramArrayOfFloat;
  }
  
  private int decodeFrame()
  {
    IVideoShelfProcessor localIVideoShelfProcessor = this.mVideoShelfProcessor;
    if (localIVideoShelfProcessor != null) {
      return localIVideoShelfProcessor.parseFrame();
    }
    return -3;
  }
  
  private void draw()
  {
    Object localObject1 = this.mVideoShelfProcessor;
    if (localObject1 != null) {
      localObject1 = ((IVideoShelfProcessor)localObject1).draw();
    } else {
      localObject1 = null;
    }
    this.encodeFrame = ((Frame)localObject1);
    this.lock.lock();
    try
    {
      if ((this.encodeFrame != null) && (this.watermarkFilter != null) && (this.enableWatermark))
      {
        int i = RendererUtils.createTexture(this.watermarkBmp);
        GlUtil.setBlendMode(true);
        this.watermarkFilter.setPositions(this.watermarkPosition);
        this.watermarkFilter.RenderProcess(i, this.encodeFrame.width, this.encodeFrame.height, -1, 0.0D, this.encodeFrame);
        GlUtil.setBlendMode(false);
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private void encodeFrame()
  {
    Frame localFrame = this.encodeFrame;
    if (localFrame == null) {
      return;
    }
    if (this.mVideoShelfProcessor != null)
    {
      this.mVideoEncoder.writeFrame(localFrame.getTextureId(), this.mVideoShelfProcessor.getCurFrameTimeStamp());
      if (this.mCallback != null)
      {
        int i = this.mVideoShelfProcessor.getProgress();
        this.mCallback.onProgress(i);
      }
    }
  }
  
  private void stop()
  {
    Object localObject1 = this.mVideoShelfProcessor;
    if (localObject1 != null) {
      ((IVideoShelfProcessor)localObject1).clear();
    }
    localObject1 = this.mVideoEncoder;
    if (localObject1 != null) {
      ((AEEncoder)localObject1).release();
    }
    this.lock.lock();
    try
    {
      if (this.watermarkFilter != null)
      {
        this.watermarkFilter.clearGLSLSelf();
        this.watermarkFilter = null;
      }
      this.lock.unlock();
      BitmapUtils.recycle(this.watermarkBmp);
      localObject1 = new int[2];
      localObject1[0] = this.decodeTexture;
      localObject1[1] = this.encodeTexture;
      GLES20.glDeleteBuffers(localObject1.length, (int[])localObject1, 0);
      localObject1 = this.mHandler;
      if (localObject1 != null)
      {
        ((Handler)localObject1).sendEmptyMessage(106);
        this.mHandler.sendEmptyMessage(107);
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void cancelSave()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(108);
    }
  }
  
  public String getOutputVideoPath()
  {
    return this.mOutputVideo;
  }
  
  public void init()
  {
    int[] arrayOfInt = new int[2];
    GlUtil.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.decodeTexture = arrayOfInt[0];
    this.encodeTexture = arrayOfInt[1];
    IVideoShelfProcessor localIVideoShelfProcessor = this.mVideoShelfProcessor;
    if (localIVideoShelfProcessor != null) {
      localIVideoShelfProcessor.init(arrayOfInt, this.mVideoFrameItemList, this.mNodeGroupList);
    }
    this.mVideoEncoder = AECoderFactory.createEncoder(this.mOutputVideo, this.canvasW, this.canvasH);
    this.watermarkFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.watermarkFilter.apply();
  }
  
  public void save(int paramInt1, int paramInt2)
  {
    this.mHandler = new Handler(HandlerThreadManager.getInstance().getHandlerThread(HandlerThreadTag.VIDEO_SHELF_SAVE).getLooper(), this.mMessageCallback);
    this.canvasW = paramInt1;
    this.canvasH = paramInt2;
    IVideoShelfProcessor localIVideoShelfProcessor = this.mVideoShelfProcessor;
    if (localIVideoShelfProcessor != null) {
      localIVideoShelfProcessor.setParam("outVideoWidthHeight", new int[] { this.canvasW, this.canvasH });
    }
    this.mHandler.sendEmptyMessage(100);
    this.mHandler.sendEmptyMessage(101);
  }
  
  public void setCallback(VideoShelfEngine.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setLutPath(String paramString)
  {
    IVideoShelfProcessor localIVideoShelfProcessor = this.mVideoShelfProcessor;
    if ((localIVideoShelfProcessor instanceof WeSeeVideoShelfProcessor)) {
      localIVideoShelfProcessor.setParam("WeSeeVideoShelfProcessor_2", paramString);
    }
  }
  
  public void setNodeGroupItemList(List<NodeGroup> paramList)
  {
    this.mNodeGroupList = paramList;
  }
  
  public void setOutputVideoPath(String paramString)
  {
    this.mOutputVideo = paramString;
  }
  
  public void setParam(String paramString, Object paramObject)
  {
    IVideoShelfProcessor localIVideoShelfProcessor = this.mVideoShelfProcessor;
    if (localIVideoShelfProcessor != null) {
      localIVideoShelfProcessor.setParam(paramString, paramObject);
    }
  }
  
  public void setSrcPath(String paramString)
  {
    String str;
    if ((this.mVideoShelfProcessor instanceof PagVideoShelfProcessor)) {
      str = "PagVideoShelfProcessor_0";
    } else {
      str = "WeSeeVideoShelfProcessor_1";
    }
    this.mVideoShelfProcessor.setParam(str, paramString);
  }
  
  public void setVideoFrameItemList(List<VideoFrameItem> paramList)
  {
    this.mVideoFrameItemList = paramList;
  }
  
  public void setVideoTemplateType(int paramInt)
  {
    IVideoShelfProcessor localIVideoShelfProcessor = this.mVideoShelfProcessor;
    if ((localIVideoShelfProcessor instanceof WeSeeVideoShelfProcessor)) {
      localIVideoShelfProcessor.setParam("WeSeeVideoShelfProcessor_3", Integer.valueOf(paramInt));
    }
  }
  
  public void setWatermarkEnable(boolean paramBoolean)
  {
    this.enableWatermark = paramBoolean;
  }
  
  public void setWatermarkPath(String paramString)
  {
    this.watermarkPath = paramString;
  }
  
  public void setWatermarkRect(float[] paramArrayOfFloat)
  {
    this.watermarkRect = paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.VideoShelfEngine
 * JD-Core Version:    0.7.0.1
 */