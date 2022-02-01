import android.annotation.TargetApi;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.videorecord.GuessPictureGameRecordCtrl.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

@TargetApi(17)
public class ngs
  extends ngp
{
  private long jdField_a_of_type_Long;
  private batj jdField_a_of_type_Batj;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private mnr jdField_a_of_type_Mnr;
  private ngr jdField_a_of_type_Ngr = new ngr();
  private ngt jdField_a_of_type_Ngt;
  private ngu jdField_a_of_type_Ngu = new ngu();
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private volatile boolean jdField_e_of_type_Boolean;
  private int f;
  
  public ngs(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 720) {
      this.jdField_b_of_type_Int = paramInt1;
    }
    for (this.jdField_c_of_type_Int = paramInt2;; this.jdField_c_of_type_Int = ((int)(paramInt2 * (720.0F / paramInt1))))
    {
      this.jdField_b_of_type_Int = bann.a(this.jdField_b_of_type_Int);
      this.jdField_c_of_type_Int = bann.a(this.jdField_c_of_type_Int);
      return;
      this.jdField_b_of_type_Int = 720;
    }
  }
  
  private void b(ngt paramngt, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ngt = paramngt;
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_Ngr.a(paramInt1, paramInt2, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Ngu.a(b(), c(), this.jdField_a_of_type_Ngr);
    this.jdField_a_of_type_JavaLangRunnable = new GuessPictureGameRecordCtrl.1(this);
  }
  
  private boolean f()
  {
    return mxl.a().a().c() == 2;
  }
  
  private boolean g()
  {
    if ((this.jdField_a_of_type_Ngt.a()) || (this.jdField_a_of_type_Ngr.b()))
    {
      ArrayList localArrayList = this.jdField_a_of_type_Ngt.a();
      this.f = this.jdField_a_of_type_Ngr.a(localArrayList);
      this.jdField_a_of_type_Ngu.a(localArrayList);
      this.jdField_a_of_type_Ngr.a();
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "addNextFrame, dataList size:", Integer.valueOf(localArrayList.size()) });
      }
    }
    if ((this.jdField_a_of_type_Mnr != null) && (this.f > 0) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < this.jdField_e_of_type_Int))
    {
      this.jdField_a_of_type_Mnr.a(3553, this.f, null, null, SystemClock.elapsedRealtimeNanos());
      return true;
    }
    return false;
  }
  
  protected String a()
  {
    return "GuessPictureGameRecordCtrl";
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.jdField_c_of_type_Boolean = true;
    k();
    QLog.e("GuessPictureGameRecordCtrl", 1, paramThrowable, new Object[] { "onEncodeError, errorCode", Integer.valueOf(paramInt) });
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onAnswerViewShow, isRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    this.jdField_a_of_type_Ngr.a(paramView, paramInt, paramBoolean);
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ngu.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Ngu.a(paramBoolean);
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +28 -> 35
    //   10: ldc 119
    //   12: iconst_2
    //   13: iconst_2
    //   14: anewarray 121	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: ldc 189
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_0
    //   25: getfield 78	ngs:jdField_e_of_type_Boolean	Z
    //   28: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: aastore
    //   32: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 53	ngs:jdField_d_of_type_Boolean	Z
    //   40: aload_0
    //   41: getfield 53	ngs:jdField_d_of_type_Boolean	Z
    //   44: ifeq +31 -> 75
    //   47: aload_0
    //   48: getfield 78	ngs:jdField_e_of_type_Boolean	Z
    //   51: ifeq +24 -> 75
    //   54: aload_0
    //   55: getfield 38	ngs:jdField_a_of_type_Ngu	Lngu;
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 162	ngs:jdField_c_of_type_Boolean	Z
    //   63: ifne +15 -> 78
    //   66: aload_1
    //   67: iload_2
    //   68: aload_0
    //   69: getfield 191	ngs:jdField_a_of_type_Long	J
    //   72: invokevirtual 194	ngu:a	(ZJ)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: iconst_0
    //   79: istore_2
    //   80: goto -14 -> 66
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	ngs
    //   0	88	1	paramString	String
    //   1	79	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	35	83	finally
    //   35	66	83	finally
    //   66	75	83	finally
  }
  
  public void a(ArrayList<ngm> paramArrayList)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ngu.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Ngu.a(paramArrayList);
    }
  }
  
  public void a(ngt paramngt, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "scheduleStartRecord");
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b(paramngt, paramInt1, paramInt2);
      l = ngj.b().jdField_b_of_type_Int * 1000;
      paramngt = mxl.a().a().a();
      if ((!f()) || (paramngt.startGameTimeMills <= 0L)) {
        break label222;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "scheduleStartRecord, gameRecordInfo:", paramngt });
      }
      if ((paramngt.videoFilePath == null) || (!new File(paramngt.videoFilePath).exists())) {
        break label136;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGameRecordCtrl", 2, "scheduleStartRecord return, video file exists");
      }
    }
    return;
    label136:
    this.jdField_a_of_type_Long = paramngt.startGameTimeMills;
    long l = Math.min(Math.max(System.currentTimeMillis() - this.jdField_a_of_type_Long, l), 0L);
    for (;;)
    {
      mxl.a().a().a(null, null, this.jdField_a_of_type_Long);
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "scheduleStartRecord indeed, delayTime:", Long.valueOf(l) });
      return;
      label222:
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Mnr != null) && (paramArrayOfByte != null)) {
      this.jdField_a_of_type_Mnr.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
    }
  }
  
  public void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onAnswerViewDismiss, isRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    this.jdField_a_of_type_Ngr.a(paramView);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onActivityStop, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    m();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onGameOver, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    m();
  }
  
  public boolean e()
  {
    super.e();
    n();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Mnr = new mnr();
    this.jdField_a_of_type_Mnr.a(this.jdField_a_of_type_Batj, this);
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "startRecord");
    }
    return true;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "onEncodeStart, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    if (this.jdField_a_of_type_Boolean) {
      g();
    }
  }
  
  public void h()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.e("GuessPictureGameRecordCtrl", 1, "onEncodeVideoFrame, mIsRecording false");
      k();
    }
    do
    {
      do
      {
        return;
      } while (g());
      k();
    } while (!QLog.isColorLevel());
    QLog.e("GuessPictureGameRecordCtrl", 2, "onEncodeVideoFrame, stop record");
  }
  
  public void i() {}
  
  public void k()
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.e("GuessPictureGameRecordCtrl", 1, new Object[] { "endRecord, mIsRecording:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    do
    {
      return;
      super.k();
    } while (this.jdField_a_of_type_Mnr == null);
    this.jdField_a_of_type_Mnr.a();
    this.jdField_a_of_type_Mnr.b();
  }
  
  /* Error */
  public void m()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +29 -> 36
    //   10: ldc 119
    //   12: iconst_2
    //   13: iconst_2
    //   14: anewarray 121	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 322
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload_0
    //   26: getfield 53	ngs:jdField_d_of_type_Boolean	Z
    //   29: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: aastore
    //   33: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 78	ngs:jdField_e_of_type_Boolean	Z
    //   41: aload_0
    //   42: getfield 175	ngs:jdField_a_of_type_Boolean	Z
    //   45: ifne +68 -> 113
    //   48: invokestatic 256	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   51: aload_0
    //   52: getfield 76	ngs:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   55: invokevirtual 326	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   58: aload_0
    //   59: getfield 53	ngs:jdField_d_of_type_Boolean	Z
    //   62: ifeq +38 -> 100
    //   65: aload_0
    //   66: getfield 78	ngs:jdField_e_of_type_Boolean	Z
    //   69: ifeq +31 -> 100
    //   72: aload_0
    //   73: getfield 203	ngs:jdField_b_of_type_Boolean	Z
    //   76: ifeq +24 -> 100
    //   79: aload_0
    //   80: getfield 38	ngs:jdField_a_of_type_Ngu	Lngu;
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 162	ngs:jdField_c_of_type_Boolean	Z
    //   88: ifne +20 -> 108
    //   91: aload_2
    //   92: iload_1
    //   93: aload_0
    //   94: getfield 191	ngs:jdField_a_of_type_Long	J
    //   97: invokevirtual 194	ngu:a	(ZJ)V
    //   100: aload_0
    //   101: iconst_0
    //   102: putfield 203	ngs:jdField_b_of_type_Boolean	Z
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: iconst_0
    //   109: istore_1
    //   110: goto -19 -> 91
    //   113: aload_0
    //   114: invokevirtual 165	ngs:k	()V
    //   117: goto -17 -> 100
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	ngs
    //   1	109	1	bool	boolean
    //   83	9	2	localngu	ngu
    //   120	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	36	120	finally
    //   36	91	120	finally
    //   91	100	120	finally
    //   100	105	120	finally
    //   113	117	120	finally
  }
  
  public void n()
  {
    this.jdField_d_of_type_Int = 5120000;
    this.jdField_e_of_type_Int = (ngj.b().jdField_c_of_type_Int * 1000);
    this.jdField_a_of_type_Batj = new batj(this.jdField_a_of_type_Ngu.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 1, false, 0);
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, new Object[] { "initRecordCodecParams, bitRate:", Integer.valueOf(this.jdField_d_of_type_Int) });
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameRecordCtrl", 2, "onVideoMuxerWaiting");
    }
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      Thread.sleep(300L);
      g();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GuessPictureGameRecordCtrl", 2, new Object[] { "onVideoMuxerWaiting", localException.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ngs
 * JD-Core Version:    0.7.0.1
 */