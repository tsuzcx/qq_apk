package com.tencent.mobileqq.qroute.route;

class Router$2
  implements Router.OnCompleteListener
{
  Router$2(Router paramRouter, String paramString) {}
  
  public void onError(int paramInt)
  {
    Logger.warning("start path fail, result:" + paramInt + " path:" + this.val$path);
  }
  
  public void onSuccess()
  {
    Logger.info("start path success, " + this.val$path);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.Router.2
 * JD-Core Version:    0.7.0.1
 */