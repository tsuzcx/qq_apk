package okio;

public final class Utf8
{
  public static long size(String paramString)
  {
    return size(paramString, 0, paramString.length());
  }
  
  public static long size(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= paramInt1)
        {
          if (paramInt2 <= paramString.length())
          {
            long l1 = 0L;
            while (paramInt1 < paramInt2)
            {
              int k = paramString.charAt(paramInt1);
              if (k < 128)
              {
                l1 += 1L;
                label50:
                paramInt1 += 1;
              }
              else
              {
                if (k < 2048) {}
                for (long l2 = 2L;; l2 = 3L)
                {
                  l1 += l2;
                  break label50;
                  if ((k >= 55296) && (k <= 57343))
                  {
                    int j = paramInt1 + 1;
                    int i;
                    if (j < paramInt2) {
                      i = paramString.charAt(j);
                    } else {
                      i = 0;
                    }
                    if ((k <= 56319) && (i >= 56320) && (i <= 57343))
                    {
                      l1 += 4L;
                      paramInt1 += 2;
                      break;
                    }
                    l1 += 1L;
                    paramInt1 = j;
                    break;
                  }
                }
              }
            }
            return l1;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("endIndex > string.length: ");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(" > ");
          localStringBuilder.append(paramString.length());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        paramString = new StringBuilder();
        paramString.append("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("beginIndex < 0: ");
      paramString.append(paramInt1);
      throw new IllegalArgumentException(paramString.toString());
    }
    paramString = new IllegalArgumentException("string == null");
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.Utf8
 * JD-Core Version:    0.7.0.1
 */