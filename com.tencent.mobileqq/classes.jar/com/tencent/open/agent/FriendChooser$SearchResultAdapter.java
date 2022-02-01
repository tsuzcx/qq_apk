package com.tencent.open.agent;

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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class FriendChooser$SearchResultAdapter
  extends AgentBaseAdapter
{
  protected List<Friend> a;
  
  public FriendChooser$SearchResultAdapter(List<Friend> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
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
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getLayoutInflater().inflate(2131562824, paramViewGroup, false);
      paramView = new FriendChooser.ViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369373));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379778));
      paramView.b = ((TextView)localView.findViewById(2131379889));
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (FriendChooser.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = (Friend)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((((Friend)localObject1).c != null) && (!"".equals(((Friend)localObject1).c))) {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Friend)localObject1).c);
      } else {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Friend)localObject1).b);
      }
      if ((((Friend)localObject1).d == null) || ("".equals(((Friend)localObject1).d))) {
        ((Friend)localObject1).d = QZonePortraitData.a(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(), ((Friend)localObject1).a);
      }
      Object localObject2 = ImageLoader.a().a(((Friend)localObject1).d);
      if (localObject2 == null)
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840321);
        localObject2 = paramView.jdField_a_of_type_AndroidWidgetImageView;
        ImageLoader.a().a(((Friend)localObject1).d, new FriendChooser.SearchResultAdapter.1(this, (ImageView)localObject2));
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      }
      if (this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a.a(((Friend)localObject1).a)) {
        paramView.b.setText(2131691771);
      } else {
        paramView.b.setText("");
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */