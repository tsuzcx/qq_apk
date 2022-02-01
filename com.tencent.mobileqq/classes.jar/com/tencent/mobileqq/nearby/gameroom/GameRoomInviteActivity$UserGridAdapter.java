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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class GameRoomInviteActivity$UserGridAdapter
  extends BaseAdapter
{
  private GameRoomInviteActivity$UserGridAdapter(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.a.jdField_a_of_type_JavaUtilList.size()) {
      return Math.min(i, this.a.jdField_a_of_type_Int);
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      return (GameRoomInviteActivity.GameRoomUser)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GameRoomInviteActivity.ViewHolder localViewHolder;
    String str;
    FaceDrawable localFaceDrawable;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131559609, paramViewGroup, false);
      localViewHolder = new GameRoomInviteActivity.ViewHolder(this.a, null);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367742));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367743));
      localViewHolder.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131367741));
      localViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368363);
      paramView.setTag(localViewHolder);
      WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
      GameRoomInviteActivity.GameRoomUser localGameRoomUser = (GameRoomInviteActivity.GameRoomUser)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      str = localGameRoomUser.jdField_a_of_type_JavaLangString;
      if ((!((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((GameRoomInviteActivity.GameRoomUser)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
        break label343;
      }
      localFaceDrawable = FaceDrawable.getFaceDrawable(this.a.app, 1, str);
      label209:
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      localWerewolvesHandler.a(localViewHolder.jdField_a_of_type_AndroidWidgetTextView, str, "%s");
      if (!localGameRoomUser.jdField_a_of_type_Boolean) {
        break label364;
      }
      localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label250:
      if ((!this.a.jdField_a_of_type_Boolean) || (localGameRoomUser.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))) {
        break label376;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new GameRoomInviteActivity.UserGridAdapter.1(this, paramInt, localWerewolvesHandler));
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_Int = 1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localViewHolder = (GameRoomInviteActivity.ViewHolder)paramView.getTag();
      break;
      label343:
      localFaceDrawable = FaceDrawable.getStrangerFaceDrawable(this.a.app, 200, str, 3);
      break label209;
      label364:
      localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(4);
      break label250;
      label376:
      localViewHolder.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.UserGridAdapter
 * JD-Core Version:    0.7.0.1
 */