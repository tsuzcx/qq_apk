package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.kg;
import com.tencent.map.sdk.a.kt;
import java.util.List;

public class BubbleGroup
{
  public static final int INVALID_BUBBLE_ID = -1;
  private kg a;
  
  public BubbleGroup(kg paramkg)
  {
    this.a = paramkg;
  }
  
  public int addBubble(BubbleOptions paramBubbleOptions)
  {
    kg localkg = this.a;
    if (localkg == null) {
      return -1;
    }
    if (localkg.a == null) {
      return -1;
    }
    return localkg.a.a(paramBubbleOptions, localkg);
  }
  
  public void clearBubbleGroup()
  {
    kg localkg = this.a;
    if (localkg == null) {
      return;
    }
    localkg.a();
  }
  
  public boolean containsBubble(int paramInt)
  {
    kg localkg = this.a;
    if (localkg == null) {
      return false;
    }
    if (localkg.a == null) {
      return false;
    }
    return localkg.a.b(paramInt);
  }
  
  public List<Integer> getBubbleIds()
  {
    kg localkg = this.a;
    if (localkg == null) {
      return null;
    }
    if (localkg.a == null) {
      return null;
    }
    return localkg.a.b();
  }
  
  public boolean remove(int paramInt)
  {
    kg localkg = this.a;
    if (localkg == null) {
      return false;
    }
    if (localkg.a == null) {
      return false;
    }
    return localkg.a.a(paramInt);
  }
  
  public boolean updateBubble(int paramInt, BubbleOptions paramBubbleOptions)
  {
    kg localkg = this.a;
    if (localkg != null)
    {
      if (paramBubbleOptions == null) {
        return false;
      }
      if (localkg.a != null)
      {
        if (paramBubbleOptions == null) {
          return false;
        }
        return localkg.a.a(paramInt, paramBubbleOptions);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BubbleGroup
 * JD-Core Version:    0.7.0.1
 */