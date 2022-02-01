package com.tencent.mobileqq.datareportviewer;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import anzj;
import aryz;
import arza;
import arzb;
import arzc;
import arzf;
import arzg;
import arzx;
import bihu;
import bihw;
import bihz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  protected ListView a;
  public arzg a;
  protected FormSwitchItem a;
  public ArrayList<aryz> a;
  protected FormSwitchItem b;
  
  protected void a()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    bihu localbihu = new bihu("https://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localbihu.d = 60L;
    ((bihw)getActivity().app.getManager(47)).a(1).a(localbihu, new arzf(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131366058));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131363069));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131377458));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(arzx.a().a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new arza(this));
    this.b.setOnCheckedChangeListener(new arzb(this));
    setRightButton(2131689551, new arzc(this));
    this.jdField_a_of_type_JavaUtilArrayList = arzx.a().a();
    this.jdField_a_of_type_Arzg = new arzg(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Arzg);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559607;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(anzj.a(2131701674));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */