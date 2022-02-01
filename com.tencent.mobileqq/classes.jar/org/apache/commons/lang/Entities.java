package org.apache.commons.lang;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

class Entities
{
  private static final String[][] APOS_ARRAY;
  private static final String[][] BASIC_ARRAY = { { "quot", "34" }, { "amp", "38" }, { "lt", "60" }, { "gt", "62" } };
  public static final Entities HTML32;
  public static final Entities HTML40;
  static final String[][] HTML40_ARRAY;
  static final String[][] ISO8859_1_ARRAY;
  public static final Entities XML;
  private final Entities.EntityMap map;
  
  static
  {
    APOS_ARRAY = new String[][] { { "apos", "39" } };
    Object localObject = { "nbsp", "160" };
    String[] arrayOfString1 = { "iexcl", "161" };
    String[] arrayOfString2 = { "cent", "162" };
    String[] arrayOfString3 = { "curren", "164" };
    String[] arrayOfString4 = { "brvbar", "166" };
    String[] arrayOfString5 = { "sect", "167" };
    String[] arrayOfString6 = { "not", "172" };
    String[] arrayOfString7 = { "shy", "173" };
    String[] arrayOfString8 = { "macr", "175" };
    String[] arrayOfString9 = { "deg", "176" };
    String[] arrayOfString10 = { "plusmn", "177" };
    String[] arrayOfString11 = { "sup2", "178" };
    String[] arrayOfString12 = { "acute", "180" };
    String[] arrayOfString13 = { "micro", "181" };
    String[] arrayOfString14 = { "para", "182" };
    String[] arrayOfString15 = { "middot", "183" };
    String[] arrayOfString16 = { "cedil", "184" };
    String[] arrayOfString17 = { "sup1", "185" };
    String[] arrayOfString18 = { "ordm", "186" };
    String[] arrayOfString19 = { "frac14", "188" };
    String[] arrayOfString20 = { "frac34", "190" };
    String[] arrayOfString21 = { "iquest", "191" };
    String[] arrayOfString22 = { "Agrave", "192" };
    String[] arrayOfString23 = { "Aacute", "193" };
    String[] arrayOfString24 = { "Acirc", "194" };
    String[] arrayOfString25 = { "Atilde", "195" };
    String[] arrayOfString26 = { "Auml", "196" };
    String[] arrayOfString27 = { "Aring", "197" };
    String[] arrayOfString28 = { "AElig", "198" };
    String[] arrayOfString29 = { "Ccedil", "199" };
    String[] arrayOfString30 = { "Eacute", "201" };
    String[] arrayOfString31 = { "Ecirc", "202" };
    String[] arrayOfString32 = { "Igrave", "204" };
    String[] arrayOfString33 = { "Iacute", "205" };
    String[] arrayOfString34 = { "Icirc", "206" };
    String[] arrayOfString35 = { "Iuml", "207" };
    String[] arrayOfString36 = { "Ntilde", "209" };
    String[] arrayOfString37 = { "Oacute", "211" };
    String[] arrayOfString38 = { "Otilde", "213" };
    String[] arrayOfString39 = { "Ouml", "214" };
    String[] arrayOfString40 = { "times", "215" };
    String[] arrayOfString41 = { "Ucirc", "219" };
    String[] arrayOfString42 = { "Uuml", "220" };
    String[] arrayOfString43 = { "THORN", "222" };
    String[] arrayOfString44 = { "szlig", "223" };
    String[] arrayOfString45 = { "aacute", "225" };
    String[] arrayOfString46 = { "acirc", "226" };
    String[] arrayOfString47 = { "atilde", "227" };
    String[] arrayOfString48 = { "auml", "228" };
    String[] arrayOfString49 = { "aring", "229" };
    String[] arrayOfString50 = { "aelig", "230" };
    String[] arrayOfString51 = { "egrave", "232" };
    String[] arrayOfString52 = { "eacute", "233" };
    String[] arrayOfString53 = { "ecirc", "234" };
    String[] arrayOfString54 = { "euml", "235" };
    String[] arrayOfString55 = { "igrave", "236" };
    String[] arrayOfString56 = { "icirc", "238" };
    String[] arrayOfString57 = { "iuml", "239" };
    String[] arrayOfString58 = { "eth", "240" };
    String[] arrayOfString59 = { "ograve", "242" };
    String[] arrayOfString60 = { "oacute", "243" };
    String[] arrayOfString61 = { "ocirc", "244" };
    String[] arrayOfString62 = { "ouml", "246" };
    String[] arrayOfString63 = { "divide", "247" };
    String[] arrayOfString64 = { "oslash", "248" };
    String[] arrayOfString65 = { "ugrave", "249" };
    String[] arrayOfString66 = { "uacute", "250" };
    String[] arrayOfString67 = { "ucirc", "251" };
    String[] arrayOfString68 = { "uuml", "252" };
    String[] arrayOfString69 = { "yacute", "253" };
    String[] arrayOfString70 = { "yuml", "255" };
    ISO8859_1_ARRAY = new String[][] { localObject, arrayOfString1, arrayOfString2, { "pound", "163" }, arrayOfString3, { "yen", "165" }, arrayOfString4, arrayOfString5, { "uml", "168" }, { "copy", "169" }, { "ordf", "170" }, { "laquo", "171" }, arrayOfString6, arrayOfString7, { "reg", "174" }, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, { "sup3", "179" }, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, { "raquo", "187" }, arrayOfString19, { "frac12", "189" }, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, arrayOfString26, arrayOfString27, arrayOfString28, arrayOfString29, { "Egrave", "200" }, arrayOfString30, arrayOfString31, { "Euml", "203" }, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, { "ETH", "208" }, arrayOfString36, { "Ograve", "210" }, arrayOfString37, { "Ocirc", "212" }, arrayOfString38, arrayOfString39, arrayOfString40, { "Oslash", "216" }, { "Ugrave", "217" }, { "Uacute", "218" }, arrayOfString41, arrayOfString42, { "Yacute", "221" }, arrayOfString43, arrayOfString44, { "agrave", "224" }, arrayOfString45, arrayOfString46, arrayOfString47, arrayOfString48, arrayOfString49, arrayOfString50, { "ccedil", "231" }, arrayOfString51, arrayOfString52, arrayOfString53, arrayOfString54, arrayOfString55, { "iacute", "237" }, arrayOfString56, arrayOfString57, arrayOfString58, { "ntilde", "241" }, arrayOfString59, arrayOfString60, arrayOfString61, { "otilde", "245" }, arrayOfString62, arrayOfString63, arrayOfString64, arrayOfString65, arrayOfString66, arrayOfString67, arrayOfString68, arrayOfString69, { "thorn", "254" }, arrayOfString70 };
    localObject = new String[] { "Beta", "914" };
    arrayOfString1 = new String[] { "Gamma", "915" };
    arrayOfString2 = new String[] { "Delta", "916" };
    arrayOfString3 = new String[] { "Epsilon", "917" };
    arrayOfString4 = new String[] { "Zeta", "918" };
    arrayOfString5 = new String[] { "Eta", "919" };
    arrayOfString6 = new String[] { "Kappa", "922" };
    arrayOfString7 = new String[] { "Lambda", "923" };
    arrayOfString8 = new String[] { "Mu", "924" };
    arrayOfString9 = new String[] { "Nu", "925" };
    arrayOfString10 = new String[] { "Xi", "926" };
    arrayOfString11 = new String[] { "Omicron", "927" };
    arrayOfString12 = new String[] { "Rho", "929" };
    arrayOfString13 = new String[] { "Sigma", "931" };
    arrayOfString14 = new String[] { "Chi", "935" };
    arrayOfString15 = new String[] { "Psi", "936" };
    arrayOfString16 = new String[] { "Omega", "937" };
    arrayOfString17 = new String[] { "alpha", "945" };
    arrayOfString18 = new String[] { "beta", "946" };
    arrayOfString19 = new String[] { "gamma", "947" };
    arrayOfString20 = new String[] { "delta", "948" };
    arrayOfString21 = new String[] { "epsilon", "949" };
    arrayOfString22 = new String[] { "eta", "951" };
    arrayOfString23 = new String[] { "iota", "953" };
    arrayOfString24 = new String[] { "kappa", "954" };
    arrayOfString25 = new String[] { "lambda", "955" };
    arrayOfString26 = new String[] { "nu", "957" };
    arrayOfString27 = new String[] { "xi", "958" };
    arrayOfString28 = new String[] { "pi", "960" };
    arrayOfString29 = new String[] { "sigmaf", "962" };
    arrayOfString30 = new String[] { "sigma", "963" };
    arrayOfString31 = new String[] { "tau", "964" };
    arrayOfString32 = new String[] { "upsilon", "965" };
    arrayOfString33 = new String[] { "chi", "967" };
    arrayOfString34 = new String[] { "psi", "968" };
    arrayOfString35 = new String[] { "omega", "969" };
    arrayOfString36 = new String[] { "piv", "982" };
    arrayOfString37 = new String[] { "bull", "8226" };
    arrayOfString38 = new String[] { "prime", "8242" };
    arrayOfString39 = new String[] { "Prime", "8243" };
    arrayOfString40 = new String[] { "oline", "8254" };
    arrayOfString41 = new String[] { "weierp", "8472" };
    arrayOfString42 = new String[] { "image", "8465" };
    arrayOfString43 = new String[] { "trade", "8482" };
    arrayOfString44 = new String[] { "alefsym", "8501" };
    arrayOfString45 = new String[] { "uarr", "8593" };
    arrayOfString46 = new String[] { "darr", "8595" };
    arrayOfString47 = new String[] { "harr", "8596" };
    arrayOfString48 = new String[] { "crarr", "8629" };
    arrayOfString49 = new String[] { "lArr", "8656" };
    arrayOfString50 = new String[] { "rArr", "8658" };
    arrayOfString51 = new String[] { "hArr", "8660" };
    arrayOfString52 = new String[] { "forall", "8704" };
    arrayOfString53 = new String[] { "part", "8706" };
    arrayOfString54 = new String[] { "empty", "8709" };
    arrayOfString55 = new String[] { "nabla", "8711" };
    arrayOfString56 = new String[] { "isin", "8712" };
    arrayOfString57 = new String[] { "notin", "8713" };
    arrayOfString58 = new String[] { "ni", "8715" };
    arrayOfString59 = new String[] { "sum", "8721" };
    arrayOfString60 = new String[] { "minus", "8722" };
    arrayOfString61 = new String[] { "lowast", "8727" };
    arrayOfString62 = new String[] { "prop", "8733" };
    arrayOfString63 = new String[] { "infin", "8734" };
    arrayOfString64 = new String[] { "ang", "8736" };
    arrayOfString65 = new String[] { "or", "8744" };
    arrayOfString66 = new String[] { "cup", "8746" };
    arrayOfString67 = new String[] { "int", "8747" };
    arrayOfString68 = new String[] { "there4", "8756" };
    arrayOfString69 = new String[] { "sim", "8764" };
    arrayOfString70 = new String[] { "cong", "8773" };
    String[] arrayOfString71 = { "asymp", "8776" };
    String[] arrayOfString72 = { "ne", "8800" };
    String[] arrayOfString73 = { "equiv", "8801" };
    String[] arrayOfString74 = { "le", "8804" };
    String[] arrayOfString75 = { "ge", "8805" };
    String[] arrayOfString76 = { "sub", "8834" };
    String[] arrayOfString77 = { "sube", "8838" };
    String[] arrayOfString78 = { "supe", "8839" };
    String[] arrayOfString79 = { "otimes", "8855" };
    String[] arrayOfString80 = { "perp", "8869" };
    String[] arrayOfString81 = { "sdot", "8901" };
    String[] arrayOfString82 = { "rceil", "8969" };
    String[] arrayOfString83 = { "rfloor", "8971" };
    String[] arrayOfString84 = { "rang", "9002" };
    String[] arrayOfString85 = { "loz", "9674" };
    String[] arrayOfString86 = { "spades", "9824" };
    String[] arrayOfString87 = { "clubs", "9827" };
    String[] arrayOfString88 = { "hearts", "9829" };
    String[] arrayOfString89 = { "diams", "9830" };
    String[] arrayOfString90 = { "OElig", "338" };
    String[] arrayOfString91 = { "scaron", "353" };
    String[] arrayOfString92 = { "Yuml", "376" };
    String[] arrayOfString93 = { "ensp", "8194" };
    String[] arrayOfString94 = { "emsp", "8195" };
    String[] arrayOfString95 = { "thinsp", "8201" };
    String[] arrayOfString96 = { "zwnj", "8204" };
    String[] arrayOfString97 = { "zwj", "8205" };
    String[] arrayOfString98 = { "lrm", "8206" };
    String[] arrayOfString99 = { "rlm", "8207" };
    String[] arrayOfString100 = { "ndash", "8211" };
    String[] arrayOfString101 = { "mdash", "8212" };
    String[] arrayOfString102 = { "lsquo", "8216" };
    String[] arrayOfString103 = { "rsquo", "8217" };
    String[] arrayOfString104 = { "sbquo", "8218" };
    String[] arrayOfString105 = { "ldquo", "8220" };
    String[] arrayOfString106 = { "rdquo", "8221" };
    String[] arrayOfString107 = { "bdquo", "8222" };
    String[] arrayOfString108 = { "dagger", "8224" };
    String[] arrayOfString109 = { "Dagger", "8225" };
    String[] arrayOfString110 = { "permil", "8240" };
    String[] arrayOfString111 = { "euro", "8364" };
    HTML40_ARRAY = new String[][] { { "fnof", "402" }, { "Alpha", "913" }, localObject, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, { "Theta", "920" }, { "Iota", "921" }, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, arrayOfString10, arrayOfString11, { "Pi", "928" }, arrayOfString12, arrayOfString13, { "Tau", "932" }, { "Upsilon", "933" }, { "Phi", "934" }, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, arrayOfString19, arrayOfString20, arrayOfString21, { "zeta", "950" }, arrayOfString22, { "theta", "952" }, arrayOfString23, arrayOfString24, arrayOfString25, { "mu", "956" }, arrayOfString26, arrayOfString27, { "omicron", "959" }, arrayOfString28, { "rho", "961" }, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, { "phi", "966" }, arrayOfString33, arrayOfString34, arrayOfString35, { "thetasym", "977" }, { "upsih", "978" }, arrayOfString36, arrayOfString37, { "hellip", "8230" }, arrayOfString38, arrayOfString39, arrayOfString40, { "frasl", "8260" }, arrayOfString41, arrayOfString42, { "real", "8476" }, arrayOfString43, arrayOfString44, { "larr", "8592" }, arrayOfString45, { "rarr", "8594" }, arrayOfString46, arrayOfString47, arrayOfString48, arrayOfString49, { "uArr", "8657" }, arrayOfString50, { "dArr", "8659" }, arrayOfString51, arrayOfString52, arrayOfString53, { "exist", "8707" }, arrayOfString54, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, { "prod", "8719" }, arrayOfString59, arrayOfString60, arrayOfString61, { "radic", "8730" }, arrayOfString62, arrayOfString63, arrayOfString64, { "and", "8743" }, arrayOfString65, { "cap", "8745" }, arrayOfString66, arrayOfString67, arrayOfString68, arrayOfString69, arrayOfString70, arrayOfString71, arrayOfString72, arrayOfString73, arrayOfString74, arrayOfString75, arrayOfString76, { "sup", "8835" }, arrayOfString77, arrayOfString78, { "oplus", "8853" }, arrayOfString79, arrayOfString80, arrayOfString81, { "lceil", "8968" }, arrayOfString82, { "lfloor", "8970" }, arrayOfString83, { "lang", "9001" }, arrayOfString84, arrayOfString85, arrayOfString86, arrayOfString87, arrayOfString88, arrayOfString89, arrayOfString90, { "oelig", "339" }, { "Scaron", "352" }, arrayOfString91, arrayOfString92, { "circ", "710" }, { "tilde", "732" }, arrayOfString93, arrayOfString94, arrayOfString95, arrayOfString96, arrayOfString97, arrayOfString98, arrayOfString99, arrayOfString100, arrayOfString101, arrayOfString102, arrayOfString103, arrayOfString104, arrayOfString105, arrayOfString106, arrayOfString107, arrayOfString108, arrayOfString109, arrayOfString110, { "lsaquo", "8249" }, { "rsaquo", "8250" }, arrayOfString111 };
    localObject = new Entities();
    ((Entities)localObject).addEntities(BASIC_ARRAY);
    ((Entities)localObject).addEntities(APOS_ARRAY);
    XML = (Entities)localObject;
    localObject = new Entities();
    ((Entities)localObject).addEntities(BASIC_ARRAY);
    ((Entities)localObject).addEntities(ISO8859_1_ARRAY);
    HTML32 = (Entities)localObject;
    localObject = new Entities();
    fillWithHtml40Entities((Entities)localObject);
    HTML40 = (Entities)localObject;
  }
  
