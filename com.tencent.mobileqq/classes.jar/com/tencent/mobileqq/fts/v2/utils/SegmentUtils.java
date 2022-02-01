package com.tencent.mobileqq.fts.v2.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.v2.logger.ILogger;
import java.util.ArrayList;
import java.util.Arrays;

public class SegmentUtils
{
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 17	java/lang/StringBuilder
    //   3: dup
    //   4: bipush 64
    //   6: invokespecial 20	java/lang/StringBuilder:<init>	(I)V
    //   9: astore_2
    //   10: new 22	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer
    //   13: dup
    //   14: new 24	java/io/StringReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 27	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokevirtual 33	java/lang/String:length	()I
    //   26: invokespecial 36	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer:<init>	(Ljava/io/Reader;I)V
    //   29: astore_3
    //   30: aconst_null
    //   31: astore_0
    //   32: aload_3
    //   33: invokevirtual 39	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer:a	()Lcom/tencent/mobileqq/fts/v2/tokenizer/Token;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +60 -> 98
    //   41: aload_0
    //   42: ifnull +214 -> 256
    //   45: aload_0
    //   46: invokevirtual 45	com/tencent/mobileqq/fts/v2/tokenizer/Token:d	()Ljava/lang/String;
    //   49: ldc 47
    //   51: invokestatic 53	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   54: ifeq +202 -> 256
    //   57: aload_0
    //   58: invokevirtual 55	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   61: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +192 -> 256
    //   67: aload_2
    //   68: aload_0
    //   69: invokevirtual 55	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   72: aload_0
    //   73: invokevirtual 55	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   76: invokevirtual 33	java/lang/String:length	()I
    //   79: iconst_1
    //   80: isub
    //   81: invokevirtual 63	java/lang/String:charAt	(I)C
    //   84: invokevirtual 67	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_2
    //   89: ldc 69
    //   91: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: goto +161 -> 256
    //   98: aload_0
    //   99: ifnull +83 -> 182
    //   102: aload_0
    //   103: invokevirtual 45	com/tencent/mobileqq/fts/v2/tokenizer/Token:d	()Ljava/lang/String;
    //   106: ldc 47
    //   108: invokestatic 53	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   111: ifeq +71 -> 182
    //   114: aload_1
    //   115: invokevirtual 45	com/tencent/mobileqq/fts/v2/tokenizer/Token:d	()Ljava/lang/String;
    //   118: ldc 47
    //   120: invokestatic 53	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   123: ifeq +14 -> 137
    //   126: aload_0
    //   127: invokevirtual 75	com/tencent/mobileqq/fts/v2/tokenizer/Token:c	()I
    //   130: aload_1
    //   131: invokevirtual 78	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()I
    //   134: if_icmpge +48 -> 182
    //   137: aload_0
    //   138: invokevirtual 55	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   141: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +38 -> 182
    //   147: aload_2
    //   148: aload_0
    //   149: invokevirtual 55	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   152: aload_0
    //   153: invokevirtual 55	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   156: invokevirtual 33	java/lang/String:length	()I
    //   159: iconst_1
    //   160: isub
    //   161: invokevirtual 63	java/lang/String:charAt	(I)C
    //   164: invokevirtual 67	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_2
    //   169: ldc 69
    //   171: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: bipush 32
    //   178: invokevirtual 67	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_1
    //   183: invokevirtual 55	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   186: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +42 -> 231
    //   192: aload_1
    //   193: invokevirtual 45	com/tencent/mobileqq/fts/v2/tokenizer/Token:d	()Ljava/lang/String;
    //   196: ldc 47
    //   198: invokestatic 53	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   201: ifeq +14 -> 215
    //   204: aload_1
    //   205: invokevirtual 55	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   208: invokevirtual 33	java/lang/String:length	()I
    //   211: iconst_1
    //   212: if_icmpeq +19 -> 231
    //   215: aload_2
    //   216: aload_1
    //   217: invokevirtual 55	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   220: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: bipush 32
    //   227: invokevirtual 67	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: astore_0
    //   233: goto -201 -> 32
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   241: invokestatic 86	com/tencent/mobileqq/fts/FTSDatabase:a	()Lcom/tencent/mobileqq/fts/v2/logger/ILogger;
    //   244: ldc 88
    //   246: ldc 90
    //   248: ldc 92
    //   250: aload_0
    //   251: invokeinterface 97 5 0
    //   256: aload_2
    //   257: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: astore_0
    //   261: aload_0
    //   262: areturn
    //   263: astore_0
    //   264: aload_0
    //   265: invokevirtual 101	java/lang/Throwable:printStackTrace	()V
    //   268: invokestatic 86	com/tencent/mobileqq/fts/FTSDatabase:a	()Lcom/tencent/mobileqq/fts/v2/logger/ILogger;
    //   271: ldc 88
    //   273: ldc 90
    //   275: ldc 92
    //   277: aload_0
    //   278: invokeinterface 97 5 0
    //   283: aconst_null
    //   284: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramString	String
    //   36	196	1	localToken	com.tencent.mobileqq.fts.v2.tokenizer.Token
    //   9	248	2	localStringBuilder	StringBuilder
    //   29	4	3	localCJKTokenizer	com.tencent.mobileqq.fts.v2.tokenizer.cjk.CJKTokenizer
    // Exception table:
    //   from	to	target	type
    //   32	37	236	java/io/IOException
    //   45	95	236	java/io/IOException
    //   102	137	236	java/io/IOException
    //   137	182	236	java/io/IOException
    //   182	215	236	java/io/IOException
    //   215	231	236	java/io/IOException
    //   0	30	263	java/lang/Throwable
    //   32	37	263	java/lang/Throwable
    //   45	95	263	java/lang/Throwable
    //   102	137	263	java/lang/Throwable
    //   137	182	263	java/lang/Throwable
    //   182	215	263	java/lang/Throwable
    //   215	231	263	java/lang/Throwable
    //   237	256	263	java/lang/Throwable
    //   256	261	263	java/lang/Throwable
  }
  
  public static String[] b(String paramString)
  {
    Object localObject = c(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    int j = 0;
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      String str = a((String)((ArrayList)localObject).get(i));
      if (!TextUtils.isEmpty(str)) {
        paramString.add(str.trim());
      }
      i += 1;
    }
    if (paramString.size() == 0) {
      return null;
    }
    localObject = new String[paramString.size()];
    i = j;
    while (i < paramString.size())
    {
      localObject[i] = ((String)paramString.get(i));
      i += 1;
    }
    return localObject;
  }
  
  public static ArrayList<String> c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("\\s");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      String str = paramString[i].trim();
      if ((str != null) && (!TextUtils.isEmpty(str))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String[] d(String paramString)
  {
    Object localObject2 = b(paramString);
    Object localObject1 = FTSDatabase.a();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("query segments = ");
    ((StringBuilder)localObject3).append(Arrays.toString((Object[])localObject2));
    ((ILogger)localObject1).a("SegmentUtils", "i", ((StringBuilder)localObject3).toString());
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label268;
      }
      localObject1 = new String[1];
      localObject1[0] = paramString;
    }
    paramString = new String[localObject1.length];
    int i = 0;
    while (i < localObject1.length)
    {
      localObject2 = new StringBuilder(64);
      localObject3 = localObject1[i].split(" ");
      int j = 0;
      while (j < localObject3.length)
      {
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(" ");
        }
        if ((localObject3[j].length() != 1) && ((localObject3[j].charAt(0) < '0') || (localObject3[j].charAt(0) > '9')) && ((localObject3[j].charAt(0) < 'a') || (localObject3[j].charAt(0) > 'z')))
        {
          ((StringBuilder)localObject2).append(localObject3[j]);
        }
        else
        {
          ((StringBuilder)localObject2).append(localObject3[j]);
          ((StringBuilder)localObject2).append("*");
        }
        j += 1;
      }
      paramString[i] = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    return paramString;
    label268:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.utils.SegmentUtils
 * JD-Core Version:    0.7.0.1
 */