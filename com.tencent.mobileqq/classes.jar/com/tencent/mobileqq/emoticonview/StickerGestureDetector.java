package com.tencent.mobileqq.emoticonview;

import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.MessageSignal;
import com.tencent.mobileqq.activity.aio.helper.ArkHelper;
import com.tencent.mobileqq.activity.aio.helper.EmojiStickerHelper;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkRecommendController;
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
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerFrameLayout;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class StickerGestureDetector
  extends GestureDetector
  implements IStickerGestureDetector
{
  private static final String TAG = "StickerGestureDetector";
  int SCROLL_DOWN;
  int SCROLL_STOP;
  int SCROLL_UP;
  double angle;
  StickerGestureDetector.StickerAnimationListener animationListener;
  private ImageView cancel;
  Rect childRect;
  double clicpXoffset;
  double clicpYoffset;
  Animator.AnimatorListener closeToMsgAnimationListener;
  ImageView confirm;
  int currentChatPieType;
  View currentChooseLayout;
  int currentDismissMode;
  float density;
  float dismissFirstX;
  float dismissFirstY;
  float dismissSecondX;
  float dismissSecondY;
  public boolean enteredAIO;
  public View expandStickerView;
  Rect firstOrLastRect;
  int heightPaddingOffset;
  public boolean isFirstUpInvoked;
  public boolean isInTowFingerMode;
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
  int leftFinger;
  int lowVersionOffset;
  BaseChatPie mBaseChatPie;
  public int mBottom;
  Context mContext;
  public int mLeft;
  int mRight;
  public TopGestureLayout mRootView;
  public int mTop;
  List<PointF> m_list_coords;
  Rect panelRect;
  public StickerFrameLayout popupEmo;
  int rightFinger;
  double scale;
  int screenWidth;
  boolean scrolling;
  double stickerHeight;
  int stickerReportType;
  int stickerType;
  double stickerWidth;
  int titleBarHeight;
  int widthPaddingOffset;
  
  public StickerGestureDetector(Context paramContext, GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramSimpleOnGestureListener);
    int i = 0;
    this.isInTowFingerMode = false;
    this.currentChooseLayout = null;
    this.angle = 0.0D;
    this.scale = 1.0D;
    this.scrolling = false;
    this.leftFinger = 0;
    this.rightFinger = 1;
    this.SCROLL_UP = 0;
    this.SCROLL_DOWN = 1;
    this.SCROLL_STOP = 2;
    this.enteredAIO = false;
    this.panelRect = new Rect();
    this.childRect = new Rect();
    this.stickerWidth = 0.0D;
    this.stickerHeight = 0.0D;
    this.clicpXoffset = 0.0D;
    this.clicpYoffset = 0.0D;
    this.stickerType = 0;
    this.stickerReportType = 1;
    this.animationListener = new StickerGestureDetector.StickerAnimationListener(this, null);
    this.isFirstUpInvoked = false;
    this.closeToMsgAnimationListener = new StickerGestureDetector.2(this);
    this.mBaseChatPie = paramBaseChatPie;
    if (this.mBaseChatPie != null)
    {
      if ((paramBaseChatPie instanceof FriendChatPie)) {
        this.currentChatPieType = 1;
      } else if ((paramBaseChatPie instanceof BaseTroopChatPie)) {
        this.currentChatPieType = 2;
      } else if ((paramBaseChatPie instanceof DiscussChatPie)) {
        this.currentChatPieType = 3;
      }
      this.mRootView = ((TopGestureLayout)this.mBaseChatPie.c);
    }
    this.m_list_coords = new ArrayList();
    this.mContext = paramContext;
    this.density = paramContext.getResources().getDisplayMetrics().density;
    float f = this.density;
    this.widthPaddingOffset = ((int)(f * 5.0F));
    this.heightPaddingOffset = ((int)(f * 5.0F));
    this.titleBarHeight = paramContext.getResources().getDimensionPixelOffset(2131299168);
    paramSimpleOnGestureListener = paramContext.getResources().getDisplayMetrics();
    this.screenWidth = paramSimpleOnGestureListener.widthPixels;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i = ImmersiveUtils.getStatusBarHeight(this.mContext);
    }
    this.lowVersionOffset = i;
    this.mLeft = this.mRootView.getLeft();
    this.mRight = this.mRootView.getRight();
    this.mTop = (ImmersiveUtils.getStatusBarHeight(paramContext) + this.titleBarHeight);
    this.mBottom = (paramSimpleOnGestureListener.heightPixels - this.lowVersionOffset);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("line 8 mBottom = ");
      paramContext.append(this.mBottom);
      QLog.i("StickerGestureDetector", 2, paramContext.toString());
    }
    this.expandStickerView = new View(this.mContext);
    paramContext = new AbsListView.LayoutParams(-1, (int)(this.density * 100.0F));
    this.expandStickerView.setLayoutParams(paramContext);
    this.firstOrLastRect = new Rect();
  }
  
  private void judgeIfEnteredAIO(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MotionEvent paramMotionEvent, ListView paramListView, int paramInt)
  {
    if (paramMotionEvent.getRawY() < paramInt)
    {
      this.enteredAIO = true;
      EmojiStickerManager.jdField_a_of_type_Boolean = true;
      this.mBaseChatPie.i(true);
      this.mBottom = (this.mTop - this.lowVersionOffset + paramListView.getMeasuredHeight() - this.titleBarHeight);
      if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("line 3 mBottom = ");
        paramMotionEvent.append(this.mBottom);
        QLog.i("StickerGestureDetector", 2, paramMotionEvent.toString());
      }
      paramFloat2 = this.mBottom - this.popupEmo.getHeight();
      paramFloat4 = this.mBottom;
      double d = paramFloat1;
      Double.isNaN(d);
      paramInt = (int)(d + 0.5D);
      d = paramFloat2;
      Double.isNaN(d);
      int i = (int)(d + 0.5D);
      d = paramFloat3;
      Double.isNaN(d);
      int j = (int)(d + 0.5D);
      d = paramFloat4;
      Double.isNaN(d);
      stickerLayout(paramInt, i, j, (int)(d + 0.5D));
      stickerButtonAnimation(true);
      return;
    }
    this.mRootView.post(new StickerGestureDetector.3(this));
    EmojiStickerManager.jdField_a_of_type_Boolean = false;
    this.mBaseChatPie.i(false);
    removeStickerExpandView();
    changeBubbleBg(this.lastIntersectView, false);
    paramMotionEvent = this.lastIntersectChatLayout;
    if ((paramMotionEvent != null) && ((paramMotionEvent instanceof BaseChatItemLayout))) {
      ((BaseChatItemLayout)paramMotionEvent).setStickerPressStatus(false);
    }
    EmojiStickerManager.b = false;
    removeStickerMaskLayout();
    this.enteredAIO = false;
    this.isFirstUpInvoked = false;
    this.mBottom = this.mRootView.getBottom();
    this.scale = 1.0D;
    this.angle = 0.0D;
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("line 4 mBottom = ");
      paramMotionEvent.append(this.mBottom);
      QLog.i("StickerGestureDetector", 2, paramMotionEvent.toString());
    }
  }
  
  private String makeSmallEmojiString(ISmallEmoticonInfo paramISmallEmoticonInfo)
  {
    if (paramISmallEmoticonInfo.getEmoticon() == null)
    {
      QLog.e("StickerGestureDetector", 1, "makeSmallEmojiString, emotion == null");
      return "";
    }
    if (this.mBaseChatPie != null) {}
    try
    {
      int i = Integer.parseInt(paramISmallEmoticonInfo.getEmoticon().eId);
      int j = Integer.parseInt(paramISmallEmoticonInfo.getEmoticon().epId);
      paramISmallEmoticonInfo = EmosmUtils.b(j, i);
      EmoticonPackage localEmoticonPackage = ((IEmoticonManagerService)this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(String.valueOf(j));
      char[] arrayOfChar = new char[5];
      arrayOfChar[0] = '\024';
      arrayOfChar[1] = paramISmallEmoticonInfo[3];
      arrayOfChar[2] = paramISmallEmoticonInfo[2];
      arrayOfChar[3] = paramISmallEmoticonInfo[1];
      arrayOfChar[4] = paramISmallEmoticonInfo[0];
      if ((localEmoticonPackage != null) && (localEmoticonPackage.isAPNG == 2)) {
        arrayOfChar[1] = 'ǿ';
      }
      paramISmallEmoticonInfo = new StringBuilder(String.valueOf(arrayOfChar));
      EmojiStickerManager.a(paramISmallEmoticonInfo);
      return paramISmallEmoticonInfo.toString();
    }
    catch (NumberFormatException paramISmallEmoticonInfo)
    {
      label171:
      break label171;
    }
    VasReportUtils.a("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
    QLog.e("StickerGestureDetector", 1, "fail to send small_emotion. id is not Int.");
    return "";
  }
  
  private void removeStickerExpandView()
  {
    ((EmojiStickerHelper)this.mBaseChatPie.a(133)).b();
  }
  
  private void showOpenVip()
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool) {
      QLog.i("StickerGestureDetector", 2, "showOpenVip invoked");
    }
    DialogUtil.a(this.mContext, 230).setTitle(HardCodeUtil.a(2131714194)).setMessage(HardCodeUtil.a(2131714187)).setPositiveButton(HardCodeUtil.a(2131714193), new StickerGestureDetector.5(this)).setNegativeButton("取消", new StickerGestureDetector.4(this)).show();
    if (this.mBaseChatPie != null)
    {
      if (EmojiStickerManager.a().jdField_a_of_type_Int == 0) {
        i = 1;
      } else if (EmojiStickerManager.a().jdField_a_of_type_Int != 1) {
        if (EmojiStickerManager.a().jdField_a_of_type_Int == 3000) {
          i = 3;
        } else {
          i = -1;
        }
      }
      VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "SVIPTip", String.valueOf(i), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  void caclLeftAndRightOffset(MotionEvent paramMotionEvent)
  {
    float f4 = paramMotionEvent.getX(this.leftFinger) - this.dismissFirstX;
    float f3 = paramMotionEvent.getX(this.rightFinger) - this.dismissSecondX;
    this.dismissFirstX = paramMotionEvent.getX(this.leftFinger);
    this.dismissSecondX = paramMotionEvent.getX(this.rightFinger);
    if (f4 * f3 < 0.0F)
    {
      int i;
      if (f4 < 0.0F) {
        i = EmojiStickerManager.jdField_d_of_type_Int;
      } else {
        i = EmojiStickerManager.jdField_e_of_type_Int;
      }
      this.currentDismissMode = i;
      paramMotionEvent = this.mBaseChatPie;
      if ((paramMotionEvent != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
      {
        paramMotionEvent = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
        i = paramMotionEvent.getChildCount() - 1;
        while (i >= 0)
        {
          Object localObject1 = paramMotionEvent.getChildAt(i);
          float f1;
          float f2;
          if ((localObject1 instanceof BaseChatItemLayout))
          {
            localObject1 = (BaseChatItemLayout)localObject1;
            if (this.currentDismissMode == EmojiStickerManager.jdField_d_of_type_Int)
            {
              f1 = Math.min(0.0F, f4);
              f2 = Math.max(0.0F, f3);
              ((BaseChatItemLayout)localObject1).a((int)Math.abs(f1 - f2), this.currentDismissMode);
            }
            else
            {
              f1 = f4;
              f2 = f3;
              if (this.currentDismissMode == EmojiStickerManager.jdField_e_of_type_Int)
              {
                f1 = Math.max(0.0F, f4);
                f2 = Math.min(0.0F, f3);
                ((BaseChatItemLayout)localObject1).a((int)Math.abs(f1 - f2), this.currentDismissMode);
              }
            }
          }
          else
          {
            f1 = f4;
            f2 = f3;
            if ((localObject1 instanceof LinearLayout))
            {
              localObject1 = (LinearLayout)localObject1;
              int j = ((LinearLayout)localObject1).getChildCount() - 1;
              for (;;)
              {
                f1 = f4;
                f2 = f3;
                if (j < 0) {
                  break;
                }
                Object localObject2 = ((LinearLayout)localObject1).getChildAt(j);
                f1 = f4;
                f2 = f3;
                if ((localObject2 instanceof StickerGrayTipLayout))
                {
                  localObject2 = (StickerGrayTipLayout)localObject2;
                  if (this.currentDismissMode == EmojiStickerManager.jdField_d_of_type_Int)
                  {
                    f1 = Math.min(0.0F, f4);
                    f2 = Math.max(0.0F, f3);
                    ((StickerGrayTipLayout)localObject2).doDismiss((int)Math.abs(f1 - f2), this.currentDismissMode);
                  }
                  else
                  {
                    f1 = f4;
                    f2 = f3;
                    if (this.currentDismissMode == EmojiStickerManager.jdField_e_of_type_Int)
                    {
                      f1 = Math.max(0.0F, f4);
                      f2 = Math.min(0.0F, f3);
                      ((StickerGrayTipLayout)localObject2).doDismiss((int)Math.abs(f1 - f2), this.currentDismissMode);
                    }
                  }
                }
                j -= 1;
                f4 = f1;
                f3 = f2;
              }
            }
          }
          i -= 1;
          f4 = f1;
          f3 = f2;
        }
      }
    }
  }
  
  void calcAngleScale()
  {
    int j = this.m_list_coords.size();
    if (j < 4) {
      return;
    }
    PointF localPointF1 = (PointF)this.m_list_coords.get(j - 4);
    PointF localPointF2 = (PointF)this.m_list_coords.get(j - 3);
    Object localObject1 = this.m_list_coords;
    int i = j - 2;
    localObject1 = (PointF)((List)localObject1).get(i);
    Object localObject2 = this.m_list_coords;
    j -= 1;
    localObject2 = (PointF)((List)localObject2).get(j);
    if (getLineLength(localPointF1, (PointF)localObject1) + getLineLength(localPointF2, (PointF)localObject2) < 5.0D)
    {
      this.m_list_coords.remove(j);
      this.m_list_coords.remove(i);
      return;
    }
    PointF localPointF3 = new PointF(localPointF2.x - localPointF1.x, localPointF2.y - localPointF1.y);
    PointF localPointF4 = new PointF(((PointF)localObject2).x - ((PointF)localObject1).x, ((PointF)localObject2).y - ((PointF)localObject1).y);
    double d4 = getLineLength(localPointF3);
    double d3 = getLineLength(localPointF4);
    double d1 = localPointF3.x * localPointF4.x + localPointF3.y * localPointF4.y;
    Double.isNaN(d1);
    double d2 = d1 / (d4 * d3);
    d1 = d2;
    if (d2 > 1.0D) {
      d1 = 1.0D;
    }
    d1 = Math.acos(d1) * 180.0D / 3.14D;
    d2 = localPointF3.x;
    Double.isNaN(d2);
    localPointF3.x = ((float)(d2 / d4));
    d2 = localPointF3.y;
    Double.isNaN(d2);
    localPointF3.y = ((float)(d2 / d4));
    d2 = localPointF4.x;
    Double.isNaN(d2);
    localPointF4.x = ((float)(d2 / d3));
    d2 = localPointF4.y;
    Double.isNaN(d2);
    localPointF4.y = ((float)(d2 / d3));
    localPointF4 = new PointF(localPointF4.y, -localPointF4.x);
    if (localPointF3.x * localPointF4.x + localPointF3.y * localPointF4.y <= 0.0F) {
      d1 = -d1;
    }
    this.angle += d1;
    d1 = this.angle;
    if (d1 >= 360.0D) {
      this.angle = (d1 - 360.0D);
    }
    d1 = this.angle;
    if (d1 < 0.0D) {
      this.angle = (d1 + 360.0D);
    }
    d1 = getLineLength(localPointF1, localPointF2);
    d2 = getLineLength((PointF)localObject1, (PointF)localObject2);
    if ((d1 >= 5.0D) && (d2 >= 5.0D))
    {
      d1 = d2 / d1;
      this.scale *= d1;
    }
    i = this.stickerType;
    if (i == 1)
    {
      if (this.scale > 1.0D) {
        this.scale = 1.0D;
      }
      if (this.scale < 0.6000000238418579D) {
        this.scale = 0.6000000238418579D;
      }
    }
    else if (i == 0)
    {
      if (this.scale > 1.6D) {
        this.scale = 1.6D;
      }
      if (this.scale < 1.0D) {
        this.scale = 1.0D;
      }
    }
    showResult();
  }
  
  void changeBubbleBg(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      BubbleInfo localBubbleInfo = (BubbleInfo)paramView.getTag(2131364116);
      Object localObject = (ChatMessage)paramView.getTag(2131364568);
      boolean bool = false;
      if (localObject != null) {
        bool = ((ChatMessage)localObject).isSend();
      }
      if (localBubbleInfo != null)
      {
        localObject = paramView.getBackground();
        if ((localObject != null) && ((localObject instanceof VipBubbleDrawable)))
        {
          ((VipBubbleDrawable)localObject).b(paramBoolean);
          return;
        }
        if (localObject != null)
        {
          localObject = this.mContext.getResources();
          int i;
          if (!paramBoolean)
          {
            if (bool) {
              i = 2130850335;
            } else {
              i = 2130850159;
            }
            localObject = ((Resources)localObject).getDrawable(i);
          }
          else
          {
            if (bool) {
              i = 2130850336;
            } else {
              i = 2130850160;
            }
            localObject = ((Resources)localObject).getDrawable(i);
          }
          if (localObject != null) {
            localBubbleInfo.a(paramView, (Drawable)localObject);
          }
        }
      }
    }
  }
  
  View findBiggestIntersectAreaView(int paramInt1, int paramInt2, Rect paramRect, ViewGroup paramViewGroup)
  {
    Object localObject = this.mBaseChatPie;
    View localView = null;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
    {
      localObject = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if ((!this.enteredAIO) && ((paramInt1 > this.mTop - this.lowVersionOffset + ((ChatXListView)localObject).getMeasuredHeight() - this.titleBarHeight) || (paramInt2 > this.mTop - this.lowVersionOffset + ((ChatXListView)localObject).getMeasuredHeight() - this.titleBarHeight))) {
        return null;
      }
    }
    localObject = paramRect;
    if (paramRect == null) {
      localObject = new Rect();
    }
    int i = paramViewGroup.getChildCount() - 1;
    int m = -1;
    int n;
    for (int k = 9999999; i >= 0; k = n)
    {
      paramViewGroup.getChildAt(i).getGlobalVisibleRect((Rect)localObject);
      int j = Math.abs(paramInt1 - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      n = Math.abs(paramInt2 - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      if (j - n >= 0) {
        j = n;
      }
      n = k;
      if (j < k)
      {
        m = i;
        n = j;
      }
      i -= 1;
    }
    paramRect = localView;
    if (m != -1)
    {
      localView = paramViewGroup.getChildAt(m);
      localView.getGlobalVisibleRect((Rect)localObject);
      if (m == 0)
      {
        ((Rect)localObject).top = (((Rect)localObject).bottom - localView.getHeight());
        return localView;
      }
      paramRect = localView;
      if (m == paramViewGroup.getChildCount() - 1)
      {
        ((Rect)localObject).bottom = (((Rect)localObject).top + localView.getHeight());
        paramRect = localView;
      }
    }
    return paramRect;
  }
  
  View findBiggestIntersectAreaView(int paramInt, Rect paramRect, ViewGroup paramViewGroup)
  {
    Object localObject = this.mBaseChatPie;
    View localView = null;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
    {
      localObject = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if ((!this.enteredAIO) && (paramInt > this.mTop - this.lowVersionOffset + ((ChatXListView)localObject).getMeasuredHeight() - this.titleBarHeight)) {
        return null;
      }
    }
    localObject = paramRect;
    if (paramRect == null) {
      localObject = new Rect();
    }
    int i = paramViewGroup.getChildCount() - 1;
    int m = -1;
    int k;
    for (int j = 9999999; i >= 0; j = k)
    {
      paramViewGroup.getChildAt(i).getGlobalVisibleRect((Rect)localObject);
      int n = Math.abs(paramInt - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      k = j;
      if (n < j)
      {
        m = i;
        k = n;
      }
      i -= 1;
    }
    paramRect = localView;
    if (m != -1)
    {
      localView = paramViewGroup.getChildAt(m);
      localView.getGlobalVisibleRect((Rect)localObject);
      if (m == 0)
      {
        ((Rect)localObject).top = (((Rect)localObject).bottom - localView.getHeight());
        return localView;
      }
      paramRect = localView;
      if (m == paramViewGroup.getChildCount() - 1)
      {
        ((Rect)localObject).bottom = (((Rect)localObject).top + localView.getHeight());
        paramRect = localView;
      }
    }
    return paramRect;
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
    Object localObject = this.mRootView;
    if (localObject != null)
    {
      int i = ((TopGestureLayout)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        localObject = this.mRootView.getChildAt(i);
        if (((View)localObject).getId() == 2131374055)
        {
          this.popupEmo = ((StickerFrameLayout)localObject);
          this.confirm = ((ImageView)this.popupEmo.findViewById(2131362352));
          this.cancel = ((ImageView)this.popupEmo.findViewById(2131362351));
          localObject = this.popupEmo.getTag();
          float f;
          if ((!(localObject instanceof IPicEmoticonInfo)) && (!(localObject instanceof Emoticon)) && (!(localObject instanceof IFavoriteEmoticonInfo)))
          {
            if (((localObject instanceof SystemAndEmojiEmoticonInfo)) || ((localObject instanceof ISmallEmoticonInfo)))
            {
              this.stickerType = 0;
              f = this.density;
              this.stickerWidth = (f * 28.0F);
              this.stickerHeight = (28.0F * f);
              this.widthPaddingOffset = ((int)(f * 41.0F));
              this.heightPaddingOffset = ((int)(f * 41.0F));
            }
          }
          else
          {
            this.stickerType = 1;
            f = this.density;
            this.stickerWidth = (f * 100.0F);
            this.stickerHeight = (100.0F * f);
            this.widthPaddingOffset = ((int)(f * 5.0F));
            this.heightPaddingOffset = ((int)(f * 5.0F));
          }
          localObject = this.popupEmo.getStickerImage();
          double d1 = ((ImageView)localObject).getDrawable().getIntrinsicWidth();
          double d2 = ((ImageView)localObject).getDrawable().getIntrinsicHeight();
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
          if (d1 > 1.0D)
          {
            d2 = this.stickerWidth;
            this.stickerHeight = (d2 / d1);
            this.clicpXoffset = 0.0D;
            this.clicpYoffset = ((d2 - this.stickerHeight) / 2.0D);
            return true;
          }
          d2 = this.stickerHeight;
          this.stickerWidth = (d1 * d2);
          this.clicpXoffset = ((d2 - this.stickerWidth) / 2.0D);
          this.clicpYoffset = 0.0D;
          return true;
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
    return Math.abs(paramRect.left + paramInt3 / 2 - paramInt1 - paramInt2 / 2) <= paramInt4;
  }
  
  boolean isInAllowedArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    paramInt2 = paramInt3 - paramInt1;
    paramInt3 = paramView.getWidth();
    paramInt4 = (paramInt3 + paramInt2) / 2;
    return Math.abs(paramView.getLeft() + paramInt3 / 2 - paramInt1 - paramInt2 / 2) <= paramInt4;
  }
  
  boolean isMovedOnCancel(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.cancel;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = new Rect();
      this.cancel.getGlobalVisibleRect((Rect)localObject);
      bool1 = bool2;
      if (paramFloat1 >= ((Rect)localObject).left)
      {
        bool1 = bool2;
        if (paramFloat1 <= ((Rect)localObject).right)
        {
          bool1 = bool2;
          if (paramFloat2 >= ((Rect)localObject).top)
          {
            bool1 = bool2;
            if (paramFloat2 <= ((Rect)localObject).bottom) {
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
    Object localObject = this.confirm;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = new Rect();
      this.confirm.getGlobalVisibleRect((Rect)localObject);
      bool1 = bool2;
      if (paramFloat1 >= ((Rect)localObject).left)
      {
        bool1 = bool2;
        if (paramFloat1 <= ((Rect)localObject).right)
        {
          bool1 = bool2;
          if (paramFloat2 >= ((Rect)localObject).top)
          {
            bool1 = bool2;
            if (paramFloat2 <= ((Rect)localObject).bottom) {
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
    paramFloat1 -= paramFloat3;
    paramFloat3 = paramFloat2 - paramFloat4;
    return (Math.sqrt(paramFloat1 * paramFloat1 + paramFloat3 * paramFloat3) < 50.0D) && (paramFloat2 < this.mBottom) && (paramFloat2 > this.mTop);
  }
  
  boolean isTouchedAboveCancel(float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    ImageView localImageView = this.cancel;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localImageView != null)
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
    ImageView localImageView = this.confirm;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localImageView != null)
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
    StickerFrameLayout localStickerFrameLayout = this.popupEmo;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (localStickerFrameLayout != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        bool1 = bool2;
        if (paramFloat1 >= this.popupEmo.getLeft())
        {
          bool1 = bool2;
          if (paramFloat1 <= this.popupEmo.getRight())
          {
            bool1 = bool2;
            if (paramFloat2 >= this.popupEmo.getTop())
            {
              bool1 = bool2;
              if (paramFloat2 <= this.popupEmo.getBottom())
              {
                bool1 = bool2;
                if (!isMovedOnCancel(paramFloat1, paramFloat2))
                {
                  bool1 = bool2;
                  if (!isMovedOnConfirm(paramFloat1, paramFloat2)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
        return bool1;
      }
      bool1 = bool3;
      if (paramFloat1 >= this.popupEmo.getLeft())
      {
        bool1 = bool3;
        if (paramFloat1 <= this.popupEmo.getRight())
        {
          bool1 = bool3;
          if (paramFloat2 >= this.popupEmo.getTop() + this.lowVersionOffset)
          {
            bool1 = bool3;
            if (paramFloat2 <= this.popupEmo.getBottom() + this.lowVersionOffset)
            {
              bool1 = bool3;
              if (!isMovedOnCancel(paramFloat1, paramFloat2))
              {
                bool1 = bool3;
                if (!isMovedOnConfirm(paramFloat1, paramFloat2)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  boolean isTouchedAboveEmotionWithButtons(float paramFloat1, float paramFloat2)
  {
    StickerFrameLayout localStickerFrameLayout = this.popupEmo;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (localStickerFrameLayout != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        bool1 = bool2;
        if (paramFloat1 >= this.popupEmo.getLeft())
        {
          bool1 = bool2;
          if (paramFloat1 <= this.popupEmo.getRight())
          {
            bool1 = bool2;
            if (paramFloat2 >= this.popupEmo.getTop())
            {
              bool1 = bool2;
              if (paramFloat2 <= this.popupEmo.getBottom()) {
                bool1 = true;
              }
            }
          }
        }
        return bool1;
      }
      bool1 = bool3;
      if (paramFloat1 >= this.popupEmo.getLeft())
      {
        bool1 = bool3;
        if (paramFloat1 <= this.popupEmo.getRight())
        {
          bool1 = bool3;
          if (paramFloat2 >= this.popupEmo.getTop() + this.lowVersionOffset)
          {
            bool1 = bool3;
            if (paramFloat2 <= this.popupEmo.getBottom() + this.lowVersionOffset) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  boolean isTouchedAboveOutsideArea(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat3 = paramFloat2 - paramFloat4;
    return (Math.sqrt(paramFloat1 * paramFloat1 + paramFloat3 * paramFloat3) < 50.0D) && ((paramFloat2 > this.mBottom) || (paramFloat2 < this.mTop));
  }
  
  void makeToast(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("makeToast, content = ");
      localStringBuilder.append(paramString);
      QLog.i("StickerGestureDetector", 2, localStringBuilder.toString());
    }
    QQToast.a(this.mContext, paramString, 0).b(this.mContext.getResources().getDimensionPixelSize(2131299168));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject1 = this.mBaseChatPie;
    if (localObject1 != null)
    {
      localObject1 = AIOEmoticonUIHelper.a(((BaseChatPie)localObject1).b());
      if ((localObject1 != null) && (((IEmoticonMainPanel)localObject1).showStickerGuide()))
      {
        localObject1 = this.mRootView;
        if (localObject1 != null)
        {
          localObject1 = ((TopGestureLayout)localObject1).findViewById(2131374090);
          if (localObject1 != null) {
            return ((View)localObject1).onTouchEvent(paramMotionEvent);
          }
        }
      }
    }
    if (EmojiStickerManager.jdField_d_of_type_Boolean)
    {
      localObject1 = this.mRootView;
      if (localObject1 != null)
      {
        localObject1 = ((TopGestureLayout)localObject1).findViewById(2131374089);
        if (localObject1 != null) {
          return ((View)localObject1).onTouchEvent(paramMotionEvent);
        }
      }
    }
    if (EmojiStickerManager.jdField_e_of_type_Boolean)
    {
      localObject1 = this.mRootView;
      if (localObject1 != null)
      {
        localObject1 = ((TopGestureLayout)localObject1).findViewById(2131374092);
        if (localObject1 != null) {
          return ((View)localObject1).onTouchEvent(paramMotionEvent);
        }
      }
    }
    int i = paramMotionEvent.getPointerCount();
    label666:
    int j;
    if (i == 1)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.lastX = paramMotionEvent.getRawX();
        this.lastY = paramMotionEvent.getRawY();
        this.isInTowFingerMode = false;
      }
      Object localObject2;
      Object localObject3;
      label1917:
      label2431:
      boolean bool2;
      label3127:
      label3399:
      boolean bool1;
      if (havePopuoEmo())
      {
        float f1 = this.popupEmo.getLeft();
        float f6 = this.popupEmo.getTop();
        float f3 = this.popupEmo.getRight();
        float f2 = this.popupEmo.getBottom();
        if ((!isTouchedAboveEmotionWithButtons(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) && (this.isFirstUpInvoked))
        {
          if (paramMotionEvent.getAction() == 0)
          {
            this.lastOutAction = 0;
            this.lastOutDownX = paramMotionEvent.getRawX();
            this.lastOutDownY = paramMotionEvent.getRawY();
          }
          else if (paramMotionEvent.getAction() == 1)
          {
            localObject1 = this.mBaseChatPie;
            if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
            {
              this.mBottom = (this.mTop - this.lowVersionOffset + this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getMeasuredHeight() - this.titleBarHeight);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("line 7 mBottom = ");
                ((StringBuilder)localObject1).append(this.mBottom);
                QLog.i("StickerGestureDetector", 2, ((StringBuilder)localObject1).toString());
              }
              setSmoothScrollMode(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.SCROLL_STOP);
            }
            if ((this.enteredAIO) && (isTouchedAboveOutsideArea(this.lastOutDownX, this.lastOutDownY, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())))
            {
              paramMotionEvent = this.mBaseChatPie;
              if ((paramMotionEvent != null) && (this.mRootView != null))
              {
                paramMotionEvent = AIOEmoticonUIHelper.a(paramMotionEvent.b());
                if ((paramMotionEvent != null) && (!paramMotionEvent.isHiden()))
                {
                  this.mBaseChatPie.Q();
                }
                else
                {
                  playDismissAnimation(f1, f6);
                  EmojiStickerManager.jdField_a_of_type_Boolean = false;
                  this.mBaseChatPie.i(false);
                  this.mBaseChatPie.a(false, false);
                  this.enteredAIO = false;
                  this.isFirstUpInvoked = false;
                  VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "CancelSendX", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                }
              }
            }
            else if ((this.mBaseChatPie != null) && (isTouchedAboveAIOArea(this.lastOutDownX, this.lastOutDownY, paramMotionEvent.getRawX(), paramMotionEvent.getRawY())))
            {
              this.mBaseChatPie.Q();
            }
            this.lastOutAction = 1;
            this.lastOutDownX = -1.0F;
            this.lastOutDownY = -1.0F;
          }
        }
        else
        {
          i = paramMotionEvent.getAction();
          if (i == 0) {
            break label7397;
          }
          if (i == 1) {
            break label1917;
          }
          if (i == 2) {
            break label666;
          }
        }
        float f7;
        float f8;
        float f5;
        float f4;
        double d1;
        int k;
        do
        {
          for (;;)
          {
            return true;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("event = ");
              ((StringBuilder)localObject1).append(paramMotionEvent.getAction());
              QLog.d("StickerGestureDetector", 2, ((StringBuilder)localObject1).toString());
            }
            if ((this.popupEmo != null) && ((isTouchedAboveEmotion(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) || (!this.isFirstUpInvoked)))
            {
              localObject1 = this.mBaseChatPie;
              if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
              {
                localObject1 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                if (f2 <= this.mTop + ((ChatXListView)localObject1).getMeasuredHeight() - this.lowVersionOffset - this.titleBarHeight) {
                  i = 1;
                } else {
                  i = 0;
                }
                if (!this.enteredAIO)
                {
                  if (i != 0)
                  {
                    this.enteredAIO = true;
                    if (this.isFirstUpInvoked) {
                      this.mBottom = (this.mTop - this.lowVersionOffset + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight);
                    }
                    if (QLog.isColorLevel())
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append("1 mBottom = ");
                      ((StringBuilder)localObject1).append(this.mBottom);
                      ((StringBuilder)localObject1).append(" isFirstUpInvoked = ");
                      ((StringBuilder)localObject1).append(this.isFirstUpInvoked);
                      QLog.i("StickerGestureDetector", 2, ((StringBuilder)localObject1).toString());
                    }
                  }
                }
                else
                {
                  if (i == 0) {
                    this.enteredAIO = false;
                  }
                  if (this.isFirstUpInvoked)
                  {
                    localObject2 = this.cancel;
                    if ((localObject2 == null) || (((ImageView)localObject2).getVisibility() == 0))
                    {
                      localObject2 = this.confirm;
                      if ((localObject2 == null) || (((ImageView)localObject2).getVisibility() == 0)) {}
                    }
                    else
                    {
                      stickerButtonAnimation(true);
                    }
                    this.mBottom = (this.mTop - this.lowVersionOffset + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight);
                  }
                  if (QLog.isColorLevel())
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("2 mBottom = ");
                    ((StringBuilder)localObject1).append(this.mBottom);
                    ((StringBuilder)localObject1).append(" isFirstUpInvoked = ");
                    ((StringBuilder)localObject1).append(this.isFirstUpInvoked);
                    QLog.i("StickerGestureDetector", 2, ((StringBuilder)localObject1).toString());
                  }
                }
              }
              f7 = paramMotionEvent.getRawX() - this.lastX;
              f8 = paramMotionEvent.getRawY() - this.lastY;
              f3 = f1 + f7;
              f5 = f6 + f8;
              f1 = this.popupEmo.getWidth() + f3;
              f6 = this.popupEmo.getHeight() + f5;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("sticker move OLD, left = ");
                ((StringBuilder)localObject1).append(f3);
                ((StringBuilder)localObject1).append(" top = ");
                ((StringBuilder)localObject1).append(f5);
                ((StringBuilder)localObject1).append(" right = ");
                ((StringBuilder)localObject1).append(f1);
                ((StringBuilder)localObject1).append(" bottom = ");
                ((StringBuilder)localObject1).append(f6);
                ((StringBuilder)localObject1).append(" distanceX = ");
                ((StringBuilder)localObject1).append(f7);
                ((StringBuilder)localObject1).append(" distanceY = ");
                ((StringBuilder)localObject1).append(f8);
                QLog.i("StickerGestureDetector", 2, ((StringBuilder)localObject1).toString());
              }
              i = this.mLeft;
              f2 = f3;
              if (f3 < i)
              {
                f2 = i;
                f1 = this.popupEmo.getWidth() + f2;
              }
              i = this.mRight;
              f3 = f1;
              f4 = f2;
              if (f1 > i)
              {
                f3 = i;
                f4 = f3 - this.popupEmo.getWidth();
              }
              i = this.mTop;
              j = this.lowVersionOffset;
              f1 = f6;
              f2 = f5;
              if (f5 < i - j)
              {
                f2 = i - j;
                f1 = this.popupEmo.getHeight() + f2;
              }
              i = this.mBottom;
              f5 = f1;
              if (f1 > i)
              {
                f5 = i;
                f2 = f5 - this.popupEmo.getHeight();
              }
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("sticker move NEW, left = ");
                ((StringBuilder)localObject1).append(f4);
                ((StringBuilder)localObject1).append(" top = ");
                ((StringBuilder)localObject1).append(f2);
                ((StringBuilder)localObject1).append(" right = ");
                ((StringBuilder)localObject1).append(f3);
                ((StringBuilder)localObject1).append(" bottom = ");
                ((StringBuilder)localObject1).append(f5);
                ((StringBuilder)localObject1).append(" distanceX = ");
                ((StringBuilder)localObject1).append(f7);
                ((StringBuilder)localObject1).append(" distanceY = ");
                ((StringBuilder)localObject1).append(f8);
                QLog.i("StickerGestureDetector", 2, ((StringBuilder)localObject1).toString());
              }
              if ((this.mRootView != null) && (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
              {
                localObject3 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                d1 = this.scale;
                d1 = this.stickerWidth;
                d1 = this.stickerHeight;
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
              if (this.popupEmo.getWidth() == (int)(this.density * 110.0F))
              {
                d1 = f4;
                Double.isNaN(d1);
                i = (int)(d1 + 0.5D);
                d1 = f2;
                Double.isNaN(d1);
                j = (int)(d1 + 0.5D);
                d1 = f3;
                Double.isNaN(d1);
                k = (int)(d1 + 0.5D);
                d1 = f5;
                Double.isNaN(d1);
                stickerLayout(i, j, k, (int)(d1 + 0.5D));
              }
              this.lastX = paramMotionEvent.getRawX();
              this.lastY = paramMotionEvent.getRawY();
              paramMotionEvent = this.mBaseChatPie;
              if ((paramMotionEvent != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
              {
                paramMotionEvent = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                if (Math.abs(f2 - this.mTop + this.lowVersionOffset) < 15.0F)
                {
                  if (!this.scrolling) {
                    setSmoothScrollMode(paramMotionEvent, this.SCROLL_UP);
                  }
                }
                else if (Math.abs(f5 - this.mBottom) < 15.0F)
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
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("event = ");
            ((StringBuilder)localObject1).append(paramMotionEvent.getAction());
            QLog.i("StickerGestureDetector", 2, ((StringBuilder)localObject1).toString());
          }
          if ((!this.isFirstUpInvoked) && (this.enteredAIO))
          {
            localObject1 = this.mBaseChatPie;
            if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
            {
              localObject1 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
              EmojiStickerManager.jdField_a_of_type_Boolean = true;
              this.mBaseChatPie.i(true);
              stickerButtonAnimation(true);
              this.mBottom = (this.mTop - this.lowVersionOffset + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("10 mBottom = ");
                ((StringBuilder)localObject1).append(this.mBottom);
                QLog.i("StickerGestureDetector", 2, ((StringBuilder)localObject1).toString());
              }
              localObject1 = this.popupEmo.getTag();
              if ((localObject1 instanceof IPicEmoticonInfo))
              {
                this.stickerReportType = 5;
              }
              else if ((localObject1 instanceof Emoticon))
              {
                this.stickerReportType = 1;
              }
              else if ((localObject1 instanceof SystemAndEmojiEmoticonInfo))
              {
                localObject1 = (SystemAndEmojiEmoticonInfo)localObject1;
                if (((SystemAndEmojiEmoticonInfo)localObject1).emotionType == 1) {
                  this.stickerReportType = 2;
                } else if (((SystemAndEmojiEmoticonInfo)localObject1).emotionType == 2) {
                  this.stickerReportType = 3;
                }
              }
              else if ((localObject1 instanceof ISmallEmoticonInfo))
              {
                this.stickerReportType = 4;
              }
              else if ((localObject1 instanceof IFavoriteEmoticonInfo))
              {
                this.stickerReportType = 5;
              }
              VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "DragToAIO", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", String.valueOf(this.stickerType), "", "", "", 0, 0, 0, 0);
            }
          }
          this.isFirstUpInvoked = true;
          if ((!this.enteredAIO) && (this.mRootView != null))
          {
            localObject1 = this.mBaseChatPie;
            if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
            {
              localObject1 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
              localObject2 = AIOEmoticonUIHelper.a(this.mBaseChatPie.b());
              if (localObject2 != null)
              {
                ((IEmoticonMainPanel)localObject2).getGlobalVisibleRect(this.panelRect);
                if ((this.panelRect.top == 0) && (this.panelRect.bottom == 0))
                {
                  i = this.mTop - this.lowVersionOffset + ((ChatXListView)localObject1).getMeasuredHeight();
                  j = this.titleBarHeight;
                }
                else
                {
                  i = this.panelRect.top;
                  break label2431;
                }
              }
              else
              {
                i = this.mTop - this.lowVersionOffset + ((ChatXListView)localObject1).getMeasuredHeight();
                j = this.titleBarHeight;
              }
              i -= j;
              judgeIfEnteredAIO(f1, f6, f3, f2, paramMotionEvent, (ListView)localObject1, i);
            }
          }
          localObject1 = this.mBaseChatPie;
          if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
            setSmoothScrollMode(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.SCROLL_STOP);
          }
        } while (this.lastMotionAction != 0);
        if (isTouchedAboveCancel(this.lastDownX, this.lastDownY, paramMotionEvent))
        {
          if (QLog.isColorLevel()) {
            QLog.i("StickerGestureDetector", 2, "isTouchedAboveCancel invoked");
          }
          EmojiStickerManager.jdField_a_of_type_Boolean = false;
          this.mBaseChatPie.i(false);
          this.mBaseChatPie.a(false, false);
          this.enteredAIO = false;
          this.isFirstUpInvoked = false;
          this.mBottom = this.mRootView.getBottom();
          if (QLog.isColorLevel())
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("line 5 mBottom = ");
            paramMotionEvent.append(this.mBottom);
            QLog.i("StickerGestureDetector", 2, paramMotionEvent.toString());
          }
          playDismissAnimation(f1, f6);
          if ((this.popupEmo.getTag(2131374091) instanceof Integer)) {
            i = ((Integer)this.popupEmo.getTag(2131374091)).intValue();
          } else {
            i = 4;
          }
          if (i == 4)
          {
            paramMotionEvent = this.mBaseChatPie;
            if (paramMotionEvent != null) {
              paramMotionEvent.ak();
            }
          }
          VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "CancelSend", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
        }
        for (;;)
        {
          return true;
          if (!isTouchedAboveConfirm(this.lastDownX, this.lastDownY, paramMotionEvent)) {
            break label7376;
          }
          if (QLog.isColorLevel()) {
            QLog.i("StickerGestureDetector", 2, "isTouchedAboveConfirm invoked");
          }
          MobileReportManager.getInstance().reportAction("tie_emoji", "4", "platform898", "6", "3", 102, 1, System.currentTimeMillis());
          if (this.mRootView == null) {
            break label7374;
          }
          if ((this.popupEmo.getTag(2131374091) instanceof Integer)) {
            i = ((Integer)this.popupEmo.getTag(2131374091)).intValue();
          } else {
            i = 4;
          }
          if ((i != 3) || (VasUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isSVip())) {
            break;
          }
          showOpenVip();
        }
        if (i == 4)
        {
          paramMotionEvent = this.mBaseChatPie;
          if (paramMotionEvent != null) {
            paramMotionEvent.ak();
          }
        }
        if (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
        {
          Object localObject6 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
          d1 = this.scale;
          Object localObject7 = "StickerGestureDetector";
          int i15 = (int)((d1 - 1.0D) * this.stickerWidth / 2.0D);
          int m = (int)((d1 - 1.0D) * this.stickerHeight / 2.0D);
          paramMotionEvent = this.currentChooseLayout;
          if (paramMotionEvent == null) {
            paramMotionEvent = findBiggestIntersectAreaView((int)((f6 + f2) / 2.0F), this.childRect, (ViewGroup)localObject6);
          }
          f5 = f2;
          if ((paramMotionEvent instanceof BaseChatItemLayout))
          {
            Object localObject8 = (BaseChatItemLayout)paramMotionEvent;
            if ((((BaseChatItemLayout)localObject8).d()) && (this.enteredAIO))
            {
              j = this.childRect.top;
              i = this.childRect.bottom;
              k = ((BaseChatItemLayout)localObject8).getTop();
              int i2 = this.titleBarHeight;
              if (k < i2) {
                j = this.mTop - i2 + ((BaseChatItemLayout)localObject8).getTop();
              }
              k = i;
              if (((BaseChatItemLayout)localObject8).getBottom() > ((ChatXListView)localObject6).getMeasuredHeight()) {
                k = i + ((BaseChatItemLayout)localObject8).getBottom() - ((ChatXListView)localObject6).getMeasuredHeight();
              }
              paramMotionEvent = this.popupEmo.getTag();
              Object localObject4;
              Object localObject5;
              if ((paramMotionEvent instanceof IPicEmoticonInfo))
              {
                localObject1 = (IPicEmoticonInfo)paramMotionEvent;
                localObject2 = null;
                localObject4 = null;
                localObject3 = null;
                localObject5 = null;
              }
              else
              {
                if ((paramMotionEvent instanceof Emoticon)) {}
                for (localObject2 = (Emoticon)paramMotionEvent;; localObject2 = null)
                {
                  localObject1 = null;
                  break;
                  if ((paramMotionEvent instanceof SystemAndEmojiEmoticonInfo))
                  {
                    localObject4 = (SystemAndEmojiEmoticonInfo)paramMotionEvent;
                    localObject2 = null;
                    localObject1 = null;
                    break label3127;
                  }
                  if ((paramMotionEvent instanceof ISmallEmoticonInfo))
                  {
                    localObject5 = (ISmallEmoticonInfo)paramMotionEvent;
                    localObject2 = null;
                    localObject1 = null;
                    localObject3 = null;
                    localObject4 = null;
                    break label3239;
                  }
                  if ((paramMotionEvent instanceof IFavoriteEmoticonInfo))
                  {
                    localObject3 = (IFavoriteEmoticonInfo)paramMotionEvent;
                    localObject1 = null;
                    localObject4 = null;
                    localObject5 = null;
                    localObject2 = null;
                    break label3239;
                  }
                }
              }
              label3239:
              if ((!EmojiStickerManager.g) && (FileUtils.getAvailableInnernalMemorySize() > 1.048576E+008F)) {
                i = 1;
              } else {
                i = 0;
              }
              double d2;
              if ((localObject1 != null) && (((IPicEmoticonInfo)localObject1).getEmoticon() != null))
              {
                if (i != 0)
                {
                  d1 = this.popupEmo.getWidth();
                  d2 = this.scale;
                  Double.isNaN(d1);
                  i = (int)(d1 * d2);
                  d1 = this.popupEmo.getHeight();
                  d2 = this.scale;
                  Double.isNaN(d1);
                  paramMotionEvent = ((IPicEmoticonInfo)localObject1).getLoadingDrawable("fromAIO", true, false, null, i, (int)(d1 * d2));
                }
                else
                {
                  paramMotionEvent = ((IPicEmoticonInfo)localObject1).getDrawable(this.mContext, this.density);
                }
              }
              else
              {
                if (localObject4 == null) {
                  break label3399;
                }
                paramMotionEvent = ((SystemAndEmojiEmoticonInfo)localObject4).getBigDrawable(this.mContext, this.density);
              }
              for (;;)
              {
                localObject9 = paramMotionEvent;
                break label3473;
                if (localObject2 != null)
                {
                  paramMotionEvent = EmojiStickerManager.a().a(this.mContext, (Emoticon)localObject2);
                }
                else if (localObject5 != null)
                {
                  paramMotionEvent = ((ISmallEmoticonInfo)localObject5).getBigDrawable(this.mContext, this.density);
                }
                else
                {
                  if (localObject3 == null) {
                    break;
                  }
                  paramMotionEvent = ((IFavoriteEmoticonInfo)localObject3).getBigDrawable(this.mContext, this.density, 0, 0);
                }
              }
              Object localObject9 = null;
              label3473:
              i = m;
              int i4 = j;
              boolean bool4;
              Object localObject10;
              int i3;
              boolean bool3;
              int i6;
              int i5;
              label4289:
              label4430:
              label4445:
              int i1;
              if (localObject9 != null)
              {
                int i10 = ((BaseChatItemLayout)localObject8).getChildCount() - 1;
                bool4 = false;
                localObject10 = null;
                bool2 = false;
                i3 = 0;
                i2 = 0;
                bool3 = false;
                m = 0;
                int i7 = 0;
                bool1 = false;
                i6 = 0;
                i5 = 0;
                f2 = 0.0F;
                j = 0;
                int i9 = k;
                k = i7;
                paramMotionEvent = (MotionEvent)localObject8;
                while (i10 >= 0)
                {
                  View localView = paramMotionEvent.getChildAt(i10);
                  if (localView != null) {
                    if (localView.getId() == 2131364521)
                    {
                      Object localObject14 = new Rect();
                      localView.getGlobalVisibleRect((Rect)localObject14);
                      d1 = f1;
                      Double.isNaN(d1);
                      int i16 = (int)(d1 + 0.5D);
                      i5 = this.widthPaddingOffset;
                      d1 = this.clicpXoffset;
                      i6 = (int)d1;
                      localObject12 = localObject3;
                      d2 = f6;
                      Double.isNaN(d2);
                      i7 = (int)(d2 + 0.5D);
                      localObject11 = localObject4;
                      d2 = f3;
                      Double.isNaN(d2);
                      int i8 = (int)(d2 + 0.5D);
                      int i12 = (int)d1;
                      d1 = f5;
                      Double.isNaN(d1);
                      int i17 = (int)(d1 + 0.5D);
                      localObject8 = localObject2;
                      Object localObject13 = localObject5;
                      f4 = f1;
                      int i11 = i4;
                      bool4 = isInAllowedArea(i6 + (i16 - i15 + i5), i7 - i, i8 + i15 - i5 - i12, i17 + i, (Rect)localObject14);
                      boolean bool5 = bool4;
                      i5 = ((Rect)localObject14).left;
                      i6 = localView.getTop() + i11;
                      localObject10 = (ChatMessage)localView.getTag(2131364568);
                      if ((!bool5) && (localObject10 != null)) {
                        if (((ChatMessage)localObject10).isSend()) {
                          j = ((Rect)localObject14).left + BaseChatItemLayout.k - this.popupEmo.getWidth() - i15 + this.widthPaddingOffset + (int)this.clicpXoffset;
                        } else {
                          j = ((Rect)localObject14).right - BaseChatItemLayout.k + i15 - this.widthPaddingOffset - (int)this.clicpXoffset;
                        }
                      }
                      if (paramMotionEvent.getParent() == null)
                      {
                        i4 = 1;
                        QLog.e((String)localObject7, 1, "itemView.getParent == null");
                        localObject2 = localObject7;
                        localObject9 = localObject1;
                        localObject4 = localObject6;
                        i7 = j;
                        bool4 = bool5;
                        j = i6;
                        localObject5 = localObject10;
                        i6 = i;
                        i = i7;
                        localObject3 = localObject8;
                        localObject6 = localObject13;
                        localObject7 = localObject12;
                        localObject8 = localObject11;
                        f1 = f4;
                        localObject1 = localObject2;
                        localObject2 = localObject9;
                        break label5468;
                      }
                      i7 = ((ChatXListView)localObject6).getPositionForView(paramMotionEvent);
                      i8 = ((ChatXListView)localObject6).getCount() - ((ChatXListView)localObject6).getHeaderViewsCount() - ((ChatXListView)localObject6).getFooterViewsCount();
                      localObject11 = localObject9;
                      if (i8 - i7 - 1 <= 20) {
                        bool3 = true;
                      } else {
                        bool3 = false;
                      }
                      if (QLog.isColorLevel())
                      {
                        localObject12 = new StringBuilder();
                        ((StringBuilder)localObject12).append("isLastTwenty = ");
                        ((StringBuilder)localObject12).append(bool3);
                        ((StringBuilder)localObject12).append(" itemCount = ");
                        ((StringBuilder)localObject12).append(i8);
                        ((StringBuilder)localObject12).append(" currentPosition = ");
                        ((StringBuilder)localObject12).append(i7);
                        ((StringBuilder)localObject12).append(" headerViewsCount = ");
                        ((StringBuilder)localObject12).append(((ChatXListView)localObject6).getHeaderViewsCount());
                        ((StringBuilder)localObject12).append(" footerViewsCount = ");
                        ((StringBuilder)localObject12).append(((ChatXListView)localObject6).getFooterViewsCount());
                        QLog.i((String)localObject7, 2, ((StringBuilder)localObject12).toString());
                      }
                      localObject12 = paramMotionEvent;
                      int n;
                      if (localObject10 != null)
                      {
                        boolean bool6 = EmojiStickerManager.d((MessageRecord)localObject10);
                        if (((ChatMessage)localObject10).istroop == 0 ? ((ChatMessage)localObject10).msgUid != 0L : ((ChatMessage)localObject10).shmsgseq != 0L) {
                          i2 = 1;
                        } else {
                          i2 = 0;
                        }
                        int i13 = android.text.TextUtils.isEmpty(((ChatMessage)localObject10).getExtInfoFromExtStr("message_is_sticker")) ^ true;
                        if ((localObject10 instanceof MessageForMixedMsg))
                        {
                          localObject13 = (MessageForMixedMsg)localObject10;
                          if (((MessageForMixedMsg)localObject13).msgElemList != null)
                          {
                            localObject13 = ((MessageForMixedMsg)localObject13).msgElemList.iterator();
                            m = 0;
                            while (((Iterator)localObject13).hasNext()) {
                              if (((MessageRecord)((Iterator)localObject13).next()).msgtype == -2000) {
                                m += 1;
                              }
                            }
                          }
                          else
                          {
                            m = 0;
                          }
                          if (m > 1)
                          {
                            i3 = 1;
                            break label4289;
                          }
                        }
                        i3 = 0;
                        localObject13 = EmojiStickerManager.a((MessageRecord)localObject10);
                        localObject14 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.mBaseChatPie.o()).iterator();
                        while (((Iterator)localObject14).hasNext())
                        {
                          ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject14).next();
                          Object localObject15;
                          if ((localChatMessage instanceof MessageForMarketFace))
                          {
                            localObject15 = (MessageForMarketFace)localChatMessage;
                            if ((((MessageForMarketFace)localObject15).mMarkFaceMessage != null) && (((MessageForMarketFace)localObject15).mMarkFaceMessage.stickerInfo != null))
                            {
                              m = 1;
                              break label4445;
                            }
                          }
                          else
                          {
                            if (((localChatMessage instanceof MessageForText)) || ((localChatMessage instanceof MessageForPic))) {
                              break label4430;
                            }
                          }
                          m = 0;
                          break label4445;
                          n = android.text.TextUtils.isEmpty(localChatMessage.getExtInfoFromExtStr("sticker_info")) ^ true;
                          if ((!(localChatMessage instanceof MessageForUniteGrayTip)) && (n == 0))
                          {
                            localObject15 = EmojiStickerManager.a(localChatMessage);
                            if ((localObject15 != null) && (((Pair)localObject15).equals(localObject13)) && (localChatMessage != localObject10))
                            {
                              n = 1;
                              break label4499;
                            }
                          }
                        }
                        n = 0;
                        label4499:
                        if ((EmojiStickerManager.b((MessageRecord)localObject10)) && (i2 != 0) && (i3 == 0) && (n == 0)) {
                          n = 1;
                        } else {
                          n = 0;
                        }
                        if ((EmojiStickerManager.jdField_d_of_type_Long > ((ChatMessage)localObject10).time) && ((localObject10 instanceof MessageForMarketFace))) {
                          i8 = 1;
                        } else {
                          i8 = 0;
                        }
                        bool2 = bool6;
                        i3 = i8;
                        i2 = i13;
                        i7 = n;
                        if ((localObject10 instanceof MessageForMarketFace))
                        {
                          localObject13 = (MessageForMarketFace)localObject10;
                          if ((((MessageForMarketFace)localObject13).mMarkFaceMessage != null) && (((MessageForMarketFace)localObject13).mMarkFaceMessage.stickerInfo != null))
                          {
                            k = 1;
                            bool2 = bool6;
                            i3 = i8;
                            i2 = i13;
                            i7 = n;
                          }
                          else
                          {
                            k = 0;
                            bool2 = bool6;
                            i3 = i8;
                            i2 = i13;
                            i7 = n;
                          }
                        }
                      }
                      else
                      {
                        i7 = n;
                      }
                      localObject13 = localObject1;
                      if ((localObject10 != null) && (((ChatMessage)localObject10).extraflag != 32772) && (((ChatMessage)localObject10).extraflag != 32768) && (bool3) && (bool5) && (((ChatMessage)localObject10).msgtype != -2009) && (((ChatMessage)localObject10).msgtype != -2016) && (!(localObject10 instanceof MessageForLongMsg)) && (!(localObject10 instanceof MessageForLongTextMsg)) && (bool2) && (i7 != 0) && (i3 == 0) && (k == 0) && (i2 == 0))
                      {
                        if ((localObject13 != null) && (((IPicEmoticonInfo)localObject13).getEmoticon() != null)) {
                          localObject8 = ((IPicEmoticonInfo)localObject13).getEmoticon().epId;
                        } else if (localObject8 != null) {
                          localObject8 = ((Emoticon)localObject8).epId;
                        } else {
                          localObject8 = "";
                        }
                        i8 = i;
                        int i14;
                        int i18;
                        int i19;
                        int i20;
                        if (f6 - i8 + this.lowVersionOffset > i11)
                        {
                          i1 = this.widthPaddingOffset;
                          i14 = (int)this.clicpXoffset;
                          i17 = this.childRect.left;
                          i18 = localView.getLeft();
                          d1 = this.lowVersionOffset + f6;
                          Double.isNaN(d1);
                          i19 = (int)(d1 + 0.5D);
                          i20 = this.childRect.top;
                          int i21 = this.heightPaddingOffset;
                          int i22 = (int)this.clicpYoffset;
                          d1 = this.stickerWidth;
                          d2 = this.scale;
                          bool1 = ((BaseChatItemLayout)localObject12).a(localObject11, i16 + i1 + i14 - i15 - i17 - i18, i19 - i20 - i8 + i21 + i22, (int)(d1 * d2), (int)(this.stickerHeight * d2), this.angle, (String)localObject8, true, 1.0F, null);
                          d1 = this.lowVersionOffset + f6;
                          Double.isNaN(d1);
                          i1 = (int)(d1 + 0.5D) - i8 + (int)this.stickerHeight;
                          if (i1 > i9) {
                            i1 -= i11;
                          } else {
                            i1 = 0;
                          }
                        }
                        else
                        {
                          i1 = this.widthPaddingOffset;
                          i14 = (int)this.clicpXoffset;
                          i17 = this.childRect.left;
                          i18 = localView.getLeft();
                          i19 = this.heightPaddingOffset;
                          i20 = (int)this.clicpYoffset;
                          d1 = this.stickerWidth;
                          d2 = this.scale;
                          bool5 = ((BaseChatItemLayout)localObject12).a(localObject11, i16 + i1 + i14 - i15 - i17 - i18, i19 + i20, (int)(d1 * d2), (int)(this.stickerHeight * d2), this.angle, (String)localObject8, true, 1.0F, null);
                          i1 = this.lowVersionOffset;
                          d1 = i1 + f6;
                          Double.isNaN(d1);
                          i14 = (int)(d1 + 0.5D);
                          i16 = (int)this.stickerHeight;
                          d1 = i1 + f6;
                          Double.isNaN(d1);
                          i1 = (int)(d1 + 0.5D);
                          i1 = ((BaseChatItemLayout)localObject12).getHeight() + (i11 - i1 + i8);
                          bool1 = bool5;
                          if (i14 - i8 + i16 > i9)
                          {
                            i1 = (int)this.stickerHeight;
                            bool1 = bool5;
                          }
                        }
                      }
                      else
                      {
                        i1 = 0;
                      }
                      f2 = i1 - ((BaseChatItemLayout)localObject12).getHeight();
                      localObject8 = this.mBaseChatPie.a();
                      if (localObject8 != null) {
                        ((AIOAnimationConatiner)localObject8).a();
                      }
                      i1 = i7;
                      i7 = i6;
                      i6 = i5;
                      i5 = i7;
                    }
                    else {}
                  }
                  i10 -= 1;
                }
                localObject8 = localObject2;
                localObject2 = localObject1;
                localObject9 = localObject3;
                Object localObject12 = localObject5;
                localObject1 = localObject7;
                Object localObject11 = localObject6;
                i7 = j;
                i4 = 0;
                j = i5;
                localObject5 = localObject10;
                i5 = i6;
                i6 = i;
                i = i7;
                localObject3 = localObject8;
                localObject6 = localObject12;
                localObject7 = localObject9;
                localObject8 = localObject4;
                localObject4 = localObject11;
              }
              else
              {
                localObject9 = localObject2;
                paramMotionEvent = (MotionEvent)localObject8;
                localObject8 = localObject4;
                localObject4 = localObject6;
                i6 = i;
                bool4 = false;
                j = 0;
                i4 = 0;
                localObject10 = null;
                i5 = 0;
                i = 0;
                bool2 = false;
                i3 = 0;
                i2 = 0;
                bool3 = false;
                i1 = 0;
                k = 0;
                bool1 = false;
                f2 = 0.0F;
                localObject2 = localObject1;
                localObject1 = localObject7;
                localObject7 = localObject3;
                localObject6 = localObject5;
                localObject3 = localObject9;
                localObject5 = localObject10;
              }
              label5468:
              localObject9 = this.lastIntersectChatLayout;
              if ((localObject9 != null) && ((localObject9 instanceof BaseChatItemLayout))) {
                ((BaseChatItemLayout)localObject9).setStickerPressStatus(false);
              }
              if (i4 != 0) {
                makeToast(HardCodeUtil.a(2131714184));
              }
              for (;;)
              {
                break;
                if (!bool2)
                {
                  makeToast(HardCodeUtil.a(2131714189));
                  VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 4, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                }
                else
                {
                  if (!bool4)
                  {
                    makeToast(HardCodeUtil.a(2131714197));
                    VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 5, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                    j = 1;
                    break label7028;
                  }
                  if (!bool3)
                  {
                    makeToast("只能贴最新的20条消息哦~");
                    VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 2, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                  }
                  else if (i2 != 0)
                  {
                    makeToast(HardCodeUtil.a(2131714185));
                  }
                  else if (i3 != 0)
                  {
                    makeToast(HardCodeUtil.a(2131714191));
                  }
                  else if ((!(localObject5 instanceof MessageForLongMsg)) && (!(localObject5 instanceof MessageForLongTextMsg)))
                  {
                    if ((i1 != 0) && (k == 0))
                    {
                      if ((this.mBaseChatPie != null) && (localObject5 != null)) {
                        if ((((ChatMessage)localObject5).extraflag != 32772) && (((ChatMessage)localObject5).extraflag != 32768))
                        {
                          if (bool1)
                          {
                            localObject9 = new StickerInfo();
                            f3 = i15;
                            f4 = this.childRect.left;
                            f5 = i5;
                            f7 = this.widthPaddingOffset;
                            f8 = (int)this.clicpXoffset;
                            k = this.screenWidth;
                            ((StickerInfo)localObject9).x = ((f1 - f3 - f4 - f5 + f7 + f8) / k);
                            ((StickerInfo)localObject9).y = ((f6 + this.lowVersionOffset - i6 - j + this.heightPaddingOffset + (int)this.clicpYoffset) / k);
                            d1 = this.stickerWidth;
                            d2 = this.scale;
                            ((StickerInfo)localObject9).width = ((float)(d1 * d2) / k);
                            ((StickerInfo)localObject9).height = ((float)(this.stickerHeight * d2) / k);
                            ((StickerInfo)localObject9).rotate = ((int)this.angle);
                            ((StickerInfo)localObject9).hostMsgSeq = ((ChatMessage)localObject5).shmsgseq;
                            ((StickerInfo)localObject9).hostMsgUid = ((ChatMessage)localObject5).msgUid;
                            ((StickerInfo)localObject9).hostMsgTime = ((ChatMessage)localObject5).time;
                            if (QLog.isColorLevel())
                            {
                              localObject10 = new StringBuilder();
                              ((StringBuilder)localObject10).append("StickerInfo send stickerInfo = ");
                              ((StringBuilder)localObject10).append(localObject9);
                              QLog.d((String)localObject1, 2, ((StringBuilder)localObject10).toString());
                            }
                            if (localObject2 != null)
                            {
                              localObject6 = localObject2;
                              ((IPicEmoticonInfo)localObject6).setStickerInfo((StickerInfo)localObject9);
                              ((ChatMessage)localObject5).stickerHidden = false;
                              localObject5 = (AIOEmoticonPanelHelper)this.mBaseChatPie.a(104);
                              if (localObject5 != null) {
                                ((AIOEmoticonPanelHelper)localObject5).send((EmoticonInfo)localObject6);
                              }
                            }
                            else if (localObject3 != null)
                            {
                              ChatActivityFacade.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mContext, this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Emoticon)localObject3, (StickerInfo)localObject9);
                            }
                            else if (localObject8 != null)
                            {
                              if (((SystemAndEmojiEmoticonInfo)localObject8).emotionType == 1) {
                                localObject5 = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemAndEmojiEmoticonInfo)localObject8).code);
                              } else {
                                localObject5 = com.tencent.mobileqq.text.TextUtils.getEmojiString(((SystemAndEmojiEmoticonInfo)localObject8).code);
                              }
                              send((String)localObject5, (StickerInfo)localObject9);
                            }
                            else if (localObject6 != null)
                            {
                              send(makeSmallEmojiString((ISmallEmoticonInfo)localObject6), (StickerInfo)localObject9);
                            }
                            else if (localObject7 != null)
                            {
                              ChatActivityFacade.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mContext, this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((IFavoriteEmoticonInfo)localObject7).getPath(), true, android.text.TextUtils.isEmpty(((IFavoriteEmoticonInfo)localObject7).getEid()) ^ true, ((IFavoriteEmoticonInfo)localObject7).getEid(), (StickerInfo)localObject9);
                            }
                            if ((localObject2 == null) && (localObject3 == null)) {
                              break label6459;
                            }
                            VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                            if (this.angle == 0.0D) {
                              if (this.scale == 1.0D) {
                                break label6459;
                              }
                            }
                            VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Adjust", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                            label6459:
                            if (f2 > 0.0F)
                            {
                              k = ((ChatXListView)localObject4).getPositionForView(paramMotionEvent);
                              i1 = ((ChatXListView)localObject4).getFirstVisiblePosition();
                              j = 0;
                              while (j < k - i1)
                              {
                                ObjectAnimator.ofPropertyValuesHolder(((ChatXListView)localObject4).getChildAt(j), new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("TranslationY", new float[] { f2, 0.0F }) }).setDuration(300L).start();
                                j += 1;
                              }
                            }
                            this.mRootView.post(new StickerGestureDetector.1(this));
                            EmojiStickerManager.jdField_a_of_type_Boolean = false;
                            this.mBaseChatPie.i(false);
                            this.mBaseChatPie.a(false, false);
                            removeStickerExpandView();
                            removeStickerMaskLayout();
                            this.isFirstUpInvoked = false;
                            this.enteredAIO = false;
                            this.mBottom = this.mRootView.getBottom();
                            this.scale = 1.0D;
                            this.angle = 0.0D;
                            localObject2 = this.lastIntersectView;
                            if (localObject2 != null)
                            {
                              changeBubbleBg((View)localObject2, false);
                              this.currentChooseLayout = null;
                            }
                            localObject2 = this.lastIntersectChatLayout;
                            if ((localObject2 != null) && ((localObject2 instanceof BaseChatItemLayout)))
                            {
                              ((BaseChatItemLayout)localObject2).setStickerPressStatus(false);
                              this.lastIntersectChatLayout = null;
                            }
                            EmojiStickerManager.b = false;
                            j = 0;
                            k = 1;
                            break label7031;
                          }
                        }
                        else
                        {
                          makeToast(HardCodeUtil.a(2131714186));
                          VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 8, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                        }
                      }
                    }
                    else
                    {
                      makeToast(HardCodeUtil.a(2131714188));
                      VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 3, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                    }
                  }
                  else
                  {
                    makeToast(HardCodeUtil.a(2131714182));
                    VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 3, 0, "", "", "", String.valueOf(this.stickerReportType), "", "", "", 0, 0, 0, 0);
                  }
                }
              }
              j = 0;
            }
            else
            {
              paramMotionEvent = (MotionEvent)localObject8;
              localObject1 = localObject7;
              if (!this.enteredAIO)
              {
                makeToast(HardCodeUtil.a(2131714190));
              }
              else
              {
                makeToast(String.format(HardCodeUtil.a(2131714196), new Object[] { Integer.valueOf(QVipStickerProcessor.b) }));
                VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 1, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
              }
              j = 0;
              i = 0;
            }
            label7028:
            k = 0;
            label7031:
            if ((this.currentChooseLayout instanceof BaseChatItemLayout)) {
              if (j != 0)
              {
                playCloseToMessageAnimation(i);
                localObject2 = this.lastIntersectView;
                if (localObject2 != null) {
                  changeBubbleBg((View)localObject2, true);
                }
                localObject2 = this.lastIntersectChatLayout;
                if ((localObject2 != null) && ((localObject2 instanceof BaseChatItemLayout))) {
                  ((BaseChatItemLayout)localObject2).setStickerPressStatus(true);
                }
              }
              else if (k == 0)
              {
                stickerJoggleAnimation();
              }
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("line 6 mBottom = ");
              ((StringBuilder)localObject2).append(this.mBottom);
              QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            paramMotionEvent.requestLayout();
          }
          else if (paramMotionEvent != null)
          {
            if ((paramMotionEvent instanceof ViewGroup))
            {
              makeToast(HardCodeUtil.a(2131714183));
              VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 3, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
            }
            else
            {
              makeToast(HardCodeUtil.a(2131714192));
              VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 5, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
            }
          }
          else
          {
            makeToast(HardCodeUtil.a(2131714195));
            VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Send", String.valueOf(this.currentChatPieType), 0, 5, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
        }
        label7374:
        return true;
        label7376:
        this.lastMotionAction = 1;
        this.lastDownX = -1.0F;
        this.lastDownY = -1.0F;
        return true;
        label7397:
        this.lastMotionAction = 0;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("event = ");
          ((StringBuilder)localObject1).append(paramMotionEvent.getAction());
          QLog.d("StickerGestureDetector", 2, ((StringBuilder)localObject1).toString());
        }
        this.lastX = paramMotionEvent.getRawX();
        this.lastY = paramMotionEvent.getRawY();
        f1 = this.lastX;
        this.lastDownX = f1;
        f2 = this.lastY;
        this.lastDownY = f2;
        return (isTouchedAboveEmotionWithButtons(f1, f2)) || (!this.isFirstUpInvoked);
      }
      if (paramMotionEvent.getAction() == 1)
      {
        localObject1 = this.mBaseChatPie;
        if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
        {
          localObject1 = this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
          i = ((ChatXListView)localObject1).getChildCount() - 1;
          for (bool1 = false; i >= 0; bool1 = bool2)
          {
            localObject2 = ((ChatXListView)localObject1).getChildAt(i);
            if ((localObject2 instanceof BaseChatItemLayout))
            {
              localObject2 = (BaseChatItemLayout)localObject2;
              bool2 = bool1;
              if (!bool1) {
                bool2 = ((BaseChatItemLayout)localObject2).e();
              }
              ((BaseChatItemLayout)localObject2).c();
            }
            else
            {
              bool2 = bool1;
              if ((localObject2 instanceof LinearLayout))
              {
                localObject2 = (LinearLayout)localObject2;
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
              }
            }
            i -= 1;
          }
          if (bool1) {
            if (this.currentDismissMode == EmojiStickerManager.jdField_d_of_type_Int) {
              VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "Hide", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
            } else {
              VasWebviewUtil.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "Stick", "CancelHide", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
            }
          }
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      if (havePopuoEmo())
      {
        j = paramMotionEvent.getAction() & paramMotionEvent.getActionMasked();
        if (j != 0) {
          if (j != 1) {
            if (j != 2) {
              if (j != 5) {
                if (j == 6) {}
              }
            }
          }
        }
        for (;;)
        {
          return true;
          this.m_list_coords.clear();
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
              this.m_list_coords.add(new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0)));
            }
          }
        }
      }
      localObject1 = BaseActivity.sTopActivity;
      if (((localObject1 instanceof BaseActivity)) && (((BaseActivity)localObject1).getChatFragment() != null))
      {
        localObject1 = ((BaseActivity)localObject1).getChatFragment().a();
        if ((((localObject1 instanceof BaseTroopChatPie)) || ((localObject1 instanceof FriendChatPie)) || ((localObject1 instanceof DiscussChatPie))) && (EmojiStickerManager.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
        {
          this.isInTowFingerMode = true;
          i = paramMotionEvent.getAction() & paramMotionEvent.getActionMasked();
          if (i != 0)
          {
            if (i != 2)
            {
              if (i != 5) {
                return true;
              }
              if (paramMotionEvent.getX(0) < paramMotionEvent.getX(1))
              {
                this.leftFinger = 0;
                this.rightFinger = 1;
                this.dismissFirstX = paramMotionEvent.getX(0);
                this.dismissFirstY = paramMotionEvent.getY(0);
                this.dismissSecondX = paramMotionEvent.getX(1);
                this.dismissSecondY = paramMotionEvent.getY(1);
                return true;
              }
              this.leftFinger = 1;
              this.rightFinger = 0;
              this.dismissFirstX = paramMotionEvent.getX(1);
              this.dismissFirstY = paramMotionEvent.getY(1);
              this.dismissSecondX = paramMotionEvent.getX(0);
              this.dismissSecondY = paramMotionEvent.getY(0);
            }
            else
            {
              caclLeftAndRightOffset(paramMotionEvent);
            }
          }
          else
          {
            this.dismissFirstX = paramMotionEvent.getX(0);
            this.dismissFirstY = paramMotionEvent.getY(0);
          }
          return true;
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  void playCloseToMessageAnimation(int paramInt)
  {
    Object localObject = this.popupEmo;
    if (localObject != null)
    {
      localObject = ((StickerFrameLayout)localObject).animate();
      ((ViewPropertyAnimator)localObject).x(paramInt);
      ((ViewPropertyAnimator)localObject).setListener(this.closeToMsgAnimationListener);
      ((ViewPropertyAnimator)localObject).setDuration(300L);
    }
  }
  
  void playDismissAnimation(float paramFloat1, float paramFloat2)
  {
    if (this.popupEmo != null)
    {
      Object localObject = this.mBaseChatPie;
      if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
      {
        localObject = this.popupEmo.animate();
        ((ViewPropertyAnimator)localObject).translationX(this.screenWidth / 2 - (paramFloat1 + this.popupEmo.getWidth() / 2)).translationY(this.mTop - this.lowVersionOffset + this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getMeasuredHeight() - this.titleBarHeight - paramFloat2);
        ((ViewPropertyAnimator)localObject).setListener(this.animationListener);
        ((ViewPropertyAnimator)localObject).setDuration(200L);
      }
    }
  }
  
  void removeStickerMaskLayout()
  {
    Object localObject = this.mBaseChatPie;
    if (localObject != null)
    {
      localObject = AIOEmoticonUIHelper.a(((BaseChatPie)localObject).b());
      if (localObject != null) {
        ((IEmoticonMainPanel)localObject).getView().removeView(((IEmoticonMainPanel)localObject).getStickerMaskLayout());
      }
    }
  }
  
  public void send(String paramString, StickerInfo paramStickerInfo)
  {
    AIOContext localAIOContext = this.mBaseChatPie.b();
    BaseSessionInfo localBaseSessionInfo = localAIOContext.a();
    if (((ReceiptHelper)this.mBaseChatPie.a(118)).jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" send start: currenttime:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, ((StringBuilder)localObject1).toString());
    }
    if (android.text.TextUtils.isEmpty(paramString))
    {
      QLog.e("EmojiStickerManager", 1, " send, emojiText is empty");
      return;
    }
    if ((paramString.length() > 0) && (paramStickerInfo != null))
    {
      Object localObject2 = (ReplyHelper)localAIOContext.a(119);
      ((ReplyHelper)localObject2).a(null);
      if (paramString.length() > 3478)
      {
        ChatActivityUtils.a(this.mContext, 2131718759, 1);
        return;
      }
      MessageSignal localMessageSignal = localAIOContext.a().a();
      localObject1 = new ChatActivityFacade.SendMsgParams();
      ((ChatActivityFacade.SendMsgParams)localObject1).b = localMessageSignal.b();
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_a_of_type_Int = localMessageSignal.a();
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_c_of_type_Boolean = localMessageSignal.a();
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_c_of_type_Int = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = ((ReplyHelper)localObject2).a();
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonStickerInfo = paramStickerInfo;
      paramStickerInfo = (AIOShortcutBarHelper)localAIOContext.a(52);
      if (paramStickerInfo != null)
      {
        localObject2 = new AIOShortcutBarHelper.AIOShortcutBarEvent(18);
        ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject2).a().putBoolean("isSendToRobotServer", false);
        paramStickerInfo.a((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject2);
        ((ChatActivityFacade.SendMsgParams)localObject1).i = ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject2).a().getBoolean("result", false);
      }
      if ((localBaseSessionInfo.jdField_a_of_type_Int != 1) && (localBaseSessionInfo.jdField_a_of_type_Int != 3000))
      {
        if (QLog.isColorLevel())
        {
          paramStickerInfo = new StringBuilder();
          paramStickerInfo.append(" send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:");
          paramStickerInfo.append(System.currentTimeMillis());
          QLog.d("SendMsgBtn", 2, paramStickerInfo.toString());
        }
        ChatActivityFacade.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mContext, (SessionInfo)localBaseSessionInfo, paramString, null, (ChatActivityFacade.SendMsgParams)localObject1);
        if (QLog.isColorLevel())
        {
          paramStickerInfo = new StringBuilder();
          paramStickerInfo.append(" send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:");
          paramStickerInfo.append(System.currentTimeMillis());
          QLog.d("SendMsgBtn", 2, paramStickerInfo.toString());
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramStickerInfo = new StringBuilder();
          paramStickerInfo.append(" send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:");
          paramStickerInfo.append(System.currentTimeMillis());
          QLog.d("SendMsgBtn", 2, paramStickerInfo.toString());
        }
        paramStickerInfo = new ArrayList();
        ChatActivityFacade.a(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mContext, (SessionInfo)localBaseSessionInfo, paramString, paramStickerInfo, (ChatActivityFacade.SendMsgParams)localObject1);
      }
      paramStickerInfo = (AIOEmoticonPanelHelper)localAIOContext.a(104);
      if (paramStickerInfo != null) {
        paramStickerInfo.reportClassicAndSmallEmoticon(paramString, false, this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (QLog.isColorLevel())
      {
        paramStickerInfo = new StringBuilder();
        paramStickerInfo.append(" msgReport start currenttime:");
        paramStickerInfo.append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, paramStickerInfo.toString());
      }
      localAIOContext.a(localBaseSessionInfo.jdField_c_of_type_Int, -1, "");
      if (QLog.isColorLevel())
      {
        paramStickerInfo = new StringBuilder();
        paramStickerInfo.append(" msgReport end currenttime:");
        paramStickerInfo.append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, paramStickerInfo.toString());
      }
      if (QLog.isColorLevel())
      {
        paramStickerInfo = new StringBuilder();
        paramStickerInfo.append(" send end currenttime:");
        paramStickerInfo.append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, paramStickerInfo.toString());
      }
      localAIOContext.a().a(1002, new Object[] { paramString });
      if (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2) {
        ReportController.b(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
      }
    }
    else
    {
      QLog.e("EmojiStickerManager", 1, " send, sticker info is empty");
    }
    paramString = ((ArkHelper)this.mBaseChatPie.a(110)).a();
    if (paramString != null) {
      paramString.c();
    }
  }
  
  public void setLastX(float paramFloat)
  {
    this.lastX = paramFloat;
  }
  
  public void setLastY(float paramFloat)
  {
    this.lastY = paramFloat;
  }
  
  void setSmoothScrollMode(ChatXListView paramChatXListView, int paramInt)
  {
    int i = paramChatXListView.getChildCount();
    int j = paramChatXListView.getCount();
    if (paramInt == this.SCROLL_UP)
    {
      this.scrolling = true;
      paramChatXListView.smoothScrollBy(-40000, 120000);
      return;
    }
    if (paramInt == this.SCROLL_DOWN)
    {
      this.scrolling = true;
      paramChatXListView.smoothScrollBy(40000, 120000);
      Object localObject = paramChatXListView.getChildAt(i - 1);
      try
      {
        if (j - 1 != paramChatXListView.getPositionForView((View)localObject)) {
          return;
        }
        ((View)localObject).getGlobalVisibleRect(this.firstOrLastRect);
        if ((Math.abs(this.firstOrLastRect.bottom - this.lowVersionOffset - this.mBottom) >= 15) || (this.mBaseChatPie == null)) {
          return;
        }
        ((EmojiStickerHelper)this.mBaseChatPie.a(133)).a();
        return;
      }
      catch (Exception paramChatXListView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setSmoothScrollMode exception = ");
        ((StringBuilder)localObject).append(paramChatXListView);
        QLog.e("StickerGestureDetector", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    else if (paramInt == this.SCROLL_STOP)
    {
      this.scrolling = false;
      paramChatXListView.smoothScrollBy(0, 0);
    }
  }
  
  @TargetApi(11)
  void showResult()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      Object localObject = this.popupEmo;
      if (localObject != null)
      {
        localObject = ((StickerFrameLayout)localObject).getStickerImage();
        if (localObject != null)
        {
          ((ImageView)localObject).setRotation((float)this.angle);
          ((ImageView)localObject).setScaleX((float)this.scale);
          ((ImageView)localObject).setScaleY((float)this.scale);
        }
      }
    }
  }
  
  void stickerButtonAnimation(boolean paramBoolean)
  {
    Object localObject = this.cancel;
    if ((localObject != null) && (this.confirm != null))
    {
      ((ImageView)localObject).setVisibility(0);
      this.confirm.setVisibility(0);
      float f1 = 1.0F;
      float f2 = 0.0F;
      if (paramBoolean)
      {
        f1 = 0.0F;
        f2 = 1.0F;
      }
      localObject = PropertyValuesHolder.ofFloat("alpha", new float[] { f1, f2 });
      PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("scaleX", new float[] { f1, f2 });
      PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleY", new float[] { f1, f2 });
      ObjectAnimator.ofPropertyValuesHolder(this.cancel, new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, localPropertyValuesHolder2 }).setDuration(300L).start();
      ObjectAnimator.ofPropertyValuesHolder(this.confirm, new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, localPropertyValuesHolder2 }).setDuration(300L).start();
      MobileReportManager.getInstance().reportAction("tie_emoji", "4", "platform898", "6", "3", 101, 1, System.currentTimeMillis());
    }
  }
  
  void stickerJoggleAnimation()
  {
    Object localObject = this.popupEmo;
    if (localObject != null)
    {
      localObject = ((StickerFrameLayout)localObject).getStickerImage();
      if (localObject != null)
      {
        float f1 = (float)this.angle;
        float f2 = f1 + 10.0F;
        float f3 = f1 - 10.0F;
        ObjectAnimator.ofPropertyValuesHolder(localObject, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("Rotation", new float[] { f2, f1, f3, f1, f2, f1, f3, f1 }) }).setDuration(400L).start();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGestureDetector
 * JD-Core Version:    0.7.0.1
 */