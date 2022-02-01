package com.tencent.mobileqq.emosm.api.impl;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.pb.mqqcomic.MqqComicPb.ComicFavorEmotIcons;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class VipComicMqqManagerServiceImpl
  implements Handler.Callback, IVipComicMqqManagerService
{
  private static final int MSG_INIT_CACHE = 91000;
  private static final int MSG_SAVE_COMIC_EMO = 91001;
  private static final int MSG_SAVE_COMIC_EMO_BATCH = 91002;
  private static final int MSG_UPDATE_COMIC_EMO = 91003;
  private static final String TAG = "VipComicMqqManager";
  private AppInterface mApp = null;
  private Map<String, VipComicFavorEmoStructMsgInfo> mComicFavEmoCache;
  private Handler mDBHandler;
  private EntityManager mEm = null;
  private VipComicMqqHandler vipComicMqqHandler;
  
  private void doSaveComicStructInfo(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    if (paramVipComicFavorEmoStructMsgInfo != null)
    {
      EntityManager localEntityManager = this.mEm;
      if ((localEntityManager != null) && (localEntityManager.isOpen()) && (!TextUtils.isEmpty(paramVipComicFavorEmoStructMsgInfo.picMd5)))
      {
        if (paramVipComicFavorEmoStructMsgInfo.getStatus() != 1000) {
          paramVipComicFavorEmoStructMsgInfo.setStatus(1000);
        }
        paramVipComicFavorEmoStructMsgInfo.picMd5 = paramVipComicFavorEmoStructMsgInfo.picMd5.toUpperCase();
        this.mEm.persistOrReplace(paramVipComicFavorEmoStructMsgInfo);
      }
    }
  }
  
  private void initCache()
  {
    Object localObject = this.mEm;
    if ((localObject != null) && (((EntityManager)localObject).isOpen())) {}
    try
    {
      localObject = this.mEm.query(VipComicFavorEmoStructMsgInfo.class, true, null, null, null, null, null, null);
    }
    catch (Exception localException)
    {
      label36:
      break label36;
    }
    localObject = null;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localVipComicFavorEmoStructMsgInfo.picMd5)) {
          this.mComicFavEmoCache.put(localVipComicFavorEmoStructMsgInfo.picMd5.toUpperCase(), localVipComicFavorEmoStructMsgInfo);
        }
      }
    }
  }
  
  private void onListenerDone(List<CustomEmotionData> paramList, IPicDownloadListener paramIPicDownloadListener)
  {
    if (paramIPicDownloadListener != null) {
      paramIPicDownloadListener.onDone(new ArrayList(), paramList);
    }
  }
  
  private void onListenerFailDone(IPicDownloadListener paramIPicDownloadListener, CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    if (paramIPicDownloadListener != null) {
      paramIPicDownloadListener.onFileDone(paramCustomEmotionData, paramBoolean);
    }
  }
  
  /* Error */
  private void saveComicEmoBatch(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 139	android/os/Message:obj	Ljava/lang/Object;
    //   4: checkcast 93	java/util/List
    //   7: astore_1
    //   8: goto +5 -> 13
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 40	com/tencent/mobileqq/emosm/api/impl/VipComicMqqManagerServiceImpl:mEm	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +110 -> 129
    //   22: aload_2
    //   23: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:isOpen	()Z
    //   26: ifeq +103 -> 129
    //   29: aload_1
    //   30: ifnull +99 -> 129
    //   33: aload_1
    //   34: invokeinterface 142 1 0
    //   39: ifle +90 -> 129
    //   42: aload_0
    //   43: getfield 40	com/tencent/mobileqq/emosm/api/impl/VipComicMqqManagerServiceImpl:mEm	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   46: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   49: invokevirtual 151	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   52: aload_1
    //   53: invokeinterface 97 1 0
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 102 1 0
    //   65: ifeq +19 -> 84
    //   68: aload_0
    //   69: aload_1
    //   70: invokeinterface 106 1 0
    //   75: checkcast 57	com/tencent/mobileqq/data/VipComicFavorEmoStructMsgInfo
    //   78: invokespecial 153	com/tencent/mobileqq/emosm/api/impl/VipComicMqqManagerServiceImpl:doSaveComicStructInfo	(Lcom/tencent/mobileqq/data/VipComicFavorEmoStructMsgInfo;)V
    //   81: goto -22 -> 59
    //   84: aload_0
    //   85: getfield 40	com/tencent/mobileqq/emosm/api/impl/VipComicMqqManagerServiceImpl:mEm	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   91: invokevirtual 156	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   94: goto +12 -> 106
    //   97: astore_1
    //   98: goto +19 -> 117
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   106: aload_0
    //   107: getfield 40	com/tencent/mobileqq/emosm/api/impl/VipComicMqqManagerServiceImpl:mEm	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   110: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   113: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   116: return
    //   117: aload_0
    //   118: getfield 40	com/tencent/mobileqq/emosm/api/impl/VipComicMqqManagerServiceImpl:mEm	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   121: invokevirtual 146	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   124: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   127: aload_1
    //   128: athrow
    //   129: return
    //   130: astore_1
    //   131: goto -120 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	VipComicMqqManagerServiceImpl
    //   0	134	1	paramMessage	Message
    //   17	6	2	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   42	59	97	finally
    //   59	81	97	finally
    //   84	94	97	finally
    //   102	106	97	finally
    //   42	59	101	java/lang/Exception
    //   59	81	101	java/lang/Exception
    //   84	94	101	java/lang/Exception
    //   0	8	130	java/lang/Exception
  }
  
  private void saveComicStructInfoList(List<VipComicFavorEmoStructMsgInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = this.mDBHandler.obtainMessage(91002);
      ((Message)localObject).obj = paramList;
      this.mDBHandler.sendMessage((Message)localObject);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (VipComicFavorEmoStructMsgInfo)paramList.next();
        if (!TextUtils.isEmpty(((VipComicFavorEmoStructMsgInfo)localObject).picMd5)) {
          this.mComicFavEmoCache.put(((VipComicFavorEmoStructMsgInfo)localObject).picMd5.toUpperCase(), localObject);
        }
      }
    }
  }
  
  private void startDownload(IPicDownloadListener paramIPicDownloadListener, EntityManager paramEntityManager, DownloaderInterface paramDownloaderInterface, List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, IFavroamingDBManagerService paramIFavroamingDBManagerService, CustomEmotionData paramCustomEmotionData, VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo, File paramFile)
  {
    DownloadTask localDownloadTask = new DownloadTask(paramCustomEmotionData.url, paramFile);
    localDownloadTask.N = true;
    localDownloadTask.L = "comic_emoticon";
    localDownloadTask.e = 3;
    paramDownloaderInterface.startDownload(localDownloadTask, new VipComicMqqManagerServiceImpl.1(this, paramFile, paramCustomEmotionData, paramIFavroamingDBManagerService, paramList1, paramIPicDownloadListener, paramList2, paramEntityManager, paramVipComicFavorEmoStructMsgInfo, paramAtomicInteger2, paramAtomicInteger1), null);
  }
  
  private void updateComicEmo(Message paramMessage)
  {
    try
    {
      paramMessage = (List)paramMessage.obj;
    }
    catch (Exception paramMessage)
    {
      label11:
      Object localObject;
      break label11;
    }
    paramMessage = null;
    localObject = this.mEm;
    if ((localObject != null) && (((EntityManager)localObject).isOpen()) && (paramMessage != null) && (paramMessage.size() > 0)) {
      try
      {
        localObject = new ContentValues();
        ((ContentValues)localObject).put("status", Integer.valueOf(2));
        String[] arrayOfString = new String[paramMessage.size()];
        StringBuilder localStringBuilder = new StringBuilder(" ( ");
        int i = 0;
        while (i < paramMessage.size())
        {
          localStringBuilder.append(" ? ");
          if (i != paramMessage.size() - 1) {
            localStringBuilder.append(",");
          }
          arrayOfString[i] = SecurityUtile.encode(((String)paramMessage.get(i)).toUpperCase());
          i += 1;
        }
        localStringBuilder.append(" ) ");
        paramMessage = new StringBuilder();
        paramMessage.append("picMd5 in ");
        paramMessage.append(localStringBuilder.toString());
        paramMessage = paramMessage.toString();
        this.mEm.update(VipComicFavorEmoStructMsgInfo.class.getSimpleName(), (ContentValues)localObject, paramMessage, arrayOfString);
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
  
  public void delComicEmoticonList(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Object localObject = new ArrayList();
      Map localMap = getComicStructInfoMap();
      if ((localMap != null) && (localMap.size() > 0))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = ((String)localIterator.next()).toUpperCase();
          if (localMap.get(str) != null) {
            ((List)localObject).add(str);
          }
        }
      }
      if ((this.vipComicMqqHandler != null) && (((List)localObject).size() > 0))
      {
        this.vipComicMqqHandler.b((List)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("delComicStructMsgInfo , delList = ");
          ((StringBuilder)localObject).append(paramList);
          QLog.i("VipComicMqqManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public VipComicFavorEmoStructMsgInfo getComicStructInfo(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (VipComicFavorEmoStructMsgInfo)this.mComicFavEmoCache.get(paramString.toUpperCase());
    }
    return null;
  }
  
  public List<VipComicFavorEmoStructMsgInfo> getComicStructInfoListByStatus(int paramInt)
  {
    Object localObject = getComicStructInfoMap();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo)((Iterator)localObject).next();
        if (localVipComicFavorEmoStructMsgInfo.status == paramInt) {
          localArrayList.add(localVipComicFavorEmoStructMsgInfo);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public Map<String, VipComicFavorEmoStructMsgInfo> getComicStructInfoMap()
  {
    if (!this.mComicFavEmoCache.isEmpty())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(this.mComicFavEmoCache);
      return localHashMap;
    }
    return null;
  }
  
  public List<CustomEmotionData> getEmoticonList(List<CustomEmotionData> paramList)
  {
    Object localObject = (IFavroamingDBManagerService)this.mApp.getRuntimeService(IFavroamingDBManagerService.class, "");
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqManager", 2, "Call getEmoticonDataList from getEmoticonList.");
    }
    localObject = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
        if ((!"needDel".equals(localCustomEmotionData.RomaingType)) && (paramList != null)) {
          paramList.add(localCustomEmotionData);
        }
      }
      return localObject;
    }
    return new ArrayList();
  }
  
  public String getFilePath(String paramString)
  {
    String str = DiySecureFileHelper.a(this.mApp.getCurrentAccountUin());
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_IMG_FAVORITE);
      localStringBuilder.append(str);
      localStringBuilder.append("-");
      localStringBuilder.append(paramString.toUpperCase());
      localStringBuilder.append(".jpg");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_IMG_FAVORITE);
    localStringBuilder.append(str);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".jpg");
    return localStringBuilder.toString();
  }
  
  public void handleComicEmoticon(Context paramContext, List<CustomEmotionData> paramList, Map<String, VipComicFavorEmoStructMsgInfo> paramMap, IPicDownloadListener paramIPicDownloadListener)
  {
    Object localObject2 = this;
    Object localObject1 = paramList;
    if ((paramContext != null) && (localObject1 != null) && (!paramList.isEmpty()) && (paramMap != null) && (!paramMap.isEmpty()))
    {
      EntityManager localEntityManager = ((VipComicMqqManagerServiceImpl)localObject2).mApp.getEntityManagerFactory().createEntityManager();
      if (!NetworkUtil.isNetworkAvailable(paramContext))
      {
        ((VipComicMqqManagerServiceImpl)localObject2).onListenerDone((List)localObject1, paramIPicDownloadListener);
        return;
      }
      paramContext = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1);
      if (paramContext == null)
      {
        ((VipComicMqqManagerServiceImpl)localObject2).onListenerDone((List)localObject1, paramIPicDownloadListener);
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localObject1 = new AtomicInteger(paramList.size());
      AtomicInteger localAtomicInteger = new AtomicInteger(0);
      localObject2 = (IFavroamingDBManagerService)((VipComicMqqManagerServiceImpl)localObject2).mApp.getRuntimeService(IFavroamingDBManagerService.class, "");
      int i = 0;
      for (;;)
      {
        VipComicMqqManagerServiceImpl localVipComicMqqManagerServiceImpl = this;
        if (i >= paramList.size()) {
          break;
        }
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramList.get(i);
        Object localObject3 = (VipComicFavorEmoStructMsgInfo)paramMap.get(localCustomEmotionData.md5);
        if (TextUtils.isEmpty(localCustomEmotionData.url))
        {
          localArrayList2.add(localCustomEmotionData);
          ((IFavroamingDBManagerService)localObject2).deleteCustomEmotion(localCustomEmotionData);
          localEntityManager.remove((Entity)localObject3);
          ((AtomicInteger)localObject1).decrementAndGet();
          localVipComicMqqManagerServiceImpl.onListenerFailDone(paramIPicDownloadListener, localCustomEmotionData, false);
        }
        for (;;)
        {
          break;
          if (paramContext.getTask(localCustomEmotionData.url) != null)
          {
            ((IFavroamingDBManagerService)localObject2).deleteCustomEmotion(localCustomEmotionData);
            localEntityManager.remove((Entity)localObject3);
            ((AtomicInteger)localObject1).decrementAndGet();
            break label546;
          }
          Object localObject4 = new File(localVipComicMqqManagerServiceImpl.getFilePath(localCustomEmotionData.md5));
          if (((File)localObject4).exists())
          {
            ((AtomicInteger)localObject1).decrementAndGet();
            localCustomEmotionData.emoPath = ((File)localObject4).getAbsolutePath();
            if ("needDownload".equals(localCustomEmotionData.RomaingType)) {
              localCustomEmotionData.RomaingType = "isUpdate";
            }
            if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(localCustomEmotionData.emoPath)))
            {
              localObject3 = SecUtil.getFileMd5(localCustomEmotionData.emoPath);
              if (!localCustomEmotionData.md5.equals(localObject3))
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("init = ");
                ((StringBuilder)localObject4).append(localCustomEmotionData.md5);
                ((StringBuilder)localObject4).append(" , compute = ");
                ((StringBuilder)localObject4).append((String)localObject3);
                QLog.i("VipComicMqqManager", 2, ((StringBuilder)localObject4).toString());
              }
            }
            ((IFavroamingDBManagerService)localObject2).updateCustomEmotion(localCustomEmotionData);
            localArrayList1.add(localCustomEmotionData);
            localVipComicMqqManagerServiceImpl.onListenerFailDone(paramIPicDownloadListener, localCustomEmotionData, true);
          }
          else
          {
            startDownload(paramIPicDownloadListener, localEntityManager, paramContext, localArrayList1, localArrayList2, (AtomicInteger)localObject1, localAtomicInteger, (IFavroamingDBManagerService)localObject2, localCustomEmotionData, (VipComicFavorEmoStructMsgInfo)localObject3, (File)localObject4);
          }
        }
        if ((((AtomicInteger)localObject1).get() == 0) && (paramIPicDownloadListener != null)) {
          paramIPicDownloadListener.onDone(localArrayList1, localArrayList2);
        }
        label546:
        i += 1;
      }
      return;
    }
    onListenerDone(paramList, paramIPicDownloadListener);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 91003: 
      updateComicEmo(paramMessage);
      return true;
    case 91002: 
      saveComicEmoBatch(paramMessage);
      return true;
    case 91001: 
      if ((paramMessage.obj instanceof VipComicFavorEmoStructMsgInfo)) {
        doSaveComicStructInfo((VipComicFavorEmoStructMsgInfo)paramMessage.obj);
      }
      return true;
    }
    initCache();
    return true;
  }
  
  public boolean isComicEmoticon(CustomEmotionData paramCustomEmotionData)
  {
    return (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)) && (getComicStructInfo(paramCustomEmotionData.md5) != null);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    this.mEm = this.mApp.getEntityManagerFactory().createEntityManager();
    this.vipComicMqqHandler = ((VipComicMqqHandler)this.mApp.getBusinessHandler(VipComicMqqHandler.a));
    this.mComicFavEmoCache = new ConcurrentHashMap();
    this.mDBHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mDBHandler.sendEmptyMessage(91000);
  }
  
  public void onDestroy()
  {
    this.mApp = null;
    this.vipComicMqqHandler = null;
    EntityManager localEntityManager = this.mEm;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
    this.mComicFavEmoCache.clear();
  }
  
  public void saveComicStructInfo(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    Message localMessage = this.mDBHandler.obtainMessage(91001);
    localMessage.obj = paramVipComicFavorEmoStructMsgInfo;
    this.mDBHandler.sendMessage(localMessage);
    this.mComicFavEmoCache.put(paramVipComicFavorEmoStructMsgInfo.picMd5, paramVipComicFavorEmoStructMsgInfo);
  }
  
  public void setMyComicEmoticon(List<VipComicFavorEmoStructMsgInfo> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramBoolean) {
        saveComicStructInfoList(paramList);
      }
      if (this.vipComicMqqHandler != null)
      {
        Object localObject = new ArrayList(paramList.size());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo)localIterator.next();
          MqqComicPb.ComicFavorEmotIcons localComicFavorEmotIcons = new MqqComicPb.ComicFavorEmotIcons();
          localComicFavorEmotIcons.md5.set(localVipComicFavorEmoStructMsgInfo.picMd5);
          localComicFavorEmotIcons.info.set(localVipComicFavorEmoStructMsgInfo.actionData);
          ((List)localObject).add(localComicFavorEmotIcons);
        }
        this.vipComicMqqHandler.a((List)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setMyComicEmoticon,isNeedSaveDb =");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append(" , favorEmoStructMsgInfoList = ");
          ((StringBuilder)localObject).append(paramList);
          QLog.i("VipComicMqqManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void updateComicStructInfo(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = this.mDBHandler.obtainMessage(91003);
      ((Message)localObject).obj = paramList;
      this.mDBHandler.sendMessage((Message)localObject);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        ((VipComicFavorEmoStructMsgInfo)this.mComicFavEmoCache.get(((String)localObject).toUpperCase())).status = 2;
      }
    }
  }
  
  public void uploadInitComicEmoStructMsgInfo()
  {
    List localList = getComicStructInfoListByStatus(1);
    setMyComicEmoticon(localList, false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uploadInitComicEmoStructMsgInfo , comicFavorEmoStructMsgInfoList = ");
      localStringBuilder.append(localList);
      QLog.i("VipComicMqqManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.VipComicMqqManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */