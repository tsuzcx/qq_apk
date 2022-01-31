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

public abstract class qmg
  extends qme
{
  private qmp a;
  
  public qmg(qlp paramqlp, qmp paramqmp)
  {
    super(paramqlp, paramqmp);
    this.a = paramqmp;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130842521;
    }
    return 2130842441;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.a.B.setVisibility(0);
    if (((this.a.c == 0) && (this.a.b == 0) && ((qlp.a(this.c) instanceof VideoFeedsPlayActivity)) && (paramBoolean)) || (paramVideoInfo.jdField_c_of_type_Boolean))
    {
      this.a.B.setText("");
      this.a.A.setText("");
    }
    for (;;)
    {
      this.a.B.getPaint().setFakeBoldText(true);
      this.a.A.getPaint().setFakeBoldText(true);
      qlp.a(this.c, this.a, paramVideoInfo);
      a(true);
      if (this.a.p != null) {
        this.a.p.setVisibility(8);
      }
      return;
      this.a.B.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      this.a.A.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
    }
  }
  
  protected void a(qmp paramqmp, VideoInfo paramVideoInfo)
  {
    if (paramqmp.C != null)
    {
      paramqmp.C.setOnClickListener(this.c);
      paramqmp.C.setTag(paramqmp);
    }
    paramqmp.jdField_m_of_type_AndroidViewViewGroup.setTag(paramqmp);
    paramqmp.jdField_m_of_type_AndroidViewViewGroup.setOnClickListener(this.c);
    paramqmp.jdField_m_of_type_AndroidViewViewGroup.setVisibility(0);
    paramqmp.jdField_k_of_type_AndroidWidgetImageView.setTag(paramqmp);
    paramqmp.jdField_k_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
    paramqmp.jdField_k_of_type_AndroidWidgetImageView.setOnLongClickListener(this.c);
    if (paramqmp.n != null)
    {
      paramqmp.n.setOnClickListener(this.c);
      paramqmp.n.setOnLongClickListener(this.c);
      paramqmp.n.setTag(paramqmp);
    }
    if (paramqmp.jdField_m_of_type_AndroidWidgetImageView != null)
    {
      paramqmp.jdField_m_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
      paramqmp.jdField_m_of_type_AndroidWidgetImageView.setTag(paramqmp);
    }
    if (!paramVideoInfo.jdField_c_of_type_Boolean) {
      paramqmp.jdField_k_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramqmp.jdField_l_of_type_AndroidWidgetImageView.setTag(paramqmp);
      paramqmp.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this.c);
      if (!rlz.a().b()) {
        paramqmp.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      b(paramVideoInfo);
      return;
      paramqmp.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.o != null)
    {
      if ((qlp.c(this.c) == 10) && (this.a.b == 0)) {
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
    this.a.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable(qlp.a(this.c, a(paramVideoInfo.l)));
    qoi.b(this.a.E, paramVideoInfo.u, "赞");
    qoi.b(this.a.F, paramVideoInfo.f, "Biu");
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_k_of_type_AndroidViewViewGroup != null)
    {
      if ((this.a.a.a.a == 0) || ((qlp.c(this.c) == 10) && (this.a.b == 0))) {
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
      qoi.b(this.a.D, paramVideoInfo.e, "0");
      this.a.j.setImageResource(2130842519);
      return;
    }
    this.a.D.setVisibility(8);
    this.a.j.setImageResource(2130842520);
  }
  
  public void d()
  {
    if (qlp.a(this.c) == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      qlp.a(this.c, localScaleAnimation);
    }
    qlp.a(this.c).setAnimationListener(new qmh(this));
    this.a.jdField_l_of_type_AndroidWidgetImageView.startAnimation(qlp.a(this.c));
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
 * Qualified Name:     qmg
 * JD-Core Version:    0.7.0.1
 */