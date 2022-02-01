package com.tencent.mobileqq.persistence.bridge;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.entitymanager.OnDBTableVerifyFailListener;
import mqq.os.MqqHandler;

public class DBTableVerifyFailHandler
  implements OnDBTableVerifyFailListener
{
  private static boolean a = false;
  
  private void a(String paramString)
  {
    ThreadManager.getUIHandler().postDelayed(new DBTableVerifyFailHandler.1(this, paramString), 1000L);
  }
  
  public void onDBTableVerifyFailed(String paramString)
  {
    if (a) {
      return;
    }
    a = true;
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.DBTableVerifyFailHandler
 * JD-Core Version:    0.7.0.1
 */