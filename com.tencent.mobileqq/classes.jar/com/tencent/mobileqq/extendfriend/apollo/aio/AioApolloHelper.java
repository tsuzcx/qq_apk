package com.tencent.mobileqq.extendfriend.apollo.aio;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader;
import com.tencent.widget.ListView;
import java.util.Collection;

public class AioApolloHelper
{
  private static String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend()) {
      return paramChatMessage.selfuin;
    }
    return paramChatMessage.senderuin;
  }
  
  public static void a(BaseChatItemLayout paramBaseChatItemLayout, View paramView)
  {
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ViewUtils.a(12.0F);
    paramBaseChatItemLayout.setPadding(BaseChatItemLayout.t, 0, BaseChatItemLayout.u, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo) {}
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    a(paramQQAppInterface, paramContext, Util.b(paramQQAppInterface, a(paramChatMessage)), paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ListView paramListView, Collection<String> paramCollection)
  {
    if (paramListView == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        Object localObject = paramListView.getChildAt(i);
        if ((localObject != null) && ((localObject instanceof BaseChatItemLayout)))
        {
          localObject = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject);
          if ((localObject != null) && (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin != null) && (paramCollection.contains(((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin))) {
            a(paramQQAppInterface, paramContext, Util.b(paramQQAppInterface, a(((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage)), ((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramSessionInfo);
          }
        }
        i += 1;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, Object paramObject, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo)
  {
    int i = AIOUtils.a(5.0F, paramBaseChatItemLayout.getContext().getResources());
    if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = new ApolloVasAvatar(paramBaseChatItemLayout.getContext());
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setId(2131364643);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setScaleType(ImageView.ScaleType.FIT_XY);
      paramQQAppInterface = new RelativeLayout.LayoutParams(ViewUtils.a(45.0F), ViewUtils.a(60.0F));
      paramQQAppInterface.topMargin = 0;
      paramQQAppInterface.addRule(3, 2131364642);
      if (paramBaseChatItemLayout.b() == 1)
      {
        paramQQAppInterface.addRule(11);
        paramQQAppInterface.addRule(9, 0);
        paramQQAppInterface.rightMargin = i;
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(3, paramBaseChatItemLayout.a());
        paramBaseChatItemLayout.addView(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, paramQQAppInterface);
        label135:
        if (!(paramObject instanceof Drawable)) {
          break label367;
        }
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setImageDrawable((Drawable)paramObject);
      }
    }
    for (;;)
    {
      if (paramBaseChatItemLayout.b != null) {
        paramBaseChatItemLayout.b.setVisibility(8);
      }
      return;
      paramQQAppInterface.addRule(9);
      paramQQAppInterface.addRule(11, 0);
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
      for (paramQQAppInterface.leftMargin = AIOUtils.a(30.0F, paramBaseChatItemLayout.getContext().getResources());; paramQQAppInterface.leftMargin = i)
      {
        paramQQAppInterface.rightMargin = 0;
        break;
      }
      paramQQAppInterface = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      paramQQAppInterface.topMargin = 0;
      paramQQAppInterface.addRule(3, 2131364642);
      if (paramBaseChatItemLayout.b() == 1)
      {
        paramQQAppInterface.addRule(11);
        paramQQAppInterface.addRule(9, 0);
        paramQQAppInterface.rightMargin = i;
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(3, paramBaseChatItemLayout.a());
        break label135;
      }
      paramQQAppInterface.addRule(9);
      paramQQAppInterface.addRule(11, 0);
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
      for (paramQQAppInterface.leftMargin = AIOUtils.a(30.0F, paramBaseChatItemLayout.getContext().getResources());; paramQQAppInterface.leftMargin = i)
      {
        paramQQAppInterface.rightMargin = 0;
        break;
      }
      label367:
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLoader(null, (VasAvatarLoader)paramObject);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, UniteGrayTipParam paramUniteGrayTipParam)
  {
    if (paramUniteGrayTipParam.b == 459817)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B445", "0X800B445", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B446", "0X800B446", 2, 0, "", "", "", "");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper
 * JD-Core Version:    0.7.0.1
 */