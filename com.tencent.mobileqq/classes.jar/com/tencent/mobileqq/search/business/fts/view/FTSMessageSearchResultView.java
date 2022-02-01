package com.tencent.mobileqq.search.business.fts.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultView;

public class FTSMessageSearchResultView
  extends SearchResultView
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView h;
  
  public FTSMessageSearchResultView(View paramView)
  {
    super(paramView);
  }
  
  public FTSMessageSearchResultView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    this.a = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377245));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377244));
    this.c = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377243));
    this.h = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377114));
  }
  
  public TextView e()
  {
    return this.a;
  }
  
  public TextView f()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public TextView g()
  {
    return this.c;
  }
  
  public TextView h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.fts.view.FTSMessageSearchResultView
 * JD-Core Version:    0.7.0.1
 */