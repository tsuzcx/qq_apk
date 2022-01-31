package com.tencent.mobileqq.ocr.data;

import afpp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class OcrRecogResult
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new afpp();
  @unique
  public String filename;
  public String goodsDetailUrl;
  public String goodsName;
  public String goodsPicUrl;
  public float goodsPrice;
  public String moreUrl;
  public String ocrContent;
  public long saveTime;
  
  public OcrRecogResult() {}
  
  public OcrRecogResult(Parcel paramParcel)
  {
    this.filename = paramParcel.readString();
    this.saveTime = paramParcel.readLong();
    this.ocrContent = paramParcel.readString();
    this.goodsPicUrl = paramParcel.readString();
    this.goodsName = paramParcel.readString();
    this.goodsPrice = paramParcel.readFloat();
    this.goodsDetailUrl = paramParcel.readString();
    this.moreUrl = paramParcel.readString();
  }
  
  public static OcrRecogResult find(EntityManager paramEntityManager, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramEntityManager != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = (OcrRecogResult)paramEntityManager.a(OcrRecogResult.class, "filename=?", new String[] { String.valueOf(paramString) });
      }
    }
    return localObject1;
  }
  
  public static void persistOrReplace(EntityManager paramEntityManager, OcrRecogResult paramOcrRecogResult)
  {
    if ((paramEntityManager != null) && (paramOcrRecogResult != null) && (!TextUtils.isEmpty(paramOcrRecogResult.filename))) {
      paramEntityManager.b(paramOcrRecogResult);
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
          bool1 = paramEntityManager.b(paramString);
        }
      }
    }
    return bool1;
  }
  
  public static void removeCache(EntityManager paramEntityManager)
  {
    List localList = paramEntityManager.a(OcrRecogResult.class);
    if ((localList != null) && (localList.size() > 50))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramEntityManager.b((OcrRecogResult)localIterator.next());
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
    if (!TextUtils.isEmpty(this.ocrContent)) {}
    for (int i = 1;; i = 0)
    {
      if ((!TextUtils.isEmpty(this.goodsPicUrl)) && (!TextUtils.isEmpty(this.goodsName)) && (!TextUtils.isEmpty(this.goodsDetailUrl))) {}
      for (int j = 1;; j = 0) {
        return (j == 0) && (i == 0);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ocrContent = ").append(this.ocrContent).append("\n").append("goodsPicUrl = ").append(this.goodsPicUrl).append("\n").append("goodsName = ").append(this.goodsName).append("\n").append("goodsPrice = ").append(this.goodsPrice).append("\n").append("goodsDetailUrl = ").append(this.goodsDetailUrl).append("\n").append("filename = ").append(this.filename).append("\n").append("saveTime = ").append(this.saveTime).append("moreUrl = ").append(this.moreUrl);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.filename);
    paramParcel.writeLong(this.saveTime);
    paramParcel.writeString(this.ocrContent);
    paramParcel.writeString(this.goodsPicUrl);
    paramParcel.writeString(this.goodsName);
    paramParcel.writeFloat(this.goodsPrice);
    paramParcel.writeString(this.goodsDetailUrl);
    paramParcel.writeString(this.moreUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrRecogResult
 * JD-Core Version:    0.7.0.1
 */