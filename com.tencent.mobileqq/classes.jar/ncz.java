import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView.ScaleType;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gameroom.video.AVGameVideoLayer.1;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ncz
  extends lro
  implements lrm, nef
{
  private Context jdField_a_of_type_AndroidContentContext;
  public AVGameAppInterface a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVGameVideoLayer.1(this);
  public mwp a;
  private ncl jdField_a_of_type_Ncl;
  protected ncv a;
  private ncx jdField_a_of_type_Ncx;
  protected nda[] a;
  public final List<nan> b;
  public nda[] b;
  protected boolean c;
  protected nda[] c;
  public volatile Rect d;
  private boolean d;
  
  public ncz(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(8);
    this.jdField_a_of_type_ArrayOfNda = new nda[9];
    this.jdField_b_of_type_ArrayOfNda = new nda[9];
    this.jdField_c_of_type_ArrayOfNda = new nda[1];
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Mwp = ((mwp)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(2));
    q();
    r();
    g(2);
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(long paramLong, mdt parammdt, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (parammdt != null)
    {
      str = nfx.a(paramString, paramInt);
      parammdt.a(paramString, paramInt);
      parammdt.a(0);
      parammdt.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    try
    {
      paramString = parammdt.a();
      GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
      GraphicRenderMgr.getInstance().setGlRender(str, paramString);
      QLog.w("AVGameVideoLayer", 1, "setGlRender[initGLVideoViewBasePara], key[" + str + "], debug[" + parammdt.c() + "], videoSrcType[" + paramInt + "], yuvTexture[" + paramString + "]");
      bjce.a().a().a_(paramLong, false, paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError parammdt)
    {
      parammdt.printStackTrace();
    }
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    bjcq.d("AVGameVideoLayer", "closeGLVideoView uin:=" + paramString);
    paramInt = a(paramString, paramInt);
    if (paramInt >= 0)
    {
      paramString = this.jdField_a_of_type_ArrayOfNda[paramInt];
      paramString.a(1);
      paramString.b(null);
      paramString.l(true);
      paramString.j(false);
      paramString.f(false);
      paramString.k(true);
      paramString.a(null, 0);
      paramString.a("");
    }
  }
  
  private void a(String paramString1, long paramLong, String paramString2, int paramInt, boolean paramBoolean)
  {
    bjcq.d("AVGameVideoLayer", "closeGLVideoViewBasePara uin:=" + paramString2);
    int i = a(paramString2, paramInt);
    if (i >= 0)
    {
      paramString2 = nfx.a(paramString2, paramInt);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(paramString2);
      if ((!paramBoolean) && (paramInt == 1)) {
        localGraphicRenderMgr.clearCameraFrames();
      }
      localGraphicRenderMgr.setGlRender(paramString2, null);
      QLog.w("AVGameVideoLayer", 1, "setGlRender[closeGLVideoViewBasePara], key[" + paramString2 + "], index[" + i + "], seq[" + paramLong + "], from[" + paramString1 + "]");
      if (paramBoolean) {
        bjce.a().a().a_(paramLong, true, paramBoolean);
      }
    }
  }
  
  private void q()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNda.length)
    {
      this.jdField_a_of_type_ArrayOfNda[i] = new nda(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(i) }), 0L);
      this.jdField_a_of_type_ArrayOfNda[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfNda[i].a(Boolean.valueOf(false));
      this.jdField_a_of_type_ArrayOfNda[i].a(1);
      this.jdField_a_of_type_ArrayOfNda[i].h(-1);
      this.jdField_a_of_type_ArrayOfNda[i].c(i * 2);
      a(this.jdField_a_of_type_ArrayOfNda[i]);
      i += 1;
    }
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfNda.length)
    {
      this.jdField_b_of_type_ArrayOfNda[i] = new nda(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(i + 9) }), 0L, false);
      this.jdField_b_of_type_ArrayOfNda[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ArrayOfNda[i].a(1);
      this.jdField_b_of_type_ArrayOfNda[i].a(Boolean.valueOf(false));
      this.jdField_b_of_type_ArrayOfNda[i].h(-1);
      this.jdField_b_of_type_ArrayOfNda[i].c((i + 9) * 2);
      a(this.jdField_b_of_type_ArrayOfNda[i]);
      i += 1;
    }
    this.jdField_c_of_type_ArrayOfNda[0] = new nda(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(17) }), 0L, false);
    this.jdField_c_of_type_ArrayOfNda[0].c(81);
    this.jdField_c_of_type_ArrayOfNda[0].a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_ArrayOfNda[0].a(Boolean.valueOf(false));
    this.jdField_c_of_type_ArrayOfNda[0].a(1);
    a(this.jdField_c_of_type_ArrayOfNda[0]);
  }
  
  private void r()
  {
    d(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165334));
  }
  
  private void s()
  {
    bjcq.d("AVGameVideoLayer", "doResumeVideo");
    String str1 = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    Object localObject1 = ndt.b().a();
    Object localObject2;
    boolean bool1;
    boolean bool2;
    String str2;
    if (localObject1 != null)
    {
      localObject2 = new ArrayList();
      ((AVGameSession)localObject1).c((List)localObject2);
      localObject1 = ((List)localObject2).iterator();
      bool1 = false;
      bool2 = false;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AVGameUserInfo)((Iterator)localObject1).next();
        str2 = String.valueOf(((AVGameUserInfo)localObject2).mUin);
        if (str1.equalsIgnoreCase(String.valueOf(((AVGameUserInfo)localObject2).mUin)))
        {
          if (((AVGameUserInfo)localObject2).mVideoOn) {
            a("doResumeVideo", -1L);
          }
          if (!((AVGameUserInfo)localObject2).mSubVideoOn) {
            break label255;
          }
          c(true);
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      break;
      if (((AVGameUserInfo)localObject2).mVideoOn) {
        a("doResumeVideo", -1L, str2, 1);
      }
      if (((AVGameUserInfo)localObject2).mSubVideoOn) {
        a("doResumeVideo", -1L, str2, 2);
      }
      bool2 = true;
      continue;
      bjcq.d("AVGameVideoLayer", "doResumeVideo mNeedRequest:=" + bool2 + ";mHasDoGoOnStage:=" + bool1 + ";mNeedReOpenCamera:=" + this.jdField_d_of_type_Boolean);
      if ((bool2) && (this.jdField_a_of_type_Ncl != null)) {
        this.jdField_a_of_type_Ncl.c();
      }
      return;
      label255:
      bool1 = true;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfNda == null) {
      return -1;
    }
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = 0;
      if (i < this.jdField_a_of_type_ArrayOfNda.length)
      {
        nda localnda = this.jdField_a_of_type_ArrayOfNda[i];
        if ((!paramString.equals(localnda.b())) || (paramInt != localnda.h()) || (localnda.a() != 0)) {}
      }
    }
    for (;;)
    {
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong)
  {
    QLog.w("AVGameVideoLayer", 1, "openSelfVideoView, from[" + paramString + "], seq[" + paramLong);
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    paramString = null;
    int i = a(str, 1);
    if (i < 0)
    {
      i = f();
      if (i >= 0)
      {
        paramString = this.jdField_a_of_type_ArrayOfNda[i];
        a(paramLong, paramString, str, 1, false);
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString.f(false);
        paramString.j(false);
        paramString.a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
        paramString.l(true);
        paramString.a(0);
        paramString.a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      str = nfx.a(str, 1);
      paramString = this.jdField_a_of_type_ArrayOfNda[i];
      GraphicRenderMgr.getInstance().setGlRender(str, paramString.a());
      QLog.w("AVGameVideoLayer", 1, "setGlRender[openSelfVideoView], key[" + str + "], index[" + i + "], forceToBigView[" + false + "], " + paramString.c());
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    QLog.w("AVGameVideoLayer", 1, "openRemoteVideoView, from[" + paramString1 + "], seq[" + paramLong + "], uin[" + paramString2);
    paramString1 = null;
    int i = a(paramString2, paramInt);
    String str = nfx.a(paramString2, paramInt);
    if (i < 0)
    {
      i = f();
      if (i >= 0)
      {
        paramString1 = this.jdField_a_of_type_ArrayOfNda[i];
        a(paramLong, paramString1, paramString2, paramInt, true);
      }
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString1.j(true);
        paramString1.a(paramLong, false);
        paramString1.a(0);
        paramString1.a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      paramString1 = this.jdField_a_of_type_ArrayOfNda[i];
      GraphicRenderMgr.getInstance().setGlRender(str, paramString1.a());
      QLog.w("AVGameVideoLayer", 1, "setGlRender[openPeerVideo], key[" + str + "], seq[" + paramLong + "], index[" + i + "], " + paramString1.c());
    }
  }
  
  public void a(List<nan> paramList) {}
  
  public void a(lpx paramlpx)
  {
    h(paramlpx);
    f(paramlpx);
  }
  
  public void a(ncl paramncl)
  {
    this.jdField_a_of_type_Ncl = paramncl;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.jdField_a_of_type_Ncv != null) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Ncv.a(paramArrayOfByte, paramInt1, paramInt2, paramLong);
      b();
    }
  }
  
  public boolean a(lrl paramlrl, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(String paramString) {}
  
  public void b(String paramString, long paramLong)
  {
    QLog.w("AVGameVideoLayer", 1, "closeSelfVideoView, from[" + paramString + "], seq[" + paramLong);
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    if (a(str, 1) >= 0)
    {
      a(paramString, paramLong, str, 1, false);
      a(str, 1, false);
    }
  }
  
  public void b(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    bjcq.d("AVGameVideoLayer", "closeRemoteVideoView uin:=" + paramString2);
    if (a(paramString2, paramInt) >= 0)
    {
      a(paramString1, paramLong, paramString2, paramInt, true);
      a(paramString2, paramInt, true);
    }
  }
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ncv != null) {
      this.jdField_a_of_type_Ncv.a(paramBoolean);
    }
    b();
  }
  
  public void d(String paramString) {}
  
  public int f()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNda.length)
    {
      nda localnda = this.jdField_a_of_type_ArrayOfNda[i];
      if ((TextUtils.isEmpty(localnda.b())) || (localnda.a() == 1)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Ncv = new ncv();
    this.jdField_a_of_type_Ncv.a(b(), c());
  }
  
  protected void f(lpx paramlpx)
  {
    super.a(paramlpx);
    p();
  }
  
  public int g()
  {
    int i = 0;
    while (i < this.jdField_b_of_type_ArrayOfNda.length)
    {
      nda localnda = this.jdField_b_of_type_ArrayOfNda[i];
      if ((TextUtils.isEmpty(localnda.b())) || (localnda.a() == 1)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Ncv != null)
    {
      this.jdField_a_of_type_Ncv.a();
      this.jdField_a_of_type_Ncv = null;
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_Ncx = ncx.a(paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface);
  }
  
  protected void h(lpx paramlpx)
  {
    if (this.jdField_a_of_type_Ncx != null) {
      this.jdField_a_of_type_Ncx.a(this.jdField_a_of_type_ArrayOfNda, this.jdField_b_of_type_ArrayOfNda, b(), c(), this.jdField_b_of_type_JavaUtilList);
    }
    paramlpx = this.jdField_a_of_type_ArrayOfNda;
    int j = paramlpx.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramlpx[i];
      if ((localObject.a()) && (localObject.h() == 2) && (localObject.c() == 0)) {
        localObject.a((b() - 640) / 2, 40, (b() + 640) / 2, 520);
      }
      i += 1;
    }
  }
  
  public void l() {}
  
  public void m()
  {
    bjcq.d("AVGameVideoLayer", "doOnResume");
    neq.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void n()
  {
    bjcq.d("AVGameVideoLayer", "doOnStop");
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    nda[] arrayOfnda = this.jdField_a_of_type_ArrayOfNda;
    int k = arrayOfnda.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      nda localnda = arrayOfnda[j];
      if (!localnda.a()) {}
      for (;;)
      {
        j += 1;
        break;
        if (str.equalsIgnoreCase(localnda.b()))
        {
          b("VideoLayer_doOnStop", -1L);
          i = 1;
        }
        else
        {
          b("VideoLayer_doOnStop", -1L, localnda.b(), localnda.h());
        }
      }
    }
    c(false);
    if ((CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(-1L)) && (i != 0)) {
      this.jdField_d_of_type_Boolean = true;
    }
    neq.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void o()
  {
    bjcq.d("AVGameVideoLayer", "doOnDestroy");
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNda.length)
    {
      this.jdField_a_of_type_ArrayOfNda[i].a(1);
      this.jdField_a_of_type_ArrayOfNda[i].l(true);
      this.jdField_a_of_type_ArrayOfNda[i].j(false);
      this.jdField_a_of_type_ArrayOfNda[i].f(false);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfNda = null;
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfNda.length)
    {
      this.jdField_b_of_type_ArrayOfNda[i].a(1);
      this.jdField_b_of_type_ArrayOfNda[i].l(true);
      this.jdField_b_of_type_ArrayOfNda[i].j(false);
      this.jdField_b_of_type_ArrayOfNda[i].f(false);
      i += 1;
    }
    this.jdField_b_of_type_ArrayOfNda = null;
    this.jdField_c_of_type_ArrayOfNda = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void p()
  {
    this.jdField_a_of_type_Ncv.a(this.jdField_d_of_type_AndroidGraphicsRect, b(), c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncz
 * JD-Core Version:    0.7.0.1
 */