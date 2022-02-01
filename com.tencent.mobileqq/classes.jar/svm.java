import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.3;
import com.tencent.mobileqq.utils.ViewUtils;

public class svm
{
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    TextView localTextView1 = (TextView)paramActivity.findViewById(2131369068);
    TextView localTextView2 = (TextView)paramActivity.findViewById(2131369074);
    ImageView localImageView = (ImageView)paramActivity.findViewById(2131369073);
    new Handler().postDelayed(new FastWebAnimationUtils.1(paramActivity, localTextView1), 500L);
    new Handler().postDelayed(new FastWebAnimationUtils.2(localTextView2, paramActivity), 2500L);
    new Handler().postDelayed(new FastWebAnimationUtils.3(paramActivity, localTextView2, localImageView), 4200L);
  }
  
  private static AnimationSet b(View paramView, Context paramContext)
  {
    paramView = new TranslateAnimation(0.0F, -(paramView.getX() - ViewUtils.dpToPx(40.0F)), 0.0F, 0.0F);
    paramView.setFillAfter(true);
    paramView.setDuration(200L);
    paramContext = (AlphaAnimation)AnimationUtils.loadAnimation(paramContext, 2130772194);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(paramContext);
    localAnimationSet.addAnimation(paramView);
    localAnimationSet.setFillAfter(true);
    return localAnimationSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svm
 * JD-Core Version:    0.7.0.1
 */