package com.tencent.mobileqq.datareportviewer;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mobileqq.app.BaseActivity;
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
  protected FormSwitchItem a;
  protected FormSwitchItem b;
  protected ListView c;
  protected ArrayList<BaseReportDataConfig> d;
  protected DataReportSettingFragment.DataAdapter e;
  
  protected void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append("/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json");
    localObject = ((StringBuilder)localObject).toString();
    DownloadTask localDownloadTask = new DownloadTask("https://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File((String)localObject));
    localDownloadTask.u = 60L;
    ((DownloaderFactory)getBaseActivity().app.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload(localDownloadTask, new DataReportSettingFragment.4(this, (String)localObject), new Bundle());
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((FormSwitchItem)this.mContentView.findViewById(2131432539));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131428941));
    this.c = ((ListView)this.mContentView.findViewById(2131445724));
    this.a.setChecked(DataReportViewerFloatViewHelper.a().f());
    this.a.setOnCheckedChangeListener(new DataReportSettingFragment.1(this));
    this.b.setOnCheckedChangeListener(new DataReportSettingFragment.2(this));
    setRightButton(2131886199, new DataReportSettingFragment.3(this));
    this.d = DataReportViewerFloatViewHelper.a().g();
    this.e = new DataReportSettingFragment.DataAdapter(this);
    this.c.setAdapter(this.e);
    a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131625625;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(HardCodeUtil.a(2131900916));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment
 * JD-Core Version:    0.7.0.1
 */