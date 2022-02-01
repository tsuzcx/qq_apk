package com.tencent.mobileqq.relationx.icebreaking;

import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AIOIceBreakShow
  implements Handler.Callback, AIOIceBreakView.OnIceImageClickListener
{
  private static int jdField_a_of_type_Int;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new AIOIceBreakShow.3(this);
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new AIOIceBreakShow.2(this);
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AIOFooterViewDetector jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private IceBreakingMng jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIceBreakingMng;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private String jdField_a_of_type_JavaLangString;
  private List<IStickerRecEmoticon> jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private MqqWeakReferenceHandler jdField_b_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = -1;
  private int d = 0;
  
  public AIOIceBreakShow(BaseChatPie paramBaseChatPie, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIceBreakingMng = ((IceBreakingMng)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG));
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getLooper(), this);
    this.jdField_b_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    jdField_a_of_type_Int = AIOUtils.b(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector;
  }
  
  private void a(int paramInt, String paramString)
  {
    this.jdField_b_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new AIOIceBreakShow.RemoveRunnable(this, paramInt, paramString), this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIceBreakingMng.jdField_a_of_type_Int * 1000L);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() != null)
    {
      ViewParent localViewParent = this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
      ViewGroup localViewGroup = null;
      if ((localViewParent instanceof ViewGroup)) {
        localViewGroup = (ViewGroup)localViewParent;
      }
      if ((localViewGroup != null) && (localViewGroup.getId() == 2131362421)) {
        return true;
      }
    }
    return false;
  }
  
  private void b(int paramInt, String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new AIOIceBreakShow.1(this, paramInt, paramString));
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("show needAnim: %s, mState: %s, mIceBreakType: %s, mIsAIOPanelOpen: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    int i = this.jdField_b_of_type_Int;
    if ((i != 1) && (i != -1)) {
      return;
    }
    if (this.c == -1) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("bind data pic urls: ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList);
          QLog.d("AIOIceBreakShow", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new AIOIceBreakView(this.jdField_a_of_type_AndroidContentContext);
        ((AIOIceBreakView)this.jdField_a_of_type_AndroidWidgetLinearLayout).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_JavaUtilList, this.d);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131362368, Integer.valueOf(this.c));
        ((AIOIceBreakView)this.jdField_a_of_type_AndroidWidgetLinearLayout).setOnIceImageClickListener(this);
      }
      else
      {
        QLog.d("AIOIceBreakShow", 1, "rec mRecEmotionList is empty!");
        return;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = 1;
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if (localObject1 != null)
      {
        ((ValueAnimator)localObject1).cancel();
        e();
      }
    }
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ice_break", true);
    Object localObject1 = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
    if (localObject1 != null) {
      try
      {
        ((AIOShortcutBarHelper)localObject1).c(6);
      }
      catch (Exception localException)
      {
        QLog.d("AIOIceBreakShow", 1, "show notifyAIOIceBreakViewShowingStatus exception ", localException);
      }
    }
    c();
    this.jdField_b_of_type_Int = 0;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      }
      localObject2 = PropertyValuesHolder.ofInt("height", new int[] { 0, jdField_a_of_type_Int });
      PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 100 });
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(3, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(0, false, "icebreak_showFooter", 0);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { localObject2, localPropertyValuesHolder });
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(3, jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(jdField_a_of_type_Int, false, "icebreak_showFooter", 0);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("real show duration = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIceBreakingMng.jdField_a_of_type_Int);
      QLog.d("AIOIceBreakShow", 2, ((StringBuilder)localObject2).toString());
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.c == 0) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X8009B95", "0X8009B95", i, 0, "", "", "", "");
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if (localObject1 != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        return;
      }
      localObject1 = ((ListView)localObject1).getChildAt(((ListView)localObject1).getLastVisiblePosition() - ((ListView)localObject1).getFirstVisiblePosition());
      int k = 0;
      int j;
      if (localObject1 != null)
      {
        localObject2 = new Rect();
        ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
        int i = ((Rect)localObject2).bottom;
        if (((View)localObject1).getId() == 2131362421) {
          i = ((Rect)localObject2).top;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().findViewById(2131368875);
        localObject2 = new Rect();
        ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
        j = k;
        if (((Rect)localObject2).top - i <= jdField_a_of_type_Int) {
          j = 1;
        }
      }
      else
      {
        j = k;
        if (QLog.isColorLevel())
        {
          QLog.d("AIOIceBreakShow", 2, "locate itemView == null");
          j = k;
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() != null)
      {
        if (!(a() ^ j))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOIceBreakShow", 2, "don't need to relocate");
          }
          return;
        }
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      Object localObject2 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject2).gravity = 81;
      if (j != 0)
      {
        ((AIOFooterViewDetector)localObject1).a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (FrameLayout.LayoutParams)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(196608);
        if (QLog.isColorLevel()) {
          QLog.d("AIOIceBreakShow", 2, "locate to ListView");
        }
      }
      else
      {
        ((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().findViewById(2131373031)).addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("AIOIceBreakShow", 2, "locate to ContentView");
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("hide needAnim: %s, mState: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    if (this.jdField_b_of_type_Int != 0) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if (localObject != null)
      {
        ((ValueAnimator)localObject).cancel();
        e();
      }
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      }
      localObject = PropertyValuesHolder.ofInt("height", new int[] { jdField_a_of_type_Int, 0 });
      PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("alpha", new int[] { 100, 0 });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { localObject, localPropertyValuesHolder });
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject != null) && (((LinearLayout)localObject).getParent() != null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(3, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(0, false, "icebreak_showFooter", 0);
      if (a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(196608);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    this.jdField_b_of_type_Int = 1;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("remove mState: %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    int i = this.jdField_b_of_type_Int;
    if ((i != 0) && (i != 1)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject != null) && (((LinearLayout)localObject).getParent() != null))
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(3, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    this.jdField_b_of_type_Int = 2;
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ice_break", false);
    localObject = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
    if (localObject != null) {
      ((AIOShortcutBarHelper)localObject).c(7);
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, "restore");
    }
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null)
    {
      localLinearLayout.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.scrollTo(0, 0);
      if (this.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_Int == 0) && (!this.jdField_b_of_type_Boolean)) {
      c();
    }
  }
  
  public void a(View paramView)
  {
    if (IceBreakingUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove matchChat Ice show");
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((paramView instanceof LimitChatPie)) {
        ((LimitChatPie)paramView).ao();
      }
      ThreadManager.getSubThreadHandler().post(new AIOIceBreakShow.4(this));
      return;
    }
    if (IceBreakingUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onImageClick remove QCircleChat Ice show");
      }
      ThreadManager.getSubThreadHandler().post(new AIOIceBreakShow.5(this));
    }
  }
  
  public void a(List<IStickerRecEmoticon> paramList, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingIceBreakingMng.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("AIOIceBreakShow", 2, String.format("updateShow, newType = %s, oldType = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.c) }));
    }
    if (i == this.c) {
      return;
    }
    if (i != -1)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.c = i;
        this.jdField_a_of_type_JavaUtilList = paramList;
        this.d = paramInt;
        paramList = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(0, 1, 0);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessage(paramList);
        return;
      }
      QLog.d("AIOIceBreakShow", 1, "update show but hotPicList is empty!");
      return;
    }
    this.c = i;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOIceBreakShow", 2, String.format("onAIOPanelChanged isShow = %s, mIsAIOPanelOpen = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if ((this.jdField_a_of_type_Boolean ^ paramBoolean))
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      Message localMessage;
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_b_of_type_Int == 0) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(0);
          this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
          localMessage = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(1, 0, 0);
          this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessage(localMessage);
        }
      }
      else if ((this.jdField_b_of_type_Int == 1) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(0);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
        localMessage = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(0, 0, 0);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessage(localMessage);
      }
    }
  }
  
  public void b()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    d();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, "show sprite (normal) onDestroy.");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        d();
        return false;
      }
      if (paramMessage.arg1 == 1)
      {
        c(true);
        return false;
      }
      c(false);
      return false;
    }
    if (paramMessage.arg1 == 1)
    {
      b(true);
      return false;
    }
    b(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow
 * JD-Core Version:    0.7.0.1
 */