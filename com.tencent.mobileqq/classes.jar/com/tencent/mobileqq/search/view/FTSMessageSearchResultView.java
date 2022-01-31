package com.tencent.mobileqq.search.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FTSMessageSearchResultView
  extends SearchResultView
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public FTSMessageSearchResultView(View paramView)
  {
    super(paramView);
  }
  
  public FTSMessageSearchResultView(ViewGroup paramViewGroup, int paramInt)
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
    this.a = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131375070));
    this.b = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131375071));
    this.c = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131375072));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131375069));
  }
  
  public TextView b()
  {
    return this.b;
  }
  
  public TextView c()
  {
    return this.c;
  }
  
  public TextView d()
  {
    return this.jdField_d_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.FTSMessageSearchResultView
 * JD-Core Version:    0.7.0.1
 */