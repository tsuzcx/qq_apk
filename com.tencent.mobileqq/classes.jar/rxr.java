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

public abstract class rxr
  extends rxp
{
  private rxy a;
  
  public rxr(rwy paramrwy, rxy paramrxy)
  {
    super(paramrwy, paramrxy);
    this.a = paramrxy;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843054;
    }
    return 2130842954;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.a.z.setVisibility(0);
    if (((this.a.c == 0) && (this.a.b == 0) && ((rwy.a(this.c) instanceof VideoFeedsPlayActivity)) && (paramBoolean)) || (paramVideoInfo.jdField_c_of_type_Boolean))
    {
      this.a.z.setText("");
      this.a.y.setText("");
    }
    for (;;)
    {
      this.a.z.getPaint().setFakeBoldText(true);
      this.a.y.getPaint().setFakeBoldText(true);
      rwy.a(this.c, this.a, paramVideoInfo);
      k(true);
      if (this.a.jdField_s_of_type_AndroidViewViewGroup != null) {
        this.a.jdField_s_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      return;
      this.a.z.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      this.a.y.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
    }
  }
  
  protected void a(rxy paramrxy, VideoInfo paramVideoInfo)
  {
    if (paramrxy.jdField_s_of_type_AndroidViewView != null)
    {
      paramrxy.jdField_s_of_type_AndroidViewView.setOnClickListener(this.c);
      paramrxy.jdField_s_of_type_AndroidViewView.setTag(paramrxy);
    }
    paramrxy.p.setTag(paramrxy);
    paramrxy.p.setOnClickListener(this.c);
    paramrxy.p.setVisibility(0);
    paramrxy.n.setTag(paramrxy);
    paramrxy.n.setOnClickListener(this.c);
    paramrxy.n.setOnLongClickListener(this.c);
    if (paramrxy.q != null)
    {
      paramrxy.q.setOnClickListener(this.c);
      paramrxy.q.setOnLongClickListener(this.c);
      paramrxy.q.setTag(paramrxy);
    }
    paramrxy.n.setVisibility(0);
    paramrxy.jdField_o_of_type_AndroidWidgetImageView.setTag(paramrxy);
    paramrxy.jdField_o_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
    paramrxy.jdField_o_of_type_AndroidWidgetImageView.setVisibility(0);
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
    this.a.jdField_o_of_type_AndroidWidgetImageView.setImageDrawable(rwy.a(this.c, a(paramVideoInfo.r)));
    ryx.b(this.a.B, paramVideoInfo.s, "赞");
    ryx.b(this.a.C, paramVideoInfo.f, "Biu");
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
      ryx.b(this.a.A, paramVideoInfo.e, "评论");
      this.a.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130843052);
      return;
    }
    this.a.A.setVisibility(8);
    this.a.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130843053);
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
    ryx.b(this.a.B, this.a.a.a.s, "赞");
    if (rwy.a(this.c) == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      rwy.a(this.c, localScaleAnimation);
    }
    rwy.a(this.c).setAnimationListener(new rxs(this));
    this.a.jdField_o_of_type_AndroidWidgetImageView.startAnimation(rwy.a(this.c));
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
 * Qualified Name:     rxr
 * JD-Core Version:    0.7.0.1
 */