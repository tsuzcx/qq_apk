package com.tencent.mobileqq.surfaceviewaction.builder;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.surfaceviewaction.ISpriteView;

class SceneBuilder$1
  implements Runnable
{
  SceneBuilder$1(SceneBuilder paramSceneBuilder, ISpriteView paramISpriteView, SceneBuilder.OnBuiltListener paramOnBuiltListener) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(SceneBuilder.a(this.this$0));
    ((StringBuilder)localObject).append("/scene.json");
    localObject = SceneBuilder.b(((StringBuilder)localObject).toString());
    new Handler(Looper.getMainLooper()).post(new SceneBuilder.1.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.1
 * JD-Core Version:    0.7.0.1
 */