package com.tencent.mobileqq.cmshow.engine.resource;

import mqq.app.AppRuntime;

class AbsApolloResManager$7
  implements Runnable
{
  AbsApolloResManager$7(AbsApolloResManager paramAbsApolloResManager, int paramInt, IApolloResManager.ApolloRoleInfoListener paramApolloRoleInfoListener, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    if (this.this$0.b(this.a))
    {
      IApolloResManager.ApolloRoleInfoListener localApolloRoleInfoListener = this.b;
      if (localApolloRoleInfoListener != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
        localStringBuilder.append(this.a);
        localApolloRoleInfoListener.a(localStringBuilder.toString(), "success", 0);
      }
    }
    else
    {
      this.this$0.a().a(this.c, null, new AbsApolloResManager.7.1(this), this.a, null, -1, -1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.7
 * JD-Core Version:    0.7.0.1
 */