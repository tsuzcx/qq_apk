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
  private int A;
  private boolean B;
  private boolean C;
  private volatile boolean D;
  private boolean E = true;
  private long F;
  SurfaceHolder a;
  WeakReferenceHandler b;
  OcrCamera.CameraCallback c;
  CameraHolder d;
  int e;
  int f;
  ARCloudImageSelect g;
  volatile boolean h = true;
  volatile boolean i = true;
  OrientationEventListener j;
  byte[] k;
  int l;
  int m;
  boolean n;
  public int o = 0;
  int p = 0;
  Camera.PreviewCallback q = new OcrCamera.6(this);
  public RectF r;
  byte[] s;
  private long t;
  private Camera u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public OcrCamera(Context paramContext, OcrCamera.CameraCallback paramCameraCallback, SurfaceHolder paramSurfaceHolder)
  {
    this.c = paramCameraCallback;
    this.a = paramSurfaceHolder;
    this.b = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.d = CameraHolder.a();
    this.j = new OcrCamera.1(this, paramContext);
    paramContext = OcrDpc.b();
    if (paramContext != null)
    {
      this.l = paramContext.k;
      this.m = (paramContext.f * paramContext.g);
      if (this.m < 76800) {
        this.m = 921600;
      }
    }
    else
    {
      this.l = 100;
      this.m = 921600;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("OcrCamera mFrameGap:");
      paramContext.append(this.l);
      paramContext.append(",mMaxPreviewPixels:");
      paramContext.append(this.m);
      QLog.d("Q.ocr.camera", 2, paramContext.toString());
    }
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
    int i1 = this.m;
    if (paramBoolean) {
      i1 = 3686400;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize2 = (Camera.Size)((Iterator)localObject).next();
      int i2 = localSize2.width;
      int i3 = localSize2.height;
      int i4 = i2 * i3;
      if ((i4 >= 76800) && (i4 <= i1) && ((i2 != 980) || (i3 != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((i2 == 1184) && (i3 == 666)) || ((i2 != 704) || (i3 != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
      {
        int i5 = 0;
        if (paramInt1 > paramInt2) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        if (i2 < i3) {
          i5 = 1;
        }
        int i6;
        if (i4 == i5)
        {
          i5 = i3;
          i4 = i2;
          i6 = i4;
        }
        else
        {
          i6 = i3;
          i4 = i2;
          i5 = i4;
        }
        if ((i5 == paramInt1) && (i6 == paramInt2)) {
          return new Point(i2, i3);
        }
        if ((i5 >= paramInt1 >> 1) && (i5 >> 1 <= paramInt1) && (i6 >= paramInt2 >> 1) && (i6 >> 1 <= paramInt2))
        {
          float f2 = Math.abs(i5 / i6 - f3);
          if (f2 <= f1)
          {
            paramCamera = new Point(i2, i3);
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
      if (this.i)
      {
        this.i = false;
        if (QLog.isDebugVersion()) {
          ThreadManager.getUIHandler().post(new OcrCamera.4(this));
        }
        ReportController.b(null, "dc00898", "", "", "0X80082C1", "0X80082C1", 0, 0, "", "", "", "");
        this.F = System.currentTimeMillis();
      }
      if (this.g == null) {
        this.g = new ARCloudImageSelect(ARCloudImageSelect.a);
      }
      int i1 = this.p;
      if (i1 >= 5) {
        return;
      }
      boolean bool;
      try
      {
        bool = this.g.a(paramArrayOfByte, this.v, this.w);
        try
        {
          this.p = 0;
        }
        catch (Throwable paramArrayOfByte) {}
        this.p += 1;
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
        long l1 = System.currentTimeMillis() - this.F;
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
          QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131897088, 0).show();
          return;
        }
        this.h = false;
        this.i = true;
        paramArrayOfByte = this.g.a();
        if (paramArrayOfByte == null)
        {
          this.h = true;
          QLog.d("Q.ocr.camera", 1, "postUploadTask imageData == null");
          return;
        }
        if (this.c != null) {
          this.c.a();
        }
        paramArrayOfByte = ((IOCR)QRoute.api(IOCR.class)).savePreviewImage(paramArrayOfByte, this.v, this.w, this.z, this.e, this.f);
        if (this.c != null) {
          this.c.a(paramArrayOfByte);
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
    //   25: invokevirtual 399	android/hardware/Camera:addCallbackBuffer	([B)V
    //   28: iload 4
    //   30: iconst_1
    //   31: iadd
    //   32: istore 4
    //   34: goto +101 -> 135
    //   37: iload 4
    //   39: iconst_1
    //   40: if_icmple +6 -> 46
    //   43: goto +99 -> 142
    //   46: invokestatic 404	com/tencent/image/URLDrawable:clearMemoryCache	()V
    //   49: new 129	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   56: astore 5
    //   58: aload 5
    //   60: ldc_w 406
    //   63: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 5
    //   69: iload_3
    //   70: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: ldc 143
    //   76: iconst_1
    //   77: aload 5
    //   79: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: goto +50 -> 135
    //   88: astore 5
    //   90: aload 5
    //   92: invokevirtual 409	java/lang/Exception:printStackTrace	()V
    //   95: new 129	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   102: astore 6
    //   104: aload 6
    //   106: ldc_w 411
    //   109: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 6
    //   115: aload 5
    //   117: invokevirtual 412	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: ldc 143
    //   126: iconst_1
    //   127: aload 6
    //   129: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: iload_3
    //   136: iconst_1
    //   137: iadd
    //   138: istore_3
    //   139: goto -123 -> 16
    //   142: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +50 -> 195
    //   148: new 129	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   155: astore_1
    //   156: aload_1
    //   157: ldc_w 414
    //   160: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_1
    //   165: iload 4
    //   167: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_1
    //   172: ldc_w 416
    //   175: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_1
    //   180: iload_2
    //   181: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: ldc 143
    //   187: iconst_2
    //   188: aload_1
    //   189: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: iload 4
    //   197: iconst_1
    //   198: if_icmple +5 -> 203
    //   201: iconst_1
    //   202: ireturn
    //   203: iconst_0
    //   204: ireturn
    //   205: ldc 143
    //   207: iconst_1
    //   208: ldc_w 418
    //   211: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: iconst_0
    //   215: ireturn
    //   216: astore 5
    //   218: goto -181 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	OcrCamera
    //   0	221	1	paramCamera	Camera
    //   0	221	2	paramInt	int
    //   12	127	3	i1	int
    //   14	185	4	i2	int
    //   56	22	5	localStringBuilder1	StringBuilder
    //   88	28	5	localException	Exception
    //   216	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   102	26	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   21	28	88	java/lang/Exception
    //   21	28	216	java/lang/OutOfMemoryError
  }
  
  private int i()
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
        this.u = CameraUtil.a();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      if (this.u == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.camera", 2, "openCamera failed!");
        }
        return -1002;
      }
      this.e = CameraAbility.f();
      CameraParameters.a(this.u, 0, 0);
      int i1 = 90;
      if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.g)) {
        i1 = 270;
      }
      this.u.setDisplayOrientation(i1);
      Object localObject3 = this.u.getParameters();
      Object localObject1 = new PixelFormat();
      i1 = ((Camera.Parameters)localObject3).getPreviewFormat();
      PixelFormat.getPixelFormatInfo(i1, (PixelFormat)localObject1);
      Object localObject4 = a(this.u, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, false);
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
        this.u.setParameters((Camera.Parameters)localObject3);
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("openInternal setCamera Params1 exp ");
        ((StringBuilder)localObject6).append(localException3.getMessage());
        QLog.d("Q.ocr.camera", 1, ((StringBuilder)localObject6).toString());
      }
      int i2 = this.o;
      if (i2 == 1) {
        try
        {
          localObject5 = this.u.getParameters();
          ((Camera.Parameters)localObject5).setPictureFormat(256);
          ((Camera.Parameters)localObject5).setJpegQuality(100);
          localObject6 = a(this.u, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, true);
          if ((((Point)localObject6).x >= ((Point)localObject4).x) && (((Point)localObject6).y >= ((Point)localObject4).y))
          {
            ((Camera.Parameters)localObject5).setPictureSize(((Point)localObject6).x, ((Point)localObject6).y);
            this.u.setParameters((Camera.Parameters)localObject5);
            localObject4 = ((Camera.Parameters)localObject5).getPictureSize();
            this.x = ((Camera.Size)localObject4).width;
            this.y = ((Camera.Size)localObject4).height;
            this.E = true;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("openInternal setCamera Params2 exp ");
          ((StringBuilder)localObject5).append(localException2.getMessage());
          QLog.d("Q.ocr.camera", 1, ((StringBuilder)localObject5).toString());
          this.E = false;
        }
      }
      localObject3 = ((Camera.Parameters)localObject3).getPreviewSize();
      this.v = ((Camera.Size)localObject3).width;
      this.w = ((Camera.Size)localObject3).height;
      this.z = i1;
      this.A = ((PixelFormat)localObject1).bitsPerPixel;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openCamera picWidth:");
        ((StringBuilder)localObject1).append(this.v);
        ((StringBuilder)localObject1).append(",picHeight:");
        ((StringBuilder)localObject1).append(this.w);
        ((StringBuilder)localObject1).append(",picFormat:");
        ((StringBuilder)localObject1).append(this.z);
        ((StringBuilder)localObject1).append("  mTakePicWidth:");
        ((StringBuilder)localObject1).append(this.x);
        ((StringBuilder)localObject1).append("   mTakePicHeight:");
        ((StringBuilder)localObject1).append(this.y);
        QLog.d("Q.ocr.camera", 2, ((StringBuilder)localObject1).toString());
      }
      boolean bool = j();
      if (!bool) {
        return -1003;
      }
      this.j.enable();
      return 0;
    }
    finally {}
  }
  
  private boolean j()
  {
    try
    {
      Object localObject1 = this.u;
      boolean bool1 = true;
      if (localObject1 != null)
      {
        localObject1 = this.a;
        if (localObject1 != null)
        {
          try
          {
            if (this.q != null)
            {
              int i1 = this.v * this.w * this.A / 8;
              boolean bool2 = a(this.u, i1);
              if (!bool2) {
                return false;
              }
              this.u.setPreviewCallbackWithBuffer(this.q);
            }
            this.u.setPreviewDisplay(this.a);
            this.u.startPreview();
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
        this.C = false;
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
  
  private boolean k()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    try
    {
      Camera localCamera = this.u;
      if (localCamera != null)
      {
        try
        {
          this.u.setPreviewCallbackWithBuffer(null);
          this.u.stopPreview();
          try
          {
            this.j.disable();
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
        this.C = true;
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
  
  private boolean l()
  {
    boolean bool2 = false;
    try
    {
      Camera localCamera = this.u;
      boolean bool1 = bool2;
      if (localCamera != null) {
        try
        {
          this.u.release();
          bool1 = true;
        }
        catch (Exception localException)
        {
          this.u = null;
          this.a = null;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("closeCamera failed. error msg: ");
          localStringBuilder.append(localException.getMessage());
          QLog.d("Q.ocr.camera", 1, localStringBuilder.toString());
          bool1 = bool2;
        }
      }
      this.s = null;
      return bool1;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.B)
    {
      if (this.C)
      {
        e();
        b();
      }
      return;
    }
    this.b.removeMessages(0);
    Object localObject = this.b.obtainMessage(0);
    this.b.sendMessage((Message)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("open isStop:");
      ((StringBuilder)localObject).append(this.C);
      ((StringBuilder)localObject).append(",isOpen:");
      ((StringBuilder)localObject).append(this.B);
      QLog.d("Q.ocr.camera", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt)
  {
    this.o = paramInt;
    if (this.o == 1)
    {
      this.m = 2073600;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setOcrMode device model: ");
        localStringBuilder.append(DeviceInfoUtil.u());
        QLog.i("Q.ocr.camera", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void a(RectF paramRectF)
  {
    this.r = paramRectF;
  }
  
  public boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      WeakReferenceHandler localWeakReferenceHandler = this.b;
      if ((localWeakReferenceHandler != null) && (this.u != null))
      {
        localWeakReferenceHandler.post(new OcrCamera.8(this, paramBoolean, paramArrayOfByte));
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.b.removeMessages(1);
    Message localMessage = this.b.obtainMessage(1);
    this.b.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "startPreview");
    }
  }
  
  public void c()
  {
    this.b.removeMessages(2);
    Message localMessage = this.b.obtainMessage(2);
    this.b.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "stopPreview");
    }
  }
  
  public void d()
  {
    this.b.removeCallbacksAndMessages(null);
    Message localMessage = this.b.obtainMessage(3);
    this.b.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "close");
    }
  }
  
  public void e()
  {
    try
    {
      this.h = true;
      this.i = true;
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
      this.h = true;
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
      this.h = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean h()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("takePicture, isOpen:");
      ((StringBuilder)localObject).append(this.B);
      ((StringBuilder)localObject).append(",mNeedSelectImage:");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(",isStop:");
      ((StringBuilder)localObject).append(this.C);
      ((StringBuilder)localObject).append(",picData:");
      boolean bool;
      if (this.k == null) {
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
      QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131897088, 0).show();
      return false;
    }
    if ((this.B) && (!this.C) && ((this.h) || (this.o == 1)) && (this.k != null) && (!this.D))
    {
      localObject = this.u;
      if (localObject != null)
      {
        this.D = true;
        if ((this.o == 1) && (this.E) && (this.x * this.y >= this.v * this.w))
        {
          ((Camera)localObject).takePicture(null, null, null, new OcrCamera.7(this));
          return true;
        }
        localObject = this.s;
        if ((localObject == null) || (localObject.length != this.k.length)) {
          try
          {
            this.s = new byte[this.k.length];
          }
          catch (Throwable localThrowable)
          {
            QLog.e("Q.ocr.camera", 1, new Object[] { "takePicture error: ", localThrowable.getMessage() });
            this.s = null;
          }
        }
        byte[] arrayOfByte1 = this.s;
        if (arrayOfByte1 != null)
        {
          byte[] arrayOfByte2 = this.k;
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
          arrayOfByte1 = this.s;
        }
        else
        {
          arrayOfByte1 = this.k;
        }
        a(arrayOfByte1, false);
        return true;
      }
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      boolean bool;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
          if (this.B)
          {
            bool = l();
            if (bool) {
              this.B = false;
            }
            paramMessage = this.c;
            if (paramMessage != null)
            {
              paramMessage.c(bool);
              return false;
            }
          }
        }
        else
        {
          bool = k();
          paramMessage = this.c;
          if (paramMessage != null)
          {
            paramMessage.b(bool);
            return false;
          }
        }
      }
      else
      {
        bool = j();
        paramMessage = this.c;
        if (paramMessage != null)
        {
          paramMessage.a(bool);
          return false;
        }
      }
    }
    else if (!this.B)
    {
      try
      {
        i1 = i();
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        i1 = -1004;
      }
      if (i1 == 0) {
        this.B = true;
      }
      paramMessage = this.c;
      if (paramMessage != null) {
        paramMessage.a(i1, this.v, this.w, this.z);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera
 * JD-Core Version:    0.7.0.1
 */