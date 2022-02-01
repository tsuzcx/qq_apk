package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$6
  extends IApolloRunnableTask
{
  public void run()
  {
    String str;
    if (1 == this.a) {
      str = "me.restoreAnimationState();";
    } else {
      str = "friend.restoreAnimationState();";
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine.execScriptString(str);
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloITriggerRenderCallback != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloITriggerRenderCallback.onRender();
      }
      return;
    }
    finally
    {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver.6
 * JD-Core Version:    0.7.0.1
 */