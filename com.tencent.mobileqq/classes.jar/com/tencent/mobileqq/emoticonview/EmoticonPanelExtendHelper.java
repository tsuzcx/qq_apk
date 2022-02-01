package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ImageButton;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.InterceptListener;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.List;

public class EmoticonPanelExtendHelper
  extends AbstractEmoticonPanelHelper
  implements PanelIconLinearLayout.InterceptListener, EmotionPanelListView.PullAndFastScrollListener
{
  public static final int ANIM_DURATION_EXTEND = 200;
  public static final int ANIM_DURATION_REDUCE = 250;
  private static final String LOG_TAG = "EmoticonPanelExtendHelper";
  private static int sMaxPanelHeight;
  private QQEmoticonMainPanelApp app;
  private float mDowny;
  private EmoticonMainPanel mMainPanel;
  private int mOldPanelHeight = 0;
  private int mOriginPanelHeight;
  private int mStartHeight;
  private TextWatcher textWatcher = new EmoticonPanelExtendHelper.3(this);
  
  public EmoticonPanelExtendHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private void doPanelAnim(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new EmoticonPanelExtendHelper.2(this, paramInt3));
    localValueAnimator.start();
  }
  
  private boolean needExtendPanel()
  {
    return (sMaxPanelHeight > this.mOriginPanelHeight) && (isShowExtendPanel());
  }
  
  private void reportPanelUpDown(String paramString)
  {
    EmotionPanelInfo localEmotionPanelInfo;
    if ((this.mPanelController.panelDataList != null) && (EmoticonPanelController.sLastSelectedSecondTabIndex >= 0) && (EmoticonPanelController.sLastSelectedSecondTabIndex < this.mPanelController.panelDataList.size()))
    {
      localEmotionPanelInfo = (EmotionPanelInfo)this.mPanelController.panelDataList.get(EmoticonPanelController.sLastSelectedSecondTabIndex);
      if (localEmotionPanelInfo.type != 7) {
        break label91;
      }
      ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
    }
    label91:
    do
    {
      return;
      if (localEmotionPanelInfo.type == 4)
      {
        ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
        return;
      }
      if (localEmotionPanelInfo.type == 11)
      {
        ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", paramString, paramString, 3, 0, "", "", "", "");
        return;
      }
      if (localEmotionPanelInfo.type == 8)
      {
        ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", paramString, paramString, 4, 0, "", "", "", "");
        return;
      }
      if (localEmotionPanelInfo.type == 10)
      {
        ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", paramString, paramString, 5, 0, "", "", "", "");
        return;
      }
    } while ((localEmotionPanelInfo.type != 9) && (localEmotionPanelInfo.type != 6));
    ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", paramString, paramString, 6, 0, "", "", "", "");
  }
  
  protected void abortFling()
  {
    if ((this.mPanelController.pageAdapter != null) && (this.mPanelController.panelDataList != null) && (EmoticonPanelController.sLastSelectedSecondTabIndex >= 0) && (EmoticonPanelController.sLastSelectedSecondTabIndex < this.mPanelController.panelDataList.size()))
    {
      Object localObject = (EmotionPanelInfo)this.mPanelController.panelDataList.get(EmoticonPanelController.sLastSelectedSecondTabIndex);
      localObject = this.mPanelController.pageAdapter.getAdapterFromCache((EmotionPanelInfo)localObject);
      if ((localObject != null) && (((BaseEmotionAdapter)localObject).getCurrentListView() != null)) {
        ((BaseEmotionAdapter)localObject).getCurrentListView().abordFling();
      }
    }
  }
  
  protected BaseEmotionAdapter getEmoticonPanelBaseEmotionAdapter()
  {
    if ((this.mPanelController.pageAdapter != null) && (this.mPanelController.panelDataList != null) && (EmoticonPanelController.sLastSelectedSecondTabIndex >= 0) && (EmoticonPanelController.sLastSelectedSecondTabIndex < this.mPanelController.panelDataList.size()))
    {
      Object localObject = (EmotionPanelInfo)this.mPanelController.panelDataList.get(EmoticonPanelController.sLastSelectedSecondTabIndex);
      localObject = this.mPanelController.pageAdapter.getAdapterFromCache((EmotionPanelInfo)localObject);
      if ((localObject != null) && (((BaseEmotionAdapter)localObject).getCurrentListView() != null) && ((((BaseEmotionAdapter)localObject).getCurrentListView().getOnScrollListener() instanceof EmoticonPanelOnScrollListener))) {
        return localObject;
      }
    }
    return null;
  }
  
  public int getMaxHeightSubNormalHeight(int paramInt)
  {
    int j = sMaxPanelHeight;
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.mOriginPanelHeight;
    }
    return j - i;
  }
  
  public int getOriginPanelHeight()
  {
    return this.mOriginPanelHeight;
  }
  
  public int getSearchAnimHeight()
  {
    return sMaxPanelHeight + ViewUtils.a(35.0F);
  }
  
  public String getTag()
  {
    return "EmoticonPanelExtendHelper";
  }
  
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!needExtendPanel()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      int i = (int)(paramMotionEvent.getY() - this.mDowny + 0.5F);
      int j = XPanelContainer.a;
      XPanelContainer.a -= i;
      if (XPanelContainer.a > sMaxPanelHeight) {
        XPanelContainer.a = sMaxPanelHeight;
      }
      while (XPanelContainer.a != j)
      {
        AbstractGifImage.pauseAll();
        if (!(this.mMainPanel.getParent() instanceof XPanelContainer)) {
          break;
        }
        this.mMainPanel.getParent().requestLayout();
        break;
        if (XPanelContainer.a < this.mOriginPanelHeight) {
          XPanelContainer.a = this.mOriginPanelHeight;
        }
      }
      j = XPanelContainer.a;
      if ((j != sMaxPanelHeight) && (j != this.mOriginPanelHeight))
      {
        if (j > this.mStartHeight)
        {
          i = sMaxPanelHeight;
          label172:
          if (Math.abs(j - this.mStartHeight) <= 100) {
            break label277;
          }
          j = 1;
          label188:
          if (j == 0) {
            break label282;
          }
          label192:
          if ((j == 0) || (i != this.mOriginPanelHeight)) {
            break label290;
          }
          reportPanelUpDown("0X800A847");
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonPanelExtendHelper", 2, "report panel close");
          }
        }
        for (;;)
        {
          paramMotionEvent = ValueAnimator.ofInt(new int[] { XPanelContainer.a, i });
          paramMotionEvent.setDuration(150L);
          paramMotionEvent.addUpdateListener(new EmoticonPanelExtendHelper.1(this, i));
          paramMotionEvent.start();
          break;
          i = this.mOriginPanelHeight;
          break label172;
          label277:
          j = 0;
          break label188;
          label282:
          i = this.mStartHeight;
          break label192;
          label290:
          if ((j != 0) && (i == sMaxPanelHeight))
          {
            reportPanelUpDown("0X800A846");
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonPanelExtendHelper", 2, "report panel open");
            }
          }
        }
      }
      AbstractGifImage.resumeAll();
    }
  }
  
  public void initBefore()
  {
    this.app = this.mPanelController.app;
    this.mMainPanel = this.mPanelController.getPanel();
    sMaxPanelHeight = (int)(this.app.getApp().getResources().getDisplayMetrics().heightPixels * 0.6D);
  }
  
  void initPanelExtendHeight()
  {
    this.mOriginPanelHeight = XPanelContainer.a;
    if (sMaxPanelHeight > this.mOriginPanelHeight) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onShow " + AppSetting.g() + " init panelH " + this.mOriginPanelHeight + " needExtendPanel" + bool);
      }
      return;
    }
  }
  
  public boolean interceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!needExtendPanel()) {}
    float f;
    int i;
    do
    {
      do
      {
        return false;
        switch (paramMotionEvent.getAction())
        {
        }
      } while (this.mPanelController.getPanel().getParent() == null);
      this.mPanelController.getPanel().getParent().requestDisallowInterceptTouchEvent(false);
      return false;
      this.mDowny = paramMotionEvent.getY();
      this.mStartHeight = XPanelContainer.a;
      return false;
      f = paramMotionEvent.getY();
      i = (int)(f - this.mDowny + 0.5F);
    } while ((!isShowExtendPanel()) || (this.mPanelController.mBaseChatPie == null) || (this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null) || (Math.abs(i) <= this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() * 0.6F));
    this.mDowny = f;
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 9, 4, 5, 1, 3 };
  }
  
  public boolean isPanelOpen()
  {
    return XPanelContainer.a == sMaxPanelHeight;
  }
  
  boolean isShowExtendPanel()
  {
    return (this.mPanelController.mBaseChatPie != null) && (!this.mPanelController.mParams.kanDianBiu) && (this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null);
  }
  
  public void onAttachedToWindow()
  {
    if (isShowExtendPanel()) {
      this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.textWatcher);
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (isShowExtendPanel())
    {
      this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.textWatcher);
      this.mOldPanelHeight = XPanelContainer.a;
      XPanelContainer.a = this.mOriginPanelHeight;
    }
  }
  
  public void onHide(boolean paramBoolean)
  {
    if (isShowExtendPanel())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onHide.");
      }
      if (paramBoolean) {
        break label76;
      }
      XPanelContainer.a = this.mOriginPanelHeight;
    }
    for (;;)
    {
      this.mOldPanelHeight = 0;
      if ((this.mPanelController.mBaseChatPie != null) && (this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
        this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(null);
      }
      return;
      label76:
      if (this.mOldPanelHeight != 0) {
        XPanelContainer.a = this.mOldPanelHeight;
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((this.mPanelController.mBaseChatPie != null) && (this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      updateDeleteBtnVisibility(this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    }
  }
  
  public void onPullDown()
  {
    if (!needExtendPanel()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.a != sMaxPanelHeight);
      doPanelAnim(250, XPanelContainer.a, this.mOriginPanelHeight);
      reportPanelUpDown("0X800A847");
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonPanelExtendHelper", 2, "onPullDown");
  }
  
  public void onPullUp()
  {
    if (!needExtendPanel()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.a != this.mOriginPanelHeight);
      doPanelAnim(200, XPanelContainer.a, sMaxPanelHeight);
      reportPanelUpDown("0X800A846");
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonPanelExtendHelper", 2, "onPullUp");
  }
  
  public void onShow()
  {
    if (isShowExtendPanel())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onShow.");
      }
      this.mOldPanelHeight = 0;
      initPanelExtendHeight();
      if ((this.mPanelController.mBaseChatPie != null) && (this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
        this.mPanelController.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
      }
      updateViewAlpha();
    }
  }
  
  protected void setUpdateViewAlphaDisEnable(boolean paramBoolean)
  {
    BaseEmotionAdapter localBaseEmotionAdapter = getEmoticonPanelBaseEmotionAdapter();
    if (localBaseEmotionAdapter != null) {
      ((EmoticonPanelOnScrollListener)localBaseEmotionAdapter.getCurrentListView().getOnScrollListener()).setDisUpdateViewAlpha(paramBoolean);
    }
  }
  
  protected void updateDeleteBtnVisibility(String paramString)
  {
    Object localObject = this.mPanelController.pageAdapter;
    List localList = this.mPanelController.panelDataList;
    if ((localObject != null) && (localList != null) && (EmoticonPanelController.sLastSelectedSecondTabIndex >= 0) && (EmoticonPanelController.sLastSelectedSecondTabIndex < localList.size()))
    {
      localObject = ((EmotionPanelViewPagerAdapter)localObject).getDeleteButtonFromCache(EmoticonPanelController.sLastSelectedSecondTabIndex);
      if (localObject != null)
      {
        setUpdateViewAlphaDisEnable(true);
        if (!TextUtils.isEmpty(paramString)) {
          break label91;
        }
      }
    }
    label91:
    for (int i = 8;; i = 0)
    {
      ((ImageButton)localObject).setVisibility(i);
      ((ImageButton)localObject).post(new EmoticonPanelExtendHelper.4(this));
      return;
    }
  }
  
  protected void updateViewAlpha()
  {
    BaseEmotionAdapter localBaseEmotionAdapter = getEmoticonPanelBaseEmotionAdapter();
    if (localBaseEmotionAdapter != null) {
      ((EmoticonPanelOnScrollListener)localBaseEmotionAdapter.getCurrentListView().getOnScrollListener()).updateViewAlpha(localBaseEmotionAdapter.getCurrentListView());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper
 * JD-Core Version:    0.7.0.1
 */