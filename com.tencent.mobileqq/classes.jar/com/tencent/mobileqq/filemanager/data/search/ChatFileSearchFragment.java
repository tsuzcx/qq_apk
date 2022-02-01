package com.tencent.mobileqq.filemanager.data.search;

import amtj;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import asmb;
import baum;
import bbfe;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
  
  public baum a()
  {
    return new asmb(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public bbfe a()
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
  
  public void g_(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        f_(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    super.g_(paramBoolean);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_Int == 2)
    {
      ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
      paramViewGroup = new TextView(getActivity());
      paramViewGroup.setText(amtj.a(2131700732));
      paramViewGroup.setSingleLine(true);
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      paramViewGroup.setTextSize(1, 15.0F);
      paramViewGroup.setTextColor(getResources().getColor(2131167098));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramViewGroup);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */