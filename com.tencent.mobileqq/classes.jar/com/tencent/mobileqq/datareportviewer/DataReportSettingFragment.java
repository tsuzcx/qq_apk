package com.tencent.mobileqq.datareportviewer;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import anvx;
import arwk;
import arwl;
import arwm;
import arwn;
import arwq;
import arwr;
import arxi;
import bhyo;
import bhyq;
import bhyt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  protected ListView a;
  public arwr a;
  protected FormSwitchItem a;
  public ArrayList<arwk> a;
  protected FormSwitchItem b;
  
  protected void a()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    bhyo localbhyo = new bhyo("https://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localbhyo.d = 60L;
    ((bhyq)getActivity().app.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).a(localbhyo, new arwq(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131366190));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131363103));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131377494));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(arxi.a().a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new arwl(this));
    this.b.setOnCheckedChangeListener(new arwm(this));
    setRightButton(2131689550, new arwn(this));
    this.jdField_a_of_type_JavaUtilArrayList = arxi.a().a();
    this.jdField_a_of_type_Arwr = new arwr(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Arwr);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559644;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(anvx.a(2131702260));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */