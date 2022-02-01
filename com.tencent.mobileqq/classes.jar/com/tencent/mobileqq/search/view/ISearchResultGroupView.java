package com.tencent.mobileqq.search.view;

import android.widget.TextView;
import java.util.List;

public abstract interface ISearchResultGroupView
  extends IView
{
  public abstract TextView a();
  
  public abstract List<ISearchResultView> a();
  
  public abstract TextView b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.ISearchResultGroupView
 * JD-Core Version:    0.7.0.1
 */