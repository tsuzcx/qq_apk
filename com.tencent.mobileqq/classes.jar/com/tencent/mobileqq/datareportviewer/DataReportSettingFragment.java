package com.tencent.mobileqq.datareportviewer;

import alpo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import apcg;
import apch;
import apci;
import apcj;
import apcm;
import apcn;
import apde;
import bdvv;
import bdvx;
import bdwa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  protected ListView a;
  public apcn a;
  protected FormSwitchItem a;
  public ArrayList<apcg> a;
  protected FormSwitchItem b;
  
  protected void a()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    bdvv localbdvv = new bdvv("http://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localbdvv.d = 60L;
    ((bdvx)getActivity().app.getManager(47)).a(1).a(localbdvv, new apcm(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131365768));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131362935));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131376474));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(apde.a().a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new apch(this));
    this.b.setOnCheckedChangeListener(new apci(this));
    setRightButton(2131689628, new apcj(this));
    this.jdField_a_of_type_JavaUtilArrayList = apde.a().a();
    this.jdField_a_of_type_Apcn = new apcn(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Apcn);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559471;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(alpo.a(2131703148));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */