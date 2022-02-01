package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;

public class SingleSoLoader
  implements ISoLoader
{
  private SoLoaderLogic a = new SoLoaderLogic();
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    SoLoaderLogic localSoLoaderLogic = this.a;
    if (localSoLoaderLogic == null) {
      return null;
    }
    return localSoLoaderLogic.a(paramLoadParam);
  }
  
  public void a(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    SoLoaderLogic localSoLoaderLogic = this.a;
    if (localSoLoaderLogic != null) {
      localSoLoaderLogic.a(paramLoadParam, paramOnLoadListener);
    }
  }
  
  public boolean a(String paramString)
  {
    SoLoaderLogic localSoLoaderLogic = this.a;
    return (localSoLoaderLogic != null) && (localSoLoaderLogic.a(paramString));
  }
  
  public void b(String paramString)
  {
    SoLoaderLogic localSoLoaderLogic = this.a;
    if (localSoLoaderLogic != null) {
      localSoLoaderLogic.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SingleSoLoader
 * JD-Core Version:    0.7.0.1
 */