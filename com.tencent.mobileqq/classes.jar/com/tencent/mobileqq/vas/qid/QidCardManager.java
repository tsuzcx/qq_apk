package com.tencent.mobileqq.vas.qid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import gxh_message.Dialogue;
import java.io.File;
import mqq.app.AppRuntime;
import org.apache.http.util.ByteArrayBuffer;

public class QidCardManager
{
  private static String a = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "qid/");
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 0;
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
    }
    return 0;
  }
  
  private static DownloaderInterface a()
  {
    return ((DownloaderFactory)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public static File a(String paramString)
  {
    paramString = new File(a(paramString));
    if (paramString.exists()) {
      return paramString;
    }
    return null;
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = ((FriendsManager)((AppRuntime)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((AppRuntime)localObject).getCurrentAccountUin());
      if (localObject != null)
      {
        if (((Card)localObject).shGender == 1) {
          return "https://cmshowar-1251316161.cos.ap-guangzhou.myqcloud.com//qqshow/0/2d/body/100.png";
        }
        return "https://cmshowar-1251316161.cos.ap-guangzhou.myqcloud.com//qqshow/1/2d/body/100.png";
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a + MD5Utils.toMD5(paramString) + ".pag";
  }
  
  public static void a(Activity paramActivity, QidPagView paramQidPagView, QidPagView.QidData paramQidData)
  {
    if ((paramQidData == null) || (TextUtils.isEmpty(paramQidData.a)) || (TextUtils.isEmpty(paramQidData.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidCardManager", 2, "QID_QR,download,params error:" + paramQidData.a);
      }
      return;
    }
    DownloadTask localDownloadTask = new DownloadTask(paramQidData.a, new File(paramQidData.b));
    a().a(localDownloadTask, new QidCardManager.1(paramActivity, paramQidPagView, paramQidData), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), QQBrowserActivity.class);
    localIntent.putExtra("url", QVipQidProcessor.c().b);
    localIntent.putExtra("hide_more_button", true);
    if (paramQQAppInterface == null) {}
    for (paramQQAppInterface = "";; paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin())
    {
      localIntent.putExtra("uin", paramQQAppInterface);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      if (paramActivity != null) {
        paramActivity.startActivityForResult(localIntent, paramInt);
      }
      return;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null) {
      return false;
    }
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("sp_vip_qid_info", 0).edit();
    ((SharedPreferences.Editor)localObject).putString("last_qid_bg" + paramString1, paramString2);
    return ((SharedPreferences.Editor)localObject).commit();
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
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl == null) {
      return null;
    }
    return localBaseApplicationImpl.getSharedPreferences("sp_vip_qid_info", 0).getString("last_qid_bg" + paramString, "");
  }
  
  private static String d(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.getBytes();
    byte[] arrayOfByte = new byte[4];
    byte[] tmp23_21 = arrayOfByte;
    tmp23_21[0] = 50;
    byte[] tmp29_23 = tmp23_21;
    tmp29_23[1] = 48;
    byte[] tmp35_29 = tmp29_23;
    tmp35_29[2] = 50;
    byte[] tmp41_35 = tmp35_29;
    tmp41_35[3] = 48;
    tmp41_35;
    ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(1024);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidCardManager
 * JD-Core Version:    0.7.0.1
 */