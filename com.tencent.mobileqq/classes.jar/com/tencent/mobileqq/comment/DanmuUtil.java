package com.tencent.mobileqq.comment;

import android.content.Context;
import android.graphics.Paint;
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
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

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
          i = FileManagerUtil.c(paramQQAppInterface.fileName);
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
          i = FileManagerUtil.c(paramQQAppInterface.t);
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
      return paramContext.getString(2131915690, new Object[] { Integer.valueOf(i) });
    }
    if (i < 3600) {
      return paramContext.getString(2131915691, new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
    }
    paramInt = i / 60;
    return paramContext.getString(2131915692, new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
  }
  
  public static final String a(Paint paramPaint, String paramString, int paramInt)
  {
    float f1 = paramPaint.measureText(paramString);
    float f2 = paramPaint.measureText("…");
    if (f2 > f1) {
      return paramString;
    }
    float f3 = paramInt;
    if (f2 > f3) {
      return "…";
    }
    if (f1 > f3)
    {
      float[] arrayOfFloat = new float[paramString.length()];
      paramPaint.getTextWidths(paramString, arrayOfFloat);
      paramInt = 0;
      f1 = 0.0F;
      while (paramInt < arrayOfFloat.length)
      {
        f1 += arrayOfFloat[paramInt];
        if (f1 > f3 - f2)
        {
          paramPaint = new StringBuilder();
          paramPaint.append(paramString.substring(0, paramInt));
          paramPaint.append("…");
          return paramPaint.toString();
        }
        paramInt += 1;
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuUtil
 * JD-Core Version:    0.7.0.1
 */