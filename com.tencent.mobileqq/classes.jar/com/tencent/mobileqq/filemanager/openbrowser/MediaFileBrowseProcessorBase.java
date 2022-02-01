package com.tencent.mobileqq.filemanager.openbrowser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.dataline.data.PrinterManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager;
import com.tencent.mobileqq.filemanager.core.IFileVideoDownloader;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDisc;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForTroop;
import com.tencent.mobileqq.filemanager.guild.VideoForGuild;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserProvider;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserProviderCallBack;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService.BrowserInfo;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MediaFileBrowseProcessorBase
  implements IMediaBrowserProvider
{
  protected final QQAppInterface a;
  protected List<RichMediaBrowserInfo> b = new ArrayList();
  protected int c = 0;
  IMediaBrowserProviderCallBack d;
  protected final List<IFileViewerAdapter> e = new ArrayList();
  protected final Map<String, Integer> f = new HashMap();
  protected final ArrayList<Long> g = new ArrayList();
  private final FMObserver h = new MediaFileBrowseProcessorBase.4(this);
  
  public MediaFileBrowseProcessorBase(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    ShortVideoUtils.loadShortVideoSo(paramQQAppInterface);
  }
  
  private BaseVideoBiz a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    paramIFileViewerAdapter = paramIFileViewerAdapter.r();
    if (paramIFileViewerAdapter == null) {
      return null;
    }
    if (paramIFileViewerAdapter.getCloudType() == 12) {
      return new VideoForGuild(this.a, paramIFileViewerAdapter);
    }
    if (paramIFileViewerAdapter.peerType == 0) {
      return new VideoForC2C(this.a, paramIFileViewerAdapter);
    }
    if (paramIFileViewerAdapter.peerType == 3000) {
      return new VideoForDisc(this.a, paramIFileViewerAdapter);
    }
    if (paramIFileViewerAdapter.peerType == 1)
    {
      paramIFileViewerAdapter = TroopFileUtils.a(this.a, paramIFileViewerAdapter);
      return new VideoForTroop(this.a, paramIFileViewerAdapter);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unsuporrt peer type:");
    localStringBuilder.append(paramIFileViewerAdapter.peerType);
    QLog.w("MediaFileBrowseProcessorBase", 1, localStringBuilder.toString());
    return null;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, BaseVideoBiz paramBaseVideoBiz)
  {
    IFileVideoDownloader localIFileVideoDownloader = FileVideoDownloadManager.b(paramBaseVideoBiz);
    localIFileVideoDownloader.a(new MediaFileBrowseProcessorBase.1(this, paramBaseVideoBiz, paramLong, paramInt1, paramInt2));
    localIFileVideoDownloader.a(new MediaFileBrowseProcessorBase.2(this, paramBaseVideoBiz, paramLong, paramInt1));
    localIFileVideoDownloader.a(true);
    localIFileVideoDownloader.c();
  }
  
  private AIOFilePictureData b(int paramInt, FileInfo paramFileInfo)
  {
    AIOFilePictureData localAIOFilePictureData = new AIOFilePictureData();
    localAIOFilePictureData.a = paramInt;
    localAIOFilePictureData.m = paramFileInfo.d();
    localAIOFilePictureData.s = paramFileInfo.f();
    localAIOFilePictureData.d = paramFileInfo.f();
    localAIOFilePictureData.r = false;
    localAIOFilePictureData.t = false;
    return localAIOFilePictureData;
  }
  
  private AIOFilePictureData b(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    AIOFilePictureData localAIOFilePictureData = new AIOFilePictureData();
    localAIOFilePictureData.a = paramInt;
    Object localObject = paramFileManagerEntity.getFilePath();
    String str = "I:N";
    if (localObject != null) {
      localObject = paramFileManagerEntity.getFilePath();
    } else {
      localObject = "I:N";
    }
    localAIOFilePictureData.m = ((String)localObject);
    if (paramFileManagerEntity.strLargeThumPath != null) {
      localObject = paramFileManagerEntity.strLargeThumPath;
    } else {
      localObject = "I:N";
    }
    localAIOFilePictureData.l = ((String)localObject);
    localObject = str;
    if (paramFileManagerEntity.strMiddleThumPath != null) {
      localObject = paramFileManagerEntity.strMiddleThumPath;
    }
    localAIOFilePictureData.k = ((String)localObject);
    localAIOFilePictureData.s = paramFileManagerEntity.fileSize;
    localAIOFilePictureData.d = paramFileManagerEntity.fileSize;
    boolean bool;
    if (paramFileManagerEntity.status == 16) {
      bool = true;
    } else {
      bool = false;
    }
    localAIOFilePictureData.r = bool;
    localAIOFilePictureData.t = paramFileManagerEntity.sendCloudUnsuccessful();
    return localAIOFilePictureData;
  }
  
  private AIOFilePictureData b(int paramInt, IFileViewerAdapter paramIFileViewerAdapter)
  {
    AIOFilePictureData localAIOFilePictureData = new AIOFilePictureData();
    localAIOFilePictureData.a = paramInt;
    localAIOFilePictureData.m = paramIFileViewerAdapter.o();
    localAIOFilePictureData.k = paramIFileViewerAdapter.p();
    localAIOFilePictureData.l = paramIFileViewerAdapter.l();
    localAIOFilePictureData.s = paramIFileViewerAdapter.c();
    localAIOFilePictureData.d = paramIFileViewerAdapter.c();
    boolean bool;
    if (paramIFileViewerAdapter.n() == 16) {
      bool = true;
    } else {
      bool = false;
    }
    localAIOFilePictureData.r = bool;
    localAIOFilePictureData.t = false;
    return localAIOFilePictureData;
  }
  
  private boolean b(IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.q();
    boolean bool = true;
    if (i == 10) {
      return true;
    }
    i = paramIFileViewerAdapter.n();
    if (i != 0)
    {
      if (i == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private AIOFileVideoData c(int paramInt, FileInfo paramFileInfo)
  {
    AIOFileVideoData localAIOFileVideoData = new AIOFileVideoData();
    localAIOFileVideoData.a = paramInt;
    localAIOFileVideoData.I = paramFileInfo.f();
    localAIOFileVideoData.d = paramFileInfo.f();
    localAIOFileVideoData.j = paramFileInfo.e();
    localAIOFileVideoData.k = paramFileInfo.d();
    localAIOFileVideoData.l = paramFileInfo.d();
    localAIOFileVideoData.v = true;
    localAIOFileVideoData.isLocal = true;
    return localAIOFileVideoData;
  }
  
  private AIOFileVideoData c(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    AIOFileVideoData localAIOFileVideoData = new AIOFileVideoData();
    localAIOFileVideoData.a = paramInt;
    localAIOFileVideoData.d = paramFileManagerEntity.fileSize;
    localAIOFileVideoData.j = paramFileManagerEntity.fileName;
    localAIOFileVideoData.o = paramFileManagerEntity.imgHeight;
    localAIOFileVideoData.n = paramFileManagerEntity.imgWidth;
    if (FileUtil.b(paramFileManagerEntity.strLargeThumPath)) {
      localAIOFileVideoData.k = paramFileManagerEntity.strLargeThumPath;
    } else if (FileUtil.b(paramFileManagerEntity.strMiddleThumPath)) {
      localAIOFileVideoData.k = paramFileManagerEntity.strMiddleThumPath;
    } else if (FileUtil.b(paramFileManagerEntity.strThumbPath)) {
      localAIOFileVideoData.k = paramFileManagerEntity.strThumbPath;
    }
    localAIOFileVideoData.m = ((IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(paramFileManagerEntity.fileName)).b;
    if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
    {
      localAIOFileVideoData.l = paramFileManagerEntity.getFilePath();
      localAIOFileVideoData.I = paramFileManagerEntity.fileSize;
      localAIOFileVideoData.v = true;
      localAIOFileVideoData.isLocal = true;
    }
    return localAIOFileVideoData;
  }
  
  private AIOFileVideoData c(int paramInt, IFileViewerAdapter paramIFileViewerAdapter)
  {
    AIOFileVideoData localAIOFileVideoData = new AIOFileVideoData();
    localAIOFileVideoData.a = paramInt;
    localAIOFileVideoData.d = paramIFileViewerAdapter.c();
    localAIOFileVideoData.j = paramIFileViewerAdapter.b();
    if (FileUtil.b(paramIFileViewerAdapter.l())) {
      localAIOFileVideoData.k = paramIFileViewerAdapter.l();
    } else if (FileUtil.b(paramIFileViewerAdapter.p())) {
      localAIOFileVideoData.k = paramIFileViewerAdapter.p();
    }
    localAIOFileVideoData.m = ((IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(paramIFileViewerAdapter.b())).b;
    if (FileUtils.fileExistsAndNotEmpty(paramIFileViewerAdapter.o()))
    {
      localAIOFileVideoData.l = paramIFileViewerAdapter.o();
      localAIOFileVideoData.I = paramIFileViewerAdapter.c();
      localAIOFileVideoData.v = true;
      localAIOFileVideoData.isLocal = true;
    }
    return localAIOFileVideoData;
  }
  
  private void c(IFileViewerAdapter paramIFileViewerAdapter)
  {
    long l = paramIFileViewerAdapter.a();
    int i = paramIFileViewerAdapter.m();
    if (b(paramIFileViewerAdapter))
    {
      if (i == 0)
      {
        this.a.getOnlineFileSessionCenter().d(l);
        return;
      }
      this.a.getFileManagerEngine().b(l);
      return;
    }
    if (i == 0)
    {
      this.a.getOnlineFileSessionCenter().b(l);
      return;
    }
    this.a.getFileManagerEngine().h(paramIFileViewerAdapter.r());
  }
  
  public Intent a(long paramLong, int paramInt)
  {
    return null;
  }
  
  public IMediaBrowserService.BrowserInfo a()
  {
    return new IMediaBrowserService.BrowserInfo(this, this.b, this.c);
  }
  
  protected RichMediaBrowserInfo a(int paramInt, FileInfo paramFileInfo)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo;
    if (paramFileInfo.l() == 0)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = b(paramInt, paramFileInfo);
    }
    else
    {
      localRichMediaBrowserInfo = null;
    }
    if (paramFileInfo.l() == 2)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = c(paramInt, paramFileInfo);
    }
    return localRichMediaBrowserInfo;
  }
  
  protected RichMediaBrowserInfo a(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo;
    if (paramFileManagerEntity.nFileType == 0)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = b(paramInt, paramFileManagerEntity);
    }
    else
    {
      localRichMediaBrowserInfo = null;
    }
    if (paramFileManagerEntity.nFileType == 2)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = c(paramInt, paramFileManagerEntity);
    }
    return localRichMediaBrowserInfo;
  }
  
  protected RichMediaBrowserInfo a(int paramInt, IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.d();
    RichMediaBrowserInfo localRichMediaBrowserInfo;
    if (i == 0)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = b(paramInt, paramIFileViewerAdapter);
    }
    else
    {
      localRichMediaBrowserInfo = null;
    }
    if (i == 2)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = c(paramInt, paramIFileViewerAdapter);
    }
    return localRichMediaBrowserInfo;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(long paramLong)
  {
    int i = (int)paramLong;
    if (i >= this.e.size()) {
      return;
    }
    Object localObject = (IFileViewerAdapter)this.e.get(i);
    i = ((IFileViewerAdapter)localObject).m();
    if (i != 1)
    {
      if ((i != 3) && (i != 5)) {
        return;
      }
      this.a.getFileManagerEngine().a(((IFileViewerAdapter)localObject).o(), null, this.a.getAccount(), 0, false);
      return;
    }
    String str;
    if (((IFileViewerAdapter)localObject).k()) {
      str = this.a.getCurrentAccountUin();
    } else {
      str = ((IFileViewerAdapter)localObject).i();
    }
    localObject = ((IFileViewerAdapter)localObject).r();
    if (localObject == null) {
      return;
    }
    this.a.getFileManagerEngine().a((FileManagerEntity)localObject, str);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    int i = (int)paramLong;
    if (i >= this.e.size()) {
      return;
    }
    IFileViewerAdapter localIFileViewerAdapter = (IFileViewerAdapter)this.e.get(i);
    if (paramInt2 == 16842753)
    {
      a(paramLong, paramInt1, paramInt2, a(localIFileViewerAdapter));
      return;
    }
    if (paramInt2 == 20)
    {
      c(localIFileViewerAdapter);
      return;
    }
    a(paramLong, localIFileViewerAdapter);
  }
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    int i = (int)paramLong;
    if (i >= this.e.size()) {
      return;
    }
    FileManagerEntity localFileManagerEntity = ((IFileViewerAdapter)this.e.get(i)).r();
    if (localFileManagerEntity == null) {
      return;
    }
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.getString("contextid");
    switch (paramInt)
    {
    default: 
      return;
    case 14: 
      FileVideoDownloadManager.c(paramBundle);
      return;
    case 13: 
      if (!this.g.contains(Long.valueOf(paramLong))) {
        this.g.add(Long.valueOf(paramLong));
      }
      FileVideoDownloadManager.b(paramBundle);
      FileVideoDownloadManager.a(paramBundle, true);
      return;
    case 12: 
      FileVideoDownloadManager.a(paramBundle);
      this.a.getFileManagerEngine().a(localFileManagerEntity.nSessionId);
      return;
    case 11: 
      FileVideoDownloadManager.b(paramBundle);
      FileVideoDownloadManager.a(paramBundle, false);
      return;
    }
    FileVideoDownloadManager.a(paramBundle, true);
  }
  
  public void a(long paramLong, IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.m();
    Object localObject1 = null;
    Object localObject2 = null;
    if (1 == i)
    {
      if (paramIFileViewerAdapter.r().isZipInnerFile) {
        localObject1 = this.a.getFileManagerEngine().d(paramIFileViewerAdapter.r());
      } else {
        localObject1 = this.a.getFileManagerEngine().a(paramIFileViewerAdapter.r(), 7);
      }
    }
    else if (2 == paramIFileViewerAdapter.m())
    {
      FileManagerEngine localFileManagerEngine = this.a.getFileManagerEngine();
      String str = paramIFileViewerAdapter.j();
      if (paramIFileViewerAdapter.s() == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = paramIFileViewerAdapter.s().i;
      }
      localObject1 = localFileManagerEngine.a(str, (String)localObject1, 7, paramIFileViewerAdapter);
    }
    if (localObject1 != null) {
      this.d.a(paramLong, 0, 18, 1, (String)localObject1, false);
    }
  }
  
  public void a(IMediaBrowserProviderCallBack paramIMediaBrowserProviderCallBack)
  {
    this.d = paramIMediaBrowserProviderCallBack;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 0) || (2 == paramInt1)) && (paramInt2 != 0);
  }
  
  public int b(long paramLong, int paramInt)
  {
    return 0;
  }
  
  public void b()
  {
    this.a.getFileManagerNotifyCenter().deleteObserver(this.h);
  }
  
  public void b(long paramLong)
  {
    int i = (int)paramLong;
    if (i >= this.e.size()) {
      return;
    }
    String str = ((IFileViewerAdapter)this.e.get(i)).o();
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!localDataLineHandler.h.d())
    {
      this.a.getApplicationContext().startActivity(new Intent(this.a.getApplicationContext(), PrinterDefaultActivity.class));
      return;
    }
    localDataLineHandler.e.a(this.a.getApplicationContext(), str);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    paramInt1 = (int)paramLong;
    if (paramInt1 >= this.e.size()) {
      return;
    }
    IFileViewerAdapter localIFileViewerAdapter = (IFileViewerAdapter)this.e.get(paramInt1);
    if (localIFileViewerAdapter.m() == 0)
    {
      this.a.getOnlineFileSessionCenter().c(localIFileViewerAdapter.a());
      return;
    }
    this.a.getFileManagerEngine().a(localIFileViewerAdapter.a());
  }
  
  public void b(String paramString) {}
  
  public Intent c(long paramLong, int paramInt1, int paramInt2)
  {
    paramInt1 = (int)paramLong;
    if (paramInt1 >= this.e.size()) {
      return null;
    }
    FileManagerEntity localFileManagerEntity = ((IFileViewerAdapter)this.e.get(paramInt1)).r();
    if (localFileManagerEntity == null) {
      return null;
    }
    return QFileUtils.b(this.a, null, localFileManagerEntity);
  }
  
  public void c(long paramLong)
  {
    int i = (int)paramLong;
    if (i >= this.e.size()) {
      return;
    }
    FileManagerEntity localFileManagerEntity = ((IFileViewerAdapter)this.e.get(i)).r();
    if (localFileManagerEntity == null) {
      return;
    }
    Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
    DatalineDeviceChooseModel.a(localFileManagerEntity).a(localContext, this.a, new MediaFileBrowseProcessorBase.3(this, localFileManagerEntity, localContext));
  }
  
  public void c(long paramLong, int paramInt) {}
  
  public void c(String paramString) {}
  
  public boolean c()
  {
    return true;
  }
  
  protected void d()
  {
    this.a.getFileManagerNotifyCenter().addObserver(this.h);
  }
  
  public void d(long paramLong)
  {
    int i = (int)paramLong;
    if (i >= this.e.size()) {
      return;
    }
    FileManagerEntity localFileManagerEntity = ((IFileViewerAdapter)this.e.get(i)).r();
    if (localFileManagerEntity == null) {
      return;
    }
    FileOperaterUtils.b(null, localFileManagerEntity).onClick(null);
  }
  
  public void d(String paramString) {}
  
  public boolean e(long paramLong)
  {
    int i = (int)paramLong;
    if (i >= this.e.size()) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = ((IFileViewerAdapter)this.e.get(i)).r();
    if (localFileManagerEntity == null) {
      return false;
    }
    return QQFileManagerUtil.o(localFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.MediaFileBrowseProcessorBase
 * JD-Core Version:    0.7.0.1
 */