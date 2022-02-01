package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.core.DirectForwarder;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.api.IFileAssistantExt;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils.FileModelOpenVideoBrowser;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.openbrowser.LocalMediaFileBrowseProcessor;
import com.tencent.mobileqq.filemanager.openbrowser.RecentMediaFileBrowseProcessor;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.QFileClickableSpan;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService.BrowserInfo;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocsListFragment;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileProcessor;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.open.pcpush.OpenFileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import com.tencent.wstt.SSCM.Utils;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqdataline.QQProxyForDataline;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavUtil;
import cooperation.troop.TroopFileProxyActivity;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class QQFileTempUtilsImpl
  implements IQQFileTempUtils
{
  private static final String TAG = "QQFileTempUtilsImpl";
  DataLineObserver mDataLineObserver = null;
  
  private FileManagerEntity getweiyunFileEntity(QQAppInterface paramQQAppInterface, WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.getFileManagerRSCenter().a(paramWeiYunFileInfo.a);
    if (localFileManagerEntity != null) {
      return localFileManagerEntity;
    }
    paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().c(paramWeiYunFileInfo.a);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface;
    }
    return FileManagerUtil.a(paramWeiYunFileInfo);
  }
  
  private void openTroopVideo(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString, View paramView)
  {
    CommonFileBrowserParams localCommonFileBrowserParams = getCommonFileBrowserParams(paramQQAppInterface, paramContext, paramFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_qlink_enter_recent", paramBoolean);
    if ((paramString != null) && (paramString.trim().length() != 0)) {
      localBundle.putString("c2c_discussion_recentfile", paramString);
    }
    localCommonFileBrowserParams.a(localBundle);
    new FileBrowserCreator(paramContext, localCommonFileBrowserParams).a(7);
    paramQQAppInterface = new RecentMediaFileBrowseProcessor(paramQQAppInterface, paramString, paramFileManagerEntity).a();
    if ((paramView != null) && ((paramView.getId() == 2131366781) || (paramView.getId() == 2131368461))) {
      paramQQAppInterface.a(AnimationUtils.a(paramView));
    }
    ((IMediaBrowserService)QRoute.api(IMediaBrowserService.class)).browserFile(paramContext, paramQQAppInterface);
  }
  
  public void addDatalineObserver()
  {
    if (this.mDataLineObserver != null) {
      return;
    }
    this.mDataLineObserver = new QQFileTempUtilsImpl.4(this);
    getApp().addObserver(this.mDataLineObserver);
  }
  
  public void addObserver(FMObserver paramFMObserver)
  {
    ((QQAppInterface)getApp()).getFileManagerNotifyCenter().addObserver(paramFMObserver);
  }
  
  public boolean bShowFlowDialog(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    return FileModel.a(paramFileManagerEntity).a(paramBoolean);
  }
  
  public void cancelDatalineFile(FileManagerEntity paramFileManagerEntity)
  {
    getDatalineHandler().a(0, paramFileManagerEntity.uniseq, false);
  }
  
  public void changeKingCardWording(QQCustomDialog paramQQCustomDialog, Context paramContext, CharSequence paramCharSequence)
  {
    if ((KingCardProcessor.c().b.a) && (!TMSManager.a().b())) {
      paramQQCustomDialog.setMessageWithoutAutoLink(KingCardProcessor.c().b.a(paramContext, paramCharSequence));
    }
  }
  
  public boolean checkEnds(String paramString, String[] paramArrayOfString)
  {
    return OpenFileUtil.a(paramString, paramArrayOfString);
  }
  
  public boolean checkFileWithCUKingCardHelper(Activity paramActivity, int paramInt, IQQFileTempUtils.FileModelOpenVideoBrowser paramFileModelOpenVideoBrowser)
  {
    return CUKingCardHelper.a(paramActivity, 2, new QQFileTempUtilsImpl.11(this, paramFileModelOpenVideoBrowser, paramActivity, paramInt), "");
  }
  
  public boolean checkFileWithFreeWifiHelper(Activity paramActivity, int paramInt, IQQFileTempUtils.FileModelOpenVideoBrowser paramFileModelOpenVideoBrowser)
  {
    return FreeWifiHelper.a(paramActivity, 3, new QQFileTempUtilsImpl.10(this, paramFileModelOpenVideoBrowser, paramActivity, paramInt));
  }
  
  public boolean checkNotifyDeviceOnline(BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramBaseQQAppInterface = (DataLineHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    boolean bool1 = paramBaseQQAppInterface.a();
    boolean bool2 = paramBaseQQAppInterface.b();
    return (bool1) && (bool2);
  }
  
  public void checkPermission(AppActivity paramAppActivity, View.OnClickListener paramOnClickListener)
  {
    if (!CheckPermission.isHasStoragePermission(paramAppActivity))
    {
      CheckPermission.requestSDCardPermission(paramAppActivity, new QQFileTempUtilsImpl.5(this, paramOnClickListener));
      return;
    }
    paramOnClickListener.onClick(null);
  }
  
  public boolean checkStatusToResume(Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (((paramFileManagerEntity.status == 0) || (paramFileManagerEntity.status == 3)) && (((paramActivity instanceof ChatActivity)) || ((paramActivity instanceof SplashActivity))) && (!paramFileManagerEntity.bSend))
    {
      ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().a(paramFileManagerEntity.nSessionId);
      return true;
    }
    return false;
  }
  
  public boolean checkWifiWithCUKingCardHelper(boolean paramBoolean, Activity paramActivity, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 2;
    }
    return CUKingCardHelper.a(paramActivity, i, new QQFileTempUtilsImpl.9(this, paramFMDialogInterface), "");
  }
  
  public boolean checkWifiWithFreeWifiHelper(boolean paramBoolean, Activity paramActivity, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    return FreeWifiHelper.a(paramActivity, i, new QQFileTempUtilsImpl.8(this, paramFMDialogInterface));
  }
  
  public void clearAllData(BaseQQAppInterface paramBaseQQAppInterface)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerProxy().c();
  }
  
  public IFileAssistantExt createFileAssistantExt()
  {
    return new FileAssistantExt();
  }
  
  public URL createFilePicDrawlableURLWithSend(FileManagerEntity paramFileManagerEntity)
  {
    return FilePicURLDrawlableHelper.a(paramFileManagerEntity);
  }
  
  public ForwardFileInfo createForwardFileInfo(FileManagerEntity paramFileManagerEntity)
  {
    return ForwardFileOption.a(paramFileManagerEntity);
  }
  
  public void createShortcut(BaseQQAppInterface paramBaseQQAppInterface, Intent paramIntent, String paramString, Bitmap paramBitmap)
  {
    QQUtils.a((QQAppInterface)paramBaseQQAppInterface, paramIntent, paramString, paramBitmap);
  }
  
  public void createThumbWithOrig(FileManagerEntity paramFileManagerEntity)
  {
    FilePicURLDrawlableHelper.a(paramFileManagerEntity);
  }
  
  public Bitmap decodeFileWithBufferedStream(String paramString, BitmapFactory.Options paramOptions)
  {
    return FilePicURLDrawlableHelper.a(paramString, paramOptions);
  }
  
  public boolean deleteFile(String paramString)
  {
    return FileUtil.c(paramString);
  }
  
  public void deleteObserver(FMObserver paramFMObserver)
  {
    ((QQAppInterface)getApp()).getFileManagerNotifyCenter().deleteObserver(paramFMObserver);
  }
  
  public void deleteOfflineFile(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().a(paramString1, paramString2, paramString3, paramString4, paramBoolean);
  }
  
  public void doJumpAction(Context paramContext, String paramString)
  {
    paramContext = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramContext, paramString);
    if (paramContext != null) {
      paramContext.a();
    }
  }
  
  public void doWithWifiChecked(FileManagerEntity paramFileManagerEntity, boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    FileModel.a(paramFileManagerEntity).a(paramBoolean, paramContext, paramFMDialogInterface);
  }
  
  public String downLoadDiscThumb(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().a(paramFileManagerEntity, paramInt);
  }
  
  public void downloadDatalineFile(FileManagerEntity paramFileManagerEntity)
  {
    DataLineHandler localDataLineHandler = getDatalineHandler();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramFileManagerEntity.uniseq));
    if (!localDataLineHandler.a(localArrayList)) {
      FMToastUtil.a(2131692553);
    }
  }
  
  public String downloadDiscVideoThumb(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().b(paramFileManagerEntity);
  }
  
  public String downloadOfflineVideoThumb(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().a(paramFileManagerEntity);
  }
  
  public int dp2px(float paramFloat, Resources paramResources)
  {
    return AIOUtils.b(paramFloat, paramResources);
  }
  
  public int dp2px(int paramInt, Resources paramResources)
  {
    return AIOUtils.b(paramInt, paramResources);
  }
  
  public boolean favBuilderNewFile(Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    BaseQQAppInterface localBaseQQAppInterface = getApp();
    return QfavBuilder.a().a((QQAppInterface)localBaseQQAppInterface, paramActivity, paramFileManagerEntity, null, true);
  }
  
  public boolean favBuilderNewFile(Activity paramActivity, String paramString)
  {
    return QfavBuilder.a().a((QQAppInterface)getApp(), paramActivity, paramString);
  }
  
  public boolean favBuilderNewLink(Activity paramActivity, String paramString)
  {
    String str = getApp().getCurrentUin();
    return QfavBuilder.a(paramString).c(str).a(paramActivity, str);
  }
  
  public ContentValues favUtilhandleFileEntry(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean)
  {
    return QfavUtil.a(paramBaseQQAppInterface, paramFileManagerEntity, paramString, paramBoolean);
  }
  
  public ContentValues favUtilhandleWeiyunFile(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return QfavUtil.a(paramWeiYunFileInfo);
  }
  
  public String formatNewRefreshTime(long paramLong)
  {
    return QfileTimeUtils.b(paramLong);
  }
  
  public void forwardFile(Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    QFileUtils.b((QQAppInterface)getApp(), paramActivity, paramFileManagerEntity);
  }
  
  public boolean forwardFileManagerEntity(FileManagerEntity paramFileManagerEntity)
  {
    return getDatalineHandler().a().a(paramFileManagerEntity);
  }
  
  public BaseQQAppInterface getApp()
  {
    return QQFileManagerUtil.a();
  }
  
  public Intent getChatActivityIntent(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, ChatActivity.class.getName());
    return AIOUtils.a(localIntent, new int[] { 1 });
  }
  
  public CommonFileBrowserParams getCommonFileBrowserParams(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    return new CommonFileBrowserParams((QQAppInterface)getApp(), paramContext, paramFileManagerEntity, paramInt);
  }
  
  public DataLineHandler getDatalineHandler()
  {
    return (DataLineHandler)getApp().getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
  }
  
  public int getDefaultTarget(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((DataLineHandler)((QQAppInterface)paramBaseQQAppInterface).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).d();
  }
  
  public URLDrawable getDrawable(URL paramURL)
  {
    return URLDrawableHelper.getDrawable(paramURL);
  }
  
  public long getDuration(String paramString)
  {
    return ShortVideoUtils.getDuration(paramString);
  }
  
  public int getExifRotation(String paramString)
  {
    return URLDrawableHelper.getExifRotation(paramString);
  }
  
  public String getExtension(String paramString)
  {
    return FileUtil.a(paramString);
  }
  
  public ArrayList<FavFileInfo> getFavFiles()
  {
    return ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getFavFiles();
  }
  
  public String getFileDirectoryOf(String paramString)
  {
    return FileUtil.b(paramString);
  }
  
  public FileManagerEntity getFileEntityByUniseq(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().b(paramLong, paramString, paramInt);
  }
  
  public int[] getFileMediaInfo(String paramString)
  {
    int i = FileManagerUtil.a(paramString);
    if (i == 0)
    {
      if (FileUtils.fileExistsAndNotEmpty(paramString))
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        FilePicURLDrawlableHelper.a(paramString, localOptions);
        i = URLDrawableHelper.getExifRotation(paramString);
        if ((i != 90) && (i != 270)) {
          return new int[] { localOptions.outWidth, localOptions.outHeight, 0 };
        }
        return new int[] { localOptions.outHeight, localOptions.outWidth, 0 };
      }
      return new int[] { 0, 0, 0 };
    }
    if (i == 2)
    {
      paramString = ShortVideoUtils.getVideoFileRtAndTime(paramString);
      return new int[] { paramString[0], paramString[1], paramString[2] };
    }
    return null;
  }
  
  public long getFileSize(String paramString)
  {
    return FileUtil.a(paramString);
  }
  
  public ArrayList<FileInfo> getFiles(String paramString, boolean paramBoolean, int paramInt)
  {
    return FileUtil.a(paramString, paramBoolean, paramInt);
  }
  
  public int getForwardId()
  {
    return ForwardOrderManager.a().a();
  }
  
  public int getForwardUtilsForwardTypeFILE()
  {
    return 0;
  }
  
  public Friends getFriendsByFriendsManager(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    FriendsManager localFriendsManager = (FriendsManager)((QQAppInterface)paramBaseQQAppInterface).getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramBaseQQAppInterface = paramFileManagerEntity.peerUin;
    if (paramFileManagerEntity.peerType == 3000) {
      paramBaseQQAppInterface = paramFileManagerEntity.selfUin;
    }
    return localFriendsManager.e(paramBaseQQAppInterface);
  }
  
  public int getFromStatisticAssist(Context paramContext, String paramString1, String paramString2)
  {
    return StatisticAssist.a(paramContext, paramString1, paramString2);
  }
  
  public String getHistoryGroupByTime(long paramLong)
  {
    return QfileTimeUtils.a(paramLong);
  }
  
  public int getImageDegree(String paramString)
  {
    return MediaStoreUtil.a(paramString);
  }
  
  public Bitmap getImageThumbnail(String paramString, int paramInt1, int paramInt2)
  {
    return MediaStoreUtil.a(paramString, paramInt1, paramInt2);
  }
  
  public Intent getIntentForFileBrowserActivity(Activity paramActivity)
  {
    return new Intent(paramActivity, FileBrowserActivity.class);
  }
  
  public boolean getIsOnline(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((DataLineHandler)((QQAppInterface)paramBaseQQAppInterface).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).b(1);
  }
  
  public boolean getIsQRing()
  {
    return JumpShareUtils.a;
  }
  
  public String getJumpActivityName()
  {
    return JumpActivity.class.getName();
  }
  
  public int getMsfConnectedNetType()
  {
    return BaseApplicationImpl.sApplication.getMsfConnectedNetType();
  }
  
  public MessageCache getMsgCache(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMsgCache();
  }
  
  public List<MessageRecord> getMsgList(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade().a(paramString, paramInt);
  }
  
  public String getMultiMsgConstantEXTRAKEYOUTESTUIN()
  {
    return "outest_uin";
  }
  
  public String getMultiMsgConstantEXTRAKEYOUTESTUINTYPE()
  {
    return "outest_uintype";
  }
  
  public String getMultiMsgConstantEXTRAKEYOUTESTUNISEQ()
  {
    return "outest_uniseq";
  }
  
  public int getNetWorkType(Context paramContext)
  {
    return Utils.a(paramContext);
  }
  
  public String getNickByDiscussionManager(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = ((DiscussionManager)((QQAppInterface)paramBaseQQAppInterface).getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(String.valueOf(paramString));
    if ((paramBaseQQAppInterface != null) && (paramBaseQQAppInterface.discussionName != null))
    {
      if ((paramBaseQQAppInterface != null) && (paramBaseQQAppInterface.discussionName != null) && (paramBaseQQAppInterface.discussionName.length() > 14)) {
        return paramBaseQQAppInterface.discussionName;
      }
      return paramBaseQQAppInterface.discussionName;
    }
    return "";
  }
  
  public String getNickName(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    return ContactUtils.a((QQAppInterface)paramBaseQQAppInterface, paramString, paramInt);
  }
  
  public MessageRecord getPrimaryStructMsg(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    return MultiMsgUtil.a((QQAppInterface)paramBaseQQAppInterface, paramMessageRecord);
  }
  
  public long getProgress(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerRSCenter().a(paramString, paramLong1, paramLong2, paramInt);
  }
  
  public Pair<StringBuilder, StringBuilder> getQRCodeResult(Context paramContext, File paramFile)
  {
    return JumpShareUtils.a(paramContext, paramFile);
  }
  
  public String getSUNIFORMABSDKDOWNLOADCANCEL()
  {
    return "Stop_download_2-1_3-1";
  }
  
  public String getSUNIFORMABSDKDOWNLOADENTER()
  {
    return "Start_download_2-0_3-0";
  }
  
  public String getSUNIFORMABSDKDOWNLOADFAILD()
  {
    return "Stop_download_2-0_3-0";
  }
  
  public String getSUNIFORMABSDKDOWNLOADPAUSE()
  {
    return "Stop_download_2-2_3-0";
  }
  
  public String getSUNIFORMABSDKDOWNLOADRUN()
  {
    return "Start_download_2-3_3-0";
  }
  
  public String getSUNIFORMABSDKDOWNLOADSUCC()
  {
    return "Complete_download_2_0";
  }
  
  public String getSUNIFORMGENDOWNLOADCANCEL()
  {
    return "Stop_download_2-1_3-1";
  }
  
  public String getSUNIFORMGENDOWNLOADENTER()
  {
    return "Start_download_2-0_3-1";
  }
  
  public String getSUNIFORMGENDOWNLOADFAILD()
  {
    return "Stop_download_2-0_3-1";
  }
  
  public String getSUNIFORMGENDOWNLOADPAUSE()
  {
    return "Stop_download_2-2_3-1";
  }
  
  public String getSUNIFORMGENDOWNLOADRUN()
  {
    return "Start_download_2-3_3-1";
  }
  
  public String getSUNIFORMGENDOWNLOADSUCC()
  {
    return "Complete_download_2_1";
  }
  
  public SpannableString getSpannableString(String paramString, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface, ColorStateList paramColorStateList, int paramInt1, int paramInt2)
  {
    paramString = new SpannableString(paramString);
    paramString.setSpan(new QFileClickableSpan(new QQFileTempUtilsImpl.12(this, paramTipsClickedInterface), paramColorStateList), paramInt1, paramInt2, 33);
    return paramString;
  }
  
  public Intent getSplashActivityIntent(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("uin", paramString);
    paramContext.putExtra("uintype", 0);
    return AIOUtils.a(paramContext, null);
  }
  
  public String getTDDocFileThumbUrl(String paramString)
  {
    return TeamWorkUtils.a(paramString);
  }
  
  public TroopInfo getTroopInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    return ((TroopManager)((QQAppInterface)paramBaseQQAppInterface).getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(paramLong));
  }
  
  public String getVipType()
  {
    return VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void gotoTIMTeamworkFileUrl(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      String str1;
      if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().h())) {
        str1 = "https://docs.qq.com/desktop/m/index.html?_from=1";
      } else {
        str1 = TencentDocConvertConfigProcessor.a().h();
      }
      String str2 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(str1, "s_qq_myfile");
      localIntent.putExtra("tdsourcetag", "s_qq_myfile");
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
      if (paramBoolean)
      {
        str2 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(str1, "s_qq_myfile_banner");
        localIntent.putExtra("tdsourcetag", "s_qq_myfile_banner");
      }
      localIntent.putExtra("fragment_class", ((ITeamWorkDocsListFragment)QRoute.api(ITeamWorkDocsListFragment.class)).getCanonicalName());
      if (!((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(paramActivity, str2, localIntent.getStringExtra("tdsourcetag")))
      {
        paramActivity.startActivity(localIntent.putExtra("url", str2));
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.i("QQFileTempUtilsImpl", 1, paramActivity.toString());
    }
  }
  
  public boolean handleVipForTroopFile(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    QVipTroopFileConfig localQVipTroopFileConfig = QVipTroopFileProcessor.c();
    if (localQVipTroopFileConfig.a())
    {
      String str = VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      if (localQVipTroopFileConfig.a(paramContext, new QQFileTempUtilsImpl.2(this, paramOnClickListener), paramBoolean2, str, paramBoolean1)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasShortCut(Activity paramActivity, String[] paramArrayOfString)
  {
    return QQUtils.a(paramActivity, paramArrayOfString);
  }
  
  public long insertAIOGrayTips(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().a(paramString1, paramString2, paramInt1, paramInt2, paramString3);
  }
  
  public long insertAIOGrayTips(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, Map<String, String> paramMap, String paramString3, long paramLong1, long paramLong2, long paramLong3)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().a(paramString1, paramString2, paramInt1, paramInt2, paramMap, paramString3, paramLong1, paramLong2, paramLong3);
  }
  
  public void insertToFMList(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().a(paramFileManagerEntity);
  }
  
  public void insertToMemMap(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().d(paramFileManagerEntity);
  }
  
  public void insertToMemMapByFileManagerProxy(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerProxy().a(paramFileManagerEntity);
  }
  
  public boolean isContainChinese(String paramString)
  {
    return ContactUtils.a(paramString);
  }
  
  public boolean isFileExists(String paramString)
  {
    return FileUtil.b(paramString);
  }
  
  public boolean isKingCard()
  {
    return TMSManager.a().b();
  }
  
  public boolean isNeedCompressCut(FileManagerEntity paramFileManagerEntity)
  {
    return FilePicURLDrawlableHelper.a(paramFileManagerEntity);
  }
  
  public boolean isRunIWeiyunSaveTipsHelper(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (BaseActivity.sTopActivity != null)
    {
      ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(paramBaseQQAppInterface, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return true;
    }
    return false;
  }
  
  public boolean isShowByCUKingCardHelper(Context paramContext, boolean paramBoolean, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    paramContext = (Activity)paramContext;
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 2;
    }
    return CUKingCardHelper.a(paramContext, i, new QQFileTempUtilsImpl.6(this, paramFMDialogInterface), "");
  }
  
  public boolean isShowByFreeWifiHelper(Context paramContext, boolean paramBoolean, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    paramContext = (Activity)paramContext;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    return FreeWifiHelper.a(paramContext, i, new QQFileTempUtilsImpl.7(this, paramFMDialogInterface));
  }
  
  public boolean isUndownloadDatalineEntity(FileManagerEntity paramFileManagerEntity)
  {
    return QFileUtils.b(paramFileManagerEntity);
  }
  
  public void notifyItemStatus(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, Object paramObject, int paramInt3, String paramString2)
  {
    ((QQAppInterface)getApp()).getFileManagerNotifyCenter().a(paramLong1, paramLong2, paramString1, paramInt1, paramInt2, paramObject, paramInt3, paramString2);
  }
  
  public void notifyItemStatus(BaseQQAppInterface paramBaseQQAppInterface, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, Object paramObject, int paramInt3, String paramString2)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerNotifyCenter().a(paramLong1, paramLong2, paramString1, paramInt1, paramInt2, paramObject, paramInt3, paramString2);
  }
  
  public void notifyUpdateRecentFileAssistant(BaseQQAppInterface paramBaseQQAppInterface)
  {
    RecentUserProxy localRecentUserProxy = ((QQAppInterface)paramBaseQQAppInterface).getRecentUserProxy();
    RecentUser localRecentUser = localRecentUserProxy.a(QFileAssistantUtils.a(paramBaseQQAppInterface), 0);
    localRecentUser.lastmsgtime = MessageCache.a();
    localRecentUserProxy.b(localRecentUser);
    paramBaseQQAppInterface = paramBaseQQAppInterface.getHandler(Conversation.class);
    if (paramBaseQQAppInterface != null) {
      paramBaseQQAppInterface.sendEmptyMessage(1009);
    }
  }
  
  public void onResultByDataLineHandler(boolean paramBoolean, long paramLong, int paramInt, String paramString, BaseQQAppInterface paramBaseQQAppInterface)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (!paramBoolean)
    {
      localDataLineHandler.OnSessionComplete(paramLong, 41, paramInt);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      localDataLineHandler.OnSessionComplete(paramLong, 0, paramInt);
      return;
    }
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    paramBaseQQAppInterface = localQQAppInterface.getMessageFacade().a(paramInt).a(paramLong);
    if (paramBaseQQAppInterface == null) {
      return;
    }
    paramBaseQQAppInterface.serverPath = paramString;
    paramBaseQQAppInterface.nOpType = 1;
    paramBaseQQAppInterface.bIsSended = true;
    paramBaseQQAppInterface.bIsTransfering = false;
    if (paramBaseQQAppInterface.entityID != 0L)
    {
      paramString = localQQAppInterface.getFileManagerDataCenter().a(paramBaseQQAppInterface.entityID);
      if (paramString != null)
      {
        paramString.status = 1;
        paramString.Uuid = paramBaseQQAppInterface.serverPath;
      }
    }
    if (localDataLineHandler.a(paramBaseQQAppInterface)) {
      localDataLineHandler.a(paramBaseQQAppInterface);
    }
  }
  
  public void openAIO(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    paramContext.startActivity(localIntent);
  }
  
  public void openFavorite(Activity paramActivity, String paramString, long paramLong)
  {
    QfavHelper.a(paramActivity, paramString, paramLong);
  }
  
  public void openFileBrowserByFileInfo(Context paramContext, FileInfo paramFileInfo, int paramInt, String paramString, View paramView)
  {
    paramFileInfo = FileManagerUtil.a(paramFileInfo);
    paramFileInfo.nFileType = paramInt;
    paramFileInfo.setFilePath(paramString);
    paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramInt != 0) && (paramInt != 2))
    {
      paramFileInfo = new FileModelAdapter(paramString, paramFileInfo);
      paramString = new FileBrowserParam().a(8);
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(paramContext, paramFileInfo, paramString);
      return;
    }
    paramFileInfo = new LocalMediaFileBrowseProcessor(paramString, paramFileInfo).a();
    paramFileInfo.a(AnimationUtils.a(paramView));
    ((IMediaBrowserService)QRoute.api(IMediaBrowserService.class)).browserFile(paramContext, paramFileInfo);
  }
  
  public void openLocalFileViewBrowser(Activity paramActivity, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap, FileInfo paramFileInfo, View paramView, FileManagerEntity paramFileManagerEntity)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramFileManagerEntity.nFileType != 0) && (paramFileManagerEntity.nFileType != 2))
    {
      paramLinkedHashMap = new FileModelAdapter(localQQAppInterface, paramFileManagerEntity);
      paramFileInfo = new FileBrowserParam().a(8);
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(paramActivity, paramLinkedHashMap, paramFileInfo);
      return;
    }
    paramFileManagerEntity = new ArrayList();
    if (paramLinkedHashMap != null)
    {
      Iterator localIterator = paramLinkedHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        paramFileManagerEntity.addAll((Collection)paramLinkedHashMap.get((String)localIterator.next()));
      }
    }
    paramLinkedHashMap = new LocalMediaFileBrowseProcessor(localQQAppInterface, paramFileManagerEntity, paramFileInfo).a();
    if ((paramView != null) && ((paramView.getId() == 2131366781) || (paramView.getId() == 2131368461))) {
      paramLinkedHashMap.a(AnimationUtils.a(paramView));
    }
    ((IMediaBrowserService)QRoute.api(IMediaBrowserService.class)).browserFile(paramActivity, paramLinkedHashMap);
  }
  
  public void openPCFile(Activity paramActivity)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("string_from", false);
    localBundle.putBoolean("string_uin", false);
    localBundle.putLong("device_din", 0L);
    localBundle.putInt("sTitleID", 0);
    QQProxyForDataline.a(paramActivity, localBundle, "com.qqdataline.mpfile.LiteMpFileMainActivity");
  }
  
  public void openQQBrowserWithoutAD(Context paramContext, String paramString)
  {
    VasWebviewUtil.b(paramContext, paramString, -1L, null, false, 0);
  }
  
  public void openRencentFileBrowser(Activity paramActivity, ForwardFileInfo paramForwardFileInfo)
  {
    Intent localIntent = new Intent(paramActivity, FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramForwardFileInfo);
    paramActivity.startActivityForResult(localIntent, 102);
  }
  
  public void openRencentFileBrowserOnItemClick(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, boolean paramBoolean1, String paramString, View paramView, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramFileManagerEntity.nFileType == 13)
    {
      if (paramBoolean2)
      {
        ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).clickWebTDDocAndUpdateTitle(paramFileManagerEntity.Uuid, paramContext, 3, paramFileManagerEntity, (QQAppInterface)paramBaseQQAppInterface);
        return;
      }
      if (paramBoolean3) {
        ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).clickWebTDDocAndUpdateTitle(paramFileManagerEntity.Uuid, paramContext, 20, paramFileManagerEntity, (QQAppInterface)paramBaseQQAppInterface);
      }
      return;
    }
    if ((paramFileManagerEntity.nFileType == 2) && (!FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())))
    {
      if ((paramFileManagerEntity.isSend()) && (paramFileManagerEntity.status != 1) && (paramFileManagerEntity.status != -1))
      {
        FMToastUtil.a(HardCodeUtil.a(2131692368));
        return;
      }
      if (!NetworkUtil.isNetSupport(paramBaseQQAppInterface.getApplicationContext()))
      {
        FMToastUtil.a(2131692554);
        return;
      }
      if ((paramFileManagerEntity.peerType != 0) && (paramFileManagerEntity.peerType != 3000))
      {
        paramBaseQQAppInterface = getCommonFileBrowserParams((QQAppInterface)paramBaseQQAppInterface, paramContext, paramFileManagerEntity, 10001);
        paramFileManagerEntity = new Bundle();
        paramFileManagerEntity.putBoolean("from_qlink_enter_recent", paramBoolean1);
        if ((paramString != null) && (paramString.trim().length() != 0)) {
          paramFileManagerEntity.putString("c2c_discussion_recentfile", paramString);
        }
        paramBaseQQAppInterface.a(paramFileManagerEntity);
        paramBaseQQAppInterface = new FileBrowserCreator(paramContext, paramBaseQQAppInterface);
        paramBaseQQAppInterface.a(7);
        paramBaseQQAppInterface.a();
        return;
      }
    }
    paramBaseQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramFileManagerEntity.nFileType == 2) && (paramFileManagerEntity.peerType == 1) && (!QFileUtils.a(paramBaseQQAppInterface)))
    {
      openTroopVideo(paramBaseQQAppInterface, paramContext, paramFileManagerEntity, paramBoolean1, paramString, paramView);
      return;
    }
    if ((paramFileManagerEntity.nFileType != 0) && (paramFileManagerEntity.nFileType != 2))
    {
      paramView = new Bundle();
      paramView.putBoolean("from_qlink_enter_recent", paramBoolean1);
      if ((paramString != null) && (paramString.trim().length() != 0)) {
        paramView.putString("c2c_discussion_recentfile", paramString);
      }
      paramBaseQQAppInterface = new FileModelAdapter(paramBaseQQAppInterface, paramFileManagerEntity);
      paramBaseQQAppInterface.a(paramView);
      paramFileManagerEntity = new FileBrowserParam().a(7).a(paramString);
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(paramContext, paramBaseQQAppInterface, paramFileManagerEntity);
      return;
    }
    paramBaseQQAppInterface = new RecentMediaFileBrowseProcessor(paramBaseQQAppInterface, paramString, paramFileManagerEntity).a();
    if ((paramView != null) && ((paramView.getId() == 2131366781) || (paramView.getId() == 2131368461))) {
      paramBaseQQAppInterface.a(AnimationUtils.a(paramView));
    }
    ((IMediaBrowserService)QRoute.api(IMediaBrowserService.class)).browserFile(paramContext, paramBaseQQAppInterface);
  }
  
  public void openTroopFilerDetailBrowse(Activity paramActivity, ForwardFileInfo paramForwardFileInfo)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, TroopFileDetailBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramForwardFileInfo);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("forward_from_troop_file", true);
    localIntent.putExtra("not_forward", true);
    localIntent.putExtra("last_time", 0);
    paramActivity.startActivityForResult(localIntent, 102);
  }
  
  public void openWeiYunFileBrowser(Context paramContext, ArrayList<WeiYunFileInfo> paramArrayList, WeiYunFileInfo paramWeiYunFileInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getApp();
    int i = FileManagerUtil.a(paramWeiYunFileInfo.c);
    if ((i != 0) && (i != 2))
    {
      paramArrayList = new FileModelAdapter(localQQAppInterface, getweiyunFileEntity(localQQAppInterface, paramWeiYunFileInfo));
      paramWeiYunFileInfo = new FileBrowserParam().a(9);
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(paramContext, paramArrayList, paramWeiYunFileInfo);
      return;
    }
    paramArrayList = new RecentMediaFileBrowseProcessor(localQQAppInterface, paramArrayList, paramWeiYunFileInfo).a();
    ((IMediaBrowserService)QRoute.api(IMediaBrowserService.class)).browserFile(paramContext, paramArrayList);
  }
  
  public long prepareForwardByDataLineMsgRecord(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3, BaseQQAppInterface paramBaseQQAppInterface, int paramInt4)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.fileUuid = paramString3;
    if (paramString2 != null) {
      localDataLineMsgRecord.uOwnerUin = Long.valueOf(paramString2).longValue();
    }
    localDataLineMsgRecord.selfuin = paramString1;
    localDataLineMsgRecord.filename = paramString4;
    if (paramString5 != null)
    {
      localDataLineMsgRecord.thumbPath = FileUtil.a(FileUtil.a(paramBaseQQAppInterface.getApplication()), QQFileManagerUtil.e(paramString5));
      FileUtils.copyFile(paramString5, localDataLineMsgRecord.thumbPath);
    }
    localDataLineMsgRecord.filesize = paramLong;
    localDataLineMsgRecord.busId = paramInt2;
    localDataLineMsgRecord.forwardTroopFileEntrance = paramInt3;
    if (paramInt1 == 0)
    {
      localDataLineMsgRecord.fileFrom = 1;
      localDataLineMsgRecord.nOpType = 29;
    }
    else
    {
      localDataLineMsgRecord.fileFrom = 2;
      localDataLineMsgRecord.nOpType = 31;
    }
    localDataLineMsgRecord.istroop = paramInt1;
    paramString1 = (DataLineHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localDataLineMsgRecord.sessionid = paramString1.a(0, paramInt4).longValue();
    localDataLineMsgRecord.msg = "";
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((SVIPHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.progress = 0.2F;
    localDataLineMsgRecord.fileMsgStatus = 0L;
    localDataLineMsgRecord.msgtype = DataLineHandler.a(0);
    localDataLineMsgRecord.bIsTransfering = true;
    ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade().a(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
    paramString1.a(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)DataLineHandler.b(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
    return localDataLineMsgRecord.sessionid;
  }
  
  public void previewFavImageFile(Activity paramActivity)
  {
    FileManagerUtil.a(paramActivity);
  }
  
  public void previewImage(Activity paramActivity, FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    FileManagerUtil.a(paramActivity, paramFileManagerEntity, paramBoolean);
  }
  
  public FileManagerEntity queryFileEntityBySessionId(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().a(paramLong);
  }
  
  public FileManagerEntity queryFileEntityByUniseq(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().a(paramLong, paramString, paramInt);
  }
  
  public List<FileManagerEntity> queryFileManagerEntityByNameAndSize(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().a(paramString, paramLong);
  }
  
  public FileManagerEntity queryFileManagerEntityBySessionId(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().b(paramLong);
  }
  
  public FileManagerEntity queryFileManagerEntityByWeiYunFileIdForMemory(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().d(paramString);
  }
  
  public List<FileManagerEntity> queryMaxRecentReocrds(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerProxy().a();
  }
  
  public void removeDatalineObserver()
  {
    if (this.mDataLineObserver != null)
    {
      getApp().removeObserver(this.mDataLineObserver);
      this.mDataLineObserver = null;
    }
  }
  
  public void reportAppStoreDownloadSuc() {}
  
  public ArrayList<String> reqDnsForIpList(String paramString, boolean paramBoolean, int paramInt)
  {
    return InnerDns.getInstance().reqDnsForIpList(paramString, 1019, paramBoolean, paramInt);
  }
  
  public void resetFileAssistantOnlineMark(BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramBaseQQAppInterface = (DataLineHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    paramBaseQQAppInterface.a(false);
    paramBaseQQAppInterface.b(false);
  }
  
  public void resumeByFileManagerEngine(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().a(paramLong);
  }
  
  public FileManagerEntity saveOfflineFile2WeiYun(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().a(paramFileManagerEntity, paramString);
  }
  
  public void sendFavFiles(ArrayList<FavFileInfo> paramArrayList, String paramString, int paramInt, Bundle paramBundle)
  {
    ((QQAppInterface)getApp()).getFileManagerEngine().a().sendFavFiles(paramArrayList, paramString, paramInt, paramBundle);
  }
  
  public void sendFileToDataline(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    QFileUtils.a((QQAppInterface)paramBaseQQAppInterface, paramContext, paramFileManagerEntity);
  }
  
  public void sendFiles(ArrayList<FileInfo> paramArrayList)
  {
    getDatalineHandler().a(paramArrayList);
  }
  
  public void sendFilesToDevice(String paramString, ArrayList<FileInfo> paramArrayList)
  {
    ((DeviceMsgHandle)getApp().getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramString, paramArrayList);
  }
  
  public void sendFilesWithService(ArrayList<FileInfo> paramArrayList, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    ((RouterHandler)getApp().getBusinessHandler(BusinessHandlerFactory.ROUTER_HANDLER)).a(paramArrayList, paramString, paramArrayOfByte, paramLong);
  }
  
  public FileManagerEntity sendLocalFile(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().a(paramString1, paramString2, paramString3, paramInt, paramBoolean);
  }
  
  public void sendLocalFileToTroop(Set<FileInfo> paramSet)
  {
    TroopFileProxyActivity.a.addAll(paramSet);
  }
  
  public void sendQlinkFiles(Activity paramActivity, String paramString, ArrayList<String> paramArrayList, int paramInt)
  {
    if (222 == paramInt)
    {
      paramActivity.getIntent().putExtra("string_filepaths", paramArrayList);
      paramActivity.setResult(-1, paramActivity.getIntent());
      return;
    }
    if ((333 != paramInt) && (666 != paramInt) && (3333 != paramInt) && (6666 != paramInt))
    {
      boolean bool = true;
      if ((444 != paramInt) && (555 != paramInt))
      {
        if ((777 != paramInt) && (888 != paramInt))
        {
          ((QQAppInterface)getApp()).getQQProxyForQlink().a(paramString, paramArrayList);
          paramArrayList = paramActivity.getIntent();
          paramArrayList.putExtra("_UIN_", paramString);
          paramArrayList.putExtra("_SEND_QLINK_FILE_", true);
          paramActivity.setResult(-1, paramActivity.getIntent());
          return;
        }
        paramString = new Bundle();
        paramString.putStringArrayList("string_filepaths", paramArrayList);
        ((QQAppInterface)getApp()).getQQProxyForQlink();
        QQProxyForQlink.a(paramActivity, 16, paramString);
        return;
      }
      paramString = paramActivity.getIntent();
      if (444 != paramInt) {
        bool = false;
      }
      paramString.putExtra("_INIT_SEND_IOS_", bool);
      paramString.putExtra("string_filepaths", paramArrayList);
      paramActivity.setResult(paramInt, paramActivity.getIntent());
      return;
    }
    paramActivity.getIntent().putExtra("string_filepaths", paramArrayList);
    paramActivity.setResult(paramInt, paramActivity.getIntent());
  }
  
  public long sendTencentDocEntity(FileManagerEntity paramFileManagerEntity)
  {
    return getDatalineHandler().a(paramFileManagerEntity);
  }
  
  public void sendWeiYunFile(FileManagerEntity paramFileManagerEntity)
  {
    getDatalineHandler().a(paramFileManagerEntity);
  }
  
  public void sendWeiYunFile(WeiYunFileInfo paramWeiYunFileInfo)
  {
    getDatalineHandler().a(paramWeiYunFileInfo);
  }
  
  public void setDefaultTarget(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    ((DataLineHandler)((QQAppInterface)paramBaseQQAppInterface).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).e(paramInt);
  }
  
  public String setEntityUuidByEntityManager(BaseQQAppInterface paramBaseQQAppInterface, MessageForFile paramMessageForFile)
  {
    EntityManager localEntityManager = paramBaseQQAppInterface.getEntityManagerFactory().createEntityManager();
    TransFileInfo localTransFileInfo = (TransFileInfo)localEntityManager.find(TransFileInfo.class, new String[] { String.valueOf(paramMessageForFile.time), String.valueOf(paramMessageForFile.msgseq), paramBaseQQAppInterface.getCurrentAccountUin(), paramMessageForFile.frienduin });
    paramMessageForFile = "";
    paramBaseQQAppInterface = paramMessageForFile;
    if (localTransFileInfo != null)
    {
      paramBaseQQAppInterface = paramMessageForFile;
      if (localTransFileInfo.uuid != null) {
        paramBaseQQAppInterface = new String(localTransFileInfo.uuid);
      }
    }
    localEntityManager.close();
    return paramBaseQQAppInterface;
  }
  
  public void setFileAssistantOnlineMark(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean)
  {
    paramBaseQQAppInterface = (DataLineHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramInt == 0)
    {
      paramBaseQQAppInterface.a(paramBoolean);
      return;
    }
    if (paramInt == 1) {
      paramBaseQQAppInterface.b(paramBoolean);
    }
  }
  
  public void setForwardBundle(Intent paramIntent, Bundle paramBundle)
  {
    String str = paramBundle.getString("key_direct_show_uin", "");
    if ((!TextUtils.isEmpty(str)) && (AppConstants.DATALINE_PC_UIN.equals(str)))
    {
      paramBundle.putString("key_direct_show_uin", "3636666661");
      paramBundle.putInt("key_direct_show_uin_type", 0);
      paramIntent.putExtra("key_direct_show_uin_type", 0);
      paramIntent.putExtra("key_direct_show_uin", "3636666661");
    }
  }
  
  public void setImageDegree(String paramString, int paramInt)
  {
    MediaStoreUtil.a(paramString, paramInt);
  }
  
  public void setStorageRptNeedScan(boolean paramBoolean)
  {
    StorageReport.a().a(true);
  }
  
  public BubblePopupWindow showAsDropDown(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    return BubbleContextMenu.a(paramView, paramQQCustomMenu, paramOnClickListener, paramOnDismissListener);
  }
  
  public void showDeviceChoose(Context paramContext, String paramString, List<FileManagerEntity> paramList, Set<FileInfo> paramSet, View.OnClickListener paramOnClickListener)
  {
    DatalineDeviceChooseModel.a(paramList, paramSet).a(paramContext, paramString, new QQFileTempUtilsImpl.3(this, paramOnClickListener));
  }
  
  public void speak(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getApp();
    QQAppInterface.speak(paramString);
  }
  
  public void startActivityByLinkByWeiyunFragment(Context paramContext, FileManagerEntity paramFileManagerEntity, String paramString, boolean paramBoolean)
  {
    LinkByWeiyunFragment.a(paramContext, paramFileManagerEntity, paramString, paramBoolean);
  }
  
  public void startAppStoreByTmast(String paramString, int paramInt)
  {
    QFileAppStorePromoteManager.a(paramString, paramInt);
  }
  
  public void startChatAndSendMsg(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtras(new Bundle(paramBundle));
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
  }
  
  public void startForwardActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    ForwardBaseOption.a(paramActivity, paramIntent, paramInt);
  }
  
  public void startForwardByOriginFile(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    paramIntent.putExtra("k_dataline", paramBoolean);
    paramIntent.putExtra("k_favorites", false);
    paramIntent.putExtra("forward_type", 0);
    ForwardBaseOption.a(paramActivity, paramIntent, 103);
  }
  
  public void startSeach(Activity paramActivity)
  {
    FileSearchActivity.a(paramActivity, "", new ArrayList(), false, 8);
  }
  
  public void startSeach(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    FileSearchActivity.a(paramActivity, "", new ArrayList(), false, paramInt, "", paramBundle);
  }
  
  public void updateFileEntity(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().c(paramFileManagerEntity);
  }
  
  public boolean uploadToWyForFreeWifi(Activity paramActivity, View.OnClickListener paramOnClickListener)
  {
    return FreeWifiHelper.a(paramActivity, 5, new QQFileTempUtilsImpl.1(this, paramOnClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileTempUtilsImpl
 * JD-Core Version:    0.7.0.1
 */