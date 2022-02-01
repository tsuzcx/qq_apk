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
  public String b;
  public String c;
  public List<TranslateResult.Record> d;
  public String e;
  public String f;
  public List<String> g;
  public int h;
  public String i;
  
  public TranslateResult(int paramInt)
  {
    this.a = paramInt;
    this.d = new ArrayList();
  }
  
  protected TranslateResult(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.createTypedArrayList(TranslateResult.Record.CREATOR);
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.createStringArrayList();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readString();
  }
  
  public CharSequence a()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      int j = 0;
      while (j < this.d.size())
      {
        TranslateResult.Record localRecord = (TranslateResult.Record)this.d.get(j);
        if ((!TextUtils.isEmpty(localRecord.a)) && (!TextUtils.isEmpty(localRecord.b)))
        {
          ((StringBuilder)localObject).append(localRecord.b);
          if (j < this.d.size() - 1) {
            ((StringBuilder)localObject).append("\n\n");
          }
        }
        j += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = paramString1;
    this.c = paramString2;
    paramString1 = new TranslateResult.Record();
    paramString1.a = paramString3;
    paramString1.b = paramString4;
    this.d.add(paramString1);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return;
      }
      this.b = paramString1;
      this.c = paramString2;
      int k = Math.min(paramList1.size(), paramList2.size());
      int j = 0;
      while (j < k)
      {
        paramString1 = new TranslateResult.Record();
        paramString1.a = ((String)paramList1.get(j));
        paramString1.b = ((String)paramList2.get(j));
        this.d.add(paramString1);
        j += 1;
      }
    }
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
  
  public String c()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      int j = 0;
      while (j < this.d.size())
      {
        TranslateResult.Record localRecord = (TranslateResult.Record)this.d.get(j);
        if (!TextUtils.isEmpty(localRecord.b))
        {
          ((StringBuilder)localObject).append(localRecord.b);
          if (j + 1 != this.d.size()) {
            ((StringBuilder)localObject).append("\n");
          }
        }
        j += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public CharSequence d()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      int j = 0;
      while (j < this.d.size())
      {
        TranslateResult.Record localRecord = (TranslateResult.Record)this.d.get(j);
        if ((!TextUtils.isEmpty(localRecord.a)) && (!TextUtils.isEmpty(localRecord.b)))
        {
          ((StringBuilder)localObject).append(localRecord.b);
          ((StringBuilder)localObject).append("\n\n");
        }
        j += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CharSequence e()
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      Object localObject2 = new StringBuilder();
      localObject1 = new ArrayList();
      int j = 0;
      Object localObject3;
      while (j < this.d.size())
      {
        localObject3 = (TranslateResult.Record)this.d.get(j);
        if ((!TextUtils.isEmpty(((TranslateResult.Record)localObject3).a)) && (!TextUtils.isEmpty(((TranslateResult.Record)localObject3).b)))
        {
          ((StringBuilder)localObject2).append(((TranslateResult.Record)localObject3).a);
          ((StringBuilder)localObject2).append("\n");
          int k = ((StringBuilder)localObject2).length();
          ((StringBuilder)localObject2).append(((TranslateResult.Record)localObject3).b);
          ((List)localObject1).add(new Pair(Integer.valueOf(k), Integer.valueOf(((StringBuilder)localObject2).length())));
          ((StringBuilder)localObject2).append("\n");
          ((StringBuilder)localObject2).append("\n");
        }
        j += 1;
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
  
  public boolean f()
  {
    List localList = this.d;
    return (localList == null) || (localList.size() == 0);
  }
  
  public boolean g()
  {
    return this.h == 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TranslateResult{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", srcLang='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dstLang='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", records=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", imagePath='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uuid='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sLanguages=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", errCode=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", errMsg='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeTypedList(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeStringList(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.TranslateResult
 * JD-Core Version:    0.7.0.1
 */