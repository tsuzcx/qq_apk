package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.view.View;

class ApolloRender$3
  implements Runnable
{
  ApolloRender$3(ApolloRender paramApolloRender, View paramView) {}
  
  public void run()
  {
    ApolloCmdChannel.getInstance().removeRenderRunner((IRenderRunner)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender.3
 * JD-Core Version:    0.7.0.1
 */