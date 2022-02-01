package com.tencent.mobileqq.forward;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForwardOptionUtils
{
  public static int a(int paramInt, double paramDouble)
  {
    float f;
    if (paramInt > 150) {
      f = paramInt / 100;
    } else {
      f = 1.0F;
    }
    if (paramDouble <= 1.5D) {}
    for (f *= 9.0F;; f *= 4.0F)
    {
      return (int)f;
      if (paramDouble <= 2.0D) {
        break;
      }
    }
  }
  
  private static ContentValues a(MessageRecord paramMessageRecord, MessageForArkApp paramMessageForArkApp)
  {
    ContentValues localContentValues = new ContentValues();
    a(localContentValues, "uniseq", Long.valueOf(paramMessageRecord.uniseq), Long.valueOf(paramMessageForArkApp.uniseq));
    a(localContentValues, "msgtype", Integer.valueOf(paramMessageRecord.msgtype), Integer.valueOf(paramMessageForArkApp.msgtype));
    a(localContentValues, "time", Long.valueOf(paramMessageRecord.time), Long.valueOf(paramMessageForArkApp.time));
    a(localContentValues, "shmsgseq", Long.valueOf(paramMessageRecord.shmsgseq), Long.valueOf(paramMessageForArkApp.shmsgseq));
    a(localContentValues, "msgseq", Long.valueOf(paramMessageRecord.msgseq), Long.valueOf(paramMessageForArkApp.msgseq));
    a(localContentValues, "isread", Boolean.valueOf(paramMessageRecord.isread), Boolean.valueOf(paramMessageForArkApp.isread));
    a(localContentValues, "issend", Integer.valueOf(paramMessageRecord.issend), Integer.valueOf(paramMessageForArkApp.issend));
    a(localContentValues, "istroop", Integer.valueOf(paramMessageRecord.istroop), Integer.valueOf(paramMessageForArkApp.istroop));
    a(localContentValues, "extraflag", Integer.valueOf(paramMessageRecord.extraflag), Integer.valueOf(paramMessageForArkApp.extraflag));
    a(localContentValues, "sendFailCode", Integer.valueOf(paramMessageRecord.sendFailCode), Integer.valueOf(paramMessageForArkApp.sendFailCode));
    a(localContentValues, "msgId", Long.valueOf(paramMessageRecord.msgId), Long.valueOf(paramMessageForArkApp.msgId));
    a(localContentValues, "msgUid", Long.valueOf(paramMessageRecord.msgUid), Long.valueOf(paramMessageForArkApp.msgUid));
    a(localContentValues, "extInt", Integer.valueOf(paramMessageRecord.extInt), Integer.valueOf(paramMessageForArkApp.extInt));
    a(localContentValues, "extLong", Integer.valueOf(paramMessageRecord.extLong), Integer.valueOf(paramMessageForArkApp.extLong));
    a(localContentValues, "extStr", paramMessageRecord.extStr, paramMessageForArkApp.extStr);
    a(localContentValues, "isValid", Boolean.valueOf(paramMessageRecord.isValid), Boolean.valueOf(paramMessageForArkApp.isValid));
    a(localContentValues, "versionCode", Integer.valueOf(paramMessageRecord.versionCode), Integer.valueOf(paramMessageForArkApp.versionCode));
    a(localContentValues, "vipBubbleID", Long.valueOf(paramMessageRecord.vipBubbleID), Long.valueOf(paramMessageForArkApp.vipBubbleID));
    a(localContentValues, "longMsgCount", Integer.valueOf(paramMessageRecord.longMsgCount), Integer.valueOf(paramMessageForArkApp.longMsgCount));
    a(localContentValues, "longMsgId", Integer.valueOf(paramMessageRecord.longMsgId), Integer.valueOf(paramMessageForArkApp.longMsgId));
    a(localContentValues, "longMsgIndex", Integer.valueOf(paramMessageRecord.longMsgIndex), Integer.valueOf(paramMessageForArkApp.longMsgIndex));
    a(localContentValues, "msgData", paramMessageRecord.msgData, paramMessageForArkApp.msgData);
    return localContentValues;
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    paramBitmap = ImageUtil.a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    if (paramBitmap != null) {
      return new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramBitmap);
    }
    return null;
  }
  
  public static Drawable a(Bitmap paramBitmap, double paramDouble)
  {
    paramBitmap = ImageUtil.a(paramBitmap, a(0, paramDouble));
    if (paramBitmap != null) {
      return new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramBitmap);
    }
    return null;
  }
  
  public static Drawable a(Drawable paramDrawable, double paramDouble)
  {
    return a(SkinUtils.a(paramDrawable), paramDouble);
  }
  
  public static List<MessageRecord> a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateFakeMsg newRecords.size=");
      ((StringBuilder)localObject1).append(paramList.size());
      QLog.d("SDK_SHARE.ForwardOptionUtils", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (MessageRecord)localIterator.next();
      if ((localObject2 instanceof MessageForArkApp))
      {
        localObject2 = (MessageForArkApp)localObject2;
        if (((MessageForArkApp)localObject2).ark_app_message == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SDK_SHARE.ForwardOptionUtils", 2, "updateFakeMsg null == serverArkRecord.ark_app_message");
          }
        }
        else
        {
          long l = ((MessageForArkApp)localObject2).ark_app_message.optMsgSeq();
          if (l != -1L)
          {
            MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().b(((MessageForArkApp)localObject2).frienduin, ((MessageForArkApp)localObject2).istroop, l);
            QLog.d("SDK_SHARE.ForwardOptionUtils", 1, new Object[] { "arkConfig.extraUniseq=", Long.valueOf(l), "fakeRecord=", localMessageRecord });
            if (!(localMessageRecord instanceof MessageForArkApp))
            {
              QLog.d("SDK_SHARE.ForwardOptionUtils", 1, "error !(fakeRecord instanceof MessageForArkApp)");
            }
            else
            {
              MessageForArkApp localMessageForArkApp = (MessageForArkApp)localMessageRecord;
              ContentValues localContentValues = a(localMessageRecord, (MessageForArkApp)localObject2);
              MessageRecord.copyMessageRecordBaseField(localMessageRecord, (MessageRecord)localObject2);
              localMessageForArkApp.updateArkAppMetaData(((MessageForArkApp)localObject2).ark_app_message.metaList);
              localMessageForArkApp.ark_app_message.mExtra = ((MessageForArkApp)localObject2).ark_app_message.getFilterExtra();
              localContentValues.put("extraflag", Integer.valueOf(localMessageForArkApp.extraflag));
              localMessageForArkApp.saveExtInfoToExtStr(MessageConstants.w, Integer.toString(0));
              localContentValues.put("extStr", localMessageForArkApp.extStr);
              localContentValues.put("extLong", Integer.valueOf(localMessageForArkApp.extLong));
              paramQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageForArkApp, localContentValues, new int[] { 2, 3 });
              paramQQAppInterface.getMsgHandler().notifyUI(6003, true, new String[] { localMessageRecord.frienduin, String.valueOf(localMessageRecord.uniseq) });
              paramQQAppInterface.getMsgCache().a(localMessageRecord.frienduin, localMessageRecord.istroop, l);
              if (localObject1 == null) {
                localObject1 = new ArrayList(paramList);
              }
              ((List)localObject1).remove(localObject2);
            }
          }
        }
      }
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return paramList;
  }
  
  private static void a(ContentValues paramContentValues, String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return;
    }
    QLog.d("SDK_SHARE.ForwardOptionUtils", 1, new Object[] { "addValues key=", paramString, ", oldValue=", paramObject1, ", newValue=", paramObject2 });
    if ((paramObject2 instanceof Integer))
    {
      paramContentValues.put(paramString, (Integer)paramObject2);
      return;
    }
    if ((paramObject2 instanceof String))
    {
      paramContentValues.put(paramString, (String)paramObject2);
      return;
    }
    if ((paramObject2 instanceof Boolean))
    {
      paramContentValues.put(paramString, (Boolean)paramObject2);
      return;
    }
    if ((paramObject2 instanceof Long))
    {
      paramContentValues.put(paramString, (Long)paramObject2);
      return;
    }
    if ((paramObject2 instanceof byte[]))
    {
      paramContentValues.put(paramString, (byte[])paramObject2);
      return;
    }
    QLog.e("SDK_SHARE.ForwardOptionUtils", 1, new Object[] { "addValues fail -------key=", paramString, ", oldValue=", paramObject1, ", newValue=", paramObject2 });
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp, int paramInt, String paramString)
  {
    QLog.d("SDK_SHARE.ForwardOptionUtils", 1, new Object[] { "updateFakeArkMsg errorCode=", Integer.valueOf(paramInt), ", errorText=", paramString, ", fakeArkApp.uniseq=", Long.valueOf(paramMessageForArkApp.uniseq) });
    if (!paramMessageForArkApp.isSendFromLocal())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("fakeArkApp isSendFromLocal false fakeArkApp.issend=");
      paramQQAppInterface.append(paramMessageForArkApp.issend);
      QLog.d("SDK_SHARE.ForwardOptionUtils", 1, paramQQAppInterface.toString());
      return;
    }
    String str = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.w);
    if (Integer.toString(0).equals(str))
    {
      QLog.d("SDK_SHARE.ForwardOptionUtils", 1, "updateFailFakeMsg already success，return");
      return;
    }
    if (TextUtils.isEmpty(paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.y)))
    {
      QLog.d("SDK_SHARE.ForwardOptionUtils", 1, "updateFailFakeMsg fakeShareInfo empty，return");
      return;
    }
    paramMessageForArkApp.extraflag = 32768;
    paramMessageForArkApp.saveExtInfoToExtStr(MessageConstants.w, String.valueOf(paramInt));
    paramMessageForArkApp.saveExtInfoToExtStr(MessageConstants.x, paramString);
    paramMessageForArkApp.saveMsgData(paramQQAppInterface);
    paramMessageForArkApp.saveMsgExtStrAndFlag(paramQQAppInterface);
    paramQQAppInterface.getMsgCache().a(paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq);
    paramString = new Object[8];
    paramString[0] = paramMessageForArkApp.frienduin;
    paramString[1] = Integer.valueOf(paramMessageForArkApp.istroop);
    paramString[2] = Integer.valueOf(0);
    paramString[3] = null;
    paramString[4] = Long.valueOf(0L);
    paramString[5] = Long.valueOf(paramMessageForArkApp.uniseq);
    paramQQAppInterface.getMsgHandler().notifyUI(3001, false, paramString);
  }
  
  public static final boolean a(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.hasExtra("report")) && ("Music_gene_aio".equals(paramIntent.getStringExtra("report")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardOptionUtils
 * JD-Core Version:    0.7.0.1
 */