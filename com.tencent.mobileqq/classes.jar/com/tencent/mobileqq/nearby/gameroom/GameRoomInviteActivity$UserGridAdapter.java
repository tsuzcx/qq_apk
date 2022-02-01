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
      return (GameRoomInviteActivity.GameRoomUser)this.a.mUsers.get(paramInt);
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
      paramView = LayoutInflater.from(this.a).inflate(2131559486, paramViewGroup, false);
      paramViewGroup = new GameRoomInviteActivity.ViewHolder(this.a, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367501));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367502));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131367500));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368114);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (GameRoomInviteActivity.ViewHolder)paramView.getTag();
    }
    WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
    GameRoomInviteActivity.GameRoomUser localGameRoomUser = (GameRoomInviteActivity.GameRoomUser)this.a.mUsers.get(paramInt);
    String str = localGameRoomUser.jdField_a_of_type_JavaLangString;
    FaceDrawable localFaceDrawable;
    if ((!((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((GameRoomInviteActivity.GameRoomUser)this.a.mUsers.get(paramInt)).jdField_a_of_type_JavaLangString)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
      localFaceDrawable = FaceDrawable.getStrangerFaceDrawable(this.a.app, 200, str, 3);
    } else {
      localFaceDrawable = FaceDrawable.getFaceDrawable(this.a.app, 1, str);
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
    localWerewolvesHandler.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, str, "%s");
    if (localGameRoomUser.jdField_a_of_type_Boolean) {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
    } else {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
    if ((this.a.mIsOwner) && (!localGameRoomUser.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())))
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new GameRoomInviteActivity.UserGridAdapter.1(this, paramInt, localWerewolvesHandler));
    }
    else
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    paramViewGroup.jdField_a_of_type_Int = 1;
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.UserGridAdapter
 * JD-Core Version:    0.7.0.1
 */