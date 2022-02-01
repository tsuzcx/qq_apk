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
  public String a;
  public HashMap<String, String> a;
  public List<String> a;
  public String b;
  public List<String> b;
  public String c;
  public List<String> c;
  
  public OCRPerformUtil$OCRLanHolder()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public Pair<String, String> a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
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
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(", ocrLanOptions:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.toString());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("srcLan:");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(", srcLanOptions:");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaUtilList.toString());
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("dstLan:");
    ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject3).append(", dstLanOptions:");
    ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaUtilList.toString());
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("\n");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("\n");
    localStringBuilder.append((String)localObject3);
    return localStringBuilder.toString();
  }
  
  public String a(String paramString)
  {
    return OcrConfig.getDefaultLanguageName(paramString);
  }
  
  public void a(OCRLanHolder paramOCRLanHolder)
  {
    this.jdField_a_of_type_JavaLangString = paramOCRLanHolder.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaUtilList = paramOCRLanHolder.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_JavaUtilHashMap = paramOCRLanHolder.jdField_a_of_type_JavaUtilHashMap;
    this.jdField_b_of_type_JavaLangString = paramOCRLanHolder.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramOCRLanHolder.jdField_c_of_type_JavaLangString;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramOCRLanHolder.jdField_b_of_type_JavaUtilList);
    this.jdField_c_of_type_JavaUtilList.addAll(paramOCRLanHolder.jdField_c_of_type_JavaUtilList);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_JavaLangString = "zh";
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaLangString);
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
    if (paramString.equalsIgnoreCase("zh")) {
      return "en/ja/ko/fr/es/it/de/tr/ru/pt/vi/id/ms/th".trim().split("/")[0];
    }
    return "zh";
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_c_of_type_JavaUtilList = OCRPerformUtil.a(this.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = ((String)this.jdField_c_of_type_JavaUtilList.get(0));
    }
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_c_of_type_JavaLangString = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformUtil.OCRLanHolder
 * JD-Core Version:    0.7.0.1
 */