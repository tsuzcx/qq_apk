package com.tencent.mobileqq.datareportviewer;

import alud;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import apgp;
import apgq;
import apgr;
import apgs;
import apgv;
import apgw;
import aphn;
import beae;
import beag;
import beaj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  protected ListView a;
  public apgw a;
  protected FormSwitchItem a;
  public ArrayList<apgp> a;
  protected FormSwitchItem b;
  
  protected void a()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    beae localbeae = new beae("http://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localbeae.d = 60L;
    ((beag)getActivity().app.getManager(47)).a(1).a(localbeae, new apgv(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131365770));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131362935));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131376528));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(aphn.a().a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new apgq(this));
    this.b.setOnCheckedChangeListener(new apgr(this));
    setRightButton(2131689628, new apgs(this));
    this.jdField_a_of_type_JavaUtilArrayList = aphn.a().a();
    this.jdField_a_of_type_Apgw = new apgw(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Apgw);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559470;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(alud.a(2131703160));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */