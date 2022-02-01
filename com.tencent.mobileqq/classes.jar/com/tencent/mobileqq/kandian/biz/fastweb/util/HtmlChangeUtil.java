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
  public static final HashMap<String, String> a = new HashMap();
  private static String b = "HtmlChangeUtil";
  private static String c = "p";
  private static String d = "section";
  private static String e = "strong";
  private static String f = "i";
  private static String g = "u";
  private static String h = "img";
  private static String i = "video";
  private static String j = "a";
  private static String k = "proteus";
  private static String l = "span";
  private static String m = "ul";
  private static String n = "li";
  private static String o = "ol";
  private static String p = "blockquote";
  private static String q = "text-decoration";
  private static String r = "color";
  private static String s = "background-color";
  
  static
  {
    a.put("aqua", "#00FFFF");
    a.put("black", "#000000");
    a.put("blue", "#0000FF");
    a.put("fuchsia", "#FF00FF");
    a.put("gray", "#808080");
    a.put("green", "#008000");
    a.put("lime", "#00FF00");
    a.put("maroon", "#800000");
    a.put("navy", "#000080");
    a.put("olive", "#808000");
    a.put("purple", "#800080");
    a.put("red", "#FF0000");
    a.put("silver", "#C0C0C0");
    a.put("teal", "#008080");
    a.put("white", "#FFFFFF");
    a.put("yellow", "#FFFF00");
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
            localProteusBookData.e = paramJSONObject.getString("id");
          }
          if (paramJSONObject.has("card_type")) {
            localProteusBookData.d = paramJSONObject.getString("card_type");
          }
          if (paramJSONObject.has("sid")) {
            localProteusBookData.f = paramJSONObject.getString("sid");
          }
          String str = b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("data: ");
          localStringBuilder.append(paramJSONObject);
          QLog.d(str, 1, localStringBuilder.toString());
          localProteusBookData.b = ((TemplateBean)localObject1);
          localProteusBookData.c = ((String)localObject2);
          return localProteusBookData;
        }
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = b;
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
          if (!PTSLiteSwitchManager.a().b()) {
            return null;
          }
          paramXmlPullParserWrapper = FastWebPtsLiteDataUtil.b(paramXmlPullParserWrapper);
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
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseProteusData error!  msg=");
      localStringBuilder.append(paramXmlPullParserWrapper);
      QLog.d(str, 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public static BaseData a(HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper)
  {
    int i1 = paramXmlPullParserWrapper.e();
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
            if (k.equals(paramXmlPullParserWrapper.c())) {
              break;
            }
            throw new IllegalArgumentException("proteus tag error: has other end tag");
          }
        }
        else
        {
          if (paramXmlPullParserWrapper.c().equals(k))
          {
            int i2 = paramXmlPullParserWrapper.d();
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
      i1 = paramXmlPullParserWrapper.g();
      localObject3 = localObject4;
      localObject1 = localObject5;
    }
    if (((localObject3 instanceof ProteusBookData)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      ((ProteusBookData)localObject3).a = ((String)localObject1);
      return localObject3;
    }
    if ((localObject3 instanceof PtsData)) {
      ((PtsData)localObject3).b = ((String)localObject2);
    }
    return localObject3;
  }
  
  private static BaseData a(HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, SparseArray<Float> paramSparseArray)
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(localStringWriter);
    int i1 = paramXmlPullParserWrapper.e();
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
              localXmlSerializer.text(paramXmlPullParserWrapper.b());
              localObject2 = localObject1;
            }
          }
          else
          {
            if (j.equals(paramXmlPullParserWrapper.c()))
            {
              localXmlSerializer.endTag("", j);
              break;
            }
            throw new IllegalArgumentException("a tag error: has other end tag");
          }
        }
        else
        {
          localObject2 = paramXmlPullParserWrapper.c();
          if (((String)localObject2).equals(j))
          {
            localXmlSerializer.startTag("", (String)localObject2);
            int i2 = paramXmlPullParserWrapper.d();
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
          throw new IllegalArgumentException(HardCodeUtil.a(2131903603));
        }
      }
      i1 = paramXmlPullParserWrapper.g();
    }
    localXmlSerializer.flush();
    return FastWebPTSDataConverter.a(localStringWriter.toString(), (String)localObject1, paramSparseArray);
  }
  
  public static BaseData a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramXmlPullParserWrapper.e();
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
            if (h.equals(paramXmlPullParserWrapper.c())) {
              break;
            }
            throw new IllegalArgumentException("img tag error: has other end tag");
          }
        }
        else
        {
          if (paramXmlPullParserWrapper.c().equals(h))
          {
            int i2 = paramXmlPullParserWrapper.d();
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
      i1 = paramXmlPullParserWrapper.g();
      localObject3 = localObject4;
      localObject1 = localObject5;
    }
    if (i())
    {
      i1 = j();
      if ((Integer.parseInt(localObject1) < i1) && (Integer.parseInt((String)localObject2) < i1)) {
        return null;
      }
    }
    return FastWebPTSDataConverter.a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, (String)localObject3, localObject1, (String)localObject2, paramSparseArray);
  }
  
  public static List<BaseData> a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    Object localObject = paramFastWebArticleInfo.b;
    ArrayList localArrayList = new ArrayList();
    HtmlChangeUtil.TextStyleInfo localTextStyleInfo = new HtmlChangeUtil.TextStyleInfo(null);
    HtmlChangeUtil.XmlPullParserWrapper localXmlPullParserWrapper = new HtmlChangeUtil.XmlPullParserWrapper(Xml.newPullParser(), localTextStyleInfo);
    localXmlPullParserWrapper.a(new StringReader((String)localObject));
    int i1 = localXmlPullParserWrapper.e();
    while (i1 != 1)
    {
      if (i1 != 0) {
        if (i1 != 2)
        {
          if (i1 == 4)
          {
            a(localXmlPullParserWrapper, localTextStyleInfo, localArrayList, paramSparseArray);
            if (2 == localXmlPullParserWrapper.e()) {
              i1 = localXmlPullParserWrapper.e();
            }
          }
        }
        else
        {
          localObject = localXmlPullParserWrapper.c();
          if ((!((String)localObject).equals(c)) && (!((String)localObject).equals(d)))
          {
            if (((String)localObject).equals(j))
            {
              localArrayList.add(a(localXmlPullParserWrapper, paramSparseArray));
            }
            else if (((String)localObject).equals(e))
            {
              a(localXmlPullParserWrapper, localTextStyleInfo, localArrayList, paramSparseArray);
              if (2 == localXmlPullParserWrapper.e()) {
                i1 = localXmlPullParserWrapper.e();
              }
            }
            else if (((String)localObject).equals(p))
            {
              localXmlPullParserWrapper.g();
              c(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, localArrayList, localTextStyleInfo, paramSparseArray);
            }
            else if (((String)localObject).equals(h))
            {
              localObject = a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, paramSparseArray);
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
            else if (((String)localObject).equals(i))
            {
              localArrayList.add(b(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, paramSparseArray));
            }
            else if (((String)localObject).equals(k))
            {
              localObject = a(localXmlPullParserWrapper);
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
            else if (((String)localObject).equals(l))
            {
              a(localXmlPullParserWrapper, localTextStyleInfo, localArrayList, paramSparseArray);
            }
            else
            {
              if ((!((String)localObject).equals(m)) && (!((String)localObject).equals(o)))
              {
                paramAbsBaseArticleInfo = new StringBuilder();
                paramAbsBaseArticleInfo.append(HardCodeUtil.a(2131903602));
                paramAbsBaseArticleInfo.append((String)localObject);
                throw new IllegalArgumentException(paramAbsBaseArticleInfo.toString());
              }
              b(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, localArrayList, localTextStyleInfo, paramSparseArray);
            }
          }
          else
          {
            a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, localArrayList);
            a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, localXmlPullParserWrapper, localArrayList, localTextStyleInfo, paramSparseArray);
          }
        }
      }
      if (localXmlPullParserWrapper.e() != 2) {
        i1 = localXmlPullParserWrapper.g();
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
    int i3 = paramXmlPullParserWrapper.e();
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
              SpannableString localSpannableString = new SpannableString(paramXmlPullParserWrapper.b().replaceAll(" +", " ").replaceAll("\t+", " "));
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
          if (!c(paramXmlPullParserWrapper.c())) {
            break;
          }
        }
      }
      i3 = paramXmlPullParserWrapper.g();
    }
    paramXmlPullParserWrapper = localSpannableStringBuilder.toString();
    if (!TextUtils.isEmpty(paramXmlPullParserWrapper.replaceAll(" ", "").trim())) {
      paramList.add(FastWebPTSDataConverter.a(paramXmlPullParserWrapper, localSpannableStringBuilder, i4, i5, paramSparseArray));
    }
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, List<BaseData> paramList)
  {
    boolean bool = paramXmlPullParserWrapper.c().equals(c);
    Object localObject1 = "";
    if (bool)
    {
      int i2 = paramXmlPullParserWrapper.d();
      int i1 = 0;
      String str = "";
      for (;;)
      {
        localObject3 = localObject1;
        localObject2 = str;
        if (i1 >= i2) {
          break;
        }
        localObject3 = paramXmlPullParserWrapper.a(i1);
        if (((String)localObject3).equals("busi-id"))
        {
          localObject2 = paramXmlPullParserWrapper.b(i1);
        }
        else
        {
          localObject2 = localObject1;
          if (((String)localObject3).equals("busi-type"))
          {
            str = paramXmlPullParserWrapper.b(i1);
            localObject2 = localObject1;
          }
        }
        i1 += 1;
        localObject1 = localObject2;
      }
    }
    Object localObject2 = "";
    Object localObject3 = localObject1;
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      paramList.add(FastWebPTSDataConverter.a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, (String)localObject3, (String)localObject2));
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, List<BaseData> paramList, HtmlChangeUtil.TextStyleInfo paramTextStyleInfo, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramXmlPullParserWrapper.e();
    int i3 = paramXmlPullParserWrapper.a();
    while (i1 != 1)
    {
      int i2 = paramXmlPullParserWrapper.e();
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
          else if (((!paramXmlPullParserWrapper.c().equals(c)) && (!paramXmlPullParserWrapper.c().equals(d))) || (i3 != paramXmlPullParserWrapper.a())) {}
        }
        else
        {
          Object localObject = paramXmlPullParserWrapper.c();
          if (c((String)localObject))
          {
            a(paramXmlPullParserWrapper, paramTextStyleInfo, paramList, paramSparseArray);
            i1 = i2;
            continue;
          }
          if (((String)localObject).equals(h))
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
          if (((String)localObject).equals(i))
          {
            paramList.add(b(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramSparseArray));
            i1 = i2;
            continue;
          }
          if (((String)localObject).equals(j))
          {
            paramList.add(a(paramXmlPullParserWrapper, paramSparseArray));
            i1 = i2;
            continue;
          }
          if ((!((String)localObject).equals(m)) && (!((String)localObject).equals(o)))
          {
            if (((String)localObject).equals(p))
            {
              paramXmlPullParserWrapper.g();
              c(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramList, paramTextStyleInfo, paramSparseArray);
              i1 = i2;
              continue;
            }
            if (!((String)localObject).equals(c)) {
              if (!((String)localObject).equals(d)) {
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
      i1 = paramXmlPullParserWrapper.g();
    }
  }
  
  public static BaseData b(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, SparseArray<Float> paramSparseArray)
  {
    int i4 = paramXmlPullParserWrapper.e();
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
            if (i.equals(paramXmlPullParserWrapper.c())) {
              break;
            }
            throw new IllegalArgumentException("video tag error: has other end tag");
          }
        }
        else
        {
          if (paramXmlPullParserWrapper.c().equals(i))
          {
            int i8 = paramXmlPullParserWrapper.d();
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
      i4 = paramXmlPullParserWrapper.g();
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
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, HtmlChangeUtil.XmlPullParserWrapper paramXmlPullParserWrapper, List<BaseData> paramList, HtmlChangeUtil.TextStyleInfo paramTextStyleInfo, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramXmlPullParserWrapper.e();
    int i3 = paramXmlPullParserWrapper.a();
    while (i1 != 1)
    {
      int i2 = paramXmlPullParserWrapper.e();
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
          Object localObject = paramXmlPullParserWrapper.c();
          if (c((String)localObject))
          {
            a(paramXmlPullParserWrapper, paramTextStyleInfo, paramList, paramSparseArray);
            i1 = i2;
            continue;
          }
          if (((String)localObject).equals(h))
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
          if (((String)localObject).equals(i))
          {
            paramList.add(b(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramSparseArray));
            i1 = i2;
            continue;
          }
          if (((String)localObject).equals(j))
          {
            paramList.add(a(paramXmlPullParserWrapper, paramSparseArray));
            i1 = i2;
            continue;
          }
          if ((((String)localObject).equals(o)) || (((String)localObject).equals(m))) {
            break label320;
          }
          if ((!((String)localObject).equals(c)) && (!((String)localObject).equals(d)))
          {
            if (((String)localObject).equals(n))
            {
              paramXmlPullParserWrapper.g();
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
      i1 = paramXmlPullParserWrapper.g();
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
      i1 = paramXmlPullParserWrapper.e();
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            break label114;
          }
        }
        else {
          if (!paramXmlPullParserWrapper.c().equals(p)) {
            break label114;
          }
        }
      }
      else
      {
        String str = paramXmlPullParserWrapper.c();
        if ((str.equals(c)) || (str.equals(d))) {
          break label103;
        }
        if (!c(str)) {
          break label92;
        }
      }
      a(paramXmlPullParserWrapper, paramTextStyleInfo, paramList, paramSparseArray);
      continue;
      throw new IOException("blockquote tag include no text tag !");
      a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramXmlPullParserWrapper, paramList, paramTextStyleInfo, paramSparseArray);
      paramXmlPullParserWrapper.g();
    } while (i1 != 1);
  }
  
  private static boolean c(String paramString)
  {
    return (paramString.equals(e)) || (paramString.equals(f)) || (paramString.equals(g)) || (paramString.equals(l));
  }
  
  private static List<Object> d(String paramString)
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
              if (q.equals(paramString))
              {
                if ("underline".equals(localObject)) {
                  localArrayList.add(HtmlChangeUtil.SpanBuilder.a(3, new Object[0]));
                } else if ("line-through".equals(localObject)) {
                  localArrayList.add(HtmlChangeUtil.SpanBuilder.a(5, new Object[0]));
                }
              }
              else if ((r.equals(paramString)) || (s.equals(paramString)))
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
                  if (!a.containsKey(((String)localObject).toLowerCase())) {
                    break label404;
                  }
                  i1 = Color.parseColor((String)a.get(((String)localObject).toLowerCase()));
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
        QLog.e(b, 2, paramString, new Object[0]);
      }
      label404:
      int i1 = -1;
    }
  }
  
  private static HashMap<String, String> e(String paramString)
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
  
  private static boolean i()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(267);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("enable_filter_small_pic", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private static int j()
  {
    return Aladdin.getConfig(267).getIntegerFromString("filter_small_pic_size", 30);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.HtmlChangeUtil
 * JD-Core Version:    0.7.0.1
 */