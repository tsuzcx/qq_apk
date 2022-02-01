package com.tencent.mobileqq.emoticonview.api.impl;

import android.view.View;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonReportDtHelper;
import com.tencent.mobileqq.emoticonview.api.IEmoticonUtilsService;

public class EmoticonUtilsServiceImpl
  implements IEmoticonUtilsService
{
  public void bindStickersRecommendBar(View paramView, String paramString)
  {
    EmoticonReportDtHelper.bindStickersRecommendBar(paramView, paramString);
  }
  
  public String getMessageForPicUrl(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      return EmoticonPanelUtils.b((MessageForPic)paramMessageRecord);
    }
    return "";
  }
  
  public String getRelatedEmotionReportType(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      return EmoticonPanelUtils.a((MessageForPic)paramMessageRecord);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoticonUtilsServiceImpl
 * JD-Core Version:    0.7.0.1
 */