package com.tencent.mobileqq.emosm.vipcomic;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.mqqcomic.MqqComicHeadPb.ComicReqHead;
import com.tencent.pb.mqqcomic.MqqComicHeadPb.ComicRspHead;
import com.tencent.pb.mqqcomic.MqqComicPb.ComicFavorEmotIcons;
import com.tencent.pb.mqqcomic.MqqComicPb.DelMyComicFavorEmotIconsReqBody;
import com.tencent.pb.mqqcomic.MqqComicPb.DelMyComicFavorEmotIconsRspBody;
import com.tencent.pb.mqqcomic.MqqComicPb.GetComicGlobalConfigReqBody;
import com.tencent.pb.mqqcomic.MqqComicPb.GetComicGlobalConfigRspBody;
import com.tencent.pb.mqqcomic.MqqComicPb.GetMyComicFavorEmotIconsReqBody;
import com.tencent.pb.mqqcomic.MqqComicPb.GetMyComicFavorEmotIconsRspBody;
import com.tencent.pb.mqqcomic.MqqComicPb.SetMyComicFavorEmotIconsReqBody;
import com.tencent.pb.mqqcomic.MqqComicPb.SetMyComicFavorEmotIconsRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicHelper;
import cooperation.comic.VipComicReportUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.manager.TicketManager;

public class VipComicMqqHandler
  extends BusinessHandler
{
  public static int a;
  public static String a;
  private QQAppInterface a;
  
  static
  {
    jdField_a_of_type_Int = 100;
    jdField_a_of_type_JavaLangString = "1000290";
  }
  
  public VipComicMqqHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
  
  public static MqqComicHeadPb.ComicReqHead a(AppInterface paramAppInterface, String paramString1, long paramLong, String paramString2)
  {
    MqqComicHeadPb.ComicReqHead localComicReqHead = new MqqComicHeadPb.ComicReqHead();
    localComicReqHead.src.set(1);
    long l = paramLong;
    if (paramLong == 0L) {
      l = NetConnInfoCenter.getServerTime();
    }
    localComicReqHead.optTs.set(l);
    localComicReqHead.os.set(2);
    PBStringField localPBStringField = localComicReqHead.clientVer;
    String str;
    if (TextUtils.isEmpty("8.5.5"))
    {
      str = "";
      localPBStringField.set(str);
      localComicReqHead.net.set(HttpUtil.getNetWorkType());
      if (paramAppInterface.getCurrentAccountUin() == null) {
        break label217;
      }
    }
    label217:
    for (paramLong = Long.valueOf(paramAppInterface.getCurrentAccountUin()).longValue();; paramLong = 0L)
    {
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
      paramAppInterface = VipComicReportUtils.a();
      if (!TextUtils.isEmpty(paramAppInterface)) {
        localComicReqHead.unifiedImei.set(paramAppInterface);
      }
      return localComicReqHead;
      str = "8.5.5";
      break;
    }
  }
  
  private static String a(AppInterface paramAppInterface)
  {
    TicketManager localTicketManager = (TicketManager)paramAppInterface.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(paramAppInterface.getAccount());
    }
    return "";
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqHandler", 2, paramString);
    }
  }
  
  public static byte[] a(MqqComicHeadPb.ComicReqHead paramComicReqHead, MessageMicro paramMessageMicro)
  {
    if ((paramComicReqHead == null) || (paramMessageMicro == null)) {
      return null;
    }
    try
    {
      paramComicReqHead = paramComicReqHead.toByteArray();
      int i = paramComicReqHead.length + 4;
      paramMessageMicro = paramMessageMicro.toByteArray();
      int j = paramMessageMicro.length + 4;
      byte[] arrayOfByte = new byte[i + j];
      PkgTools.DWord2Byte(arrayOfByte, 0, i);
      PkgTools.copyData(arrayOfByte, 4, paramComicReqHead, paramComicReqHead.length);
      PkgTools.DWord2Byte(arrayOfByte, i, j);
      PkgTools.copyData(arrayOfByte, i + 4, paramMessageMicro, paramMessageMicro.length);
      return arrayOfByte;
    }
    catch (Exception paramComicReqHead)
    {
      paramComicReqHead.printStackTrace();
    }
    return null;
  }
  
  private static String b(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getResources().getDisplayMetrics();
    return Math.min(paramAppInterface.widthPixels, paramAppInterface.heightPixels) + "*" + Math.max(paramAppInterface.widthPixels, paramAppInterface.heightPixels);
  }
  
  public void a()
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ComicProtoConvSvr.tunnel");
    localToServiceMsg.extraData.putString("subcmd", "GetMyComicFavorEmotIcons");
    localToServiceMsg.extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    localToServiceMsg.putWupBuffer(a(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GetMyComicFavorEmotIcons", NetConnInfoCenter.getServerTime(), null), new MqqComicPb.GetMyComicFavorEmotIconsReqBody()));
    sendPbReq(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    MqqComicPb.SetMyComicFavorEmotIconsReqBody localSetMyComicFavorEmotIconsReqBody = new MqqComicPb.SetMyComicFavorEmotIconsReqBody();
    try
    {
      paramToServiceMsg = (byte[])paramToServiceMsg.getWupBuffer();
      int j = a(paramToServiceMsg, 4);
      byte[] arrayOfByte = new byte[a(paramToServiceMsg, j + 4) - 4];
      PkgTools.copyData(arrayOfByte, 0, paramToServiceMsg, j + 8, arrayOfByte.length);
      localSetMyComicFavorEmotIconsReqBody.mergeFrom(arrayOfByte);
      if ((localSetMyComicFavorEmotIconsReqBody != null) && (localSetMyComicFavorEmotIconsReqBody.reqs != null))
      {
        paramToServiceMsg = new ArrayList();
        while (i < localSetMyComicFavorEmotIconsReqBody.reqs.size())
        {
          paramToServiceMsg.add(((MqqComicPb.ComicFavorEmotIcons)localSetMyComicFavorEmotIconsReqBody.reqs.get(i)).md5.get());
          i += 1;
        }
        ((VipComicMqqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MQQ_COMIC_MANAGER)).b(paramToServiceMsg);
        a("responseSetMyComicFavorEmotIcons updateComicStructInfo");
      }
    }
    catch (Exception paramToServiceMsg)
    {
      try
      {
        paramToServiceMsg.mergeFrom(paramArrayOfByte);
        if (paramInt != 0) {
          break label249;
        }
        notifyUI(2, true, paramToServiceMsg);
        return;
        paramToServiceMsg = paramToServiceMsg;
        a("responseSetMyComicFavorEmotIcons exception:" + paramToServiceMsg.getMessage());
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          paramToServiceMsg = null;
          a("SetMyComicFavorEmotIconsRspBody mergeFrom exception : " + paramArrayOfByte.getMessage());
        }
        label249:
        notifyUI(4, true, paramToServiceMsg);
      }
    }
    paramToServiceMsg = new MqqComicPb.SetMyComicFavorEmotIconsRspBody();
  }
  
  public void a(List<MqqComicPb.ComicFavorEmotIcons> paramList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ComicProtoConvSvr.tunnel");
    localToServiceMsg.extraData.putString("subcmd", "SetMyComicFavorEmotIcons");
    localToServiceMsg.extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    MqqComicHeadPb.ComicReqHead localComicReqHead = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SetMyComicFavorEmotIcons", NetConnInfoCenter.getServerTime(), null);
    MqqComicPb.SetMyComicFavorEmotIconsReqBody localSetMyComicFavorEmotIconsReqBody = new MqqComicPb.SetMyComicFavorEmotIconsReqBody();
    localSetMyComicFavorEmotIconsReqBody.reqs.set(paramList);
    localToServiceMsg.putWupBuffer(a(localComicReqHead, localSetMyComicFavorEmotIconsReqBody));
    sendPbReq(localToServiceMsg);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new MqqComicPb.GetMyComicFavorEmotIconsRspBody();
    if (paramInt == 0)
    {
      try
      {
        ((MqqComicPb.GetMyComicFavorEmotIconsRspBody)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          a("GetMyComicFavorEmotIconsRspBody mergeFrom exception : " + paramArrayOfByte.getMessage());
          paramArrayOfByte = null;
        }
        notifyUI(2, true, paramArrayOfByte);
        return;
      }
      if (paramArrayOfByte != null) {
        if (paramArrayOfByte.rsps != null)
        {
          localObject = (VipComicMqqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MQQ_COMIC_MANAGER);
          if (localObject != null)
          {
            paramInt = 0;
            while (paramInt < paramArrayOfByte.rsps.size())
            {
              VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = new VipComicFavorEmoStructMsgInfo();
              localVipComicFavorEmoStructMsgInfo.picMd5 = ((MqqComicPb.ComicFavorEmotIcons)paramArrayOfByte.rsps.get(paramInt)).md5.get();
              localVipComicFavorEmoStructMsgInfo.actionData = ((MqqComicPb.ComicFavorEmotIcons)paramArrayOfByte.rsps.get(paramInt)).info.get();
              localVipComicFavorEmoStructMsgInfo.status = 2;
              ((VipComicMqqManager)localObject).a(localVipComicFavorEmoStructMsgInfo);
              paramInt += 1;
            }
          }
        }
      }
      notifyUI(3, true, paramArrayOfByte);
      return;
    }
    notifyUI(4, true, localObject);
  }
  
  public boolean a()
  {
    int i;
    if (jdField_a_of_type_Int < 0)
    {
      i = 0;
      if (i != 0) {
        break label35;
      }
    }
    label35:
    do
    {
      return false;
      if (jdField_a_of_type_Int > 100)
      {
        i = 100;
        break;
      }
      i = jdField_a_of_type_Int;
      break;
      if (i == 100) {
        return true;
      }
    } while (new Random(System.currentTimeMillis()).nextInt(100) + 1 > i);
    return true;
  }
  
  public void b()
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ComicProtoConvSvr.tunnel");
    localToServiceMsg.extraData.putString("subcmd", "GetComicGlobalConfig");
    localToServiceMsg.extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    byte[] arrayOfByte = a(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "GetComicGlobalConfig", NetConnInfoCenter.getServerTime(), null), new MqqComicPb.GetComicGlobalConfigReqBody());
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      a("intent error , data = " + arrayOfByte);
      return;
    }
    localToServiceMsg.putWupBuffer(arrayOfByte);
    sendPbReq(localToServiceMsg);
    a("[ComicGlobalConfig] send request to server");
  }
  
  public void b(List<String> paramList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ComicProtoConvSvr.tunnel");
    localToServiceMsg.extraData.putString("subcmd", "DelMyComicFavorEmotIcons");
    localToServiceMsg.extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    MqqComicHeadPb.ComicReqHead localComicReqHead = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "DelMyComicFavorEmotIcons", NetConnInfoCenter.getServerTime(), null);
    MqqComicPb.DelMyComicFavorEmotIconsReqBody localDelMyComicFavorEmotIconsReqBody = new MqqComicPb.DelMyComicFavorEmotIconsReqBody();
    localDelMyComicFavorEmotIconsReqBody.md5List.set(paramList);
    localToServiceMsg.putWupBuffer(a(localComicReqHead, localDelMyComicFavorEmotIconsReqBody));
    sendPbReq(localToServiceMsg);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    MqqComicPb.DelMyComicFavorEmotIconsRspBody localDelMyComicFavorEmotIconsRspBody = new MqqComicPb.DelMyComicFavorEmotIconsRspBody();
    try
    {
      localDelMyComicFavorEmotIconsRspBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localDelMyComicFavorEmotIconsRspBody;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramArrayOfByte = null;
        a("DelMyComicFavorEmotIconsRspBody mergeFrom exception : " + localException.getMessage());
      }
      notifyUI(9, true, paramArrayOfByte);
    }
    if (paramInt == 0)
    {
      notifyUI(8, true, paramArrayOfByte);
      return;
    }
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt)
  {
    MqqComicPb.GetComicGlobalConfigRspBody localGetComicGlobalConfigRspBody;
    if (paramInt == 0) {
      localGetComicGlobalConfigRspBody = new MqqComicPb.GetComicGlobalConfigRspBody();
    }
    try
    {
      localGetComicGlobalConfigRspBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localGetComicGlobalConfigRspBody;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        a("getComicGlobalConfigRspBody mergeFrom exception : " + paramArrayOfByte.getMessage());
        paramArrayOfByte = null;
      }
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.maintab.has())) {
      VipComicHelper.b(paramArrayOfByte.maintab.get());
    }
    a("[ComicGlobalConfig] receive from server");
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return VipComicMqqObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramFromServiceMsg.getServiceCmd();
    long l3 = paramToServiceMsg.extraData.size();
    long l2 = 0L;
    long l1 = l2;
    if (paramObject != null)
    {
      l1 = l2;
      if ((paramObject instanceof byte[])) {
        l1 = ((byte[])paramObject).length;
      }
    }
    l2 = paramToServiceMsg.extraData.getLong("requestTime");
    String str = paramToServiceMsg.extraData.getString("subcmd");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {}
    for (;;)
    {
      return;
      if (!"ComicProtoConvSvr.tunnel".equals(localObject)) {
        continue;
      }
      if (!paramFromServiceMsg.isSuccess())
      {
        paramToServiceMsg = "";
        if ("GetMyComicFavorEmotIcons".equals(str))
        {
          notifyUI(1, true, null);
          paramToServiceMsg = "[会员中心].查询我的漫图发送失败";
        }
        while ((a()) && (!TextUtils.isEmpty(paramToServiceMsg)))
        {
          ReportCenter.a().a(str, l2, l3, l1, paramFromServiceMsg.getBusinessFailCode(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), jdField_a_of_type_JavaLangString, paramToServiceMsg, false);
          return;
          if ("SetMyComicFavorEmotIcons".equals(str))
          {
            notifyUI(7, true, null);
            paramToServiceMsg = "[会员中心].设置我的漫图发送失败";
          }
          else if ("DelMyComicFavorEmotIcons".equals(str))
          {
            notifyUI(10, true, null);
            paramToServiceMsg = "[会员中心].删除我的漫图发送失败";
          }
          else if ("GetComicGlobalConfig".equals(str))
          {
            paramToServiceMsg = "[QQ动漫].查询动漫全局配置失败";
          }
        }
        continue;
      }
      localObject = (byte[])paramObject;
      int i = a((byte[])localObject, 0);
      paramObject = new byte[i - 4];
      PkgTools.copyData(paramObject, 0, (byte[])localObject, 4, paramObject.length);
      paramFromServiceMsg = new MqqComicHeadPb.ComicRspHead();
      try
      {
        paramFromServiceMsg.mergeFrom(paramObject);
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.retCode.has())) {
          continue;
        }
        j = paramFromServiceMsg.retCode.get();
        jdField_a_of_type_Int = paramFromServiceMsg.reportRate.get();
        paramObject = null;
        if (j == 0)
        {
          paramFromServiceMsg = new byte[a((byte[])localObject, i) - 4];
          PkgTools.copyData(paramFromServiceMsg, 0, (byte[])localObject, i + 4, paramFromServiceMsg.length);
          paramObject = "";
          if (!"GetMyComicFavorEmotIcons".equals(str)) {
            break label483;
          }
          a(paramFromServiceMsg, j);
          paramToServiceMsg = "[会员中心].查询我的漫图成功";
          if ((!a()) || (TextUtils.isEmpty(paramToServiceMsg))) {
            continue;
          }
          ReportCenter.a().a("GetMyComicFavorEmotIcons", l2, l3, l1, j, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), jdField_a_of_type_JavaLangString, paramToServiceMsg, false);
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          int j;
          a("onReceive comicRspHead mergeFrom exception:" + paramFromServiceMsg.getMessage());
          paramFromServiceMsg = null;
          continue;
          paramFromServiceMsg = paramObject;
          if (j > 0)
          {
            paramFromServiceMsg = paramObject;
            continue;
            label483:
            if ("SetMyComicFavorEmotIcons".equals(str))
            {
              a(paramToServiceMsg, paramFromServiceMsg, j);
              paramToServiceMsg = "[会员中心].设置我的漫图信息成功";
            }
            else if ("DelMyComicFavorEmotIcons".equals(str))
            {
              b(paramFromServiceMsg, j);
              paramToServiceMsg = "[会员中心].删除我的漫图信息成功";
            }
            else
            {
              paramToServiceMsg = paramObject;
              if ("GetComicGlobalConfig".equals(str))
              {
                c(paramFromServiceMsg, j);
                paramToServiceMsg = "[QQ动漫].查询动漫全局配置，code = " + j;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler
 * JD-Core Version:    0.7.0.1
 */