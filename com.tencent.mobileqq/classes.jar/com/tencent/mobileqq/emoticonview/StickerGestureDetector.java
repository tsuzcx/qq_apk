package com.tencent.mobileqq.emoticonview;

import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StickerGestureDetector
  extends GestureDetector
{
  private static final String TAG = "StickerGestureDetector";
  int SCROLL_DOWN = 1;
  int SCROLL_STOP = 2;
  int SCROLL_UP = 0;
  double angle = 0.0D;
  StickerGestureDetector.StickerAnimationListener animationListener = new StickerGestureDetector.StickerAnimationListener(this, null);
  private ImageView cancel;
  Rect childRect = new Rect();
  double clicpXoffset = 0.0D;
  double clicpYoffset = 0.0D;
  Animator.AnimatorListener closeToMsgAnimationListener = new StickerGestureDetector.2(this);
  ImageView confirm;
  int currentChatPieType;
  View currentChooseLayout = null;
  int currentDismissMode;
  float density;
  float dismissFirstX;
  float dismissFirstY;
  float dismissSecondX;
  float dismissSecondY;
  public boolean enteredAIO = false;
  public View expandStickerView;
  Rect firstOrLastRect;
  int heightPaddingOffset;
  boolean isFirstUpInvoked = false;
  public boolean isInTowFingerMode = false;
  float lastDownX;
  float lastDownY;
  View lastIntersectChatLayout;
  View lastIntersectView;
  int lastMotionAction;
  int lastOutAction;
  float lastOutDownX;
  float lastOutDownY;
  public float lastX;
  public float lastY;
  int leftFinger = 0;
  int lowVersionOffset;
  BaseChatPie mBaseChatPie;
  public int mBottom;
  Context mContext;
  public int mLeft;
  int mRight;
  public TopGestureLayout mRootView;
  public int mTop;
  List<PointF> m_list_coords;
  Rect panelRect = new Rect();
  public EmojiStickerManager.StickerFrameLayout popupEmo;
  int rightFinger = 1;
  double scale = 1.0D;
  int screenWidth;
  boolean scrolling = false;
  double stickerHeight = 0.0D;
  int stickerReportType = 1;
  int stickerType = 0;
  double stickerWidth = 0.0D;
  int titleBarHeight;
  int widthPaddingOffset;
  
  public StickerGestureDetector(Context paramContext, GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramSimpleOnGestureListener);
    this.mBaseChatPie = paramBaseChatPie;
    if (this.mBaseChatPie != null)
    {
      if ((paramBaseChatPie instanceof FriendChatPie))
      {
        this.currentChatPieType = 1;
        this.mRootView = ((TopGestureLayout)this.mBaseChatPie.c);
      }
    }
    else
    {
      this.m_list_coords = new ArrayList();
      this.mContext = paramContext;
      this.density = paramContext.getResources().getDisplayMetrics().density;
      this.widthPaddingOffset = ((int)(this.density * 5.0F));
      this.heightPaddingOffset = ((int)(this.density * 5.0F));
      this.titleBarHeight = paramContext.getResources().getDimensionPixelOffset(2131299166);
      paramSimpleOnGestureListener = paramContext.getResources().getDisplayMetrics();
      this.screenWidth = paramSimpleOnGestureListener.widthPixels;
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label445;
      }
    }
    label445:
    for (int i = 0;; i = ImmersiveUtils.getStatusBarHeight(this.mContext))
    {
      this.lowVersionOffset = i;
      this.mLeft = this.mRootView.getLeft();
      this.mRight = this.mRootView.getRight();
      this.mTop = (ImmersiveUtils.getStatusBarHeight(paramContext) + this.titleBarHeight);
      this.mBottom = (paramSimpleOnGestureListener.heightPixels - this.lowVersionOffset);
      if (QLog.isColorLevel()) {
        QLog.i("StickerGestureDetector", 2, "line 8 mBottom = " + this.mBottom);
      }
      this.expandStickerView = new View(this.mContext);
      paramContext = new AbsListView.LayoutParams(-1, (int)(100.0F * this.density));
      this.expandStickerView.setLayoutParams(paramContext);
      this.firstOrLastRect = new Rect();
      return;
      if ((paramBaseChatPie instanceof BaseTroopChatPie))
      {
        this.currentChatPieType = 2;
        break;
      }
      if (!(paramBaseChatPie instanceof DiscussChatPie)) {
        break;
      }
      this.currentChatPieType = 3;
      break;
    }
  }
  
  private void judgeIfEnteredAIO(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MotionEvent paramMotionEvent, ListView paramListView, int paramInt)
  {
    if (paramMotionEvent.getRawY() < paramInt)
    {
      this.enteredAIO = true;
      EmojiStickerManager.jdField_a_of_type_Boolean = true;
      this.mBaseChatPie.o(true);
      this.mBottom = (this.mTop - this.lowVersionOffset + paramListView.getMeasuredHeight() - this.titleBarHeight);
      if (QLog.isColorLevel()) {
        QLog.i("StickerGestureDetector", 2, "line 3 mBottom = " + this.mBottom);
      }
      paramFloat2 = this.mBottom - this.popupEmo.getHeight();
      paramFloat4 = this.mBottom;
      stickerLayout((int)(paramFloat1 + 0.5D), (int)(paramFloat2 + 0.5D), (int)(paramFloat3 + 0.5D), (int)(paramFloat4 + 0.5D));
      stickerButtonAnimation(true);
    }
    do
    {
      return;
      this.mRootView.post(new StickerGestureDetector.3(this));
      EmojiStickerManager.jdField_a_of_type_Boolean = false;
      this.mBaseChatPie.o(false);
      this.mBaseChatPie.aS();
      changeBubbleBg(this.lastIntersectView, false);
      if ((this.lastIntersectChatLayout != null) && ((this.lastIntersectChatLayout instanceof BaseChatItemLayout))) {
        ((BaseChatItemLayout)this.lastIntersectChatLayout).setStickerPressStatus(false);
      }
      EmojiStickerManager.b = false;
      removeStickerMaskLayout();
      this.enteredAIO = false;
      this.isFirstUpInvoked = false;
      this.mBottom = this.mRootView.getBottom();
      this.scale = 1.0D;
      this.angle = 0.0D;
    } while (!QLog.isColorLevel());
    QLog.i("StickerGestureDetector", 2, "line 4 mBottom = " + this.mBottom);
  }
  
  private String makeSmallEmojiString(SmallEmoticonInfo paramSmallEmoticonInfo)
  {
    if (paramSmallEmoticonInfo.emoticon == null)
    {
      QLog.e("StickerGestureDetector", 1, "makeSmallEmojiString, emotion == null");
      return "";
    }
    if (this.mBaseChatPie != null) {
      try
      {
        int i = Integer.parseInt(paramSmallEmoticonInfo.emoticon.eId);
        int j = Integer.parseInt(paramSmallEmoticonInfo.emoticon.epId);
        paramSmallEmoticonInfo = EmosmUtils.a(j, i);
        EmoticonPackage localEmoticonPackage = ((EmoticonManager)this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(String.valueOf(j));
        char[] arrayOfChar = new char[5];
        arrayOfChar[0] = '\024';
        arrayOfChar[1] = paramSmallEmoticonInfo[3];
        arrayOfChar[2] = paramSmallEmoticonInfo[2];
        arrayOfChar[3] = paramSmallEmoticonInfo[1];
        arrayOfChar[4] = paramSmallEmoticonInfo[0];
        if ((localEmoticonPackage != null) && (localEmoticonPackage.isAPNG == 2)) {
          arrayOfChar[1] = 'ǿ';
        }
        paramSmallEmoticonInfo = new StringBuilder(String.valueOf(arrayOfChar));
        EmojiStickerManager.a(paramSmallEmoticonInfo);
        return paramSmallEmoticonInfo.toString();
      }
      catch (NumberFormatException paramSmallEmoticonInfo)
      {
        VasReportUtils.a("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
        QLog.e("StickerGestureDetector", 1, "fail to send small_emotion. id is not Int.");
        return "";
      }
    }
    return "";
  }
  
  private void showOpenVip()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerGestureDetector", 2, "showOpenVip invoked");
    }
    DialogUtil.a(this.mContext, 230).setTitle(HardCodeUtil.a(2131714265)).setMessage(HardCodeUtil.a(2131714258)).setPositiveButton(HardCodeUtil.a(2131714264), new StickerGestureDetector.5(this)).setNegativeButton("取消", new StickerGestureDetector.4(this)).show();
    int i;
    if (this.mBaseChatPie != null)
    {
      if (EmojiStickerManager.a().jdField_a_of_type_Int != 0) {
        break label147;
      }
      i = 1;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "SVIPTip", String.valueOf(i), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
      label147:
      if (EmojiStickerManager.a().jdField_a_of_type_Int == 1) {
        i = 2;
      } else if (EmojiStickerManager.a().jdField_a_of_type_Int == 3000) {
        i = 3;
      } else {
        i = -1;
      }
    }
  }
  
  void caclLeftAndRightOffset(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getX(this.leftFinger) - this.dismissFirstX;
    float f1 = paramMotionEvent.getX(this.rightFinger) - this.dismissSecondX;
    this.dismissFirstX = paramMotionEvent.getX(this.leftFinger);
    this.dismissSecondX = paramMotionEvent.getX(this.rightFinger);
    int i;
    label110:
    Object localObject1;
    if (f2 * f1 < 0.0F) {
      if (f2 < 0.0F)
      {
        i = EmojiStickerManager.jdField_g_of_type_Int;
        this.currentDismissMode = i;
        if ((this.mBaseChatPie == null) || (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
          break label420;
        }
        paramMotionEvent = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
        i = paramMotionEvent.getChildCount() - 1;
        if (i < 0) {
          break label420;
        }
        localObject1 = paramMotionEvent.getChildAt(i);
        if (!(localObject1 instanceof BaseChatItemLayout)) {
          break label246;
        }
        localObject1 = (BaseChatItemLayout)localObject1;
        if (this.currentDismissMode != EmojiStickerManager.jdField_g_of_type_Int) {
          break label205;
        }
        f2 = Math.min(0.0F, f2);
        f1 = Math.max(0.0F, f1);
        ((BaseChatItemLayout)localObject1).a((int)Math.abs(f2 - f1), this.currentDismissMode);
      }
    }
    label420:
    label421:
    for (;;)
    {
      label176:
      float f3 = f2;
      float f4 = f1;
      label205:
      label246:
      int j;
      do
      {
        do
        {
          i -= 1;
          f1 = f4;
          f2 = f3;
          break label110;
          i = EmojiStickerManager.h;
          break;
          if (this.currentDismissMode != EmojiStickerManager.h) {
            break label421;
          }
          f2 = Math.max(0.0F, f2);
          f1 = Math.min(0.0F, f1);
          ((BaseChatItemLayout)localObject1).a((int)Math.abs(f2 - f1), this.currentDismissMode);
          break label176;
          f4 = f1;
          f3 = f2;
        } while (!(localObject1 instanceof LinearLayout));
        j = ((LinearLayout)localObject1).getChildCount() - 1;
        f4 = f1;
        f3 = f2;
      } while (j < 0);
      Object localObject2 = ((LinearLayout)localObject1).getChildAt(j);
      f4 = f1;
      f3 = f2;
      if ((localObject2 instanceof StickerGrayTipLayout))
      {
        localObject2 = (StickerGrayTipLayout)localObject2;
        if (this.currentDismissMode == EmojiStickerManager.jdField_g_of_type_Int)
        {
          f2 = Math.min(0.0F, f2);
          f1 = Math.max(0.0F, f1);
          ((StickerGrayTipLayout)localObject2).doDismiss((int)Math.abs(f2 - f1), this.currentDismissMode);
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        f4 = f1;
        f3 = f2;
        if (this.currentDismissMode == EmojiStickerManager.h)
        {
          f3 = Math.max(0.0F, f2);
          f4 = Math.min(0.0F, f1);
          ((StickerGrayTipLayout)localObject2).doDismiss((int)Math.abs(f3 - f4), this.currentDismissMode);
        }
        f1 = f4;
        f2 = f3;
      }
      return;
    }
  }
  
  void calcAngleScale()
  {
    int i = this.m_list_coords.size();
    if (i < 4) {
      return;
    }
    PointF localPointF1 = (PointF)this.m_list_coords.get(i - 4);
    PointF localPointF2 = (PointF)this.m_list_coords.get(i - 3);
    PointF localPointF3 = (PointF)this.m_list_coords.get(i - 2);
    PointF localPointF4 = (PointF)this.m_list_coords.get(i - 1);
    if (getLineLength(localPointF1, localPointF3) + getLineLength(localPointF2, localPointF4) < 5.0D)
    {
      this.m_list_coords.remove(i - 1);
      this.m_list_coords.remove(i - 2);
      return;
    }
    PointF localPointF5 = new PointF(localPointF2.x - localPointF1.x, localPointF2.y - localPointF1.y);
    PointF localPointF6 = new PointF(localPointF4.x - localPointF3.x, localPointF4.y - localPointF3.y);
    double d3 = getLineLength(localPointF5);
    double d4 = getLineLength(localPointF6);
    double d2 = (localPointF5.x * localPointF6.x + localPointF5.y * localPointF6.y) / (d3 * d4);
    double d1 = d2;
    if (d2 > 1.0D) {
      d1 = 1.0D;
    }
    d1 = Math.acos(d1) * 180.0D / 3.14D;
    localPointF5.x = ((float)(localPointF5.x / d3));
    localPointF5.y = ((float)(localPointF5.y / d3));
    localPointF6.x = ((float)(localPointF6.x / d4));
    localPointF6.y = ((float)(localPointF6.y / d4));
    localPointF6 = new PointF(localPointF6.y, -localPointF6.x);
    float f1 = localPointF5.x;
    float f2 = localPointF6.x;
    if (localPointF5.y * localPointF6.y + f1 * f2 > 0.0F)
    {
      this.angle = (d1 + this.angle);
      if (this.angle >= 360.0D) {
        this.angle -= 360.0D;
      }
      if (this.angle < 0.0D) {
        this.angle += 360.0D;
      }
      d1 = getLineLength(localPointF1, localPointF2);
      d2 = getLineLength(localPointF3, localPointF4);
      if ((d1 >= 5.0D) && (d2 >= 5.0D)) {
        this.scale = (d2 / d1 * this.scale);
      }
      if (this.stickerType != 1) {
        break label542;
      }
      if (this.scale > 1.0D) {
        this.scale = 1.0D;
      }
      if (this.scale < 0.6000000238418579D) {
        this.scale = 0.6000000238418579D;
      }
    }
    for (;;)
    {
      showResult();
      return;
      d1 = -d1;
      break;
      label542:
      if (this.stickerType == 0)
      {
        if (this.scale > 1.6D) {
          this.scale = 1.6D;
        }
        if (this.scale < 1.0D) {
          this.scale = 1.0D;
        }
      }
    }
  }
  
  void changeBubbleBg(View paramView, boolean paramBoolean)
  {
    BubbleInfo localBubbleInfo;
    boolean bool;
    if (paramView != null)
    {
      localBubbleInfo = (BubbleInfo)paramView.getTag(2131364199);
      localObject = (ChatMessage)paramView.getTag(2131364681);
      bool = false;
      if (localObject != null) {
        bool = ((ChatMessage)localObject).isSend();
      }
      if (localBubbleInfo != null)
      {
        localObject = paramView.getBackground();
        if ((localObject == null) || (!(localObject instanceof VipBubbleDrawable))) {
          break label77;
        }
        ((VipBubbleDrawable)localObject).b(paramBoolean);
      }
    }
    label77:
    while (localObject == null) {
      return;
    }
    Object localObject = this.mContext.getResources();
    if (!paramBoolean)
    {
      if (bool) {}
      for (i = 2130850408;; i = 2130850232)
      {
        localObject = ((Resources)localObject).getDrawable(i);
        label112:
        if (localObject == null) {
          break;
        }
        localBubbleInfo.a(paramView, (Drawable)localObject);
        return;
      }
    }
    if (bool) {}
    for (int i = 2130850409;; i = 2130850233)
    {
      localObject = ((Resources)localObject).getDrawable(i);
      break label112;
      break;
    }
  }
  
  View findBiggestIntersectAreaView(int paramInt1, int paramInt2, Rect paramRect, ViewGroup paramViewGroup)
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
    {
      localObject = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if (!this.enteredAIO) {
        if (paramInt1 <= this.mTop - this.lowVersionOffset + ((ChatXListView)localObject).getMeasuredHeight() - this.titleBarHeight)
        {
          i = this.mTop;
          j = this.lowVersionOffset;
          if (paramInt2 <= ((ChatXListView)localObject).getMeasuredHeight() + (i - j) - this.titleBarHeight) {}
        }
        else
        {
          return null;
        }
      }
    }
    int j = 9999999;
    Object localObject = paramRect;
    if (paramRect == null) {
      localObject = new Rect();
    }
    int i = paramViewGroup.getChildCount() - 1;
    int m = -1;
    int k;
    int n;
    if (i >= 0)
    {
      paramViewGroup.getChildAt(i).getGlobalVisibleRect((Rect)localObject);
      k = Math.abs(paramInt1 - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      n = Math.abs(paramInt2 - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      if (k - n < 0)
      {
        label190:
        if (k >= j) {
          break label299;
        }
        m = i;
      }
    }
    for (;;)
    {
      i -= 1;
      j = k;
      break;
      k = n;
      break label190;
      if (m != -1)
      {
        paramRect = paramViewGroup.getChildAt(m);
        paramRect.getGlobalVisibleRect((Rect)localObject);
        if (m == 0) {
          ((Rect)localObject).top = (((Rect)localObject).bottom - paramRect.getHeight());
        }
      }
      for (;;)
      {
        return paramRect;
        if (m == paramViewGroup.getChildCount() - 1) {
          ((Rect)localObject).bottom = (((Rect)localObject).top + paramRect.getHeight());
        }
        continue;
        paramRect = null;
      }
      label299:
      k = j;
    }
  }
  
  View findBiggestIntersectAreaView(int paramInt, Rect paramRect, ViewGroup paramViewGroup)
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
    {
      localObject = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if (!this.enteredAIO)
      {
        i = this.mTop;
        j = this.lowVersionOffset;
        if (paramInt > ((ChatXListView)localObject).getMeasuredHeight() + (i - j) - this.titleBarHeight) {
          return null;
        }
      }
    }
    int j = 9999999;
    Object localObject = paramRect;
    if (paramRect == null) {
      localObject = new Rect();
    }
    int i = paramViewGroup.getChildCount() - 1;
    int k = -1;
    if (i >= 0)
    {
      paramViewGroup.getChildAt(i).getGlobalVisibleRect((Rect)localObject);
      int m = Math.abs(paramInt - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      if (m >= j) {
        break label236;
      }
      k = i;
      j = m;
    }
    label236:
    for (;;)
    {
      i -= 1;
      break;
      if (k != -1)
      {
        paramRect = paramViewGroup.getChildAt(k);
        paramRect.getGlobalVisibleRect((Rect)localObject);
        if (k == 0) {
          ((Rect)localObject).top = (((Rect)localObject).bottom - paramRect.getHeight());
        }
      }
      for (;;)
      {
        return paramRect;
        if (k == paramViewGroup.getChildCount() - 1) {
          ((Rect)localObject).bottom = (((Rect)localObject).top + paramRect.getHeight());
        }
        continue;
        paramRect = null;
      }
    }
  }
  
  double getLineLength(PointF paramPointF)
  {
    return Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
  }
  
  double getLineLength(PointF paramPointF1, PointF paramPointF2)
  {
    return Math.sqrt((paramPointF1.x - paramPointF2.x) * (paramPointF1.x - paramPointF2.x) + (paramPointF1.y - paramPointF2.y) * (paramPointF1.y - paramPointF2.y));
  }
  
  boolean havePopuoEmo()
  {
    if (this.mRootView != null)
    {
      int i = this.mRootView.getChildCount() - 1;
      while (i >= 0)
      {
        Object localObject = this.mRootView.getChildAt(i);
        if (((View)localObject).getId() == 2131374517)
        {
          this.popupEmo = ((EmojiStickerManager.StickerFrameLayout)localObject);
          this.confirm = ((ImageView)this.popupEmo.findViewById(2131362396));
          this.cancel = ((ImageView)this.popupEmo.findViewById(2131362395));
          localObject = this.popupEmo.getTag();
          double d;
          if (((localObject instanceof PicEmoticonInfo)) || ((localObject instanceof Emoticon)) || ((localObject instanceof FavoriteEmoticonInfo)))
          {
            this.stickerType = 1;
            this.stickerWidth = (100.0F * this.density);
            this.stickerHeight = (100.0F * this.density);
            this.widthPaddingOffset = ((int)(this.density * 5.0F));
            this.heightPaddingOffset = ((int)(this.density * 5.0F));
            localObject = this.popupEmo.a();
            d = ((ImageView)localObject).getDrawable().getIntrinsicWidth() / ((ImageView)localObject).getDrawable().getIntrinsicHeight();
            if (d <= 1.0D) {
              break label318;
            }
            this.stickerHeight = (this.stickerWidth / d);
            this.clicpXoffset = 0.0D;
          }
          for (this.clicpYoffset = ((this.stickerWidth - this.stickerHeight) / 2.0D);; this.clicpYoffset = 0.0D)
          {
            return true;
            if ((!(localObject instanceof SystemAndEmojiEmoticonInfo)) && (!(localObject instanceof SmallEmoticonInfo))) {
              break;
            }
            this.stickerType = 0;
            this.stickerWidth = (this.density * 28.0F);
            this.stickerHeight = (this.density * 28.0F);
            this.widthPaddingOffset = ((int)(this.density * 41.0F));
            this.heightPaddingOffset = ((int)(this.density * 41.0F));
            break;
            label318:
            this.stickerWidth = (d * this.stickerHeight);
            this.clicpXoffset = ((this.stickerHeight - this.stickerWidth) / 2.0D);
          }
        }
        i -= 1;
      }
    }
    return false;
  }
  
  boolean isInAllowedArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Rect paramRect)
  {
    paramInt2 = paramInt3 - paramInt1;
    paramInt3 = paramRect.width();
    paramInt4 = (paramInt3 + paramInt2) / 2;
    int i = paramRect.left;
    return Math.abs(paramInt3 / 2 + i - paramInt1 - paramInt2 / 2) <= paramInt4;
  }
  
  boolean isInAllowedArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    paramInt2 = paramInt3 - paramInt1;
    paramInt3 = paramView.getWidth();
    paramInt4 = (paramInt3 + paramInt2) / 2;
    int i = paramView.getLeft();
    return Math.abs(paramInt3 / 2 + i - paramInt1 - paramInt2 / 2) <= paramInt4;
  }
  
  boolean isMovedOnCancel(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.cancel != null)
    {
      Rect localRect = new Rect();
      this.cancel.getGlobalVisibleRect(localRect);
      bool1 = bool2;
      if (paramFloat1 >= localRect.left)
      {
        bool1 = bool2;
        if (paramFloat1 <= localRect.right)
        {
          bool1 = bool2;
          if (paramFloat2 >= localRect.top)
          {
            bool1 = bool2;
            if (paramFloat2 <= localRect.bottom) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  boolean isMovedOnConfirm(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.confirm != null)
    {
      Rect localRect = new Rect();
      this.confirm.getGlobalVisibleRect(localRect);
      bool1 = bool2;
      if (paramFloat1 >= localRect.left)
      {
        bool1 = bool2;
        if (paramFloat1 <= localRect.right)
        {
          bool1 = bool2;
          if (paramFloat2 >= localRect.top)
          {
            bool1 = bool2;
            if (paramFloat2 <= localRect.bottom) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  boolean isTouchedAboveAIOArea(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) < 50.0D) && (paramFloat2 < this.mBottom) && (paramFloat2 > this.mTop);
  }
  
  boolean isTouchedAboveCancel(float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.cancel != null)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = new Rect();
      this.cancel.getGlobalVisibleRect(paramMotionEvent);
      bool1 = bool2;
      if (f1 >= paramMotionEvent.left)
      {
        bool1 = bool2;
        if (f1 <= paramMotionEvent.right)
        {
          bool1 = bool2;
          if (f2 >= paramMotionEvent.top)
          {
            bool1 = bool2;
            if (f2 <= paramMotionEvent.bottom)
            {
              bool1 = bool2;
              if (paramFloat1 >= paramMotionEvent.left)
              {
                bool1 = bool2;
                if (paramFloat1 <= paramMotionEvent.right)
                {
                  bool1 = bool2;
                  if (paramFloat2 >= paramMotionEvent.top)
                  {
                    bool1 = bool2;
                    if (paramFloat2 <= paramMotionEvent.bottom) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  boolean isTouchedAboveConfirm(float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.confirm != null)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = new Rect();
      this.confirm.getGlobalVisibleRect(paramMotionEvent);
      bool1 = bool2;
      if (f1 >= paramMotionEvent.left)
      {
        bool1 = bool2;
        if (f1 <= paramMotionEvent.right)
        {
          bool1 = bool2;
          if (f2 >= paramMotionEvent.top)
          {
            bool1 = bool2;
            if (f2 <= paramMotionEvent.bottom)
            {
              bool1 = bool2;
              if (paramFloat1 >= paramMotionEvent.left)
              {
                bool1 = bool2;
                if (paramFloat1 <= paramMotionEvent.right)
                {
                  bool1 = bool2;
                  if (paramFloat2 >= paramMotionEvent.top)
                  {
                    bool1 = bool2;
                    if (paramFloat2 <= paramMotionEvent.bottom) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  boolean isTouchedAboveEmotion(float paramFloat1, float paramFloat2)
  {
    if (this.popupEmo != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        if ((paramFloat1 < this.popupEmo.getLeft()) || (paramFloat1 > this.popupEmo.getRight()) || (paramFloat2 < this.popupEmo.getTop()) || (paramFloat2 > this.popupEmo.getBottom()) || (isMovedOnCancel(paramFloat1, paramFloat2)) || (isMovedOnConfirm(paramFloat1, paramFloat2))) {}
      }
      while ((paramFloat1 >= this.popupEmo.getLeft()) && (paramFloat1 <= this.popupEmo.getRight()) && (paramFloat2 >= this.popupEmo.getTop() + this.lowVersionOffset) && (paramFloat2 <= this.popupEmo.getBottom() + this.lowVersionOffset) && (!isMovedOnCancel(paramFloat1, paramFloat2)) && (!isMovedOnConfirm(paramFloat1, paramFloat2)))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  boolean isTouchedAboveEmotionWithButtons(float paramFloat1, float paramFloat2)
  {
    if (this.popupEmo != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        if ((paramFloat1 < this.popupEmo.getLeft()) || (paramFloat1 > this.popupEmo.getRight()) || (paramFloat2 < this.popupEmo.getTop()) || (paramFloat2 > this.popupEmo.getBottom())) {}
      }
      while ((paramFloat1 >= this.popupEmo.getLeft()) && (paramFloat1 <= this.popupEmo.getRight()) && (paramFloat2 >= this.popupEmo.getTop() + this.lowVersionOffset) && (paramFloat2 <= this.popupEmo.getBottom() + this.lowVersionOffset))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  boolean isTouchedAboveOutsideArea(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) < 50.0D) && ((paramFloat2 > this.mBottom) || (paramFloat2 < this.mTop));
  }
  
  void makeToast(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerGestureDetector", 2, "makeToast, content = " + paramString);
    }
    QQToast.a(this.mContext, paramString, 0).b(this.mContext.getResources().getDimensionPixelSize(2131299166));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject1;
    if (this.mBaseChatPie != null)
    {
      localObject1 = AIOEmoticonUIHelper.a(this.mBaseChatPie);
      if ((localObject1 != null) && (((EmoticonMainPanel)localObject1).showStickerGuide) && (this.mRootView != null))
      {
        localObject1 = this.mRootView.findViewById(2131374552);
        if (localObject1 != null) {
          return ((View)localObject1).onTouchEvent(paramMotionEvent);
        }
      }
    }
    if ((EmojiStickerManager.jdField_d_of_type_Boolean) && (this.mRootView != null))
    {
      localObject1 = this.mRootView.findViewById(2131374551);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    if ((EmojiStickerManager.jdField_e_of_type_Boolean) && (this.mRootView != null))
    {
      localObject1 = this.mRootView.findViewById(2131374554);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    int i = paramMotionEvent.getPointerCount();
    float f3;
    float f2;
    float f4;
    float f5;
    label492:
    float f1;
    Object localObject3;
    Object localObject2;
    label1258:
    label1264:
    label1395:
    int j;
    label1625:
    boolean bool5;
    boolean bool1;
    boolean bool3;
    boolean bool4;
    boolean bool2;
    boolean bool6;
    int n;
    int i2;
    int m;
    int i1;
    int i6;
    int i7;
    int k;
    int i3;
    int i8;
    int i5;
    int i4;
    label2234:
    label2246:
    label2271:
    ChatXListView localChatXListView;
    int i10;
    int i11;
    BaseChatItemLayout localBaseChatItemLayout;
    int i9;
    if (i == 1)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.lastX = paramMotionEvent.getRawX();
        this.lastY = paramMotionEvent.getRawY();
        this.isInTowFingerMode = false;
      }
      if (havePopuoEmo())
      {
        f3 = this.popupEmo.getLeft();
        f2 = this.popupEmo.getTop();
        f4 = this.popupEmo.getRight();
        f5 = this.popupEmo.getBottom();
        if ((isTouchedAboveEmotionWithButtons(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) || (!this.isFirstUpInvoked))
        {
          switch (paramMotionEvent.getAction())
          {
          default: 
          case 0: 
          case 2: 
            for (;;)
            {
              return true;
              this.lastMotionAction = 0;
              if (QLog.isColorLevel()) {
                QLog.d("StickerGestureDetector", 2, "event = " + paramMotionEvent.getAction());
              }
              this.lastX = paramMotionEvent.getRawX();
              this.lastY = paramMotionEvent.getRawY();
              this.lastDownX = this.lastX;
              this.lastDownY = this.lastY;
              return (isTouchedAboveEmotionWithButtons(this.lastX, this.lastY)) || (!this.isFirstUpInvoked);
              if (QLog.isColorLevel()) {
                QLog.d("StickerGestureDetector", 2, "event = " + paramMotionEvent.getAction());
              }
              if ((this.popupEmo != null) && ((isTouchedAboveEmotion(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) || (!this.isFirstUpInvoked)))
              {
                if ((this.mBaseChatPie != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
                {
                  localObject1 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                  if (f5 > this.mTop + ((ChatXListView)localObject1).getMeasuredHeight() - this.lowVersionOffset - this.titleBarHeight) {
                    break label1258;
                  }
                  i = 1;
                  if (this.enteredAIO) {
                    break label1264;
                  }
                  if (i != 0)
                  {
                    this.enteredAIO = true;
                    if (this.isFirstUpInvoked) {
                      this.mBottom = (this.mTop - this.lowVersionOffset + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight);
                    }
                    if (QLog.isColorLevel()) {
                      QLog.i("StickerGestureDetector", 2, "1 mBottom = " + this.mBottom + " isFirstUpInvoked = " + this.isFirstUpInvoked);
                    }
                  }
                }
                for (;;)
                {
                  float f7 = paramMotionEvent.getRawX() - this.lastX;
                  float f8 = paramMotionEvent.getRawY() - this.lastY;
                  f3 += f7;
                  f5 = f2 + f8;
                  f1 = this.popupEmo.getWidth() + f3;
                  float f6 = this.popupEmo.getHeight() + f5;
                  if (QLog.isColorLevel()) {
                    QLog.i("StickerGestureDetector", 2, "sticker move OLD, left = " + f3 + " top = " + f5 + " right = " + f1 + " bottom = " + f6 + " distanceX = " + f7 + " distanceY = " + f8);
                  }
                  f2 = f3;
                  if (f3 < this.mLeft)
                  {
                    f2 = this.mLeft;
                    f1 = this.popupEmo.getWidth() + f2;
                  }
                  f3 = f1;
                  f4 = f2;
                  if (f1 > this.mRight)
                  {
                    f3 = this.mRight;
                    f4 = f3 - this.popupEmo.getWidth();
                  }
                  f1 = f6;
                  f2 = f5;
                  if (f5 < this.mTop - this.lowVersionOffset)
                  {
                    f2 = this.mTop - this.lowVersionOffset;
                    f1 = this.popupEmo.getHeight() + f2;
                  }
                  f5 = f1;
                  if (f1 > this.mBottom)
                  {
                    f5 = this.mBottom;
                    f2 = f5 - this.popupEmo.getHeight();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("StickerGestureDetector", 2, "sticker move NEW, left = " + f4 + " top = " + f2 + " right = " + f3 + " bottom = " + f5 + " distanceX = " + f7 + " distanceY = " + f8);
                  }
                  if ((this.mRootView != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
                  {
                    localObject3 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                    i = (int)((1.0D - this.scale) * this.stickerWidth / 2.0D);
                    i = (int)((1.0D - this.scale) * this.stickerHeight / 2.0D);
                    localObject2 = findBiggestIntersectAreaView((int)paramMotionEvent.getRawY(), this.childRect, (ViewGroup)localObject3);
                    localObject1 = localObject2;
                    if (!(localObject2 instanceof BaseChatItemLayout)) {
                      localObject1 = findBiggestIntersectAreaView((int)((f2 + f5) / 2.0F), this.childRect, (ViewGroup)localObject3);
                    }
                    localObject2 = localObject1;
                    if (!(localObject1 instanceof BaseChatItemLayout)) {
                      localObject2 = findBiggestIntersectAreaView((int)f2, (int)f5, this.childRect, (ViewGroup)localObject3);
                    }
                    if (localObject2 != null) {
                      this.currentChooseLayout = ((View)localObject2);
                    }
                    this.lastIntersectChatLayout = ((View)localObject2);
                  }
                  if (this.popupEmo.getWidth() == (int)(110.0F * this.density)) {
                    stickerLayout((int)(f4 + 0.5D), (int)(f2 + 0.5D), (int)(f3 + 0.5D), (int)(f5 + 0.5D));
                  }
                  this.lastX = paramMotionEvent.getRawX();
                  this.lastY = paramMotionEvent.getRawY();
                  if ((this.mBaseChatPie == null) || (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
                    break;
                  }
                  paramMotionEvent = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                  if (Math.abs(f2 - this.mTop + this.lowVersionOffset) >= 15.0F) {
                    break label1395;
                  }
                  if (this.scrolling) {
                    break;
                  }
                  setSmoothScrollMode(paramMotionEvent, this.SCROLL_UP);
                  break;
                  i = 0;
                  break label492;
                  if (i == 0) {
                    this.enteredAIO = false;
                  }
                  if (this.isFirstUpInvoked)
                  {
                    if (((this.cancel != null) && (this.cancel.getVisibility() != 0)) || ((this.confirm != null) && (this.confirm.getVisibility() != 0))) {
                      stickerButtonAnimation(true);
                    }
                    this.mBottom = (this.mTop - this.lowVersionOffset + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("StickerGestureDetector", 2, "2 mBottom = " + this.mBottom + " isFirstUpInvoked = " + this.isFirstUpInvoked);
                  }
                }
                if (Math.abs(f5 - this.mBottom) < 15.0F)
                {
                  if (!this.scrolling) {
                    setSmoothScrollMode(paramMotionEvent, this.SCROLL_DOWN);
                  }
                }
                else {
                  setSmoothScrollMode(paramMotionEvent, this.SCROLL_STOP);
                }
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("StickerGestureDetector", 2, "event = " + paramMotionEvent.getAction());
          }
          if ((!this.isFirstUpInvoked) && (this.enteredAIO) && (this.mBaseChatPie != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
          {
            localObject1 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
            EmojiStickerManager.jdField_a_of_type_Boolean = true;
            this.mBaseChatPie.o(true);
            stickerButtonAnimation(true);
            i = this.mTop;
            j = this.lowVersionOffset;
            this.mBottom = (((ChatXListView)localObject1).getMeasuredHeight() + (i - j) - this.titleBarHeight);
            if (QLog.isColorLevel()) {
              QLog.i("StickerGestureDetector", 2, "10 mBottom = " + this.mBottom);
            }
            localObject1 = this.popupEmo.getTag();
            if ((localObject1 instanceof PicEmoticonInfo))
            {
              this.stickerReportType = 5;
              VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "DragToAIO", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", String.valueOf(this.stickerType), "", "", "", 0, 0, 0, 0);
            }
          }
          else
          {
            this.isFirstUpInvoked = true;
            if ((!this.enteredAIO) && (this.mRootView != null) && (this.mBaseChatPie != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
            {
              localObject1 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
              localObject2 = AIOEmoticonUIHelper.a(this.mBaseChatPie);
              if (localObject2 == null) {
                break label2246;
              }
              ((EmoticonMainPanel)localObject2).getGlobalVisibleRect(this.panelRect);
              if ((this.panelRect.top != 0) || (this.panelRect.bottom != 0)) {
                break label2234;
              }
              i = this.mTop - this.lowVersionOffset + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight;
            }
          }
          for (;;)
          {
            judgeIfEnteredAIO(f3, f2, f4, f5, paramMotionEvent, (ListView)localObject1, i);
            if ((this.mBaseChatPie != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
              setSmoothScrollMode(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.SCROLL_STOP);
            }
            bool5 = false;
            bool1 = false;
            bool3 = false;
            bool4 = false;
            bool2 = false;
            bool6 = false;
            n = 0;
            i2 = 0;
            m = 0;
            i1 = 0;
            i6 = 0;
            j = 0;
            i7 = 0;
            k = 0;
            i3 = 0;
            f1 = 0.0F;
            i8 = 0;
            i5 = 0;
            i4 = 0;
            if (this.lastMotionAction != 0) {
              break;
            }
            if (!isTouchedAboveCancel(this.lastDownX, this.lastDownY, paramMotionEvent)) {
              break label2271;
            }
            if (QLog.isColorLevel()) {
              QLog.i("StickerGestureDetector", 2, "isTouchedAboveCancel invoked");
            }
            EmojiStickerManager.jdField_a_of_type_Boolean = false;
            this.mBaseChatPie.o(false);
            this.mBaseChatPie.c(false, false);
            this.enteredAIO = false;
            this.isFirstUpInvoked = false;
            this.mBottom = this.mRootView.getBottom();
            if (QLog.isColorLevel()) {
              QLog.i("StickerGestureDetector", 2, "line 5 mBottom = " + this.mBottom);
            }
            playDismissAnimation(f3, f2);
            i = 4;
            if ((this.popupEmo.getTag(2131374553) instanceof Integer)) {
              i = ((Integer)this.popupEmo.getTag(2131374553)).intValue();
            }
            if ((i == 4) && (this.mBaseChatPie != null)) {
              this.mBaseChatPie.aQ();
            }
            VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "CancelSend", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
            return true;
            if ((localObject1 instanceof Emoticon))
            {
              this.stickerReportType = 1;
              break label1625;
            }
            if ((localObject1 instanceof SystemAndEmojiEmoticonInfo))
            {
              localObject1 = (SystemAndEmojiEmoticonInfo)localObject1;
              if (((SystemAndEmojiEmoticonInfo)localObject1).emotionType == 1)
              {
                this.stickerReportType = 2;
                break label1625;
              }
              if (((SystemAndEmojiEmoticonInfo)localObject1).emotionType != 2) {
                break label1625;
              }
              this.stickerReportType = 3;
              break label1625;
            }
            if ((localObject1 instanceof SmallEmoticonInfo))
            {
              this.stickerReportType = 4;
              break label1625;
            }
            if (!(localObject1 instanceof FavoriteEmoticonInfo)) {
              break label1625;
            }
            this.stickerReportType = 5;
            break label1625;
            i = this.panelRect.top;
            continue;
            i = this.mTop - this.lowVersionOffset + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight;
          }
          if (isTouchedAboveConfirm(this.lastDownX, this.lastDownY, paramMotionEvent))
          {
            if (QLog.isColorLevel()) {
              QLog.i("StickerGestureDetector", 2, "isTouchedAboveConfirm invoked");
            }
            MobileReportManager.getInstance().reportAction("tie_emoji", "4", "platform898", "6", "3", 102, 1, System.currentTimeMillis());
            if (this.mRootView != null)
            {
              i = 4;
              if ((this.popupEmo.getTag(2131374553) instanceof Integer)) {
                i = ((Integer)this.popupEmo.getTag(2131374553)).intValue();
              }
              if ((i == 3) && (!VipUtils.b(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
              {
                showOpenVip();
                return true;
              }
              if ((i == 4) && (this.mBaseChatPie != null)) {
                this.mBaseChatPie.aQ();
              }
              if (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
              {
                localChatXListView = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                i10 = (int)((this.scale - 1.0D) * this.stickerWidth / 2.0D);
                i11 = (int)((this.scale - 1.0D) * this.stickerHeight / 2.0D);
                localObject1 = this.currentChooseLayout;
                paramMotionEvent = (MotionEvent)localObject1;
                if (localObject1 == null) {
                  paramMotionEvent = findBiggestIntersectAreaView((int)((f2 + f5) / 2.0F), this.childRect, localChatXListView);
                }
                if (!(paramMotionEvent instanceof BaseChatItemLayout)) {
                  break label6225;
                }
                localBaseChatItemLayout = (BaseChatItemLayout)paramMotionEvent;
                if ((!localBaseChatItemLayout.g()) || (!this.enteredAIO)) {
                  break label6086;
                }
                i8 = 0;
                i9 = 0;
                i3 = this.childRect.top;
                i4 = this.childRect.bottom;
                if (localBaseChatItemLayout.getTop() >= this.titleBarHeight) {
                  break label7873;
                }
                i3 = this.mTop - this.titleBarHeight + localBaseChatItemLayout.getTop();
              }
            }
          }
        }
      }
    }
    label2733:
    label3760:
    label3764:
    label4160:
    label7873:
    for (;;)
    {
      if (localBaseChatItemLayout.getBottom() > localChatXListView.getMeasuredHeight()) {
        i4 = localBaseChatItemLayout.getBottom() + i4 - localChatXListView.getMeasuredHeight();
      }
      for (;;)
      {
        Object localObject6 = null;
        Object localObject5 = null;
        paramMotionEvent = this.popupEmo.getTag();
        Object localObject4;
        FavoriteEmoticonInfo localFavoriteEmoticonInfo;
        if ((paramMotionEvent instanceof PicEmoticonInfo))
        {
          localObject1 = (PicEmoticonInfo)paramMotionEvent;
          localObject3 = null;
          localObject4 = null;
          localObject2 = null;
          localFavoriteEmoticonInfo = null;
        }
        for (;;)
        {
          label2654:
          label2673:
          View localView;
          if ((!EmojiStickerManager.jdField_g_of_type_Boolean) && (FileUtils.a() > 1.048576E+008F))
          {
            i = 1;
            paramMotionEvent = null;
            if ((localObject1 == null) || (((PicEmoticonInfo)localObject1).emoticon == null)) {
              break label3318;
            }
            if (i == 0) {
              break label3301;
            }
            paramMotionEvent = ((PicEmoticonInfo)localObject1).getLoadingDrawable("fromAIO", true, false, null, (int)(this.popupEmo.getWidth() * this.scale), (int)(this.popupEmo.getHeight() * this.scale));
            if (paramMotionEvent == null) {
              break label7813;
            }
            i5 = localBaseChatItemLayout.getChildCount() - 1;
            i7 = 0;
            i8 = 0;
            bool4 = false;
            i6 = 0;
            bool2 = bool6;
            n = i2;
            m = i1;
            i = j;
            i1 = i8;
            i2 = i7;
            j = i6;
            label2786:
            if (i5 < 0) {
              break label7723;
            }
            localView = localBaseChatItemLayout.getChildAt(i5);
            if ((localView == null) || (localView.getId() != 2131364634)) {
              break label7680;
            }
            localObject5 = new Rect();
            localView.getGlobalVisibleRect((Rect)localObject5);
            bool4 = isInAllowedArea((int)(f3 + 0.5D) - i10 + this.widthPaddingOffset + (int)this.clicpXoffset, (int)(f2 + 0.5D) - i11, (int)(f4 + 0.5D) + i10 - this.widthPaddingOffset - (int)this.clicpXoffset, (int)(f5 + 0.5D) + i11, (Rect)localObject5);
            i2 = ((Rect)localObject5).left;
            i6 = i3 + localView.getTop();
            localObject6 = (ChatMessage)localView.getTag(2131364681);
            if ((bool4) || (localObject6 == null)) {
              break label7677;
            }
            if (!((ChatMessage)localObject6).isSend()) {
              break label3407;
            }
            j = ((Rect)localObject5).left + BaseChatItemLayout.k - this.popupEmo.getWidth() - i10 + this.widthPaddingOffset + (int)this.clicpXoffset;
            if (localBaseChatItemLayout.getParent() != null) {
              break label3435;
            }
            QLog.e("StickerGestureDetector", 1, "itemView.getParent == null");
            i4 = 1;
            i3 = i2;
            i2 = i6;
            i1 = j;
            localObject5 = localObject6;
            j = i4;
          }
          for (;;)
          {
            label3027:
            if ((this.lastIntersectChatLayout != null) && ((this.lastIntersectChatLayout instanceof BaseChatItemLayout))) {
              ((BaseChatItemLayout)this.lastIntersectChatLayout).setStickerPressStatus(false);
            }
            label3141:
            label3181:
            label3318:
            label3708:
            ChatMessage localChatMessage;
            if (j != 0)
            {
              makeToast(HardCodeUtil.a(2131714255));
              i = 0;
              j = 0;
              if ((this.currentChooseLayout instanceof BaseChatItemLayout))
              {
                if (i == 0) {
                  break label6213;
                }
                playCloseToMessageAnimation(i1);
                if (this.lastIntersectView != null) {
                  changeBubbleBg(this.lastIntersectView, true);
                }
                if ((this.lastIntersectChatLayout != null) && ((this.lastIntersectChatLayout instanceof BaseChatItemLayout))) {
                  ((BaseChatItemLayout)this.lastIntersectChatLayout).setStickerPressStatus(true);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.i("StickerGestureDetector", 2, "line 6 mBottom = " + this.mBottom);
              }
              localBaseChatItemLayout.requestLayout();
              return true;
              if ((paramMotionEvent instanceof Emoticon))
              {
                localObject2 = (Emoticon)paramMotionEvent;
                localObject3 = null;
                localObject4 = null;
                localFavoriteEmoticonInfo = null;
                localObject1 = null;
                break label2654;
              }
              if ((paramMotionEvent instanceof SystemAndEmojiEmoticonInfo))
              {
                localObject4 = (SystemAndEmojiEmoticonInfo)paramMotionEvent;
                localObject3 = null;
                localObject2 = null;
                localFavoriteEmoticonInfo = null;
                localObject1 = null;
                break label2654;
              }
              if ((paramMotionEvent instanceof SmallEmoticonInfo))
              {
                localObject3 = (SmallEmoticonInfo)paramMotionEvent;
                localObject4 = null;
                localObject2 = null;
                localFavoriteEmoticonInfo = null;
                localObject1 = null;
                break label2654;
              }
              if (!(paramMotionEvent instanceof FavoriteEmoticonInfo)) {
                break label7852;
              }
              localFavoriteEmoticonInfo = (FavoriteEmoticonInfo)paramMotionEvent;
              localObject3 = null;
              localObject4 = null;
              localObject2 = null;
              localObject1 = null;
              break label2654;
              i = 0;
              break label2673;
              label3301:
              paramMotionEvent = ((PicEmoticonInfo)localObject1).getDrawable(this.mContext, this.density);
              break label2733;
              if (localObject4 != null)
              {
                paramMotionEvent = ((SystemAndEmojiEmoticonInfo)localObject4).getBigDrawable(this.mContext, this.density);
                break label2733;
              }
              if (localObject2 != null)
              {
                paramMotionEvent = EmojiStickerManager.a().a(this.mContext, (Emoticon)localObject2);
                break label2733;
              }
              if (localObject3 != null)
              {
                paramMotionEvent = ((SmallEmoticonInfo)localObject3).getBigDrawable(this.mContext, this.density);
                break label2733;
              }
              if (localFavoriteEmoticonInfo == null) {
                break label2733;
              }
              paramMotionEvent = localFavoriteEmoticonInfo.getBigDrawable(this.mContext, this.density, 0, 0);
              break label2733;
              label3407:
              j = ((Rect)localObject5).right - BaseChatItemLayout.k + i10 - this.widthPaddingOffset - (int)this.clicpXoffset;
              break label2987;
              label3435:
              i1 = localChatXListView.getPositionForView(localBaseChatItemLayout);
              i7 = localChatXListView.getCount() - localChatXListView.getHeaderViewsCount() - localChatXListView.getFooterViewsCount();
              if (i7 - i1 - 1 <= 20)
              {
                bool3 = true;
                if (QLog.isColorLevel()) {
                  QLog.i("StickerGestureDetector", 2, "isLastTwenty = " + bool3 + " itemCount = " + i7 + " currentPosition = " + i1 + " headerViewsCount = " + localChatXListView.getHeaderViewsCount() + " footerViewsCount = " + localChatXListView.getFooterViewsCount());
                }
                localObject5 = localBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView;
                localObject5 = localBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar;
                i8 = 0;
                if (localObject6 == null) {
                  break label7798;
                }
                bool2 = EmojiStickerManager.d((MessageRecord)localObject6);
                if (((ChatMessage)localObject6).istroop != 0) {
                  break label3723;
                }
                if (((ChatMessage)localObject6).msgUid == 0L) {
                  break label3717;
                }
                m = 1;
                if (android.text.TextUtils.isEmpty(((ChatMessage)localObject6).getExtInfoFromExtStr("message_is_sticker"))) {
                  break label3745;
                }
                k = 1;
              }
              for (;;)
              {
                if ((localObject6 instanceof MessageForMixedMsg))
                {
                  localObject5 = (MessageForMixedMsg)localObject6;
                  i1 = 0;
                  n = 0;
                  if (((MessageForMixedMsg)localObject5).msgElemList != null)
                  {
                    localObject5 = ((MessageForMixedMsg)localObject5).msgElemList.iterator();
                    for (;;)
                    {
                      i1 = n;
                      if (!((Iterator)localObject5).hasNext()) {
                        break;
                      }
                      if (((MessageRecord)((Iterator)localObject5).next()).msgtype != -2000) {
                        break label7789;
                      }
                      n += 1;
                    }
                    bool3 = false;
                    break;
                    m = 0;
                    break label3611;
                    if (((ChatMessage)localObject6).shmsgseq != 0L)
                    {
                      m = 1;
                      break label3611;
                    }
                    m = 0;
                    break label3611;
                    k = 0;
                    continue;
                  }
                  if (i1 > 1)
                  {
                    n = 1;
                    i1 = n;
                    localObject5 = EmojiStickerManager.a((MessageRecord)localObject6);
                    Iterator localIterator = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.mBaseChatPie.x()).iterator();
                    label3922:
                    for (;;)
                    {
                      label3818:
                      if (localIterator.hasNext())
                      {
                        localChatMessage = (ChatMessage)localIterator.next();
                        if ((localChatMessage instanceof MessageForMarketFace))
                        {
                          Object localObject7 = (MessageForMarketFace)localChatMessage;
                          if ((((MessageForMarketFace)localObject7).mMarkFaceMessage == null) || (((MessageForMarketFace)localObject7).mMarkFaceMessage.stickerInfo == null)) {
                            break label7777;
                          }
                          n = 1;
                          if (((localChatMessage instanceof MessageForUniteGrayTip)) || (n != 0)) {
                            break label7781;
                          }
                          localObject7 = EmojiStickerManager.a(localChatMessage);
                          if ((localObject7 == null) || (!((Pair)localObject7).equals(localObject5)) || (localChatMessage == localObject6)) {
                            continue;
                          }
                          n = 1;
                          if ((!EmojiStickerManager.b((MessageRecord)localObject6)) || (m == 0) || (i1 != 0) || (n != 0)) {
                            break label4494;
                          }
                          m = 1;
                          label3948:
                          if ((EmojiStickerManager.jdField_d_of_type_Long <= ((ChatMessage)localObject6).time) || (!(localObject6 instanceof MessageForMarketFace))) {
                            break label4500;
                          }
                          n = 1;
                          if (!(localObject6 instanceof MessageForMarketFace)) {
                            break label7750;
                          }
                          localObject5 = (MessageForMarketFace)localObject6;
                          if ((((MessageForMarketFace)localObject5).mMarkFaceMessage == null) || (((MessageForMarketFace)localObject5).mMarkFaceMessage.stickerInfo == null)) {
                            break label4506;
                          }
                          i = 1;
                          i1 = k;
                          k = n;
                          n = m;
                          m = k;
                          k = i;
                          i = i1;
                        }
                      }
                    }
                  }
                }
              }
            }
            for (;;)
            {
              if ((localObject6 != null) && (((ChatMessage)localObject6).extraflag != 32772) && (((ChatMessage)localObject6).extraflag != 32768) && (bool3) && (bool4) && (((ChatMessage)localObject6).msgtype != -2009) && (((ChatMessage)localObject6).msgtype != -2016) && (!(localObject6 instanceof MessageForLongMsg)) && (!(localObject6 instanceof MessageForLongTextMsg)) && (bool2) && (n != 0) && (m == 0) && (k == 0) && (i == 0))
              {
                localObject5 = "";
                if ((localObject1 != null) && (((PicEmoticonInfo)localObject1).emoticon != null))
                {
                  localObject5 = ((PicEmoticonInfo)localObject1).emoticon.epId;
                  if (f2 - i11 + this.lowVersionOffset <= i3) {
                    break label4527;
                  }
                  bool1 = localBaseChatItemLayout.a(paramMotionEvent, (int)(f3 + 0.5D) + this.widthPaddingOffset + (int)this.clicpXoffset - i10 - this.childRect.left - localView.getLeft(), (int)(this.lowVersionOffset + f2 + 0.5D) - this.childRect.top - i11 + this.heightPaddingOffset + (int)this.clicpYoffset, (int)(this.stickerWidth * this.scale), (int)(this.stickerHeight * this.scale), this.angle, (String)localObject5, true, 1.0F, null);
                  i1 = (int)(this.lowVersionOffset + f2 + 0.5D) - i11 + (int)this.stickerHeight;
                  if (i1 <= i4) {
                    break label7737;
                  }
                  i1 -= i3;
                }
              }
              for (;;)
              {
                label4324:
                f1 = i1 - localBaseChatItemLayout.getHeight();
                localObject5 = this.mBaseChatPie.a();
                if (localObject5 != null) {
                  ((AIOAnimationConatiner)localObject5).a();
                }
                bool5 = bool2;
                bool2 = bool4;
                i7 = i2;
                localObject5 = localObject6;
                bool4 = bool5;
                i1 = m;
                i2 = k;
                m = i;
                k = i7;
                i = i6;
                for (;;)
                {
                  i7 = i5 - 1;
                  i5 = i2;
                  i6 = i1;
                  bool5 = bool4;
                  i2 = i;
                  i1 = k;
                  bool4 = bool2;
                  k = m;
                  i = i5;
                  m = i6;
                  bool2 = bool5;
                  i5 = i7;
                  break label2786;
                  n = 0;
                  break label3760;
                  if ((!(localChatMessage instanceof MessageForText)) && (!(localChatMessage instanceof MessageForPic))) {
                    break label7777;
                  }
                  if (!android.text.TextUtils.isEmpty(localChatMessage.getExtInfoFromExtStr("sticker_info")))
                  {
                    n = 1;
                    break label3877;
                  }
                  n = 0;
                  break label3877;
                  m = 0;
                  break label3948;
                  n = 0;
                  break label3971;
                  i = 0;
                  break label4008;
                  if (localObject2 == null) {
                    break label4160;
                  }
                  localObject5 = ((Emoticon)localObject2).epId;
                  break label4160;
                  bool5 = localBaseChatItemLayout.a(paramMotionEvent, (int)(f3 + 0.5D) + this.widthPaddingOffset + (int)this.clicpXoffset - i10 - this.childRect.left - localView.getLeft(), this.heightPaddingOffset + (int)this.clicpYoffset, (int)(this.stickerWidth * this.scale), (int)(this.stickerHeight * this.scale), this.angle, (String)localObject5, true, 1.0F, null);
                  i7 = (int)(this.lowVersionOffset + f2 + 0.5D);
                  i8 = (int)this.stickerHeight;
                  i1 = i3 - (int)(this.lowVersionOffset + f2 + 0.5D) + i11 + localBaseChatItemLayout.getHeight();
                  bool1 = bool5;
                  if (i7 - i11 + i8 <= i4) {
                    break label4324;
                  }
                  i1 = (int)this.stickerHeight;
                  bool1 = bool5;
                  break label4324;
                  if (!bool2)
                  {
                    makeToast(HardCodeUtil.a(2131714260));
                    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 4, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                    i = 0;
                    j = 0;
                    break label3076;
                  }
                  if (!bool4)
                  {
                    makeToast(HardCodeUtil.a(2131714268));
                    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 5, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                    i = 1;
                    j = 0;
                    break label3076;
                  }
                  if (!bool3)
                  {
                    makeToast("只能贴最新的20条消息哦~");
                    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 2, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                    i = 0;
                    j = 0;
                    break label3076;
                  }
                  if (k != 0)
                  {
                    makeToast(HardCodeUtil.a(2131714256));
                    i = 0;
                    j = 0;
                    break label3076;
                  }
                  if (m != 0)
                  {
                    makeToast(HardCodeUtil.a(2131714262));
                    i = 0;
                    j = 0;
                    break label3076;
                  }
                  if (((localObject5 instanceof MessageForLongMsg)) || ((localObject5 instanceof MessageForLongTextMsg)))
                  {
                    makeToast(HardCodeUtil.a(2131714253));
                    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 3, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                    i = 0;
                    j = 0;
                    break label3076;
                  }
                  if ((n == 0) || (i != 0))
                  {
                    makeToast(HardCodeUtil.a(2131714259));
                    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 3, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                    i = 0;
                    j = 0;
                    break label3076;
                  }
                  if ((this.mBaseChatPie != null) && (localObject5 != null))
                  {
                    if ((((ChatMessage)localObject5).extraflag == 32772) || (((ChatMessage)localObject5).extraflag == 32768))
                    {
                      makeToast(HardCodeUtil.a(2131714257));
                      VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 8, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                      i = 0;
                      j = 0;
                      break label3076;
                    }
                    if (bool1)
                    {
                      localObject6 = new EmojiStickerManager.StickerInfo();
                      ((EmojiStickerManager.StickerInfo)localObject6).x = ((f3 - i10 - this.childRect.left - i3 + this.widthPaddingOffset + (int)this.clicpXoffset) / this.screenWidth);
                      ((EmojiStickerManager.StickerInfo)localObject6).y = ((this.lowVersionOffset + f2 - i11 - i2 + this.heightPaddingOffset + (int)this.clicpYoffset) / this.screenWidth);
                      ((EmojiStickerManager.StickerInfo)localObject6).width = ((float)(this.stickerWidth * this.scale) / this.screenWidth);
                      ((EmojiStickerManager.StickerInfo)localObject6).height = ((float)(this.stickerHeight * this.scale) / this.screenWidth);
                      ((EmojiStickerManager.StickerInfo)localObject6).rotate = ((int)this.angle);
                      ((EmojiStickerManager.StickerInfo)localObject6).hostMsgSeq = ((ChatMessage)localObject5).shmsgseq;
                      ((EmojiStickerManager.StickerInfo)localObject6).hostMsgUid = ((ChatMessage)localObject5).msgUid;
                      ((EmojiStickerManager.StickerInfo)localObject6).hostMsgTime = ((ChatMessage)localObject5).time;
                      if (QLog.isColorLevel()) {
                        QLog.d("StickerGestureDetector", 2, "EmojiStickerManager.StickerInfo send stickerInfo = " + localObject6);
                      }
                      if (localObject1 != null)
                      {
                        ((PicEmoticonInfo)localObject1).stickerInfo = ((Serializable)localObject6);
                        ((ChatMessage)localObject5).stickerHidden = false;
                        paramMotionEvent = (AIOEmoticonPanelHelper)this.mBaseChatPie.a(104);
                        if (paramMotionEvent != null) {
                          paramMotionEvent.send((EmoticonInfo)localObject1);
                        }
                      }
                      do
                      {
                        for (;;)
                        {
                          if ((localObject1 != null) || (localObject2 != null))
                          {
                            VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                            if ((this.angle != 0.0D) || (this.scale != 1.0D)) {
                              VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Adjust", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                            }
                          }
                          if (f1 <= 0.0F) {
                            break label5940;
                          }
                          j = localChatXListView.getPositionForView(localBaseChatItemLayout);
                          k = localChatXListView.getFirstVisiblePosition();
                          i = 0;
                          while (i < j - k)
                          {
                            ObjectAnimator.ofPropertyValuesHolder(localChatXListView.getChildAt(i), new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("TranslationY", new float[] { f1, 0.0F }) }).setDuration(300L).start();
                            i += 1;
                          }
                          if (localObject2 != null)
                          {
                            ChatActivityFacade.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mContext, this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Emoticon)localObject2, (EmojiStickerManager.StickerInfo)localObject6);
                          }
                          else
                          {
                            if (localObject4 != null)
                            {
                              if (((SystemAndEmojiEmoticonInfo)localObject4).emotionType == 1) {}
                              for (paramMotionEvent = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemAndEmojiEmoticonInfo)localObject4).code);; paramMotionEvent = com.tencent.mobileqq.text.TextUtils.getEmojiString(((SystemAndEmojiEmoticonInfo)localObject4).code))
                              {
                                this.mBaseChatPie.a(paramMotionEvent, (EmojiStickerManager.StickerInfo)localObject6);
                                break;
                              }
                            }
                            if (localObject3 == null) {
                              break;
                            }
                            paramMotionEvent = makeSmallEmojiString((SmallEmoticonInfo)localObject3);
                            this.mBaseChatPie.a(paramMotionEvent, (EmojiStickerManager.StickerInfo)localObject6);
                          }
                        }
                      } while (localFavoriteEmoticonInfo == null);
                      paramMotionEvent = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                      localObject3 = this.mContext;
                      localObject4 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
                      localObject5 = localFavoriteEmoticonInfo.path;
                      if (!android.text.TextUtils.isEmpty(localFavoriteEmoticonInfo.eId)) {}
                      for (bool1 = true;; bool1 = false)
                      {
                        ChatActivityFacade.a(paramMotionEvent, (Context)localObject3, (SessionInfo)localObject4, (String)localObject5, true, bool1, localFavoriteEmoticonInfo.eId, (EmojiStickerManager.StickerInfo)localObject6);
                        break;
                      }
                      this.mRootView.post(new StickerGestureDetector.1(this));
                      EmojiStickerManager.jdField_a_of_type_Boolean = false;
                      this.mBaseChatPie.o(false);
                      this.mBaseChatPie.c(false, false);
                      this.mBaseChatPie.aS();
                      removeStickerMaskLayout();
                      this.isFirstUpInvoked = false;
                      this.enteredAIO = false;
                      this.mBottom = this.mRootView.getBottom();
                      this.scale = 1.0D;
                      this.angle = 0.0D;
                      if (this.lastIntersectView != null)
                      {
                        changeBubbleBg(this.lastIntersectView, false);
                        this.currentChooseLayout = null;
                      }
                      if ((this.lastIntersectChatLayout != null) && ((this.lastIntersectChatLayout instanceof BaseChatItemLayout)))
                      {
                        ((BaseChatItemLayout)this.lastIntersectChatLayout).setStickerPressStatus(false);
                        this.lastIntersectChatLayout = null;
                      }
                      EmojiStickerManager.b = false;
                      i = 0;
                      j = 1;
                      break label3076;
                      label6086:
                      if (!this.enteredAIO)
                      {
                        makeToast(HardCodeUtil.a(2131714261));
                        i1 = i8;
                        i = i4;
                        j = i3;
                        break label3076;
                      }
                      makeToast(String.format(HardCodeUtil.a(2131714267), new Object[] { Integer.valueOf(EmojiStickerManager.jdField_e_of_type_Int) }));
                      VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 1, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                      i1 = i8;
                      i = i4;
                      j = i3;
                      break label3076;
                      label6213:
                      if (j != 0) {
                        break label3141;
                      }
                      stickerJoggleAnimation();
                      break label3141;
                      label6225:
                      if (paramMotionEvent != null)
                      {
                        if ((paramMotionEvent instanceof ViewGroup))
                        {
                          makeToast(HardCodeUtil.a(2131714254));
                          VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 3, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                          break label3181;
                        }
                        makeToast(HardCodeUtil.a(2131714263));
                        VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 5, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        break label3181;
                      }
                      makeToast(HardCodeUtil.a(2131714266));
                      VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 5, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                      break label3181;
                      this.lastMotionAction = 1;
                      this.lastDownX = -1.0F;
                      this.lastDownY = -1.0F;
                      break;
                      if (paramMotionEvent.getAction() == 0)
                      {
                        this.lastOutAction = 0;
                        this.lastOutDownX = paramMotionEvent.getRawX();
                        this.lastOutDownY = paramMotionEvent.getRawY();
                        break;
                      }
                      if (paramMotionEvent.getAction() != 1) {
                        break;
                      }
                      if ((this.mBaseChatPie != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
                      {
                        this.mBottom = (this.mTop - this.lowVersionOffset + this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getMeasuredHeight() - this.titleBarHeight);
                        if (QLog.isColorLevel()) {
                          QLog.i("StickerGestureDetector", 2, "line 7 mBottom = " + this.mBottom);
                        }
                        setSmoothScrollMode(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.SCROLL_STOP);
                      }
                      if ((this.enteredAIO) && (isTouchedAboveOutsideArea(this.lastOutDownX, this.lastOutDownY, paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
                        if ((this.mBaseChatPie != null) && (this.mRootView != null))
                        {
                          paramMotionEvent = AIOEmoticonUIHelper.a(this.mBaseChatPie);
                          if ((paramMotionEvent != null) && (!paramMotionEvent.isHiden)) {
                            break label6771;
                          }
                          playDismissAnimation(f3, f2);
                          EmojiStickerManager.jdField_a_of_type_Boolean = false;
                          this.mBaseChatPie.o(false);
                          this.mBaseChatPie.c(false, false);
                          this.enteredAIO = false;
                          this.isFirstUpInvoked = false;
                          VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "CancelSendX", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        }
                      }
                      for (;;)
                      {
                        this.lastOutAction = 1;
                        this.lastOutDownX = -1.0F;
                        this.lastOutDownY = -1.0F;
                        break;
                        label6771:
                        this.mBaseChatPie.an();
                        continue;
                        if ((this.mBaseChatPie != null) && (isTouchedAboveAIOArea(this.lastOutDownX, this.lastOutDownY, paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
                          this.mBaseChatPie.an();
                        }
                      }
                      if ((paramMotionEvent.getAction() == 1) && (this.mBaseChatPie != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
                      {
                        bool1 = false;
                        localObject1 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                        i = ((ChatXListView)localObject1).getChildCount() - 1;
                        if (i >= 0)
                        {
                          localObject2 = ((ChatXListView)localObject1).getChildAt(i);
                          if ((localObject2 instanceof BaseChatItemLayout))
                          {
                            localObject2 = (BaseChatItemLayout)localObject2;
                            if (bool1) {
                              break label7665;
                            }
                            bool1 = ((BaseChatItemLayout)localObject2).h();
                          }
                        }
                      }
                      label7665:
                      for (;;)
                      {
                        ((BaseChatItemLayout)localObject2).c();
                        bool2 = bool1;
                        do
                        {
                          i -= 1;
                          bool1 = bool2;
                          break;
                          bool2 = bool1;
                        } while (!(localObject2 instanceof LinearLayout));
                        j = ((LinearLayout)localObject2).getChildCount() - 1;
                        for (;;)
                        {
                          bool2 = bool1;
                          if (j < 0) {
                            break;
                          }
                          localObject3 = ((LinearLayout)localObject2).getChildAt(j);
                          bool2 = bool1;
                          if ((localObject3 instanceof StickerGrayTipLayout))
                          {
                            localObject3 = (StickerGrayTipLayout)localObject3;
                            bool2 = bool1;
                            if (!bool1) {
                              bool2 = ((StickerGrayTipLayout)localObject3).haveStickers();
                            }
                            ((StickerGrayTipLayout)localObject3).startAutoDismiss();
                          }
                          j -= 1;
                          bool1 = bool2;
                        }
                        if (bool1)
                        {
                          if (this.currentDismissMode != EmojiStickerManager.jdField_g_of_type_Int) {
                            break label7103;
                          }
                          VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Hide", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        }
                        for (;;)
                        {
                          return super.onTouchEvent(paramMotionEvent);
                          VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "CancelHide", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        }
                        if (i == 2)
                        {
                          if (havePopuoEmo())
                          {
                            switch (paramMotionEvent.getAction() & paramMotionEvent.getActionMasked())
                            {
                            }
                            for (;;)
                            {
                              return true;
                              this.m_list_coords.add(new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0)));
                              continue;
                              if (!this.m_list_coords.isEmpty())
                              {
                                this.m_list_coords.add(new PointF(paramMotionEvent.getX(1), paramMotionEvent.getY(1)));
                                continue;
                                if (i > 1)
                                {
                                  this.m_list_coords.add(new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0)));
                                  this.m_list_coords.add(new PointF(paramMotionEvent.getX(1), paramMotionEvent.getY(1)));
                                  calcAngleScale();
                                  continue;
                                  this.m_list_coords.clear();
                                  continue;
                                  this.m_list_coords.clear();
                                }
                              }
                            }
                          }
                          localObject1 = BaseActivity.sTopActivity;
                          if ((localObject1 instanceof FragmentActivity))
                          {
                            localObject1 = (FragmentActivity)localObject1;
                            if (((FragmentActivity)localObject1).getChatFragment() != null)
                            {
                              localObject1 = ((FragmentActivity)localObject1).getChatFragment().a();
                              if ((((localObject1 instanceof BaseTroopChatPie)) || ((localObject1 instanceof FriendChatPie)) || ((localObject1 instanceof DiscussChatPie))) && (EmojiStickerManager.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
                              {
                                this.isInTowFingerMode = true;
                                switch (paramMotionEvent.getAction() & paramMotionEvent.getActionMasked())
                                {
                                }
                                for (;;)
                                {
                                  return true;
                                  this.dismissFirstX = paramMotionEvent.getX(0);
                                  this.dismissFirstY = paramMotionEvent.getY(0);
                                  continue;
                                  if (paramMotionEvent.getX(0) < paramMotionEvent.getX(1))
                                  {
                                    this.leftFinger = 0;
                                    this.rightFinger = 1;
                                    this.dismissFirstX = paramMotionEvent.getX(0);
                                    this.dismissFirstY = paramMotionEvent.getY(0);
                                    this.dismissSecondX = paramMotionEvent.getX(1);
                                    this.dismissSecondY = paramMotionEvent.getY(1);
                                  }
                                  else
                                  {
                                    this.leftFinger = 1;
                                    this.rightFinger = 0;
                                    this.dismissFirstX = paramMotionEvent.getX(1);
                                    this.dismissFirstY = paramMotionEvent.getY(1);
                                    this.dismissSecondX = paramMotionEvent.getX(0);
                                    this.dismissSecondY = paramMotionEvent.getY(0);
                                    continue;
                                    caclLeftAndRightOffset(paramMotionEvent);
                                  }
                                }
                              }
                            }
                          }
                        }
                        return super.onTouchEvent(paramMotionEvent);
                      }
                    }
                  }
                  i = 0;
                  j = 0;
                  break label3076;
                  label7677:
                  break label2987;
                  i6 = i;
                  i7 = m;
                  i = i2;
                  bool5 = bool4;
                  m = k;
                  k = i1;
                  i2 = i6;
                  i1 = i7;
                  bool4 = bool2;
                  bool2 = bool5;
                }
                i3 = i1;
                i1 = j;
                j = 0;
                break label3027;
                i1 = 0;
                continue;
                i1 = i8;
              }
              label7750:
              i1 = i;
              i7 = m;
              i = k;
              k = i1;
              m = n;
              n = i7;
              continue;
              label7777:
              n = 0;
              break label3877;
              label7781:
              break label3818;
              n = 0;
              break label3922;
              label7789:
              break label3708;
              i1 = 0;
              break label3764;
              label7798:
              i1 = i;
              i = k;
              k = i1;
            }
            j = 0;
            bool3 = false;
            f1 = 0.0F;
            bool1 = bool5;
            k = i7;
            i = i6;
            localObject5 = localObject6;
            i1 = i5;
            i2 = i9;
            i3 = i8;
          }
          localObject3 = null;
          localObject4 = null;
          localObject2 = null;
          localFavoriteEmoticonInfo = null;
          localObject1 = null;
        }
      }
    }
  }
  
  void playCloseToMessageAnimation(int paramInt)
  {
    if (this.popupEmo != null)
    {
      ViewPropertyAnimator localViewPropertyAnimator = this.popupEmo.animate();
      localViewPropertyAnimator.x(paramInt);
      localViewPropertyAnimator.setListener(this.closeToMsgAnimationListener);
      localViewPropertyAnimator.setDuration(300L);
    }
  }
  
  void playDismissAnimation(float paramFloat1, float paramFloat2)
  {
    if ((this.popupEmo != null) && (this.mBaseChatPie != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
    {
      ViewPropertyAnimator localViewPropertyAnimator = this.popupEmo.animate();
      localViewPropertyAnimator.translationX(this.screenWidth / 2 - (this.popupEmo.getWidth() / 2 + paramFloat1)).translationY(this.mTop - this.lowVersionOffset + this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getMeasuredHeight() - this.titleBarHeight - paramFloat2);
      localViewPropertyAnimator.setListener(this.animationListener);
      localViewPropertyAnimator.setDuration(200L);
    }
  }
  
  void removeStickerMaskLayout()
  {
    if (this.mBaseChatPie != null)
    {
      EmoticonMainPanel localEmoticonMainPanel = AIOEmoticonUIHelper.a(this.mBaseChatPie);
      if (localEmoticonMainPanel != null) {
        localEmoticonMainPanel.removeView(localEmoticonMainPanel.stickerMaskLayout);
      }
    }
  }
  
  void setSmoothScrollMode(ChatXListView paramChatXListView, int paramInt)
  {
    int i = paramChatXListView.getChildCount();
    int j = paramChatXListView.getCount();
    if (paramInt == this.SCROLL_UP)
    {
      this.scrolling = true;
      paramChatXListView.smoothScrollBy(-40000, 120000);
    }
    do
    {
      for (;;)
      {
        return;
        if (paramInt == this.SCROLL_DOWN)
        {
          this.scrolling = true;
          paramChatXListView.smoothScrollBy(40000, 120000);
          View localView = paramChatXListView.getChildAt(i - 1);
          try
          {
            if (j - 1 == paramChatXListView.getPositionForView(localView))
            {
              localView.getGlobalVisibleRect(this.firstOrLastRect);
              if ((Math.abs(this.firstOrLastRect.bottom - this.lowVersionOffset - this.mBottom) < 15) && (this.mBaseChatPie != null))
              {
                this.mBaseChatPie.aR();
                return;
              }
            }
          }
          catch (Exception paramChatXListView)
          {
            QLog.e("StickerGestureDetector", 1, "setSmoothScrollMode exception = " + paramChatXListView);
            return;
          }
        }
      }
    } while (paramInt != this.SCROLL_STOP);
    this.scrolling = false;
    paramChatXListView.smoothScrollBy(0, 0);
  }
  
  @TargetApi(11)
  void showResult()
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.popupEmo != null))
    {
      ImageView localImageView = this.popupEmo.a();
      if (localImageView != null)
      {
        localImageView.setRotation((float)this.angle);
        localImageView.setScaleX((float)this.scale);
        localImageView.setScaleY((float)this.scale);
      }
    }
  }
  
  void stickerButtonAnimation(boolean paramBoolean)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    if ((this.cancel != null) && (this.confirm != null))
    {
      this.cancel.setVisibility(0);
      this.confirm.setVisibility(0);
      if (paramBoolean) {
        break label193;
      }
    }
    for (;;)
    {
      PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("alpha", new float[] { f2, f1 });
      PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleX", new float[] { f2, f1 });
      PropertyValuesHolder localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("scaleY", new float[] { f2, f1 });
      ObjectAnimator.ofPropertyValuesHolder(this.cancel, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3 }).setDuration(300L).start();
      ObjectAnimator.ofPropertyValuesHolder(this.confirm, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3 }).setDuration(300L).start();
      MobileReportManager.getInstance().reportAction("tie_emoji", "4", "platform898", "6", "3", 101, 1, System.currentTimeMillis());
      return;
      label193:
      f2 = 0.0F;
      f1 = 1.0F;
    }
  }
  
  void stickerJoggleAnimation()
  {
    if (this.popupEmo != null)
    {
      ImageView localImageView = this.popupEmo.a();
      if (localImageView != null)
      {
        float f = (float)this.angle;
        ObjectAnimator.ofPropertyValuesHolder(localImageView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("Rotation", new float[] { f + 10.0F, f, f - 10.0F, f, f + 10.0F, f, f - 10.0F, f }) }).setDuration(400L).start();
      }
    }
  }
  
  void stickerLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.popupEmo.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.popupEmo.getLayoutParams();
    localLayoutParams.leftMargin = paramInt1;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLayoutParams.topMargin = (paramInt2 - ImmersiveUtils.getStatusBarHeight(this.mContext));
      return;
    }
    localLayoutParams.topMargin = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGestureDetector
 * JD-Core Version:    0.7.0.1
 */