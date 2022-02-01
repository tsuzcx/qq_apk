package com.tencent.mobileqq.ocr;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class OCRPerformUtil$OCRLanHolder
{
  public String a = "";
  public List<String> b;
  public HashMap<String, String> c;
  public String d = "";
  public String e = "";
  public List<String> f;
  public List<String> g;
  
  public Pair<String, String> a(String paramString)
  {
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((String)localEntry.getKey()).equalsIgnoreCase(paramString)) {
        return new Pair(localEntry.getKey(), localEntry.getValue());
      }
    }
    return null;
  }
  
  public String a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ocrLan:");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(", ocrLanOptions:");
    ((StringBuilder)localObject1).append(this.b.toString());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("srcLan:");
    ((StringBuilder)localObject2).append(this.d);
    ((StringBuilder)localObject2).append(", srcLanOptions:");
    ((StringBuilder)localObject2).append(this.f.toString());
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("dstLan:");
    ((StringBuilder)localObject3).append(this.e);
    ((StringBuilder)localObject3).append(", dstLanOptions:");
    ((StringBuilder)localObject3).append(this.g.toString());
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("\n");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("\n");
    localStringBuilder.append((String)localObject3);
    return localStringBuilder.toString();
  }
  
  public void a(OCRLanHolder paramOCRLanHolder)
  {
    this.a = paramOCRLanHolder.a;
    this.b = paramOCRLanHolder.b;
    this.c = paramOCRLanHolder.c;
    this.d = paramOCRLanHolder.d;
    this.e = paramOCRLanHolder.e;
    this.f.clear();
    this.g.clear();
    this.f.addAll(paramOCRLanHolder.f);
    this.g.addAll(paramOCRLanHolder.g);
  }
  
  public boolean a(List<String> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((String)paramList.next()).trim().equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public String b(String paramString)
  {
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.a = paramString;
    this.d = paramString;
    this.e = "zh";
    this.f.clear();
    this.g.clear();
    this.g.add(this.e);
    this.f.add(this.d);
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.d = paramString;
      this.g = OCRPerformUtil.b(this.d);
      this.e = ((String)this.g.get(0));
    }
  }
  
  public void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.e = paramString;
    }
  }
  
  public String f(String paramString)
  {
    if (paramString.equalsIgnoreCase("zh")) {
      return "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th".trim().split("/")[0];
    }
    return "zh";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformUtil.OCRLanHolder
 * JD-Core Version:    0.7.0.1
 */