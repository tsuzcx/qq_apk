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
  protected int a;
  protected final QQAppInterface a;
  private final FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new MediaFileBrowseProcessorBase.4(this);
  IMediaBrowserProviderCallBack jdField_a_of_type_ComTencentMobileqqMediabrowserIMediaBrowserProviderCallBack;
  protected final ArrayList<Long> a;
  protected List<RichMediaBrowserInfo> a;
  protected final Map<String, Integer> a;
  protected final List<IFileViewerAdapter> b = new ArrayList();
  
  public MediaFileBrowseProcessorBase(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ShortVideoUtils.loadShortVideoSo(paramQQAppInterface);
  }
  
  private BaseVideoBiz a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    paramIFileViewerAdapter = paramIFileViewerAdapter.a();
    if (paramIFileViewerAdapter == null) {
      return null;
    }
    if (paramIFileViewerAdapter.peerType == 0) {
      return new VideoForC2C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIFileViewerAdapter);
    }
    if (paramIFileViewerAdapter.peerType == 3000) {
      return new VideoForDisc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIFileViewerAdapter);
    }
    if (paramIFileViewerAdapter.peerType == 1)
    {
      paramIFileViewerAdapter = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIFileViewerAdapter);
      return new VideoForTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIFileViewerAdapter);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unsuporrt peer type:");
    localStringBuilder.append(paramIFileViewerAdapter.peerType);
    QLog.w("MediaFileBrowseProcessorBase", 1, localStringBuilder.toString());
    return null;
  }
  
  private AIOFilePictureData a(int paramInt, FileInfo paramFileInfo)
  {
    AIOFilePictureData localAIOFilePictureData = new AIOFilePictureData();
    localAIOFilePictureData.jdField_a_of_type_Long = paramInt;
    localAIOFilePictureData.jdField_c_of_type_JavaLangString = paramFileInfo.c();
    localAIOFilePictureData.e = paramFileInfo.a();
    localAIOFilePictureData.jdField_c_of_type_Long = paramFileInfo.a();
    localAIOFilePictureData.g = false;
    localAIOFilePictureData.h = false;
    return localAIOFilePictureData;
  }
  
  private AIOFilePictureData a(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    AIOFilePictureData localAIOFilePictureData = new AIOFilePictureData();
    localAIOFilePictureData.jdField_a_of_type_Long = paramInt;
    Object localObject = paramFileManagerEntity.getFilePath();
    String str = "I:N";
    if (localObject != null) {
      localObject = paramFileManagerEntity.getFilePath();
    } else {
      localObject = "I:N";
    }
    localAIOFilePictureData.jdField_c_of_type_JavaLangString = ((String)localObject);
    if (paramFileManagerEntity.strLargeThumPath != null) {
      localObject = paramFileManagerEntity.strLargeThumPath;
    } else {
      localObject = "I:N";
    }
    localAIOFilePictureData.b = ((String)localObject);
    localObject = str;
    if (paramFileManagerEntity.strMiddleThumPath != null) {
      localObject = paramFileManagerEntity.strMiddleThumPath;
    }
    localAIOFilePictureData.jdField_a_of_type_JavaLangString = ((String)localObject);
    localAIOFilePictureData.e = paramFileManagerEntity.fileSize;
    localAIOFilePictureData.jdField_c_of_type_Long = paramFileManagerEntity.fileSize;
    boolean bool;
    if (paramFileManagerEntity.status == 16) {
      bool = true;
    } else {
      bool = false;
    }
    localAIOFilePictureData.g = bool;
    localAIOFilePictureData.h = paramFileManagerEntity.sendCloudUnsuccessful();
    return localAIOFilePictureData;
  }
  
  private AIOFilePictureData a(int paramInt, IFileViewerAdapter paramIFileViewerAdapter)
  {
    AIOFilePictureData localAIOFilePictureData = new AIOFilePictureData();
    localAIOFilePictureData.jdField_a_of_type_Long = paramInt;
    localAIOFilePictureData.jdField_c_of_type_JavaLangString = paramIFileViewerAdapter.g();
    localAIOFilePictureData.jdField_a_of_type_JavaLangString = paramIFileViewerAdapter.h();
    localAIOFilePictureData.b = paramIFileViewerAdapter.f();
    localAIOFilePictureData.e = paramIFileViewerAdapter.b();
    localAIOFilePictureData.jdField_c_of_type_Long = paramIFileViewerAdapter.b();
    boolean bool;
    if (paramIFileViewerAdapter.d() == 16) {
      bool = true;
    } else {
      bool = false;
    }
    localAIOFilePictureData.g = bool;
    localAIOFilePictureData.h = false;
    return localAIOFilePictureData;
  }
  
  private AIOFileVideoData a(int paramInt, FileInfo paramFileInfo)
  {
    AIOFileVideoData localAIOFileVideoData = new AIOFileVideoData();
    localAIOFileVideoData.jdField_a_of_type_Long = paramInt;
    localAIOFileVideoData.g = paramFileInfo.a();
    localAIOFileVideoData.jdField_c_of_type_Long = paramFileInfo.a();
    localAIOFileVideoData.jdField_a_of_type_JavaLangString = paramFileInfo.d();
    localAIOFileVideoData.b = paramFileInfo.c();
    localAIOFileVideoData.jdField_c_of_type_JavaLangString = paramFileInfo.c();
    localAIOFileVideoData.f = true;
    localAIOFileVideoData.isLocal = true;
    return localAIOFileVideoData;
  }
  
  private AIOFileVideoData a(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    AIOFileVideoData localAIOFileVideoData = new AIOFileVideoData();
    localAIOFileVideoData.jdField_a_of_type_Long = paramInt;
    localAIOFileVideoData.jdField_c_of_type_Long = paramFileManagerEntity.fileSize;
    localAIOFileVideoData.jdField_a_of_type_JavaLangString = paramFileManagerEntity.fileName;
    localAIOFileVideoData.d = paramFileManagerEntity.imgHeight;
    localAIOFileVideoData.jdField_c_of_type_Int = paramFileManagerEntity.imgWidth;
    if (FileUtil.a(paramFileManagerEntity.strLargeThumPath)) {
      localAIOFileVideoData.b = paramFileManagerEntity.strLargeThumPath;
    } else if (FileUtil.a(paramFileManagerEntity.strMiddleThumPath)) {
      localAIOFileVideoData.b = paramFileManagerEntity.strMiddleThumPath;
    } else if (FileUtil.a(paramFileManagerEntity.strThumbPath)) {
      localAIOFileVideoData.b = paramFileManagerEntity.strThumbPath;
    }
    localAIOFileVideoData.e = ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(paramFileManagerEntity.fileName)).b;
    if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
    {
      localAIOFileVideoData.jdField_c_of_type_JavaLangString = paramFileManagerEntity.getFilePath();
      localAIOFileVideoData.g = paramFileManagerEntity.fileSize;
      localAIOFileVideoData.f = true;
      localAIOFileVideoData.isLocal = true;
    }
    return localAIOFileVideoData;
  }
  
  private AIOFileVideoData a(int paramInt, IFileViewerAdapter paramIFileViewerAdapter)
  {
    AIOFileVideoData localAIOFileVideoData = new AIOFileVideoData();
    localAIOFileVideoData.jdField_a_of_type_Long = paramInt;
    localAIOFileVideoData.jdField_c_of_type_Long = paramIFileViewerAdapter.b();
    localAIOFileVideoData.jdField_a_of_type_JavaLangString = paramIFileViewerAdapter.a();
    if (FileUtil.a(paramIFileViewerAdapter.f())) {
      localAIOFileVideoData.b = paramIFileViewerAdapter.f();
    } else if (FileUtil.a(paramIFileViewerAdapter.h())) {
      localAIOFileVideoData.b = paramIFileViewerAdapter.h();
    }
    localAIOFileVideoData.e = ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(paramIFileViewerAdapter.a())).b;
    if (FileUtils.fileExistsAndNotEmpty(paramIFileViewerAdapter.g()))
    {
      localAIOFileVideoData.jdField_c_of_type_JavaLangString = paramIFileViewerAdapter.g();
      localAIOFileVideoData.g = paramIFileViewerAdapter.b();
      localAIOFileVideoData.f = true;
      localAIOFileVideoData.isLocal = true;
    }
    return localAIOFileVideoData;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, BaseVideoBiz paramBaseVideoBiz)
  {
    IFileVideoDownloader localIFileVideoDownloader = FileVideoDownloadManager.a(paramBaseVideoBiz);
    localIFileVideoDownloader.a(new MediaFileBrowseProcessorBase.1(this, paramBaseVideoBiz, paramLong, paramInt1, paramInt2));
    localIFileVideoDownloader.a(new MediaFileBrowseProcessorBase.2(this, paramBaseVideoBiz, paramLong, paramInt1));
    localIFileVideoDownloader.a(true);
    localIFileVideoDownloader.a();
  }
  
  private void a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    long l = paramIFileViewerAdapter.a();
    int i = paramIFileViewerAdapter.c();
    if (a(paramIFileViewerAdapter))
    {
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().b(l);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(l);
      return;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(l);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().c(paramIFileViewerAdapter.a());
  }
  
  private boolean a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.e();
    boolean bool = true;
    if (i == 10) {
      return true;
    }
    i = paramIFileViewerAdapter.d();
    if (i != 0)
    {
      if (i == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public int a(long paramLong, int paramInt)
  {
    return 0;
  }
  
  public Intent a(long paramLong, int paramInt)
  {
    return null;
  }
  
  public Intent a(long paramLong, int paramInt1, int paramInt2)
  {
    paramInt1 = (int)paramLong;
    if (paramInt1 >= this.b.size()) {
      return null;
    }
    FileManagerEntity localFileManagerEntity = ((IFileViewerAdapter)this.b.get(paramInt1)).a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, localFileManagerEntity);
  }
  
  public IMediaBrowserService.BrowserInfo a()
  {
    return new IMediaBrowserService.BrowserInfo(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
  }
  
  protected RichMediaBrowserInfo a(int paramInt, FileInfo paramFileInfo)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo;
    if (paramFileInfo.a() == 0)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = a(paramInt, paramFileInfo);
    }
    else
    {
      localRichMediaBrowserInfo = null;
    }
    if (paramFileInfo.a() == 2)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = a(paramInt, paramFileInfo);
    }
    return localRichMediaBrowserInfo;
  }
  
  protected RichMediaBrowserInfo a(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo;
    if (paramFileManagerEntity.nFileType == 0)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = a(paramInt, paramFileManagerEntity);
    }
    else
    {
      localRichMediaBrowserInfo = null;
    }
    if (paramFileManagerEntity.nFileType == 2)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = a(paramInt, paramFileManagerEntity);
    }
    return localRichMediaBrowserInfo;
  }
  
  protected RichMediaBrowserInfo a(int paramInt, IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.a();
    RichMediaBrowserInfo localRichMediaBrowserInfo;
    if (i == 0)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = a(paramInt, paramIFileViewerAdapter);
    }
    else
    {
      localRichMediaBrowserInfo = null;
    }
    if (i == 2)
    {
      localRichMediaBrowserInfo = new RichMediaBrowserInfo();
      localRichMediaBrowserInfo.baseData = a(paramInt, paramIFileViewerAdapter);
    }
    return localRichMediaBrowserInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(long paramLong)
  {
    int i = (int)paramLong;
    if (i >= this.b.size()) {
      return;
    }
    Object localObject = (IFileViewerAdapter)this.b.get(i);
    i = ((IFileViewerAdapter)localObject).c();
    if (i != 1)
    {
      if ((i != 3) && (i != 5)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(((IFileViewerAdapter)localObject).g(), null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false);
      return;
    }
    String str;
    if (((IFileViewerAdapter)localObject).a()) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    } else {
      str = ((IFileViewerAdapter)localObject).d();
    }
    localObject = ((IFileViewerAdapter)localObject).a();
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a((FileManagerEntity)localObject, str);
  }
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    int i = (int)paramLong;
    if (i >= this.b.size()) {
      return;
    }
    IFileViewerAdapter localIFileViewerAdapter = (IFileViewerAdapter)this.b.get(i);
    if (paramInt2 == 16842753)
    {
      a(paramLong, paramInt1, paramInt2, a(localIFileViewerAdapter));
      return;
    }
    if (paramInt2 == 20)
    {
      a(localIFileViewerAdapter);
      return;
    }
    a(paramLong, localIFileViewerAdapter);
  }
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    int i = (int)paramLong;
    if (i >= this.b.size()) {
      return;
    }
    FileManagerEntity localFileManagerEntity = ((IFileViewerAdapter)this.b.get(i)).a();
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
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
      }
      FileVideoDownloadManager.b(paramBundle);
      FileVideoDownloadManager.a(paramBundle, true);
      return;
    case 12: 
      FileVideoDownloadManager.a(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity.nSessionId);
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
    int i = paramIFileViewerAdapter.c();
    Object localObject1 = null;
    Object localObject2 = null;
    if (1 == i)
    {
      if (paramIFileViewerAdapter.a().isZipInnerFile) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().c(paramIFileViewerAdapter.a());
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramIFileViewerAdapter.a(), 7);
      }
    }
    else if (2 == paramIFileViewerAdapter.c())
    {
      FileManagerEngine localFileManagerEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
      String str = paramIFileViewerAdapter.e();
      if (paramIFileViewerAdapter.a() == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = paramIFileViewerAdapter.a().e;
      }
      localObject1 = localFileManagerEngine.a(str, (String)localObject1, 7, paramIFileViewerAdapter);
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqMediabrowserIMediaBrowserProviderCallBack.a(paramLong, 0, 18, 1, (String)localObject1, false);
    }
  }
  
  public void a(IMediaBrowserProviderCallBack paramIMediaBrowserProviderCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqMediabrowserIMediaBrowserProviderCallBack = paramIMediaBrowserProviderCallBack;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public boolean a()
  {
    return true;
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 0) || (2 == paramInt1)) && (paramInt2 != 0);
  }
  
  public boolean a(long paramLong)
  {
    int i = (int)paramLong;
    if (i >= this.b.size()) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = ((IFileViewerAdapter)this.b.get(i)).a();
    if (localFileManagerEntity == null) {
      return false;
    }
    return QQFileManagerUtil.e(localFileManagerEntity);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void b(long paramLong)
  {
    int i = (int)paramLong;
    if (i >= this.b.size()) {
      return;
    }
    String str = ((IFileViewerAdapter)this.b.get(i)).g();
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!localDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplicationContext().startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplicationContext(), PrinterDefaultActivity.class));
      return;
    }
    localDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplicationContext(), str);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    paramInt1 = (int)paramLong;
    if (paramInt1 >= this.b.size()) {
      return;
    }
    IFileViewerAdapter localIFileViewerAdapter = (IFileViewerAdapter)this.b.get(paramInt1);
    if (localIFileViewerAdapter.c() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(localIFileViewerAdapter.a());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localIFileViewerAdapter.a());
  }
  
  public void b(String paramString) {}
  
  public void c(long paramLong)
  {
    int i = (int)paramLong;
    if (i >= this.b.size()) {
      return;
    }
    FileManagerEntity localFileManagerEntity = ((IFileViewerAdapter)this.b.get(i)).a();
    if (localFileManagerEntity == null) {
      return;
    }
    Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
    DatalineDeviceChooseModel.a(localFileManagerEntity).a(localContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new MediaFileBrowseProcessorBase.3(this, localFileManagerEntity, localContext));
  }
  
  public void c(String paramString) {}
  
  public void d(long paramLong)
  {
    int i = (int)paramLong;
    if (i >= this.b.size()) {
      return;
    }
    FileManagerEntity localFileManagerEntity = ((IFileViewerAdapter)this.b.get(i)).a();
    if (localFileManagerEntity == null) {
      return;
    }
    FileOperaterUtils.b(null, localFileManagerEntity).onClick(null);
  }
  
  public void d(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.MediaFileBrowseProcessorBase
 * JD-Core Version:    0.7.0.1
 */