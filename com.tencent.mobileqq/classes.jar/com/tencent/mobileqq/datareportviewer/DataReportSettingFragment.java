package com.tencent.mobileqq.datareportviewer;

import ajya;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import ankz;
import anla;
import anlb;
import anlc;
import anlf;
import anlg;
import anlx;
import bbwu;
import bbww;
import bbwz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  protected ListView a;
  public anlg a;
  protected FormSwitchItem a;
  public ArrayList<ankz> a;
  protected FormSwitchItem b;
  
  protected void a()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    bbwu localbbwu = new bbwu("http://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localbbwu.d = 60L;
    ((bbww)getActivity().app.getManager(47)).a(1).a(localbbwu, new anlf(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131365684));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131362900));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131375975));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(anlx.a().a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new anla(this));
    this.b.setOnCheckedChangeListener(new anlb(this));
    setRightButton(2131689628, new anlc(this));
    this.jdField_a_of_type_JavaUtilArrayList = anlx.a().a();
    this.jdField_a_of_type_Anlg = new anlg(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Anlg);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559419;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(ajya.a(2131702776));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */