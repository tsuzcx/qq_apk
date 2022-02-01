package com.tencent.mobileqq.emosm.vipcomic;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VipComicMqqHandler
  extends BusinessHandler
  implements IVipComicMqqHandler
{
  public static final String a = "com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler";
  private AppInterface a;
  
  public VipComicMqqHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqHandler", 2, paramString);
    }
  }
  
  public void a()
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ComicProtoConvSvr.tunnel");
    localToServiceMsg.extraData.putString("subcmd", "GetMyComicFavorEmotIcons");
    localToServiceMsg.extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    localToServiceMsg.putWupBuffer(VipComicMqqHandlerConstants.a(VipComicMqqHandlerConstants.a(this.a, "GetMyComicFavorEmotIcons", NetConnInfoCenter.getServerTime(), null), new MqqComicPb.GetMyComicFavorEmotIconsReqBody()));
    sendPbReq(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new MqqComicPb.SetMyComicFavorEmotIconsReqBody();
    try
    {
      paramToServiceMsg = (byte[])paramToServiceMsg.getWupBuffer();
      int j = a(paramToServiceMsg, 4);
      byte[] arrayOfByte = new byte[a(paramToServiceMsg, j + 4) - 4];
      int k = arrayOfByte.length;
      int i = 0;
      PkgTools.copyData(arrayOfByte, 0, paramToServiceMsg, j + 8, k);
      ((MqqComicPb.SetMyComicFavorEmotIconsReqBody)localObject).mergeFrom(arrayOfByte);
      if (((MqqComicPb.SetMyComicFavorEmotIconsReqBody)localObject).reqs != null)
      {
        paramToServiceMsg = new ArrayList();
        while (i < ((MqqComicPb.SetMyComicFavorEmotIconsReqBody)localObject).reqs.size())
        {
          paramToServiceMsg.add(((MqqComicPb.ComicFavorEmotIcons)((MqqComicPb.SetMyComicFavorEmotIconsReqBody)localObject).reqs.get(i)).md5.get());
          i += 1;
        }
        ((IVipComicMqqManagerService)this.a.getRuntimeService(IVipComicMqqManagerService.class, "")).updateComicStructInfo(paramToServiceMsg);
        a("responseSetMyComicFavorEmotIcons updateComicStructInfo");
      }
    }
    catch (Exception paramToServiceMsg)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("responseSetMyComicFavorEmotIcons exception:");
      ((StringBuilder)localObject).append(paramToServiceMsg.getMessage());
      a(((StringBuilder)localObject).toString());
    }
    paramToServiceMsg = new MqqComicPb.SetMyComicFavorEmotIconsRspBody();
    try
    {
      paramToServiceMsg.mergeFrom(paramArrayOfByte);
    }
    catch (Exception paramToServiceMsg)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("SetMyComicFavorEmotIconsRspBody mergeFrom exception : ");
      paramArrayOfByte.append(paramToServiceMsg.getMessage());
      a(paramArrayOfByte.toString());
      paramToServiceMsg = null;
    }
    if (paramInt == 0)
    {
      notifyUI(2, true, paramToServiceMsg);
      return;
    }
    notifyUI(4, true, paramToServiceMsg);
  }
  
  public void a(List<MqqComicPb.ComicFavorEmotIcons> paramList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ComicProtoConvSvr.tunnel");
    localToServiceMsg.extraData.putString("subcmd", "SetMyComicFavorEmotIcons");
    localToServiceMsg.extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    MqqComicHeadPb.ComicReqHead localComicReqHead = VipComicMqqHandlerConstants.a(this.a, "SetMyComicFavorEmotIcons", NetConnInfoCenter.getServerTime(), null);
    MqqComicPb.SetMyComicFavorEmotIconsReqBody localSetMyComicFavorEmotIconsReqBody = new MqqComicPb.SetMyComicFavorEmotIconsReqBody();
    localSetMyComicFavorEmotIconsReqBody.reqs.set(paramList);
    localToServiceMsg.putWupBuffer(VipComicMqqHandlerConstants.a(localComicReqHead, localSetMyComicFavorEmotIconsReqBody));
    sendPbReq(localToServiceMsg);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    MqqComicPb.GetMyComicFavorEmotIconsRspBody localGetMyComicFavorEmotIconsRspBody = new MqqComicPb.GetMyComicFavorEmotIconsRspBody();
    IVipComicMqqManagerService localIVipComicMqqManagerService;
    if (paramInt == 0)
    {
      Object localObject;
      try
      {
        localGetMyComicFavorEmotIconsRspBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localGetMyComicFavorEmotIconsRspBody;
      }
      catch (Exception localException)
      {
        paramArrayOfByte = null;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetMyComicFavorEmotIconsRspBody mergeFrom exception : ");
        ((StringBuilder)localObject).append(localException.getMessage());
        a(((StringBuilder)localObject).toString());
      }
      if (paramArrayOfByte != null)
      {
        if (paramArrayOfByte.rsps != null)
        {
          localIVipComicMqqManagerService = (IVipComicMqqManagerService)this.a.getRuntimeService(IVipComicMqqManagerService.class, "");
          if (localIVipComicMqqManagerService != null)
          {
            paramInt = 0;
            while (paramInt < paramArrayOfByte.rsps.size())
            {
              localObject = new VipComicFavorEmoStructMsgInfo();
              ((VipComicFavorEmoStructMsgInfo)localObject).picMd5 = ((MqqComicPb.ComicFavorEmotIcons)paramArrayOfByte.rsps.get(paramInt)).md5.get();
              ((VipComicFavorEmoStructMsgInfo)localObject).actionData = ((MqqComicPb.ComicFavorEmotIcons)paramArrayOfByte.rsps.get(paramInt)).info.get();
              ((VipComicFavorEmoStructMsgInfo)localObject).status = 2;
              localIVipComicMqqManagerService.saveComicStructInfo((VipComicFavorEmoStructMsgInfo)localObject);
              paramInt += 1;
            }
          }
        }
        notifyUI(2, true, paramArrayOfByte);
        return;
      }
      notifyUI(3, true, paramArrayOfByte);
      return;
    }
    notifyUI(4, true, localIVipComicMqqManagerService);
  }
  
  public boolean a()
  {
    int i;
    if (VipComicMqqHandlerConstants.jdField_a_of_type_Int < 0) {
      i = 0;
    } else if (VipComicMqqHandlerConstants.jdField_a_of_type_Int > 100) {
      i = 100;
    } else {
      i = VipComicMqqHandlerConstants.jdField_a_of_type_Int;
    }
    if (i == 0) {
      return false;
    }
    if (i == 100) {
      return true;
    }
    return new Random(System.currentTimeMillis()).nextInt(100) + 1 <= i;
  }
  
  public void b()
  {
    Object localObject = createToServiceMsg("ComicProtoConvSvr.tunnel");
    ((ToServiceMsg)localObject).extraData.putString("subcmd", "GetComicGlobalConfig");
    ((ToServiceMsg)localObject).extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    byte[] arrayOfByte = VipComicMqqHandlerConstants.a(VipComicMqqHandlerConstants.a(this.a, "GetComicGlobalConfig", NetConnInfoCenter.getServerTime(), null), new MqqComicPb.GetComicGlobalConfigReqBody());
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      ((ToServiceMsg)localObject).putWupBuffer(arrayOfByte);
      sendPbReq((ToServiceMsg)localObject);
      a("[ComicGlobalConfig] send request to server");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("intent error , data = ");
    ((StringBuilder)localObject).append(arrayOfByte);
    a(((StringBuilder)localObject).toString());
  }
  
  public void b(List<String> paramList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("ComicProtoConvSvr.tunnel");
    localToServiceMsg.extraData.putString("subcmd", "DelMyComicFavorEmotIcons");
    localToServiceMsg.extraData.putLong("requestTime", SystemClock.elapsedRealtime());
    MqqComicHeadPb.ComicReqHead localComicReqHead = VipComicMqqHandlerConstants.a(this.a, "DelMyComicFavorEmotIcons", NetConnInfoCenter.getServerTime(), null);
    MqqComicPb.DelMyComicFavorEmotIconsReqBody localDelMyComicFavorEmotIconsReqBody = new MqqComicPb.DelMyComicFavorEmotIconsReqBody();
    localDelMyComicFavorEmotIconsReqBody.md5List.set(paramList);
    localToServiceMsg.putWupBuffer(VipComicMqqHandlerConstants.a(localComicReqHead, localDelMyComicFavorEmotIconsReqBody));
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
      paramArrayOfByte = null;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DelMyComicFavorEmotIconsRspBody mergeFrom exception : ");
      localStringBuilder.append(localException.getMessage());
      a(localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      notifyUI(8, true, paramArrayOfByte);
      return;
    }
    notifyUI(9, true, paramArrayOfByte);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = new MqqComicPb.GetComicGlobalConfigRspBody();
      try
      {
        ((MqqComicPb.GetComicGlobalConfigRspBody)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getComicGlobalConfigRspBody mergeFrom exception : ");
        ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
        a(((StringBuilder)localObject).toString());
        paramArrayOfByte = null;
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.maintab.has())) {
        ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).setDefaultComicTab(paramArrayOfByte.maintab.get());
      }
    }
    a("[ComicGlobalConfig] receive from server");
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return VipComicMqqObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramFromServiceMsg.getServiceCmd();
    long l2 = paramToServiceMsg.extraData.size();
    long l1;
    if ((paramObject != null) && ((paramObject instanceof byte[]))) {
      l1 = ((byte[])paramObject).length;
    } else {
      l1 = 0L;
    }
    long l3 = paramToServiceMsg.extraData.getLong("requestTime");
    String str = paramToServiceMsg.extraData.getString("subcmd");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if (!"ComicProtoConvSvr.tunnel".equals(localObject)) {
        return;
      }
      if (!paramFromServiceMsg.isSuccess())
      {
        if ("GetMyComicFavorEmotIcons".equals(str))
        {
          notifyUI(1, true, null);
          paramToServiceMsg = "[会员中心].查询我的漫图发送失败";
        }
        for (;;)
        {
          break;
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
          else
          {
            paramToServiceMsg = "";
          }
        }
        if ((a()) && (!TextUtils.isEmpty(paramToServiceMsg))) {
          ReportCenter.a().a(str, l3, l2, l1, paramFromServiceMsg.getBusinessFailCode(), Long.valueOf(this.a.getCurrentAccountUin()).longValue(), VipComicMqqHandlerConstants.jdField_a_of_type_JavaLangString, paramToServiceMsg, false);
        }
        return;
      }
      paramObject = (byte[])paramObject;
      int i = a(paramObject, 0);
      localObject = new byte[i - 4];
      PkgTools.copyData((byte[])localObject, 0, paramObject, 4, localObject.length);
      paramFromServiceMsg = new MqqComicHeadPb.ComicRspHead();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])localObject);
      }
      catch (Exception paramFromServiceMsg)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceive comicRspHead mergeFrom exception:");
        ((StringBuilder)localObject).append(paramFromServiceMsg.getMessage());
        a(((StringBuilder)localObject).toString());
        paramFromServiceMsg = null;
      }
      if (paramFromServiceMsg != null)
      {
        if (!paramFromServiceMsg.retCode.has()) {
          return;
        }
        int j = paramFromServiceMsg.retCode.get();
        VipComicMqqHandlerConstants.jdField_a_of_type_Int = paramFromServiceMsg.reportRate.get();
        if (j == 0)
        {
          paramFromServiceMsg = new byte[a(paramObject, i) - 4];
          PkgTools.copyData(paramFromServiceMsg, 0, paramObject, i + 4, paramFromServiceMsg.length);
        }
        else
        {
          paramFromServiceMsg = null;
        }
        if ("GetMyComicFavorEmotIcons".equals(str))
        {
          a(paramFromServiceMsg, j);
          paramToServiceMsg = "[会员中心].查询我的漫图成功";
        }
        for (;;)
        {
          break;
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
          else if ("GetComicGlobalConfig".equals(str))
          {
            c(paramFromServiceMsg, j);
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("[QQ动漫].查询动漫全局配置，code = ");
            paramToServiceMsg.append(j);
            paramToServiceMsg = paramToServiceMsg.toString();
          }
          else
          {
            paramToServiceMsg = "";
          }
        }
        if ((a()) && (!TextUtils.isEmpty(paramToServiceMsg))) {
          ReportCenter.a().a("GetMyComicFavorEmotIcons", l3, l2, l1, j, Long.valueOf(this.a.getCurrentAccountUin()).longValue(), VipComicMqqHandlerConstants.jdField_a_of_type_JavaLangString, paramToServiceMsg, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler
 * JD-Core Version:    0.7.0.1
 */