package com.tencent.mobileqq.leba;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.DynamicFeeds.DynamicDislike.FeedsItem_Dislike;
import tencent.im.DynamicFeeds.DynamicDislike.SubCmd_FeedsItem_ReqInfo_Dislike;
import tencent.im.DynamicFeeds.DynamicDislike.SubCmd_FeedsItem_RespInfo_Dislike;
import tencent.im.DynamicFeeds.DynamicFeeds.FeedsItem_History;
import tencent.im.DynamicFeeds.DynamicFeeds.FeedsItem_Req;
import tencent.im.DynamicFeeds.DynamicFeeds.FeedsItem_Resp;
import tencent.im.DynamicFeeds.DynamicFeeds.SubCmd_Feeds_ReqInfo;
import tencent.im.DynamicFeeds.DynamicFeeds.SubCmd_Feeds_RespInfo;
import tencent.im.DynamicFeeds.DynamicLike.FeedsItem_Like;
import tencent.im.DynamicFeeds.DynamicLike.SubCmd_FeedsItem_ReqInfo_Like;
import tencent.im.DynamicFeeds.DynamicLike.SubCmd_FeedsItem_RespInfo_Like;

public class LebaFeedsHandler
  extends BusinessHandler
{
  public LebaFeedsHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool1;
    int j;
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      j = -1;
      if (!bool1) {
        break label473;
      }
      paramBundle = new DynamicFeeds.SubCmd_Feeds_RespInfo();
      i = j;
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom((byte[])paramObject);
        i = j;
        j = paramBundle.uiRetCode.get();
        i = j;
        paramObject = paramBundle.strError.get();
        i = j;
      }
      catch (Exception paramObject)
      {
        int m;
        List localList;
        String str;
        ArrayList localArrayList;
        LebaFeedInfo localLebaFeedInfo;
        QLog.e("new_leba", 1, "handleGetFeeds, ", paramObject);
        paramObject = "";
        continue;
        ((LebaFeedsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(276)).a(j, m, localArrayList, paramToServiceMsg, localList, str, k);
      }
      j = paramToServiceMsg.extraData.getInt("uiLoadDayStartTimestamp");
      int k = paramToServiceMsg.extraData.getInt("eventType");
      boolean bool2 = ((LebaFeedsManager)this.a.getManager(276)).a;
      if ((bool1) && (i == 0))
      {
        m = paramBundle.uiNextDayTimestamp.get();
        paramToServiceMsg = paramBundle.strTodayTitle.get();
        localList = paramBundle.ulDelFeeds.get();
        str = paramBundle.strReqCookie.get();
        localArrayList = new ArrayList();
        paramBundle = paramBundle.RespFeeds.get();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.iterator();
          if (paramBundle.hasNext())
          {
            localLebaFeedInfo = LebaFeedInfo.convFeedInfo((DynamicFeeds.FeedsItem_Resp)paramBundle.next(), bool2);
            if (localLebaFeedInfo == null) {
              continue;
            }
            localArrayList.add(localLebaFeedInfo);
            continue;
            bool1 = false;
            break;
          }
        }
        bool2 = true;
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", Integer.toString(0));
        if ((!bool1) || (i != 0)) {
          if (bool1) {
            break label466;
          }
        }
      }
      label466:
      for (j = paramFromServiceMsg.getResultCode();; j = i)
      {
        paramToServiceMsg.put("param_FailCode", Integer.toString(j));
        bool2 = false;
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "newleba_reqfeeds", bool2, 0L, 0L, paramToServiceMsg, "");
        QLog.d("new_leba", 2, "handleGetFeeds, isSucc=" + bool1 + ", msfcode=" + paramFromServiceMsg.getResultCode() + ", busiServerRetCode=" + i + ",strErr=" + paramObject);
        return;
        a(1, false, new Object[] { Integer.valueOf(k), Integer.valueOf(2) });
        break;
      }
      label473:
      paramObject = "";
      i = -1;
      paramBundle = null;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (boolean bool = true;; bool = false)
    {
      paramFromServiceMsg = null;
      paramToServiceMsg = paramFromServiceMsg;
      if (bool) {
        paramToServiceMsg = new DynamicLike.SubCmd_FeedsItem_RespInfo_Like();
      }
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        int i = paramToServiceMsg.uiRetCode.get();
        paramToServiceMsg = Integer.valueOf(i);
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          paramToServiceMsg.printStackTrace();
          paramToServiceMsg = paramFromServiceMsg;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("new_leba", 2, "handleReportLike, isSucc=" + bool + ", retCode=" + paramToServiceMsg);
      }
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (boolean bool = true;; bool = false)
    {
      paramFromServiceMsg = null;
      paramToServiceMsg = paramFromServiceMsg;
      if (bool) {
        paramToServiceMsg = new DynamicDislike.SubCmd_FeedsItem_RespInfo_Dislike();
      }
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        int i = paramToServiceMsg.uiRetCode.get();
        paramToServiceMsg = Integer.valueOf(i);
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          paramToServiceMsg.printStackTrace();
          paramToServiceMsg = paramFromServiceMsg;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("new_leba", 2, "handleReportDisLike, isSucc=" + bool + ", retCode=" + paramToServiceMsg);
      }
      return;
    }
  }
  
  protected Class a()
  {
    return LebaFeedsObserver.class;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, List paramList1, List paramList2, String paramString, long paramLong1, long paramLong2)
  {
    DynamicFeeds.SubCmd_Feeds_ReqInfo localSubCmd_Feeds_ReqInfo = new DynamicFeeds.SubCmd_Feeds_ReqInfo();
    localSubCmd_Feeds_ReqInfo.uiReqEvent.set(paramInt2);
    localSubCmd_Feeds_ReqInfo.uiLoadDayTimestamp.set(paramInt1);
    if (!TextUtils.isEmpty(paramString)) {
      localSubCmd_Feeds_ReqInfo.strReqCookie.set(paramString);
    }
    localSubCmd_Feeds_ReqInfo.ulFinishDayBitmap.set(paramLong1);
    Object localObject2;
    Object localObject1;
    if (paramList1 != null)
    {
      paramString = new ArrayList();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject2 = (LebaGridItemInfo)paramList1.next();
        localObject1 = new DynamicFeeds.FeedsItem_Req();
        localObject2 = ((LebaGridItemInfo)localObject2).a;
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("new_leba", 2, "realGetFeeds, pluginInfo=" + ((PluginInfo)localObject2).pluginId + "," + ((PluginInfo)localObject2).openFlag);
          }
          ((DynamicFeeds.FeedsItem_Req)localObject1).uiResID.set(((PluginInfo)localObject2).pluginId);
          ((DynamicFeeds.FeedsItem_Req)localObject1).uiOpenFlag.set(((PluginInfo)localObject2).openFlag);
          paramString.add(localObject1);
        }
      }
      localSubCmd_Feeds_ReqInfo.ReqResIDs.set(paramString);
    }
    if (paramList2 != null)
    {
      paramList1 = new ArrayList();
      paramList2 = paramList2.iterator();
      if (paramList2.hasNext())
      {
        paramString = (LebaFeedInfo)paramList2.next();
        localObject1 = new DynamicFeeds.FeedsItem_History();
        ((DynamicFeeds.FeedsItem_History)localObject1).ulFeedID.set(paramString.feedID);
        ((DynamicFeeds.FeedsItem_History)localObject1).uiUpdateTimestamp.set(paramString.serverUpdateTime);
        localObject2 = ((DynamicFeeds.FeedsItem_History)localObject1).bDislike;
        if (paramString.showFlag == 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((PBBoolField)localObject2).set(bool);
          paramList1.add(localObject1);
          break;
        }
      }
      localSubCmd_Feeds_ReqInfo.HistoryFeedIDs.set(paramList1);
    }
    paramList1 = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "DynamicFeedsNew.getfeeds");
    paramList1.extraData.putInt("uiLoadDayStartTimestamp", paramInt1);
    paramList1.extraData.putInt("eventType", paramInt2);
    paramList1.extraData.putLong("reqTime", paramLong2);
    paramList1.putWupBuffer(localSubCmd_Feeds_ReqInfo.toByteArray());
    b(paramList1);
    if (QLog.isColorLevel()) {
      QLog.i("new_leba", 2, "reqGetFeeds called cost: ");
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    Object localObject = new ArrayList(1);
    DynamicDislike.FeedsItem_Dislike localFeedsItem_Dislike = new DynamicDislike.FeedsItem_Dislike();
    localFeedsItem_Dislike.ulFeedID.set(paramLong);
    if (!TextUtils.isEmpty(paramString)) {
      localFeedsItem_Dislike.strFeedCookie.set(paramString);
    }
    ((List)localObject).add(localFeedsItem_Dislike);
    paramString = new DynamicDislike.SubCmd_FeedsItem_ReqInfo_Dislike();
    paramString.DislikeList.set((List)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "DynamicFeedsDislike.dislike");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    Object localObject = new ArrayList(1);
    DynamicLike.FeedsItem_Like localFeedsItem_Like = new DynamicLike.FeedsItem_Like();
    localFeedsItem_Like.ulFeedID.set(paramLong);
    localFeedsItem_Like.uiClickTime.set(paramInt);
    if (!TextUtils.isEmpty(paramString)) {
      localFeedsItem_Like.strFeedCookie.set(paramString);
    }
    ((List)localObject).add(localFeedsItem_Like);
    paramString = new DynamicLike.SubCmd_FeedsItem_ReqInfo_Like();
    paramString.LikeList.set((List)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "DynamicFeedsLike.like");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("new_leba", 2, "reqLike called cost: ");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (a(paramFromServiceMsg.getServiceCmd())) {}
    String str;
    do
    {
      return;
      Bundle localBundle = new Bundle();
      str = paramFromServiceMsg.getServiceCmd();
      if ("DynamicFeedsNew.getfeeds".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject, localBundle);
        return;
      }
      if ("DynamicFeedsDislike.dislike".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"DynamicFeedsLike.like".equals(str));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("DynamicFeedsNew.getfeeds");
      this.jdField_b_of_type_JavaUtilSet.add("DynamicFeedsLike.like");
      this.jdField_b_of_type_JavaUtilSet.add("DynamicFeedsDislike.dislike");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaFeedsHandler
 * JD-Core Version:    0.7.0.1
 */