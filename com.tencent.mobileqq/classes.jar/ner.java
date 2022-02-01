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

public class ner
  extends lsk
  implements lsi, nfy
{
  private Context jdField_a_of_type_AndroidContentContext;
  public AVGameAppInterface a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVGameVideoLayer.1(this);
  public mxo a;
  private ndy jdField_a_of_type_Ndy;
  protected nel a;
  private nep jdField_a_of_type_Nep;
  protected nes[] a;
  public final List<nbr> b;
  public nes[] b;
  protected boolean c;
  protected nes[] c;
  public volatile Rect d;
  private boolean d;
  
  public ner(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(8);
    this.jdField_a_of_type_ArrayOfNes = new nes[9];
    this.jdField_b_of_type_ArrayOfNes = new nes[9];
    this.jdField_c_of_type_ArrayOfNes = new nes[1];
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Mxo = ((mxo)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(2));
    q();
    r();
    g(2);
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(long paramLong, mep parammep, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (parammep != null)
    {
      str = nhs.a(paramString, paramInt);
      parammep.a(paramString, paramInt);
      parammep.a(0);
      parammep.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    try
    {
      paramString = parammep.a();
      GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
      GraphicRenderMgr.getInstance().setGlRender(str, paramString);
      QLog.w("AVGameVideoLayer", 1, "setGlRender[initGLVideoViewBasePara], key[" + str + "], debug[" + parammep.c() + "], videoSrcType[" + paramInt + "], yuvTexture[" + paramString + "]");
      bkdd.a().a().a_(paramLong, false, paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError parammep)
    {
      parammep.printStackTrace();
    }
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    bkdp.d("AVGameVideoLayer", "closeGLVideoView uin:=" + paramString);
    paramInt = a(paramString, paramInt);
    if (paramInt >= 0)
    {
      paramString = this.jdField_a_of_type_ArrayOfNes[paramInt];
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
    bkdp.d("AVGameVideoLayer", "closeGLVideoViewBasePara uin:=" + paramString2);
    int i = a(paramString2, paramInt);
    if (i >= 0)
    {
      paramString2 = nhs.a(paramString2, paramInt);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(paramString2);
      if ((!paramBoolean) && (paramInt == 1)) {
        localGraphicRenderMgr.clearCameraFrames();
      }
      localGraphicRenderMgr.setGlRender(paramString2, null);
      QLog.w("AVGameVideoLayer", 1, "setGlRender[closeGLVideoViewBasePara], key[" + paramString2 + "], index[" + i + "], seq[" + paramLong + "], from[" + paramString1 + "]");
      if (paramBoolean) {
        bkdd.a().a().a_(paramLong, true, paramBoolean);
      }
    }
  }
  
  private void q()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNes.length)
    {
      this.jdField_a_of_type_ArrayOfNes[i] = new nes(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(i) }), 0L);
      this.jdField_a_of_type_ArrayOfNes[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfNes[i].a(Boolean.valueOf(false));
      this.jdField_a_of_type_ArrayOfNes[i].a(1);
      this.jdField_a_of_type_ArrayOfNes[i].h(-1);
      this.jdField_a_of_type_ArrayOfNes[i].c(i * 2);
      a(this.jdField_a_of_type_ArrayOfNes[i]);
      i += 1;
    }
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfNes.length)
    {
      this.jdField_b_of_type_ArrayOfNes[i] = new nes(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(i + 9) }), 0L, false);
      this.jdField_b_of_type_ArrayOfNes[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ArrayOfNes[i].a(1);
      this.jdField_b_of_type_ArrayOfNes[i].a(Boolean.valueOf(false));
      this.jdField_b_of_type_ArrayOfNes[i].h(-1);
      this.jdField_b_of_type_ArrayOfNes[i].c((i + 9) * 2);
      a(this.jdField_b_of_type_ArrayOfNes[i]);
      i += 1;
    }
    this.jdField_c_of_type_ArrayOfNes[0] = new nes(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(17) }), 0L, false);
    this.jdField_c_of_type_ArrayOfNes[0].c(81);
    this.jdField_c_of_type_ArrayOfNes[0].a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_ArrayOfNes[0].a(Boolean.valueOf(false));
    this.jdField_c_of_type_ArrayOfNes[0].a(1);
    a(this.jdField_c_of_type_ArrayOfNes[0]);
  }
  
  private void r()
  {
    d(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165334));
  }
  
  private void s()
  {
    bkdp.d("AVGameVideoLayer", "doResumeVideo");
    String str1 = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    Object localObject1 = nfm.b().a();
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
      bkdp.d("AVGameVideoLayer", "doResumeVideo mNeedRequest:=" + bool2 + ";mHasDoGoOnStage:=" + bool1 + ";mNeedReOpenCamera:=" + this.jdField_d_of_type_Boolean);
      if ((bool2) && (this.jdField_a_of_type_Ndy != null)) {
        this.jdField_a_of_type_Ndy.c();
      }
      return;
      label255:
      bool1 = true;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfNes == null) {
      return -1;
    }
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = 0;
      if (i < this.jdField_a_of_type_ArrayOfNes.length)
      {
        nes localnes = this.jdField_a_of_type_ArrayOfNes[i];
        if ((!paramString.equals(localnes.b())) || (paramInt != localnes.h()) || (localnes.a() != 0)) {}
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
        paramString = this.jdField_a_of_type_ArrayOfNes[i];
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
      str = nhs.a(str, 1);
      paramString = this.jdField_a_of_type_ArrayOfNes[i];
      GraphicRenderMgr.getInstance().setGlRender(str, paramString.a());
      QLog.w("AVGameVideoLayer", 1, "setGlRender[openSelfVideoView], key[" + str + "], index[" + i + "], forceToBigView[" + false + "], " + paramString.c());
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    QLog.w("AVGameVideoLayer", 1, "openRemoteVideoView, from[" + paramString1 + "], seq[" + paramLong + "], uin[" + paramString2);
    paramString1 = null;
    int i = a(paramString2, paramInt);
    String str = nhs.a(paramString2, paramInt);
    if (i < 0)
    {
      i = f();
      if (i >= 0)
      {
        paramString1 = this.jdField_a_of_type_ArrayOfNes[i];
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
      paramString1 = this.jdField_a_of_type_ArrayOfNes[i];
      GraphicRenderMgr.getInstance().setGlRender(str, paramString1.a());
      QLog.w("AVGameVideoLayer", 1, "setGlRender[openPeerVideo], key[" + str + "], seq[" + paramLong + "], index[" + i + "], " + paramString1.c());
    }
  }
  
  public void a(List<nbr> paramList) {}
  
  public void a(lqt paramlqt)
  {
    h(paramlqt);
    f(paramlqt);
  }
  
  public void a(ndy paramndy)
  {
    this.jdField_a_of_type_Ndy = paramndy;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.jdField_a_of_type_Nel != null) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_Nel.a(paramArrayOfByte, paramInt1, paramInt2, paramLong);
      b();
    }
  }
  
  public boolean a(lsh paramlsh, MotionEvent paramMotionEvent)
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
    bkdp.d("AVGameVideoLayer", "closeRemoteVideoView uin:=" + paramString2);
    if (a(paramString2, paramInt) >= 0)
    {
      a(paramString1, paramLong, paramString2, paramInt, true);
      a(paramString2, paramInt, true);
    }
  }
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Nel != null) {
      this.jdField_a_of_type_Nel.a(paramBoolean);
    }
    b();
  }
  
  public void d(String paramString) {}
  
  public int f()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNes.length)
    {
      nes localnes = this.jdField_a_of_type_ArrayOfNes[i];
      if ((TextUtils.isEmpty(localnes.b())) || (localnes.a() == 1)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Nel = new nel();
    this.jdField_a_of_type_Nel.a(b(), c());
  }
  
  protected void f(lqt paramlqt)
  {
    super.a(paramlqt);
    p();
  }
  
  public int g()
  {
    int i = 0;
    while (i < this.jdField_b_of_type_ArrayOfNes.length)
    {
      nes localnes = this.jdField_b_of_type_ArrayOfNes[i];
      if ((TextUtils.isEmpty(localnes.b())) || (localnes.a() == 1)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Nel != null)
    {
      this.jdField_a_of_type_Nel.a();
      this.jdField_a_of_type_Nel = null;
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_Nep = nep.a(paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface);
  }
  
  protected void h(lqt paramlqt)
  {
    if (this.jdField_a_of_type_Nep != null) {
      this.jdField_a_of_type_Nep.a(this.jdField_a_of_type_ArrayOfNes, this.jdField_b_of_type_ArrayOfNes, b(), c(), this.jdField_b_of_type_JavaUtilList);
    }
    paramlqt = this.jdField_a_of_type_ArrayOfNes;
    int j = paramlqt.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramlqt[i];
      if ((localObject.a()) && (localObject.h() == 2) && (localObject.c() == 0)) {
        localObject.a((b() - 640) / 2, 40, (b() + 640) / 2, 520);
      }
      i += 1;
    }
  }
  
  public void l() {}
  
  public void m()
  {
    bkdp.d("AVGameVideoLayer", "doOnResume");
    ngk.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void n()
  {
    bkdp.d("AVGameVideoLayer", "doOnStop");
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    nes[] arrayOfnes = this.jdField_a_of_type_ArrayOfNes;
    int k = arrayOfnes.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      nes localnes = arrayOfnes[j];
      if (!localnes.a()) {}
      for (;;)
      {
        j += 1;
        break;
        if (str.equalsIgnoreCase(localnes.b()))
        {
          b("VideoLayer_doOnStop", -1L);
          i = 1;
        }
        else
        {
          b("VideoLayer_doOnStop", -1L, localnes.b(), localnes.h());
        }
      }
    }
    c(false);
    if ((CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(-1L)) && (i != 0)) {
      this.jdField_d_of_type_Boolean = true;
    }
    ngk.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void o()
  {
    bkdp.d("AVGameVideoLayer", "doOnDestroy");
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNes.length)
    {
      this.jdField_a_of_type_ArrayOfNes[i].a(1);
      this.jdField_a_of_type_ArrayOfNes[i].l(true);
      this.jdField_a_of_type_ArrayOfNes[i].j(false);
      this.jdField_a_of_type_ArrayOfNes[i].f(false);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfNes = null;
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfNes.length)
    {
      this.jdField_b_of_type_ArrayOfNes[i].a(1);
      this.jdField_b_of_type_ArrayOfNes[i].l(true);
      this.jdField_b_of_type_ArrayOfNes[i].j(false);
      this.jdField_b_of_type_ArrayOfNes[i].f(false);
      i += 1;
    }
    this.jdField_b_of_type_ArrayOfNes = null;
    this.jdField_c_of_type_ArrayOfNes = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void p()
  {
    this.jdField_a_of_type_Nel.a(this.jdField_d_of_type_AndroidGraphicsRect, b(), c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ner
 * JD-Core Version:    0.7.0.1
 */