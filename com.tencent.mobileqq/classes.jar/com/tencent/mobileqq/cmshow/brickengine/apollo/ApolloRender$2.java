package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.qphone.base.util.QLog;

class ApolloRender$2
  implements Runnable
{
  ApolloRender$2(ApolloRender paramApolloRender, OnApolloViewListener paramOnApolloViewListener, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.a != null)
    {
      QLog.d("[cmshow][ApolloRender]", 2, "cb.onSurfaceReady");
      this.a.a(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender.2
 * JD-Core Version:    0.7.0.1
 */