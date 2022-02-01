package com.tencent.mobileqq.msgbackup.data;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/msgbackup/data/MsgbackupMsgGenerator$Companion;", "", "()V", "RANDOM", "Ljava/util/Random;", "TEST_DECRY_KEY", "", "TEST_ENTRY_KEY", "TEST_FILE_META", "selfuin", "clearAllMsgTable", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "createMsg", "Lcom/tencent/mobileqq/data/MessageRecord;", "text", "msgtype", "", "friendUin", "uinType", "senderuin", "isSend", "", "msgseq", "", "shmsgseq", "msgUid", "generateText", "count", "generateTextMsgList", "", "insertDB", "msgList", "isAble", "letters", "numbers", "ch", "", "random", "start", "end", "chars", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class MsgbackupMsgGenerator$Companion
{
  private final boolean a(boolean paramBoolean1, boolean paramBoolean2, char paramChar)
  {
    return ((paramBoolean1) && (Character.isLetter(paramChar))) || ((paramBoolean2) && (Character.isDigit(paramChar))) || ((!paramBoolean1) && (!paramBoolean2));
  }
  
  @JvmStatic
  @NotNull
  public final MessageRecord a(@Nullable String paramString1, int paramInt1, @Nullable String paramString2, int paramInt2, @Nullable String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @JvmStatic
  @NotNull
  public final String a(int paramInt)
  {
    return a((Companion)this, paramInt, 0, 0, false, false, null, null, 126, null);
  }
  
  @JvmOverloads
  @NotNull
  public final String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, @Nullable char[] paramArrayOfChar, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    char[] arrayOfChar = new char[paramInt1];
    int j = paramInt3 - paramInt2;
    label207:
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
      if (((Companion)this).a(paramBoolean1, paramBoolean2, i)) {
        if ((i >= 56320) && (i <= 57343))
        {
          if (paramInt3 != 0)
          {
            arrayOfChar[paramInt3] = i;
            paramInt1 = paramInt3 - 1;
            arrayOfChar[paramInt1] = ((char)(paramRandom.nextInt(128) + 55296));
            break label207;
          }
        }
        else if ((i >= 55296) && (i <= 56191))
        {
          if (paramInt3 != 0)
          {
            arrayOfChar[paramInt3] = ((char)(paramRandom.nextInt(128) + 56320));
            paramInt1 = paramInt3 - 1;
            arrayOfChar[paramInt1] = i;
            break label207;
          }
        }
        else if ((i < 56192) || (i > 56319))
        {
          arrayOfChar[paramInt3] = i;
          paramInt1 = paramInt3;
          break label207;
        }
      }
      paramInt1 = paramInt3 + 1;
    }
    return new String(arrayOfChar);
  }
  
  @JvmStatic
  @NotNull
  public final List<MessageRecord> a(@Nullable String paramString1, int paramInt1, @Nullable String paramString2, int paramInt2, @Nullable String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramString1 != null) {
      i = paramString1.length();
    } else {
      i = 0;
    }
    String str = "";
    int j = 0;
    while (j < paramInt1)
    {
      if (TextUtils.isEmpty((CharSequence)paramString1))
      {
        str = ((Companion)this).a(100);
      }
      else
      {
        int k = j * 100;
        if (i >= k)
        {
          if (paramString1 == null) {
            Intrinsics.throwNpe();
          }
          if (paramString1 != null)
          {
            str = paramString1.substring(k, k + 100);
            Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
        }
      }
      long l1 = MessageUtils.a(j);
      long l2 = MessageUtils.a(j);
      MessageRecord localMessageRecord = ((Companion)this).a(str, -1000, paramString2, paramInt2, paramString3, true, l2, l2, l1);
      Object localObject = Charsets.UTF_8;
      if (str != null)
      {
        localObject = str.getBytes((Charset)localObject);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
        localMessageRecord.msgData = ((byte[])localObject);
        localArrayList.add(localMessageRecord);
        j += 1;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    return (List)localArrayList;
  }
  
  @JvmStatic
  public final void a(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    paramQQAppInterface.getMessageFacade().b();
  }
  
  @JvmStatic
  public final void a(@NotNull QQAppInterface paramQQAppInterface, @Nullable List<? extends MessageRecord> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    paramQQAppInterface.getMessageFacade().d(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgbackupMsgGenerator.Companion
 * JD-Core Version:    0.7.0.1
 */