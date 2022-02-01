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
  public ArrayList<QMiniResult> b;
  public boolean c;
  public boolean d;
  
  public ScannerResult()
  {
    this.c = false;
    this.d = false;
  }
  
  protected ScannerResult(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.c = false;
    this.d = false;
    this.a = paramParcel.createTypedArrayList(QBarResult.CREATOR);
    this.b = paramParcel.createTypedArrayList(QMiniResult.CREATOR);
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.d = bool1;
  }
  
  public void a(SparseArray<Object> paramSparseArray)
  {
    Object localObject = b();
    if (localObject != null) {
      paramSparseArray.put(1, localObject);
    }
    localObject = c();
    String str = d();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSparseArray.put(2, localObject);
      paramSparseArray.put(1001, str);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, new Rect(), 0.0F, 0, 0, paramInt);
  }
  
  public void a(String paramString, Rect paramRect, float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QMiniResult localQMiniResult = new QMiniResult();
    localQMiniResult.b = paramString;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      float f2 = paramRect.left;
      float f1 = paramInt1;
      f2 = f2 * 1.0F / f1;
      float f3 = paramRect.top;
      float f4 = paramInt2;
      localQMiniResult.c = new RectF(f2, f3 * 1.0F / f4, paramRect.right * 1.0F / f1, paramRect.bottom * 1.0F / f4);
    }
    else
    {
      localQMiniResult.c = new RectF();
    }
    localQMiniResult.a = paramFloat;
    if (this.b == null) {
      this.b = new ArrayList();
    }
    if (paramInt3 == 3) {
      localQMiniResult.d = "wx";
    } else if (paramInt3 == 2) {
      localQMiniResult.d = "qq";
    }
    this.b.add(localQMiniResult);
  }
  
  public boolean a()
  {
    Object localObject1 = this.a;
    Object localObject2;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = this.a.iterator();
      j = 0;
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (QBarResult)((Iterator)localObject1).next();
        if ((((QBarResult)localObject2).d != null) && (!((QBarResult)localObject2).d.isEmpty())) {
          j += 1;
        }
      }
    }
    int i = 0;
    localObject1 = this.b;
    int j = i;
    if (localObject1 != null)
    {
      j = i;
      if (!((ArrayList)localObject1).isEmpty())
      {
        if (!this.c) {
          return false;
        }
        localObject1 = this.b.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (QMiniResult)((Iterator)localObject1).next();
          if ((((QMiniResult)localObject2).c != null) && (!((QMiniResult)localObject2).c.isEmpty())) {
            i += 1;
          }
        }
      }
    }
    return j > 1;
  }
  
  public Pair<StringBuilder, StringBuilder> b()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      ((StringBuilder)localObject).append(((QBarResult)this.a.get(0)).b);
      localStringBuilder.append(((QBarResult)this.a.get(0)).c);
      return new Pair(localStringBuilder, localObject);
    }
    return null;
  }
  
  public String c()
  {
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      return ((QMiniResult)this.b.get(0)).b;
    }
    return null;
  }
  
  public String d()
  {
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      return ((QMiniResult)this.b.get(0)).d;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    int i;
    if (h()) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (g()) {
      j = i | 0x2;
    }
    return j;
  }
  
  public boolean f()
  {
    return (g()) || (h());
  }
  
  public boolean g()
  {
    ArrayList localArrayList = this.b;
    return (localArrayList != null) && (!localArrayList.isEmpty());
  }
  
  public boolean h()
  {
    ArrayList localArrayList = this.a;
    return (localArrayList != null) && (!localArrayList.isEmpty());
  }
  
  public void i()
  {
    if (!f()) {
      return;
    }
    Object localObject = this.a;
    if ((localObject != null) && (((ArrayList)localObject).size() > 1))
    {
      localObject = (QBarResult)this.a.get(0);
      this.a.clear();
      this.a.add(localObject);
    }
    if ((h()) && (g())) {
      this.b.clear();
    }
    localObject = this.b;
    if ((localObject != null) && (((ArrayList)localObject).size() > 1))
    {
      localObject = (QMiniResult)this.b.get(0);
      this.b.clear();
      this.b.add(localObject);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScannerResult{hasQrCode:");
    localStringBuilder.append(h());
    localStringBuilder.append(" hasMiniCode:");
    localStringBuilder.append(g());
    localStringBuilder.append(" maybeMulti:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" hasMultiResult:");
    localStringBuilder.append(a());
    localStringBuilder.append(" qMiniUseAIDetect:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\nqBarResults=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\nqMiniResults=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.a);
    paramParcel.writeTypedList(this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeByte((byte)this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ScannerResult
 * JD-Core Version:    0.7.0.1
 */