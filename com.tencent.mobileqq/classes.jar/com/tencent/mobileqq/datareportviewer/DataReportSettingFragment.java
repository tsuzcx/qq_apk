package com.tencent.mobileqq.datareportviewer;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import anni;
import arjk;
import arjl;
import arjm;
import arjn;
import arjq;
import arjr;
import arki;
import bhhf;
import bhhh;
import bhhk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  protected ListView a;
  public arjr a;
  protected FormSwitchItem a;
  public ArrayList<arjk> a;
  protected FormSwitchItem b;
  
  protected void a()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    bhhf localbhhf = new bhhf("https://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localbhhf.d = 60L;
    ((bhhh)getActivity().app.getManager(47)).a(1).a(localbhhf, new arjq(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131366012));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131363048));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131377318));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(arki.a().a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new arjl(this));
    this.b.setOnCheckedChangeListener(new arjm(this));
    setRightButton(2131689550, new arjn(this));
    this.jdField_a_of_type_JavaUtilArrayList = arki.a().a();
    this.jdField_a_of_type_Arjr = new arjr(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Arjr);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559602;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(anni.a(2131701567));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */