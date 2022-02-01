package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

public class FileSearchDetailFragment
  extends ReportV4Fragment
{
  private static FileEntitySearchResultModel b;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  FileEntitySearchResultModel jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel;
  BaseMvpAdapter jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString;
  
  public static FileSearchDetailFragment a(String paramString, FileEntitySearchResultModel paramFileEntitySearchResultModel)
  {
    b = paramFileEntitySearchResultModel;
    paramFileEntitySearchResultModel = new FileSearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString);
    paramFileEntitySearchResultModel.setArguments(localBundle);
    return paramFileEntitySearchResultModel;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel = b;
    b = null;
    this.jdField_a_of_type_JavaLangString = getArguments().getString("keyword");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559457, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131368336));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370452));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getString(2131692510);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(paramView, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel.a.size()), this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)getActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter = new FileSearchDetailFragment.FileSearchAdapter(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel, this.jdField_a_of_type_JavaLangString, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */