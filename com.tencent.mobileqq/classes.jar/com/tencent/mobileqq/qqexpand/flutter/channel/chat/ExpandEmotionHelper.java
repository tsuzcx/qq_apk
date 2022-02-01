package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExpandEmotionHelper
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) == '\024')
      {
        int j = i + 1;
        if (j < paramString.length())
        {
          int k = paramString.charAt(j);
          if (a(k))
          {
            int m = QQSysFaceUtil.convertToServer(k);
            localStringBuilder1.append(paramString.charAt(i));
            localStringBuilder1.append(m);
            localStringBuilder1.append("/");
            StringBuilder localStringBuilder2;
            if (m == k)
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("unrecognized code? pos:");
              localStringBuilder2.append(j);
              localStringBuilder2.append(", ");
              localStringBuilder2.append(m);
              localStringBuilder2.append(",  content:");
              localStringBuilder2.append(paramString);
              QLog.w("expand.chat.ExpandSysEmotionHelper", 1, localStringBuilder2.toString());
            }
            if (QLog.isDebugVersion())
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("encodeQQEmotion value:[");
              localStringBuilder2.append(k);
              localStringBuilder2.append(", ");
              localStringBuilder2.append(m);
              localStringBuilder2.append(",  content:");
              localStringBuilder2.append(paramString);
              QLog.d("expand.chat.ExpandSysEmotionHelper", 2, localStringBuilder2.toString());
            }
            i = j;
            break label270;
          }
          localStringBuilder1.append(paramString.charAt(i));
          break label270;
        }
      }
      localStringBuilder1.append(paramString.charAt(i));
      label270:
      i += 1;
    }
    return localStringBuilder1.toString();
  }
  
  public static Map<String, String> a(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    String str1;
    while (paramList.hasNext())
    {
      str1 = (String)paramList.next();
      try
      {
        i = Integer.parseInt(str1);
        boolean bool = false;
        str2 = QQSysAndEmojiResMgr.getFullResPath(2, String.format("/s%d.png", new Object[] { Integer.valueOf(i) }));
        if (!TextUtils.isEmpty(str2)) {
          bool = new File(str2).exists();
        }
        if (bool) {}
      }
      catch (Exception localException1)
      {
        int i;
        String str2;
        label109:
        localHashMap.put(str1, "");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getEmotionPath error:");
        localStringBuilder.append(str1);
        localStringBuilder.append(" ");
        localStringBuilder.append(localException1);
        QLog.w("expand.chat.ExpandSysEmotionHelper", 1, localStringBuilder.toString());
      }
      try
      {
        i = QQSysFaceUtil.convertToLocal(i);
        QQSysAndEmojiResMgr.getInstance().getResImpl(1).addReloadDrawable(i);
      }
      catch (Exception localException2)
      {
        break label109;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEmotionPath error serverId:");
      localStringBuilder.append(str1);
      QLog.w("expand.chat.ExpandSysEmotionHelper", 1, localStringBuilder.toString());
      localHashMap.put(str1, str2);
    }
    return localHashMap;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandEmotionHelper
 * JD-Core Version:    0.7.0.1
 */