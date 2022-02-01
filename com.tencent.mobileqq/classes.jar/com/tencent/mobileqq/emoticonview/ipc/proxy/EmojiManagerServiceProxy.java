package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class EmojiManagerServiceProxy
  extends AbsEmoRuntimeServiceProxy<IEmojiManagerService>
{
  public static final String ACTION_EMOJIMANAGER_DOWNLOADAIOEMOTICON = "emojimanager_downemoticon";
  public static final String ACTION_EMOJIMANAGER_GETLOADINGPROGRESS = "emojimanager_getloadingprogress";
  public static final String ACTION_EMOJIMANAGER_HAVEINITFAV = "emojimanager_haveinitfav";
  public static final String ACTION_EMOJIMANAGER_HAVEINITSMALLANDNORMAL = "emojimanager_haveInitSmallAndNormal";
  public static final String ACTION_EMOJIMANAGER_PULLEMOTICONPACKAGE = "emojimanager_pullemoticonpackage";
  public static final String ACTION_EMOJIMANAGER_SETHAVEINITFAV = "emojimanager_setHaveInitFav";
  public static final String ACTION_EMOJIMANAGER_SETHAVEINITSMALLANDNORMAL = "emojimanager_sethaveinitsmallandnormal";
  public static final String ACTION_EMOJIMANAGER_STARTCOVERDOWNLOAD = "emojimanager_startcoverdownload";
  public static final String ACTION_EMOJIMANAGER_STARTDOWNLOADEMOSMJSON = "emojimanager_startdownloademosmjson";
  public static final String ACTION_EMOJIMANAGER_STATUSPERCENT = "emojimanager_statuspercent";
  public static final String ACTION_EMOJIMANAGER_STOPEMOTICONPACKAGE = "emojimanager_stopemoticonpackage";
  public static final String ACTION_EMOJIMANAGER_TASKSFILEEXISTS = "emojimanager_tasksfileexists";
  public static final String BUSINESS_TYPE = "businessType";
  public static final String EMOTICON_BUSINESSTYPE = "emoticon_businessType";
  public static final String EMOTICON_NEWPACKAGE = "emoticon_newPackage";
  public static final String EMOTICON_PACKAGE = "emoticon_package";
  public static final String EMOTICON_SWITCHTAB = "emoticon_switchTab";
  public static final String EMOTICON_TASKS = "emoticon_tasks";
  public static final String EMOTICON_TASKS_DOWNLOAD = "emoticon_download";
  public static final String EMOTICON_TASKS_FILEEXISTS = "emoticon_tasksfileexists";
  public static final String EPID = "epId";
  public static final String HAVE_INITFAV = "haveInitFav";
  public static final String IS_SMALLEMOTICON = "is_smallemoticon";
  public static final String JSON_TYPE = "jsonType";
  public static final String LOADING_PROGRESS = "loading_progress";
  public static final String REQ_PRAMAS = "req_pramas";
  public static final String TAG = "EmojiManagerServiceProxy";
  
  public EmojiManagerServiceProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, IEmojiManagerService.class);
  }
  
  public static EIPCResult checkMatch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if ("emojimanager_haveinitfav".equals(paramString)) {
      return onHaveInitFav((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_setHaveInitFav".equals(paramString)) {
      return onSetHaveInitFav((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_haveInitSmallAndNormal".equals(paramString)) {
      return onHaveInitSmallAndNormal((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_sethaveinitsmallandnormal".equals(paramString)) {
      return onSetHaveInitSmallAndNormal((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_getloadingprogress".equals(paramString)) {
      return onGetEmoticonPackageLoadingProgress((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_pullemoticonpackage".equals(paramString)) {
      return onPullEmoticonPackage((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_stopemoticonpackage".equals(paramString)) {
      return onStopEmoticonPackageDownload((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_startdownloademosmjson".equals(paramString)) {
      return onStartDownloadEmosmJson((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_startcoverdownload".equals(paramString)) {
      return onStartCoverDownload((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_tasksfileexists".equals(paramString)) {
      return onTasksFileExists((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_downemoticon".equals(paramString)) {
      return onDownloadAIOEmoticon((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_statuspercent".equals(paramString)) {
      return onGetStatusPercent((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    return null;
  }
  
  public static EIPCResult onDownloadAIOEmoticon(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = ((IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).downloadAIOEmoticon((Emoticon)paramBundle.getSerializable("emoticon_package"), paramBundle.getInt("emoticon_tasks"));
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putBoolean("emoticon_download", bool);
    return EIPCResult.createSuccessResult(paramBaseQQAppInterface);
  }
  
  public static EIPCResult onGetEmoticonPackageLoadingProgress(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    float f = ((IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).getEmoticonPackageLoadingProgress(paramBundle.getString("epId"));
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putFloat("loading_progress", f);
    return EIPCResult.createSuccessResult(paramBaseQQAppInterface);
  }
  
  public static EIPCResult onGetStatusPercent(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBaseQQAppInterface = (TaskStatus)((IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).getStatusMap().get(paramBundle.getString("epId"));
    float f;
    if (paramBaseQQAppInterface != null) {
      f = paramBaseQQAppInterface.getPercent();
    } else {
      f = -1.0F;
    }
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putFloat("emoticon_download", f);
    return EIPCResult.createSuccessResult(paramBaseQQAppInterface);
  }
  
  public static EIPCResult onHaveInitFav(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBaseQQAppInterface = (IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
    paramString = new Bundle();
    paramString.putBoolean("haveInitFav", paramBaseQQAppInterface.getHaveInitFav());
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onHaveInitSmallAndNormal(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBaseQQAppInterface = (IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
    paramString = new Bundle();
    paramString.putBoolean("haveInitFav", paramBaseQQAppInterface.getHaveInitSmallAndNormal());
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onPullEmoticonPackage(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramString = new StringBuilder();
    paramString.append("thread_name: ");
    paramString.append(Thread.currentThread().getName());
    QLog.d("EmojiManagerServiceProxy", 4, paramString.toString());
    ((IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).pullEmoticonPackage((EmoticonPackage)paramBundle.getSerializable("emoticon_package"), paramBundle.getBoolean("emoticon_newPackage"), paramBundle.getBoolean("emoticon_switchTab"), paramBundle.getInt("emoticon_businessType", 0));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSetHaveInitFav(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).setHaveInitFav(paramBundle.getBoolean("haveInitFav"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSetHaveInitSmallAndNormal(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).setHaveInitSmallAndNormal(paramBundle.getBoolean("haveInitFav"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onStartCoverDownload(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramString = (EmoticonPackage)paramBundle.getSerializable("emoticon_package");
    ((IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).startCoverDownload(paramString);
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onStartDownloadEmosmJson(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramString = paramBundle.getString("epId");
    paramInt = paramBundle.getInt("jsonType");
    int i = paramBundle.getInt("businessType");
    Bundle localBundle = paramBundle.getBundle("req_pramas");
    boolean bool = paramBundle.getBoolean("is_smallemoticon");
    ((IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).startDownloadEmosmJson(paramString, paramInt, localBundle, bool, i);
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onStopEmoticonPackageDownload(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).stopEmoticonPackageDownload(paramBundle.getString("epId"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onTasksFileExists(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = ((IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class)).tasksFileExists((Emoticon)paramBundle.getSerializable("emoticon_package"), paramBundle.getInt("emoticon_tasks"));
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putBoolean("emoticon_tasksfileexists", bool);
    return EIPCResult.createSuccessResult(paramBaseQQAppInterface);
  }
  
  public boolean downloadAIOEmoticon(Emoticon paramEmoticon, int paramInt)
  {
    if (this.manager != null) {
      return ((IEmojiManagerService)this.manager).downloadAIOEmoticon(paramEmoticon, paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticon_package", paramEmoticon);
    localBundle.putInt("emoticon_tasks", paramInt);
    paramEmoticon = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_downemoticon", localBundle);
    if ((paramEmoticon != null) && (paramEmoticon.isSuccess())) {
      return paramEmoticon.data.getBoolean("emoticon_download");
    }
    QLog.e("EmojiManagerServiceProxy", 4, "downloadAIOEmoticon fail.");
    return false;
  }
  
  public float getEmoticonPackageLoadingProgress(String paramString)
  {
    if (this.manager != null) {
      return ((IEmojiManagerService)this.manager).getEmoticonPackageLoadingProgress(paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("epId", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_getloadingprogress", localBundle);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getFloat("loading_progress");
    }
    QLog.e("EmojiManagerServiceProxy", 4, "setHaveInitSmallAndNormal fail.");
    return 0.0F;
  }
  
  public float getStatusPercent(String paramString)
  {
    if (paramString == null) {
      return -1.0F;
    }
    if (this.manager != null)
    {
      paramString = (TaskStatus)((IEmojiManagerService)this.manager).getStatusMap().get(paramString);
      if (paramString != null) {
        return paramString.getPercent();
      }
      return -1.0F;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("epId", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_statuspercent", localBundle);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getFloat("emoticon_download");
    }
    QLog.e("EmojiManagerServiceProxy", 4, "getStatusPercent fail.");
    return -1.0F;
  }
  
  public boolean haveInitFav()
  {
    if (this.manager != null) {
      return ((IEmojiManagerService)this.manager).getHaveInitFav();
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_haveinitfav", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess())) {
      return localEIPCResult.data.getBoolean("haveInitFav");
    }
    QLog.e("EmojiManagerServiceProxy", 4, "haveInitFav fail.");
    return false;
  }
  
  public boolean haveInitSmallAndNormal()
  {
    if (this.manager != null) {
      return ((IEmojiManagerService)this.manager).getHaveInitSmallAndNormal();
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_haveInitSmallAndNormal", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess())) {
      return localEIPCResult.data.getBoolean("haveInitFav");
    }
    QLog.e("EmojiManagerServiceProxy", 4, "haveInitSmallAndNormal fail.");
    return false;
  }
  
  public void pullEmoticonPackage(EmoticonPackage paramEmoticonPackage, boolean paramBoolean, int paramInt)
  {
    pullEmoticonPackage(paramEmoticonPackage, paramBoolean, true, paramInt);
  }
  
  public void pullEmoticonPackage(EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (this.manager != null)
    {
      ((IEmojiManagerService)this.manager).pullEmoticonPackage(paramEmoticonPackage, paramBoolean1, paramBoolean2, paramInt);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticon_package", paramEmoticonPackage);
    localBundle.putBoolean("emoticon_newPackage", paramBoolean1);
    localBundle.putBoolean("emoticon_switchTab", paramBoolean2);
    localBundle.putInt("emoticon_businessType", paramInt);
    paramEmoticonPackage = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_pullemoticonpackage", localBundle);
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmojiManagerServiceProxy", 4, "pullEmoticonPackage suc.");
      }
    }
    else {
      QLog.e("EmojiManagerServiceProxy", 4, "pullEmoticonPackage fail.");
    }
  }
  
  public void setHaveInitFav(boolean paramBoolean)
  {
    if (this.manager != null)
    {
      ((IEmojiManagerService)this.manager).setHaveInitFav(paramBoolean);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("haveInitFav", paramBoolean);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_setHaveInitFav", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmojiManagerServiceProxy", 4, "setHaveInitFav suc.");
      }
    }
    else {
      QLog.e("EmojiManagerServiceProxy", 4, "setHaveInitFav fail.");
    }
  }
  
  public void setHaveInitSmallAndNormal(boolean paramBoolean)
  {
    if (this.manager != null)
    {
      ((IEmojiManagerService)this.manager).setHaveInitSmallAndNormal(paramBoolean);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("haveInitFav", paramBoolean);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_sethaveinitsmallandnormal", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmojiManagerServiceProxy", 4, "setHaveInitSmallAndNormal suc.");
      }
    }
    else {
      QLog.e("EmojiManagerServiceProxy", 4, "setHaveInitSmallAndNormal fail.");
    }
  }
  
  public void startCoverDownload(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (this.manager != null)
    {
      ((IEmojiManagerService)this.manager).startCoverDownload(paramEmoticonPackage);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticon_package", paramEmoticonPackage);
    paramEmoticonPackage = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_startcoverdownload", localBundle);
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmojiManagerServiceProxy", 4, "startCoverDownload suc.");
      }
    }
    else {
      QLog.e("EmojiManagerServiceProxy", 4, "startCoverDownload fail.");
    }
  }
  
  public void startDownloadEmosmJson(String paramString, int paramInt)
  {
    startDownloadEmosmJson(paramString, paramInt, null, false, 0);
  }
  
  public void startDownloadEmosmJson(String paramString, int paramInt1, int paramInt2)
  {
    startDownloadEmosmJson(paramString, paramInt1, null, false, paramInt2);
  }
  
  public void startDownloadEmosmJson(String paramString, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    startDownloadEmosmJson(paramString, paramInt, paramBundle, paramBoolean, 0);
  }
  
  public void startDownloadEmosmJson(String paramString, int paramInt1, Bundle paramBundle, boolean paramBoolean, int paramInt2)
  {
    if (this.manager != null)
    {
      ((IEmojiManagerService)this.manager).startDownloadEmosmJson(paramString, paramInt1, paramBundle, paramBoolean, paramInt2);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("epId", paramString);
    localBundle.putInt("jsonType", paramInt1);
    localBundle.putInt("businessType", paramInt2);
    localBundle.putBundle("req_pramas", paramBundle);
    localBundle.putBoolean("is_smallemoticon", paramBoolean);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_startdownloademosmjson", localBundle);
    if ((paramString != null) && (paramString.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmojiManagerServiceProxy", 4, "startDownloadEmosmJson suc.");
      }
    }
    else {
      QLog.e("EmojiManagerServiceProxy", 4, "startDownloadEmosmJson fail.");
    }
  }
  
  public void stopEmoticonPackageDownload(String paramString)
  {
    if (this.manager != null)
    {
      ((IEmojiManagerService)this.manager).stopEmoticonPackageDownload(paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("epId", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_stopemoticonpackage", localBundle);
    if ((paramString != null) && (paramString.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmojiManagerServiceProxy", 4, "stopEmoticonPackageDownload suc.");
      }
    }
    else {
      QLog.e("EmojiManagerServiceProxy", 4, "stopEmoticonPackageDownload fail.");
    }
  }
  
  public boolean tasksFileExists(Emoticon paramEmoticon, int paramInt)
  {
    if (this.manager != null) {
      return ((IEmojiManagerService)this.manager).tasksFileExists(paramEmoticon, paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticon_package", paramEmoticon);
    localBundle.putInt("emoticon_tasks", paramInt);
    paramEmoticon = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_tasksfileexists", localBundle);
    if ((paramEmoticon != null) && (paramEmoticon.isSuccess())) {
      return paramEmoticon.data.getBoolean("emoticon_tasksfileexists");
    }
    QLog.e("EmojiManagerServiceProxy", 4, "tasksFileExists fail.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy
 * JD-Core Version:    0.7.0.1
 */