package com.tencent.mobileqq.qroute.route;

import android.app.Activity;
import java.util.ArrayList;

class Router$1
  implements IRouteRegister
{
  Router$1(Router paramRouter, ArrayList paramArrayList) {}
  
  public void register(String paramString, Class<? extends Activity> paramClass)
  {
    this.val$paths.add(paramString + ">" + paramClass.toString());
    this.this$0.register(paramString, paramClass);
  }
  
  public void register(String paramString1, String paramString2)
  {
    this.val$paths.add(paramString1 + ">" + paramString2);
    this.this$0.register(paramString1, paramString2);
  }
  
  public void register(String paramString1, String paramString2, URIHandler paramURIHandler)
  {
    this.val$paths.add(paramString1 + "://" + paramString2 + ">" + paramURIHandler.toString());
    this.this$0.register(paramString1, paramString2, paramURIHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.Router.1
 * JD-Core Version:    0.7.0.1
 */