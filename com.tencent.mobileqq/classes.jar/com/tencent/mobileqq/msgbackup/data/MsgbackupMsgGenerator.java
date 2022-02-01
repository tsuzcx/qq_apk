package com.tencent.mobileqq.msgbackup.data;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MsgbackupMsgGenerator
{
  public static String a;
  private static final Random a;
  
  static
  {
    jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static MessageRecord a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    int i = 1;
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramInt1);
    localMessageRecord.selfuin = jdField_a_of_type_JavaLangString;
    localMessageRecord.frienduin = paramString2;
    localMessageRecord.senderuin = paramString3;
    localMessageRecord.istroop = paramInt2;
    localMessageRecord.isread = true;
    if (paramBoolean) {}
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localMessageRecord.issend = paramInt1;
      localMessageRecord.msgseq = paramLong1;
      localMessageRecord.shmsgseq = paramLong2;
      localMessageRecord.msgUid = paramLong3;
      localMessageRecord.msg = paramString1;
      localMessageRecord.time = ((int)MessageCache.a());
      if ((localMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)localMessageRecord).parse();
      }
      return localMessageRecord;
    }
  }
  
  public static String a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, Random paramRandom)
  {
    char[] arrayOfChar = new char[paramInt1];
    int k = paramInt3 - paramInt2;
    paramInt3 = paramInt1 - 1;
    if (paramInt1 != 0)
    {
      if (paramArrayOfChar == null)
      {
        int i = (char)(paramRandom.nextInt(k) + paramInt2);
        label35:
        if (!a(paramBoolean1, paramBoolean2, i)) {
          break label203;
        }
        if ((i < 56320) || (i > 57343)) {
          break label117;
        }
        if (paramInt3 != 0) {
          break label88;
        }
        paramInt1 = paramInt3 + 1;
      }
      label203:
      for (;;)
      {
        break;
        int j = paramArrayOfChar[(paramRandom.nextInt(k) + paramInt2)];
        break label35;
        label88:
        arrayOfChar[paramInt3] = j;
        paramInt1 = paramInt3 - 1;
        arrayOfChar[paramInt1] = ((char)(paramRandom.nextInt(128) + 55296));
        continue;
        label117:
        if ((j >= 55296) && (j <= 56191))
        {
          if (paramInt3 == 0)
          {
            paramInt1 = paramInt3 + 1;
          }
          else
          {
            arrayOfChar[paramInt3] = ((char)(paramRandom.nextInt(128) + 56320));
            paramInt1 = paramInt3 - 1;
            arrayOfChar[paramInt1] = j;
          }
        }
        else if ((j >= 56192) && (j <= 56319))
        {
          paramInt1 = paramInt3 + 1;
        }
        else
        {
          arrayOfChar[paramInt3] = j;
          paramInt1 = paramInt3;
          continue;
          paramInt1 = paramInt3 + 1;
        }
      }
    }
    return new String(arrayOfChar);
  }
  
  public static List<MessageRecord> a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    int j;
    String str;
    if (paramString1 == null)
    {
      i = 0;
      j = 0;
      str = "";
      label23:
      if (j >= paramInt1) {
        break label146;
      }
      if (!TextUtils.isEmpty(paramString1)) {
        break label116;
      }
      str = a(100);
    }
    for (;;)
    {
      long l1 = MessageUtils.a(j);
      long l2 = MessageUtils.a(j);
      MessageRecord localMessageRecord = a(str, -1000, paramString2, paramInt2, paramString3, true, l2, l2, l1);
      localMessageRecord.msgData = str.getBytes();
      localArrayList.add(localMessageRecord);
      j += 1;
      break label23;
      i = paramString1.length();
      break;
      label116:
      int k = j * 100;
      if (i >= k) {
        str = paramString1.substring(k, k + 100);
      }
    }
    label146:
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getMessageFacade().f();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    paramQQAppInterface.getMessageFacade().b(paramList);
  }
  
  private static boolean a(boolean paramBoolean1, boolean paramBoolean2, char paramChar)
  {
    return ((paramBoolean1) && (Character.isLetter(paramChar))) || ((paramBoolean2) && (Character.isDigit(paramChar))) || ((!paramBoolean1) && (!paramBoolean2));
  }
  
  public static String b(int paramInt)
  {
    return a(paramInt, 32, 127, false, false, null, jdField_a_of_type_JavaUtilRandom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgbackupMsgGenerator
 * JD-Core Version:    0.7.0.1
 */