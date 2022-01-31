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
    if (paramJSONObject == null) {
      return null;
    }
    int i = paramJSONObject.optInt("frame");
    if (i > 0) {
      return new PlayItem(i);
    }
    int k = paramJSONObject.optInt("from");
    int m = paramJSONObject.optInt("to");
    int j = paramJSONObject.optInt("cycle");
    if ((m > 0) && (k > 0) && (m > k))
    {
      i = j;
      if (j < 0) {
        i = 1;
      }
      return new PlayItem(k, m, i);
    }
    return null;
  }
  
  public ArrayList getFrames()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mFrame > 0) {
      localArrayList.add(Integer.valueOf(this.mFrame));
    }
    for (;;)
    {
      return localArrayList;
      if ((this.mTo > 0) && (this.mFrom > 0) && (this.mTo > this.mFrom))
      {
        int i = this.mFrom;
        while (i < this.mTo + 1)
        {
          localArrayList.add(Integer.valueOf(i));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView.PlayItem
 * JD-Core Version:    0.7.0.1
 */