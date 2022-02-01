package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkForAppStoreFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkSimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.OnlineSimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.PictureFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.PreviewSimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.PreviewVideoSimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.FileBrowserViewBase;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileBrowserManager
{
  protected IFileViewListener a;
  private Activity b;
  private FileBrowserViewBase c;
  private FileBrowserPresenterBase d;
  private FileBrowserModelBase e;
  private IFileBrowser f;
  private FileBrowserManager.IModelCreater g;
  private Bundle h;
  private int i = 0;
  private ShareActionSheet j;
  
  public FileBrowserManager(Activity paramActivity, IFileBrowser paramIFileBrowser, FileBrowserManager.IModelCreater paramIModelCreater)
  {
    this.b = paramActivity;
    this.f = paramIFileBrowser;
    this.g = paramIModelCreater;
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList)
  {
    if ((paramArrayOfArrayList != null) && (paramArrayOfArrayList.length > 0))
    {
      int k = 0;
      while (k < paramArrayOfArrayList.length)
      {
        Object localObject = paramArrayOfArrayList[k];
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next()).action == 26) {
              ReportController.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        k += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.d;
    if (localFileBrowserPresenterBase != null) {
      localFileBrowserPresenterBase.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.d;
    if (localFileBrowserPresenterBase != null) {
      localFileBrowserPresenterBase.a(paramConfiguration);
    }
  }
  
  public void a(IFileViewListener paramIFileViewListener)
  {
    this.a = paramIFileViewListener;
  }
  
  public boolean a()
  {
    int k = this.e.z();
    return (k == 3) || (k == 9) || (k == 7) || (k == 10) || (k == 6);
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = i();
    if ((bool) && (paramViewGroup != null) && (paramLayoutParams != null))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.addView(this.c.b(), paramLayoutParams);
    }
    return bool;
  }
  
  public boolean a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 1, "FileBrowserManager init.");
    }
    this.h = paramBundle;
    if (this.e == null)
    {
      this.e = this.g.a();
      FileBrowserModelBase localFileBrowserModelBase = this.e;
      if (localFileBrowserModelBase == null)
      {
        QLog.e("FileBrowserManager<FileAssistant>", 1, "create FileBrowser failed, mFileModel = null");
        return false;
      }
      localFileBrowserModelBase.a(this.f);
      this.e.e(paramInt);
      this.e.a(paramBundle);
    }
    boolean bool2 = i();
    boolean bool1;
    if ((this.c != null) && (this.d != null))
    {
      bool1 = bool2;
      if (paramViewGroup != null)
      {
        bool1 = bool2;
        if (paramLayoutParams != null)
        {
          paramViewGroup.removeAllViews();
          paramViewGroup.addView(this.c.b(), paramLayoutParams);
          return bool2;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserManager<FileAssistant>", 2, "create file view error");
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public String b()
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.d;
    if (localFileBrowserPresenterBase != null) {
      return localFileBrowserPresenterBase.q();
    }
    return "";
  }
  
  public long c()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.e;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.x();
    }
    return 0L;
  }
  
  public boolean d()
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.d;
    if (localFileBrowserPresenterBase != null) {
      return localFileBrowserPresenterBase.c();
    }
    return false;
  }
  
  public boolean e()
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.d;
    if (localFileBrowserPresenterBase != null) {
      return localFileBrowserPresenterBase.b();
    }
    return false;
  }
  
  public int f()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.e;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.z();
    }
    return -1;
  }
  
  public boolean g()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.e;
    return (localFileBrowserModelBase != null) && (localFileBrowserModelBase.W() != 0);
  }
  
  public IServiceInfo h()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.e;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.X();
    }
    return null;
  }
  
  protected boolean i()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      int m = ((FileBrowserModelBase)localObject).a();
      this.e.y();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshFileView. currentType[");
        ((StringBuilder)localObject).append(this.i);
        ((StringBuilder)localObject).append("] fileType[");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileBrowserManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      if (this.i != m)
      {
        localObject = this.d;
        if (localObject != null) {
          ((FileBrowserPresenterBase)localObject).k();
        }
        localObject = this.e.y();
        int k = m;
        if (localObject != null)
        {
          k = m;
          if (((String)localObject).contains("/chatpic/chatimg/")) {
            k = 6;
          }
        }
        switch (k)
        {
        default: 
          this.d = new SimpleFilePresenter(this.e, this.b);
          break;
        case 11: 
          this.d = new ApkForAppStoreFilePresenter(this.e, this.b);
          break;
        case 10: 
          this.d = new DocExportFilePresenter(this.e, this.b);
          break;
        case 9: 
          this.d = new OnlineSimpleFilePresenter(this.e, this.b);
          break;
        case 8: 
          this.d = new PreviewVideoSimpleFilePresenter(this.e, this.b);
          break;
        case 7: 
          this.d = new PreviewSimpleFilePresenter(this.e, this.b);
          break;
        case 6: 
          this.d = new PictureFilePresenter(this.e, this.b);
          break;
        case 5: 
          this.d = new ZipFilePresenter(this.e, this.b);
          break;
        case 4: 
          this.d = new MusicFilePresenter(this.e, this.b);
          break;
        case 3: 
          this.d = new ApkSimpleFilePresenter(this.e, this.b);
          break;
        case 2: 
          this.d = new VideoFilePresenter(this.e, this.b);
        }
        this.d.a(this.f);
        this.d.a(this.h);
        this.d.a(this.a);
        this.d.a();
        this.c = this.d.o();
        this.i = k;
        return true;
      }
      this.d.a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserManager<FileAssistant>", 2, "initFileViewer error : model is null");
    }
    return false;
  }
  
  public boolean j()
  {
    Object localObject1 = m();
    Object localObject2 = null;
    if (localObject1 != null)
    {
      if (localObject1.length == 1)
      {
        localObject2 = localObject1[0];
        localObject1 = null;
        break label45;
      }
      if (localObject1.length == 2)
      {
        localObject2 = localObject1[0];
        localObject1 = localObject1[1];
        break label45;
      }
    }
    localObject1 = null;
    label45:
    return ((localObject2 != null) && (!localObject2.isEmpty())) || ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()));
  }
  
  public void k()
  {
    if (this.j == null)
    {
      localParam = new ShareActionSheetV2.Param();
      localParam.context = this.b;
      this.j = ShareActionSheetFactory.create(localParam);
    }
    this.j.setRowVisibility(0, 0, 0);
    this.j.setOnDismissListener(new FileBrowserManager.1(this));
    Object localObject = m();
    ShareActionSheetV2.Param localParam = null;
    if (localObject != null)
    {
      if (localObject.length == 1)
      {
        localParam = localObject[0];
        localList = null;
        break label105;
      }
      if (localObject.length == 2)
      {
        localParam = localObject[0];
        localList = localObject[1];
        break label105;
      }
    }
    List localList = null;
    label105:
    if (((localParam != null) && (!localParam.isEmpty())) || ((localList != null) && (!localList.isEmpty())))
    {
      a((ArrayList[])localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(FileUtil.a(c()));
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      this.j.setActionSheetTitle((CharSequence)localObject);
      localObject = this.e.k();
      String str = this.e.l();
      this.b.getIntent().putExtra("big_brother_source_key", str);
      if ((localObject != null) && (!TextUtils.isEmpty(str))) {
        this.j.setIntentForStartForwardRecentActivity((Intent)localObject);
      } else {
        this.j.setRowVisibility(8, 0, 0);
      }
      this.j.setActionSheetItems(localParam, localList);
      this.j.setItemClickListenerV2(new FileBrowserManager.2(this));
      this.j.show();
    }
  }
  
  public void l()
  {
    Object localObject = this.d;
    if ((localObject != null) && ((localObject instanceof VideoFilePresenter)))
    {
      ((FileBrowserPresenterBase)localObject).t();
      return;
    }
    if (this.j != null)
    {
      localObject = m();
      List localList = null;
      if (localObject != null)
      {
        if (localObject.length == 1)
        {
          localList = localObject[0];
          localObject = null;
          break label73;
        }
        if (localObject.length == 2)
        {
          localList = localObject[0];
          localObject = localObject[1];
          break label73;
        }
      }
      localObject = null;
      label73:
      if (((localList != null) && (!localList.isEmpty())) || ((localObject != null) && (!((ArrayList)localObject).isEmpty()))) {
        this.j.setActionSheetItems(localList, (List)localObject);
      }
      if (this.j.isShowing()) {
        this.j.refresh();
      }
    }
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] m()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.e;
    if ((localFileBrowserModelBase != null) && (localFileBrowserModelBase.aq())) {
      return this.e.m();
    }
    return null;
  }
  
  public void n()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((FileBrowserModelBase)localObject).an();
    }
    localObject = this.d;
    if (localObject != null) {
      ((FileBrowserPresenterBase)localObject).n();
    }
  }
  
  public void o()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((FileBrowserModelBase)localObject).af();
    }
    localObject = this.d;
    if (localObject != null) {
      ((FileBrowserPresenterBase)localObject).l();
    }
  }
  
  public void p()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((FileBrowserModelBase)localObject).ae();
    }
    localObject = this.d;
    if (localObject != null) {
      ((FileBrowserPresenterBase)localObject).m();
    }
  }
  
  public void q()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserManager<FileAssistant><FileAssistant>", 1, "FileBrowserManager Finish");
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      ((FileBrowserModelBase)localObject).g();
      this.e = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((FileBrowserPresenterBase)localObject).k();
      this.d = null;
    }
    if (this.c != null) {
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager
 * JD-Core Version:    0.7.0.1
 */