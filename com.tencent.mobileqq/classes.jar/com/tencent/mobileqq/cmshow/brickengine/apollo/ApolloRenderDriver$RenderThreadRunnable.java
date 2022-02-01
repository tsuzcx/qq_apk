package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$RenderThreadRunnable
  extends IApolloRunnableTask
{
  private String jdField_a_of_type_JavaLangString;
  WeakReference<ApolloEngine> jdField_a_of_type_JavaLangRefWeakReference = null;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  
  public ApolloRenderDriver$RenderThreadRunnable(ApolloRenderDriver paramApolloRenderDriver, String paramString, ReentrantLock paramReentrantLock, ApolloEngine paramApolloEngine)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = paramReentrantLock;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloEngine);
  }
  
  public void run()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      ApolloEngine localApolloEngine = (ApolloEngine)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localApolloEngine != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("run js =");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("[cmshow]ApolloRenderDriver", 2, localStringBuilder.toString());
        localApolloEngine.execScriptString(this.jdField_a_of_type_JavaLangString);
        if (!this.this$0.a.get()) {
          localApolloEngine.drawSpecialFrame(0.0D);
        }
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver.RenderThreadRunnable
 * JD-Core Version:    0.7.0.1
 */