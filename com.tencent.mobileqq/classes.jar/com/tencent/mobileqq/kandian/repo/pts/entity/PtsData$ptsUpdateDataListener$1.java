package com.tencent.mobileqq.kandian.repo.pts.entity;

import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "jsonData", "", "kotlin.jvm.PlatformType", "onDataUpdated"}, k=3, mv={1, 1, 16})
final class PtsData$ptsUpdateDataListener$1
  implements PTSComposer.IPTSUpdateDataListener
{
  PtsData$ptsUpdateDataListener$1(PtsData paramPtsData) {}
  
  public final void onDataUpdated(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onDataUpdated] jsonData = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("PtsData", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.a();
    if (localObject != null)
    {
      paramString = new PTSItemData.Builder().withPageName(((PTSItemData)localObject).getPageName()).withItemID(((PTSItemData)localObject).getItemID()).withFrameTreeJson(((PTSItemData)localObject).getFrameTreeJson()).withJsonData(paramString).build();
      this.a.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.entity.PtsData.ptsUpdateDataListener.1
 * JD-Core Version:    0.7.0.1
 */