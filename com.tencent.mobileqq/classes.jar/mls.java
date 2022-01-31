import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.VideoController;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.ui.ScreenRecordHelper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Timer;

@RequiresApi(api=21)
public class mls
{
  static final int[][] jdField_a_of_type_Array2dOfInt;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private VirtualDisplay jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay;
  private MediaProjection jdField_a_of_type_AndroidMediaProjectionMediaProjection;
  private MediaProjectionManager jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private lrt jdField_a_of_type_Lrt;
  private final lyh jdField_a_of_type_Lyh = new lyh();
  private mlt jdField_a_of_type_Mlt;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  static
  {
    int[] arrayOfInt1 = { 1080, 1920 };
    int[] arrayOfInt2 = { 1080, 1920 };
    jdField_a_of_type_Array2dOfInt = new int[][] { { 720, 1280 }, arrayOfInt1, arrayOfInt2 };
  }
  
  private void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_a_of_type_Mlt != null)) {
      this.jdField_a_of_type_Mlt.b(1);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay = this.jdField_a_of_type_AndroidMediaProjectionMediaProjection.createVirtualDisplay("ScreenRecordHelper", this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_Int, 16, this.jdField_a_of_type_Lrt.a(), null, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof Activity)) {
        break label81;
      }
    }
    label81:
    Object localObject2;
    for (Object localObject1 = (Activity)localObject1;; localObject2 = null)
    {
      if (localObject1 == null)
      {
        QLog.i("ScreenRecordHelper", 1, "requestScreenCapture, context not bind Activity .");
        return;
        localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        break;
      }
      QLog.d("ScreenRecordHelper", 1, "Start requestScreenCapture");
      try
      {
        ((Activity)localObject1).startActivityForResult(this.jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager.createScreenCaptureIntent(), 8080);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        QLog.d("ScreenRecordHelper", 1, "Start requestScreenCapture fail ActivityNotFoundException");
        return;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ScreenRecordHelper", 4, "stop, fromType[" + paramInt + "]");
    }
    b();
    a(paramInt);
    c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int i;
    label55:
    int m;
    int j;
    if (this.jdField_b_of_type_Int < this.c)
    {
      k = 1;
      switch (AEFilterSupport.a())
      {
      case 5: 
      case 6: 
      default: 
        i = 0;
        m = jdField_a_of_type_Array2dOfInt[i][0];
        j = jdField_a_of_type_Array2dOfInt[i][1];
        if ((paramInt1 != 0) && (paramInt2 != 0) && (Math.max(paramInt1, paramInt2) < Math.max(m, j)))
        {
          i = Math.min(paramInt1, paramInt2);
          j = Math.max(paramInt1, paramInt2);
        }
        break;
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        m = i;
        i = j;
        j = m;
      }
      for (;;)
      {
        if (k != 0)
        {
          k = Math.min(this.c, j) / 8 * 8;
          m = (int)(k * (this.jdField_b_of_type_Int / this.c)) / 16 * 16;
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("ScreenRecordHelper", 4, "updateRecordParam, pre[" + this.jdField_a_of_type_Lyh + "], display[" + this.jdField_b_of_type_Int + "," + this.c + "], limit[" + i + "," + j + "], come[" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "], record[" + m + "," + k + "]");
          }
          this.jdField_a_of_type_Lyh.jdField_a_of_type_Int = m;
          this.jdField_a_of_type_Lyh.jdField_b_of_type_Int = k;
          if (paramInt3 > 0) {
            this.jdField_a_of_type_Lyh.c = paramInt3;
          }
          if (this.jdField_a_of_type_Lrt != null) {
            this.jdField_a_of_type_Lrt.a(this.jdField_a_of_type_Lyh);
          }
          return;
          k = 0;
          break;
          i = 2;
          break label55;
          i = 1;
          break label55;
          i = 0;
          break label55;
          m = Math.min(this.jdField_b_of_type_Int, i) / 16 * 16;
          k = (int)(m * this.c / this.jdField_b_of_type_Int) / 8 * 8;
        }
      }
      i = m;
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager = ((MediaProjectionManager)paramContext.getApplicationContext().getSystemService("media_projection"));
      Object localObject = new DisplayMetrics();
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_a_of_type_Int = ((DisplayMetrics)localObject).densityDpi;
      localObject = new Point();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealSize((Point)localObject);
      this.jdField_b_of_type_Int = ((Point)localObject).x;
      this.c = ((Point)localObject).y;
      a(0, 0, 15);
      this.jdField_a_of_type_Lrt = new lrt();
      this.jdField_a_of_type_Lrt.a(this.jdField_b_of_type_Int, this.c);
      this.jdField_a_of_type_Lrt.a(this.jdField_a_of_type_Lyh);
      this.jdField_a_of_type_Lrt.a();
    } while (!QLog.isDevelopLevel());
    QLog.i("ScreenRecordHelper", 4, "doBindActivityContext, density[" + this.jdField_a_of_type_Int + "], size[" + this.jdField_b_of_type_Int + "," + this.c + "]");
  }
  
  public void a(lrv paramlrv)
  {
    if (this.jdField_a_of_type_Lrt != null) {
      this.jdField_a_of_type_Lrt.a(paramlrv);
    }
  }
  
  public void a(mlt parammlt)
  {
    this.jdField_a_of_type_Mlt = parammlt;
  }
  
  public boolean a()
  {
    try
    {
      QLog.d("ScreenRecordHelper", 1, "attachRecorder");
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(int paramInt)
  {
    Context localContext = null;
    QLog.d("ScreenRecordHelper", 1, "Start stopProjection fromType:=" + paramInt);
    if (this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay != null)
    {
      this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay.release();
      this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay = null;
    }
    if (this.jdField_a_of_type_AndroidMediaProjectionMediaProjection != null)
    {
      this.jdField_a_of_type_AndroidMediaProjectionMediaProjection.stop();
      this.jdField_a_of_type_AndroidMediaProjectionMediaProjection = null;
    }
    if (this.jdField_a_of_type_Mlt != null) {
      this.jdField_a_of_type_Mlt.a(paramInt);
    }
    a(null);
    a(null);
    this.jdField_b_of_type_Boolean = false;
    mdd.a(VideoController.a().a, true);
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      if ((localContext != null) && (Build.VERSION.SDK_INT >= 21))
      {
        if (paramInt != 1) {
          break label152;
        }
        lyo.b(localContext);
      }
    }
    label152:
    while ((paramInt == 2) || (paramInt == 3))
    {
      return true;
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
    }
    lyo.b(localContext);
    return true;
  }
  
  public boolean a(Intent paramIntent)
  {
    QLog.d("ScreenRecordHelper", 1, "Start startProjection");
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (Context localContext = null; localContext == null; localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      QLog.d("ScreenRecordHelper", 1, "Start startProjection, context is null.");
      return false;
    }
    if (this.jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager == null)
    {
      a(false);
      QLog.d("ScreenRecordHelper", 1, "Start startProjection, mMediaProjectionManager is null.");
      return false;
    }
    this.jdField_a_of_type_AndroidMediaProjectionMediaProjection = this.jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager.getMediaProjection(-1, paramIntent);
    if (this.jdField_a_of_type_AndroidMediaProjectionMediaProjection == null)
    {
      a(false);
      return false;
    }
    a(true);
    d();
    if (this.jdField_a_of_type_Mlt != null) {
      this.jdField_a_of_type_Mlt.a(this.jdField_a_of_type_Lyh, this.jdField_b_of_type_Int, this.c);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      lyo.a(localContext);
    }
    mdd.a(VideoController.a().a, 8, 0L, true);
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new ScreenRecordHelper.1(this), 0L, 1000L);
    this.jdField_b_of_type_Boolean = true;
    return true;
  }
  
  public void b()
  {
    a(false);
  }
  
  public boolean b()
  {
    try
    {
      QLog.d("ScreenRecordHelper", 1, "detachRecorder");
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ScreenRecordHelper", 4, "quit");
    }
    if (this.jdField_a_of_type_Lrt != null)
    {
      this.jdField_a_of_type_Lrt.a(true);
      this.jdField_a_of_type_Lrt = null;
    }
    this.jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay = null;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mls
 * JD-Core Version:    0.7.0.1
 */