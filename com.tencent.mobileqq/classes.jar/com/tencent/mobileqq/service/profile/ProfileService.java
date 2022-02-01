package com.tencent.mobileqq.service.profile;

import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import KQQ.ChangeFriendNameReq;
import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateReq;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigReq;
import KQQ.GetRichSigRes;
import KQQ.GroupMngReq;
import KQQ.ProfGroupInfoReq;
import KQQ.ProfGroupInfoRes;
import KQQ.ProfIncInfoReq;
import KQQ.ProfSmpInfoRes;
import KQQ.ProfVipqqInfoReq;
import KQQ.ProfVipqqInfoRes;
import KQQ.ReqItem;
import KQQ.ReqRichInfo;
import KQQ.SetRichSigReq;
import KQQ.SetRichSigRes;
import KQQ.SyncRes;
import KQQ.WeatherInfoReq;
import QQService.SvcReqBindUin;
import QQService.SvcReqDelLoginInfo;
import QQService.SvcReqGetDevLoginInfo;
import QQService.SvcReqKikOut;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import ResPackage.ReqResOrder;
import ResPackage.ReqResUpdate;
import ResPackage.RspResOrder;
import ResPackage.RspResUpdate;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.OnlineStatusService;
import com.tencent.mobileqq.service.troop.TroopService;
import com.tencent.mobileqq.troop.service.api.IBizTroopServiceApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class ProfileService
  extends BaseProtocolCoder
{
  private static final String[] a = { "ProfileService", "StatSvc", "AvatarInfoSvr", "NickQuerySvc", "GetAvatarInfo", "ChatAvatar" };
  private int b = 0;
  private final AppInterface c = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  private TroopService d;
  private OnlineStatusService e;
  private IBizTroopServiceApi f = (IBizTroopServiceApi)QRoute.api(IBizTroopServiceApi.class);
  
  public ProfileService()
  {
    this.requestHandles.put("ProfileService.GetWeatherInfo", Integer.valueOf(1));
    this.requestHandles.put("ProfileService.GetSimpleInfo", Integer.valueOf(2));
    this.requestHandles.put("ProfileService.GetRichSig", Integer.valueOf(3));
    this.requestHandles.put("ProfileService.SetRichSig", Integer.valueOf(7));
    this.requestHandles.put("ProfileService.ChangeFriendName", Integer.valueOf(8));
    this.requestHandles.put("ProfileService.GetProfIncInfo", Integer.valueOf(11));
    this.requestHandles.put("ProfileService.ProfVipqqInfo", Integer.valueOf(12));
    this.requestHandles.put("AvatarInfoSvr.QQHeadUrlReq", Integer.valueOf(13));
    this.requestHandles.put("ProfileService.getGroupInfoReq", Integer.valueOf(15));
    this.requestHandles.put("ProfileService.GroupMngReq", Integer.valueOf(17));
    this.requestHandles.put("ProfileService.CheckUpdateReq", Integer.valueOf(23));
    this.requestHandles.put("ChatAvatar.ReqResOrder", Integer.valueOf(24));
    this.requestHandles.put("ChatAvatar.ReqResUpdate", Integer.valueOf(25));
    this.requestHandles.put("StatSvc.GetDevLoginInfo", Integer.valueOf(26));
    this.requestHandles.put("StatSvc.DelDevLoginInfo", Integer.valueOf(27));
    this.requestHandles.put("StatSvc.SvcReqKikOut", Integer.valueOf(28));
    this.requestHandles.put("StatSvc.BindUin", Integer.valueOf(29));
    this.requestHandles.put("ProfileService.ReqBatchProcess", Integer.valueOf(30));
    this.requestHandles.put("StatSvc.SetStatusFromClient", Integer.valueOf(31));
    this.d = new TroopService(this.c);
    this.e = new OnlineStatusService(this.c);
  }
  
  private boolean A(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 7;
    localGroupMngReq.uin = l1;
    l1 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = a(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private long a(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      if (paramString.length() <= 0) {
        return 0L;
      }
    }
    try
    {
      l = Long.parseLong(paramString);
      if (l < 10000L) {
        return 0L;
      }
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  private void a(ToServiceMsg paramToServiceMsg) {}
  
  private boolean a(ToServiceMsg paramToServiceMsg, ArrayList<Long> paramArrayList, UniPacket paramUniPacket)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean a(String paramString, UniPacket paramUniPacket)
  {
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetWeatherInfo");
    int i = this.b;
    this.b = (i + 1);
    paramUniPacket.put("req", new WeatherInfoReq(i, "", paramString));
    return true;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRspGetDevLoginInfo)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRspGetDevLoginInfo", new SvcRspGetDevLoginInfo());
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.ChatAvatarServer.ChatAvatarObj");
    paramUniPacket.setFuncName("ReqResUpdate");
    ReqResUpdate localReqResUpdate = new ReqResUpdate();
    localReqResUpdate.SeqID = paramToServiceMsg.extraData.getInt("seq_id", 0);
    localReqResUpdate.ResID = paramToServiceMsg.extraData.getInt("ResID", 2);
    paramUniPacket.put("ReqResUpdate", localReqResUpdate);
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRspDelLoginInfo)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRspDelLoginInfo", new SvcRspDelLoginInfo());
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.ChatAvatarServer.ChatAvatarObj");
    paramUniPacket.setFuncName("ReqResOrder");
    ReqResOrder localReqResOrder = new ReqResOrder();
    localReqResOrder.ResID = 1;
    localReqResOrder.Path = Integer.toString(paramToServiceMsg.extraData.getInt("req_res_order_pkgid", 0));
    paramUniPacket.put("ReqResOrder", localReqResOrder);
    return true;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespKikOut)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp", new SvcRespKikOut());
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateReq called");
    }
    CheckUpdateReq localCheckUpdateReq = new CheckUpdateReq();
    localCheckUpdateReq.isSupportSubPack = true;
    localCheckUpdateReq.vecReqPkg = new ArrayList();
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("isFirstTime", Boolean.valueOf(true))).booleanValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("CheckUpdateType", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, String.format("handleCheckUpdateReq isFirstTime:%s, type:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
    }
    Object localObject1;
    if (bool)
    {
      paramToServiceMsg = ((QQAppInterface)this.c).mAutomator.a().entrySet().iterator();
      while (paramToServiceMsg.hasNext())
      {
        localObject1 = (Map.Entry)paramToServiceMsg.next();
        Object localObject2 = (Integer)((Map.Entry)localObject1).getKey();
        localObject1 = (CheckUpdateItemInterface)((Map.Entry)localObject1).getValue();
        if ((((CheckUpdateItemInterface)localObject1).a() & i) != 0)
        {
          localObject1 = ((CheckUpdateItemInterface)localObject1).a(i);
          if (localObject1 != null)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleCheckUpdateReq item:eServiceId=");
              ((StringBuilder)localObject2).append(((ReqItem)localObject1).eServiceID);
              ((StringBuilder)localObject2).append(",cOperType=");
              ((StringBuilder)localObject2).append(((ReqItem)localObject1).cOperType);
              QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject2).toString());
            }
            localCheckUpdateReq.vecReqPkg.add(localObject1);
          }
        }
      }
    }
    paramToServiceMsg = (CheckUpdateItemInterface)((QQAppInterface)this.c).mAutomator.a().get(Integer.valueOf(101));
    if ((paramToServiceMsg.a() & i) != 0)
    {
      paramToServiceMsg = paramToServiceMsg.a(i);
      if (paramToServiceMsg != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleCheckUpdateReq item:eServiceId=");
          ((StringBuilder)localObject1).append(paramToServiceMsg.eServiceID);
          ((StringBuilder)localObject1).append(",cOperType=");
          ((StringBuilder)localObject1).append(paramToServiceMsg.cOperType);
          QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject1).toString());
        }
        localCheckUpdateReq.vecReqPkg.add(paramToServiceMsg);
      }
    }
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("CheckUpdateReq");
    paramUniPacket.put("CheckUpdateReq", localCheckUpdateReq);
    return true;
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRspBindUin)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRspBindUin", new SvcRspBindUin());
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqGetDevLoginInfo");
    SvcReqGetDevLoginInfo localSvcReqGetDevLoginInfo = new SvcReqGetDevLoginInfo();
    localSvcReqGetDevLoginInfo.iLoginType = paramToServiceMsg.extraData.getLong("iLoginType");
    localSvcReqGetDevLoginInfo.iNextItemIndex = paramToServiceMsg.extraData.getLong("iNextItemIndex");
    localSvcReqGetDevLoginInfo.iRequireMax = paramToServiceMsg.extraData.getLong("iRequireMax");
    localSvcReqGetDevLoginInfo.iTimeStamp = paramToServiceMsg.extraData.getLong("iTimeStamp");
    localSvcReqGetDevLoginInfo.strAppName = paramToServiceMsg.extraData.getString("strAppName");
    localSvcReqGetDevLoginInfo.vecGuid = paramToServiceMsg.extraData.getByteArray("vecGuid");
    localSvcReqGetDevLoginInfo.iGetDevListType = paramToServiceMsg.extraData.getLong("iGetDevListType");
    paramUniPacket.put("SvcReqGetDevLoginInfo", localSvcReqGetDevLoginInfo);
    return true;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ProfGroupInfoRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "res", new ProfGroupInfoRes());
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqDelLoginInfo");
    SvcReqDelLoginInfo localSvcReqDelLoginInfo = new SvcReqDelLoginInfo();
    localSvcReqDelLoginInfo.strAppName = paramToServiceMsg.extraData.getString("strAppName");
    localSvcReqDelLoginInfo.vecDeviceItemDes = ((ArrayList)paramToServiceMsg.getAttribute("vecDeviceItemDes"));
    paramToServiceMsg.addAttribute("vecDeviceItemDes", null);
    localSvcReqDelLoginInfo.vecGuid = paramToServiceMsg.extraData.getByteArray("vecGuid");
    localSvcReqDelLoginInfo.iDelType = paramToServiceMsg.extraData.getInt("iDelType");
    localSvcReqDelLoginInfo.iDelMe = paramToServiceMsg.extraData.getInt("iDelMe");
    localSvcReqDelLoginInfo.iAppId = paramToServiceMsg.extraData.getLong("iAppId");
    paramUniPacket.put("SvcReqDelLoginInfo", localSvcReqDelLoginInfo);
    return true;
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ProfVipqqInfoRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "res", new ProfVipqqInfoRes());
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqKikOut");
    SvcReqKikOut localSvcReqKikOut = new SvcReqKikOut();
    localSvcReqKikOut.appid = paramToServiceMsg.extraData.getLong("appid");
    localSvcReqKikOut.cKeyType = paramToServiceMsg.extraData.getByte("cKeyType");
    localSvcReqKikOut.lUin = paramToServiceMsg.extraData.getLong("lUin");
    localSvcReqKikOut.sKey = paramToServiceMsg.extraData.getByteArray("sKey");
    paramUniPacket.put("req", localSvcReqKikOut);
    return true;
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return decodePacket(paramFromServiceMsg.getWupBuffer(), "SetRichSigRes", new SetRichSigRes());
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StatSvc");
    paramUniPacket.setFuncName("SvcReqBindUin");
    SvcReqBindUin localSvcReqBindUin = new SvcReqBindUin();
    localSvcReqBindUin.cCmd = paramToServiceMsg.extraData.getByte("cCmd");
    localSvcReqBindUin.vecBindUin = ((ArrayList)paramToServiceMsg.getAttribute("vecBindUin"));
    paramToServiceMsg.addAttribute("vecBindUin", null);
    paramUniPacket.put("SvcReqBindUin", localSvcReqBindUin);
    return true;
  }
  
  private Object i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (ChangeFriendNameRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "res", new ChangeFriendNameRes());
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = paramToServiceMsg.extraData.getString("uin");
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    if (a((String)localObject) == 0L)
    {
      a(paramToServiceMsg);
      return false;
    }
    localObject = new ProfGroupInfoReq();
    ((ProfGroupInfoReq)localObject).uGroupCode = a(str);
    ((ProfGroupInfoReq)localObject).dwTimeStamp = paramToServiceMsg.extraData.getLong("groupablm_timestamp");
    ((ProfGroupInfoReq)localObject).cIsGetGroupAlbum = paramToServiceMsg.extraData.getByte("get_groupablm");
    ((ProfGroupInfoReq)localObject).wSourceID = paramToServiceMsg.extraData.getInt("cStatOption", 0);
    ((ProfGroupInfoReq)localObject).cIfGetAuthInfo = paramToServiceMsg.extraData.getByte("cIfGetAuthInfo");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupInfoReq");
    paramUniPacket.put("req", localObject);
    return true;
  }
  
  private Object j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return decodePacket(paramFromServiceMsg.getWupBuffer(), "GetRichSigRes", new GetRichSigRes());
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrlReq();
    JceInputStream localJceInputStream = new JceInputStream(paramToServiceMsg.extraData.getByteArray("QQHeadUrlReq"));
    localJceInputStream.setServerEncoding("UTF-8");
    localQQHeadUrlReq.readFrom(localJceInputStream);
    if ((localQQHeadUrlReq.dstUsrType < 0) && (QLog.isColorLevel())) {
      QLog.e("", 2, "==============================handleGetQQHead error! ");
    }
    paramUniPacket.setServantName("GetAvatarInfo");
    paramUniPacket.setFuncName("QQHeadUrlReq");
    paramUniPacket.put("QQHeadUrlReq", localQQHeadUrlReq);
    paramToServiceMsg.setServiceCmd("AvatarInfoSvr.QQHeadUrlReq");
    return true;
  }
  
  private Object k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = new ArrayList();
      paramFromServiceMsg.add(new ProfSmpInfoRes());
      paramToServiceMsg = (ArrayList)paramToServiceMsg.getByClass("res", paramFromServiceMsg);
      if (QLog.isColorLevel())
      {
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
        {
          paramFromServiceMsg = (ProfSmpInfoRes)paramToServiceMsg.get(0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("businessCardFlag: ");
          localStringBuilder.append(paramFromServiceMsg.cBusiCardFlag);
          QLog.e("BusinessCard_Manager", 2, localStringBuilder.toString());
          return paramToServiceMsg;
        }
        QLog.e("BusinessCard_Manager", 2, "businessCardFlag: empty");
      }
      return paramToServiceMsg;
    }
    catch (RuntimeException|Exception paramToServiceMsg) {}
    return null;
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.extraData.getString("uin"));
    if (l == 0L)
    {
      a(paramToServiceMsg);
      return false;
    }
    paramToServiceMsg = new ProfVipqqInfoReq();
    paramToServiceMsg.iUin = l;
    paramToServiceMsg.iRetIncomPlete = 1;
    paramToServiceMsg.iReloadFlag = 1;
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ProfVipqqInfo");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private Object l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (QQHeadUrlResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "QQHeadUrlResp", new QQHeadUrlResp());
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.extraData.getString("uin"));
    if (l == 0L)
    {
      a(paramToServiceMsg);
      return false;
    }
    paramToServiceMsg = new ProfIncInfoReq();
    paramToServiceMsg.iUin = l;
    paramToServiceMsg.iRetIncomPlete = 1;
    paramToServiceMsg.iReloadFlag = 1;
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetProfIncInfo");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private Object m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RspResUpdate)decodePacket(paramFromServiceMsg.getWupBuffer(), "RspResUpdate", new RspResUpdate());
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new SetRichSigReq(paramToServiceMsg.extraData.getByteArray("sig_value"), paramToServiceMsg.extraData.getInt("key"));
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("SetRichSig");
    paramUniPacket.put("SetRichSigReq", paramToServiceMsg);
    return true;
  }
  
  private Object n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RspResOrder)decodePacket(paramFromServiceMsg.getWupBuffer(), "RspResOrder", new RspResOrder());
  }
  
  private boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.extraData.getString("uin"));
    if (l == 0L)
    {
      a(paramToServiceMsg);
      return false;
    }
    paramToServiceMsg = new ChangeFriendNameReq(l, paramToServiceMsg.extraData.getString("com_value"));
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("ChangeFriendName");
    paramUniPacket.put("req", paramToServiceMsg);
    return true;
  }
  
  private Object o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SyncRes)decodePacket(paramFromServiceMsg.getWupBuffer(), "SyncRes", new SyncRes());
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("sendArray");
    boolean bool1 = false;
    int j;
    boolean bool2;
    FriendsManager localFriendsManager;
    int k;
    int i;
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return false;
      }
      j = paramToServiceMsg.extraData.getInt("reqType", 0);
      bool2 = paramToServiceMsg.extraData.getBoolean("showDateNickname");
      paramToServiceMsg = new ArrayList();
      localFriendsManager = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
      k = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i < k) {
        localObject = arrayOfString[i];
      }
      try
      {
        long l2 = Long.parseLong((String)localObject);
        if (j != 1)
        {
          localObject = localFriendsManager.x((String)localObject);
          long l1;
          if (localObject != null) {
            l1 = ((ExtensionInfo)localObject).richTime;
          } else {
            l1 = 0L;
          }
          paramToServiceMsg.add(new ReqRichInfo(l2, l1));
        }
        i += 1;
      }
      catch (NumberFormatException paramToServiceMsg) {}
    }
    if (j == 1) {
      bool1 = true;
    }
    paramToServiceMsg = new GetRichSigReq(paramToServiceMsg, bool1, bool2, true);
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GetRichSig");
    paramUniPacket.put("GetRichSigReq", paramToServiceMsg);
    return true;
    return false;
    return false;
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (a(paramToServiceMsg.extraData.getString("uin")) == 0L)
    {
      a(paramToServiceMsg);
      return false;
    }
    switch (paramToServiceMsg.extraData.getInt("groupreqtype"))
    {
    default: 
      a(paramToServiceMsg);
      return false;
    case 10: 
      return t(paramToServiceMsg, paramUniPacket);
    case 9: 
      return v(paramToServiceMsg, paramUniPacket);
    case 8: 
      return u(paramToServiceMsg, paramUniPacket);
    case 7: 
      return A(paramToServiceMsg, paramUniPacket);
    case 6: 
      return z(paramToServiceMsg, paramUniPacket);
    case 5: 
      return y(paramToServiceMsg, paramUniPacket);
    case 4: 
      return x(paramToServiceMsg, paramUniPacket);
    case 3: 
      return w(paramToServiceMsg, paramUniPacket);
    case 2: 
      return s(paramToServiceMsg, paramUniPacket);
    case 1: 
      return r(paramToServiceMsg, paramUniPacket);
    }
    return q(paramToServiceMsg, paramUniPacket);
  }
  
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 0;
    localGroupMngReq.uin = l;
    localGroupMngReq.cIsSupportAuthQuestionJoin = 1;
    l = a(paramToServiceMsg.extraData.getString("troop_uin"));
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.putInt((int)l);
    localGroupMngReq.vecBody = localByteBuffer.array();
    localGroupMngReq.wSourceID = paramToServiceMsg.extraData.getInt("stat_option");
    localGroupMngReq.cIfGetAuthInfo = paramToServiceMsg.extraData.getByte("cIfGetAuthInfo");
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean r(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 1;
    localGroupMngReq.uin = l1;
    long l2 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    String str2 = paramToServiceMsg.extraData.getString("back_msg");
    int i = str2.getBytes().length;
    String str3 = paramToServiceMsg.extraData.getString("join_group_key");
    String str1 = paramToServiceMsg.extraData.getString("join_group_sig");
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("new_Member_Msg");
    String str4 = paramToServiceMsg.extraData.getString("pic_url");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 9);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.put((byte)i);
    localByteBuffer.put(str2.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    i = paramToServiceMsg.extraData.getInt("stat_option");
    localGroupMngReq.wSourceSubID = i;
    localGroupMngReq.wSourceID = 3;
    localGroupMngReq.sJoinGroupKey = str3;
    localGroupMngReq.sJoinGroupAuth = str1;
    if (!TextUtils.isEmpty(str4)) {
      localGroupMngReq.sJoinGroupPicUrl = str4;
    }
    if (arrayOfByte != null) {
      localGroupMngReq.vecJoinGroupRichMsg = arrayOfByte;
    }
    int j = paramToServiceMsg.extraData.getInt("join_group_verify_type");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("join_group_verify_token");
    if ((!TextUtils.isEmpty(paramToServiceMsg)) && ((j == 1) || (j == 2)))
    {
      localGroupMngReq.dwJoinVerifyType = j;
      localGroupMngReq.sJoinGroupVerifyToken = paramToServiceMsg;
    }
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopReport", 4, String.format("handleJoinGroup: wSourceSubID=%d troop_authSig=%s", new Object[] { Integer.valueOf(i), str1 }));
    }
    return true;
  }
  
  private boolean s(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 2;
    localGroupMngReq.uin = l1;
    long l2 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    paramToServiceMsg = ByteBuffer.allocate(8);
    paramToServiceMsg.putInt((int)l1);
    paramToServiceMsg.putInt((int)l2);
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean t(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 10;
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    localGroupMngReq.uin = l1;
    localGroupMngReq.sGroupLocation = paramToServiceMsg.extraData.getString("groupcity");
    byte b1 = paramToServiceMsg.extraData.getByte("type");
    byte b2 = paramToServiceMsg.extraData.getByte("group_ops");
    String str1 = paramToServiceMsg.extraData.getString("group_name");
    String str2 = paramToServiceMsg.extraData.getString("group_memo");
    String str3 = paramToServiceMsg.extraData.getString("group_finger_memo");
    String str4 = paramToServiceMsg.extraData.getString("group_class_text");
    int i = paramToServiceMsg.extraData.getInt("group_class");
    long l2 = paramToServiceMsg.extraData.getLong("group_discussuin");
    paramToServiceMsg = ByteBuffer.allocate(str1.getBytes().length + 19 + 2 + 1 + str2.getBytes().length + 1 + str3.getBytes().length + 1 + str4.getBytes().length);
    paramToServiceMsg.put(b1);
    paramToServiceMsg.putInt(0);
    paramToServiceMsg.putInt((int)l1);
    paramToServiceMsg.put(b2);
    paramToServiceMsg.putInt(0);
    paramToServiceMsg.putInt(i);
    paramToServiceMsg.put((byte)str1.getBytes().length);
    paramToServiceMsg.put(str1.getBytes());
    paramToServiceMsg.putShort((short)0);
    paramToServiceMsg.put((byte)str2.getBytes().length);
    paramToServiceMsg.put(str2.getBytes());
    paramToServiceMsg.put((byte)str3.getBytes().length);
    paramToServiceMsg.put(str3.getBytes());
    paramToServiceMsg.put((byte)str4.getBytes().length);
    paramToServiceMsg.put(str4.getBytes());
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    localGroupMngReq.dwDiscussUin = Long.valueOf(l2).longValue();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean u(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 8;
    localGroupMngReq.uin = l1;
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    long l2 = a(str);
    localGroupMngReq.wSourceSubID = 32;
    localGroupMngReq.wSourceID = 3;
    ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("Invite_uins");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(localArrayList.size() * 4 + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putShort((short)localArrayList.size());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localByteBuffer.putInt((int)a((String)localIterator.next()));
    }
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("inviteGroup: groupCode=");
    paramToServiceMsg.append(str);
    paramToServiceMsg.append(", uinListSize=");
    paramToServiceMsg.append(localArrayList.size());
    QLog.d("Q.troopInviteMember", 1, paramToServiceMsg.toString());
    return true;
  }
  
  private boolean v(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 9;
    localGroupMngReq.uin = l1;
    long l2 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    paramToServiceMsg = ByteBuffer.allocate(8);
    paramToServiceMsg.putInt((int)l2);
    paramToServiceMsg.putInt((int)l1);
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean w(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 3;
    localGroupMngReq.uin = l1;
    long l2 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    Object localObject = paramToServiceMsg.extraData.getStringArrayList("frie_uins");
    paramToServiceMsg = ByteBuffer.allocate(((ArrayList)localObject).size() * 4 + 8);
    paramToServiceMsg.putInt((int)l2);
    paramToServiceMsg.putInt((int)l1);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramToServiceMsg.putInt((int)a((String)((Iterator)localObject).next()));
    }
    localGroupMngReq.vecBody = paramToServiceMsg.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean x(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 4;
    localGroupMngReq.uin = l1;
    l1 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = a(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean y(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 5;
    localGroupMngReq.uin = l1;
    l1 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = a(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  private boolean z(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.extraData.getString("uin"));
    GroupMngReq localGroupMngReq = new GroupMngReq();
    localGroupMngReq.reqtype = 6;
    localGroupMngReq.uin = l1;
    l1 = a(paramToServiceMsg.extraData.getString("troop_uin"));
    long l2 = a(paramToServiceMsg.extraData.getString("Request_uin"));
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("Auth");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("back_msg");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 10 + 1 + paramToServiceMsg.getBytes().length);
    localByteBuffer.putInt((int)l1);
    localByteBuffer.putInt((int)l2);
    localByteBuffer.putShort((short)arrayOfByte.length);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.put((byte)paramToServiceMsg.getBytes().length);
    localByteBuffer.put(paramToServiceMsg.getBytes());
    localGroupMngReq.vecBody = localByteBuffer.array();
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("KQQ.ProfileService.ProfileServantObj");
    paramUniPacket.setFuncName("GroupMngReq");
    paramUniPacket.put("GroupMngReq", localGroupMngReq);
    return true;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "decodeCheckUpdateReq() ");
    }
    return (CheckUpdateResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "CheckUpdateResp", new CheckUpdateResp());
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (this.f.handleRequest(paramToServiceMsg, paramUniPacket)) {
      return true;
    }
    int i = ((Integer)this.requestHandles.get(paramToServiceMsg.getServiceCmd())).intValue();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 7)
          {
            if (i != 8)
            {
              if (i != 15)
              {
                if (i != 17)
                {
                  switch (i)
                  {
                  default: 
                    switch (i)
                    {
                    default: 
                      return false;
                    case 31: 
                      return this.e.encodeReqMsg(paramToServiceMsg, paramUniPacket);
                    case 30: 
                      return this.d.encodeReqMsg(paramToServiceMsg, paramUniPacket);
                    case 29: 
                      return h(paramToServiceMsg, paramUniPacket);
                    case 28: 
                      return g(paramToServiceMsg, paramUniPacket);
                    case 27: 
                      return f(paramToServiceMsg, paramUniPacket);
                    case 26: 
                      return e(paramToServiceMsg, paramUniPacket);
                    case 25: 
                      return b(paramToServiceMsg, paramUniPacket);
                    case 24: 
                      return c(paramToServiceMsg, paramUniPacket);
                    }
                    return d(paramToServiceMsg, paramUniPacket);
                  case 13: 
                    return j(paramToServiceMsg, paramUniPacket);
                  case 12: 
                    return k(paramToServiceMsg, paramUniPacket);
                  }
                  return l(paramToServiceMsg, paramUniPacket);
                }
                return p(paramToServiceMsg, paramUniPacket);
              }
              return i(paramToServiceMsg, paramUniPacket);
            }
            return n(paramToServiceMsg, paramUniPacket);
          }
          return m(paramToServiceMsg, paramUniPacket);
        }
        return o(paramToServiceMsg, paramUniPacket);
      }
      localObject = new ArrayList();
      Iterator localIterator = paramToServiceMsg.extraData.getStringArrayList("uinList").iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(Long.valueOf(Long.parseLong((String)localIterator.next())));
      }
      a(paramToServiceMsg, (ArrayList)localObject, paramUniPacket);
      return true;
    }
    Object localObject = paramToServiceMsg.extraData.getString("city");
    paramToServiceMsg = (ToServiceMsg)localObject;
    if (localObject == null) {
      paramToServiceMsg = "";
    }
    a(paramToServiceMsg, paramUniPacket);
    return true;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = this.f.handleDecode(paramToServiceMsg, paramFromServiceMsg);
    if (localObject != null) {
      return localObject;
    }
    localObject = (Integer)this.requestHandles.get(paramFromServiceMsg.getServiceCmd());
    int i;
    if (localObject != null) {
      i = ((Integer)localObject).intValue();
    } else {
      i = -1;
    }
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 7)
        {
          if (i != 8)
          {
            if (i != 12)
            {
              if (i != 13)
              {
                if (i != 15) {
                  switch (i)
                  {
                  default: 
                    break;
                  case 31: 
                    return this.e.decode(paramToServiceMsg, paramFromServiceMsg);
                  case 30: 
                    return this.d.decode(paramToServiceMsg, paramFromServiceMsg);
                  case 29: 
                    return e(paramToServiceMsg, paramFromServiceMsg);
                  case 28: 
                    return d(paramToServiceMsg, paramFromServiceMsg);
                  case 27: 
                    return c(paramToServiceMsg, paramFromServiceMsg);
                  case 26: 
                    return b(paramToServiceMsg, paramFromServiceMsg);
                  case 25: 
                    return m(paramToServiceMsg, paramFromServiceMsg);
                  case 24: 
                    return n(paramToServiceMsg, paramFromServiceMsg);
                  case 23: 
                    return a(paramToServiceMsg, paramFromServiceMsg);
                  case 22: 
                    return o(paramToServiceMsg, paramFromServiceMsg);
                  }
                } else {
                  return f(paramToServiceMsg, paramFromServiceMsg);
                }
              }
              else {
                return l(paramToServiceMsg, paramFromServiceMsg);
              }
            }
            else {
              g(paramToServiceMsg, paramFromServiceMsg);
            }
            return null;
          }
          return i(paramToServiceMsg, paramFromServiceMsg);
        }
        return h(paramToServiceMsg, paramFromServiceMsg);
      }
      return j(paramToServiceMsg, paramFromServiceMsg);
    }
    return k(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void destroy() {}
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return a(paramToServiceMsg, paramUniPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.profile.ProfileService
 * JD-Core Version:    0.7.0.1
 */