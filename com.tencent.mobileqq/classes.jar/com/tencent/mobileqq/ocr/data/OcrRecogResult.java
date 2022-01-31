package com.tencent.mobileqq.ocr.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import avxx;
import awge;
import awgf;
import awhs;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OcrRecogResult
  extends awge
  implements Parcelable
{
  public static final Parcelable.Creator<OcrRecogResult> CREATOR = new avxx();
  @awhs
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
  
  public static OcrRecogResult find(awgf paramawgf, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramawgf != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = (OcrRecogResult)paramawgf.a(OcrRecogResult.class, "filename=?", new String[] { String.valueOf(paramString) });
      }
    }
    return localObject1;
  }
  
  public static void persistOrReplace(awgf paramawgf, OcrRecogResult paramOcrRecogResult)
  {
    if ((paramawgf != null) && (paramOcrRecogResult != null) && (!TextUtils.isEmpty(paramOcrRecogResult.filename))) {
      paramawgf.b(paramOcrRecogResult);
    }
  }
  
  public static boolean remove(awgf paramawgf, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramawgf != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = find(paramawgf, paramString);
        bool1 = bool2;
        if (paramString != null) {
          bool1 = paramawgf.b(paramString);
        }
      }
    }
    return bool1;
  }
  
  public static void removeCache(awgf paramawgf)
  {
    List localList = paramawgf.a(OcrRecogResult.class);
    if ((localList != null) && (localList.size() > 50))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramawgf.b((OcrRecogResult)localIterator.next());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrRecogResult
 * JD-Core Version:    0.7.0.1
 */