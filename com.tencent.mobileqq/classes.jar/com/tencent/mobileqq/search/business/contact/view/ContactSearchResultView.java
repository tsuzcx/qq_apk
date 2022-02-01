package com.tencent.mobileqq.search.business.contact.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultView;

public class ContactSearchResultView
  extends SearchResultView
{
  private TextView a;
  private View b;
  
  public ContactSearchResultView(View paramView)
  {
    super(paramView);
  }
  
  public ContactSearchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    this.a = ((TextView)this.e.findViewById(2131446045));
    this.b = this.e.findViewById(2131448716);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.b;
    if (localView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
  
  public TextView k()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView
 * JD-Core Version:    0.7.0.1
 */