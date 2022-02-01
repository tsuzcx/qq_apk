package com.tencent.mobileqq.pic.api.impl;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicBaseInfo;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.MobileQQ;

public class PicHelperImpl
  implements IPicHelper
{
  public static boolean hasBigFile(MessageForPic paramMessageForPic)
  {
    return hasFile(paramMessageForPic, "chatimg");
  }
  
  public static boolean hasFile(MessageForPic paramMessageForPic, String paramString)
  {
    if (paramMessageForPic.isSendFromLocal())
    {
      paramMessageForPic = paramMessageForPic.getPicUploadInfo();
      paramMessageForPic.e = paramString;
      return paramMessageForPic.b();
    }
    paramMessageForPic = paramMessageForPic.getPicDownloadInfo();
    paramMessageForPic.e = paramString;
    return paramMessageForPic.b();
  }
  
  public static boolean hasRawFile(MessageForPic paramMessageForPic)
  {
    return hasFile(paramMessageForPic, "chatraw");
  }
  
  public static boolean hasThumbFile(MessageForPic paramMessageForPic)
  {
    return hasFile(paramMessageForPic, "chatthumb");
  }
  
  public void cachePicToDisk(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.md5 == null) {
      return;
    }
    int j = paramMessageForPic.fileSizeFlag;
    int i = 1;
    if (j == 1) {
      i = 131075;
    }
    String str = null;
    URL localURL = getURL(paramMessageForPic.md5, i);
    if (localURL != null) {
      str = localURL.toString();
    }
    if (!AbsDownloader.hasFile(str))
    {
      str = AbsDownloader.getFilePath(str);
      FileUtils.copyFile(paramMessageForPic.path, str);
    }
  }
  
  public String getBiggestFilePath(MessageForPic paramMessageForPic)
  {
    if (hasRawFile(paramMessageForPic)) {
      return paramMessageForPic.getFilePath("chatraw");
    }
    if (hasBigFile(paramMessageForPic)) {
      return paramMessageForPic.getFilePath("chatimg");
    }
    if (hasThumbFile(paramMessageForPic)) {
      return paramMessageForPic.getFilePath("chatthumb");
    }
    return null;
  }
  
  public URLDrawable getDrawable(PicUiInterface paramPicUiInterface, int paramInt, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramPicUiInterface == null) {
      return null;
    }
    paramString = URLDrawable.getDrawable(getURL(paramPicUiInterface, paramInt, paramString), paramURLDrawableOptions);
    paramString.setTag(paramPicUiInterface);
    if (paramPicUiInterface.isSendFromLocal()) {
      return paramString;
    }
    boolean bool1 = PicContants.a;
    boolean bool2 = true;
    if (bool1)
    {
      paramString.setAutoDownload(true);
      return paramString;
    }
    boolean bool3 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694986), "qqsetting_auto_receive_pic_key", true);
    bool1 = bool2;
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {
      if (bool3) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    paramString.setAutoDownload(bool1);
    return paramString;
  }
  
  public int getFileSizeType(String paramString, boolean paramBoolean)
  {
    if ("chatthumb".equals(paramString)) {}
    do
    {
      return 65537;
      if ("chatimg".equals(paramString))
      {
        if (!paramBoolean) {
          break;
        }
        return 1;
      }
    } while (!"chatraw".equals(paramString));
    return 131075;
  }
  
  String getHost(PicBaseInfo paramPicBaseInfo)
  {
    if (paramPicBaseInfo == null) {
      return null;
    }
    int i = paramPicBaseInfo.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i == 1000) || (i == 1001) || (i == 1008) || (i == 1009) || (i == 1020)) {
          break label132;
        }
        if (i != 3000) {
          if ((i == 10002) || (i == 10004) || (i == 10008) || (i == 1023) || (i == 1024)) {
            break label132;
          }
        }
      }
      switch (i)
      {
      default: 
        return null;
        return "Disscussion";
        return "Troup";
      }
    }
    label132:
    return "C2C";
  }
  
  public String getMsgSummaryForAnimationPic(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      return null;
    }
    if (paramMessageForPic.picExtraData != null)
    {
      String str = paramMessageForPic.picExtraData.textSummary;
      if (!TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel())
        {
          paramMessageForPic = new StringBuilder();
          paramMessageForPic.append("textSummary: ");
          paramMessageForPic.append(MessageRecordUtil.a(str));
          QLog.d("msgSummary", 2, paramMessageForPic.toString());
        }
        return str;
      }
    }
    if ((paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isEmotion())) {
      return MobileQQ.getContext().getString(2131691279);
    }
    if (paramMessageForPic.checkGif()) {
      return MobileQQ.getContext().getString(2131691279);
    }
    return null;
  }
  
  String getProtocol(PicBaseInfo paramPicBaseInfo, int paramInt)
  {
    String str = null;
    if (paramInt == 65537) {
      str = "chatthumb";
    } else if (paramInt == 1) {
      str = "chatimg";
    } else if (paramInt == 131075) {
      str = "chatraw";
    }
    if (paramPicBaseInfo.jdField_b_of_type_Int != 8000) {
      return str;
    }
    return "favimage";
  }
  
  public URL getURL(PicDownloadInfo paramPicDownloadInfo, int paramInt, String paramString)
  {
    if (paramPicDownloadInfo == null) {
      return null;
    }
    Object localObject1 = paramPicDownloadInfo.f;
    if ((localObject1 == null) || ("null".equals(localObject1)) || ("".equals(localObject1))) {
      if ((paramPicDownloadInfo.jdField_b_of_type_Int == 8000) && (paramInt == 65537)) {
        localObject1 = paramPicDownloadInfo.h;
      } else {
        localObject1 = paramPicDownloadInfo.g;
      }
    }
    if (paramPicDownloadInfo.jdField_b_of_type_Boolean) {
      paramInt = 1;
    }
    if (paramString == null) {
      paramString = getProtocol(paramPicDownloadInfo, paramInt);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("holyshit_");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getURL file == null");
        ((StringBuilder)localObject2).append(paramPicDownloadInfo.toString());
        QLog.e("PicBaseInfo", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
      if (paramString == null) {
        break label222;
      }
      paramPicDownloadInfo = new URL(paramString, null, (String)localObject2);
      return paramPicDownloadInfo;
    }
    catch (MalformedURLException paramPicDownloadInfo)
    {
      label211:
      label222:
      break label211;
    }
    QLog.e("PicBaseInfo", 1, "getURL error ", paramPicDownloadInfo);
    return null;
  }
  
  public URL getURL(PicUiInterface paramPicUiInterface, int paramInt, String paramString)
  {
    if (paramPicUiInterface == null) {
      return null;
    }
    if (paramPicUiInterface.isSendFromLocal()) {
      return getURL(paramPicUiInterface.getPicUploadInfo(), paramInt, paramString);
    }
    return getURL(paramPicUiInterface.getPicDownloadInfo(), paramInt, paramString);
  }
  
  public URL getURL(PicUploadInfo paramPicUploadInfo, int paramInt, String paramString)
  {
    if (paramPicUploadInfo == null) {
      return null;
    }
    String str2;
    if (paramPicUploadInfo.d < 4) {
      str2 = getHost(paramPicUploadInfo);
    } else {
      str2 = null;
    }
    String str3 = getProtocol(paramPicUploadInfo, paramInt);
    String str1;
    if ((paramPicUploadInfo.jdField_b_of_type_Int == 8000) && (paramInt == 65537)) {
      str1 = paramPicUploadInfo.h;
    } else if ((paramPicUploadInfo.f != null) && (!"".equals(paramPicUploadInfo.f))) {
      str1 = paramPicUploadInfo.f;
    } else if ((paramPicUploadInfo.a != null) && (!"".equals(paramPicUploadInfo.a))) {
      str1 = paramPicUploadInfo.a;
    } else if ((paramPicUploadInfo.g != null) && (!"".equals(paramPicUploadInfo.g))) {
      str1 = paramPicUploadInfo.g;
    } else {
      str1 = "";
    }
    if (str1 != null) {}
    try
    {
      if (("".equals(str1)) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getURL file == null");
        localStringBuilder.append(paramPicUploadInfo.toString());
        QLog.e("PicBaseInfo", 2, localStringBuilder.toString());
      }
      if (paramString != null) {
        return new URL(paramString, str2, str1);
      }
      if (str3 != null)
      {
        paramPicUploadInfo = new URL(str3, str2, str1);
        return paramPicUploadInfo;
      }
    }
    catch (MalformedURLException paramPicUploadInfo)
    {
      paramPicUploadInfo.printStackTrace();
    }
    return null;
  }
  
  public URL getURL(String paramString, int paramInt)
  {
    String str = "chatimg";
    if (paramInt == 65537) {
      str = "chatthumb";
    } else if ((paramInt != 1) && (paramInt == 131075)) {
      str = "chatraw";
    }
    try
    {
      paramString = new URL(str, null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public boolean isEmotion(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.checkGif()) {
      return true;
    }
    if (paramMessageForPic.picExtraData != null) {
      return paramMessageForPic.picExtraData.isEmotion();
    }
    return false;
  }
  
  public void parseDbMsgOldVersion(MessageForPic paramMessageForPic, String paramString)
  {
    TranDbRecord.PicDbRecord localPicDbRecord = new TranDbRecord.PicDbRecord();
    localPicDbRecord.initFromMsg(paramString);
    paramMessageForPic.path = localPicDbRecord.path;
    paramMessageForPic.size = localPicDbRecord.size;
    paramMessageForPic.type = localPicDbRecord.type;
    paramMessageForPic.isRead = localPicDbRecord.isRead;
    paramMessageForPic.uuid = localPicDbRecord.uuid;
    paramMessageForPic.md5 = localPicDbRecord.md5;
    paramMessageForPic.serverStoreSource = localPicDbRecord.serverStoreSource;
    paramMessageForPic.thumbMsgUrl = localPicDbRecord.thumbMsgUrl;
    paramMessageForPic.bigThumbMsgUrl = localPicDbRecord.bigThumbMsgUrl;
    paramMessageForPic.bigMsgUrl = localPicDbRecord.bigMsgUrl;
    paramMessageForPic.rawMsgUrl = localPicDbRecord.rawMsgUrl;
    paramMessageForPic.picExtraFlag = localPicDbRecord.extraFlag;
    paramMessageForPic.picExtraObject = localPicDbRecord.extraObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.PicHelperImpl
 * JD-Core Version:    0.7.0.1
 */