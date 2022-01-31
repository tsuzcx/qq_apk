import android.text.TextPaint;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;

public abstract class rbo
  extends rbm
{
  private rbt a;
  
  public rbo(raw paramraw, rbt paramrbt)
  {
    super(paramraw, paramrbt);
    this.a = paramrbt;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130842713;
    }
    return 2130842625;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.a.B.setVisibility(0);
    if (((this.a.c == 0) && (this.a.b == 0) && ((raw.a(this.c) instanceof VideoFeedsPlayActivity)) && (paramBoolean)) || (paramVideoInfo.jdField_c_of_type_Boolean))
    {
      this.a.B.setText("");
      this.a.A.setText("");
    }
    for (;;)
    {
      this.a.B.getPaint().setFakeBoldText(true);
      this.a.A.getPaint().setFakeBoldText(true);
      raw.a(this.c, this.a, paramVideoInfo);
      a(true);
      if (this.a.q != null) {
        this.a.q.setVisibility(8);
      }
      return;
      this.a.B.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      this.a.A.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
    }
  }
  
  protected void a(rbt paramrbt, VideoInfo paramVideoInfo)
  {
    if (paramrbt.C != null)
    {
      paramrbt.C.setOnClickListener(this.c);
      paramrbt.C.setTag(paramrbt);
    }
    paramrbt.n.setTag(paramrbt);
    paramrbt.n.setOnClickListener(this.c);
    paramrbt.n.setVisibility(0);
    paramrbt.k.setTag(paramrbt);
    paramrbt.k.setOnClickListener(this.c);
    paramrbt.k.setOnLongClickListener(this.c);
    if (paramrbt.o != null)
    {
      paramrbt.o.setOnClickListener(this.c);
      paramrbt.o.setOnLongClickListener(this.c);
      paramrbt.o.setTag(paramrbt);
    }
    if (!paramVideoInfo.jdField_c_of_type_Boolean) {
      paramrbt.k.setVisibility(0);
    }
    for (;;)
    {
      paramrbt.jdField_l_of_type_AndroidWidgetImageView.setTag(paramrbt);
      paramrbt.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
      paramrbt.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      b(paramVideoInfo);
      return;
      paramrbt.k.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.p != null)
    {
      if (paramBoolean) {
        this.a.p.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.a.p.setVisibility(8);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    c(paramVideoInfo);
    VideoFeedsAccessibilityHelper.a(this.a.D, paramVideoInfo.e);
    this.a.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable(raw.a(this.c, a(paramVideoInfo.p)));
    rdm.b(this.a.E, paramVideoInfo.r, "赞");
    rdm.b(this.a.F, paramVideoInfo.f, "Biu");
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_l_of_type_AndroidViewViewGroup != null)
    {
      if ((this.a.a.a.a == 0) || (!this.a.a.a.a())) {
        this.a.jdField_l_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_l_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.a.jdField_l_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e > 0)
    {
      this.a.D.setVisibility(0);
      rdm.b(this.a.D, paramVideoInfo.e, "0");
      this.a.j.setImageResource(2130842711);
      return;
    }
    this.a.D.setVisibility(8);
    this.a.j.setImageResource(2130842712);
  }
  
  public void d()
  {
    if (raw.a(this.c) == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      raw.a(this.c, localScaleAnimation);
    }
    raw.a(this.c).setAnimationListener(new rbp(this));
    this.a.jdField_l_of_type_AndroidWidgetImageView.startAnimation(raw.a(this.c));
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (paramBoolean)
    {
      this.a.B.setVisibility(8);
      a(false);
      b(false);
      j(false);
      return;
    }
    this.a.B.setVisibility(0);
    a(true);
    b(true);
    j(true);
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.a.m != null)
    {
      if (!this.a.a.a.a()) {
        this.a.m.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.a.m.setVisibility(0);
      return;
    }
    this.a.m.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbo
 * JD-Core Version:    0.7.0.1
 */