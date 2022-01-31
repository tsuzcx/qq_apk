package com.tencent.mobileqq.emoticonview;

import acoy;
import acoz;
import acpa;
import acpb;
import acpc;
import acpd;
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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StickerGestureDetector
  extends GestureDetector
{
  public double a;
  public float a;
  int jdField_a_of_type_Int;
  acpd jdField_a_of_type_Acpd = new acpd(this, null);
  Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new acoz(this);
  public Context a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public BaseChatPie a;
  public TopGestureLayout a;
  public EmojiStickerManager.StickerFrameLayout a;
  List jdField_a_of_type_JavaUtilList;
  public boolean a;
  public double b;
  public float b;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  public View b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  boolean jdField_b_of_type_Boolean = false;
  double jdField_c_of_type_Double = 0.0D;
  float jdField_c_of_type_Float;
  public int c;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  public View c;
  public boolean c;
  double jdField_d_of_type_Double = 0.0D;
  float jdField_d_of_type_Float;
  public int d;
  public View d;
  boolean jdField_d_of_type_Boolean = false;
  double jdField_e_of_type_Double = 0.0D;
  float jdField_e_of_type_Float;
  public int e;
  double jdField_f_of_type_Double = 0.0D;
  float jdField_f_of_type_Float;
  int jdField_f_of_type_Int;
  float jdField_g_of_type_Float;
  int jdField_g_of_type_Int;
  float jdField_h_of_type_Float;
  int jdField_h_of_type_Int;
  float jdField_i_of_type_Float;
  int jdField_i_of_type_Int;
  float jdField_j_of_type_Float;
  int jdField_j_of_type_Int;
  float jdField_k_of_type_Float;
  int jdField_k_of_type_Int = 0;
  int l = 1;
  int m = 0;
  int n = 1;
  int o = 2;
  int p;
  int q;
  int r;
  int s = 0;
  int t = 1;
  
  public StickerGestureDetector(Context paramContext, GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramSimpleOnGestureListener);
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 1.0D;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if ((paramBaseChatPie instanceof FriendChatPie))
      {
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c);
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_g_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
      this.jdField_h_of_type_Int = ((int)(this.jdField_g_of_type_Float * 5.0F));
      this.jdField_i_of_type_Int = ((int)(this.jdField_g_of_type_Float * 5.0F));
      this.jdField_j_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131558448);
      paramSimpleOnGestureListener = paramContext.getResources().getDisplayMetrics();
      this.q = paramSimpleOnGestureListener.widthPixels;
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label434;
      }
    }
    label434:
    for (int i1 = 0;; i1 = ImmersiveUtils.a(this.jdField_a_of_type_AndroidContentContext))
    {
      this.r = i1;
      this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getLeft();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getRight();
      this.jdField_e_of_type_Int = (ImmersiveUtils.a(paramContext) + this.jdField_j_of_type_Int);
      this.jdField_c_of_type_Int = (paramSimpleOnGestureListener.heightPixels - this.r);
      if (QLog.isColorLevel()) {
        QLog.i("StickerGestureDetector", 2, "line 8 mBottom = " + this.jdField_c_of_type_Int);
      }
      this.jdField_d_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramContext = new AbsListView.LayoutParams(-1, (int)(100.0F * this.jdField_g_of_type_Float));
      this.jdField_d_of_type_AndroidViewView.setLayoutParams(paramContext);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      return;
      if ((paramBaseChatPie instanceof BaseTroopChatPie))
      {
        this.jdField_a_of_type_Int = 2;
        break;
      }
      if (!(paramBaseChatPie instanceof DiscussChatPie)) {
        break;
      }
      this.jdField_a_of_type_Int = 3;
      break;
    }
  }
  
  private String a(SmallEmoticonInfo paramSmallEmoticonInfo)
  {
    if (paramSmallEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null)
    {
      QLog.e("StickerGestureDetector", 1, "makeSmallEmojiString, emotion == null");
      return "";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      try
      {
        int i1 = Integer.parseInt(paramSmallEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
        int i2 = Integer.parseInt(paramSmallEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
        paramSmallEmoticonInfo = EmosmUtils.a(i2, i1);
        EmoticonPackage localEmoticonPackage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(String.valueOf(i2));
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
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MotionEvent paramMotionEvent, ListView paramListView, int paramInt)
  {
    if (paramMotionEvent.getRawY() < paramInt)
    {
      this.jdField_c_of_type_Boolean = true;
      EmojiStickerManager.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(true);
      this.jdField_c_of_type_Int = (this.jdField_e_of_type_Int - this.r + paramListView.getMeasuredHeight() - this.jdField_j_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.i("StickerGestureDetector", 2, "line 3 mBottom = " + this.jdField_c_of_type_Int);
      }
      paramFloat2 = this.jdField_c_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getHeight();
      paramFloat4 = this.jdField_c_of_type_Int;
      a((int)(paramFloat1 + 0.5D), (int)(paramFloat2 + 0.5D), (int)(paramFloat3 + 0.5D), (int)(paramFloat4 + 0.5D));
      a(true);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.post(new acpa(this));
      EmojiStickerManager.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aN();
      a(this.jdField_a_of_type_AndroidViewView, false);
      if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof BaseChatItemLayout))) {
        ((BaseChatItemLayout)this.jdField_b_of_type_AndroidViewView).setStickerPressStatus(false);
      }
      EmojiStickerManager.jdField_b_of_type_Boolean = false;
      c();
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getBottom();
      this.jdField_b_of_type_Double = 1.0D;
      this.jdField_a_of_type_Double = 0.0D;
    } while (!QLog.isColorLevel());
    QLog.i("StickerGestureDetector", 2, "line 4 mBottom = " + this.jdField_c_of_type_Int);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerGestureDetector", 2, "showOpenVip invoked");
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle("温馨提示").setMessage("开通超级会员，可以贴收藏表情哦~").setPositiveButton("开通超级会员", new acpc(this)).setNegativeButton("取消", new acpb(this)).show();
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (EmojiStickerManager.a().jdField_a_of_type_Int != 0) {
        break label131;
      }
      i1 = 1;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "SVIPTip", String.valueOf(i1), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
      label131:
      if (EmojiStickerManager.a().jdField_a_of_type_Int == 1) {
        i1 = 2;
      } else if (EmojiStickerManager.a().jdField_a_of_type_Int == 3000) {
        i1 = 3;
      } else {
        i1 = -1;
      }
    }
  }
  
  double a(PointF paramPointF)
  {
    return Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
  }
  
  double a(PointF paramPointF1, PointF paramPointF2)
  {
    return Math.sqrt((paramPointF1.x - paramPointF2.x) * (paramPointF1.x - paramPointF2.x) + (paramPointF1.y - paramPointF2.y) * (paramPointF1.y - paramPointF2.y));
  }
  
  View a(int paramInt1, int paramInt2, Rect paramRect, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if (!this.jdField_c_of_type_Boolean) {
        if (paramInt1 <= this.jdField_e_of_type_Int - this.r + ((ChatXListView)localObject).getMeasuredHeight() - this.jdField_j_of_type_Int)
        {
          i1 = this.jdField_e_of_type_Int;
          i2 = this.r;
          if (paramInt2 <= ((ChatXListView)localObject).getMeasuredHeight() + (i1 - i2) - this.jdField_j_of_type_Int) {}
        }
        else
        {
          return null;
        }
      }
    }
    int i2 = 9999999;
    Object localObject = paramRect;
    if (paramRect == null) {
      localObject = new Rect();
    }
    int i1 = paramViewGroup.getChildCount() - 1;
    int i4 = -1;
    int i3;
    int i5;
    if (i1 >= 0)
    {
      paramViewGroup.getChildAt(i1).getGlobalVisibleRect((Rect)localObject);
      i3 = Math.abs(paramInt1 - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      i5 = Math.abs(paramInt2 - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      if (i3 - i5 < 0)
      {
        label190:
        if (i3 >= i2) {
          break label299;
        }
        i4 = i1;
      }
    }
    for (;;)
    {
      i1 -= 1;
      i2 = i3;
      break;
      i3 = i5;
      break label190;
      if (i4 != -1)
      {
        paramRect = paramViewGroup.getChildAt(i4);
        paramRect.getGlobalVisibleRect((Rect)localObject);
        if (i4 == 0) {
          ((Rect)localObject).top = (((Rect)localObject).bottom - paramRect.getHeight());
        }
      }
      for (;;)
      {
        return paramRect;
        if (i4 == paramViewGroup.getChildCount() - 1) {
          ((Rect)localObject).bottom = (((Rect)localObject).top + paramRect.getHeight());
        }
        continue;
        paramRect = null;
      }
      label299:
      i3 = i2;
    }
  }
  
  View a(int paramInt, Rect paramRect, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if (!this.jdField_c_of_type_Boolean)
      {
        i1 = this.jdField_e_of_type_Int;
        i2 = this.r;
        if (paramInt > ((ChatXListView)localObject).getMeasuredHeight() + (i1 - i2) - this.jdField_j_of_type_Int) {
          return null;
        }
      }
    }
    int i2 = 9999999;
    Object localObject = paramRect;
    if (paramRect == null) {
      localObject = new Rect();
    }
    int i1 = paramViewGroup.getChildCount() - 1;
    int i3 = -1;
    if (i1 >= 0)
    {
      paramViewGroup.getChildAt(i1).getGlobalVisibleRect((Rect)localObject);
      int i4 = Math.abs(paramInt - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      if (i4 >= i2) {
        break label236;
      }
      i3 = i1;
      i2 = i4;
    }
    label236:
    for (;;)
    {
      i1 -= 1;
      break;
      if (i3 != -1)
      {
        paramRect = paramViewGroup.getChildAt(i3);
        paramRect.getGlobalVisibleRect((Rect)localObject);
        if (i3 == 0) {
          ((Rect)localObject).top = (((Rect)localObject).bottom - paramRect.getHeight());
        }
      }
      for (;;)
      {
        return paramRect;
        if (i3 == paramViewGroup.getChildCount() - 1) {
          ((Rect)localObject).bottom = (((Rect)localObject).top + paramRect.getHeight());
        }
        continue;
        paramRect = null;
      }
    }
  }
  
  void a()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    if (i1 < 4) {
      return;
    }
    PointF localPointF1 = (PointF)this.jdField_a_of_type_JavaUtilList.get(i1 - 4);
    PointF localPointF2 = (PointF)this.jdField_a_of_type_JavaUtilList.get(i1 - 3);
    PointF localPointF3 = (PointF)this.jdField_a_of_type_JavaUtilList.get(i1 - 2);
    PointF localPointF4 = (PointF)this.jdField_a_of_type_JavaUtilList.get(i1 - 1);
    if (a(localPointF1, localPointF3) + a(localPointF2, localPointF4) < 5.0D)
    {
      this.jdField_a_of_type_JavaUtilList.remove(i1 - 1);
      this.jdField_a_of_type_JavaUtilList.remove(i1 - 2);
      return;
    }
    PointF localPointF5 = new PointF(localPointF2.x - localPointF1.x, localPointF2.y - localPointF1.y);
    PointF localPointF6 = new PointF(localPointF4.x - localPointF3.x, localPointF4.y - localPointF3.y);
    double d3 = a(localPointF5);
    double d4 = a(localPointF6);
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
      this.jdField_a_of_type_Double = (d1 + this.jdField_a_of_type_Double);
      if (this.jdField_a_of_type_Double >= 360.0D) {
        this.jdField_a_of_type_Double -= 360.0D;
      }
      if (this.jdField_a_of_type_Double < 0.0D) {
        this.jdField_a_of_type_Double += 360.0D;
      }
      d1 = a(localPointF1, localPointF2);
      d2 = a(localPointF3, localPointF4);
      if ((d1 >= 5.0D) && (d2 >= 5.0D)) {
        this.jdField_b_of_type_Double = (d2 / d1 * this.jdField_b_of_type_Double);
      }
      if (this.s != 1) {
        break label542;
      }
      if (this.jdField_b_of_type_Double > 1.0D) {
        this.jdField_b_of_type_Double = 1.0D;
      }
      if (this.jdField_b_of_type_Double < 0.6000000238418579D) {
        this.jdField_b_of_type_Double = 0.6000000238418579D;
      }
    }
    for (;;)
    {
      b();
      return;
      d1 = -d1;
      break;
      label542:
      if (this.s == 0)
      {
        if (this.jdField_b_of_type_Double > 1.6D) {
          this.jdField_b_of_type_Double = 1.6D;
        }
        if (this.jdField_b_of_type_Double < 1.0D) {
          this.jdField_b_of_type_Double = 1.0D;
        }
      }
    }
  }
  
  void a(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
    {
      ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.animate();
      localViewPropertyAnimator.translationX(this.q / 2 - (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() / 2 + paramFloat1)).translationY(this.jdField_e_of_type_Int - this.r + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getMeasuredHeight() - this.jdField_j_of_type_Int - paramFloat2);
      localViewPropertyAnimator.setListener(this.jdField_a_of_type_Acpd);
      localViewPropertyAnimator.setDuration(200L);
    }
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null)
    {
      ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.animate();
      localViewPropertyAnimator.x(paramInt);
      localViewPropertyAnimator.setListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
      localViewPropertyAnimator.setDuration(300L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt1;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLayoutParams.topMargin = (paramInt2 - ImmersiveUtils.a(this.jdField_a_of_type_AndroidContentContext));
      return;
    }
    localLayoutParams.topMargin = paramInt2;
  }
  
  void a(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getX(this.jdField_k_of_type_Int) - this.jdField_h_of_type_Float;
    float f1 = paramMotionEvent.getX(this.l) - this.jdField_i_of_type_Float;
    this.jdField_h_of_type_Float = paramMotionEvent.getX(this.jdField_k_of_type_Int);
    this.jdField_i_of_type_Float = paramMotionEvent.getX(this.l);
    int i1;
    label110:
    Object localObject1;
    if (f2 * f1 < 0.0F) {
      if (f2 < 0.0F)
      {
        i1 = EmojiStickerManager.jdField_g_of_type_Int;
        this.p = i1;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
          break label420;
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
        i1 = paramMotionEvent.getChildCount() - 1;
        if (i1 < 0) {
          break label420;
        }
        localObject1 = paramMotionEvent.getChildAt(i1);
        if (!(localObject1 instanceof BaseChatItemLayout)) {
          break label246;
        }
        localObject1 = (BaseChatItemLayout)localObject1;
        if (this.p != EmojiStickerManager.jdField_g_of_type_Int) {
          break label205;
        }
        f2 = Math.min(0.0F, f2);
        f1 = Math.max(0.0F, f1);
        ((BaseChatItemLayout)localObject1).a((int)Math.abs(f2 - f1), this.p);
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
      int i2;
      do
      {
        do
        {
          i1 -= 1;
          f1 = f4;
          f2 = f3;
          break label110;
          i1 = EmojiStickerManager.jdField_h_of_type_Int;
          break;
          if (this.p != EmojiStickerManager.jdField_h_of_type_Int) {
            break label421;
          }
          f2 = Math.max(0.0F, f2);
          f1 = Math.min(0.0F, f1);
          ((BaseChatItemLayout)localObject1).a((int)Math.abs(f2 - f1), this.p);
          break label176;
          f4 = f1;
          f3 = f2;
        } while (!(localObject1 instanceof LinearLayout));
        i2 = ((LinearLayout)localObject1).getChildCount() - 1;
        f4 = f1;
        f3 = f2;
      } while (i2 < 0);
      Object localObject2 = ((LinearLayout)localObject1).getChildAt(i2);
      f4 = f1;
      f3 = f2;
      if ((localObject2 instanceof StickerGrayTipLayout))
      {
        localObject2 = (StickerGrayTipLayout)localObject2;
        if (this.p == EmojiStickerManager.jdField_g_of_type_Int)
        {
          f2 = Math.min(0.0F, f2);
          f1 = Math.max(0.0F, f1);
          ((StickerGrayTipLayout)localObject2).a((int)Math.abs(f2 - f1), this.p);
        }
      }
      for (;;)
      {
        i2 -= 1;
        break;
        f4 = f1;
        f3 = f2;
        if (this.p == EmojiStickerManager.jdField_h_of_type_Int)
        {
          f3 = Math.max(0.0F, f2);
          f4 = Math.min(0.0F, f1);
          ((StickerGrayTipLayout)localObject2).a((int)Math.abs(f3 - f4), this.p);
        }
        f1 = f4;
        f2 = f3;
      }
      return;
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    BubbleInfo localBubbleInfo;
    boolean bool;
    if (paramView != null)
    {
      localBubbleInfo = (BubbleInfo)paramView.getTag(2131362293);
      localObject = (ChatMessage)paramView.getTag(2131362294);
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
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (!paramBoolean)
    {
      if (bool) {}
      for (i1 = 2130845866;; i1 = 2130845702)
      {
        localObject = ((Resources)localObject).getDrawable(i1);
        label112:
        if (localObject == null) {
          break;
        }
        localBubbleInfo.a(paramView, (Drawable)localObject);
        return;
      }
    }
    if (bool) {}
    for (int i1 = 2130845867;; i1 = 2130845703)
    {
      localObject = ((Resources)localObject).getDrawable(i1);
      break label112;
      break;
    }
  }
  
  void a(ChatXListView paramChatXListView, int paramInt)
  {
    int i1 = paramChatXListView.getChildCount();
    int i2 = paramChatXListView.getCount();
    if (paramInt == this.m)
    {
      this.jdField_b_of_type_Boolean = true;
      paramChatXListView.smoothScrollBy(-40000, 120000);
    }
    do
    {
      for (;;)
      {
        return;
        if (paramInt == this.n)
        {
          this.jdField_b_of_type_Boolean = true;
          paramChatXListView.smoothScrollBy(40000, 120000);
          View localView = paramChatXListView.getChildAt(i1 - 1);
          try
          {
            if (i2 - 1 == paramChatXListView.getPositionForView(localView))
            {
              localView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
              if ((Math.abs(this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.r - this.jdField_c_of_type_Int) < 15) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aM();
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
    } while (paramInt != this.o);
    this.jdField_b_of_type_Boolean = false;
    paramChatXListView.smoothScrollBy(0, 0);
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerGestureDetector", 2, "makeToast, content = " + paramString);
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramString, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
  }
  
  void a(boolean paramBoolean)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramBoolean) {
        break label166;
      }
    }
    for (;;)
    {
      PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("alpha", new float[] { f2, f1 });
      PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleX", new float[] { f2, f1 });
      PropertyValuesHolder localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("scaleY", new float[] { f2, f1 });
      ObjectAnimator.ofPropertyValuesHolder(this.jdField_b_of_type_AndroidWidgetImageView, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3 }).setDuration(300L).start();
      ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetImageView, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3 }).setDuration(300L).start();
      return;
      label166:
      f2 = 0.0F;
      f1 = 1.0F;
    }
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getChildCount() - 1;
      while (i1 >= 0)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getChildAt(i1);
        if (((View)localObject).getId() == 2131362314)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout = ((EmojiStickerManager.StickerFrameLayout)localObject);
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getChildAt(1));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getChildAt(2));
          localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag();
          double d1;
          if (((localObject instanceof PicEmoticonInfo)) || ((localObject instanceof Emoticon)) || ((localObject instanceof FavoriteEmoticonInfo)))
          {
            this.s = 1;
            this.jdField_c_of_type_Double = (100.0F * this.jdField_g_of_type_Float);
            this.jdField_d_of_type_Double = (100.0F * this.jdField_g_of_type_Float);
            this.jdField_h_of_type_Int = ((int)(this.jdField_g_of_type_Float * 5.0F));
            this.jdField_i_of_type_Int = ((int)(this.jdField_g_of_type_Float * 5.0F));
            localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.a();
            d1 = ((ImageView)localObject).getDrawable().getIntrinsicWidth() / ((ImageView)localObject).getDrawable().getIntrinsicHeight();
            if (d1 <= 1.0D) {
              break label312;
            }
            this.jdField_d_of_type_Double = (this.jdField_c_of_type_Double / d1);
            this.jdField_e_of_type_Double = 0.0D;
          }
          for (this.jdField_f_of_type_Double = ((this.jdField_c_of_type_Double - this.jdField_d_of_type_Double) / 2.0D);; this.jdField_f_of_type_Double = 0.0D)
          {
            return true;
            if ((!(localObject instanceof SystemAndEmojiEmoticonInfo)) && (!(localObject instanceof SmallEmoticonInfo))) {
              break;
            }
            this.s = 0;
            this.jdField_c_of_type_Double = (this.jdField_g_of_type_Float * 28.0F);
            this.jdField_d_of_type_Double = (this.jdField_g_of_type_Float * 28.0F);
            this.jdField_h_of_type_Int = ((int)(41.0F * this.jdField_g_of_type_Float));
            this.jdField_i_of_type_Int = ((int)(41.0F * this.jdField_g_of_type_Float));
            break;
            label312:
            this.jdField_c_of_type_Double = (d1 * this.jdField_d_of_type_Double);
            this.jdField_e_of_type_Double = ((this.jdField_d_of_type_Double - this.jdField_c_of_type_Double) / 2.0D);
          }
        }
        i1 -= 1;
      }
    }
    return false;
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        if ((paramFloat1 < this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLeft()) || (paramFloat1 > this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getRight()) || (paramFloat2 < this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTop()) || (paramFloat2 > this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getBottom()) || (c(paramFloat1, paramFloat2)) || (d(paramFloat1, paramFloat2))) {}
      }
      while ((paramFloat1 >= this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLeft()) && (paramFloat1 <= this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getRight()) && (paramFloat2 >= this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTop() + this.r) && (paramFloat2 <= this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getBottom() + this.r) && (!c(paramFloat1, paramFloat2)) && (!d(paramFloat1, paramFloat2)))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) < 50.0D) && ((paramFloat2 > this.jdField_c_of_type_Int) || (paramFloat2 < this.jdField_e_of_type_Int));
  }
  
  boolean a(float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = new Rect();
      this.jdField_b_of_type_AndroidWidgetImageView.getGlobalVisibleRect(paramMotionEvent);
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
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Rect paramRect)
  {
    paramInt2 = paramInt3 - paramInt1;
    paramInt3 = paramRect.width();
    paramInt4 = (paramInt3 + paramInt2) / 2;
    int i1 = paramRect.left;
    return Math.abs(paramInt3 / 2 + i1 - paramInt1 - paramInt2 / 2) <= paramInt4;
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    paramInt2 = paramInt3 - paramInt1;
    paramInt3 = paramView.getWidth();
    paramInt4 = (paramInt3 + paramInt2) / 2;
    int i1 = paramView.getLeft();
    return Math.abs(paramInt3 / 2 + i1 - paramInt1 - paramInt2 / 2) <= paramInt4;
  }
  
  @TargetApi(11)
  void b()
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null))
    {
      ImageView localImageView = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.a();
      if (localImageView != null)
      {
        localImageView.setRotation((float)this.jdField_a_of_type_Double);
        localImageView.setScaleX((float)this.jdField_b_of_type_Double);
        localImageView.setScaleY((float)this.jdField_b_of_type_Double);
      }
    }
  }
  
  boolean b(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        if ((paramFloat1 < this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLeft()) || (paramFloat1 > this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getRight()) || (paramFloat2 < this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTop()) || (paramFloat2 > this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getBottom())) {}
      }
      while ((paramFloat1 >= this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLeft()) && (paramFloat1 <= this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getRight()) && (paramFloat2 >= this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTop() + this.r) && (paramFloat2 <= this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getBottom() + this.r))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  boolean b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) < 50.0D) && (paramFloat2 < this.jdField_c_of_type_Int) && (paramFloat2 > this.jdField_e_of_type_Int);
  }
  
  boolean b(float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = new Rect();
      this.jdField_a_of_type_AndroidWidgetImageView.getGlobalVisibleRect(paramMotionEvent);
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
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      EmoticonMainPanel localEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
      if (localEmoticonMainPanel != null) {
        localEmoticonMainPanel.removeView(localEmoticonMainPanel.jdField_b_of_type_AndroidViewView);
      }
    }
  }
  
  boolean c(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      Rect localRect = new Rect();
      this.jdField_b_of_type_AndroidWidgetImageView.getGlobalVisibleRect(localRect);
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
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null)
    {
      ImageView localImageView = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.a();
      if (localImageView != null)
      {
        float f1 = (float)this.jdField_a_of_type_Double;
        ObjectAnimator.ofPropertyValuesHolder(localImageView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("Rotation", new float[] { f1 + 10.0F, f1, f1 - 10.0F, f1, f1 + 10.0F, f1, f1 - 10.0F, f1 }) }).setDuration(400L).start();
      }
    }
  }
  
  boolean d(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidWidgetImageView.getGlobalVisibleRect(localRect);
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
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
      if ((localObject1 != null) && (((EmoticonMainPanel)localObject1).q) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131362317);
        if (localObject1 != null) {
          return ((View)localObject1).onTouchEvent(paramMotionEvent);
        }
      }
    }
    if ((EmojiStickerManager.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131362319);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    if ((EmojiStickerManager.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131362318);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    int i1 = paramMotionEvent.getPointerCount();
    float f3;
    float f2;
    float f5;
    label588:
    float f7;
    float f8;
    float f6;
    float f1;
    if (i1 == 1)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
        this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
        this.jdField_a_of_type_Boolean = false;
      }
      if (a())
      {
        f3 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLeft();
        f2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTop();
        f4 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getRight();
        f5 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getBottom();
        if ((b(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) || (!this.jdField_d_of_type_Boolean)) {
          switch (paramMotionEvent.getAction())
          {
          default: 
          case 0: 
          case 2: 
            do
            {
              return true;
              this.jdField_f_of_type_Int = 0;
              if (QLog.isColorLevel()) {
                QLog.d("StickerGestureDetector", 2, "event = " + paramMotionEvent.getAction());
              }
              this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
              this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
              this.jdField_c_of_type_Float = this.jdField_a_of_type_Float;
              this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
              return (b(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float)) || (!this.jdField_d_of_type_Boolean);
              if (QLog.isColorLevel()) {
                QLog.d("StickerGestureDetector", 2, "event = " + paramMotionEvent.getAction());
              }
            } while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout == null) || ((!a(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) && (this.jdField_d_of_type_Boolean)));
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
              if (f5 > this.jdField_e_of_type_Int + ((ChatXListView)localObject1).getMeasuredHeight() - this.r - this.jdField_j_of_type_Int) {
                break;
              }
              i1 = 1;
              if (this.jdField_c_of_type_Boolean) {
                break label1331;
              }
              if (i1 != 0)
              {
                this.jdField_c_of_type_Boolean = true;
                if (this.jdField_d_of_type_Boolean) {
                  this.jdField_c_of_type_Int = (this.jdField_e_of_type_Int - this.r + ((ChatXListView)localObject1).getMeasuredHeight() - this.jdField_j_of_type_Int);
                }
                if (QLog.isColorLevel()) {
                  QLog.i("StickerGestureDetector", 2, "1 mBottom = " + this.jdField_c_of_type_Int + " isFirstUpInvoked = " + this.jdField_d_of_type_Boolean);
                }
              }
            }
            f7 = paramMotionEvent.getRawX() - this.jdField_a_of_type_Float;
            f8 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
            f3 += f7;
            f5 = f2 + f8;
            f2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() + f3;
            f6 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getHeight() + f5;
            if (QLog.isColorLevel()) {
              QLog.i("StickerGestureDetector", 2, "sticker move OLD, left = " + f3 + " top = " + f5 + " right = " + f2 + " bottom = " + f6 + " distanceX = " + f7 + " distanceY = " + f8);
            }
            f1 = f3;
            if (f3 < this.jdField_d_of_type_Int)
            {
              f1 = this.jdField_d_of_type_Int;
              f2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() + f1;
            }
            if (f2 > this.jdField_b_of_type_Int)
            {
              f1 = this.jdField_b_of_type_Int;
              f2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth();
              f3 = f1;
            }
            break;
          }
        }
      }
    }
    for (float f4 = f1 - f2;; f4 = f1)
    {
      if (f5 < this.jdField_e_of_type_Int - this.r)
      {
        f1 = this.jdField_e_of_type_Int - this.r;
        f2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getHeight() + f1;
      }
      for (;;)
      {
        if (f2 > this.jdField_c_of_type_Int)
        {
          f2 = this.jdField_c_of_type_Int;
          f5 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getHeight();
          f1 = f2;
        }
        label3974:
        label3980:
        label4750:
        label4756:
        label4762:
        for (f2 -= f5;; f2 = f5)
        {
          if (QLog.isColorLevel()) {
            QLog.i("StickerGestureDetector", 2, "sticker move NEW, left = " + f4 + " top = " + f2 + " right = " + f3 + " bottom = " + f1 + " distanceX = " + f7 + " distanceY = " + f8);
          }
          Object localObject3;
          int i2;
          int i3;
          Object localObject2;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
            i2 = (int)((1.0D - this.jdField_b_of_type_Double) * this.jdField_c_of_type_Double / 2.0D);
            i3 = (int)((1.0D - this.jdField_b_of_type_Double) * this.jdField_d_of_type_Double / 2.0D);
            localObject2 = a((int)paramMotionEvent.getRawY(), this.jdField_c_of_type_AndroidGraphicsRect, (ViewGroup)localObject3);
            localObject1 = localObject2;
            if (!(localObject2 instanceof BaseChatItemLayout)) {
              localObject1 = a((int)((f2 + f1) / 2.0F), this.jdField_c_of_type_AndroidGraphicsRect, (ViewGroup)localObject3);
            }
            if ((localObject1 instanceof BaseChatItemLayout)) {
              break label7984;
            }
            localObject1 = a((int)f2, (int)f1, this.jdField_c_of_type_AndroidGraphicsRect, (ViewGroup)localObject3);
          }
          label2981:
          label4134:
          label4265:
          label4783:
          label7984:
          for (;;)
          {
            if (localObject1 != null) {
              this.jdField_c_of_type_AndroidViewView = ((View)localObject1);
            }
            label1124:
            int i4;
            int i5;
            if ((localObject1 instanceof BaseChatItemLayout))
            {
              localObject2 = (BaseChatItemLayout)localObject1;
              i1 = ((BaseChatItemLayout)localObject2).getChildCount() - 1;
              if (i1 >= 0)
              {
                localObject3 = ((BaseChatItemLayout)localObject2).getChildAt(i1);
                if ((localObject3 != null) && (((View)localObject3).getId() == 2131361877))
                {
                  if ((this.jdField_a_of_type_AndroidViewView != null) && (localObject3 != this.jdField_a_of_type_AndroidViewView)) {
                    a(this.jdField_a_of_type_AndroidViewView, false);
                  }
                  if ((this.jdField_b_of_type_AndroidViewView != null) && (localObject2 != this.jdField_b_of_type_AndroidViewView) && ((this.jdField_b_of_type_AndroidViewView instanceof BaseChatItemLayout))) {
                    ((BaseChatItemLayout)this.jdField_b_of_type_AndroidViewView).setStickerPressStatus(false);
                  }
                  i4 = (int)(f4 + 0.5D);
                  i5 = this.jdField_h_of_type_Int;
                  if (!a((int)this.jdField_e_of_type_Double + (i4 + i2 + i5), (int)(f2 + 0.5D) + i3, (int)(f3 + 0.5D) - i2 - this.jdField_h_of_type_Int - (int)this.jdField_e_of_type_Double, (int)(f1 + 0.5D) - i3, (View)localObject3)) {
                    break label1462;
                  }
                  a((View)localObject3, true);
                  ((BaseChatItemLayout)localObject2).setStickerPressStatus(true);
                  this.jdField_a_of_type_AndroidViewView = ((View)localObject3);
                }
                for (;;)
                {
                  i1 -= 1;
                  break label1124;
                  i1 = 0;
                  break;
                  label1331:
                  if (i1 == 0) {
                    this.jdField_c_of_type_Boolean = false;
                  }
                  if (this.jdField_d_of_type_Boolean)
                  {
                    if (((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0)) || ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0))) {
                      a(true);
                    }
                    this.jdField_c_of_type_Int = (this.jdField_e_of_type_Int - this.r + ((ChatXListView)localObject1).getMeasuredHeight() - this.jdField_j_of_type_Int);
                  }
                  if (!QLog.isColorLevel()) {
                    break label588;
                  }
                  QLog.i("StickerGestureDetector", 2, "2 mBottom = " + this.jdField_c_of_type_Int + " isFirstUpInvoked = " + this.jdField_d_of_type_Boolean);
                  break label588;
                  label1462:
                  a((View)localObject3, false);
                  ((BaseChatItemLayout)localObject2).setStickerPressStatus(false);
                }
              }
            }
            else
            {
              if (this.jdField_a_of_type_AndroidViewView != null) {
                a(this.jdField_a_of_type_AndroidViewView, false);
              }
              if ((this.jdField_b_of_type_AndroidViewView != null) && (localObject1 != this.jdField_b_of_type_AndroidViewView) && ((this.jdField_b_of_type_AndroidViewView instanceof BaseChatItemLayout))) {
                ((BaseChatItemLayout)this.jdField_b_of_type_AndroidViewView).setStickerPressStatus(false);
              }
            }
            this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() == (int)(110.0F * this.jdField_g_of_type_Float)) {
              a((int)(f4 + 0.5D), (int)(f2 + 0.5D), (int)(f3 + 0.5D), (int)(f1 + 0.5D));
            }
            this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
            this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
              break;
            }
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
            if (Math.abs(f2 - this.jdField_e_of_type_Int + this.r) < 15.0F)
            {
              if (this.jdField_b_of_type_Boolean) {
                break;
              }
              a(paramMotionEvent, this.m);
              break;
            }
            if (Math.abs(f1 - this.jdField_c_of_type_Int) < 15.0F)
            {
              if (this.jdField_b_of_type_Boolean) {
                break;
              }
              a(paramMotionEvent, this.n);
              break;
            }
            a(paramMotionEvent, this.o);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("StickerGestureDetector", 2, "event = " + paramMotionEvent.getAction());
            }
            if ((!this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
              EmojiStickerManager.jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(true);
              a(true);
              i1 = this.jdField_e_of_type_Int;
              i2 = this.r;
              this.jdField_c_of_type_Int = (((ChatXListView)localObject1).getMeasuredHeight() + (i1 - i2) - this.jdField_j_of_type_Int);
              if (QLog.isColorLevel()) {
                QLog.i("StickerGestureDetector", 2, "10 mBottom = " + this.jdField_c_of_type_Int);
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag();
              if ((localObject1 instanceof PicEmoticonInfo))
              {
                this.t = 5;
                label1902:
                VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "DragToAIO", String.valueOf(this.jdField_a_of_type_Int), 0, 0, 0, "", "", "", String.valueOf(this.s), "", "", "", 0, 0, 0, 0);
              }
            }
            else
            {
              this.jdField_d_of_type_Boolean = true;
              if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
                if (localObject2 == null) {
                  break label2515;
                }
                ((EmoticonMainPanel)localObject2).getGlobalVisibleRect(this.jdField_b_of_type_AndroidGraphicsRect);
                if ((this.jdField_b_of_type_AndroidGraphicsRect.top != 0) || (this.jdField_b_of_type_AndroidGraphicsRect.bottom != 0)) {
                  break label2503;
                }
                i1 = this.jdField_e_of_type_Int - this.r + ((ChatXListView)localObject1).getMeasuredHeight() - this.jdField_j_of_type_Int;
              }
            }
            boolean bool5;
            boolean bool1;
            boolean bool3;
            boolean bool4;
            boolean bool2;
            boolean bool6;
            int i7;
            int i6;
            int i11;
            int i12;
            int i8;
            int i13;
            int i10;
            int i9;
            for (;;)
            {
              a(f3, f2, f4, f5, paramMotionEvent, (ListView)localObject1, i1);
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
                a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.o);
              }
              bool5 = false;
              bool1 = false;
              bool3 = false;
              bool4 = false;
              bool2 = false;
              bool6 = false;
              i5 = 0;
              i7 = 0;
              i4 = 0;
              i6 = 0;
              i11 = 0;
              i2 = 0;
              i12 = 0;
              i3 = 0;
              i8 = 0;
              f1 = 0.0F;
              i13 = 0;
              i10 = 0;
              i9 = 0;
              if (this.jdField_f_of_type_Int != 0) {
                break;
              }
              if (!a(this.jdField_c_of_type_Float, this.jdField_d_of_type_Float, paramMotionEvent)) {
                break label2540;
              }
              if (QLog.isColorLevel()) {
                QLog.i("StickerGestureDetector", 2, "isTouchedAboveCancel invoked");
              }
              EmojiStickerManager.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(false);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, false);
              this.jdField_c_of_type_Boolean = false;
              this.jdField_d_of_type_Boolean = false;
              this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getBottom();
              if (QLog.isColorLevel()) {
                QLog.i("StickerGestureDetector", 2, "line 5 mBottom = " + this.jdField_c_of_type_Int);
              }
              a(f3, f2);
              i1 = EmoticonPanelLinearLayout.jdField_e_of_type_Int;
              if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag(2131362320) instanceof Integer)) {
                i1 = ((Integer)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag(2131362320)).intValue();
              }
              if ((i1 == EmoticonPanelLinearLayout.jdField_e_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)) {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aL();
              }
              VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "CancelSend", String.valueOf(this.jdField_a_of_type_Int), 0, 0, 0, "", "", "", String.valueOf(this.t), "", "", "", 0, 0, 0, 0);
              return true;
              if ((localObject1 instanceof Emoticon))
              {
                this.t = 1;
                break label1902;
              }
              if ((localObject1 instanceof SystemAndEmojiEmoticonInfo))
              {
                localObject1 = (SystemAndEmojiEmoticonInfo)localObject1;
                if (((SystemAndEmojiEmoticonInfo)localObject1).jdField_a_of_type_Int == 1)
                {
                  this.t = 2;
                  break label1902;
                }
                if (((SystemAndEmojiEmoticonInfo)localObject1).jdField_a_of_type_Int != 2) {
                  break label1902;
                }
                this.t = 3;
                break label1902;
              }
              if ((localObject1 instanceof SmallEmoticonInfo))
              {
                this.t = 4;
                break label1902;
              }
              if (!(localObject1 instanceof FavoriteEmoticonInfo)) {
                break label1902;
              }
              this.t = 5;
              break label1902;
              label2503:
              i1 = this.jdField_b_of_type_AndroidGraphicsRect.top;
              continue;
              label2515:
              i1 = this.jdField_e_of_type_Int - this.r + ((ChatXListView)localObject1).getMeasuredHeight() - this.jdField_j_of_type_Int;
            }
            label2540:
            ChatXListView localChatXListView;
            int i15;
            int i16;
            BaseChatItemLayout localBaseChatItemLayout;
            int i14;
            if (b(this.jdField_c_of_type_Float, this.jdField_d_of_type_Float, paramMotionEvent))
            {
              if (QLog.isColorLevel()) {
                QLog.i("StickerGestureDetector", 2, "isTouchedAboveConfirm invoked");
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
              {
                i1 = EmoticonPanelLinearLayout.jdField_e_of_type_Int;
                if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag(2131362320) instanceof Integer)) {
                  i1 = ((Integer)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag(2131362320)).intValue();
                }
                if ((i1 == EmoticonPanelLinearLayout.jdField_d_of_type_Int) && (!VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
                {
                  e();
                  return true;
                }
                if ((i1 == EmoticonPanelLinearLayout.jdField_e_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aL();
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
                {
                  localChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                  i15 = (int)((this.jdField_b_of_type_Double - 1.0D) * this.jdField_c_of_type_Double / 2.0D);
                  i16 = (int)((this.jdField_b_of_type_Double - 1.0D) * this.jdField_d_of_type_Double / 2.0D);
                  localObject1 = this.jdField_c_of_type_AndroidViewView;
                  paramMotionEvent = (MotionEvent)localObject1;
                  if (localObject1 == null) {
                    paramMotionEvent = a((int)((f2 + f5) / 2.0F), this.jdField_c_of_type_AndroidGraphicsRect, localChatXListView);
                  }
                  if (!(paramMotionEvent instanceof BaseChatItemLayout)) {
                    break label6385;
                  }
                  localBaseChatItemLayout = (BaseChatItemLayout)paramMotionEvent;
                  if ((!localBaseChatItemLayout.b()) || (!this.jdField_c_of_type_Boolean)) {
                    break label6259;
                  }
                  i13 = 0;
                  i14 = 0;
                  i8 = this.jdField_c_of_type_AndroidGraphicsRect.top;
                  i9 = this.jdField_c_of_type_AndroidGraphicsRect.bottom;
                  if (localBaseChatItemLayout.getTop() >= this.jdField_j_of_type_Int) {
                    break label7981;
                  }
                  i8 = this.jdField_e_of_type_Int - this.jdField_j_of_type_Int + localBaseChatItemLayout.getTop();
                }
              }
            }
            for (;;)
            {
              if (localBaseChatItemLayout.getBottom() > localChatXListView.getMeasuredHeight()) {
                i9 = localBaseChatItemLayout.getBottom() + i9 - localChatXListView.getMeasuredHeight();
              }
              for (;;)
              {
                Object localObject6 = null;
                Object localObject5 = null;
                paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag();
                Object localObject4;
                FavoriteEmoticonInfo localFavoriteEmoticonInfo;
                if ((paramMotionEvent instanceof PicEmoticonInfo))
                {
                  localObject1 = (PicEmoticonInfo)paramMotionEvent;
                  localObject2 = null;
                  localObject4 = null;
                  localObject3 = null;
                  localFavoriteEmoticonInfo = null;
                }
                for (;;)
                {
                  label2902:
                  label2921:
                  View localView;
                  if ((!EmojiStickerManager.f) && (FileUtils.a() > 1.048576E+008F))
                  {
                    i1 = 1;
                    paramMotionEvent = null;
                    if ((localObject1 == null) || (((PicEmoticonInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon == null)) {
                      break label3563;
                    }
                    if (i1 == 0) {
                      break label3546;
                    }
                    paramMotionEvent = ((PicEmoticonInfo)localObject1).a("fromAIO", true, false, null, (int)(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() * this.jdField_b_of_type_Double), (int)(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getHeight() * this.jdField_b_of_type_Double));
                    if (paramMotionEvent == null) {
                      break label7921;
                    }
                    i10 = localBaseChatItemLayout.getChildCount() - 1;
                    i12 = 0;
                    i13 = 0;
                    bool4 = false;
                    i11 = 0;
                    bool2 = bool6;
                    i5 = i7;
                    i4 = i6;
                    i1 = i2;
                    i6 = i13;
                    i7 = i12;
                    i2 = i11;
                    label3034:
                    if (i10 < 0) {
                      break label7831;
                    }
                    localView = localBaseChatItemLayout.getChildAt(i10);
                    if ((localView == null) || (localView.getId() != 2131361877)) {
                      break label7788;
                    }
                    localObject5 = new Rect();
                    localView.getGlobalVisibleRect((Rect)localObject5);
                    bool4 = a((int)(f3 + 0.5D) - i15 + this.jdField_h_of_type_Int + (int)this.jdField_e_of_type_Double, (int)(f2 + 0.5D) - i16, (int)(f4 + 0.5D) + i15 - this.jdField_h_of_type_Int - (int)this.jdField_e_of_type_Double, (int)(f5 + 0.5D) + i16, (Rect)localObject5);
                    i7 = ((Rect)localObject5).left;
                    i11 = i8 + localView.getTop();
                    localObject6 = (ChatMessage)localView.getTag(2131362294);
                    if ((bool4) || (localObject6 == null)) {
                      break label7785;
                    }
                    if (!((ChatMessage)localObject6).isSend()) {
                      break label3652;
                    }
                    i2 = ((Rect)localObject5).left + BaseChatItemLayout.jdField_j_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() - i15 + this.jdField_h_of_type_Int + (int)this.jdField_e_of_type_Double;
                    if (localBaseChatItemLayout.getParent() != null) {
                      break label3680;
                    }
                    QLog.e("StickerGestureDetector", 1, "itemView.getParent == null");
                    i9 = 1;
                    i8 = i7;
                    i7 = i11;
                    i6 = i2;
                    localObject5 = localObject6;
                    i2 = i9;
                  }
                  for (;;)
                  {
                    label3275:
                    if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof BaseChatItemLayout))) {
                      ((BaseChatItemLayout)this.jdField_b_of_type_AndroidViewView).setStickerPressStatus(false);
                    }
                    label3321:
                    label3965:
                    ChatMessage localChatMessage;
                    if (i2 != 0)
                    {
                      a("贴表情出错啦，只能贴当前屏幕中的消息～");
                      i1 = 0;
                      i2 = 0;
                      if ((this.jdField_c_of_type_AndroidViewView instanceof BaseChatItemLayout))
                      {
                        if (i1 == 0) {
                          break label6373;
                        }
                        a(i6);
                        if (this.jdField_a_of_type_AndroidViewView != null) {
                          a(this.jdField_a_of_type_AndroidViewView, true);
                        }
                        if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof BaseChatItemLayout))) {
                          ((BaseChatItemLayout)this.jdField_b_of_type_AndroidViewView).setStickerPressStatus(true);
                        }
                      }
                      label3386:
                      if (QLog.isColorLevel()) {
                        QLog.i("StickerGestureDetector", 2, "line 6 mBottom = " + this.jdField_c_of_type_Int);
                      }
                      localBaseChatItemLayout.requestLayout();
                      label3426:
                      return true;
                      if ((paramMotionEvent instanceof Emoticon))
                      {
                        localObject3 = (Emoticon)paramMotionEvent;
                        localObject2 = null;
                        localObject4 = null;
                        localFavoriteEmoticonInfo = null;
                        localObject1 = null;
                        break label2902;
                      }
                      if ((paramMotionEvent instanceof SystemAndEmojiEmoticonInfo))
                      {
                        localObject4 = (SystemAndEmojiEmoticonInfo)paramMotionEvent;
                        localObject2 = null;
                        localObject3 = null;
                        localFavoriteEmoticonInfo = null;
                        localObject1 = null;
                        break label2902;
                      }
                      if ((paramMotionEvent instanceof SmallEmoticonInfo))
                      {
                        localObject2 = (SmallEmoticonInfo)paramMotionEvent;
                        localObject4 = null;
                        localObject3 = null;
                        localFavoriteEmoticonInfo = null;
                        localObject1 = null;
                        break label2902;
                      }
                      if (!(paramMotionEvent instanceof FavoriteEmoticonInfo)) {
                        break label7960;
                      }
                      localFavoriteEmoticonInfo = (FavoriteEmoticonInfo)paramMotionEvent;
                      localObject2 = null;
                      localObject4 = null;
                      localObject3 = null;
                      localObject1 = null;
                      break label2902;
                      i1 = 0;
                      break label2921;
                      label3546:
                      paramMotionEvent = ((PicEmoticonInfo)localObject1).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_g_of_type_Float);
                      break label2981;
                      label3563:
                      if (localObject4 != null)
                      {
                        paramMotionEvent = ((SystemAndEmojiEmoticonInfo)localObject4).b(this.jdField_a_of_type_AndroidContentContext, this.jdField_g_of_type_Float);
                        break label2981;
                      }
                      if (localObject3 != null)
                      {
                        paramMotionEvent = EmojiStickerManager.a().a(this.jdField_a_of_type_AndroidContentContext, (Emoticon)localObject3);
                        break label2981;
                      }
                      if (localObject2 != null)
                      {
                        paramMotionEvent = ((SmallEmoticonInfo)localObject2).b(this.jdField_a_of_type_AndroidContentContext, this.jdField_g_of_type_Float);
                        break label2981;
                      }
                      if (localFavoriteEmoticonInfo == null) {
                        break label2981;
                      }
                      paramMotionEvent = localFavoriteEmoticonInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_g_of_type_Float, 0, 0);
                      break label2981;
                      label3652:
                      i2 = ((Rect)localObject5).right - BaseChatItemLayout.jdField_j_of_type_Int + i15 - this.jdField_h_of_type_Int - (int)this.jdField_e_of_type_Double;
                      break label3235;
                      label3680:
                      i6 = localChatXListView.getPositionForView(localBaseChatItemLayout);
                      i12 = localChatXListView.getCount() - localChatXListView.getHeaderViewsCount() - localChatXListView.getFooterViewsCount();
                      if (i12 - i6 - 1 <= 20)
                      {
                        bool3 = true;
                        if (QLog.isColorLevel()) {
                          QLog.i("StickerGestureDetector", 2, "isLastTwenty = " + bool3 + " itemCount = " + i12 + " currentPosition = " + i6 + " headerViewsCount = " + localChatXListView.getHeaderViewsCount() + " footerViewsCount = " + localChatXListView.getFooterViewsCount());
                        }
                        localObject5 = localBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView;
                        localObject5 = localBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView;
                        localBaseChatItemLayout.a();
                        localBaseChatItemLayout.a();
                        i13 = 0;
                        if (localObject6 == null) {
                          break label7906;
                        }
                        bool2 = EmojiStickerManager.d((MessageRecord)localObject6);
                        if (((ChatMessage)localObject6).istroop != 0) {
                          break label3980;
                        }
                        if (((ChatMessage)localObject6).msgUid == 0L) {
                          break label3974;
                        }
                        i4 = 1;
                        if (android.text.TextUtils.isEmpty(((ChatMessage)localObject6).getExtInfoFromExtStr("message_is_sticker"))) {
                          break label4002;
                        }
                        i3 = 1;
                      }
                      for (;;)
                      {
                        if ((localObject6 instanceof MessageForMixedMsg))
                        {
                          localObject5 = (MessageForMixedMsg)localObject6;
                          i6 = 0;
                          i5 = 0;
                          if (((MessageForMixedMsg)localObject5).msgElemList != null)
                          {
                            localObject5 = ((MessageForMixedMsg)localObject5).msgElemList.iterator();
                            for (;;)
                            {
                              i6 = i5;
                              if (!((Iterator)localObject5).hasNext()) {
                                break;
                              }
                              if (((MessageRecord)((Iterator)localObject5).next()).msgtype != -2000) {
                                break label7897;
                              }
                              i5 += 1;
                            }
                            bool3 = false;
                            break;
                            i4 = 0;
                            break label3868;
                            if (((ChatMessage)localObject6).shmsgseq != 0L)
                            {
                              i4 = 1;
                              break label3868;
                            }
                            i4 = 0;
                            break label3868;
                            i3 = 0;
                            continue;
                          }
                          if (i6 > 1)
                          {
                            i5 = 1;
                            label4017:
                            i6 = i5;
                            label4021:
                            localObject5 = EmojiStickerManager.a((MessageRecord)localObject6);
                            Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.w()).iterator();
                            label4179:
                            for (;;)
                            {
                              label4075:
                              if (localIterator.hasNext())
                              {
                                localChatMessage = (ChatMessage)localIterator.next();
                                if ((localChatMessage instanceof MessageForMarketFace))
                                {
                                  Object localObject7 = (MessageForMarketFace)localChatMessage;
                                  if ((((MessageForMarketFace)localObject7).mMarkFaceMessage == null) || (((MessageForMarketFace)localObject7).mMarkFaceMessage.stickerInfo == null)) {
                                    break label7885;
                                  }
                                  i5 = 1;
                                  if (((localChatMessage instanceof MessageForUniteGrayTip)) || (i5 != 0)) {
                                    break label7889;
                                  }
                                  localObject7 = EmojiStickerManager.a(localChatMessage);
                                  if ((localObject7 == null) || (!((Pair)localObject7).equals(localObject5)) || (localChatMessage == localObject6)) {
                                    continue;
                                  }
                                  i5 = 1;
                                  if ((!EmojiStickerManager.b((MessageRecord)localObject6)) || (i4 == 0) || (i6 != 0) || (i5 != 0)) {
                                    break label4750;
                                  }
                                  i4 = 1;
                                  label4205:
                                  if ((EmojiStickerManager.jdField_d_of_type_Long <= ((ChatMessage)localObject6).time) || (!(localObject6 instanceof MessageForMarketFace))) {
                                    break label4756;
                                  }
                                  i5 = 1;
                                  if (!(localObject6 instanceof MessageForMarketFace)) {
                                    break label7858;
                                  }
                                  localObject5 = (MessageForMarketFace)localObject6;
                                  if ((((MessageForMarketFace)localObject5).mMarkFaceMessage == null) || (((MessageForMarketFace)localObject5).mMarkFaceMessage.stickerInfo == null)) {
                                    break label4762;
                                  }
                                  i1 = 1;
                                  i6 = i3;
                                  i3 = i5;
                                  i5 = i4;
                                  i4 = i3;
                                  i3 = i1;
                                  i1 = i6;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    for (;;)
                    {
                      if ((localObject6 != null) && (((ChatMessage)localObject6).extraflag != 32772) && (((ChatMessage)localObject6).extraflag != 32768) && (bool3) && (bool4) && (((ChatMessage)localObject6).msgtype != -2009) && (((ChatMessage)localObject6).msgtype != -2016) && (!(localObject6 instanceof MessageForLongMsg)) && (!(localObject6 instanceof MessageForLongTextMsg)) && (bool2) && (i5 != 0) && (i4 == 0) && (i3 == 0) && (i1 == 0))
                      {
                        localObject5 = "";
                        if ((localObject1 != null) && (((PicEmoticonInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon != null))
                        {
                          localObject5 = ((PicEmoticonInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
                          label4416:
                          if (f2 - i16 + this.r <= i8) {
                            break label4783;
                          }
                          bool1 = localBaseChatItemLayout.a(paramMotionEvent, (int)(f3 + 0.5D) + this.jdField_h_of_type_Int + (int)this.jdField_e_of_type_Double - i15 - this.jdField_c_of_type_AndroidGraphicsRect.left - localView.getLeft(), (int)(this.r + f2 + 0.5D) - this.jdField_c_of_type_AndroidGraphicsRect.top - i16 + this.jdField_i_of_type_Int + (int)this.jdField_f_of_type_Double, (int)(this.jdField_c_of_type_Double * this.jdField_b_of_type_Double), (int)(this.jdField_d_of_type_Double * this.jdField_b_of_type_Double), this.jdField_a_of_type_Double, (String)localObject5, true, 1.0F, null);
                          i6 = (int)(this.r + f2 + 0.5D) - i16 + (int)this.jdField_d_of_type_Double;
                          if (i6 <= i9) {
                            break label7845;
                          }
                          i6 -= i8;
                        }
                      }
                      for (;;)
                      {
                        label4580:
                        f1 = i6 - localBaseChatItemLayout.getHeight();
                        localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
                        if (localObject5 != null) {
                          ((AIOAnimationConatiner)localObject5).a();
                        }
                        bool5 = bool2;
                        bool2 = bool4;
                        i12 = i7;
                        localObject5 = localObject6;
                        bool4 = bool5;
                        i6 = i4;
                        i7 = i3;
                        i4 = i1;
                        i3 = i12;
                        i1 = i11;
                        for (;;)
                        {
                          i12 = i10 - 1;
                          i10 = i7;
                          i11 = i6;
                          bool5 = bool4;
                          i7 = i1;
                          i6 = i3;
                          bool4 = bool2;
                          i3 = i4;
                          i1 = i10;
                          i4 = i11;
                          bool2 = bool5;
                          i10 = i12;
                          break label3034;
                          i5 = 0;
                          break label4017;
                          if ((!(localChatMessage instanceof MessageForText)) && (!(localChatMessage instanceof MessageForPic))) {
                            break label7885;
                          }
                          if (!android.text.TextUtils.isEmpty(localChatMessage.getExtInfoFromExtStr("sticker_info")))
                          {
                            i5 = 1;
                            break label4134;
                          }
                          i5 = 0;
                          break label4134;
                          i4 = 0;
                          break label4205;
                          i5 = 0;
                          break label4228;
                          i1 = 0;
                          break label4265;
                          if (localObject3 == null) {
                            break label4416;
                          }
                          localObject5 = ((Emoticon)localObject3).epId;
                          break label4416;
                          bool5 = localBaseChatItemLayout.a(paramMotionEvent, (int)(f3 + 0.5D) + this.jdField_h_of_type_Int + (int)this.jdField_e_of_type_Double - i15 - this.jdField_c_of_type_AndroidGraphicsRect.left - localView.getLeft(), this.jdField_i_of_type_Int + (int)this.jdField_f_of_type_Double, (int)(this.jdField_c_of_type_Double * this.jdField_b_of_type_Double), (int)(this.jdField_d_of_type_Double * this.jdField_b_of_type_Double), this.jdField_a_of_type_Double, (String)localObject5, true, 1.0F, null);
                          i12 = (int)(this.r + f2 + 0.5D);
                          i13 = (int)this.jdField_d_of_type_Double;
                          i6 = i8 - (int)(this.r + f2 + 0.5D) + i16 + localBaseChatItemLayout.getHeight();
                          bool1 = bool5;
                          if (i12 - i16 + i13 <= i9) {
                            break label4580;
                          }
                          i6 = (int)this.jdField_d_of_type_Double;
                          bool1 = bool5;
                          break label4580;
                          if (!bool2)
                          {
                            a("仅支持给好友贴表情哦~");
                            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 4, 0, "", "", "", String.valueOf(this.t), "", "", "", 0, 0, 0, 0);
                            i1 = 0;
                            i2 = 0;
                            break label3321;
                          }
                          if (!bool4)
                          {
                            a("只能贴在消息上哦，再靠近一点～");
                            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 5, 0, "", "", "", String.valueOf(this.t), "", "", "", 0, 0, 0, 0);
                            i1 = 1;
                            i2 = 0;
                            break label3321;
                          }
                          if (!bool3)
                          {
                            a("只能贴最新的20条消息哦~");
                            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 2, 0, "", "", "", String.valueOf(this.t), "", "", "", 0, 0, 0, 0);
                            i1 = 0;
                            i2 = 0;
                            break label3321;
                          }
                          if (i3 != 0)
                          {
                            a("这个表情是新版本贴的，不能再贴表情哦~");
                            i1 = 0;
                            i2 = 0;
                            break label3321;
                          }
                          if (i4 != 0)
                          {
                            a("这条表情消息来自旧版本，不支持贴表情哦~");
                            i1 = 0;
                            i2 = 0;
                            break label3321;
                          }
                          if (((localObject5 instanceof MessageForLongMsg)) || ((localObject5 instanceof MessageForLongTextMsg)))
                          {
                            a("太长的消息鹅不喜欢，换条短的贴~");
                            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 3, 0, "", "", "", String.valueOf(this.t), "", "", "", 0, 0, 0, 0);
                            i1 = 0;
                            i2 = 0;
                            break label3321;
                          }
                          if ((i5 == 0) || (i1 != 0))
                          {
                            a("此类消息暂不支持贴表情，换条试试~");
                            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 3, 0, "", "", "", String.valueOf(this.t), "", "", "", 0, 0, 0, 0);
                            i1 = 0;
                            i2 = 0;
                            break label3321;
                          }
                          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (localObject5 != null))
                          {
                            if ((((ChatMessage)localObject5).extraflag == 32772) || (((ChatMessage)localObject5).extraflag == 32768))
                            {
                              a("表情只能贴在发送成功的消息上哦~");
                              VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 8, 0, "", "", "", String.valueOf(this.t), "", "", "", 0, 0, 0, 0);
                              i1 = 0;
                              i2 = 0;
                              break label3321;
                            }
                            if (bool1)
                            {
                              localObject6 = new EmojiStickerManager.StickerInfo();
                              ((EmojiStickerManager.StickerInfo)localObject6).x = ((f3 - i15 - this.jdField_c_of_type_AndroidGraphicsRect.left - i8 + this.jdField_h_of_type_Int + (int)this.jdField_e_of_type_Double) / this.q);
                              ((EmojiStickerManager.StickerInfo)localObject6).y = ((this.r + f2 - i16 - i7 + this.jdField_i_of_type_Int + (int)this.jdField_f_of_type_Double) / this.q);
                              ((EmojiStickerManager.StickerInfo)localObject6).width = ((float)(this.jdField_c_of_type_Double * this.jdField_b_of_type_Double) / this.q);
                              ((EmojiStickerManager.StickerInfo)localObject6).height = ((float)(this.jdField_d_of_type_Double * this.jdField_b_of_type_Double) / this.q);
                              ((EmojiStickerManager.StickerInfo)localObject6).rotate = ((int)this.jdField_a_of_type_Double);
                              ((EmojiStickerManager.StickerInfo)localObject6).hostMsgSeq = ((ChatMessage)localObject5).shmsgseq;
                              ((EmojiStickerManager.StickerInfo)localObject6).hostMsgUid = ((ChatMessage)localObject5).msgUid;
                              ((EmojiStickerManager.StickerInfo)localObject6).hostMsgTime = ((ChatMessage)localObject5).time;
                              if (QLog.isColorLevel()) {
                                QLog.d("StickerGestureDetector", 2, "EmojiStickerManager.StickerInfo send stickerInfo = " + localObject6);
                              }
                              if (localObject1 != null)
                              {
                                ((PicEmoticonInfo)localObject1).jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo = ((EmojiStickerManager.StickerInfo)localObject6);
                                ((ChatMessage)localObject5).stickerHidden = false;
                                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a((EmoticonInfo)localObject1);
                              }
                              do
                              {
                                for (;;)
                                {
                                  if ((localObject1 != null) || (localObject3 != null))
                                  {
                                    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 0, 0, "", "", "", String.valueOf(this.t), "", "", "", 0, 0, 0, 0);
                                    if ((this.jdField_a_of_type_Double != 0.0D) || (this.jdField_b_of_type_Double != 1.0D)) {
                                      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Adjust", String.valueOf(this.jdField_a_of_type_Int), 0, 0, 0, "", "", "", String.valueOf(this.t), "", "", "", 0, 0, 0, 0);
                                    }
                                  }
                                  if (f1 <= 0.0F) {
                                    break label6113;
                                  }
                                  i2 = localChatXListView.getPositionForView(localBaseChatItemLayout);
                                  i3 = localChatXListView.getFirstVisiblePosition();
                                  i1 = 0;
                                  while (i1 < i2 - i3)
                                  {
                                    ObjectAnimator.ofPropertyValuesHolder(localChatXListView.getChildAt(i1), new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("TranslationY", new float[] { f1, 0.0F }) }).setDuration(300L).start();
                                    i1 += 1;
                                  }
                                  if (localObject3 != null)
                                  {
                                    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Emoticon)localObject3, (EmojiStickerManager.StickerInfo)localObject6);
                                  }
                                  else
                                  {
                                    if (localObject4 != null)
                                    {
                                      if (((SystemAndEmojiEmoticonInfo)localObject4).jdField_a_of_type_Int == 1) {}
                                      for (paramMotionEvent = com.tencent.mobileqq.text.TextUtils.c(((SystemAndEmojiEmoticonInfo)localObject4).jdField_b_of_type_Int);; paramMotionEvent = com.tencent.mobileqq.text.TextUtils.a(((SystemAndEmojiEmoticonInfo)localObject4).jdField_b_of_type_Int))
                                      {
                                        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramMotionEvent, (EmojiStickerManager.StickerInfo)localObject6);
                                        break;
                                      }
                                    }
                                    if (localObject2 == null) {
                                      break;
                                    }
                                    paramMotionEvent = a((SmallEmoticonInfo)localObject2);
                                    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramMotionEvent, (EmojiStickerManager.StickerInfo)localObject6);
                                  }
                                }
                              } while (localFavoriteEmoticonInfo == null);
                              paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                              localObject2 = this.jdField_a_of_type_AndroidContentContext;
                              localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
                              localObject5 = localFavoriteEmoticonInfo.d;
                              if (!android.text.TextUtils.isEmpty(localFavoriteEmoticonInfo.c)) {}
                              for (bool1 = true;; bool1 = false)
                              {
                                ChatActivityFacade.a(paramMotionEvent, (Context)localObject2, (SessionInfo)localObject4, (String)localObject5, true, bool1, localFavoriteEmoticonInfo.c, (EmojiStickerManager.StickerInfo)localObject6);
                                break;
                              }
                              label6113:
                              this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.post(new acoy(this));
                              EmojiStickerManager.jdField_a_of_type_Boolean = false;
                              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(false);
                              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, false);
                              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aN();
                              c();
                              this.jdField_d_of_type_Boolean = false;
                              this.jdField_c_of_type_Boolean = false;
                              this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getBottom();
                              this.jdField_b_of_type_Double = 1.0D;
                              this.jdField_a_of_type_Double = 0.0D;
                              if (this.jdField_a_of_type_AndroidViewView != null)
                              {
                                a(this.jdField_a_of_type_AndroidViewView, false);
                                this.jdField_c_of_type_AndroidViewView = null;
                              }
                              if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof BaseChatItemLayout)))
                              {
                                ((BaseChatItemLayout)this.jdField_b_of_type_AndroidViewView).setStickerPressStatus(false);
                                this.jdField_b_of_type_AndroidViewView = null;
                              }
                              EmojiStickerManager.jdField_b_of_type_Boolean = false;
                              i1 = 0;
                              i2 = 1;
                              break label3321;
                              label6259:
                              if (!this.jdField_c_of_type_Boolean)
                              {
                                a("将表情移出面板才能贴哦~");
                                i6 = i13;
                                i1 = i9;
                                i2 = i8;
                                break label3321;
                              }
                              a(String.format("这条消息贴了%d个表情了，换条贴吧~", new Object[] { Integer.valueOf(EmojiStickerManager.jdField_e_of_type_Int) }));
                              VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 1, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                              i6 = i13;
                              i1 = i9;
                              i2 = i8;
                              break label3321;
                              label6373:
                              if (i2 != 0) {
                                break label3386;
                              }
                              d();
                              break label3386;
                              label6385:
                              if (paramMotionEvent != null)
                              {
                                if ((paramMotionEvent instanceof ViewGroup))
                                {
                                  a("此类消息暂不支持贴表情，换条试试~");
                                  VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 3, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                                  break label3426;
                                }
                                a("只能贴在消息上哦，再靠近一点～");
                                VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 5, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                                break label3426;
                              }
                              a("只能贴在消息上哦，再靠近一点～");
                              VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Send", String.valueOf(this.jdField_a_of_type_Int), 0, 5, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                              break label3426;
                              this.jdField_f_of_type_Int = 1;
                              this.jdField_c_of_type_Float = -1.0F;
                              this.jdField_d_of_type_Float = -1.0F;
                              break;
                              if (paramMotionEvent.getAction() == 0)
                              {
                                this.jdField_g_of_type_Int = 0;
                                this.jdField_e_of_type_Float = paramMotionEvent.getRawX();
                                this.jdField_f_of_type_Float = paramMotionEvent.getRawY();
                                break;
                              }
                              if (paramMotionEvent.getAction() != 1) {
                                break;
                              }
                              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
                              {
                                this.jdField_c_of_type_Int = (this.jdField_e_of_type_Int - this.r + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getMeasuredHeight() - this.jdField_j_of_type_Int);
                                if (QLog.isColorLevel()) {
                                  QLog.i("StickerGestureDetector", 2, "line 7 mBottom = " + this.jdField_c_of_type_Int);
                                }
                                a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.o);
                              }
                              if ((this.jdField_c_of_type_Boolean) && (a(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float, paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
                                if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
                                {
                                  paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
                                  if ((paramMotionEvent != null) && (!paramMotionEvent.p)) {
                                    break label6894;
                                  }
                                  a(f3, f2);
                                  EmojiStickerManager.jdField_a_of_type_Boolean = false;
                                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(false);
                                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, false);
                                  this.jdField_c_of_type_Boolean = false;
                                  this.jdField_d_of_type_Boolean = false;
                                  VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "CancelSendX", String.valueOf(this.jdField_a_of_type_Int), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                                }
                              }
                              for (;;)
                              {
                                this.jdField_g_of_type_Int = 1;
                                this.jdField_e_of_type_Float = -1.0F;
                                this.jdField_f_of_type_Float = -1.0F;
                                break;
                                label6894:
                                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
                                continue;
                                if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (b(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float, paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
                                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
                                }
                              }
                              if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
                              {
                                bool1 = false;
                                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
                                i1 = ((ChatXListView)localObject1).getChildCount() - 1;
                                if (i1 >= 0)
                                {
                                  localObject2 = ((ChatXListView)localObject1).getChildAt(i1);
                                  if ((localObject2 instanceof BaseChatItemLayout))
                                  {
                                    localObject2 = (BaseChatItemLayout)localObject2;
                                    if (bool1) {
                                      break label7773;
                                    }
                                    bool1 = ((BaseChatItemLayout)localObject2).c();
                                  }
                                }
                              }
                              label7219:
                              label7773:
                              for (;;)
                              {
                                ((BaseChatItemLayout)localObject2).b();
                                bool2 = bool1;
                                do
                                {
                                  i1 -= 1;
                                  bool1 = bool2;
                                  break;
                                  bool2 = bool1;
                                } while (!(localObject2 instanceof LinearLayout));
                                i2 = ((LinearLayout)localObject2).getChildCount() - 1;
                                for (;;)
                                {
                                  bool2 = bool1;
                                  if (i2 < 0) {
                                    break;
                                  }
                                  localObject3 = ((LinearLayout)localObject2).getChildAt(i2);
                                  bool2 = bool1;
                                  if ((localObject3 instanceof StickerGrayTipLayout))
                                  {
                                    localObject3 = (StickerGrayTipLayout)localObject3;
                                    bool2 = bool1;
                                    if (!bool1) {
                                      bool2 = ((StickerGrayTipLayout)localObject3).a();
                                    }
                                    ((StickerGrayTipLayout)localObject3).b();
                                  }
                                  i2 -= 1;
                                  bool1 = bool2;
                                }
                                if (bool1)
                                {
                                  if (this.p != EmojiStickerManager.jdField_g_of_type_Int) {
                                    break label7219;
                                  }
                                  VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "Hide", String.valueOf(this.jdField_a_of_type_Int), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                                }
                                for (;;)
                                {
                                  return super.onTouchEvent(paramMotionEvent);
                                  VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "Stick", "CancelHide", String.valueOf(this.jdField_a_of_type_Int), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                                }
                                if (i1 == 2)
                                {
                                  if (a())
                                  {
                                    switch (paramMotionEvent.getAction() & paramMotionEvent.getActionMasked())
                                    {
                                    }
                                    for (;;)
                                    {
                                      return true;
                                      this.jdField_a_of_type_JavaUtilList.add(new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0)));
                                      continue;
                                      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
                                      {
                                        this.jdField_a_of_type_JavaUtilList.add(new PointF(paramMotionEvent.getX(1), paramMotionEvent.getY(1)));
                                        continue;
                                        if (i1 > 1)
                                        {
                                          this.jdField_a_of_type_JavaUtilList.add(new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0)));
                                          this.jdField_a_of_type_JavaUtilList.add(new PointF(paramMotionEvent.getX(1), paramMotionEvent.getY(1)));
                                          a();
                                          continue;
                                          this.jdField_a_of_type_JavaUtilList.clear();
                                          continue;
                                          this.jdField_a_of_type_JavaUtilList.clear();
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
                                        this.jdField_a_of_type_Boolean = true;
                                        switch (paramMotionEvent.getAction() & paramMotionEvent.getActionMasked())
                                        {
                                        }
                                        for (;;)
                                        {
                                          return true;
                                          this.jdField_h_of_type_Float = paramMotionEvent.getX(0);
                                          this.jdField_j_of_type_Float = paramMotionEvent.getY(0);
                                          continue;
                                          if (paramMotionEvent.getX(0) < paramMotionEvent.getX(1))
                                          {
                                            this.jdField_k_of_type_Int = 0;
                                            this.l = 1;
                                            this.jdField_h_of_type_Float = paramMotionEvent.getX(0);
                                            this.jdField_j_of_type_Float = paramMotionEvent.getY(0);
                                            this.jdField_i_of_type_Float = paramMotionEvent.getX(1);
                                            this.jdField_k_of_type_Float = paramMotionEvent.getY(1);
                                          }
                                          else
                                          {
                                            this.jdField_k_of_type_Int = 1;
                                            this.l = 0;
                                            this.jdField_h_of_type_Float = paramMotionEvent.getX(1);
                                            this.jdField_j_of_type_Float = paramMotionEvent.getY(1);
                                            this.jdField_i_of_type_Float = paramMotionEvent.getX(0);
                                            this.jdField_k_of_type_Float = paramMotionEvent.getY(0);
                                            continue;
                                            a(paramMotionEvent);
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
                          i1 = 0;
                          i2 = 0;
                          break label3321;
                          label7785:
                          break label3235;
                          label7788:
                          i11 = i1;
                          i12 = i4;
                          i1 = i7;
                          bool5 = bool4;
                          i4 = i3;
                          i3 = i6;
                          i7 = i11;
                          i6 = i12;
                          bool4 = bool2;
                          bool2 = bool5;
                        }
                        i8 = i6;
                        i6 = i2;
                        i2 = 0;
                        break label3275;
                        i6 = 0;
                        continue;
                        i6 = i13;
                      }
                      label7858:
                      i6 = i1;
                      i12 = i4;
                      i1 = i3;
                      i3 = i6;
                      i4 = i5;
                      i5 = i12;
                      continue;
                      label7885:
                      i5 = 0;
                      break label4134;
                      label7889:
                      break label4075;
                      i5 = 0;
                      break label4179;
                      label7897:
                      break label3965;
                      i6 = 0;
                      break label4021;
                      label7906:
                      i6 = i1;
                      i1 = i3;
                      i3 = i6;
                    }
                    label7921:
                    i2 = 0;
                    bool3 = false;
                    f1 = 0.0F;
                    bool1 = bool5;
                    i3 = i12;
                    i1 = i11;
                    localObject5 = localObject6;
                    i6 = i10;
                    i7 = i14;
                    i8 = i13;
                  }
                  localObject2 = null;
                  localObject4 = null;
                  localObject3 = null;
                  localFavoriteEmoticonInfo = null;
                  localObject1 = null;
                }
              }
            }
          }
          label3235:
          label7845:
          label7981:
          f5 = f1;
          label3868:
          label4002:
          f1 = f2;
        }
        label4228:
        label7831:
        label7960:
        f2 = f6;
        f1 = f5;
      }
      f3 = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGestureDetector
 * JD-Core Version:    0.7.0.1
 */