package com.tencent.mobileqq.search.fragment;

import ahtk;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.search.adapter.BaseMvpMessageAdapter;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;
import java.util.List;

public class MessageSearchDetailFragment
  extends Fragment
{
  private static FullMessageSearchResult.SearchResultItem jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseMvpMessageAdapter jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpMessageAdapter;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
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
    paramLayoutInflater = paramLayoutInflater.inflate(2130969068, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364975));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131364045));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131438146, new Object[] { Integer.valueOf(this.b.secondPageMessageUniseq.size()), this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getActivity(), getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpMessageAdapter = new ahtk(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.b, this.jdField_a_of_type_JavaLangString, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpMessageAdapter);
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpMessageAdapter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */