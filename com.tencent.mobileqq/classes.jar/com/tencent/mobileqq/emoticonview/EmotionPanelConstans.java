package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EmotionPanelConstans
  extends EmoticonViewBinder
{
  public static final int COLUMNNUM_CAMERA_EMO = 4;
  public static final int COLUMNNUM_CMSHOW = 4;
  public static final int COLUMNNUM_FAVORITE = 4;
  public static final int COLUMNNUM_HOTPIC_SEARCH = 4;
  public static final int COLUMNNUM_MAGIC_FACE = 4;
  public static final int COLUMNNUM_RECOMMENT = 3;
  public static final int COLUMNNUM_SMALL_EMOTION = 7;
  public static final int COLUMNUM_BIG_EMOTION = 4;
  public static String H5MagicFileListPath;
  public static String H5MagicIndexHtmlPath;
  public static String H5MagicRootPath;
  public static String H5MagicZipPath;
  public static final int PANEL_TYPE_BIG_EMOTION_COMPLETE_INVALID = 10;
  public static final int PANEL_TYPE_BIG_EMOTION_DOWNLOADED = 6;
  public static final int PANEL_TYPE_BIG_EMOTION_NEED_UPDATE = 8;
  public static final int PANEL_TYPE_CAMERA_EMOTION = 13;
  public static final int PANEL_TYPE_CMSHOW_EMOTION = 15;
  public static final int PANEL_TYPE_EMOTION_COMPLETE_INVALID = 12;
  public static final int PANEL_TYPE_EMOTION_NEED_DOWNLOAD_OR_INVALID = 7;
  public static final int PANEL_TYPE_FAVORITE = 4;
  public static final int PANEL_TYPE_HOTPIC_SEARCH_EMOTION = 14;
  public static final int PANEL_TYPE_MAGIC_FACE = 5;
  public static final int PANEL_TYPE_RECOMMEND = 3;
  public static final int PANEL_TYPE_SMALL_EMOTION_COMPLETE_INVALID = 11;
  public static final int PANEL_TYPE_SMALL_EMOTION_DOWNLOADED = 2;
  public static final int PANEL_TYPE_SMALL_EMOTION_NEED_UPDATE = 9;
  public static final int PANEL_TYPE_SYSTEM_AND_EMOJI = 1;
  public static final int PANEL_TYPE_TKD_COMMENT_END = 1100;
  public static final int PANEL_TYPE_TKD_COMMENT_START = 1000;
  public static final String RELATED_EMO_C2C_HTTP_PREFIX = "http://c2cpicdw.qpic.cn";
  public static final String RELATED_EMO_GROUP_HTTP_PREFIX = "http://gchat.qpic.cn";
  public static final String TAG = "EmotionPanelConstans";
  public static final int TYPE_CAMERA_EMOTICON = 11;
  public static final int TYPE_CMSHOW = 15;
  public static final int TYPE_HOTPIC_SEARCH_EMOTICON = 12;
  public static final int TYPE_MAGIC_FACE = 9;
  public static final int TYPE_PLUS_BUTTON = 13;
  public static final int TYPE_RECOMMEND = 8;
  public static final int TYPE_SETTING_BUTTON = 14;
  public static final int TYPE_SMALL_EMOTICON = 10;
  public static final int TYPE_TKD_COMMENT_END = 1100;
  public static final int TYPE_TKD_COMMENT_START = 1000;
  public static String emoticonAIOPreviewExtensionUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]x[height].png";
  public static String emoticonAIOPreviewPath;
  public static String emoticonAPNGPath;
  public static String emoticonEncryptExtensionApngUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]_apng";
  public static String emoticonEncryptExtensionUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]";
  public static String emoticonEncryptPath;
  public static String emoticonJsonFilePath;
  public static String emoticonPNGZIPUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/pngframe.zip";
  public static String emoticonPackageFolderPath;
  public static String emoticonPreviewPath;
  public static String emoticonPreviewUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/126x126.png";
  public static String emoticonRecommendUrl = "https://gxh.vip.qq.com/club/item/parcel/img/parcel/[mod]/[epId]/200x200.png";
  public static String emoticonSoundPath;
  public static String emoticonSoundUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/ring.amr";
  public static String giftBigAnimationPath;
  public static String magicFaceZipPath;
  public static String pngFramePath;
  public static String smallApngUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId]_apng.png";
  public static String smallEmoticonJsonUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/xydata.json";
  public static String smallEmoticonThumbUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].png";
  public static String smallGifUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].gif";
  public static String smallRecommendUrl = "https://gxh.vip.qq.com/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/200x200.png";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_GIFT_SAVE);
    localStringBuilder.append("[epId]");
    localStringBuilder.append(File.separator);
    giftBigAnimationPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_EMOTICON_SAVE);
    localStringBuilder.append("[epId]");
    localStringBuilder.append(File.separator);
    emoticonPackageFolderPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(emoticonPackageFolderPath);
    localStringBuilder.append("pngframe/");
    pngFramePath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(emoticonPackageFolderPath);
    localStringBuilder.append("[epId].zip");
    magicFaceZipPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(emoticonPackageFolderPath);
    localStringBuilder.append("h5magic");
    localStringBuilder.append(File.separator);
    H5MagicRootPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(H5MagicRootPath);
    localStringBuilder.append("fileList");
    H5MagicFileListPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(H5MagicRootPath);
    localStringBuilder.append("index.html");
    H5MagicIndexHtmlPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(emoticonPackageFolderPath);
    localStringBuilder.append("h5_json.zip");
    H5MagicZipPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(emoticonPackageFolderPath);
    localStringBuilder.append("[eId]_apng");
    emoticonAPNGPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(emoticonPackageFolderPath);
    localStringBuilder.append("[eId]");
    emoticonEncryptPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(emoticonPackageFolderPath);
    localStringBuilder.append("[epId].jtmp");
    emoticonJsonFilePath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(emoticonPackageFolderPath);
    localStringBuilder.append("[eId]_aio.png");
    emoticonAIOPreviewPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(emoticonPackageFolderPath);
    localStringBuilder.append("[eId]_thu.png");
    emoticonPreviewPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(emoticonPackageFolderPath);
    localStringBuilder.append("[eId].amr");
    emoticonSoundPath = localStringBuilder.toString();
  }
  
  public EmotionPanelConstans(int paramInt)
  {
    super(paramInt);
  }
  
  private static int getEmotionPanelType(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, EmotionPanelInfo paramEmotionPanelInfo, boolean paramBoolean)
  {
    if ((paramIEmoticonMainPanelApp != null) && (paramEmotionPanelInfo != null))
    {
      EmoticonPackage localEmoticonPackage = paramEmotionPanelInfo.emotionPkg;
      if (localEmoticonPackage == null)
      {
        paramIEmoticonMainPanelApp = new StringBuilder();
        paramIEmoticonMainPanelApp.append("getEmotionPanelType emotionPkg is null; type = ");
        paramIEmoticonMainPanelApp.append(paramEmotionPanelInfo.type);
        QLog.e("EmotionPanelConstans", 1, paramIEmoticonMainPanelApp.toString());
        return -1;
      }
      boolean bool = ((IVasEmojiManagerService)QRoute.api(IVasEmojiManagerService.class)).emoticonPkgNeedUpdate(localEmoticonPackage.status, localEmoticonPackage.updateFlag);
      int i = localEmoticonPackage.status;
      if (QLog.isColorLevel())
      {
        paramEmotionPanelInfo = new StringBuilder();
        paramEmotionPanelInfo.append("getEmotionPanelType epid = ");
        paramEmotionPanelInfo.append(localEmoticonPackage.epId);
        paramEmotionPanelInfo.append("status = ");
        paramEmotionPanelInfo.append(i);
        paramEmotionPanelInfo.append(";shouldUpdate = ");
        paramEmotionPanelInfo.append(bool);
        QLog.d("EmotionPanelConstans", 2, paramEmotionPanelInfo.toString());
      }
      if ((localEmoticonPackage.valid) && (i != 3) && (isAuthorized(paramIEmoticonMainPanelApp, localEmoticonPackage)))
      {
        if (bool)
        {
          if (paramBoolean) {
            return 9;
          }
          return 8;
        }
        if (i != 2) {
          return 7;
        }
        if (paramBoolean) {
          return 2;
        }
        return 6;
      }
      if (i == 2) {
        return 12;
      }
      return 7;
    }
    QLog.e("EmotionPanelConstans", 1, "getEmotionPanelType app or panelinfo is null");
    return -1;
  }
  
  public static int getPanelType(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {
      return -1;
    }
    int j = paramEmotionPanelInfo.type;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPanelType type = ");
      localStringBuilder.append(j);
      QLog.d("EmotionPanelConstans", 2, localStringBuilder.toString());
    }
    int i = 4;
    if (j != 4)
    {
      i = 15;
      if (j != 15)
      {
        switch (j)
        {
        default: 
          if ((j >= 1000) && (j <= 1100)) {
            return j;
          }
          return -1;
        case 12: 
          return 14;
        case 11: 
          return 13;
        case 10: 
          return getEmotionPanelType(paramIEmoticonMainPanelApp, paramEmotionPanelInfo, true);
        case 9: 
          return 5;
        case 8: 
          return 3;
        case 7: 
          return 1;
        }
        return getEmotionPanelType(paramIEmoticonMainPanelApp, paramEmotionPanelInfo, false);
      }
    }
    return i;
  }
  
  public static boolean isAuthorized(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramIEmoticonMainPanelApp != null)) {
      return ((IVasEmojiManagerService)QRoute.api(IVasEmojiManagerService.class)).isAuthorized(paramIEmoticonMainPanelApp, paramEmoticonPackage.mobileFeetype);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelConstans
 * JD-Core Version:    0.7.0.1
 */