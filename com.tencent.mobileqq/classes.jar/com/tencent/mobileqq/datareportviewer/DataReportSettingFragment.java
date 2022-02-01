package com.tencent.mobileqq.datareportviewer;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import java.util.ArrayList;

public class DataReportSettingFragment
  extends IphoneTitleBarFragment
{
  protected ListView a;
  protected DataReportSettingFragment.DataAdapter a;
  protected FormSwitchItem a;
  protected ArrayList<BaseReportDataConfig> a;
  protected FormSwitchItem b;
  
  protected void a()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
    DownloadTask localDownloadTask = new DownloadTask("https://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
    localDownloadTask.d = 60L;
    ((DownloaderFactory)getActivity().app.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).a(localDownloadTask, new DataReportSettingFragment.4(this, str), new Bundle());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131366361));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131363148));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.mContentView.findViewById(2131377909));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(DataReportViewerFloatViewHelper.a().a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new DataReportSettingFragment.1(this));
    this.b.setOnCheckedChangeListener(new DataReportSettingFragment.2(this));
    setRightButton(2131689557, new DataReportSettingFragment.3(this));
    this.jdField_a_of_type_JavaUtilArrayList = DataReportViewerFloatViewHelper.a().a();
    this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment$DataAdapter = new DataReportSettingFragment.DataAdapter(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment$DataAdapter);
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559720;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(HardCodeUtil.a(2131702808));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */