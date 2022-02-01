package com.tencent.mobileqq.msg.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable.Callback;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.GrayTipsMessageConstants.HighlightItem;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msg.api.IMessageForGrayTips;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class MessageForGrayTipsImpl
  implements IMessageForGrayTips
{
  public static final String TAG = "MessageForGrayTipsImpl";
  private QQAppInterface mApp;
  
  public void addHightlightItem(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips)) {
      ((MessageForGrayTips)paramMessageRecord).addHightlightItem(paramInt1, paramInt2, paramBundle);
    }
  }
  
  public boolean checkAppRuntimeInValid()
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.mApp == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("MessageForGrayTipsImpl", 2, new Object[] { "checkAppRuntimeInValid: ", Boolean.valueOf(bool) });
    }
    return this.mApp == null;
  }
  
  public MessageRecord getMessageForGrayTips(int paramInt)
  {
    return MessageRecordFactory.a(paramInt);
  }
  
  public SpannableStringBuilder getSpannableStringBuilder(MessageRecord paramMessageRecord, Context paramContext, boolean paramBoolean, Drawable.Callback paramCallback, String paramString)
  {
    if ((!checkAppRuntimeInValid()) && ((paramMessageRecord instanceof MessageForUniteGrayTip)))
    {
      Object localObject = (MessageForUniteGrayTip)paramMessageRecord;
      if (((MessageForUniteGrayTip)localObject).tipParam.i == 2) {
        paramString = new SpannableStringBuilder(new QQText(paramString, 3));
      } else {
        paramString = new SpannableStringBuilder(new ColorNickText(paramString, 16));
      }
      localObject = ((MessageForUniteGrayTip)localObject).tipParam.b().iterator();
      while (((Iterator)localObject).hasNext())
      {
        GrayTipsMessageConstants.HighlightItem localHighlightItem = (GrayTipsMessageConstants.HighlightItem)((Iterator)localObject).next();
        if (localHighlightItem != null) {
          if (TextUtils.isEmpty(localHighlightItem.icon))
          {
            paramString.setSpan(new MessageForGrayTips.HightlightClickableSpan(this.mApp, localHighlightItem.textColor, paramContext, localHighlightItem, paramMessageRecord), localHighlightItem.start, localHighlightItem.end, 33);
          }
          else
          {
            MessageForGrayTips.decodeImageSpan(paramContext, paramString, localHighlightItem, paramBoolean, paramCallback, paramMessageRecord);
            if (localHighlightItem.actionType == 1) {
              paramString.setSpan(new MessageForGrayTips.HightlightClickableSpan(this.mApp, localHighlightItem.textColor, paramContext, localHighlightItem, paramMessageRecord), localHighlightItem.start, localHighlightItem.end, 33);
            }
          }
        }
      }
      return paramString;
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      boolean bool1 = false;
      boolean bool2 = paramAppRuntime instanceof QQAppInterface;
      if (paramAppRuntime == null) {
        bool1 = true;
      }
      QLog.d("MessageForGrayTipsImpl", 2, new Object[] { "MessageForGrayTipsImpl onCreate: app instanceOf QQApp: ", Boolean.valueOf(bool2), "app is null: ", Boolean.valueOf(bool1) });
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
  
  public void setTextGravity(MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips)) {
      ((MessageForGrayTips)paramMessageRecord).setTextGravity(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.MessageForGrayTipsImpl
 * JD-Core Version:    0.7.0.1
 */