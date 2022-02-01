import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;

public class ljk
{
  public static int a;
  protected static ljo a;
  public static boolean a;
  public static int b;
  protected static boolean b;
  public static int c;
  protected static int d;
  protected static int e;
  public static volatile boolean f;
  Context jdField_a_of_type_AndroidContentContext = null;
  Camera jdField_a_of_type_AndroidHardwareCamera = null;
  Display jdField_a_of_type_AndroidViewDisplay;
  String jdField_a_of_type_JavaLangString;
  private ljm jdField_a_of_type_Ljm;
  String b;
  boolean c;
  boolean d;
  public boolean e;
  int f;
  int g = 0;
  int h;
  int i;
  int j = 0;
  int k = 0;
  int l = 0;
  int m = 0;
  private int n = 0;
  
  static
  {
    jdField_a_of_type_Int = 640;
    jdField_b_of_type_Int = 480;
    jdField_c_of_type_Int = 17;
    jdField_e_of_type_Int = 15000;
    jdField_a_of_type_Ljo = new ljo();
    jdField_f_of_type_Boolean = true;
  }
  
  public ljk(Context paramContext)
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_c_of_type_Boolean = mtj.g(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_Boolean = mtj.c();
    this.h = Build.VERSION.SDK_INT;
    this.jdField_a_of_type_JavaLangString = Build.MODEL;
    this.jdField_b_of_type_JavaLangString = Build.MANUFACTURER;
    jdField_a_of_type_Ljo.jdField_b_of_type_Int = -1;
    jdField_a_of_type_Ljo.jdField_c_of_type_Int = -1;
    if (QLog.isColorLevel()) {
      QLog.w("AndroidCamera", 1, "AndroidCamera, Device_Tag[" + this.jdField_b_of_type_JavaLangString + ": " + this.jdField_a_of_type_JavaLangString + "], Rom_Tag[" + Build.VERSION.INCREMENTAL + "]");
    }
  }
  
  private int a(long paramLong, Camera.Parameters paramParameters)
  {
    int i2 = 16;
    for (;;)
    {
      try
      {
        localList = paramParameters.getSupportedPreviewFormats();
        if (localList == null) {
          break label539;
        }
        if (AudioHelper.f())
        {
          StringBuilder localStringBuilder = new StringBuilder("setPreviewFormat[");
          i1 = 0;
          if (i1 < localList.size())
          {
            localStringBuilder.append(localList.get(i1)).append(";");
            i1 += 1;
            continue;
          }
          localStringBuilder.append("]");
          QLog.w("AndroidCamera", 1, localStringBuilder.toString());
        }
        bool = localList.contains(Integer.valueOf(17));
        if (!bool) {
          continue;
        }
        i1 = 17;
      }
      catch (Exception localException)
      {
        List localList;
        boolean bool;
        i1 = 0;
        continue;
        if (!AudioHelper.f()) {
          continue;
        }
        QLog.w("AndroidCamera", 1, "setPreviewFormat, default supportFormat[" + 17 + "], seq[" + paramLong + "]");
        paramParameters.setPreviewFormat(17);
        return 17;
      }
      if (i1 != 0)
      {
        if (AudioHelper.f()) {
          QLog.w("AndroidCamera", 1, "setPreviewFormat, supportFormat[" + i1 + "], seq[" + paramLong + "]");
        }
        paramParameters.setPreviewFormat(i1);
        return i1;
        i1 = i2;
        if (localList.contains(Integer.valueOf(16))) {
          continue;
        }
        if (localList.contains(Integer.valueOf(20)))
        {
          i1 = 20;
          continue;
        }
        if (localList.contains(Integer.valueOf(842094169)))
        {
          i1 = 842094169;
          continue;
        }
        if (localList.contains(Integer.valueOf(4)))
        {
          i1 = 4;
          continue;
        }
        if (localList.contains(Integer.valueOf(17)))
        {
          i1 = 17;
          continue;
        }
        i1 = i2;
        if (localList.contains(Integer.valueOf(16))) {
          continue;
        }
        if (localList.contains(Integer.valueOf(3)))
        {
          i1 = 3;
          continue;
        }
        if (localList.contains(Integer.valueOf(2)))
        {
          i1 = 2;
          continue;
        }
        if (localList.contains(Integer.valueOf(4)))
        {
          i1 = 4;
          continue;
        }
        if (localList.contains(Integer.valueOf(100)))
        {
          i1 = 100;
          continue;
        }
        if (localList.contains(Integer.valueOf(101)))
        {
          i1 = 101;
          continue;
        }
        if (localList.contains(Integer.valueOf(102)))
        {
          i1 = 102;
          continue;
        }
        if (localList.contains(Integer.valueOf(103)))
        {
          i1 = 103;
          continue;
        }
        bool = localList.contains(Integer.valueOf(104));
        if (!bool) {
          break label539;
        }
        i1 = 104;
      }
      label539:
      int i1 = 0;
    }
  }
  
