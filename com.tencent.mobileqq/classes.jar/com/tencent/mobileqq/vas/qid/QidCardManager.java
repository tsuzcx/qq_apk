package com.tencent.mobileqq.vas.qid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gxh_message.Dialogue;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;

public class QidCardManager
{
  private static String a;
  private static String b = "sp_vip_qid_info";
  private static String c = "last_qid_bg";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("qid/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      Dialogue localDialogue = new Dialogue();
      localDialogue.mergeFrom(paramString.getBytes());
      if (localDialogue.short_nameplate_itemid.has())
      {
        int i = localDialogue.short_nameplate_itemid.get();
        return i;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private static DownloaderInterface a()
  {
    return ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).getDownloader(VasUtil.a());
  }
  
  public static File a(String paramString)
  {
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString;
    }
    return null;
  }
  
  public static String a()
  {
    Card localCard = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).findAndCreateCardByUin(VasUtil.a());
    if (localCard != null)
    {
      if (localCard.shGender == 1) {
        return "https://cmshowar-1251316161.cos.ap-guangzhou.myqcloud.com//qqshow/0/2d/body/100.png";
      }
      return "https://cmshowar-1251316161.cos.ap-guangzhou.myqcloud.com//qqshow/1/2d/body/100.png";
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(MD5Utils.toMD5(paramString));
    localStringBuilder.append(".pag");
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity, QidPagView paramQidPagView, QidPagView.QidData paramQidData)
  {
    if ((paramQidData != null) && (!TextUtils.isEmpty(paramQidData.a)) && (!TextUtils.isEmpty(paramQidData.b)))
    {
      DownloadTask localDownloadTask = new DownloadTask(paramQidData.a, new File(paramQidData.b));
      a().startDownload(localDownloadTask, new QidCardManager.1(paramActivity, paramQidPagView, paramQidData), null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QidCardManager", 2, "QID_QR,download,params error");
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Activity paramActivity, int paramInt)
  {
    Intent localIntent = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).getQQBrowserIntent();
    localIntent.putExtra("url", QVipQidProcessor.c().b);
    localIntent.putExtra("hide_more_button", true);
    if (paramAppRuntime == null) {
      paramAppRuntime = "";
    } else {
      paramAppRuntime = paramAppRuntime.getCurrentAccountUin();
    }
    localIntent.putExtra("uin", paramAppRuntime);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    if (paramActivity != null) {
      paramActivity.startActivityForResult(localIntent, paramInt);
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = MobileQQ.getContext().getSharedPreferences(b, 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(paramString1);
    localEditor.putString(localStringBuilder.toString(), paramString2);
    return localEditor.commit();
  }
  
  public static String b(String paramString)
  {
    paramString = d(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return String.format("https://cmshowar-1251316161.cos.ap-guangzhou.myqcloud.com/qqshow/%s/2d/body/640.png", new Object[] { paramString });
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences(b, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(paramString);
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  private static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.getBytes();
    byte[] arrayOfByte = new byte[4];
    byte[] tmp21_19 = arrayOfByte;
    tmp21_19[0] = 50;
    byte[] tmp27_21 = tmp21_19;
    tmp27_21[1] = 48;
    byte[] tmp33_27 = tmp27_21;
    tmp33_27[2] = 50;
    byte[] tmp39_33 = tmp33_27;
    tmp39_33[3] = 48;
    tmp39_33;
    ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(1024);
    int j = 0;
    int i = 0;
    while ((j < paramString.length) && (j < arrayOfByte.length))
    {
      localByteArrayBuffer.append(paramString[j] ^ 0xA5);
      localByteArrayBuffer.append(arrayOfByte[j] ^ 0xA5);
      i += 1;
      j += 1;
    }
    j = i;
    int k;
    for (;;)
    {
      k = i;
      if (j >= paramString.length) {
        break;
      }
      localByteArrayBuffer.append(paramString[j] ^ 0xA5);
      j += 1;
    }
    while (k < arrayOfByte.length)
    {
      localByteArrayBuffer.append(arrayOfByte[k] ^ 0xA5);
      k += 1;
    }
    return HexUtil.bytes2HexStr(localByteArrayBuffer.toByteArray()).toLowerCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidCardManager
 * JD-Core Version:    0.7.0.1
 */