package com.tencent.mobileqq.core.util;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonReportUtil;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class EmoticonPanelUtils
{
  public static String a(MessageForPic paramMessageForPic)
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
      if ((!localPicMessageExtraData.isDoutu()) && (!localPicMessageExtraData.isDiyDouTu()))
      {
        if (localPicMessageExtraData.isZhitu()) {
          return "8";
        }
        if ((!localPicMessageExtraData.isStickerPics()) && (!localPicMessageExtraData.isStickerAdPic()))
        {
          if (localPicMessageExtraData.isRelatedEmo()) {
            return "10";
          }
          if (paramMessageForPic.checkGif()) {
            return "9";
          }
        }
        else
        {
          return "5";
        }
      }
      else
      {
        return "7";
      }
    }
    else if (paramMessageForPic.checkGif())
    {
      return "9";
    }
    return "";
  }
  
  public static void a(EmoticonSpan[] paramArrayOfEmoticonSpan, float paramFloat1, float paramFloat2, boolean paramBoolean1, int paramInt1, int paramInt2, AppInterface paramAppInterface, Parcelable paramParcelable, Activity paramActivity, boolean paramBoolean2)
  {
    ((IEmosmService)QRoute.api(IEmosmService.class)).clickSmallEmoticon(paramArrayOfEmoticonSpan, paramFloat1, paramFloat2, paramBoolean1, paramInt1, paramInt2, paramAppInterface, paramParcelable, paramActivity, paramBoolean2);
  }
  
  public static boolean a()
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 3)
      {
        if (i == 4) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 2) && ((paramInt2 & 0x1) == 1);
  }
  
  public static boolean a(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage != null) && (paramEmoticonPackage.status == 2) && ((paramEmoticonPackage.updateFlag & 0x1) == 1);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if ((paramMessageRecord.picExtraData != null) && (paramMessageRecord.picExtraData.isCustomFace())) {
        return true;
      }
    }
    return false;
  }
  
  public static byte[] a(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      arrayOfByte[i] = Integer.valueOf(paramString.substring(k, k + 2), 16).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public static String b(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      return "";
    }
    if (paramMessageForPic.isSend()) {
      return "";
    }
    int i = paramMessageForPic.istroop;
    if (paramMessageForPic.rawMsgUrl != null)
    {
      paramMessageForPic = paramMessageForPic.rawMsgUrl;
    }
    else if (paramMessageForPic.bigMsgUrl != null)
    {
      paramMessageForPic = paramMessageForPic.bigMsgUrl;
    }
    else
    {
      if (paramMessageForPic.thumbMsgUrl == null) {
        break label131;
      }
      paramMessageForPic = paramMessageForPic.thumbMsgUrl;
    }
    if ((i != 1) && (i != 3000))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://c2cpicdw.qpic.cn");
      localStringBuilder.append(paramMessageForPic);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://gchat.qpic.cn");
    localStringBuilder.append(paramMessageForPic);
    return localStringBuilder.toString();
    label131:
    return "";
  }
  
  public static boolean b()
  {
    return NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 1;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if ((paramMessageRecord.picExtraData != null) && (paramMessageRecord.picExtraData.isSelfieFace())) {
        return true;
      }
    }
    return false;
  }
  
  public static String c(String paramString)
  {
    int i = b(paramString);
    if (i == -1) {
      return null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("https://i.gtimg.cn/club/item/parcel/");
    localStringBuilder2.append(i % 10);
    localStringBuilder2.append("/");
    localStringBuilder2.append(paramString);
    localStringBuilder2.append("_android.json");
    localStringBuilder1.append(localStringBuilder2.toString());
    return EmosmUtils.a("VIP_emosm", localStringBuilder1.toString());
  }
  
  public static boolean c()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int i = NetworkUtil.getSystemNetwork(localBaseApplication);
    boolean bool = SettingCloneUtil.readValue(localBaseApplication, null, localBaseApplication.getString(2131897788), "qqsetting_auto_receive_magic_face_key", true);
    return ((i == 3) || (i == 4)) && (!bool);
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 3000)
        {
          bool1 = bool2;
          if (paramInt != 99999)
          {
            if (paramInt == 10014) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public static IEmoticonManagerService d()
  {
    try
    {
      Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject != null)
      {
        localObject = (IEmoticonManagerService)((AppInterface)localObject).getRuntimeService(IEmoticonManagerService.class, "");
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static boolean d(int paramInt)
  {
    boolean bool = false;
    if (paramInt != -1)
    {
      paramInt = Integer.valueOf(EmoticonReportUtil.getAioMoreFlag(paramInt)).intValue();
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
        return false;
      }
      bool = true;
    }
    return bool;
  }
  
  public static int e(int paramInt)
  {
    int i = 3;
    if (paramInt != -1)
    {
      int j = Integer.valueOf(EmoticonReportUtil.getAioMoreFlag(paramInt)).intValue();
      if (j != 0)
      {
        paramInt = i;
        if (j == 1) {
          return paramInt;
        }
        if (j != 2)
        {
          if (j == 3) {
            return 1;
          }
        }
        else {
          return 4;
        }
      }
      else
      {
        return 2;
      }
    }
    paramInt = 0;
    return paramInt;
  }
  
  public static int f(int paramInt)
  {
    int i = 3;
    if (paramInt != -1)
    {
      int j = Integer.valueOf(EmoticonReportUtil.getAioMoreFlag(paramInt)).intValue();
      if (j != 0)
      {
        paramInt = i;
        if (j == 2) {
          return paramInt;
        }
        if (j == 3) {
          return 2;
        }
      }
      else
      {
        return 1;
      }
    }
    paramInt = 4;
    return paramInt;
  }
  
  public static String g(int paramInt)
  {
    if (paramInt == 11000) {
      return "qzone";
    }
    paramInt = Integer.valueOf(EmoticonReportUtil.getAioMoreFlag(paramInt)).intValue();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "other";
          }
          return "group";
        }
        return "discuss";
      }
      return "temp";
    }
    return "c2c";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.core.util.EmoticonPanelUtils
 * JD-Core Version:    0.7.0.1
 */