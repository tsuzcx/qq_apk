package com.tencent.mobileqq.datareportviewer;

import ajjy;
import amum;
import amun;
import amuo;
import amup;
import amus;
import amut;
import amvk;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import batm;
import bato;
import batr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  public amut a;
  protected ListView a;
  protected FormSwitchItem a;
  public ArrayList<amum> a;
  protected FormSwitchItem b;
  
  protected void a()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    batm localbatm = new batm("http://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localbatm.d = 60L;
    ((bato)getActivity().app.getManager(47)).a(1).a(localbatm, new amus(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131300088));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131297361));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131310206));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(amvk.a().a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new amun(this));
    this.b.setOnCheckedChangeListener(new amuo(this));
    setRightButton(2131624088, new amup(this));
    this.jdField_a_of_type_JavaUtilArrayList = amvk.a().a();
    this.jdField_a_of_type_Amut = new amut(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Amut);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131493851;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(ajjy.a(2131636981));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */