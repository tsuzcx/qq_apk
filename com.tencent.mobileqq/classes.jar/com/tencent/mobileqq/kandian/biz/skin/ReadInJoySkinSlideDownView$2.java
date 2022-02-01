package com.tencent.mobileqq.kandian.biz.skin;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.ILayoutSizeHandler;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;

class ReadInJoySkinSlideDownView$2
  implements SceneBuilder.ILayoutSizeHandler
{
  ReadInJoySkinSlideDownView$2(ReadInJoySkinSlideDownView paramReadInJoySkinSlideDownView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = this.a.getHeight();
    this.a.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinSlideDownView.2
 * JD-Core Version:    0.7.0.1
 */