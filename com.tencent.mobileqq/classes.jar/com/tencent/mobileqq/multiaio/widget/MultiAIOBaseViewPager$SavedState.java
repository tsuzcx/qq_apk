package com.tencent.mobileqq.multiaio.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.AbsSavedState;

public class MultiAIOBaseViewPager$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new MultiAIOBaseViewPager.SavedState.1();
  int a;
  Parcelable b;
  ClassLoader c;
  
  MultiAIOBaseViewPager$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel);
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = getClass().getClassLoader();
    }
    this.a = paramParcel.readInt();
    this.b = paramParcel.readParcelable(localClassLoader);
    this.c = localClassLoader;
  }
  
  public MultiAIOBaseViewPager$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FragmentPager.SavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" position=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.SavedState
 * JD-Core Version:    0.7.0.1
 */