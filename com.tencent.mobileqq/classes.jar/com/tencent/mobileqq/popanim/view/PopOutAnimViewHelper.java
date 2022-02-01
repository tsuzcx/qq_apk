package com.tencent.mobileqq.popanim.view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQBlurView;
import mqq.app.MobileQQ;

public class PopOutAnimViewHelper
{
  public static void a(int paramInt, View... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        ((View)localObject).setVisibility(paramInt);
        if ((localObject instanceof DiniFlyAnimationView))
        {
          localObject = ((DiniFlyAnimationView)localObject).getDrawable();
          if ((localObject != null) && ((localObject instanceof LottieDrawable)))
          {
            localObject = (LottieDrawable)localObject;
            if (paramInt == 0)
            {
              if (!((LottieDrawable)localObject).isAnimating()) {
                ((LottieDrawable)localObject).playAnimation();
              }
            }
            else if (((LottieDrawable)localObject).isAnimating()) {
              ((LottieDrawable)localObject).stop();
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public static void a(LottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener)
  {
    LottieHelper.a(MobileQQ.getContext(), "emoc/pop_anim_top_static.json", null, 60, 60, -1, paramLottieDrawableLoadedListener);
  }
  
  public static void a(QQBlurView paramQQBlurView, View paramView, int paramInt)
  {
    paramQQBlurView.a(paramView);
    paramQQBlurView.b(paramQQBlurView);
    paramQQBlurView.b(0);
    paramQQBlurView.a(8.0F);
    paramQQBlurView.a(8);
    paramView = new ColorDrawable(Color.rgb(3, 8, 26));
    paramView.setAlpha(128);
    paramQQBlurView.a(paramView);
    paramQQBlurView.getLayoutParams().height = paramInt;
    paramQQBlurView.d();
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, paramInt, 0, paramString2, "", "", "");
  }
  
  public static void a(String paramString, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) {
      a(paramString, ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).code, "");
    }
  }
  
  public static void b(LottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener)
  {
    LottieHelper.a(MobileQQ.getContext(), "emoc/pop_anim_finger.json", null, 160, 160, -1, paramLottieDrawableLoadedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper
 * JD-Core Version:    0.7.0.1
 */