  private void a()
  {
    if ((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("meizu")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("meizu_m9"))) {
      jdField_c_of_type_Int = 18;
    }
    while ((!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("ZTE")) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("ZTE-T U880"))) {
      return;
    }
    jdField_c_of_type_Int = 100;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, Camera.Parameters paramParameters)
  {
    int i1 = jdField_a_of_type_Int;
    int i2 = jdField_b_of_type_Int;
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
      label54:
      break label54;
    }
    if (((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("samsung")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("GT-I9003"))) || ((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("samsung")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("GT-I9220"))) || ((this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("samsung")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("GT-I7000")))) {
      a("setPreviewSize_hardcode", paramLong, 320, 240);
    }
    if (a()) {
      a("setPreviewSize_hardcode", paramLong, 1280, 720);
    }
    if (AudioHelper.f()) {
      QLog.w("AndroidCamera", 1, "setPreviewSize, in[" + paramInt1 + "x" + paramInt2 + "], before[" + i1 + "x" + i2 + "], final[" + jdField_a_of_type_Int + "x" + jdField_b_of_type_Int + "], seq[" + paramLong + "]");
    }
    paramParameters.setPreviewSize(jdField_a_of_type_Int, jdField_b_of_type_Int);
  }
  
  private void a(long paramLong, Camera.Parameters paramParameters, int paramInt1, int paramInt2)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    jdField_e_of_type_Int = paramInt2;
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = (int[])((List)localObject2).get(0);
      int i1 = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        if (AudioHelper.f()) {
          QLog.w("AndroidCamera", 1, "setPreviewRate2, Range[" + localObject2[0] + "->" + localObject2[1] + "], seq[" + paramLong + "]");
        }
        int i2 = Math.abs(localObject2[0] - jdField_e_of_type_Int) + Math.abs(localObject2[1] - jdField_e_of_type_Int);
        if (i1 <= i2) {
          break label277;
        }
        localObject1 = localObject2;
        i1 = i2;
      }
    }
    label277:
    for (;;)
    {
      break;
      if (AudioHelper.f()) {
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
      int i1 = 2147483647;
      Iterator localIterator = ((List)localObject2).iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        if (AudioHelper.f()) {
          QLog.w("AndroidCamera", 1, "setPreviewRate1, Range[" + localObject2[0] + "->" + localObject2[1] + "]");
        }
        int i2 = Math.abs(localObject2[0] - jdField_e_of_type_Int) + Math.abs(localObject2[1] - jdField_e_of_type_Int);
        if (i1 <= i2) {
          break label239;
        }
        localObject1 = localObject2;
        i1 = i2;
      }
    }
    label239:
    for (;;)
    {
      break;
      if (AudioHelper.f()) {
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
      if ((jdField_a_of_type_Int != paramInt1) || (jdField_b_of_type_Int != paramInt2) || (QLog.isDevelopLevel())) {
        QLog.w("AndroidCamera", 1, "resetPreViewSize, from[" + paramString + "], src[" + jdField_a_of_type_Int + "x" + jdField_b_of_type_Int + "], final[" + paramInt1 + "x" + paramInt2 + "], seq[" + paramLong + "]");
      }
      jdField_a_of_type_Int = paramInt1;
      jdField_b_of_type_Int = paramInt2;
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return "1".equalsIgnoreCase(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.use720PCameraPreviewSize.name(), "0"));
  }
  
  private void b()
  {
    int i1 = 0;
    this.i = 0;
    try
    {
      if (this.g == 0) {
        this.g = b();
      }
      if (this.g > 0)
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        for (;;)
        {
          if (i1 < this.g)
          {
            Camera.getCameraInfo(i1, localCameraInfo);
            int i2 = localCameraInfo.facing;
            if (i2 == 0) {}
            try
            {
              this.i = i1;
              i1 += 1;
            }
            catch (RuntimeException localRuntimeException)
            {
              for (;;)
              {
                this.i = 0;
                if (AudioHelper.f()) {
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
      if (AudioHelper.f()) {
        QLog.w("AndroidCamera", 1, "findBackCameraId, Exception", localException);
      }
    }
  }
  
  public int a()
  {
    return this.n;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 360 - llc.a(this.jdField_a_of_type_AndroidContentContext, true, true, (byte)0, false) * 90;
    }
    return 360 - llc.b(this.jdField_a_of_type_AndroidContentContext, true, true, (byte)0, false) * 90;
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
      if (AudioHelper.f()) {
        QLog.w("AndroidCamera", 1, "getCameraParams, Exception", localException);
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
  
  protected ljo a(int paramInt, Camera paramCamera)
  {
    paramCamera = new ljo();
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
      switch (c())
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
  
  public void a(int paramInt)
  {
    int i1 = jdField_a_of_type_Ljo.jdField_c_of_type_Int;
    jdField_a_of_type_Ljo.jdField_c_of_type_Int = ((this.k + paramInt) % 360);
    if (i1 != jdField_a_of_type_Ljo.jdField_c_of_type_Int) {
      QLog.w("AndroidCamera", 1, "setMobileRotation, rotation[" + i1 + "->" + jdField_a_of_type_Ljo.jdField_c_of_type_Int + "], mCompenSateSendAngle[" + this.k + "]");
    }
  }
  
  public void a(int paramInt, ljl paramljl)
  {
    int i1 = 0;
    if (this.n != paramInt)
    {
      this.n = paramInt;
      i1 = 1;
    }
    if (this.n == 0) {
      if ((this.jdField_a_of_type_Ljm != null) && (i1 == 0)) {}
    }
    for (this.jdField_a_of_type_Ljm = new ljx(this, paramljl);; this.jdField_a_of_type_Ljm = new ljy(this, paramljl))
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.i("SurfaceTag", 2, "setCameraMode, mode[" + paramInt + "]");
        }
        return;
      } while ((this.n != 1) || ((this.jdField_a_of_type_Ljm != null) && (i1 == 0)));
      if (this.jdField_a_of_type_Ljm != null) {
        this.jdField_a_of_type_Ljm.a();
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {}
    for (;;)
    {
      return;
      synchronized (jdField_a_of_type_Ljo)
      {
        a(paramLong, this.i, this.jdField_a_of_type_AndroidHardwareCamera);
        Object localObject2 = null;
      }
      int i1;
      try
      {
        ??? = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (??? == null)
        {
          if (!AudioHelper.f()) {
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
          if (AudioHelper.f())
          {
            QLog.w("AndroidCamera", 1, "setCameraParaFPS, Exception", localException2);
            ??? = localObject3;
          }
        }
        i1 = a(paramLong, (Camera.Parameters)???);
        a(paramLong, (Camera.Parameters)???, i1, paramInt);
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
          jdField_c_of_type_Int = paramInt;
          int[] arrayOfInt = new int[2];
          ((Camera.Parameters)???).getPreviewFpsRange(arrayOfInt);
          jdField_d_of_type_Int = (arrayOfInt[0] + arrayOfInt[1]) / 2 / 1000;
          a();
          if ((!AudioHelper.f()) && (localSize != null)) {
            break;
          }
          QLog.w("AndroidCamera", 1, "setCameraParaFPS, width[" + jdField_a_of_type_Int + "], height[" + jdField_b_of_type_Int + "], nInFPS[" + jdField_d_of_type_Int + "], fpsRange[" + arrayOfInt[0] + "|" + arrayOfInt[1] + "], videoFormat[" + jdField_c_of_type_Int + "], supportFormat[" + i1 + "], seq[" + paramLong + "]");
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
      synchronized (jdField_a_of_type_Ljo)
      {
        a(paramLong, this.i, this.jdField_a_of_type_AndroidHardwareCamera);
        Object localObject2 = null;
      }
      try
      {
        ??? = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (??? == null)
        {
          if (!AudioHelper.f()) {
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
          if (AudioHelper.f())
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
          int i1 = ((Camera.Parameters)???).getPreviewFormat();
          a("setCameraPara", paramLong, ((Camera.Size)localObject4).width, ((Camera.Size)localObject4).height);
          jdField_c_of_type_Int = i1;
          localObject4 = new int[2];
          ((Camera.Parameters)???).getPreviewFpsRange((int[])localObject4);
          jdField_d_of_type_Int = (localObject4[0] + localObject4[1]) / 2 / 1000;
          a();
          QLog.w("AndroidCamera", 1, "setCameraPara, size[" + jdField_a_of_type_Int + "x" + jdField_b_of_type_Int + "], src[" + paramInt1 + "x" + paramInt2 + "], nInFPS[" + jdField_d_of_type_Int + "], fpsRange[" + localObject4[0] + "~" + localObject4[1] + "], videoFormat[" + jdField_c_of_type_Int + "], seq[" + paramLong + "]");
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
      while (!AudioHelper.f()) {}
      QLog.w("AndroidCamera", 1, "setDisplayOrientation, Exception", paramCamera);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.l = (paramInt % 360);
    }
    for (;;)
    {
      lbd.f("AndroidCamera", "mFrontCameraAngle: " + this.l + ", mBackCameraAngle: " + this.m);
      return;
      this.m = (paramInt % 360);
    }
  }
  
  protected boolean a(long paramLong)
  {
    jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidHardwareCamera = a(paramLong);
    if (this.jdField_a_of_type_AndroidHardwareCamera == null)
    {
      if (AudioHelper.f()) {
        QLog.w("AndroidCamera", 1, "openFrontCamera, fail, seq[" + paramLong + "]");
      }
      jdField_a_of_type_Boolean = false;
      jdField_b_of_type_Boolean = false;
      return false;
    }
    if (this.g == 0) {
      this.g = 2;
    }
    this.jdField_f_of_type_Int = 1;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = false;
    if (AudioHelper.f()) {
      QLog.w("AndroidCamera", 1, "openFrontCamera, success, seq[" + paramLong + "]");
    }
    return true;
  }
  
  protected boolean a(long paramLong, int paramInt, Camera paramCamera)
  {
    ljo localljo = a(paramInt, paramCamera);
    this.k = d();
    this.j = e();
    int i2 = f();
    int i3 = g();
    int i4;
    int i5;
    if (localljo.jdField_a_of_type_Int == 1)
    {
      i1 = (360 - (localljo.jdField_b_of_type_Int + localljo.jdField_c_of_type_Int) % 360) % 360;
      i4 = a(this.jdField_e_of_type_Boolean);
      i5 = b(this.jdField_e_of_type_Boolean);
      if (localljo.jdField_a_of_type_Int != 1) {
        break label372;
      }
    }
    label372:
    for (int i1 = (i1 + i4) % 360;; i1 = (i1 + i5) % 360)
    {
      QLog.w("AndroidCamera", 1, "setCameraDisplayOrientation, cameraId[" + paramInt + "], orientation[" + jdField_a_of_type_Ljo.jdField_b_of_type_Int + "->" + localljo.jdField_b_of_type_Int + "], rotation[" + jdField_a_of_type_Ljo.jdField_c_of_type_Int + "->" + localljo.jdField_c_of_type_Int + "], mCompenSateSendAngle[" + this.k + "], mCompenSateRecvAngle[" + this.j + "], mSupportLandscape[" + this.jdField_e_of_type_Boolean + "], previewAngleForFrontCamera[" + i4 + "], previewAngleForBackCamera[" + i5 + "], cameraImageOrientation[" + i2 + "], mobileRotation[" + i3 + "], result[" + i1 + "], cameraMode[" + this.n + "], seq[" + paramLong + "]");
      a(paramCamera, i1);
      jdField_a_of_type_Ljo.jdField_a_of_type_Int = localljo.jdField_a_of_type_Int;
      jdField_a_of_type_Ljo.jdField_b_of_type_Int = localljo.jdField_b_of_type_Int;
      return true;
      i1 = (localljo.jdField_b_of_type_Int - localljo.jdField_c_of_type_Int + 360) % 360;
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
        QLog.w("AndroidCamera", 1, "openCamera begin, Camera[" + toString() + "], PreViewSize[" + jdField_a_of_type_Int + "x" + jdField_b_of_type_Int + "], seq[" + paramLong + "]");
        if (jdField_a_of_type_Boolean)
        {
          bool1 = true;
          jdField_a_of_type_Boolean = bool1;
          QLog.w("AndroidCamera", 1, "openCamera end, result[" + bool1 + "], Camera[" + toString() + "], seq[" + paramLong + "]");
          if (!bool1) {
            break label578;
          }
          lka.a(BaseApplicationImpl.getContext(), "openCamera");
          return bool1;
        }
        if (this.jdField_a_of_type_AndroidContentContext == null)
        {
          QLog.w("AndroidCamera", 1, "openCamera, context为空, seq[" + paramLong + "]");
          bool1 = false;
          continue;
        }
        if (this.jdField_f_of_type_Int == 0)
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
          a(paramLong, jdField_a_of_type_Int, jdField_b_of_type_Int);
          bool1 = true;
          if (bool1) {
            break label414;
          }
          this.jdField_f_of_type_Int = 0;
          continue;
        }
        switch (this.jdField_f_of_type_Int)
        {
        }
      }
      finally {}
      if (a(paramLong))
      {
        a(paramLong, jdField_a_of_type_Int, jdField_b_of_type_Int);
        bool1 = true;
        continue;
        if (b(paramLong))
        {
          a(paramLong, jdField_a_of_type_Int, jdField_b_of_type_Int);
          bool1 = true;
          continue;
          try
          {
            label414:
            if (this.jdField_a_of_type_Ljm != null) {
              this.jdField_a_of_type_Ljm.a(paramLong, paramSurfaceTexture);
            }
            if (paramSurfaceTexture != null) {
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
            }
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
        break label596;
        label578:
        lka.b(BaseApplicationImpl.getContext(), "openCamera");
        break label154;
        bool1 = false;
        break label321;
      }
      label596:
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
        int i1;
        if (this.g >= 1) {
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            break label370;
            if (bool1)
            {
              lka.a(BaseApplicationImpl.getContext(), "reopenCamera");
              return bool1;
            }
          }
          else
          {
            QLog.w("AndroidCamera", 1, "reopenCamera, size[" + jdField_a_of_type_Int + ", " + jdField_b_of_type_Int + "], mCurCamera[" + this.jdField_f_of_type_Int + "], isCameraOpened[" + jdField_a_of_type_Boolean + "], sizeFromParameter[" + paramInt1 + ", " + paramInt2 + "], seq[" + paramLong + "]");
            if (paramInt1 != -1)
            {
              i1 = paramInt1;
              paramInt1 = paramInt2;
              if (paramInt2 != -1) {}
            }
            else
            {
              i1 = jdField_a_of_type_Int;
              paramInt1 = jdField_b_of_type_Int;
            }
            c(paramLong);
          }
        }
        switch (this.jdField_f_of_type_Int)
        {
        case 2: 
          bool1 = bool2;
          if (!bool2) {
            continue;
          }
          a("reopenCamera", paramLong, i1, paramInt1);
        case 1: 
          try
          {
            if (this.jdField_a_of_type_Ljm != null) {
              this.jdField_a_of_type_Ljm.a(paramLong, paramSurfaceTexture);
            }
            if (paramSurfaceTexture != null) {
              this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
            }
            this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
            bool1 = true;
          }
          catch (Exception paramSurfaceTexture)
          {
            if (!AudioHelper.f()) {
              break label382;
            }
          }
          if (!b(paramLong)) {
            break label376;
          }
          a(paramLong, i1, paramInt1);
          bool2 = true;
          continue;
          if (!a(paramLong)) {
            break label376;
          }
          a(paramLong, i1, paramInt1);
          bool2 = true;
          continue;
          QLog.w("AndroidCamera", 1, "reopenCamera, Exception, seq[" + paramLong + "]", paramSurfaceTexture);
          break label382;
          lka.b(BaseApplicationImpl.getContext(), "reopenCamera");
          continue;
          bool1 = false;
        }
      }
      finally {}
      label370:
      continue;
      label376:
      boolean bool2 = false;
      continue;
      label382:
      boolean bool1 = false;
    }
  }
  
  protected int b()
  {
    int i1;
    if (!bhkn.h)
    {
      if (AudioHelper.f()) {
        QLog.w("AndroidCamera", 1, "getNumberOfCamera, hardcode[" + bhkk.a().a() + "]");
      }
      i1 = bhkk.a().a();
    }
    do
    {
      for (;;)
      {
        return i1;
        try
        {
          i2 = Camera.getNumberOfCameras();
          i1 = i2;
          try
          {
            if (AudioHelper.f())
            {
              QLog.w("AndroidCamera", 1, "getNumberOfCamera, count[" + i2 + "]");
              return i2;
            }
          }
          catch (Exception localException1) {}
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i2 = 1;
          }
        }
      }
      i1 = i2;
    } while (!AudioHelper.f());
    QLog.w("AndroidCamera", 1, "getNumberOfCamera, Exception", localException1);
    return i2;
  }
  
  int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return llc.a(this.jdField_a_of_type_AndroidContentContext, false, true, (byte)0, false) * 90;
    }
    return llc.b(this.jdField_a_of_type_AndroidContentContext, false, true, (byte)0, false) * 90;
  }
  
  protected Camera.Size b(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    int i3 = -1;
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
          if (AudioHelper.f())
          {
            QLog.w("AndroidCamera", 1, "getOptimalEqualPreviewSize1, width[" + ((Camera.Size)localObject).width + "], height[" + ((Camera.Size)localObject).height + "]");
            paramList = (List<Camera.Size>)localObject;
          }
        }
      }
    }
    int i1;
    int i2;
    do
    {
      return paramList;
      i1 = paramInt1;
      i2 = paramInt2;
      if (paramInt1 != 320) {
        break;
      }
      i1 = paramInt1;
      i2 = paramInt2;
      if (paramInt2 != 240) {
        break;
      }
      paramInt1 = 640;
      paramInt2 = 480;
      localIterator = paramList.iterator();
      do
      {
        i1 = paramInt1;
        i2 = paramInt2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Camera.Size)localIterator.next();
      } while ((((Camera.Size)localObject).width != 640) || (((Camera.Size)localObject).height != 480));
      paramList = (List<Camera.Size>)localObject;
    } while (!AudioHelper.f());
    QLog.w("AndroidCamera", 1, "getOptimalEqualPreviewSize2, width[" + ((Camera.Size)localObject).width + "], height[" + ((Camera.Size)localObject).height + "]");
    return localObject;
    if (0 == 0)
    {
      paramInt2 = jdField_a_of_type_Int;
      int i4 = jdField_b_of_type_Int;
      paramList = a(paramList, paramInt2, i4);
      if (AudioHelper.f())
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
        paramInt1 = i3;
        if (paramList != null) {
          paramInt1 = paramList.height;
        }
        QLog.w("AndroidCamera", 1, paramInt1 + "], srcW[" + i1 + "], srcH[" + i2 + "], fw[" + paramInt2 + "], fh[" + i4 + "]");
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
    //   8: putfield 342	ljk:i	I
    //   11: aload_0
    //   12: getfield 56	ljk:g	I
    //   15: ifne +11 -> 26
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 344	ljk:b	()I
    //   23: putfield 56	ljk:g	I
    //   26: aload_0
    //   27: getfield 56	ljk:g	I
    //   30: ifle +240 -> 270
    //   33: new 346	android/hardware/Camera$CameraInfo
    //   36: dup
    //   37: invokespecial 347	android/hardware/Camera$CameraInfo:<init>	()V
    //   40: astore 8
    //   42: iconst_0
    //   43: istore_3
    //   44: iload_3
    //   45: aload_0
    //   46: getfield 56	ljk:g	I
    //   49: if_icmpge +319 -> 368
    //   52: iload_3
    //   53: aload 8
    //   55: invokestatic 353	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   58: aload 8
    //   60: getfield 356	android/hardware/Camera$CameraInfo:facing	I
    //   63: istore 4
    //   65: invokestatic 161	com/tencent/mobileqq/utils/AudioHelper:f	()Z
    //   68: ifeq +54 -> 122
    //   71: ldc 122
    //   73: iconst_1
    //   74: new 124	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 676
    //   84: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: iload_3
    //   88: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: ldc_w 678
    //   94: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload 4
    //   99: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc 198
    //   104: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: lload_1
    //   108: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   111: ldc 140
    //   113: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: iload 4
    //   124: iconst_1
    //   125: if_icmpne +249 -> 374
    //   128: iload_3
    //   129: invokestatic 682	android/hardware/Camera:open	(I)Landroid/hardware/Camera;
    //   132: astore 5
    //   134: aload_0
    //   135: iload_3
    //   136: putfield 342	ljk:i	I
    //   139: aload 5
    //   141: astore 6
    //   143: invokestatic 161	com/tencent/mobileqq/utils/AudioHelper:f	()Z
    //   146: ifeq +74 -> 220
    //   149: ldc 122
    //   151: iconst_1
    //   152: new 124	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 684
    //   162: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 5
    //   167: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: ldc_w 686
    //   173: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 342	ljk:i	I
    //   180: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc_w 688
    //   186: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: getfield 56	ljk:g	I
    //   193: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc 198
    //   198: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: lload_1
    //   202: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: ldc 140
    //   207: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload 5
    //   218: astore 6
    //   220: aload 6
    //   222: astore 5
    //   224: aload 5
    //   226: areturn
    //   227: astore 5
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield 342	ljk:i	I
    //   234: ldc 122
    //   236: iconst_1
    //   237: new 124	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 690
    //   247: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: lload_1
    //   251: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: ldc 140
    //   256: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload 5
    //   264: invokestatic 361	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: goto +107 -> 374
    //   270: invokestatic 161	com/tencent/mobileqq/utils/AudioHelper:f	()Z
    //   273: ifeq -49 -> 224
    //   276: ldc 122
    //   278: iconst_1
    //   279: new 124	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 692
    //   289: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_0
    //   293: getfield 56	ljk:g	I
    //   296: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: ldc 198
    //   301: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: lload_1
    //   305: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   308: ldc 140
    //   310: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aconst_null
    //   320: areturn
    //   321: astore 6
    //   323: aload 7
    //   325: astore 5
    //   327: ldc 122
    //   329: iconst_1
    //   330: new 124	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 694
    //   340: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: lload_1
    //   344: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: ldc 140
    //   349: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: aload 6
    //   357: invokestatic 361	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   0	381	0	this	ljk
    //   0	381	1	paramLong	long
    //   43	335	3	i1	int
    //   63	63	4	i2	int
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
    if (this.jdField_f_of_type_Int == 0) {}
    while (this.jdField_f_of_type_Int == 1) {
      return true;
    }
    return false;
  }
  
  protected boolean b(long paramLong)
  {
    boolean bool = jdField_a_of_type_Boolean;
    try
    {
      jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
      if (AudioHelper.f()) {
        QLog.w("AndroidCamera", 1, "openBackCamera, camera[" + this.jdField_a_of_type_AndroidHardwareCamera + "], seq[" + paramLong + "]");
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_f_of_type_Int = 2;
        jdField_a_of_type_Boolean = true;
        jdField_b_of_type_Boolean = false;
        b();
        if (AudioHelper.f()) {
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
      jdField_b_of_type_Boolean = false;
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
        if (this.g >= 1)
        {
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            break label277;
            if (bool1)
            {
              lka.a(BaseApplicationImpl.getContext(), "switchCamera");
              return bool1;
            }
          }
          else
          {
            QLog.w("AndroidCamera", 1, "switchCamera, mCurCamera[" + this.jdField_f_of_type_Int + "], seq[" + paramLong + "]");
            c(paramLong);
            int i1 = this.jdField_f_of_type_Int;
            boolean bool2;
            switch (i1)
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
                if (this.jdField_a_of_type_Ljm != null) {
                  this.jdField_a_of_type_Ljm.a(paramLong, paramSurfaceTexture);
                }
                this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
                this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
                bool1 = true;
              }
              catch (Exception paramSurfaceTexture)
              {
                if (!AudioHelper.f()) {
                  break label283;
                }
              }
              if (!b(paramLong)) {
                continue;
              }
              a(paramLong, jdField_a_of_type_Int, jdField_b_of_type_Int);
              bool2 = true;
              continue;
              if (!a(paramLong)) {
                continue;
              }
              a(paramLong, jdField_a_of_type_Int, jdField_b_of_type_Int);
              bool2 = true;
              continue;
              QLog.w("AndroidCamera", 1, "switchCamera, Exception, seq[" + paramLong + "]");
              break;
            }
          }
          lka.b(BaseApplicationImpl.getContext(), "switchCamera");
          continue;
        }
        bool1 = false;
      }
      finally {}
      label277:
      continue;
      label283:
      boolean bool1 = false;
    }
  }
  
  protected int c()
  {
    if (jdField_f_of_type_Boolean) {
      return 0;
    }
    try
    {
      int i1 = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
      return i1;
    }
    catch (Exception localException)
    {
      QLog.w("AndroidCamera", 1, "getDisplayRotation Exception", localException);
    }
    return 0;
  }
  
  public int c(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return this.l;
    }
    return this.m;
  }
  
  public boolean c()
  {
    return jdField_b_of_type_Boolean;
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
          if (this.jdField_a_of_type_Ljm != null) {
            this.jdField_a_of_type_Ljm.a();
          }
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
      lka.b(BaseApplicationImpl.getContext(), "closeCamera");
      return true;
    }
    finally {}
  }
  
  protected int d()
  {
    return 0;
  }
  
  public boolean d()
  {
    return jdField_a_of_type_Boolean;
  }
  
  protected int e()
  {
    return 0;
  }
  
  public int f()
  {
    if (jdField_a_of_type_Ljo.jdField_b_of_type_Int == -1)
    {
      if (this.jdField_f_of_type_Int == 1) {
        return 270;
      }
      if (this.jdField_f_of_type_Int == 2) {
        return 90;
      }
    }
    return jdField_a_of_type_Ljo.jdField_b_of_type_Int;
  }
  
  public int g()
  {
    if (jdField_a_of_type_Ljo.jdField_c_of_type_Int == -1) {
      return 0;
    }
    return jdField_a_of_type_Ljo.jdField_c_of_type_Int;
  }
  
  public int h()
  {
    return b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("isCameraOpened[").append(jdField_a_of_type_Boolean).append("], mCameraId[").append(this.i).append("], NUM[").append(this.g).append("], CUR[").append(this.jdField_f_of_type_Int).append("], camera[");
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {}
    for (boolean bool = true;; bool = false) {
      return bool + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljk
 * JD-Core Version:    0.7.0.1
 */