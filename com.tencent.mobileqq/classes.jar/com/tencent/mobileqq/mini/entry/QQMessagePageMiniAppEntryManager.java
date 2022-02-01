package com.tencent.mobileqq.mini.entry;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.StoryTouchEventInterceptor;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.QQStoryListViewListener;
import com.tencent.widget.ListView;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class QQMessagePageMiniAppEntryManager
  implements DrawerFrame.StoryTouchEventInterceptor, MiniAppPullInterface, ARMapHongBaoListView.QQStoryListViewListener, BusinessObserver
{
  public static final long APP_STORE_TIME_THRESHOLD = 86400000L;
  public static final int MODE_IDLE = 1;
  public static final int MODE_REFRESH = 2;
  public static final int MODE_SHOW_NODE = 3;
  private static final int OFFSET_NODE_OPEN = ViewUtils.a(-50.0F);
  private static final int OFFSET_NODE_SCROLL = ViewUtils.a(-50.0F);
  private static final int OFFSET_NODE_SCROLL_FAST = ViewUtils.a(-100.0F);
  private static final int OVER_FLING_DISTANCE = 70;
  private static final float SPEED_2 = 1.5F;
  private static final int STORY_TRANSLATE = ViewUtils.a(-70.0F);
  public static final String TAG = "QQMessagePageMicroAppEntryManager";
  private int OFFSET_SCROLL_OVER;
  private final int OVER_FLING_DISTANCE_DEFAULT = 30;
  QQMessagePageMiniAppEntryManager.RedDotAppletsObserver appletsObserver = new QQMessagePageMiniAppEntryManager.RedDotAppletsObserver(this);
  boolean flag = false;
  private boolean isFirstOpenMiniAppEntry = false;
  private QQAppInterface mApp;
  private final CareNotificationBar mCareNotificationBar;
  private PullRefreshHeader mChatTopRefresh;
  private MiniAppEntryLayout mContentView;
  private Context mContext;
  private DrawerFrame mDrawer;
  private ARMapHongBaoListView mListView;
  private ViewGroup mMiniAppListLayout;
  private int mode = 1;
  private int preMode = 1;
  private ProgressBar refreshProgressBar;
  
  public QQMessagePageMiniAppEntryManager(Context paramContext, Conversation paramConversation, ListView paramListView, PullRefreshHeader paramPullRefreshHeader, DrawerFrame paramDrawerFrame)
  {
    this.mContext = paramContext;
    this.mApp = paramConversation.a();
    this.mDrawer = paramDrawerFrame;
    this.mListView = ((ARMapHongBaoListView)paramListView);
    this.mChatTopRefresh = paramPullRefreshHeader;
    this.mCareNotificationBar = paramConversation.a;
  }
  
  private void doOnScroll(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.preMode != 3)) {
      this.mContentView.dotViewOnScroll(paramFloat);
    }
    QLog.d("QQMessagePageMicroAppEntryManager", 4, String.format("fight..doOnScroll.scrollY:%f,offset_node_scrll:%d,offset_scroll_over:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(OFFSET_NODE_SCROLL), Integer.valueOf(this.OFFSET_SCROLL_OVER) }));
    int i = OFFSET_NODE_SCROLL;
    if (paramFloat <= i)
    {
      int j = this.OFFSET_SCROLL_OVER;
      if (paramFloat > j)
      {
        int k = OFFSET_NODE_SCROLL_FAST;
        if (paramFloat <= k)
        {
          f1 = (k - paramFloat) / (k - j);
          f2 = STORY_TRANSLATE + (i - k);
          f1 = f2 - f1 * f2 * 1.5F;
        }
        else
        {
          f1 = STORY_TRANSLATE;
          f1 = i - paramFloat + f1;
        }
        float f2 = this.mMiniAppListLayout.getTranslationY();
        this.mMiniAppListLayout.setTranslationY(f1);
        f1 = this.mMiniAppListLayout.getTranslationY();
        i = STORY_TRANSLATE;
        if (f1 < i) {
          this.mMiniAppListLayout.setTranslationY(i);
        }
        if (this.mMiniAppListLayout.getTranslationY() > 0.0F) {
          this.mMiniAppListLayout.setTranslationY(0.0F);
        }
        f1 = this.mMiniAppListLayout.getTranslationY() - f2;
        setMicroAppEntryPanelAlpha(1.0F - this.mMiniAppListLayout.getTranslationY() / STORY_TRANSLATE + 0.8F);
        break label282;
      }
    }
    i = this.OFFSET_SCROLL_OVER;
    if ((paramFloat <= i) && (i != 0)) {
      setMicroAppEntryCompleteVisible(true);
    }
    float f1 = 0.0F;
    label282:
    MiniAppEntryLayout localMiniAppEntryLayout;
    if (paramFloat > ViewUtils.b(-70.0F))
    {
      localMiniAppEntryLayout = this.mContentView;
      localMiniAppEntryLayout.setDotViewTranslationY((localMiniAppEntryLayout.getDotViewHeight() + paramFloat) / 2.0F);
    }
    else
    {
      localMiniAppEntryLayout = this.mContentView;
      localMiniAppEntryLayout.setDotViewTranslationY(localMiniAppEntryLayout.getDotViewTranslationY() + f1);
    }
    if (Math.signum(paramFloat) == 0.0F)
    {
      paramBoolean = this.mCareNotificationBar.a();
      this.mCareNotificationBar.a(false);
      if (paramBoolean != this.mCareNotificationBar.a()) {
        this.mCareNotificationBar.b();
      }
    }
  }
  
  public static boolean isNightMode()
  {
    return ("1103".equals(ThemeUtil.getCurrentThemeId())) || ("2920".equals(ThemeUtil.getCurrentThemeId()));
  }
  
  private boolean needIntercept()
  {
    MiniAppEntryLayout localMiniAppEntryLayout = this.mContentView;
    if (localMiniAppEntryLayout != null)
    {
      if (this.mListView == null) {
        return false;
      }
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      localMiniAppEntryLayout.getLocationInWindow(arrayOfInt1);
      this.mListView.getLocationInWindow(arrayOfInt2);
      return (arrayOfInt1[1] >= arrayOfInt2[1]) && (this.mListView.getScrollY() < 0);
    }
    return false;
  }
  
  private boolean needShowMiniAppStoreAnimation()
  {
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject == null)
    {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "[mini_app_anim].needShowMiniAppStoreAnimation, app is null.");
      return false;
    }
    long l = ((AppInterface)localObject).getPreferences().getLong("key_mini_app_store_show_animation_time", 0L);
    l = System.currentTimeMillis() - l;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[mini_app_anim].needShowMiniAppStoreAnimation, diff time = ");
    ((StringBuilder)localObject).append(l);
    QLog.e("QQMessagePageMicroAppEntryManager", 1, ((StringBuilder)localObject).toString());
    return l > 86400000L;
  }
  
  private void setMicroAppEntryCompleteVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mMiniAppListLayout.getTranslationY() != 0.0F) {
        this.mMiniAppListLayout.setTranslationY(0.0F);
      }
      if (this.mMiniAppListLayout.getAlpha() != 1.0F) {
        setMicroAppEntryPanelAlpha(1.0F);
      }
    }
    else
    {
      float f = this.mMiniAppListLayout.getTranslationY();
      int i = STORY_TRANSLATE;
      if (f != i) {
        this.mMiniAppListLayout.setTranslationY(i);
      }
      if (this.mMiniAppListLayout.getAlpha() != 0.0F) {
        setMicroAppEntryPanelAlpha(0.0F);
      }
    }
  }
  
  private void setMicroAppEntryPanelAlpha(float paramFloat)
  {
    ViewGroup localViewGroup = this.mMiniAppListLayout;
    if (localViewGroup != null) {
      localViewGroup.setAlpha(paramFloat);
    }
  }
  
  private void setNightMode()
  {
    try
    {
      this.mListView.setOverscrollHeader(new ColorDrawable(Color.parseColor("#000000")));
      int i = this.mContext.getResources().getColor(2131167163);
      if (this.mChatTopRefresh != null)
      {
        this.mChatTopRefresh.setTextColor(i, i, i, i, i);
        TextView localTextView = (TextView)this.mChatTopRefresh.findViewById(2131376344);
        if (localTextView != null)
        {
          localTextView.setTextColor(i);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNightMode, e");
      localStringBuilder.append(Log.getStackTraceString(localException));
      QLog.e("QQMessagePageMicroAppEntryManager", 1, localStringBuilder.toString());
    }
  }
  
  private void setNormalMode()
  {
    try
    {
      this.mListView.setOverscrollHeader(this.mContext.getResources().getDrawable(2130851328));
      int i = this.mContext.getResources().getColor(2131167123);
      if (this.mChatTopRefresh != null)
      {
        this.mChatTopRefresh.setTextColor(i, i, i, i, i);
        TextView localTextView = (TextView)this.mChatTopRefresh.findViewById(2131376344);
        if (localTextView != null)
        {
          localTextView.setTextColor(i);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNormalMode, e");
      localStringBuilder.append(Log.getStackTraceString(localException));
      QLog.e("QQMessagePageMicroAppEntryManager", 1, localStringBuilder.toString());
    }
  }
  
  private void setRefreshLayoutVisible(boolean paramBoolean)
  {
    View localView = this.mChatTopRefresh.findViewById(2131376339);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  private void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2)
  {
    if ((paramPopupWindow != null) && (paramView != null))
    {
      paramPopupWindow.showAtLocation(paramView, 48, paramInt1, paramInt2);
      paramPopupWindow.setFocusable(true);
      paramPopupWindow.setTouchable(true);
      paramPopupWindow.setOutsideTouchable(true);
    }
    try
    {
      paramPopupWindow.update();
    }
    catch (Exception localException)
    {
      label40:
      break label40;
    }
    QLog.e("QQMessagePageMicroAppEntryManager", 1, "showAsDropDown.update() exception!");
    paramView.postDelayed(new QQMessagePageMiniAppEntryManager.3(this, paramPopupWindow), 5000L);
  }
  
  private void shutdownMiniAppPullDownEntry()
  {
    try
    {
      if (this.mChatTopRefresh.indexOfChild(this.mContentView) >= 0)
      {
        hideMiniAppEntry(-1);
        this.mChatTopRefresh.removeView(this.mContentView);
        setRefreshLayoutVisible(true);
        this.mListView.setMaxOverScrollTopDistance(30);
        this.mListView.setQQStoryListViewListener(null);
        this.mListView.scrollTo(0, 0);
        this.mListView.mEnableStory = false;
        this.mListView.mForStory = false;
        this.mode = 1;
        if (this.mDrawer != null)
        {
          this.mDrawer.a(FrameControllerUtil.a);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shutdownMiniAppPullDownEntry, ");
      localStringBuilder.append(Log.getStackTraceString(localException));
      QLog.e("QQMessagePageMicroAppEntryManager", 1, localStringBuilder.toString());
    }
  }
  
  private void updateRefreshTheme()
  {
    try
    {
      if (this.refreshProgressBar != null)
      {
        Drawable localDrawable = this.mContext.getResources().getDrawable(2130839406);
        this.refreshProgressBar.setIndeterminateDrawable(localDrawable);
      }
      if (this.mChatTopRefresh != null) {
        this.mChatTopRefresh.setArrowColor(0);
      }
      if (isNightMode())
      {
        setNightMode();
        return;
      }
      setNormalMode();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "updateRefreshTheme error.", localThrowable);
    }
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    float f = paramARMapHongBaoListView.getScrollY();
    int i = this.mode;
    if (i == 1)
    {
      this.mContentView.stopSwitchIconAnimation();
      this.mCareNotificationBar.b();
      MiniAppEntryLayout.exposureReport();
      return 0;
    }
    if (i == 3)
    {
      if (needShowMiniAppStoreAnimation()) {
        this.mContentView.startSwitchIconAnimation();
      }
      this.mCareNotificationBar.a();
      return -this.mContentView.getHeight();
    }
    if (i == 2)
    {
      this.mCareNotificationBar.a();
      return -paramARMapHongBaoListView.getOverScrollHeight();
    }
    return (int)f;
  }
  
  public void handlePullRefresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMessagePageMicroAppEntryManager", 1, "[MiniAppUserAppInfoListManager]. handlePullRefresh");
    }
    MiniAppUtils.checkSendUserAppListRequest();
  }
  
  public boolean hasOpenDesktop()
  {
    return this.mode != 1;
  }
  
  public void hideMiniAppEntry(int paramInt)
  {
    if ((this.mListView.mEnableStory) && (this.mListView.mForStory))
    {
      this.mListView.setScrollY(0);
      this.mListView.mForStory = false;
      this.mode = 1;
      setMicroAppEntryCompleteVisible(false);
      setRefreshLayoutVisible(false);
    }
  }
  
  public void initLater(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup instanceof DrawerFrame)) {
      initLaterDrawerFrame((DrawerFrame)paramViewGroup);
    }
  }
  
  public void initLaterDrawerFrame(DrawerFrame paramDrawerFrame)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramDrawerFrame);
      localStringBuilder.append(" initLater ");
      localStringBuilder.append(this.mListView.mEnableStory);
      QLog.i("QQMessagePageMicroAppEntryManager", 2, localStringBuilder.toString());
    }
    this.mDrawer = paramDrawerFrame;
    paramDrawerFrame = this.mDrawer;
    if (paramDrawerFrame != null) {
      paramDrawerFrame.setMiniAppTouchEventInterceptor(FrameControllerUtil.a, this);
    }
  }
  
  public void initUI(Activity paramActivity)
  {
    QLog.d("QQMessagePageMicroAppEntryManager", 1, "initUI");
    if (this.mChatTopRefresh != null)
    {
      this.mContentView = new MiniAppEntryLayout(paramActivity, this.mListView, 0);
      this.mMiniAppListLayout = this.mContentView.getContainerView();
      this.mApp.registObserver(this);
      this.mApp.addObserver(this.appletsObserver);
      paramActivity = (MiniAppUserAppInfoListManager)this.mApp.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
      if (this.mChatTopRefresh.indexOfChild(this.mContentView) < 0)
      {
        Object localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131376339);
        this.mChatTopRefresh.addView(this.mContentView, (ViewGroup.LayoutParams)localObject);
        this.refreshProgressBar = ((ProgressBar)this.mChatTopRefresh.findViewById(2131376345));
        updateRefreshTheme();
        this.mListView.setMaxOverScrollTopDistance(70);
        this.mListView.setQQStoryListViewListener(this);
        localObject = this.mListView;
        ((ARMapHongBaoListView)localObject).mEnableStory = true;
        ((ARMapHongBaoListView)localObject).mForStory = false;
        this.mode = 1;
        localObject = this.mDrawer;
        if (localObject != null) {
          ((DrawerFrame)localObject).setMiniAppTouchEventInterceptor(FrameControllerUtil.a, this);
        }
        this.mListView.setScrollY(0);
        setMicroAppEntryCompleteVisible(false);
        this.mContentView.resetDotViewStatus();
        this.mContentView.addOnLayoutChangeListener(new QQMessagePageMiniAppEntryManager.1(this));
      }
      if (paramActivity != null)
      {
        paramActivity.initLocalCacheData();
        paramActivity.sendUserAppListRequest(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue(), 20L);
      }
    }
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    if (needIntercept()) {
      return this.mContentView.interceptDrawer(paramView, paramMotionEvent);
    }
    if (this.mListView != null)
    {
      paramView = new StringBuilder();
      paramView.append("interceptDrawer error. listView, scrollY: ");
      paramView.append(this.mListView.getScrollY());
      QLog.e("QQMessagePageMicroAppEntryManager", 2, paramView.toString());
    }
    return false;
  }
  
  public boolean isMiniAppLauncherOpened()
  {
    return false;
  }
  
  public void onAccountChanged(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      onAccountChangedInternal((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onAccountChangedInternal(QQAppInterface paramQQAppInterface)
  {
    this.mApp.unRegistObserver(this);
    this.mApp.removeObserver(this.appletsObserver);
    this.mApp = paramQQAppInterface;
    Object localObject = MiniAppConfProcessor.a();
    boolean bool;
    if (localObject != null) {
      bool = ((MiniAppConfBean)localObject).a();
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniAppUserAppInfoListManager].onAccountChanged: ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("QQMessagePageMicroAppEntryManager", 1, ((StringBuilder)localObject).toString());
    if ((!bool) && (this.mChatTopRefresh != null) && (this.mContentView != null))
    {
      shutdownMiniAppPullDownEntry();
      QLog.d("QQMessagePageMicroAppEntryManager", 1, "onAccountChanged: shutDown mini app entry");
      return;
    }
    paramQQAppInterface.registObserver(this);
    this.appletsObserver = new QQMessagePageMiniAppEntryManager.RedDotAppletsObserver(this);
    paramQQAppInterface.addObserver(this.appletsObserver);
    localObject = (MiniAppUserAppInfoListManager)paramQQAppInterface.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    ((MiniAppUserAppInfoListManager)localObject).queryMiniAppInfoFromDb();
    ((MiniAppUserAppInfoListManager)localObject).asyncQueryMiniAppPushRedDotData();
    ThreadManager.executeOnSubThread(new QQMessagePageMiniAppEntryManager.2(this, paramQQAppInterface));
  }
  
  public void onChangeRedDotSwitch(int paramInt, boolean paramBoolean)
  {
    if ((this.mContentView != null) && (MiniAppConfProcessor.h())) {
      this.mContentView.onChangeRedDotSwitch(paramInt, paramBoolean);
    }
  }
  
  public void onDestroy()
  {
    QLog.d("QQMessagePageMicroAppEntryManager", 1, "onDestroy");
  }
  
  public void onFlingScrollHeader(int paramInt1, int paramInt2)
  {
    if ((this.mListView.mEnableStory) && (this.mContentView != null))
    {
      if ((paramInt1 == 2) && (this.OFFSET_SCROLL_OVER != 0)) {
        doOnScroll(paramInt2, false);
      }
      if ((this.mContentView.getHeight() != 0) && (paramInt2 <= -this.mContentView.getHeight()))
      {
        setMicroAppEntryCompleteVisible(true);
        this.mContentView.resetDotViewStatus();
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    this.mContentView.onPostThemeChanged();
    updateRefreshTheme();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("[MiniAppUserAppInfoListManager], onReceive, type = ");
      paramBundle.append(paramInt);
      paramBundle.append(" , mContentView = ");
      paramBundle.append(this.mContentView);
      QLog.d("QQMessagePageMicroAppEntryManager", 2, paramBundle.toString());
    }
    if (paramInt == 100)
    {
      hideMiniAppEntry(-1);
      return;
    }
    if (paramInt == 103)
    {
      try
      {
        if (this.mContentView != null)
        {
          updateRefreshTheme();
          this.mContentView.updateHongBaoRes();
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("QQMessagePageMicroAppEntryManager", 1, "TYPE_HONGBAO_UPDATE_DESKTOP_RES error.", paramBundle);
      }
      return;
    }
    paramBundle = this.mContentView;
    if (paramBundle != null) {
      paramBundle.updateMicroAppItemData();
    }
  }
  
  public void onResume() {}
  
  public void onStop() {}
  
  public void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    if (this.mContentView.getVisibility() != 0) {
      this.mContentView.setVisibility(0);
    }
    if (this.OFFSET_SCROLL_OVER == 0) {
      this.OFFSET_SCROLL_OVER = (-this.mContentView.getHeight());
    }
    float f = paramARMapHongBaoListView.getScrollY();
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i == 3) {}
        }
        else
        {
          if ((!this.flag) && (this.mode == 1))
          {
            this.flag = true;
            setMicroAppEntryCompleteVisible(false);
            this.mContentView.resetDotViewStatus();
          }
          if ((f <= 0.0F) && (this.mode == 1))
          {
            doOnScroll(f, true);
            return;
          }
          if (f >= 0.0F) {
            return;
          }
          paramARMapHongBaoListView = new StringBuilder();
          paramARMapHongBaoListView.append("fight...onTouchMoving.onMove..scrollY = ");
          paramARMapHongBaoListView.append(f);
          QLog.d("QQMessagePageMicroAppEntryManager", 2, paramARMapHongBaoListView.toString());
          return;
        }
      }
      i = paramARMapHongBaoListView.getListViewScrollY();
      if ((i > 0) && (f == 0.0F))
      {
        this.mCareNotificationBar.a(false);
        this.mCareNotificationBar.b();
      }
      else if (i == 0)
      {
        this.mCareNotificationBar.a(true);
        this.mCareNotificationBar.b();
      }
      this.flag = false;
      this.preMode = this.mode;
      if (f >= 0.0F)
      {
        paramBoolean = paramARMapHongBaoListView.mForStory;
        this.mode = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
      else if (paramARMapHongBaoListView.mForStory)
      {
        if (f <= -paramARMapHongBaoListView.getOverScrollHeight())
        {
          paramMotionEvent = (TextView)this.mChatTopRefresh.findViewById(2131376344);
          if ((paramMotionEvent.getText().toString() != null) && (paramMotionEvent.getText().toString().contains(HardCodeUtil.a(2131710409))))
          {
            this.mode = 3;
          }
          else
          {
            QLog.d("QQMessagePageMicroAppEntryManager", 2, "story node start refresh onTouchMoving");
            this.mode = 2;
          }
          paramARMapHongBaoListView.mForStory = true;
        }
        else if (f <= -this.mContentView.getHeight())
        {
          this.mode = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
        else
        {
          this.mode = 1;
          paramARMapHongBaoListView.mForStory = false;
        }
      }
      else if (f <= -this.mContentView.getHeight())
      {
        if (this.mode != 2)
        {
          this.mode = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
      }
      else if (f <= OFFSET_NODE_OPEN)
      {
        if (this.mode == 2)
        {
          setMicroAppEntryCompleteVisible(false);
        }
        else
        {
          this.mode = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
      }
      else
      {
        this.mode = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
      if ((this.preMode == 1) && (this.mode == 3))
      {
        this.mContentView.recordExposureItem();
        MiniProgramLpReportDC04239.reportPageView("expo_page", "pulldown_mini_msg");
      }
      setRefreshLayoutVisible(paramARMapHongBaoListView.mForStory);
      paramARMapHongBaoListView = new StringBuilder();
      paramARMapHongBaoListView.append("fight...onTouchMoving.onUp..scrollY = ");
      paramARMapHongBaoListView.append(f);
      QLog.d("QQMessagePageMicroAppEntryManager", 2, paramARMapHongBaoListView.toString());
    }
    else if (this.mode == 1)
    {
      this.flag = true;
      setMicroAppEntryCompleteVisible(false);
      this.mContentView.resetDotViewStatus();
    }
  }
  
  public int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewCompleteAfterRefresh, mode:");
      localStringBuilder.append(this.mode);
      QLog.d("QQMessagePageMicroAppEntryManager", 2, localStringBuilder.toString());
    }
    this.mContentView.updateMicroAppItemData();
    int i = this.mode;
    if (i == 2) {
      if (paramARMapHongBaoListView.mForStory) {
        this.mode = 3;
      }
    }
    for (i = this.mContentView.getHeight();; i = this.mContentView.getHeight())
    {
      return -i;
      this.mode = 1;
      return 0;
      if (i != 3) {
        break;
      }
    }
    return 0;
  }
  
  public boolean showMicroAppEntry()
  {
    if ((this.mListView.mEnableStory) && (!this.mListView.mForStory) && (this.mListView.getListViewScrollY() == 0))
    {
      this.mListView.setScrollY(-this.mContentView.getHeight());
      this.mListView.mForStory = true;
      this.mode = 3;
      setMicroAppEntryCompleteVisible(true);
      this.mContentView.resetDotViewStatus();
      setRefreshLayoutVisible(true);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager
 * JD-Core Version:    0.7.0.1
 */