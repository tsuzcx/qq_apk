package com.tencent.mobileqq.filemanager.openbrowser;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnEventListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnMMApkSafeCheckListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnThumbEventListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnTransEventListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnZipEventListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.EntityFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.TroopFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnMMApkSafeCheckListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnZipEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.filemanager.guild.GuildFileModel;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class FileModelAdapter
  extends FileBrowserModelDefault
{
  protected Activity b;
  private QQAppInterface c;
  private Bundle d;
  private int e;
  private IFileBrowserData f;
  private IFileViewerAdapter g;
  private FileBrowserModelBase h;
  private boolean i = false;
  private boolean j = false;
  private BroadcastReceiver k = null;
  private IFileBrowserModel.OnEventListener l;
  private IFileBrowserModel.OnMMApkSafeCheckListener m;
  private final FileBrowserModelBase.OnMMApkSafeCheckListener n = new FileModelAdapter.1(this);
  private final IFileBrowser o = new FileModelAdapter.2(this);
  private IFileBrowserModel.OnTransEventListener p;
  private final FileBrowserModelBase.OnTransEventListener q = new FileModelAdapter.3(this);
  private IFileBrowserModel.OnThumbEventListener r;
  private final FileBrowserModelBase.OnThumbEventListener s = new FileModelAdapter.4(this);
  private ZipFilesListAdapter t;
  private IFileBrowserModel.OnZipEventListener u;
  private final FileBrowserModelBase.OnZipEventListener v = new FileModelAdapter.5(this);
  
  public FileModelAdapter(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.getCloudType() != 9)
    {
      int i1 = paramFileManagerEntity.peerType;
      if (i1 != 6000)
      {
        if (i1 != 9501)
        {
          if ((paramFileManagerEntity.guildId != null) && (paramFileManagerEntity.channelId != null) && (!paramFileManagerEntity.guildId.isEmpty()) && (!paramFileManagerEntity.channelId.isEmpty()))
          {
            a(paramQQAppInterface, paramFileManagerEntity, 5);
            return;
          }
          a(paramQQAppInterface, paramFileManagerEntity, 1);
        }
      }
      else {
        a(paramQQAppInterface, paramFileManagerEntity, 3);
      }
    }
    else
    {
      a(paramQQAppInterface, paramFileManagerEntity, 4);
    }
  }
  
  public FileModelAdapter(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    a(paramQQAppInterface, paramFileManagerEntity, paramInt);
  }
  
  private void H()
  {
    if (this.k != null)
    {
      this.c.getApp().unregisterReceiver(this.k);
      this.k = null;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    this.c = paramQQAppInterface;
    this.e = paramInt;
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if ((paramInt != 3) && (paramInt != 4) && (paramInt != 5))
        {
          this.g = null;
          this.f = null;
        }
      }
      else
      {
        this.g = new TroopFileViewerAdapter(paramQQAppInterface, paramFileManagerEntity);
        this.f = new TroopFileBrowserData(paramQQAppInterface, paramFileManagerEntity);
        return;
      }
    }
    this.g = new EntityFileViewerAdapter(paramQQAppInterface, paramFileManagerEntity);
    this.f = new EntityFileBrowserData(paramQQAppInterface, paramFileManagerEntity);
  }
  
  public void A()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.p();
  }
  
  public void B()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.T();
  }
  
  public void C()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.M();
  }
  
  public IServiceInfo D()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return null;
    }
    return localFileBrowserModelBase.X();
  }
  
  public TeamWorkFileImportInfo E()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return null;
    }
    return localFileBrowserModelBase.U();
  }
  
  public boolean F()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return false;
    }
    return localFileBrowserModelBase.V();
  }
  
  public BaseAdapter G()
  {
    return this.t;
  }
  
  public IFileBrowserData a()
  {
    return this.f;
  }
  
  public void a(int paramInt)
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.d(paramInt);
  }
  
  public void a(Activity paramActivity)
  {
    this.b = paramActivity;
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(this.g);
    int i1 = this.e;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              this.h = null;
            } else {
              this.h = new GuildFileModel(this.c, paramActivity, localArrayList, 0);
            }
          }
          else {
            this.h = new DocsExportFileModel(this.c, paramActivity, localArrayList, 0);
          }
        }
        else {
          this.h = new DatalineFileModel(this.c, paramActivity, localArrayList, 0);
        }
      }
      else {
        this.h = new TroopFileModel(this.c, paramActivity, localArrayList, 0);
      }
    }
    else {
      this.h = new C2CFileModel(this.c, paramActivity, localArrayList, 0);
    }
    paramActivity = this.h;
    if (paramActivity != null)
    {
      paramActivity.a(this.d);
      this.h.a(this.q);
      this.h.a(this.o);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.d = paramBundle;
  }
  
  public void a(IFileBrowserModel.OnEventListener paramOnEventListener)
  {
    this.l = paramOnEventListener;
  }
  
  public void a(IFileBrowserModel.OnMMApkSafeCheckListener paramOnMMApkSafeCheckListener)
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    this.m = paramOnMMApkSafeCheckListener;
    localFileBrowserModelBase.a(this.n);
  }
  
  public void a(IFileBrowserModel.OnThumbEventListener paramOnThumbEventListener)
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    this.r = paramOnThumbEventListener;
    localFileBrowserModelBase.a(this.s);
  }
  
  public void a(IFileBrowserModel.OnTransEventListener paramOnTransEventListener)
  {
    this.p = paramOnTransEventListener;
  }
  
  public void a(IFileBrowserModel.OnZipEventListener paramOnZipEventListener)
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    this.u = paramOnZipEventListener;
    localFileBrowserModelBase.a(this.v);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.a(paramActionSheetItem);
  }
  
  public void b()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase != null) {
      localFileBrowserModelBase.ae();
    }
  }
  
  public void c()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase != null) {
      localFileBrowserModelBase.af();
    }
  }
  
  public void d()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase != null) {
      localFileBrowserModelBase.g();
    }
    this.p = null;
    H();
  }
  
  public int e()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.a();
    }
    return 0;
  }
  
  public String f()
  {
    QQAppInterface localQQAppInterface = this.c;
    if (localQQAppInterface == null) {
      return "";
    }
    return localQQAppInterface.getCurrentAccountUin();
  }
  
  public int g()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.O();
    }
    return 2;
  }
  
  public String h()
  {
    return FileUtil.a(this.g.c());
  }
  
  public String i()
  {
    return this.g.t();
  }
  
  public boolean j()
  {
    if (this.g.r() != null) {
      return FileManagerUtil.d(this.g.r());
    }
    return false;
  }
  
  public int k()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.R();
    }
    return 0;
  }
  
  public float l()
  {
    if (this.g.r() != null) {
      return this.g.r().fProgress;
    }
    return 0.0F;
  }
  
  public String m()
  {
    FileManagerEntity localFileManagerEntity = this.g.r();
    if (localFileManagerEntity == null) {
      return null;
    }
    return localFileManagerEntity.mExcitingSpeed;
  }
  
  public boolean n()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return false;
    }
    return localFileBrowserModelBase.P();
  }
  
  public boolean o()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return false;
    }
    return localFileBrowserModelBase.H();
  }
  
  public boolean p()
  {
    if (this.g.r() != null) {
      return this.g.r().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public String q()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return "";
    }
    return localFileBrowserModelBase.ac();
  }
  
  public String r()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return "";
    }
    return localFileBrowserModelBase.aa();
  }
  
  public String s()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return "";
    }
    return localFileBrowserModelBase.ab();
  }
  
  public boolean t()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return false;
    }
    return localFileBrowserModelBase.Z();
  }
  
  public Intent u()
  {
    FileManagerEntity localFileManagerEntity = this.g.r();
    if (localFileManagerEntity == null) {
      return null;
    }
    return QFileUtils.b(this.c, this.b, localFileManagerEntity);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] v()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return null;
    }
    return localFileBrowserModelBase.m();
  }
  
  public void w()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.e().a();
  }
  
  public void x()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.e().b();
  }
  
  public void y()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.f().a();
  }
  
  public void z()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.h;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.f().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter
 * JD-Core Version:    0.7.0.1
 */