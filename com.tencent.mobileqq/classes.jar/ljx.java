import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ljx
{
  public static int a;
  
  public static QQText a(String paramString, int paramInt)
  {
    return new QQText(a(paramString), 3, paramInt);
  }
  
  public static String a(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (paramInt >= 0)
    {
      str1 = str2;
      if (paramInt < EmotcationConstants.SYS_EMOTICON_SYMBOL.length) {
        str1 = '\024' + EmotcationConstants.SYS_EMOTICON_SYMBOL[paramInt];
      }
    }
    return str1;
  }
  
  public static String a(QQTextBuilder paramQQTextBuilder)
  {
    int j = 0;
    if (paramQQTextBuilder == null) {
      return null;
    }
    int i = paramQQTextBuilder.length();
    Object localObject1 = new char[i];
    paramQQTextBuilder.getChars(0, i, (char[])localObject1, 0);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject2 = (QQText.EmoticonSpan[])paramQQTextBuilder.getSpans(0, i, QQText.EmoticonSpan.class);
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append((char[])localObject1);
      localObject1 = new ArrayList(localObject2.length);
      i = 0;
      Object localObject3;
      if (i < localObject2.length)
      {
        localObject3 = localObject2[i];
        if (localObject3 == null) {}
        for (;;)
        {
          i += 1;
          break;
          ((ArrayList)localObject1).add(ljy.a((QQText.EmoticonSpan)localObject3, paramQQTextBuilder.getSpanStart(localObject3), paramQQTextBuilder.getSpanEnd(localObject3)));
        }
      }
      Collections.sort((List)localObject1, ljy.jdField_a_of_type_JavaUtilComparator);
      localObject2 = ((ArrayList)localObject1).iterator();
      i = j;
      if (((Iterator)localObject2).hasNext())
      {
        paramQQTextBuilder = (ljy)((Iterator)localObject2).next();
        localObject3 = paramQQTextBuilder.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan;
        int k = paramQQTextBuilder.jdField_a_of_type_Int;
        j = paramQQTextBuilder.b;
        switch (((QQText.EmoticonSpan)localObject3).emojiType)
        {
        default: 
          paramQQTextBuilder = localStringBuilder2.substring(k, j);
        }
        for (;;)
        {
          if (i < k) {
            localStringBuilder1.append(localStringBuilder2.substring(i, k));
          }
          localStringBuilder1.append(paramQQTextBuilder);
          i = j;
          break;
          paramQQTextBuilder = '\024' + ((QQText.EmoticonSpan)localObject3).getDescription();
          continue;
          paramQQTextBuilder = a(((QQText.EmoticonSpan)localObject3).index & 0x7FFFFFFF);
        }
      }
      if (i < localStringBuilder2.length()) {
        localStringBuilder1.append(localStringBuilder2.substring(i));
      }
      ljy.a((List)localObject1);
    }
    for (;;)
    {
      return localStringBuilder1.toString();
      localStringBuilder1.append((char[])localObject1);
    }
  }
  
  public static String a(String paramString)
  {
    int k = 0;
    if (android.text.TextUtils.isEmpty(paramString)) {
      localObject1 = "";
    }
    do
    {
      return localObject1;
      localObject1 = paramString;
    } while (paramString.indexOf("/") == -1);
    int i = 0;
    for (Object localObject1 = paramString;; localObject1 = paramString)
    {
      paramString = (String)localObject1;
      int j = k;
      Object localObject2 = localObject1;
      try
      {
        String str;
        if (i < EmotcationConstants.SYS_EMOTICON_SYMBOL.length)
        {
          localObject2 = localObject1;
          str = '\024' + EmotcationConstants.SYS_EMOTICON_SYMBOL[i];
          localObject2 = localObject1;
          paramString = (String)localObject1;
          if (((String)localObject1).indexOf(str) != -1)
          {
            localObject2 = localObject1;
            paramString = ((String)localObject1).replace(str, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i));
          }
        }
        else
        {
          for (;;)
          {
            localObject2 = paramString;
            localObject1 = paramString;
            if (j >= EmotcationConstants.SYS_EMOTICON_SYMBOL.length) {
              break;
            }
            localObject2 = paramString;
            str = EmotcationConstants.SYS_EMOTICON_SYMBOL[j];
            localObject1 = paramString;
            localObject2 = paramString;
            if (paramString.indexOf(str) != -1)
            {
              localObject2 = paramString;
              localObject1 = paramString.replace(str, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(j));
            }
            j += 1;
            paramString = (String)localObject1;
          }
          return localObject1;
        }
      }
      catch (Exception paramString)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("ChatRoomUtil", 2, "convertMsg exception", paramString);
          localObject1 = localObject2;
        }
      }
      i += 1;
    }
  }
  
  public static void a(String paramString)
  {
    int i = lbu.a().a().d;
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, String.format("doReport, tag[%s], fromType[%s]", new Object[] { paramString, Integer.valueOf(i) }));
    }
    bcef.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljx
 * JD-Core Version:    0.7.0.1
 */