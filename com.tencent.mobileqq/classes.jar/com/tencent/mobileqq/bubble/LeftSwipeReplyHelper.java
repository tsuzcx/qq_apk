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
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class LeftSwipeReplyHelper
  implements Handler.Callback, ILifeCycleHelper, ChatXListView.OnTouchEventConsumer, IKeyboardHiddenCallback
{
  private ChatXListView a;
  private BaseChatPie b;
  private final int c;
  private Scroller d;
  private Handler e;
  private boolean f;
  private boolean g = false;
  private int h;
  private int i;
  private int j;
  private View k;
  private View l;
  private byte m = 0;
  private View n;
  private View o;
  private int p = -1;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private MediaPlayerManager t;
  private int u = 0;
  private AnimatorSet v;
  private LeftSwipeReplyHelper.ItemTypeUtil w;
  private DrawerFrame.TouchEventConsumer x = new LeftSwipeReplyHelper.1(this);
  
  public LeftSwipeReplyHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
    this.c = ViewConfiguration.get(this.b.e).getScaledTouchSlop();
    this.d = new Scroller(this.b.e, new SwipListView.SmoothInterpolator());
    this.e = new Handler(Looper.getMainLooper(), this);
  }
  
  private float a(float paramFloat)
  {
    float f2 = (Math.abs(paramFloat) - (BaseChatItemLayout.V + BaseChatItemLayout.W)) / AIOUtils.b(20.0F, this.a.getResources());
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
      if (b(paramChatMessage)) {
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
      int i2 = paramMessageForText.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if ((paramMessageForText[i1] instanceof LinkSpan)) {
          return 7;
        }
        i1 += 1;
      }
    }
    return 2;
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
  
  private void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.h;
    float f2 = this.i;
    float f1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2 - f2);
    int i1 = this.c;
    Object localObject;
    if ((f1 > i1) || (paramFloat2 > i1)) {
      if (paramFloat2 / f1 < 0.6F)
      {
        if (paramFloat1 < 0.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LeftSwipeReplyHelper", 2, "swipeDirectionJudge intercept the left swipe gesture");
          }
          this.m = 1;
          if ((this.a.getAdapter() instanceof HeaderViewListAdapter))
          {
            localObject = ((HeaderViewListAdapter)this.a.getAdapter()).getWrappedAdapter();
            if ((localObject instanceof ChatAdapter1)) {
              ((ChatAdapter1)localObject).e();
            }
          }
          this.a.requestDisallowInterceptTouchEvent(true);
        }
        else
        {
          this.m = 2;
        }
      }
      else {
        this.m = 2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("swipeDirectionJudge mSlideStartDir: ");
      ((StringBuilder)localObject).append(this.m);
      QLog.d("hidePanelFromGesture", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt >= c())
    {
      if ((!this.q) && (a(NoDisturbUtil.b(BaseApplicationImpl.getApplication().getApplicationContext(), this.b.d), false)))
      {
        this.q = true;
        if (QLog.isColorLevel()) {
          QLog.d("LeftSwipeReplyHelper", 2, "scrollItemView Vibrator do vibrate");
        }
        if (!this.g) {
          ((Vibrator)this.b.d.getApp().getSystemService("vibrator")).vibrate(100L);
        }
      }
    }
    else {
      this.q = false;
    }
  }
  
  private void a(int paramInt, View paramView1, View paramView2)
  {
    int i3 = c();
    int i4 = paramView1.getScrollX();
    int i1 = e();
    if (Math.abs(i4) >= d()) {
      paramInt = (int)((paramInt - this.j) * 0.25F);
    } else {
      paramInt -= this.j;
    }
    int i2 = i4 - paramInt;
    if (i2 > i1)
    {
      paramInt = i1;
    }
    else
    {
      paramInt = i2;
      if (i2 < 0) {
        paramInt = 0;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollItemView : scrollX -> ");
      localStringBuilder.append(i4);
      localStringBuilder.append(", targetX ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", replyDistance -> ");
      localStringBuilder.append(i3);
      QLog.d("LeftSwipeReplyHelper", 2, localStringBuilder.toString());
    }
    paramView1.scrollTo(paramInt, 0);
    a(paramInt);
    a(paramView2, paramInt);
  }
  
  private void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    int i1 = 0;
    this.s = false;
    if (paramInt1 < this.a.getWidth() - BaseChatItemLayout.getBubblePaddingAlignHead() - AIOUtils.b(5.0F, this.b.e.getResources()) - BaseChatItemLayout.R) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      i1 = paramInt2;
      if (this.a.isOverscrollHeadVisiable()) {
        i1 = paramInt2 + this.a.getScrollY();
      }
      this.p = this.a.pointToPosition(paramInt1, i1);
      if (this.p >= 0) {
        d(paramMotionEvent);
      }
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    int i1 = c();
    if (!this.s)
    {
      if (paramInt >= i1)
      {
        this.s = true;
        this.v = new AnimatorSet();
        this.v.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F }) });
        this.v.setDuration(150L);
        this.v.addListener(new LeftSwipeReplyHelper.2(this));
        this.v.start();
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
      AnimatorSet localAnimatorSet = this.v;
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
    int i1;
    if (paramView1 != null) {
      i1 = paramView1.getScrollX();
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.n = paramView1;
      this.o = paramView2;
      int i2 = c();
      int i3 = -i1;
      this.d.startScroll(i1, 0, i3, 0, b(i3));
      this.e.sendEmptyMessage(0);
      if ((i1 >= i2) && (!this.g)) {
        f();
      }
    }
    if (QLog.isColorLevel())
    {
      paramView1 = new StringBuilder();
      paramView1.append("recoveryReplyItem : scrollX -> ");
      paramView1.append(i1);
      QLog.d("LeftSwipeReplyHelper", 2, paramView1.toString());
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.m == 0) && (b(paramInt1, paramInt2))) {
      return false;
    }
    if (j()) {
      return false;
    }
    if (this.k == null)
    {
      this.m = 2;
      return false;
    }
    if (!h())
    {
      this.m = 2;
      return false;
    }
    if (this.m == 0) {
      a(paramInt1, paramInt2);
    }
    return this.m == 1;
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    int i1 = (int)paramMotionEvent.getRawX();
    int i2 = (int)paramMotionEvent.getRawY();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int i3 = paramMotionEvent[0];
    int i4 = paramMotionEvent[1];
    int i5 = paramView.getMeasuredWidth();
    int i6 = paramView.getMeasuredHeight();
    boolean bool1 = bool2;
    if (i2 >= i4)
    {
      bool1 = bool2;
      if (i2 <= i6 + i4)
      {
        bool1 = bool2;
        if (i1 >= i3)
        {
          bool1 = bool2;
          if (i1 <= i5 + i3) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    LeftSwipeReplyHelper.ItemTypeUtil localItemTypeUtil = this.w;
    if ((localItemTypeUtil != null) && (LeftSwipeReplyHelper.ItemTypeUtil.a(localItemTypeUtil, paramChatMessage))) {
      return LeftSwipeReplyHelper.ItemTypeUtil.b(this.w, paramChatMessage);
    }
    if (((paramChatMessage.senderuin != null) && (paramChatMessage.isSupportReply()) && (!paramChatMessage.senderuin.equals(this.b.d.getCurrentUin()))) || (d(paramChatMessage))) {
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
    if ((this.b.d.isRingerVibrate()) && (!paramBoolean1)) {
      return true;
    }
    if ((this.b.d.isRingerNormal()) && (this.b.d.isRingerNormalVibrate()) && (!paramBoolean1)) {
      return true;
    }
    return paramBoolean2;
  }
  
  private int b(int paramInt)
  {
    int i1 = e();
    if (i1 > 0) {
      return (int)(Math.abs(paramInt) / i1 * 150.0F) + 50;
    }
    return 150;
  }
  
  private void b()
  {
    a(this.k, this.l);
    this.u = 0;
    this.k = null;
    this.l = null;
    this.j = -1;
    this.p = -1;
    this.h = -1;
    this.i = -1;
    this.m = 0;
    this.s = false;
    this.a.requestDisallowInterceptTouchEvent(false);
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    float f1 = Math.abs(paramInt1 - this.h);
    float f2 = Math.abs(paramInt2 - this.i);
    paramInt1 = this.c;
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
    return ((paramChatMessage instanceof MessageForFile)) || ((paramChatMessage instanceof MessageForTroopFile));
  }
  
  private int c()
  {
    return AIOUtils.b(59.0F, this.a.getResources());
  }
  
  private int c(ChatMessage paramChatMessage)
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
    tmp135_128[19] = 10013;
    tmp135_128;
    if (paramChatMessage.istroop == 0) {
      return 1;
    }
    if (paramChatMessage.istroop == 1) {
      return 2;
    }
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      if (paramChatMessage.istroop == i3) {
        return 3;
      }
      i1 += 1;
    }
    return 4;
  }
  
  @Nullable
  private Boolean c(int paramInt1, int paramInt2)
  {
    int i1 = this.m;
    Object localObject = Boolean.valueOf(false);
    if ((i1 == 0) && (b(paramInt1, paramInt2))) {
      return localObject;
    }
    if (j()) {
      return localObject;
    }
    if (this.k == null)
    {
      this.m = 2;
      return localObject;
    }
    if (!h())
    {
      this.m = 2;
      return localObject;
    }
    if (this.m == 0) {
      a(paramInt1, paramInt2);
    }
    if (this.m == 1)
    {
      localObject = this.k;
      if (localObject != null)
      {
        a(paramInt1, (View)localObject, this.l);
        this.j = paramInt1;
        return Boolean.valueOf(true);
      }
    }
    this.j = paramInt1;
    return null;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    return (this.g) && (paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3);
  }
  
  private int d()
  {
    return c();
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    Object localObject = this.a;
    localObject = ((ChatXListView)localObject).getChildAt(this.p - ((ChatXListView)localObject).getFirstVisiblePosition());
    if (((localObject instanceof BaseChatItemLayout)) && (a(((BaseChatItemLayout)localObject).findViewById(2131430578), paramMotionEvent)))
    {
      this.k = ((View)localObject);
      this.l = this.k.findViewById(2131430602);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("determineWhetherConsume() is called. ev");
      ((StringBuilder)localObject).append(paramMotionEvent);
      QLog.d("LeftSwipeReplyHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean d(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()) && (paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768) && (paramChatMessage.istroop != 3000);
  }
  
  private int e()
  {
    return AIOUtils.b(89.0F, this.a.getResources());
  }
  
  private boolean e(MotionEvent paramMotionEvent)
  {
    int i3 = (int)(paramMotionEvent.getX() + 0.5F);
    int i2 = (int)(paramMotionEvent.getY() + 0.5F);
    int i1 = this.a.getWidth();
    int i4 = BaseChatItemLayout.getBubblePaddingAlignHead();
    int i5 = AIOUtils.b(5.0F, this.b.e.getResources());
    int i6 = BaseChatItemLayout.R;
    boolean bool2 = false;
    if (i3 < i1 - i4 - i5 - i6) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1 = bool2;
    if (i1 != 0)
    {
      if (this.a.isOverscrollHeadVisiable()) {
        i1 = this.a.getScrollY() + i2;
      } else {
        i1 = i2;
      }
      i1 = this.a.pointToPosition(i3, i1);
      bool1 = bool2;
      if (i1 >= 0)
      {
        Object localObject = this.a;
        localObject = ((ChatXListView)localObject).getChildAt(i1 - ((ChatXListView)localObject).getFirstVisiblePosition());
        bool1 = bool2;
        if ((localObject instanceof BaseChatItemLayout))
        {
          bool2 = a(((BaseChatItemLayout)localObject).findViewById(2131430578), paramMotionEvent);
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isInterestedMotionEvent() is called. ev");
            ((StringBuilder)localObject).append(paramMotionEvent);
            ((StringBuilder)localObject).append("right to left touchPointInView = ");
            ((StringBuilder)localObject).append(bool2);
            ((StringBuilder)localObject).append(",curX=");
            ((StringBuilder)localObject).append(i3);
            ((StringBuilder)localObject).append(",curY=");
            ((StringBuilder)localObject).append(i2);
            ((StringBuilder)localObject).append(",motionPos=");
            ((StringBuilder)localObject).append(i1);
            QLog.d("LeftSwipeReplyHelper", 2, ((StringBuilder)localObject).toString());
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean e(ChatMessage paramChatMessage)
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
  
  private void f()
  {
    if (!g())
    {
      Object localObject = i();
      if (localObject != null)
      {
        ReportController.b(this.b.d, "dc00898", "", "", "0X800A92F", "0X800A92F", a((ChatMessage)localObject), c((ChatMessage)localObject), "", "", "", "");
        ((ReplyHelper)this.b.q(119)).a((ChatMessage)localObject, 0, 0L, null);
        if ((localObject instanceof MessageForStructing))
        {
          localObject = (MessageForStructing)localObject;
          if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 81) && (this.b.d != null)) {
            StoryReportor.a(this.b.d, this.b.e, (MessageForStructing)localObject, "reply");
          }
        }
      }
    }
  }
  
  private void f(ChatMessage paramChatMessage)
  {
    if (this.u != 2)
    {
      if (this.t == null)
      {
        localObject = this.b;
        if ((localObject != null) && (((BaseChatPie)localObject).d != null)) {
          this.t = ((MediaPlayerManager)this.b.d.getManager(QQManagerFactory.MGR_MEDIA_PLAYER));
        }
      }
      Object localObject = this.t;
      if ((localObject != null) && (((MediaPlayerManager)localObject).f() == paramChatMessage) && (this.t.g())) {
        this.u = 2;
      }
    }
  }
  
  private boolean g()
  {
    int i1 = this.b.ah.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 == 1)
    {
      bool1 = bool2;
      if (((TroopGagMgr)this.b.d.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.b.ah.b, true).b)
      {
        QQToast.makeText(this.b.d.getApp(), 2131895180, 0).show(this.b.e.getResources().getDimensionPixelSize(2131299920));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean h()
  {
    ChatMessage localChatMessage = i();
    boolean bool2 = e(localChatMessage);
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
  
  private ChatMessage i()
  {
    int i1 = this.p;
    if ((i1 >= 0) && (i1 < this.a.getAdapter().getCount()))
    {
      Object localObject = this.a.getAdapter().getItem(this.p);
      if ((localObject instanceof ChatMessage)) {
        return (ChatMessage)localObject;
      }
    }
    return null;
  }
  
  private boolean j()
  {
    if (this.u == 0)
    {
      this.u = 1;
      ChatMessage localChatMessage = i();
      if (((localChatMessage instanceof MessageForPtt)) && (((MessageForPtt)localChatMessage).playProgress > 0.0F)) {
        this.u = 2;
      }
      f(localChatMessage);
    }
    return this.u == 2;
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (paramView == this.k))
    {
      paramView = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      if ((paramView != null) && (paramView.l + 1 != this.p))
      {
        this.g = true;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSwipeItemReused value set :  true, motionPos -> ");
          localStringBuilder.append(this.p);
          localStringBuilder.append(", holder.pos -> ");
          localStringBuilder.append(paramView.l);
          QLog.d("LeftSwipeReplyHelper", 2, localStringBuilder.toString());
        }
        b();
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mSlideStartDir : ");
      localStringBuilder.append(this.m);
      localStringBuilder.append(", forceCloseSoftInput: ");
      localStringBuilder.append(this.r);
      QLog.d("hidePanelFromGesture", 2, localStringBuilder.toString());
    }
    if (this.r) {
      return true;
    }
    int i1 = this.m;
    if (i1 == 0) {
      return false;
    }
    return i1 != 1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (c(paramMotionEvent)) {
      return true;
    }
    if ((this.f) && (!BaseChatItemLayout.ad))
    {
      int i1 = (int)(paramMotionEvent.getX() + 0.5F);
      int i2 = (int)(paramMotionEvent.getY() + 0.5F);
      int i3 = paramMotionEvent.getAction();
      if (i3 != 0)
      {
        if (i3 != 1)
        {
          if (i3 != 2)
          {
            if (i3 != 3) {
              return false;
            }
            b();
            this.g = false;
            return false;
          }
          return a(i1, i2);
        }
        b();
        this.g = false;
        if (QLog.isColorLevel())
        {
          QLog.d("LeftSwipeReplyHelper", 2, "onInterceptTouchEvent ACTION_UP isSwipeItemReused value set : false");
          return false;
        }
      }
      else
      {
        a(paramMotionEvent, i1, i2);
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
  
  public void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (c(paramMotionEvent)) {
      return true;
    }
    if ((this.f) && (!BaseChatItemLayout.ad))
    {
      int i1 = (int)(paramMotionEvent.getX() + 0.5F);
      int i2 = (int)(paramMotionEvent.getY() + 0.5F);
      int i3 = paramMotionEvent.getAction();
      if (i3 != 0)
      {
        if (i3 != 1)
        {
          if (i3 != 2)
          {
            if (i3 != 3) {
              return false;
            }
            b();
            this.g = false;
            return false;
          }
          paramMotionEvent = c(i1, i2);
          if (paramMotionEvent != null) {
            return paramMotionEvent.booleanValue();
          }
        }
        else
        {
          b();
          this.g = false;
          if (QLog.isColorLevel())
          {
            QLog.d("LeftSwipeReplyHelper", 2, "onTouchEvent ACTION_UP isSwipeItemReused value set : false");
            return false;
          }
        }
      }
      else
      {
        this.s = false;
        this.h = i1;
        this.i = i2;
        this.j = i1;
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
    boolean bool = this.d.computeScrollOffset();
    float f1 = this.d.getCurrX();
    if ((this.s) && (this.o != null))
    {
      float f2 = a(f1);
      this.o.setAlpha(f2);
    }
    paramMessage = this.n;
    if (paramMessage != null)
    {
      int i1 = paramMessage.getScrollX();
      int i2 = (int)f1;
      if (i1 > i2)
      {
        this.n.scrollTo(i2, 0);
        this.a.invalidate();
      }
    }
    if (bool)
    {
      this.e.sendEmptyMessage(0);
      return false;
    }
    this.n = null;
    paramMessage = this.o;
    if (paramMessage != null) {
      paramMessage.setVisibility(4);
    }
    this.o = null;
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
        this.f = false;
        localObject = this.a;
        if (localObject != null) {
          ((ChatXListView)localObject).setOnTouchEventConsumer(null);
        }
        localObject = this.b;
        if ((localObject != null) && (((ChatDrawerHelper)((BaseChatPie)localObject).q(124)).a != null)) {
          ((ChatDrawerHelper)this.b.q(124)).a.b(this.x);
        }
      }
      else
      {
        this.a = this.b.U;
        localObject = this.b;
        if (((localObject instanceof FriendChatPie)) || ((localObject instanceof TroopChatPie)) || ((localObject instanceof DiscussChatPie))) {
          bool = true;
        }
        this.f = bool;
        if (this.b.d != null) {
          this.w = new LeftSwipeReplyHelper.ItemTypeUtil(this.b.d, null);
        }
        this.a.setOnTouchEventConsumer(this);
        ((ChatDrawerHelper)this.b.q(124)).a.a(this.x);
      }
    }
    else
    {
      this.b.bv().q().a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.LeftSwipeReplyHelper
 * JD-Core Version:    0.7.0.1
 */