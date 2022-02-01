package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.KickResult;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopMemberMngHandler
  extends TroopBaseHandler
  implements ITroopMemberMngHandler
{
  protected Set<String> a;
  
  public TroopMemberMngHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramString = Integer.valueOf(3);
    Object localObject;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramToServiceMsg.extraData.getLong("troopUin"));
      ((StringBuilder)localObject).append("");
      paramToServiceMsg = ((StringBuilder)localObject).toString();
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(TroopObserver.TYPE_DEL_TROOP_MEMBER, false, new Object[] { paramString, null, paramToServiceMsg });
        return;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    label413:
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
        paramObject = new oidb_0x8a0.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      int i;
      label215:
      break label463;
    }
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramObject = paramObject.rpt_msg_kick_result.get();
      paramFromServiceMsg = new ArrayList();
      paramObject = paramObject.iterator();
      i = 0;
      if (paramObject.hasNext())
      {
        localObject = (oidb_0x8a0.KickResult)paramObject.next();
        if (((oidb_0x8a0.KickResult)localObject).opt_uint32_result.get() == 0)
        {
          paramFromServiceMsg.add(Long.toString(((oidb_0x8a0.KickResult)localObject).opt_uint64_member_uin.get()));
          break label215;
        }
        if (((oidb_0x8a0.KickResult)localObject).opt_uint32_result.get() != 2) {
          break label215;
        }
        i = 1;
        break label215;
      }
      if (paramFromServiceMsg.size() > 0)
      {
        paramObject = (ITroopMemberInfoService)this.appRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
        localObject = paramFromServiceMsg.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramObject.deleteTroopMember(paramToServiceMsg, (String)((Iterator)localObject).next());
        }
        notifyUI(TroopObserver.TYPE_DEL_TROOP_MEMBER, true, new Object[] { Integer.valueOf(1), paramFromServiceMsg, paramToServiceMsg });
        return;
      }
      if (i == 0) {
        break label437;
      }
      notifyUI(TroopObserver.TYPE_DEL_TROOP_MEMBER, false, new Object[] { Integer.valueOf(2), null, paramToServiceMsg });
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label413;
    }
    notifyUI(TroopObserver.TYPE_DEL_TROOP_MEMBER, false, new Object[] { paramString, null, paramToServiceMsg });
    label437:
    return;
    notifyUI(TroopObserver.TYPE_DEL_TROOP_MEMBER, false, new Object[] { paramString, null, paramToServiceMsg });
    return;
    label463:
    notifyUI(TroopObserver.TYPE_DEL_TROOP_MEMBER, false, new Object[] { paramString, null, paramToServiceMsg });
    return;
    notifyUI(TroopObserver.TYPE_DEL_TROOP_MEMBER, false, new Object[] { paramString, null, "" });
  }
  
  protected String a()
  {
    return "TroopMemberMngHandler";
  }
  
  public void a(long paramLong, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0x8a0_0");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopMemberMngHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopMemberMngHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x8a0_0".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramFromServiceMsg.getServiceCmd(), paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberMngHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopMemberMngHandler
 * JD-Core Version:    0.7.0.1
 */