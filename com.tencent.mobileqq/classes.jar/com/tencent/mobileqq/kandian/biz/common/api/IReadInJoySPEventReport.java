package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.widget.AbsListView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoySPEventReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addAioEnterAndOutInfo", "", "type", "", "extraMsg", "", "uin", "", "userType", "hasUnreadCount", "addForeBackGroundCallback", "foreBackGroundCallback", "Lcom/tencent/mobileqq/kandian/repo/feeds/IForeBackGroundCallback;", "addMsgTabTotalRedCntChangeInfo", "cnt", "enterPublicAccount", "leaveMsgTab", "onLebaItemClick", "resId", "hasRedDot", "", "busiName", "onLebaResume", "onScrollStateChanged", "view", "Lcom/tencent/widget/AbsListView;", "scrollState", "recordOneKeyClean", "removeForeBackGroundCallback", "reportAfterSyncMsg", "reason", "reportDau", "reportInForeground", "reportInQQNews", "enterMullis", "", "hasRed", "list", "Lcom/tencent/mobileqq/data/ChatMessage;", "reportLeaveQQ", "reportManualRefresMsg", "reportPubAioItemClick", "cell", "", "reportPubAioMenuAction", "menuId", "menuLevel", "buttonInfo", "Lcom/tencent/mobileqq/mp/mobileqq_mp$ButtonInfo;", "reportQQNewsAction", "action", "hasRedPot", "exposureInfo", "clickInfo", "reportTabExposure", "updateDTRedPntStats", "DauReportType", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoySPEventReport
  extends QRouteApi
{
  public abstract void addAioEnterAndOutInfo(int paramInt1, @Nullable List<?> paramList, @Nullable String paramString, int paramInt2, int paramInt3);
  
  public abstract void addForeBackGroundCallback(@Nullable IForeBackGroundCallback paramIForeBackGroundCallback);
  
  public abstract void addMsgTabTotalRedCntChangeInfo(int paramInt);
  
  public abstract void enterPublicAccount(@Nullable String paramString);
  
  public abstract void leaveMsgTab();
  
  public abstract void onLebaItemClick(int paramInt, boolean paramBoolean);
  
  public abstract void onLebaItemClick(@Nullable String paramString, boolean paramBoolean);
  
  public abstract void onLebaResume();
  
  public abstract void onScrollStateChanged(@Nullable AbsListView paramAbsListView, int paramInt);
  
  public abstract void recordOneKeyClean();
  
  public abstract void removeForeBackGroundCallback(@Nullable IForeBackGroundCallback paramIForeBackGroundCallback);
  
  public abstract void reportAfterSyncMsg(int paramInt);
  
  public abstract void reportDau(int paramInt);
  
  public abstract void reportInForeground();
  
  public abstract void reportInQQNews(@Nullable String paramString, long paramLong, boolean paramBoolean, @Nullable List<? extends ChatMessage> paramList);
  
  public abstract void reportLeaveQQ();
  
  public abstract void reportManualRefresMsg();
  
  public abstract void reportPubAioItemClick(@Nullable String paramString, @Nullable Object paramObject);
  
  public abstract void reportPubAioMenuAction(@Nullable String paramString, int paramInt1, int paramInt2, @Nullable mobileqq_mp.ButtonInfo paramButtonInfo);
  
  public abstract void reportQQNewsAction(@Nullable String paramString1, long paramLong, boolean paramBoolean, @Nullable String paramString2, @Nullable String paramString3);
  
  public abstract void reportTabExposure();
  
  public abstract void updateDTRedPntStats(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport
 * JD-Core Version:    0.7.0.1
 */