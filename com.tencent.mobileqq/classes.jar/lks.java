import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class lks
{
  public static int a;
  
  public static aykk a(String paramString, int paramInt)
  {
    return new aykk(a(paramString), 3, paramInt);
  }
  
  public static String a(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (paramInt >= 0)
    {
      str1 = str2;
      if (paramInt < ayjy.a.length) {
        str1 = '\024' + ayjy.a[paramInt];
      }
    }
    return str1;
  }
  
  public static String a(ayku paramayku)
  {
    int j = 0;
    if (paramayku == null) {
      return null;
    }
    int i = paramayku.length();
    Object localObject1 = new char[i];
    paramayku.getChars(0, i, (char[])localObject1, 0);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject2 = (aykr[])paramayku.getSpans(0, i, aykr.class);
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
          ((ArrayList)localObject1).add(lkt.a((aykr)localObject3, paramayku.getSpanStart(localObject3), paramayku.getSpanEnd(localObject3)));
        }
      }
      Collections.sort((List)localObject1, lkt.jdField_a_of_type_JavaUtilComparator);
      localObject2 = ((ArrayList)localObject1).iterator();
      i = j;
      if (((Iterator)localObject2).hasNext())
      {
        paramayku = (lkt)((Iterator)localObject2).next();
        localObject3 = paramayku.jdField_a_of_type_Aykr;
        int k = paramayku.jdField_a_of_type_Int;
        j = paramayku.b;
        switch (((aykr)localObject3).c)
        {
        default: 
          paramayku = localStringBuilder2.substring(k, j);
        }
        for (;;)
        {
          if (i < k) {
            localStringBuilder1.append(localStringBuilder2.substring(i, k));
          }
          localStringBuilder1.append(paramayku);
          i = j;
          break;
          paramayku = '\024' + ((aykr)localObject3).a();
          continue;
          paramayku = a(((aykr)localObject3).jdField_a_of_type_Int & 0x7FFFFFFF);
        }
      }
      if (i < localStringBuilder2.length()) {
        localStringBuilder1.append(localStringBuilder2.substring(i));
      }
      lkt.a((List)localObject1);
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
    if (TextUtils.isEmpty(paramString)) {
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
        if (i < ayjy.a.length)
        {
          localObject2 = localObject1;
          str = '\024' + ayjy.a[i];
          localObject2 = localObject1;
          paramString = (String)localObject1;
          if (((String)localObject1).indexOf(str) != -1)
          {
            localObject2 = localObject1;
            paramString = ((String)localObject1).replace(str, aylc.c(i));
          }
        }
        else
        {
          for (;;)
          {
            localObject2 = paramString;
            localObject1 = paramString;
            if (j >= ayjy.a.length) {
              break;
            }
            localObject2 = paramString;
            str = ayjy.a[j];
            localObject1 = paramString;
            localObject2 = paramString;
            if (paramString.indexOf(str) != -1)
            {
              localObject2 = paramString;
              localObject1 = paramString.replace(str, aylc.c(j));
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
    int i = lcx.a().a().d;
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, String.format("doReport, tag[%s], fromType[%s]", new Object[] { paramString, Integer.valueOf(i) }));
    }
    axqy.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lks
 * JD-Core Version:    0.7.0.1
 */