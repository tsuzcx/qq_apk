import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;

public abstract class rvo
  extends rvm
{
  private rvv a;
  
  public rvo(ruw paramruw, rvv paramrvv)
  {
    super(paramruw, paramrvv);
    this.a = paramrvv;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843128;
    }
    return 2130843028;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.a.z.setVisibility(0);
    if (((this.a.c == 0) && (this.a.b == 0) && ((ruw.a(this.c) instanceof VideoFeedsPlayActivity)) && (paramBoolean)) || (paramVideoInfo.c))
    {
      this.a.z.setText("");
      this.a.y.setText("");
    }
    for (;;)
    {
      this.a.z.getPaint().setFakeBoldText(true);
      this.a.y.getPaint().setFakeBoldText(true);
      ruw.a(this.c, this.a, paramVideoInfo);
      k(true);
      if (this.a.jdField_s_of_type_AndroidViewViewGroup != null) {
        this.a.jdField_s_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      return;
      rwv.a(paramVideoInfo, this.a.z);
      rwv.a(paramVideoInfo, this.a.y);
    }
  }
  
  protected void a(rvv paramrvv, VideoInfo paramVideoInfo)
  {
    if (paramrvv.jdField_s_of_type_AndroidViewView != null)
    {
      paramrvv.jdField_s_of_type_AndroidViewView.setOnClickListener(this.c);
      paramrvv.jdField_s_of_type_AndroidViewView.setTag(paramrvv);
    }
    paramrvv.p.setTag(paramrvv);
    paramrvv.p.setOnClickListener(this.c);
    paramrvv.p.setVisibility(0);
    paramrvv.n.setTag(paramrvv);
    paramrvv.n.setOnClickListener(this.c);
    paramrvv.n.setOnLongClickListener(this.c);
    if (paramrvv.q != null)
    {
      paramrvv.q.setOnClickListener(this.c);
      paramrvv.q.setOnLongClickListener(this.c);
      paramrvv.q.setTag(paramrvv);
    }
    paramrvv.n.setVisibility(0);
    paramrvv.jdField_o_of_type_AndroidWidgetImageView.setTag(paramrvv);
    paramrvv.jdField_o_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
    paramrvv.jdField_o_of_type_AndroidWidgetImageView.setVisibility(0);
    b(paramVideoInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.jdField_m_of_type_AndroidViewViewGroup != null)
    {
      if ((this.a.a.a.a == 0) || (!this.a.a.a.a())) {
        this.a.jdField_m_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_m_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.a.jdField_m_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    c(paramVideoInfo);
    VideoFeedsAccessibilityHelper.a(this.a.A, paramVideoInfo.e);
    this.a.jdField_o_of_type_AndroidWidgetImageView.setImageDrawable(ruw.a(this.c, a(paramVideoInfo.r)));
    rwv.b(this.a.B, paramVideoInfo.t, "赞");
    rwv.b(this.a.C, paramVideoInfo.f, "Biu");
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.a.t != null)
    {
      localViewGroup = this.a.t;
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e > 0)
    {
      this.a.A.setVisibility(0);
      rwv.b(this.a.A, paramVideoInfo.e, "评论");
      this.a.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130843126);
      return;
    }
    this.a.A.setVisibility(8);
    this.a.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130843127);
  }
  
  public void c(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.a.u != null)
    {
      localViewGroup = this.a.u;
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void d()
  {
    rwv.b(this.a.B, this.a.a.a.t, "赞");
    if (ruw.a(this.c) == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      ruw.a(this.c, localScaleAnimation);
    }
    ruw.a(this.c).setAnimationListener(new rvp(this));
    this.a.jdField_o_of_type_AndroidWidgetImageView.startAnimation(ruw.a(this.c));
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    if (paramBoolean)
    {
      this.a.z.setVisibility(8);
      k(false);
      a(false);
      l(false);
      return;
    }
    this.a.z.setVisibility(0);
    k(true);
    a(true);
    l(true);
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.a.r != null)
    {
      if (paramBoolean) {
        this.a.r.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.a.r.setVisibility(8);
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.a.jdField_o_of_type_AndroidViewViewGroup != null)
    {
      if (!this.a.a.a.a()) {
        this.a.jdField_o_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_o_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.a.jdField_o_of_type_AndroidViewViewGroup.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvo
 * JD-Core Version:    0.7.0.1
 */