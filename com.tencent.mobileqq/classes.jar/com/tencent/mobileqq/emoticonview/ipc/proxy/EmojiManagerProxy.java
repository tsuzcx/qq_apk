package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class EmojiManagerProxy
  extends AbsManagerProxy<EmojiManager>
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
  public static final String TAG = "EmojiManagerProxy";
  
  public EmojiManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.CHAT_EMOTION_MANAGER);
  }
  
  public static EIPCResult checkMatch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if ("emojimanager_haveinitfav".equals(paramString)) {
      return onHaveInitFav((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_setHaveInitFav".equals(paramString)) {
      return onSetHaveInitFav((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_haveInitSmallAndNormal".equals(paramString)) {
      return onHaveInitSmallAndNormal((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_sethaveinitsmallandnormal".equals(paramString)) {
      return onSetHaveInitSmallAndNormal((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_getloadingprogress".equals(paramString)) {
      return onGetEmoticonPackageLoadingProgress((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_pullemoticonpackage".equals(paramString)) {
      return onPullEmoticonPackage((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_stopemoticonpackage".equals(paramString)) {
      return onStopEmoticonPackageDownload((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_startdownloademosmjson".equals(paramString)) {
      return onStartDownloadEmosmJson((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_startcoverdownload".equals(paramString)) {
      return onStartCoverDownload((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_tasksfileexists".equals(paramString)) {
      return onTasksFileExists((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_downemoticon".equals(paramString)) {
      return onDownloadAIOEmoticon((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("emojimanager_statuspercent".equals(paramString)) {
      return onGetStatusPercent((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    return null;
  }
  
  public static EIPCResult onDownloadAIOEmoticon(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a((Emoticon)paramBundle.getSerializable("emoticon_package"), paramBundle.getInt("emoticon_tasks"));
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("emoticon_download", bool);
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  public static EIPCResult onGetEmoticonPackageLoadingProgress(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    float f = ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(paramBundle.getString("epId"));
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putFloat("loading_progress", f);
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  public static EIPCResult onGetStatusPercent(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramQQAppInterface = (TaskStatus)((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a.get(paramBundle.getString("epId"));
    if (paramQQAppInterface != null) {}
    for (float f = paramQQAppInterface.a();; f = -1.0F)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putFloat("emoticon_download", f);
      return EIPCResult.createSuccessResult(paramQQAppInterface);
    }
  }
  
  public static EIPCResult onHaveInitFav(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramQQAppInterface = (EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    paramString = new Bundle();
    paramString.putBoolean("haveInitFav", paramQQAppInterface.e);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onHaveInitSmallAndNormal(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramQQAppInterface = (EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    paramString = new Bundle();
    paramString.putBoolean("haveInitFav", paramQQAppInterface.d);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onPullEmoticonPackage(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.d("EmojiManagerProxy", 4, "thread_name: " + Thread.currentThread().getName());
    ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a((EmoticonPackage)paramBundle.getSerializable("emoticon_package"), paramBundle.getBoolean("emoticon_newPackage"), paramBundle.getBoolean("emoticon_switchTab"), paramBundle.getInt("emoticon_businessType", 0));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSetHaveInitFav(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).e = paramBundle.getBoolean("haveInitFav");
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onSetHaveInitSmallAndNormal(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).d = paramBundle.getBoolean("haveInitFav");
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onStartCoverDownload(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramString = (EmoticonPackage)paramBundle.getSerializable("emoticon_package");
    ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(paramString);
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onStartDownloadEmosmJson(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramString = paramBundle.getString("epId");
    paramInt = paramBundle.getInt("jsonType");
    int i = paramBundle.getInt("businessType");
    Bundle localBundle = paramBundle.getBundle("req_pramas");
    boolean bool = paramBundle.getBoolean("is_smallemoticon");
    ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(paramString, paramInt, localBundle, bool, i);
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onStopEmoticonPackageDownload(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(paramBundle.getString("epId"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public static EIPCResult onTasksFileExists(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).b((Emoticon)paramBundle.getSerializable("emoticon_package"), paramBundle.getInt("emoticon_tasks"));
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("emoticon_tasksfileexists", bool);
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  public boolean downloadAIOEmoticon(Emoticon paramEmoticon, int paramInt)
  {
    if (this.manager != null) {
      return ((EmojiManager)this.manager).a(paramEmoticon, paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticon_package", paramEmoticon);
    localBundle.putInt("emoticon_tasks", paramInt);
    paramEmoticon = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_downemoticon", localBundle);
    if ((paramEmoticon != null) && (paramEmoticon.isSuccess())) {
      return paramEmoticon.data.getBoolean("emoticon_download");
    }
    QLog.e("EmojiManagerProxy", 4, "downloadAIOEmoticon fail.");
    return false;
  }
  
  public float getEmoticonPackageLoadingProgress(String paramString)
  {
    if (this.manager != null) {
      return ((EmojiManager)this.manager).a(paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("epId", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_getloadingprogress", localBundle);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getFloat("loading_progress");
    }
    QLog.e("EmojiManagerProxy", 4, "setHaveInitSmallAndNormal fail.");
    return 0.0F;
  }
  
  public float getStatusPercent(String paramString)
  {
    if (paramString == null) {
      return -1.0F;
    }
    if (this.manager != null)
    {
      paramString = (TaskStatus)((EmojiManager)this.manager).a.get(paramString);
      if (paramString != null) {
        return paramString.a();
      }
      return -1.0F;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("epId", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_statuspercent", localBundle);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getFloat("emoticon_download");
    }
    QLog.e("EmojiManagerProxy", 4, "getStatusPercent fail.");
    return -1.0F;
  }
  
  public boolean haveInitFav()
  {
    if (this.manager != null) {
      return ((EmojiManager)this.manager).e;
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_haveinitfav", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess())) {
      return localEIPCResult.data.getBoolean("haveInitFav");
    }
    QLog.e("EmojiManagerProxy", 4, "haveInitFav fail.");
    return false;
  }
  
  public boolean haveInitSmallAndNormal()
  {
    if (this.manager != null) {
      return ((EmojiManager)this.manager).d;
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_haveInitSmallAndNormal", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess())) {
      return localEIPCResult.data.getBoolean("haveInitFav");
    }
    QLog.e("EmojiManagerProxy", 4, "haveInitSmallAndNormal fail.");
    return false;
  }
  
  public void pullEmoticonPackage(EmoticonPackage paramEmoticonPackage, boolean paramBoolean, int paramInt)
  {
    pullEmoticonPackage(paramEmoticonPackage, paramBoolean, true, paramInt);
  }
  
  public void pullEmoticonPackage(EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      if (this.manager != null)
      {
        ((EmojiManager)this.manager).a(paramEmoticonPackage, paramBoolean1, paramBoolean2, paramInt);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("emoticon_package", paramEmoticonPackage);
      localBundle.putBoolean("emoticon_newPackage", paramBoolean1);
      localBundle.putBoolean("emoticon_switchTab", paramBoolean2);
      localBundle.putInt("emoticon_businessType", paramInt);
      paramEmoticonPackage = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_pullemoticonpackage", localBundle);
      if ((paramEmoticonPackage == null) || (!paramEmoticonPackage.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmojiManagerProxy", 4, "pullEmoticonPackage suc.");
    return;
    QLog.e("EmojiManagerProxy", 4, "pullEmoticonPackage fail.");
  }
  
  public void setHaveInitFav(boolean paramBoolean)
  {
    if (this.manager != null) {
      ((EmojiManager)this.manager).e = paramBoolean;
    }
    do
    {
      return;
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("haveInitFav", paramBoolean);
      localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_setHaveInitFav", (Bundle)localObject);
      if ((localObject == null) || (!((EIPCResult)localObject).isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmojiManagerProxy", 4, "setHaveInitFav suc.");
    return;
    QLog.e("EmojiManagerProxy", 4, "setHaveInitFav fail.");
  }
  
  public void setHaveInitSmallAndNormal(boolean paramBoolean)
  {
    if (this.manager != null) {
      ((EmojiManager)this.manager).d = paramBoolean;
    }
    do
    {
      return;
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("haveInitFav", paramBoolean);
      localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_sethaveinitsmallandnormal", (Bundle)localObject);
      if ((localObject == null) || (!((EIPCResult)localObject).isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmojiManagerProxy", 4, "setHaveInitSmallAndNormal suc.");
    return;
    QLog.e("EmojiManagerProxy", 4, "setHaveInitSmallAndNormal fail.");
  }
  
  public void startCoverDownload(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      if (this.manager != null)
      {
        ((EmojiManager)this.manager).a(paramEmoticonPackage);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("emoticon_package", paramEmoticonPackage);
      paramEmoticonPackage = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_startcoverdownload", localBundle);
      if ((paramEmoticonPackage == null) || (!paramEmoticonPackage.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmojiManagerProxy", 4, "startCoverDownload suc.");
    return;
    QLog.e("EmojiManagerProxy", 4, "startCoverDownload fail.");
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
    if (this.manager != null) {
      ((EmojiManager)this.manager).a(paramString, paramInt1, paramBundle, paramBoolean, paramInt2);
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("epId", paramString);
      localBundle.putInt("jsonType", paramInt1);
      localBundle.putInt("businessType", paramInt2);
      localBundle.putBundle("req_pramas", paramBundle);
      localBundle.putBoolean("is_smallemoticon", paramBoolean);
      paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_startdownloademosmjson", localBundle);
      if ((paramString == null) || (!paramString.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmojiManagerProxy", 4, "startDownloadEmosmJson suc.");
    return;
    QLog.e("EmojiManagerProxy", 4, "startDownloadEmosmJson fail.");
  }
  
  public void stopEmoticonPackageDownload(String paramString)
  {
    if (this.manager != null) {
      ((EmojiManager)this.manager).a(paramString);
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("epId", paramString);
      paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_stopemoticonpackage", localBundle);
      if ((paramString == null) || (!paramString.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmojiManagerProxy", 4, "stopEmoticonPackageDownload suc.");
    return;
    QLog.e("EmojiManagerProxy", 4, "stopEmoticonPackageDownload fail.");
  }
  
  public boolean tasksFileExists(Emoticon paramEmoticon, int paramInt)
  {
    if (this.manager != null) {
      return ((EmojiManager)this.manager).b(paramEmoticon, paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticon_package", paramEmoticon);
    localBundle.putInt("emoticon_tasks", paramInt);
    paramEmoticon = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "emojimanager_tasksfileexists", localBundle);
    if ((paramEmoticon != null) && (paramEmoticon.isSuccess())) {
      return paramEmoticon.data.getBoolean("emoticon_tasksfileexists");
    }
    QLog.e("EmojiManagerProxy", 4, "tasksFileExists fail.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerProxy
 * JD-Core Version:    0.7.0.1
 */