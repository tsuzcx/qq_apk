package com.tencent.mobileqq.emosm.vipcomic;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.mqqcomic.MqqComicHeadPb.ComicReqHead;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.TicketManager;

public class VipComicMqqHandlerConstants
{
  public static int a = 100;
  public static String a = "1000290";
  
  public static MqqComicHeadPb.ComicReqHead a(AppInterface paramAppInterface, String paramString1, long paramLong, String paramString2)
  {
    MqqComicHeadPb.ComicReqHead localComicReqHead = new MqqComicHeadPb.ComicReqHead();
    localComicReqHead.src.set(1);
    long l2 = 0L;
    long l1 = paramLong;
    if (paramLong == 0L) {
      l1 = NetConnInfoCenter.getServerTime();
    }
    localComicReqHead.optTs.set(l1);
    localComicReqHead.os.set(2);
    PBStringField localPBStringField = localComicReqHead.clientVer;
    String str = "8.7.0";
    if (TextUtils.isEmpty("8.7.0")) {
      str = "";
    }
    localPBStringField.set(str);
    localComicReqHead.net.set(HttpUtil.getNetWorkType());
    paramLong = l2;
    if (paramAppInterface.getCurrentAccountUin() != null) {
      paramLong = Long.valueOf(paramAppInterface.getCurrentAccountUin()).longValue();
    }
    localComicReqHead.uin.set(paramLong);
    str = b(paramAppInterface);
    if (!TextUtils.isEmpty(str)) {
      localComicReqHead.screenQuality.set(str);
    }
    localComicReqHead.cmd.set(paramString1);
    paramAppInterface = a(paramAppInterface);
    if (!TextUtils.isEmpty(paramAppInterface)) {
      localComicReqHead.skey.set(paramAppInterface);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localComicReqHead.etag.set(paramString2);
    }
    paramAppInterface = ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).getQimei();
    if (!TextUtils.isEmpty(paramAppInterface)) {
      localComicReqHead.unifiedImei.set(paramAppInterface);
    }
    return localComicReqHead;
  }
  
  private static String a(AppInterface paramAppInterface)
  {
    TicketManager localTicketManager = (TicketManager)paramAppInterface.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(paramAppInterface.getAccount());
    }
    return "";
  }
  
  public static byte[] a(MqqComicHeadPb.ComicReqHead paramComicReqHead, MessageMicro paramMessageMicro)
  {
    if (paramComicReqHead != null)
    {
      if (paramMessageMicro == null) {
        return null;
      }
      try
      {
        paramComicReqHead = paramComicReqHead.toByteArray();
        int i = paramComicReqHead.length + 4;
        paramMessageMicro = paramMessageMicro.toByteArray();
        int j = paramMessageMicro.length + 4;
        byte[] arrayOfByte = new byte[i + j];
        PkgTools.dWord2Byte(arrayOfByte, 0, i);
        PkgTools.copyData(arrayOfByte, 4, paramComicReqHead, paramComicReqHead.length);
        PkgTools.dWord2Byte(arrayOfByte, i, j);
        PkgTools.copyData(arrayOfByte, i + 4, paramMessageMicro, paramMessageMicro.length);
        return arrayOfByte;
      }
      catch (Exception paramComicReqHead)
      {
        paramComicReqHead.printStackTrace();
      }
    }
    return null;
  }
  
  private static String b(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getResources().getDisplayMetrics();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Math.min(paramAppInterface.widthPixels, paramAppInterface.heightPixels));
    localStringBuilder.append("*");
    localStringBuilder.append(Math.max(paramAppInterface.widthPixels, paramAppInterface.heightPixels));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandlerConstants
 * JD-Core Version:    0.7.0.1
 */