  public Entities()
  {
    this.map = new Entities.LookupEntityMap();
  }
  
  Entities(Entities.EntityMap paramEntityMap)
  {
    this.map = paramEntityMap;
  }
  
  private StringWriter createStringWriter(String paramString)
  {
    double d1 = paramString.length();
    double d2 = paramString.length();
    Double.isNaN(d2);
    Double.isNaN(d1);
    return new StringWriter((int)(d1 + d2 * 0.1D));
  }
  
  private void doUnescape(Writer paramWriter, String paramString, int paramInt)
  {
    paramWriter.write(paramString, 0, paramInt);
    int k = paramString.length();
    while (paramInt < k)
    {
      int i = paramString.charAt(paramInt);
      int j;
      String str;
      if (i == 38)
      {
        int m = paramInt + 1;
        j = paramString.indexOf(';', m);
        if (j == -1)
        {
          paramWriter.write(i);
          break label249;
        }
        int n = paramString.indexOf('&', m);
        if ((n != -1) && (n < j))
        {
          paramWriter.write(i);
          break label249;
        }
        str = paramString.substring(m, j);
        paramInt = str.length();
        if (paramInt > 0) {
          if (str.charAt(0) == '#')
          {
            if (paramInt <= 1) {
              break label201;
            }
            paramInt = str.charAt(1);
            if ((paramInt == 88) || (paramInt == 120)) {}
          }
        }
      }
      try
      {
        paramInt = Integer.parseInt(str.substring(1), 10);
        break label177;
        paramInt = Integer.parseInt(str.substring(2), 16);
        label177:
        i = paramInt;
        if (paramInt <= 65535) {
          break label204;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label201;
      }
      i = entityValue(str);
      break label204;
      label201:
      i = -1;
      label204:
      if (i == -1)
      {
        paramWriter.write(38);
        paramWriter.write(str);
        paramWriter.write(59);
      }
      else
      {
        paramWriter.write(i);
      }
      paramInt = j;
      break label249;
      paramWriter.write(i);
      label249:
      paramInt += 1;
    }
  }
  
  static void fillWithHtml40Entities(Entities paramEntities)
  {
    paramEntities.addEntities(BASIC_ARRAY);
    paramEntities.addEntities(ISO8859_1_ARRAY);
    paramEntities.addEntities(HTML40_ARRAY);
  }
  
  public void addEntities(String[][] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      addEntity(paramArrayOfString[i][0], Integer.parseInt(paramArrayOfString[i][1]));
      i += 1;
    }
  }
  
