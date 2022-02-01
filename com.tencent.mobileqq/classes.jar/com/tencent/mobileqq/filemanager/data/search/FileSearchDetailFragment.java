package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

public class FileSearchDetailFragment
  extends BaseFragment
{
  private static FileEntitySearchResultModel b;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  FileEntitySearchResultModel jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel;
  BaseMvpAdapter jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter;
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559331, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131368087));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370110));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getString(2131692448);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(paramView, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel.a.size()), this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)getBaseActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(getBaseActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter = new FileSearchDetailFragment.FileSearchAdapter(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchFileEntitySearchResultModel, this.jdField_a_of_type_JavaLangString, getBaseActivity().app);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */