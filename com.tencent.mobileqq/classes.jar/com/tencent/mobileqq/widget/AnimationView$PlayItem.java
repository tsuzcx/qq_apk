package com.tencent.mobileqq.widget;

import java.util.ArrayList;
import org.json.JSONObject;

public class AnimationView$PlayItem
{
  public int mCycle;
  public int mFrame;
  public int mFrom;
  public int mTo;
  
  public AnimationView$PlayItem(int paramInt)
  {
    this.mFrame = paramInt;
  }
  
  public AnimationView$PlayItem(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mFrom = paramInt1;
    this.mTo = paramInt2;
    this.mCycle = paramInt3;
  }
  
  protected static PlayItem a(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject == null) {
      return null;
    }
    int i = paramJSONObject.optInt("frame");
    if (i > 0) {
      return new PlayItem(i);
    }
    int k = paramJSONObject.optInt("from");
    int m = paramJSONObject.optInt("to");
    int j = paramJSONObject.optInt("cycle", 1);
    paramJSONObject = localObject;
    if (m > 0)
    {
      paramJSONObject = localObject;
      if (k > 0)
      {
        paramJSONObject = localObject;
        if (m > k)
        {
          i = j;
          if (j < 0) {
            i = 1;
          }
          paramJSONObject = new PlayItem(k, m, i);
        }
      }
    }
    return paramJSONObject;
  }
  
  public ArrayList<Integer> getFrames()
  {
    ArrayList localArrayList = new ArrayList();
    int i = this.mFrame;
    if (i > 0)
    {
      localArrayList.add(Integer.valueOf(i));
      return localArrayList;
    }
    int j = this.mTo;
    if (j > 0)
    {
      i = this.mFrom;
      if ((i > 0) && (j > i)) {
        while (i < this.mTo + 1)
        {
          localArrayList.add(Integer.valueOf(i));
          i += 1;
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView.PlayItem
 * JD-Core Version:    0.7.0.1
 */