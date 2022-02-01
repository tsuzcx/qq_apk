package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.SwipListView.SmoothInterpolator;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONObject;

public class LeftSwipeReplyHelper
  implements Handler.Callback, ILifeCycleHelper, ChatXListView.OnTouchEventConsumer
{
  private byte jdField_a_of_type_Byte = 0;
  private final int jdField_a_of_type_Int;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private LeftSwipeReplyHelper.ItemTypeUtil jdField_a_of_type_ComTencentMobileqqBubbleLeftSwipeReplyHelper$ItemTypeUtil;
  private DrawerFrame.TouchEventConsumer jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer = new LeftSwipeReplyHelper.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = false;
  private int f = 0;
  
  public LeftSwipeReplyHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, new SwipListView.SmoothInterpolator());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private float a(float paramFloat)
  {
    float f1 = 0.0F;
    float f2 = (Math.abs(paramFloat) - (BaseChatItemLayout.V + BaseChatItemLayout.W)) / AIOUtils.a(20.0F, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getResources());
    if (f2 < 0.0F) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "getReplyIconAlpha : scrollX -> " + paramFloat + ", alpha -> " + f1 + ", BaseChatItemLayout.replayIconSize -> " + BaseChatItemLayout.V + ", BaseChatItemLayout.replayIconLeftMargin -> " + BaseChatItemLayout.W);
      }
      return f1;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      } else {
        f1 = f2;
      }
    }
  }
  
  private int a()
  {
    return AIOUtils.a(59.0F, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getResources());
  }
  
  private int a(int paramInt)
  {
    int i = c();
    if (i > 0) {
      return (int)(Math.abs(paramInt) / i * 150.0F) + 50;
    }
    return 150;
  }
  
  private int a(ChatMessage paramChatMessage)
  {
    int i = 8;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if (paramChatMessage.structingMsg != null)
      {
        if (paramChatMessage.structingMsg.mMsgServiceID == 35) {
          i = 1;
        }
        while (paramChatMessage.structingMsg.mMsgServiceID == 95) {
          return i;
        }
      }
    }
    for (;;)
    {
      return 10;
      if ((paramChatMessage instanceof MessageForShortVideo)) {
        return 6;
      }
      if ((paramChatMessage instanceof MessageForPic))
      {
        if (((MessageForPic)paramChatMessage).checkGif()) {
          return 4;
        }
        return 5;
      }
      if ((paramChatMessage instanceof MessageForText))
      {
        paramChatMessage = new QQText(((MessageForText)paramChatMessage).sb, 8);
        if ((paramChatMessage.mSpans != null) && (paramChatMessage.mSpans.length > 0))
        {
          paramChatMessage = paramChatMessage.mSpans;
          int j = paramChatMessage.length;
          i = 0;
          while (i < j)
          {
            if ((paramChatMessage[i] instanceof LinkSpan)) {
              return 7;
            }
            i += 1;
          }
        }
        return 2;
      }
      if ((paramChatMessage instanceof MessageForMarketFace)) {
        return 3;
      }
      if (((paramChatMessage instanceof MessageForFile)) || ((paramChatMessage instanceof MessageForTroopFile))) {
        return 9;
      }
      if ((paramChatMessage instanceof MessageForArkApp)) {
        try
        {
          boolean bool = "101458937".equals(new JSONObject(((MessageForArkApp)paramChatMessage).ark_app_message.metaList).optJSONObject("news").optString("appid"));
          if (bool) {
            return 8;
          }
        }
        catch (Throwable paramChatMessage)
        {
          paramChatMessage.printStackTrace();
        }
      }
    }
  }
  
  private ChatMessage a()
  {
    if ((this.jdField_e_of_type_Int >= 0) && (this.jdField_e_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getCount()))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(this.jdField_e_of_type_Int);
      if ((localObject instanceof ChatMessage)) {
        return (ChatMessage)localObject;
      }
    }
    return null;
  }
  
  private void a()
  {
    a(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidViewView);
    this.f = 0;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Byte = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.requestDisallowInterceptTouchEvent(false);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.jdField_b_of_type_Int;
    float f2 = this.jdField_c_of_type_Int;
    float f1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2 - f2);
    if ((f1 > this.jdField_a_of_type_Int) || (paramFloat2 > this.jdField_a_of_type_Int))
    {
      if (paramFloat2 / f1 >= 0.6F) {
        break label181;
      }
      if (paramFloat1 >= 0.0F) {
        break label173;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "swipeDirectionJudge intercept the left swipe gesture");
      }
      this.jdField_a_of_type_Byte = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter() instanceof HeaderViewListAdapter))
      {
        ListAdapter localListAdapter = ((HeaderViewListAdapter)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter()).getWrappedAdapter();
        if ((localListAdapter instanceof ChatAdapter1)) {
          ((ChatAdapter1)localListAdapter).d();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("hidePanelFromGesture", 2, "swipeDirectionJudge mSlideStartDir: " + this.jdField_a_of_type_Byte);
      }
      return;
      label173:
      this.jdField_a_of_type_Byte = 2;
      continue;
      label181:
      this.jdField_a_of_type_Byte = 2;
    }
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    if (paramInt >= a())
    {
      boolean bool;
      if (!this.jdField_c_of_type_Boolean)
      {
        bool = NoDisturbUtil.b(BaseApplicationImpl.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerVibrate()) || (bool)) {
          break label110;
        }
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          this.jdField_c_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("LeftSwipeReplyHelper", 2, "scrollItemView Vibrator do vibrate");
          }
          if (!this.jdField_b_of_type_Boolean) {
            ((Vibrator)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("vibrator")).vibrate(100L);
          }
        }
        return;
        label110:
        paramInt = i;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormal())
        {
          paramInt = i;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormalVibrate())
          {
            paramInt = i;
            if (!bool) {
              paramInt = 1;
            }
          }
        }
      }
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(int paramInt, View paramView1, View paramView2)
  {
    int j = a();
    int k = paramView1.getScrollX();
    int i = c();
    if (Math.abs(k) >= b())
    {
      paramInt = (int)((paramInt - this.jdField_d_of_type_Int) * 0.25F);
      paramInt = k - paramInt;
      if (paramInt <= i) {
        break label139;
      }
      paramInt = i;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "scrollItemView : scrollX -> " + k + ", targetX " + paramInt + ", replyDistance -> " + j);
      }
      paramView1.scrollTo(paramInt, 0);
      a(paramInt);
      a(paramView2, paramInt);
      return;
      paramInt -= this.jdField_d_of_type_Int;
      break;
      label139:
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_e_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
    if (((localView instanceof BaseChatItemLayout)) && (a(((BaseChatItemLayout)localView).findViewById(2131364634), paramMotionEvent)))
    {
      this.jdField_a_of_type_AndroidViewView = localView;
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364657);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LeftSwipeReplyHelper", 2, "determineWhetherConsume() is called. ev" + paramMotionEvent);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    int i = a();
    if (!this.jdField_e_of_type_Boolean) {
      if (paramInt >= i)
      {
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F }) });
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(150L);
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new LeftSwipeReplyHelper.2(this));
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
        if (paramView.getVisibility() != 0) {
          paramView.setVisibility(0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("LeftSwipeReplyHelper", 2, "doReplyIconAlphaAnimation : object animation start");
        }
      }
    }
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) || (!this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LeftSwipeReplyHelper", 2, "doReplyIconAlphaAnimation : object animation not finish");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "doReplyIconAlphaAnimation : set alpha by scroll distance");
      }
      paramView.setAlpha(a(paramInt));
    } while (paramView.getVisibility() == 0);
    paramView.setVisibility(0);
  }
  
  private void a(View paramView1, View paramView2)
  {
    if (paramView1 != null) {}
    for (int i = paramView1.getScrollX();; i = 0)
    {
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidViewView = paramView1;
        this.jdField_d_of_type_AndroidViewView = paramView2;
        int j = a();
        int k = -i;
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, k, 0, a(k));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        if ((i >= j) && (!this.jdField_b_of_type_Boolean)) {
          b();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "recoveryReplyItem : scrollX -> " + i);
      }
      return;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    float f1 = Math.abs(paramInt1 - this.jdField_b_of_type_Int);
    float f2 = Math.abs(paramInt2 - this.jdField_c_of_type_Int);
    if ((f1 <= this.jdField_a_of_type_Int) && (f2 <= this.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "onTouchEventConsume ACTION_MOVE judge fail");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramView == null) {
      return false;
    }
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int k = paramMotionEvent[0];
    int m = paramMotionEvent[1];
    int n = paramView.getMeasuredWidth();
    int i1 = paramView.getMeasuredHeight();
    if ((j >= m) && (j <= i1 + m) && (i >= k) && (i <= n + k)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private int b()
  {
    return a();
  }
  
  private int b(ChatMessage paramChatMessage)
  {
    switch (paramChatMessage.istroop)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  private void b()
  {
    if (!b())
    {
      Object localObject = a();
      if (localObject != null)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92F", "0X800A92F", a((ChatMessage)localObject), b((ChatMessage)localObject), "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d((ChatMessage)localObject);
        if ((localObject instanceof MessageForStructing))
        {
          localObject = (MessageForStructing)localObject;
          if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 81) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
            StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, (MessageForStructing)localObject, "reply");
          }
        }
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697388, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return true;
    }
    return false;
  }
  
  private int c()
  {
    return AIOUtils.a(89.0F, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getResources());
  }
  
  private boolean c()
  {
    boolean bool = true;
    ChatMessage localChatMessage = a();
    if (localChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while ((localChatMessage.shmsgseq == 0L) || ((localChatMessage instanceof MessageForLongTextMsg)) || ((localChatMessage instanceof MessageForMixedMsg)) || ((localChatMessage instanceof MessageForTribeShortVideo)));
        if (((localChatMessage instanceof MessageForScribble)) || ((localChatMessage instanceof MessageForHiBoom)))
        {
          if (localChatMessage.istroop == 0) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
      } while (((localChatMessage.istroop == 3000) || (localChatMessage.istroop == 1)) && ((localChatMessage instanceof MessageForArkFlashChat)));
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleLeftSwipeReplyHelper$ItemTypeUtil != null) && (LeftSwipeReplyHelper.ItemTypeUtil.a(this.jdField_a_of_type_ComTencentMobileqqBubbleLeftSwipeReplyHelper$ItemTypeUtil, localChatMessage))) {
        return LeftSwipeReplyHelper.ItemTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqBubbleLeftSwipeReplyHelper$ItemTypeUtil, localChatMessage);
      }
      if ((localChatMessage.senderuin != null) && (localChatMessage.isSupportReply()) && (!localChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
        return true;
      }
    } while ((!localChatMessage.isSend()) || (!localChatMessage.isSupportReply()) || (localChatMessage.extraflag == 32772) || (localChatMessage.extraflag == 32768) || (localChatMessage.istroop == 3000));
    return true;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    int k = (int)(paramMotionEvent.getX() + 0.5F);
    int j = (int)(paramMotionEvent.getY() + 0.5F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
    if (k < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getWidth() - BaseChatItemLayout.j - AIOUtils.a(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources()) - BaseChatItemLayout.R) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.isOverscrollHeadVisiable()) {
        i = j + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
      }
      i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.pointToPosition(k, i);
      if (i < 0) {
        break;
      }
      View localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
      if (!(localView instanceof BaseChatItemLayout)) {
        break;
      }
      boolean bool = a(((BaseChatItemLayout)localView).findViewById(2131364634), paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "isInterestedMotionEvent() is called. ev" + paramMotionEvent + "right to left touchPointInView = " + bool);
      }
      return bool;
    }
    return false;
  }
  
  private boolean d()
  {
    if (this.f == 0)
    {
      this.f = 1;
      ChatMessage localChatMessage = a();
      if (((localChatMessage instanceof MessageForPtt)) && (((MessageForPtt)localChatMessage).playProgress > 0.0F)) {
        this.f = 2;
      }
      if (this.f != 2)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a() == localChatMessage) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a())) {
          this.f = 2;
        }
      }
    }
    return this.f == 2;
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (paramView == this.jdField_a_of_type_AndroidViewView))
    {
      paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      if ((paramView != null) && (paramView.jdField_b_of_type_Int + 1 != this.jdField_e_of_type_Int))
      {
        this.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("LeftSwipeReplyHelper", 2, "isSwipeItemReused value set :  true, motionPos -> " + this.jdField_e_of_type_Int + ", holder.pos -> " + paramView.jdField_b_of_type_Int);
        }
        a();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("hidePanelFromGesture", 2, "mSlideStartDir : " + this.jdField_a_of_type_Byte + ", forceCloseSoftInput: " + this.jdField_d_of_type_Boolean);
    }
    if (this.jdField_d_of_type_Boolean) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_Byte == 0) {
        return false;
      }
    } while (this.jdField_a_of_type_Byte != 1);
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_b_of_type_Boolean) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
      bool1 = true;
    }
    label255:
    do
    {
      int k;
      int j;
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!this.jdField_a_of_type_Boolean);
            bool1 = bool2;
          } while (BaseChatItemLayout.jdField_a_of_type_Boolean);
          k = (int)(paramMotionEvent.getX() + 0.5F);
          j = (int)(paramMotionEvent.getY() + 0.5F);
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          case 0: 
            this.jdField_b_of_type_Int = k;
            this.jdField_c_of_type_Int = j;
            this.jdField_e_of_type_Boolean = false;
            if (k < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getWidth() - BaseChatItemLayout.j - AIOUtils.a(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources()) - BaseChatItemLayout.R) {}
            for (;;)
            {
              bool1 = bool2;
              if (i == 0) {
                break;
              }
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.isOverscrollHeadVisiable()) {
                i = j + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
              }
              this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.pointToPosition(k, i);
              bool1 = bool2;
              if (this.jdField_e_of_type_Int < 0) {
                break;
              }
              a(paramMotionEvent);
              return false;
              i = 0;
            }
          case 2: 
            if (this.jdField_a_of_type_Byte != 0) {
              break label255;
            }
            bool1 = bool2;
          }
        } while (a(k, j));
        bool1 = bool2;
      } while (d());
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_Byte = 2;
        return false;
      }
      if (!c())
      {
        this.jdField_a_of_type_Byte = 2;
        return false;
      }
      if (this.jdField_a_of_type_Byte == 0) {
        a(k, j);
      }
      if (this.jdField_a_of_type_Byte == 1) {}
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
      a();
      this.jdField_b_of_type_Boolean = false;
      return false;
      a();
      this.jdField_b_of_type_Boolean = false;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("LeftSwipeReplyHelper", 2, "onInterceptTouchEvent ACTION_UP isSwipeItemReused value set : false");
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
      return true;
    }
    int i;
    int j;
    if ((this.jdField_a_of_type_Boolean) && (!BaseChatItemLayout.jdField_a_of_type_Boolean))
    {
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      this.jdField_e_of_type_Boolean = false;
      this.jdField_b_of_type_Int = i;
      this.jdField_c_of_type_Int = j;
      this.jdField_d_of_type_Int = i;
      continue;
      if ((this.jdField_a_of_type_Byte == 0) && (a(i, j))) {
        return false;
      }
      if (d()) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_Byte = 2;
        return false;
      }
      if (!c())
      {
        this.jdField_a_of_type_Byte = 2;
        return false;
      }
      if (this.jdField_a_of_type_Byte == 0) {
        a(i, j);
      }
      if ((this.jdField_a_of_type_Byte == 1) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        a(i, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidViewView);
        this.jdField_d_of_type_Int = i;
        return true;
      }
      this.jdField_d_of_type_Int = i;
      continue;
      a();
      this.jdField_b_of_type_Boolean = false;
      continue;
      a();
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "onTouchEvent ACTION_UP isSwipeItemReused value set : false");
      }
    }
  }
  
  public String getTag()
  {
    return "LeftSwipeReplyHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
    float f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      float f2 = a(f1);
      this.jdField_d_of_type_AndroidViewView.setAlpha(f2);
    }
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getScrollX() > (int)f1))
    {
      this.jdField_c_of_type_AndroidViewView.scrollTo((int)f1, 0);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.invalidate();
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return false;
    }
    this.jdField_c_of_type_AndroidViewView = null;
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
    }
    this.jdField_d_of_type_AndroidViewView = null;
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof FriendChatPie)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof DiscussChatPie))) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleLeftSwipeReplyHelper$ItemTypeUtil = new LeftSwipeReplyHelper.ItemTypeUtil(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchEventConsumer(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
      return;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchEventConsumer(null);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.LeftSwipeReplyHelper
 * JD-Core Version:    0.7.0.1
 */