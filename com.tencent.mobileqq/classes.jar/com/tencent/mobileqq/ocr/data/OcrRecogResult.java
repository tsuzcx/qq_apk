package com.tencent.mobileqq.ocr.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import axnq;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OcrRecogResult
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<OcrRecogResult> CREATOR = new axnq();
  @unique
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
  
  public static OcrRecogResult find(EntityManager paramEntityManager, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEntityManager != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = (OcrRecogResult)paramEntityManager.find(OcrRecogResult.class, "filename=?", new String[] { String.valueOf(paramString) });
      }
    }
    return localObject1;
  }
  
  public static void persistOrReplace(EntityManager paramEntityManager, OcrRecogResult paramOcrRecogResult)
  {
    if ((paramEntityManager != null) && (paramOcrRecogResult != null) && (!TextUtils.isEmpty(paramOcrRecogResult.filename))) {
      paramEntityManager.persistOrReplace(paramOcrRecogResult);
    }
  }
  
  public static boolean remove(EntityManager paramEntityManager, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEntityManager != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = find(paramEntityManager, paramString);
        bool1 = bool2;
        if (paramString != null) {
          bool1 = paramEntityManager.remove(paramString);
        }
      }
    }
    return bool1;
  }
  
  public static void removeCache(EntityManager paramEntityManager)
  {
    List localList = paramEntityManager.query(OcrRecogResult.class);
    if ((localList != null) && (localList.size() > 50))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramEntityManager.remove((OcrRecogResult)localIterator.next());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrRecogResult
 * JD-Core Version:    0.7.0.1
 */