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
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nfy
  extends lrs
  implements lrq, nhg
{
  private Context jdField_a_of_type_AndroidContentContext;
  public AVGameAppInterface a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVGameVideoLayer.1(this);
  public mxz a;
  private nff jdField_a_of_type_Nff;
  protected nfs a;
  private nfw jdField_a_of_type_Nfw;
  protected nfz[] a;
  public final List<ncs> b;
  public nfz[] b;
  protected boolean c;
  protected nfz[] c;
  public volatile Rect d;
  private boolean d;
  
  public nfy(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(8);
    this.jdField_a_of_type_ArrayOfNfz = new nfz[9];
    this.jdField_b_of_type_ArrayOfNfz = new nfz[9];
    this.jdField_c_of_type_ArrayOfNfz = new nfz[1];
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Mxz = ((mxz)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(2));
    q();
    r();
    g(2);
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(long paramLong, mdy parammdy, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (parammdy != null)
    {
      str = njh.a(paramString, paramInt);
      parammdy.a(paramString, paramInt);
      parammdy.a(0);
      parammdy.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    try
    {
      paramString = parammdy.a();
      GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
      GraphicRenderMgr.getInstance().setGlRender(str, paramString);
      QLog.w("AVGameVideoLayer", 1, "setGlRender[initGLVideoViewBasePara], key[" + str + "], debug[" + parammdy.c() + "], videoSrcType[" + paramInt + "], yuvTexture[" + paramString + "]");
      biin.a().a().a_(paramLong, false, paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError parammdy)
    {
      parammdy.printStackTrace();
    }
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    bija.d("AVGameVideoLayer", "closeGLVideoView uin:=" + paramString);
    paramInt = a(paramString, paramInt);
    if (paramInt >= 0)
    {
      paramString = this.jdField_a_of_type_ArrayOfNfz[paramInt];
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
    bija.d("AVGameVideoLayer", "closeGLVideoViewBasePara uin:=" + paramString2);
    int i = a(paramString2, paramInt);
    if (i >= 0)
    {
      paramString2 = njh.a(paramString2, paramInt);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(paramString2);
      if ((!paramBoolean) && (paramInt == 1)) {
        localGraphicRenderMgr.clearCameraFrames();
      }
      localGraphicRenderMgr.setGlRender(paramString2, null);
      QLog.w("AVGameVideoLayer", 1, "setGlRender[closeGLVideoViewBasePara], key[" + paramString2 + "], index[" + i + "], seq[" + paramLong + "], from[" + paramString1 + "]");
      if (paramBoolean) {
        biin.a().a().a_(paramLong, true, paramBoolean);
      }
    }
  }
  
  private void q()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNfz.length)
    {
      this.jdField_a_of_type_ArrayOfNfz[i] = new nfz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(i) }), 0L);
      this.jdField_a_of_type_ArrayOfNfz[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfNfz[i].a(Boolean.valueOf(false));
      this.jdField_a_of_type_ArrayOfNfz[i].a(1);
      this.jdField_a_of_type_ArrayOfNfz[i].h(-1);
      this.jdField_a_of_type_ArrayOfNfz[i].c(i * 2);
      a(this.jdField_a_of_type_ArrayOfNfz[i]);
      i += 1;
    }
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfNfz.length)
    {
      this.jdField_b_of_type_ArrayOfNfz[i] = new nfz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(i + 9) }), 0L, false);
      this.jdField_b_of_type_ArrayOfNfz[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ArrayOfNfz[i].a(1);
      this.jdField_b_of_type_ArrayOfNfz[i].a(Boolean.valueOf(false));
      this.jdField_b_of_type_ArrayOfNfz[i].h(-1);
      this.jdField_b_of_type_ArrayOfNfz[i].c((i + 9) * 2);
      a(this.jdField_b_of_type_ArrayOfNfz[i]);
      i += 1;
    }
    this.jdField_c_of_type_ArrayOfNfz[0] = new nfz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(17) }), 0L, false);
    this.jdField_c_of_type_ArrayOfNfz[0].c(81);
    this.jdField_c_of_type_ArrayOfNfz[0].a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_ArrayOfNfz[0].a(Boolean.valueOf(false));
    this.jdField_c_of_type_ArrayOfNfz[0].a(1);
    a(this.jdField_c_of_type_ArrayOfNfz[0]);
  }
  
  private void r()
  {
    d(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165342));
  }
  
  private void s()
  {
    bija.d("AVGameVideoLayer", "doResumeVideo");
    String str1 = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    Object localObject1 = ngu.b().a();
    Object localObject2;
    boolean bool1;
    boolean bool2;
    String str2;
    if (localObject1 != null)
    {
      localObject2 = new ArrayList();
      ((nhn)localObject1).c((List)localObject2);
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
      bija.d("AVGameVideoLayer", "doResumeVideo mNeedRequest:=" + bool2 + ";mHasDoGoOnStage:=" + bool1 + ";mNeedReOpenCamera:=" + this.jdField_d_of_type_Boolean);
      if ((bool2) && (this.jdField_a_of_type_Nff != null)) {
        this.jdField_a_of_type_Nff.c();
      }
      return;
      label255:
      bool1 = true;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfNfz == null) {
      return -1;
    }
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = 0;
      if (i < this.jdField_a_of_type_ArrayOfNfz.length)
      {
        nfz localnfz = this.jdField_a_of_type_ArrayOfNfz[i];
        if ((!paramString.equals(localnfz.b())) || (paramInt != localnfz.h()) || (localnfz.a() != 0)) {}
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
        paramString = this.jdField_a_of_type_ArrayOfNfz[i];
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
      str = njh.a(str, 1);
      paramString = this.jdField_a_of_type_ArrayOfNfz[i];
      GraphicRenderMgr.getInstance().setGlRender(str, paramString.a());
      QLog.w("AVGameVideoLayer", 1, "setGlRender[openSelfVideoView], key[" + str + "], index[" + i + "], forceToBigView[" + false + "], " + paramString.c());
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    QLog.w("AVGameVideoLayer", 1, "openRemoteVideoView, from[" + paramString1 + "], seq[" + paramLong + "], uin[" + paramString2);
    paramString1 = null;
    int i = a(paramString2, paramInt);
    String str = njh.a(paramString2, paramInt);
    if (i < 0)
    {
      i = f();
      if (i >= 0)
      {
        paramString1 = this.jdField_a_of_type_ArrayOfNfz[i];
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
      paramString1 = this.jdField_a_of_type_ArrayOfNfz[i];
      GraphicRenderMgr.getInstance().setGlRender(str, paramString1.a());
      QLog.w("AVGameVideoLayer", 1, "setGlRender[openPeerVideo], key[" + str + "], seq[" + paramLong + "], index[" + i + "], " + paramString1.c());
    }
  }
  
  public void a(List<ncs> paramList) {}
  
  public void a(lqb paramlqb)
  {
    h(paramlqb);
    f(paramlqb);
  }
  
  public void a(nff paramnff)
  {
    this.jdField_a_of_type_Nff = paramnff;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.jdField_a_of_type_Nfs != null) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Nfs.a(paramArrayOfByte, paramInt1, paramInt2, paramLong);
      b();
    }
  }
  
  public boolean a(lrp paramlrp, MotionEvent paramMotionEvent)
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
    bija.d("AVGameVideoLayer", "closeRemoteVideoView uin:=" + paramString2);
    if (a(paramString2, paramInt) >= 0)
    {
      a(paramString1, paramLong, paramString2, paramInt, true);
      a(paramString2, paramInt, true);
    }
  }
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Nfs != null) {
      this.jdField_a_of_type_Nfs.a(paramBoolean);
    }
    b();
  }
  
  public void d(String paramString) {}
  
  public int f()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNfz.length)
    {
      nfz localnfz = this.jdField_a_of_type_ArrayOfNfz[i];
      if ((TextUtils.isEmpty(localnfz.b())) || (localnfz.a() == 1)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Nfs = new nfs();
    this.jdField_a_of_type_Nfs.a(b(), c());
  }
  
  protected void f(lqb paramlqb)
  {
    super.a(paramlqb);
    p();
  }
  
  public int g()
  {
    int i = 0;
    while (i < this.jdField_b_of_type_ArrayOfNfz.length)
    {
      nfz localnfz = this.jdField_b_of_type_ArrayOfNfz[i];
      if ((TextUtils.isEmpty(localnfz.b())) || (localnfz.a() == 1)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Nfs != null)
    {
      this.jdField_a_of_type_Nfs.a();
      this.jdField_a_of_type_Nfs = null;
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_Nfw = nfw.a(paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface);
  }
  
  protected void h(lqb paramlqb)
  {
    if (this.jdField_a_of_type_Nfw != null) {
      this.jdField_a_of_type_Nfw.a(this.jdField_a_of_type_ArrayOfNfz, this.jdField_b_of_type_ArrayOfNfz, b(), c(), this.jdField_b_of_type_JavaUtilList);
    }
    paramlqb = this.jdField_a_of_type_ArrayOfNfz;
    int j = paramlqb.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramlqb[i];
      if ((localObject.a()) && (localObject.h() == 2) && (localObject.c() == 0)) {
        localObject.a((b() - 640) / 2, 40, (b() + 640) / 2, 520);
      }
      i += 1;
    }
  }
  
  public void l() {}
  
  public void m()
  {
    bija.d("AVGameVideoLayer", "doOnResume");
    nht.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void n()
  {
    bija.d("AVGameVideoLayer", "doOnStop");
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    nfz[] arrayOfnfz = this.jdField_a_of_type_ArrayOfNfz;
    int k = arrayOfnfz.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      nfz localnfz = arrayOfnfz[j];
      if (!localnfz.a()) {}
      for (;;)
      {
        j += 1;
        break;
        if (str.equalsIgnoreCase(localnfz.b()))
        {
          b("VideoLayer_doOnStop", -1L);
          i = 1;
        }
        else
        {
          b("VideoLayer_doOnStop", -1L, localnfz.b(), localnfz.h());
        }
      }
    }
    c(false);
    if ((CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(-1L)) && (i != 0)) {
      this.jdField_d_of_type_Boolean = true;
    }
    nht.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void o()
  {
    bija.d("AVGameVideoLayer", "doOnDestroy");
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNfz.length)
    {
      this.jdField_a_of_type_ArrayOfNfz[i].a(1);
      this.jdField_a_of_type_ArrayOfNfz[i].l(true);
      this.jdField_a_of_type_ArrayOfNfz[i].j(false);
      this.jdField_a_of_type_ArrayOfNfz[i].f(false);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfNfz = null;
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfNfz.length)
    {
      this.jdField_b_of_type_ArrayOfNfz[i].a(1);
      this.jdField_b_of_type_ArrayOfNfz[i].l(true);
      this.jdField_b_of_type_ArrayOfNfz[i].j(false);
      this.jdField_b_of_type_ArrayOfNfz[i].f(false);
      i += 1;
    }
    this.jdField_b_of_type_ArrayOfNfz = null;
    this.jdField_c_of_type_ArrayOfNfz = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void p()
  {
    this.jdField_a_of_type_Nfs.a(this.jdField_d_of_type_AndroidGraphicsRect, b(), c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfy
 * JD-Core Version:    0.7.0.1
 */