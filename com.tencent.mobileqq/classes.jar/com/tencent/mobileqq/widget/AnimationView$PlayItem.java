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
    int i = 1;
    if (paramJSONObject == null) {
      return null;
    }
    int j = paramJSONObject.optInt("frame");
    if (j > 0) {
      return new PlayItem(j);
    }
    int k = paramJSONObject.optInt("from");
    int m = paramJSONObject.optInt("to");
    j = paramJSONObject.optInt("cycle", 1);
    if ((m > 0) && (k > 0) && (m > k)) {
      if (j >= 0) {
        break label84;
      }
    }
    for (;;)
    {
      return new PlayItem(k, m, i);
      return null;
      label84:
      i = j;
    }
  }
  
  public ArrayList<Integer> getFrames()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView.PlayItem
 * JD-Core Version:    0.7.0.1
 */