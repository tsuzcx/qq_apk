package com.tencent.mobileqq.text;

import com.tencent.mobileqq.utils.Patterns;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQTextParseLinkUtil
{
  public static final Pattern a = Pattern.compile("(?=.*,)(?=.*#)(\\+*[0-9]+[\\-,]*)?(\\([0-9]+\\)[\\-,]*)?([0-9][0-9\\-,][0-9\\-,#]+#)");
  static String b = "((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)|(\\+[0-9]+[\\-]*)?(\\([0-9]+\\)[\\-]*)?([0-9][0-9\\-][0-9\\-]+[0-9])";
  public static final Pattern c = Pattern.compile("[\\d]{5,15}");
  public static final Pattern d = Pattern.compile("[\\d,]+");
  static final Pattern e = Pattern.compile("((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)");
  public static final Pattern f = Pattern.compile(b);
  public static final Pattern g = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
  public static final String h;
  public static final Pattern i = Pattern.compile(h, 2);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Patterns.c.pattern());
    localStringBuilder.append("|");
    localStringBuilder.append(Patterns.d.pattern());
    localStringBuilder.append("|");
    localStringBuilder.append("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    localStringBuilder.append("|");
    localStringBuilder.append("(?=.*,)(?=.*#)(\\+*[0-9]+[\\-,]*)?(\\([0-9]+\\)[\\-,]*)?([0-9][0-9\\-,][0-9\\-,#]+#)");
    localStringBuilder.append("|");
    localStringBuilder.append("[\\d]{5,15}");
    localStringBuilder.append("|");
    localStringBuilder.append(b);
    h = localStringBuilder.toString();
  }
  
  public static List<LinkSpanEntity> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (b(paramString)) {
      return localArrayList;
    }
    if (!Patterns.b.matcher(paramString).find()) {
      return localArrayList;
    }
    Matcher localMatcher1 = i.matcher(paramString);
    while (localMatcher1.find())
    {
      int j = localMatcher1.start();
      int k = localMatcher1.end();
      String str = paramString.substring(j, k);
      if (Patterns.c.matcher(str).find())
      {
        localArrayList.add(new LinkSpanEntity(str, j, k));
      }
      else if (Patterns.d.matcher(str).find())
      {
        localArrayList.add(new LinkSpanEntity(str, j, k));
      }
      else if (a.matcher(str).find())
      {
        localArrayList.add(new LinkSpanEntity(str, j, k));
      }
      else if (d.matcher(str).find())
      {
        int m = k - j;
        if ((m >= 5) && (m <= 16))
        {
          Matcher localMatcher2 = e.matcher(str);
          if (((m != 5) || (localMatcher2.find())) && ((j <= 0) || (!a(paramString.charAt(j - 1)))) && ((k >= paramString.length()) || (!a(paramString.charAt(k))))) {
            localArrayList.add(new LinkSpanEntity(str, j, k));
          }
        }
      }
      else
      {
        localArrayList.add(new LinkSpanEntity(str, j, k));
      }
    }
    return localArrayList;
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static boolean b(String paramString)
  {
    return (paramString == null) || ("".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQTextParseLinkUtil
 * JD-Core Version:    0.7.0.1
 */