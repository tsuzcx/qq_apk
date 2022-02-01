package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$1
  extends IApolloRunnableTask
{
  ApolloRenderDriver$1(ApolloRenderDriver paramApolloRenderDriver, int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloRenderDriver", 2, "start run.");
    }
    Object localObject1 = ApolloUtilImpl.getApolloId(1);
    int i = this.a;
    int k = this.b;
    String[] arrayOfString1 = this.c;
    int j = 0;
    String[] arrayOfString2 = ApolloActionHelperImpl.getActionScriptString((String)localObject1, i, k, arrayOfString1[0], arrayOfString1[1]);
    arrayOfString1 = null;
    String[] arrayOfString3 = this.d;
    localObject1 = arrayOfString1;
    if (arrayOfString3 != null)
    {
      localObject1 = arrayOfString1;
      if (arrayOfString3.length == 2)
      {
        localObject1 = ApolloUtilImpl.getApolloId(2);
        i = this.a;
        k = this.b;
        arrayOfString1 = this.d;
        localObject1 = ApolloActionHelperImpl.getActionScriptString((String)localObject1, i, k, arrayOfString1[0], arrayOfString1[1]);
      }
    }
    this.this$0.c.lock();
    if (arrayOfString2 != null) {}
    for (i = 0;; i = j)
    {
      try
      {
        while (i < arrayOfString2.length)
        {
          this.this$0.b.execScriptString(arrayOfString2[i]);
          i += 1;
        }
        if (i >= localObject1.length) {
          break label209;
        }
        this.this$0.b.execScriptString(localObject1[i]);
        i += 1;
      }
      finally
      {
        label196:
        label209:
        break label196;
      }
      this.this$0.c.unlock();
      throw ((Throwable)localObject1);
      do
      {
        this.this$0.c.unlock();
        if ((!this.this$0.f.get()) && (this.this$0.a != null)) {
          this.this$0.a.onRender();
        }
        return;
      } while (localObject2 == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver.1
 * JD-Core Version:    0.7.0.1
 */