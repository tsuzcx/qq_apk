package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.qphone.base.util.QLog;

class ApolloRender$2
  implements Runnable
{
  ApolloRender$2(ApolloRender paramApolloRender, OnApolloViewListener paramOnApolloViewListener, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener != null)
    {
      QLog.d("[cmshow]sava_ApolloRender", 2, "cb.onSurfaceReady");
      this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener.onSurfaceReady(this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender.2
 * JD-Core Version:    0.7.0.1
 */