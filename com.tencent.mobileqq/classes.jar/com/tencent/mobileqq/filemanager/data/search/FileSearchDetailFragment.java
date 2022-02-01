package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aoof;
import atzt;
import atzv;
import bcbi;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

public class FileSearchDetailFragment
  extends ReportV4Fragment
{
  private static atzt b;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public aoof a;
  atzt jdField_a_of_type_Atzt;
  bcbi jdField_a_of_type_Bcbi;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString;
  
  public static FileSearchDetailFragment a(String paramString, atzt paramatzt)
  {
    b = paramatzt;
    paramatzt = new FileSearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString);
    paramatzt.setArguments(localBundle);
    return paramatzt;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Atzt = b;
    b = null;
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
    paramView = getString(2131692240);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(paramView, new Object[] { Integer.valueOf(this.jdField_a_of_type_Atzt.a.size()), this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_Aoof = new aoof(getActivity(), getActivity().app);
    this.jdField_a_of_type_Bcbi = new atzv(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Aoof, this.jdField_a_of_type_Atzt, this.jdField_a_of_type_JavaLangString, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Bcbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */