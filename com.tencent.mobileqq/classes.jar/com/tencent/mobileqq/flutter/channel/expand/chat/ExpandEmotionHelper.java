package com.tencent.mobileqq.flutter.channel.expand.chat;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;

public class ExpandEmotionHelper
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 1 < paramString.length()))
      {
        int k = paramString.charAt(i + 1);
        if (a(k))
        {
          int m = QQSysFaceUtil.convertToServer(k);
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append(m);
          localStringBuilder.append("/");
          int j = i + 1;
          if (m == k) {
            QLog.w("expand.chat.ExpandSysEmotionHelper", 1, "unrecognized code? pos:" + j + ", " + m + ",  content:" + paramString);
          }
          i = j;
          if (QLog.isDebugVersion())
          {
            QLog.d("expand.chat.ExpandSysEmotionHelper", 2, "encodeQQEmotion value:[" + k + ", " + m + ",  content:" + paramString);
            i = j;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
        continue;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static java.util.Map<String, String> a(java.util.List<String> paramList)
  {
    // Byte code:
    //   0: new 83	java/util/HashMap
    //   3: dup
    //   4: invokespecial 84	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokeinterface 90 1 0
    //   14: astore_0
    //   15: aload_0
    //   16: invokeinterface 95 1 0
    //   21: ifeq +180 -> 201
    //   24: aload_0
    //   25: invokeinterface 99 1 0
    //   30: checkcast 22	java/lang/String
    //   33: astore 4
    //   35: aload 4
    //   37: invokestatic 105	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   40: istore_1
    //   41: iconst_2
    //   42: ldc 107
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: iload_1
    //   51: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: invokestatic 115	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   58: invokestatic 121	com/tencent/mobileqq/emoticon/QQSysAndEmojiResMgr:getFullResPath	(ILjava/lang/String;)Ljava/lang/String;
    //   61: astore 5
    //   63: aload 5
    //   65: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifne +135 -> 203
    //   71: new 123	java/io/File
    //   74: dup
    //   75: aload 5
    //   77: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: invokevirtual 129	java/io/File:exists	()Z
    //   83: istore_2
    //   84: iload_2
    //   85: ifne +19 -> 104
    //   88: iload_1
    //   89: invokestatic 132	com/tencent/mobileqq/emoticon/QQSysFaceUtil:convertToLocal	(I)I
    //   92: istore_1
    //   93: invokestatic 136	com/tencent/mobileqq/emoticon/QQSysAndEmojiResMgr:getInstance	()Lcom/tencent/mobileqq/emoticon/QQSysAndEmojiResMgr;
    //   96: iconst_1
    //   97: invokevirtual 140	com/tencent/mobileqq/emoticon/QQSysAndEmojiResMgr:getResImpl	(I)Lcom/tencent/mobileqq/emoticon/QQSysAndEmojiResInfo;
    //   100: iload_1
    //   101: invokevirtual 146	com/tencent/mobileqq/emoticon/QQSysAndEmojiResInfo:addReloadDrawable	(I)V
    //   104: aload_3
    //   105: aload 4
    //   107: aload 5
    //   109: invokeinterface 152 3 0
    //   114: pop
    //   115: goto -100 -> 15
    //   118: astore 5
    //   120: aload_3
    //   121: aload 4
    //   123: ldc 154
    //   125: invokeinterface 152 3 0
    //   130: pop
    //   131: ldc 53
    //   133: iconst_1
    //   134: new 19	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   141: ldc 156
    //   143: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 4
    //   148: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc 158
    //   153: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 5
    //   158: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 69	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: goto -152 -> 15
    //   170: astore 6
    //   172: ldc 53
    //   174: iconst_1
    //   175: new 19	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   182: ldc 163
    //   184: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 4
    //   189: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 69	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: goto -94 -> 104
    //   201: aload_3
    //   202: areturn
    //   203: iconst_0
    //   204: istore_2
    //   205: goto -121 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramList	java.util.List<String>
    //   40	61	1	i	int
    //   83	122	2	bool	boolean
    //   7	195	3	localHashMap	java.util.HashMap
    //   33	155	4	str1	String
    //   61	47	5	str2	String
    //   118	39	5	localException1	java.lang.Exception
    //   170	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   35	84	118	java/lang/Exception
    //   104	115	118	java/lang/Exception
    //   172	198	118	java/lang/Exception
    //   88	104	170	java/lang/Exception
  }
  
  public static boolean a(int paramInt)
  {
    if ((QQSysAndEmojiResMgr.getInstance().getResImpl(1).getServerId(paramInt) == -1) && (paramInt >= QQSysFaceUtil.LOCALE_TO_SERVER.length))
    {
      QLog.d("expand.chat.ExpandSysEmotionHelper", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandEmotionHelper
 * JD-Core Version:    0.7.0.1
 */