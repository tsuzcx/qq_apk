package com.tencent.mobileqq.emosm.favroaming;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler;
import com.tencent.mobileqq.app.DiyDoutuHelper;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerProxy;
import com.tencent.mobileqq.model.EmoticonManager;
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
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamPicInfo;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionExpRoamTryUp;

public class FavroamingManager
  extends CustomEmotionRoamingManagerBase<CustomEmotionData>
{
  protected int a;
  private FavEmoRoamingObserver jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver = new FavroamingManager.2(this);
  private EmoAddedAuthCallback.UploadListener jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoAddedAuthCallback$UploadListener;
  public EmoticonPackageDownloadListener a;
  private EmotionJsonDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener = new FavroamingManager.6(this);
  protected TransProcessorHandler a;
  protected ITransFileController a;
  WeakReference<TransferRequest> jdField_a_of_type_JavaLangRefWeakReference;
  protected Map<String, ArrayList<CustomEmotionData>> a;
  private ConcurrentHashMap<Integer, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  protected AtomicInteger a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  protected AtomicInteger b;
  private boolean b;
  
  public FavroamingManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new FavroamingManager.1(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new FavroamingManager.5(this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      int i = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("fav_roaming_max" + this.jdField_a_of_type_JavaLangString, 144);
      if (i > 144) {
        FavEmoConstant.jdField_a_of_type_Int = i;
      }
    }
  }
  
  public static FavroamingManager a(QQAppInterface paramQQAppInterface)
  {
    return (FavroamingManager)paramQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
  }
  
  public static FavroamingManagerProxy a(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    return (FavroamingManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return String.format(BaseApplicationImpl.getApplication().getString(2131691970), new Object[] { str });
  }
  
  private void a(String paramString, EmoAddedAuthCallback.UploadListener paramUploadListener)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (FavroamingDBManager)localQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    List localList = ((FavroamingDBManager)localObject).a();
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
            ((FavroamingDBManager)localObject).a(localCustomEmotionData, j);
            if (paramUploadListener != null) {
              paramUploadListener.a(0, str);
            }
          }
          while (paramUploadListener == null) {
            return;
          }
          paramUploadListener.a(1, str);
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
    ((CustomEmotionData)localObject).uin = localQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (k + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    ((CustomEmotionData)localObject).isMarkFace = false;
    paramString = new EmoAddedAuthCallback(localQQAppInterface, null, (CustomEmotionData)localObject, null, 2);
    paramString.a(paramUploadListener);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(b((CustomEmotionData)localObject, paramString));
  }
  
  private void i()
  {
    int j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_a_of_type_Int = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
      {
        SyncListener localSyncListener = (SyncListener)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
        if (localSyncListener != null) {
          localSyncListener.onDownloadFinish(j);
        }
      }
      i += 1;
    }
    g();
  }
  
  public int a()
  {
    return 9;
  }
  
  public int a(List<CustomEmotionData> paramList)
  {
    int i = 0;
    if ((paramList == null) || (paramList.size() == 0) || (!NetworkUtil.d(BaseApplication.getContext()))) {
      return 0;
    }
    Object localObject = paramList;
    if (paramList.size() > FavEmoConstant.jdField_a_of_type_Int)
    {
      j = paramList.size() - FavEmoConstant.jdField_a_of_type_Int;
      localObject = paramList.subList(j, FavEmoConstant.jdField_a_of_type_Int + j);
    }
    int k = ((List)localObject).size();
    int j = 0;
    if (j < k)
    {
      paramList = (CustomEmotionData)((List)localObject).get(j);
      if (("needDownload".equals(paramList.RomaingType)) || ("needDel".equals(paramList.RomaingType))) {
        break label161;
      }
      if (!"isUpdate".equals(paramList.RomaingType)) {}
    }
    label161:
    for (;;)
    {
      j += 1;
      break;
      a(paramList, null);
      i += 1;
      continue;
      this.jdField_b_of_type_Int = i;
      return i;
    }
  }
  
  public CustomEmoRoamingBaseHandler<CustomEmotionData> a()
  {
    return (FavEmoRoamingHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER);
  }
  
  public CustomEmotionRoamingDBManagerBase<CustomEmotionData> a()
  {
    return (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
  }
  
  public TransferRequest a(CustomEmotionData paramCustomEmotionData, UpCallBack paramUpCallBack)
  {
    if (paramCustomEmotionData == null) {
      if ((paramUpCallBack instanceof EmoBatchAddedCallback)) {
        EmoBatchAddedCallback.a((EmoBatchAddedCallback)paramUpCallBack);
      }
    }
    do
    {
      return null;
      if (NetworkUtil.d(BaseApplication.getContext())) {
        break;
      }
    } while (!(paramUpCallBack instanceof EmoBatchAddedCallback));
    EmoBatchAddedCallback.a((EmoBatchAddedCallback)paramUpCallBack);
    return null;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_Boolean = true;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mFileType = 24;
    localTransferRequest.mCommandId = 9;
    localTransferRequest.mRichTag = "scbqmanyou";
    localTransferRequest.mSelfUin = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.mPeerUin = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.mIsUp = true;
    if (paramUpCallBack != null) {
      localTransferRequest.mUpCallBack = paramUpCallBack;
    }
    if (paramCustomEmotionData.isMarkFace)
    {
      b(paramCustomEmotionData, localTransferRequest);
      return localTransferRequest;
    }
    a(paramCustomEmotionData, localTransferRequest);
    return localTransferRequest;
  }
  
  public String a(Integer paramInteger)
  {
    if (paramInteger == null) {
      return a("");
    }
    return a((String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramInteger));
  }
  
  public void a(CustomEmotionData paramCustomEmotionData)
  {
    paramCustomEmotionData.increaseClickNum();
    a().b(paramCustomEmotionData);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, TransferRequest paramTransferRequest)
  {
    int j = 1;
    int i = 1;
    if ((paramCustomEmotionData == null) || (paramTransferRequest == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "uploadNoMarkFace " + paramCustomEmotionData);
    }
    cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
    cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
    Object localObject = FunnyPicHelper.a(paramCustomEmotionData.emoPath);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("qto_")))
    {
      localObject = ((String)localObject).replace("qto_", "qto@");
      localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "upload FunnyPic name.replace->" + (String)localObject);
      }
      j = FunnyPicHelper.a(paramCustomEmotionData.eId);
      if (j != 0) {
        break label354;
      }
    }
    for (;;)
    {
      localExpRoamPicInfo.uint32_pkg_id.set(i);
      for (;;)
      {
        localExpRoamPicInfo.uint32_shop_flag.set(0);
        localObject = new ArrayList();
        ((List)localObject).add(localExpRoamPicInfo);
        localExtensionExpRoamTryUp.rpt_msg_exproam_pic_info.set((List)localObject);
        paramTransferRequest.mExtentionInfo = localExtensionExpRoamTryUp.toByteArray();
        paramTransferRequest.mUniseq = paramCustomEmotionData.emoId;
        paramTransferRequest.mLocalPath = paramCustomEmotionData.emoPath;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.transferAsync(paramTransferRequest);
        return;
        localObject = DiyDoutuHelper.a(paramCustomEmotionData.emoPath);
        if (!((String)localObject).equals("")) {
          localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
        }
        try
        {
          i = Integer.parseInt(paramCustomEmotionData.eId);
          localExpRoamPicInfo.uint32_pkg_id.set(i);
          continue;
          localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom("0".getBytes()));
          localExpRoamPicInfo.uint32_pkg_id.set(0);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            i = j;
          }
        }
      }
      label354:
      i = j;
    }
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramCustomEmotionData == null)) {}
    FavEmoRoamingHandler localFavEmoRoamingHandler;
    do
    {
      return;
      localFavEmoRoamingHandler = (FavEmoRoamingHandler)a();
    } while (localFavEmoRoamingHandler == null);
    localFavEmoRoamingHandler.a(paramCustomEmotionData, paramString);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    if ((paramCustomEmotionData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    int i;
    label205:
    label228:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onFileDone, resId=" + paramCustomEmotionData.resid + ",isSuccess = " + paramBoolean + " , roamingType: " + paramCustomEmotionData.RomaingType);
      }
      Object localObject = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
      if ((localObject != null) && (paramBoolean))
      {
        if (!"needDownload".equals(paramCustomEmotionData.RomaingType)) {
          break label205;
        }
        paramCustomEmotionData.RomaingType = "isUpdate";
        if ("needDel".equals(paramCustomEmotionData.RomaingType)) {
          break label228;
        }
        ((FavroamingDBManager)localObject).b(paramCustomEmotionData);
      }
      for (;;)
      {
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
          {
            localObject = (SyncListener)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
            if (localObject != null) {
              ((SyncListener)localObject).onFileDone(paramCustomEmotionData, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
            }
          }
          i += 1;
        }
        if (!"overflow".equals(paramCustomEmotionData.RomaingType)) {
          break;
        }
        paramCustomEmotionData.RomaingType = "overflow_downloaded";
        break;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "onFileDone, resId=" + paramCustomEmotionData.resid + " has been deleted");
        }
      }
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "market face : downloadCount: " + i + ",needDownloadCount: " + this.jdField_a_of_type_Int);
      }
    } while (i < this.jdField_a_of_type_Int);
    i();
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramEmoticonPackage.epId);
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localArrayList.get(i);
        if (localCustomEmotionData != null) {
          a(localCustomEmotionData, false);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "downloadAIOEmoticon fail epId:" + paramEmoticonPackage.epId);
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, EmojiManager paramEmojiManager)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramEmoticonPackage.epId);
    int i;
    CustomEmotionData localCustomEmotionData;
    Emoticon localEmoticon;
    if (localArrayList != null) {
      if (paramEmoticonPackage.jobType == 0)
      {
        i = 0;
        if (i >= localArrayList.size()) {
          break label367;
        }
        localCustomEmotionData = (CustomEmotionData)localArrayList.get(i);
        if (localCustomEmotionData == null) {}
        for (;;)
        {
          i += 1;
          break;
          localEmoticon = new Emoticon();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            break label100;
          }
          QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|app null");
          a(localCustomEmotionData, false);
        }
        label100:
        EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
        if (localEmoticonManager == null) {
          break label368;
        }
        localEmoticon = localEmoticonManager.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
      }
    }
    label367:
    label368:
    for (;;)
    {
      if (localEmoticon == null)
      {
        QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|cannot find emoticon: epId:" + paramEmoticonPackage.epId + "，eid=" + localCustomEmotionData.eId);
        localCustomEmotionData.RomaingType = "needDel";
        ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).b(localCustomEmotionData);
        a((CustomEmotionData)localArrayList.get(i), false);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "downloadAIOEmoticon|taskvalue:" + 14 + "，epid:" + localEmoticon.epId + "，eid=" + localEmoticon.eId);
      }
      if (paramEmojiManager.a(localEmoticon, 14))
      {
        a((CustomEmotionData)localArrayList.get(i), true);
        break;
      }
      a((CustomEmotionData)localArrayList.get(i), false);
      break;
      if ((paramEmoticonPackage.jobType == 3) || (paramEmoticonPackage.jobType == 5))
      {
        EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
        paramEmojiManager.a(paramEmoticonPackage, false);
      }
      return;
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, EmojiManager paramEmojiManager, ArrayList<Emoticon> paramArrayList, ReqInfo paramReqInfo)
  {
    if ((!paramReqInfo.jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
    {
      int i = 0;
      int j;
      do
      {
        paramReqInfo.jdField_a_of_type_JavaLangString = null;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
        }
        paramEmojiManager.a(paramEmoticonPackage.epId, paramArrayList, paramReqInfo);
        j = i + 1;
        if (paramReqInfo.jdField_a_of_type_Boolean) {
          break;
        }
        i = j;
      } while (j < 3);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + paramReqInfo.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void a(Integer paramInteger)
  {
    if (paramInteger == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramInteger);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener);
    ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(paramString, EmojiManager.c, null, false);
  }
  
  public void a(List<CustomEmotionData> paramList)
  {
    if (paramList == null) {
      return;
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        Object localObject;
        try
        {
          this.jdField_a_of_type_JavaUtilMap.clear();
          i = 0;
          if (i < paramList.size())
          {
            localObject = (CustomEmotionData)paramList.get(i);
            if (localObject == null) {
              break label219;
            }
            if (this.jdField_a_of_type_JavaUtilMap.containsKey(((CustomEmotionData)localObject).emoPath))
            {
              ((ArrayList)this.jdField_a_of_type_JavaUtilMap.get(((CustomEmotionData)localObject).emoPath)).add(localObject);
            }
            else
            {
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localObject);
              this.jdField_a_of_type_JavaUtilMap.put(((CustomEmotionData)localObject).emoPath, localArrayList);
            }
          }
        }
        finally {}
        try
        {
          paramList = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          while (paramList.hasNext())
          {
            localObject = (Map.Entry)paramList.next();
            if (localObject != null) {
              a((String)((Map.Entry)localObject).getKey());
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception paramList) {}
      }
      QLog.d("FavroamingManager", 2, "downMap exception=" + paramList.toString());
      break;
      label219:
      i += 1;
    }
  }
  
  public void a(List<String> paramList, FavroamingManager.AddCustomEmotionsCallback paramAddCustomEmotionsCallback)
  {
    if (paramList == null) {}
    int i;
    do
    {
      return;
      i = paramList.size();
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FavroamingManager", 2, "addCustomEmotions pathList is empty");
    return;
    this.jdField_b_of_type_Boolean = false;
    ThreadManager.excute(new FavroamingManager.8(this, i, paramAddCustomEmotionsCallback, paramList), 64, null, true);
  }
  
  public TransferRequest b(CustomEmotionData paramCustomEmotionData, UpCallBack paramUpCallBack)
  {
    return a(paramCustomEmotionData, paramUpCallBack);
  }
  
  public void b(CustomEmotionData paramCustomEmotionData)
  {
    paramCustomEmotionData.increaseExposeNum();
    a().b(paramCustomEmotionData);
  }
  
  public void b(CustomEmotionData paramCustomEmotionData, TransferRequest paramTransferRequest)
  {
    if ((paramCustomEmotionData == null) || (paramTransferRequest == null)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "uploadMarkFace favEmoticon.epid=" + paramCustomEmotionData.emoPath + " and eid=" + paramCustomEmotionData.eId);
        }
        if (paramCustomEmotionData.checkMarketFace("uploadMarkFace")) {
          break;
        }
        QLog.e("FavroamingManager", 1, "uploadMarkFace: marketFace is invalid");
      } while (!(paramTransferRequest.mUpCallBack instanceof EmoBatchAddedCallback));
      EmoBatchAddedCallback.a((EmoBatchAddedCallback)paramTransferRequest.mUpCallBack);
      return;
      try
      {
        cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
        cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
        localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(paramCustomEmotionData.eId.getBytes()));
        localExpRoamPicInfo.uint32_pkg_id.set(Integer.parseInt(paramCustomEmotionData.emoPath));
        localExpRoamPicInfo.uint32_shop_flag.set(1);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localExpRoamPicInfo);
        localExtensionExpRoamTryUp.rpt_msg_exproam_pic_info.set(localArrayList);
        paramTransferRequest.mExtentionInfo = localExtensionExpRoamTryUp.toByteArray();
        paramTransferRequest.mUniseq = paramCustomEmotionData.emoId;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "uploadMarkFace frequest.mUniseq=" + paramTransferRequest.mUniseq);
        }
        paramCustomEmotionData = EmojiManager.a(paramCustomEmotionData.emoPath, paramCustomEmotionData.eId, false);
        paramTransferRequest.mLocalPath = paramCustomEmotionData[1];
        ThreadManager.post(new FavroamingManager.7(this, paramCustomEmotionData, paramTransferRequest), 5, null, true);
        return;
      }
      catch (Exception paramCustomEmotionData)
      {
        QLog.e("FavroamingManager", 1, new Object[] { "uploadMarkFace error =", paramCustomEmotionData.getMessage() });
      }
    } while (!(paramTransferRequest.mUpCallBack instanceof EmoBatchAddedCallback));
    EmoBatchAddedCallback.a((EmoBatchAddedCallback)paramTransferRequest.mUpCallBack);
  }
  
  public void b(List<CustomEmotionData> paramList)
  {
    if (paramList != null) {
      a(paramList);
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "downloadCount:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", needDownloadCount" + this.jdField_a_of_type_Int + "uploadCount:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", needUploadCount" + this.jdField_b_of_type_Int);
    }
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.jdField_a_of_type_Int) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.jdField_b_of_type_Int);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    FavEmoRoamingHandler localFavEmoRoamingHandler;
    do
    {
      return;
      localFavEmoRoamingHandler = (FavEmoRoamingHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER);
    } while (localFavEmoRoamingHandler == null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
    ThreadManager.excute(new FavroamingManager.3(this, localFavEmoRoamingHandler), 128, null, true);
  }
  
  public void c(CustomEmotionData paramCustomEmotionData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramCustomEmotionData == null)) {
      return;
    }
    a().b(paramCustomEmotionData);
    StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
  }
  
  public void d()
  {
    int i = 0;
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    Object localObject2;
    Object localObject3;
    label197:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      Object localObject1 = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
      localObject2 = ((FavroamingDBManager)localObject1).b("needDownload");
      localObject3 = ((FavroamingDBManager)localObject1).b("overflow");
      localObject1 = new ArrayList();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject3);
      }
      CustomEmotionData localCustomEmotionData;
      if (((List)localObject1).size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        if (i >= ((List)localObject1).size()) {
          continue;
        }
        localCustomEmotionData = (CustomEmotionData)((List)localObject1).get(i);
        if (!localCustomEmotionData.isMarkFace) {
          break label197;
        }
        ((List)localObject3).add(localCustomEmotionData);
      }
      for (;;)
      {
        i += 1;
        break;
        g();
        return;
        ((List)localObject2).add(localCustomEmotionData);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    this.jdField_a_of_type_Int = ((List)localObject3).size();
    if (this.jdField_a_of_type_Int == 0) {
      g();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "markFace size: " + ((List)localObject3).size() + ", noMarkFace size:" + ((List)localObject2).size());
    }
    ThreadManager.getUIHandler().post(new FavroamingManager.4(this));
    a((List)localObject3);
  }
  
  public void d(CustomEmotionData paramCustomEmotionData)
  {
    b(paramCustomEmotionData, null);
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      TransferRequest localTransferRequest = (TransferRequest)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localTransferRequest != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.stop(localTransferRequest);
      }
    }
  }
  
  protected void f()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_b_of_type_Int = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
      {
        SyncListener localSyncListener = (SyncListener)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
        if (localSyncListener != null) {
          localSyncListener.onUploadFinish();
        }
      }
      i += 1;
    }
    g();
  }
  
  protected void g()
  {
    if (b())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "------------end syncRoaming----------");
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
        {
          SyncListener localSyncListener = (SyncListener)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
          if (localSyncListener != null) {
            localSyncListener.onSyncFinish();
          }
        }
        i += 1;
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject;
    EmoticonManager localEmoticonManager;
    do
    {
      return;
      localObject = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
      localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
      localObject = ((FavroamingDBManager)localObject).a();
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Iterator localIterator = ((List)localObject).iterator();
    label69:
    CustomEmotionData localCustomEmotionData;
    String str;
    if (localIterator.hasNext())
    {
      localCustomEmotionData = (CustomEmotionData)localIterator.next();
      str = "";
      if (!localCustomEmotionData.isMarkFace) {
        break label164;
      }
      Emoticon localEmoticon = localEmoticonManager.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
      localObject = str;
      if (localEmoticon != null)
      {
        localObject = str;
        if (!TextUtils.isEmpty(localEmoticon.name)) {
          localObject = localEmoticon.name;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localCustomEmotionData.emoId), localObject);
      break label69;
      break;
      label164:
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
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager
 * JD-Core Version:    0.7.0.1
 */