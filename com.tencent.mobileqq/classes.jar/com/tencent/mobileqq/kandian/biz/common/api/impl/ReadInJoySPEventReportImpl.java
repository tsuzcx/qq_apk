package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ScrollReport;
import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.widget.AbsListView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/ReadInJoySPEventReportImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoySPEventReport;", "()V", "addAioEnterAndOutInfo", "", "type", "", "extraMsg", "", "uin", "", "userType", "hasUnreadCount", "addForeBackGroundCallback", "foreBackGroundCallback", "Lcom/tencent/mobileqq/kandian/repo/feeds/IForeBackGroundCallback;", "addMsgTabTotalRedCntChangeInfo", "cnt", "enterPublicAccount", "leaveMsgTab", "onLebaItemClick", "resId", "hasRedDot", "", "busiName", "onLebaResume", "onScrollStateChanged", "view", "Lcom/tencent/widget/AbsListView;", "scrollState", "recordOneKeyClean", "removeForeBackGroundCallback", "reportAfterSyncMsg", "reason", "reportDau", "reportInForeground", "reportInQQNews", "enterMullis", "", "hasRed", "list", "Lcom/tencent/mobileqq/data/ChatMessage;", "reportLeaveQQ", "reportManualRefresMsg", "reportPubAioItemClick", "cell", "", "reportPubAioMenuAction", "menuId", "menuLevel", "buttonInfo", "Lcom/tencent/mobileqq/mp/mobileqq_mp$ButtonInfo;", "reportQQNewsAction", "action", "hasRedPot", "exposureInfo", "clickInfo", "reportTabExposure", "updateDTRedPntStats", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoySPEventReportImpl
  implements IReadInJoySPEventReport
{
  public void addAioEnterAndOutInfo(int paramInt1, @Nullable List<?> paramList, @Nullable String paramString, int paramInt2, int paramInt3)
  {
    ReadinjoySPEventReport.a().a(paramInt1, paramList, paramString, paramInt2, paramInt3);
  }
  
  public void addForeBackGroundCallback(@Nullable IForeBackGroundCallback paramIForeBackGroundCallback)
  {
    ReadinjoySPEventReport.ForeBackGround.a(paramIForeBackGroundCallback);
  }
  
  public void addMsgTabTotalRedCntChangeInfo(int paramInt)
  {
    ReadinjoySPEventReport.a().a(paramInt);
  }
  
  public void enterPublicAccount(@Nullable String paramString)
  {
    ReadinjoySPEventReport.a().a(paramString);
  }
  
  public void leaveMsgTab() {}
  
  public void onLebaItemClick(int paramInt, boolean paramBoolean)
  {
    ReadinjoySPEventReport.a().a(paramInt, paramBoolean);
  }
  
  public void onLebaItemClick(@Nullable String paramString, boolean paramBoolean)
  {
    ReadinjoySPEventReport.a().a(paramString, paramBoolean);
  }
  
  public void onLebaResume()
  {
    ReadinjoySPEventReport.a().c();
  }
  
  public void onScrollStateChanged(@Nullable AbsListView paramAbsListView, int paramInt)
  {
    ReadinjoySPEventReport.ScrollReport.a(paramAbsListView, paramInt);
  }
  
  public void recordOneKeyClean()
  {
    ReadinjoySPEventReport.a().h();
  }
  
  public void removeForeBackGroundCallback(@Nullable IForeBackGroundCallback paramIForeBackGroundCallback)
  {
    ReadinjoySPEventReport.ForeBackGround.b(paramIForeBackGroundCallback);
  }
  
  public void reportAfterSyncMsg(int paramInt)
  {
    ReadinjoySPEventReport.d(paramInt);
  }
  
  public void reportDau(int paramInt)
  {
    ReadinjoySPEventReport.e(paramInt);
  }
  
  public void reportInForeground() {}
  
  public void reportInQQNews(@Nullable String paramString, long paramLong, boolean paramBoolean, @Nullable List<? extends ChatMessage> paramList)
  {
    ReadinjoySPEventReport.a().a(paramString, paramLong, paramBoolean, paramList);
  }
  
  public void reportLeaveQQ() {}
  
  public void reportManualRefresMsg()
  {
    ReadinjoySPEventReport.a().a();
  }
  
  public void reportPubAioItemClick(@Nullable String paramString, @Nullable Object paramObject)
  {
    ReadinjoySPEventReport.a().a(paramString, (AbsStructMsgElement)paramObject);
  }
  
  public void reportPubAioMenuAction(@Nullable String paramString, int paramInt1, int paramInt2, @Nullable mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    ReadinjoySPEventReport.a().a(paramString, paramInt1, paramInt2, paramButtonInfo);
  }
  
  public void reportQQNewsAction(@Nullable String paramString1, long paramLong, boolean paramBoolean, @Nullable String paramString2, @Nullable String paramString3)
  {
    ReadinjoySPEventReport.a().a(paramString1, paramLong, paramBoolean, paramString2, paramString3);
  }
  
  public void reportTabExposure() {}
  
  public void updateDTRedPntStats(boolean paramBoolean)
  {
    ReadinjoySPEventReport.a().b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.ReadInJoySPEventReportImpl
 * JD-Core Version:    0.7.0.1
 */