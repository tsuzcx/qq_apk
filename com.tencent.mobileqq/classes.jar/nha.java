import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.3;
import com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.4;
import com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.5;
import com.tencent.avgame.videorecord.ShowAndGuessGameVideoRecordCtrl.6;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.nio.Buffer;
import java.nio.IntBuffer;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

@RequiresApi(api=17)
public class nha
  extends ngp
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private mnr jdField_a_of_type_Mnr;
  private nbn jdField_a_of_type_Nbn;
  private ncz jdField_a_of_type_Ncz;
  private nea jdField_a_of_type_Nea = new nhc(this);
  private volatile ngm jdField_a_of_type_Ngm;
  private ngn jdField_a_of_type_Ngn;
  private ngo jdField_a_of_type_Ngo;
  private nhd jdField_a_of_type_Nhd = new nhb(this);
  private volatile int jdField_b_of_type_Int;
  private volatile long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private volatile String jdField_b_of_type_JavaLangString;
  private volatile ngm jdField_b_of_type_Ngm;
  private ngo jdField_b_of_type_Ngo;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 10000L;
  private volatile String jdField_c_of_type_JavaLangString;
  private ngo jdField_c_of_type_Ngo;
  private volatile boolean jdField_c_of_type_Boolean;
  private volatile int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long = 15000L;
  private volatile boolean jdField_d_of_type_Boolean;
  private volatile int jdField_e_of_type_Int;
  private volatile boolean jdField_e_of_type_Boolean;
  private boolean f;
  private volatile boolean g;
  private volatile boolean h;
  private volatile boolean i;
  
  public nha(Context paramContext, ncz paramncz)
  {
    super(paramContext);
    this.jdField_a_of_type_Ncz = paramncz;
    this.jdField_a_of_type_Ngo = new ngo();
    this.jdField_a_of_type_Ngn = new ngn();
    this.jdField_b_of_type_Ngo = new ngo();
    this.jdField_c_of_type_Ngo = new ngo();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    paramContext = ndt.b().a();
    if (paramContext != null) {
      paramContext.a(this.jdField_a_of_type_Nea);
    }
    paramContext = ngj.a();
    if (paramContext != null)
    {
      this.jdField_c_of_type_Long = (paramContext.jdField_b_of_type_Int * 1000);
      this.jdField_d_of_type_Long = (paramContext.jdField_c_of_type_Int * 1000);
      if (this.jdField_c_of_type_Long > 2000L) {
        this.jdField_c_of_type_Long -= 2000L;
      }
    }
  }
  
  private boolean l()
  {
    Player localPlayer = mxl.a().a().b();
    if (localPlayer != null) {
      return mxl.a().a().getAccount().equals(localPlayer.uin);
    }
    return false;
  }
  
  private boolean m()
  {
    return mxl.a().a().c() == 1;
  }
  
  private boolean n()
  {
    int j = mxl.a().a().a();
    return (j != 10) && (j != 0);
  }
  
  private void q()
  {
    mxl.a().b(this.jdField_a_of_type_Nhd);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.f = false;
    this.jdField_a_of_type_Long = 0L;
    this.h = false;
    this.g = false;
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (d()) {
      k();
    }
    q();
    if (this.jdField_a_of_type_Mnr != null) {
      this.jdField_a_of_type_Mnr.b();
    }
  }
  
  protected String a()
  {
    return "ShowAndGuessGameVideoRecordCtrl";
  }
  
  public void a()
  {
    if (m())
    {
      boolean bool = d();
      GameRecordInfo localGameRecordInfo = mxl.a().a().a();
      bjcq.c(this.jdField_a_of_type_JavaLangString, "onSelfGuessActionStart " + bool + " " + this.jdField_b_of_type_Long + " " + localGameRecordInfo);
      if (localGameRecordInfo.startGameTimeMills == 0L)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        mxl.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, this.jdField_c_of_type_Long);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    int k = 1;
    int j;
    if ((d()) && (this.jdField_a_of_type_Mnr != null))
    {
      boolean bool = this.jdField_a_of_type_Mnr.a();
      if (!bool) {
        bjcq.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check audio not ready");
      }
      if ((!this.f) && (!bool)) {
        break label131;
      }
      j = 1;
      if (j != 0) {
        break label150;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L) {
        break label137;
      }
      this.f = true;
      bjcq.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check timeout");
      j = k;
    }
    for (;;)
    {
      if (j != 0) {
        this.jdField_a_of_type_Mnr.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      }
      return;
      label131:
      j = 0;
      break;
      label137:
      bjcq.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable checking");
      continue;
      label150:
      this.f = true;
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    bjcq.a(this.jdField_a_of_type_JavaLangString, "onEncodeError " + this.jdField_b_of_type_JavaLangString + " " + paramInt + " " + paramThrowable);
    this.i = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ShowAndGuessGameVideoRecordCtrl.4(this), 50L);
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("setDrawGameTopicTextureData ");
    boolean bool;
    if (paramBitmap != null)
    {
      bool = true;
      bjcq.c((String)localObject, bool + " w:" + paramInt1 + " h:" + paramInt2 + " l:" + paramInt3 + " t:" + paramInt4);
      localObject = this.jdField_a_of_type_JavaLangObject;
      if (paramBitmap == null) {
        break label182;
      }
    }
    for (;;)
    {
      label182:
      try
      {
        if (this.jdField_a_of_type_Ngm == null) {
          this.jdField_a_of_type_Ngm = new ngm();
        }
        this.jdField_a_of_type_Ngm.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        this.jdField_a_of_type_Ngm.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Ngm.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_Ngm.jdField_c_of_type_Int = paramInt3;
        this.jdField_a_of_type_Ngm.jdField_d_of_type_Int = paramInt4;
        this.jdField_a_of_type_Ngo.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      finally {}
      bool = false;
      break;
      this.jdField_a_of_type_Ngm = null;
    }
  }
  
  public void a(View paramView)
  {
    if ((m()) && (l()))
    {
      boolean bool = d();
      bjcq.c(this.jdField_a_of_type_JavaLangString, "onTopicViewDismiss " + bool);
      a(null, 0, 0, 0, 0);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if ((m()) && (l()))
    {
      paramBoolean = d();
      bjcq.c(this.jdField_a_of_type_JavaLangString, "onAnswerViewShow " + paramBoolean);
      if ((paramBoolean) && (paramView != null))
      {
        if (!paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(true);
        }
        paramView.requestLayout();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ShowAndGuessGameVideoRecordCtrl.6(this, paramInt, paramView), 500L);
      }
    }
  }
  
  public void a(String paramString)
  {
    boolean bool1 = false;
    bjcq.c(this.jdField_a_of_type_JavaLangString, "onEncodeFinish " + this.jdField_b_of_type_JavaLangString + " " + this.jdField_c_of_type_JavaLangString);
    if (this.i) {
      this.i = false;
    }
    try
    {
      boolean bool2 = new File(paramString).delete();
      bool1 = bool2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        bjcq.a(this.jdField_a_of_type_JavaLangString, "onEncodeFinish", paramString);
      }
    }
    this.jdField_b_of_type_JavaLangString = null;
    bjcq.c(this.jdField_a_of_type_JavaLangString, "onEncodeFinish delete=" + bool1);
    mxl.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
  }
  
  public void a(nbn paramnbn)
  {
    this.jdField_a_of_type_Nbn = paramnbn;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    bjcq.c(this.jdField_a_of_type_JavaLangString, "enableDrawDefaultBg " + paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = nfx.a("avgame_actfallback@2x.png");
      }
      this.jdField_c_of_type_Ngo.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, 0, 0);
      return;
    }
    this.jdField_c_of_type_Ngo.a(null, 0, 0, 0, 0);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.g = paramBoolean;
    this.jdField_a_of_type_Ngn.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((d()) && (this.jdField_a_of_type_Mnr != null) && (paramArrayOfByte != null)) {
      this.jdField_a_of_type_Mnr.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
    }
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ngo.a(paramInt1, paramInt2);
    this.jdField_b_of_type_Ngo.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Ngn.a(paramInt1, paramInt2);
    this.jdField_c_of_type_Ngo.a(paramInt1, paramInt2);
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_c_of_type_JavaLangString = c();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.f = false;
    if (!b())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
      return new int[] { 0, 0 };
    }
    if (this.jdField_a_of_type_Mnr == null) {}
    int j;
    try
    {
      if (a()) {
        this.jdField_a_of_type_Mnr = new mnr();
      }
      if (this.jdField_a_of_type_Mnr == null)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = true;
        return new int[] { 0, 0 };
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_Mnr = null;
        bjcq.a(this.jdField_a_of_type_JavaLangString, "oom " + localOutOfMemoryError);
      }
      this.jdField_b_of_type_JavaLangString = b();
      bjcq.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord path=" + this.jdField_b_of_type_JavaLangString + ", w=" + paramInt1 + ", h=" + paramInt2 + ", rh=" + paramInt2);
      j = this.jdField_a_of_type_Mnl.f;
      if (paramInt1 <= j) {
        break label460;
      }
    }
    paramInt2 = (int)(1.0F * j / paramInt1 * paramInt2);
    bjcq.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord calc size, maxWidth=" + j + ", realWidth=" + j + ", realHeight=" + paramInt2);
    paramInt1 = j;
    label460:
    for (;;)
    {
      if (paramInt2 % 2 == 1) {
        paramInt2 += 1;
      }
      for (;;)
      {
        bjcq.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord rW=" + paramInt1 + ", rH=" + paramInt2);
        this.jdField_b_of_type_Int = paramInt1;
        this.jdField_c_of_type_Int = paramInt2;
        batj localbatj = new batj(this.jdField_b_of_type_JavaLangString, paramInt1, paramInt2, 5120000, 1, false, 0);
        localbatj.a(EGL14.eglGetCurrentContext());
        if (this.jdField_a_of_type_Mnr != null) {
          this.jdField_a_of_type_Mnr.a(localbatj, this);
        }
        for (;;)
        {
          return new int[] { paramInt1, paramInt2 };
          a(5, null);
        }
      }
    }
  }
  
  public void b()
  {
    if (m())
    {
      boolean bool = d();
      bjcq.c(this.jdField_a_of_type_JavaLangString, "onSelfGuessActionEnd " + bool);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void b(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("setDrawGameAnswerTextureData ");
    boolean bool;
    if (paramBitmap != null)
    {
      bool = true;
      bjcq.c((String)localObject, bool + " w:" + paramInt1 + " h:" + paramInt2 + " l:" + paramInt3 + " t:" + paramInt4);
      localObject = this.jdField_b_of_type_JavaLangObject;
      if (paramBitmap == null) {
        break label182;
      }
    }
    for (;;)
    {
      label182:
      try
      {
        if (this.jdField_b_of_type_Ngm == null) {
          this.jdField_b_of_type_Ngm = new ngm();
        }
        this.jdField_b_of_type_Ngm.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        this.jdField_b_of_type_Ngm.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Ngm.jdField_b_of_type_Int = paramInt2;
        this.jdField_b_of_type_Ngm.jdField_c_of_type_Int = paramInt3;
        this.jdField_b_of_type_Ngm.jdField_d_of_type_Int = paramInt4;
        this.jdField_b_of_type_Ngo.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      finally {}
      bool = false;
      break;
      this.jdField_b_of_type_Ngm = null;
    }
  }
  
  public void b(View paramView)
  {
    if ((m()) && (l()))
    {
      boolean bool = d();
      bjcq.c(this.jdField_a_of_type_JavaLangString, "onTopicViewSwitch " + bool);
      if (paramView != null)
      {
        if (!paramView.isDrawingCacheEnabled()) {
          paramView.setDrawingCacheEnabled(true);
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ShowAndGuessGameVideoRecordCtrl.5(this, paramView), 500L);
      }
    }
  }
  
  public void c()
  {
    bjcq.c(this.jdField_a_of_type_JavaLangString, "onActivityStart ");
    if ((m()) && (l()) && (n()))
    {
      GameRecordInfo localGameRecordInfo = mxl.a().a().a();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localGameRecordInfo != null)
      {
        bool1 = bool2;
        if (localGameRecordInfo.startGameTimeMills > 0L)
        {
          this.jdField_b_of_type_Long = localGameRecordInfo.startGameTimeMills;
          this.jdField_b_of_type_JavaLangString = localGameRecordInfo.videoFilePath;
          this.jdField_c_of_type_JavaLangString = localGameRecordInfo.photoFilePath;
          bool1 = bool2;
          if (localGameRecordInfo.photoFilePath != null)
          {
            bool1 = bool2;
            if (new File(localGameRecordInfo.photoFilePath).exists()) {
              bool1 = true;
            }
          }
        }
      }
      bjcq.c(this.jdField_a_of_type_JavaLangString, "onActivityStart " + localGameRecordInfo + " " + bool1);
      if (!bool1)
      {
        long l = this.jdField_c_of_type_Long - (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        bjcq.c(this.jdField_a_of_type_JavaLangString, "onActivityStart remainTime:" + l);
        l = Math.max(l, 1000L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, l);
      }
    }
  }
  
  public void c(View paramView)
  {
    if ((m()) && (l()))
    {
      boolean bool = d();
      bjcq.c(this.jdField_a_of_type_JavaLangString, "onAnswerViewDismiss " + bool);
      if (bool)
      {
        b(null, 0, 0, 0, 0);
        a(false, 0.0F, 0.0F, 0.0F, 0.0F);
      }
    }
  }
  
  public void d()
  {
    bjcq.c(this.jdField_a_of_type_JavaLangString, "onActivityStop ");
    if (m())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void e()
  {
    bjcq.c(this.jdField_a_of_type_JavaLangString, "onGameOver ");
    if (m())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Ngm = null;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Ngm = null;
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (l())
    {
      bool1 = bool2;
      if (super.e())
      {
        q();
        this.jdField_b_of_type_JavaLangString = null;
        this.jdField_c_of_type_JavaLangString = null;
        this.i = false;
        mxl.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
        mxl.a().a(this.jdField_a_of_type_Nhd);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean f()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool3 = false;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          bjcq.c(this.jdField_a_of_type_JavaLangString, "start record come." + d());
        } while (d());
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        paramMessage = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if (paramMessage != null) {
          this.jdField_e_of_type_Boolean = CameraUtils.a(paramMessage).b(-1L);
        }
        if (e()) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_d_of_type_Long);
        }
        for (;;)
        {
          if (!f())
          {
            bjcq.c(this.jdField_a_of_type_JavaLangString, "start record but camera close");
            a(true);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 200L);
          this.jdField_c_of_type_Boolean = true;
          return true;
          this.jdField_d_of_type_Boolean = true;
        }
        bjcq.c(this.jdField_a_of_type_JavaLangString, "end record come." + d());
        if (d()) {
          k();
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        return true;
        bjcq.c(this.jdField_a_of_type_JavaLangString, "render no camera come." + f() + d());
        if (f())
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
          return true;
        }
        if (d())
        {
          if ((this.jdField_a_of_type_Mnr != null) && (this.jdField_a_of_type_Mnr.a())) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            boolean bool2 = bool3;
            if (this.jdField_a_of_type_Mnr != null)
            {
              bool2 = bool3;
              if (this.jdField_a_of_type_Mnr.b()) {
                bool2 = true;
              }
            }
            bjcq.c(this.jdField_a_of_type_JavaLangString, "render no camera ." + bool1 + " " + bool2);
            if ((this.jdField_a_of_type_Ncz == null) || (this.jdField_a_of_type_Ncz.a() == null)) {
              break;
            }
            this.jdField_a_of_type_Ncz.a().requestRender();
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 50L);
            return true;
          }
        }
        bjcq.c(this.jdField_a_of_type_JavaLangString, "render no camera ." + this.jdField_d_of_type_Boolean);
      } while ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Ncz == null) || (this.jdField_a_of_type_Ncz.a() == null));
      this.jdField_a_of_type_Ncz.a().requestRender();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 50L);
      return true;
      bjcq.c(this.jdField_a_of_type_JavaLangString, "destroy");
      r();
      return true;
      this.jdField_c_of_type_Boolean = false;
      return true;
    } while ((!d()) || (!f()));
    a(false);
    return true;
  }
  
  public boolean i()
  {
    return this.h;
  }
  
  public void j()
  {
    bjcq.c(this.jdField_a_of_type_JavaLangString, "onEncodeRealStart " + this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean j()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_Ngm != null) && (this.jdField_a_of_type_Ngm.jdField_a_of_type_AndroidGraphicsBitmap != null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void k()
  {
    super.k();
    if (this.jdField_a_of_type_Mnr != null) {
      this.jdField_a_of_type_Mnr.a();
    }
    q();
  }
  
  public boolean k()
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_b_of_type_Ngm != null) && (this.jdField_b_of_type_Ngm.jdField_a_of_type_AndroidGraphicsBitmap != null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void l()
  {
    bjcq.c(this.jdField_a_of_type_JavaLangString, "onDestroy ");
    super.l();
    r();
    AVGameCameraAssistant localAVGameCameraAssistant = ndt.b().a();
    if (localAVGameCameraAssistant != null) {
      localAVGameCameraAssistant.b(this.jdField_a_of_type_Nea);
    }
    this.jdField_a_of_type_Ncz = null;
    this.jdField_a_of_type_Nbn = null;
  }
  
  public void m()
  {
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
      this.jdField_b_of_type_Boolean = true;
    }
    try
    {
      Object localObject = IntBuffer.allocate(this.jdField_d_of_type_Int * this.jdField_e_of_type_Int);
      GLES20.glReadPixels(0, 0, this.jdField_d_of_type_Int, this.jdField_d_of_type_Int, 6408, 5121, (Buffer)localObject);
      localObject = ((IntBuffer)localObject).array();
      ThreadManager.getSubThreadHandler().post(new ShowAndGuessGameVideoRecordCtrl.3(this, (int[])localObject));
      if (this.jdField_d_of_type_Boolean)
      {
        bjcq.c(this.jdField_a_of_type_JavaLangString, "checkFirstFramePhoto record first photo done");
        this.jdField_d_of_type_Boolean = false;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bjcq.c(this.jdField_a_of_type_JavaLangString, "checkFirstFramePhoto " + localThrowable);
      }
    }
  }
  
  public void n()
  {
    if (i()) {
      this.jdField_c_of_type_Ngo.h();
    }
    if (j()) {
      this.jdField_a_of_type_Ngo.h();
    }
    if (h()) {
      this.jdField_a_of_type_Ngn.h();
    }
    if (k()) {
      this.jdField_b_of_type_Ngo.h();
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Ngo != null) {
      this.jdField_a_of_type_Ngo.d();
    }
    if (this.jdField_a_of_type_Ngn != null) {
      this.jdField_a_of_type_Ngn.d();
    }
    if (this.jdField_b_of_type_Ngo != null) {
      this.jdField_b_of_type_Ngo.d();
    }
    if (this.jdField_c_of_type_Ngo != null) {
      this.jdField_c_of_type_Ngo.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nha
 * JD-Core Version:    0.7.0.1
 */