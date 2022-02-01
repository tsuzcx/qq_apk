package cooperation.vip.qqbanner.manager;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.qqbanner.data.ImmersionData;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerImmersionInfo;

public class VasADImmersionBannerManager
  extends VasADBannerManager
{
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private ImageView i;
  private ImageView j;
  private RelativeLayout k;
  private RelativeLayout l;
  private Drawable m;
  private VasADBannerImmersionInfo n;
  
  private int a(VasADBannerImmersionInfo paramVasADBannerImmersionInfo)
  {
    if (paramVasADBannerImmersionInfo == null) {
      return 24;
    }
    paramVasADBannerImmersionInfo = this.n.b;
    if (paramVasADBannerImmersionInfo != null)
    {
      if (TextUtils.isEmpty(paramVasADBannerImmersionInfo.f)) {
        return 24;
      }
      try
      {
        int i1 = Integer.parseInt(paramVasADBannerImmersionInfo.f);
        return i1;
      }
      catch (Exception paramVasADBannerImmersionInfo)
      {
        paramVasADBannerImmersionInfo.printStackTrace();
        QLog.i("VasADBannerManager", 1, "getFrameRate exception");
      }
    }
    return 24;
  }
  
  private void m()
  {
    Object localObject2 = this.b.getLayoutParams();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ViewGroup.LayoutParams(-1, -2);
    }
    ((ViewGroup.LayoutParams)localObject1).width = k();
    ((ViewGroup.LayoutParams)localObject1).height = l();
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject2 = (ViewGroup.MarginLayoutParams)this.k.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = this.l.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = k();
    ((ViewGroup.LayoutParams)localObject2).height = super.l();
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = this.j.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = ((int)(((ViewGroup.LayoutParams)localObject1).height * 2.050848F));
    ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.b.addOnLayoutChangeListener(new VasADImmersionBannerManager.1(this));
  }
  
  private void n()
  {
    if (this.a != null)
    {
      if (this.a.app == null) {
        return;
      }
      QLog.i("VasADBannerManager", 1, "notifyBannerShow");
      Message localMessage = Message.obtain();
      localMessage.what = 3000;
      localMessage.obj = new View[] { this.b, this.g, this.h, this.i };
      BannerManager.a().b(VasADBannerProcessor.a, localMessage);
    }
  }
  
  private void o()
  {
    if (this.a != null)
    {
      if (this.a.app == null) {
        return;
      }
      QLog.i("VasADBannerManager", 1, "notifyBannerHide");
      BannerManager.a().b(VasADBannerProcessor.a, 3001);
    }
  }
  
  public View a()
  {
    View localView = super.a();
    this.e = ((TextView)localView.findViewById(2131448576));
    this.f = ((TextView)localView.findViewById(2131448728));
    this.g = ((TextView)localView.findViewById(2131448231));
    this.h = ((TextView)localView.findViewById(2131448239));
    this.i = ((ImageView)localView.findViewById(2131431401));
    this.j = ((ImageView)localView.findViewById(2131435439));
    this.k = ((RelativeLayout)localView.findViewById(2131431392));
    this.l = ((RelativeLayout)localView.findViewById(2131437007));
    m();
    return new View(this.a);
  }
  
  protected void a(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    super.a(paramVasADBannerConfigInfo);
    ThreadManagerV2.getUIHandlerV2().post(new VasADImmersionBannerManager.2(this, paramVasADBannerConfigInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.m != null)
    {
      if (paramBoolean)
      {
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).stop(this.m);
        return;
      }
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).start(this.m);
    }
  }
  
  protected int b()
  {
    return 2131628357;
  }
  
  public void c()
  {
    super.c();
    if (this.m != null)
    {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).stop(this.m);
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(this.m);
    }
    o();
  }
  
  public void d()
  {
    super.d();
    if (this.m != null)
    {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).stop(this.m);
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(this.m);
      this.m = null;
    }
  }
  
  public void g()
  {
    super.g();
    n();
  }
  
  protected int l()
  {
    return super.l() + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + ViewUtils.dpToPx(50.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADImmersionBannerManager
 * JD-Core Version:    0.7.0.1
 */