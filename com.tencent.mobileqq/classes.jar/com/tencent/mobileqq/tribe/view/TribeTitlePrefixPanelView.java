package com.tencent.mobileqq.tribe.view;

import aith;
import android.content.Context;
import android.widget.ListView;
import java.util.List;

public class TribeTitlePrefixPanelView
{
  private static String jdField_a_of_type_JavaLangString = "TribeTitlePrefixPanelView";
  private aith jdField_a_of_type_Aith;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  
  public TribeTitlePrefixPanelView(Context paramContext, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
    this.jdField_a_of_type_Aith = new aith(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Aith);
  }
  
  public void a(TribeTitlePrefixPanelView.PrefixSelectedListener paramPrefixSelectedListener)
  {
    if (this.jdField_a_of_type_Aith != null) {
      this.jdField_a_of_type_Aith.a(paramPrefixSelectedListener);
    }
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_Aith != null) {
      this.jdField_a_of_type_Aith.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView
 * JD-Core Version:    0.7.0.1
 */