package com.tencent.mobileqq.emoticonview.api;

import android.view.View;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEmoticonUtilsService
  extends QRouteApi
{
  public abstract void bindStickersRecommendBar(View paramView, String paramString);
  
  public abstract String getMessageForPicUrl(MessageRecord paramMessageRecord);
  
  public abstract String getRelatedEmotionReportType(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmoticonUtilsService
 * JD-Core Version:    0.7.0.1
 */