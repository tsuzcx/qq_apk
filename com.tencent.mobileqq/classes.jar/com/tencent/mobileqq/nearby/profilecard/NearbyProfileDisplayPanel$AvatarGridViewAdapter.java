package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.picbrowser.PicInfo;
import java.util.ArrayList;
import java.util.List;

public class NearbyProfileDisplayPanel$AvatarGridViewAdapter
  extends BaseAdapter
{
  private List<PicInfo> b = new ArrayList();
  
  public NearbyProfileDisplayPanel$AvatarGridViewAdapter(List<PicInfo> paramList, int paramInt)
  {
    int j = i * 6;
    int i = j;
    while ((i < paramInt.size()) && (i < j + 6))
    {
      this.b.add(paramInt.get(i));
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.a.a(paramInt, (PicInfo)this.b.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.AvatarGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */