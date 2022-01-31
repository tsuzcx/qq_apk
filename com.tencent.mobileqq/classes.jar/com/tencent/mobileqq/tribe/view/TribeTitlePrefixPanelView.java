package com.tencent.mobileqq.tribe.view;

import aiyk;
import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class TribeTitlePrefixPanelView
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private aiyk jdField_a_of_type_Aiyk;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  
  public TribeTitlePrefixPanelView(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Aiyk = new aiyk(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Aiyk);
  }
  
  public void a(TribeTitlePrefixPanelView.PrefixSelectedListener paramPrefixSelectedListener)
  {
    if (this.jdField_a_of_type_Aiyk != null) {
      this.jdField_a_of_type_Aiyk.a(paramPrefixSelectedListener);
    }
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_Aiyk != null) {
      this.jdField_a_of_type_Aiyk.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView
 * JD-Core Version:    0.7.0.1
 */