package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aoof;
import bcbk;
import bcct;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

public class MessageSearchDetailFragment
  extends ReportV4Fragment
{
  private static FullMessageSearchResult.SearchResultItem jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoof jdField_a_of_type_Aoof;
  private bcbk jdField_a_of_type_Bcbk;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private FullMessageSearchResult.SearchResultItem b;
  
  public static MessageSearchDetailFragment a(String paramString, FullMessageSearchResult.SearchResultItem paramSearchResultItem)
  {
    jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem = paramSearchResultItem;
    paramSearchResultItem = new MessageSearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString);
    paramSearchResultItem.setArguments(localBundle);
    return paramSearchResultItem;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem;
    jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem = null;
    this.jdField_a_of_type_JavaLangString = getArguments().getString("keyword");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559338, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367946));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370012));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if ((this.b == null) || (this.b.secondPageMessageUniseq == null)) {}
    for (int i = 0;; i = this.b.secondPageMessageUniseq.size())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131717750, new Object[] { Integer.valueOf(i), this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Aoof = new aoof(getActivity(), getActivity().app);
      this.jdField_a_of_type_Bcbk = new bcct(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Aoof, this.b, this.jdField_a_of_type_JavaLangString, getActivity().app);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Bcbk);
      this.jdField_a_of_type_Bcbk.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */