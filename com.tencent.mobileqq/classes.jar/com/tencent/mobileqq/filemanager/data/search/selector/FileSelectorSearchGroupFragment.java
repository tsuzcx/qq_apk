package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import atqy;
import atqz;
import atrb;
import auft;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.widget.ListView;

public class FileSelectorSearchGroupFragment
  extends IphoneTitleBarFragment
{
  private static atrb jdField_a_of_type_Atrb;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private atqz jdField_a_of_type_Atqz;
  private auft jdField_a_of_type_Auft;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  
  private String a()
  {
    if (jdField_a_of_type_Atrb != null) {
      return String.format(getString(2131692378), new Object[] { Integer.valueOf(jdField_a_of_type_Atrb.d()), jdField_a_of_type_Atrb.a() });
    }
    return "";
  }
  
  public static void a(atrb paramatrb)
  {
    jdField_a_of_type_Atrb = paramatrb;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RelativeLayout)this.mContentView;
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370180));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new atqy(this));
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131368149);
    paramViewGroup = new QFileSendBottomView(paramLayoutInflater.getContext());
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    paramLayoutInflater.addView(paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = getArguments().getBundle("qfile_search_param_ex_params");
    this.jdField_a_of_type_Auft = auft.a(getActivity().app, getActivity(), paramViewGroup, this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Auft.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Auft.b();
    this.jdField_a_of_type_Auft.a(this.jdField_a_of_type_AndroidOsBundle);
    paramViewGroup.a(this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  public int getContentLayoutId()
  {
    return 2131560856;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    jdField_a_of_type_Atrb = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    setTitle(jdField_a_of_type_Atrb.d());
    super.onViewCreated(paramView, paramBundle);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368115)).setText(a());
    this.jdField_a_of_type_Atqz = new atqz(this, jdField_a_of_type_Atrb);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Atqz);
    this.jdField_a_of_type_Auft.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment
 * JD-Core Version:    0.7.0.1
 */