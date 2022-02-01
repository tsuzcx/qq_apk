package com.tencent.mobileqq.theme.diy;

import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper;

class ThemeBackground$4$1
  implements Runnable
{
  ThemeBackground$4$1(ThemeBackground.4 param4, ThemeBackground paramThemeBackground) {}
  
  public void run()
  {
    Object localObject;
    if ((!"null".equals(this.val$themeBackground.path)) && (this.val$themeBackground.img != null))
    {
      this.this$0.val$view.setTag(this.val$themeBackground);
      if ((this.this$0.val$view instanceof ImageView))
      {
        localObject = (ImageView)this.this$0.val$view;
        ((ImageView)localObject).setImageDrawable(this.val$themeBackground.img);
        if ((ThemeUtil.isHorizontalAnimate()) && (GLDrawableWraper.a(this.val$themeBackground.img)))
        {
          this.val$themeBackground.scaleType = ((ImageView)localObject).getScaleType();
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        ThemeBackground.access$000(this.this$0.val$bgType, this.val$themeBackground, this.this$0.val$view);
      }
    }
    do
    {
      return;
      if ((this.this$0.val$view instanceof ChatXListView))
      {
        ((ChatXListView)this.this$0.val$view).setContentBackground(this.val$themeBackground.img);
        break;
      }
      if ((this.this$0.val$view instanceof FPSSwipListView))
      {
        ((FPSSwipListView)this.this$0.val$view).setContentBackground(this.val$themeBackground.img);
        break;
      }
      this.this$0.val$view.setBackgroundDrawable(this.val$themeBackground.img);
      break;
      localObject = this.this$0.val$view.getTag();
      if (((localObject instanceof ThemeBackground)) && (GLDrawableWraper.b(((ThemeBackground)localObject).img))) {
        GLDrawableWraper.a().a(((ThemeBackground)localObject).img);
      }
      this.val$themeBackground.img = null;
      this.this$0.val$view.setTag(null);
      if (!(this.this$0.val$view instanceof ImageView)) {
        break label352;
      }
      ((ImageView)this.this$0.val$view).setImageResource(this.this$0.val$defaultBgResId);
    } while (this.val$themeBackground.scaleType == null);
    ((ImageView)this.this$0.val$view).setScaleType(this.val$themeBackground.scaleType);
    return;
    label352:
    if ((this.this$0.val$view instanceof ChatXListView))
    {
      ((ChatXListView)this.this$0.val$view).setContentBackground(this.this$0.val$defaultBgResId);
      return;
    }
    if ((this.this$0.val$view instanceof FPSSwipListView))
    {
      ((FPSSwipListView)this.this$0.val$view).setContentBackground(this.this$0.val$defaultBgResId);
      return;
    }
    this.this$0.val$view.setBackgroundResource(this.this$0.val$defaultBgResId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground.4.1
 * JD-Core Version:    0.7.0.1
 */