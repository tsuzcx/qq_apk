package com.tencent.mobileqq.text;

import bczu;
import bfwx;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQTextParseLinkUtil
{
  static final String ANDROID_PHONE = "(\\+[0-9]+[\\-]*)?(\\([0-9]+\\)[\\-]*)?([0-9][0-9\\-][0-9\\-]+[0-9])";
  public static final Pattern LINK_PATTERN = Pattern.compile(LINK_REGEX, 2);
  public static final String LINK_REGEX;
  static final String MEETING_PHONE = "(?=.*,)(?=.*#)(\\+*[0-9]+[\\-,]*)?(\\([0-9]+\\)[\\-,]*)?([0-9][0-9\\-,][0-9\\-,#]+#)";
  static final Pattern MEETING_PHONE_PATTERN = Pattern.compile("(?=.*,)(?=.*#)(\\+*[0-9]+[\\-,]*)?(\\([0-9]+\\)[\\-,]*)?([0-9][0-9\\-,][0-9\\-,#]+#)");
  public static final String QQ_MAIL = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+";
  public static final Pattern QQ_MAIL_PATTERN;
  static final String QQ_NUMBER = "[\\d]{5,15}";
  public static final Pattern QQ_NUMBER_PATTERN;
  public static final Pattern QQ_NUMBER_PATTERN2;
  static String QQ_PHONE = "((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)|(\\+[0-9]+[\\-]*)?(\\([0-9]+\\)[\\-]*)?([0-9][0-9\\-][0-9\\-]+[0-9])";
  static final String QQ_PHONE1 = "((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)";
  static final Pattern QQ_PHONE1_PATTERN;
  public static final Pattern QQ_PHONE_PATTERN;
  
  static
  {
    QQ_NUMBER_PATTERN = Pattern.compile("[\\d]{5,15}");
    QQ_NUMBER_PATTERN2 = Pattern.compile("[\\d,]+");
    QQ_PHONE1_PATTERN = Pattern.compile("((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)");
    QQ_PHONE_PATTERN = Pattern.compile(QQ_PHONE);
    QQ_MAIL_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    LINK_REGEX = bfwx.c.pattern() + "|" + bfwx.d.pattern() + "|" + "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+" + "|" + "(?=.*,)(?=.*#)(\\+*[0-9]+[\\-,]*)?(\\([0-9]+\\)[\\-,]*)?([0-9][0-9\\-,][0-9\\-,#]+#)" + "|" + "[\\d]{5,15}" + "|" + QQ_PHONE;
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || ("".equals(paramString));
  }
  
  public static boolean isNumeric(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  static List<bczu> parseLinkSpan(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      if (bfwx.b.matcher(paramString).find())
      {
        Matcher localMatcher1 = LINK_PATTERN.matcher(paramString);
        while (localMatcher1.find())
        {
          int i = localMatcher1.start();
          int j = localMatcher1.end();
          String str = paramString.substring(i, j);
          if (bfwx.c.matcher(str).find()) {
            localArrayList.add(new bczu(str, i, j));
          } else if (bfwx.d.matcher(str).find()) {
            localArrayList.add(new bczu(str, i, j));
          } else if (MEETING_PHONE_PATTERN.matcher(str).find()) {
            localArrayList.add(new bczu(str, i, j));
          } else if (QQ_NUMBER_PATTERN2.matcher(str).find())
          {
            if ((j - i >= 5) && (j - i <= 16))
            {
              Matcher localMatcher2 = QQ_PHONE1_PATTERN.matcher(str);
              if (((j - i != 5) || (localMatcher2.find())) && ((i <= 0) || (!isNumeric(paramString.charAt(i - 1)))) && ((j >= paramString.length()) || (!isNumeric(paramString.charAt(j))))) {
                localArrayList.add(new bczu(str, i, j));
              }
            }
          }
          else {
            localArrayList.add(new bczu(str, i, j));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQTextParseLinkUtil
 * JD-Core Version:    0.7.0.1
 */