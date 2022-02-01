package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.qphone.base.util.QLog;

class ApolloRender$1
  extends IApolloRunnableTask
{
  ApolloRender$1(ApolloRender paramApolloRender) {}
  
  public int a()
  {
    return 4;
  }
  
  public void run()
  {
    this.this$0.onDestroy();
    ApolloRender.access$002(this.this$0, true);
    QLog.i("[cmshow][ApolloRender]", 1, "queueDestroy disposeDirector");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender.1
 * JD-Core Version:    0.7.0.1
 */