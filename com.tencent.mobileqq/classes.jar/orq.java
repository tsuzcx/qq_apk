public class orq
{
  private static String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "&lt;", "<" };
    String[] arrayOfString2 = { "&gt;", ">" };
    String[] arrayOfString3 = { "&agrave;", "à" };
    String[] arrayOfString4 = { "&Agrave;", "À" };
    String[] arrayOfString5 = { "&acirc;", "â" };
    String[] arrayOfString6 = { "&ccedil;", "ç" };
    String[] arrayOfString7 = { "&eacute;", "é" };
    String[] arrayOfString8 = { "&egrave;", "è" };
    String[] arrayOfString9 = { "&Egrave;", "È" };
    String[] arrayOfString10 = { "&ecirc;", "ê" };
    String[] arrayOfString11 = { "&Ecirc;", "Ê" };
    String[] arrayOfString12 = { "&Euml;", "Ë" };
    String[] arrayOfString13 = { "&ocirc;", "ô" };
    String[] arrayOfString14 = { "&ouml;", "ö" };
    String[] arrayOfString15 = { "&Oslash;", "Ø" };
    String[] arrayOfString16 = { "&Ugrave;", "Ù" };
    String[] arrayOfString17 = { "&Ucirc;", "Û" };
    String[] arrayOfString18 = { "&Uuml;", "Ü" };
    a = new String[][] { arrayOfString1, arrayOfString2, { "&amp;", "&" }, { "&quot;", "\"" }, arrayOfString3, arrayOfString4, arrayOfString5, { "&auml;", "ä" }, { "&Auml;", "Ä" }, { "&Acirc;", "Â" }, { "&aring;", "å" }, { "&Aring;", "Å" }, { "&aelig;", "æ" }, { "&AElig;", "Æ" }, arrayOfString6, { "&Ccedil;", "Ç" }, arrayOfString7, { "&Eacute;", "É" }, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, { "&euml;", "ë" }, arrayOfString12, { "&iuml;", "ï" }, { "&Iuml;", "Ï" }, arrayOfString13, { "&Ocirc;", "Ô" }, arrayOfString14, { "&Ouml;", "Ö" }, { "&oslash;", "ø" }, arrayOfString15, { "&szlig;", "ß" }, { "&ugrave;", "ù" }, arrayOfString16, { "&ucirc;", "û" }, arrayOfString17, { "&uuml;", "ü" }, arrayOfString18, { "&nbsp;", " " }, { "&copy;", "©" }, { "&reg;", "®" }, { "&euro;", "₠" } };
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