  public void addEntity(String paramString, int paramInt)
  {
    this.map.add(paramString, paramInt);
  }
  
  public String entityName(int paramInt)
  {
    return this.map.name(paramInt);
  }
  
  public int entityValue(String paramString)
  {
    return this.map.value(paramString);
  }
  
  public String escape(String paramString)
  {
    StringWriter localStringWriter = createStringWriter(paramString);
    try
    {
      escape(localStringWriter, paramString);
      return localStringWriter.toString();
    }
    catch (IOException paramString)
    {
      throw new UnhandledException(paramString);
    }
  }
  
  public void escape(Writer paramWriter, String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      String str = entityName(k);
      if (str == null)
      {
        if (k > 127)
        {
          paramWriter.write("&#");
          paramWriter.write(Integer.toString(k, 10));
          paramWriter.write(59);
        }
        else
        {
          paramWriter.write(k);
        }
      }
      else
      {
        paramWriter.write(38);
        paramWriter.write(str);
        paramWriter.write(59);
      }
      i += 1;
    }
  }
  
  public String unescape(String paramString)
  {
    int i = paramString.indexOf('&');
    if (i < 0) {
      return paramString;
    }
    StringWriter localStringWriter = createStringWriter(paramString);
    try
    {
      doUnescape(localStringWriter, paramString, i);
      return localStringWriter.toString();
    }
    catch (IOException paramString)
    {
      throw new UnhandledException(paramString);
    }
  }
  
  public void unescape(Writer paramWriter, String paramString)
  {
    int i = paramString.indexOf('&');
    if (i < 0)
    {
      paramWriter.write(paramString);
      return;
    }
    doUnescape(paramWriter, paramString, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.Entities
 * JD-Core Version:    0.7.0.1
 */