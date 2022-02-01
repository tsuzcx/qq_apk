package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener.InterceptListener;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.List;

public class EmoticonPanelExtendHelper
  extends AbstractEmoticonPanelHelper<EmoticonPanelController>
  implements IPanelInteractionListener.InterceptListener, EmotionPanelListView.PullAndFastScrollListener, IEmoticonPanelExtendHelper
{
  private static final String LOG_TAG = "EmoticonPanelExtendHelper";
  private static int sMaxPanelHeight;
  private QQEmoticonMainPanelApp app;
  private float mDowny;
  private IPanelInteractionListener mInteractionListener;
  private EmoticonMainPanel mMainPanel;
  private int mOldPanelHeight = 0;
  private int mOriginPanelHeight;
  private int mStartHeight;
  private TextWatcher textWatcher = new EmoticonPanelExtendHelper.4(this);
  
  public EmoticonPanelExtendHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private void doPanelAnim(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new EmoticonPanelExtendHelper.3(this, paramInt3));
    localValueAnimator.start();
  }
  
  private boolean needExtendPanel()
  {
    return (sMaxPanelHeight > this.mOriginPanelHeight) && (isShowExtendPanel());
  }
  
  private void reportPanelUpDown(String paramString)
  {
    if ((((EmoticonPanelController)this.mPanelController).getPanelDataList() != null) && (BasePanelModel.sLastSelectedSecondTabIndex >= 0) && (BasePanelModel.sLastSelectedSecondTabIndex < ((EmoticonPanelController)this.mPanelController).getPanelDataList().size()))
    {
      EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)((EmoticonPanelController)this.mPanelController).getPanelDataList().get(BasePanelModel.sLastSelectedSecondTabIndex);
      if (localEmotionPanelInfo.type == 7)
      {
        ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
        return;
      }
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
      if ((localEmotionPanelInfo.type == 9) || (localEmotionPanelInfo.type == 6)) {
        ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", paramString, paramString, 6, 0, "", "", "", "");
      }
    }
  }
  
  protected void abortFling()
  {
    if ((((EmoticonPanelController)this.mPanelController).getPageAdapter() != null) && (((EmoticonPanelController)this.mPanelController).getPanelDataList() != null) && (BasePanelModel.sLastSelectedSecondTabIndex >= 0) && (BasePanelModel.sLastSelectedSecondTabIndex < ((EmoticonPanelController)this.mPanelController).getPanelDataList().size()))
    {
      Object localObject = (EmotionPanelInfo)((EmoticonPanelController)this.mPanelController).getPanelDataList().get(BasePanelModel.sLastSelectedSecondTabIndex);
      localObject = ((EmoticonPanelController)this.mPanelController).getPageAdapter().getAdapterFromCache((EmotionPanelInfo)localObject);
      if ((localObject != null) && (((BaseEmotionAdapter)localObject).getCurrentListView() != null)) {
        ((BaseEmotionAdapter)localObject).getCurrentListView().abordFling();
      }
    }
  }
  
  protected BaseEmotionAdapter getEmoticonPanelBaseEmotionAdapter()
  {
    if ((((EmoticonPanelController)this.mPanelController).getPageAdapter() != null) && (((EmoticonPanelController)this.mPanelController).getPanelDataList() != null) && (BasePanelModel.sLastSelectedSecondTabIndex >= 0) && (BasePanelModel.sLastSelectedSecondTabIndex < ((EmoticonPanelController)this.mPanelController).getPanelDataList().size()))
    {
      Object localObject = (EmotionPanelInfo)((EmoticonPanelController)this.mPanelController).getPanelDataList().get(BasePanelModel.sLastSelectedSecondTabIndex);
      localObject = ((EmoticonPanelController)this.mPanelController).getPageAdapter().getAdapterFromCache((EmotionPanelInfo)localObject);
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
    int i = paramMotionEvent.getAction();
    int j;
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
      }
      else
      {
        j = (int)(paramMotionEvent.getY() - this.mDowny + 0.5F);
        i = XPanelContainer.a;
        XPanelContainer.a -= j;
        j = XPanelContainer.a;
        k = sMaxPanelHeight;
        if (j > k)
        {
          XPanelContainer.a = k;
        }
        else
        {
          j = XPanelContainer.a;
          k = this.mOriginPanelHeight;
          if (j < k) {
            XPanelContainer.a = k;
          }
        }
        if (XPanelContainer.a == i) {
          break label322;
        }
        AbstractGifImage.pauseAll();
        if (this.mMainPanel.getParent() == null) {
          break label322;
        }
        this.mMainPanel.getParent().requestLayout();
        return true;
      }
    }
    int k = XPanelContainer.a;
    i = sMaxPanelHeight;
    if (k != i)
    {
      j = this.mOriginPanelHeight;
      if (k != j)
      {
        if (k <= this.mStartHeight) {
          i = j;
        }
        if (Math.abs(k - this.mStartHeight) > 100) {
          j = 1;
        } else {
          j = 0;
        }
        if (j == 0) {
          i = this.mStartHeight;
        }
        if ((j != 0) && (i == this.mOriginPanelHeight))
        {
          reportPanelUpDown("0X800A847");
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonPanelExtendHelper", 2, "report panel close");
          }
        }
        else if ((j != 0) && (i == sMaxPanelHeight))
        {
          reportPanelUpDown("0X800A846");
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonPanelExtendHelper", 2, "report panel open");
          }
        }
        paramMotionEvent = ValueAnimator.ofInt(new int[] { XPanelContainer.a, i });
        paramMotionEvent.setDuration(150L);
        paramMotionEvent.addUpdateListener(new EmoticonPanelExtendHelper.1(this, i));
        paramMotionEvent.start();
        return true;
      }
    }
    AbstractGifImage.resumeAll();
    label322:
    return true;
  }
  
  public void initBefore()
  {
    this.mInteractionListener = ((EmoticonPanelController)this.mPanelController).getInteractionListener();
    this.app = ((EmoticonPanelController)this.mPanelController).app;
    this.mMainPanel = ((EmoticonPanelController)this.mPanelController).getPanel();
    double d = this.app.getApp().getResources().getDisplayMetrics().heightPixels;
    Double.isNaN(d);
    sMaxPanelHeight = (int)(d * 0.6D);
  }
  
  void initPanelExtendHeight()
  {
    if (this.mOriginPanelHeight > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("originPanelHeight has value is ");
      localStringBuilder.append(this.mOriginPanelHeight);
      QLog.e("EmoticonPanelExtendHelper", 2, localStringBuilder.toString());
      return;
    }
    this.mOriginPanelHeight = XPanelContainer.a;
    ((EmoticonPanelController)this.mPanelController).getPanel().post(new EmoticonPanelExtendHelper.2(this));
  }
  
  public boolean interceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!needExtendPanel()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 2)
      {
        if (((EmoticonPanelController)this.mPanelController).getPanel().getParent() != null)
        {
          ((EmoticonPanelController)this.mPanelController).getPanel().getParent().requestDisallowInterceptTouchEvent(false);
          return false;
        }
      }
      else
      {
        float f = paramMotionEvent.getY();
        i = (int)(f - this.mDowny + 0.5F);
        if ((isShowExtendPanel()) && (this.mInteractionListener.getPanelicons() != null) && (Math.abs(i) > this.mInteractionListener.getPanelicons().getHeight() * 0.6F))
        {
          this.mDowny = f;
          return true;
        }
      }
    }
    else
    {
      this.mDowny = paramMotionEvent.getY();
      this.mStartHeight = XPanelContainer.a;
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 9, 4, 5, 1, 3, 11, 12 };
  }
  
  public boolean isPanelOpen()
  {
    return XPanelContainer.a == sMaxPanelHeight;
  }
  
  boolean isShowExtendPanel()
  {
    IPanelInteractionListener localIPanelInteractionListener = this.mInteractionListener;
    return (localIPanelInteractionListener != null) && (localIPanelInteractionListener.getBaseChatPie() != null) && (!((EmoticonPanelController)this.mPanelController).getParams().kanDianBiu) && (this.mInteractionListener.getAIOInput() != null);
  }
  
  public void onAttachedToWindow()
  {
    if (isShowExtendPanel()) {
      this.mInteractionListener.getAIOInput().addTextChangedListener(this.textWatcher);
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (isShowExtendPanel())
    {
      this.mInteractionListener.getAIOInput().removeTextChangedListener(this.textWatcher);
      this.mOldPanelHeight = XPanelContainer.a;
      int i = this.mOriginPanelHeight;
      if (i != sMaxPanelHeight) {
        XPanelContainer.a = i;
      }
    }
  }
  
  public void onHide(boolean paramBoolean)
  {
    if (isShowExtendPanel())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onHide.");
      }
      int i;
      if (!paramBoolean)
      {
        i = this.mOriginPanelHeight;
        if (i != sMaxPanelHeight) {
          XPanelContainer.a = i;
        }
      }
      else
      {
        i = this.mOldPanelHeight;
        if (i != 0) {
          XPanelContainer.a = i;
        }
      }
      this.mOldPanelHeight = 0;
      this.mInteractionListener.setPaneliconsInterceptListener(null);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    IPanelInteractionListener localIPanelInteractionListener = this.mInteractionListener;
    if ((localIPanelInteractionListener != null) && (localIPanelInteractionListener.getAIOInput() != null)) {
      updateDeleteBtnVisibility(this.mInteractionListener.getAIOInput().getText().toString());
    }
  }
  
  public void onPullDown()
  {
    if (!needExtendPanel()) {
      return;
    }
    if (XPanelContainer.a == sMaxPanelHeight)
    {
      doPanelAnim(250, XPanelContainer.a, this.mOriginPanelHeight);
      reportPanelUpDown("0X800A847");
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onPullDown");
      }
    }
  }
  
  public void onPullUp()
  {
    if (!needExtendPanel()) {
      return;
    }
    if (XPanelContainer.a == this.mOriginPanelHeight)
    {
      doPanelAnim(200, XPanelContainer.a, sMaxPanelHeight);
      reportPanelUpDown("0X800A846");
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onPullUp");
      }
    }
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
      this.mInteractionListener.setPaneliconsInterceptListener(this);
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
    Object localObject = ((EmoticonPanelController)this.mPanelController).getPageAdapter();
    List localList = ((EmoticonPanelController)this.mPanelController).getPanelDataList();
    if ((localObject != null) && (localList != null) && (BasePanelModel.sLastSelectedSecondTabIndex >= 0) && (BasePanelModel.sLastSelectedSecondTabIndex < localList.size()))
    {
      localObject = ((EmotionPanelViewPagerAdapter)localObject).getDeleteButtonFromCache(BasePanelModel.sLastSelectedSecondTabIndex);
      if (localObject != null)
      {
        setUpdateViewAlphaDisEnable(true);
        int i;
        if (TextUtils.isEmpty(paramString)) {
          i = 8;
        } else {
          i = 0;
        }
        ((ImageButton)localObject).setVisibility(i);
        ((ImageButton)localObject).post(new EmoticonPanelExtendHelper.5(this));
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper
 * JD-Core Version:    0.7.0.1
 */