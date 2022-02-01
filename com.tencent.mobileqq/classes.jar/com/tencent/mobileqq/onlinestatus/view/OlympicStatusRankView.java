package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.onlinestatus.OlympicStatusResDownloader;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean.OlympicConfig;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean.OlympicShareConfig;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfProcessor;
import com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareHelper;
import com.tencent.mobileqq.onlinestatus.utils.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class OlympicStatusRankView
  extends BaseStatusCardView
{
  public static final int a = BaseApplication.getContext().getResources().getDimensionPixelSize(2131298863);
  public static final int b = BaseApplication.getContext().getResources().getDimensionPixelSize(2131298864);
  public static final int c = BaseApplication.getContext().getResources().getDimensionPixelSize(2131298862);
  public static final int d = BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865);
  private View e;
  private View f;
  private ImageView g;
  private ImageView h;
  private ImageView o;
  private ImageView p;
  private ImageView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private Button u;
  private Activity v;
  private long w;
  private OlympicConfBean.OlympicConfig x;
  private OlympicConfBean.OlympicShareConfig y;
  
  public OlympicStatusRankView(@NonNull Activity paramActivity, long paramLong, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramActivity, paramOnDismissCallback);
    this.v = paramActivity;
    this.w = paramLong;
    this.x = OlympicConfProcessor.b().b();
    this.y = ((OlympicConfBean.OlympicShareConfig)this.x.c.get(Integer.valueOf(OlympicShareHelper.a(this.w))));
    a();
  }
  
  private void a()
  {
    this.e = LayoutInflater.from(this.v).inflate(2131627857, null);
    this.f = this.e.findViewById(2131444989);
    this.g = ((ImageView)this.e.findViewById(2131436280));
    this.h = ((ImageView)this.e.findViewById(2131436479));
    this.o = ((ImageView)this.e.findViewById(2131436271));
    this.p = ((ImageView)this.e.findViewById(2131436523));
    this.r = ((TextView)this.e.findViewById(2131448606));
    this.q = ((ImageView)this.e.findViewById(2131436480));
    this.s = ((TextView)this.e.findViewById(2131448622));
    this.t = ((TextView)this.e.findViewById(2131448682));
    this.u = ((Button)this.e.findViewById(2131430026));
    this.j = this.f;
    this.i = this.e;
    b();
    setContentView(this.e);
  }
  
  private void b()
  {
    d();
    e();
    f();
    i();
    j();
    l();
    n();
    o();
    c();
  }
  
  private void c()
  {
    this.e.setOnClickListener(new OlympicStatusRankView.1(this));
    this.f.setOnClickListener(new OlympicStatusRankView.2(this));
  }
  
  private void d()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = a;
    localURLDrawableOptions.mRequestWidth = b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OlympicStatusResDownloader.b());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(OlympicShareHelper.b(this.w));
    ((StringBuilder)localObject).append("share_bg.png");
    localObject = ((StringBuilder)localObject).toString();
    if ((OlympicStatusResDownloader.d()) && (OlympicShareHelper.a((String)localObject))) {
      localObject = URLDrawable.getFileDrawable((String)localObject, localURLDrawableOptions);
    } else {
      localObject = URLDrawable.getDrawable("https://static-res.qq.com/static-res/online_status/olympics_state/share_bg_default@2x.png", localURLDrawableOptions);
    }
    ((URLDrawable)localObject).setTag(URLDrawableHelper.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, Utils.a(16.0F, getContext().getResources())));
    ((URLDrawable)localObject).setDecodeHandler(URLDrawableHelper.d);
    this.g.setImageDrawable((Drawable)localObject);
  }
  
  private void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OlympicStatusResDownloader.b());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append("share/share_mid_animation.png");
    localObject = ((StringBuilder)localObject).toString();
    if ((OlympicStatusResDownloader.d()) && (OlympicShareHelper.a((String)localObject)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = b;
      localURLDrawableOptions.mRequestHeight = c;
      localURLDrawableOptions.mUseApngImage = true;
      localObject = URLDrawable.getFileDrawable((String)localObject, localURLDrawableOptions);
      this.h.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void f()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    IFaceDecoder localIFaceDecoder = ((IQQAvatarService)localAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(localAppInterface);
    Bitmap localBitmap = localIFaceDecoder.getBitmapFromCache(1, localAppInterface.getCurrentAccountUin());
    if (localBitmap != null)
    {
      this.o.setImageBitmap(BaseImageUtil.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight()));
      return;
    }
    localIFaceDecoder.requestDecodeFace(localAppInterface.getCurrentAccountUin(), 200, false, 1, true, (byte)0, 4);
    localIFaceDecoder.setDecodeTaskCompletionListener(new OlympicStatusRankView.3(this, localIFaceDecoder));
  }
  
  private void i()
  {
    Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    localObject = OlympicShareHelper.a((AppInterface)localObject, ((AppInterface)localObject).getCurrentAccountUin());
    this.r.setText((CharSequence)localObject);
    localObject = this.y;
    if ((localObject != null) && (!TextUtils.isEmpty(((OlympicConfBean.OlympicShareConfig)localObject).b)))
    {
      this.r.setTextColor(Color.parseColor(this.y.b));
      return;
    }
    this.r.setTextColor(Color.parseColor("#ffffff"));
  }
  
  private void j()
  {
    Object localObject2 = OnLineStatusHelper.a().f();
    Object localObject1 = ((OnlineStatusItem)localObject2).c;
    localObject2 = ((OnlineStatusItem)localObject2).d;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      this.q.setVisibility(8);
    }
    else
    {
      this.q.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int i = d;
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      this.q.setImageDrawable((Drawable)localObject2);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      this.s.setText(2131896390);
    } else {
      this.s.setText((CharSequence)localObject1);
    }
    localObject1 = this.y;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((OlympicConfBean.OlympicShareConfig)localObject1).b)))
    {
      this.s.setTextColor(Color.parseColor(this.y.b));
      return;
    }
    this.s.setTextColor(Color.parseColor("#ffffff"));
  }
  
  private void l()
  {
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = Utils.a(40.0F, getContext().getResources());
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = Utils.a(100.0F, getContext().getResources());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(OlympicStatusResDownloader.b());
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append(OlympicShareHelper.b(this.w));
    ((StringBuilder)localObject2).append("share_name_card.png");
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((OlympicStatusResDownloader.d()) && (OlympicShareHelper.a((String)localObject2)))
    {
      ((URLDrawable.URLDrawableOptions)localObject1).mUseApngImage = true;
      localObject1 = URLDrawable.getFileDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
    }
    else
    {
      localObject1 = URLDrawable.getDrawable("https://static-res.qq.com/static-res/online_status/olympics_state/share_name_card_default@2x.png", (URLDrawable.URLDrawableOptions)localObject1);
    }
    this.p.setImageDrawable((Drawable)localObject1);
  }
  
  private void n()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("NO.");
    ((StringBuilder)localObject).append(this.w);
    localObject = ((StringBuilder)localObject).toString();
    this.t.setTypeface(Typeface.create("sans-serif-condensed", 1));
    this.t.setText((CharSequence)localObject);
    localObject = this.y;
    if ((localObject != null) && (!TextUtils.isEmpty(((OlympicConfBean.OlympicShareConfig)localObject).c)))
    {
      this.t.setTextColor(Color.parseColor(this.y.c));
      return;
    }
    this.t.setTextColor(Color.parseColor("#6a480b"));
  }
  
  private void o()
  {
    Object localObject = this.y;
    if ((localObject != null) && (!TextUtils.isEmpty(((OlympicConfBean.OlympicShareConfig)localObject).d))) {
      this.u.setText(this.y.d);
    } else {
      this.u.setText(getContext().getResources().getString(2131896391));
    }
    localObject = this.y;
    if ((localObject != null) && (!TextUtils.isEmpty(((OlympicConfBean.OlympicShareConfig)localObject).e))) {
      this.u.setTextColor(Color.parseColor(this.y.e));
    } else {
      this.u.setTextColor(Color.parseColor("#4249eb"));
    }
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(Utils.a(6.0F, getContext().getResources()));
    OlympicConfBean.OlympicShareConfig localOlympicShareConfig = this.y;
    if ((localOlympicShareConfig != null) && (!TextUtils.isEmpty(localOlympicShareConfig.f))) {
      ((GradientDrawable)localObject).setColor(Color.parseColor(this.y.f));
    } else {
      ((GradientDrawable)localObject).setColor(Color.parseColor("#ffffff"));
    }
    this.u.setBackgroundDrawable((Drawable)localObject);
    this.u.setOnClickListener(new OlympicStatusRankView.4(this));
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if ((this.j.getWidth() != 0) && (this.j.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.j.getWidth();
      paramArrayOfInt[1] = this.j.getHeight();
      return;
    }
    paramArrayOfInt[0] = b;
    paramArrayOfInt[1] = a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OlympicStatusRankView
 * JD-Core Version:    0.7.0.1
 */