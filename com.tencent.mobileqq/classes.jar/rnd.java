import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.Xml;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
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

public class rnd
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
  
  private static int a()
  {
    return Aladdin.getConfig(267).getIntegerFromString("filter_small_pic_size", 30);
  }
  
  public static BaseData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, rni paramrni, SparseArray<Float> paramSparseArray)
  {
    Object localObject2 = "";
    Object localObject3 = "";
    Object localObject1 = "";
    int i1 = paramrni.c();
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
          i1 = paramrni.d();
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          break;
          if (!paramrni.b().equals(g)) {
            break label331;
          }
          int i2 = paramrni.b();
          i1 = 0;
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject4;
          if (i1 < i2)
          {
            String str = paramrni.a(i1);
            if (str.equals("src"))
            {
              localObject1 = paramrni.b(i1);
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
                localObject6 = paramrni.b(i1);
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
                  localObject5 = paramrni.b(i1);
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
      if (!g.equals(paramrni.b())) {}
    }
    else
    {
      if (!a()) {
        break label404;
      }
      i1 = a();
      if ((Integer.valueOf((String)localObject3).intValue() >= i1) || (Integer.valueOf((String)localObject1).intValue() >= i1)) {
        break label404;
      }
      return null;
    }
    throw new IllegalArgumentException("img tag error: has other end tag");
    label404:
    return rmn.a(paramArticleInfo, paramFastWebArticleInfo, (String)localObject2, (String)localObject3, (String)localObject1, paramSparseArray);
  }
  
  public static BaseData a(rni paramrni)
  {
    ProteusBookData localProteusBookData = new ProteusBookData();
    int i1 = paramrni.c();
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
          i1 = paramrni.d();
          break;
          if (!paramrni.b().equals(j)) {
            break label304;
          }
          i2 = paramrni.b();
          i1 = 0;
        } while (i1 >= i2);
        localObject = paramrni.a(i1);
        if (((String)localObject).equals("id")) {
          localProteusBookData.jdField_a_of_type_JavaLangString = paramrni.b(i1);
        }
        while (!((String)localObject).equals("data"))
        {
          i1 += 1;
          break;
        }
        str2 = paramrni.b(i1);
        if (!TextUtils.isEmpty(str2))
        {
          JSONObject localJSONObject = new JSONObject(str2);
          str1 = localJSONObject.getString("source_id");
          localObject = rpr.a("native_article", true);
          if (localObject != null)
          {
            localObject = ((rpr)localObject).getTemplateBean(localJSONObject);
            label183:
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
      break label183;
      label304:
      throw new IllegalArgumentException("proteus tag error: has other start tag");
      if (j.equals(paramrni.b())) {
        return localProteusBookData;
      }
      throw new IllegalArgumentException("proteus tag error: has other end tag");
      str1 = null;
      localObject = null;
    }
  }
  
  private static BaseData a(rni paramrni, SparseArray<Float> paramSparseArray)
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(localStringWriter);
    int i1 = paramrni.c();
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
          i1 = paramrni.d();
          localObject1 = localObject2;
          break;
          localObject2 = paramrni.b();
          if (!((String)localObject2).equals(i)) {
            throw new IllegalArgumentException(ajya.a(2131705636));
          }
          localXmlSerializer.startTag("", (String)localObject2);
          int i2 = paramrni.b();
          i1 = 0;
          for (;;)
          {
            localObject2 = localObject1;
            if (i1 >= i2) {
              break;
            }
            String str = paramrni.a(i1);
            localObject2 = paramrni.b(i1);
            if (str.equals("href")) {
              localObject1 = localObject2;
            }
            localXmlSerializer.attribute("", str, (String)localObject2);
            i1 += 1;
          }
          localXmlSerializer.text(paramrni.a());
          localObject2 = localObject1;
        }
      }
      if (i.equals(paramrni.b())) {
        localXmlSerializer.endTag("", i);
      }
    }
    else
    {
      localXmlSerializer.flush();
      return rmn.a(localStringWriter.toString(), (String)localObject1, paramSparseArray);
    }
    throw new IllegalArgumentException("a tag error: has other end tag");
  }
  
  public static List<BaseData> a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    Object localObject = paramFastWebArticleInfo.jdField_a_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    rnh localrnh = new rnh(null);
    rni localrni = new rni(Xml.newPullParser(), localrnh);
    localrni.a(new StringReader((String)localObject));
    int i1 = localrni.c();
    while (i1 != 1)
    {
      switch (i1)
      {
      }
      for (;;)
      {
        if (localrni.c() != 2)
        {
          i1 = localrni.d();
          break;
          localObject = localrni.b();
          if ((((String)localObject).equals(b)) || (((String)localObject).equals(c)))
          {
            a(paramArticleInfo, paramFastWebArticleInfo, localrni, localArrayList, localrnh, paramSparseArray);
          }
          else if (((String)localObject).equals(i))
          {
            localArrayList.add(a(localrni, paramSparseArray));
          }
          else
          {
            if (((String)localObject).equals(d))
            {
              a(localrni, localrnh, localArrayList, paramSparseArray);
              if (2 != localrni.c()) {
                continue;
              }
              i1 = localrni.c();
              break;
            }
            if (((String)localObject).equals(o))
            {
              localrni.d();
              c(paramArticleInfo, paramFastWebArticleInfo, localrni, localArrayList, localrnh, paramSparseArray);
            }
            else if (((String)localObject).equals(g))
            {
              localObject = a(paramArticleInfo, paramFastWebArticleInfo, localrni, paramSparseArray);
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
            else if (((String)localObject).equals(h))
            {
              localArrayList.add(b(paramArticleInfo, paramFastWebArticleInfo, localrni, paramSparseArray));
            }
            else if (((String)localObject).equals(j))
            {
              localArrayList.add(a(localrni));
            }
            else if (((String)localObject).equals(k))
            {
              a(localrni, localrnh, localArrayList, paramSparseArray);
            }
            else if ((((String)localObject).equals(l)) || (((String)localObject).equals(n)))
            {
              b(paramArticleInfo, paramFastWebArticleInfo, localrni, localArrayList, localrnh, paramSparseArray);
            }
            else
            {
              throw new IllegalArgumentException(ajya.a(2131705635) + (String)localObject);
              a(localrni, localrnh, localArrayList, paramSparseArray);
              if (2 == localrni.c())
              {
                i1 = localrni.c();
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
          Object localObject2 = ((rng)((ArrayList)localObject1).get(i2)).a();
          if ((localObject2 instanceof rnf)) {
            ((rnf)localObject2).a(paramSpannableString.toString());
          }
          paramSpannableString.setSpan(localObject2, 0, paramSpannableString.length(), 33);
          i2 += 1;
        }
      }
      else
      {
        localObject1 = ((rng)localObject1).a();
        if ((localObject1 instanceof rnf)) {
          ((rnf)localObject1).a(paramSpannableString.toString());
        }
        paramSpannableString.setSpan(localObject1, 0, paramSpannableString.length(), 33);
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, rni paramrni, List<BaseData> paramList, rnh paramrnh, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramrni.c();
    int i3 = paramrni.a();
    for (;;)
    {
      int i2;
      if (i1 != 1) {
        i2 = paramrni.c();
      }
      switch (i2)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
      case 3: 
        do
        {
          Object localObject;
          do
          {
            i1 = paramrni.d();
            break;
            localObject = paramrni.b();
            if (a((String)localObject))
            {
              a(paramrni, paramrnh, paramList, paramSparseArray);
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(g))
            {
              localObject = a(paramArticleInfo, paramFastWebArticleInfo, paramrni, paramSparseArray);
              i1 = i2;
              if (localObject == null) {
                break;
              }
              paramList.add(localObject);
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(h))
            {
              paramList.add(b(paramArticleInfo, paramFastWebArticleInfo, paramrni, paramSparseArray));
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(i))
            {
              paramList.add(a(paramrni, paramSparseArray));
              i1 = i2;
              break;
            }
            if ((((String)localObject).equals(l)) || (((String)localObject).equals(n)))
            {
              b(paramArticleInfo, paramFastWebArticleInfo, paramrni, paramList, paramrnh, paramSparseArray);
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(o))
            {
              paramrni.d();
              c(paramArticleInfo, paramFastWebArticleInfo, paramrni, paramList, paramrnh, paramSparseArray);
              i1 = i2;
              break;
            }
          } while ((((String)localObject).equals(b)) || (((String)localObject).equals(c)));
          return;
        } while (((!paramrni.b().equals(b)) && (!paramrni.b().equals(c))) || (i3 != paramrni.a()));
        return;
      }
      a(paramrni, paramrnh, paramList, paramSparseArray);
      i1 = i2;
    }
  }
  
  public static void a(rni paramrni, rnh paramrnh, List<BaseData> paramList, SparseArray<Float> paramSparseArray)
  {
    int i4 = paramrnh.a();
    int i5 = paramrnh.b();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i3 = paramrni.c();
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
      i3 = paramrni.d();
      i2 = i1;
      break;
      i1 = i2 + 1;
      if (!a(paramrni.b()))
      {
        do
        {
          paramrni = localSpannableStringBuilder.toString();
          if (!TextUtils.isEmpty(paramrni.replaceAll(" ", "").trim())) {
            paramList.add(rmn.a(paramrni, localSpannableStringBuilder, i4, i5, paramSparseArray));
          }
          return;
          SpannableString localSpannableString = new SpannableString(paramrni.a().replaceAll(" +", " ").replaceAll("\t+", " "));
          a(localSpannableString, paramrnh.b);
          localSpannableStringBuilder.append(localSpannableString);
          i1 = i2;
          break;
        } while (i2 == 0);
        i1 = i2 - 1;
      }
    }
  }
  
  private static boolean a()
  {
    return Aladdin.getConfig(267).getIntegerFromString("enable_filter_small_pic", 0) == 1;
  }
  
  private static boolean a(String paramString)
  {
    return (paramString.equals(d)) || (paramString.equals(e)) || (paramString.equals(f)) || (paramString.equals(k));
  }
  
  public static BaseData b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, rni paramrni, SparseArray<Float> paramSparseArray)
  {
    int i7 = paramrni.c();
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
          i7 = paramrni.d();
          localObject3 = localObject6;
          localObject5 = localObject7;
          i2 = i4;
          i3 = i5;
          localObject1 = localObject8;
          localObject2 = localObject9;
          localObject4 = localObject10;
          i1 = i6;
          break;
          if (!paramrni.b().equals(h)) {
            break label739;
          }
          i7 = paramrni.b();
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
            String str = paramrni.a(i4);
            if (str.equals("vid"))
            {
              localObject10 = paramrni.b(i4);
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
                i6 = Integer.valueOf(paramrni.b(i4)).intValue();
                i5 = i2;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("height"))
              {
                i5 = Integer.valueOf(paramrni.b(i4)).intValue();
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("cover"))
              {
                localObject9 = paramrni.b(i4);
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject10 = localObject3;
              }
              else if (str.equals("tid"))
              {
                localObject8 = paramrni.b(i4);
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("appid"))
              {
                localObject7 = paramrni.b(i4);
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("appkey"))
              {
                localObject6 = paramrni.b(i4);
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
                  i3 = Integer.valueOf(paramrni.b(i4)).intValue();
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
      if (!h.equals(paramrni.b())) {}
    }
    else
    {
      return rmn.a(paramArticleInfo, paramFastWebArticleInfo, (String)localObject3, (String)localObject5, i2, i3, (String)localObject1, (String)localObject2, (String)localObject4, i1, paramSparseArray);
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
          localArrayList.add(rng.a(3, new Object[0]));
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
        localArrayList.add(rng.a(5, new Object[0]));
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
            for (paramString = rng.a(2, new Object[] { Integer.valueOf(i1) });; paramString = rng.a(1, new Object[] { Integer.valueOf(i1) }))
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
  
  public static void b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, rni paramrni, List<BaseData> paramList, rnh paramrnh, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramrni.c();
    int i3 = paramrni.a();
    for (;;)
    {
      int i2;
      if (i1 != 1) {
        i2 = paramrni.c();
      }
      switch (i2)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
      case 3: 
        Object localObject;
        do
        {
          do
          {
            i1 = paramrni.d();
            break;
            localObject = paramrni.b();
            if (a((String)localObject))
            {
              a(paramrni, paramrnh, paramList, paramSparseArray);
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(g))
            {
              localObject = a(paramArticleInfo, paramFastWebArticleInfo, paramrni, paramSparseArray);
              i1 = i2;
              if (localObject == null) {
                break;
              }
              paramList.add(localObject);
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(h))
            {
              paramList.add(b(paramArticleInfo, paramFastWebArticleInfo, paramrni, paramSparseArray));
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(i))
            {
              paramList.add(a(paramrni, paramSparseArray));
              i1 = i2;
              break;
            }
          } while ((((String)localObject).equals(n)) || (((String)localObject).equals(l)));
          if ((!((String)localObject).equals(b)) && (!((String)localObject).equals(c))) {
            break label274;
          }
          a(paramArticleInfo, paramFastWebArticleInfo, paramrni, paramList, paramrnh, paramSparseArray);
        } while (i3 != paramrni.a());
        return;
        if (((String)localObject).equals(m))
        {
          paramrni.d();
          a(paramrni, paramrnh, paramList, paramSparseArray);
          i1 = i2;
        }
        else
        {
          throw new IOException("illegal tag include in list element(ul or ol)");
        }
        break;
      case 4: 
        label274:
        a(paramrni, paramrnh, paramList, paramSparseArray);
        i1 = i2;
      }
    }
  }
  
  public static void c(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, rni paramrni, List<BaseData> paramList, rnh paramrnh, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramrni.c();
    switch (i1)
    {
    }
    label36:
    do
    {
      paramrni.d();
      while (i1 == 1)
      {
        return;
        String str = paramrni.b();
        if ((str.equals(b)) || (str.equals(c)))
        {
          a(paramArticleInfo, paramFastWebArticleInfo, paramrni, paramList, paramrnh, paramSparseArray);
          break label36;
        }
        if (!a(str)) {
          throw new IOException("blockquote tag include no text tag !");
        }
        a(paramrni, paramrnh, paramList, paramSparseArray);
      }
    } while (!paramrni.b().equals(o));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnd
 * JD-Core Version:    0.7.0.1
 */