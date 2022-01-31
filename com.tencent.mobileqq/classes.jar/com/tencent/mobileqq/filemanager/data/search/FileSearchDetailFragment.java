package com.tencent.mobileqq.filemanager.data.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aqyg;
import aqyi;
import ayfe;
import bcws;
import com.tencent.widget.ListView;
import java.util.List;

public class FileSearchDetailFragment
  extends Fragment
{
  private static aqyg b;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aqyg jdField_a_of_type_Aqyg;
  ayfe jdField_a_of_type_Ayfe;
  public bcws a;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString;
  
  public static FileSearchDetailFragment a(String paramString, aqyg paramaqyg)
  {
    b = paramaqyg;
    paramaqyg = new FileSearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString);
    paramaqyg.setArguments(localBundle);
    return paramaqyg;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Aqyg = b;
    b = null;
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
    paramView = getString(2131692647);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(paramView, new Object[] { Integer.valueOf(this.jdField_a_of_type_Aqyg.a.size()), this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_Bcws = new bcws(getActivity(), getActivity().app);
    this.jdField_a_of_type_Ayfe = new aqyi(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bcws, this.jdField_a_of_type_Aqyg, this.jdField_a_of_type_JavaLangString, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Ayfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */