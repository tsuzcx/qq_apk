package io.flutter.embedding.android;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import androidx.annotation.Keep;

@Keep
public class FlutterSplashView$SavedState
  extends View.BaseSavedState
{
  public static Parcelable.Creator<SavedState> CREATOR = new FlutterSplashView.SavedState.1();
  private String previousCompletedSplashIsolate;
  private Bundle splashScreenState;
  
  FlutterSplashView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.previousCompletedSplashIsolate = paramParcel.readString();
    this.splashScreenState = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  FlutterSplashView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.previousCompletedSplashIsolate);
    paramParcel.writeBundle(this.splashScreenState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView.SavedState
 * JD-Core Version:    0.7.0.1
 */