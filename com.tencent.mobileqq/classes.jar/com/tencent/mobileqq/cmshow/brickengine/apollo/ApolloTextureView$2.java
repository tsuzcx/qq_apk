package com.tencent.mobileqq.cmshow.brickengine.apollo;

class ApolloTextureView$2
  implements Runnable
{
  ApolloTextureView$2(ApolloTextureView paramApolloTextureView) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.this$0.getRender();
    if ((localApolloRender != null) && (localApolloRender.getSavaWrapper() != null))
    {
      double d = 0.0D;
      if (localApolloRender.mIsFrameMode) {
        d = localApolloRender.mDuration;
      }
      localApolloRender.getSavaWrapper().drawSpecialFrame(d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView.2
 * JD-Core Version:    0.7.0.1
 */