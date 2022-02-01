package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.pts.PTSParcelableUtil;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;

class BaseArticleInfo$1
  implements PTSComposer.IPTSUpdateDataListener
{
  BaseArticleInfo$1(BaseArticleInfo paramBaseArticleInfo) {}
  
  public void onDataUpdated(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onDataUpdated] jsonData = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("Q.readinjoy.BaseArticleInfo", 1, ((StringBuilder)localObject).toString());
    localObject = this.a.ptsItemData;
    if (localObject != null)
    {
      this.a.ptsItemData = new PTSItemData.Builder().withPageName(((PTSItemData)localObject).getPageName()).withItemID(((PTSItemData)localObject).getItemID()).withJsonData(paramString).withFrameTreeJson(((PTSItemData)localObject).getFrameTreeJson()).build();
      paramString = this.a;
      paramString.ptsItemDataBytes = PTSParcelableUtil.a(paramString.ptsItemData);
      paramString = RIJQQAppInterfaceUtil.a();
      if (paramString != null)
      {
        paramString = (ReadInJoyLogicManager)paramString.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        if (paramString != null) {
          paramString.getReadInJoyLogicEngine().c(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo.1
 * JD-Core Version:    0.7.0.1
 */