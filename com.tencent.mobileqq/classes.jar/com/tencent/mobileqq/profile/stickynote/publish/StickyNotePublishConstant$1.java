package com.tencent.mobileqq.profile.stickynote.publish;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.profile.stickynote.publish.bean.BackgroundSelectBean;
import java.util.ArrayList;

final class StickyNotePublishConstant$1
  extends ArrayList<BackgroundSelectBean>
{
  StickyNotePublishConstant$1()
  {
    add(new BackgroundSelectBean(0L, false, new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { Color.parseColor("#C773FF"), Color.parseColor("#FF73C7") })));
    add(new BackgroundSelectBean(1L, false, new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { Color.parseColor("#FF596A"), Color.parseColor("#FF9F40") })));
    add(new BackgroundSelectBean(2L, false, new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { Color.parseColor("#8173FF"), Color.parseColor("#4D94FF") })));
    add(new BackgroundSelectBean(3L, false, new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { Color.parseColor("#00CF68"), Color.parseColor("#0ECDB9") })));
    add(new BackgroundSelectBean(4L, false, new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { Color.parseColor("#FF73C7"), Color.parseColor("#FF596A") })));
    add(new BackgroundSelectBean(5L, false, new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { Color.parseColor("#4D94FF"), Color.parseColor("#00CAFC") })));
    add(new BackgroundSelectBean(999L, false, BaseApplicationImpl.getApplication().getResources().getDrawable(2130850659)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.StickyNotePublishConstant.1
 * JD-Core Version:    0.7.0.1
 */