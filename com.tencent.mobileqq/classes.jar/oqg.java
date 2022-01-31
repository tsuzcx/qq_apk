import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;

public class oqg
  extends ValueAnimator
{
  private ValueAnimator.AnimatorUpdateListener a;
  
  private oqg(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    setObjectValues(new Object[] { new oqj(paramFloat1, paramFloat2, paramFloat3), new oqj(paramFloat4, paramFloat5, paramFloat6) });
    setEvaluator(new oqk(null));
    this.a = new oqh(this, a(paramView));
    addUpdateListener(this.a);
  }
  
  private CircularRevealCompatLayout a(View paramView)
  {
    if ((paramView instanceof CircularRevealCompatLayout)) {
      return (CircularRevealCompatLayout)paramView;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if ((localViewGroup instanceof CircularRevealCompatLayout)) {
      return (CircularRevealCompatLayout)localViewGroup;
    }
    CircularRevealCompatLayout localCircularRevealCompatLayout = new CircularRevealCompatLayout(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    localCircularRevealCompatLayout.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
    localViewGroup.addView(localCircularRevealCompatLayout, i, localLayoutParams);
    return localCircularRevealCompatLayout;
  }
  
  public static oqg a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return new oqg(paramView, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public static oqg a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return new oqg(paramView, paramInt1, paramInt2, paramFloat1, paramInt1, paramInt2, paramFloat2);
  }
  
  public void removeAllUpdateListeners()
  {
    super.removeAllUpdateListeners();
    addUpdateListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqg
 * JD-Core Version:    0.7.0.1
 */