package com.tencent.mobileqq.nearby.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.nearby.CikeConfigData;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRelativeLayout;

public class NearbyAppDownloadDialog
  extends Dialog
  implements View.OnClickListener
{
  protected Context a;
  protected RoundRelativeLayout b;
  protected TextView c;
  protected ImageView d;
  protected Button e;
  protected ImageView f;
  protected TextView g;
  protected Drawable h;
  protected int i;
  protected int j;
  protected CikeConfigData k;
  
  public NearbyAppDownloadDialog(Context paramContext)
  {
    super(paramContext, 2131953338);
    this.a = paramContext;
    a();
  }
  
  protected void a()
  {
    setContentView(2131624604);
    this.b = ((RoundRelativeLayout)findViewById(2131431358));
    this.e = ((Button)findViewById(2131429786));
    this.d = ((ImageView)findViewById(2131429408));
    this.f = ((ImageView)findViewById(2131435536));
    this.c = ((TextView)findViewById(2131447419));
    this.g = ((TextView)findViewById(2131438844));
    this.f.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.b.setRoundLayoutRadius(ScreenUtil.dip2px(3.0F));
    this.i = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(28.0F) * 2);
    this.j = (this.i * 150 / 320);
    Object localObject = this.d.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.i;
    ((ViewGroup.LayoutParams)localObject).height = this.j;
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init, w=");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(", h=");
      ((StringBuilder)localObject).append(this.j);
      QLog.d("NearbyAppDownloadDialog", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a(ImageView paramImageView, String paramString)
  {
    if (this.h == null) {
      this.h = new ColorDrawable(Color.parseColor("#f4f4f4"));
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadImage, url=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("NearbyAppDownloadDialog", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.j;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.i;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.h;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.h;
        localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      }
      else
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("NearbyAppDownloadDialog", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadImage exp: url=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.w("NearbyAppDownloadDialog", 2, ((StringBuilder)localObject1).toString(), localException);
        localObject1 = localObject2;
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = this.h;
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  protected void a(String paramString)
  {
    new ReportTask(null).a("dc00899").b("grp_lbs").c("home").d(paramString).e(this.k.g).a(new String[] { this.k.f }).a();
  }
  
  public boolean a(CikeConfigData paramCikeConfigData)
  {
    this.k = paramCikeConfigData;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initContent=");
      localStringBuilder.append(paramCikeConfigData.toString());
      QLog.d("NearbyAppDownloadDialog", 2, localStringBuilder.toString());
    }
    a(this.d, paramCikeConfigData.a);
    if (!TextUtils.isEmpty(paramCikeConfigData.c))
    {
      this.e.setText(paramCikeConfigData.c);
      this.e.setVisibility(0);
    }
    else
    {
      this.e.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramCikeConfigData.b))
    {
      this.c.setText(paramCikeConfigData.b);
      this.c.setVisibility(0);
    }
    else
    {
      this.c.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramCikeConfigData.e))
    {
      this.g.setVisibility(0);
      return false;
    }
    this.g.setVisibility(8);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == 2131435536)
    {
      dismiss();
      a("pop_new_quit");
      return;
    }
    if (m == 2131429786)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("btn onClick, jumpUrl=");
        paramView.append(this.k.d);
        QLog.d("NearbyAppDownloadDialog", 2, paramView.toString());
      }
      NearbyPublishMenuHelper.a(this.a, this.k.d);
      dismiss();
      a("pop_new_clk");
      return;
    }
    if (m == 2131438844)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("more onClick, jumpUrl=");
        paramView.append(this.k.e);
        QLog.d("NearbyAppDownloadDialog", 2, paramView.toString());
      }
      NearbyPublishMenuHelper.a(this.a, this.k.e);
    }
  }
  
  public void show()
  {
    super.show();
    a("pop_new_exp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyAppDownloadDialog
 * JD-Core Version:    0.7.0.1
 */