package com.tencent.mobileqq.ocr.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import auck;
import auko;
import aukp;
import aumc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OcrRecogResult
  extends auko
  implements Parcelable
{
  public static final Parcelable.Creator<OcrRecogResult> CREATOR = new auck();
  @aumc
  public String filename;
  public String language;
  public String ocrContent;
  public ArrayList<String> ocr_languages;
  public long saveTime;
  
  public OcrRecogResult() {}
  
  public OcrRecogResult(Parcel paramParcel)
  {
    this.filename = paramParcel.readString();
    this.saveTime = paramParcel.readLong();
    this.ocrContent = paramParcel.readString();
    try
    {
      this.language = paramParcel.readString();
      this.ocr_languages = paramParcel.readArrayList(getClass().getClassLoader());
      return;
    }
    catch (Throwable paramParcel)
    {
      this.language = null;
      this.ocr_languages = null;
      QLog.e("OcrRecogResult", 1, "OcrRecogResult(Parcel in) e:" + paramParcel.getMessage());
    }
  }
  
  public static OcrRecogResult find(aukp paramaukp, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramaukp != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = (OcrRecogResult)paramaukp.a(OcrRecogResult.class, "filename=?", new String[] { String.valueOf(paramString) });
      }
    }
    return localObject1;
  }
  
  public static void persistOrReplace(aukp paramaukp, OcrRecogResult paramOcrRecogResult)
  {
    if ((paramaukp != null) && (paramOcrRecogResult != null) && (!TextUtils.isEmpty(paramOcrRecogResult.filename))) {
      paramaukp.b(paramOcrRecogResult);
    }
  }
  
  public static boolean remove(aukp paramaukp, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramaukp != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = find(paramaukp, paramString);
        bool1 = bool2;
        if (paramString != null) {
          bool1 = paramaukp.b(paramString);
        }
      }
    }
    return bool1;
  }
  
  public static void removeCache(aukp paramaukp)
  {
    List localList = paramaukp.a(OcrRecogResult.class);
    if ((localList != null) && (localList.size() > 50))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramaukp.b((OcrRecogResult)localIterator.next());
      }
      QLog.d("Q.ocr", 1, "removeCache size:" + localList.size());
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return TextUtils.isEmpty(this.ocrContent);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OcrRecogResult ocrContent = ").append(this.ocrContent).append("\n").append("language = ").append(this.language).append("\n").append("ocr_languages = ").append(this.ocr_languages).append("\n").append("filename = ").append(this.filename).append("\n").append("saveTime = ").append(this.saveTime);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.filename);
    paramParcel.writeLong(this.saveTime);
    paramParcel.writeString(this.ocrContent);
    try
    {
      paramParcel.writeString(this.language);
      paramParcel.writeList(this.ocr_languages);
      return;
    }
    catch (Throwable paramParcel)
    {
      QLog.e("OcrRecogResult", 1, "writeToParcel() e:" + paramParcel.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrRecogResult
 * JD-Core Version:    0.7.0.1
 */