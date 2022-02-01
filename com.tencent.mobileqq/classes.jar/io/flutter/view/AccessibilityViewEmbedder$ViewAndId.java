package io.flutter.view;

import android.view.View;

class AccessibilityViewEmbedder$ViewAndId
{
  final int id;
  final View view;
  
  private AccessibilityViewEmbedder$ViewAndId(View paramView, int paramInt)
  {
    this.view = paramView;
    this.id = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ViewAndId)) {
      return false;
    }
    paramObject = (ViewAndId)paramObject;
    return (this.id == paramObject.id) && (this.view.equals(paramObject.view));
  }
  
  public int hashCode()
  {
    return (this.view.hashCode() + 31) * 31 + this.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.view.AccessibilityViewEmbedder.ViewAndId
 * JD-Core Version:    0.7.0.1
 */