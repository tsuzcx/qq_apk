package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import betc;

public class MoreItemView
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public MoreItemView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    View localView = inflate(getContext(), 2131559306, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370418));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370420));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(MoreItem paramMoreItem)
  {
    if (paramMoreItem == null)
    {
      betc.c("MoreItemView", "bind. Failed to bind data. MoreItem is null");
      return;
    }
    if ((paramMoreItem.b == 0) || (paramMoreItem.jdField_a_of_type_JavaLangString == null))
    {
      betc.c("MoreItemView", "bind. Failed to bind data. MoreItem is null");
      return;
    }
    this.jdField_a_of_type_Int = paramMoreItem.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(paramMoreItem.b));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMoreItem.jdField_a_of_type_JavaLangString);
    if (paramMoreItem.jdField_a_of_type_Boolean) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MoreItemView
 * JD-Core Version:    0.7.0.1
 */