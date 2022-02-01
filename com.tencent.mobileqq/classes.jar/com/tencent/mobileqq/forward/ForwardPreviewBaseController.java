package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.MaxHeightRelativelayout;

public abstract class ForwardPreviewBaseController
{
  protected View a;
  protected Context b;
  protected MaxHeightRelativelayout c;
  protected QQCustomDialog d;
  private TextView e;
  private RelativeLayout f;
  private ImageView g;
  
  public ForwardPreviewBaseController(QQCustomDialog paramQQCustomDialog)
  {
    this.d = paramQQCustomDialog;
    this.b = paramQQCustomDialog.getContext();
    a();
    this.c.setMaxHeight(Math.max(paramQQCustomDialog.getRootViewHeight() - this.b.getResources().getDimensionPixelSize(2131297496), AIOUtils.b(d(), this.b.getResources())));
  }
  
  protected void a()
  {
    this.a = LayoutInflater.from(this.b).inflate(2131624592, null);
    this.e = ((TextView)this.a.findViewById(2131449007));
    this.c = ((MaxHeightRelativelayout)this.a.findViewById(2131444933));
    this.g = ((ImageView)this.a.findViewById(2131435632));
    this.f = ((RelativeLayout)this.a.findViewById(2131444979));
    View localView = c();
    if (localView != null) {
      this.c.addView(localView);
    }
    this.g.setOnClickListener(new ForwardPreviewBaseController.1(this));
    int i = ViewUtils.dip2px(15.0F);
    AIOUtils.a(this.g, i, i, i, i);
    this.g.setContentDescription(HardCodeUtil.a(2131901576));
  }
  
  public void a(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void b()
  {
    e();
    this.d.removePreviewView();
  }
  
  protected abstract View c();
  
  protected int d()
  {
    return 380;
  }
  
  protected void e() {}
  
  public View f()
  {
    return this.a;
  }
  
  protected void g()
  {
    this.f.setVisibility(0);
  }
  
  protected void h()
  {
    this.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewBaseController
 * JD-Core Version:    0.7.0.1
 */