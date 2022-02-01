package okhttp3;

import java.util.Comparator;

class CipherSuite$1
  implements Comparator<String>
{
  public int compare(String paramString1, String paramString2)
  {
    int i = 4;
    int j = Math.min(paramString1.length(), paramString2.length());
    if (i < j)
    {
      int k = paramString1.charAt(i);
      int m = paramString2.charAt(i);
      if (k != m) {
        if (k >= m) {}
      }
    }
    do
    {
      return -1;
      return 1;
      i += 1;
      break;
      i = paramString1.length();
      j = paramString2.length();
      if (i == j) {
        break label85;
      }
    } while (i < j);
    return 1;
    label85:
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.CipherSuite.1
 * JD-Core Version:    0.7.0.1
 */