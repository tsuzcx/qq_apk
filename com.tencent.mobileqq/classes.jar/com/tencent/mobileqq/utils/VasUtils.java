package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public final class VasUtils
{
  private static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VasUtils";
    jdField_a_of_type_Int = 1000;
  }
  
  public static void a()
  {
    HiBoomFont.a().d();
    ETTextView.clearCache();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      HiBoomManager localHiBoomManager = (HiBoomManager)((QQAppInterface)localObject).getManager(QQManagerFactory.HIBOOM_MANAGER);
      if (localHiBoomManager != null) {
        localHiBoomManager.d();
      }
      localObject = (FontManager)((QQAppInterface)localObject).getManager(QQManagerFactory.CHAT_FONT_MANAGER);
      if (localObject != null) {
        ((FontManager)localObject).b();
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    ((BaseActivity)paramContext).runOnUiThread(new VasUtils.1(paramContext, paramString));
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    MqqHandler localMqqHandler = paramAppInterface.getHandler(ChatActivity.class);
    if (localMqqHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshAIO");
      }
      localMqqHandler.removeMessages(16711697);
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(16711697), jdField_a_of_type_Int);
    }
    localMqqHandler = paramAppInterface.getHandler(ChatHistoryBubbleListForTroopFragment.class);
    if (localMqqHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refresh troop history");
      }
      localMqqHandler.removeMessages(16711697);
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(16711697), jdField_a_of_type_Int);
    }
    paramAppInterface = paramAppInterface.getHandler(MiniChatActivity.class);
    if (paramAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refresh miniAIO");
      }
      paramAppInterface.removeMessages(8);
      paramAppInterface.sendMessageDelayed(paramAppInterface.obtainMessage(8), jdField_a_of_type_Int);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    if (paramQQAppInterface != null) {}
    for (BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);; localBubbleManager = null)
    {
      if ((paramXListView != null) && (localBubbleManager != null))
      {
        int i = paramXListView.getChildCount() - 1;
        while (i >= 0)
        {
          Object localObject = paramXListView.getChildAt(i);
          if ((localObject instanceof BaseChatItemLayout))
          {
            BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject);
            localObject = AIOUtils.a((View)localObject);
            if ((localObject != null) && (((ChatMessage)localObject).needVipBubble()) && (localViewHolder != null) && (localViewHolder.a != null) && (localViewHolder.a.jdField_a_of_type_Int == BubbleUtils.a.jdField_a_of_type_Int) && (localBubbleManager.a(SVIPHandler.a(((ChatMessage)localObject).vipBubbleID)))) {
              return true;
            }
            if ((localObject != null) && (((FontManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(localViewHolder, (ChatMessage)localObject))) {
              return true;
            }
          }
          else if ((localObject != null) && ((AIOUtils.a((View)localObject) instanceof RichStatItemBuilder.Holder)))
          {
            return true;
          }
          i -= 1;
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasUtils
 * JD-Core Version:    0.7.0.1
 */