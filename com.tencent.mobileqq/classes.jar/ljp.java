import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.SystemClock;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ljp
  extends liy
  implements lnv
{
  private Camera.AutoFocusCallback a;
  
  public ljp(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = new ljq(this);
  }
  
  @TargetApi(9)
  private void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    if (paramParameters == null)
    {
      lba.f("AndroidCamera", "parameters null, do nothing about focus config");
      return;
    }
    List localList = paramParameters.getSupportedFocusModes();
    if (localList == null)
    {
      lba.f("AndroidCamera", "getSupportedFocusModes empty");
      return;
    }
    lnz locallnz = lnz.a();
    if ((locallnz != null) && (locallnz.g())) {}
    for (boolean bool = true;; bool = false)
    {
      lba.f("AndroidCamera", String.format("enableAutoFocus, isUserSelfFocusDev[%s], enable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) }));
      if (!bool) {
        break;
      }
      a(paramBoolean, localList);
      return;
    }
    a(paramBoolean, localList, paramParameters);
  }
  
  private void a(boolean paramBoolean, List<String> paramList)
  {
    if (!paramList.contains("auto")) {
      return;
    }
    if (paramBoolean)
    {
      GraphicRenderMgr.getInstance().setFocusDetectCallback(this);
      GraphicRenderMgr.getInstance().setFocusConfig(true, SystemClock.elapsedRealtime(), 111, 3000);
      return;
    }
    GraphicRenderMgr.getInstance().setFocusDetectCallback(null);
    GraphicRenderMgr.getInstance().setFocusConfig(false, SystemClock.elapsedRealtime(), 111, 3000);
  }
  
  private void a(boolean paramBoolean, List<String> paramList, Camera.Parameters paramParameters)
  {
    if ((paramBoolean) && (this.h >= 9) && (paramList.contains("continuous-video"))) {
      paramParameters.setFocusMode("continuous-video");
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramParameters);
      return;
    }
    catch (Exception paramList) {}
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    super.a(paramLong, paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {}
    while (!QLog.isDevelopLevel()) {
      try
      {
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localParameters != null)
        {
          mwb.a(BaseApplicationImpl.getContext()).a(localParameters.flatten());
          a(localParameters, true);
          return;
        }
      }
      catch (Exception localException)
      {
        do
        {
          for (;;)
          {
            QLog.d("AndroidCamera", 2, "setCameraPara exception", localException);
            Object localObject = null;
          }
        } while (!QLog.isDevelopLevel());
        QLog.w("AndroidCamera", 1, "setCameraPara, parameters[null]");
        return;
      }
    }
    QLog.w("AndroidCamera", 1, "setCameraPara, camera[false]");
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
        lba.f("AndroidCamera", "camera null, return");
      }
    }
    else {
      return;
    }
    GraphicRenderMgr.getInstance().setIsFocusing(true);
    this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
  }
  
  /* Error */
  public boolean c(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 186	ljp:jdField_a_of_type_Boolean	Z
    //   5: istore_3
    //   6: iload_3
    //   7: ifeq +19 -> 26
    //   10: aload_0
    //   11: getfield 119	ljp:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   14: invokevirtual 133	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   17: astore 4
    //   19: aload_0
    //   20: aload 4
    //   22: iconst_0
    //   23: invokespecial 152	ljp:a	(Landroid/hardware/Camera$Parameters;Z)V
    //   26: aload_0
    //   27: lload_1
    //   28: invokespecial 188	liy:c	(J)Z
    //   31: istore_3
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_3
    //   35: ireturn
    //   36: astore 4
    //   38: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +13 -> 54
    //   44: ldc 26
    //   46: iconst_2
    //   47: ldc 193
    //   49: aload 4
    //   51: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   54: aconst_null
    //   55: astore 4
    //   57: goto -38 -> 19
    //   60: astore 4
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 4
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	ljp
    //   0	67	1	paramLong	long
    //   5	30	3	bool	boolean
    //   17	4	4	localParameters	Camera.Parameters
    //   36	14	4	localException	Exception
    //   55	1	4	localObject1	Object
    //   60	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	19	36	java/lang/Exception
    //   2	6	60	finally
    //   10	19	60	finally
    //   19	26	60	finally
    //   26	32	60	finally
    //   38	54	60	finally
  }
  
  public int i()
  {
    return a(this.i, this.jdField_a_of_type_AndroidHardwareCamera).c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljp
 * JD-Core Version:    0.7.0.1
 */