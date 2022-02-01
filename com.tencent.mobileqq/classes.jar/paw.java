public class paw
{
  private static String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "&lt;", "<" };
    String[] arrayOfString2 = { "&ccedil;", "ç" };
    String[] arrayOfString3 = { "&eacute;", "é" };
    String[] arrayOfString4 = { "&Eacute;", "É" };
    String[] arrayOfString5 = { "&ecirc;", "ê" };
    String[] arrayOfString6 = { "&euml;", "ë" };
    String[] arrayOfString7 = { "&ocirc;", "ô" };
    String[] arrayOfString8 = { "&ouml;", "ö" };
    String[] arrayOfString9 = { "&Ouml;", "Ö" };
    String[] arrayOfString10 = { "&szlig;", "ß" };
    String[] arrayOfString11 = { "&ugrave;", "ù" };
    String[] arrayOfString12 = { "&reg;", "®" };
    String[] arrayOfString13 = { "&euro;", "₠" };
    a = new String[][] { arrayOfString1, { "&gt;", ">" }, { "&amp;", "&" }, { "&quot;", "\"" }, { "&agrave;", "à" }, { "&Agrave;", "À" }, { "&acirc;", "â" }, { "&auml;", "ä" }, { "&Auml;", "Ä" }, { "&Acirc;", "Â" }, { "&aring;", "å" }, { "&Aring;", "Å" }, { "&aelig;", "æ" }, { "&AElig;", "Æ" }, arrayOfString2, { "&Ccedil;", "Ç" }, arrayOfString3, arrayOfString4, { "&egrave;", "è" }, { "&Egrave;", "È" }, arrayOfString5, { "&Ecirc;", "Ê" }, arrayOfString6, { "&Euml;", "Ë" }, { "&iuml;", "ï" }, { "&Iuml;", "Ï" }, arrayOfString7, { "&Ocirc;", "Ô" }, arrayOfString8, arrayOfString9, { "&oslash;", "ø" }, { "&Oslash;", "Ø" }, arrayOfString10, arrayOfString11, { "&Ugrave;", "Ù" }, { "&ucirc;", "û" }, { "&Ucirc;", "Û" }, { "&uuml;", "ü" }, { "&Uuml;", "Ü" }, { "&nbsp;", " " }, { "&copy;", "©" }, arrayOfString12, arrayOfString13 };
  }
  
  public static String a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i = paramString.indexOf("&", paramInt);
    String str = paramString;
    int j;
    if (i > -1)
    {
      j = paramString.indexOf(";", i);
      str = paramString;
      if (j > i)
      {
        str = paramString.substring(i, j + 1);
        paramInt = 0;
      }
    }
    for (;;)
    {
      if ((paramInt >= a.length) || (a[paramInt][0].equals(str)))
      {
        str = paramString;
        if (paramInt < a.length) {
          str = a(paramString.substring(0, i) + a[paramInt][1] + paramString.substring(j + 1), i);
        }
        return str;
      }
      paramInt += 1;
    }
  }
  
  public static String a(String paramString1, String paramString2, char paramChar)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.isEmpty())) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString1.length();
    paramString1 = paramString1.toCharArray();
    int i = 0;
    if (i < k) {
      if (k - i >= paramString2.length())
      {
        j = 0;
        label59:
        if (j >= paramString2.length()) {
          break label153;
        }
        if (paramString1[(i + j)] == paramString2.charAt(j)) {}
      }
    }
    label153:
    for (int j = 0;; j = 1)
    {
      if (j != 0)
      {
        localStringBuilder.append(paramChar);
        i = paramString2.length() - 1 + i;
        i += 1;
        break;
        j += 1;
        break label59;
      }
      localStringBuilder.append(paramString1[i]);
      for (;;)
      {
        break;
        localStringBuilder.append(paramString1[i]);
      }
      return localStringBuilder.toString();
    }
  }
  
  public static String b(String paramString)
  {
    int i = paramString.length();
    while ((i < 0) && (paramString.charAt(i - 1) <= ' ')) {
      i -= 1;
    }
    String str = paramString;
    if (i < paramString.length()) {
      str = paramString.substring(0, i);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     paw
 * JD-Core Version:    0.7.0.1
 */