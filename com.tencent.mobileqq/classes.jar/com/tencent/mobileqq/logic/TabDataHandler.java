package com.tencent.mobileqq.logic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.ITabDataUtil;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.automator.AutomatorHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pb.UserDynamicTab.GetTabListRequest;
import com.tencent.mobileqq.pb.UserDynamicTab.GetTabListResponse;
import com.tencent.mobileqq.pb.UserDynamicTab.SetTabListRequest;
import com.tencent.mobileqq.pb.UserDynamicTab.SetTabListResponse;
import com.tencent.mobileqq.pb.UserDynamicTab.TabData;
import com.tencent.mobileqq.service.Cmd2HandlerMapHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class TabDataHandler
  extends BusinessHandler
{
  protected static final String[] a = { TabDataHandler.class.getName() };
  protected AppInterface b;
  private ITabDataUtil c;
  private TabDataHandler.LoadTabDataRunnable d;
  
  protected TabDataHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.b = paramAppInterface;
    try
    {
      this.c = ((ITabDataUtil)((Class)TabDataUtil.a.get(0)).newInstance());
      return;
    }
    catch (Exception paramAppInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TabDataUtil init e:");
      localStringBuilder.append(paramAppInterface);
      QLog.i("TabDataHandler", 1, localStringBuilder.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, UserDynamicTab.GetTabListResponse paramGetTabListResponse)
  {
    String str = paramToServiceMsg.extraData.getString("uin", "");
    if (TextUtils.isEmpty(str))
    {
      QLog.i("TabDataHandler", 1, "handleGetTabListSucc error uin isEmpty");
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if ((paramGetTabListResponse.sequence.get() != 0L) && (paramGetTabListResponse.tab_data.size() > 0))
    {
      TabDataHelper.updateTabSwitchFull(localBaseApplication, str, paramGetTabListResponse.tab_data.get());
      TabDataHelper.updateSequence(localBaseApplication, str, paramGetTabListResponse.sequence.get());
    }
    if (paramGetTabListResponse.model_rule.size() > 0) {
      TabDataHelper.updateTabRuleList(localBaseApplication, str, paramGetTabListResponse.model_rule.get());
    }
    TabDataHelper.updateRIJAndQCircleMutual(this.b, str, localBaseApplication);
    paramGetTabListResponse = this.c;
    if (paramGetTabListResponse != null) {
      paramGetTabListResponse.a(TabDataHelper.isExtendTabShow(localBaseApplication, str, "RIJ"));
    }
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("KeyNeedUIRefresh", Boolean.valueOf(false))).booleanValue();
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleGetTabListSucc needUIRefresh: ");
    paramToServiceMsg.append(bool);
    QLog.i("TabDataHandler", 1, paramToServiceMsg.toString());
    if (bool) {
      notifyUI(0, true, null);
    }
  }
  
  private void a(AppRuntime paramAppRuntime, ToServiceMsg paramToServiceMsg, UserDynamicTab.SetTabListResponse paramSetTabListResponse, boolean paramBoolean)
  {
    if (paramAppRuntime == null)
    {
      QLog.i("TabDataHandler", 1, "handleSetTabList app == null");
      return;
    }
    paramAppRuntime = paramToServiceMsg.extraData.getString("uin", "");
    boolean bool = paramToServiceMsg.extraData.getBoolean("KeyRetry", false);
    paramSetTabListResponse = paramToServiceMsg.extraData.getStringArrayList("KeyRetryTabList");
    if ((!TextUtils.isEmpty(paramAppRuntime)) && (paramSetTabListResponse != null) && (!paramSetTabListResponse.isEmpty()))
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (paramBoolean)
      {
        HashMap localHashMap = new HashMap();
        Iterator localIterator = paramSetTabListResponse.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          int i;
          if (paramToServiceMsg.extraData.getBoolean(str, false)) {
            i = 2;
          } else {
            i = 3;
          }
          localHashMap.put(str, Integer.valueOf(i));
        }
        TabDataHelper.updateTabSwitchIncremental(localBaseApplication, paramAppRuntime, localHashMap);
        TabDataHelper.clearTabLocalSwitch(localBaseApplication, paramAppRuntime, paramSetTabListResponse);
      }
      if (bool) {
        a(true);
      }
      return;
    }
    QLog.i("TabDataHandler", 1, "handleSetTabList error");
  }
  
  public void a()
  {
    if (this.d == null) {
      this.d = new TabDataHandler.LoadTabDataRunnable(this);
    }
    ThreadManager.excute(this.d, 160, null, true);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    UserDynamicTab.GetTabListResponse localGetTabListResponse = new UserDynamicTab.GetTabListResponse();
    StringBuilder localStringBuilder = new StringBuilder("handleGetTabListNet ");
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      if (!paramFromServiceMsg.isSuccess())
      {
        localStringBuilder.append(",resultCode=");
        localStringBuilder.append(paramFromServiceMsg.getResultCode());
        localStringBuilder.append(",RequestSsoSeq=");
        localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
        paramFromServiceMsg = localGetTabListResponse;
        bool1 = bool2;
      }
      else
      {
        try
        {
          paramFromServiceMsg = (UserDynamicTab.GetTabListResponse)localGetTabListResponse.mergeFrom((byte[])paramObject);
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.i("TabDataHandler", 1, "handleGetTabListNet", paramFromServiceMsg);
          paramFromServiceMsg = localGetTabListResponse;
        }
        if (paramFromServiceMsg.reson_code.get() == 0) {
          bool1 = true;
        }
        localStringBuilder.append(",reson_code=");
        localStringBuilder.append(paramFromServiceMsg.reson_code.get());
        localStringBuilder.append(",sequence=");
        localStringBuilder.append(paramFromServiceMsg.sequence.get());
        localStringBuilder.append(",tab_data=");
        localStringBuilder.append(paramFromServiceMsg.tab_data.size());
        localStringBuilder.append(",model_rule=");
        localStringBuilder.append(paramFromServiceMsg.model_rule.size());
      }
    }
    else
    {
      localStringBuilder.append("res == null || data == null ");
      bool1 = bool2;
      paramFromServiceMsg = localGetTabListResponse;
    }
    localStringBuilder.append(",isSuc=");
    localStringBuilder.append(bool1);
    if (bool1) {
      a(paramToServiceMsg, paramFromServiceMsg);
    }
    QLog.i("TabDataHandler", 1, localStringBuilder.toString());
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.b == null)
    {
      QLog.i("TabDataHandler", 1, "setTabList app == null");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("TabDataHandler", 1, "setTabList tabName isEmpty");
      return;
    }
    HashMap localHashMap = new HashMap();
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 3;
    }
    localHashMap.put(paramString, Integer.valueOf(i));
    TabDataHelper.updateTabLocalSwitch(BaseApplication.getContext(), this.b.getCurrentAccountUin(), localHashMap);
    localHashMap = new HashMap();
    localHashMap.put(paramString, Boolean.valueOf(paramBoolean));
    a(localHashMap, false);
  }
  
  public void a(Map<String, Boolean> paramMap)
  {
    if (this.b == null)
    {
      QLog.i("TabDataHandler", 1, "setTabListBatch app == null");
      return;
    }
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (Boolean)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str)) && (localObject != null))
        {
          int i;
          if (((Boolean)localObject).booleanValue()) {
            i = 2;
          } else {
            i = 3;
          }
          localHashMap.put(str, Integer.valueOf(i));
        }
      }
      TabDataHelper.updateTabLocalSwitch(BaseApplication.getContext(), this.b.getCurrentAccountUin(), localHashMap);
      a(paramMap, false);
      return;
    }
    QLog.i("TabDataHandler", 1, "setTabListBatch tabSwitchMap isEmpty");
  }
  
  public void a(Map<String, Boolean> paramMap, boolean paramBoolean)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      String str1 = this.b.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder("setTabList uin=");
      localStringBuilder.append(StringUtil.getSimpleUinForPrint(str1));
      localStringBuilder.append(",isFromRetry=");
      localStringBuilder.append(paramBoolean);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", str1, "trpc.qq_tab.user_dynamic_tab.UserDynamicTab.SetTabList");
      UserDynamicTab.SetTabListRequest localSetTabListRequest = new UserDynamicTab.SetTabListRequest();
      localSetTabListRequest.from_type.set(1);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str2 = (String)((Map.Entry)localObject).getKey();
        localObject = (Boolean)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str2)) && (localObject != null))
        {
          localStringBuilder.append(",tabName=");
          localStringBuilder.append(str2);
          localStringBuilder.append(",isOpen=");
          localStringBuilder.append(localObject);
          UserDynamicTab.TabData localTabData = new UserDynamicTab.TabData();
          localTabData.tab_id.set(TabDataHelper.getTabId(str2));
          PBEnumField localPBEnumField = localTabData.tab_status;
          int i;
          if (((Boolean)localObject).booleanValue()) {
            i = 1;
          } else {
            i = 2;
          }
          localPBEnumField.set(i);
          localArrayList1.add(localTabData);
          localArrayList2.add(str2);
          localToServiceMsg.extraData.putBoolean(str2, ((Boolean)localObject).booleanValue());
        }
      }
      localSetTabListRequest.tab_data.addAll(localArrayList1);
      localToServiceMsg.putWupBuffer(localSetTabListRequest.toByteArray());
      localToServiceMsg.extraData.putString("uin", str1);
      localToServiceMsg.extraData.putBoolean("KeyRetry", paramBoolean);
      localToServiceMsg.extraData.putStringArrayList("KeyRetryTabList", localArrayList2);
      sendPbReq(localToServiceMsg);
      QLog.i("TabDataHandler", 1, localStringBuilder.toString());
      return;
    }
    QLog.i("TabDataHandler", 1, "retrySetTabList switchMap isEmpty");
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      QLog.i("TabDataHandler", 1, "getPluginSettingNet app == null");
      return;
    }
    String str4 = ((AppInterface)localObject).getCurrentAccountUin();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", str4, "trpc.qq_tab.user_dynamic_tab.UserDynamicTab.GetTabList");
    UserDynamicTab.GetTabListRequest localGetTabListRequest = new UserDynamicTab.GetTabListRequest();
    long l = TabDataHelper.getSequence(BaseApplication.getContext(), str4);
    localGetTabListRequest.sequence.set(l);
    StringBuilder localStringBuilder = new StringBuilder("getTabListNet uin=");
    localStringBuilder.append(StringUtil.getSimpleUinForPrint(str4));
    localStringBuilder.append(",sequence=");
    localStringBuilder.append(l);
    if (this.c != null)
    {
      int i;
      if (AutomatorHelper.a) {
        i = 0;
      } else if (this.c.c()) {
        i = 1;
      } else {
        i = 2;
      }
      String str1 = this.c.a();
      String str2 = this.c.b();
      localStringBuilder.append(",kanDianStatus=");
      localStringBuilder.append(i);
      localStringBuilder.append(",qua=");
      String str3 = "null";
      if (str1 == null) {
        localObject = "null";
      } else {
        localObject = str1;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",deviceInfo=");
      if (str2 == null) {
        localObject = str3;
      } else {
        localObject = str2;
      }
      localStringBuilder.append((String)localObject);
      localObject = new UserDynamicTab.TabData();
      ((UserDynamicTab.TabData)localObject).tab_id.set(3);
      ((UserDynamicTab.TabData)localObject).tab_status.set(i);
      localGetTabListRequest.kandian_data.set((MessageMicro)localObject);
      if (str1 != null) {
        localGetTabListRequest.qua.set(str1);
      }
      if (str2 != null) {
        localGetTabListRequest.device_info.set(str2);
      }
    }
    localToServiceMsg.putWupBuffer(localGetTabListRequest.toByteArray());
    localToServiceMsg.extraData.putString("uin", str4);
    localToServiceMsg.addAttribute("KeyNeedUIRefresh", Boolean.valueOf(paramBoolean));
    sendPbReq(localToServiceMsg);
    QLog.i("TabDataHandler", 1, localStringBuilder.toString());
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    UserDynamicTab.SetTabListResponse localSetTabListResponse = new UserDynamicTab.SetTabListResponse();
    StringBuilder localStringBuilder = new StringBuilder("handleSetTabListNet ");
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      if (!paramFromServiceMsg.isSuccess())
      {
        localStringBuilder.append(",resultCode=");
        localStringBuilder.append(paramFromServiceMsg.getResultCode());
        localStringBuilder.append(",RequestSsoSeq=");
        localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
        paramFromServiceMsg = localSetTabListResponse;
      }
      else
      {
        try
        {
          paramFromServiceMsg = (UserDynamicTab.SetTabListResponse)localSetTabListResponse.mergeFrom((byte[])paramObject);
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.i("TabDataHandler", 1, "handleSetTabListNet", paramFromServiceMsg);
          paramFromServiceMsg = localSetTabListResponse;
        }
        bool1 = bool2;
        if (paramFromServiceMsg.reson_code.get() == 0)
        {
          bool1 = bool2;
          if (paramFromServiceMsg.sequence.get() != 0L) {
            bool1 = true;
          }
        }
        localStringBuilder.append(",reson_code=");
        localStringBuilder.append(paramFromServiceMsg.reson_code.get());
        localStringBuilder.append(",sequence=");
        localStringBuilder.append(paramFromServiceMsg.sequence.get());
      }
    }
    else
    {
      localStringBuilder.append("res == null || data == null ");
      paramFromServiceMsg = localSetTabListResponse;
    }
    localStringBuilder.append(",isSuc=");
    localStringBuilder.append(bool1);
    a(this.appRuntime, paramToServiceMsg, paramFromServiceMsg, bool1);
    QLog.i("TabDataHandler", 1, localStringBuilder.toString());
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("trpc.qq_tab.user_dynamic_tab.UserDynamicTab.GetTabList");
      this.allowCmdSet.add("trpc.qq_tab.user_dynamic_tab.UserDynamicTab.SetTabList");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TabDataObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (!msgCmdFilter(paramFromServiceMsg.getServiceCmd())))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if ("trpc.qq_tab.user_dynamic_tab.UserDynamicTab.GetTabList".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("trpc.qq_tab.user_dynamic_tab.UserDynamicTab.SetTabList".equals(str)) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    QLog.i("TabDataHandler", 1, "req or res is null");
  }
  
  public void sendPbReq(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      QLog.i("TabDataHandler", 1, "request is null");
      return;
    }
    String str = paramToServiceMsg.getServiceCmd();
    if (!Cmd2HandlerMapHelper.a(str)) {
      Cmd2HandlerMapHelper.a(str, a);
    }
    super.sendPbReq(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.logic.TabDataHandler
 * JD-Core Version:    0.7.0.1
 */