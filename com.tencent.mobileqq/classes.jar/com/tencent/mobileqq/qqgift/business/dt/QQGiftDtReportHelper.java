package com.tencent.mobileqq.qqgift.business.dt;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewModelForLive;
import com.tencent.mobileqq.qqgift.data.service.GiftSendReqData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.data.QQGiftDtParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;

public class QQGiftDtReportHelper
{
  private final QQGiftPanelViewModelForLive a;
  private View b;
  
  public QQGiftDtReportHelper(QQGiftPanelViewModelForLive paramQQGiftPanelViewModelForLive)
  {
    this.a = paramQQGiftPanelViewModelForLive;
  }
  
  private void a(Object paramObject)
  {
    VideoReport.setPageId(paramObject, "pg_qqlive_gift_panel");
    b(paramObject);
    Map localMap = a();
    localMap.put("pgid", "pg_qqlive_gift_panel");
    a(localMap);
    VideoReport.reportEvent("pgin", paramObject, localMap);
  }
  
  private void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static void b(GiftServiceData paramGiftServiceData, View paramView)
  {
    if (paramGiftServiceData.i)
    {
      VideoReport.setElementId(paramView, "em_yes_gift_panel_send");
      VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
      HashMap localHashMap = new HashMap();
      localHashMap.put("yes_gift_price", Integer.valueOf(paramGiftServiceData.c));
      localHashMap.put("yes_gift_name", paramGiftServiceData.b);
      localHashMap.put("yes_gift_id", Integer.valueOf(paramGiftServiceData.a));
      localHashMap.put("dt_pgid", "pg_sgrp_stream_aio");
      VideoReport.setElementParams(paramView, localHashMap);
      VideoReport.reportEvent("imp", paramView, null);
      return;
    }
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_NONE);
  }
  
  private void b(Object paramObject)
  {
    Map localMap = a();
    Object localObject = this.a.s();
    if ((localObject != null) && (!TextUtils.isEmpty(((QQGiftDtParams)localObject).a))) {
      localObject = ((QQGiftDtParams)localObject).a;
    } else {
      localObject = "0";
    }
    VideoReport.setPublicParam("zengzhi_tracedetail", localObject);
    localObject = this.a.t();
    if (localObject != null) {
      localMap.putAll((Map)localObject);
    }
    a(localMap);
    VideoReport.setPageParams(paramObject, new PageParams(localMap));
  }
  
  private void c(Object paramObject)
  {
    VideoReport.setElementId(paramObject, "em_qqlive_gift_send");
    VideoReport.setElementClickPolicy(paramObject, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(paramObject, ExposurePolicy.REPORT_ALL);
    a(this.a.m());
    VideoReport.reportEvent("imp", paramObject, null);
  }
  
  private void d(Object paramObject)
  {
    VideoReport.setElementId(paramObject, "em_qqlive_recharge_entrance");
    VideoReport.setElementClickPolicy(paramObject, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(paramObject, ExposurePolicy.REPORT_ALL);
    a(paramObject, (Long)this.a.a.getValue());
    VideoReport.reportEvent("imp", paramObject, null);
  }
  
  public Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    QQGiftDtParams localQQGiftDtParams = this.a.s();
    if (localQQGiftDtParams != null)
    {
      a(localHashMap, "zengzhi_tracedetail", localQQGiftDtParams.a);
      a(localHashMap, "qqlive_user_id", localQQGiftDtParams.b);
      a(localHashMap, "qqlive_anchor_id", localQQGiftDtParams.c);
      a(localHashMap, "qqlive_room_id", localQQGiftDtParams.d);
      a(localHashMap, "qqlive_program_id", localQQGiftDtParams.e);
      a(localHashMap, "qqlive_zhibo_type", localQQGiftDtParams.f);
      a(localHashMap, "qqlive_zhibo_content", localQQGiftDtParams.g);
      a(localHashMap, "qqlive_start_source", localQQGiftDtParams.h);
      a(localHashMap, "qqlive_scene_id", localQQGiftDtParams.i);
      a(localHashMap, "qqlive_subscene_id", localQQGiftDtParams.j);
    }
    return localHashMap;
  }
  
  public void a(View paramView1, View paramView2, View paramView3)
  {
    this.b = paramView2;
    try
    {
      a(paramView1);
      c(paramView2);
      d(paramView3);
      return;
    }
    catch (Exception paramView1)
    {
      QLog.e("QQGiftDtHelper", 1, paramView1, new Object[0]);
    }
  }
  
  public void a(GiftServiceData paramGiftServiceData)
  {
    VideoReport.setElementParams(this.b, b(paramGiftServiceData));
  }
  
  public void a(GiftServiceData paramGiftServiceData, View paramView)
  {
    VideoReport.setElementId(paramView, "em_qqlive_gift_list");
    VideoReport.setElementReuseIdentifier(paramView, String.valueOf(paramGiftServiceData.a));
    VideoReport.setElementParams(paramView, b(paramGiftServiceData));
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_FIRST);
    if (!paramGiftServiceData.o)
    {
      paramGiftServiceData.o = true;
      VideoReport.reportEvent("imp", paramView, null);
    }
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqlive_combo_click", String.valueOf(paramInt2));
    localHashMap.put("qqlive_combo_real", String.valueOf(paramInt1));
    a(localHashMap);
    VideoReport.reportEvent("ev_qqlive_gift_combo", paramObject, localHashMap);
  }
  
  public void a(Object paramObject, Long paramLong)
  {
    HashMap localHashMap = new HashMap();
    a(localHashMap);
    if (paramLong != null) {
      localHashMap.put("qqlive_balance_amt", String.valueOf(paramLong));
    }
    VideoReport.setElementParams(paramObject, localHashMap);
  }
  
  public void a(Map<String, String> paramMap)
  {
    paramMap.put("dt_pgid", "pg_qqlive_gift_panel");
    paramMap.put("dt_appkey", "0AND06MK9E48EOTF");
  }
  
  public void a(boolean paramBoolean, GiftServiceData paramGiftServiceData, int paramInt)
  {
    paramGiftServiceData = b(paramGiftServiceData);
    if (paramBoolean)
    {
      VideoReport.reportEvent("ev_qqlive_gift_success", this.b, paramGiftServiceData);
      return;
    }
    paramGiftServiceData.put("qqlive_fail_reason", String.valueOf(paramInt));
    VideoReport.reportEvent("ev_qqlive_gift_failure", this.b, paramGiftServiceData);
  }
  
  public Map<String, String> b(GiftServiceData paramGiftServiceData)
  {
    HashMap localHashMap = new HashMap();
    a(localHashMap);
    if (paramGiftServiceData != null)
    {
      localHashMap.put("qqlive_gift_id", String.valueOf(paramGiftServiceData.a));
      localHashMap.put("qqlive_gift_name", paramGiftServiceData.b);
      localHashMap.put("qqlive_gift_price", String.valueOf(paramGiftServiceData.c));
    }
    paramGiftServiceData = this.a.i().d().c();
    long l;
    if ((paramGiftServiceData != null) && (paramGiftServiceData.b != 0L)) {
      l = paramGiftServiceData.b;
    } else {
      l = 0L;
    }
    if (l == 0L)
    {
      paramGiftServiceData = this.a.s();
      if (paramGiftServiceData != null)
      {
        localHashMap.put("qqlive_receiver_id", paramGiftServiceData.c);
        return localHashMap;
      }
    }
    else
    {
      localHashMap.put("qqlive_receiver_id", String.valueOf(l));
    }
    return localHashMap;
  }
  
  public void b(View paramView1, View paramView2, View paramView3)
  {
    Map localMap = a();
    localMap.put("pgid", "pg_qqlive_gift_panel");
    a(localMap);
    VideoReport.reportEvent("pgout", paramView1, localMap);
    VideoReport.reportEvent("imp_end", paramView2, null);
    VideoReport.reportEvent("imp_end", paramView3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.dt.QQGiftDtReportHelper
 * JD-Core Version:    0.7.0.1
 */