package com.tencent.mobileqq.writetogether.client;

import com.tencent.mobileqq.easysync2.Changeset.Builder;
import com.tencent.mobileqq.easysync2.IChangesetTracker;
import com.tencent.util.Pair;
import java.util.Arrays;

public class OtHelper
{
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    int j;
    for (int i = 0; (paramString != null) && (paramInt1 < paramInt2); i = j)
    {
      j = i;
      if (paramString.charAt(paramInt1) == '\n') {
        j = i + 1;
      }
      paramInt1 += 1;
    }
    return i;
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Changeset.Builder(paramString3.length() + paramInt2);
    paramString1.a(paramInt1, a(paramString2, 0, paramInt1));
    paramString1.b(paramInt2, a(paramString2, 0, paramInt1));
    return paramString1.toString();
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, IChangesetTracker paramIChangesetTracker)
  {
    paramString3 = new Changeset.Builder(paramString3.length() - paramInt2);
    paramString3.a(paramInt1, a(paramString2, 0, paramInt1));
    paramString3.a(paramString1, Arrays.asList(new Pair[] { new Pair("author", paramString4) }), paramIChangesetTracker.d());
    return paramString3.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.OtHelper
 * JD-Core Version:    0.7.0.1
 */