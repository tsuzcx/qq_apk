package com.tencent.mobileqq.nearby.now.model;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

public abstract class BasePlayListDataModel
{
  protected int a;
  protected boolean b = false;
  public AppInterface c;
  protected ArrayList<VideoData> d = new ArrayList();
  protected BasePlayListDataModel.OnDataComeListener e;
  
  public ArrayList<VideoData> a()
  {
    return this.d;
  }
  
  public abstract void a(Bundle paramBundle);
  
  public void a(BasePlayListDataModel.OnDataComeListener paramOnDataComeListener)
  {
    this.e = paramOnDataComeListener;
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b()
  {
    if (this.b) {}
  }
  
  public void c() {}
  
  public int d()
  {
    return this.a;
  }
  
  public boolean e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel
 * JD-Core Version:    0.7.0.1
 */