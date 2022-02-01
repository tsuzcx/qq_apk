package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

final class WebSocketUtil$1
  implements HandshakeCompletedListener
{
  WebSocketUtil$1(View paramView, long paramLong) {}
  
  public void handshakeCompleted(HandshakeCompletedEvent paramHandshakeCompletedEvent)
  {
    ((ApolloSurfaceView)this.a).runRenderTask(new WebSocketUtil.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.WebSocketUtil.1
 * JD-Core Version:    0.7.0.1
 */