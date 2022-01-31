package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmini.sdk.log.QMLog;

public class MoreItemView
  extends LinearLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MoreItem jdField_a_of_type_ComTencentQqminiSdkUiMoreItem;
  
  public MoreItemView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    View localView = inflate(getContext(), 2131559354, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370743));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370745));
  }
  
  public MoreItem a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItem;
  }
  
  public void a(MoreItem paramMoreItem)
  {
    if (paramMoreItem == null)
    {
      QMLog.w("MoreItemView", "bind. Failed to bind data. MoreItem is null");
      return;
    }
    if ((paramMoreItem.b == 0) || (paramMoreItem.jdField_a_of_type_JavaLangString == null))
    {
      QMLog.w("MoreItemView", "bind. Failed to bind data. MoreItem is null");
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkUiMoreItem = paramMoreItem;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MoreItemView
 * JD-Core Version:    0.7.0.1
 */