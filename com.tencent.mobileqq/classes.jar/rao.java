import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.Xml;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusBookData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class rao
{
  private static String a;
  public static final HashMap<String, String> a;
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static String o;
  private static String p;
  private static String q;
  private static String r;
  private static String s = "{\n    \"id_container\": {\n        \"url\": \"http://hhhh.html\"\n    },\n    \"id_pic\": {\n        \"src\": \"http://hhh.jpg\"\n    },\n    \"id_title\": {\n        \"text\": \"简爱\"\n    },\n    \"id_summary\": {\n        \"text\": \"[英] 夏洛蒂 . 勃朗特\"\n    },\n    \"id_wording\": {\n        \"text\": \"13.5万人阅读\"\n    },\n    \"id_pic_right\": {\n        \"url\": \"img_book_right\"\n    },\n    \"source_id\": \"123xx\",\n    \"style_ID\": \"ReadInjoy_native_web_normal\"\n}";
  
  static
  {
    jdField_a_of_type_JavaLangString = "HtmlChangeUtil";
    b = "p";
    c = "section";
    d = "strong";
    e = "i";
    f = "u";
    g = "img";
    h = "video";
    i = "a";
    j = "proteus";
    k = "span";
    l = "ul";
    m = "li";
    n = "ol";
    o = "blockquote";
    p = "text-decoration";
    q = "color";
    r = "background-color";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("aqua", "#00FFFF");
    jdField_a_of_type_JavaUtilHashMap.put("black", "#000000");
    jdField_a_of_type_JavaUtilHashMap.put("blue", "#0000FF");
    jdField_a_of_type_JavaUtilHashMap.put("fuchsia", "#FF00FF");
    jdField_a_of_type_JavaUtilHashMap.put("gray", "#808080");
    jdField_a_of_type_JavaUtilHashMap.put("green", "#008000");
    jdField_a_of_type_JavaUtilHashMap.put("lime", "#00FF00");
    jdField_a_of_type_JavaUtilHashMap.put("maroon", "#800000");
    jdField_a_of_type_JavaUtilHashMap.put("navy", "#000080");
    jdField_a_of_type_JavaUtilHashMap.put("olive", "#808000");
    jdField_a_of_type_JavaUtilHashMap.put("purple", "#800080");
    jdField_a_of_type_JavaUtilHashMap.put("red", "#FF0000");
    jdField_a_of_type_JavaUtilHashMap.put("silver", "#C0C0C0");
    jdField_a_of_type_JavaUtilHashMap.put("teal", "#008080");
    jdField_a_of_type_JavaUtilHashMap.put("white", "#FFFFFF");
    jdField_a_of_type_JavaUtilHashMap.put("yellow", "#FFFF00");
  }
  
  public static BaseData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, rat paramrat, SparseArray<Float> paramSparseArray)
  {
    Object localObject2 = "";
    Object localObject3 = "";
    Object localObject1 = "";
    int i1 = paramrat.c();
    if (i1 != 1)
    {
      Object localObject4 = localObject2;
      Object localObject5 = localObject3;
      Object localObject6 = localObject1;
      switch (i1)
      {
      default: 
        localObject6 = localObject1;
        localObject5 = localObject3;
        localObject4 = localObject2;
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          i1 = paramrat.d();
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          break;
          if (!paramrat.b().equals(g)) {
            break label331;
          }
          int i2 = paramrat.b();
          i1 = 0;
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject4;
          if (i1 < i2)
          {
            String str = paramrat.a(i1);
            if (str.equals("src"))
            {
              localObject1 = paramrat.b(i1);
              localObject5 = localObject3;
              localObject6 = localObject2;
              localObject4 = localObject1;
              if (((String)localObject1).indexOf("http") == -1)
              {
                localObject4 = "http::" + (String)localObject1;
                localObject6 = localObject2;
                localObject5 = localObject3;
              }
            }
            for (;;)
            {
              i1 += 1;
              localObject3 = localObject5;
              localObject2 = localObject6;
              localObject1 = localObject4;
              break;
              if (str.equals("width"))
              {
                localObject6 = paramrat.b(i1);
                localObject5 = localObject3;
                localObject4 = localObject1;
              }
              else
              {
                localObject5 = localObject3;
                localObject6 = localObject2;
                localObject4 = localObject1;
                if (str.equals("height"))
                {
                  localObject5 = paramrat.b(i1);
                  localObject6 = localObject2;
                  localObject4 = localObject1;
                }
              }
            }
          }
          localObject4 = localObject1;
          localObject5 = localObject2;
          localObject6 = localObject3;
        }
        label331:
        throw new IllegalArgumentException("img tag error: has other start tag");
      }
      if (!g.equals(paramrat.b())) {}
    }
    else
    {
      return qzy.a(paramArticleInfo, paramFastWebArticleInfo, (String)localObject2, (String)localObject3, (String)localObject1, paramSparseArray);
    }
    throw new IllegalArgumentException("img tag error: has other end tag");
  }
  
  public static BaseData a(rat paramrat)
  {
    ProteusBookData localProteusBookData = new ProteusBookData();
    int i1 = paramrat.c();
    Object localObject;
    String str2;
    String str1;
    if (i1 != 1) {
      switch (i1)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
        int i2;
        do
        {
          i1 = paramrat.d();
          break;
          if (!paramrat.b().equals(j)) {
            break label300;
          }
          i2 = paramrat.b();
          i1 = 0;
        } while (i1 >= i2);
        localObject = paramrat.a(i1);
        if (((String)localObject).equals("id")) {
          localProteusBookData.jdField_a_of_type_JavaLangString = paramrat.b(i1);
        }
        while (!((String)localObject).equals("data"))
        {
          i1 += 1;
          break;
        }
        str2 = paramrat.b(i1);
        if (!TextUtils.isEmpty(str2))
        {
          JSONObject localJSONObject = new JSONObject(str2);
          str1 = localJSONObject.getString("source_id");
          localObject = rdg.a("native_article", true);
          if (localObject != null)
          {
            localObject = ((rdg)localObject).getTemplateBean(localJSONObject);
            label181:
            if (localJSONObject.has("id")) {
              localProteusBookData.d = localJSONObject.getString("id");
            }
            if (localJSONObject.has("card_type")) {
              localProteusBookData.c = localJSONObject.getString("card_type");
            }
            if (localJSONObject.has("sid")) {
              localProteusBookData.e = localJSONObject.getString("sid");
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      QLog.d("Q.readinjoy.fast_web", 2, "data: " + str2);
      localProteusBookData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject);
      localProteusBookData.b = str1;
      break;
      localObject = null;
      break label181;
      label300:
      throw new IllegalArgumentException("proteus tag error: has other start tag");
      if (j.equals(paramrat.b())) {
        return localProteusBookData;
      }
      throw new IllegalArgumentException("proteus tag error: has other end tag");
      str1 = null;
      localObject = null;
    }
  }
  
  private static BaseData a(rat paramrat, SparseArray<Float> paramSparseArray)
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(localStringWriter);
    int i1 = paramrat.c();
    Object localObject1 = "";
    if (i1 != 1)
    {
      Object localObject2 = localObject1;
      switch (i1)
      {
      default: 
        localObject2 = localObject1;
      case 0: 
      case 1: 
      case 2: 
      case 4: 
        for (;;)
        {
          i1 = paramrat.d();
          localObject1 = localObject2;
          break;
          localObject2 = paramrat.b();
          if (!((String)localObject2).equals(i)) {
            throw new IllegalArgumentException(ajjy.a(2131639840));
          }
          localXmlSerializer.startTag("", (String)localObject2);
          int i2 = paramrat.b();
          i1 = 0;
          for (;;)
          {
            localObject2 = localObject1;
            if (i1 >= i2) {
              break;
            }
            String str = paramrat.a(i1);
            localObject2 = paramrat.b(i1);
            if (str.equals("href")) {
              localObject1 = localObject2;
            }
            localXmlSerializer.attribute("", str, (String)localObject2);
            i1 += 1;
          }
          localXmlSerializer.text(paramrat.a());
          localObject2 = localObject1;
        }
      }
      if (i.equals(paramrat.b())) {
        localXmlSerializer.endTag("", i);
      }
    }
    else
    {
      localXmlSerializer.flush();
      return qzy.a(localStringWriter.toString(), (String)localObject1, paramSparseArray);
    }
    throw new IllegalArgumentException("a tag error: has other end tag");
  }
  
  public static List<BaseData> a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    String str = paramFastWebArticleInfo.jdField_a_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    ras localras = new ras(null);
    rat localrat = new rat(Xml.newPullParser(), localras);
    localrat.a(new StringReader(str));
    int i1 = localrat.c();
    while (i1 != 1)
    {
      switch (i1)
      {
      }
      for (;;)
      {
        if (localrat.c() != 2)
        {
          i1 = localrat.d();
          break;
          str = localrat.b();
          if ((str.equals(b)) || (str.equals(c)))
          {
            a(paramArticleInfo, paramFastWebArticleInfo, localrat, localArrayList, localras, paramSparseArray);
          }
          else if (str.equals(i))
          {
            localArrayList.add(a(localrat, paramSparseArray));
          }
          else
          {
            if (str.equals(d))
            {
              a(localrat, localras, localArrayList, paramSparseArray);
              if (2 != localrat.c()) {
                continue;
              }
              i1 = localrat.c();
              break;
            }
            if (str.equals(o))
            {
              localrat.d();
              c(paramArticleInfo, paramFastWebArticleInfo, localrat, localArrayList, localras, paramSparseArray);
            }
            else if (str.equals(g))
            {
              localArrayList.add(a(paramArticleInfo, paramFastWebArticleInfo, localrat, paramSparseArray));
            }
            else if (str.equals(h))
            {
              localArrayList.add(b(paramArticleInfo, paramFastWebArticleInfo, localrat, paramSparseArray));
            }
            else if (str.equals(j))
            {
              localArrayList.add(a(localrat));
            }
            else if (str.equals(k))
            {
              a(localrat, localras, localArrayList, paramSparseArray);
            }
            else if ((str.equals(l)) || (str.equals(n)))
            {
              b(paramArticleInfo, paramFastWebArticleInfo, localrat, localArrayList, localras, paramSparseArray);
            }
            else
            {
              throw new IllegalArgumentException(ajjy.a(2131639839) + str);
              a(localrat, localras, localArrayList, paramSparseArray);
              if (2 == localrat.c())
              {
                i1 = localrat.c();
                break;
              }
            }
          }
        }
      }
      i1 = 2;
    }
    return localArrayList;
  }
  
  private static void a(SpannableString paramSpannableString, SparseArray<Object> paramSparseArray)
  {
    if (paramSparseArray == null) {
      return;
    }
    int i1 = 0;
    label7:
    Object localObject1;
    if (i1 < paramSparseArray.size())
    {
      localObject1 = paramSparseArray.valueAt(i1);
      if (localObject1 != null) {
        break label34;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label7;
      break;
      label34:
      if ((localObject1 instanceof ArrayList))
      {
        localObject1 = (ArrayList)localObject1;
        int i2 = 0;
        while (i2 < ((ArrayList)localObject1).size())
        {
          Object localObject2 = ((rar)((ArrayList)localObject1).get(i2)).a();
          if ((localObject2 instanceof raq)) {
            ((raq)localObject2).a(paramSpannableString.toString());
          }
          paramSpannableString.setSpan(localObject2, 0, paramSpannableString.length(), 33);
          i2 += 1;
        }
      }
      else
      {
        localObject1 = ((rar)localObject1).a();
        if ((localObject1 instanceof raq)) {
          ((raq)localObject1).a(paramSpannableString.toString());
        }
        paramSpannableString.setSpan(localObject1, 0, paramSpannableString.length(), 33);
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, rat paramrat, List<BaseData> paramList, ras paramras, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramrat.c();
    int i2 = paramrat.a();
    for (;;)
    {
      if (i1 != 1) {
        i1 = paramrat.c();
      }
      switch (i1)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
      case 3: 
        do
        {
          String str;
          do
          {
            i1 = paramrat.d();
            break;
            str = paramrat.b();
            if (a(str))
            {
              a(paramrat, paramras, paramList, paramSparseArray);
              break;
            }
            if (str.equals(g))
            {
              paramList.add(a(paramArticleInfo, paramFastWebArticleInfo, paramrat, paramSparseArray));
              break;
            }
            if (str.equals(h))
            {
              paramList.add(b(paramArticleInfo, paramFastWebArticleInfo, paramrat, paramSparseArray));
              break;
            }
            if (str.equals(i))
            {
              paramList.add(a(paramrat, paramSparseArray));
              break;
            }
            if ((str.equals(l)) || (str.equals(n)))
            {
              b(paramArticleInfo, paramFastWebArticleInfo, paramrat, paramList, paramras, paramSparseArray);
              break;
            }
            if (str.equals(o))
            {
              paramrat.d();
              c(paramArticleInfo, paramFastWebArticleInfo, paramrat, paramList, paramras, paramSparseArray);
              break;
            }
          } while ((str.equals(b)) || (str.equals(c)));
          return;
        } while (((!paramrat.b().equals(b)) && (!paramrat.b().equals(c))) || (i2 != paramrat.a()));
        return;
      }
      a(paramrat, paramras, paramList, paramSparseArray);
    }
  }
  
  public static void a(rat paramrat, ras paramras, List<BaseData> paramList, SparseArray<Float> paramSparseArray)
  {
    int i4 = paramras.a();
    int i5 = paramras.b();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i3 = paramrat.c();
    int i2 = 0;
    int i1;
    if (i3 != 1)
    {
      i1 = i2;
      switch (i3)
      {
      default: 
        i1 = i2;
      }
    }
    for (;;)
    {
      i3 = paramrat.d();
      i2 = i1;
      break;
      i1 = i2 + 1;
      if (!a(paramrat.b()))
      {
        do
        {
          paramrat = localSpannableStringBuilder.toString();
          if (!TextUtils.isEmpty(paramrat.replaceAll(" ", "").trim())) {
            paramList.add(qzy.a(paramrat, localSpannableStringBuilder, i4, i5, paramSparseArray));
          }
          return;
          SpannableString localSpannableString = new SpannableString(paramrat.a().replaceAll(" +", " ").replaceAll("\t+", " "));
          a(localSpannableString, paramras.b);
          localSpannableStringBuilder.append(localSpannableString);
          i1 = i2;
          break;
        } while (i2 == 0);
        i1 = i2 - 1;
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    return (paramString.equals(d)) || (paramString.equals(e)) || (paramString.equals(f)) || (paramString.equals(k));
  }
  
  public static BaseData b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, rat paramrat, SparseArray<Float> paramSparseArray)
  {
    int i7 = paramrat.c();
    Object localObject5 = "";
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject1 = "";
    Object localObject2 = "";
    int i2 = 0;
    int i3 = 0;
    int i1 = 1;
    if (i7 != 1)
    {
      Object localObject6 = localObject3;
      Object localObject7 = localObject5;
      int i4 = i2;
      int i5 = i3;
      Object localObject8 = localObject1;
      Object localObject9 = localObject2;
      Object localObject10 = localObject4;
      int i6 = i1;
      switch (i7)
      {
      default: 
        i6 = i1;
        localObject10 = localObject4;
        localObject9 = localObject2;
        localObject8 = localObject1;
        i5 = i3;
        i4 = i2;
        localObject7 = localObject5;
        localObject6 = localObject3;
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          i7 = paramrat.d();
          localObject3 = localObject6;
          localObject5 = localObject7;
          i2 = i4;
          i3 = i5;
          localObject1 = localObject8;
          localObject2 = localObject9;
          localObject4 = localObject10;
          i1 = i6;
          break;
          if (!paramrat.b().equals(h)) {
            break label739;
          }
          i7 = paramrat.b();
          i4 = 0;
          i5 = i1;
          localObject6 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          i1 = i2;
          localObject3 = localObject5;
          localObject5 = localObject4;
          localObject4 = localObject6;
          i2 = i3;
          i3 = i5;
          if (i4 < i7)
          {
            String str = paramrat.a(i4);
            if (str.equals("vid"))
            {
              localObject10 = paramrat.b(i4);
              localObject9 = localObject1;
              localObject8 = localObject5;
              localObject7 = localObject2;
              localObject6 = localObject4;
              i6 = i1;
              i5 = i2;
            }
            for (;;)
            {
              i4 += 1;
              i2 = i5;
              i1 = i6;
              localObject4 = localObject6;
              localObject2 = localObject7;
              localObject5 = localObject8;
              localObject1 = localObject9;
              localObject3 = localObject10;
              break;
              if (str.equals("width"))
              {
                i6 = Integer.valueOf(paramrat.b(i4)).intValue();
                i5 = i2;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("height"))
              {
                i5 = Integer.valueOf(paramrat.b(i4)).intValue();
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("cover"))
              {
                localObject9 = paramrat.b(i4);
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject10 = localObject3;
              }
              else if (str.equals("tid"))
              {
                localObject8 = paramrat.b(i4);
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("appid"))
              {
                localObject7 = paramrat.b(i4);
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("appkey"))
              {
                localObject6 = paramrat.b(i4);
                i5 = i2;
                i6 = i1;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else
              {
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
                if (str.equals("busitype"))
                {
                  i3 = Integer.valueOf(paramrat.b(i4)).intValue();
                  i5 = i2;
                  i6 = i1;
                  localObject6 = localObject4;
                  localObject7 = localObject2;
                  localObject8 = localObject5;
                  localObject9 = localObject1;
                  localObject10 = localObject3;
                }
              }
            }
          }
          localObject6 = localObject1;
          localObject7 = localObject3;
          i4 = i1;
          i5 = i2;
          localObject8 = localObject2;
          localObject9 = localObject4;
          localObject10 = localObject5;
          i6 = i3;
        }
        label739:
        throw new IllegalArgumentException("video tag error: has other start tag");
      }
      if (!h.equals(paramrat.b())) {}
    }
    else
    {
      return qzy.a(paramArticleInfo, paramFastWebArticleInfo, (String)localObject3, (String)localObject5, i2, i3, (String)localObject1, (String)localObject2, (String)localObject4, i1, paramSparseArray);
    }
    throw new IllegalArgumentException("video tag error: has other end tag");
  }
  
  private static HashMap<String, String> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split(";");
    int i1 = 0;
    if (i1 < paramString.length)
    {
      Object localObject = paramString[i1].split(":");
      if (localObject.length != 2) {}
      for (;;)
      {
        i1 += 1;
        break;
        String str = localObject[0].trim();
        localObject = localObject[1].trim();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localHashMap.put(str.toLowerCase(), ((String)localObject).toLowerCase());
        }
      }
    }
    return localHashMap;
  }
  
  private static List<Object> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    for (;;)
    {
      int i2;
      Object localObject;
      try
      {
        String[] arrayOfString = paramString.split(";");
        i2 = 0;
        if (i2 < arrayOfString.length)
        {
          localObject = arrayOfString[i2].split(":");
          if (localObject.length != 2) {
            break label399;
          }
          paramString = localObject[0].trim();
          localObject = localObject[1].trim();
          if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject))) {
            break label399;
          }
          if (!p.equals(paramString)) {
            break label172;
          }
          if (!"underline".equals(localObject)) {
            break label143;
          }
          localArrayList.add(rar.a(3, new Object[0]));
        }
      }
      catch (Exception paramString)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramString, new Object[0]);
      }
      return localArrayList;
      label143:
      if ("line-through".equals(localObject))
      {
        localArrayList.add(rar.a(5, new Object[0]));
        break label399;
        label172:
        if ((q.equals(paramString)) || (r.equals(paramString)))
        {
          int i1;
          if (((String)localObject).startsWith("rgb("))
          {
            localObject = localObject.split("\\(")[1].split("\\)")[0].split(",");
            if (localObject.length != 3) {
              break label394;
            }
            i1 = Color.rgb(Integer.valueOf(localObject[0].trim()).intValue(), Integer.valueOf(localObject[1].trim()).intValue(), Integer.valueOf(localObject[2].trim()).intValue());
          }
          while (i1 != -1)
          {
            if ("color".equals(paramString)) {}
            for (paramString = rar.a(2, new Object[] { Integer.valueOf(i1) });; paramString = rar.a(1, new Object[] { Integer.valueOf(i1) }))
            {
              localArrayList.add(paramString);
              break label399;
              if (((String)localObject).startsWith("#"))
              {
                i1 = Color.parseColor((String)localObject);
                break;
              }
              if (!jdField_a_of_type_JavaUtilHashMap.containsKey(((String)localObject).toLowerCase())) {
                break label394;
              }
              i1 = Color.parseColor((String)jdField_a_of_type_JavaUtilHashMap.get(((String)localObject).toLowerCase()));
              break;
            }
            i1 = -1;
          }
        }
      }
      label394:
      label399:
      i2 += 1;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, rat paramrat, List<BaseData> paramList, ras paramras, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramrat.c();
    int i2 = paramrat.a();
    for (;;)
    {
      if (i1 != 1) {
        i1 = paramrat.c();
      }
      switch (i1)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
      case 3: 
        String str;
        do
        {
          do
          {
            i1 = paramrat.d();
            break;
            str = paramrat.b();
            if (a(str))
            {
              a(paramrat, paramras, paramList, paramSparseArray);
              break;
            }
            if (str.equals(g))
            {
              paramList.add(a(paramArticleInfo, paramFastWebArticleInfo, paramrat, paramSparseArray));
              break;
            }
            if (str.equals(h))
            {
              paramList.add(b(paramArticleInfo, paramFastWebArticleInfo, paramrat, paramSparseArray));
              break;
            }
            if (str.equals(i))
            {
              paramList.add(a(paramrat, paramSparseArray));
              break;
            }
          } while ((str.equals(n)) || (str.equals(l)));
          if ((!str.equals(b)) && (!str.equals(c))) {
            break label245;
          }
          a(paramArticleInfo, paramFastWebArticleInfo, paramrat, paramList, paramras, paramSparseArray);
        } while (i2 != paramrat.a());
        return;
        if (str.equals(m))
        {
          paramrat.d();
          a(paramrat, paramras, paramList, paramSparseArray);
        }
        else
        {
          throw new IOException("illegal tag include in list element(ul or ol)");
        }
        break;
      case 4: 
        label245:
        a(paramrat, paramras, paramList, paramSparseArray);
      }
    }
  }
  
  public static void c(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, rat paramrat, List<BaseData> paramList, ras paramras, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramrat.c();
    switch (i1)
    {
    }
    label36:
    do
    {
      paramrat.d();
      while (i1 == 1)
      {
        return;
        String str = paramrat.b();
        if ((str.equals(b)) || (str.equals(c)))
        {
          a(paramArticleInfo, paramFastWebArticleInfo, paramrat, paramList, paramras, paramSparseArray);
          break label36;
        }
        if (!a(str)) {
          throw new IOException("blockquote tag include no text tag !");
        }
        a(paramrat, paramras, paramList, paramSparseArray);
      }
    } while (!paramrat.b().equals(o));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rao
 * JD-Core Version:    0.7.0.1
 */