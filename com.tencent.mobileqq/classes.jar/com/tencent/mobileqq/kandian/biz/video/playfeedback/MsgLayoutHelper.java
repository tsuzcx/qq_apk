package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class MsgLayoutHelper
  implements IMsgLayoutHelper
{
  private Context a;
  private View b;
  private View.OnClickListener c;
  private Object d;
  private View e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  public MsgLayoutHelper(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.b = paramView;
    this.c = paramOnClickListener;
    this.a = BaseApplication.getContext();
  }
  
  private void d()
  {
    TextView localTextView = this.g;
    if (localTextView != null)
    {
      localTextView.setOnClickListener(this.c);
      this.g.setTag(this.d);
    }
    localTextView = this.h;
    if (localTextView != null)
    {
      localTextView.setOnClickListener(this.c);
      this.h.setTag(this.d);
    }
  }
  
  public void a()
  {
    View localView = this.e;
    if (localView != null)
    {
      localView.clearAnimation();
      this.e.setVisibility(8);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, 2130844248);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (this.e == null)
    {
      this.e = ((ViewStub)this.b.findViewById(2131432595)).inflate();
      this.f = ((TextView)this.e.findViewById(2131432597));
      this.g = ((TextView)this.e.findViewById(2131432590));
      this.h = ((TextView)this.e.findViewById(2131449655));
      this.e.setOnClickListener(null);
    }
    d();
    VideoFeedsHelper.a(this.e);
    this.e.setVisibility(0);
    Drawable localDrawable = this.a.getResources().getDrawable(paramInt2);
    paramInt2 = DisplayUtil.a(this.a, 18.6F);
    localDrawable.setBounds(0, 0, paramInt2, paramInt2);
    this.g.setCompoundDrawables(localDrawable, null, null, null);
    this.g.setCompoundDrawablePadding(AIOUtils.b(6.0F, this.a.getResources()));
    this.f.setText(paramString1);
    this.g.setText(paramString2);
    if (paramInt1 == 1)
    {
      this.h.setVisibility(0);
      paramString1 = this.a.getResources().getDrawable(2130842786);
      paramInt1 = DisplayUtil.a(this.a, 18.6F);
      paramString1.setBounds(0, 0, paramInt1, paramInt1);
      this.h.setCompoundDrawables(paramString1, null, null, null);
      this.h.setCompoundDrawablePadding(AIOUtils.b(6.0F, this.a.getResources()));
      return;
    }
    this.h.setVisibility(8);
    this.e.requestLayout();
  }
  
  public void a(View.OnClickListener paramOnClickListener, Object paramObject)
  {
    this.c = paramOnClickListener;
    this.d = paramObject;
    d();
  }
  
  public void b()
  {
    View localView = this.e;
    if (localView != null) {
      VideoFeedsHelper.a(localView, 8, 300, true);
    }
  }
  
  public boolean c()
  {
    View localView = this.e;
    return (localView != null) && (localView.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.MsgLayoutHelper
 * JD-Core Version:    0.7.0.1
 */