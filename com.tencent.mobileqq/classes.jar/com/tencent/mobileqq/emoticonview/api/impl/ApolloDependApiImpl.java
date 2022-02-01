package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.apollo.statistics.product.api.IApolloCmEmojiReportHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.api.IApolloDependApi;
import com.tencent.mobileqq.qroute.QRoute;

public class ApolloDependApiImpl
  implements IApolloDependApi
{
  public void apolloCmEmojiDtReport(int paramInt)
  {
    IApolloCmEmojiReportHelper localIApolloCmEmojiReportHelper = (IApolloCmEmojiReportHelper)QRoute.api(IApolloCmEmojiReportHelper.class);
    if ((!localIApolloCmEmojiReportHelper.needReport()) && (QQSysFaceUtil.isApolloEmoticon(paramInt))) {
      ThreadManagerV2.executeOnSubThread(new ApolloDependApiImpl.1(this, localIApolloCmEmojiReportHelper));
    }
  }
  
  public void onEmoticonNewIconShown(int paramInt)
  {
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).onEmoticonNewIconShown(paramInt);
  }
  
  public boolean shouldShowNewIcon(int paramInt)
  {
    return ((IApolloUtil)QRoute.api(IApolloUtil.class)).shouldShowNewIcon(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.ApolloDependApiImpl
 * JD-Core Version:    0.7.0.1
 */