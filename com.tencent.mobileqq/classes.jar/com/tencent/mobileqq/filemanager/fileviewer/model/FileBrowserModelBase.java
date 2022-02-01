package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.DefaultFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.filemanager.fileviewer.data.FileQRScanResult;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public abstract class FileBrowserModelBase
{
  protected Activity i;
  protected int j = 0;
  protected IFileBrowser k;
  protected FilePreViewControllerBase l;
  protected ControlerCallback m;
  protected FileBrowserModelBase.OnZipEventListener n;
  protected IDownloadController o;
  protected IUploadController p;
  protected FileBrowserModelBase.OnTransEventListener q;
  protected IThumbController r;
  protected FileBrowserModelBase.OnThumbEventListener s;
  protected int t;
  protected Bundle u;
  protected HashMap<String, FileQRScanResult> v = new HashMap();
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> w;
  protected String x;
  protected FileBrowserModelBase.OnMMApkSafeCheckListener y;
  
  public FileBrowserModelBase(Activity paramActivity)
  {
    this.i = paramActivity;
    this.t = 0;
  }
  
  public String A()
  {
    return "";
  }
  
  public abstract int B();
  
  public abstract long C();
  
  public abstract String D();
  
  public abstract String E();
  
  public abstract boolean F();
  
  public abstract boolean G();
  
  public abstract boolean H();
  
  public abstract String I();
  
  public abstract float J();
  
  public abstract boolean K();
  
  public abstract int L();
  
  public abstract void M();
  
  public abstract boolean N();
  
  public abstract int O();
  
  public abstract boolean P();
  
  public abstract IThumbController Q();
  
  public BaseVideoBiz Q_()
  {
    return null;
  }
  
  public abstract int R();
  
  public abstract List<FileBrowserModelBase.ImageFileInfo> S();
  
  public abstract void T();
  
  public abstract TeamWorkFileImportInfo U();
  
  public abstract boolean V();
  
  public int W()
  {
    return 0;
  }
  
  public IServiceInfo X()
  {
    return new DefaultFileColorNoteServiceInfo();
  }
  
  public String Y()
  {
    return null;
  }
  
  public boolean Z()
  {
    return false;
  }
  
  public int a()
  {
    int i1 = z();
    if ((w() == 3) && (QQFileManagerUtil.z(y())) && (b() != 16))
    {
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 4) {
              if (i1 == 5) {}
            }
            while (!N())
            {
              return 1;
              return 3;
            }
            return 5;
          }
          return 2;
        }
        return 4;
      }
      return 6;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "getCreateFileType error : this is a local file, but is invalid, may be can not find file path");
    }
    return 0;
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, FileBrowserModelBase.ImageFileInfo paramImageFileInfo);
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(Bundle paramBundle)
  {
    this.u = paramBundle;
  }
  
  public void a(IFileBrowser paramIFileBrowser)
  {
    this.k = paramIFileBrowser;
  }
  
  public void a(FileBrowserModelBase.OnMMApkSafeCheckListener paramOnMMApkSafeCheckListener)
  {
    this.y = paramOnMMApkSafeCheckListener;
  }
  
  public abstract void a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener);
  
  public void a(FileBrowserModelBase.OnThumbEventListener paramOnThumbEventListener)
  {
    this.s = paramOnThumbEventListener;
  }
  
  public void a(FileBrowserModelBase.OnTransEventListener paramOnTransEventListener)
  {
    this.q = paramOnTransEventListener;
  }
  
  public void a(FileBrowserModelBase.OnZipEventListener paramOnZipEventListener)
  {
    this.n = paramOnZipEventListener;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem) {}
  
  public void a(String paramString, Bundle paramBundle) {}
  
  public void a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    b(paramList);
    ar();
  }
  
  protected final void a(@NonNull List<ShareActionSheetBuilder.ActionSheetItem> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if (z() == 0)
    {
      localObject = A();
      localObject = (FileQRScanResult)this.v.get(localObject);
      if ((localObject != null) && (((FileQRScanResult)localObject).c())) {
        return;
      }
    }
    Object localObject = y();
    if (!((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).isFileSupported((String)localObject)) {
      return;
    }
    paramList.add(QFileUtils.a(166, FileOperaterUtils.c(this.i, (String)localObject)));
  }
  
  public abstract void a(boolean paramBoolean);
  
  public String aa()
  {
    return "";
  }
  
  public String ab()
  {
    return "";
  }
  
  public String ac()
  {
    return "";
  }
  
  public void ae()
  {
    c();
    as();
  }
  
  public void af()
  {
    if (this.q != null) {
      this.q = null;
    }
    if (this.s != null) {
      this.s = null;
    }
    if (this.n != null) {
      this.n = null;
    }
  }
  
  public String ag()
  {
    return "";
  }
  
  public String ah()
  {
    return null;
  }
  
  public int ak()
  {
    return 0;
  }
  
  public String al()
  {
    return "";
  }
  
  public String am()
  {
    return "";
  }
  
  public void an() {}
  
  public int ao()
  {
    return this.t;
  }
  
  public int ap()
  {
    return this.i.getResources().getDimensionPixelSize(2131299920);
  }
  
  public boolean aq()
  {
    return this.t != 12;
  }
  
  protected final void ar()
  {
    if (z() != 0) {
      return;
    }
    String str = A();
    if (this.v.get(str) != null) {
      return;
    }
    QFileUtils.a(this.i, str, new FileBrowserModelBase.1(this, str));
  }
  
  protected void as()
  {
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.3(this));
  }
  
  protected void at()
  {
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.4(this));
  }
  
  public abstract int b();
  
  public abstract void b(int paramInt);
  
  public void b(@NonNull List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = A();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      localObject = (FileQRScanResult)this.v.get(localObject);
      if (localObject != null)
      {
        localObject = QFileUtils.a((FileQRScanResult)localObject);
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          paramList.addAll((Collection)localObject);
        }
      }
    }
  }
  
  public boolean b(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    if (paramOnPreviewVideoOnlineListener != null) {
      paramOnPreviewVideoOnlineListener.cp_();
    }
    return false;
  }
  
  protected abstract void c();
  
  public abstract void c(int paramInt);
  
  public void c(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    ArrayList localArrayList = this.w;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      paramList.addAll(this.w);
    }
    this.w = null;
  }
  
  protected abstract void d();
  
  public abstract void d(int paramInt);
  
  public abstract IUploadController e();
  
  public void e(int paramInt)
  {
    this.t = paramInt;
  }
  
  public abstract IDownloadController f();
  
  protected void f(int paramInt)
  {
    if (paramInt != 52)
    {
      if (paramInt != 118)
      {
        if (paramInt != 55)
        {
          if (paramInt != 56) {
            return;
          }
          ReportController.b(null, "dc00898", "", "", "0X800ADBF", "0X800ADBF", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X800ADBE", "0X800ADBE", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X800ADBC", "0X800ADBC", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800ADBD", "0X800ADBD", 0, 0, "", "", "", "");
  }
  
  public void g()
  {
    d();
    if (this.q != null) {
      this.q = null;
    }
    if (this.s != null) {
      this.s = null;
    }
    if (this.n != null) {
      this.n = null;
    }
    at();
  }
  
  public Intent k()
  {
    return null;
  }
  
  public String l()
  {
    return "";
  }
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] m();
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] n();
  
  protected abstract void o();
  
  public abstract void p();
  
  public abstract boolean q();
  
  public abstract long r();
  
  public int s()
  {
    int i2 = this.j;
    int i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    return i1;
  }
  
  public abstract boolean t();
  
  public abstract String u();
  
  public abstract String v();
  
  public abstract int w();
  
  public abstract long x();
  
  public abstract String y();
  
  public abstract int z();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
 * JD-Core Version:    0.7.0.1
 */