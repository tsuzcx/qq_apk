package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.troop.api.ITroopNickEdit;
import com.tencent.mobileqq.vas.troopnick.TroopNickNameHelper;
import com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable;

public class TroopNickEditImpl
  implements ITroopNickEdit
{
  public void onDetachedFromWindow(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof TroopNickResDrawable))
    {
      paramDrawable = (TroopNickResDrawable)paramDrawable;
      paramDrawable.a(null);
      paramDrawable.a();
    }
  }
  
  public void setCustomCloth(TextView paramTextView, Context paramContext, int paramInt, boolean paramBoolean)
  {
    TroopNickNameHelper.a(paramTextView, paramContext, paramInt, paramBoolean);
  }
  
  public void updateDrawablePadding(Drawable paramDrawable, PointF paramPointF)
  {
    if ((paramDrawable instanceof TroopNickResDrawable))
    {
      paramDrawable = (TroopNickResDrawable)paramDrawable;
      if ((paramPointF.x == 0.0F) && (paramPointF.y == 0.0F)) {
        paramPointF.x = 1.0F;
      }
      paramDrawable.a(paramPointF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopNickEditImpl
 * JD-Core Version:    0.7.0.1
 */