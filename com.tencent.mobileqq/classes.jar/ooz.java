import android.animation.ValueAnimator;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory.SimpleAnimatorListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class ooz
  extends AnimatorFactory.SimpleAnimatorListener
{
  public ooz(ElasticImageView paramElasticImageView) {}
  
  public void a(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ElasticImageView.a(this.a, this.a.d);
    SLog.b("ElasticImageView", "updateAnimator:" + this.a.d);
    ElasticImageView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ooz
 * JD-Core Version:    0.7.0.1
 */