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
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
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
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.IKeyboardHiddenCallback;
import com.tencent.widget.SwipListView.SmoothInterpolator;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class LeftSwipeReplyHelper
  implements Handler.Callback, ILifeCycleHelper, ChatXListView.OnTouchEventConsumer, IKeyboardHiddenCallback
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
    float f2 = (Math.abs(paramFloat) - (BaseChatItemLayout.V + BaseChatItemLayout.W)) / AIOUtils.b(20.0F, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getResources());
    float f1;
    if (f2 < 0.0F)
    {
      f1 = 0.0F;
    }
    else
    {
      f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getReplyIconAlpha : scrollX -> ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(", alpha -> ");
      localStringBuilder.append(f1);
      localStringBuilder.append(", BaseChatItemLayout.replayIconSize -> ");
      localStringBuilder.append(BaseChatItemLayout.V);
      localStringBuilder.append(", BaseChatItemLayout.replayIconLeftMargin -> ");
      localStringBuilder.append(BaseChatItemLayout.W);
      QLog.d("LeftSwipeReplyHelper", 2, localStringBuilder.toString());
    }
    return f1;
  }
  
  private int a()
  {
    return AIOUtils.b(59.0F, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getResources());
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
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = a((MessageForStructing)paramChatMessage);
      if (paramChatMessage != null) {
        return paramChatMessage.intValue();
      }
    }
    else
    {
      if ((paramChatMessage instanceof MessageForShortVideo)) {
        return 6;
      }
      if ((paramChatMessage instanceof MessageForPic)) {
        return a((MessageForPic)paramChatMessage);
      }
      if ((paramChatMessage instanceof MessageForText)) {
        return a((MessageForText)paramChatMessage);
      }
      if ((paramChatMessage instanceof MessageForMarketFace)) {
        return 3;
      }
      if (a(paramChatMessage)) {
        return 9;
      }
      if (((paramChatMessage instanceof MessageForArkApp)) && (a((MessageForArkApp)paramChatMessage))) {
        return 8;
      }
    }
    return 10;
  }
  
  private int a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.checkGif()) {
      return 4;
    }
    return 5;
  }
  
  private int a(MessageForText paramMessageForText)
  {
    paramMessageForText = new QQText(paramMessageForText.sb, 8);
    if ((paramMessageForText.mSpans != null) && (paramMessageForText.mSpans.length > 0))
    {
      paramMessageForText = paramMessageForText.mSpans;
      int j = paramMessageForText.length;
      int i = 0;
      while (i < j)
      {
        if ((paramMessageForText[i] instanceof LinkSpan)) {
          return 7;
        }
        i += 1;
      }
    }
    return 2;
  }
  
  private ChatMessage a()
  {
    int i = this.jdField_e_of_type_Int;
    if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getCount()))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(this.jdField_e_of_type_Int);
      if ((localObject instanceof ChatMessage)) {
        return (ChatMessage)localObject;
      }
    }
    return null;
  }
  
  @Nullable
  private Boolean a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_Byte;
    Object localObject = Boolean.valueOf(false);
    if ((i == 0) && (b(paramInt1, paramInt2))) {
      return localObject;
    }
    if (d()) {
      return localObject;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_Byte = 2;
      return localObject;
    }
    if (!c())
    {
      this.jdField_a_of_type_Byte = 2;
      return localObject;
    }
    if (this.jdField_a_of_type_Byte == 0) {
      a(paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_Byte == 1)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null)
      {
        a(paramInt1, (View)localObject, this.jdField_b_of_type_AndroidViewView);
        this.jdField_d_of_type_Int = paramInt1;
        return Boolean.valueOf(true);
      }
    }
    this.jdField_d_of_type_Int = paramInt1;
    return null;
  }
  
  @Nullable
  private Integer a(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg != null)
    {
      if (paramMessageForStructing.structingMsg.mMsgServiceID == 35) {
        return Integer.valueOf(1);
      }
      if (paramMessageForStructing.structingMsg.mMsgServiceID == 95) {
        return Integer.valueOf(8);
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
    int i = this.jdField_a_of_type_Int;
    Object localObject;
    if ((f1 > i) || (paramFloat2 > i)) {
      if (paramFloat2 / f1 < 0.6F)
      {
        if (paramFloat1 < 0.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LeftSwipeReplyHelper", 2, "swipeDirectionJudge intercept the left swipe gesture");
          }
          this.jdField_a_of_type_Byte = 1;
          if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter() instanceof HeaderViewListAdapter))
          {
            localObject = ((HeaderViewListAdapter)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter()).getWrappedAdapter();
            if ((localObject instanceof ChatAdapter1)) {
              ((ChatAdapter1)localObject).d();
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.requestDisallowInterceptTouchEvent(true);
        }
        else
        {
          this.jdField_a_of_type_Byte = 2;
        }
      }
      else {
        this.jdField_a_of_type_Byte = 2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("swipeDirectionJudge mSlideStartDir: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Byte);
      QLog.d("hidePanelFromGesture", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt >= a())
    {
      if ((!this.jdField_c_of_type_Boolean) && (a(NoDisturbUtil.b(BaseApplicationImpl.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), false)))
      {
        this.jdField_c_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("LeftSwipeReplyHelper", 2, "scrollItemView Vibrator do vibrate");
        }
        if (!this.jdField_b_of_type_Boolean) {
          ((Vibrator)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("vibrator")).vibrate(100L);
        }
      }
    }
    else {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void a(int paramInt, View paramView1, View paramView2)
  {
    int k = a();
    int m = paramView1.getScrollX();
    int i = c();
    if (Math.abs(m) >= b()) {
      paramInt = (int)((paramInt - this.jdField_d_of_type_Int) * 0.25F);
    } else {
      paramInt -= this.jdField_d_of_type_Int;
    }
    int j = m - paramInt;
    if (j > i)
    {
      paramInt = i;
    }
    else
    {
      paramInt = j;
      if (j < 0) {
        paramInt = 0;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollItemView : scrollX -> ");
      localStringBuilder.append(m);
      localStringBuilder.append(", targetX ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", replyDistance -> ");
      localStringBuilder.append(k);
      QLog.d("LeftSwipeReplyHelper", 2, localStringBuilder.toString());
    }
    paramView1.scrollTo(paramInt, 0);
    a(paramInt);
    a(paramView2, paramInt);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    localObject = ((ChatXListView)localObject).getChildAt(this.jdField_e_of_type_Int - ((ChatXListView)localObject).getFirstVisiblePosition());
    if (((localObject instanceof BaseChatItemLayout)) && (a(((BaseChatItemLayout)localObject).findViewById(2131364521), paramMotionEvent)))
    {
      this.jdField_a_of_type_AndroidViewView = ((View)localObject);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364544);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("determineWhetherConsume() is called. ev");
      ((StringBuilder)localObject).append(paramMotionEvent);
      QLog.d("LeftSwipeReplyHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    int i = 0;
    this.jdField_e_of_type_Boolean = false;
    if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getWidth() - BaseChatItemLayout.j - AIOUtils.b(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources()) - BaseChatItemLayout.R) {
      i = 1;
    }
    if (i != 0)
    {
      i = paramInt2;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.isOverscrollHeadVisiable()) {
        i = paramInt2 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
      }
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.pointToPosition(paramInt1, i);
      if (this.jdField_e_of_type_Int >= 0) {
        a(paramMotionEvent);
      }
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    int i = a();
    if (!this.jdField_e_of_type_Boolean)
    {
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
    else
    {
      AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
      if ((localAnimatorSet != null) && (localAnimatorSet.isRunning()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LeftSwipeReplyHelper", 2, "doReplyIconAlphaAnimation : object animation not finish");
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "doReplyIconAlphaAnimation : set alpha by scroll distance");
      }
      paramView.setAlpha(a(paramInt));
      if (paramView.getVisibility() != 0) {
        paramView.setVisibility(0);
      }
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    int i;
    if (paramView1 != null) {
      i = paramView1.getScrollX();
    } else {
      i = 0;
    }
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
    if (QLog.isColorLevel())
    {
      paramView1 = new StringBuilder();
      paramView1.append("recoveryReplyItem : scrollX -> ");
      paramView1.append(i);
      QLog.d("LeftSwipeReplyHelper", 2, paramView1.toString());
    }
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if (this.f != 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager == null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER));
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
      if ((localObject != null) && (((MediaPlayerManager)localObject).a() == paramChatMessage) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a())) {
        this.f = 2;
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Byte == 0) && (b(paramInt1, paramInt2))) {
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
      a(paramInt1, paramInt2);
    }
    return this.jdField_a_of_type_Byte == 1;
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
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
    boolean bool1 = bool2;
    if (j >= m)
    {
      bool1 = bool2;
      if (j <= i1 + m)
      {
        bool1 = bool2;
        if (i >= k)
        {
          bool1 = bool2;
          if (i <= n + k) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    return ((paramChatMessage instanceof MessageForFile)) || ((paramChatMessage instanceof MessageForTroopFile));
  }
  
  private boolean a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    LeftSwipeReplyHelper.ItemTypeUtil localItemTypeUtil = this.jdField_a_of_type_ComTencentMobileqqBubbleLeftSwipeReplyHelper$ItemTypeUtil;
    if ((localItemTypeUtil != null) && (LeftSwipeReplyHelper.ItemTypeUtil.a(localItemTypeUtil, paramChatMessage))) {
      return LeftSwipeReplyHelper.ItemTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqBubbleLeftSwipeReplyHelper$ItemTypeUtil, paramChatMessage);
    }
    if (((paramChatMessage.senderuin != null) && (paramChatMessage.isSupportReply()) && (!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) || (b(paramChatMessage))) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private boolean a(MessageForArkApp paramMessageForArkApp)
  {
    try
    {
      boolean bool = "101458937".equals(new JSONObject(paramMessageForArkApp.ark_app_message.metaList).optJSONObject("news").optString("appid"));
      if (bool) {
        return true;
      }
    }
    catch (Throwable paramMessageForArkApp)
    {
      paramMessageForArkApp.printStackTrace();
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerVibrate()) && (!paramBoolean1)) {
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormalVibrate()) && (!paramBoolean1)) {
      return true;
    }
    return paramBoolean2;
  }
  
  private int b()
  {
    return a();
  }
  
  private int b(ChatMessage paramChatMessage)
  {
    int[] arrayOfInt = new int[20];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 1000;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 1001;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 1002;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 1003;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 1004;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 1006;
    int[] tmp44_38 = tmp38_32;
    tmp44_38[6] = 2016;
    int[] tmp51_44 = tmp44_38;
    tmp51_44[7] = 1008;
    int[] tmp58_51 = tmp51_44;
    tmp58_51[8] = 1009;
    int[] tmp65_58 = tmp58_51;
    tmp65_58[9] = 1010;
    int[] tmp72_65 = tmp65_58;
    tmp72_65[10] = 1011;
    int[] tmp79_72 = tmp72_65;
    tmp79_72[11] = 1020;
    int[] tmp86_79 = tmp79_72;
    tmp86_79[12] = 1021;
    int[] tmp93_86 = tmp86_79;
    tmp93_86[13] = 1022;
    int[] tmp100_93 = tmp93_86;
    tmp100_93[14] = 1023;
    int[] tmp107_100 = tmp100_93;
    tmp107_100[15] = 1024;
    int[] tmp114_107 = tmp107_100;
    tmp114_107[16] = 1025;
    int[] tmp121_114 = tmp114_107;
    tmp121_114[17] = 1036;
    int[] tmp128_121 = tmp121_114;
    tmp128_121[18] = 10008;
    int[] tmp135_128 = tmp128_121;
    tmp135_128[19] = 10009;
    tmp135_128;
    if (paramChatMessage.istroop == 0) {
      return 1;
    }
    if (paramChatMessage.istroop == 1) {
      return 2;
    }
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (paramChatMessage.istroop == k) {
        return 3;
      }
      i += 1;
    }
    return 4;
  }
  
  private void b()
  {
    if (!b())
    {
      Object localObject = a();
      if (localObject != null)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92F", "0X800A92F", a((ChatMessage)localObject), b((ChatMessage)localObject), "", "", "", "");
        ((ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(119)).a((ChatMessage)localObject, 0, 0L, null);
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
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697407, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    float f1 = Math.abs(paramInt1 - this.jdField_b_of_type_Int);
    float f2 = Math.abs(paramInt2 - this.jdField_c_of_type_Int);
    paramInt1 = this.jdField_a_of_type_Int;
    if ((f1 <= paramInt1) && (f2 <= paramInt1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeftSwipeReplyHelper", 2, "onTouchEventConsume ACTION_MOVE judge fail");
      }
      return true;
    }
    return false;
  }
  
  private boolean b(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()) && (paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768) && (paramChatMessage.istroop != 3000);
  }
  
  private int c()
  {
    return AIOUtils.b(89.0F, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getResources());
  }
  
  private boolean c()
  {
    ChatMessage localChatMessage = a();
    boolean bool2 = c(localChatMessage);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((!(localChatMessage instanceof MessageForScribble)) && (!(localChatMessage instanceof MessageForHiBoom))) {
      return a(localChatMessage, false);
    }
    if (localChatMessage.istroop == 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    return (this.jdField_b_of_type_Boolean) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3);
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return true;
    }
    if ((paramChatMessage.shmsgseq != 0L) && (!(paramChatMessage instanceof MessageForLongTextMsg)) && (!(paramChatMessage instanceof MessageForMixedMsg)))
    {
      if ((paramChatMessage instanceof MessageForTribeShortVideo)) {
        return true;
      }
      return ((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && ((paramChatMessage instanceof MessageForArkFlashChat));
    }
    return true;
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
      a(localChatMessage);
    }
    return this.f == 2;
  }
  
  private boolean d(MotionEvent paramMotionEvent)
  {
    int k = (int)(paramMotionEvent.getX() + 0.5F);
    int j = (int)(paramMotionEvent.getY() + 0.5F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
    int i;
    if (k < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getWidth() - BaseChatItemLayout.j - AIOUtils.b(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources()) - BaseChatItemLayout.R) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.isOverscrollHeadVisiable()) {
        i = j + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
      }
      i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.pointToPosition(k, i);
      if (i >= 0)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
        localObject = ((ChatXListView)localObject).getChildAt(i - ((ChatXListView)localObject).getFirstVisiblePosition());
        if ((localObject instanceof BaseChatItemLayout))
        {
          boolean bool = a(((BaseChatItemLayout)localObject).findViewById(2131364521), paramMotionEvent);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isInterestedMotionEvent() is called. ev");
            ((StringBuilder)localObject).append(paramMotionEvent);
            ((StringBuilder)localObject).append("right to left touchPointInView = ");
            ((StringBuilder)localObject).append(bool);
            QLog.d("LeftSwipeReplyHelper", 2, ((StringBuilder)localObject).toString());
          }
          return bool;
        }
      }
    }
    return false;
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (paramView == this.jdField_a_of_type_AndroidViewView))
    {
      paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      if ((paramView != null) && (paramView.jdField_b_of_type_Int + 1 != this.jdField_e_of_type_Int))
      {
        this.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSwipeItemReused value set :  true, motionPos -> ");
          localStringBuilder.append(this.jdField_e_of_type_Int);
          localStringBuilder.append(", holder.pos -> ");
          localStringBuilder.append(paramView.jdField_b_of_type_Int);
          QLog.d("LeftSwipeReplyHelper", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mSlideStartDir : ");
      localStringBuilder.append(this.jdField_a_of_type_Byte);
      localStringBuilder.append(", forceCloseSoftInput: ");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      QLog.d("hidePanelFromGesture", 2, localStringBuilder.toString());
    }
    if (this.jdField_d_of_type_Boolean) {
      return true;
    }
    int i = this.jdField_a_of_type_Byte;
    if (i == 0) {
      return false;
    }
    return i != 1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (c(paramMotionEvent)) {
      return true;
    }
    if ((this.jdField_a_of_type_Boolean) && (!BaseChatItemLayout.jdField_a_of_type_Boolean))
    {
      int i = (int)(paramMotionEvent.getX() + 0.5F);
      int j = (int)(paramMotionEvent.getY() + 0.5F);
      int k = paramMotionEvent.getAction();
      if (k != 0)
      {
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3) {
              return false;
            }
            a();
            this.jdField_b_of_type_Boolean = false;
            return false;
          }
          return a(i, j);
        }
        a();
        this.jdField_b_of_type_Boolean = false;
        if (QLog.isColorLevel())
        {
          QLog.d("LeftSwipeReplyHelper", 2, "onInterceptTouchEvent ACTION_UP isSwipeItemReused value set : false");
          return false;
        }
      }
      else
      {
        a(paramMotionEvent, i, j);
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a();
    }
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (c(paramMotionEvent)) {
      return true;
    }
    if ((this.jdField_a_of_type_Boolean) && (!BaseChatItemLayout.jdField_a_of_type_Boolean))
    {
      int i = (int)(paramMotionEvent.getX() + 0.5F);
      int j = (int)(paramMotionEvent.getY() + 0.5F);
      int k = paramMotionEvent.getAction();
      if (k != 0)
      {
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3) {
              return false;
            }
            a();
            this.jdField_b_of_type_Boolean = false;
            return false;
          }
          paramMotionEvent = a(i, j);
          if (paramMotionEvent != null) {
            return paramMotionEvent.booleanValue();
          }
        }
        else
        {
          a();
          this.jdField_b_of_type_Boolean = false;
          if (QLog.isColorLevel())
          {
            QLog.d("LeftSwipeReplyHelper", 2, "onTouchEvent ACTION_UP isSwipeItemReused value set : false");
            return false;
          }
        }
      }
      else
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_b_of_type_Int = i;
        this.jdField_c_of_type_Int = j;
        this.jdField_d_of_type_Int = i;
      }
    }
    return false;
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
    paramMessage = this.jdField_c_of_type_AndroidViewView;
    if (paramMessage != null)
    {
      int i = paramMessage.getScrollX();
      int j = (int)f1;
      if (i > j)
      {
        this.jdField_c_of_type_AndroidViewView.scrollTo(j, 0);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.invalidate();
      }
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return false;
    }
    this.jdField_c_of_type_AndroidViewView = null;
    paramMessage = this.jdField_d_of_type_AndroidViewView;
    if (paramMessage != null) {
      paramMessage.setVisibility(4);
    }
    this.jdField_d_of_type_AndroidViewView = null;
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      boolean bool = false;
      Object localObject;
      if (paramInt != 4)
      {
        if (paramInt != 15) {
          return;
        }
        this.jdField_a_of_type_Boolean = false;
        localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
        if (localObject != null) {
          ((ChatXListView)localObject).setOnTouchEventConsumer(null);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if ((localObject != null) && (((ChatDrawerHelper)((BaseChatPie)localObject).a(124)).a != null)) {
          ((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(124)).a.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        if (((localObject instanceof FriendChatPie)) || ((localObject instanceof TroopChatPie)) || ((localObject instanceof DiscussChatPie))) {
          bool = true;
        }
        this.jdField_a_of_type_Boolean = bool;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleLeftSwipeReplyHelper$ItemTypeUtil = new LeftSwipeReplyHelper.ItemTypeUtil(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchEventConsumer(this);
        ((ChatDrawerHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(124)).a.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame$TouchEventConsumer);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.LeftSwipeReplyHelper
 * JD-Core Version:    0.7.0.1
 */