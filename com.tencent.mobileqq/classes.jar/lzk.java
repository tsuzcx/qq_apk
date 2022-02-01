import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI.1;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public class lzk
  extends VideoLayerUIBase
{
  private lzl jdField_a_of_type_Lzl;
  moo jdField_a_of_type_Moo;
  private int i;
  
  public lzk(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView, lzl paramlzl)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.jdField_a_of_type_Lzl = paramlzl;
    this.t = 2;
    this.jdField_a_of_type_Mis = mis.a(paramContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController.a().N, true);
    n();
    m();
    l();
    r();
    t();
  }
  
  private void a(String paramString, YUVTexture paramYUVTexture)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.o())
    {
      GraphicRenderMgr.getInstance().setGlRender(paramString, paramYUVTexture);
      QLog.i("SmallScreenVideoLayerUI", 1, "setGlRender[small_screen], key[" + paramString + "], render[" + paramYUVTexture + "]");
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
    {
      this.jdField_a_of_type_ArrayOfMdy[0].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfMdy[1].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfMdy[2].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfMdy[3].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfMdy[4].a(Boolean.valueOf(true));
      if ((!this.jdField_a_of_type_ArrayOfMdy[0].f()) || ((this.u != 0) && (this.u != 180)) || (this.jdField_a_of_type_ArrayOfMdy[0].k())) {
        break label208;
      }
      if (this.u != 0) {
        break label181;
      }
      this.jdField_a_of_type_ArrayOfMdy[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297776));
    }
    for (;;)
    {
      this.jdField_a_of_type_Mis.a(this.jdField_a_of_type_ComTencentAvVideoController.a(), this.jdField_a_of_type_ArrayOfMdy, paramInt1, paramInt2, paramBoolean, this.u, this.o);
      return;
      label181:
      this.jdField_a_of_type_ArrayOfMdy[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297776), 0, 0);
      continue;
      label208:
      this.jdField_a_of_type_ArrayOfMdy[0].a(paramInt3, paramInt3, paramInt3, paramInt3);
    }
  }
  
  private int i()
  {
    int j = 0;
    int m;
    for (int k = 0; j < this.jdField_a_of_type_ArrayOfMdy.length; k = m)
    {
      mdy localmdy = this.jdField_a_of_type_ArrayOfMdy[j];
      String str = (String)localmdy.a(0);
      m = k;
      if (localmdy.a() == 0)
      {
        m = k;
        if (localmdy.j())
        {
          m = k;
          if (!TextUtils.isEmpty(str)) {
            m = k + 1;
          }
        }
      }
      j += 1;
    }
    return k;
  }
  
  private void i(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "closeVideoView index: " + paramInt);
    }
    int k = 0;
    float f1 = 0.0F;
    int j = 0;
    boolean bool1 = false;
    Object localObject2 = ImageView.ScaleType.CENTER_INSIDE;
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
    Object localObject1 = localObject2;
    int n;
    if (paramInt == 0)
    {
      m = this.jdField_a_of_type_ArrayOfMdy[0].f();
      float f2 = this.jdField_a_of_type_ArrayOfMdy[0].d();
      n = this.jdField_a_of_type_ArrayOfMdy[0].g();
      boolean bool2 = this.jdField_a_of_type_ArrayOfMdy[0].i();
      localObject1 = localObject2;
      bool1 = bool2;
      j = n;
      f1 = f2;
      k = m;
      if (i1 == 4)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfMdy[0].a();
        k = m;
        f1 = f2;
        j = n;
        bool1 = bool2;
      }
    }
    int m = paramInt;
    while (m < this.jdField_a_of_type_ArrayOfMdy.length) {
      if ((m < this.jdField_a_of_type_ArrayOfMdy.length - 1) && (this.jdField_a_of_type_ArrayOfMdy[(m + 1)].a() == 0))
      {
        n = this.jdField_a_of_type_ArrayOfMdy[m].d();
        int i2 = this.jdField_a_of_type_ArrayOfMdy[(m + 1)].d();
        this.jdField_a_of_type_ArrayOfMdy[m].c(i2);
        this.jdField_a_of_type_ArrayOfMdy[(m + 1)].c(n);
        localObject2 = this.jdField_a_of_type_ArrayOfMdy[m];
        this.jdField_a_of_type_ArrayOfMdy[m] = this.jdField_a_of_type_ArrayOfMdy[(m + 1)];
        this.jdField_a_of_type_ArrayOfMdy[(m + 1)] = localObject2;
        m += 1;
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ArrayOfMdy[m];
        ((mdy)localObject2).a(1);
        v_();
        ((mdy)localObject2).b(null);
        ((mdy)localObject2).l(true);
        ((mdy)localObject2).j(false);
        ((mdy)localObject2).f(false);
        ((mdy)localObject2).k(true);
        ((mdy)localObject2).a(null, 0);
        ((mdy)localObject2).a("");
      }
    }
    u();
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfMdy[0].g(false);
      this.jdField_a_of_type_ArrayOfMdy[0].k(k);
      this.jdField_a_of_type_ArrayOfMdy[0].a(f1);
      this.jdField_a_of_type_ArrayOfMdy[0].j(j);
      this.jdField_a_of_type_ArrayOfMdy[0].i(bool1);
      if (i1 == 4) {
        this.jdField_a_of_type_ArrayOfMdy[0].a((ImageView.ScaleType)localObject1);
      }
    }
    c(false);
  }
  
  private int j()
  {
    String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int j = 0;
    while (j < this.jdField_a_of_type_ArrayOfMdy.length)
    {
      mdy localmdy = this.jdField_a_of_type_ArrayOfMdy[j];
      String str2 = (String)localmdy.a(0);
      if ((localmdy.a() == 0) && (!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        return j;
      }
      j += 1;
    }
    return -1;
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "initGlVideoViewBackground");
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ArrayOfMdy != null)
    {
      int j = 1;
      while (j < this.jdField_a_of_type_ArrayOfMdy.length)
      {
        this.jdField_a_of_type_ArrayOfMdy[j].c(-1);
        j += 1;
      }
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ArrayOfMdy[0].a() == 0)
    {
      String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      String str2 = (String)this.jdField_a_of_type_ArrayOfMdy[0].a(0);
      if ((str2 != null) && (str2.equals(str1)))
      {
        int j = j();
        if (j > 0) {
          a(0, j);
        }
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setOffset topOffset: " + paramInt1 + ", bottomOffset: " + paramInt2);
    }
    this.n = paramInt1;
    this.o = paramInt2;
    c(true);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().J)
      {
        int j = 0;
        if (j < this.jdField_a_of_type_ArrayOfMdy.length)
        {
          mdy localmdy = this.jdField_a_of_type_ArrayOfMdy[j];
          if (j == 0) {
            if ((paramInt1 != 0) && (paramInt2 != 0)) {
              localmdy.i(false);
            }
          }
          for (;;)
          {
            j += 1;
            break;
            localmdy.i(true);
            continue;
            localmdy.i(true);
          }
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_ArrayOfMdy.length)
        {
          this.jdField_a_of_type_ArrayOfMdy[paramInt1].i(false);
          paramInt1 += 1;
        }
      }
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.d) && (!l())) {
      this.s = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramInt != this.r) || (paramInt == this.s))
      {
        if (paramInt % 90 != this.r % 90) {
          this.p = 0;
        }
        this.r = paramInt;
        this.s = paramInt;
        int j = VideoLayerUI.a("SmallScreenVideoLayerUI", this.jdField_a_of_type_AndroidContentContext, paramInt, paramBoolean, this.jdField_a_of_type_AndroidViewDisplay);
        switch (paramInt)
        {
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
        {
          if (this.u != 0)
          {
            paramBoolean = bool;
            if (this.u != 180) {}
          }
          else
          {
            paramBoolean = true;
          }
          c(paramBoolean);
          return;
          paramInt = 0;
          while (paramInt < super.e())
          {
            super.a(paramInt).b(j);
            paramInt += 1;
          }
          this.u = j;
        }
      }
    }
  }
  
  void a(String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    int k = a("setBackground", paramString, paramInt);
    int j = k;
    mdy localmdy;
    if (k < 0)
    {
      k = a(0);
      if (k >= 0)
      {
        localmdy = this.jdField_a_of_type_ArrayOfMdy[k];
        localmdy.a(0);
        v_();
        u();
        localmdy.a(0, paramString);
        localmdy.a(1, Integer.valueOf(paramInt));
        localmdy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        String str = VideoLayerUI.a(paramString, paramInt);
        a(str, null);
        a(str, localmdy.a());
        long l = AudioHelper.b();
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[setBackground], key[" + str + "], index[" + k + "], seq[" + l + "], " + localmdy.c());
        boolean bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            bool1 = false;
          }
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, bool1);
      }
      j = k;
      if (paramBoolean2)
      {
        j = k;
        if (k > 0)
        {
          a(0, k);
          j = 0;
        }
      }
    }
    if (j >= 0)
    {
      localmdy = this.jdField_a_of_type_ArrayOfMdy[j];
      localmdy.a(paramBitmap);
      localmdy.l(paramBoolean1);
      if (!paramBoolean1) {
        localmdy.j(false);
      }
    }
    c(false);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setBackground uin: " + paramString + ", videoSrcType: " + paramInt + ", index: " + j + ", needRenderVideo: " + paramBoolean1);
    }
  }
  
  void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    boolean bool = false;
    int j = a("setText", paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setText uin: " + paramString1 + ", videoSrcType: " + paramInt1 + ", text: " + paramString2 + ", textSize: " + paramFloat + ", textColor: " + paramInt2 + ", index: " + j);
    }
    if (j >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfMdy[j];
      paramString1.a(0);
      v_();
      u();
      paramString1.b(paramString2);
      paramString1.a(paramFloat);
      paramString1.k(paramInt2);
      if (j != 0) {
        bool = true;
      }
      paramString1.g(bool);
      if (j == 0) {
        paramString1.j(12);
      }
    }
    else
    {
      return;
    }
    paramString1.j(2147483647);
  }
  
  void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoLayerUI", 1, "setRemoteHasVideo, uin[" + paramString + "], videoSrcType[" + paramInt + "], isRemoteHasVideo[" + paramBoolean1 + "], forceToBigView[" + paramBoolean2 + "], mIsLocalHasVideo[" + this.d + "], isFillBlackEdge[" + paramBoolean3 + "], seq[" + l + "]");
    }
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))) {
      break label129;
    }
    label129:
    while (lsd.a(this.jdField_a_of_type_AndroidContentContext) == 1) {
      return;
    }
    boolean bool = paramBoolean2;
    if (a(this.jdField_a_of_type_ComTencentAvVideoController.a()))
    {
      bool = paramBoolean2;
      if (!paramBoolean2)
      {
        bool = paramBoolean2;
        if (!k()) {
          bool = true;
        }
      }
    }
    n();
    int j;
    String str;
    Object localObject;
    if (paramBoolean1)
    {
      j = a("setRemoteHasVideo_open", paramString, paramInt);
      str = VideoLayerUI.a(paramString, paramInt);
      if (j < 0)
      {
        j = a(0);
        if (j < 0) {
          break label736;
        }
        localObject = this.jdField_a_of_type_ArrayOfMdy[j];
        ((mdy)localObject).a(paramString, paramInt);
        ((mdy)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      }
    }
    for (;;)
    {
      try
      {
        a(str, ((mdy)localObject).a());
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_1], key[" + str + "], index[" + j + "], " + ((mdy)localObject).c());
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, true);
        paramString = (String)localObject;
        if ((j <= 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4)) {
          break label730;
        }
        paramInt = j;
        if (paramString != null)
        {
          paramString.f(paramBoolean3);
          paramString.a(l, this.jdField_a_of_type_Mis.b());
          paramString.j(true);
          paramString.a(0);
          v_();
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4) {
            break label596;
          }
          if (paramInt != 0) {
            break label586;
          }
          paramString.a(ImageView.ScaleType.CENTER_INSIDE);
        }
        if ((bool) && (paramInt > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().i))) {
          a(0, paramInt);
        }
        if (paramInt > 0) {
          u();
        }
        c(false);
        return;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      paramString = this.jdField_a_of_type_ArrayOfMdy[j];
      a(str, paramString.a());
      QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_2], key[" + str + "], index[" + j + "], " + paramString.c());
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, true);
      paramInt = j;
      continue;
      label586:
      paramString.a(ImageView.ScaleType.CENTER_CROP);
      continue;
      label596:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
      {
        paramString.a(ImageView.ScaleType.CENTER_INSIDE);
        continue;
        j = a("setRemoteHasVideo_close", paramString, paramInt);
        if (j < 0) {
          break;
        }
        paramString = VideoLayerUI.a(paramString, paramInt);
        localObject = GraphicRenderMgr.getInstance();
        ((GraphicRenderMgr)localObject).flushGlRender(paramString);
        ((GraphicRenderMgr)localObject).setGlRender(paramString, null);
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_no], key[" + paramString + "], index[" + j + "]");
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, true, true);
        i(j);
        return;
        label730:
        paramInt = j;
        continue;
        label736:
        paramString = null;
      }
    }
  }
  
  public void a(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    case 6006: 
    case 6007: 
    default: 
    case 6005: 
      do
      {
        return;
      } while (((mci)mcc.a(paramObservable)).a != 2);
      return;
    }
    o();
    paramObservable = (lgc)paramObservable[1];
    this.jdField_a_of_type_Moo.a(paramObservable);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "switchVideo index1: " + paramInt1 + ", index2: " + paramInt2);
    }
    if ((paramInt1 == paramInt2) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfMdy.length) || (paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfMdy.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoLayerUI", 2, "switchVideo index invalid!");
      }
      return false;
    }
    a(paramInt1, paramInt2);
    return true;
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoLayerUI", 1, "setLocalHasVideo, isLocalHasVideo[" + this.d + "->" + paramBoolean1 + "], forceToBigView[" + paramBoolean2 + "], seq[" + l + "]");
    }
    if (lsd.a(this.jdField_a_of_type_AndroidContentContext) == 1) {
      return false;
    }
    int j;
    String str1;
    Object localObject3;
    if (paramBoolean1)
    {
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      j = a("setLocalHasVideo_open", str2, 1);
      str1 = VideoLayerUI.a(str2, 1);
      if (j < 0)
      {
        int k = a(0);
        if (k >= 0)
        {
          localObject3 = this.jdField_a_of_type_ArrayOfMdy[k];
          ((mdy)localObject3).a(0, str2);
          ((mdy)localObject3).a(1, Integer.valueOf(1));
          ((mdy)localObject3).a(str2);
        }
        try
        {
          GraphicRenderMgr.getInstance().setAccountUin(str2);
          a(str1, ((mdy)localObject3).a());
          localObject1 = localObject4;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            localObject2 = "UnsatisfiedLinkError" + localUnsatisfiedLinkError.getMessage();
          }
        }
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_1], key[" + str1 + "], index[" + k + "], log[" + localObject1 + "], " + ((mdy)localObject3).c());
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, false);
        localObject1 = localObject3;
        localObject3 = localObject1;
        j = k;
        if (k <= 1) {
          break label566;
        }
        localObject3 = localObject1;
        j = k;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4) {
          break label566;
        }
        j = k;
        if (localObject1 != null)
        {
          localObject1.f(false);
          localObject1.j(false);
          localObject1.l(true);
          localObject1.a(0);
          localObject1.a(ImageView.ScaleType.CENTER_CROP);
          if (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(l)) {
            localObject1.a(l, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
          }
          v_();
        }
        if (j == 0)
        {
          k = j();
          if (k > 0) {
            a(j, k);
          }
        }
        c(false);
      }
    }
    for (;;)
    {
      this.d = paramBoolean1;
      return true;
      localObject3 = this.jdField_a_of_type_ArrayOfMdy[j];
      a(str1, ((mdy)localObject3).a());
      QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_2], key[" + str1 + "], index[" + j + "], " + ((mdy)localObject3).c());
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, false);
      label566:
      Object localObject2 = localObject3;
      break;
      if (!paramBoolean1)
      {
        ThreadManager.post(this.b, 8, null, false);
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        j = a("setLocalHasVideo_close", (String)localObject2, 1);
        if (j >= 0)
        {
          localObject2 = VideoLayerUI.a((String)localObject2, 1);
          localObject3 = GraphicRenderMgr.getInstance();
          ((GraphicRenderMgr)localObject3).flushGlRender((String)localObject2);
          ((GraphicRenderMgr)localObject3).clearCameraFrames();
          ((GraphicRenderMgr)localObject3).setGlRender((String)localObject2, null);
          QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_no], key[" + (String)localObject2 + "], index[" + j + "]");
          this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, true, false);
          i(j);
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = true;
    int j = super.b();
    int k = super.c();
    lez locallez = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoLayerUI", 1, "layoutVideoView, virtical[" + paramBoolean + "], sessionType[" + locallez.d + "], width[" + j + "], height[" + k + "]");
    }
    this.jdField_a_of_type_ArrayOfMdy[0].a(0, 0, 0, 0);
    this.jdField_a_of_type_ArrayOfMdy[0].b(0, 0, j, k);
    this.jdField_a_of_type_ArrayOfMdy[0].d(-15197410);
    if (a(locallez))
    {
      mis localmis = this.jdField_a_of_type_Mis;
      mdy[] arrayOfmdy = this.jdField_a_of_type_ArrayOfMdy;
      int m = this.t;
      int n = this.n;
      int i1 = this.o;
      if (!locallez.e)
      {
        paramBoolean = bool;
        localmis.a(arrayOfmdy, j, k, m, n, i1, paramBoolean);
        lil.b(k, j);
      }
    }
    for (;;)
    {
      super.b();
      return;
      paramBoolean = false;
      break;
      if (b(locallez)) {
        a(paramBoolean, j, k, 0);
      }
    }
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onFirstDraw");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new SmallScreenVideoLayerUI.1(this));
    }
  }
  
  public int f()
  {
    return this.jdField_a_of_type_Mis.a();
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
    if (this.jdField_a_of_type_Mis.a() != paramInt)
    {
      this.jdField_a_of_type_Mis = mis.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, true);
      c(true);
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_ArrayOfMdy.length)
      {
        this.jdField_a_of_type_ArrayOfMdy[paramInt].d(this.jdField_a_of_type_Mis.b());
        a(-1049L, this.jdField_a_of_type_ArrayOfMdy[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  public void h(int paramInt)
  {
    this.jdField_a_of_type_Mis.a(this.jdField_a_of_type_ArrayOfMdy, b(), c(), paramInt, this.n, this.o);
  }
  
  public void m()
  {
    this.jdField_a_of_type_Mjb = new mjb(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  public void n()
  {
    super.n();
    int j = 0;
    while (j < this.jdField_a_of_type_ArrayOfMdy.length)
    {
      this.jdField_a_of_type_ArrayOfMdy[j].m(true);
      j += 1;
    }
  }
  
  void o()
  {
    if (this.jdField_a_of_type_Moo == null) {
      this.jdField_a_of_type_Moo = new moo(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public void p()
  {
    super.p();
    if (this.jdField_a_of_type_Mis != null)
    {
      this.jdField_a_of_type_Mis.a();
      this.jdField_a_of_type_Mis = null;
    }
  }
  
  void v_()
  {
    int j = i();
    if (this.i != j)
    {
      this.i = j;
      if (this.jdField_a_of_type_Lzl != null) {
        this.jdField_a_of_type_Lzl.a(this.i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzk
 * JD-Core Version:    0.7.0.1
 */