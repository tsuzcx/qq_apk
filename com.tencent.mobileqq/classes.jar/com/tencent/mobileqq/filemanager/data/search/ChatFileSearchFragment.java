package com.tencent.mobileqq.filemanager.data.search;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
  
  protected BaseMvpAdapter a()
  {
    return new ChatFileSearchFragment.ChatFileSearchAdapter(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_JavaLangString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  protected ISearchEngine a()
  {
    ChatFileManagerSearchEngine localChatFileManagerSearchEngine = new ChatFileManagerSearchEngine((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.c);
    int i = this.jdField_a_of_type_Int;
    Bundle localBundle;
    if (i == 1)
    {
      localBundle = new Bundle();
      localBundle.putString("qfile_search_param_uin", this.jdField_a_of_type_JavaLangString);
      localChatFileManagerSearchEngine.a(3, localBundle);
      return localChatFileManagerSearchEngine;
    }
    if (i == 2)
    {
      localBundle = new Bundle();
      localBundle.putString("qfile_search_param_uin", this.jdField_a_of_type_JavaLangString);
      localBundle.putInt("qfile_search_param_type", this.jdField_b_of_type_Int);
      localBundle.putIntegerArrayList("qfile_search_param_others", (ArrayList)this.jdField_a_of_type_JavaUtilList);
      localChatFileManagerSearchEngine.a(4, localBundle);
    }
    return localChatFileManagerSearchEngine;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected void j_(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        c_(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    super.j_(paramBoolean);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_Int == 2)
    {
      ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
      paramViewGroup = new TextView(getQBaseActivity());
      paramViewGroup.setText(HardCodeUtil.a(2131701798));
      paramViewGroup.setSingleLine(true);
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      paramViewGroup.setTextSize(1, 15.0F);
      paramViewGroup.setTextColor(getResources().getColor(2131167144));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramViewGroup);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */