package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.EmotionInjectionInfo;
import com.tencent.mobileqq.EmotionPanelManager;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor.EmoticonTabSortConfBean;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.SmallEmojiSpan;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class EmoticonUtils
{
  public static String H5MagicFileListPath = H5MagicRootPath + "fileList";
  public static String H5MagicIndexHtmlPath;
  public static String H5MagicRootPath;
  public static String H5MagicZipPath;
  private static final String LOG_TAG = "EmoticonUtils";
  public static final String RELATED_EMO_C2C_HTTP_PREFIX = "http://c2cpicdw.qpic.cn";
  public static final String RELATED_EMO_GROUP_HTTP_PREFIX = "http://gchat.qpic.cn";
  public static final String REPORT_TAG_0X800AE20 = "0X800AE20";
  public static final String REPORT_TAG_0X800AE21 = "0X800AE21";
  public static final String REPORT_TAG_0X800AE22 = "0X800AE22";
  public static final String REPORT_TAG_0X800AE23 = "0X800AE23";
  public static final String REPORT_TAG_0X800AE24 = "0X800AE24";
  public static final String REPORT_TAG_0X800AE25 = "0X800AE25";
  public static final String REPORT_TAG_0X800AE27 = "0X800AE27";
  public static final String REPORT_TAG_0X800AE28 = "0X800AE28";
  public static final String REPORT_TAG_0X800AE29 = "0X800AE29";
  public static final String REPORT_TAG_0X800AE2A = "0X800AE2A";
  public static final String REPORT_TAG_0X800AE2B = "0X800AE2B";
  public static final String REPORT_TAG_0X800AE2C = "0X800AE2C";
  public static final String REPORT_TAG_0X800AE2E = "0X800AE2E";
  public static final String REPORT_TAG_0X800AE2F = "0X800AE2F";
  public static final String REPORT_TAG_0X800AE30 = "0X800AE30";
  public static final String REPORT_TAG_0X800AE31 = "0X800AE31";
  public static final String REPORT_TAG_0X800AE32 = "0X800AE32";
  public static final String REPORT_TAG_0X800AE33 = "0X800AE33";
  public static String emoticonAIOPreviewExtensionUrl;
  public static String emoticonAIOPreviewPath;
  public static String emoticonAPNGPath;
  public static String emoticonEncryptExtensionApngUrl;
  public static String emoticonEncryptExtensionUrl;
  public static String emoticonEncryptPath;
  public static String emoticonJsonFilePath;
  public static String emoticonPNGZIPUrl;
  public static String emoticonPackageFolderPath;
  public static String emoticonPreviewPath;
  public static String emoticonPreviewUrl;
  public static String emoticonRecommendUrl;
  public static String emoticonSoundPath;
  public static String emoticonSoundUrl;
  public static String giftBigAnimationPath;
  public static String magicFaceZipPath = emoticonPackageFolderPath + "[epId].zip";
  public static String pngFramePath = emoticonPackageFolderPath + "pngframe/";
  public static String smallApngUrl;
  public static String smallEmoticonJsonUrl;
  public static String smallEmoticonThumbUrl;
  public static String smallGifUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].gif";
  public static String smallRecommendUrl;
  
  static
  {
    smallApngUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId]_apng.png";
    smallEmoticonJsonUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/xydata.json";
    smallEmoticonThumbUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].png";
    emoticonSoundUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/ring.amr";
    emoticonPNGZIPUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/pngframe.zip";
    emoticonPreviewUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/126x126.png";
    emoticonEncryptExtensionUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]";
    emoticonEncryptExtensionApngUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]_apng";
    emoticonAIOPreviewExtensionUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]x[height].png";
    emoticonRecommendUrl = "https://gxh.vip.qq.com/club/item/parcel/img/parcel/[mod]/[epId]/200x200.png";
    smallRecommendUrl = "https://gxh.vip.qq.com/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/200x200.png";
    giftBigAnimationPath = AppConstants.SDCARD_GIFT_SAVE + "[epId]" + File.separator;
    emoticonPackageFolderPath = AppConstants.SDCARD_EMOTICON_SAVE + "[epId]" + File.separator;
    emoticonSoundPath = emoticonPackageFolderPath + "[eId].amr";
    emoticonPreviewPath = emoticonPackageFolderPath + "[eId]_thu.png";
    emoticonAIOPreviewPath = emoticonPackageFolderPath + "[eId]_aio.png";
    emoticonJsonFilePath = emoticonPackageFolderPath + "[epId].jtmp";
    emoticonEncryptPath = emoticonPackageFolderPath + "[eId]";
    emoticonAPNGPath = emoticonPackageFolderPath + "[eId]_apng";
    H5MagicZipPath = emoticonPackageFolderPath + "h5_json.zip";
    H5MagicRootPath = emoticonPackageFolderPath + "h5magic" + File.separator;
    H5MagicIndexHtmlPath = H5MagicRootPath + "index.html";
  }
  
  public static void clickSmallEmoticon(EmoticonSpan[] paramArrayOfEmoticonSpan, float paramFloat1, float paramFloat2, boolean paramBoolean1, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Activity paramActivity, boolean paramBoolean2)
  {
    if ((paramArrayOfEmoticonSpan == null) || (paramQQAppInterface == null) || (paramSessionInfo == null) || (paramActivity == null)) {}
    Object localObject1;
    int j;
    do
    {
      return;
      localObject1 = new TreeSet();
      int i = 0;
      j = paramInt1;
      paramInt1 = i;
      while (paramInt1 < paramArrayOfEmoticonSpan.length)
      {
        Object localObject2 = paramArrayOfEmoticonSpan[paramInt1];
        boolean bool = paramBoolean1;
        int k = j;
        i = paramInt2;
        if ((localObject2 instanceof SmallEmojiSpan))
        {
          localObject2 = (SmallEmojiSpan)localObject2;
          float f1 = ((SmallEmojiSpan)localObject2).eLeft;
          float f2 = ((SmallEmojiSpan)localObject2).eTop;
          float f3 = ((SmallEmojiSpan)localObject2).eRight;
          float f4 = ((SmallEmojiSpan)localObject2).eBottom;
          int m = ((SmallEmojiSpan)localObject2).b;
          int n = ((SmallEmojiSpan)localObject2).c;
          ((TreeSet)localObject1).add(Integer.valueOf(m));
          bool = paramBoolean1;
          k = j;
          i = paramInt2;
          if (!paramBoolean2)
          {
            bool = paramBoolean1;
            k = j;
            i = paramInt2;
            if (paramFloat1 >= f1)
            {
              bool = paramBoolean1;
              k = j;
              i = paramInt2;
              if (paramFloat1 <= f3)
              {
                bool = paramBoolean1;
                k = j;
                i = paramInt2;
                if (paramFloat2 >= f2)
                {
                  bool = paramBoolean1;
                  k = j;
                  i = paramInt2;
                  if (paramFloat2 <= f4)
                  {
                    bool = paramBoolean1;
                    k = j;
                    i = paramInt2;
                    if (!paramBoolean1)
                    {
                      bool = true;
                      i = n;
                      k = m;
                    }
                  }
                }
              }
            }
          }
        }
        paramInt1 += 1;
        paramBoolean1 = bool;
        j = k;
        paramInt2 = i;
      }
    } while (!paramBoolean1);
    if (((TreeSet)localObject1).size() == 1)
    {
      ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).b(String.valueOf(j), 0, new EmoticonUtils.1(paramSessionInfo, paramQQAppInterface, j, paramActivity));
      return;
    }
    paramSessionInfo = ((TreeSet)localObject1).iterator();
    for (paramArrayOfEmoticonSpan = ""; paramSessionInfo.hasNext(); paramArrayOfEmoticonSpan = paramArrayOfEmoticonSpan + localObject1 + ",") {
      localObject1 = (Integer)paramSessionInfo.next();
    }
    paramSessionInfo = paramArrayOfEmoticonSpan;
    if (!paramArrayOfEmoticonSpan.equals("")) {
      paramSessionInfo = paramArrayOfEmoticonSpan.substring(0, paramArrayOfEmoticonSpan.length() - 1);
    }
    EmojiHomeUiPlugin.openSmallEmojiListPage(paramActivity, paramQQAppInterface.getAccount(), 11, paramSessionInfo);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007000", 0, 0, String.valueOf(j), String.valueOf(paramInt2), "", "");
  }
  
  public static void downloadNormalEmotion(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramQQEmoticonMainPanelApp != null) && (paramEmoticonPackage != null))
    {
      paramQQEmoticonMainPanelApp = (EmojiManagerProxy)paramQQEmoticonMainPanelApp.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
      if ((paramQQEmoticonMainPanelApp.getEmoticonPackageLoadingProgress(paramEmoticonPackage.epId) < 0.0F) && (isWifi()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonUtils", 2, "downloadNormalEmotion wifi auto download emotion , epid = " + paramEmoticonPackage.epId);
        }
        paramQQEmoticonMainPanelApp.pullEmoticonPackage(paramEmoticonPackage, false, false, paramInt);
      }
    }
  }
  
  public static boolean emoticonPkgNeedUpdate(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 2) && ((paramInt2 & 0x1) == 1);
  }
  
  public static boolean emoticonPkgNeedUpdate(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage != null) && (paramEmoticonPackage.status == 2) && ((paramEmoticonPackage.updateFlag & 0x1) == 1);
  }
  
  public static List<EmotionPanelInfo> getAllEmotionPanelData(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    List localList2 = Collections.synchronizedList(new ArrayList());
    List localList1 = ((EmoticonManagerProxy)paramQQEmoticonMainPanelApp.getManager(QQManagerFactory.EMOTICON_MANAGER)).syncGetTabEmoticonPackages(paramInt);
    Object localObject = EmoticonTabSortConfProcessor.a();
    label92:
    EmoticonPackage localEmoticonPackage;
    label176:
    int i;
    if ((localObject != null) && (!((EmoticonTabSortConfProcessor.EmoticonTabSortConfBean)localObject).b.isEmpty()))
    {
      localList2.addAll(sortEmoticonTabs(paramQQEmoticonMainPanelApp, ((EmoticonTabSortConfProcessor.EmoticonTabSortConfBean)localObject).b, null, paramInt, paramBoolean));
      if (localList1 == null) {
        break label409;
      }
      localObject = localList1.iterator();
      paramInt = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label409;
      }
      localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
      if ((localEmoticonPackage.type == 1) || (3 == localEmoticonPackage.jobType) || (1 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
        break label352;
      }
      localList1 = null;
      if (localEmoticonPackage.jobType != 4) {
        break label318;
      }
      paramQQEmoticonMainPanelApp = new EmotionPanelInfo(10, 7, localEmoticonPackage);
      i = paramInt;
      if (paramQQEmoticonMainPanelApp != null)
      {
        localList2.add(paramQQEmoticonMainPanelApp);
        i = paramInt;
      }
      label193:
      paramQQEmoticonMainPanelApp = localEmoticonPackage.epId;
      if (localEmoticonPackage.status != 2) {
        break label403;
      }
    }
    label403:
    for (boolean bool = true;; bool = false)
    {
      EmoticonTabAdapter.generateTabUrl(paramQQEmoticonMainPanelApp, bool);
      paramInt = i;
      break label92;
      localObject = new ArrayList();
      ((List)localObject).add("sysface");
      ((List)localObject).add("favorite");
      ((List)localObject).add("hotpic");
      ((List)localObject).add("camera");
      ((List)localObject).add("cmshow");
      ((List)localObject).add("recommend");
      localList2.addAll(sortEmoticonTabs(paramQQEmoticonMainPanelApp, (List)localObject, null, paramInt, paramBoolean));
      break;
      label318:
      paramQQEmoticonMainPanelApp = localList1;
      if (localEmoticonPackage.jobType != 0) {
        break label176;
      }
      paramQQEmoticonMainPanelApp = localList1;
      if (paramBoolean) {
        break label176;
      }
      paramQQEmoticonMainPanelApp = new EmotionPanelInfo(6, 4, localEmoticonPackage);
      break label176;
      label352:
      if (3 != localEmoticonPackage.jobType)
      {
        i = paramInt;
        if (5 != localEmoticonPackage.jobType) {
          break label193;
        }
      }
      i = paramInt;
      if (paramInt != 0) {
        break label193;
      }
      localList2.add(new EmotionPanelInfo(9, 4, localEmoticonPackage));
      i = 1;
      break label193;
    }
    label409:
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonUtils", 2, "prepare data cost time:" + (l2 - l1));
    }
    return localList2;
  }
  
  public static EmoticonManager getEmoticonManager()
  {
    try
    {
      AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localAppInterface != null) {
        return (EmoticonManager)localAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        localClassCastException.printStackTrace();
        Object localObject = null;
      }
    }
    return null;
  }
  
  public static String getMessageForPicUrl(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.isSend()) {
      return "";
    }
    int i = paramMessageForPic.istroop;
    if (paramMessageForPic.rawMsgUrl != null) {
      paramMessageForPic = paramMessageForPic.rawMsgUrl;
    }
    while ((i == 1) || (i == 3000))
    {
      return "http://gchat.qpic.cn" + paramMessageForPic;
      if (paramMessageForPic.bigMsgUrl != null) {
        paramMessageForPic = paramMessageForPic.bigMsgUrl;
      } else if (paramMessageForPic.thumbMsgUrl != null) {
        paramMessageForPic = paramMessageForPic.thumbMsgUrl;
      } else {
        return "";
      }
    }
    return "http://c2cpicdw.qpic.cn" + paramMessageForPic;
  }
  
  public static List<EmotionPanelInfo> getNonBigAndFavEmotionPanelData(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp)
  {
    paramQQEmoticonMainPanelApp = new ArrayList();
    paramQQEmoticonMainPanelApp.add(new EmotionPanelInfo(7, 7, null));
    return paramQQEmoticonMainPanelApp;
  }
  
  public static List<EmotionPanelInfo> getNonBigEmotionPanelData(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp)
  {
    ArrayList localArrayList1 = new ArrayList();
    EmoticonTabSortConfProcessor.EmoticonTabSortConfBean localEmoticonTabSortConfBean = EmoticonTabSortConfProcessor.a();
    if ((localEmoticonTabSortConfBean != null) && (!localEmoticonTabSortConfBean.b.isEmpty()))
    {
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add("sysface");
      localArrayList2.add("favorite");
      localArrayList2.add("hotpic");
      localArrayList2.add("camera");
      localArrayList1.addAll(sortEmoticonTabs(paramQQEmoticonMainPanelApp, localEmoticonTabSortConfBean.b, localArrayList2, 0, false));
    }
    do
    {
      return localArrayList1;
      localArrayList1.add(new EmotionPanelInfo(7, 7, null));
    } while (paramQQEmoticonMainPanelApp.getQQAppInterface() == null);
    localArrayList1.add(new EmotionPanelInfo(4, 4, null));
    localArrayList1.add(new EmotionPanelInfo(12, 4, null));
    localArrayList1.add(new EmotionPanelInfo(11, 4, null));
    return localArrayList1;
  }
  
  public static int getRelatedEmoCurType(int paramInt)
  {
    if (paramInt != -1) {}
    switch (Integer.valueOf(ChatActivityUtils.b(paramInt)).intValue())
    {
    case 1: 
    default: 
      return 4;
    case 0: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static int getRelatedEmotionReportFromType(int paramInt)
  {
    if (paramInt != -1) {}
    switch (Integer.valueOf(ChatActivityUtils.b(paramInt)).intValue())
    {
    default: 
      return 0;
    case 0: 
      return 2;
    case 3: 
      return 1;
    case 1: 
      return 3;
    }
    return 4;
  }
  
  public static String getRelatedEmotionReportType(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      return "";
    }
    if ((paramMessageForPic.picExtraData == null) && (!paramMessageForPic.checkGif())) {
      return "";
    }
    PicMessageExtraData localPicMessageExtraData = paramMessageForPic.picExtraData;
    if (localPicMessageExtraData != null)
    {
      if (localPicMessageExtraData.isCustomFace()) {
        return "2";
      }
      if (localPicMessageExtraData.isSelfieFace()) {
        return "3";
      }
      if (localPicMessageExtraData.isHotPics()) {
        return "6";
      }
      if ((localPicMessageExtraData.isDoutu()) || (localPicMessageExtraData.isDiyDouTu())) {
        return "7";
      }
      if (localPicMessageExtraData.isZhitu()) {
        return "8";
      }
      if ((localPicMessageExtraData.isStickerPics()) || (localPicMessageExtraData.isStickerAdPic())) {
        return "5";
      }
      if (localPicMessageExtraData.isRelatedEmo()) {
        return "10";
      }
      if (paramMessageForPic.checkGif()) {
        return "9";
      }
    }
    else if (paramMessageForPic.checkGif())
    {
      return "9";
    }
    return "";
  }
  
  public static String getStickerRecAioType(int paramInt)
  {
    if (paramInt == 11000) {
      return "qzone";
    }
    switch (Integer.valueOf(ChatActivityUtils.b(paramInt)).intValue())
    {
    default: 
      return "other";
    case 0: 
      return "c2c";
    case 3: 
      return "group";
    case 2: 
      return "discuss";
    }
    return "temp";
  }
  
  public static String getSystemAndEmojiEmoticonName(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) {
      if (((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).emotionType == 1) {
        paramEmoticonInfo = QQSysFaceUtil.getFaceDescription(((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).code);
      }
    }
    for (;;)
    {
      Object localObject = paramEmoticonInfo;
      if (paramEmoticonInfo != null)
      {
        localObject = paramEmoticonInfo;
        if (paramEmoticonInfo.length() > 1)
        {
          localObject = paramEmoticonInfo;
          if (paramEmoticonInfo.startsWith("/")) {
            localObject = paramEmoticonInfo.substring(1);
          }
        }
      }
      return localObject;
      if (((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).emotionType == 2)
      {
        paramEmoticonInfo = QQEmojiUtil.getEmojiDescription(((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).code);
        continue;
        return "";
      }
      else
      {
        paramEmoticonInfo = null;
      }
    }
  }
  
  public static boolean isEmoticonPkgNeverUpdateBitSet(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static boolean isEmoticonPkgUpdateBitSet(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean isShowEmoTitleInPreview(BaseChatPie paramBaseChatPie, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo == null) || (paramBaseChatPie == null)) {}
    while (paramEmoticonInfo.type != 7) {
      return false;
    }
    return true;
  }
  
  public static boolean isShowRelatedEmoInAio(int paramInt)
  {
    if (paramInt != -1) {}
    switch (Integer.valueOf(ChatActivityUtils.b(paramInt)).intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean isWifi()
  {
    return NetworkUtil.a(BaseApplication.getContext()) == 1;
  }
  
  public static boolean isWifiOrG3OrG4()
  {
    int i = NetworkUtil.a(BaseApplication.getContext());
    return (i == 1) || (i == 3) || (i == 4);
  }
  
  public static boolean needDisableAutoReceiveMagicFace()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int i = NetworkUtil.a(localBaseApplication);
    boolean bool = SettingCloneUtil.readValue(localBaseApplication, null, localBaseApplication.getString(2131694996), "qqsetting_auto_receive_magic_face_key", true);
    return ((i == 3) || (i == 4)) && (!bool);
  }
  
  public static void report(String paramString, int paramInt)
  {
    report(paramString, paramString, paramInt);
  }
  
  public static void report(String paramString1, String paramString2, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", paramString1, paramString2, paramInt, 0, "", "0", "0", "");
  }
  
  public static void reportFavAddEmotionEvent(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800AEE5", "0X800AEE5", paramInt, 0, "", "", paramString1, paramString2);
        return;
      }
    }
  }
  
  public static boolean shouldDisplayBigEmoticon(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 99999);
  }
  
  public static List<EmotionPanelInfo> sortEmoticonTabs(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, List<String> paramList1, List<String> paramList2, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList1 == null) {
      return localArrayList;
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      Object localObject = (String)paramList1.next();
      if ((paramList2 == null) || (paramList2.contains(localObject))) {
        if ("sysface".equals(localObject))
        {
          localArrayList.add(new EmotionPanelInfo(7, 7, null));
        }
        else if ("favorite".equals(localObject))
        {
          if ((paramInt == 0) && (paramQQEmoticonMainPanelApp.getQQAppInterface() != null)) {
            localArrayList.add(new EmotionPanelInfo(4, 4, null));
          }
        }
        else if ("hotpic".equals(localObject))
        {
          if ((paramInt == 0) && (paramQQEmoticonMainPanelApp.getQQAppInterface() != null)) {
            localArrayList.add(new EmotionPanelInfo(12, 4, null));
          }
        }
        else if ("camera".equals(localObject))
        {
          localObject = (CameraEmoRoamingManagerProxy)paramQQEmoticonMainPanelApp.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER);
          if ((localObject != null) && (((CameraEmoRoamingManagerProxy)localObject).isShowCameraEmoInApp()) && (paramQQEmoticonMainPanelApp.getQQAppInterface() != null)) {
            localArrayList.add(new EmotionPanelInfo(11, 4, null));
          }
        }
        else if ("recommend".equals(localObject))
        {
          localObject = ((EmoticonManagerProxy)paramQQEmoticonMainPanelApp.getManager(QQManagerFactory.EMOTICON_MANAGER)).getProEmoticonPkgs(false, paramInt, paramBoolean);
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            localArrayList.add(new EmotionPanelInfo(8, 3, null));
          }
        }
        else
        {
          localObject = EmotionPanelManager.a().a((String)localObject);
          if (localObject != null) {
            localArrayList.add(new EmotionPanelInfo(((EmotionInjectionInfo)localObject).a, ((EmotionInjectionInfo)localObject).b, null));
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static byte[] toByte(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonUtils
 * JD-Core Version:    0.7.0.1
 */