package com.tencent.mobileqq.kandian.repo.pts.entity;

import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;

class ProteusItemData$1
  implements PTSComposer.IPTSUpdateDataListener
{
  ProteusItemData$1(ProteusItemData paramProteusItemData) {}
  
  public void onDataUpdated(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onDataUpdated], jsonData = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ProteusItemData", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.bj;
    if (localObject != null) {
      this.a.bj = new PTSItemData.Builder().withPageName(((PTSItemData)localObject).getPageName()).withItemID(((PTSItemData)localObject).getItemID()).withJsonData(paramString).withFrameTreeJson(((PTSItemData)localObject).getFrameTreeJson()).build();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData.1
 * JD-Core Version:    0.7.0.1
 */