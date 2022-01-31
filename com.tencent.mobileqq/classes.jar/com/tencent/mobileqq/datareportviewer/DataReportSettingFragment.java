package com.tencent.mobileqq.datareportviewer;

import ajyc;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import anku;
import ankv;
import ankw;
import ankx;
import anla;
import anlb;
import anls;
import bbwg;
import bbwi;
import bbwl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  protected ListView a;
  public anlb a;
  protected FormSwitchItem a;
  public ArrayList<anku> a;
  protected FormSwitchItem b;
  
  protected void a()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    bbwg localbbwg = new bbwg("http://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localbbwg.d = 60L;
    ((bbwi)getActivity().app.getManager(47)).a(1).a(localbbwg, new anla(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131365685));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131362901));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131375973));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(anls.a().a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new ankv(this));
    this.b.setOnCheckedChangeListener(new ankw(this));
    setRightButton(2131689628, new ankx(this));
    this.jdField_a_of_type_JavaUtilArrayList = anls.a().a();
    this.jdField_a_of_type_Anlb = new anlb(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Anlb);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559419;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(ajyc.a(2131702765));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */