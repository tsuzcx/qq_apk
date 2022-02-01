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
    return this.a.B.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.B.size())) {
      return this.a.B.get(paramInt);
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
      paramView = this.a.getLayoutInflater().inflate(2131625198, null);
      ((FriendChooser.ViewHolder)localObject).c = ((ImageView)paramView.findViewById(2131432714));
      paramView.setTag(localObject);
    }
    else
    {
      localObject = (FriendChooser.ViewHolder)paramView.getTag();
    }
    if (localFriend == null)
    {
      QLog.e("qqBaseActivity", 1, new Object[] { "FriendChooser rr == nul pos=", Integer.valueOf(paramInt) });
    }
    else
    {
      if ((localFriend.d == null) || ("".equals(localFriend.d))) {
        localFriend.d = QZonePortraitData.a(this.a.i(), localFriend.a);
      }
      Bitmap localBitmap = ImageLoader.a().a(localFriend.d);
      if (localBitmap == null)
      {
        ((FriendChooser.ViewHolder)localObject).c.setImageResource(2130841060);
        localObject = ((FriendChooser.ViewHolder)localObject).c;
        ImageLoader.a().a(localFriend.d, new FriendChooser.GridViewAdapter.1(this, (ImageView)localObject));
      }
      else
      {
        ((FriendChooser.ViewHolder)localObject).c.setImageBitmap(localBitmap);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */