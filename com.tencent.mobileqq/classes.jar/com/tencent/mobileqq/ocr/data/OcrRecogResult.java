package com.tencent.mobileqq.ocr.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
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
  public static final Parcelable.Creator<OcrRecogResult> CREATOR = new OcrRecogResult.1();
  @unique
  public String filename;
  public String language;
  public String ocrContent;
  public ArrayList<String> ocr_languages;
  public long saveTime;
  
  public OcrRecogResult() {}
  
  protected OcrRecogResult(Parcel paramParcel)
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OcrRecogResult(Parcel in) e:");
      localStringBuilder.append(paramParcel.getMessage());
      QLog.e("OcrRecogResult", 1, localStringBuilder.toString());
    }
  }
  
  public static OcrRecogResult find(EntityManager paramEntityManager, String paramString)
  {
    if ((paramEntityManager != null) && (!TextUtils.isEmpty(paramString))) {
      return (OcrRecogResult)paramEntityManager.find(OcrRecogResult.class, "filename=?", new String[] { String.valueOf(paramString) });
    }
    return null;
  }
  
  public static void persistOrReplace(EntityManager paramEntityManager, OcrRecogResult paramOcrRecogResult)
  {
    if ((paramEntityManager != null) && (paramOcrRecogResult != null) && (!TextUtils.isEmpty(paramOcrRecogResult.filename))) {
      paramEntityManager.persistOrReplace(paramOcrRecogResult);
    }
  }
  
  public static boolean remove(EntityManager paramEntityManager, String paramString)
  {
    if ((paramEntityManager != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = find(paramEntityManager, paramString);
      if (paramString != null) {
        return paramEntityManager.remove(paramString);
      }
    }
    return false;
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
      paramEntityManager = new StringBuilder();
      paramEntityManager.append("removeCache size:");
      paramEntityManager.append(localList.size());
      QLog.d("Q.ocr", 1, paramEntityManager.toString());
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
    localStringBuilder.append("OcrRecogResult ocrContent = ");
    localStringBuilder.append(this.ocrContent);
    localStringBuilder.append("\n");
    localStringBuilder.append("language = ");
    localStringBuilder.append(this.language);
    localStringBuilder.append("\n");
    localStringBuilder.append("ocr_languages = ");
    localStringBuilder.append(this.ocr_languages);
    localStringBuilder.append("\n");
    localStringBuilder.append("filename = ");
    localStringBuilder.append(this.filename);
    localStringBuilder.append("\n");
    localStringBuilder.append("saveTime = ");
    localStringBuilder.append(this.saveTime);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("writeToParcel() e:");
      localStringBuilder.append(paramParcel.getMessage());
      QLog.e("OcrRecogResult", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrRecogResult
 * JD-Core Version:    0.7.0.1
 */