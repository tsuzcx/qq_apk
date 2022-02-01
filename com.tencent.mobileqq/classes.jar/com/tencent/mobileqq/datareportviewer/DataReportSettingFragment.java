package com.tencent.mobileqq.datareportviewer;

import amtj;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import aqsw;
import aqsx;
import aqsy;
import aqsz;
import aqtc;
import aqtd;
import aqtu;
import bgoe;
import bgog;
import bgoj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  protected ListView a;
  public aqtd a;
  protected FormSwitchItem a;
  public ArrayList<aqsw> a;
  protected FormSwitchItem b;
  
  protected void a()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    bgoe localbgoe = new bgoe("https://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localbgoe.d = 60L;
    ((bgog)getActivity().app.getManager(47)).a(1).a(localbgoe, new aqtc(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131366088));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131363086));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131377221));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(aqtu.a().a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aqsx(this));
    this.b.setOnCheckedChangeListener(new aqsy(this));
    setRightButton(2131689550, new aqsz(this));
    this.jdField_a_of_type_JavaUtilArrayList = aqtu.a().a();
    this.jdField_a_of_type_Aqtd = new aqtd(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Aqtd);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559609;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(amtj.a(2131701909));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */