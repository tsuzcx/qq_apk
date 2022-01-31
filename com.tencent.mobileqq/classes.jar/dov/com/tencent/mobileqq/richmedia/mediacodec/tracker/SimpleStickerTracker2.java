package dov.com.tencent.mobileqq.richmedia.mediacodec.tracker;

import android.os.HandlerThread;
import android.os.Looper;
import aowa;
import aowb;
import aowc;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.shortvideo.util.TrackerSoLoader;
import com.tencent.qphone.base.util.QLog;
import com.tracking.sdk.TrackerManager;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView.TrackerCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleStickerTracker2
  extends BaseStickerTracker
{
  public float a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("Story_HWVideoTrackerThread", 0);
  private aowc jdField_a_of_type_Aowc;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = new DecodeConfig();
  private LimitQueue jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue = new LimitQueue(7);
  private StickerDecodePlayer jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer = new StickerDecodePlayer();
  private TrackingDecoderListener jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener = new aowa(this);
  private VideoFilterPlayView.TrackerCallback jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback;
  private String jdField_a_of_type_JavaLangString;
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
  public float f;
  private float g = 1.0F;
  private float h;
  private float i;
  
  public SimpleStickerTracker2(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Aowc = new aowc(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  private void a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    TrackerStickerParam.MotionInfo localMotionInfo = new TrackerStickerParam.MotionInfo(paramBoolean, paramLong, paramFloat1 - this.e, paramFloat2 - this.f, paramFloat3, 0.0F);
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localMotionInfo);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a(localMotionInfo);
    h();
  }
  
  private void a(aowb paramaowb)
  {
    long l1 = System.currentTimeMillis();
    float[] arrayOfFloat = TrackerManager.newInstance().processTrackFrame(paramaowb.jdField_a_of_type_ArrayOfByte, 3, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTracker2", 2, "trackVideoFrame CMTgetRect  , l[0] = " + arrayOfFloat[0] + ", l[1] = " + arrayOfFloat[1] + ", l[2] = " + arrayOfFloat[1] + ", l[3] = " + arrayOfFloat[3] + ", l[6] = " + arrayOfFloat[6] + ", l[7] = " + arrayOfFloat[7] + ",track time =" + (l2 - l1) + ", valid l[8] = " + arrayOfFloat[8] + ", scale l[9] = " + arrayOfFloat[9]);
    }
    float f1 = arrayOfFloat[0] * this.g - this.h;
    float f2 = arrayOfFloat[1] * this.g - this.i;
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTracker2", 2, " trackVideoFrame centerX = " + f1 + ", centerY = " + f2 + ", imageInfo.timestamp" + paramaowb.jdField_a_of_type_Long);
    }
    int j;
    double d1;
    if (arrayOfFloat[8] == 1.0F)
    {
      j = 1;
      float f3 = arrayOfFloat[9];
      float f4 = arrayOfFloat[10];
      if (f3 <= 0.0F) {
        break label339;
      }
      d1 = 1.273239544735163D * Math.atan(f3);
      label297:
      if (j == 0) {
        break label344;
      }
      a(paramaowb.jdField_a_of_type_Long, f1, f2, (float)d1, 0.0F, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramaowb.jdField_a_of_type_ArrayOfByte);
      return;
      j = 0;
      break;
      label339:
      d1 = 1.0D;
      break label297;
      label344:
      a(paramaowb.jdField_a_of_type_Long, 0.0F, 0.0F, 1.0F, 0.0F, true);
    }
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    try
    {
      this.jdField_b_of_type_JavaUtilList.add(new aowb(paramArrayOfByte, paramLong));
      g();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e("SimpleStickerTracker2", 2, "dealImageData get error ");
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.c() != this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.b()) {}
    label77:
    label117:
    do
    {
      int k;
      TrackerStickerParam.MotionInfo localMotionInfo1;
      do
      {
        do
        {
          return;
          k = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a();
          localMotionInfo1 = (TrackerStickerParam.MotionInfo)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a(k);
          if (!localMotionInfo1.jdField_a_of_type_Boolean) {
            break;
          }
          j = 0;
          for (;;)
          {
            if (j >= k) {
              break label77;
            }
            if (((TrackerStickerParam.MotionInfo)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a(j)).jdField_a_of_type_Boolean == true) {
              break;
            }
            j += 1;
          }
          j = k + 1;
          for (;;)
          {
            if (j >= this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.b()) {
              break label117;
            }
            if (((TrackerStickerParam.MotionInfo)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a(j)).jdField_a_of_type_Boolean == true) {
              break;
            }
            j += 1;
          }
          localMotionInfo1.jdField_a_of_type_Boolean = false;
        } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.b() <= 2);
        j = k - 1;
        k += 1;
        if ((j >= 0) && (k < this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.b()))
        {
          TrackerStickerParam.MotionInfo localMotionInfo2 = (TrackerStickerParam.MotionInfo)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a(j);
          TrackerStickerParam.MotionInfo localMotionInfo3 = (TrackerStickerParam.MotionInfo)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a(k);
          localMotionInfo1.jdField_a_of_type_Float = ((localMotionInfo2.jdField_a_of_type_Float + localMotionInfo3.jdField_a_of_type_Float) / 2.0F);
          localMotionInfo1.jdField_b_of_type_Float = ((localMotionInfo2.jdField_b_of_type_Float + localMotionInfo3.jdField_b_of_type_Float) / 2.0F);
          localMotionInfo1.jdField_d_of_type_Float = ((localMotionInfo2.jdField_d_of_type_Float + localMotionInfo3.jdField_d_of_type_Float) / 2.0F);
        }
      } while (!QLog.isColorLevel());
      QLog.d("SimpleStickerTracker2", 2, "filterData fix to not lost");
      return;
      int j = 0;
      for (;;)
      {
        if (j >= k) {
          break label280;
        }
        if (!((TrackerStickerParam.MotionInfo)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a(j)).jdField_a_of_type_Boolean) {
          break;
        }
        j += 1;
      }
      j = k + 1;
      for (;;)
      {
        if (j >= this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.b()) {
          break label319;
        }
        if (!((TrackerStickerParam.MotionInfo)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a(j)).jdField_a_of_type_Boolean) {
          break;
        }
        j += 1;
      }
      localMotionInfo1.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    label280:
    label319:
    QLog.d("SimpleStickerTracker2", 2, "filterData fix to lost");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.e();
    }
    if (this.jdField_a_of_type_Aowc != null) {
      this.jdField_a_of_type_Aowc.removeCallbacksAndMessages(null);
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
    this.e = paramFloat5;
    this.f = paramFloat6;
    this.jdField_a_of_type_Boolean = false;
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
      QLog.d("SimpleStickerTracker2", 2, "onSurfaceChanged surfaceWidth=" + paramInt3 + "surfaceHeight=" + paramInt4 + "videoWidth=" + paramInt1 + "videoHeight=" + paramInt2 + ", scaleRatio =" + this.g + ", paddingX =" + this.h + ", paddingY =" + this.i);
    }
  }
  
  public void a(String paramString, VideoFilterPlayView.TrackerCallback paramTrackerCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback = paramTrackerCallback;
    if (FileUtils.c(paramString))
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(paramString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(null, true);
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a("");
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = TrackerSoLoader.a(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTracker2", 2, "initFirstFrame frameX=" + this.jdField_a_of_type_Float + ",frameY=" + this.jdField_b_of_type_Float + ",frameWidth=" + this.jdField_c_of_type_Float + ",frameHeight=" + this.jdField_d_of_type_Float + ", deltX =" + this.e + ", deltY =" + this.f + ", loadSuccess =" + bool);
    }
    if (!bool) {
      return false;
    }
    bool = TrackerManager.newInstance().openTrack(paramArrayOfByte, 2, 0, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_d_of_type_Float, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 1.0F);
    this.jdField_a_of_type_Boolean = bool;
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTracker2", 2, "onSurfaceCreated ");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTracker2", 2, "surfaceDestory ");
    }
    a();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTracker2", 2, "destory ");
    }
    if (this.jdField_a_of_type_Aowc != null) {
      this.jdField_a_of_type_Aowc.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTracker2", 2, "handle frame start");
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerLimitQueue.a();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void f()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("SimpleStickerTracker2", 2, "handle finish cos time  =" + (l1 - l2));
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(this.jdField_a_of_type_JavaUtilMap);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback.a(localHashMap);
    }
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_JavaUtilList.size() == 0) {}
    aowb localaowb;
    do
    {
      return;
      localaowb = (aowb)this.jdField_b_of_type_JavaUtilList.remove(0);
      if (localaowb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SimpleStickerTracker2", 2, "handleTrackingFrame ,info == null, thread id=" + Thread.currentThread().getId());
    return;
    try
    {
      a(localaowb);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SimpleStickerTracker2", 2, "handleTrackingFrame Exception");
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleStickerTracker2
 * JD-Core Version:    0.7.0.1
 */