package com.tencent.mobileqq.msg.api;

import android.content.Context;
import android.graphics.drawable.Drawable.Callback;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IMessageForGrayTips
  extends IRuntimeService
{
  public abstract void addHightlightItem(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, Bundle paramBundle);
  
  public abstract MessageRecord getMessageForGrayTips(int paramInt);
  
  public abstract SpannableStringBuilder getSpannableStringBuilder(MessageRecord paramMessageRecord, Context paramContext, boolean paramBoolean, Drawable.Callback paramCallback, String paramString);
  
  public abstract void setTextGravity(MessageRecord paramMessageRecord, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IMessageForGrayTips
 * JD-Core Version:    0.7.0.1
 */