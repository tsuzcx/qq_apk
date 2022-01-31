import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.provider.MediaStore.MediaColumns;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.tencent.qphone.base.util.QLog;

public class lsq
{
  public static final boolean A;
  public static final boolean B;
  public static final boolean C;
  public static final boolean D;
  public static final boolean E;
  public static final boolean F;
  public static final boolean G;
  public static final boolean H;
  public static final boolean I;
  public static final boolean J;
  public static final boolean K;
  public static final boolean L;
  public static final boolean M;
  public static final boolean N;
  public static final boolean O;
  public static final boolean P;
  public static final boolean Q;
  public static final boolean R;
  public static final boolean S;
  static int a;
  public static final boolean a;
  public static final boolean b;
  public static final boolean c;
  public static final boolean d;
  public static final boolean e;
  public static final boolean f;
  public static final boolean g;
  public static final boolean h;
  public static final boolean i;
  public static final boolean j;
  public static final boolean k;
  public static final boolean l;
  public static final boolean m;
  public static final boolean n;
  public static final boolean o;
  public static final boolean p;
  public static final boolean q;
  public static final boolean r;
  public static final boolean s;
  public static final boolean t;
  public static final boolean u;
  public static final boolean v;
  public static final boolean w;
  public static final boolean x;
  public static final boolean y;
  public static final boolean z;
  
  static
  {
    boolean bool2 = true;
    if (Build.VERSION.SDK_INT >= 16)
    {
      bool1 = true;
      jdField_a_of_type_Boolean = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label703;
      }
      bool1 = true;
      label26:
      b = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        break label708;
      }
      bool1 = true;
      label40:
      c = bool1;
      d = a(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE");
      e = a(View.class, "SYSTEM_UI_FLAG_HIDE_NAVIGATION");
      f = a(MediaStore.MediaColumns.class, "WIDTH");
      if (Build.VERSION.SDK_INT < 16) {
        break label713;
      }
      bool1 = true;
      label84:
      g = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label718;
      }
      bool1 = true;
      label98:
      h = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label723;
      }
      bool1 = true;
      label112:
      i = bool1;
      j = a("android.graphics.SurfaceTexture", "setDefaultBufferSize", new Class[] { Integer.TYPE, Integer.TYPE });
      k = a("android.graphics.SurfaceTexture", "release", new Class[0]);
      if (Build.VERSION.SDK_INT < 11) {
        break label728;
      }
      bool1 = true;
      label166:
      l = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        break label733;
      }
      bool1 = true;
      label180:
      m = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        break label738;
      }
      bool1 = true;
      label194:
      n = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label743;
      }
      bool1 = true;
      label208:
      o = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        break label748;
      }
      bool1 = true;
      label222:
      p = bool1;
      q = a(View.class, "setSystemUiVisibility", new Class[] { Integer.TYPE });
    }
    for (;;)
    {
      try
      {
        if ((!a(Camera.class, "setFaceDetectionListener", new Class[] { Class.forName("android.hardware.Camera$FaceDetectionListener") })) || (!a(Camera.class, "startFaceDetection", new Class[0])) || (!a(Camera.class, "stopFaceDetection", new Class[0]))) {
          continue;
        }
        bool1 = a(Camera.Parameters.class, "getMaxNumDetectedFaces", new Class[0]);
        if (!bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (Throwable localThrowable)
      {
        label703:
        label708:
        label713:
        label718:
        label723:
        label728:
        label733:
        label738:
        label743:
        label748:
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
      }
      r = bool1;
      s = a(DevicePolicyManager.class, "getCameraDisabled", new Class[] { ComponentName.class });
      if (Build.VERSION.SDK_INT < 16) {
        continue;
      }
      bool1 = true;
      t = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      u = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        continue;
      }
      bool1 = true;
      v = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        continue;
      }
      bool1 = true;
      w = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        continue;
      }
      bool1 = true;
      x = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      y = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        continue;
      }
      bool1 = true;
      z = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      A = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      B = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      C = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        continue;
      }
      bool1 = true;
      D = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      E = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      F = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        continue;
      }
      bool1 = true;
      G = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      H = bool1;
      if (Build.VERSION.SDK_INT < 14) {
        continue;
      }
      bool1 = true;
      I = bool1;
      if (Build.VERSION.SDK_INT < 12) {
        continue;
      }
      bool1 = true;
      J = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        continue;
      }
      bool1 = true;
      K = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        continue;
      }
      bool1 = true;
      L = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      M = bool1;
      if (Build.VERSION.SDK_INT < 11) {
        continue;
      }
      bool1 = true;
      N = bool1;
      O = a(WindowManager.LayoutParams.class, "rotationAnimation");
      if (Build.VERSION.SDK_INT < 18) {
        continue;
      }
      bool1 = true;
      P = bool1;
      if (Build.VERSION.SDK_INT < 16) {
        continue;
      }
      bool1 = true;
      Q = bool1;
      if (Build.VERSION.SDK_INT < 18) {
        continue;
      }
      bool1 = true;
      R = bool1;
      if (Build.VERSION.SDK_INT < 17) {
        continue;
      }
      bool1 = bool2;
      S = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label26;
      bool1 = false;
      break label40;
      bool1 = false;
      break label84;
      bool1 = false;
      break label98;
      bool1 = false;
      break label112;
      bool1 = false;
      break label166;
      bool1 = false;
      break label180;
      bool1 = false;
      break label194;
      bool1 = false;
      break label208;
      bool1 = false;
      break label222;
      bool1 = false;
    }
  }
  
  public static int a()
  {
    int i1 = GLES20.glGetError();
    if (i1 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Utils", 2, "checkError error = " + i1);
      }
      lze.a();
    }
    return i1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static int a(Context paramContext)
  {
    if (jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
        if (paramContext != null) {
          continue;
        }
        jdField_a_of_type_Int = 1;
      }
      catch (Exception paramContext)
      {
        jdField_a_of_type_Int = 1;
        continue;
        int i1 = 1;
        continue;
      }
      return jdField_a_of_type_Int;
      if (paramContext.reqGlEsVersion < 131072) {
        continue;
      }
      i1 = 2;
      jdField_a_of_type_Int = i1;
    }
  }
  
  private static boolean a(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass.getDeclaredField(paramString);
      return true;
    }
    catch (NoSuchFieldException paramClass) {}
    return false;
  }
  
  private static boolean a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass.getDeclaredMethod(paramString, paramVarArgs);
      return true;
    }
    catch (NoSuchMethodException paramClass) {}
    return false;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != paramObject2)
    {
      if (paramObject1 == null) {}
      while (!paramObject1.equals(paramObject2)) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean a(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lsq
 * JD-Core Version:    0.7.0.1
 */