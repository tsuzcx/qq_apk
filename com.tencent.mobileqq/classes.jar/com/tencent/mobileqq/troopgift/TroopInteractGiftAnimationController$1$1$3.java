package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import org.json.JSONObject;

class TroopInteractGiftAnimationController$1$1$3
  implements FrameSprite.OnFrameEndListener
{
  TroopInteractGiftAnimationController$1$1$3(TroopInteractGiftAnimationController.1.1 param1, int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject1, int paramInt3, JSONObject paramJSONObject2) {}
  
  public void a()
  {
    if (this.a > this.b)
    {
      if (this.g.b.this$0.b == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(this.d.optString("videoPath", "2.mp4"));
      localObject = ((StringBuilder)localObject).toString();
      this.g.b.this$0.b.a((String)localObject, new TroopInteractGiftAnimationController.1.1.3.1(this));
      return;
    }
    this.g.b.this$0.a();
    if (this.g.b.d != null) {
      this.g.b.d.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.3
 * JD-Core Version:    0.7.0.1
 */