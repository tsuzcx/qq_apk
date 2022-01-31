package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ayfg;
import aygn;
import bcws;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.widget.ListView;
import java.util.List;

public class MessageSearchDetailFragment
  extends Fragment
{
  private static FullMessageSearchResult.SearchResultItem jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ayfg jdField_a_of_type_Ayfg;
  private bcws jdField_a_of_type_Bcws;
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559254, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367555));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131369501));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if ((this.b == null) || (this.b.secondPageMessageUniseq == null)) {}
    for (int i = 0;; i = this.b.secondPageMessageUniseq.size())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131719569, new Object[] { Integer.valueOf(i), this.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_Bcws = new bcws(getActivity(), getActivity().app);
      this.jdField_a_of_type_Ayfg = new aygn(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bcws, this.b, this.jdField_a_of_type_JavaLangString, getActivity().app);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Ayfg);
      this.jdField_a_of_type_Ayfg.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */