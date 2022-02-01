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
public class nkf
  extends njz
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private mnx jdField_a_of_type_Mnx;
  private nfy jdField_a_of_type_Nfy;
  private volatile njw jdField_a_of_type_Njw;
  private njx jdField_a_of_type_Njx = new njx();
  private njy jdField_a_of_type_Njy = new njy();
  private nkn jdField_a_of_type_Nkn = new nkg(this);
  private final int jdField_b_of_type_Int = 720;
  private volatile long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private volatile String jdField_b_of_type_JavaLangString;
  private volatile njw jdField_b_of_type_Njw;
  private njy jdField_b_of_type_Njy = new njy();
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 720;
  private long jdField_c_of_type_Long = 10000L;
  private volatile String jdField_c_of_type_JavaLangString;
  private njy jdField_c_of_type_Njy = new njy();
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long = 15000L;
  private volatile boolean jdField_d_of_type_Boolean;
  private volatile boolean e;
  private volatile boolean f;
  private volatile boolean g;
  
  public nkf(Context paramContext, nfy paramnfy)
  {
    super(paramContext);
    paramContext = njt.d();
    if (paramContext != null)
    {
      this.jdField_c_of_type_Long = (paramContext.jdField_b_of_type_Int * 1000);
      this.jdField_d_of_type_Long = (paramContext.jdField_c_of_type_Int * 1000);
      if (this.jdField_c_of_type_Long > 1000L) {
        this.jdField_c_of_type_Long -= 1000L;
      }
    }
    this.jdField_a_of_type_Nfy = paramnfy;
  }
  
  private boolean j()
  {
    int i = mzl.a().a().a();
    return (i != 10) && (i != 0);
  }
  
  private void r()
  {
    if (d()) {
      k();
    }
    s();
    if (this.jdField_a_of_type_Mnx != null) {
      this.jdField_a_of_type_Mnx.b();
    }
    this.jdField_a_of_type_Nfy = null;
  }
  
  private void s()
  {
    mzl.a().b(this.jdField_a_of_type_Nkn);
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
    if ((d()) && (this.jdField_a_of_type_Mnx != null))
    {
      boolean bool = this.jdField_a_of_type_Mnx.a();
      if (!bool) {
        bija.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check audio not ready");
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
      bija.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable check timeout");
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        this.jdField_a_of_type_Mnx.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      }
      return;
      label129:
      i = 0;
      break;
      label135:
      bija.c(this.jdField_a_of_type_JavaLangString, "videoFrameAvailable checking");
      continue;
      label147:
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    bija.a(this.jdField_a_of_type_JavaLangString, "onEncodeError " + this.jdField_b_of_type_JavaLangString + " " + paramInt + " " + paramThrowable);
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
      bija.c((String)localObject, bool + " w:" + paramInt1 + " h:" + paramInt2 + " l:" + paramInt3 + " t:" + paramInt4);
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
        if (this.jdField_a_of_type_Njw == null) {
          this.jdField_a_of_type_Njw = new njw();
        }
        this.jdField_a_of_type_Njw.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        this.jdField_a_of_type_Njw.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Njw.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_Njw.jdField_c_of_type_Int = paramInt3;
        this.jdField_a_of_type_Njw.d = paramInt4;
        this.jdField_a_of_type_Njy.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      finally {}
      bool = false;
      break;
      this.jdField_a_of_type_Njw = null;
    }
  }
  
  public void a(View paramView)
  {
    bija.c(this.jdField_a_of_type_JavaLangString, "onTopicViewDismiss ");
    a(null, 0, 0, 0, 0);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    paramBoolean = d();
    bija.c(this.jdField_a_of_type_JavaLangString, "onAnswerViewShow " + paramBoolean);
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
    bija.c(this.jdField_a_of_type_JavaLangString, "onEncodeFinish " + this.jdField_b_of_type_JavaLangString + " " + this.jdField_c_of_type_JavaLangString);
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
        bija.a(this.jdField_a_of_type_JavaLangString, "onEncodeFinish", paramString);
      }
    }
    this.jdField_b_of_type_JavaLangString = null;
    bija.c(this.jdField_a_of_type_JavaLangString, "onEncodeFinish delete=" + bool1);
    mzl.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    bija.c(this.jdField_a_of_type_JavaLangString, "enableDrawDefaultBg " + paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = njh.a("avgame_songfallback@2x.png");
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
        {
          Bitmap localBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
          localBitmap.eraseColor(-1144611);
          this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
        }
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_c_of_type_Njy.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_c_of_type_Njy.a(), this.jdField_c_of_type_Njy.b(), 0, 0);
      }
      return;
    }
    this.jdField_c_of_type_Njy.a(null, 0, 0, 0, 0);
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.e = paramBoolean;
    this.jdField_a_of_type_Njx.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((d()) && (this.jdField_a_of_type_Mnx != null) && (paramArrayOfByte != null)) {
      this.jdField_a_of_type_Mnx.a(paramArrayOfByte, SystemClock.elapsedRealtimeNanos() / 1000L);
    }
  }
  
  public int[] a()
  {
    if (!b())
    {
      this.jdField_a_of_type_Boolean = false;
      return new int[] { 0, 0 };
    }
    if (this.jdField_a_of_type_Mnx == null) {}
    bafx localbafx;
    try
    {
      if (a()) {
        this.jdField_a_of_type_Mnx = new mnx();
      }
      if (this.jdField_a_of_type_Mnx == null)
      {
        this.jdField_a_of_type_Boolean = false;
        return new int[] { 0, 0 };
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.jdField_a_of_type_Mnx = null;
        bija.a(this.jdField_a_of_type_JavaLangString, "oom " + localOutOfMemoryError);
      }
      this.jdField_a_of_type_Njy.a(720, 720);
      this.jdField_b_of_type_Njy.a(720, 720);
      this.jdField_a_of_type_Njx.a(720, 720);
      this.jdField_c_of_type_Njy.a(720, 720);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_JavaLangString = b();
      this.jdField_c_of_type_JavaLangString = c();
      bija.c(this.jdField_a_of_type_JavaLangString, "doNeedStartRecord rW=720, rH=720");
      localbafx = new bafx(this.jdField_b_of_type_JavaLangString, 720, 720, 5120000, 1, false, 0);
      localbafx.a(EGL14.eglGetCurrentContext());
      if (this.jdField_a_of_type_Mnx == null) {
        break label255;
      }
    }
    this.jdField_a_of_type_Mnx.a(localbafx, this);
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
      bija.c((String)localObject, bool + " w:" + paramInt1 + " h:" + paramInt2 + " l:" + paramInt3 + " t:" + paramInt4);
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
        if (this.jdField_b_of_type_Njw == null) {
          this.jdField_b_of_type_Njw = new njw();
        }
        this.jdField_b_of_type_Njw.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        this.jdField_b_of_type_Njw.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Njw.jdField_b_of_type_Int = paramInt2;
        this.jdField_b_of_type_Njw.jdField_c_of_type_Int = paramInt3;
        this.jdField_b_of_type_Njw.d = paramInt4;
        this.jdField_b_of_type_Njy.a(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      finally {}
      bool = false;
      break;
      this.jdField_b_of_type_Njw = null;
    }
  }
  
  public void b(View paramView)
  {
    boolean bool = d();
    bija.c(this.jdField_a_of_type_JavaLangString, "onTopicViewSwitch " + bool);
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
    bija.c(this.jdField_a_of_type_JavaLangString, "onActivityStart ");
    if (j())
    {
      GameRecordInfo localGameRecordInfo = mzl.a().a().a();
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
      bija.c(this.jdField_a_of_type_JavaLangString, "onActivityStart " + localGameRecordInfo + " " + bool1);
      if (!bool1)
      {
        long l = this.jdField_c_of_type_Long - (System.currentTimeMillis() - this.jdField_b_of_type_Long);
        bija.c(this.jdField_a_of_type_JavaLangString, "onActivityStart remainTime:" + l);
        l = Math.max(l, 1000L);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, l);
      }
    }
  }
  
  public void c(View paramView)
  {
    boolean bool = d();
    bija.c(this.jdField_a_of_type_JavaLangString, "onAnswerViewDismiss " + bool);
    if (bool)
    {
      b(null, 0, 0, 0, 0);
      a(false, 0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void d()
  {
    bija.c(this.jdField_a_of_type_JavaLangString, "onActivityStop ");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void e()
  {
    boolean bool = d();
    bija.c(this.jdField_a_of_type_JavaLangString, "onGameOver " + bool);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Njw = null;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Njw = null;
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
      mzl.a().a(this.jdField_a_of_type_Nkn);
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
    GameRecordInfo localGameRecordInfo = mzl.a().a().a();
    bija.c(this.jdField_a_of_type_JavaLangString, "onGameStart " + bool + " " + this.jdField_b_of_type_Long + " " + localGameRecordInfo);
    if (localGameRecordInfo.startGameTimeMills == 0L)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
      mzl.a().a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long);
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
        if ((this.jdField_a_of_type_Njw != null) && (this.jdField_a_of_type_Njw.jdField_a_of_type_AndroidGraphicsBitmap != null))
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
      bija.c(this.jdField_a_of_type_JavaLangString, "start record come.");
      if (d()) {
        k();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (e())
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_d_of_type_Long);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        continue;
        bija.c(this.jdField_a_of_type_JavaLangString, "end record come." + d());
        if (d())
        {
          k();
          if ((this.jdField_a_of_type_Nfy != null) && (this.jdField_a_of_type_Nfy.a() != null))
          {
            this.jdField_a_of_type_Nfy.a().requestRender();
            continue;
            bija.c(this.jdField_a_of_type_JavaLangString, "destroy");
            r();
            continue;
            if (d())
            {
              bija.c(this.jdField_a_of_type_JavaLangString, "render call .");
              if ((this.jdField_a_of_type_Nfy != null) && (this.jdField_a_of_type_Nfy.a() != null))
              {
                this.jdField_a_of_type_Nfy.a().requestRender();
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
        if ((this.jdField_b_of_type_Njw != null) && (this.jdField_b_of_type_Njw.jdField_a_of_type_AndroidGraphicsBitmap != null))
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
    if (this.jdField_a_of_type_Mnx != null) {
      this.jdField_a_of_type_Mnx.a();
    }
    s();
  }
  
  public void l()
  {
    bija.c(this.jdField_a_of_type_JavaLangString, "onDestroy ");
    super.l();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    r();
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth(), this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight());
    if (g()) {
      this.jdField_c_of_type_Njy.h();
    }
    if (h()) {
      this.jdField_a_of_type_Njy.h();
    }
    if (f()) {
      this.jdField_a_of_type_Njx.h();
    }
    if (i()) {
      this.jdField_b_of_type_Njy.h();
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
      bija.c(this.jdField_a_of_type_JavaLangString, "checkFirstFramePhoto " + localThrowable);
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
      bija.c(this.jdField_a_of_type_JavaLangString, "releaseGameTexture");
      if (this.jdField_a_of_type_Njy != null) {
        this.jdField_a_of_type_Njy.d();
      }
      if (this.jdField_a_of_type_Njx != null) {
        this.jdField_a_of_type_Njx.d();
      }
      if (this.jdField_b_of_type_Njy != null) {
        this.jdField_b_of_type_Njy.d();
      }
      if (this.jdField_c_of_type_Njy != null) {
        this.jdField_c_of_type_Njy.d();
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
 * Qualified Name:     nkf
 * JD-Core Version:    0.7.0.1
 */