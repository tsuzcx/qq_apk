package com.tencent.mobileqq.emosm.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler;
import com.tencent.mobileqq.app.DiyDoutuHelper;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.UploadListener;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerServiceProxy;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamPicInfo;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionExpRoamTryUp;

public class FavroamingManagerServiceImpl
  extends CustomEmotionRoamingManagerBase<CustomEmotionData>
  implements IFavroamingManagerService
{
  public static final String TAG = "FavroamingManager";
  private static final long serialVersionUID = 1L;
  protected Map<String, ArrayList<CustomEmotionData>> downMap = new HashMap();
  protected AtomicInteger downloadCount = new AtomicInteger(0);
  public EmoticonPackageDownloadListener downloadListener = new FavroamingManagerServiceImpl.5(this);
  private FavEmoRoamingObserver emoRoamingObserver = new FavroamingManagerServiceImpl.2(this);
  boolean isAddHandler = false;
  private EmotionJsonDownloadListener jsonListener = new FavroamingManagerServiceImpl.6(this);
  private ConcurrentHashMap<Integer, String> mAccessibilityEmotionDataMap = new ConcurrentHashMap();
  private boolean mCancelAddCustomEmotion;
  WeakReference<TransferRequest> mCurAddCustomEmotionsRequest;
  protected ITransFileController mFileController;
  protected TransProcessorHandler mTransProcessorHandler = new FavroamingManagerServiceImpl.1(this, ThreadManager.getSubThreadLooper());
  protected int needDownloadCount = 0;
  protected int needUploadCount = 0;
  protected AtomicInteger uploadCount = new AtomicInteger(0);
  private EmoAddedAuthCallback.UploadListener uploadListener;
  
  private void addCustomEmotion(String paramString, EmoAddedAuthCallback.UploadListener paramUploadListener)
  {
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (IFavroamingDBManagerService)this.mApp.getRuntimeService(IFavroamingDBManagerService.class);
    List localList = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    if (localList != null)
    {
      int j = 0;
      for (int i = 1;; i = k)
      {
        k = i;
        if (j >= localList.size()) {
          break;
        }
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        int m = localCustomEmotionData.emoId;
        if ((str != null) && (str.equals(localCustomEmotionData.md5)))
        {
          if ("needDel".equals(localCustomEmotionData.RomaingType))
          {
            ((IFavroamingDBManagerService)localObject).updateDeletedEmoticon(localCustomEmotionData, j);
            if (paramUploadListener != null) {
              paramUploadListener.a(0, str);
            }
          }
          else if (paramUploadListener != null)
          {
            paramUploadListener.a(1, str);
          }
          return;
        }
        k = i;
        if (i < m) {
          k = m;
        }
        j += 1;
      }
    }
    int k = 1;
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = localBaseQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (k + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    ((CustomEmotionData)localObject).isMarkFace = false;
    paramString = new EmoAddedAuthCallback(localBaseQQAppInterface, null, (CustomEmotionData)localObject, null, 2);
    paramString.a(paramUploadListener);
    this.mCurAddCustomEmotionsRequest = new WeakReference(syncUpload((CustomEmotionData)localObject, paramString));
  }
  
  public static FavroamingManagerServiceImpl get(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return (FavroamingManagerServiceImpl)paramBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
  }
  
  public static FavroamingManagerServiceProxy get(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    return (FavroamingManagerServiceProxy)paramIEmoticonMainPanelApp.getRuntimeService(IFavroamingManagerService.class);
  }
  
  private String getContentDescription(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return String.format(MobileQQ.getContext().getString(2131691895), new Object[] { str });
  }
  
  private void notifyFavEmoticonDownloaded()
  {
    int j = this.downloadCount.get();
    Object localObject = this.downloadCount;
    int i = 0;
    ((AtomicInteger)localObject).set(0);
    this.needDownloadCount = 0;
    while (i < this.listeners.size())
    {
      if (this.listeners.get(i) != null)
      {
        localObject = (SyncListener)((WeakReference)this.listeners.get(i)).get();
        if (localObject != null) {
          ((SyncListener)localObject).onDownloadFinish(j);
        }
      }
      i += 1;
    }
    notifyFavEmoticonSyncFinished();
  }
  
  public void addCustomEmotions(List<String> paramList, IFavroamingManagerService.AddCustomEmotionsCallback paramAddCustomEmotionsCallback)
  {
    if (paramList == null) {
      return;
    }
    int i = paramList.size();
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingManager", 2, "addCustomEmotions pathList is empty");
      }
      return;
    }
    this.mCancelAddCustomEmotion = false;
    ThreadManager.excute(new FavroamingManagerServiceImpl.8(this, i, paramAddCustomEmotionsCallback, paramList), 64, null, true);
  }
  
  public void asyncIncreaseEmotionClickNum(CustomEmotionData paramCustomEmotionData)
  {
    paramCustomEmotionData.increaseClickNum();
    getDBManager().updateCustomEmotion(paramCustomEmotionData);
  }
  
  public void cacheAccessibilityEmotionData()
  {
    if (this.mApp == null) {
      return;
    }
    Object localObject = (IFavroamingDBManagerService)this.mApp.getRuntimeService(IFavroamingDBManagerService.class);
    IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.mApp.getRuntimeService(IEmoticonManagerService.class);
    localObject = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.mAccessibilityEmotionDataMap.clear();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
        String str = "";
        if (localCustomEmotionData.isMarkFace)
        {
          Emoticon localEmoticon = localIEmoticonManagerService.syncFindEmoticonById(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
          localObject = str;
          if (localEmoticon != null)
          {
            localObject = str;
            if (!TextUtils.isEmpty(localEmoticon.name)) {
              localObject = localEmoticon.name;
            }
          }
        }
        else
        {
          if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {
            str = localCustomEmotionData.modifyWord;
          }
          localObject = str;
          if (TextUtils.isEmpty(str))
          {
            localObject = str;
            if (!TextUtils.isEmpty(localCustomEmotionData.ocrWord)) {
              localObject = localCustomEmotionData.ocrWord;
            }
          }
        }
        this.mAccessibilityEmotionDataMap.put(Integer.valueOf(localCustomEmotionData.emoId), localObject);
      }
    }
  }
  
  public void cancelAddCustomEmotions()
  {
    this.mCancelAddCustomEmotion = true;
    Object localObject = this.mCurAddCustomEmotionsRequest;
    if (localObject != null)
    {
      localObject = (TransferRequest)((WeakReference)localObject).get();
      if (localObject != null) {
        this.mFileController.stop((TransferRequest)localObject);
      }
    }
  }
  
  public void downLoadEmo()
  {
    boolean bool = NetworkUtil.isNetSupport(BaseApplication.getContext());
    int i = 0;
    if (!bool)
    {
      this.isInSync.set(false);
      return;
    }
    if (this.mApp == null) {
      return;
    }
    Object localObject1 = (IFavroamingDBManagerService)this.mApp.getRuntimeService(IFavroamingDBManagerService.class);
    Object localObject2 = ((IFavroamingDBManagerService)localObject1).getEmoticonDatasByType("needDownload");
    Object localObject3 = ((IFavroamingDBManagerService)localObject1).getEmoticonDatasByType("overflow");
    localObject1 = new ArrayList();
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      ((List)localObject1).addAll((Collection)localObject2);
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
      ((List)localObject1).addAll((Collection)localObject3);
    }
    if (((List)localObject1).size() > 0)
    {
      this.downloadCount.set(0);
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      while (i < ((List)localObject1).size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)((List)localObject1).get(i);
        if (localCustomEmotionData.isMarkFace) {
          ((List)localObject3).add(localCustomEmotionData);
        } else {
          ((List)localObject2).add(localCustomEmotionData);
        }
        i += 1;
      }
      if (this.mApp == null) {
        return;
      }
      this.needDownloadCount = ((List)localObject3).size();
      if (this.needDownloadCount == 0) {
        notifyFavEmoticonSyncFinished();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("markFace size: ");
        ((StringBuilder)localObject1).append(((List)localObject3).size());
        ((StringBuilder)localObject1).append(", noMarkFace size:");
        ((StringBuilder)localObject1).append(((List)localObject2).size());
        QLog.d("FavroamingManager", 2, ((StringBuilder)localObject1).toString());
      }
      ThreadManager.getUIHandler().post(new FavroamingManagerServiceImpl.4(this));
      downLoadMarketEmoList((List)localObject3);
      return;
    }
    notifyFavEmoticonSyncFinished();
  }
  
  public void downLoadMarketEmo(String paramString)
  {
    if (paramString == null) {
      return;
    }
    EmojiListenerManager.a().addEmotionJsonDownloadListener(this.jsonListener);
    ((IEmojiManagerService)this.mApp.getRuntimeService(IEmojiManagerService.class)).startDownloadEmosmJson(paramString, EmojiManagerServiceConstant.JSON_EMOSM_MALL, null, false);
  }
  
  public void downLoadMarketEmoList(List<CustomEmotionData> paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      this.downMap.clear();
      int i = 0;
      Object localObject;
      while (i < paramList.size())
      {
        localObject = (CustomEmotionData)paramList.get(i);
        if (localObject != null) {
          if (this.downMap.containsKey(((CustomEmotionData)localObject).emoPath))
          {
            ((ArrayList)this.downMap.get(((CustomEmotionData)localObject).emoPath)).add(localObject);
          }
          else
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localObject);
            this.downMap.put(((CustomEmotionData)localObject).emoPath, localArrayList);
          }
        }
        i += 1;
      }
      try
      {
        paramList = this.downMap.entrySet().iterator();
        while (paramList.hasNext())
        {
          localObject = (Map.Entry)paramList.next();
          if (localObject != null) {
            downLoadMarketEmo((String)((Map.Entry)localObject).getKey());
          }
        }
        paramList = finally;
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("downMap exception=");
          ((StringBuilder)localObject).append(paramList.toString());
          QLog.d("FavroamingManager", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      throw paramList;
    }
    finally {}
    for (;;) {}
  }
  
  protected void fetchEmoticonEncryptKeys(EmoticonPackage paramEmoticonPackage, IEmojiManagerService paramIEmojiManagerService, ArrayList<Emoticon> paramArrayList, ReqInfo paramReqInfo)
  {
    if ((!paramReqInfo.encryptKeysSuccess) && (paramEmoticonPackage.jobType != 4))
    {
      int i = 0;
      int j;
      do
      {
        paramReqInfo.strGetKeySeq = null;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("addEmoticonsTask| fetchEncryptKeys count=");
          localStringBuilder.append(i);
          QLog.d("FavroamingManager", 2, localStringBuilder.toString());
        }
        paramIEmojiManagerService.fetchEmoticonEncryptKeys(paramEmoticonPackage.epId, paramArrayList, paramReqInfo);
        j = i + 1;
        if (paramReqInfo.encryptKeysSuccess) {
          break;
        }
        i = j;
      } while (j < 3);
      if (QLog.isColorLevel())
      {
        paramEmoticonPackage = new StringBuilder();
        paramEmoticonPackage.append("addEmoticonsTask| fetchEncryptKeys count=");
        paramEmoticonPackage.append(j);
        paramEmoticonPackage.append(" encryptKeysSuccess=");
        paramEmoticonPackage.append(paramReqInfo.encryptKeysSuccess);
        QLog.d("FavroamingManager", 2, paramEmoticonPackage.toString());
      }
    }
  }
  
  public String getAccessibilityDescription(Integer paramInteger)
  {
    if (paramInteger == null) {
      return getContentDescription("");
    }
    return getContentDescription((String)this.mAccessibilityEmotionDataMap.get(paramInteger));
  }
  
  protected CustomEmotionRoamingDBManagerBase<CustomEmotionData> getDBManager()
  {
    return (CustomEmotionRoamingDBManagerBase)this.mApp.getRuntimeService(IFavroamingDBManagerService.class);
  }
  
  protected CustomEmoRoamingBaseHandler<CustomEmotionData> getRoamingHandler()
  {
    return (FavEmoRoamingHandler)this.mApp.getBusinessHandler(FavEmoRoamingHandler.a);
  }
  
  public int getUploadProcessorID()
  {
    return 9;
  }
  
  public boolean isSyncFinish()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadCount:");
      localStringBuilder.append(this.downloadCount.get());
      localStringBuilder.append(", needDownloadCount");
      localStringBuilder.append(this.needDownloadCount);
      localStringBuilder.append("uploadCount:");
      localStringBuilder.append(this.uploadCount.get());
      localStringBuilder.append(", needUploadCount");
      localStringBuilder.append(this.needUploadCount);
      QLog.d("FavroamingManager", 2, localStringBuilder.toString());
    }
    return (this.downloadCount.get() == this.needDownloadCount) && (this.uploadCount.get() == this.needUploadCount);
  }
  
  protected void notifyFavEmoticonSyncFinished()
  {
    if (isSyncFinish())
    {
      Object localObject = this.isInSync;
      int j = 0;
      ((AtomicBoolean)localObject).set(false);
      int i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("FavroamingManager", 2, "------------end syncRoaming----------");
        i = j;
      }
      while (i < this.listeners.size())
      {
        if (this.listeners.get(i) != null)
        {
          localObject = (SyncListener)((WeakReference)this.listeners.get(i)).get();
          if (localObject != null) {
            ((SyncListener)localObject).onSyncFinish();
          }
        }
        i += 1;
      }
    }
  }
  
  protected void notifyFavEmoticonUploaded()
  {
    Object localObject = this.uploadCount;
    int i = 0;
    ((AtomicInteger)localObject).set(0);
    this.needUploadCount = 0;
    while (i < this.listeners.size())
    {
      if (this.listeners.get(i) != null)
      {
        localObject = (SyncListener)((WeakReference)this.listeners.get(i)).get();
        if (localObject != null) {
          ((SyncListener)localObject).onUploadFinish();
        }
      }
      i += 1;
    }
    notifyFavEmoticonSyncFinished();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    super.onCreate(paramAppRuntime);
    this.mFileController = ((ITransFileController)this.mApp.getRuntimeService(ITransFileController.class));
    if (!TextUtils.isEmpty(this.uin))
    {
      paramAppRuntime = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fav_roaming_max");
      localStringBuilder.append(this.uin);
      int i = paramAppRuntime.getInt(localStringBuilder.toString(), 144);
      if (i > 144) {
        FavEmoConstant.a = i;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ITransFileController localITransFileController = this.mFileController;
    if (localITransFileController != null)
    {
      localITransFileController.removeHandle(this.mTransProcessorHandler);
      this.mTransProcessorHandler = null;
    }
    this.mApp.removeObserver(this.emoRoamingObserver);
    EmojiListenerManager.a().removeEmotionJsonDownloadListener(this.jsonListener);
  }
  
  public void onFileDone(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    if (paramCustomEmotionData != null)
    {
      if (this.mApp == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onFileDone, resId=");
        ((StringBuilder)localObject).append(paramCustomEmotionData.resid);
        ((StringBuilder)localObject).append(",isSuccess = ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" , roamingType: ");
        ((StringBuilder)localObject).append(paramCustomEmotionData.RomaingType);
        QLog.d("FavroamingManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (IFavroamingDBManagerService)this.mApp.getRuntimeService(IFavroamingDBManagerService.class);
      if ((localObject != null) && (paramBoolean))
      {
        if ("needDownload".equals(paramCustomEmotionData.RomaingType)) {
          paramCustomEmotionData.RomaingType = "isUpdate";
        } else if ("overflow".equals(paramCustomEmotionData.RomaingType)) {
          paramCustomEmotionData.RomaingType = "overflow_downloaded";
        }
        if (!"needDel".equals(paramCustomEmotionData.RomaingType))
        {
          ((IFavroamingDBManagerService)localObject).updateCustomEmotion(paramCustomEmotionData);
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onFileDone, resId=");
          ((StringBuilder)localObject).append(paramCustomEmotionData.resid);
          ((StringBuilder)localObject).append(" has been deleted");
          QLog.d("FavroamingManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      int i = 0;
      while (i < this.listeners.size())
      {
        if (this.listeners.get(i) != null)
        {
          localObject = (SyncListener)((WeakReference)this.listeners.get(i)).get();
          if (localObject != null) {
            ((SyncListener)localObject).onFileDone(paramCustomEmotionData, this.needDownloadCount, this.downloadCount.get());
          }
        }
        i += 1;
      }
      i = this.downloadCount.incrementAndGet();
      if (QLog.isColorLevel())
      {
        paramCustomEmotionData = new StringBuilder();
        paramCustomEmotionData.append("market face : downloadCount: ");
        paramCustomEmotionData.append(i);
        paramCustomEmotionData.append(",needDownloadCount: ");
        paramCustomEmotionData.append(this.needDownloadCount);
        QLog.d("FavroamingManager", 2, paramCustomEmotionData.toString());
      }
      if (i >= this.needDownloadCount) {
        notifyFavEmoticonDownloaded();
      }
    }
  }
  
  protected void onJsonCompleteFail(EmoticonPackage paramEmoticonPackage)
  {
    Object localObject = (ArrayList)this.downMap.get(paramEmoticonPackage.epId);
    if (localObject != null)
    {
      int i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)((ArrayList)localObject).get(i);
        if (localCustomEmotionData != null) {
          onFileDone(localCustomEmotionData, false);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadAIOEmoticon fail epId:");
      ((StringBuilder)localObject).append(paramEmoticonPackage.epId);
      QLog.d("FavroamingManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void onJsonCompleteSuccess(EmoticonPackage paramEmoticonPackage, IEmojiManagerService paramIEmojiManagerService)
  {
    ArrayList localArrayList = (ArrayList)this.downMap.get(paramEmoticonPackage.epId);
    if (localArrayList != null)
    {
      if (paramEmoticonPackage.jobType == 0)
      {
        int i = 0;
        while (i < localArrayList.size())
        {
          Object localObject2 = (CustomEmotionData)localArrayList.get(i);
          if (localObject2 != null)
          {
            Object localObject1 = new Emoticon();
            if (this.mApp == null)
            {
              QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|app null");
              onFileDone((CustomEmotionData)localObject2, false);
            }
            else
            {
              IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.mApp.getRuntimeService(IEmoticonManagerService.class);
              if (localIEmoticonManagerService != null) {
                localObject1 = localIEmoticonManagerService.syncFindEmoticonById(((CustomEmotionData)localObject2).emoPath, ((CustomEmotionData)localObject2).eId);
              }
              if (localObject1 == null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("downloadAIOEmoticon|cannot find emoticon: epId:");
                ((StringBuilder)localObject1).append(paramEmoticonPackage.epId);
                ((StringBuilder)localObject1).append("，eid=");
                ((StringBuilder)localObject1).append(((CustomEmotionData)localObject2).eId);
                QLog.i("FavroamingManager", 1, ((StringBuilder)localObject1).toString());
                ((CustomEmotionData)localObject2).RomaingType = "needDel";
                ((IFavroamingDBManagerService)this.mApp.getRuntimeService(IFavroamingDBManagerService.class)).updateCustomEmotion((CustomEmotionData)localObject2);
                onFileDone((CustomEmotionData)localArrayList.get(i), false);
              }
              else
              {
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("downloadAIOEmoticon|taskvalue:");
                  ((StringBuilder)localObject2).append(14);
                  ((StringBuilder)localObject2).append("，epid:");
                  ((StringBuilder)localObject2).append(((Emoticon)localObject1).epId);
                  ((StringBuilder)localObject2).append("，eid=");
                  ((StringBuilder)localObject2).append(((Emoticon)localObject1).eId);
                  QLog.d("FavroamingManager", 2, ((StringBuilder)localObject2).toString());
                }
                if (paramIEmojiManagerService.downloadAIOEmoticon((Emoticon)localObject1, 14)) {
                  onFileDone((CustomEmotionData)localArrayList.get(i), true);
                } else {
                  onFileDone((CustomEmotionData)localArrayList.get(i), false);
                }
              }
            }
          }
          i += 1;
        }
      }
      if ((paramEmoticonPackage.jobType == 3) || (paramEmoticonPackage.jobType == 5))
      {
        EmojiListenerManager.a().addEmoticonPackageDownloadListener(this.downloadListener);
        paramIEmojiManagerService.pullEmoticonPackage(paramEmoticonPackage, false);
      }
    }
  }
  
  public void removeCacheAccessibilityEmotionData(Integer paramInteger)
  {
    if (paramInteger == null) {
      return;
    }
    this.mAccessibilityEmotionDataMap.remove(paramInteger);
  }
  
  public void syncIncreaseEmoticonExposeNum(CustomEmotionData paramCustomEmotionData)
  {
    paramCustomEmotionData.increaseExposeNum();
    getDBManager().updateCustomEmotion(paramCustomEmotionData);
  }
  
  public void syncLocalDel()
  {
    if (this.mApp == null) {
      return;
    }
    FavEmoRoamingHandler localFavEmoRoamingHandler = (FavEmoRoamingHandler)this.mApp.getBusinessHandler(FavEmoRoamingHandler.a);
    if (localFavEmoRoamingHandler == null) {
      return;
    }
    this.mApp.addObserver(this.emoRoamingObserver);
    ThreadManager.excute(new FavroamingManagerServiceImpl.3(this, localFavEmoRoamingHandler), 128, null, true);
  }
  
  public TransferRequest syncUpload(CustomEmotionData paramCustomEmotionData, UpCallBack paramUpCallBack)
  {
    return uploadCustomEmoticon(paramCustomEmotionData, paramUpCallBack);
  }
  
  public void syncUpload(CustomEmotionData paramCustomEmotionData)
  {
    syncUpload(paramCustomEmotionData, null);
  }
  
  public void syncUpload(List<CustomEmotionData> paramList)
  {
    if (paramList != null) {
      uploadCustomEmoticon(paramList);
    }
  }
  
  public void updateCustomEmotionDataOCR(CustomEmotionData paramCustomEmotionData)
  {
    if (this.mApp != null)
    {
      if (paramCustomEmotionData == null) {
        return;
      }
      getDBManager().updateCustomEmotion(paramCustomEmotionData);
      StickerRecManagerImpl.get(this.mApp).updateKeywordForFavEmotion();
    }
  }
  
  public void updateCustomEmotionDataOCRReq(CustomEmotionData paramCustomEmotionData, String paramString)
  {
    if (this.mApp != null)
    {
      if (paramCustomEmotionData == null) {
        return;
      }
      FavEmoRoamingHandler localFavEmoRoamingHandler = (FavEmoRoamingHandler)getRoamingHandler();
      if (localFavEmoRoamingHandler != null) {
        localFavEmoRoamingHandler.a(paramCustomEmotionData, paramString);
      }
    }
  }
  
  public int uploadCustomEmoticon(List<CustomEmotionData> paramList)
  {
    int i = 0;
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        return 0;
      }
      Object localObject = paramList;
      if (paramList.size() > FavEmoConstant.a)
      {
        j = paramList.size() - FavEmoConstant.a;
        localObject = paramList.subList(j, FavEmoConstant.a + j);
      }
      int m = ((List)localObject).size();
      int k;
      for (int j = 0; i < m; j = k)
      {
        paramList = (CustomEmotionData)((List)localObject).get(i);
        k = j;
        if (!"needDownload".equals(paramList.RomaingType))
        {
          k = j;
          if (!"needDel".equals(paramList.RomaingType)) {
            if ("isUpdate".equals(paramList.RomaingType))
            {
              k = j;
            }
            else
            {
              uploadCustomEmoticon(paramList, null);
              k = j + 1;
            }
          }
        }
        i += 1;
      }
      this.needUploadCount = j;
      return j;
    }
    return 0;
  }
  
  public TransferRequest uploadCustomEmoticon(CustomEmotionData paramCustomEmotionData, UpCallBack paramUpCallBack)
  {
    if (paramCustomEmotionData == null)
    {
      if ((paramUpCallBack instanceof EmoBatchAddedCallback)) {
        EmoBatchAddedCallback.a((EmoBatchAddedCallback)paramUpCallBack);
      }
      return null;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if ((paramUpCallBack instanceof EmoBatchAddedCallback)) {
        EmoBatchAddedCallback.a((EmoBatchAddedCallback)paramUpCallBack);
      }
      return null;
    }
    if (!this.isAddHandler)
    {
      localObject = this.mTransProcessorHandler;
      if ((localObject != null) && (this.mFileController != null))
      {
        ((TransProcessorHandler)localObject).addFilter(new Class[] { BDHCommonUploadProcessor.class });
        this.mFileController.addHandle(this.mTransProcessorHandler);
        this.isAddHandler = true;
      }
    }
    Object localObject = new TransferRequest();
    ((TransferRequest)localObject).mFileType = 24;
    ((TransferRequest)localObject).mCommandId = 9;
    ((TransferRequest)localObject).mRichTag = "scbqmanyou";
    ((TransferRequest)localObject).mSelfUin = this.uin;
    ((TransferRequest)localObject).mPeerUin = this.uin;
    ((TransferRequest)localObject).mIsUp = true;
    if (paramUpCallBack != null) {
      ((TransferRequest)localObject).mUpCallBack = paramUpCallBack;
    }
    if (paramCustomEmotionData.isMarkFace)
    {
      uploadMarkFace(paramCustomEmotionData, (TransferRequest)localObject);
      return localObject;
    }
    uploadNoMarkFace(paramCustomEmotionData, (TransferRequest)localObject);
    return localObject;
  }
  
  public void uploadMarkFace(CustomEmotionData paramCustomEmotionData, TransferRequest paramTransferRequest)
  {
    if (paramCustomEmotionData != null)
    {
      if (paramTransferRequest == null) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uploadMarkFace favEmoticon.epid=");
        ((StringBuilder)localObject).append(paramCustomEmotionData.emoPath);
        ((StringBuilder)localObject).append(" and eid=");
        ((StringBuilder)localObject).append(paramCustomEmotionData.eId);
        QLog.d("FavroamingManager", 2, ((StringBuilder)localObject).toString());
      }
      if (!paramCustomEmotionData.checkMarketFace("uploadMarkFace"))
      {
        QLog.e("FavroamingManager", 1, "uploadMarkFace: marketFace is invalid");
        if ((paramTransferRequest.mUpCallBack instanceof EmoBatchAddedCallback)) {
          EmoBatchAddedCallback.a((EmoBatchAddedCallback)paramTransferRequest.mUpCallBack);
        }
        return;
      }
      try
      {
        localObject = new cmd0x388.ExtensionExpRoamTryUp();
        cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
        localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(paramCustomEmotionData.eId.getBytes()));
        localExpRoamPicInfo.uint32_pkg_id.set(Integer.parseInt(paramCustomEmotionData.emoPath));
        localExpRoamPicInfo.uint32_shop_flag.set(1);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localExpRoamPicInfo);
        ((cmd0x388.ExtensionExpRoamTryUp)localObject).rpt_msg_exproam_pic_info.set(localArrayList);
        paramTransferRequest.mExtentionInfo = ((cmd0x388.ExtensionExpRoamTryUp)localObject).toByteArray();
        paramTransferRequest.mUniseq = paramCustomEmotionData.emoId;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("uploadMarkFace frequest.mUniseq=");
          ((StringBuilder)localObject).append(paramTransferRequest.mUniseq);
          QLog.d("FavroamingManager", 2, ((StringBuilder)localObject).toString());
        }
        paramCustomEmotionData = ((IEmojiManagerService)this.mApp.getRuntimeService(IEmojiManagerService.class)).getImgPreviewTask(paramCustomEmotionData.emoPath, paramCustomEmotionData.eId, false);
        paramTransferRequest.mLocalPath = paramCustomEmotionData[1];
        ThreadManager.post(new FavroamingManagerServiceImpl.7(this, paramCustomEmotionData, paramTransferRequest), 5, null, true);
        return;
      }
      catch (Exception paramCustomEmotionData)
      {
        QLog.e("FavroamingManager", 1, new Object[] { "uploadMarkFace error =", paramCustomEmotionData.getMessage() });
        if ((paramTransferRequest.mUpCallBack instanceof EmoBatchAddedCallback)) {
          EmoBatchAddedCallback.a((EmoBatchAddedCallback)paramTransferRequest.mUpCallBack);
        }
      }
    }
  }
  
  public void uploadNoMarkFace(CustomEmotionData paramCustomEmotionData, TransferRequest paramTransferRequest)
  {
    Object localObject1;
    cmd0x388.ExpRoamPicInfo localExpRoamPicInfo;
    int i;
    int j;
    if (paramCustomEmotionData != null)
    {
      if (paramTransferRequest == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("uploadNoMarkFace ");
        ((StringBuilder)localObject1).append(paramCustomEmotionData);
        QLog.d("FavroamingManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new cmd0x388.ExtensionExpRoamTryUp();
      localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
      localObject2 = FunnyPicHelperConstant.a(paramCustomEmotionData.emoPath);
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
      i = 1;
      if ((!bool) && (((String)localObject2).contains("qto_")))
      {
        localObject2 = ((String)localObject2).replace("qto_", "qto@");
        localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("upload FunnyPic name.replace->");
          localStringBuilder.append((String)localObject2);
          QLog.d("FavroamingManager", 2, localStringBuilder.toString());
        }
        j = FunnyPicHelper.a(paramCustomEmotionData.eId);
        i = j;
        if (j == 0) {
          i = 1;
        }
        localExpRoamPicInfo.uint32_pkg_id.set(i);
      }
      else
      {
        localObject2 = DiyDoutuHelper.a(paramCustomEmotionData.emoPath);
        if (!((String)localObject2).equals("")) {
          localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
        }
      }
    }
    try
    {
      j = Integer.parseInt(paramCustomEmotionData.eId);
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label254:
      break label254;
    }
    localExpRoamPicInfo.uint32_pkg_id.set(i);
    break label292;
    localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom("0".getBytes()));
    localExpRoamPicInfo.uint32_pkg_id.set(0);
    label292:
    localExpRoamPicInfo.uint32_shop_flag.set(0);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localExpRoamPicInfo);
    ((cmd0x388.ExtensionExpRoamTryUp)localObject1).rpt_msg_exproam_pic_info.set((List)localObject2);
    paramTransferRequest.mExtentionInfo = ((cmd0x388.ExtensionExpRoamTryUp)localObject1).toByteArray();
    paramTransferRequest.mUniseq = paramCustomEmotionData.emoId;
    paramTransferRequest.mLocalPath = paramCustomEmotionData.emoPath;
    paramCustomEmotionData = this.mFileController;
    if (paramCustomEmotionData != null) {
      paramCustomEmotionData.transferAsync(paramTransferRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */