package com.tencent.mobileqq.filemanager.data.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.text.QQTextBuilder;

public class FileSearchResultView
  implements ISearchResultView
{
  protected int a;
  protected View a;
  protected ImageView a;
  protected TextView a;
  protected TextView b;
  
  public FileSearchResultView() {}
  
  public FileSearchResultView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Int = 2131562980;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(this.jdField_a_of_type_Int, paramViewGroup, false);
    a();
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
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368729));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379432));
    this.jdField_a_of_type_AndroidWidgetTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365699));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131379511).setVisibility(8);
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
    return this.b;
  }
  
  public TextView d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchResultView
 * JD-Core Version:    0.7.0.1
 */