package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apfx;
import apfy;
import apga;
import apxh;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.widget.ListView;

public class FileSelectorSearchGroupFragment
  extends IphoneTitleBarFragment
{
  private static apga jdField_a_of_type_Apga;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private apfy jdField_a_of_type_Apfy;
  private apxh jdField_a_of_type_Apxh;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  
  private String a()
  {
    if (jdField_a_of_type_Apga != null) {
      return String.format(getString(2131692571), new Object[] { Integer.valueOf(jdField_a_of_type_Apga.d()), jdField_a_of_type_Apga.a() });
    }
    return "";
  }
  
  public static void a(apga paramapga)
  {
    jdField_a_of_type_Apga = paramapga;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RelativeLayout)this.mContentView;
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131369266));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new apfx(this));
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131367465);
    paramViewGroup = new QFileSendBottomView(paramLayoutInflater.getContext());
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    paramLayoutInflater.addView(paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = getArguments().getBundle("qfile_search_param_ex_params");
    this.jdField_a_of_type_Apxh = apxh.a(getActivity().app, getActivity(), paramViewGroup, this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Apxh.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Apxh.b();
    this.jdField_a_of_type_Apxh.a(this.jdField_a_of_type_AndroidOsBundle);
    paramViewGroup.a(this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  public int getContentLayoutId()
  {
    return 2131560487;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    jdField_a_of_type_Apga = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    setTitle(jdField_a_of_type_Apga.d());
    super.onViewCreated(paramView, paramBundle);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367427)).setText(a());
    this.jdField_a_of_type_Apfy = new apfy(this, jdField_a_of_type_Apga);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Apfy);
    this.jdField_a_of_type_Apxh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment
 * JD-Core Version:    0.7.0.1
 */