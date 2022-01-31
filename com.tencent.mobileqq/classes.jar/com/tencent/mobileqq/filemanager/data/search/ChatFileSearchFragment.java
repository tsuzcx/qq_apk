package com.tencent.mobileqq.filemanager.data.search;

import ajya;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import apfg;
import awke;
import awuu;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;

public class ChatFileSearchFragment
  extends FileSearchFragment
{
  public int a;
  Runnable a;
  public String a;
  public List<Integer> a;
  public int b;
  
  public ChatFileSearchFragment()
  {
    this.jdField_a_of_type_JavaLangRunnable = new ChatFileSearchFragment.1(this);
  }
  
  public awke a()
  {
    return new apfg(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Baxy, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public awuu a()
  {
    ChatFileManagerSearchEngine localChatFileManagerSearchEngine = new ChatFileManagerSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
    if (this.jdField_a_of_type_Int == 1)
    {
      localBundle = new Bundle();
      localBundle.putString("qfile_search_param_uin", this.jdField_a_of_type_JavaLangString);
      localChatFileManagerSearchEngine.a(3, localBundle);
    }
    while (this.jdField_a_of_type_Int != 2) {
      return localChatFileManagerSearchEngine;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("qfile_search_param_uin", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("qfile_search_param_type", this.jdField_b_of_type_Int);
    localBundle.putIntegerArrayList("qfile_search_param_others", (ArrayList)this.jdField_a_of_type_JavaUtilList);
    localChatFileManagerSearchEngine.a(4, localBundle);
    return localChatFileManagerSearchEngine;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void h_(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        g_(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    super.h_(paramBoolean);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_Int == 2)
    {
      ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
      paramViewGroup = new TextView(getActivity());
      paramViewGroup.setText(ajya.a(2131701585));
      paramViewGroup.setSingleLine(true);
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      paramViewGroup.setTextSize(1, 15.0F);
      paramViewGroup.setTextColor(getResources().getColor(2131166933));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramViewGroup);
    }
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */