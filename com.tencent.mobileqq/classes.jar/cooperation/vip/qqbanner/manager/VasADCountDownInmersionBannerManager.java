package cooperation.vip.qqbanner.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.qqbanner.data.CountDownImmersionData;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo.ResourceInfo;
import cooperation.vip.qqbanner.info.VasADBannerCountDownImmersionInfo;
import java.util.Timer;
import java.util.TimerTask;

public class VasADCountDownInmersionBannerManager
  extends VasADBannerManager
{
  private int e;
  private TextView f;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private RelativeLayout k;
  private RelativeLayout l;
  private TextView m;
  private TextView n;
  private URLDrawable o;
  private URLDrawable p;
  private URLDrawable q;
  private URLDrawable r;
  private URLDrawable s;
  private VasADBannerCountDownImmersionInfo t;
  private Timer u;
  private TimerTask v;
  private long w;
  
  private URLDrawable a(VasADBannerCountDownImmersionInfo paramVasADBannerCountDownImmersionInfo, int paramInt)
  {
    paramVasADBannerCountDownImmersionInfo = (VasADBannerConfigInfo.ResourceInfo)paramVasADBannerCountDownImmersionInfo.a.get(paramInt);
    if (paramVasADBannerCountDownImmersionInfo == null)
    {
      paramVasADBannerCountDownImmersionInfo = new StringBuilder();
      paramVasADBannerCountDownImmersionInfo.append("getApngDrawable error,type = ");
      paramVasADBannerCountDownImmersionInfo.append(paramInt);
      QLog.e("QbossADCountDownInmersi", 1, paramVasADBannerCountDownImmersionInfo.toString());
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    localObject = URLDrawable.getFileDrawable(paramVasADBannerCountDownImmersionInfo.c, (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalDrawable urlDrawable has memory data , url = ");
      localStringBuilder.append(paramVasADBannerCountDownImmersionInfo.a);
      QLog.i("QbossADCountDownInmersi", 1, localStringBuilder.toString());
      return localObject;
    }
    ((URLDrawable)localObject).setURLDrawableListener(new VasADCountDownInmersionBannerManager.2(this, paramVasADBannerCountDownImmersionInfo));
    ThreadManager.executeOnFileThread(new VasADCountDownInmersionBannerManager.3(this, (URLDrawable)localObject));
    return localObject;
  }
  
  private String a(long paramLong)
  {
    long l2 = 0L;
    if (paramLong <= 0L) {
      return "00:00:00";
    }
    long l1 = paramLong;
    if (paramLong >= 3600L)
    {
      l2 = paramLong / 3600L;
      l1 = paramLong % 3600L;
    }
    paramLong = l1 / 60L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(l2));
    localStringBuilder.append(":");
    localStringBuilder.append(b(paramLong));
    localStringBuilder.append(":");
    localStringBuilder.append(b(l1 % 60L));
    return localStringBuilder.toString();
  }
  
  private URLDrawable b(VasADBannerCountDownImmersionInfo paramVasADBannerCountDownImmersionInfo, int paramInt)
  {
    ApngOptions localApngOptions = new ApngOptions();
    localApngOptions.a(new ColorDrawable(7));
    localApngOptions.a(true);
    localApngOptions.a(new int[] { 2 });
    Object localObject = (VasADBannerConfigInfo.ResourceInfo)paramVasADBannerCountDownImmersionInfo.a.get(paramInt);
    paramVasADBannerCountDownImmersionInfo = null;
    if (localObject == null)
    {
      paramVasADBannerCountDownImmersionInfo = new StringBuilder();
      paramVasADBannerCountDownImmersionInfo.append("getApngDrawable error,type = ");
      paramVasADBannerCountDownImmersionInfo.append(paramInt);
      QLog.e("QbossADCountDownInmersi", 1, paramVasADBannerCountDownImmersionInfo.toString());
      return null;
    }
    String str = ((VasADBannerConfigInfo.ResourceInfo)localObject).a;
    localObject = ((VasADBannerConfigInfo.ResourceInfo)localObject).c;
    if (!FileUtils.isEmptyFile((String)localObject)) {
      return ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", localApngOptions, (String)localObject);
    }
    if (str.startsWith("https://")) {
      paramVasADBannerCountDownImmersionInfo = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(str, localApngOptions);
    }
    return paramVasADBannerCountDownImmersionInfo;
  }
  
  private String b(long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong < 10L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(Long.toString(paramLong));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    URLDrawable localURLDrawable;
    if (paramBoolean)
    {
      this.h.setVisibility(0);
      this.g.setVisibility(8);
      this.f.setVisibility(8);
      localURLDrawable = this.p;
      if (localURLDrawable != null) {
        this.j.setImageDrawable(localURLDrawable);
      }
      localURLDrawable = this.r;
      if (localURLDrawable != null) {
        this.h.setImageDrawable(localURLDrawable);
      }
      if (this.s != null) {
        this.d.setImageDrawable(this.s);
      }
    }
    else
    {
      this.h.setVisibility(8);
      this.g.setVisibility(0);
      this.f.setVisibility(0);
      localURLDrawable = this.o;
      if (localURLDrawable != null) {
        this.j.setImageDrawable(localURLDrawable);
      }
      localURLDrawable = this.q;
      if (localURLDrawable != null) {
        this.g.setImageDrawable(localURLDrawable);
      }
    }
  }
  
  private void c(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    if (paramVasADBannerConfigInfo == null) {
      return;
    }
    if ((paramVasADBannerConfigInfo instanceof VasADBannerCountDownImmersionInfo))
    {
      paramVasADBannerConfigInfo = (VasADBannerCountDownImmersionInfo)paramVasADBannerConfigInfo;
      this.t = paramVasADBannerConfigInfo;
      CountDownImmersionData localCountDownImmersionData = this.t.f();
      if (localCountDownImmersionData == null) {
        return;
      }
      this.o = b(paramVasADBannerConfigInfo, 5);
      this.p = b(paramVasADBannerConfigInfo, 6);
      this.q = a(paramVasADBannerConfigInfo, 3);
      this.r = a(paramVasADBannerConfigInfo, 4);
      this.s = a(paramVasADBannerConfigInfo, 7);
      this.f.setTextColor(a(localCountDownImmersionData.f));
      s();
      this.w = (localCountDownImmersionData.e * 1000L);
      long l1 = (this.w - System.currentTimeMillis()) / 1000L;
      paramVasADBannerConfigInfo = new StringBuilder();
      paramVasADBannerConfigInfo.append("handleBannerShow countDownTotalTime = ");
      paramVasADBannerConfigInfo.append(l1);
      paramVasADBannerConfigInfo.append(" mCountDownTime = ");
      paramVasADBannerConfigInfo.append(this.w);
      paramVasADBannerConfigInfo.append(" countDownTotalTime = ");
      paramVasADBannerConfigInfo.append(l1);
      QLog.e("QbossADCountDownInmersi", 1, paramVasADBannerConfigInfo.toString());
      if (l1 > 0L)
      {
        p();
        return;
      }
      q();
    }
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
    ((ViewGroup.LayoutParams)localObject2).width = ((int)(((ViewGroup.LayoutParams)localObject1).height * 2.20339F));
    ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = this.g.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = ViewUtils.dpToPx(40.0F);
    ((ViewGroup.LayoutParams)localObject1).height = ViewUtils.dpToPx(40.0F);
    this.g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.h.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = ViewUtils.dpToPx(244.0F);
    ((ViewGroup.LayoutParams)localObject1).height = ViewUtils.dpToPx(38.0F);
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  private void n()
  {
    if (this.a != null)
    {
      if (this.a.app == null) {
        return;
      }
      QLog.i("QbossADCountDownInmersi", 1, "notifyBannerShow");
      Message localMessage = Message.obtain();
      localMessage.what = 3000;
      localMessage.obj = new View[] { this.b, this.m, this.n, this.i };
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
      QLog.i("QbossADCountDownInmersi", 1, "notifyBannerHide");
      BannerManager.a().b(VasADBannerProcessor.a, 3001);
    }
  }
  
  private void p()
  {
    b(false);
    QLog.e("QbossADCountDownInmersi", 1, "startCountDown");
    r();
    this.u = new Timer();
    this.v = new VasADCountDownInmersionBannerManager.4(this);
    this.u.schedule(this.v, 0L, 1000L);
  }
  
  private void q()
  {
    QLog.e("QbossADCountDownInmersi", 1, "countDownComplete");
    r();
    b(true);
  }
  
  private void r()
  {
    QLog.e("QbossADCountDownInmersi", 1, "stopTimer");
    Object localObject = this.v;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    localObject = this.u;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    this.u = null;
    this.v = null;
  }
  
  private void s()
  {
    Object localObject = BaseApplicationImpl.getApplication().getAssets();
    if (localObject != null)
    {
      localObject = Typeface.createFromAsset((AssetManager)localObject, "fonts/DIN Alternate.ttf");
      if (localObject != null)
      {
        QLog.e("QbossADCountDownInmersi", 1, "setTypeFace");
        this.f.setTypeface((Typeface)localObject);
      }
    }
  }
  
  public View a()
  {
    View localView = super.a();
    this.f = ((TextView)localView.findViewById(2131448357));
    this.g = ((ImageView)localView.findViewById(2131435454));
    this.h = ((ImageView)localView.findViewById(2131435455));
    this.m = ((TextView)localView.findViewById(2131448231));
    this.n = ((TextView)localView.findViewById(2131448239));
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
    ThreadManagerV2.getUIHandlerV2().post(new VasADCountDownInmersionBannerManager.1(this, paramVasADBannerConfigInfo));
  }
  
  protected int b()
  {
    return 2131628356;
  }
  
  public void c()
  {
    super.c();
    o();
    r();
  }
  
  public void d()
  {
    super.d();
    r();
    this.p = null;
    this.o = null;
  }
  
  public void g()
  {
    super.g();
    n();
  }
  
  public void h()
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      localObject = ((VasADBannerCountDownImmersionInfo)localObject).f();
      if ((localObject != null) && (((CountDownImmersionData)localObject).l)) {
        return;
      }
    }
    super.h();
  }
  
  protected int l()
  {
    this.e = super.l();
    return this.e + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + ViewUtils.dpToPx(50.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager
 * JD-Core Version:    0.7.0.1
 */