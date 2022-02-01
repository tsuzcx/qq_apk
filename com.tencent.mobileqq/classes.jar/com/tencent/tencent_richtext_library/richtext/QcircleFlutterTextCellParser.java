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
  public static final Pattern a;
  public static final Pattern b;
  public static final Pattern c;
  public static final Pattern d;
  public static final Pattern e;
  public static final int f = ViewUtils.a(17.0F);
  public static final Pattern g;
  public static final Pattern h;
  public static final Pattern i;
  public static String j = "QcircleFlutterTextCellParser";
  public static final Pattern k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  public static int p;
  public static int q;
  public static int r = 9;
  public static int s;
  public static int t;
  public static int u;
  public int v = f;
  public int w = -14392957;
  public boolean x = true;
  public int y = -14392957;
  
  static
  {
    a = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
    b = Pattern.compile("\\{url:(.*?),text:(.*?),color:(.*?)\\}");
    e = Pattern.compile("\\{url:.*?,text:.*?\\}");
    g = Pattern.compile("\\<uin:.*?,nick(name)?:.*?\\>");
    i = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]");
    c = Pattern.compile("\\{text:.*?,color:.*?\\}");
    h = Pattern.compile("\\{img:.*?,w:\\d+,h:\\d+\\}");
    d = Pattern.compile("\\{img:.*?,w:\\d+,h:.+?\\}");
    k = Pattern.compile("#?\\{tagName=.*?\\}");
    q = 0;
    u = 1;
    l = 2;
    n = 3;
    t = 4;
    p = 5;
    o = 6;
    m = 7;
    s = 8;
  }
  
  public static ArrayList<HashMap<String, Object>> a(CharSequence paramCharSequence)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList(5);
    localArrayList2.add(new AtUserMatcher(a));
    localArrayList2.add(new EmoMatcher(i));
    localArrayList2.add(new TagMatcher(k));
    Object localObject1 = localArrayList2.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((TextMatcher)((Iterator)localObject1).next()).b(paramCharSequence.toString());
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
        ((HashMap)localObject2).put("nodeType", Integer.valueOf(q));
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
      paramCharSequence.put("nodeType", Integer.valueOf(q));
      paramCharSequence.put("text", ((StringBuilder)localObject1).toString());
      localArrayList1.add(paramCharSequence);
    }
    Log.d(j, localArrayList1.toString());
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencent_richtext_library.richtext.QcircleFlutterTextCellParser
 * JD-Core Version:    0.7.0.1
 */