package com.tencent.mobileqq.emosm.vipcomic;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
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
import mqq.manager.Manager;

public class VipComicMqqManager
  implements Handler.Callback, Manager
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private VipComicMqqHandler jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private final Map<String, VipComicFavorEmoStructMsgInfo> jdField_a_of_type_JavaUtilMap;
  
  public VipComicMqqManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler = ((VipComicMqqHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MQQ_COMIC_HANDLER));
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(91000);
  }
  
  public static String a(Map<String, VipComicFavorEmoStructMsgInfo> paramMap, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    paramMap = (VipComicFavorEmoStructMsgInfo)paramMap.get(paramString.toUpperCase());
    if (paramMap != null) {
      return paramMap.actionData;
    }
    return null;
  }
  
  private void a(Message paramMessage)
  {
    try
    {
      paramMessage = (List)paramMessage.obj;
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()) && (paramMessage != null) && (paramMessage.size() > 0)) {}
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("status", Integer.valueOf(2));
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
        paramMessage = "picMd5 in " + localStringBuilder.toString();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(VipComicFavorEmoStructMsgInfo.class.getSimpleName(), localContentValues, paramMessage, arrayOfString);
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        paramMessage = null;
      }
    }
  }
  
  private void a(IPicDownloadListener paramIPicDownloadListener, CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    if (paramIPicDownloadListener != null) {
      paramIPicDownloadListener.onFileDone(paramCustomEmotionData, paramBoolean);
    }
  }
  
  private void a(IPicDownloadListener paramIPicDownloadListener, EntityManager paramEntityManager, DownloaderInterface paramDownloaderInterface, List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, FavroamingDBManager paramFavroamingDBManager, CustomEmotionData paramCustomEmotionData, VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo, File paramFile)
  {
    DownloadTask localDownloadTask = new DownloadTask(paramCustomEmotionData.url, paramFile);
    localDownloadTask.p = true;
    localDownloadTask.f = "comic_emoticon";
    localDownloadTask.b = 3;
    paramDownloaderInterface.a(localDownloadTask, new VipComicMqqManager.1(this, paramFile, paramCustomEmotionData, paramFavroamingDBManager, paramList1, paramIPicDownloadListener, paramList2, paramEntityManager, paramVipComicFavorEmoStructMsgInfo, paramAtomicInteger2, paramAtomicInteger1), null);
  }
  
  private void a(List<CustomEmotionData> paramList, IPicDownloadListener paramIPicDownloadListener)
  {
    if (paramIPicDownloadListener != null) {
      paramIPicDownloadListener.onDone(new ArrayList(), paramList);
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(VipComicFavorEmoStructMsgInfo.class, true, null, null, null, null, null, null);
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo)((Iterator)localObject1).next();
            if (!TextUtils.isEmpty(localVipComicFavorEmoStructMsgInfo.picMd5)) {
              this.jdField_a_of_type_JavaUtilMap.put(localVipComicFavorEmoStructMsgInfo.picMd5.toUpperCase(), localVipComicFavorEmoStructMsgInfo);
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
  
  /* Error */
  private void b(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 113	android/os/Message:obj	Ljava/lang/Object;
    //   4: checkcast 115	java/util/List
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 24	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   12: ifnull +83 -> 95
    //   15: aload_0
    //   16: getfield 24	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   19: invokevirtual 121	com/tencent/mobileqq/persistence/EntityManager:isOpen	()Z
    //   22: ifeq +73 -> 95
    //   25: aload_1
    //   26: ifnull +69 -> 95
    //   29: aload_1
    //   30: invokeinterface 122 1 0
    //   35: ifle +60 -> 95
    //   38: aload_0
    //   39: getfield 24	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   42: invokevirtual 262	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   45: invokevirtual 267	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   48: aload_1
    //   49: invokeinterface 243 1 0
    //   54: astore_1
    //   55: aload_1
    //   56: invokeinterface 248 1 0
    //   61: ifeq +41 -> 102
    //   64: aload_0
    //   65: aload_1
    //   66: invokeinterface 252 1 0
    //   71: checkcast 99	com/tencent/mobileqq/data/VipComicFavorEmoStructMsgInfo
    //   74: invokespecial 270	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:b	(Lcom/tencent/mobileqq/data/VipComicFavorEmoStructMsgInfo;)V
    //   77: goto -22 -> 55
    //   80: astore_1
    //   81: aload_1
    //   82: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   85: aload_0
    //   86: getfield 24	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   89: invokevirtual 262	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   92: invokevirtual 273	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   95: return
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_1
    //   99: goto -91 -> 8
    //   102: aload_0
    //   103: getfield 24	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   106: invokevirtual 262	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   109: invokevirtual 276	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   112: aload_0
    //   113: getfield 24	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   116: invokevirtual 262	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   119: invokevirtual 273	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   122: return
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 24	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   128: invokevirtual 262	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   131: invokevirtual 273	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	VipComicMqqManager
    //   0	136	1	paramMessage	Message
    // Exception table:
    //   from	to	target	type
    //   38	55	80	java/lang/Exception
    //   55	77	80	java/lang/Exception
    //   102	112	80	java/lang/Exception
    //   0	8	96	java/lang/Exception
    //   38	55	123	finally
    //   55	77	123	finally
    //   81	85	123	finally
    //   102	112	123	finally
  }
  
  private void b(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    if ((paramVipComicFavorEmoStructMsgInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()) && (!TextUtils.isEmpty(paramVipComicFavorEmoStructMsgInfo.picMd5)))
    {
      if (paramVipComicFavorEmoStructMsgInfo.getStatus() != 1000) {
        paramVipComicFavorEmoStructMsgInfo.setStatus(1000);
      }
      paramVipComicFavorEmoStructMsgInfo.picMd5 = paramVipComicFavorEmoStructMsgInfo.picMd5.toUpperCase();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramVipComicFavorEmoStructMsgInfo);
    }
  }
  
  private void c(List<VipComicFavorEmoStructMsgInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(91002);
      ((Message)localObject).obj = paramList;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (VipComicFavorEmoStructMsgInfo)paramList.next();
        if (!TextUtils.isEmpty(((VipComicFavorEmoStructMsgInfo)localObject).picMd5)) {
          this.jdField_a_of_type_JavaUtilMap.put(((VipComicFavorEmoStructMsgInfo)localObject).picMd5.toUpperCase(), localObject);
        }
      }
    }
  }
  
  public VipComicFavorEmoStructMsgInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (VipComicFavorEmoStructMsgInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString.toUpperCase());
    }
    return null;
  }
  
  public String a(String paramString)
  {
    String str = DiySecureFileHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(paramString)) {
      return AppConstants.SDCARD_IMG_FAVORITE + str + "-" + paramString.toUpperCase() + ".jpg";
    }
    return AppConstants.SDCARD_IMG_FAVORITE + str + "-" + paramString + ".jpg";
  }
  
  public List<VipComicFavorEmoStructMsgInfo> a(int paramInt)
  {
    Object localObject = a();
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
  
  public List<CustomEmotionData> a(List<CustomEmotionData> paramList)
  {
    Object localObject = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqManager", 2, "Call getEmoticonDataList from getEmoticonList.");
    }
    localObject = ((FavroamingDBManager)localObject).a();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return new ArrayList();
    }
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
  
  public Map<String, VipComicFavorEmoStructMsgInfo> a()
  {
    HashMap localHashMap = null;
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      localHashMap = new HashMap();
      localHashMap.putAll(this.jdField_a_of_type_JavaUtilMap);
    }
    return localHashMap;
  }
  
  public void a()
  {
    List localList = a(1);
    a(localList, false);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqManager", 2, "uploadInitComicEmoStructMsgInfo , comicFavorEmoStructMsgInfoList = " + localList);
    }
  }
  
  public void a(Context paramContext, List<CustomEmotionData> paramList, Map<String, VipComicFavorEmoStructMsgInfo> paramMap, IPicDownloadListener paramIPicDownloadListener)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.isEmpty()) || (paramMap == null) || (paramMap.isEmpty()))
    {
      a(paramList, paramIPicDownloadListener);
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (!NetworkUtil.g(paramContext))
    {
      a(paramList, paramIPicDownloadListener);
      return;
    }
    paramContext = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if (paramContext == null)
    {
      a(paramList, paramIPicDownloadListener);
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
    AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
    FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    int i = 0;
    label156:
    CustomEmotionData localCustomEmotionData;
    Object localObject;
    if (i < paramList.size())
    {
      localCustomEmotionData = (CustomEmotionData)paramList.get(i);
      localObject = (VipComicFavorEmoStructMsgInfo)paramMap.get(localCustomEmotionData.md5);
      if (!TextUtils.isEmpty(localCustomEmotionData.url)) {
        break label278;
      }
      localArrayList2.add(localCustomEmotionData);
      localFavroamingDBManager.a(localCustomEmotionData);
      localEntityManager.remove((Entity)localObject);
      localAtomicInteger1.decrementAndGet();
      a(paramIPicDownloadListener, localCustomEmotionData, false);
    }
    for (;;)
    {
      if ((localAtomicInteger1.get() == 0) && (paramIPicDownloadListener != null)) {
        paramIPicDownloadListener.onDone(localArrayList1, localArrayList2);
      }
      for (;;)
      {
        i += 1;
        break label156;
        break;
        label278:
        if (paramContext.a(localCustomEmotionData.url) == null) {
          break label316;
        }
        localFavroamingDBManager.a(localCustomEmotionData);
        localEntityManager.remove((Entity)localObject);
        localAtomicInteger1.decrementAndGet();
      }
      label316:
      File localFile = new File(a(localCustomEmotionData.md5));
      if (localFile.exists())
      {
        localAtomicInteger1.decrementAndGet();
        localCustomEmotionData.emoPath = localFile.getAbsolutePath();
        if ("needDownload".equals(localCustomEmotionData.RomaingType)) {
          localCustomEmotionData.RomaingType = "isUpdate";
        }
        if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(localCustomEmotionData.emoPath)))
        {
          localObject = SecUtil.getFileMd5(localCustomEmotionData.emoPath);
          if (!localCustomEmotionData.md5.equals(localObject)) {
            QLog.i("VipComicMqqManager", 2, "init = " + localCustomEmotionData.md5 + " , compute = " + (String)localObject);
          }
        }
        localFavroamingDBManager.b(localCustomEmotionData);
        localArrayList1.add(localCustomEmotionData);
        a(paramIPicDownloadListener, localCustomEmotionData, true);
      }
      else
      {
        a(paramIPicDownloadListener, localEntityManager, paramContext, localArrayList1, localArrayList2, localAtomicInteger1, localAtomicInteger2, localFavroamingDBManager, localCustomEmotionData, (VipComicFavorEmoStructMsgInfo)localObject, localFile);
      }
    }
  }
  
  public void a(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(91001);
    localMessage.obj = paramVipComicFavorEmoStructMsgInfo;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    this.jdField_a_of_type_JavaUtilMap.put(paramVipComicFavorEmoStructMsgInfo.picMd5, paramVipComicFavorEmoStructMsgInfo);
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Map localMap = a();
      if ((localMap != null) && (localMap.size() > 0))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = ((String)localIterator.next()).toUpperCase();
          if (localMap.get(str) != null) {
            localArrayList.add(str);
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler != null) && (localArrayList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler.b(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.i("VipComicMqqManager", 2, "delComicStructMsgInfo , delList = " + paramList);
        }
      }
    }
  }
  
  public void a(List<VipComicFavorEmoStructMsgInfo> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramBoolean) {
        c(paramList);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler != null)
      {
        ArrayList localArrayList = new ArrayList(paramList.size());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo)localIterator.next();
          MqqComicPb.ComicFavorEmotIcons localComicFavorEmotIcons = new MqqComicPb.ComicFavorEmotIcons();
          localComicFavorEmotIcons.md5.set(localVipComicFavorEmoStructMsgInfo.picMd5);
          localComicFavorEmotIcons.info.set(localVipComicFavorEmoStructMsgInfo.actionData);
          localArrayList.add(localComicFavorEmotIcons);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler.a(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.i("VipComicMqqManager", 2, "setMyComicEmoticon,isNeedSaveDb =" + paramBoolean + " , favorEmoStructMsgInfoList = " + paramList);
        }
      }
    }
  }
  
  public boolean a(CustomEmotionData paramCustomEmotionData)
  {
    return (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)) && (a(paramCustomEmotionData.md5) != null);
  }
  
  public void b(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(91003);
      ((Message)localObject).obj = paramList;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        ((VipComicFavorEmoStructMsgInfo)this.jdField_a_of_type_JavaUtilMap.get(((String)localObject).toUpperCase())).status = 2;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 91000: 
      b();
      return true;
    case 91001: 
      if ((paramMessage.obj instanceof VipComicFavorEmoStructMsgInfo)) {
        b((VipComicFavorEmoStructMsgInfo)paramMessage.obj);
      }
      return true;
    case 91002: 
      b(paramMessage);
      return true;
    }
    a(paramMessage);
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager
 * JD-Core Version:    0.7.0.1
 */