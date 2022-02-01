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

public abstract class rom
  extends rok
{
  private rot a;
  
  public rom(rnu paramrnu, rot paramrot)
  {
    super(paramrnu, paramrot);
    this.a = paramrot;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843074;
    }
    return 2130842974;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.a.z.setVisibility(0);
    if (((this.a.c == 0) && (this.a.b == 0) && ((rnu.a(this.c) instanceof VideoFeedsPlayActivity)) && (paramBoolean)) || (paramVideoInfo.c))
    {
      this.a.z.setText("");
      this.a.y.setText("");
    }
    for (;;)
    {
      this.a.z.getPaint().setFakeBoldText(true);
      this.a.y.getPaint().setFakeBoldText(true);
      rnu.a(this.c, this.a, paramVideoInfo);
      k(true);
      if (this.a.r != null) {
        this.a.r.setVisibility(8);
      }
      return;
      rpt.a(paramVideoInfo, this.a.z);
      rpt.a(paramVideoInfo, this.a.y);
    }
  }
  
  protected void a(rot paramrot, VideoInfo paramVideoInfo)
  {
    if (paramrot.jdField_s_of_type_AndroidViewView != null)
    {
      paramrot.jdField_s_of_type_AndroidViewView.setOnClickListener(this.c);
      paramrot.jdField_s_of_type_AndroidViewView.setTag(paramrot);
    }
    paramrot.jdField_o_of_type_AndroidViewViewGroup.setTag(paramrot);
    paramrot.jdField_o_of_type_AndroidViewViewGroup.setOnClickListener(this.c);
    paramrot.jdField_o_of_type_AndroidViewViewGroup.setVisibility(0);
    paramrot.jdField_n_of_type_AndroidWidgetImageView.setTag(paramrot);
    paramrot.jdField_n_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
    paramrot.jdField_n_of_type_AndroidWidgetImageView.setOnLongClickListener(this.c);
    if (paramrot.p != null)
    {
      paramrot.p.setOnClickListener(this.c);
      paramrot.p.setOnLongClickListener(this.c);
      paramrot.p.setTag(paramrot);
    }
    paramrot.jdField_n_of_type_AndroidWidgetImageView.setVisibility(0);
    paramrot.jdField_o_of_type_AndroidWidgetImageView.setTag(paramrot);
    paramrot.jdField_o_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
    paramrot.jdField_o_of_type_AndroidWidgetImageView.setVisibility(0);
    b(paramVideoInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.l != null)
    {
      if ((this.a.a.a.a == 0) || (!this.a.a.a.a())) {
        this.a.l.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.a.l.setVisibility(0);
      return;
    }
    this.a.l.setVisibility(8);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    c(paramVideoInfo);
    VideoFeedsAccessibilityHelper.a(this.a.A, paramVideoInfo.e);
    this.a.jdField_o_of_type_AndroidWidgetImageView.setImageDrawable(rnu.a(this.c, a(paramVideoInfo.o)));
    rpt.b(this.a.B, paramVideoInfo.s, "赞");
    rpt.b(this.a.C, paramVideoInfo.f, "Biu");
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.a.jdField_s_of_type_AndroidViewViewGroup != null)
    {
      localViewGroup = this.a.jdField_s_of_type_AndroidViewViewGroup;
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
      rpt.b(this.a.A, paramVideoInfo.e, "评论");
      this.a.m.setImageResource(2130843072);
      return;
    }
    this.a.A.setVisibility(8);
    this.a.m.setImageResource(2130843073);
  }
  
  public void c(boolean paramBoolean)
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
  
  public void d()
  {
    rpt.b(this.a.B, this.a.a.a.s, "赞");
    if (rnu.a(this.c) == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      rnu.a(this.c, localScaleAnimation);
    }
    rnu.a(this.c).setAnimationListener(new ron(this));
    this.a.jdField_o_of_type_AndroidWidgetImageView.startAnimation(rnu.a(this.c));
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
    if (this.a.q != null)
    {
      if (paramBoolean) {
        this.a.q.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.a.q.setVisibility(8);
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.a.jdField_n_of_type_AndroidViewViewGroup != null)
    {
      if (!this.a.a.a.a()) {
        this.a.jdField_n_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_n_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.a.jdField_n_of_type_AndroidViewViewGroup.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rom
 * JD-Core Version:    0.7.0.1
 */