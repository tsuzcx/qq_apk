public class obx
{
  private static String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "&lt;", "<" };
    String[] arrayOfString2 = { "&gt;", ">" };
    String[] arrayOfString3 = { "&amp;", "&" };
    String[] arrayOfString4 = { "&quot;", "\"" };
    String[] arrayOfString5 = { "&agrave;", "à" };
    String[] arrayOfString6 = { "&Agrave;", "À" };
    String[] arrayOfString7 = { "&acirc;", "â" };
    String[] arrayOfString8 = { "&auml;", "ä" };
    String[] arrayOfString9 = { "&Auml;", "Ä" };
    String[] arrayOfString10 = { "&aring;", "å" };
    String[] arrayOfString11 = { "&Aring;", "Å" };
    String[] arrayOfString12 = { "&aelig;", "æ" };
    String[] arrayOfString13 = { "&AElig;", "Æ" };
    String[] arrayOfString14 = { "&ccedil;", "ç" };
    String[] arrayOfString15 = { "&Ccedil;", "Ç" };
    String[] arrayOfString16 = { "&eacute;", "é" };
    String[] arrayOfString17 = { "&Eacute;", "É" };
    String[] arrayOfString18 = { "&egrave;", "è" };
    String[] arrayOfString19 = { "&Egrave;", "È" };
    String[] arrayOfString20 = { "&Ecirc;", "Ê" };
    String[] arrayOfString21 = { "&Euml;", "Ë" };
    String[] arrayOfString22 = { "&iuml;", "ï" };
    String[] arrayOfString23 = { "&Iuml;", "Ï" };
    String[] arrayOfString24 = { "&ocirc;", "ô" };
    String[] arrayOfString25 = { "&Ocirc;", "Ô" };
    String[] arrayOfString26 = { "&ouml;", "ö" };
    String[] arrayOfString27 = { "&Ouml;", "Ö" };
    String[] arrayOfString28 = { "&Oslash;", "Ø" };
    String[] arrayOfString29 = { "&Ugrave;", "Ù" };
    String[] arrayOfString30 = { "&ucirc;", "û" };
    String[] arrayOfString31 = { "&Ucirc;", "Û" };
    String[] arrayOfString32 = { "&nbsp;", " " };
    String[] arrayOfString33 = { "&reg;", "®" };
    String[] arrayOfString34 = { "&euro;", "₠" };
    a = new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, { "&Acirc;", "Â" }, arrayOfString10, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, { "&ecirc;", "ê" }, arrayOfString20, { "&euml;", "ë" }, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, arrayOfString27, { "&oslash;", "ø" }, arrayOfString28, { "&szlig;", "ß" }, { "&ugrave;", "ù" }, arrayOfString29, arrayOfString30, arrayOfString31, { "&uuml;", "ü" }, { "&Uuml;", "Ü" }, arrayOfString32, { "&copy;", "©" }, arrayOfString33, arrayOfString34 };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     obx
 * JD-Core Version:    0.7.0.1
 */