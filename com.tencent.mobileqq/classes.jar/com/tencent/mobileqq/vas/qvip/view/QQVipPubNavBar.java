package com.tencent.mobileqq.vas.qvip.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;

public class QQVipPubNavBar
  extends NavBarCommon
{
  private static final String b = "QQVipPubNavBar";
  protected ImageView a;
  private RelativeLayout c;
  private LinearLayout d;
  private TextView e;
  private TextView f;
  private String g;
  private int h = 0;
  
  public QQVipPubNavBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QQVipPubNavBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QQVipPubNavBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.d = new LinearLayout(getContext());
    Object localObject = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    this.d.setOrientation(0);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(40.0F, getResources());
    addView(this.d, (ViewGroup.LayoutParams)localObject);
    this.c = new RelativeLayout(getContext());
    localObject = new LinearLayout.LayoutParams(AIOUtils.b(30.0F, getResources()), AIOUtils.b(64.0F, getResources()));
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    this.d.addView(this.c, (ViewGroup.LayoutParams)localObject);
    this.a = new ImageView(getContext());
    this.a.setId(2131436194);
    localObject = new RelativeLayout.LayoutParams(AIOUtils.b(24.0F, getResources()), AIOUtils.b(24.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    this.c.addView(this.a, (ViewGroup.LayoutParams)localObject);
    this.f = new TextView(getContext());
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.f.setSingleLine();
    this.f.setTextColor(-1);
    this.f.setTextSize(10.0F);
    this.f.setGravity(17);
    this.d.addView(this.f, (ViewGroup.LayoutParams)localObject);
    this.d.setOnClickListener(new QQVipPubNavBar.1(this));
    this.d.setVisibility(8);
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
  
  public void a(String paramString)
  {
    ImageView localImageView = this.a;
    if (localImageView != null)
    {
      localImageView.setVisibility(0);
      this.a.setImageResource(2130848711);
      this.f.setText("");
      this.g = paramString;
      setCurType(4);
    }
  }
  
  public TextView getTitleTextView()
  {
    if (this.e == null) {
      this.e = ((TextView)findViewById(2131436227));
    }
    if (this.e == null)
    {
      this.e = new TextView(getContext());
      QLog.e(b, 2, "[getTitleTextView] titleTv is null");
    }
    return this.e;
  }
  
  public void setCurType(int paramInt)
  {
    this.h = paramInt;
    if (this.h == 0)
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public void setTitle(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131447463);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QQVipPubNavBar
 * JD-Core Version:    0.7.0.1
 */