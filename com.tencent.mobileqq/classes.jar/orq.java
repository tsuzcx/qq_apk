public class orq
{
  private static String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "&agrave;", "à" };
    String[] arrayOfString2 = { "&acirc;", "â" };
    String[] arrayOfString3 = { "&auml;", "ä" };
    String[] arrayOfString4 = { "&Acirc;", "Â" };
    String[] arrayOfString5 = { "&aring;", "å" };
    String[] arrayOfString6 = { "&Ccedil;", "Ç" };
    String[] arrayOfString7 = { "&Ecirc;", "Ê" };
    String[] arrayOfString8 = { "&Euml;", "Ë" };
    String[] arrayOfString9 = { "&iuml;", "ï" };
    String[] arrayOfString10 = { "&ouml;", "ö" };
    String[] arrayOfString11 = { "&Ouml;", "Ö" };
    String[] arrayOfString12 = { "&Oslash;", "Ø" };
    String[] arrayOfString13 = { "&ugrave;", "ù" };
    String[] arrayOfString14 = { "&ucirc;", "û" };
    String[] arrayOfString15 = { "&uuml;", "ü" };
    String[] arrayOfString16 = { "&copy;", "©" };
    String[] arrayOfString17 = { "&reg;", "®" };
    a = new String[][] { { "&lt;", "<" }, { "&gt;", ">" }, { "&amp;", "&" }, { "&quot;", "\"" }, arrayOfString1, { "&Agrave;", "À" }, arrayOfString2, arrayOfString3, { "&Auml;", "Ä" }, arrayOfString4, arrayOfString5, { "&Aring;", "Å" }, { "&aelig;", "æ" }, { "&AElig;", "Æ" }, { "&ccedil;", "ç" }, arrayOfString6, { "&eacute;", "é" }, { "&Eacute;", "É" }, { "&egrave;", "è" }, { "&Egrave;", "È" }, { "&ecirc;", "ê" }, arrayOfString7, { "&euml;", "ë" }, arrayOfString8, arrayOfString9, { "&Iuml;", "Ï" }, { "&ocirc;", "ô" }, { "&Ocirc;", "Ô" }, arrayOfString10, arrayOfString11, { "&oslash;", "ø" }, arrayOfString12, { "&szlig;", "ß" }, arrayOfString13, { "&Ugrave;", "Ù" }, arrayOfString14, { "&Ucirc;", "Û" }, arrayOfString15, { "&Uuml;", "Ü" }, { "&nbsp;", " " }, arrayOfString16, arrayOfString17, { "&euro;", "₠" } };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     orq
 * JD-Core Version:    0.7.0.1
 */