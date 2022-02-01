package com.tencent.tencent_richtext_library.richtext;

import android.util.Log;
import com.tencent.tencent_richtext_library.richtext.matcher.AtUserMatcher;
import com.tencent.tencent_richtext_library.richtext.matcher.EmoMatcher;
import com.tencent.tencent_richtext_library.richtext.matcher.TagMatcher;
import com.tencent.tencent_richtext_library.richtext.matcher.TextMatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

public class QcircleFlutterTextCellParser
{
  public static final int a;
  public static String a = "QcircleFlutterTextCellParser";
  public static final Pattern a;
  public static int b;
  public static final Pattern b;
  public static int c;
  public static final Pattern c;
  public static int d;
  public static final Pattern d;
  public static int e;
  public static final Pattern e;
  public static int f;
  public static final Pattern f;
  public static int g;
  public static final Pattern g;
  public static int h;
  public static final Pattern h;
  public static int i;
  public static final Pattern i;
  public static int j;
  public static int k;
  public boolean a;
  public int l = jdField_a_of_type_Int;
  public int m = -14392957;
  public int n = -14392957;
  
  static
  {
    jdField_a_of_type_Int = ViewUtils.a(17.0F);
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("\\{url:(.*?),text:(.*?),color:(.*?)\\}");
    jdField_e_of_type_JavaUtilRegexPattern = Pattern.compile("\\{url:.*?,text:.*?\\}");
    jdField_f_of_type_JavaUtilRegexPattern = Pattern.compile("\\<uin:.*?,nick(name)?:.*?\\>");
    jdField_h_of_type_JavaUtilRegexPattern = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]");
    jdField_c_of_type_JavaUtilRegexPattern = Pattern.compile("\\{text:.*?,color:.*?\\}");
    jdField_g_of_type_JavaUtilRegexPattern = Pattern.compile("\\{img:.*?,w:\\d+,h:\\d+\\}");
    jdField_d_of_type_JavaUtilRegexPattern = Pattern.compile("\\{img:.*?,w:\\d+,h:.+?\\}");
    jdField_i_of_type_JavaUtilRegexPattern = Pattern.compile("#?\\{tagName=.*?\\}");
    jdField_g_of_type_Int = 0;
    k = 1;
    jdField_b_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    j = 4;
    jdField_f_of_type_Int = 5;
    jdField_e_of_type_Int = 6;
    jdField_c_of_type_Int = 7;
    jdField_i_of_type_Int = 8;
    jdField_h_of_type_Int = 9;
  }
  
  public QcircleFlutterTextCellParser()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static ArrayList<HashMap<String, Object>> a(CharSequence paramCharSequence)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList(5);
    localArrayList2.add(new AtUserMatcher(jdField_a_of_type_JavaUtilRegexPattern));
    localArrayList2.add(new EmoMatcher(jdField_h_of_type_JavaUtilRegexPattern));
    localArrayList2.add(new TagMatcher(jdField_i_of_type_JavaUtilRegexPattern));
    Object localObject1 = localArrayList2.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((TextMatcher)((Iterator)localObject1).next()).a(paramCharSequence.toString());
    }
    int i3 = paramCharSequence.length();
    localObject1 = new StringBuilder(i3);
    int i1 = 0;
    while (i1 < i3)
    {
      Object localObject2 = localArrayList2.iterator();
      TextMatcher localTextMatcher;
      do
      {
        boolean bool = ((Iterator)localObject2).hasNext();
        i2 = 1;
        if (!bool) {
          break;
        }
        localTextMatcher = (TextMatcher)((Iterator)localObject2).next();
      } while (!localTextMatcher.a(i1));
      if (((StringBuilder)localObject1).length() > 0)
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("nodeType", Integer.valueOf(jdField_g_of_type_Int));
        ((HashMap)localObject2).put("text", ((StringBuilder)localObject1).toString());
        localArrayList1.add(localObject2);
        ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
      }
      localArrayList1.add(localTextMatcher.a(0, true, paramCharSequence));
      i1 = localTextMatcher.a() - 1;
      break label265;
      int i2 = 0;
      label265:
      if (i2 == 0) {
        ((StringBuilder)localObject1).append(paramCharSequence.charAt(i1));
      }
      i1 += 1;
    }
    if (((StringBuilder)localObject1).length() > 0)
    {
      paramCharSequence = new HashMap();
      paramCharSequence.put("nodeType", Integer.valueOf(jdField_g_of_type_Int));
      paramCharSequence.put("text", ((StringBuilder)localObject1).toString());
      localArrayList1.add(paramCharSequence);
    }
    Log.d(jdField_a_of_type_JavaLangString, localArrayList1.toString());
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencent_richtext_library.richtext.QcircleFlutterTextCellParser
 * JD-Core Version:    0.7.0.1
 */