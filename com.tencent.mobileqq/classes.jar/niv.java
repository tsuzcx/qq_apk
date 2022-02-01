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
public class niv
  extends nik
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private moo jdField_a_of_type_Moo;
  private nda jdField_a_of_type_Nda;
  private ner jdField_a_of_type_Ner;
  private nft jdField_a_of_type_Nft = new nix(this);
  private volatile nih jdField_a_of_type_Nih;
  private nii jdField_a_of_type_Nii;
  private nij jdField_a_of_type_Nij;
  private niy jdField_a_of_type_Niy = new niw(this);
  private volatile int jdField_b_of_type_Int;
  private volatile long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private volatile String jdField_b_of_type_JavaLangString;
  private volatile nih jdField_b_of_type_Nih;
  private nij jdField_b_of_type_Nij;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 10000L;
  private volatile String jdField_c_of_type_JavaLangString;
  private nij jdField_c_of_type_Nij;
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
  
  public niv(Context paramContext, ner paramner)
  {
    super(paramContext);
    this.jdField_a_of_type_Ner = paramner;
    this.jdField_a_of_type_Nij = new nij();
    this.jdField_a_of_type_Nii = new nii();
    this.jdField_b_of_type_Nij = new nij();
    this.jdField_c_of_type_Nij = new nij();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    paramContext = nfm.b().a();
    if (paramContext != null) {
      paramContext.a(this.jdField_a_of_type_Nft);
    }
    paramContext = nie.a();
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
    Player localPlayer = myk.a().a().b();
    if (localPlayer != null) {
      return myk.a().a().getAccount().equals(localPlayer.uin);
    }
    return false;
  }
  
  private boolean m()
  {
    return myk.a().a().c() == 1;
  }
  
  private boolean n()
  {
    int j = myk.a().a().a();
    return (j != 10) && (j != 0);
  }
  
  private void q()
  {
    myk.a().b(this.jdField_a_of_type_Niy);
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
    if (this.jdField_a_of_type_Moo != null) {
      this.jdField_a_of_type_Moo.b();
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
      GameRecordInfo localGameRecordInfo = myk.a().a().a();
      bkdp.c(this.jdField_a_of_type_JavaLangString, "onSelfGuessActionStart " + bool + " " + this.jdField_b_of_type_Long + " " + localGameRecordInfo);
      if (localGameRecordInfo.startGameTimeMills == 0L)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        myk.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, this.jdField_c_of_type_Long);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    int k = 1;
    int j;
    if ((d()) && (this.jdField_a_of_type_Moo != null))
    {
      boolean bool = this.jdField_a_of_type_Moo.a();
      if (!bool) {
        bkdp.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check audio not ready");
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
      bkdp.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check timeout");
      j = k;
    }
    for (;;)
    {
      if (j != 0) {
        this.jdField_a_of_type_Moo.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      }
      return;
      label131:
      j = 0;
      break;
      label137:
      bkdp.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable checking");
      continue;
      label150:
      this.f = true;
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    bkdp.a(this.jdField_a_of_type_JavaLangString, "onEncodeError " + this.jdField_b_of_type_JavaLangString + " " + paramInt + " " + paramThrowable);
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
      bkdp.c((String)localObject, bool + " w:" + paramInt1 + " h:" + paramInt2 + " l:" + paramInt3 + " t:" + paramInt4);
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
        if (this.jdField_a_of_type_Nih == null) {
          this.jdField_a_of_type_Nih = new nih();
        }
        this.jdField_a_of_type_Nih.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        this.jdField_a_of_type_Nih.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Nih.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_Nih.jdField_c_of_type_Int = paramInt3;
        this.jdField_a_of_type_Nih.jdField_d_of_type_Int = paramInt4;
        this.jdField_a_of_type_Nij.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      finally {}
      bool = false;
      break;
      this.jdField_a_of_type_Nih = null;
    }
  }
  
  public void a(View paramView)
  {
    if ((m()) && (l()))
    {
      boolean bool = d();
      bkdp.c(this.jdField_a_of_type_JavaLangString, "onTopicViewDismiss " + bool);
      a(null, 0, 0, 0, 0);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if ((m()) && (l()))
    {
      paramBoolean = d();
      bkdp.c(this.jdField_a_of_type_JavaLangString, "onAnswerViewShow " + paramBoolean);
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
    bkdp.c(this.jdField_a_of_type_JavaLangString, "onEncodeFinish " + this.jdField_b_of_type_JavaLangString + " " + this.jdField_c_of_type_JavaLangString);
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
        bkdp.a(this.jdField_a_of_type_JavaLangString, "onEncodeFinish", paramString);
      }
    }
    this.jdField_b_of_type_JavaLangString = null;
    bkdp.c(this.jdField_a_of_type_JavaLangString, "onEncodeFinish delete=" + bool1);
    myk.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
  }
  
  public void a(nda paramnda)
  {
    this.jdField_a_of_type_Nda = paramnda;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    bkdp.c(this.jdField_a_of_type_JavaLangString, "enableDrawDefaultBg " + paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = nhs.a("avgame_actfallback@2x.png");
      }
      this.jdField_c_of_type_Nij.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, 0, 0);
      return;
    }
    this.jdField_c_of_type_Nij.a(null, 0, 0, 0, 0);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.g = paramBoolean;
    this.jdField_a_of_type_Nii.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((d()) && (this.jdField_a_of_type_Moo != null) && (paramArrayOfByte != null)) {
      this.jdField_a_of_type_Moo.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
    }
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Nij.a(paramInt1, paramInt2);
    this.jdField_b_of_type_Nij.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Nii.a(paramInt1, paramInt2);
    this.jdField_c_of_type_Nij.a(paramInt1, paramInt2);
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
    if (this.jdField_a_of_type_Moo == null) {}
    int j;
    try
    {
      if (a()) {
        this.jdField_a_of_type_Moo = new moo();
      }
      if (this.jdField_a_of_type_Moo == null)
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
        this.jdField_a_of_type_Moo = null;
        bkdp.a(this.jdField_a_of_type_JavaLangString, "oom " + localOutOfMemoryError);
      }
      this.jdField_b_of_type_JavaLangString = b();
      bkdp.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord path=" + this.jdField_b_of_type_JavaLangString + ", w=" + paramInt1 + ", h=" + paramInt2 + ", rh=" + paramInt2);
      j = this.jdField_a_of_type_Moi.f;
      if (paramInt1 <= j) {
        break label460;
      }
    }
    paramInt2 = (int)(1.0F * j / paramInt1 * paramInt2);
    bkdp.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord calc size, maxWidth=" + j + ", realWidth=" + j + ", realHeight=" + paramInt2);
    paramInt1 = j;
    label460:
    for (;;)
    {
      if (paramInt2 % 2 == 1) {
        paramInt2 += 1;
      }
      for (;;)
      {
        bkdp.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord rW=" + paramInt1 + ", rH=" + paramInt2);
        this.jdField_b_of_type_Int = paramInt1;
        this.jdField_c_of_type_Int = paramInt2;
        bbmc localbbmc = new bbmc(this.jdField_b_of_type_JavaLangString, paramInt1, paramInt2, 5120000, 1, false, 0);
        localbbmc.a(EGL14.eglGetCurrentContext());
        if (this.jdField_a_of_type_Moo != null) {
          this.jdField_a_of_type_Moo.a(localbbmc, this);
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
      bkdp.c(this.jdField_a_of_type_JavaLangString, "onSelfGuessActionEnd " + bool);
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
      bkdp.c((String)localObject, bool + " w:" + paramInt1 + " h:" + paramInt2 + " l:" + paramInt3 + " t:" + paramInt4);
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
        if (this.jdField_b_of_type_Nih == null) {
          this.jdField_b_of_type_Nih = new nih();
        }
        this.jdField_b_of_type_Nih.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        this.jdField_b_of_type_Nih.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Nih.jdField_b_of_type_Int = paramInt2;
        this.jdField_b_of_type_Nih.jdField_c_of_type_Int = paramInt3;
        this.jdField_b_of_type_Nih.jdField_d_of_type_Int = paramInt4;
        this.jdField_b_of_type_Nij.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      finally {}
      bool = false;
      break;
      this.jdField_b_of_type_Nih = null;
    }
  }
  
  public void b(View paramView)
  {
    if ((m()) && (l()))
    {
      boolean bool = d();
      bkdp.c(this.jdField_a_of_type_JavaLangString, "onTopicViewSwitch " + bool);
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
    bkdp.c(this.jdField_a_of_type_JavaLangString, "onActivityStart ");
    if ((m()) && (l()) && (n()))
    {
      GameRecordInfo localGameRecordInfo = myk.a().a().a();
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
      bkdp.c(this.jdField_a_of_type_JavaLangString, "onActivityStart " + localGameRecordInfo + " " + bool1);
      if (!bool1)
      {
        long l = this.jdField_c_of_type_Long - (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        bkdp.c(this.jdField_a_of_type_JavaLangString, "onActivityStart remainTime:" + l);
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
      bkdp.c(this.jdField_a_of_type_JavaLangString, "onAnswerViewDismiss " + bool);
      if (bool)
      {
        b(null, 0, 0, 0, 0);
        a(false, 0.0F, 0.0F, 0.0F, 0.0F);
      }
    }
  }
  
  public void d()
  {
    bkdp.c(this.jdField_a_of_type_JavaLangString, "onActivityStop ");
    if (m())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void e()
  {
    bkdp.c(this.jdField_a_of_type_JavaLangString, "onGameOver ");
    if (m())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Nih = null;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Nih = null;
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
        myk.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
        myk.a().a(this.jdField_a_of_type_Niy);
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
          bkdp.c(this.jdField_a_of_type_JavaLangString, "start record come." + d());
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
            bkdp.c(this.jdField_a_of_type_JavaLangString, "start record but camera close");
            a(true);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 200L);
          this.jdField_c_of_type_Boolean = true;
          return true;
          this.jdField_d_of_type_Boolean = true;
        }
        bkdp.c(this.jdField_a_of_type_JavaLangString, "end record come." + d());
        if (d()) {
          k();
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        return true;
        bkdp.c(this.jdField_a_of_type_JavaLangString, "render no camera come." + f() + d());
        if (f())
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
          return true;
        }
        if (d())
        {
          if ((this.jdField_a_of_type_Moo != null) && (this.jdField_a_of_type_Moo.a())) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            boolean bool2 = bool3;
            if (this.jdField_a_of_type_Moo != null)
            {
              bool2 = bool3;
              if (this.jdField_a_of_type_Moo.b()) {
                bool2 = true;
              }
            }
            bkdp.c(this.jdField_a_of_type_JavaLangString, "render no camera ." + bool1 + " " + bool2);
            if ((this.jdField_a_of_type_Ner == null) || (this.jdField_a_of_type_Ner.a() == null)) {
              break;
            }
            this.jdField_a_of_type_Ner.a().requestRender();
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 50L);
            return true;
          }
        }
        bkdp.c(this.jdField_a_of_type_JavaLangString, "render no camera ." + this.jdField_d_of_type_Boolean);
      } while ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Ner == null) || (this.jdField_a_of_type_Ner.a() == null));
      this.jdField_a_of_type_Ner.a().requestRender();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 50L);
      return true;
      bkdp.c(this.jdField_a_of_type_JavaLangString, "destroy");
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
    bkdp.c(this.jdField_a_of_type_JavaLangString, "onEncodeRealStart " + this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean j()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_Nih != null) && (this.jdField_a_of_type_Nih.jdField_a_of_type_AndroidGraphicsBitmap != null))
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
    if (this.jdField_a_of_type_Moo != null) {
      this.jdField_a_of_type_Moo.a();
    }
    q();
  }
  
  public boolean k()
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_b_of_type_Nih != null) && (this.jdField_b_of_type_Nih.jdField_a_of_type_AndroidGraphicsBitmap != null))
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
    bkdp.c(this.jdField_a_of_type_JavaLangString, "onDestroy ");
    super.l();
    r();
    AVGameCameraAssistant localAVGameCameraAssistant = nfm.b().a();
    if (localAVGameCameraAssistant != null) {
      localAVGameCameraAssistant.b(this.jdField_a_of_type_Nft);
    }
    this.jdField_a_of_type_Ner = null;
    this.jdField_a_of_type_Nda = null;
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
        bkdp.c(this.jdField_a_of_type_JavaLangString, "checkFirstFramePhoto record first photo done");
        this.jdField_d_of_type_Boolean = false;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bkdp.c(this.jdField_a_of_type_JavaLangString, "checkFirstFramePhoto " + localThrowable);
      }
    }
  }
  
  public void n()
  {
    if (i()) {
      this.jdField_c_of_type_Nij.h();
    }
    if (j()) {
      this.jdField_a_of_type_Nij.h();
    }
    if (h()) {
      this.jdField_a_of_type_Nii.h();
    }
    if (k()) {
      this.jdField_b_of_type_Nij.h();
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Nij != null) {
      this.jdField_a_of_type_Nij.d();
    }
    if (this.jdField_a_of_type_Nii != null) {
      this.jdField_a_of_type_Nii.d();
    }
    if (this.jdField_b_of_type_Nij != null) {
      this.jdField_b_of_type_Nij.d();
    }
    if (this.jdField_c_of_type_Nij != null) {
      this.jdField_c_of_type_Nij.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     niv
 * JD-Core Version:    0.7.0.1
 */