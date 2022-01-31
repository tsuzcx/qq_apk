package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqyv;
import aqyw;
import aqyy;
import arqj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.widget.ListView;

public class FileSelectorSearchGroupFragment
  extends IphoneTitleBarFragment
{
  private static aqyy jdField_a_of_type_Aqyy;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private aqyw jdField_a_of_type_Aqyw;
  private arqj jdField_a_of_type_Arqj;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  
  private String a()
  {
    if (jdField_a_of_type_Aqyy != null) {
      return String.format(getString(2131692647), new Object[] { Integer.valueOf(jdField_a_of_type_Aqyy.d()), jdField_a_of_type_Aqyy.a() });
    }
    return "";
  }
  
  public static void a(aqyy paramaqyy)
  {
    jdField_a_of_type_Aqyy = paramaqyy;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RelativeLayout)this.mContentView;
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131369501));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new aqyv(this));
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131367593);
    paramViewGroup = new QFileSendBottomView(paramLayoutInflater.getContext());
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    paramLayoutInflater.addView(paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = getArguments().getBundle("qfile_search_param_ex_params");
    this.jdField_a_of_type_Arqj = arqj.a(getActivity().app, getActivity(), paramViewGroup, this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Arqj.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Arqj.b();
    this.jdField_a_of_type_Arqj.a(this.jdField_a_of_type_AndroidOsBundle);
    paramViewGroup.a(this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  public int getContentLayoutId()
  {
    return 2131560663;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    jdField_a_of_type_Aqyy = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    setTitle(jdField_a_of_type_Aqyy.d());
    super.onViewCreated(paramView, paramBundle);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367555)).setText(a());
    this.jdField_a_of_type_Aqyw = new aqyw(this, jdField_a_of_type_Aqyy);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Aqyw);
    this.jdField_a_of_type_Arqj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment
 * JD-Core Version:    0.7.0.1
 */