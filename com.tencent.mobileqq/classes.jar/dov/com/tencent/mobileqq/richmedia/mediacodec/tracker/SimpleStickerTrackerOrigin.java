package dov.com.tencent.mobileqq.richmedia.mediacodec.tracker;

import android.annotation.TargetApi;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import aowd;
import aowe;
import aowf;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.util.TrackerSoLoader;
import com.tencent.qphone.base.util.QLog;
import com.tracking.sdk.TrackerManager;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUVideoFrameRender;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView.TrackerCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(19)
public class SimpleStickerTrackerOrigin
  extends BaseStickerTracker
{
  public float a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageReader jdField_a_of_type_AndroidMediaImageReader;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private GPUVideoFrameRender jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUVideoFrameRender;
  private StickerDecodePlayer jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer = new StickerDecodePlayer();
  private TrackingDecoderListener jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener = new aowd(this);
  private VideoFilterPlayView.TrackerCallback jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  public float b;
  private int jdField_b_of_type_Int;
  private List jdField_b_of_type_JavaUtilList;
  public float c;
  private int c;
  public float d;
  private int d;
  public float e;
  private int e;
  public float f;
  private int f;
  private float g = 1.0F;
  private float h;
  private float i;
  
  public SimpleStickerTrackerOrigin(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    e();
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  private void a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    TrackerStickerParam.MotionInfo localMotionInfo = new TrackerStickerParam.MotionInfo(paramBoolean, paramLong, paramFloat1 - this.jdField_e_of_type_Float, paramFloat2 - this.jdField_f_of_type_Float, paramFloat3, 0.0F);
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localMotionInfo);
  }
  
  private void a(aowf paramaowf)
  {
    long l1 = System.currentTimeMillis();
    float[] arrayOfFloat = TrackerManager.newInstance().processTrackFrame(paramaowf.jdField_a_of_type_ArrayOfByte, 2, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    if (arrayOfFloat == null) {
      return;
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "trackVideoFrame CMTgetRect  , l[0] = " + arrayOfFloat[0] + ", l[1] = " + arrayOfFloat[1] + ", l[2] = " + arrayOfFloat[1] + ", l[3] = " + arrayOfFloat[3] + ", l[6] = " + arrayOfFloat[6] + ", l[7] = " + arrayOfFloat[7] + ",track time =" + (l2 - l1) + ", valid l[8] = " + arrayOfFloat[8] + ", scale l[9] = " + arrayOfFloat[9]);
    }
    float f1 = arrayOfFloat[0] * this.g - this.h;
    float f2 = arrayOfFloat[1] * this.g - this.i;
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "trackVideoFrame centerX = " + f1 + ", centerY = " + f2 + ", imageInfo.timestamp" + paramaowf.jdField_a_of_type_Long);
    }
    int j;
    double d1;
    if (arrayOfFloat[8] == 1.0F)
    {
      j = 1;
      float f3 = arrayOfFloat[9];
      float f4 = arrayOfFloat[10];
      if (f3 <= 0.0F) {
        break label345;
      }
      d1 = 1.273239544735163D * Math.atan(f3);
      label303:
      if (j == 0) {
        break label350;
      }
      a(paramaowf.jdField_a_of_type_Long, f1, f2, (float)d1, 0.0F, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramaowf.jdField_a_of_type_ArrayOfByte);
      return;
      j = 0;
      break;
      label345:
      d1 = 1.0D;
      break label303;
      label350:
      a(paramaowf.jdField_a_of_type_Long, 0.0F, 0.0F, 1.0F, 0.0F, true);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("Story_HWVideoTrackerThread", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new aowe(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUVideoFrameRender = new GPUVideoFrameRender(this);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
      this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_JavaUtilList.size() == 0) {}
    aowf localaowf;
    do
    {
      return;
      localaowf = (aowf)this.jdField_b_of_type_JavaUtilList.remove(0);
      if (localaowf != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SimpleStickerTrackerOrigin", 2, "handleTrackingFrame ,info == null, thread id=" + Thread.currentThread().getId());
    return;
    try
    {
      a(localaowf);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SimpleStickerTrackerOrigin", 2, "handleTrackingFrame Exception");
      }
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.e();
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUVideoFrameRender != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUVideoFrameRender.a();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidMediaImageReader != null)
    {
      this.jdField_a_of_type_AndroidMediaImageReader.close();
      this.jdField_a_of_type_AndroidMediaImageReader = null;
    }
    if (this.jdField_a_of_type_AndroidViewSurface != null) {
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback = null;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_a_of_type_Float = ((this.h + paramFloat1) / this.g);
    this.jdField_b_of_type_Float = ((this.i + paramFloat2) / this.g);
    this.jdField_c_of_type_Float = (paramFloat3 / this.g);
    this.jdField_d_of_type_Float = (paramFloat4 / this.g);
    this.jdField_e_of_type_Float = paramFloat5;
    this.jdField_f_of_type_Float = paramFloat6;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_b_of_type_Int = paramInt4;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.g = TrackingUtil.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = TrackingUtil.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = TrackingUtil.c(paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "onSurfaceChanged surfaceWidth=" + paramInt3 + "surfaceHeight=" + paramInt4 + "videoWidth=" + paramInt1 + "videoHeight=" + paramInt2 + ", scaleRatio =" + this.g + ", paddingX =" + this.h + ", paddingY =" + this.i);
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUVideoFrameRender.a();
      if (localObject == null)
      {
        QLog.e("SimpleStickerTrackerOrigin", 2, "dealImageData get data null");
        return;
      }
      this.jdField_b_of_type_JavaUtilList.add(new aowf((byte[])localObject, 0, 0, paramLong));
      if (this.jdField_b_of_type_JavaUtilList.size() == 0) {
        return;
      }
      localObject = (aowf)this.jdField_b_of_type_JavaUtilList.remove(0);
      if (localObject == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("SimpleStickerTrackerOrigin", 2, "handleTrackingFrame ,info == null, thread id=" + Thread.currentThread().getId());
        return;
      }
    }
    catch (Exception localException1)
    {
      QLog.e("SimpleStickerTrackerOrigin", 2, "dealImageData get error ");
      localException1.printStackTrace();
      return;
    }
    try
    {
      a(localException1);
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SimpleStickerTrackerOrigin", 2, "handleTrackingFrame Exception");
      }
      localException2.printStackTrace();
    }
  }
  
  public void a(String paramString, VideoFilterPlayView.TrackerCallback paramTrackerCallback)
  {
    a();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback = paramTrackerCallback;
    if (FileUtils.c(paramString))
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(paramString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUVideoFrameRender.a(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUVideoFrameRender.a(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(null, false);
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a("");
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = TrackerSoLoader.a(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "initFirstFrame frameX=" + this.jdField_a_of_type_Float + ",frameY=" + this.jdField_b_of_type_Float + ",frameWidth=" + this.jdField_c_of_type_Float + ",frameHeight=" + this.jdField_d_of_type_Float + ", deltX =" + this.jdField_e_of_type_Float + ", deltY =" + this.jdField_f_of_type_Float + ", loadSuccess =" + bool);
    }
    if (!bool) {
      return false;
    }
    bool = TrackerManager.newInstance().openTrack(paramArrayOfByte, 2, 0, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_d_of_type_Float, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 1.0F);
    this.jdField_a_of_type_Boolean = bool;
    return bool;
  }
  
  public byte[] a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return new byte[paramInt];
    }
    return (byte[])this.jdField_a_of_type_JavaUtilList.remove(0);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "onSurfaceCreated ");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "surfaceDestory ");
    }
    a();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTrackerOrigin", 2, "destory ");
    }
    if (this.jdField_a_of_type_AndroidMediaImageReader != null)
    {
      this.jdField_a_of_type_AndroidMediaImageReader.close();
      this.jdField_a_of_type_AndroidMediaImageReader = null;
    }
    if (this.jdField_a_of_type_AndroidViewSurface != null) {
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleStickerTrackerOrigin
 * JD-Core Version:    0.7.0.1
 */