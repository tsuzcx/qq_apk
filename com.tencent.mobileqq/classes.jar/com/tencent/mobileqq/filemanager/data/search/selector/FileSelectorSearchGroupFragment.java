package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import auai;
import auaj;
import aual;
import aupe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.widget.ListView;

public class FileSelectorSearchGroupFragment
  extends IphoneTitleBarFragment
{
  private static aual jdField_a_of_type_Aual;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private auaj jdField_a_of_type_Auaj;
  private aupe jdField_a_of_type_Aupe;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  
  private String a()
  {
    if (jdField_a_of_type_Aual != null) {
      return String.format(getString(2131692240), new Object[] { Integer.valueOf(jdField_a_of_type_Aual.d()), jdField_a_of_type_Aual.a() });
    }
    return "";
  }
  
  public static void a(aual paramaual)
  {
    jdField_a_of_type_Aual = paramaual;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RelativeLayout)this.mContentView;
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370012));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new auai(this));
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131367981);
    paramViewGroup = new QFileSendBottomView(paramLayoutInflater.getContext());
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    paramLayoutInflater.addView(paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = getArguments().getBundle("qfile_search_param_ex_params");
    this.jdField_a_of_type_Aupe = aupe.a(getActivity().app, getActivity(), paramViewGroup, this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Aupe.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Aupe.b();
    this.jdField_a_of_type_Aupe.a(this.jdField_a_of_type_AndroidOsBundle);
    paramViewGroup.a(this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  public int getContentLayoutId()
  {
    return 2131560916;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    jdField_a_of_type_Aual = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    setTitle(jdField_a_of_type_Aual.d());
    super.onViewCreated(paramView, paramBundle);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367946)).setText(a());
    this.jdField_a_of_type_Auaj = new auaj(this, jdField_a_of_type_Aual);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Auaj);
    this.jdField_a_of_type_Aupe.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment
 * JD-Core Version:    0.7.0.1
 */