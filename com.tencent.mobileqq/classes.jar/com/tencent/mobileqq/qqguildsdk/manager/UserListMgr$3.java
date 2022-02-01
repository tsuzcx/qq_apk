package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.concurrent.Executor;

class UserListMgr$3
  implements Executor
{
  UserListMgr$3(UserListMgr paramUserListMgr) {}
  
  public void execute(Runnable paramRunnable)
  {
    ThreadManagerV2.executeOnSubThread(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.UserListMgr.3
 * JD-Core Version:    0.7.0.1
 */