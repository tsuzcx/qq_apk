package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloCmEmojiReportUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.api.IApolloDependListener;
import com.tencent.mobileqq.qroute.QRoute;

public class ApolloDependListener
  implements IApolloDependListener
{
  public void apolloCmEmojiDtReport(int paramInt)
  {
    if ((!ApolloCmEmojiReportUtil.a.a()) && (QQSysFaceUtil.isApolloEmoticon(paramInt))) {
      ThreadManagerV2.executeOnSubThread(new ApolloDependListener.1(this));
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
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.ApolloDependListener
 * JD-Core Version:    0.7.0.1
 */