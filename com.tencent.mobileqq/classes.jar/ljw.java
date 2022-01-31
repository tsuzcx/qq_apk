import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;

public class ljw
{
  static int jdField_a_of_type_Int;
  static ljy jdField_a_of_type_Ljy = new ljy();
  public static boolean a;
  static int jdField_b_of_type_Int = 15000;
  private static boolean jdField_f_of_type_Boolean;
  public static int k = 640;
  public static int l = 480;
  public static int m = 17;
  Context jdField_a_of_type_AndroidContentContext = null;
  private Camera.PreviewCallback jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = new ljx(this);
  Camera jdField_a_of_type_AndroidHardwareCamera = null;
  Display jdField_a_of_type_AndroidViewDisplay;
  String jdField_a_of_type_JavaLangString;
  ljz jdField_a_of_type_Ljz = null;
  lka jdField_a_of_type_Lka = new lka();
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  int e;
  public boolean e;
  int jdField_f_of_type_Int;
  int g = 0;
  int h = 0;
  int i = 0;
  int j = 0;
  
  public ljw(Context paramContext)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_c_of_type_Boolean = msf.f(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_Boolean = msf.c();
    this.jdField_e_of_type_Int = bbdh.a();
    this.jdField_a_of_type_JavaLangString = Build.MODEL;
    this.jdField_b_of_type_JavaLangString = Build.MANUFACTURER;
    jdField_a_of_type_Ljy.jdField_b_of_type_Int = -1;
    jdField_a_of_type_Ljy.jdField_c_of_type_Int = -1;
    if (QLog.isColorLevel()) {
      QLog.w("AndroidCamera", 1, "AndroidCamera, Device_Tag[" + this.jdField_b_of_type_JavaLangString + ": " + this.jdField_a_of_type_JavaLangString + "], Rom_Tag[" + Build.VERSION.INCREMENTAL + "]");
    }
  }
  
  private int a(int paramInt)
  {
    int n = ImageFormat.getBitsPerPixel(paramInt);
    float f1 = n * 1.0F / 8.0F;
    int i1 = (int)(l * k * f1);
    if (AudioHelper.e()) {
      QLog.w("AndroidCamera", 1, "getPreviewBufferSize, previewFormat[" + paramInt + "], bitpixel[" + n + "], byteNum[" + f1 + "], bufSize[" + i1 + "]");
    }
    return i1;
  }
  
  private int a(long paramLong, Camera.Parameters paramParameters)
  {
    int i1 = 16;
    for (;;)
    {
      try
      {
        localList = paramParameters.getSupportedPreviewFormats();
        if (localList == null) {
          break label539;
        }
        if (AudioHelper.e())
        {
          StringBuilder localStringBuilder = new StringBuilder("setPreviewFormat[");
          n = 0;
          if (n < localList.size())
          {
            localStringBuilder.append(localList.get(n)).append(";");
            n += 1;
            continue;
          }
          localStringBuilder.append("]");
          QLog.w("AndroidCamera", 1, localStringBuilder.toString());
        }
        bool = localList.contains(Integer.valueOf(17));
        if (!bool) {
          continue;
        }
        n = 17;
      }
      catch (Exception localException)
      {
        List localList;
        boolean bool;
        n = 0;
        continue;
        if (!AudioHelper.e()) {
          continue;
        }
        QLog.w("AndroidCamera", 1, "setPreviewFormat, default supportFormat[" + 17 + "], seq[" + paramLong + "]");
        paramParameters.setPreviewFormat(17);
        return 17;
      }
      if (n != 0)
      {
        if (AudioHelper.e()) {
          QLog.w("AndroidCamera", 1, "setPreviewFormat, supportFormat[" + n + "], seq[" + paramLong + "]");
        }
        paramParameters.setPreviewFormat(n);
        return n;
        n = i1;
        if (localList.contains(Integer.valueOf(16))) {
          continue;
        }
        if (localList.contains(Integer.valueOf(20)))
        {
          n = 20;
          continue;
        }
        if (localList.contains(Integer.valueOf(842094169)))
        {
          n = 842094169;
          continue;
        }
        if (localList.contains(Integer.valueOf(4)))
        {
          n = 4;
          continue;
        }
        if (localList.contains(Integer.valueOf(17)))
        {
          n = 17;
          continue;
        }
        n = i1;
        if (localList.contains(Integer.valueOf(16))) {
          continue;
        }
        if (localList.contains(Integer.valueOf(3)))
        {
          n = 3;
          continue;
        }
        if (localList.contains(Integer.valueOf(2)))
        {
          n = 2;
          continue;
        }
        if (localList.contains(Integer.valueOf(4)))
        {
          n = 4;
          continue;
        }
        if (localList.contains(Integer.valueOf(100)))
        {
          n = 100;
          continue;
        }
        if (localList.contains(Integer.valueOf(101)))
        {
          n = 101;
          continue;
        }
        if (localList.contains(Integer.valueOf(102)))
        {
          n = 102;
          continue;
        }
        if (localList.contains(Integer.valueOf(103)))
        {
          n = 103;
          continue;
        }
        bool = localList.contains(Integer.valueOf(104));
        if (!bool) {
          break label539;
        }
        n = 104;
      }
      label539:
      int n = 0;
    }
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_Lka.a();
    int i1;
    int i2;
    int n;
    if ((this.jdField_b_of_type_Boolean) && (a() != null)) {
      if (a(a(a().getPreviewFormat())))
      {
        i1 = 0;
        i2 = 0;
        if (i1 < lkh.a().a())
        {
          byte[] arrayOfByte = lkh.a().a(0);
          n = i2;
          if (arrayOfByte != null)
          {
            lkh.a().a(arrayOfByte, 1);
            this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(arrayOfByte);
            i2 += 1;
            n = i2;
            if (i2 < 2) {}
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
          n = 1;
        }
      }
    }
    for (;;)
    {
      QLog.w("AndroidCamera", 1, "setPreviewCallback, type[" + n + "], seq[" + paramLong + "]");
      return;
      i1 += 1;
      i2 = n;
      break;
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
      n = 2;
      continue;
      n = 3;
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, Camera.Parameters paramParameters)
  {
    int n = k;
    int i1 = l;
    try
    {
      Object localObject = paramParameters.getSupportedPreviewSizes();
      if (localObject != null)
      {
        localObject = b((List)localObject, paramInt1, paramInt2);
        if (localObject != null) {
          a("setPreviewSize_support", paramLong, ((Camera.Size)localObject).width, ((Camera.Size)localObject).height);
        }
      }
    }
    catch (Exception localException)
    {
      label55:
      break label55;
    }
    if (((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("samsung")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("GT-I9003"))) || ((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("samsung")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("GT-I9220"))) || ((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("samsung")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("GT-I7000")))) {
      a("setPreviewSize_hardcode", paramLong, 320, 240);
    }
    if (AudioHelper.e()) {
      QLog.w("AndroidCamera", 1, "setPreviewSize, in[" + paramInt1 + "x" + paramInt2 + "], before[" + n + "x" + i1 + "], final[" + k + "x" + l + "], seq[" + paramLong + "]");
    }
    paramParameters.setPreviewSize(k, l);
  }
  
  private void a(long paramLong, Camera.Parameters paramParameters, int paramInt1, int paramInt2)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    jdField_b_of_type_Int = paramInt2;
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = (int[])((List)localObject2).get(0);
      int n = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        if (AudioHelper.e()) {
          QLog.w("AndroidCamera", 1, "setPreviewRate2, Range[" + localObject2[0] + "->" + localObject2[1] + "], seq[" + paramLong + "]");
        }
        int i1 = Math.abs(localObject2[0] - jdField_b_of_type_Int) + Math.abs(localObject2[1] - jdField_b_of_type_Int);
        if (n <= i1) {
          break label277;
        }
        localObject1 = localObject2;
        n = i1;
      }
    }
    label277:
    for (;;)
    {
      break;
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "setPreviewRate2, Range[" + localObject1[0] + "->" + localObject1[1] + "], supportFormat[" + paramInt1 + "], newFps[" + paramInt2 + "], seq[" + paramLong + "]");
      }
      paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
      return;
    }
  }
  
  @TargetApi(9)
  private void a(Camera.Parameters paramParameters, int paramInt)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = (int[])((List)localObject2).get(0);
      int n = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        if (AudioHelper.e()) {
          QLog.w("AndroidCamera", 1, "setPreviewRate1, Range[" + localObject2[0] + "->" + localObject2[1] + "]");
        }
        int i1 = Math.abs(localObject2[0] - jdField_b_of_type_Int) + Math.abs(localObject2[1] - jdField_b_of_type_Int);
        if (n <= i1) {
          break label239;
        }
        localObject1 = localObject2;
        n = i1;
      }
    }
    label239:
    for (;;)
    {
      break;
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "setPreviewRate1, Range[" + localObject1[0] + "->" + localObject1[1] + "], supportFormat[" + paramInt + "]");
      }
      paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
      return;
    }
  }
  
  public static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      if ((k != paramInt1) || (l != paramInt2) || (QLog.isDevelopLevel())) {
        QLog.w("AndroidCamera", 1, "resetPreViewSize, from[" + paramString + "], src[" + k + "x" + l + "], final[" + paramInt1 + "x" + paramInt2 + "], seq[" + paramLong + "]");
      }
      k = paramInt1;
      l = paramInt2;
      return;
    }
    finally {}
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      lkh.a().a(paramInt);
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        URLDrawable.clearMemoryCache();
        try
        {
          lkh.a().a(paramInt);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e("AndroidCamera", 2, "allocateFrame failed , size:" + paramInt + ", " + localOutOfMemoryError2.getMessage());
        }
      }
    }
    return false;
  }
  
  private void b()
  {
    if ((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("meizu")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("meizu_m9"))) {
      m = 18;
    }
    while ((!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("ZTE")) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("ZTE-T U880"))) {
      return;
    }
    m = 100;
  }
  
  private void c()
  {
    int n = 0;
    this.jdField_f_of_type_Int = 0;
    try
    {
      if (this.jdField_d_of_type_Int == 0) {
        this.jdField_d_of_type_Int = a();
      }
      if (this.jdField_d_of_type_Int > 0)
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        for (;;)
        {
          if (n < this.jdField_d_of_type_Int)
          {
            Camera.getCameraInfo(n, localCameraInfo);
            int i1 = localCameraInfo.facing;
            if (i1 == 0) {}
            try
            {
              this.jdField_f_of_type_Int = n;
              n += 1;
            }
            catch (RuntimeException localRuntimeException)
            {
              for (;;)
              {
                this.jdField_f_of_type_Int = 0;
                if (AudioHelper.e()) {
                  QLog.w("AndroidCamera", 1, "findBackCameraId, RuntimeException", localRuntimeException);
                }
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "findBackCameraId, Exception", localException);
      }
    }
  }
  
  private int g()
  {
    try
    {
      int n = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
      return n;
    }
    catch (Exception localException)
    {
      QLog.w("AndroidCamera", 1, "getDisplayRotation Exception", localException);
    }
    return 0;
  }
  
  protected int a()
  {
    int n;
    if (!bbnf.h)
    {
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "GetNumberOfCamera, hardcode[" + bbnc.a().a() + "]");
      }
      n = bbnc.a().a();
    }
    do
    {
      for (;;)
      {
        return n;
        try
        {
          i1 = Camera.getNumberOfCameras();
          n = i1;
          try
          {
            if (AudioHelper.e())
            {
              QLog.w("AndroidCamera", 1, "GetNumberOfCamera, count[" + i1 + "]");
              return i1;
            }
          }
          catch (Exception localException1) {}
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i1 = 1;
          }
        }
      }
      n = i1;
    } while (!AudioHelper.e());
    QLog.w("AndroidCamera", 1, "GetNumberOfCamera, Exception", localException1);
    return i1;
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    byte b1;
    switch (paramInt)
    {
    default: 
      b1 = 0;
    }
    while (paramBoolean)
    {
      return lll.a(this.jdField_a_of_type_AndroidContentContext, true, false, b1, false) * 90;
      b1 = 0;
      continue;
      b1 = 1;
      continue;
      b1 = 2;
      continue;
      b1 = 3;
    }
    return lll.b(this.jdField_a_of_type_AndroidContentContext, true, false, b1, false) * 90;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 360 - lll.a(this.jdField_a_of_type_AndroidContentContext, true, true, (byte)0, false) * 90;
    }
    return 360 - lll.b(this.jdField_a_of_type_AndroidContentContext, true, true, (byte)0, false) * 90;
  }
  
  public Camera.Parameters a()
  {
    try
    {
      Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "GetCameraParams, Exception", localException);
      }
    }
    return null;
  }
  
  protected Camera.Size a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    double d2 = paramInt1 / paramInt2;
    Object localObject2;
    if (paramList == null)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    label33:
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - d2) <= 0.05D)
      {
        if (Math.abs(((Camera.Size)localObject2).height - paramInt2) >= d1) {
          break label205;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    label205:
    for (;;)
    {
      break label33;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      d1 = 1.7976931348623157E+308D;
      localIterator = paramList.iterator();
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Camera.Size)localIterator.next();
      if (Math.abs(paramList.height - paramInt2) < d1) {
        d1 = Math.abs(paramList.height - paramInt2);
      }
      for (;;)
      {
        localObject1 = paramList;
        break;
        paramList = (List<Camera.Size>)localObject1;
      }
    }
  }
  
  protected Camera a(long paramLong)
  {
    return b(paramLong);
  }
  
  protected ljy a(int paramInt, Camera paramCamera)
  {
    paramCamera = new ljy();
    try
    {
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(paramInt, localCameraInfo);
      paramCamera.jdField_a_of_type_Int = localCameraInfo.facing;
      paramCamera.jdField_b_of_type_Int = localCameraInfo.orientation;
      if (this.jdField_a_of_type_AndroidViewDisplay == null)
      {
        paramCamera.jdField_c_of_type_Int = -1;
        return paramCamera;
      }
      switch (g())
      {
      case 0: 
        paramCamera.jdField_c_of_type_Int = 0;
        return paramCamera;
      }
    }
    catch (Exception localException)
    {
      paramCamera.jdField_c_of_type_Int = 0;
      return paramCamera;
    }
    paramCamera.jdField_c_of_type_Int = 90;
    return paramCamera;
    paramCamera.jdField_c_of_type_Int = 180;
    return paramCamera;
    paramCamera.jdField_c_of_type_Int = 270;
    return paramCamera;
    return paramCamera;
  }
  
  public void a()
  {
    lkh.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("AndroidCamera", 2, "releasePreviewFrameBuffer");
    }
  }
  
  public void a(int paramInt)
  {
    int n = jdField_a_of_type_Ljy.jdField_c_of_type_Int;
    jdField_a_of_type_Ljy.jdField_c_of_type_Int = ((this.h + paramInt) % 360);
    if (n != jdField_a_of_type_Ljy.jdField_c_of_type_Int) {
      QLog.w("AndroidCamera", 1, "setMobileRotation, rotation[" + n + "->" + jdField_a_of_type_Ljy.jdField_c_of_type_Int + "], CompenSateSendAngle[" + this.h + "]");
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {}
    for (;;)
    {
      return;
      synchronized (jdField_a_of_type_Ljy)
      {
        a(paramLong, this.jdField_f_of_type_Int, this.jdField_a_of_type_AndroidHardwareCamera);
        Object localObject2 = null;
      }
      int n;
      try
      {
        ??? = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (??? == null)
        {
          if (!AudioHelper.e()) {
            continue;
          }
          QLog.w("AndroidCamera", 1, "setCameraParaFPS, parameters为空");
          return;
          localObject3 = finally;
          throw localObject3;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ??? = localObject3;
          if (AudioHelper.e())
          {
            QLog.w("AndroidCamera", 1, "setCameraParaFPS, Exception", localException2);
            ??? = localObject3;
          }
        }
        n = a(paramLong, (Camera.Parameters)???);
        a(paramLong, (Camera.Parameters)???, n, paramInt);
        ((Camera.Parameters)???).set("Rotation", 180);
      }
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)???);
        label143:
        Camera.Size localSize = ((Camera.Parameters)???).getPreviewSize();
        paramInt = ((Camera.Parameters)???).getPreviewFormat();
        if (localSize != null) {
          a("setCameraParaFPS", paramLong, localSize.width, localSize.height);
        }
        for (;;)
        {
          m = paramInt;
          int[] arrayOfInt = new int[2];
          ((Camera.Parameters)???).getPreviewFpsRange(arrayOfInt);
          jdField_a_of_type_Int = (arrayOfInt[0] + arrayOfInt[1]) / 2 / 1000;
          b();
          if ((!AudioHelper.e()) && (localSize != null)) {
            break;
          }
          QLog.w("AndroidCamera", 1, "setCameraParaFPS, width[" + k + "], height[" + l + "], nInFPS[" + jdField_a_of_type_Int + "], fpsRange[" + arrayOfInt[0] + "|" + arrayOfInt[1] + "], videoFormat[" + m + "], supportFormat[" + n + "], seq[" + paramLong + "]");
          return;
          QLog.w("AndroidCamera", 1, "setCameraParaFPS, getPreviewSize fail, size[" + ((Camera.Parameters)???).get("preview-size") + "]");
        }
      }
      catch (Exception localException1)
      {
        break label143;
      }
    }
  }
  
  @TargetApi(9)
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {}
    for (;;)
    {
      return;
      synchronized (jdField_a_of_type_Ljy)
      {
        a(paramLong, this.jdField_f_of_type_Int, this.jdField_a_of_type_AndroidHardwareCamera);
        Object localObject2 = null;
      }
      try
      {
        ??? = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (??? == null)
        {
          if (!AudioHelper.e()) {
            continue;
          }
          QLog.w("AndroidCamera", 1, "setCameraPara, parameters为空");
          return;
          localObject3 = finally;
          throw localObject3;
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          ??? = localObject3;
          if (AudioHelper.e())
          {
            QLog.w("AndroidCamera", 1, "setCameraPara, Exception", localException3);
            ??? = localObject3;
          }
        }
        a((Camera.Parameters)???, a(paramLong, (Camera.Parameters)???));
        a(paramLong, paramInt1, paramInt2, (Camera.Parameters)???);
      }
    }
    try
    {
      ((Camera.Parameters)???).setRotation(180);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)???);
          label144:
          Object localObject4 = ((Camera.Parameters)???).getPreviewSize();
          int n = ((Camera.Parameters)???).getPreviewFormat();
          a("setCameraPara", paramLong, ((Camera.Size)localObject4).width, ((Camera.Size)localObject4).height);
          m = n;
          localObject4 = new int[2];
          ((Camera.Parameters)???).getPreviewFpsRange((int[])localObject4);
          jdField_a_of_type_Int = (localObject4[0] + localObject4[1]) / 2 / 1000;
          b();
          QLog.w("AndroidCamera", 1, "setCameraPara, size[" + k + "x" + l + "], src[" + paramInt1 + "x" + paramInt2 + "], nInFPS[" + jdField_a_of_type_Int + "], fpsRange[" + localObject4[0] + "~" + localObject4[1] + "], videoFormat[" + m + "], seq[" + paramLong + "]");
          return;
          localException1 = localException1;
          ((Camera.Parameters)???).set("Rotation", 180);
        }
      }
      catch (Exception localException2)
      {
        break label144;
      }
    }
  }
  
  protected void a(Camera paramCamera, int paramInt)
  {
    try
    {
      paramCamera.setDisplayOrientation(paramInt);
      return;
    }
    catch (Exception paramCamera)
    {
      while (!AudioHelper.e()) {}
      QLog.w("AndroidCamera", 1, "setDisplayOrientation, Exception", paramCamera);
    }
  }
  
  public void a(ljz paramljz)
  {
    this.jdField_a_of_type_Ljz = paramljz;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.i = (paramInt % 360);
    }
    for (;;)
    {
      lcg.c("AndroidCamera", "mFrontCameraAngle: " + this.i + ", mBackCameraAngle: " + this.j);
      return;
      this.j = (paramInt % 360);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_c_of_type_Int == 0) {}
    while (this.jdField_c_of_type_Int == 1) {
      return true;
    }
    return false;
  }
  
  protected boolean a(long paramLong)
  {
    jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidHardwareCamera = a(paramLong);
    if (this.jdField_a_of_type_AndroidHardwareCamera == null)
    {
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "openFrontCamera, fail, seq[" + paramLong + "]");
      }
      jdField_a_of_type_Boolean = false;
      jdField_f_of_type_Boolean = false;
      return false;
    }
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_d_of_type_Int = 2;
    }
    this.jdField_c_of_type_Int = 1;
    jdField_a_of_type_Boolean = true;
    jdField_f_of_type_Boolean = false;
    if (AudioHelper.e()) {
      QLog.w("AndroidCamera", 1, "openFrontCamera, success, seq[" + paramLong + "]");
    }
    return true;
  }
  
  protected boolean a(long paramLong, int paramInt, Camera paramCamera)
  {
    ljy localljy = a(paramInt, paramCamera);
    this.h = b();
    this.g = c();
    int i1 = d();
    int i2 = e();
    int i3;
    int i4;
    if (localljy.jdField_a_of_type_Int == 1)
    {
      n = (360 - (i1 + i2) % 360) % 360;
      i3 = a(this.jdField_e_of_type_Boolean);
      i4 = b(this.jdField_e_of_type_Boolean);
      if (localljy.jdField_a_of_type_Int != 1) {
        break label347;
      }
    }
    label347:
    for (int n = (n + i3) % 360;; n = (n + i4) % 360)
    {
      QLog.w("AndroidCamera", 1, "setCameraDisplayOrientation, cameraId[" + paramInt + "], orientation[" + jdField_a_of_type_Ljy.jdField_b_of_type_Int + "->" + localljy.jdField_b_of_type_Int + "], rotation[" + jdField_a_of_type_Ljy.jdField_c_of_type_Int + "->" + localljy.jdField_c_of_type_Int + "], CompenSateSendAngle[" + this.h + "], CompenSateRecvAngle[" + this.g + "], mSupportLandscape[" + this.jdField_e_of_type_Boolean + "], previewAngleForFrontCamera[" + i3 + "], previewAngleForBackCamera[" + i4 + "], cameraImageOrientation[" + i1 + "], mobileRotation[" + i2 + "], result[" + n + "], seq[" + paramLong + "]");
      a(paramCamera, n);
      jdField_a_of_type_Ljy.jdField_a_of_type_Int = localljy.jdField_a_of_type_Int;
      jdField_a_of_type_Ljy.jdField_b_of_type_Int = localljy.jdField_b_of_type_Int;
      return true;
      n = (i1 - i2 + 360) % 360;
      break;
    }
  }
  
  @TargetApi(11)
  public boolean a(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    boolean bool2 = true;
    label154:
    label321:
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        QLog.w("AndroidCamera", 1, "openCamera begin, Camera[" + toString() + "], PreViewSize[" + k + "x" + l + "], seq[" + paramLong + "]");
        if (jdField_a_of_type_Boolean)
        {
          bool1 = true;
          jdField_a_of_type_Boolean = bool1;
          QLog.w("AndroidCamera", 1, "openCamera end, result[" + bool1 + "], Camera[" + toString() + "], seq[" + paramLong + "]");
          if (!bool1) {
            break label563;
          }
          lkj.a(BaseApplicationImpl.getContext(), "openCamera");
          return bool1;
        }
        if (this.jdField_a_of_type_AndroidContentContext == null)
        {
          QLog.w("AndroidCamera", 1, "openCamera, context为空, seq[" + paramLong + "]");
          bool1 = false;
          continue;
        }
        if (this.jdField_c_of_type_Int == 0)
        {
          if ((!a(paramLong)) && (!b(paramLong)))
          {
            QLog.w("AndroidCamera", 1, "openCamera failed, seq[" + paramLong + "]");
            bool1 = false;
            continue;
          }
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            QLog.w("AndroidCamera", 1, "openCamera camera为空,setPreviewSize seq[" + paramLong + "]");
            bool1 = false;
            continue;
          }
          a(paramLong, k, l);
          bool1 = true;
          if (bool1) {
            break label414;
          }
          this.jdField_c_of_type_Int = 0;
          continue;
        }
        switch (this.jdField_c_of_type_Int)
        {
        }
      }
      finally {}
      if (a(paramLong))
      {
        a(paramLong, k, l);
        bool1 = true;
        continue;
        if (b(paramLong))
        {
          a(paramLong, k, l);
          bool1 = true;
          continue;
          try
          {
            label414:
            a(paramLong);
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
            this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
            bool1 = true;
          }
          catch (Exception paramSurfaceTexture)
          {
            localStringBuilder = new StringBuilder().append("setPreviewDisplay Exception, camera[");
            if (this.jdField_a_of_type_AndroidHardwareCamera == null) {}
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.w("AndroidCamera", 1, bool1 + "], isCameraOpened[" + jdField_a_of_type_Boolean + "], seq[" + paramLong + "]", paramSurfaceTexture);
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera.release();
        this.jdField_a_of_type_AndroidHardwareCamera = null;
        QLog.w("AndroidCamera", 1, "setPreviewDisplay fail, set camera null, seq[" + paramLong + "]");
        break label581;
        label563:
        lkj.b(BaseApplicationImpl.getContext(), "openCamera");
        break label154;
        bool1 = false;
        break label321;
      }
      label581:
      bool1 = false;
      break;
    }
  }
  
  public boolean a(long paramLong, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        int n;
        if (this.jdField_d_of_type_Int >= 1) {
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            break label359;
            if (bool1)
            {
              lkj.a(BaseApplicationImpl.getContext(), "reopenCamera");
              return bool1;
            }
          }
          else
          {
            QLog.w("AndroidCamera", 1, "reopenCamera, size[" + k + ", " + l + "], CUR_CAMERA[" + this.jdField_c_of_type_Int + "], isCameraOpened[" + jdField_a_of_type_Boolean + "], sizeFromParameter[" + paramInt1 + ", " + paramInt2 + "], seq[" + paramLong + "]");
            if (paramInt1 != -1)
            {
              n = paramInt1;
              paramInt1 = paramInt2;
              if (paramInt2 != -1) {}
            }
            else
            {
              n = k;
              paramInt1 = l;
            }
            c(paramLong);
          }
        }
        switch (this.jdField_c_of_type_Int)
        {
        case 2: 
          bool1 = bool2;
          if (!bool2) {
            continue;
          }
          a("reopenCamera", paramLong, n, paramInt1);
        case 1: 
          try
          {
            a(paramLong);
            if (paramSurfaceTexture != null) {
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
            }
            this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
            bool1 = true;
          }
          catch (Exception paramSurfaceTexture)
          {
            if (!AudioHelper.e()) {
              break label371;
            }
          }
          if (!b(paramLong)) {
            break label365;
          }
          a(paramLong, n, paramInt1);
          bool2 = true;
          continue;
          if (!a(paramLong)) {
            break label365;
          }
          a(paramLong, n, paramInt1);
          bool2 = true;
          continue;
          QLog.w("AndroidCamera", 1, "reopenCamera, Exception, seq[" + paramLong + "]", paramSurfaceTexture);
          break label371;
          lkj.b(BaseApplicationImpl.getContext(), "reopenCamera");
          continue;
          bool1 = false;
        }
      }
      finally {}
      label359:
      continue;
      label365:
      boolean bool2 = false;
      continue;
      label371:
      boolean bool1 = false;
    }
  }
  
  protected int b()
  {
    return 0;
  }
  
  int b(int paramInt, boolean paramBoolean)
  {
    byte b1;
    switch (paramInt)
    {
    default: 
      b1 = 0;
    }
    while (paramBoolean)
    {
      return lll.a(this.jdField_a_of_type_AndroidContentContext, false, false, b1, false) * 90;
      b1 = 0;
      continue;
      b1 = 1;
      continue;
      b1 = 2;
      continue;
      b1 = 3;
    }
    return lll.b(this.jdField_a_of_type_AndroidContentContext, false, false, b1, false) * 90;
  }
  
  int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return lll.a(this.jdField_a_of_type_AndroidContentContext, false, true, (byte)0, false) * 90;
    }
    return lll.b(this.jdField_a_of_type_AndroidContentContext, false, true, (byte)0, false) * 90;
  }
  
  protected Camera.Size b(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    int i2 = -1;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (Camera.Size)localIterator.next();
        if ((((Camera.Size)localObject).width == paramInt1) && (((Camera.Size)localObject).height == paramInt2))
        {
          paramList = (List<Camera.Size>)localObject;
          if (AudioHelper.e())
          {
            QLog.w("AndroidCamera", 1, "getOptimalEqualPreviewSize1, width[" + ((Camera.Size)localObject).width + "], height[" + ((Camera.Size)localObject).height + "]");
            paramList = (List<Camera.Size>)localObject;
          }
        }
      }
    }
    int n;
    int i1;
    do
    {
      return paramList;
      n = paramInt1;
      i1 = paramInt2;
      if (paramInt1 != 320) {
        break;
      }
      n = paramInt1;
      i1 = paramInt2;
      if (paramInt2 != 240) {
        break;
      }
      paramInt1 = 640;
      paramInt2 = 480;
      localIterator = paramList.iterator();
      do
      {
        n = paramInt1;
        i1 = paramInt2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Camera.Size)localIterator.next();
      } while ((((Camera.Size)localObject).width != 640) || (((Camera.Size)localObject).height != 480));
      paramList = (List<Camera.Size>)localObject;
    } while (!AudioHelper.e());
    QLog.w("AndroidCamera", 1, "getOptimalEqualPreviewSize2, width[" + ((Camera.Size)localObject).width + "], height[" + ((Camera.Size)localObject).height + "]");
    return localObject;
    if (0 == 0)
    {
      paramInt2 = k;
      int i3 = l;
      paramList = a(paramList, paramInt2, i3);
      if (AudioHelper.e())
      {
        localObject = new StringBuilder().append("getOptimalEqualPreviewSize3, width[");
        if (paramList == null) {
          break label410;
        }
      }
      label410:
      for (paramInt1 = paramList.width;; paramInt1 = -1)
      {
        localObject = ((StringBuilder)localObject).append(paramInt1).append("], height[");
        paramInt1 = i2;
        if (paramList != null) {
          paramInt1 = paramList.height;
        }
        QLog.w("AndroidCamera", 1, paramInt1 + "], srcW[" + n + "], srcH[" + i1 + "], fw[" + paramInt2 + "], fh[" + i3 + "]");
        return paramList;
      }
    }
    return null;
  }
  
  /* Error */
  protected Camera b(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 411	ljw:jdField_f_of_type_Int	I
    //   11: aload_0
    //   12: getfield 57	ljw:jdField_d_of_type_Int	I
    //   15: ifne +11 -> 26
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 412	ljw:a	()I
    //   23: putfield 57	ljw:jdField_d_of_type_Int	I
    //   26: aload_0
    //   27: getfield 57	ljw:jdField_d_of_type_Int	I
    //   30: ifle +240 -> 270
    //   33: new 414	android/hardware/Camera$CameraInfo
    //   36: dup
    //   37: invokespecial 415	android/hardware/Camera$CameraInfo:<init>	()V
    //   40: astore 8
    //   42: iconst_0
    //   43: istore_3
    //   44: iload_3
    //   45: aload_0
    //   46: getfield 57	ljw:jdField_d_of_type_Int	I
    //   49: if_icmpge +319 -> 368
    //   52: iload_3
    //   53: aload 8
    //   55: invokestatic 419	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   58: aload 8
    //   60: getfield 422	android/hardware/Camera$CameraInfo:facing	I
    //   63: istore 4
    //   65: invokestatic 174	com/tencent/mobileqq/utils/AudioHelper:e	()Z
    //   68: ifeq +54 -> 122
    //   71: ldc 135
    //   73: iconst_1
    //   74: new 137	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 724
    //   84: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: iload_3
    //   88: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: ldc_w 726
    //   94: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload 4
    //   99: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc 230
    //   104: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: lload_1
    //   108: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   111: ldc 155
    //   113: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 163	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: iload 4
    //   124: iconst_1
    //   125: if_icmpne +249 -> 374
    //   128: iload_3
    //   129: invokestatic 730	android/hardware/Camera:open	(I)Landroid/hardware/Camera;
    //   132: astore 5
    //   134: aload_0
    //   135: iload_3
    //   136: putfield 411	ljw:jdField_f_of_type_Int	I
    //   139: aload 5
    //   141: astore 6
    //   143: invokestatic 174	com/tencent/mobileqq/utils/AudioHelper:e	()Z
    //   146: ifeq +74 -> 220
    //   149: ldc 135
    //   151: iconst_1
    //   152: new 137	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 732
    //   162: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 5
    //   167: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: ldc_w 734
    //   173: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 411	ljw:jdField_f_of_type_Int	I
    //   180: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc_w 736
    //   186: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: getfield 57	ljw:jdField_d_of_type_Int	I
    //   193: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc 230
    //   198: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: lload_1
    //   202: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: ldc 155
    //   207: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 163	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload 5
    //   218: astore 6
    //   220: aload 6
    //   222: astore 5
    //   224: aload 5
    //   226: areturn
    //   227: astore 5
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield 411	ljw:jdField_f_of_type_Int	I
    //   234: ldc 135
    //   236: iconst_1
    //   237: new 137	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 738
    //   247: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: lload_1
    //   251: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: ldc 155
    //   256: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload 5
    //   264: invokestatic 427	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: goto +107 -> 374
    //   270: invokestatic 174	com/tencent/mobileqq/utils/AudioHelper:e	()Z
    //   273: ifeq -49 -> 224
    //   276: ldc 135
    //   278: iconst_1
    //   279: new 137	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 740
    //   289: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_0
    //   293: getfield 57	ljw:jdField_d_of_type_Int	I
    //   296: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: ldc 230
    //   301: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: lload_1
    //   305: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   308: ldc 155
    //   310: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 163	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aconst_null
    //   320: areturn
    //   321: astore 6
    //   323: aload 7
    //   325: astore 5
    //   327: ldc 135
    //   329: iconst_1
    //   330: new 137	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 742
    //   340: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: lload_1
    //   344: invokevirtual 233	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: ldc 155
    //   349: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: aload 6
    //   357: invokestatic 427	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   360: aload 5
    //   362: areturn
    //   363: astore 6
    //   365: goto -38 -> 327
    //   368: aconst_null
    //   369: astore 6
    //   371: goto -151 -> 220
    //   374: iload_3
    //   375: iconst_1
    //   376: iadd
    //   377: istore_3
    //   378: goto -334 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	ljw
    //   0	381	1	paramLong	long
    //   43	335	3	n	int
    //   63	63	4	i1	int
    //   4	221	5	localObject1	Object
    //   227	36	5	localRuntimeException	RuntimeException
    //   325	36	5	localObject2	Object
    //   141	80	6	localObject3	Object
    //   321	35	6	localException1	Exception
    //   363	1	6	localException2	Exception
    //   369	1	6	localObject4	Object
    //   1	323	7	localObject5	Object
    //   40	19	8	localCameraInfo	Camera.CameraInfo
    // Exception table:
    //   from	to	target	type
    //   128	134	227	java/lang/RuntimeException
    //   134	139	227	java/lang/RuntimeException
    //   143	216	227	java/lang/RuntimeException
    //   11	26	321	java/lang/Exception
    //   26	42	321	java/lang/Exception
    //   44	122	321	java/lang/Exception
    //   128	134	321	java/lang/Exception
    //   229	267	321	java/lang/Exception
    //   270	319	321	java/lang/Exception
    //   134	139	363	java/lang/Exception
    //   143	216	363	java/lang/Exception
  }
  
  public boolean b()
  {
    return jdField_f_of_type_Boolean;
  }
  
  protected boolean b(long paramLong)
  {
    boolean bool = jdField_a_of_type_Boolean;
    try
    {
      jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "openBackCamera, camera[" + this.jdField_a_of_type_AndroidHardwareCamera + "], seq[" + paramLong + "]");
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_c_of_type_Int = 2;
        jdField_a_of_type_Boolean = true;
        jdField_f_of_type_Boolean = false;
        c();
        if (AudioHelper.e()) {
          QLog.w("AndroidCamera", 1, "openBackCamera, success, seq[" + paramLong + "]");
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          this.jdField_a_of_type_AndroidHardwareCamera.release();
          this.jdField_a_of_type_AndroidHardwareCamera = null;
          QLog.w("AndroidCamera", 1, "openBackCamera Exception, set camera null, seq[" + paramLong + "]");
        }
        QLog.w("AndroidCamera", 1, "openBackCamera Exception, srcIsCameraOpened[" + bool + "], seq[" + paramLong + "]", localException);
      }
      jdField_f_of_type_Boolean = false;
    }
    return false;
  }
  
  @TargetApi(11)
  public boolean b(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_d_of_type_Int >= 1)
        {
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            break label266;
            if (bool1)
            {
              lkj.a(BaseApplicationImpl.getContext(), "switchCamera");
              return bool1;
            }
          }
          else
          {
            QLog.w("AndroidCamera", 1, "switchCamera, CUR_CAMERA[" + this.jdField_c_of_type_Int + "], seq[" + paramLong + "]");
            c(paramLong);
            int n = this.jdField_c_of_type_Int;
            boolean bool2;
            switch (n)
            {
            default: 
              bool2 = false;
              bool1 = bool2;
              if (!bool2) {
                continue;
              }
            case 1: 
            case 2: 
              try
              {
                a(paramLong);
                this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
                this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
                bool1 = true;
              }
              catch (Exception paramSurfaceTexture)
              {
                if (!AudioHelper.e()) {
                  break label272;
                }
              }
              if (!b(paramLong)) {
                continue;
              }
              a(paramLong, k, l);
              bool2 = true;
              continue;
              if (!a(paramLong)) {
                continue;
              }
              a(paramLong, k, l);
              bool2 = true;
              continue;
              QLog.w("AndroidCamera", 1, "switchCamera, Exception, seq[" + paramLong + "]");
              break;
            }
          }
          lkj.b(BaseApplicationImpl.getContext(), "switchCamera");
          continue;
        }
        bool1 = false;
      }
      finally {}
      label266:
      continue;
      label272:
      boolean bool1 = false;
    }
  }
  
  protected int c()
  {
    return 0;
  }
  
  public int c(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return this.i;
    }
    return this.j;
  }
  
  public boolean c()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public boolean c(long paramLong)
  {
    try
    {
      QLog.w("AndroidCamera", 1, "closeCamera begin, camera[" + toString() + "], seq[" + paramLong + "]");
      try
      {
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          if (jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(null);
            this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
            this.jdField_a_of_type_AndroidHardwareCamera.release();
          }
          a();
          this.jdField_a_of_type_AndroidHardwareCamera = null;
          QLog.w("AndroidCamera", 1, "closeCamera, set camera null, seq[" + paramLong + "]");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("AndroidCamera", 1, "closeCamera, Exception, seq[" + paramLong + "]", localException);
        }
      }
      jdField_a_of_type_Boolean = false;
      QLog.w("AndroidCamera", 1, "closeCamera end, camera[" + toString() + "], seq[" + paramLong + "]");
      lkj.b(BaseApplicationImpl.getContext(), "closeCamera");
      return true;
    }
    finally {}
  }
  
  public int d()
  {
    if (jdField_a_of_type_Ljy.jdField_b_of_type_Int == -1)
    {
      if (this.jdField_c_of_type_Int == 1) {
        return 270;
      }
      if (this.jdField_c_of_type_Int == 2) {
        return 90;
      }
    }
    return jdField_a_of_type_Ljy.jdField_b_of_type_Int;
  }
  
  public int e()
  {
    if (jdField_a_of_type_Ljy.jdField_c_of_type_Int == -1) {
      return 0;
    }
    return jdField_a_of_type_Ljy.jdField_c_of_type_Int;
  }
  
  public int f()
  {
    return a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isCameraOpened[").append(jdField_a_of_type_Boolean).append("], CameraId[").append(this.jdField_f_of_type_Int).append("], NUM[").append(this.jdField_d_of_type_Int).append("], CUR[").append(this.jdField_c_of_type_Int).append("], camera[");
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {}
    for (boolean bool = true;; bool = false) {
      return bool + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljw
 * JD-Core Version:    0.7.0.1
 */