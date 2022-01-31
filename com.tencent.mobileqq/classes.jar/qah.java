import android.text.TextPaint;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;

public abstract class qah
  extends qaf
{
  private qaq a;
  
  public qah(pzs parampzs, qaq paramqaq)
  {
    super(parampzs, paramqaq);
    this.a = paramqaq;
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130842446;
    }
    return 2130842365;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.a.w.setVisibility(0);
    if (((this.a.jdField_c_of_type_Int == 0) && (this.a.b == 0) && ((pzs.a(this.c) instanceof VideoFeedsPlayActivity)) && (paramBoolean)) || (paramVideoInfo.jdField_c_of_type_Boolean))
    {
      this.a.w.setText("");
      this.a.v.setText("");
    }
    for (;;)
    {
      this.a.w.getPaint().setFakeBoldText(true);
      this.a.v.getPaint().setFakeBoldText(true);
      pzs.a(this.c, this.a, paramVideoInfo);
      a(true);
      if (this.a.r != null) {
        this.a.r.setVisibility(8);
      }
      return;
      this.a.w.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      this.a.v.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
    }
  }
  
  protected void a(qaq paramqaq, VideoInfo paramVideoInfo)
  {
    paramqaq.z.setOnClickListener(this.c);
    paramqaq.z.setTag(paramqaq);
    paramqaq.p.setTag(paramqaq);
    paramqaq.p.setOnClickListener(this.c);
    paramqaq.p.setVisibility(0);
    paramqaq.h.setTag(paramqaq);
    paramqaq.h.setOnClickListener(this.c);
    paramqaq.h.setOnLongClickListener(this.c);
    if (paramqaq.jdField_c_of_type_AndroidWidgetLinearLayout != null)
    {
      paramqaq.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.c);
      paramqaq.jdField_c_of_type_AndroidWidgetLinearLayout.setOnLongClickListener(this.c);
      paramqaq.jdField_c_of_type_AndroidWidgetLinearLayout.setTag(paramqaq);
    }
    if (paramqaq.j != null)
    {
      paramqaq.j.setOnClickListener(this.c);
      paramqaq.j.setTag(paramqaq);
    }
    if (!paramVideoInfo.jdField_c_of_type_Boolean) {
      paramqaq.h.setVisibility(0);
    }
    for (;;)
    {
      paramqaq.i.setTag(paramqaq);
      paramqaq.i.setOnClickListener(this.c);
      if (!qzk.a().b()) {
        paramqaq.i.setVisibility(0);
      }
      b(paramVideoInfo);
      return;
      paramqaq.h.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.q != null)
    {
      if ((pzs.c(this.c) == 10) && (this.a.b == 0))
      {
        this.a.q.setVisibility(8);
        this.a.w.setVisibility(0);
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      this.a.q.setVisibility(0);
      this.a.w.setVisibility(0);
      return;
    }
    this.a.q.setVisibility(8);
    this.a.w.setVisibility(8);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    FusionBiuInfo localFusionBiuInfo;
    if (paramVideoInfo.e > 0)
    {
      this.a.y.setVisibility(0);
      qcn.b(this.a.y, paramVideoInfo.e, "0");
      this.a.k.setImageResource(2130842444);
      VideoFeedsAccessibilityHelper.a(this.a.y, paramVideoInfo.e);
      this.a.i.setImageDrawable(pzs.a(this.c, a(paramVideoInfo.l)));
      localFusionBiuInfo = null;
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        localFusionBiuInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
      }
      if ((qzk.a().b()) && (localFusionBiuInfo != null))
      {
        paramVideoInfo = this.a.h;
        if (!localFusionBiuInfo.b) {
          break label181;
        }
      }
    }
    label181:
    for (int i = 2130841140;; i = 2130842442)
    {
      paramVideoInfo.setImageResource(i);
      if ((this.a instanceof qap)) {
        localFusionBiuInfo.jdField_c_of_type_Boolean = true;
      }
      return;
      this.a.y.setVisibility(8);
      this.a.k.setImageResource(2130842445);
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.m != null)
    {
      if ((this.a.a.a.jdField_a_of_type_Int == 0) || ((pzs.c(this.c) == 10) && (this.a.b == 0))) {
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
  
  public void d()
  {
    if (pzs.a(this.c) == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      pzs.a(this.c, localScaleAnimation);
    }
    pzs.a(this.c).setAnimationListener(new qai(this));
    this.a.i.startAnimation(pzs.a(this.c));
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (paramBoolean)
    {
      this.a.w.setVisibility(8);
      a(false);
      b(false);
      j(false);
      return;
    }
    this.a.w.setVisibility(0);
    a(true);
    b(true);
    j(true);
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.a.o != null)
    {
      if (!this.a.a.a.a()) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qah
 * JD-Core Version:    0.7.0.1
 */