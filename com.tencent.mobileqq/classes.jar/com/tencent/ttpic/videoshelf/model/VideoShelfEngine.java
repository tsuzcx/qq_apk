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
  private static final String TAG = VideoShelfEngine.class.getSimpleName();
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
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mVideoShelfProcessor = new WeSeeVideoShelfProcessor();
      return;
    }
    this.mVideoShelfProcessor = new PagVideoShelfProcessor();
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
    float f5 = 0.0F;
    float f4 = 0.0F;
    float f8 = this.watermarkBmp.getWidth();
    float f7 = this.watermarkBmp.getHeight();
    if (((paramArrayOfFloat != null) && (paramArrayOfFloat.length == 0)) || (paramArrayOfFloat == null))
    {
      f5 = paramInt1 / 2 - this.watermarkBmp.getWidth() / 2;
      f4 = paramInt2 - 30.0F - this.watermarkBmp.getHeight();
    }
    float f6 = f7;
    float f3 = f8;
    float f1 = f4;
    float f2 = f5;
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length != 1) {
        break label289;
      }
      f2 = paramInt1 / 2 - this.watermarkBmp.getWidth() / 2;
      f1 = paramArrayOfFloat[0];
      f3 = f8;
      f6 = f7;
    }
    for (;;)
    {
      this.watermarkPosition[0] = (f2 / paramInt1 * 2.0F - 1.0F);
      this.watermarkPosition[1] = (f1 / paramInt2 * 2.0F - 1.0F);
      this.watermarkPosition[2] = (f2 / paramInt1 * 2.0F - 1.0F);
      this.watermarkPosition[3] = ((f1 + f6) / paramInt2 * 2.0F - 1.0F);
      this.watermarkPosition[4] = ((f2 + f3) / paramInt1 * 2.0F - 1.0F);
      this.watermarkPosition[5] = ((f6 + f1) / paramInt2 * 2.0F - 1.0F);
      this.watermarkPosition[6] = ((f3 + f2) / paramInt1 * 2.0F - 1.0F);
      this.watermarkPosition[7] = (f1 / paramInt2 * 2.0F - 1.0F);
      return this.watermarkPosition;
      label289:
      if (paramArrayOfFloat.length == 2)
      {
        f2 = paramArrayOfFloat[0];
        f1 = paramArrayOfFloat[1];
        f6 = f7;
        f3 = f8;
      }
      else if (paramArrayOfFloat.length == 3)
      {
        f2 = paramArrayOfFloat[0];
        f1 = paramArrayOfFloat[1];
        f3 = paramArrayOfFloat[2];
        f6 = f7;
      }
      else
      {
        f6 = f7;
        f3 = f8;
        f1 = f4;
        f2 = f5;
        if (paramArrayOfFloat.length >= 4)
        {
          f2 = paramArrayOfFloat[0];
          f1 = paramArrayOfFloat[1];
          f3 = paramArrayOfFloat[2];
          f6 = paramArrayOfFloat[3];
        }
      }
    }
  }
  
  private int decodeFrame()
  {
    if (this.mVideoShelfProcessor != null) {
      return this.mVideoShelfProcessor.parseFrame();
    }
    return -3;
  }
  
  private void draw()
  {
    if (this.mVideoShelfProcessor != null) {}
    for (Frame localFrame = this.mVideoShelfProcessor.draw();; localFrame = null)
    {
      this.encodeFrame = localFrame;
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
  }
  
  private void encodeFrame()
  {
    if (this.encodeFrame == null) {}
    do
    {
      do
      {
        return;
      } while (this.mVideoShelfProcessor == null);
      this.mVideoEncoder.writeFrame(this.encodeFrame.getTextureId(), this.mVideoShelfProcessor.getCurFrameTimeStamp());
    } while (this.mCallback == null);
    int i = this.mVideoShelfProcessor.getProgress();
    this.mCallback.onProgress(i);
  }
  
  private void stop()
  {
    if (this.mVideoShelfProcessor != null) {
      this.mVideoShelfProcessor.clear();
    }
    if (this.mVideoEncoder != null) {
      this.mVideoEncoder.release();
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
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = this.decodeTexture;
      arrayOfInt[1] = this.encodeTexture;
      GLES20.glDeleteBuffers(arrayOfInt.length, arrayOfInt, 0);
      if (this.mHandler != null)
      {
        this.mHandler.sendEmptyMessage(106);
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
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(108);
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
    if (this.mVideoShelfProcessor != null) {
      this.mVideoShelfProcessor.init(arrayOfInt, this.mVideoFrameItemList, this.mNodeGroupList);
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
    if (this.mVideoShelfProcessor != null) {
      this.mVideoShelfProcessor.setParam("outVideoWidthHeight", new int[] { this.canvasW, this.canvasH });
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
    if ((this.mVideoShelfProcessor instanceof WeSeeVideoShelfProcessor)) {
      this.mVideoShelfProcessor.setParam("WeSeeVideoShelfProcessor_2", paramString);
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
    if (this.mVideoShelfProcessor != null) {
      this.mVideoShelfProcessor.setParam(paramString, paramObject);
    }
  }
  
  public void setSrcPath(String paramString)
  {
    String str = "WeSeeVideoShelfProcessor_1";
    if ((this.mVideoShelfProcessor instanceof PagVideoShelfProcessor)) {
      str = "PagVideoShelfProcessor_0";
    }
    this.mVideoShelfProcessor.setParam(str, paramString);
  }
  
  public void setVideoFrameItemList(List<VideoFrameItem> paramList)
  {
    this.mVideoFrameItemList = paramList;
  }
  
  public void setVideoTemplateType(int paramInt)
  {
    if ((this.mVideoShelfProcessor instanceof WeSeeVideoShelfProcessor)) {
      this.mVideoShelfProcessor.setParam("WeSeeVideoShelfProcessor_3", Integer.valueOf(paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.VideoShelfEngine
 * JD-Core Version:    0.7.0.1
 */