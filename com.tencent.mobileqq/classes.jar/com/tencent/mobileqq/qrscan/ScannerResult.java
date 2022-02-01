package com.tencent.mobileqq.qrscan;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;

public class ScannerResult
  implements Parcelable
{
  public static final Parcelable.Creator<ScannerResult> CREATOR = new ScannerResult.1();
  public ArrayList<QBarResult> a;
  public boolean a;
  public ArrayList<QMiniResult> b;
  public boolean b;
  
  public ScannerResult()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected ScannerResult(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(QBarResult.CREATOR);
    this.jdField_b_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(QMiniResult.CREATOR);
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.jdField_b_of_type_Boolean = bool1;
  }
  
  public int a()
  {
    int i;
    if (d()) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (c()) {
      j = i | 0x2;
    }
    return j;
  }
  
  public Pair<StringBuilder, StringBuilder> a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      ((StringBuilder)localObject).append(((QBarResult)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
      localStringBuilder.append(((QBarResult)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b);
      return new Pair(localStringBuilder, localObject);
    }
    return null;
  }
  
  public String a()
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      return ((QMiniResult)this.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    if (!b()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 1))
    {
      localObject = (QBarResult)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    if ((d()) && (c())) {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 1))
    {
      localObject = (QMiniResult)this.jdField_b_of_type_JavaUtilArrayList.get(0);
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
    }
  }
  
  public void a(SparseArray<Object> paramSparseArray)
  {
    Object localObject = a();
    if (localObject != null) {
      paramSparseArray.put(1, localObject);
    }
    localObject = a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramSparseArray.put(2, localObject);
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, new Rect(), 0.0F, 0, 0);
  }
  
  public void a(String paramString, Rect paramRect, float paramFloat, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QMiniResult localQMiniResult = new QMiniResult();
    localQMiniResult.jdField_a_of_type_JavaLangString = paramString;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      float f2 = paramRect.left;
      float f1 = paramInt1;
      f2 = f2 * 1.0F / f1;
      float f3 = paramRect.top;
      float f4 = paramInt2;
      localQMiniResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF(f2, f3 * 1.0F / f4, paramRect.right * 1.0F / f1, paramRect.bottom * 1.0F / f4);
    }
    else
    {
      localQMiniResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    }
    localQMiniResult.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(localQMiniResult);
  }
  
  public boolean a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    Object localObject2;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      j = 0;
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (QBarResult)((Iterator)localObject1).next();
        if ((((QBarResult)localObject2).jdField_a_of_type_AndroidGraphicsRectF != null) && (!((QBarResult)localObject2).jdField_a_of_type_AndroidGraphicsRectF.isEmpty())) {
          j += 1;
        }
      }
    }
    int i = 0;
    localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
    int j = i;
    if (localObject1 != null)
    {
      j = i;
      if (!((ArrayList)localObject1).isEmpty())
      {
        if (!this.jdField_a_of_type_Boolean) {
          return false;
        }
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (QMiniResult)((Iterator)localObject1).next();
          if ((((QMiniResult)localObject2).jdField_a_of_type_AndroidGraphicsRectF != null) && (!((QMiniResult)localObject2).jdField_a_of_type_AndroidGraphicsRectF.isEmpty())) {
            i += 1;
          }
        }
      }
    }
    return j > 1;
  }
  
  public boolean b()
  {
    return (c()) || (d());
  }
  
  public boolean c()
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (!localArrayList.isEmpty());
  }
  
  public boolean d()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (!localArrayList.isEmpty());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScannerResult{hasQrCode:");
    localStringBuilder.append(d());
    localStringBuilder.append(" hasMiniCode:");
    localStringBuilder.append(c());
    localStringBuilder.append(" maybeMulti:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" hasMultiResult:");
    localStringBuilder.append(a());
    localStringBuilder.append(" qMiniUseAIDetect:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\nqBarResults=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append("\nqMiniResults=");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeTypedList(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeByte((byte)this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ScannerResult
 * JD-Core Version:    0.7.0.1
 */