import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.2;
import com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.3;
import com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.4;
import com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.5;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.io.File;
import java.nio.Buffer;
import java.nio.IntBuffer;
import mqq.os.MqqHandler;

@RequiresApi(api=17)
public class nrf
  extends nqz
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private mou jdField_a_of_type_Mou;
  private nmq jdField_a_of_type_Nmq;
  private volatile nqw jdField_a_of_type_Nqw;
  private nqx jdField_a_of_type_Nqx = new nqx();
  private nqy jdField_a_of_type_Nqy = new nqy();
  private nrn jdField_a_of_type_Nrn = new nrg(this);
  private final int jdField_b_of_type_Int = 720;
  private volatile long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private volatile String jdField_b_of_type_JavaLangString;
  private volatile nqw jdField_b_of_type_Nqw;
  private nqy jdField_b_of_type_Nqy = new nqy();
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 720;
  private long jdField_c_of_type_Long = 10000L;
  private volatile String jdField_c_of_type_JavaLangString;
  private nqy jdField_c_of_type_Nqy = new nqy();
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long = 15000L;
  private volatile boolean jdField_d_of_type_Boolean;
  private volatile boolean e;
  private volatile boolean f;
  private volatile boolean g;
  
  public nrf(Context paramContext, nmq paramnmq)
  {
    super(paramContext);
    paramContext = nqt.d();
    if (paramContext != null)
    {
      this.jdField_c_of_type_Long = (paramContext.jdField_b_of_type_Int * 1000);
      this.jdField_d_of_type_Long = (paramContext.jdField_c_of_type_Int * 1000);
      if (this.jdField_c_of_type_Long > 1000L) {
        this.jdField_c_of_type_Long -= 1000L;
      }
    }
    this.jdField_a_of_type_Nmq = paramnmq;
  }
  
  private boolean j()
  {
    int i = nfc.a().a().a();
    return (i != 10) && (i != 0);
  }
  
  private void r()
  {
    if (d()) {
      k();
    }
    s();
    if (this.jdField_a_of_type_Mou != null) {
      this.jdField_a_of_type_Mou.b();
    }
    this.jdField_a_of_type_Nmq = null;
  }
  
  private void s()
  {
    nfc.a().b(this.jdField_a_of_type_Nrn);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.f = false;
    this.e = false;
  }
  
  protected String a()
  {
    return "GuessSongGameRecordCtrl";
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    int j = 1;
    int i;
    if ((d()) && (this.jdField_a_of_type_Mou != null))
    {
      boolean bool = this.jdField_a_of_type_Mou.a();
      if (!bool) {
        bjuc.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check audio not ready");
      }
      if ((!this.jdField_b_of_type_Boolean) && (!bool)) {
        break label129;
      }
      i = 1;
      if (i != 0) {
        break label147;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L) {
        break label135;
      }
      this.jdField_b_of_type_Boolean = true;
      bjuc.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check timeout");
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        this.jdField_a_of_type_Mou.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      }
      return;
      label129:
      i = 0;
      break;
      label135:
      bjuc.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable checking");
      continue;
      label147:
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    bjuc.a(this.jdField_a_of_type_JavaLangString, "onEncodeError " + this.jdField_b_of_type_JavaLangString + " " + paramInt + " " + paramThrowable);
    this.g = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GuessSongGameRecordCtrl.3(this), 50L);
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("setDrawGameTopicTextureData ");
    boolean bool;
    if (paramBitmap != null)
    {
      bool = true;
      bjuc.c((String)localObject, bool + " w:" + paramInt1 + " h:" + paramInt2 + " l:" + paramInt3 + " t:" + paramInt4);
      localObject = this.jdField_a_of_type_JavaLangObject;
      if (paramBitmap == null) {
        break label177;
      }
    }
    for (;;)
    {
      label177:
      try
      {
        if (this.jdField_a_of_type_Nqw == null) {
          this.jdField_a_of_type_Nqw = new nqw();
        }
        this.jdField_a_of_type_Nqw.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        this.jdField_a_of_type_Nqw.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Nqw.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_Nqw.jdField_c_of_type_Int = paramInt3;
        this.jdField_a_of_type_Nqw.d = paramInt4;
        this.jdField_a_of_type_Nqy.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      finally {}
      bool = false;
      break;
      this.jdField_a_of_type_Nqw = null;
    }
  }
  
  public void a(View paramView)
  {
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onTopicViewDismiss ");
    a(null, 0, 0, 0, 0);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    paramBoolean = d();
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onAnswerViewShow " + paramBoolean);
    if ((paramBoolean) && (paramView != null))
    {
      if (!paramView.isDrawingCacheEnabled()) {
        paramView.setDrawingCacheEnabled(true);
      }
      paramView.requestLayout();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GuessSongGameRecordCtrl.4(this, paramInt, paramView), 500L);
    }
  }
  
  public void a(String paramString)
  {
    boolean bool1 = false;
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onEncodeFinish " + this.jdField_b_of_type_JavaLangString + " " + this.jdField_c_of_type_JavaLangString);
    if (this.g) {
      this.g = false;
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
        bjuc.a(this.jdField_a_of_type_JavaLangString, "onEncodeFinish", paramString);
      }
    }
    this.jdField_b_of_type_JavaLangString = null;
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onEncodeFinish delete=" + bool1);
    nfc.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    bjuc.c(this.jdField_a_of_type_JavaLangString, "enableDrawDefaultBg " + paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = nqf.a("avgame_songfallback@2x.png");
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
        {
          Bitmap localBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
          localBitmap.eraseColor(-1144611);
          this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
        }
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_c_of_type_Nqy.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_c_of_type_Nqy.a(), this.jdField_c_of_type_Nqy.b(), 0, 0);
      }
      return;
    }
    this.jdField_c_of_type_Nqy.a(null, 0, 0, 0, 0);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.e = paramBoolean;
    this.jdField_a_of_type_Nqx.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((d()) && (this.jdField_a_of_type_Mou != null) && (paramArrayOfByte != null)) {
      this.jdField_a_of_type_Mou.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
    }
  }
  
  public int[] a()
  {
    if (!b())
    {
      this.jdField_a_of_type_Boolean = false;
      return new int[] { 0, 0 };
    }
    if (this.jdField_a_of_type_Mou == null) {}
    bbmm localbbmm;
    try
    {
      if (a()) {
        this.jdField_a_of_type_Mou = new mou();
      }
      if (this.jdField_a_of_type_Mou == null)
      {
        this.jdField_a_of_type_Boolean = false;
        return new int[] { 0, 0 };
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_Mou = null;
        bjuc.a(this.jdField_a_of_type_JavaLangString, "oom " + localOutOfMemoryError);
      }
      this.jdField_a_of_type_Nqy.a(720, 720);
      this.jdField_b_of_type_Nqy.a(720, 720);
      this.jdField_a_of_type_Nqx.a(720, 720);
      this.jdField_c_of_type_Nqy.a(720, 720);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_JavaLangString = b();
      this.jdField_c_of_type_JavaLangString = c();
      bjuc.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord rW=720, rH=720");
      localbbmm = new bbmm(this.jdField_b_of_type_JavaLangString, 720, 720, 5120000, 1, false, 0);
      localbbmm.a(EGL14.eglGetCurrentContext());
      if (this.jdField_a_of_type_Mou == null) {
        break label255;
      }
    }
    this.jdField_a_of_type_Mou.a(localbbmm, this);
    for (;;)
    {
      return new int[] { 720, 720 };
      label255:
      a(5, null);
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
      bjuc.c((String)localObject, bool + " w:" + paramInt1 + " h:" + paramInt2 + " l:" + paramInt3 + " t:" + paramInt4);
      localObject = this.jdField_b_of_type_JavaLangObject;
      if (paramBitmap == null) {
        break label178;
      }
    }
    for (;;)
    {
      label178:
      try
      {
        if (this.jdField_b_of_type_Nqw == null) {
          this.jdField_b_of_type_Nqw = new nqw();
        }
        this.jdField_b_of_type_Nqw.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        this.jdField_b_of_type_Nqw.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Nqw.jdField_b_of_type_Int = paramInt2;
        this.jdField_b_of_type_Nqw.jdField_c_of_type_Int = paramInt3;
        this.jdField_b_of_type_Nqw.d = paramInt4;
        this.jdField_b_of_type_Nqy.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      finally {}
      bool = false;
      break;
      this.jdField_b_of_type_Nqw = null;
    }
  }
  
  public void b(View paramView)
  {
    boolean bool = d();
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onTopicViewSwitch " + bool);
    if (paramView != null)
    {
      if (!paramView.isDrawingCacheEnabled()) {
        paramView.setDrawingCacheEnabled(true);
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GuessSongGameRecordCtrl.5(this, paramView), 500L);
    }
  }
  
  public void c()
  {
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onActivityStart ");
    if (j())
    {
      GameRecordInfo localGameRecordInfo = nfc.a().a().a();
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
      bjuc.c(this.jdField_a_of_type_JavaLangString, "onActivityStart " + localGameRecordInfo + " " + bool1);
      if (!bool1)
      {
        long l = this.jdField_c_of_type_Long - (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        bjuc.c(this.jdField_a_of_type_JavaLangString, "onActivityStart remainTime:" + l);
        l = Math.max(l, 1000L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, l);
      }
    }
  }
  
  public void c(View paramView)
  {
    boolean bool = d();
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onAnswerViewDismiss " + bool);
    if (bool)
    {
      b(null, 0, 0, 0, 0);
      a(false, 0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void d()
  {
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onActivityStop ");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void e()
  {
    boolean bool = d();
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onGameOver " + bool);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Nqw = null;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Nqw = null;
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public boolean e()
  {
    boolean bool = false;
    if (super.e())
    {
      s();
      nfc.a().a(this.jdField_a_of_type_Nrn);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.g = false;
      bool = true;
    }
    return bool;
  }
  
  public void f()
  {
    boolean bool = d();
    GameRecordInfo localGameRecordInfo = nfc.a().a().a();
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onGameStart " + bool + " " + this.jdField_b_of_type_Long + " " + localGameRecordInfo);
    if (localGameRecordInfo.startGameTimeMills == 0L)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
      nfc.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, this.jdField_c_of_type_Long);
    }
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public void g() {}
  
  public boolean g()
  {
    return this.f;
  }
  
  public void h() {}
  
  public boolean h()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_Nqw != null) && (this.jdField_a_of_type_Nqw.jdField_a_of_type_AndroidGraphicsBitmap != null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      bjuc.c(this.jdField_a_of_type_JavaLangString, "start record come.");
      if (d()) {
        k();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (e())
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_d_of_type_Long);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        continue;
        bjuc.c(this.jdField_a_of_type_JavaLangString, "end record come." + d());
        if (d())
        {
          k();
          if ((this.jdField_a_of_type_Nmq != null) && (this.jdField_a_of_type_Nmq.a() != null))
          {
            this.jdField_a_of_type_Nmq.a().requestRender();
            continue;
            bjuc.c(this.jdField_a_of_type_JavaLangString, "destroy");
            r();
            continue;
            if (d())
            {
              bjuc.c(this.jdField_a_of_type_JavaLangString, "render call .");
              if ((this.jdField_a_of_type_Nmq != null) && (this.jdField_a_of_type_Nmq.a() != null))
              {
                this.jdField_a_of_type_Nmq.a().requestRender();
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 50L);
              }
            }
            else
            {
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
            }
          }
        }
      }
    }
  }
  
  public boolean i()
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if ((this.jdField_b_of_type_Nqw != null) && (this.jdField_b_of_type_Nqw.jdField_a_of_type_AndroidGraphicsBitmap != null))
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
    if (this.jdField_a_of_type_Mou != null) {
      this.jdField_a_of_type_Mou.a();
    }
    s();
  }
  
  public void l()
  {
    bjuc.c(this.jdField_a_of_type_JavaLangString, "onDestroy ");
    super.l();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    r();
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
    if (g()) {
      this.jdField_c_of_type_Nqy.h();
    }
    if (h()) {
      this.jdField_a_of_type_Nqy.h();
    }
    if (f()) {
      this.jdField_a_of_type_Nqx.h();
    }
    if (i()) {
      this.jdField_b_of_type_Nqy.h();
    }
    n();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
  }
  
  public void n()
  {
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_Boolean = true;
    }
    try
    {
      Object localObject = IntBuffer.allocate(518400);
      GLES20.glReadPixels(0, 0, 720, 720, 6408, 5121, (Buffer)localObject);
      localObject = ((IntBuffer)localObject).array();
      ThreadManager.getSubThreadHandler().post(new GuessSongGameRecordCtrl.2(this, (int[])localObject));
      return;
    }
    catch (Throwable localThrowable)
    {
      bjuc.c(this.jdField_a_of_type_JavaLangString, "checkFirstFramePhoto " + localThrowable);
    }
  }
  
  public void p()
  {
    if (d())
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(720, 720, 33984);
        a(true);
        a();
        this.jdField_c_of_type_Boolean = true;
      }
      m();
      a(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null, SystemClock.elapsedRealtimeNanos());
    }
  }
  
  public void q()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      bjuc.c(this.jdField_a_of_type_JavaLangString, "releaseGameTexture");
      if (this.jdField_a_of_type_Nqy != null) {
        this.jdField_a_of_type_Nqy.d();
      }
      if (this.jdField_a_of_type_Nqx != null) {
        this.jdField_a_of_type_Nqx.d();
      }
      if (this.jdField_b_of_type_Nqy != null) {
        this.jdField_b_of_type_Nqy.d();
      }
      if (this.jdField_c_of_type_Nqy != null) {
        this.jdField_c_of_type_Nqy.d();
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrf
 * JD-Core Version:    0.7.0.1
 */