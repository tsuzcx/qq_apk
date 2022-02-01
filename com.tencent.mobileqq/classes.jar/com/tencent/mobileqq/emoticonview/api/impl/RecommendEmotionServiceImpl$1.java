package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.IFindEmotionPackageListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.model.QueryCallback;

class RecommendEmotionServiceImpl$1
  implements QueryCallback<EmoticonPackage>
{
  RecommendEmotionServiceImpl$1(RecommendEmotionServiceImpl paramRecommendEmotionServiceImpl, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, String paramString, int paramInt2, IFindEmotionPackageListener paramIFindEmotionPackageListener) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool = false;
    int i = ((SVIPHandlerProxy)this.val$app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
    Object localObject = "vip";
    String str1 = "";
    String str2;
    if (this.val$promotionType == 4)
    {
      str1 = "mvip.g.a.bq_" + this.val$epId;
      if (this.val$feeType != 4) {
        break label194;
      }
      str2 = "!vip";
      if (i != 1)
      {
        localObject = str2;
        if (i != 3) {}
      }
      else
      {
        bool = true;
        localObject = str2;
      }
    }
    for (;;)
    {
      if (this.val$callback != null) {
        this.val$callback.callBack(paramEmoticonPackage, bool, (String)localObject, str1, i);
      }
      return;
      if (this.val$promotionType == 0)
      {
        str1 = "mvip.g.a.bq_" + this.val$epId;
        break;
      }
      if ((this.val$promotionType != 3) && (this.val$promotionType != 5)) {
        break;
      }
      str1 = "mvip.g.a.bq_mg_" + this.val$epId;
      break;
      label194:
      if (this.val$feeType == 5)
      {
        str2 = "!svip";
        localObject = str2;
        if (i == 3)
        {
          bool = true;
          localObject = str2;
        }
      }
      else
      {
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.RecommendEmotionServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */