package com.tencent.mobileqq.search.view;

import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;

public class MiniProgramSearchResultView
  extends SearchResultView
{
  protected TextView a;
  protected URLImageView a;
  
  public MiniProgramSearchResultView(View paramView)
  {
    super(paramView);
  }
  
  public URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.b.findViewById(2131378221));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.b.findViewById(2131379511));
  }
  
  public TextView e()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.MiniProgramSearchResultView
 * JD-Core Version:    0.7.0.1
 */