package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

public abstract interface CommonEmoticonConstans
{
  public static final String BUSINESS_CAMERA_EMO_PANEL_DYNAMIC = "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC";
  public static final String BUSINESS_CAMERA_EMO_PANEL_THUMB = "BUSINESS_CAMERA_EMO_PANEL_THUMB";
  public static final String BUSINESS_FAVORITE_PANEL_DYNAMIC = "FAVOROTE_PANEL_DYNAMIC";
  public static final String BUSINESS_FAVORITE_PANEL_THUMB = "FAVORITE_PANEL_THUMB";
  public static final String BUSINESS_FAVORITE_PANEL_THUMB_NEW = "FAVORITE_PANEL_THUMB_NEW";
  public static final int BUSINESS_ID_ALL = -1;
  public static final String H5MagicFileListPath = H5MagicRootPath + "fileList";
  public static final String H5MagicIndexHtmlPath;
  public static final String H5MagicRootPath;
  public static final String H5MagicZipPath;
  public static final String emoticonAIOPreviewPath;
  public static final String emoticonAPNGPath;
  public static final String emoticonEncryptPath;
  public static final String emoticonJsonFilePath;
  public static final String emoticonPackageFolderPath;
  public static final String emoticonPreviewPath;
  public static final String emoticonSoundPath;
  public static final String giftBigAnimationPath = AppConstants.SDCARD_GIFT_SAVE + "[epId]" + File.separator;
  public static final String magicFaceZipPath = emoticonPackageFolderPath + "[epId].zip";
  public static final String pngFramePath = emoticonPackageFolderPath + "pngframe/";
  
  static
  {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CommonEmoticonConstans
 * JD-Core Version:    0.7.0.1
 */