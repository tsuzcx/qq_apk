package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.utils.ThreadManager;
import com.tencent.qphone.base.util.QLog;

abstract class BaseBannerView
  extends RelativeLayout
  implements HitNumberListener, IBannerView
{
  protected HitNumberView a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected ImageView e;
  protected GiftAnimData f;
  protected BannerAnimListener g;
  protected BannerResManager h;
  protected long i = 0L;
  protected boolean j = false;
  protected Runnable k = new BaseBannerView.1(this);
  
  public BaseBannerView(Context paramContext, BannerResManager paramBannerResManager)
  {
    super(paramContext);
    this.h = paramBannerResManager;
    LayoutInflater.from(paramContext).inflate(c(), this, true);
    a();
  }
  
  private String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (paramString.length() > 4)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, paramInt - 1));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  protected void a()
  {
    this.a = ((HitNumberView)findViewById(2131439506));
    this.b = ((TextView)findViewById(2131439316));
    this.c = ((TextView)findViewById(2131439315));
    this.d = ((TextView)findViewById(2131434261));
    this.e = ((ImageView)findViewById(2131429397));
    this.a.setResManager(this.h);
    this.a.setListener(this);
  }
  
  public void a(int paramInt)
  {
    this.j = true;
    ThreadManager.b(this.k);
    this.i = System.currentTimeMillis();
    this.a.a(paramInt);
  }
  
  public void a(GiftAnimData paramGiftAnimData, String paramString)
  {
    this.f = paramGiftAnimData;
    this.b.setText(a(paramGiftAnimData.h, 4));
    this.c.setText(a(paramGiftAnimData.j, 4));
    paramString = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("送");
    localStringBuilder.append(a(paramGiftAnimData.c, 3));
    localStringBuilder.append("给");
    paramString.setText(localStringBuilder.toString());
  }
  
  public void a(BannerAnimListener paramBannerAnimListener)
  {
    this.g = paramBannerAnimListener;
  }
  
  public void b()
  {
    ThreadManager.b(this.k);
    this.j = false;
    this.a.b();
  }
  
  public void b(int paramInt)
  {
    this.a.setNum(paramInt);
  }
  
  abstract int c();
  
  public void c(int paramInt)
  {
    this.e.setImageBitmap(this.a.a.d(paramInt));
  }
  
  public void d()
  {
    this.j = true;
    ThreadManager.b(this.k);
  }
  
  protected void f()
  {
    this.j = false;
    long l = Math.max(3000L - (System.currentTimeMillis() - this.i), 600L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnd need delay:");
    localStringBuilder.append(l);
    QLog.i("Gift_Banner_BBanner", 1, localStringBuilder.toString());
    ThreadManager.a(this.k, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.BaseBannerView
 * JD-Core Version:    0.7.0.1
 */