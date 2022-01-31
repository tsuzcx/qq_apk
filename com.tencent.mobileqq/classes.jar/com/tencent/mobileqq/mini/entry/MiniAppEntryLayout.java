package com.tencent.mobileqq.mini.entry;

import ahfz;
import ahjz;
import amtc;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.HongBaoResBuilder;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MiniAppEntryLayout
  extends FrameLayout
  implements View.OnClickListener
{
  private static final int SCROLL_MODE_HORIZONTAL = 1;
  private static final int SCROLL_MODE_UNDEFINED = 0;
  private static final int SCROLL_MODE_VERTICAL = 2;
  public static final String TAG = "MicroAppEntryLayout";
  private DownloadParams.DecodeHandler decodeHandler = new MiniAppEntryLayout.2(this);
  private MiniAppEntryAdapter mAdapter;
  private TextView mAppStoreEntryText;
  private BaseActivity mContext;
  private ViewGroup mDefaultStateView;
  private MiniAppDotAnimationView mDotView;
  private LinearLayoutManager mLinearLayoutManager;
  private ARMapHongBaoListView mListView;
  private ViewGroup mNormalStateView;
  private ViewGroup mParent;
  private int[] mParentLocation = new int[2];
  private float mPressX;
  private float mPressY;
  private RecyclerView mRecyclerView;
  private int mRefer;
  private int mScrollMode;
  private int[] mStoryBarLocation = new int[2];
  private ImageView mThemeBackgroudView;
  private int mTouchSlop;
  private boolean result;
  
  public MiniAppEntryLayout(@NonNull Context paramContext, ARMapHongBaoListView paramARMapHongBaoListView, int paramInt)
  {
    super(paramContext);
    this.mContext = ((BaseActivity)paramContext);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mRefer = paramInt;
    this.mListView = paramARMapHongBaoListView;
    inflate(paramContext, 2131561976, this);
    this.mParent = ((ViewGroup)findViewById(2131370306));
    this.mRecyclerView = ((RecyclerView)findViewById(2131369946));
    this.mRecyclerView.setItemAnimator(null);
    this.mAdapter = new MiniAppEntryAdapter((Activity)paramContext, paramInt);
    if (amtc.l())
    {
      boolean bool = ((ahjz)this.mContext.app.getManager(315)).a();
      paramARMapHongBaoListView = this.mAdapter;
      if (!bool) {
        break label295;
      }
    }
    label295:
    for (paramInt = 1;; paramInt = 0)
    {
      paramARMapHongBaoListView.setRedDotSwitchState(paramInt);
      this.mRecyclerView.setAdapter(this.mAdapter);
      this.mRecyclerView.addOnScrollListener(new MiniAppEntryLayout.1(this));
      this.mThemeBackgroudView = ((ImageView)findViewById(2131370183));
      this.mNormalStateView = ((ViewGroup)findViewById(2131370221));
      this.mDefaultStateView = ((ViewGroup)findViewById(2131370171));
      this.mAppStoreEntryText = ((TextView)findViewById(2131370252));
      this.mAppStoreEntryText.setOnClickListener(this);
      this.mDotView = ((MiniAppDotAnimationView)findViewById(2131370304));
      this.mLinearLayoutManager = new MiniAppEntryLayout.MiniAppLinearLayoutManager(paramContext, 0, false);
      this.mLinearLayoutManager.setAutoMeasureEnabled(false);
      this.mRecyclerView.setLayoutManager(this.mLinearLayoutManager);
      return;
    }
  }
  
  public static void exposureReport()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null) {}
    for (localObject = (MiniAppExposureManager)((AppInterface)localObject).getManager(322);; localObject = null)
    {
      if (localObject != null)
      {
        List localList = ((MiniAppExposureManager)localObject).getReportItemList();
        int i = 0;
        while (i < localList.size())
        {
          MiniAppExposureManager.BaseExposureReport localBaseExposureReport = (MiniAppExposureManager.BaseExposureReport)localList.get(i);
          if ((localBaseExposureReport instanceof MiniAppExposureManager.MiniAppExposureData)) {
            localArrayList.add((MiniAppExposureManager.MiniAppExposureData)localBaseExposureReport);
          }
          i += 1;
        }
        MiniProgramLpReportDC04239.reportPageView(localArrayList, "expo");
        MiniProgramLpReportDC04239.reportPageView(localArrayList, "expo_scene", true);
        ((MiniAppExposureManager)localObject).clear();
      }
      return;
    }
  }
  
  private void setMiniAppData(List<MiniAppInfo> paramList, Map<String, Integer> paramMap)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.setData(paramList, paramMap);
      this.mAdapter.notifyDataSetChanged();
    }
  }
  
  public void dotViewOnScroll(float paramFloat)
  {
    this.mDotView.doOnScroll(paramFloat);
  }
  
  public ViewGroup getContainerView()
  {
    return this.mParent;
  }
  
  public int getDotViewHeight()
  {
    return this.mDotView.getHeight();
  }
  
  public float getDotViewTranslationY()
  {
    return this.mDotView.getTranslationY();
  }
  
  public RecyclerView getRecyclerView()
  {
    return this.mRecyclerView;
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      if (this.result)
      {
        paramMotionEvent.offsetLocation(0.0F, this.mParentLocation[1] - this.mStoryBarLocation[1]);
        dispatchTouchEvent(paramMotionEvent);
      }
      return this.result;
      getLocationInWindow(this.mStoryBarLocation);
      paramView.getLocationInWindow(this.mParentLocation);
      if ((f1 >= this.mStoryBarLocation[1]) && (f1 < this.mStoryBarLocation[1] + getHeight())) {}
      for (boolean bool = true;; bool = false)
      {
        this.result = bool;
        this.mPressX = f2;
        this.mPressY = f1;
        this.mScrollMode = 0;
        break;
      }
      f2 = Math.abs(this.mPressX - f2);
      f1 = Math.abs(this.mPressY - f1);
      if ((this.mScrollMode == 0) && (f2 > this.mTouchSlop)) {
        this.mScrollMode = 1;
      }
      if ((this.mScrollMode == 0) && (f1 > this.mTouchSlop)) {
        this.mScrollMode = 2;
      }
      if ((this.mScrollMode == 2) && (this.result))
      {
        this.result = false;
        paramMotionEvent.setAction(3);
        dispatchTouchEvent(paramMotionEvent);
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    updateHongBaoRes();
    if (this.mRecyclerView.getLayoutManager().getChildCount() != this.mRecyclerView.getChildCount())
    {
      QLog.e("MicroAppEntryLayout", 2, "onAttachedToWindow recyclerView count not match, need reset!");
      this.mLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
      this.mLinearLayoutManager.setAutoMeasureEnabled(true);
      this.mRecyclerView.setLayoutManager(this.mLinearLayoutManager);
      this.mRecyclerView.getAdapter().notifyDataSetChanged();
    }
    MiniAppUtils.updateMiniAppList(3);
  }
  
  public void onChangeRedDotSwitch(int paramInt, boolean paramBoolean)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.setRedDotSwitchState(paramInt);
      if (paramBoolean) {
        this.mAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    MiniAppUtils.handleMiniAppMoreClick(this.mContext);
  }
  
  public void onPostThemeChanged()
  {
    try
    {
      this.mRecyclerView.setBackgroundDrawable(null);
      updateHongBaoRes();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MicroAppEntryLayout", 1, "onPostThemeChanged:", localException);
      }
    }
  }
  
  public void recordExposureItem()
  {
    if (this.mRecyclerView != null)
    {
      localObject1 = MiniAppUtils.getAppInterface();
      if (localObject1 == null) {
        break label455;
      }
    }
    label137:
    label450:
    label455:
    for (Object localObject1 = (MiniAppExposureManager)((AppInterface)localObject1).getManager(322);; localObject1 = null)
    {
      Map localMap = this.mAdapter.getRedDotDataMap();
      Object localObject2 = (LinearLayoutManager)this.mRecyclerView.getLayoutManager();
      int j = ((LinearLayoutManager)localObject2).findFirstVisibleItemPosition();
      int m = ((LinearLayoutManager)localObject2).findLastVisibleItemPosition();
      Object localObject3;
      int k;
      if (j <= m)
      {
        localObject3 = this.mAdapter.getItemForPosition(j);
        if ((localObject3 != null) && (localObject1 != null))
        {
          k = 1001;
          if ((this.mRefer != 0) || (((MiniAppInfo)localObject3).reportData == null)) {
            break label249;
          }
          if (((MiniAppInfo)localObject3).recommend != 1) {
            break label216;
          }
          ((MiniAppInfo)localObject3).reportData.put("via", "1001_1");
          i = k;
          localObject2 = new MiniAppConfig((MiniAppInfo)localObject3);
          ((MiniAppConfig)localObject2).launchParam.scene = i;
          if (localMap == null) {
            break label450;
          }
          localObject3 = (Integer)localMap.get(((MiniAppInfo)localObject3).appId);
          if (localObject3 == null) {
            break label450;
          }
        }
      }
      for (int i = ((Integer)localObject3).intValue();; i = 0)
      {
        ((MiniAppExposureManager)localObject1).addReportItem(new MiniAppExposureManager.MiniAppExposureData((MiniAppConfig)localObject2, j, String.valueOf(i)));
        j += 1;
        break;
        label216:
        i = k;
        if (((MiniAppInfo)localObject3).topType != 1) {
          break label137;
        }
        ((MiniAppInfo)localObject3).reportData.put("via", "1001_3");
        i = k;
        break label137;
        label249:
        if ((this.mRefer == 1) && (((MiniAppInfo)localObject3).reportData != null))
        {
          if (((MiniAppInfo)localObject3).recommend == 1) {
            ((MiniAppInfo)localObject3).reportData.put("via", "2006_1");
          }
          for (;;)
          {
            i = 2006;
            break;
            if (((MiniAppInfo)localObject3).topType == 1) {
              ((MiniAppInfo)localObject3).reportData.put("via", "2006_2");
            } else {
              ((MiniAppInfo)localObject3).reportData.put("via", "2006_3");
            }
          }
        }
        i = k;
        if (this.mRefer != 2) {
          break label137;
        }
        i = k;
        if (((MiniAppInfo)localObject3).reportData == null) {
          break label137;
        }
        if (((MiniAppInfo)localObject3).recommend == 1) {
          ((MiniAppInfo)localObject3).reportData.put("via", "2007_1");
        }
        for (;;)
        {
          i = 2007;
          break;
          if (((MiniAppInfo)localObject3).topType == 1) {
            ((MiniAppInfo)localObject3).reportData.put("via", "2007_2");
          } else {
            ((MiniAppInfo)localObject3).reportData.put("via", "2007_3");
          }
        }
        return;
      }
    }
  }
  
  public void resetDotViewStatus()
  {
    this.mDotView.resetDots();
  }
  
  public void setDotViewTranslationY(float paramFloat)
  {
    this.mDotView.setTranslationY(paramFloat);
  }
  
  public void setThemeBackgroundDrawable()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (this.mContext != null)
        {
          localObject1 = localObject2;
          if (this.mContext.app != null) {
            localObject1 = (ahfz)this.mContext.app.getManager(342);
          }
        }
        if ((localObject1 != null) && (((ahfz)localObject1).h()))
        {
          updateHongBaoRes();
          this.mAdapter.notifyDataSetChanged();
          return;
        }
        if (this.mThemeBackgroudView != null)
        {
          if ((ThemeUtil.isDefaultTheme()) || (MiniAppUtils.isNightMode())) {
            this.mThemeBackgroudView.setVisibility(8);
          }
        }
        else
        {
          try
          {
            if (!ThemeUtil.isDefaultTheme()) {
              break label170;
            }
            this.mDefaultStateView.setBackgroundResource(2130840661);
          }
          catch (Exception localException)
          {
            QLog.e("MicroAppEntryLayout", 1, new Object[] { "setThemeBackgroundDrawable:", Log.getStackTraceString(localException) });
          }
          continue;
        }
        this.mThemeBackgroudView.setVisibility(0);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MicroAppEntryLayout", 1, "setThemeBackgroundDrawable error.", localThrowable);
        return;
      }
      this.mThemeBackgroudView.setImageResource(2130838515);
      continue;
      label170:
      this.mDefaultStateView.setBackgroundColor(0);
    }
  }
  
  public void startSwitchIconAnimation()
  {
    if (this.mAdapter != null) {
      this.mAdapter.startAnimation();
    }
  }
  
  public void stopSwitchIconAnimation()
  {
    if (this.mAdapter != null) {
      this.mAdapter.stopAnimation();
    }
  }
  
  public void updateHongBaoRes()
  {
    for (;;)
    {
      DesktopDataManager.HongBaoResBuilder localHongBaoResBuilder;
      try
      {
        QLog.d("MicroAppEntryLayout", 1, "---updateHongBaoRes---");
        if ((this.mContext == null) || (this.mContext.app == null)) {
          break label302;
        }
        Object localObject1 = (ahfz)this.mContext.app.getManager(342);
        if ((localObject1 == null) || (!((ahfz)localObject1).h())) {
          break label276;
        }
        localHongBaoResBuilder = ((ahfz)localObject1).a();
        DesktopDataManager localDesktopDataManager = (DesktopDataManager)this.mContext.app.getManager(336);
        if (localDesktopDataManager.getHongBaoResBuilder() != null) {
          localHongBaoResBuilder = localDesktopDataManager.getHongBaoResBuilder();
        }
        if ((localHongBaoResBuilder != null) && ((getParent() instanceof PullRefreshHeader)))
        {
          if (((ahfz)localObject1).a() != null)
          {
            localObject1 = new BitmapDrawable(((ahfz)localObject1).a());
            ((PullRefreshHeader)getParent()).setBackgroundDrawable((Drawable)localObject1);
          }
        }
        else
        {
          if (this.mAdapter == null) {
            break;
          }
          this.mAdapter.notifyDataSetChanged();
          return;
        }
        if ((localHongBaoResBuilder.getBackgroundUrl() != null) && (localHongBaoResBuilder.getBackgroundLoadingResId() != -1) && (localHongBaoResBuilder.getBackgroundFailedResId() != -1))
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(localHongBaoResBuilder.getBackgroundLoadingResId());
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(localHongBaoResBuilder.getBackgroundFailedResId());
          localObject1 = URLDrawable.getDrawable(localHongBaoResBuilder.getBackgroundUrl(), (URLDrawable.URLDrawableOptions)localObject1);
          ((URLDrawable)localObject1).setDecodeHandler(this.decodeHandler);
          ((PullRefreshHeader)getParent()).setBackgroundDrawable((Drawable)localObject1);
          continue;
        }
        if (localHongBaoResBuilder.getBackgroundResId() == -1) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MicroAppEntryLayout", 1, "updateHongBaoRes error.", localThrowable);
        return;
      }
      ((PullRefreshHeader)getParent()).setBackgroundResource(localHongBaoResBuilder.getBackgroundResId());
      continue;
      label276:
      if ((getParent() instanceof PullRefreshHeader)) {
        ((PullRefreshHeader)getParent()).setBackgroundColor(0);
      }
      setThemeBackgroundDrawable();
      return;
      label302:
      Object localObject2 = null;
    }
  }
  
  public void updateMicroAppItemData()
  {
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)this.mContext.app.getManager(309);
    List localList = localMiniAppUserAppInfoListManager.getMiniAppInfoData();
    if ((localList == null) || (localList.size() == 0))
    {
      this.mDefaultStateView.setVisibility(0);
      this.mNormalStateView.setVisibility(8);
      if (localMiniAppUserAppInfoListManager.getPullDownEntryExtInfo() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MicroAppEntryLayout", 1, "[MiniAppUserAppInfoListManager]. updateMicroAppItemData");
        }
        MiniAppUtils.checkSendUserAppListRequest();
      }
      return;
    }
    this.mDefaultStateView.setVisibility(8);
    this.mNormalStateView.setVisibility(0);
    setMiniAppData(localList, localMiniAppUserAppInfoListManager.getRedDotData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryLayout
 * JD-Core Version:    0.7.0.1
 */