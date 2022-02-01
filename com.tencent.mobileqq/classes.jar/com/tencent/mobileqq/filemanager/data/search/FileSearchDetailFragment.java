package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import atqj;
import atql;
import bcbc;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

public class FileSearchDetailFragment
  extends ReportV4Fragment
{
  private static atqj b;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  atqj jdField_a_of_type_Atqj;
  bcbc jdField_a_of_type_Bcbc;
  public FaceDecoder a;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString;
  
  public static FileSearchDetailFragment a(String paramString, atqj paramatqj)
  {
    b = paramatqj;
    paramatqj = new FileSearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString);
    paramatqj.setArguments(localBundle);
    return paramatqj;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Atqj = b;
    b = null;
    this.jdField_a_of_type_JavaLangString = getArguments().getString("keyword");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559390, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131368115));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370180));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getString(2131692378);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(paramView, new Object[] { Integer.valueOf(this.jdField_a_of_type_Atqj.a.size()), this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(getActivity(), getActivity().app);
    this.jdField_a_of_type_Bcbc = new atql(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this.jdField_a_of_type_Atqj, this.jdField_a_of_type_JavaLangString, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Bcbc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */