package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;

public class NavBarQQGamePub
  extends NavBarCommon
{
  private static final String a;
  private TextView b;
  private ImageView c;
  private RelativeLayout d;
  private LinearLayout e;
  private TextView f;
  private TextView g;
  private String h;
  private String i;
  private int j = 0;
  private String k = "";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGamePub_");
    localStringBuilder.append(NavBarQQGamePub.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public NavBarQQGamePub(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public NavBarQQGamePub(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public NavBarQQGamePub(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.e = new LinearLayout(getContext());
    Object localObject = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    this.e.setOrientation(0);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = UIUtils.a(40.0F, getResources());
    addView(this.e, (ViewGroup.LayoutParams)localObject);
    this.d = new RelativeLayout(getContext());
    localObject = new LinearLayout.LayoutParams(UIUtils.a(30.0F, getResources()), UIUtils.a(64.0F, getResources()));
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    this.e.addView(this.d, (ViewGroup.LayoutParams)localObject);
    this.c = new ImageView(getContext());
    this.c.setImageResource(2130845836);
    localObject = new RelativeLayout.LayoutParams(UIUtils.a(24.0F, getResources()), UIUtils.a(24.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    this.d.addView(this.c, (ViewGroup.LayoutParams)localObject);
    this.b = new TextView(getContext());
    this.b.setText("");
    this.b.setTextColor(-1);
    this.b.setTextSize(10.0F);
    this.b.setGravity(17);
    this.b.setBackgroundResource(2130848420);
    int m = UIUtils.a(1.0F, getResources());
    this.b.setPadding(m, m, m, m);
    localObject = new RelativeLayout.LayoutParams(UIUtils.a(6.0F, getResources()), UIUtils.a(6.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).topMargin = UIUtils.a(16.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).rightMargin = UIUtils.a(6.0F, getResources());
    this.d.addView(this.b, (ViewGroup.LayoutParams)localObject);
    this.b.setVisibility(4);
    this.g = new TextView(getContext());
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.g.setSingleLine();
    this.g.setTextColor(-1);
    this.g.setTextSize(10.0F);
    this.g.setGravity(17);
    this.e.addView(this.g, (ViewGroup.LayoutParams)localObject);
    this.e.setOnClickListener(new NavBarQQGamePub.1(this));
    this.e.setVisibility(8);
  }
  
  private void b(String paramString)
  {
    if (paramString.startsWith("mqqapi://miniapp/"))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getContext(), paramString, 2016, null);
      return;
    }
    Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    getContext().startActivity(localIntent);
  }
  
  public void a()
  {
    ImageView localImageView = this.c;
    if (localImageView != null)
    {
      localImageView.setVisibility(0);
      this.c.setImageResource(2130845836);
      this.g.setText("");
      setmBubbleid("");
      setCurType(1);
    }
  }
  
  public void a(String paramString)
  {
    ImageView localImageView = this.c;
    if (localImageView != null)
    {
      localImageView.setVisibility(0);
      this.c.setImageResource(2130845836);
      this.g.setText("");
      this.h = paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.c != null)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130845539);
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130845539);
      paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      this.c.setImageDrawable(paramString1);
      this.c.setVisibility(0);
      this.h = paramString3;
      setCurType(2);
    }
    if (this.g != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 5)
      {
        paramString1 = paramString2.substring(0, 5);
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("...");
        paramString1 = paramString2.toString();
      }
      this.g.setText(paramString1);
      this.g.setVisibility(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 4;
      }
      this.b.setVisibility(m);
    }
  }
  
  public View getRightImg()
  {
    return this.c;
  }
  
  public TextView getTitleTextView()
  {
    if (this.f == null) {
      this.f = ((TextView)findViewById(2131436227));
    }
    if (this.f == null)
    {
      this.f = new TextView(getContext());
      QLog.e(a, 2, "[getTitleTextView] titleTv is null");
    }
    return this.f;
  }
  
  public void setCurType(int paramInt)
  {
    this.j = paramInt;
    if (this.j == 0)
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
  }
  
  public void setGamePubType(String paramString)
  {
    this.k = paramString;
  }
  
  public void setRightImage2(Drawable paramDrawable) {}
  
  public void setTitle(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131447463);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setmBubbleid(String paramString)
  {
    this.i = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub
 * JD-Core Version:    0.7.0.1
 */