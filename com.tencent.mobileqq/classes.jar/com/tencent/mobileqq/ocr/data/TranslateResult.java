package com.tencent.mobileqq.ocr.data;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import ayhq;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageRecord;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageTranslateRspResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TranslateResult
  implements Parcelable
{
  public static final Parcelable.Creator<TranslateResult> CREATOR = new ayhq();
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
  
  public TranslateResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilList = paramParcel.createTypedArrayList(TranslateResult.Record.CREATOR);
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_b_of_type_JavaUtilList = paramParcel.createStringArrayList();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.e = paramParcel.readString();
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {}
    while ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(paramString2))) {
      return true;
    }
    return false;
  }
  
  public CharSequence a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return "";
    }
    Object localObject1 = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (TranslateResult.Record)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((!TextUtils.isEmpty(((TranslateResult.Record)localObject2).jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(((TranslateResult.Record)localObject2).jdField_b_of_type_JavaLangString)))
      {
        ((StringBuilder)localObject1).append(((TranslateResult.Record)localObject2).jdField_b_of_type_JavaLangString);
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1) {
          ((StringBuilder)localObject1).append("\n\n");
        }
      }
      i += 1;
    }
    Object localObject2 = new ForegroundColorSpan(Color.parseColor("#12B7F5"));
    localObject1 = new SpannableString(((StringBuilder)localObject1).toString());
    ((SpannableString)localObject1).setSpan(localObject2, 0, ((SpannableString)localObject1).length(), 33);
    return localObject1;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      TranslateResult.Record localRecord = (TranslateResult.Record)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((!TextUtils.isEmpty(localRecord.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localRecord.jdField_b_of_type_JavaLangString))) {
        localStringBuilder.append(localRecord.jdField_a_of_type_JavaLangString).append("\n").append(localRecord.jdField_b_of_type_JavaLangString).append("\n").append("\n");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a(ARCloudRecogCustomPb.ImageTranslateRspResult paramImageTranslateRspResult)
  {
    if (paramImageTranslateRspResult == null) {}
    for (;;)
    {
      return;
      if (paramImageTranslateRspResult.image_translate_err_code.has()) {
        this.jdField_b_of_type_Int = paramImageTranslateRspResult.image_translate_err_code.get();
      }
      if (paramImageTranslateRspResult.image_translate_err_msg.has()) {
        this.e = paramImageTranslateRspResult.image_translate_err_msg.get().toStringUtf8();
      }
      if (paramImageTranslateRspResult.session_uuid.has()) {
        this.d = paramImageTranslateRspResult.session_uuid.get().toStringUtf8();
      }
      if (paramImageTranslateRspResult.source_lange.has()) {
        this.jdField_a_of_type_JavaLangString = paramImageTranslateRspResult.source_lange.get().toStringUtf8();
      }
      if (paramImageTranslateRspResult.target_lang.has()) {
        this.jdField_b_of_type_JavaLangString = paramImageTranslateRspResult.target_lang.get().toStringUtf8();
      }
      Object localObject;
      if (paramImageTranslateRspResult.msg_image_record_list.has())
      {
        localObject = paramImageTranslateRspResult.msg_image_record_list.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ARCloudRecogCustomPb.ImageRecord localImageRecord = (ARCloudRecogCustomPb.ImageRecord)((Iterator)localObject).next();
            TranslateResult.Record localRecord = new TranslateResult.Record();
            localRecord.jdField_a_of_type_JavaLangString = localImageRecord.source_text.get().toStringUtf8();
            localRecord.jdField_b_of_type_JavaLangString = localImageRecord.target_text.get().toStringUtf8();
            localRecord.jdField_a_of_type_Int = localImageRecord.coordinate_x.get();
            localRecord.jdField_b_of_type_Int = localImageRecord.coordinate_y.get();
            localRecord.jdField_c_of_type_Int = localImageRecord.width.get();
            localRecord.d = localImageRecord.height.get();
            localRecord.jdField_c_of_type_JavaLangString = localImageRecord.angle.get().toStringUtf8();
            this.jdField_a_of_type_JavaUtilList.add(localRecord);
          }
        }
      }
      if (paramImageTranslateRspResult.support_translate_lang.has())
      {
        paramImageTranslateRspResult = paramImageTranslateRspResult.support_translate_lang.get();
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
        if (paramImageTranslateRspResult != null)
        {
          paramImageTranslateRspResult = paramImageTranslateRspResult.iterator();
          while (paramImageTranslateRspResult.hasNext())
          {
            localObject = (ByteStringMicro)paramImageTranslateRspResult.next();
            this.jdField_b_of_type_JavaUtilList.add(((ByteStringMicro)localObject).toStringUtf8());
          }
        }
      }
    }
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
    if ((paramList1 == null) || (paramList2 == null)) {}
    for (;;)
    {
      return;
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
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString)) && (this.jdField_c_of_type_JavaLangString.equals(paramString));
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_Int == 2) {}
    while ((a(paramString2, this.jdField_a_of_type_JavaLangString)) && (a(paramString3, this.jdField_b_of_type_JavaLangString)) && (b(paramString1))) {
      return false;
    }
    return true;
  }
  
  public CharSequence b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return "";
    }
    Object localObject2 = new StringBuilder();
    Object localObject1 = new ArrayList();
    int i = 0;
    Object localObject3;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject3 = (TranslateResult.Record)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((!TextUtils.isEmpty(((TranslateResult.Record)localObject3).jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(((TranslateResult.Record)localObject3).jdField_b_of_type_JavaLangString)))
      {
        ((StringBuilder)localObject2).append(((TranslateResult.Record)localObject3).jdField_a_of_type_JavaLangString).append("\n");
        int j = ((StringBuilder)localObject2).length();
        ((StringBuilder)localObject2).append(((TranslateResult.Record)localObject3).jdField_b_of_type_JavaLangString);
        ((List)localObject1).add(new Pair(Integer.valueOf(j), Integer.valueOf(((StringBuilder)localObject2).length())));
        ((StringBuilder)localObject2).append("\n").append("\n");
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
  
  public String b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      TranslateResult.Record localRecord = (TranslateResult.Record)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!TextUtils.isEmpty(localRecord.jdField_b_of_type_JavaLangString))
      {
        localStringBuilder.append(localRecord.jdField_b_of_type_JavaLangString);
        if (i + 1 != this.jdField_a_of_type_JavaUtilList.size()) {
          localStringBuilder.append("\n");
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 0;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!TextUtils.isEmpty(paramString.trim())) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      String str;
      do
      {
        do
        {
          return bool1;
          str = c();
          bool1 = bool2;
        } while (TextUtils.isEmpty(str));
        bool1 = bool2;
      } while (TextUtils.isEmpty(str.trim()));
      bool2 = paramString.trim().replace("\n", "").equals(str.trim().replace("\n", ""));
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("TranslateResult", 2, "isSame: " + bool2);
    return bool2;
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      TranslateResult.Record localRecord = (TranslateResult.Record)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((!TextUtils.isEmpty(localRecord.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localRecord.jdField_b_of_type_JavaLangString)))
      {
        localStringBuilder.append(localRecord.jdField_a_of_type_JavaLangString);
        if (i < this.jdField_a_of_type_JavaUtilList.size() - 1) {
          localStringBuilder.append("\n\n");
        }
      }
      i += 1;
    }
    return localStringBuilder.toString().trim();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "TranslateResult{type=" + this.jdField_a_of_type_Int + ", srcLang='" + this.jdField_a_of_type_JavaLangString + '\'' + ", dstLang='" + this.jdField_b_of_type_JavaLangString + '\'' + ", records=" + this.jdField_a_of_type_JavaUtilList + ", imagePath='" + this.jdField_c_of_type_JavaLangString + '\'' + ", uuid='" + this.d + '\'' + ", sLanguages=" + this.jdField_b_of_type_JavaUtilList + ", errCode=" + this.jdField_b_of_type_Int + ", errMsg='" + this.e + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeStringList(this.jdField_b_of_type_JavaUtilList);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.TranslateResult
 * JD-Core Version:    0.7.0.1
 */