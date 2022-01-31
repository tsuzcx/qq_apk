package com.tencent.qidian.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;

public class QidianUtils
{
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ldc 15
    //   5: invokevirtual 21	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8: astore_0
    //   9: bipush 24
    //   11: istore_2
    //   12: iconst_0
    //   13: istore_1
    //   14: iload_1
    //   15: istore 4
    //   17: iload_3
    //   18: aload_0
    //   19: arraylength
    //   20: if_icmpge +46 -> 66
    //   23: iload_1
    //   24: i2l
    //   25: lstore 5
    //   27: aload_0
    //   28: iload_3
    //   29: aaload
    //   30: invokestatic 27	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   33: lstore 7
    //   35: lload 5
    //   37: lload 7
    //   39: iload_2
    //   40: lshl
    //   41: lor
    //   42: l2i
    //   43: istore_1
    //   44: iload_3
    //   45: iconst_1
    //   46: iadd
    //   47: istore_3
    //   48: iload_2
    //   49: bipush 8
    //   51: isub
    //   52: istore_2
    //   53: goto -39 -> 14
    //   56: astore_0
    //   57: iconst_0
    //   58: istore_1
    //   59: aload_0
    //   60: invokevirtual 30	java/lang/Exception:printStackTrace	()V
    //   63: iload_1
    //   64: istore 4
    //   66: iload 4
    //   68: ireturn
    //   69: astore_0
    //   70: goto -11 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramString	String
    //   13	51	1	i	int
    //   11	42	2	j	int
    //   1	47	3	k	int
    //   15	52	4	m	int
    //   25	11	5	l1	long
    //   33	5	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	9	56	java/lang/Exception
    //   17	23	69	java/lang/Exception
    //   27	35	69	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    int i;
    if (!TextUtils.isEmpty(paramString4))
    {
      i = paramString4.indexOf(paramQQAppInterface.getApp().getString(2131438727));
      if (i != -1) {}
    }
    else
    {
      return;
    }
    paramString4 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString4, paramInt, -5023, 1245186, MessageCache.a());
    paramString4.f = false;
    paramString4.a = paramLong;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 12);
    paramString4.a(i, i + 4, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString4);
    ((MessageForUniteGrayTip)localObject).masterUin = paramString2;
    ((MessageForUniteGrayTip)localObject).extUin = paramString1;
    ((MessageForUniteGrayTip)localObject).taskId = paramString3;
    UniteGrayTipUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    long l = MessageCache.a();
    paramString1 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, paramInt, -5020, 1245187, l);
    paramString1.f = false;
    paramString1.a = l;
    paramString2 = new MessageForUniteGrayTip();
    paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
    UniteGrayTipUtil.a(paramQQAppInterface, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.qidian.util.QidianUtils
 * JD-Core Version:    0.7.0.1
 */