package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

class ApolloRenderDriver$7
  extends IApolloRunnableTask
{
  ApolloRenderDriver$7(ApolloRenderDriver paramApolloRenderDriver, String paramString) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      boolean bool = new File(this.a).exists();
      if (bool)
      {
        try
        {
          long l = SystemClock.uptimeMillis();
          localObject3 = CmGameUtil.a(this.a);
          Object localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = FileUtils.readFileToString(new File(this.a));
            CmGameUtil.b(this.a, (String)localObject1);
          }
          QLog.d("[cmshow]ApolloRenderDriver", 1, new Object[] { "read game file, duration=", Long.valueOf(SystemClock.uptimeMillis() - l) });
          if (ApolloManagerServiceImpl.sApolloGameStkey != null) {
            this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine.setSkey(ApolloManagerServiceImpl.sApolloGameStkey.getBytes());
          }
          if (ApolloManagerServiceImpl.sApolloGameSt != null) {
            this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine.setSt(HexUtil.hexStr2Bytes(ApolloManagerServiceImpl.sApolloGameSt));
          }
          l = SystemClock.uptimeMillis();
          this.this$0.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine.execScriptString((String)localObject1);
          QLog.d("[cmshow]ApolloRenderDriver", 1, new Object[] { "execScriptString, duration=", Long.valueOf(SystemClock.uptimeMillis() - l) });
        }
        catch (Throwable localThrowable)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("loadScript error =");
          ((StringBuilder)localObject3).append(localThrowable.toString());
          QLog.e("[cmshow]ApolloRenderDriver", 1, ((StringBuilder)localObject3).toString());
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("loadScript OutOfMemoryError =");
          ((StringBuilder)localObject3).append(localOutOfMemoryError.toString());
          QLog.e("[cmshow]ApolloRenderDriver", 1, ((StringBuilder)localObject3).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onEnterGame], file not exsit:");
        localStringBuilder.append(this.a);
        QLog.d("[cmshow]ApolloRenderDriver", 2, localStringBuilder.toString());
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
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver.7
 * JD-Core Version:    0.7.0.1
 */