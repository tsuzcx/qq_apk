package com.tencent.mobileqq.filemanager.data.search;

import adaw;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;
import java.util.List;

public class FileSearchDetailFragment
  extends Fragment
{
  private static FileEntitySearchResultModel b;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FileEntitySearchResultModel jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel;
  BaseMvpAdapter jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter;
  public FaceDecoder a;
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%d条与\"%s\"相关的同名文件记录", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel.a.size()), this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getActivity(), getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter = new adaw(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel, this.jdField_a_of_type_JavaLangString, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */