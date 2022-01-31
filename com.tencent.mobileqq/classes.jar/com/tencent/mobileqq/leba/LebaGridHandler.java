package com.tencent.mobileqq.leba;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.header.LebaPluginInfoObserver;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.DynamicList.DynamicList.SubCmd_DynamicItem_Req;
import tencent.im.DynamicList.DynamicList.SubCmd_DynamicItem_Resp;
import tencent.im.DynamicList.DynamicList.SubCmd_DynamicList_ReqInfo;
import tencent.im.DynamicList.DynamicList.SubCmd_DynamicList_RespInfo;

public class LebaGridHandler
  extends BusinessHandler
{
  int jdField_a_of_type_Int = 0;
  public long a;
  private LebaGridManager jdField_a_of_type_ComTencentMobileqqLebaLebaGridManager;
  boolean jdField_a_of_type_Boolean = false;
  
  public LebaGridHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaGridManager = ((LebaGridManager)paramQQAppInterface.getManager(211));
  }
  
  private void a(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebanew", 2, "reqPluginList|pluginIds:" + paramArrayList + ",isReqAll:" + paramBoolean1);
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    if (paramBoolean1) {}
    DynamicList.SubCmd_DynamicList_ReqInfo localSubCmd_DynamicList_ReqInfo;
    ArrayList localArrayList;
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaLebaGridManager.a(2);; localObject = this.jdField_a_of_type_ComTencentMobileqqLebaLebaGridManager.a(paramArrayList))
    {
      localSubCmd_DynamicList_ReqInfo = new DynamicList.SubCmd_DynamicList_ReqInfo();
      localArrayList = new ArrayList();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PluginInfo localPluginInfo = (PluginInfo)((Iterator)localObject).next();
        DynamicList.SubCmd_DynamicItem_Req localSubCmd_DynamicItem_Req = new DynamicList.SubCmd_DynamicItem_Req();
        localSubCmd_DynamicItem_Req.uiPluginID.set(localPluginInfo.pluginId);
        localSubCmd_DynamicItem_Req.uiNewVer.set(localPluginInfo.version);
        localSubCmd_DynamicItem_Req.uiOpenFlag.set(localPluginInfo.openFlag);
        localArrayList.add(localSubCmd_DynamicItem_Req);
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebanew", 2, "reqPluginList add plugin:" + localPluginInfo.pluginId);
        }
      }
    }
    QLog.d("Q.lebanew", 1, "reqPluginList local plugin is empty!");
    localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "DynamicList.getlist");
    localSubCmd_DynamicList_ReqInfo.SubCmd_Req.set(localArrayList);
    localSubCmd_DynamicList_ReqInfo.isGrayVer.set(false);
    ((ToServiceMsg)localObject).putWupBuffer(localSubCmd_DynamicList_ReqInfo.toByteArray());
    ((ToServiceMsg)localObject).extraData.putIntegerArrayList("pluginIds", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putBoolean("isReqAll", paramBoolean1);
    ((ToServiceMsg)localObject).extraData.putBoolean("reqFeeds", paramBoolean2);
    b((ToServiceMsg)localObject);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    ArrayList localArrayList2;
    Object localObject;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label453;
      }
      ArrayList localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      paramToServiceMsg = new ArrayList();
      localObject = new DynamicList.SubCmd_DynamicList_RespInfo();
      try
      {
        paramObject = (DynamicList.SubCmd_DynamicList_RespInfo)((DynamicList.SubCmd_DynamicList_RespInfo)localObject).mergeFrom((byte[])paramObject);
        if (!paramObject.SubCmd_Resp_Add.has()) {
          break label344;
        }
        localObject = paramObject.SubCmd_Resp_Add.get();
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break label344;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList1.add(PluginInfo.covertFromResp((DynamicList.SubCmd_DynamicItem_Resp)((Iterator)localObject).next()));
        }
        if (!bool) {
          break label282;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        QLog.d("Q.lebanew", 1, "handleGetPlugins exp:" + paramObject.toString());
        bool = false;
      }
      paramObject = (LebaGridManager)this.b.getManager(211);
      paramObject.a(localArrayList1);
      paramObject.a(localArrayList2);
      paramObject.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebanew", 2, "" + localArrayList1.size() + "," + localArrayList2.size() + "," + paramToServiceMsg.size());
      }
    }
    label282:
    label305:
    label450:
    label453:
    for (;;)
    {
      a(0, bool, null);
      int i;
      if (!bool)
      {
        if (paramFromServiceMsg != null)
        {
          i = paramFromServiceMsg.getResultCode();
          QLog.d("Q.lebanew", 1, "reqPlugins failed resultCode:" + i);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        return;
        bool = false;
        break;
        label344:
        if (paramObject.SubCmd_Resp_Modify.has())
        {
          localObject = paramObject.SubCmd_Resp_Modify.get();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              localArrayList2.add(PluginInfo.covertFromResp((DynamicList.SubCmd_DynamicItem_Resp)((Iterator)localObject).next()));
            }
          }
        }
        if (!paramObject.SubCmd_Resp_Delete.has()) {
          break label450;
        }
        paramObject = paramObject.SubCmd_Resp_Delete.get();
        paramToServiceMsg = paramObject;
      }
      for (;;)
      {
        break;
        i = -1;
        break label305;
      }
    }
  }
  
  protected Class a()
  {
    return LebaPluginInfoObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("raymondguo", 2, "handleGetPlugins");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      QLog.d("Q.lebanew", 1, "req or res is null");
    }
    while (!"DynamicList.getlist".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void b()
  {
    a(null, true, true);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      b();
      this.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaGridHandler
 * JD-Core Version:    0.7.0.1
 */