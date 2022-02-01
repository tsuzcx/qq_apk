package com.tencent.mobileqq.vas.troopnick;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.VasResDrawableAdapter;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureSwitchConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureSwitchProcessor;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.QColorNickTextView;
import mqq.app.AppRuntime;

public class TroopNickNameHelper
{
  private static void a(TextView paramTextView)
  {
    if ((paramTextView instanceof ColorNickTextView))
    {
      ((ColorNickTextView)paramTextView).b();
      return;
    }
    if ((paramTextView instanceof ColorClearableEditText))
    {
      ((ColorClearableEditText)paramTextView).b();
      return;
    }
    if ((paramTextView instanceof QColorNickTextView))
    {
      QColorNickTextView localQColorNickTextView = (QColorNickTextView)paramTextView;
      localQColorNickTextView.updateDrawablePadding();
      paramTextView = paramTextView.getBackground();
      if ((paramTextView instanceof TroopNickResDrawable))
      {
        localQColorNickTextView.splitParagraph();
        ((TroopNickResDrawable)paramTextView).a(localQColorNickTextView.getContentSize());
      }
    }
  }
  
  private static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    Object localObject = TroopNickFontAdapter.c(paramInt1, paramInt2);
    if (localObject != null)
    {
      paramTextView.setTypeface((Typeface)localObject);
      return;
    }
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    VasRes localVasRes = new VasRes((AppRuntime)localObject, paramInt1);
    localVasRes.a(new TroopNickFontAdapter(paramTextView, localVasRes, (AppRuntime)localObject, paramInt2));
  }
  
  public static void a(TextView paramTextView, Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if ((QVipFeatureSwitchProcessor.a() != null) && (!QVipFeatureSwitchProcessor.a().isTroopNickEnable()))
    {
      b(paramTextView);
      return;
    }
    if ((paramInt > 0) && (paramContext != null))
    {
      Object localObject = paramTextView.getBackground();
      int i;
      if (((localObject instanceof TroopNickResDrawable)) && (((TroopNickResDrawable)localObject).e() == paramInt)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        paramContext = new TroopNickResDrawable(paramContext, paramInt);
        localObject = new TroopNickAdapter(paramContext);
        if (paramBoolean) {
          ((TroopNickAdapter)localObject).a(true);
        }
        paramContext.a((VasResDrawable.VasResDrawableAdapter)localObject);
        paramTextView.setBackgroundDrawable(paramContext);
        paramContext.a(new TroopNickNameHelper.1(paramTextView));
        a(paramTextView, ((TroopNickAdapter)localObject).a, ((TroopNickAdapter)localObject).b);
      }
      a(paramTextView);
      return;
    }
    b(paramTextView);
  }
  
  private static void b(TextView paramTextView)
  {
    paramTextView.setTypeface(Typeface.DEFAULT);
    paramTextView.setBackgroundDrawable(null);
    paramTextView.setPadding(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickNameHelper
 * JD-Core Version:    0.7.0.1
 */