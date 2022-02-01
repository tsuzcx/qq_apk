package com.tencent.mobileqq.nearby.gameroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import java.util.List;

class GameRoomInviteActivity$UserGridAdapter
  extends BaseAdapter
{
  private GameRoomInviteActivity$UserGridAdapter(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public int getCount()
  {
    int i;
    if (this.a.mUsers == null) {
      i = 0;
    } else {
      i = this.a.mUsers.size();
    }
    return Math.min(i, this.a.mRoomNum);
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a.mUsers != null) {
      return this.a.mUsers.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131625506, paramViewGroup, false);
      paramViewGroup = new GameRoomInviteActivity.ViewHolder(this.a, null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131434019));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131434020));
      paramViewGroup.c = ((ImageButton)paramView.findViewById(2131434018));
      paramViewGroup.d = paramView.findViewById(2131434968);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (GameRoomInviteActivity.ViewHolder)paramView.getTag();
    }
    WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
    GameRoomInviteActivity.GameRoomUser localGameRoomUser = (GameRoomInviteActivity.GameRoomUser)this.a.mUsers.get(paramInt);
    String str = localGameRoomUser.a;
    FaceDrawable localFaceDrawable;
    if ((!((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(((GameRoomInviteActivity.GameRoomUser)this.a.mUsers.get(paramInt)).a)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
      localFaceDrawable = FaceDrawable.getStrangerFaceDrawable(this.a.app, 200, str, 3);
    } else {
      localFaceDrawable = FaceDrawable.getFaceDrawable(this.a.app, 1, str);
    }
    paramViewGroup.a.setImageDrawable(localFaceDrawable);
    localWerewolvesHandler.a(paramViewGroup.b, str, "%s");
    if (localGameRoomUser.b) {
      paramViewGroup.d.setVisibility(0);
    } else {
      paramViewGroup.d.setVisibility(4);
    }
    if ((this.a.mIsOwner) && (!localGameRoomUser.a.equals(this.a.app.getCurrentAccountUin())))
    {
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setOnClickListener(new GameRoomInviteActivity.UserGridAdapter.1(this, paramInt, localWerewolvesHandler));
    }
    else
    {
      paramViewGroup.c.setVisibility(8);
    }
    paramViewGroup.e = 1;
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.UserGridAdapter
 * JD-Core Version:    0.7.0.1
 */