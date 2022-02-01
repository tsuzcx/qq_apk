package com.tencent.mobileqq.comment;

import android.content.Context;
import android.graphics.Paint;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class DanmuUtil
{
  public static int a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      return 1;
    }
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      return 2;
    }
    if (FileManagerUtil.a(paramMessageRecord))
    {
      paramMessageRecord = ReplyTextItemBuilder.a(paramQQAppInterface, paramMessageRecord);
      int i;
      if ((paramMessageRecord instanceof MessageForFile))
      {
        paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (paramQQAppInterface != null)
        {
          i = FileManagerUtil.a(paramQQAppInterface.fileName);
          if (i == 0) {
            return 3;
          }
          if (i == 2) {
            return 4;
          }
        }
      }
      else if ((paramMessageRecord instanceof MessageForTroopFile))
      {
        paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramQQAppInterface != null)
        {
          i = FileManagerUtil.a(paramQQAppInterface.g);
          if (i == 0) {
            return 3;
          }
          if (i == 2) {
            return 4;
          }
        }
      }
    }
    return 0;
  }
  
  public static final String a(Context paramContext, int paramInt)
  {
    if (paramInt < 0) {
      return "";
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    if (i < 60) {
      return paramContext.getString(2131699094, new Object[] { Integer.valueOf(i) });
    }
    if (i < 3600) {
      return paramContext.getString(2131699095, new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
    }
    paramInt = i / 60;
    return paramContext.getString(2131699096, new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
  }
  
  public static final String a(Paint paramPaint, String paramString, int paramInt)
  {
    float f1 = paramPaint.measureText(paramString);
    float f2 = paramPaint.measureText("…");
    if (f2 > f1) {}
    for (;;)
    {
      return paramString;
      if (f2 > paramInt) {
        return "…";
      }
      if (f1 > paramInt)
      {
        float[] arrayOfFloat = new float[paramString.length()];
        paramPaint.getTextWidths(paramString, arrayOfFloat);
        float f3 = paramInt;
        f1 = 0.0F;
        paramInt = 0;
        while (paramInt < arrayOfFloat.length)
        {
          f1 += arrayOfFloat[paramInt];
          if (f1 > f3 - f2) {
            return paramString.substring(0, paramInt) + "…";
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean1)
    {
      str = "1";
      localHashMap.put("eventSuccess", str);
      localHashMap.put("statusCode", String.valueOf(paramInt1));
      localHashMap.put("mediaType", String.valueOf(paramInt2));
      if (!paramBoolean2) {
        break label113;
      }
    }
    label113:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("rspValid", str);
      localHashMap.put("errInfo", paramString);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "DanmakuRequestMonitor", paramBoolean1, 0L, 0L, localHashMap, null);
      return;
      str = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuUtil
 * JD-Core Version:    0.7.0.1
 */