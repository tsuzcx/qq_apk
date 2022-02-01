package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.IQfileViewBinder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.filemanager.data.FileInfo;>;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QfileLocalFilePicTabView
  extends QfileBaseLocalFileTabView
{
  protected QfilePinnedHeaderExpandableListView.OnSelectListener M = new QfileLocalFilePicTabView.4(this);
  private IClickListenerVer51 a = null;
  private View.OnClickListener b = new QfileLocalFilePicTabView.5(this);
  private View.OnClickListener c = new QfileLocalFilePicTabView.6(this);
  QfileLocalImageExpandableListAdapter j;
  QfileBaseExpandableListAdapter.IQfileViewBinder k = null;
  
  public QfileLocalFilePicTabView(Context paramContext, List<QfileTabBarView.ScanParams> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    setEditbarButton(true, false, true, true, true);
    this.J = new QfileLocalFilePicTabView.1(this);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject2 = (ImageHolder)paramView.getTag();
    paramView = (FileInfo)((ImageHolder)localObject2).i;
    Object localObject1 = ((ImageHolder)localObject2).a;
    if (paramView == null) {
      return;
    }
    if ((this.C.F()) || (this.C.G()))
    {
      SharedPreferences.Editor localEditor = this.C.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      localEditor.putInt("GROUP", ((ImageHolder)localObject2).h);
      localEditor.putInt("CHILD", (((ImageHolder)localObject2).g + 1) / 4);
      localEditor.commit();
    }
    if (paramBoolean)
    {
      if (FMDataCache.a(paramView))
      {
        FMDataCache.c(paramView);
        b(paramView, false);
      }
      else
      {
        FMDataCache.b(paramView);
        b(paramView, true);
        if ((this.C.I()) && (!FMDataCache.c(FMDataCache.a)) && (!FMDataCache.d(paramView)))
        {
          localObject1 = DialogUtil.a(this.C, 2131896123);
          ((QQCustomDialog)localObject1).setPositiveButton(2131917392, new DialogUtil.DialogOnClickAdapter());
          ((QQCustomDialog)localObject1).show();
          FMDataCache.b(FMDataCache.a);
          FileManagerReporter.a("0X800942D");
        }
      }
      this.C.h(true);
      if ((this.C.l) && (!FileUtils.fileExistsAndNotEmpty(paramView.d())))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(QQFileManagerUtil.b(paramView.e()));
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131896095));
        FMToastUtil.a(((StringBuilder)localObject1).toString());
        FMDataCache.c(paramView);
      }
      e();
      C();
      h();
    }
    else
    {
      if (!v())
      {
        if (QLog.isColorLevel()) {
          QLog.i(o, 2, "click too fast , wait a minute.");
        }
        return;
      }
      if (B()) {
        ReportController.b(this.D, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      w();
      localObject2 = QQFileManagerUtil.a(paramView);
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openLocalFileViewBrowser(this.C, this.l, paramView, (View)localObject1, (FileManagerEntity)localObject2);
      localObject1 = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject1).b = "file_viewer_in";
      ((FileManagerReporter.FileAssistantReportData)localObject1).c = 80;
      ((FileManagerReporter.FileAssistantReportData)localObject1).d = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramView.e());
      ((FileManagerReporter.FileAssistantReportData)localObject1).e = paramView.f();
      FileManagerReporter.a(this.D.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject1);
      FileManagerReporter.a("0X8004AE5");
    }
    a(B());
  }
  
  private boolean a(FileInfo paramFileInfo, boolean paramBoolean)
  {
    if (paramFileInfo == null) {
      return false;
    }
    if ((B()) && (((FMDataCache.a(paramFileInfo)) && (paramBoolean)) || ((!FMDataCache.a(paramFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (B())
    {
      if (paramBoolean)
      {
        localIQfileViewBinder = this.k;
        if (localIQfileViewBinder != null) {
          localIQfileViewBinder.a(paramFileInfo, true);
        }
        FMDataCache.b(paramFileInfo);
        return true;
      }
      QfileBaseExpandableListAdapter.IQfileViewBinder localIQfileViewBinder = this.k;
      if (localIQfileViewBinder != null) {
        localIQfileViewBinder.a(paramFileInfo, false);
      }
      FMDataCache.c(paramFileInfo);
    }
    return true;
  }
  
  private Map<String, List<FileInfo>> d(ArrayList<FileInfo> paramArrayList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(HardCodeUtil.a(2131896109), new ArrayList());
    localLinkedHashMap.put(HardCodeUtil.a(2131896093), new ArrayList());
    Object localObject2 = paramArrayList.iterator();
    Object localObject3;
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FileInfo)((Iterator)localObject2).next();
      localObject1 = ((FileInfo)localObject3).a();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equalsIgnoreCase("QQfile_recv")))
      {
        paramArrayList = (ArrayList<FileInfo>)localObject1;
        if (!((String)localObject1).equalsIgnoreCase("QQ")) {}
      }
      else
      {
        paramArrayList = HardCodeUtil.a(2131896093);
      }
      localObject1 = paramArrayList;
      if (paramArrayList.equalsIgnoreCase("camera") == true) {
        localObject1 = HardCodeUtil.a(2131896109);
      }
      if (!localLinkedHashMap.containsKey(localObject1)) {
        localLinkedHashMap.put(localObject1, new ArrayList());
      }
      ((List)localLinkedHashMap.get(localObject1)).add(localObject3);
    }
    if (((FMActivity)this.C).N() == 1)
    {
      paramArrayList = HardCodeUtil.a(2131896139);
      localLinkedHashMap.put(paramArrayList, new ArrayList());
      localObject1 = new HashMap();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
      ((StringBuilder)localObject2).append("/chatpic/chatimg/");
      FileCategoryUtil.a(true, ((StringBuilder)localObject2).toString(), "", "", (HashMap)localObject1, null);
      localObject2 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (List)((HashMap)localObject1).get((String)((Iterator)localObject2).next());
        ((List)localLinkedHashMap.get(paramArrayList)).addAll((Collection)localObject3);
      }
    }
    paramArrayList = localLinkedHashMap.keySet().iterator();
    while (paramArrayList.hasNext()) {
      if (((List)localLinkedHashMap.get((String)paramArrayList.next())).size() == 0) {
        paramArrayList.remove();
      }
    }
    return localLinkedHashMap;
  }
  
  private ArrayList<FileInfo> p()
  {
    if (this.n) {
      localObject1 = (HashMap)FileCategoryUtil.a(this.C);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new HashMap();
    }
    Object localObject1 = this.m.iterator();
    while (((Iterator)localObject1).hasNext()) {
      FileCategoryUtil.a(true, ((QfileTabBarView.ScanParams)((Iterator)localObject1).next()).a(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", (HashMap)localObject2, this);
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll(this.v);
    if (y()) {
      return localObject1;
    }
    FileCategoryUtil.a((Map)localObject2);
    if (localObject2 != null)
    {
      Iterator localIterator = ((HashMap)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!"QQfile_recv".equalsIgnoreCase(str)) {
          ((ArrayList)localObject1).addAll((List)((HashMap)localObject2).get(str));
        }
      }
    }
    return localObject1;
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    if (paramSet != null)
    {
      if (paramSet.size() == 0) {
        return;
      }
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        e((FileInfo)paramSet.next());
      }
    }
  }
  
  public void b(FileInfo paramFileInfo) {}
  
  protected void d(FileInfo paramFileInfo)
  {
    if (!this.v.contains(paramFileInfo)) {
      this.v.add(paramFileInfo);
    }
    a(new QfileLocalFilePicTabView.2(this, paramFileInfo));
  }
  
  protected boolean e(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.a();
    this.v.remove(paramFileInfo);
    if (!this.l.containsKey(str))
    {
      QLog.e(o, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.l.get(str)).remove(paramFileInfo);
    i();
    return true;
  }
  
  protected QfileBaseExpandableListAdapter getQfileRecentFileBaseExpandableListAdapter()
  {
    this.j = new QfileLocalImageExpandableListAdapter(getActivity(), this.l, this.y, this.c, this.b, this.A, this.K);
    return this.j;
  }
  
  protected void getRecentFileRecords()
  {
    ThreadManagerV2.excute(this.J, 64, null, true);
  }
  
  public void j()
  {
    super.j();
    setEditbarButton(true, false, true, true, true);
    if (!this.C.K()) {
      if (this.C.q()) {
        this.C.A().T();
      } else {
        this.C.A().Y();
      }
    }
    k();
    this.r.setOnIndexChangedListener(this.M);
  }
  
  public void o()
  {
    this.C.runOnUiThread(new QfileLocalFilePicTabView.3(this));
  }
  
  protected void setViewBinder(QfileBaseExpandableListAdapter.IQfileViewBinder paramIQfileViewBinder)
  {
    this.k = paramIQfileViewBinder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView
 * JD-Core Version:    0.7.0.1
 */