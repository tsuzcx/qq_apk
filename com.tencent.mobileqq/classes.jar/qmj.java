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

public abstract class qmj
  extends qmh
{
  private qms a;
  
  public qmj(qls paramqls, qms paramqms)
  {
    super(paramqls, paramqms);
    this.a = paramqms;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130842520;
    }
    return 2130842440;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.a.B.setVisibility(0);
    if (((this.a.c == 0) && (this.a.b == 0) && ((qls.a(this.c) instanceof VideoFeedsPlayActivity)) && (paramBoolean)) || (paramVideoInfo.jdField_c_of_type_Boolean))
    {
      this.a.B.setText("");
      this.a.A.setText("");
    }
    for (;;)
    {
      this.a.B.getPaint().setFakeBoldText(true);
      this.a.A.getPaint().setFakeBoldText(true);
      qls.a(this.c, this.a, paramVideoInfo);
      a(true);
      if (this.a.p != null) {
        this.a.p.setVisibility(8);
      }
      return;
      this.a.B.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      this.a.A.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
    }
  }
  
  protected void a(qms paramqms, VideoInfo paramVideoInfo)
  {
    if (paramqms.C != null)
    {
      paramqms.C.setOnClickListener(this.c);
      paramqms.C.setTag(paramqms);
    }
    paramqms.jdField_m_of_type_AndroidViewViewGroup.setTag(paramqms);
    paramqms.jdField_m_of_type_AndroidViewViewGroup.setOnClickListener(this.c);
    paramqms.jdField_m_of_type_AndroidViewViewGroup.setVisibility(0);
    paramqms.jdField_k_of_type_AndroidWidgetImageView.setTag(paramqms);
    paramqms.jdField_k_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
    paramqms.jdField_k_of_type_AndroidWidgetImageView.setOnLongClickListener(this.c);
    if (paramqms.n != null)
    {
      paramqms.n.setOnClickListener(this.c);
      paramqms.n.setOnLongClickListener(this.c);
      paramqms.n.setTag(paramqms);
    }
    if (paramqms.jdField_m_of_type_AndroidWidgetImageView != null)
    {
      paramqms.jdField_m_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
      paramqms.jdField_m_of_type_AndroidWidgetImageView.setTag(paramqms);
    }
    if (!paramVideoInfo.jdField_c_of_type_Boolean) {
      paramqms.jdField_k_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramqms.jdField_l_of_type_AndroidWidgetImageView.setTag(paramqms);
      paramqms.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
      if (!rmc.a().b()) {
        paramqms.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      b(paramVideoInfo);
      return;
      paramqms.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.o != null)
    {
      if ((qls.c(this.c) == 10) && (this.a.b == 0)) {
        this.a.o.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.a.o.setVisibility(0);
      return;
    }
    this.a.o.setVisibility(8);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    c(paramVideoInfo);
    VideoFeedsAccessibilityHelper.a(this.a.D, paramVideoInfo.e);
    this.a.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable(qls.a(this.c, a(paramVideoInfo.l)));
    qol.b(this.a.E, paramVideoInfo.u, "赞");
    qol.b(this.a.F, paramVideoInfo.f, "Biu");
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_k_of_type_AndroidViewViewGroup != null)
    {
      if ((this.a.a.a.a == 0) || ((qls.c(this.c) == 10) && (this.a.b == 0))) {
        this.a.jdField_k_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_k_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.a.jdField_k_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e > 0)
    {
      this.a.D.setVisibility(0);
      qol.b(this.a.D, paramVideoInfo.e, "0");
      this.a.j.setImageResource(2130842518);
      return;
    }
    this.a.D.setVisibility(8);
    this.a.j.setImageResource(2130842519);
  }
  
  public void d()
  {
    if (qls.a(this.c) == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      qls.a(this.c, localScaleAnimation);
    }
    qls.a(this.c).setAnimationListener(new qmk(this));
    this.a.jdField_l_of_type_AndroidWidgetImageView.startAnimation(qls.a(this.c));
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
    if (this.a.jdField_l_of_type_AndroidViewViewGroup != null)
    {
      if (!this.a.a.a.a()) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmj
 * JD-Core Version:    0.7.0.1
 */