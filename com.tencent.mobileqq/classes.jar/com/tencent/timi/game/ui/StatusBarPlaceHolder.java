package com.tencent.timi.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;
import mqq.app.MobileQQ;

public class StatusBarPlaceHolder
  extends View
{
  public StatusBarPlaceHolder(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatusBarPlaceHolder(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StatusBarPlaceHolder(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, Math.round(ViewUtils.getStatusBarHeight(MobileQQ.context)) | 0x40000000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.StatusBarPlaceHolder
 * JD-Core Version:    0.7.0.1
 */