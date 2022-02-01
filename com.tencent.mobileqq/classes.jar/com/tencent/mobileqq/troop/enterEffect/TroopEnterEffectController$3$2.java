package com.tencent.mobileqq.troop.enterEffect;

import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.ILayoutSizeHandler;

class TroopEnterEffectController$3$2
  implements SceneBuilder.ILayoutSizeHandler
{
  TroopEnterEffectController$3$2(TroopEnterEffectController.3 param3) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.this$0.d.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    this.a.this$0.d.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3.2
 * JD-Core Version:    0.7.0.1
 */