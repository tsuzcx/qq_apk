package com.tencent.mobileqq.filemanager.data.search.selector;

import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

public class FileSelectorSearchResultView
  implements ISearchResultView
{
  private View jdField_a_of_type_AndroidViewView;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private EllipsizingTextView jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView;
  
  public FileSelectorSearchResultView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560822, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366781));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366792));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365517));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(1);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131366794));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public View a(String paramString)
  {
    return null;
  }
  
  public ImageView a()
  {
    return null;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView;
  }
  
  public ImageView b()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView b()
  {
    return null;
  }
  
  public TextView c()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public TextView d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchResultView
 * JD-Core Version:    0.7.0.1
 */