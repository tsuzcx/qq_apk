package com.tencent.mobileqq.search.business.contact.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultView;

public class ContactSearchResultView
  extends SearchResultView
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.b.findViewById(2131377636));
    this.jdField_a_of_type_AndroidViewView = this.b.findViewById(2131379859);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
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
  
  public TextView e()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView
 * JD-Core Version:    0.7.0.1
 */