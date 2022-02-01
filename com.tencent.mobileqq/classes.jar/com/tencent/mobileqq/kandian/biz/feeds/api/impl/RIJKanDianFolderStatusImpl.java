package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/RIJKanDianFolderStatusImpl;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IRIJKanDianFolderStatus;", "()V", "getRedPntInfoForReport", "Lcom/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport;", "kotlin.jvm.PlatformType", "getReportFolderStatus", "", "setReportLastRedPntPosition", "", "p0", "updateKandianFolderStatus", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "p1", "Lcom/tencent/mobileqq/data/MessageRecord;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJKanDianFolderStatusImpl
  implements IRIJKanDianFolderStatus
{
  public RedPntInfoForReport getRedPntInfoForReport()
  {
    return this.$$delegate_0.getRedPntInfoForReport();
  }
  
  public int getReportFolderStatus()
  {
    return this.$$delegate_0.getReportFolderStatus();
  }
  
  public void setReportLastRedPntPosition(int paramInt)
  {
    this.$$delegate_0.setReportLastRedPntPosition(paramInt);
  }
  
  public void updateKandianFolderStatus(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    this.$$delegate_0.updateKandianFolderStatus(paramBaseQQAppInterface, paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJKanDianFolderStatusImpl
 * JD-Core Version:    0.7.0.1
 */