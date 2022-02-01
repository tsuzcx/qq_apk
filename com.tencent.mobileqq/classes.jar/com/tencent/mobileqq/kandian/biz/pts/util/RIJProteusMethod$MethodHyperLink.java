package com.tencent.mobileqq.kandian.biz.pts.util;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentAtUtil;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentTopicUtil;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class RIJProteusMethod$MethodHyperLink
  implements CustomMethodsRegister.CustomMethodInterface
{
  private static boolean a(View paramView, String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramView != null) && (paramString.endsWith("#comment_topic")))
    {
      ((IRIJCommentTopicUtil)QRoute.api(IRIJCommentTopicUtil.class)).onTopicClick(paramView, paramString);
      return true;
    }
    return false;
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramString.startsWith("more-")))
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(paramString);
      return true;
    }
    return false;
  }
  
  private static boolean b(View paramView, String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramView != null) && (paramString.endsWith("#comment_at")))
    {
      ((IRIJCommentAtUtil)QRoute.api(IRIJCommentAtUtil.class)).onAtClick(paramView, paramString);
      return true;
    }
    return false;
  }
  
  private static boolean b(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramString.endsWith("#native_article_topic_tag")))
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(paramString);
      return true;
    }
    return false;
  }
  
  public Object invoke(String paramString, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      Object localObject = paramVarArgs[0];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MethodHyperLink invoke,s=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" firstObject=");
      localStringBuilder.append(localObject);
      QLog.d("RIJProteusMethod", 1, localStringBuilder.toString());
      localObject = String.valueOf(localObject);
      if ((paramVarArgs.length >= 2) && ((paramVarArgs[1] instanceof View))) {
        paramString = (View)paramVarArgs[1];
      } else {
        paramString = null;
      }
      boolean bool = false | a((String)localObject, false);
      bool |= b((String)localObject, bool);
      bool |= a(paramString, (String)localObject, bool);
      if (!(b(paramString, (String)localObject, bool) | bool)) {
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(BaseApplication.getContext(), (String)localObject);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJProteusMethod.MethodHyperLink
 * JD-Core Version:    0.7.0.1
 */