package com.tencent.mobileqq.ocr.data;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TranslateResult
  implements Parcelable
{
  public static final Parcelable.Creator<TranslateResult> CREATOR = new TranslateResult.1();
  public int a;
  public String a;
  public List<TranslateResult.Record> a;
  public int b;
  public String b;
  public List<String> b;
  public String c;
  public String d;
  public String e;
  
  public TranslateResult(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected TranslateResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilList = paramParcel.createTypedArrayList(TranslateResult.Record.CREATOR);
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_b_of_type_JavaUtilList = paramParcel.createStringArrayList();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.e = paramParcel.readString();
  }
  
  public CharSequence a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        TranslateResult.Record localRecord = (TranslateResult.Record)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((!TextUtils.isEmpty(localRecord.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localRecord.jdField_b_of_type_JavaLangString)))
        {
          ((StringBuilder)localObject).append(localRecord.jdField_b_of_type_JavaLangString);
          if (i < this.jdField_a_of_type_JavaUtilList.size() - 1) {
            ((StringBuilder)localObject).append("\n\n");
          }
        }
        i += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        TranslateResult.Record localRecord = (TranslateResult.Record)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.isEmpty(localRecord.jdField_b_of_type_JavaLangString))
        {
          ((StringBuilder)localObject).append(localRecord.jdField_b_of_type_JavaLangString);
          if (i + 1 != this.jdField_a_of_type_JavaUtilList.size()) {
            ((StringBuilder)localObject).append("\n");
          }
        }
        i += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    paramString1 = new TranslateResult.Record();
    paramString1.jdField_a_of_type_JavaLangString = paramString3;
    paramString1.jdField_b_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      int j = Math.min(paramList1.size(), paramList2.size());
      int i = 0;
      while (i < j)
      {
        paramString1 = new TranslateResult.Record();
        paramString1.jdField_a_of_type_JavaLangString = ((String)paramList1.get(i));
        paramString1.jdField_b_of_type_JavaLangString = ((String)paramList2.get(i));
        this.jdField_a_of_type_JavaUtilList.add(paramString1);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    return (localList == null) || (localList.size() == 0);
  }
  
  public CharSequence b()
  {
    Object localObject = a();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(Color.parseColor("#12B7F5"));
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(localForegroundColorSpan, 0, ((SpannableString)localObject).length(), 33);
    return localObject;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 0;
  }
  
  public CharSequence c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        TranslateResult.Record localRecord = (TranslateResult.Record)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((!TextUtils.isEmpty(localRecord.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localRecord.jdField_b_of_type_JavaLangString)))
        {
          ((StringBuilder)localObject).append(localRecord.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject).append("\n\n");
        }
        i += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public CharSequence d()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      Object localObject2 = new StringBuilder();
      localObject1 = new ArrayList();
      int i = 0;
      Object localObject3;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject3 = (TranslateResult.Record)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((!TextUtils.isEmpty(((TranslateResult.Record)localObject3).jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(((TranslateResult.Record)localObject3).jdField_b_of_type_JavaLangString)))
        {
          ((StringBuilder)localObject2).append(((TranslateResult.Record)localObject3).jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append("\n");
          int j = ((StringBuilder)localObject2).length();
          ((StringBuilder)localObject2).append(((TranslateResult.Record)localObject3).jdField_b_of_type_JavaLangString);
          ((List)localObject1).add(new Pair(Integer.valueOf(j), Integer.valueOf(((StringBuilder)localObject2).length())));
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append("\n");
        }
        i += 1;
      }
      localObject2 = new SpannableString(((StringBuilder)localObject2).toString());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Pair)((Iterator)localObject1).next();
        ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), ((Integer)((Pair)localObject3).first).intValue(), ((Integer)((Pair)localObject3).second).intValue(), 33);
      }
      return localObject2;
    }
    return "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TranslateResult{type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", srcLang='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dstLang='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", records=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", imagePath='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uuid='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sLanguages=");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilList);
    localStringBuilder.append(", errCode=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", errMsg='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeStringList(this.jdField_b_of_type_JavaUtilList);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.TranslateResult
 * JD-Core Version:    0.7.0.1
 */