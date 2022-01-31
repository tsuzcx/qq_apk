package dov.com.qq.im.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import blst;

public class QIMBeautyItem
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<QIMBeautyItem> CREATOR = new blst();
  public String a;
  public String b;
  public String c;
  public String d;
  
  public QIMBeautyItem() {}
  
  public QIMBeautyItem(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public QIMFilterCategoryItem a()
  {
    try
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)super.clone();
      return localQIMFilterCategoryItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.d))
    {
      bool1 = bool2;
      if (this.d.startsWith("qim")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (paramObject.hashCode() != hashCode()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.a.intern().hashCode();
  }
  
  public String toString()
  {
    return "FilterCategoryItem{id='" + this.a + '\'' + ", name='" + this.b + '\'' + ", jumpApp=" + this.d + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.data.QIMBeautyItem
 * JD-Core Version:    0.7.0.1
 */