package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import java.util.ArrayList;
import java.util.List;

public class NearbyProfileDisplayPanel$AvatarGridViewAdapter
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public NearbyProfileDisplayPanel$AvatarGridViewAdapter(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, List paramList, int paramInt)
  {
    int i = paramInt * 6;
    paramInt = i;
    while ((paramInt < paramList.size()) && (paramInt < i + 6))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramList.get(paramInt));
      paramInt += 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a(paramInt, (PicInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.AvatarGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */