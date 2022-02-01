package com.tencent.mobileqq.nearby.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRelativeLayout;
import org.json.JSONObject;

public class NearbyActivityDialog
  extends Dialog
  implements View.OnClickListener
{
  protected String a = "";
  protected Context b;
  protected RoundRelativeLayout c;
  protected RoundRelativeLayout d;
  protected Button e;
  protected ImageView f;
  protected ImageView g;
  protected RoundRelativeLayout h;
  protected Drawable i;
  protected int j;
  protected int k;
  protected AppInterface l;
  protected Handler m;
  
  public NearbyActivityDialog(AppInterface paramAppInterface, Context paramContext)
  {
    super(paramContext, 2131953338);
    this.b = paramContext;
    this.l = paramAppInterface;
    this.m = new Handler(Looper.getMainLooper());
    a();
  }
  
  private void a()
  {
    setContentView(2131624603);
    this.c = ((RoundRelativeLayout)findViewById(2131435542));
    this.d = ((RoundRelativeLayout)findViewById(2131429850));
    this.e = ((Button)findViewById(2131429786));
    this.f = ((ImageView)findViewById(2131435543));
    this.g = ((ImageView)findViewById(2131435536));
    this.h = ((RoundRelativeLayout)findViewById(2131437635));
    this.g.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.c.setRoundLayoutRadius(ScreenUtil.dip2px(3.0F));
    this.d.setRoundLayoutRadius(ScreenUtil.dip2px(3.0F));
    this.h.setRoundLayoutRadius(ScreenUtil.dip2px(3.0F));
    this.j = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(28.0F) * 2);
    this.k = (this.j * 5 / 4);
    Object localObject = this.c.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.j;
    ((ViewGroup.LayoutParams)localObject).height = this.k;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init, w=");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append(", h=");
      ((StringBuilder)localObject).append(this.k);
      QLog.d("NearbyActivityDialog", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(ImageView paramImageView, String paramString)
  {
    if (this.i == null) {
      this.i = new ColorDrawable(Color.parseColor("#f2f2f2"));
    }
    Object localObject2 = null;
    URLDrawable localURLDrawable2 = null;
    URLDrawable localURLDrawable1 = localURLDrawable2;
    Object localObject1;
    try
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.k;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.j;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.i;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.i;
      localURLDrawable1 = localURLDrawable2;
      if (!TextUtils.isEmpty(paramString))
      {
        localURLDrawable1 = localURLDrawable2;
        localURLDrawable2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
        localURLDrawable1 = localURLDrawable2;
        if (QLog.isColorLevel())
        {
          localURLDrawable1 = localURLDrawable2;
          localObject1 = new StringBuilder();
          localURLDrawable1 = localURLDrawable2;
          ((StringBuilder)localObject1).append("loadImage, status=");
          localURLDrawable1 = localURLDrawable2;
          ((StringBuilder)localObject1).append(localURLDrawable2.getStatus());
          localURLDrawable1 = localURLDrawable2;
          ((StringBuilder)localObject1).append(", url=");
          localURLDrawable1 = localURLDrawable2;
          ((StringBuilder)localObject1).append(paramString);
          localURLDrawable1 = localURLDrawable2;
          QLog.d("NearbyActivityDialog", 2, ((StringBuilder)localObject1).toString());
        }
        localURLDrawable1 = localURLDrawable2;
        localObject1 = localURLDrawable2;
        if (localURLDrawable2.getStatus() != 1)
        {
          localURLDrawable1 = localURLDrawable2;
          this.h.setVisibility(0);
          localURLDrawable1 = localURLDrawable2;
          this.m.postDelayed(new NearbyActivityDialog.1(this), 2500L);
          localURLDrawable1 = localURLDrawable2;
          localURLDrawable2.setDownloadListener(new NearbyActivityDialog.2(this));
          localURLDrawable1 = localURLDrawable2;
          localURLDrawable2.restartDownload();
          localObject1 = localURLDrawable2;
        }
      }
      else
      {
        localURLDrawable1 = localURLDrawable2;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localURLDrawable1 = localURLDrawable2;
          QLog.w("NearbyActivityDialog", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      localObject1 = localURLDrawable1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadImage exp: url=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.w("NearbyActivityDialog", 2, ((StringBuilder)localObject1).toString(), localException);
        localObject1 = localURLDrawable1;
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = this.i;
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  public boolean a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateContent=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("NearbyActivityDialog", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.optJSONObject("pic").optString("pic_url");
      a(this.f, (String)localObject);
      paramString = paramString.optJSONObject("jump_button");
      localObject = paramString.optString("text");
      int n = paramString.optInt("text_color");
      int i1 = paramString.optInt("bg_color");
      this.a = paramString.optString("jump_url");
      this.e.setText((CharSequence)localObject);
      this.e.setTextColor(n);
      this.e.setBackgroundColor(i1);
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyActivityDialog", 2, "updateContent exception:", paramString);
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.l.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    int n = paramView.getId();
    if (n == 2131435536)
    {
      dismiss();
      ReportController.b(null, "dc00899", "grp_lbs", "", "home", "pop_clk_close", 0, 0, (String)localObject, "", "", "");
      return;
    }
    if (n == 2131429786)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onClick, mJumpUrl=");
        paramView.append(this.a);
        QLog.d("NearbyActivityDialog", 2, paramView.toString());
      }
      if (!TextUtils.isEmpty(this.a)) {
        if (this.a.startsWith("http"))
        {
          paramView = new Intent(this.b, QQBrowserActivity.class);
          paramView.putExtra("url", this.a);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramView, this.a);
          this.b.startActivity(paramView);
        }
        else if (this.a.startsWith("mqqapi"))
        {
          paramView = this.b;
          paramView.startActivity(new Intent(paramView, JumpActivity.class).setData(Uri.parse(this.a)));
        }
      }
      dismiss();
      ReportController.b(null, "dc00899", "grp_lbs", "", "home", "pop_clk_btn", 0, 0, (String)localObject, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyActivityDialog
 * JD-Core Version:    0.7.0.1
 */