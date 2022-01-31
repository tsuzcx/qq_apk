package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactSearchResultView
  extends SearchResultView
{
  private TextView a;
  
  public ContactSearchResultView(View paramView)
  {
    super(paramView);
  }
  
  public ContactSearchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public TextView a()
  {
    return this.a;
  }
  
  protected void a()
  {
    super.a();
    this.a = ((TextView)this.d.findViewById(2131363522));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.ContactSearchResultView
 * JD-Core Version:    0.7.0.1
 */