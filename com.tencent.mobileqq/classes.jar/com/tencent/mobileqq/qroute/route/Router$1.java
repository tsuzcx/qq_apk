package com.tencent.mobileqq.qroute.route;

import android.app.Activity;
import java.util.ArrayList;

class Router$1
  implements IRouteRegister
{
  Router$1(Router paramRouter, ArrayList paramArrayList) {}
  
  public void register(String paramString, Class<? extends Activity> paramClass)
  {
    ArrayList localArrayList = this.val$paths;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(">");
    localStringBuilder.append(paramClass.toString());
    localArrayList.add(localStringBuilder.toString());
    this.this$0.register(paramString, paramClass);
  }
  
  public void register(String paramString1, String paramString2)
  {
    ArrayList localArrayList = this.val$paths;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(">");
    localStringBuilder.append(paramString2);
    localArrayList.add(localStringBuilder.toString());
    this.this$0.register(paramString1, paramString2);
  }
  
  public void register(String paramString1, String paramString2, URIHandler paramURIHandler)
  {
    ArrayList localArrayList = this.val$paths;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("://");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(">");
    localStringBuilder.append(paramURIHandler.toString());
    localArrayList.add(localStringBuilder.toString());
    this.this$0.register(paramString1, paramString2, paramURIHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.Router.1
 * JD-Core Version:    0.7.0.1
 */