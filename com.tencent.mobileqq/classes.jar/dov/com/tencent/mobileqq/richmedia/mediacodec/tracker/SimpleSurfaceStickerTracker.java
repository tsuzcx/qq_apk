package dov.com.tencent.mobileqq.richmedia.mediacodec.tracker;

import android.annotation.TargetApi;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import anxl;
import anxm;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tracking.sdk.TrackerManager;
import dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView.TrackerCallback;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(19)
public class SimpleSurfaceStickerTracker
  extends BaseStickerTracker
{
  public float a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageReader jdField_a_of_type_AndroidMediaImageReader;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private StickerDecodePlayer jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer;
  private TrackingDecoderListener jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener;
  private VideoFilterPlayView.TrackerCallback jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback;
  private Object jdField_a_of_type_JavaLangObject;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  public float b;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  public float c;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  public float d;
  private int d;
  public float e;
  public float f;
  private float g;
  private float h;
  private float i;
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidMediaImageReader == null)
    {
      this.jdField_a_of_type_AndroidMediaImageReader = ImageReader.newInstance(paramInt1, paramInt2, 35, 10);
      this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_AndroidMediaImageReader.getSurface();
      this.jdField_a_of_type_AndroidMediaImageReader.setOnImageAvailableListener(new anxl(this), this.jdField_a_of_type_AndroidOsHandler);
    }
  }
  
  private void a(Image paramImage)
  {
    Image.Plane[] arrayOfPlane = paramImage.getPlanes();
    int j = paramImage.getWidth();
    paramImage.getHeight();
    int k = arrayOfPlane[0].getPixelStride();
    int m = arrayOfPlane[0].getRowStride();
    long l = paramImage.getTimestamp();
    try
    {
      paramImage = a(paramImage);
      if (paramImage == null)
      {
        QLog.e("SimpleSurfaceStickerTracker", 2, "dealImageData get data null");
        return;
      }
      this.jdField_b_of_type_JavaUtilList.add(new anxm(paramImage, k, m - j * k, l));
    }
    catch (Exception paramImage)
    {
      for (;;)
      {
        QLog.e("SimpleSurfaceStickerTracker", 2, "dealImageData get error ");
        paramImage.printStackTrace();
      }
    }
    paramImage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramImage);
  }
  
  private byte[] a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return new byte[paramInt];
    }
    return (byte[])this.jdField_a_of_type_JavaUtilList.remove(0);
  }
  
  private byte[] a(Image paramImage)
  {
    int j = paramImage.getFormat();
    int n = paramImage.getWidth();
    int i1 = paramImage.getHeight();
    paramImage = paramImage.getPlanes();
    byte[] arrayOfByte = a(n * i1);
    QLog.d("SimpleSurfaceStickerTracker", 2, "get data from " + paramImage.length + " planes, format=" + j);
    ByteBuffer localByteBuffer = paramImage[0].getBuffer();
    int i2 = paramImage[0].getRowStride();
    int i3 = paramImage[0].getPixelStride();
    if (QLog.isColorLevel()) {
      QLog.d("SimpleSurfaceStickerTracker", 2, "pixelStride " + i3 + " rowStride " + i2 + " buffer size " + localByteBuffer.remaining());
    }
    localByteBuffer.position(0);
    j = 0;
    int k = 0;
    if (j < i1)
    {
      if (i3 == 1)
      {
        localByteBuffer.get(arrayOfByte, k, n);
        k += n;
      }
      for (int m = n;; m = (n - 1) * i3 + 1)
      {
        if (j < i1 - 1) {
          localByteBuffer.position(localByteBuffer.position() + i2 - m);
        }
        j += 1;
        break;
      }
    }
    return arrayOfByte;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
      this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.e();
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
      QLog.d("SimpleSurfaceStickerTracker", 2, "onSurfaceChanged surfaceWidth=" + paramInt3 + "surfaceHeight=" + paramInt4 + "videoWidth=" + paramInt1 + "videoHeight=" + paramInt2 + ", scaleRatio =" + this.g + ", paddingX =" + this.h + ", paddingY =" + this.i);
    }
  }
  
  public void a(String paramString, VideoFilterPlayView.TrackerCallback paramTrackerCallback)
  {
    a();
    if (this.jdField_a_of_type_AndroidMediaImageReader == null) {
      a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_AndroidViewSurface == null) {
      this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_AndroidMediaImageReader.getSurface();
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback = paramTrackerCallback;
    if (FileUtils.c(paramString))
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(paramString);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a(this.jdField_a_of_type_AndroidViewSurface, false);
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerStickerDecodePlayer.a("");
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleSurfaceStickerTracker", 2, "initFirstFrame frameX=" + this.jdField_a_of_type_Float + ",frameY=" + this.jdField_b_of_type_Float + ",frameWidth=" + this.jdField_c_of_type_Float + ",frameHeight=" + this.jdField_d_of_type_Float + ", deltX =" + this.e + ", deltY =" + this.f);
    }
    boolean bool = TrackerManager.newInstance().openTrack(paramArrayOfByte, 2, 0, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_d_of_type_Float, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 1.0F);
    this.jdField_a_of_type_Boolean = bool;
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleSurfaceStickerTracker", 2, "onSurfaceCreated ");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleSurfaceStickerTracker", 2, "surfaceDestory ");
    }
    a();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleSurfaceStickerTracker", 2, "destory ");
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
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleSurfaceStickerTracker
 * JD-Core Version:    0.7.0.1
 */