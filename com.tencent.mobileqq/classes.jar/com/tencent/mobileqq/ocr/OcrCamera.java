package com.tencent.mobileqq.ocr;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import com.hiar.sdk.camera.CameraParameters;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arengine.ARCloudImageSelect;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.data.OcrDpc;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.CameraUtil;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class OcrCamera
  implements Handler.Callback
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public RectF a;
  Camera.PreviewCallback jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = new OcrCamera.6(this);
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  ARCloudImageSelect jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect;
  CameraHolder jdField_a_of_type_ComTencentMobileqqCameraCameraHolder;
  OcrCamera.CameraCallback jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  volatile boolean jdField_a_of_type_Boolean = true;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  volatile boolean jdField_b_of_type_Boolean = true;
  byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  public int e;
  private boolean e;
  int jdField_f_of_type_Int = 0;
  private volatile boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public OcrCamera(Context paramContext, OcrCamera.CameraCallback paramCameraCallback, SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback = paramCameraCallback;
    this.jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceHolder;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder = CameraHolder.a();
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new OcrCamera.1(this, paramContext);
    paramContext = OcrDpc.a();
    if (paramContext != null)
    {
      this.c = paramContext.i;
      this.jdField_d_of_type_Int = (paramContext.jdField_d_of_type_Int * paramContext.jdField_e_of_type_Int);
      if (this.jdField_d_of_type_Int < 76800) {
        this.jdField_d_of_type_Int = 921600;
      }
    }
    else
    {
      this.c = 100;
      this.jdField_d_of_type_Int = 921600;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("OcrCamera mFrameGap:");
      paramContext.append(this.c);
      paramContext.append(",mMaxPreviewPixels:");
      paramContext.append(this.jdField_d_of_type_Int);
      QLog.d("Q.ocr.camera", 2, paramContext.toString());
    }
  }
  
  private int a()
  {
    try
    {
      if (QavCameraUsage.b(BaseApplicationImpl.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.camera", 2, "openCamera take up!");
        }
        return -1001;
      }
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera = CameraUtil.a();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.camera", 2, "openCamera failed!");
        }
        return -1002;
      }
      this.jdField_a_of_type_Int = CameraAbility.b();
      CameraParameters.a(this.jdField_a_of_type_AndroidHardwareCamera, 0, 0);
      int m = 90;
      if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.g)) {
        m = 270;
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(m);
      Object localObject3 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      Object localObject1 = new PixelFormat();
      m = ((Camera.Parameters)localObject3).getPreviewFormat();
      PixelFormat.getPixelFormatInfo(m, (PixelFormat)localObject1);
      Object localObject4 = a(this.jdField_a_of_type_AndroidHardwareCamera, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, false);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openCamera bestPreviewSize:");
        localStringBuilder.append(((Point)localObject4).x);
        localStringBuilder.append(",");
        localStringBuilder.append(((Point)localObject4).y);
        QLog.d("Q.ocr.camera", 2, localStringBuilder.toString());
      }
      Object localObject6;
      try
      {
        ((Camera.Parameters)localObject3).setPreviewSize(((Point)localObject4).x, ((Point)localObject4).y);
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)localObject3);
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("openInternal setCamera Params1 exp ");
        ((StringBuilder)localObject6).append(localException3.getMessage());
        QLog.d("Q.ocr.camera", 1, ((StringBuilder)localObject6).toString());
      }
      int n = this.jdField_e_of_type_Int;
      if (n == 1) {
        try
        {
          localObject5 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
          ((Camera.Parameters)localObject5).setPictureFormat(256);
          ((Camera.Parameters)localObject5).setJpegQuality(100);
          localObject6 = a(this.jdField_a_of_type_AndroidHardwareCamera, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, true);
          if ((((Point)localObject6).x >= ((Point)localObject4).x) && (((Point)localObject6).y >= ((Point)localObject4).y))
          {
            ((Camera.Parameters)localObject5).setPictureSize(((Point)localObject6).x, ((Point)localObject6).y);
            this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)localObject5);
            localObject4 = ((Camera.Parameters)localObject5).getPictureSize();
            this.i = ((Camera.Size)localObject4).width;
            this.j = ((Camera.Size)localObject4).height;
            this.jdField_g_of_type_Boolean = true;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("openInternal setCamera Params2 exp ");
          ((StringBuilder)localObject5).append(localException2.getMessage());
          QLog.d("Q.ocr.camera", 1, ((StringBuilder)localObject5).toString());
          this.jdField_g_of_type_Boolean = false;
        }
      }
      localObject3 = ((Camera.Parameters)localObject3).getPreviewSize();
      this.jdField_g_of_type_Int = ((Camera.Size)localObject3).width;
      this.h = ((Camera.Size)localObject3).height;
      this.k = m;
      this.l = ((PixelFormat)localObject1).bitsPerPixel;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openCamera picWidth:");
        ((StringBuilder)localObject1).append(this.jdField_g_of_type_Int);
        ((StringBuilder)localObject1).append(",picHeight:");
        ((StringBuilder)localObject1).append(this.h);
        ((StringBuilder)localObject1).append(",picFormat:");
        ((StringBuilder)localObject1).append(this.k);
        ((StringBuilder)localObject1).append("  mTakePicWidth:");
        ((StringBuilder)localObject1).append(this.i);
        ((StringBuilder)localObject1).append("   mTakePicHeight:");
        ((StringBuilder)localObject1).append(this.j);
        QLog.d("Q.ocr.camera", 2, ((StringBuilder)localObject1).toString());
      }
      boolean bool = b();
      if (!bool) {
        return -1003;
      }
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      return 0;
    }
    finally {}
  }
  
  private Point a(Camera paramCamera, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = paramCamera.getParameters();
    Camera.Size localSize1 = ((Camera.Parameters)localObject).getPreviewSize();
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL))) {
      return new Point(localSize1.width, localSize1.height);
    }
    paramCamera = ((Camera.Parameters)localObject).getSupportedPreviewSizes();
    if (paramBoolean) {
      paramCamera = ((Camera.Parameters)localObject).getSupportedPictureSizes();
    }
    if (paramCamera == null) {
      return new Point(localSize1.width, localSize1.height);
    }
    localObject = new ArrayList(paramCamera);
    Collections.sort((List)localObject, new OcrCamera.3(this));
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = (1.0F / 1.0F);
    int m = this.jdField_d_of_type_Int;
    if (paramBoolean) {
      m = 3686400;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize2 = (Camera.Size)((Iterator)localObject).next();
      int n = localSize2.width;
      int i1 = localSize2.height;
      int i2 = n * i1;
      if ((i2 >= 76800) && (i2 <= m) && ((n != 980) || (i1 != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((n == 1184) && (i1 == 666)) || ((n != 704) || (i1 != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
      {
        int i3 = 0;
        if (paramInt1 > paramInt2) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if (n < i1) {
          i3 = 1;
        }
        int i4;
        if (i2 == i3)
        {
          i3 = i1;
          i2 = n;
          i4 = i2;
        }
        else
        {
          i4 = i1;
          i2 = n;
          i3 = i2;
        }
        if ((i3 == paramInt1) && (i4 == paramInt2)) {
          return new Point(n, i1);
        }
        if ((i3 >= paramInt1 >> 1) && (i3 >> 1 <= paramInt1) && (i4 >= paramInt2 >> 1) && (i4 >> 1 <= paramInt2))
        {
          float f2 = Math.abs(i3 / i4 - f3);
          if (f2 <= f1)
          {
            paramCamera = new Point(n, i1);
            f1 = f2;
          }
        }
      }
    }
    if (paramCamera != null) {
      return paramCamera;
    }
    return new Point(localSize1.width, localSize1.height);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        if (QLog.isDebugVersion()) {
          ThreadManager.getUIHandler().post(new OcrCamera.4(this));
        }
        ReportController.b(null, "dc00898", "", "", "0X80082C1", "0X80082C1", 0, 0, "", "", "", "");
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect == null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect = new ARCloudImageSelect(ARCloudImageSelect.jdField_a_of_type_Int);
      }
      int m = this.jdField_f_of_type_Int;
      if (m >= 5) {
        return;
      }
      boolean bool;
      try
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.a(paramArrayOfByte, this.jdField_g_of_type_Int, this.h);
        try
        {
          this.jdField_f_of_type_Int = 0;
        }
        catch (Throwable paramArrayOfByte) {}
        this.jdField_f_of_type_Int += 1;
      }
      catch (Throwable paramArrayOfByte)
      {
        bool = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("selectImage error ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      QLog.d("Q.ocr.camera", 4, localStringBuilder.toString());
      if (bool)
      {
        long l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("select image isBest:");
        paramArrayOfByte.append(bool);
        paramArrayOfByte.append(",costTime:");
        paramArrayOfByte.append(l1);
        QLog.d("Q.ocr.camera", 4, paramArrayOfByte.toString());
        ReportController.b(null, "dc00898", "", "", "0X80082C3", "0X80082C3", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X80082C5", "0X80082C5", 0, 0, String.valueOf(l1), "", "", "");
        ThreadManager.post(new OcrCamera.5(this, l1), 5, null, false);
        if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
        {
          QLog.d("Q.ocr.camera", 1, "selectImage best but error!");
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699079, 0).a();
          return;
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = true;
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.a();
        if (paramArrayOfByte == null)
        {
          this.jdField_a_of_type_Boolean = true;
          QLog.d("Q.ocr.camera", 1, "postUploadTask imageData == null");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback.a();
        }
        paramArrayOfByte = ((IOCR)QRoute.api(IOCR.class)).savePreviewImage(paramArrayOfByte, this.jdField_g_of_type_Int, this.h, this.k, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback.a(paramArrayOfByte);
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(Camera paramCamera, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +204 -> 205
    //   4: iload_2
    //   5: ifgt +6 -> 11
    //   8: goto +197 -> 205
    //   11: iconst_0
    //   12: istore_3
    //   13: iconst_0
    //   14: istore 4
    //   16: iload_3
    //   17: iconst_5
    //   18: if_icmpge +124 -> 142
    //   21: aload_1
    //   22: iload_2
    //   23: newarray byte
    //   25: invokevirtual 497	android/hardware/Camera:addCallbackBuffer	([B)V
    //   28: iload 4
    //   30: iconst_1
    //   31: iadd
    //   32: istore 4
    //   34: goto +101 -> 135
    //   37: iload 4
    //   39: iconst_1
    //   40: if_icmple +6 -> 46
    //   43: goto +99 -> 142
    //   46: invokestatic 502	com/tencent/image/URLDrawable:clearMemoryCache	()V
    //   49: new 107	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   56: astore 5
    //   58: aload 5
    //   60: ldc_w 504
    //   63: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 5
    //   69: iload_3
    //   70: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: ldc 121
    //   76: iconst_1
    //   77: aload 5
    //   79: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: goto +50 -> 135
    //   88: astore 5
    //   90: aload 5
    //   92: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   95: new 107	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   102: astore 6
    //   104: aload 6
    //   106: ldc_w 506
    //   109: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 6
    //   115: aload 5
    //   117: invokevirtual 243	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: ldc 121
    //   126: iconst_1
    //   127: aload 6
    //   129: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: iload_3
    //   136: iconst_1
    //   137: iadd
    //   138: istore_3
    //   139: goto -123 -> 16
    //   142: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +50 -> 195
    //   148: new 107	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   155: astore_1
    //   156: aload_1
    //   157: ldc_w 508
    //   160: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_1
    //   165: iload 4
    //   167: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_1
    //   172: ldc_w 510
    //   175: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_1
    //   180: iload_2
    //   181: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: ldc 121
    //   187: iconst_2
    //   188: aload_1
    //   189: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: iload 4
    //   197: iconst_1
    //   198: if_icmple +5 -> 203
    //   201: iconst_1
    //   202: ireturn
    //   203: iconst_0
    //   204: ireturn
    //   205: ldc 121
    //   207: iconst_1
    //   208: ldc_w 512
    //   211: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: iconst_0
    //   215: ireturn
    //   216: astore 5
    //   218: goto -181 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	OcrCamera
    //   0	221	1	paramCamera	Camera
    //   0	221	2	paramInt	int
    //   12	127	3	m	int
    //   14	185	4	n	int
    //   56	22	5	localStringBuilder1	StringBuilder
    //   88	28	5	localException	Exception
    //   216	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   102	26	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   21	28	88	java/lang/Exception
    //   21	28	216	java/lang/OutOfMemoryError
  }
  
  private boolean b()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_AndroidHardwareCamera;
      boolean bool1 = true;
      if (localObject1 != null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewSurfaceHolder;
        if (localObject1 != null)
        {
          try
          {
            if (this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback != null)
            {
              int m = this.jdField_g_of_type_Int * this.h * this.l / 8;
              boolean bool2 = a(this.jdField_a_of_type_AndroidHardwareCamera, m);
              if (!bool2) {
                return false;
              }
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
            }
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
            this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
            try
            {
              f();
            }
            catch (Exception localException1)
            {
              bool1 = true;
            }
            localException2.printStackTrace();
          }
          catch (Exception localException2)
          {
            bool1 = false;
          }
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startPreview failed. error msg:");
          localStringBuilder2.append(localException2.getMessage());
          QLog.d("Q.ocr.camera", 1, localStringBuilder2.toString());
          break label175;
        }
      }
      QLog.d("Q.ocr.camera", 1, "startPreview camera is null or holder is null");
      bool1 = false;
      label175:
      if (bool1) {
        this.jdField_e_of_type_Boolean = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startPreviewInternal isSuc:");
        localStringBuilder1.append(bool1);
        QLog.d("Q.ocr.camera", 2, localStringBuilder1.toString());
      }
      return bool1;
    }
    finally {}
  }
  
  private boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    try
    {
      Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
      if (localCamera != null)
      {
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(null);
          this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
          try
          {
            this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
            g();
            bool1 = true;
          }
          catch (Exception localException1)
          {
            bool1 = true;
          }
          localStringBuilder2 = new StringBuilder();
        }
        catch (Exception localException2)
        {
          bool1 = bool2;
        }
        StringBuilder localStringBuilder2;
        localStringBuilder2.append("stopPreview failed. error msg: ");
        localStringBuilder2.append(localException2.getMessage());
        QLog.d("Q.ocr.camera", 1, localStringBuilder2.toString());
      }
      if (bool1) {
        this.jdField_e_of_type_Boolean = true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("stopPreviewInternal isSuc:");
        localStringBuilder1.append(bool1);
        QLog.d("Q.ocr.camera", 2, localStringBuilder1.toString());
      }
      return bool1;
    }
    finally {}
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    try
    {
      Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
      boolean bool1 = bool2;
      if (localCamera != null) {
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.release();
          bool1 = true;
        }
        catch (Exception localException)
        {
          this.jdField_a_of_type_AndroidHardwareCamera = null;
          this.jdField_a_of_type_AndroidViewSurfaceHolder = null;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("closeCamera failed. error msg: ");
          localStringBuilder.append(localException.getMessage());
          QLog.d("Q.ocr.camera", 1, localStringBuilder.toString());
          bool1 = bool2;
        }
      }
      this.jdField_b_of_type_ArrayOfByte = null;
      return bool1;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_e_of_type_Boolean)
      {
        e();
        b();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(0);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("open isStop:");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
      ((StringBuilder)localObject).append(",isOpen:");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      QLog.d("Q.ocr.camera", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    if (this.jdField_e_of_type_Int == 1)
    {
      this.jdField_d_of_type_Int = 2073600;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setOcrMode device model: ");
        localStringBuilder.append(DeviceInfoUtil.i());
        QLog.i("Q.ocr.camera", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void a(RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
  }
  
  public boolean a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("takePicture, isOpen:");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject).append(",mNeedSelectImage:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(",isStop:");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
      ((StringBuilder)localObject).append(",picData:");
      boolean bool;
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.ocr.camera", 2, ((StringBuilder)localObject).toString());
    }
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      QLog.d("Q.ocr.camera", 1, "takePicture but net error!");
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699079, 0).a();
      return false;
    }
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_e_of_type_Boolean) && ((this.jdField_a_of_type_Boolean) || (this.jdField_e_of_type_Int == 1)) && (this.jdField_a_of_type_ArrayOfByte != null) && (!this.jdField_f_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_AndroidHardwareCamera;
      if (localObject != null)
      {
        this.jdField_f_of_type_Boolean = true;
        if ((this.jdField_e_of_type_Int == 1) && (this.jdField_g_of_type_Boolean) && (this.i * this.j >= this.jdField_g_of_type_Int * this.h))
        {
          ((Camera)localObject).takePicture(null, null, null, new OcrCamera.7(this));
          return true;
        }
        localObject = this.jdField_b_of_type_ArrayOfByte;
        if ((localObject == null) || (localObject.length != this.jdField_a_of_type_ArrayOfByte.length)) {
          try
          {
            this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_ArrayOfByte.length];
          }
          catch (Throwable localThrowable)
          {
            QLog.e("Q.ocr.camera", 1, new Object[] { "takePicture error: ", localThrowable.getMessage() });
            this.jdField_b_of_type_ArrayOfByte = null;
          }
        }
        byte[] arrayOfByte1 = this.jdField_b_of_type_ArrayOfByte;
        if (arrayOfByte1 != null)
        {
          byte[] arrayOfByte2 = this.jdField_a_of_type_ArrayOfByte;
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
          arrayOfByte1 = this.jdField_b_of_type_ArrayOfByte;
        }
        else
        {
          arrayOfByte1 = this.jdField_a_of_type_ArrayOfByte;
        }
        a(arrayOfByte1, false);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      WeakReferenceHandler localWeakReferenceHandler = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
      if ((localWeakReferenceHandler != null) && (this.jdField_a_of_type_AndroidHardwareCamera != null))
      {
        localWeakReferenceHandler.post(new OcrCamera.8(this, paramBoolean, paramArrayOfByte));
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "startPreview");
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(2);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "stopPreview");
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(3);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "close");
    }
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void g()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 0)
    {
      boolean bool;
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            return false;
          }
          if (this.jdField_d_of_type_Boolean)
          {
            bool = d();
            if (bool) {
              this.jdField_d_of_type_Boolean = false;
            }
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback;
            if (paramMessage != null)
            {
              paramMessage.c(bool);
              return false;
            }
          }
        }
        else
        {
          bool = c();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback;
          if (paramMessage != null)
          {
            paramMessage.b(bool);
            return false;
          }
        }
      }
      else
      {
        bool = b();
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback;
        if (paramMessage != null)
        {
          paramMessage.a(bool);
          return false;
        }
      }
    }
    else if (!this.jdField_d_of_type_Boolean)
    {
      try
      {
        m = a();
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        m = -1004;
      }
      if (m == 0) {
        this.jdField_d_of_type_Boolean = true;
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqOcrOcrCamera$CameraCallback;
      if (paramMessage != null) {
        paramMessage.a(m, this.jdField_g_of_type_Int, this.h, this.k);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera
 * JD-Core Version:    0.7.0.1
 */