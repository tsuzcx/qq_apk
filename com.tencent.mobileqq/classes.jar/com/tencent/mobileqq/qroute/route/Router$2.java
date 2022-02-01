package com.tencent.mobileqq.qroute.route;

class Router$2
  implements Router.OnCompleteListener
{
  Router$2(Router paramRouter, String paramString) {}
  
  public void onError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start path fail, result:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" path:");
    localStringBuilder.append(this.val$path);
    Logger.warning(localStringBuilder.toString());
  }
  
  public void onSuccess()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start path success, ");
    localStringBuilder.append(this.val$path);
    Logger.info(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.Router.2
 * JD-Core Version:    0.7.0.1
 */