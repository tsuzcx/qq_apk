package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TeamWorkMiniMsgUser
  extends MiniMsgUser
{
  int jdField_a_of_type_Int = -1;
  Activity jdField_a_of_type_AndroidAppActivity;
  MiniMsgUserParam jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam;
  String jdField_a_of_type_JavaLangString = "";
  String b = "";
  
  public TeamWorkMiniMsgUser(Activity paramActivity, MiniMsgUserParam paramMiniMsgUserParam, String paramString1, int paramInt, String paramString2)
  {
    super(paramActivity, paramMiniMsgUserParam);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam = paramMiniMsgUserParam;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramString2;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam;
    if (localObject != null)
    {
      if (((MiniMsgUserParam)localObject).actionCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUserParam.actionCallback.onOpenMiniAIOCallback();
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      int i = this.jdField_a_of_type_Int;
      if ((i != -1) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, i, (String)localObject, this.b);
        hideUnread();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void updateUnreadCountSync(int paramInt)
  {
    super.updateUnreadCountSync(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkMiniMsgUser
 * JD-Core Version:    0.7.0.1
 */