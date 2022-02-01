package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.utils.FileUtils;

class AbsApolloResManager$17$1
  implements Runnable
{
  AbsApolloResManager$17$1(AbsApolloResManager.17 param17, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    if (AbsApolloResManager.b(this.b.a, this.a))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b.a.a(this.a, 6));
      ((StringBuilder)localObject).append("action");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.a.a(this.a, 6));
      localStringBuilder.append("panelAction/action/");
      FileUtils.copyDirectory((String)localObject, localStringBuilder.toString(), false, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.17.1
 * JD-Core Version:    0.7.0.1
 */