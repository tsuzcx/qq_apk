package com.tencent.mobileqq.vipav;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewTempUtil;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.funcall.VipFunCallAndRing.TGroupInfo;
import com.tencent.pb.funcall.VipFunCallAndRing.TSourceInfo;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x1Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x1Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x2Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x3Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x5Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x5Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoReq;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoRsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TUserInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class VipSetFunCallHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public VipSetFunCallHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private int a(VipFunCallAndRing.TSsoReq paramTSsoReq)
  {
    if (paramTSsoReq.i32_cmd.has()) {
      return paramTSsoReq.i32_cmd.get();
    }
    return -1;
  }
  
  private int a(VipFunCallAndRing.TSsoReq paramTSsoReq, int paramInt, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("srcType", paramInt);
    int i = paramBundle.getInt("callId");
    int j = paramBundle.getInt("ringId");
    if (i == 0)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("sendReqToSVR Error 3 callId=");
      paramBundle.append(i);
      QLog.d("VipSetFunCallHandler", 1, paramBundle.toString());
    }
    paramBundle = new VipFunCallAndRing.TSsoCmd0x3Req();
    paramBundle.i32_funcall_id.set(i);
    paramBundle.i32_ring_id.set(j);
    paramTSsoReq.st_cmd0x3_req.set(paramBundle);
    return paramInt;
  }
  
  private void a(int paramInt, VipFunCallAndRing.TSsoRsp paramTSsoRsp, String paramString, IVipFunCallManager paramIVipFunCallManager)
  {
    if (paramInt == 0)
    {
      Object localObject1 = (VipFunCallAndRing.TSsoCmd0x1Rsp)paramTSsoRsp.st_cmd0x1_rsp.get();
      long l = ((VipFunCallAndRing.TSsoCmd0x1Rsp)localObject1).u64_server_ver.get();
      paramTSsoRsp = VipFunCallUtil.a(this.a, 1, null);
      if (paramTSsoRsp.getLong("local_version", 0L) == l)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipSetFunCallHandler", 2, "onReceive localVer == ver.");
        }
        return;
      }
      localObject1 = (VipFunCallAndRing.TUserInfo)((VipFunCallAndRing.TSsoCmd0x1Rsp)localObject1).st_User_Info.get();
      paramTSsoRsp.edit().putLong("local_version", l).apply();
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onReceive~ localVer=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", ver=");
        ((StringBuilder)localObject2).append(l);
        QLog.d("VipSetFunCallHandler", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 != null)
      {
        paramString = this.a;
        paramIVipFunCallManager.setFunCallData(paramString, 0, paramString.getAccount(), ((VipFunCallAndRing.TUserInfo)localObject1).i32_common_id.get(), ((VipFunCallAndRing.TUserInfo)localObject1).i32_ring_id.get(), null, l);
        paramString = (VipFunCallAndRing.TSourceInfo)((VipFunCallAndRing.TUserInfo)localObject1).st_src_info.get();
        VipFunCallManager.a(this.a, ((VipFunCallAndRing.TUserInfo)localObject1).i32_common_id.get(), null, paramString, true);
        paramString = ((VipFunCallAndRing.TUserInfo)localObject1).rpt_user_groups.get();
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramTSsoRsp.edit().putString("group", "").commit();
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (VipFunCallAndRing.TGroupInfo)paramString.next();
            paramIVipFunCallManager.setFunCallData(this.a, 1, null, ((VipFunCallAndRing.TGroupInfo)localObject2).i32_group_id.get(), ((VipFunCallAndRing.TGroupInfo)localObject2).i32_ring_id.get(), ((VipFunCallAndRing.TGroupInfo)localObject2).u64_group_uins.get(), 0L);
            VipFunCallAndRing.TSourceInfo localTSourceInfo = (VipFunCallAndRing.TSourceInfo)((VipFunCallAndRing.TGroupInfo)localObject2).st_src_info.get();
            VipFunCallManager.a(this.a, ((VipFunCallAndRing.TGroupInfo)localObject2).i32_group_id.get(), null, localTSourceInfo, true);
          }
        }
        if (VipFunCallUtil.b()) {
          paramIVipFunCallManager.downloadFCSuit(((VipFunCallAndRing.TUserInfo)localObject1).i32_common_id.get(), ((VipFunCallAndRing.TUserInfo)localObject1).i32_ring_id.get(), false, 0, null);
        }
      }
      paramTSsoRsp.edit().putLong("update_time", System.currentTimeMillis()).commit();
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (!TextUtils.isEmpty(paramString)))
    {
      FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      ExtensionInfo localExtensionInfo2 = localFriendsManager.x(paramString);
      ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
      if (localExtensionInfo2 == null)
      {
        localExtensionInfo1 = new ExtensionInfo();
        localExtensionInfo1.uin = paramString;
      }
      long l = paramInt;
      localExtensionInfo1.colorRingId = l;
      localExtensionInfo1.commingRingId = l;
      localFriendsManager.a(localExtensionInfo1);
    }
  }
  
  private void a(VipFunCallAndRing.TSsoReq paramTSsoReq, int paramInt1, Bundle paramBundle, int paramInt2, VipFunCallAndRing.TSsoRsp paramTSsoRsp, IVipFunCallManager paramIVipFunCallManager)
  {
    paramTSsoReq = (VipFunCallAndRing.TSsoCmd0x4Req)paramTSsoReq.st_cmd0x4_req.get();
    paramBundle.putInt("callId", paramTSsoReq.i32_funcall_id.get());
    if (paramInt2 == 0)
    {
      paramBundle = (VipFunCallAndRing.TSsoCmd0x4Rsp)paramTSsoRsp.st_cmd0x4_rsp.get();
      paramIVipFunCallManager.setFunCallData(this.a, 1, null, paramTSsoReq.i32_funcall_id.get(), paramTSsoReq.i32_ring_id.get(), paramTSsoReq.rpt_uins.get(), 0L);
    }
    if (1 == paramInt1)
    {
      paramBundle = this.a;
      paramInt1 = paramTSsoReq.i32_funcall_id.get();
      if (paramInt2 == 0) {
        paramTSsoReq = "0";
      } else {
        paramTSsoReq = "1";
      }
      VasWebviewTempUtil.reportVASTo00145(paramBundle, String.valueOf(paramInt1), "preview", "SetGroupCall", paramTSsoReq, new String[0]);
    }
  }
  
  private void a(VipFunCallAndRing.TSsoReq paramTSsoReq, int paramInt, VipFunCallAndRing.TSsoRsp paramTSsoRsp, IVipFunCallManager paramIVipFunCallManager)
  {
    if (paramInt == 0)
    {
      paramTSsoRsp = (VipFunCallAndRing.TSsoCmd0x5Rsp)paramTSsoRsp.st_cmd0x5_rsp.get();
      paramTSsoReq = (VipFunCallAndRing.TSsoCmd0x5Req)paramTSsoReq.st_cmd0x5_req.get();
      paramIVipFunCallManager.setFunCallData(this.a, 2, null, paramTSsoReq.i32_funcall_id.get(), 0, null, 0L);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive~ isSuccess=false ,data=");
    localStringBuilder.append(PkgTools.toHexStr(paramArrayOfByte));
    localStringBuilder.append(", funcType=");
    localStringBuilder.append(paramInt1);
    QLog.e("VipSetFunCallHandler", 1, localStringBuilder.toString());
    ReportCenter.a().a("FunCallSvr.call", 100, paramFromServiceMsg.getBusinessFailCode(), this.a.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131913698), true);
    paramBundle.putInt("result", paramInt2);
    notifyUI(paramInt1, false, paramBundle);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      if (paramInt2 == 0)
      {
        localQQAppInterface = this.a;
        VipFunCallUtil.a(localQQAppInterface, paramString, 2, localQQAppInterface.getAccount(), paramInt1);
        return;
      }
      QQAppInterface localQQAppInterface = this.a;
      VipFunCallUtil.a(localQQAppInterface, paramString, 1, localQQAppInterface.getAccount(), paramInt1);
    }
  }
  
  private void a(boolean paramBoolean, VipFunCallAndRing.TSsoReq paramTSsoReq)
  {
    VipFunCallAndRing.TSsoCmd0x1Req localTSsoCmd0x1Req = new VipFunCallAndRing.TSsoCmd0x1Req();
    long l = 0L;
    if (!paramBoolean) {
      l = VipFunCallUtil.a(this.a, 1, null).getLong("local_version", 0L);
    }
    localTSsoCmd0x1Req.u64_local_ver.set(l);
    paramTSsoReq.st_cmd0x1_req.set(localTSsoCmd0x1Req);
  }
  
  private boolean a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    return (paramFromServiceMsg.isSuccess()) && (paramObject != null);
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    VipFunCallAndRing.TSsoReq localTSsoReq = new VipFunCallAndRing.TSsoReq();
    localTSsoReq.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
    int j = a(localTSsoReq);
    int i = paramToServiceMsg.extraData.getInt("srcType", 0);
    int m = paramToServiceMsg.extraData.getInt("from");
    Bundle localBundle = new Bundle();
    localBundle.putInt("srcType", i);
    if (!a(paramFromServiceMsg, paramObject))
    {
      a(paramFromServiceMsg, (byte[])paramObject, j, localBundle, -1);
      return true;
    }
    paramToServiceMsg = new VipFunCallAndRing.TSsoRsp();
    paramToServiceMsg.mergeFrom((byte[])paramObject);
    int k = paramToServiceMsg.i32_ret.get();
    paramFromServiceMsg = paramToServiceMsg.str_msg.get();
    paramObject = paramToServiceMsg.str_url.get();
    String str = paramToServiceMsg.str_act_wording.get();
    localBundle.putInt("result", k);
    IVipFunCallManager localIVipFunCallManager = VasUtil.a().getFunCallManager();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VipSetFunCallHandler onReceive~ ret=");
      localStringBuilder.append(k);
      localStringBuilder.append(",msg=");
      localStringBuilder.append(paramFromServiceMsg);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", funcType=");
      localStringBuilder.append(j);
      localStringBuilder.append(", srcType=");
      localStringBuilder.append(i);
      localStringBuilder.append(", actStr=");
      localStringBuilder.append(str);
      QLog.d("VipSetFunCallHandler", 2, localStringBuilder.toString());
    }
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            if (j != 5)
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("sendReqToSVR Error funcType=");
              paramToServiceMsg.append(j);
              QLog.e("VipSetFunCallHandler", 1, paramToServiceMsg.toString());
            }
          }
          for (;;)
          {
            break;
            a(localTSsoReq, k, paramToServiceMsg, localIVipFunCallManager);
            continue;
            a(localTSsoReq, m, localBundle, k, paramToServiceMsg, localIVipFunCallManager);
          }
        }
        paramToServiceMsg = new VipSetFunCallHandler.HandleMyDefaultFC(this, localTSsoReq, m, localBundle, k, paramToServiceMsg, localIVipFunCallManager, -1, null).c();
        i = paramToServiceMsg.a();
        paramToServiceMsg = paramToServiceMsg.b();
      }
      else
      {
        paramToServiceMsg = new VipSetFunCallHandler.HandleFriiendFC(this, localTSsoReq, localBundle, k, paramToServiceMsg, localIVipFunCallManager, -1, null).c();
        i = paramToServiceMsg.a();
        paramToServiceMsg = paramToServiceMsg.b();
      }
    }
    else
    {
      a(k, paramToServiceMsg, paramFromServiceMsg, localIVipFunCallManager);
      paramToServiceMsg = null;
      i = -1;
    }
    localBundle.putString("message", paramFromServiceMsg);
    localBundle.putString("svr_url", paramObject);
    localBundle.putString("svr_actStr", str);
    boolean bool;
    if (k == 0) {
      bool = true;
    } else {
      bool = false;
    }
    notifyUI(j, bool, localBundle);
    a(i, paramToServiceMsg);
    return false;
  }
  
  @Nullable
  private Bundle b(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof Bundle)) {
      paramObject = (Bundle)paramObject;
    } else {
      paramObject = null;
    }
    if (paramObject == null)
    {
      if ((2 != paramInt) && (3 != paramInt) && (5 != paramInt)) {
        return new Bundle();
      }
      paramObject = new StringBuilder();
      paramObject.append("sendReqToSVR Error fcBundle==null funcType=");
      paramObject.append(paramInt);
      QLog.e("VipSetFunCallHandler", 1, paramObject.toString());
      return null;
    }
    return paramObject;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    a(paramInt, paramObject, false);
  }
  
  public void a(int paramInt, Object paramObject, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("FunCallSvr.call");
    VipFunCallAndRing.TSsoReq localTSsoReq = new VipFunCallAndRing.TSsoReq();
    localTSsoReq.i32_implat.set(109);
    localTSsoReq.i32_cmd.set(paramInt);
    localTSsoReq.str_qq_ver.set("8.8.17");
    Object localObject = b(paramInt, paramObject);
    if (localObject == null) {
      return;
    }
    int j = ((Bundle)localObject).getInt("from");
    int i = 0;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              paramObject = new StringBuilder();
              paramObject.append("sendReqToSVR Error funcType=");
              paramObject.append(paramInt);
              QLog.e("VipSetFunCallHandler", 1, paramObject.toString());
              return;
            }
            paramObject = new VipFunCallAndRing.TSsoCmd0x5Req();
            i = ((Bundle)localObject).getInt("srcType", 0);
            int k = ((Bundle)localObject).getInt("callId");
            if (k == 0)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("sendReqToSVR Error 5 callId5=");
              ((StringBuilder)localObject).append(k);
              QLog.e("VipSetFunCallHandler", 1, ((StringBuilder)localObject).toString());
            }
            paramObject.i32_funcall_id.set(k);
            localTSsoReq.st_cmd0x5_req.set(paramObject);
          }
          else
          {
            paramObject = (VipFunCallAndRing.TSsoCmd0x4Req)paramObject;
            localTSsoReq.st_cmd0x4_req.set(paramObject);
            j = 1;
          }
        }
        else {
          i = a(localTSsoReq, 0, (Bundle)localObject);
        }
      }
      else
      {
        paramObject = new VipFunCallAndRing.TSsoCmd0x2Req();
        paramObject.u64_friend_uin.set(((Bundle)localObject).getLong("uin"));
        paramObject.str_friend_phone.set(((Bundle)localObject).getString("phone"));
        localTSsoReq.st_cmd0x2_req.set(paramObject);
      }
    }
    else {
      a(paramBoolean, localTSsoReq);
    }
    localTSsoReq.setHasFlag(true);
    localToServiceMsg.extraData.putInt("srcType", i);
    localToServiceMsg.extraData.putInt("from", j);
    localToServiceMsg.putWupBuffer(localTSsoReq.toByteArray());
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("sendReqToSVR funcType=");
      paramObject.append(paramInt);
      paramObject.append(", srcType:");
      paramObject.append(i);
      QLog.d("VipSetFunCallHandler", 2, paramObject.toString());
    }
    super.sendPbReq(localToServiceMsg);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return VipFunCallObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"FunCallSvr.call".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    try
    {
      boolean bool = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (bool) {}
    }
    catch (Exception paramToServiceMsg)
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onReceive prb.mergeFrom error: ");
      paramFromServiceMsg.append(paramToServiceMsg.getMessage());
      QLog.e("VipSetFunCallHandler", 2, paramFromServiceMsg.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipSetFunCallHandler
 * JD-Core Version:    0.7.0.1
 */