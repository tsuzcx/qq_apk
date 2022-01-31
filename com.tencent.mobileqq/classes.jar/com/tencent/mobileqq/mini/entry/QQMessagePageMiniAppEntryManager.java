package com.tencent.mobileqq.mini.entry;

import ahfx;
import ahml;
import ahqy;
import ajya;
import amta;
import amtb;
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
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bbll;
import bfol;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntryBannerView;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.HongBaoResBuilder;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ListView;
import mqq.observer.BusinessObserver;

public class QQMessagePageMiniAppEntryManager
  implements ahml, bfol, MiniAppPullInterface, BusinessObserver
{
  public static final long APP_STORE_TIME_THRESHOLD = 86400000L;
  public static final int MODE_IDLE = 1;
  public static final int MODE_REFRESH = 2;
  public static final int MODE_SHOW_NODE = 3;
  private static final int OFFSET_NODE_OPEN = bbll.a(-50.0F);
  private static final int OFFSET_NODE_SCROLL = bbll.a(-50.0F);
  private static final int OFFSET_NODE_SCROLL_FAST = bbll.a(-100.0F);
  private static final int OVER_FLING_DISTANCE = 70;
  private static final float SPEED_2 = 1.5F;
  private static final int STORY_TRANSLATE = bbll.a(-70.0F);
  public static final String TAG = "QQMessagePageMicroAppEntryManager";
  private int OFFSET_SCROLL_OVER;
  private final int OVER_FLING_DISTANCE_DEFAULT = 30;
  QQMessagePageMiniAppEntryManager.RedDotAppletsObserver appletsObserver = new QQMessagePageMiniAppEntryManager.RedDotAppletsObserver(this);
  boolean flag = false;
  private boolean isFirstOpenMiniAppEntry;
  private QQAppInterface mApp;
  private SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo mBannerInfo;
  private final ahqy mCareNotificationBar;
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
    this.mApp = paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.mDrawer = paramDrawerFrame;
    this.mListView = ((ARMapHongBaoListView)paramListView);
    this.mChatTopRefresh = paramPullRefreshHeader;
    this.mCareNotificationBar = paramConversation.jdField_a_of_type_Ahqy;
  }
  
  private void doOnScroll(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.preMode != 3)) {
      this.mContentView.dotViewOnScroll(paramFloat);
    }
    QLog.d("QQMessagePageMicroAppEntryManager", 4, String.format("fight..doOnScroll.scrollY:%f,offset_node_scrll:%d,offset_scroll_over:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(OFFSET_NODE_SCROLL), Integer.valueOf(this.OFFSET_SCROLL_OVER) }));
    float f1;
    if ((paramFloat <= OFFSET_NODE_SCROLL) && (paramFloat > this.OFFSET_SCROLL_OVER)) {
      if (paramFloat <= OFFSET_NODE_SCROLL_FAST)
      {
        f1 = (OFFSET_NODE_SCROLL_FAST - paramFloat) / (OFFSET_NODE_SCROLL_FAST - this.OFFSET_SCROLL_OVER);
        float f2 = STORY_TRANSLATE + (OFFSET_NODE_SCROLL - OFFSET_NODE_SCROLL_FAST);
        f1 = f2 - f1 * f2 * 1.5F;
        f2 = this.mMiniAppListLayout.getTranslationY();
        this.mMiniAppListLayout.setTranslationY(f1);
        if (this.mMiniAppListLayout.getTranslationY() < STORY_TRANSLATE) {
          this.mMiniAppListLayout.setTranslationY(STORY_TRANSLATE);
        }
        if (this.mMiniAppListLayout.getTranslationY() > 0.0F) {
          this.mMiniAppListLayout.setTranslationY(0.0F);
        }
        f1 = this.mMiniAppListLayout.getTranslationY() - f2;
        setMicroAppEntryPanelAlpha(1.0F - this.mMiniAppListLayout.getTranslationY() / STORY_TRANSLATE + 0.8F);
        label226:
        if (paramFloat <= bbll.b(-70.0F)) {
          break label342;
        }
        this.mContentView.setDotViewTranslationY((this.mContentView.getDotViewHeight() + paramFloat) / 2.0F);
      }
    }
    for (;;)
    {
      if (Math.signum(paramFloat) == 0.0F)
      {
        paramBoolean = this.mCareNotificationBar.a();
        this.mCareNotificationBar.a(false);
        if (paramBoolean != this.mCareNotificationBar.a()) {
          this.mCareNotificationBar.b();
        }
      }
      return;
      f1 = STORY_TRANSLATE + (OFFSET_NODE_SCROLL - paramFloat);
      break;
      if ((paramFloat <= this.OFFSET_SCROLL_OVER) && (this.OFFSET_SCROLL_OVER != 0)) {
        setMicroAppEntryCompleteVisible(true);
      }
      f1 = 0.0F;
      break label226;
      label342:
      this.mContentView.setDotViewTranslationY(f1 + this.mContentView.getDotViewTranslationY());
    }
  }
  
  public static boolean isNightMode()
  {
    return ("1103".equals(ThemeUtil.getCurrentThemeId())) || ("2920".equals(ThemeUtil.getCurrentThemeId()));
  }
  
  private boolean needIntercept()
  {
    boolean bool = true;
    if ((this.mContentView == null) || (this.mListView == null)) {
      bool = false;
    }
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    do
    {
      return bool;
      arrayOfInt1 = new int[2];
      arrayOfInt2 = new int[2];
      this.mContentView.getLocationInWindow(arrayOfInt1);
      this.mListView.getLocationInWindow(arrayOfInt2);
    } while ((arrayOfInt1[1] >= arrayOfInt2[1]) && (this.mListView.getScrollY() < 0));
    return false;
  }
  
  private boolean needShowMiniAppStoreAnimation()
  {
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    if (localAppInterface == null) {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "[mini_app_anim].needShowMiniAppStoreAnimation, app is null.");
    }
    long l;
    do
    {
      return false;
      l = localAppInterface.getPreferences().getLong("key_mini_app_store_show_animation_time", 0L);
      l = System.currentTimeMillis() - l;
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "[mini_app_anim].needShowMiniAppStoreAnimation, diff time = " + l);
    } while (l <= 86400000L);
    return true;
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
    do
    {
      return;
      if (this.mMiniAppListLayout.getTranslationY() != STORY_TRANSLATE) {
        this.mMiniAppListLayout.setTranslationY(STORY_TRANSLATE);
      }
    } while (this.mMiniAppListLayout.getAlpha() == 0.0F);
    setMicroAppEntryPanelAlpha(0.0F);
  }
  
  private void setMicroAppEntryPanelAlpha(float paramFloat)
  {
    if (this.mMiniAppListLayout != null) {
      this.mMiniAppListLayout.setAlpha(paramFloat);
    }
  }
  
  private void setNightMode()
  {
    try
    {
      this.mListView.setOverscrollHeader(new ColorDrawable(Color.parseColor("#000000")));
      int i = this.mContext.getResources().getColor(2131166952);
      this.mChatTopRefresh.setTextColor(i, i, i, i, i);
      TextView localTextView = (TextView)this.mChatTopRefresh.findViewById(2131375055);
      if (localTextView != null) {
        localTextView.setTextColor(i);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "setNightMode, e" + Log.getStackTraceString(localException));
    }
  }
  
  private void setNormalMode()
  {
    try
    {
      this.mListView.setOverscrollHeader(this.mContext.getResources().getDrawable(2130849717));
      int i = this.mContext.getResources().getColor(2131166914);
      this.mChatTopRefresh.setTextColor(i, i, i, i, i);
      TextView localTextView = (TextView)this.mChatTopRefresh.findViewById(2131375055);
      if (localTextView != null) {
        localTextView.setTextColor(i);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "setNormalMode, e" + Log.getStackTraceString(localException));
    }
  }
  
  private void setRefreshLayoutVisible(boolean paramBoolean)
  {
    View localView = this.mChatTopRefresh.findViewById(2131375051);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
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
      paramView.postDelayed(new QQMessagePageMiniAppEntryManager.4(this, paramPopupWindow), 5000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QQMessagePageMicroAppEntryManager", 1, "showAsDropDown.update() exception!");
      }
    }
  }
  
  private void shutdownMiniAppPullDownEntry()
  {
    try
    {
      if (this.mChatTopRefresh.indexOfChild(this.mContentView) >= 0)
      {
        hideMiniAppEntry();
        this.mChatTopRefresh.removeView(this.mContentView);
        setRefreshLayoutVisible(true);
        this.mListView.setMaxOverScrollTopDistance(30);
        this.mListView.setQQStoryListViewListener(null);
        this.mListView.scrollTo(0, 0);
        this.mListView.mEnableStory = false;
        this.mListView.mForStory = false;
        this.mode = 1;
        if (this.mDrawer != null) {
          this.mDrawer.a(MainFragment.b);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQMessagePageMicroAppEntryManager", 1, "shutdownMiniAppPullDownEntry, " + Log.getStackTraceString(localException));
    }
  }
  
  private void updateRefreshTheme()
  {
    for (;;)
    {
      try
      {
        if (this.mApp == null) {
          break label333;
        }
        Object localObject1 = (ahfx)this.mApp.getManager(342);
        if ((localObject1 != null) && (((ahfx)localObject1).h()))
        {
          DesktopDataManager.HongBaoResBuilder localHongBaoResBuilder = ((ahfx)localObject1).a();
          Object localObject3 = (DesktopDataManager)this.mApp.getManager(336);
          if (((DesktopDataManager)localObject3).getHongBaoResBuilder() == null) {
            break label330;
          }
          localHongBaoResBuilder = ((DesktopDataManager)localObject3).getHongBaoResBuilder();
          if (localHongBaoResBuilder == null) {
            break;
          }
          if ((localHongBaoResBuilder.getRefreshProgressResId() != -1) && (this.refreshProgressBar != null))
          {
            localObject3 = this.mContext.getResources().getDrawable(localHongBaoResBuilder.getRefreshProgressResId());
            ((Drawable)localObject3).setBounds(0, 0, ((Drawable)localObject3).getMinimumWidth(), ((Drawable)localObject3).getMinimumHeight());
            this.refreshProgressBar.setIndeterminateDrawable((Drawable)localObject3);
          }
          if ((localHongBaoResBuilder.getRefreshTextColor() != 2147483647) && (this.mChatTopRefresh != null))
          {
            int i = localHongBaoResBuilder.getRefreshTextColor();
            this.mChatTopRefresh.setTextColor(i, i, i, i, i);
            localObject3 = (TextView)this.mChatTopRefresh.findViewById(2131375055);
            if (localObject3 != null) {
              ((TextView)localObject3).setTextColor(i);
            }
          }
          if ((localHongBaoResBuilder.getRefreshArrowColor() != -1) && (this.mChatTopRefresh != null)) {
            this.mChatTopRefresh.setArrowColor(localHongBaoResBuilder.getRefreshArrowColor());
          }
          if ((((ahfx)localObject1).a() != null) || (localHongBaoResBuilder.getBackgroundUrl() != null) || (localHongBaoResBuilder.getBackgroundResId() != -1) || (this.mListView == null)) {
            break;
          }
          this.mListView.setOverscrollHeader(new ColorDrawable(0));
          return;
        }
        if (this.refreshProgressBar != null)
        {
          localObject1 = this.mContext.getResources().getDrawable(2130839144);
          this.refreshProgressBar.setIndeterminateDrawable((Drawable)localObject1);
        }
        if (this.mChatTopRefresh != null) {
          this.mChatTopRefresh.setArrowColor(0);
        }
        if (isNightMode())
        {
          setNightMode();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQMessagePageMicroAppEntryManager", 1, "updateRefreshTheme error.", localThrowable);
        return;
      }
      setNormalMode();
      return;
      label330:
      continue;
      label333:
      Object localObject2 = null;
    }
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public View getSpringEntryView()
  {
    View localView = null;
    if (this.mContentView != null) {
      localView = this.mContentView.findViewById(2131376411);
    }
    return localView;
  }
  
  public int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    float f = paramARMapHongBaoListView.getScrollY();
    if (this.mode == 1)
    {
      this.mContentView.stopSwitchIconAnimation();
      this.mCareNotificationBar.b();
      MiniAppEntryLayout.exposureReport();
      return 0;
    }
    if (this.mode == 3)
    {
      if (needShowMiniAppStoreAnimation()) {
        this.mContentView.startSwitchIconAnimation();
      }
      this.mCareNotificationBar.a();
      return -this.mContentView.getHeight();
    }
    if (this.mode == 2)
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
  
  public void hideMiniAppEntry()
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
  
  public void initLater(DrawerFrame paramDrawerFrame)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMessagePageMicroAppEntryManager", 2, paramDrawerFrame + " initLater " + this.mListView.mEnableStory);
    }
    this.mDrawer = paramDrawerFrame;
    if (this.mDrawer != null) {
      this.mDrawer.setMiniAppTouchEventInterceptor(MainFragment.b, this);
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
      paramActivity = (MiniAppUserAppInfoListManager)this.mApp.getManager(309);
      if (this.mChatTopRefresh.indexOfChild(this.mContentView) < 0)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(3, 2131375051);
        this.mChatTopRefresh.addView(this.mContentView, localLayoutParams);
        this.refreshProgressBar = ((ProgressBar)this.mChatTopRefresh.findViewById(2131375056));
        updateRefreshTheme();
        this.mListView.setMaxOverScrollTopDistance(70);
        this.mListView.setQQStoryListViewListener(this);
        this.mListView.mEnableStory = true;
        this.mListView.mForStory = false;
        this.mode = 1;
        if (this.mDrawer != null) {
          this.mDrawer.setMiniAppTouchEventInterceptor(MainFragment.b, this);
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
      if (getSpringEntryView() != null) {
        getSpringEntryView().setOnClickListener(new QQMessagePageMiniAppEntryManager.2(this));
      }
    }
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    if (needIntercept()) {
      return this.mContentView.interceptDrawer(paramView, paramMotionEvent);
    }
    if (this.mListView != null) {
      QLog.e("QQMessagePageMicroAppEntryManager", 2, "interceptDrawer error. listView, scrollY: " + this.mListView.getScrollY());
    }
    return false;
  }
  
  public boolean isMiniAppLauncherOpened()
  {
    return false;
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    this.mApp.unRegistObserver(this);
    this.mApp.removeObserver(this.appletsObserver);
    this.mApp = paramQQAppInterface;
    if (getSpringEntryView() != null) {
      getSpringEntryView().setVisibility(8);
    }
    boolean bool = false;
    Object localObject = amtb.a();
    if (localObject != null) {
      bool = ((amta)localObject).a();
    }
    QLog.d("QQMessagePageMicroAppEntryManager", 1, "[MiniAppUserAppInfoListManager].onAccountChanged: " + bool);
    if ((!bool) && (this.mChatTopRefresh != null) && (this.mContentView != null))
    {
      shutdownMiniAppPullDownEntry();
      QLog.d("QQMessagePageMicroAppEntryManager", 1, "onAccountChanged: shutDown mini app entry");
      return;
    }
    paramQQAppInterface.registObserver(this);
    this.appletsObserver = new QQMessagePageMiniAppEntryManager.RedDotAppletsObserver(this);
    paramQQAppInterface.addObserver(this.appletsObserver);
    localObject = (MiniAppUserAppInfoListManager)paramQQAppInterface.getManager(309);
    ((MiniAppUserAppInfoListManager)localObject).queryMiniAppInfoFromDb();
    ((MiniAppUserAppInfoListManager)localObject).asyncQueryMiniAppPushRedDotData();
    ThreadManager.executeOnSubThread(new QQMessagePageMiniAppEntryManager.3(this, paramQQAppInterface));
  }
  
  public void onChangeRedDotSwitch(int paramInt, boolean paramBoolean)
  {
    if ((this.mContentView != null) && (amtb.l())) {
      this.mContentView.onChangeRedDotSwitch(paramInt, paramBoolean);
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "[MiniAppUserAppInfoListManager], onReceive, type = " + paramInt + " , mContentView = " + this.mContentView);
    }
    if (paramInt == 100) {
      hideMiniAppEntry();
    }
    label235:
    label243:
    do
    {
      View localView;
      do
      {
        for (;;)
        {
          return;
          if (paramInt == 103) {
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
              return;
            }
          }
        }
        if (paramInt != 104) {
          break;
        }
        for (;;)
        {
          try
          {
            localView = getSpringEntryView();
            if (paramBundle == null) {
              break label243;
            }
            paramBoolean = paramBundle.getBoolean("show");
            if ((localView instanceof SpringHbEntryBannerView))
            {
              if (paramBoolean)
              {
                paramInt = 0;
                localView.setVisibility(paramInt);
                if (!paramBoolean) {
                  break label235;
                }
                this.mBannerInfo = ((SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo)paramBundle.getSerializable("bannerInfo"));
                ((SpringHbEntryBannerView)localView).setBannerBg(this.mBannerInfo, hasOpenDesktop());
              }
            }
            else
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("QQMessagePageMicroAppEntryManager", 2, "onReceive...TYPE_HONGBAO_MINI_BANNER_ACTION,show:" + paramBoolean + ",mBannerInfo:" + this.mBannerInfo);
              return;
            }
          }
          catch (Throwable paramBundle)
          {
            QLog.e("QQMessagePageMicroAppEntryManager", 1, "TYPE_HONGBAO_MINI_BANNER_ACTION error.", paramBundle);
            return;
          }
          paramInt = 8;
          continue;
          this.mBannerInfo = null;
        }
      } while ((this.mBannerInfo == null) || (localView.getVisibility() != 0));
      ((SpringHbEntryBannerView)localView).setBannerBg(this.mBannerInfo, true);
      return;
    } while (this.mContentView == null);
    this.mContentView.updateMicroAppItemData();
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
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return;
        } while (this.mode != 1);
        this.flag = true;
        setMicroAppEntryCompleteVisible(false);
        this.mContentView.resetDotViewStatus();
        return;
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
      } while (f >= 0.0F);
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "fight...onTouchMoving.onMove..scrollY = " + f);
      return;
    }
    int i = paramARMapHongBaoListView.getListViewScrollY();
    if ((i > 0) && (f == 0.0F))
    {
      this.mCareNotificationBar.a(false);
      this.mCareNotificationBar.b();
      label234:
      this.flag = false;
      this.preMode = this.mode;
      if (f < 0.0F) {
        break label415;
      }
      if (paramARMapHongBaoListView.mForStory) {}
      this.mode = 1;
      paramARMapHongBaoListView.mForStory = false;
    }
    for (;;)
    {
      if ((this.preMode == 1) && (this.mode == 3))
      {
        this.mContentView.recordExposureItem();
        MiniProgramLpReportDC04239.reportPageView("expo_page", "pulldown_mini_msg");
        if (this.mApp != null) {
          ((ahfx)this.mApp.getManager(342)).d();
        }
      }
      setRefreshLayoutVisible(paramARMapHongBaoListView.mForStory);
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "fight...onTouchMoving.onUp..scrollY = " + f);
      if ((f >= 0.0F) || (this.mApp == null)) {
        break;
      }
      ((ahfx)this.mApp.getManager(342)).c();
      return;
      if (i != 0) {
        break label234;
      }
      this.mCareNotificationBar.a(true);
      this.mCareNotificationBar.b();
      break label234;
      label415:
      if (paramARMapHongBaoListView.mForStory)
      {
        if (f <= -paramARMapHongBaoListView.getOverScrollHeight())
        {
          paramMotionEvent = (TextView)this.mChatTopRefresh.findViewById(2131375055);
          if ((paramMotionEvent.getText().toString() != null) && (paramMotionEvent.getText().toString().contains(ajya.a(2131710466)))) {}
          for (this.mode = 3;; this.mode = 2)
          {
            paramARMapHongBaoListView.mForStory = true;
            break;
            QLog.d("QQMessagePageMicroAppEntryManager", 2, "story node start refresh onTouchMoving");
          }
        }
        if (f <= -this.mContentView.getHeight())
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
    }
  }
  
  public int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "onViewCompleteAfterRefresh, mode:" + this.mode);
    }
    this.mContentView.updateMicroAppItemData();
    if (this.mode == 2) {
      if (paramARMapHongBaoListView.mForStory)
      {
        this.mode = 3;
        i = -this.mContentView.getHeight();
      }
    }
    while (this.mode != 3)
    {
      return i;
      this.mode = 1;
      return 0;
    }
    return -this.mContentView.getHeight();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager
 * JD-Core Version:    0.7.0.1
 */