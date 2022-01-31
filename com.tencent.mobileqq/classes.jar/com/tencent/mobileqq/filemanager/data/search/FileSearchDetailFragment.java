package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import apfi;
import apfk;
import awke;
import baxy;
import com.tencent.widget.ListView;
import java.util.List;

public class FileSearchDetailFragment
  extends Fragment
{
  private static apfi b;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  apfi jdField_a_of_type_Apfi;
  awke jdField_a_of_type_Awke;
  public baxy a;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString;
  
  public static FileSearchDetailFragment a(String paramString, apfi paramapfi)
  {
    b = paramapfi;
    paramapfi = new FileSearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString);
    paramapfi.setArguments(localBundle);
    return paramapfi;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Apfi = b;
    b = null;
    this.jdField_a_of_type_JavaLangString = getArguments().getString("keyword");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559210, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367427));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131369266));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getString(2131692571);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(paramView, new Object[] { Integer.valueOf(this.jdField_a_of_type_Apfi.a.size()), this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_Baxy = new baxy(getActivity(), getActivity().app);
    this.jdField_a_of_type_Awke = new apfk(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Baxy, this.jdField_a_of_type_Apfi, this.jdField_a_of_type_JavaLangString, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Awke);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */