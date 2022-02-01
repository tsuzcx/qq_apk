package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.Xml;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusBookData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.PtsData;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class HtmlChangeUtil
{
  private static String a = "HtmlChangeUtil";
  public static final HashMap<String, String> a;
  private static String b = "p";
  private static String c = "section";
  private static String d = "strong";
  private static String e = "i";
  private static String f = "u";
  private static String g = "img";
  private static String h = "video";
  private static String i = "a";
  private static String j = "proteus";
  private static String k = "span";
  private static String l = "ul";
  private static String m = "li";
  private static String n = "ol";
  private static String o = "blockquote";
  private static String p = "text-decoration";
  private static String q = "color";
  private static String r = "background-color";
  
  static
  {
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
  
  private static ProteusBookData a(JSONObject paramJSONObject)
  {
    ProteusBookData localProteusBookData = new ProteusBookData();
    for (;;)
    {
      try
      {
        localObject2 = paramJSONObject.getString("source_id");
        localObject1 = TemplateFactory.a("native_article", true);
        if (localObject1 != null)
        {
          localObject1 = ((TemplateFactory)localObject1).getTemplateBean(paramJSONObject);
          if (paramJSONObject.has("id")) {
            localProteusBookData.d = paramJSONObject.getString("id");
          }
          if (paramJSONObject.has("card_type")) {
            localProteusBookData.c = paramJSONObject.getString("card_type");
          }
          if (paramJSONObject.has("sid")) {
            localProteusBookData.e = paramJSONObject.getString("sid");
          }
          String str = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("data: ");
          localStringBuilder.append(paramJSONObject);
          QLog.d(str, 1, localStringBuilder.toString());
          localProteusBookData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject1);
          localProteusBookData.b = ((String)localObject2);
          return localProteusBookData;
        }
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseBookData error!  msg=");
        ((StringBuilder)localObject2).append(paramJSONObject);
        QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return localProteusBookData;
      }
      Object localObject1 = null;
    }
  }
  
  private static BaseData a(int paramInt, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper)
  {
    paramXmlPullParserWrapper = paramXmlPullParserWrapper.b(paramInt);
    try
    {
      if (!TextUtils.isEmpty(paramXmlPullParserWrapper))
      {
        paramXmlPullParserWrapper = new JSONObject(paramXmlPullParserWrapper);
        if (FastWebPtsLiteDataUtil.a(paramXmlPullParserWrapper))
        {
          if (!PTSLiteSwitchManager.a().a()) {
            return null;
          }
          paramXmlPullParserWrapper = FastWebPtsLiteDataUtil.a(paramXmlPullParserWrapper);
        }
        else
        {
          paramXmlPullParserWrapper = a(paramXmlPullParserWrapper);
        }
        return paramXmlPullParserWrapper;
      }
    }
    catch (Exception paramXmlPullParserWrapper)
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseProteusData error!  msg=");
      localStringBuilder.append(paramXmlPullParserWrapper);
      QLog.d(str, 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public static BaseData a(HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper)
  {
    int i1 = paramXmlPullParserWrapper.c();
    Object localObject3 = null;
    Object localObject1 = "";
    Object localObject6;
    for (Object localObject2 = "unknown"; i1 != 1; localObject2 = localObject6)
    {
      Object localObject4 = localObject3;
      Object localObject5 = localObject1;
      localObject6 = localObject2;
      if (i1 != 0) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            localObject4 = localObject3;
            localObject5 = localObject1;
            localObject6 = localObject2;
          }
          else
          {
            if (j.equals(paramXmlPullParserWrapper.b())) {
              break;
            }
            throw new IllegalArgumentException("proteus tag error: has other end tag");
          }
        }
        else
        {
          if (paramXmlPullParserWrapper.b().equals(j))
          {
            int i2 = paramXmlPullParserWrapper.b();
            i1 = 0;
            for (;;)
            {
              localObject4 = localObject3;
              localObject5 = localObject1;
              localObject6 = localObject2;
              if (i1 >= i2) {
                break;
              }
              localObject6 = paramXmlPullParserWrapper.a(i1);
              if (((String)localObject6).equals("id"))
              {
                localObject5 = paramXmlPullParserWrapper.b(i1);
                localObject4 = localObject3;
              }
              else if (((String)localObject6).equals("data"))
              {
                localObject4 = a(i1, paramXmlPullParserWrapper);
                localObject5 = localObject1;
              }
              else
              {
                localObject4 = localObject3;
                localObject5 = localObject1;
                if (((String)localObject6).equals("type"))
                {
                  localObject2 = paramXmlPullParserWrapper.b(i1);
                  localObject5 = localObject1;
                  localObject4 = localObject3;
                }
              }
              i1 += 1;
              localObject3 = localObject4;
              localObject1 = localObject5;
            }
          }
          throw new IllegalArgumentException("proteus tag error: has other start tag");
        }
      }
      i1 = paramXmlPullParserWrapper.d();
      localObject3 = localObject4;
      localObject1 = localObject5;
    }
    if (((localObject3 instanceof ProteusBookData)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      ((ProteusBookData)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
      return localObject3;
    }
    if ((localObject3 instanceof PtsData)) {
      ((PtsData)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
    }
    return localObject3;
  }
  
  private static BaseData a(HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, SparseArray<Float> paramSparseArray)
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(localStringWriter);
    int i1 = paramXmlPullParserWrapper.c();
    Object localObject2;
    for (Object localObject1 = ""; i1 != 1; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (i1 != 0) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              localObject2 = localObject1;
            }
            else
            {
              localXmlSerializer.text(paramXmlPullParserWrapper.a());
              localObject2 = localObject1;
            }
          }
          else
          {
            if (i.equals(paramXmlPullParserWrapper.b()))
            {
              localXmlSerializer.endTag("", i);
              break;
            }
            throw new IllegalArgumentException("a tag error: has other end tag");
          }
        }
        else
        {
          localObject2 = paramXmlPullParserWrapper.b();
          if (((String)localObject2).equals(i))
          {
            localXmlSerializer.startTag("", (String)localObject2);
            int i2 = paramXmlPullParserWrapper.b();
            i1 = 0;
            for (;;)
            {
              localObject2 = localObject1;
              if (i1 >= i2) {
                break;
              }
              String str = paramXmlPullParserWrapper.a(i1);
              localObject2 = paramXmlPullParserWrapper.b(i1);
              if (str.equals("href")) {
                localObject1 = localObject2;
              }
              localXmlSerializer.attribute("", str, (String)localObject2);
              i1 += 1;
            }
          }
          throw new IllegalArgumentException(HardCodeUtil.a(2131705718));
        }
      }
      i1 = paramXmlPullParserWrapper.d();
    }
    localXmlSerializer.flush();
    return FastWebPTSDataConverter.a(localStringWriter.toString(), (String)localObject1, paramSparseArray);
  }
  
  public static BaseData a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramXmlPullParserWrapper.c();
    Object localObject3 = "";
    Object localObject1 = localObject3;
    Object localObject6;
    for (Object localObject2 = localObject1; i1 != 1; localObject2 = localObject6)
    {
      Object localObject4 = localObject3;
      Object localObject5 = localObject1;
      localObject6 = localObject2;
      if (i1 != 0) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            localObject4 = localObject3;
            localObject5 = localObject1;
            localObject6 = localObject2;
          }
          else
          {
            if (g.equals(paramXmlPullParserWrapper.b())) {
              break;
            }
            throw new IllegalArgumentException("img tag error: has other end tag");
          }
        }
        else
        {
          if (paramXmlPullParserWrapper.b().equals(g))
          {
            int i2 = paramXmlPullParserWrapper.b();
            i1 = 0;
            for (;;)
            {
              localObject4 = localObject3;
              localObject5 = localObject1;
              localObject6 = localObject2;
              if (i1 >= i2) {
                break;
              }
              localObject6 = paramXmlPullParserWrapper.a(i1);
              if (((String)localObject6).equals("src"))
              {
                localObject4 = paramXmlPullParserWrapper.b(i1);
                localObject3 = localObject4;
                if (((String)localObject4).indexOf("http") == -1)
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("http::");
                  ((StringBuilder)localObject3).append((String)localObject4);
                  localObject3 = ((StringBuilder)localObject3).toString();
                }
                localObject4 = localObject3;
                localObject5 = localObject1;
              }
              else if (((String)localObject6).equals("width"))
              {
                localObject5 = paramXmlPullParserWrapper.b(i1);
                localObject4 = localObject3;
              }
              else
              {
                localObject4 = localObject3;
                localObject5 = localObject1;
                if (((String)localObject6).equals("height"))
                {
                  localObject2 = paramXmlPullParserWrapper.b(i1);
                  localObject5 = localObject1;
                  localObject4 = localObject3;
                }
              }
              i1 += 1;
              localObject3 = localObject4;
              localObject1 = localObject5;
            }
          }
          throw new IllegalArgumentException("img tag error: has other start tag");
        }
      }
      i1 = paramXmlPullParserWrapper.d();
      localObject3 = localObject4;
      localObject1 = localObject5;
    }
    if (a())
    {
      i1 = a();
      if ((Integer.parseInt(localObject1) < i1) && (Integer.parseInt((String)localObject2) < i1)) {
        return null;
      }
    }
    return FastWebPTSDataConverter.a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, (String)localObject3, localObject1, (String)localObject2, paramSparseArray);
  }
  
  public static List<BaseData> a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    Object localObject = paramFastWebArticleInfo.jdField_a_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    HtmlChangeUtil.TextStyleInfo localTextStyleInfo = new HtmlChangeUtil.TextStyleInfo(null);
    HtmlChangeUtil.XmlPullParserWrapper localXmlPullParserWrapper = new HtmlChangeUtil.XmlPullParserWrapper(Xml.newPullParser(), localTextStyleInfo);
    localXmlPullParserWrapper.a(new StringReader((String)localObject));
    int i1 = localXmlPullParserWrapper.c();
    while (i1 != 1)
    {
      if (i1 != 0) {
        if (i1 != 2)
        {
          if (i1 == 4)
          {
            a(localXmlPullParserWrapper, localTextStyleInfo, localArrayList, paramSparseArray);
            if (2 == localXmlPullParserWrapper.c()) {
              i1 = localXmlPullParserWrapper.c();
            }
          }
        }
        else
        {
          localObject = localXmlPullParserWrapper.b();
          if ((!((String)localObject).equals(b)) && (!((String)localObject).equals(c)))
          {
            if (((String)localObject).equals(i))
            {
              localArrayList.add(a(localXmlPullParserWrapper, paramSparseArray));
            }
            else if (((String)localObject).equals(d))
            {
              a(localXmlPullParserWrapper, localTextStyleInfo, localArrayList, paramSparseArray);
              if (2 == localXmlPullParserWrapper.c()) {
                i1 = localXmlPullParserWrapper.c();
              }
            }
            else if (((String)localObject).equals(o))
            {
              localXmlPullParserWrapper.d();
              c(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, localArrayList, localTextStyleInfo, paramSparseArray);
            }
            else if (((String)localObject).equals(g))
            {
              localObject = a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, paramSparseArray);
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
            else if (((String)localObject).equals(h))
            {
              localArrayList.add(b(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, paramSparseArray));
            }
            else if (((String)localObject).equals(j))
            {
              localObject = a(localXmlPullParserWrapper);
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
            else if (((String)localObject).equals(k))
            {
              a(localXmlPullParserWrapper, localTextStyleInfo, localArrayList, paramSparseArray);
            }
            else
            {
              if ((!((String)localObject).equals(l)) && (!((String)localObject).equals(n)))
              {
                paramAbsBaseArticleInfo = new StringBuilder();
                paramAbsBaseArticleInfo.append(HardCodeUtil.a(2131705717));
                paramAbsBaseArticleInfo.append((String)localObject);
                throw new IllegalArgumentException(paramAbsBaseArticleInfo.toString());
              }
              b(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, localArrayList, localTextStyleInfo, paramSparseArray);
            }
          }
          else {
            a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, localArrayList, localTextStyleInfo, paramSparseArray);
          }
        }
      }
      if (localXmlPullParserWrapper.c() != 2) {
        i1 = localXmlPullParserWrapper.d();
      } else {
        i1 = 2;
      }
    }
    return localArrayList;
  }
  
  private static void a(SpannableString paramSpannableString, SparseArray<Object> paramSparseArray)
  {
    if (paramSparseArray == null) {
      return;
    }
    int i1 = 0;
    while (i1 < paramSparseArray.size())
    {
      Object localObject1 = paramSparseArray.valueAt(i1);
      if (localObject1 != null)
      {
        if ((localObject1 instanceof ArrayList))
        {
          localObject1 = (ArrayList)localObject1;
          int i2 = 0;
          while (i2 < ((ArrayList)localObject1).size())
          {
            Object localObject2 = ((HtmlChangeUtil.SpanBuilder)((ArrayList)localObject1).get(i2)).a();
            if ((localObject2 instanceof HtmlChangeUtil.MyBackgroundColorSpan)) {
              ((HtmlChangeUtil.MyBackgroundColorSpan)localObject2).a(paramSpannableString.toString());
            }
            paramSpannableString.setSpan(localObject2, 0, paramSpannableString.length(), 33);
            i2 += 1;
          }
        }
        localObject1 = ((HtmlChangeUtil.SpanBuilder)localObject1).a();
        if ((localObject1 instanceof HtmlChangeUtil.MyBackgroundColorSpan)) {
          ((HtmlChangeUtil.MyBackgroundColorSpan)localObject1).a(paramSpannableString.toString());
        }
        paramSpannableString.setSpan(localObject1, 0, paramSpannableString.length(), 33);
      }
      i1 += 1;
    }
  }
  
  public static void a(HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, HtmlChangeUtil.TextStyleInfo paramTextStyleInfo, List<BaseData> paramList, SparseArray<Float> paramSparseArray)
  {
    int i4 = paramTextStyleInfo.a();
    int i5 = paramTextStyleInfo.b();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i3 = paramXmlPullParserWrapper.c();
    int i1;
    for (int i2 = 0; i3 != 1; i2 = i1)
    {
      i1 = i2;
      if (i3 != 0) {
        if (i3 != 2)
        {
          if (i3 != 3)
          {
            if (i3 != 4)
            {
              i1 = i2;
            }
            else
            {
              SpannableString localSpannableString = new SpannableString(paramXmlPullParserWrapper.a().replaceAll(" +", " ").replaceAll("\t+", " "));
              a(localSpannableString, paramTextStyleInfo.b);
              localSpannableStringBuilder.append(localSpannableString);
              i1 = i2;
            }
          }
          else
          {
            if (i2 == 0) {
              break;
            }
            i1 = i2 - 1;
          }
        }
        else
        {
          i1 = i2 + 1;
          if (!a(paramXmlPullParserWrapper.b())) {
            break;
          }
        }
      }
      i3 = paramXmlPullParserWrapper.d();
    }
    paramXmlPullParserWrapper = localSpannableStringBuilder.toString();
    if (!TextUtils.isEmpty(paramXmlPullParserWrapper.replaceAll(" ", "").trim())) {
      paramList.add(FastWebPTSDataConverter.a(paramXmlPullParserWrapper, localSpannableStringBuilder, i4, i5, paramSparseArray));
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, List<BaseData> paramList, HtmlChangeUtil.TextStyleInfo paramTextStyleInfo, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramXmlPullParserWrapper.c();
    int i3 = paramXmlPullParserWrapper.a();
    while (i1 != 1)
    {
      int i2 = paramXmlPullParserWrapper.c();
      if (i2 != 0) {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 == 4)
            {
              a(paramXmlPullParserWrapper, paramTextStyleInfo, paramList, paramSparseArray);
              i1 = i2;
            }
          }
          else if (((!paramXmlPullParserWrapper.b().equals(b)) && (!paramXmlPullParserWrapper.b().equals(c))) || (i3 != paramXmlPullParserWrapper.a())) {}
        }
        else
        {
          Object localObject = paramXmlPullParserWrapper.b();
          if (a((String)localObject))
          {
            a(paramXmlPullParserWrapper, paramTextStyleInfo, paramList, paramSparseArray);
            i1 = i2;
            continue;
          }
          if (((String)localObject).equals(g))
          {
            localObject = a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramSparseArray);
            i1 = i2;
            if (localObject == null) {
              continue;
            }
            paramList.add(localObject);
            i1 = i2;
            continue;
          }
          if (((String)localObject).equals(h))
          {
            paramList.add(b(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramSparseArray));
            i1 = i2;
            continue;
          }
          if (((String)localObject).equals(i))
          {
            paramList.add(a(paramXmlPullParserWrapper, paramSparseArray));
            i1 = i2;
            continue;
          }
          if ((!((String)localObject).equals(l)) && (!((String)localObject).equals(n)))
          {
            if (((String)localObject).equals(o))
            {
              paramXmlPullParserWrapper.d();
              c(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramList, paramTextStyleInfo, paramSparseArray);
              i1 = i2;
              continue;
            }
            if (!((String)localObject).equals(b)) {
              if (!((String)localObject).equals(c)) {
                break;
              }
            }
          }
          else
          {
            b(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramList, paramTextStyleInfo, paramSparseArray);
            i1 = i2;
            continue;
          }
        }
      }
      i1 = paramXmlPullParserWrapper.d();
    }
  }
  
  private static boolean a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(267);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("enable_filter_small_pic", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean a(String paramString)
  {
    return (paramString.equals(d)) || (paramString.equals(e)) || (paramString.equals(f)) || (paramString.equals(k));
  }
  
  public static BaseData b(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, SparseArray<Float> paramSparseArray)
  {
    int i4 = paramXmlPullParserWrapper.c();
    Object localObject5 = "";
    Object localObject4 = localObject5;
    Object localObject3 = localObject4;
    Object localObject2 = localObject3;
    Object localObject1 = localObject2;
    int i3 = 0;
    int i1 = 0;
    int i7;
    for (int i2 = 1; i4 != 1; i2 = i7)
    {
      Object localObject6 = localObject5;
      Object localObject7 = localObject4;
      int i5 = i3;
      int i6 = i1;
      Object localObject8 = localObject3;
      Object localObject9 = localObject2;
      Object localObject10 = localObject1;
      i7 = i2;
      if (i4 != 0) {
        if (i4 != 2)
        {
          if (i4 != 3)
          {
            localObject6 = localObject5;
            localObject7 = localObject4;
            i5 = i3;
            i6 = i1;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            i7 = i2;
          }
          else
          {
            if (h.equals(paramXmlPullParserWrapper.b())) {
              break;
            }
            throw new IllegalArgumentException("video tag error: has other end tag");
          }
        }
        else
        {
          if (paramXmlPullParserWrapper.b().equals(h))
          {
            int i8 = paramXmlPullParserWrapper.b();
            i4 = 0;
            for (;;)
            {
              localObject6 = localObject5;
              localObject7 = localObject4;
              i5 = i3;
              i6 = i1;
              localObject8 = localObject3;
              localObject9 = localObject2;
              localObject10 = localObject1;
              i7 = i2;
              if (i4 >= i8) {
                break;
              }
              String str = paramXmlPullParserWrapper.a(i4);
              if (str.equals("vid"))
              {
                localObject7 = paramXmlPullParserWrapper.b(i4);
                localObject6 = localObject5;
                i5 = i3;
                i6 = i1;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
              }
              else if (str.equals("width"))
              {
                i5 = Integer.valueOf(paramXmlPullParserWrapper.b(i4)).intValue();
                localObject6 = localObject5;
                localObject7 = localObject4;
                i6 = i1;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
              }
              else if (str.equals("height"))
              {
                i6 = Integer.valueOf(paramXmlPullParserWrapper.b(i4)).intValue();
                localObject6 = localObject5;
                localObject7 = localObject4;
                i5 = i3;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
              }
              else if (str.equals("cover"))
              {
                localObject6 = paramXmlPullParserWrapper.b(i4);
                localObject7 = localObject4;
                i5 = i3;
                i6 = i1;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
              }
              else if (str.equals("tid"))
              {
                localObject10 = paramXmlPullParserWrapper.b(i4);
                localObject6 = localObject5;
                localObject7 = localObject4;
                i5 = i3;
                i6 = i1;
                localObject8 = localObject3;
                localObject9 = localObject2;
              }
              else if (str.equals("appid"))
              {
                localObject8 = paramXmlPullParserWrapper.b(i4);
                localObject6 = localObject5;
                localObject7 = localObject4;
                i5 = i3;
                i6 = i1;
                localObject9 = localObject2;
                localObject10 = localObject1;
              }
              else if (str.equals("appkey"))
              {
                localObject9 = paramXmlPullParserWrapper.b(i4);
                localObject6 = localObject5;
                localObject7 = localObject4;
                i5 = i3;
                i6 = i1;
                localObject8 = localObject3;
                localObject10 = localObject1;
              }
              else
              {
                localObject6 = localObject5;
                localObject7 = localObject4;
                i5 = i3;
                i6 = i1;
                localObject8 = localObject3;
                localObject9 = localObject2;
                localObject10 = localObject1;
                if (str.equals("busitype"))
                {
                  i2 = Integer.valueOf(paramXmlPullParserWrapper.b(i4)).intValue();
                  localObject10 = localObject1;
                  localObject9 = localObject2;
                  localObject8 = localObject3;
                  i6 = i1;
                  i5 = i3;
                  localObject7 = localObject4;
                  localObject6 = localObject5;
                }
              }
              i4 += 1;
              localObject5 = localObject6;
              localObject4 = localObject7;
              i3 = i5;
              i1 = i6;
              localObject3 = localObject8;
              localObject2 = localObject9;
              localObject1 = localObject10;
            }
          }
          throw new IllegalArgumentException("video tag error: has other start tag");
        }
      }
      i4 = paramXmlPullParserWrapper.d();
      localObject5 = localObject6;
      localObject4 = localObject7;
      i3 = i5;
      i1 = i6;
      localObject3 = localObject8;
      localObject2 = localObject9;
      localObject1 = localObject10;
    }
    return FastWebPTSDataConverter.a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, (String)localObject5, localObject4, i3, i1, localObject3, localObject2, localObject1, i2, paramSparseArray);
  }
  
  private static HashMap<String, String> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split(";");
    int i1 = 0;
    while (i1 < paramString.length)
    {
      Object localObject = paramString[i1].split(":");
      if (localObject.length == 2)
      {
        String str = localObject[0].trim();
        localObject = localObject[1].trim();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localHashMap.put(str.toLowerCase(), ((String)localObject).toLowerCase());
        }
      }
      i1 += 1;
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
      try
      {
        String[] arrayOfString = paramString.split(";");
        int i2 = 0;
        if (i2 < arrayOfString.length)
        {
          Object localObject = arrayOfString[i2].split(":");
          if (localObject.length == 2)
          {
            paramString = localObject[0].trim();
            localObject = localObject[1].trim();
            if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
              if (p.equals(paramString))
              {
                if ("underline".equals(localObject)) {
                  localArrayList.add(HtmlChangeUtil.SpanBuilder.a(3, new Object[0]));
                } else if ("line-through".equals(localObject)) {
                  localArrayList.add(HtmlChangeUtil.SpanBuilder.a(5, new Object[0]));
                }
              }
              else if ((q.equals(paramString)) || (r.equals(paramString)))
              {
                if (((String)localObject).startsWith("rgb("))
                {
                  localObject = localObject.split("\\(")[1].split("\\)")[0].split(",");
                  if (localObject.length != 3) {
                    break label404;
                  }
                  i1 = Color.rgb(Integer.valueOf(localObject[0].trim()).intValue(), Integer.valueOf(localObject[1].trim()).intValue(), Integer.valueOf(localObject[2].trim()).intValue());
                }
                else if (((String)localObject).startsWith("#"))
                {
                  i1 = Color.parseColor((String)localObject);
                }
                else
                {
                  if (!jdField_a_of_type_JavaUtilHashMap.containsKey(((String)localObject).toLowerCase())) {
                    break label404;
                  }
                  i1 = Color.parseColor((String)jdField_a_of_type_JavaUtilHashMap.get(((String)localObject).toLowerCase()));
                }
                if (i1 != -1)
                {
                  if ("color".equals(paramString)) {
                    paramString = HtmlChangeUtil.SpanBuilder.a(2, new Object[] { Integer.valueOf(i1) });
                  } else {
                    paramString = HtmlChangeUtil.SpanBuilder.a(1, new Object[] { Integer.valueOf(i1) });
                  }
                  localArrayList.add(paramString);
                }
              }
            }
          }
          i2 += 1;
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramString)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramString, new Object[0]);
      }
      label404:
      int i1 = -1;
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, List<BaseData> paramList, HtmlChangeUtil.TextStyleInfo paramTextStyleInfo, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramXmlPullParserWrapper.c();
    int i3 = paramXmlPullParserWrapper.a();
    while (i1 != 1)
    {
      int i2 = paramXmlPullParserWrapper.c();
      if (i2 != 0)
      {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 != 4) {
              break label320;
            }
            a(paramXmlPullParserWrapper, paramTextStyleInfo, paramList, paramSparseArray);
            i1 = i2;
          }
        }
        else
        {
          Object localObject = paramXmlPullParserWrapper.b();
          if (a((String)localObject))
          {
            a(paramXmlPullParserWrapper, paramTextStyleInfo, paramList, paramSparseArray);
            i1 = i2;
            continue;
          }
          if (((String)localObject).equals(g))
          {
            localObject = a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramSparseArray);
            i1 = i2;
            if (localObject == null) {
              continue;
            }
            paramList.add(localObject);
            i1 = i2;
            continue;
          }
          if (((String)localObject).equals(h))
          {
            paramList.add(b(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramSparseArray));
            i1 = i2;
            continue;
          }
          if (((String)localObject).equals(i))
          {
            paramList.add(a(paramXmlPullParserWrapper, paramSparseArray));
            i1 = i2;
            continue;
          }
          if ((((String)localObject).equals(n)) || (((String)localObject).equals(l))) {
            break label320;
          }
          if ((!((String)localObject).equals(b)) && (!((String)localObject).equals(c)))
          {
            if (((String)localObject).equals(m))
            {
              paramXmlPullParserWrapper.d();
              a(paramXmlPullParserWrapper, paramTextStyleInfo, paramList, paramSparseArray);
              i1 = i2;
              continue;
            }
            throw new IOException("illegal tag include in list element(ul or ol)");
          }
          a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramList, paramTextStyleInfo, paramSparseArray);
        }
        if (i3 == paramXmlPullParserWrapper.a()) {
          return;
        }
      }
      label320:
      i1 = paramXmlPullParserWrapper.d();
    }
  }
  
  public static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, List<BaseData> paramList, HtmlChangeUtil.TextStyleInfo paramTextStyleInfo, SparseArray<Float> paramSparseArray)
  {
    int i1;
    label92:
    label103:
    label114:
    do
    {
      i1 = paramXmlPullParserWrapper.c();
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            break label114;
          }
        }
        else {
          if (!paramXmlPullParserWrapper.b().equals(o)) {
            break label114;
          }
        }
      }
      else
      {
        String str = paramXmlPullParserWrapper.b();
        if ((str.equals(b)) || (str.equals(c))) {
          break label103;
        }
        if (!a(str)) {
          break label92;
        }
      }
      a(paramXmlPullParserWrapper, paramTextStyleInfo, paramList, paramSparseArray);
      continue;
      throw new IOException("blockquote tag include no text tag !");
      a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramList, paramTextStyleInfo, paramSparseArray);
      paramXmlPullParserWrapper.d();
    } while (i1 != 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.HtmlChangeUtil
 * JD-Core Version:    0.7.0.1
 */