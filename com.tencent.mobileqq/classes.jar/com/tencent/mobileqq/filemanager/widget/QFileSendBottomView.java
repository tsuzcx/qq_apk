package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.widget.ListView;

public class QFileSendBottomView
  extends RelativeLayout
{
  private QQBlurView a;
  private ListView b;
  private RelativeLayout c;
  
  public QFileSendBottomView(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627057, this);
    b();
  }
  
  public QFileSendBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627057, this, true);
    b();
  }
  
  private void b()
  {
    this.c = ((RelativeLayout)findViewById(2131445569));
  }
  
  public View a(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  protected void a()
  {
    QQBlurView localQQBlurView = this.a;
    if (localQQBlurView != null)
    {
      localQQBlurView.c();
      this.a = null;
    }
    if (!ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.c.setBackgroundResource(2130845625);
      return;
    }
    this.a = ((QQBlurView)findViewById(2131449300));
    this.a.setVisibility(0);
    this.a.a(this.b);
    localQQBlurView = this.a;
    localQQBlurView.b(localQQBlurView);
    this.a.c(-1);
    this.a.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.a.b(0);
    this.a.a(8.0F);
    this.a.a(8);
    this.a.d();
    this.a.a();
  }
  
  public void a(ListView paramListView)
  {
    this.b = paramListView;
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.addView(new View(getContext()), new RelativeLayout.LayoutParams(-1, AIOUtils.b(50.0F, getResources())));
    paramListView.addFooterView(localRelativeLayout);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QFileSendBottomView
 * JD-Core Version:    0.7.0.1
 */