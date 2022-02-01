package com.tencent.mobileqq.troop.troopphoto.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.troopphoto.api.ITroopPhotoHandler;
import com.tencent.mobileqq.troop.troopphoto.api.TroopPhotoObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class TroopPhotoHandler
  extends TroopBaseHandler
  implements ITroopPhotoHandler
{
  public TroopPhotoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    paramString = new TroopPhotoHandler.1(this, paramString, paramBoolean);
    this.appRuntime.addDefaultObservers(paramString);
  }
  
  protected String a()
  {
    return "TroopPhotoHandler";
  }
  
  public void a(String paramString)
  {
    a(paramString, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    b(paramString, paramBoolean);
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.uint32_app_privilege_flag.set(0);
    ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.appRuntime.getBusinessHandler(TroopInfoHandler.class.getName());
    try
    {
      localITroopInfoHandler.a(Long.valueOf(Long.parseLong(paramString)), localGroupInfo, "SUBCMD_GET_PRIVILEGE");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = (TroopInfo)this.appRuntime.getEntityManagerFactory().createEntityManager().find(TroopInfo.class, paramString);
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PrivilegeFlag:");
      localStringBuilder.append(((TroopInfo)localObject).troopPrivilegeFlag);
      QLog.d("TroopPhotoHandler", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("troop.isAdmin:");
      localStringBuilder.append(((TroopInfo)localObject).isAdmin());
      QLog.d("TroopPhotoHandler", 2, localStringBuilder.toString());
    }
    int i;
    if ((localObject != null) && ((((TroopInfo)localObject).troopPrivilegeFlag & 1L) == 1L) && (!((TroopInfo)localObject).isAdmin())) {
      i = 0;
    } else {
      i = 1;
    }
    long l = Long.valueOf(this.appRuntime.getCurrentAccountUin()).longValue();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.appRuntime.getCurrentAccountUin());
    ((StringBuilder)localObject).append("__qzone_pic_permission__");
    ((StringBuilder)localObject).append(paramString);
    if (i != LocalMultiProcConfig.getInt4Uin(((StringBuilder)localObject).toString(), -1, l))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.appRuntime.getCurrentAccountUin());
      ((StringBuilder)localObject).append("__qzone_pic_permission__");
      ((StringBuilder)localObject).append(paramString);
      LocalMultiProcConfig.putInt4Uin(((StringBuilder)localObject).toString(), i, l);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopPhotoObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopphoto.api.impl.TroopPhotoHandler
 * JD-Core Version:    0.7.0.1
 */