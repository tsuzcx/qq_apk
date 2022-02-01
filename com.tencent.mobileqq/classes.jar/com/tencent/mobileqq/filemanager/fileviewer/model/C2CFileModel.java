package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.CloudFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.DefaultFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.FavFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.LocalFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.OfflineFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDisc;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.core.DiscOfflinePreviewController;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class C2CFileModel
  extends DefaultFileModel
{
  private FMObserver z;
  
  public C2CFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity, List<IFileViewerAdapter> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("C2CFileModel<FileAssistant>", 1, "FileBrowserModel init: type = c2c");
    }
    a(paramList, paramInt);
  }
  
  public void M()
  {
    if ((FileManagerUtil.a(this.a, this.c, true)) && (FileManagerUtil.b(this.a, this.c, true)))
    {
      long l = C();
      if (w() == 2) {
        l = FileManagerUtil.d(x());
      }
      this.a.getFileManagerDataCenter().b(l, this.c.r().WeiYunFileId);
    }
    super.M();
  }
  
  public int O()
  {
    if (L() == 51) {
      return 1;
    }
    return super.O();
  }
  
  public boolean P()
  {
    int i = L();
    if ((w() == 0) && ((i == 11) || (i == 12) || (i == 13))) {
      return false;
    }
    return super.P();
  }
  
  public BaseVideoBiz Q_()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity == null) {
      return null;
    }
    if (localFileManagerEntity.peerType == 0) {
      return new VideoForC2C(this.a, localFileManagerEntity);
    }
    if (localFileManagerEntity.peerType == 3000) {
      return new VideoForDisc(this.a, localFileManagerEntity);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unsuporrt peer type:");
    localStringBuilder.append(localFileManagerEntity.peerType);
    QLog.w("C2CFileModel<FileAssistant>", 1, localStringBuilder.toString());
    return null;
  }
  
  public int R()
  {
    int i = super.R();
    if (L() == 10) {
      i = 6;
    }
    return i;
  }
  
  public int W()
  {
    int i = z();
    int j = 1;
    if ((i != 0) && (i != 2) && (i != 13)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 0;
    }
    String str = y();
    boolean bool = FileUtil.b(str);
    FileManagerEntity localFileManagerEntity3 = this.c.r();
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity3;
    FileManagerEntity localFileManagerEntity2;
    if (bool)
    {
      localFileManagerEntity1 = localFileManagerEntity3;
      if (localFileManagerEntity3 == null) {
        try
        {
          localFileManagerEntity1 = FileManagerUtil.a(new FileInfo(str));
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
          localFileManagerEntity2 = localFileManagerEntity3;
        }
      }
    }
    if (localFileManagerEntity2 == null) {
      return 0;
    }
    if (localFileManagerEntity2.status == 16) {
      return 0;
    }
    if (L() == 0)
    {
      i = b();
      if ((i == 0) || (i == 3) || (i == 2)) {
        return 0;
      }
    }
    if ((TextUtils.isEmpty(localFileManagerEntity2.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity2.WeiYunFileId)) && (!FileUtils.fileExistsAndNotEmpty(str))) {
      return 0;
    }
    i = j;
    if (this.k != null)
    {
      i = j;
      if (this.k.k()) {
        i = 2;
      }
    }
    return i;
  }
  
  public IServiceInfo X()
  {
    Object localObject3 = this.c.r();
    Object localObject1 = localObject3;
    Object localObject2;
    if (localObject3 == null) {
      try
      {
        localObject1 = FileManagerUtil.a(new FileInfo(y()));
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
      }
    }
    if (localObject2 == null) {
      return new DefaultFileColorNoteServiceInfo();
    }
    if ((this.t == 14) && (this.u != null) && (this.u.containsKey("file_color_note_subType")))
    {
      int i = this.u.getInt("file_color_note_subType", -1);
      localObject3 = y();
      if ((i == 4) && (FileUtils.fileExistsAndNotEmpty((String)localObject3))) {
        return new FavFileColorNoteServiceInfo(localObject2.getFilePath());
      }
    }
    localObject3 = y();
    if ((TextUtils.isEmpty(localObject2.Uuid)) && (FileUtils.fileExistsAndNotEmpty((String)localObject3))) {
      return new LocalFileColorNoteServiceInfo(localObject2.getFilePath());
    }
    if (!TextUtils.isEmpty(localObject2.Uuid)) {
      return new OfflineFileColorNoteServiceInfo(this.c.r());
    }
    if (!TextUtils.isEmpty(localObject2.WeiYunFileId)) {
      return new CloudFileColorNoteServiceInfo(localObject2);
    }
    return new DefaultFileColorNoteServiceInfo();
  }
  
  public String Y()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity == null) {
      return null;
    }
    return localFileManagerEntity.mExcitingSpeed;
  }
  
  public boolean Z()
  {
    return true;
  }
  
  public int a()
  {
    int k = w();
    if (k == 0) {
      return 9;
    }
    String str = u();
    boolean bool = FileManagerUtil.n(y());
    int j = 1;
    if ((!bool) && (QFileAssistantUtils.a(str))) {
      return 1;
    }
    int i = super.a();
    if (i != 0) {
      return i;
    }
    int m = z();
    if (m != 0)
    {
      i = j;
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 4) {
            if (m == 5) {}
          }
          while ((!FileManagerUtil.b(this.a, this.c, false)) || (!FileManagerUtil.a(this.i, v(), x())))
          {
            return 7;
            return 11;
          }
          return 5;
        }
        i = j;
        if (k != 2)
        {
          if (H()) {
            return 1;
          }
          return 2;
        }
      }
    }
    else
    {
      i = 6;
    }
    return i;
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (this.u == null) {
      return;
    }
    if (this.u.getBoolean("file_location_pos_entrance_multiseq", false)) {
      return;
    }
    int i = this.u.getInt("FromChatHistoryTab", 0);
    if (i == 106) {
      return;
    }
    i = QFileUtils.c(this.t, i);
    if (i == 0) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("file_location_pos_entrance_type", i);
    paramArrayList.add(QFileUtils.a(54, FileOperaterUtils.a(this.i, localBundle, paramFileManagerEntity)));
    ReportController.b(null, "dc00898", "", "", "0X800B450", "0X800B450", i, 0, "", "", "", "");
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity == null) {
      return;
    }
    int m = paramActionSheetItem.action;
    int k = 1;
    int j;
    if (m == 52)
    {
      int i = localFileManagerEntity.getCloudType();
      if (i == 2) {
        i = -1006;
      } else if (i == 1) {
        i = -1001;
      } else {
        i = -1004;
      }
      Object localObject = localFileManagerEntity.strFileMd5;
      paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramActionSheetItem = localFileManagerEntity.str10Md5;
      }
      String str = y();
      localObject = str;
      if (!FileUtils.fileExistsAndNotEmpty(str)) {
        localObject = localFileManagerEntity.strLargeThumPath;
      }
      j = k;
      if (FileUtils.fileExistsAndNotEmpty((String)localObject))
      {
        ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment(this.i, (String)localObject, 1, i, paramActionSheetItem);
        j = k;
      }
    }
    else
    {
      j = 0;
      super.a(paramActionSheetItem);
    }
    if (j != 0) {
      f(m);
    }
  }
  
  public String aa()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkPackageName;
    }
    return "";
  }
  
  public String ab()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkName;
    }
    return "";
  }
  
  public String ac()
  {
    if (z() == 5)
    {
      FileManagerEntity localFileManagerEntity = this.c.r();
      if (localFileManagerEntity != null) {
        return localFileManagerEntity.yybApkIconUrl;
      }
    }
    return "";
  }
  
  protected boolean ad()
  {
    return true;
  }
  
  protected void c()
  {
    if (this.z != null) {
      return;
    }
    this.z = new C2CFileModel.C2CFileObserver(this, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "add fmObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().addObserver(this.z);
  }
  
  protected void d()
  {
    if (this.z != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del fmObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().deleteObserver(this.z);
      this.z = null;
    }
    if (this.c.r() == null) {}
  }
  
  public IUploadController e()
  {
    if (this.p == null) {
      this.p = new C2CFileModel.2(this);
    }
    return this.p;
  }
  
  public IDownloadController f()
  {
    if (this.o == null) {
      this.o = new C2CFileModel.1(this);
    }
    return this.o;
  }
  
  public void g()
  {
    super.g();
    if ((FileManagerUtil.a(this.a, this.c, true)) && (FileManagerUtil.b(this.a, this.c, true))) {
      this.a.getFileManagerDataCenter().f();
    }
  }
  
  public void h()
  {
    int i = R();
    int j = w();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (i == 6)
    {
      if (j == 0) {
        localQQAppInterface.getOnlineFileSessionCenter().d(C());
      } else {
        localQQAppInterface.getFileManagerEngine().b(C());
      }
    }
    else if (j == 0) {
      localQQAppInterface.getOnlineFileSessionCenter().b(C());
    } else {
      localQQAppInterface.getFileManagerEngine().h(this.c.r());
    }
    if (this.q != null) {
      this.q.d();
    }
  }
  
  public void i()
  {
    super.i();
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (w() == 1)
    {
      if (B() == 3000)
      {
        this.a.getFileManagerDataCenter().a(new DiscOfflinePreviewController(this.a, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
        return;
      }
      this.a.getFileManagerDataCenter().a(new OfflinePreviewController(this.a, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc));
    }
  }
  
  public String l()
  {
    return "biz_src_jc_file";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] m()
  {
    int i = w();
    if ((i != 0) && (i != 11)) {
      return super.m();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel
 * JD-Core Version:    0.7.0.1
 */