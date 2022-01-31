package dov.com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aogy;
import aogz;
import aoha;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class GuideHelper
{
  private boolean a(ViewGroup paramViewGroup, Context paramContext, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuideHelper", 2, "showPasterTrackerGuideThird left =" + paramInt1 + ", top=" + paramInt2);
    }
    if ((paramViewGroup == null) || (paramViewGroup.findViewById(2131362518) != null)) {}
    int j;
    RelativeLayout.LayoutParams localLayoutParams;
    int k;
    do
    {
      int i;
      do
      {
        return false;
        paramInt2 -= AIOUtils.a(10.0F, paramContext.getResources());
        localObject1 = paramContext.getResources().getDisplayMetrics();
        i = ((DisplayMetrics)localObject1).widthPixels;
        j = ((DisplayMetrics)localObject1).heightPixels;
        localObject1 = new RelativeLayout(paramContext);
        ((RelativeLayout)localObject1).setId(2131362518);
        ((RelativeLayout)localObject1).setOnClickListener(new aogy(this, paramViewGroup));
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setText("拖动贴纸，并把贴纸盖在跟随目标上。");
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setTextSize(1, 16.0F);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setShadowLayer(2.0F, 0.0F, 0.0F, -16777216);
        ((TextView)localObject2).setSingleLine();
        localLayoutParams = new RelativeLayout.LayoutParams(-2, AIOUtils.a(36.0F, paramContext.getResources()));
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        ((TextView)localObject2).measure(-2, -2);
        j = ((TextView)localObject2).getMeasuredWidth();
        k = ((TextView)localObject2).getMeasuredHeight();
        if (paramInt2 - k >= 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("GuideHelper", 2, "showPasterTrackerGuideThird height exceed");
      return false;
      if ((paramInt1 - j / 2 >= 0) && (j / 2 + paramInt1 <= i)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GuideHelper", 2, "showPasterTrackerGuideThird left right exceed");
    return false;
    Object localObject2 = new RelativeLayout.LayoutParams(j, AIOUtils.a(7.0F, paramContext.getResources()) + k);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = (paramInt1 - j / 2);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt2 - k);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(6.0F, paramContext.getResources());
    paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    float f = ((RelativeLayout)localObject1).getTranslationY();
    paramViewGroup = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { AIOUtils.a(15.0F, paramContext.getResources()) + f, f });
    paramViewGroup.setDuration(140L);
    paramViewGroup.setInterpolator(new AccelerateDecelerateInterpolator());
    paramContext = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F });
    paramContext.setDuration(140L);
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(new Animator[] { paramViewGroup, paramContext });
    ((AnimatorSet)localObject1).start();
    return true;
  }
  
  private boolean b(ViewGroup paramViewGroup, Context paramContext, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuideHelper", 2, "showPasterTrackerGuideFirst left =" + paramInt1 + ", top=" + paramInt2);
    }
    if ((paramViewGroup == null) || (paramViewGroup.findViewById(2131362518) != null)) {}
    int j;
    RelativeLayout.LayoutParams localLayoutParams;
    int k;
    do
    {
      int i;
      do
      {
        return false;
        localObject1 = paramContext.getResources().getDisplayMetrics();
        i = ((DisplayMetrics)localObject1).widthPixels;
        j = ((DisplayMetrics)localObject1).heightPixels;
        localObject1 = new RelativeLayout(paramContext);
        ((RelativeLayout)localObject1).setId(2131362518);
        ((RelativeLayout)localObject1).setOnClickListener(new aogz(this, paramViewGroup));
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setText("选中贴纸，体验贴纸跟随玩法。");
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setTextSize(1, 16.0F);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setShadowLayer(2.0F, 0.0F, 0.0F, -16777216);
        ((TextView)localObject2).setSingleLine();
        localLayoutParams = new RelativeLayout.LayoutParams(-2, AIOUtils.a(36.0F, paramContext.getResources()));
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        ((TextView)localObject2).measure(-2, -2);
        j = ((TextView)localObject2).getMeasuredWidth();
        k = ((TextView)localObject2).getMeasuredHeight();
        if (paramInt2 - k - 86 >= 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("GuideHelper", 2, "showPasterTrackerGuideFirst height exceed");
      return false;
      if ((paramInt1 - j / 2 >= 0) && (j / 2 + paramInt1 <= i)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GuideHelper", 2, "showPasterTrackerGuideFirst left right exceed");
    return false;
    Object localObject2 = new RelativeLayout.LayoutParams(j, AIOUtils.a(7.0F, paramContext.getResources()) + k);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = (paramInt1 - j / 2);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt2 - k);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(6.0F, paramContext.getResources());
    paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    float f = ((RelativeLayout)localObject1).getTranslationY();
    paramViewGroup = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { AIOUtils.a(15.0F, paramContext.getResources()) + f, f });
    paramViewGroup.setDuration(140L);
    paramViewGroup.setInterpolator(new AccelerateDecelerateInterpolator());
    paramContext = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F });
    paramContext.setDuration(140L);
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(new Animator[] { paramViewGroup, paramContext });
    ((AnimatorSet)localObject1).start();
    return true;
  }
  
  private boolean c(ViewGroup paramViewGroup, Context paramContext, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuideHelper", 2, "showPasterTrackerGuide");
    }
    if ((paramViewGroup == null) || (paramViewGroup.findViewById(2131362518) != null)) {
      return false;
    }
    paramInt2 = AIOUtils.a(10.0F, paramContext.getResources()) + paramInt2;
    int i = AIOUtils.a(38.0F, paramContext.getResources());
    Object localObject1 = paramContext.getResources().getDisplayMetrics();
    int j = ((DisplayMetrics)localObject1).widthPixels;
    int k = ((DisplayMetrics)localObject1).heightPixels;
    if (QLog.isColorLevel()) {
      QLog.d("GuideHelper", 2, "showPasterGuide :left = " + paramInt1 + ", defaultBottom = " + i);
    }
    Object localObject2 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject2).setId(2131362518);
    ((RelativeLayout)localObject2).setOnClickListener(new aoha(this, paramViewGroup));
    localObject1 = new View(paramContext);
    ((View)localObject1).setBackgroundResource(2130841932);
    ((View)localObject1).setId(2131362505);
    int n = AIOUtils.a(13.0F, paramContext.getResources());
    int m = AIOUtils.a(7.0F, paramContext.getResources());
    Object localObject3 = new RelativeLayout.LayoutParams(n, m);
    ((RelativeLayout.LayoutParams)localObject3).addRule(10);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = (paramInt1 - n / 2);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = paramInt2;
    paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(paramContext);
    ((TextView)localObject3).setText("点这里，选择贴纸要跟随的目标。");
    ((TextView)localObject3).setBackgroundResource(2130841933);
    ((TextView)localObject3).setTextColor(-1);
    ((TextView)localObject3).setTextSize(1, 16.0F);
    ((TextView)localObject3).setGravity(17);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, AIOUtils.a(36.0F, paramContext.getResources()));
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(14);
    ((RelativeLayout)localObject2).addView((View)localObject3, localLayoutParams);
    ((TextView)localObject3).measure(-2, -2);
    n = ((TextView)localObject3).getMeasuredWidth();
    int i1 = ((TextView)localObject3).getMeasuredHeight();
    localObject3 = new RelativeLayout.LayoutParams(n, AIOUtils.a(7.0F, paramContext.getResources()) + i1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    if ((paramInt1 <= 0) || (paramInt1 >= j))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuideHelper", 2, "showPasterTrackerGuide left right exceed");
      }
      paramViewGroup.removeView((View)localObject1);
      return false;
    }
    if (i1 + (paramInt2 + m) > k - i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuideHelper", 2, "showPasterTrackerGuide height exceed");
      }
      paramViewGroup.removeView((View)localObject1);
      return false;
    }
    if (paramInt1 - n / 2 < 0) {
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 0;
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject3).topMargin = (paramInt2 + m);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.a(6.0F, paramContext.getResources());
      paramViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      float f = ((RelativeLayout)localObject2).getTranslationY();
      paramViewGroup = ObjectAnimator.ofFloat(localObject2, "translationY", new float[] { AIOUtils.a(15.0F, paramContext.getResources()) + f, f });
      paramViewGroup.setDuration(140L);
      paramViewGroup.setInterpolator(new AccelerateDecelerateInterpolator());
      localObject2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject2).setDuration(140L);
      paramContext = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { AIOUtils.a(15.0F, paramContext.getResources()) + f, f });
      paramContext.setDuration(140L);
      paramContext.setInterpolator(new AccelerateDecelerateInterpolator());
      localObject1 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject1).setDuration(140L);
      localObject3 = new AnimatorSet();
      ((AnimatorSet)localObject3).playTogether(new Animator[] { paramViewGroup, localObject2, paramContext, localObject1 });
      ((AnimatorSet)localObject3).start();
      return true;
      if (n / 2 + paramInt1 > j) {
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = (paramInt1 - (n + paramInt1 - j));
      } else {
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = (paramInt1 - n / 2);
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      View localView1 = paramViewGroup.findViewById(2131362518);
      View localView2 = paramViewGroup.findViewById(2131362505);
      if (localView1 != null) {
        paramViewGroup.removeView(localView1);
      }
      if (localView2 != null) {
        paramViewGroup.removeView(localView2);
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (paramViewGroup == null) {}
    while ((paramViewGroup.findViewById(2131362518) != null) || (SharedPreUtils.C(paramContext, paramString)) || (!c(paramViewGroup, paramContext, paramInt1, paramInt2))) {
      return;
    }
    SharedPreUtils.G(paramContext, paramString);
  }
  
  public boolean a(ViewGroup paramViewGroup, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (paramViewGroup == null) {}
    while ((paramViewGroup.findViewById(2131362518) != null) || (SharedPreUtils.D(paramContext, paramString)) || (!b(paramViewGroup, paramContext, paramInt1, paramInt2))) {
      return false;
    }
    SharedPreUtils.H(paramContext, paramString);
    return true;
  }
  
  public boolean b(ViewGroup paramViewGroup, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (paramViewGroup == null) {}
    while ((paramViewGroup.findViewById(2131362518) != null) || (SharedPreUtils.B(paramContext, paramString)) || (!a(paramViewGroup, paramContext, paramInt1, paramInt2))) {
      return false;
    }
    SharedPreUtils.F(paramContext, paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.GuideHelper
 * JD-Core Version:    0.7.0.1
 */