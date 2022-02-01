package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
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
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public final class VasUtils
{
  public static String a = "VasUtils";
  private static int b = 1000;
  
  public static void a()
  {
    HiBoomFont.a().e();
    ETTextView.clearCache();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      IHiBoomManager localIHiBoomManager = ((IVasService)((QQAppInterface)localObject).getRuntimeService(IVasService.class, "")).getHiBoomManager();
      if (localIHiBoomManager != null) {
        localIHiBoomManager.onAIODestroy();
      }
      localObject = (IFontManagerService)((QQAppInterface)localObject).getRuntimeService(IFontManagerService.class, "");
      if (localObject != null) {
        ((IFontManagerService)localObject).onAIODestroy();
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
        QLog.d(a, 2, "refreshAIO");
      }
      localMqqHandler.removeMessages(16711697);
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(16711697), b);
    }
    localMqqHandler = paramAppInterface.getHandler(ChatHistoryBubbleListForTroopFragment.class);
    if (localMqqHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "refresh troop history");
      }
      localMqqHandler.removeMessages(16711697);
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(16711697), b);
    }
    paramAppInterface = paramAppInterface.getHandler(MiniChatActivity.class);
    if (paramAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "refresh miniAIO");
      }
      paramAppInterface.removeMessages(8);
      paramAppInterface.sendMessageDelayed(paramAppInterface.obtainMessage(8), b);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    BubbleManager localBubbleManager;
    if (paramQQAppInterface != null) {
      localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    } else {
      localBubbleManager = null;
    }
    if ((paramXListView != null) && (localBubbleManager != null))
    {
      int i = paramXListView.getChildCount() - 1;
      while (i >= 0)
      {
        Object localObject = paramXListView.getChildAt(i);
        if ((localObject instanceof BaseChatItemLayout))
        {
          BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.b((View)localObject);
          localObject = AIOUtils.a((View)localObject);
          if ((localObject != null) && (((ChatMessage)localObject).needVipBubble()) && (localViewHolder != null) && (localViewHolder.i != null) && (localViewHolder.i.a == BubbleUtils.a.a) && (localBubbleManager.a(SVIPHandlerConstants.a(((ChatMessage)localObject).vipBubbleID)))) {
            return true;
          }
          if ((localObject != null) && (((IFontManagerService)paramQQAppInterface.getRuntimeService(IFontManagerService.class, "")).isAioNeedRefresh(localViewHolder, localObject))) {
            return true;
          }
        }
        else if ((localObject != null) && ((AIOUtils.b((View)localObject) instanceof RichStatItemBuilder.Holder)))
        {
          return true;
        }
        i -= 1;
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    if (StudyModeManager.h())
    {
      QLog.i(a, 1, "study mode, can not start by link");
      c();
      return true;
    }
    return false;
  }
  
  private static void c()
  {
    ThreadManagerV2.getUIHandlerV2().post(new VasUtils.2());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasUtils
 * JD-Core Version:    0.7.0.1
 */