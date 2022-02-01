package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import java.util.List;

public class FilterCategory
  implements Parcelable
{
  public static final Parcelable.Creator<FilterCategory> CREATOR = new FilterCategory.1();
  public int a;
  public String b;
  public List<FilterCategoryItem> c;
  
  protected FilterCategory(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.createTypedArrayList(FilterCategoryItem.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeTypedList(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.FilterCategory
 * JD-Core Version:    0.7.0.1
 */