package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;

public class SingleSoLoader
  implements ISoLoader
{
  private DownSoLoader a = new DownSoLoader();
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.a(paramLoadParam);
  }
  
  public void a(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    if (this.a != null) {
      this.a.a(paramLoadParam, paramOnLoadListener);
    }
  }
  
  public void a(String paramString)
  {
    if (this.a != null) {
      this.a.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return (this.a != null) && (this.a.a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SingleSoLoader
 * JD-Core Version:    0.7.0.1
 */