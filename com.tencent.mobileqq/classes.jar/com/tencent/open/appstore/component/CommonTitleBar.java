package com.tencent.open.appstore.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CommonTitleBar
  extends RelativeLayout
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private ProgressBar e;
  private CommonTitleBar.IClick f;
  
  public CommonTitleBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommonTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommonTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131625682, this);
    this.a = ((ImageView)findViewById(2131435347));
    this.a.setOnClickListener(new CommonTitleBar.1(this));
    this.b = ((TextView)findViewById(2131448975));
    this.b.setOnClickListener(new CommonTitleBar.2(this));
    this.c = ((TextView)findViewById(2131449008));
    this.d = ((ImageView)findViewById(2131435348));
    this.d.setOnClickListener(new CommonTitleBar.3(this));
    this.e = ((ProgressBar)findViewById(2131440737));
  }
  
  public void a()
  {
    this.e.setVisibility(0);
  }
  
  public void b()
  {
    this.e.setVisibility(8);
  }
  
  public void c()
  {
    this.d.setVisibility(8);
  }
  
  public void setBackText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.b.setText(paramString);
    }
  }
  
  public void setIClickListener(CommonTitleBar.IClick paramIClick)
  {
    this.f = paramIClick;
  }
  
  public void setTitleText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.c.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.component.CommonTitleBar
 * JD-Core Version:    0.7.0.1
 */