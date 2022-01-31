package com.tencent.open.agent;

import akmi;
import akmj;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import java.util.List;

public class FriendChooser$SearchResultAdapter
  extends AgentBaseAdapter
{
  protected List a;
  
  public FriendChooser$SearchResultAdapter(FriendChooser paramFriendChooser, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getLayoutInflater().inflate(2130971516, paramViewGroup, false);
      paramViewGroup = new akmj();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364316));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363531));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131363532));
      paramView.setTag(paramViewGroup);
    }
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      return paramView;
      paramViewGroup = (akmj)paramView.getTag();
    }
    Friend localFriend = (Friend)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if ((localFriend.c == null) || ("".equals(localFriend.c)))
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFriend.b);
      if ((localFriend.d == null) || ("".equals(localFriend.d))) {
        localFriend.d = QZonePortraitData.a(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(), localFriend.a);
      }
      localObject = ImageLoader.a().a(localFriend.d);
      if (localObject != null) {
        break label290;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839128);
      localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      ImageLoader.a().a(localFriend.d, new akmi(this, (ImageView)localObject));
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a.a(localFriend.a)) {
        break label302;
      }
      paramViewGroup.b.setText(2131433992);
      return paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFriend.c);
      break;
      label290:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
    label302:
    paramViewGroup.b.setText("");
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */