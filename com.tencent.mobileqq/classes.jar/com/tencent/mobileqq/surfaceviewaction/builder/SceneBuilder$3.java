package com.tencent.mobileqq.surfaceviewaction.builder;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.ILayer;
import com.tencent.mobileqq.surfaceviewaction.ISprite;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SceneBuilder$3
  implements View.OnClickListener
{
  SceneBuilder$3(SceneBuilder paramSceneBuilder, ILayer paramILayer, BaseNode paramBaseNode, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (SceneBuilder.b(this.d) != null) {
      SceneBuilder.b(this.d).a(this.a, (ISprite)this.b, this.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.3
 * JD-Core Version:    0.7.0.1
 */