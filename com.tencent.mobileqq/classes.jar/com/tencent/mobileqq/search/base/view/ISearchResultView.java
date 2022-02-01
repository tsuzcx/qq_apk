package com.tencent.mobileqq.search.base.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public abstract interface ISearchResultView
  extends IFaceView
{
  public abstract View a(String paramString);
  
  public abstract ImageView a();
  
  public abstract TextView a();
  
  public abstract TextView b();
  
  public abstract TextView c();
  
  public abstract TextView d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.view.ISearchResultView
 * JD-Core Version:    0.7.0.1
 */