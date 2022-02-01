package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class FriendChooser$GridViewAdapter
  extends AgentBaseAdapter
{
  protected FriendChooser$GridViewAdapter(FriendChooser paramFriendChooser) {}
  
  public int getCount()
  {
    return this.a.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.b.size())) {
      return this.a.b.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Friend localFriend = (Friend)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      localObject = new FriendChooser.ViewHolder();
      paramView = this.a.getLayoutInflater().inflate(2131559402, null);
      ((FriendChooser.ViewHolder)localObject).a = ((ImageView)paramView.findViewById(2131366520));
      paramView.setTag(localObject);
    }
    while (localFriend == null)
    {
      QLog.e("qqBaseActivity", 1, new Object[] { "FriendChooser rr == nul pos=", Integer.valueOf(paramInt) });
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (FriendChooser.ViewHolder)paramView.getTag();
    }
    if ((localFriend.d == null) || ("".equals(localFriend.d))) {
      localFriend.d = QZonePortraitData.a(this.a.a(), localFriend.a);
    }
    Bitmap localBitmap = ImageLoader.a().a(localFriend.d);
    if (localBitmap == null)
    {
      ((FriendChooser.ViewHolder)localObject).a.setImageResource(2130840452);
      localObject = ((FriendChooser.ViewHolder)localObject).a;
      ImageLoader.a().a(localFriend.d, new FriendChooser.GridViewAdapter.1(this, (ImageView)localObject));
    }
    for (;;)
    {
      break;
      ((FriendChooser.ViewHolder)localObject).a.setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */