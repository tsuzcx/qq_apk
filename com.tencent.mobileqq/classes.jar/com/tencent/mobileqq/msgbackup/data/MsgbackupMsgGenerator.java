package com.tencent.mobileqq.msgbackup.data;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MsgbackupMsgGenerator
{
  public static String a;
  private static final Random a = new Random();
  
  public static MessageRecord a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static String a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, Random paramRandom)
  {
    char[] arrayOfChar = new char[paramInt1];
    int j = paramInt3 - paramInt2;
    label195:
    for (;;)
    {
      paramInt3 = paramInt1 - 1;
      if (paramInt1 == 0) {
        break;
      }
      int i;
      if (paramArrayOfChar == null) {
        i = (char)(paramRandom.nextInt(j) + paramInt2);
      } else {
        i = paramArrayOfChar[(paramRandom.nextInt(j) + paramInt2)];
      }
      if (a(paramBoolean1, paramBoolean2, i)) {
        if ((i >= 56320) && (i <= 57343))
        {
          if (paramInt3 != 0)
          {
            arrayOfChar[paramInt3] = i;
            paramInt1 = paramInt3 - 1;
            arrayOfChar[paramInt1] = ((char)(paramRandom.nextInt(128) + 55296));
            break label195;
          }
        }
        else if ((i >= 55296) && (i <= 56191))
        {
          if (paramInt3 != 0)
          {
            arrayOfChar[paramInt3] = ((char)(paramRandom.nextInt(128) + 56320));
            paramInt1 = paramInt3 - 1;
            arrayOfChar[paramInt1] = i;
            break label195;
          }
        }
        else if ((i < 56192) || (i > 56319))
        {
          arrayOfChar[paramInt3] = i;
          paramInt1 = paramInt3;
          break label195;
        }
      }
      paramInt1 = paramInt3 + 1;
    }
    return new String(arrayOfChar);
  }
  
  public static List<MessageRecord> a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramString1 == null) {
      i = 0;
    } else {
      i = paramString1.length();
    }
    String str = "";
    int j = 0;
    while (j < paramInt1)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        str = a(100);
      }
      else
      {
        int k = j * 100;
        if (i >= k) {
          str = paramString1.substring(k, k + 100);
        }
      }
      long l1 = MessageUtils.a(j);
      long l2 = MessageUtils.a(j);
      MessageRecord localMessageRecord = a(str, -1000, paramString2, paramInt2, paramString3, true, l2, l2, l1);
      localMessageRecord.msgData = str.getBytes();
      localArrayList.add(localMessageRecord);
      j += 1;
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getMessageFacade().a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    paramQQAppInterface.getMessageFacade().d(paramList);
  }
  
  private static boolean a(boolean paramBoolean1, boolean paramBoolean2, char paramChar)
  {
    return ((paramBoolean1) && (Character.isLetter(paramChar))) || ((paramBoolean2) && (Character.isDigit(paramChar))) || ((!paramBoolean1) && (!paramBoolean2));
  }
  
  public static String b(int paramInt)
  {
    return a(paramInt, 32, 127, false, false, null, a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgbackupMsgGenerator
 * JD-Core Version:    0.7.0.1
 */