package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  private DownloadParams.DecodeHandler decodeHandler;
  private MiniAppEntryAdapter mAdapter;
  private TextView mAppStoreEntryText;
  private BaseActivity mContext;
  private ViewGroup mDefaultStateView;
  private MiniAppDotAnimationView mDotView;
  private LinearLayoutManager mLinearLayoutManager;
  private ARMapHongBaoListView mListView;
  private ViewGroup mNormalStateView;
  private ViewGroup mParent;
  private int[] mParentLocation;
  private float mPressX;
  private float mPressY;
  private RecyclerView mRecyclerView;
  private int mRefer;
  private int mScrollMode;
  private int[] mStoryBarLocation;
  private ImageView mThemeBackgroudView;
  private int mTouchSlop;
  private boolean result;
  
  public MiniAppEntryLayout(@NonNull Context paramContext, ARMapHongBaoListView paramARMapHongBaoListView, int paramInt) {}
  
  public static void exposureReport()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = MiniAppUtils.getAppInterface();
    if (localObject != null) {
      localObject = (MiniAppExposureManager)((AppInterface)localObject).getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
    } else {
      localObject = null;
    }
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
  }
  
  private void setMiniAppData(List<MiniAppInfo> paramList, Map<String, Integer> paramMap)
  {
    MiniAppEntryAdapter localMiniAppEntryAdapter = this.mAdapter;
    if (localMiniAppEntryAdapter != null)
    {
      localMiniAppEntryAdapter.setData(paramList, paramMap);
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
    int i = paramMotionEvent.getAction() & 0xFF;
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    if (i != 0)
    {
      if (i == 2)
      {
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
    else
    {
      getLocationInWindow(this.mStoryBarLocation);
      paramView.getLocationInWindow(this.mParentLocation);
      paramView = this.mStoryBarLocation;
      boolean bool;
      if ((f1 >= paramView[1]) && (f1 < paramView[1] + getHeight())) {
        bool = true;
      } else {
        bool = false;
      }
      this.result = bool;
      this.mPressX = f2;
      this.mPressY = f1;
      this.mScrollMode = 0;
    }
    if (this.result)
    {
      paramMotionEvent.offsetLocation(0.0F, this.mParentLocation[1] - this.mStoryBarLocation[1]);
      dispatchTouchEvent(paramMotionEvent);
    }
    return this.result;
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
    MiniAppEntryAdapter localMiniAppEntryAdapter = this.mAdapter;
    if (localMiniAppEntryAdapter != null)
    {
      localMiniAppEntryAdapter.setRedDotSwitchState(paramInt);
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
    }
    catch (Exception localException)
    {
      QLog.e("MicroAppEntryLayout", 1, "onPostThemeChanged:", localException);
    }
    updateHongBaoRes();
  }
  
  public void recordExposureItem()
  {
    if (this.mRecyclerView != null)
    {
      Object localObject1 = MiniAppUtils.getAppInterface();
      MiniAppExposureManager localMiniAppExposureManager = null;
      if (localObject1 != null) {
        localMiniAppExposureManager = (MiniAppExposureManager)((AppInterface)localObject1).getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
      }
      localObject1 = this.mAdapter.getRedDotDataMap();
      Object localObject2 = (LinearLayoutManager)this.mRecyclerView.getLayoutManager();
      int j = ((LinearLayoutManager)localObject2).findFirstVisibleItemPosition();
      int m = ((LinearLayoutManager)localObject2).findLastVisibleItemPosition();
      while (j <= m)
      {
        Object localObject3 = this.mAdapter.getItemForPosition(j);
        if ((localObject3 != null) && (localMiniAppExposureManager != null))
        {
          int k = 1001;
          if ((this.mRefer == 0) && (((MiniAppInfo)localObject3).reportData != null))
          {
            if (((MiniAppInfo)localObject3).recommend == 1)
            {
              ((MiniAppInfo)localObject3).via = "1001_1";
              i = k;
            }
            else
            {
              i = k;
              if (((MiniAppInfo)localObject3).topType == 1)
              {
                ((MiniAppInfo)localObject3).via = "1001_3";
                i = k;
              }
            }
          }
          else if ((this.mRefer == 1) && (((MiniAppInfo)localObject3).reportData != null))
          {
            if (((MiniAppInfo)localObject3).recommend == 1) {
              ((MiniAppInfo)localObject3).via = "2006_1";
            } else if (((MiniAppInfo)localObject3).topType == 1) {
              ((MiniAppInfo)localObject3).via = "2006_2";
            } else {
              ((MiniAppInfo)localObject3).via = "2006_3";
            }
            i = 2006;
          }
          else
          {
            i = k;
            if (this.mRefer == 2)
            {
              i = k;
              if (((MiniAppInfo)localObject3).reportData != null)
              {
                if (((MiniAppInfo)localObject3).recommend == 1) {
                  ((MiniAppInfo)localObject3).via = "2007_1";
                } else if (((MiniAppInfo)localObject3).topType == 1) {
                  ((MiniAppInfo)localObject3).via = "2007_2";
                } else {
                  ((MiniAppInfo)localObject3).via = "2007_3";
                }
                i = 2007;
              }
            }
          }
          localObject2 = new MiniAppConfig((MiniAppInfo)localObject3);
          ((MiniAppConfig)localObject2).launchParam.scene = i;
          k = 0;
          int i = k;
          if (localObject1 != null)
          {
            localObject3 = (Integer)((Map)localObject1).get(((MiniAppInfo)localObject3).appId);
            i = k;
            if (localObject3 != null) {
              i = ((Integer)localObject3).intValue();
            }
          }
          localMiniAppExposureManager.addReportItem(new MiniAppExposureManager.MiniAppExposureData((MiniAppConfig)localObject2, j, String.valueOf(i)));
        }
        j += 1;
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
    try
    {
      if (this.mThemeBackgroudView != null) {
        if ((!ThemeUtil.isDefaultTheme()) && (!MiniAppUtils.isNightMode()))
        {
          this.mThemeBackgroudView.setVisibility(0);
          this.mThemeBackgroudView.setImageResource(2130838959);
        }
        else
        {
          this.mThemeBackgroudView.setVisibility(8);
        }
      }
      this.mAdapter.notifyDataSetChanged();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MicroAppEntryLayout", 1, "setThemeBackgroundDrawable error.", localThrowable);
    }
  }
  
  public void startSwitchIconAnimation()
  {
    MiniAppEntryAdapter localMiniAppEntryAdapter = this.mAdapter;
    if (localMiniAppEntryAdapter != null) {
      localMiniAppEntryAdapter.startAnimation();
    }
  }
  
  public void stopSwitchIconAnimation()
  {
    MiniAppEntryAdapter localMiniAppEntryAdapter = this.mAdapter;
    if (localMiniAppEntryAdapter != null) {
      localMiniAppEntryAdapter.stopAnimation();
    }
  }
  
  public void updateHongBaoRes()
  {
    try
    {
      QLog.d("MicroAppEntryLayout", 1, "---updateHongBaoRes---");
      if ((getParent() instanceof PullRefreshHeader)) {
        ((PullRefreshHeader)getParent()).setBackgroundColor(0);
      }
      setThemeBackgroundDrawable();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MicroAppEntryLayout", 1, "updateHongBaoRes error.", localThrowable);
    }
  }
  
  public void updateMicroAppItemData()
  {
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)this.mContext.app.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    List localList = localMiniAppUserAppInfoListManager.getMiniAppInfoData();
    if ((localList != null) && (localList.size() != 0))
    {
      this.mDefaultStateView.setVisibility(8);
      this.mNormalStateView.setVisibility(0);
      setMiniAppData(localList, localMiniAppUserAppInfoListManager.getRedDotData());
      return;
    }
    this.mDefaultStateView.setVisibility(0);
    this.mNormalStateView.setVisibility(8);
    if (localMiniAppUserAppInfoListManager.getPullDownEntryExtInfo() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MicroAppEntryLayout", 1, "[MiniAppUserAppInfoListManager]. updateMicroAppItemData");
      }
      MiniAppUtils.checkSendUserAppListRequest();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryLayout
 * JD-Core Version:    0.7.0.1
 */