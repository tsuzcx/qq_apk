package com.tencent.mobileqq.mini.entry;

import akxz;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import aqpv;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    inflate(paramContext, 2131562420, this);
    this.mParent = ((ViewGroup)findViewById(2131371177));
    this.mRecyclerView = ((RecyclerView)findViewById(2131370673));
    this.mRecyclerView.setItemAnimator(null);
    this.mAdapter = new MiniAppEntryAdapter((Activity)paramContext, paramInt);
    if (aqpv.h())
    {
      boolean bool = ((akxz)this.mContext.app.getManager(315)).a();
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
      this.mThemeBackgroudView = ((ImageView)findViewById(2131370935));
      this.mNormalStateView = ((ViewGroup)findViewById(2131370976));
      this.mDefaultStateView = ((ViewGroup)findViewById(2131370923));
      this.mAppStoreEntryText = ((TextView)findViewById(2131371070));
      this.mAppStoreEntryText.setOnClickListener(this);
      this.mDotView = ((MiniAppDotAnimationView)findViewById(2131371175));
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
    EventCollector.getInstance().onViewClicked(paramView);
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
        break label383;
      }
    }
    label128:
    label207:
    label231:
    label378:
    label383:
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
            break label231;
          }
          if (((MiniAppInfo)localObject3).recommend != 1) {
            break label207;
          }
          ((MiniAppInfo)localObject3).via = "1001_1";
          i = k;
          localObject2 = new MiniAppConfig((MiniAppInfo)localObject3);
          ((MiniAppConfig)localObject2).launchParam.scene = i;
          if (localMap == null) {
            break label378;
          }
          localObject3 = (Integer)localMap.get(((MiniAppInfo)localObject3).appId);
          if (localObject3 == null) {
            break label378;
          }
        }
      }
      for (int i = ((Integer)localObject3).intValue();; i = 0)
      {
        ((MiniAppExposureManager)localObject1).addReportItem(new MiniAppExposureManager.MiniAppExposureData((MiniAppConfig)localObject2, j, String.valueOf(i)));
        j += 1;
        break;
        i = k;
        if (((MiniAppInfo)localObject3).topType != 1) {
          break label128;
        }
        ((MiniAppInfo)localObject3).via = "1001_3";
        i = k;
        break label128;
        if ((this.mRefer == 1) && (((MiniAppInfo)localObject3).reportData != null))
        {
          if (((MiniAppInfo)localObject3).recommend == 1) {
            ((MiniAppInfo)localObject3).via = "2006_1";
          }
          for (;;)
          {
            i = 2006;
            break;
            if (((MiniAppInfo)localObject3).topType == 1) {
              ((MiniAppInfo)localObject3).via = "2006_2";
            } else {
              ((MiniAppInfo)localObject3).via = "2006_3";
            }
          }
        }
        i = k;
        if (this.mRefer != 2) {
          break label128;
        }
        i = k;
        if (((MiniAppInfo)localObject3).reportData == null) {
          break label128;
        }
        if (((MiniAppInfo)localObject3).recommend == 1) {
          ((MiniAppInfo)localObject3).via = "2007_1";
        }
        for (;;)
        {
          i = 2007;
          break;
          if (((MiniAppInfo)localObject3).topType == 1) {
            ((MiniAppInfo)localObject3).via = "2007_2";
          } else {
            ((MiniAppInfo)localObject3).via = "2007_3";
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
  
  /* Error */
  public void setThemeBackgroundDrawable()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 160	com/tencent/mobileqq/mini/entry/MiniAppEntryLayout:mThemeBackgroudView	Landroid/widget/ImageView;
    //   4: ifnull +24 -> 28
    //   7: invokestatic 497	com/tencent/mobileqq/theme/ThemeUtil:isDefaultTheme	()Z
    //   10: ifne +9 -> 19
    //   13: invokestatic 500	com/tencent/mobileqq/mini/entry/MiniAppUtils:isNightMode	()Z
    //   16: ifeq +36 -> 52
    //   19: aload_0
    //   20: getfield 160	com/tencent/mobileqq/mini/entry/MiniAppEntryLayout:mThemeBackgroudView	Landroid/widget/ImageView;
    //   23: bipush 8
    //   25: invokevirtual 503	android/widget/ImageView:setVisibility	(I)V
    //   28: invokestatic 497	com/tencent/mobileqq/theme/ThemeUtil:isDefaultTheme	()Z
    //   31: ifeq +54 -> 85
    //   34: aload_0
    //   35: getfield 166	com/tencent/mobileqq/mini/entry/MiniAppEntryLayout:mDefaultStateView	Landroid/view/ViewGroup;
    //   38: ldc_w 504
    //   41: invokevirtual 507	android/view/ViewGroup:setBackgroundResource	(I)V
    //   44: aload_0
    //   45: getfield 119	com/tencent/mobileqq/mini/entry/MiniAppEntryLayout:mAdapter	Lcom/tencent/mobileqq/mini/entry/MiniAppEntryAdapter;
    //   48: invokevirtual 262	com/tencent/mobileqq/mini/entry/MiniAppEntryAdapter:notifyDataSetChanged	()V
    //   51: return
    //   52: aload_0
    //   53: getfield 160	com/tencent/mobileqq/mini/entry/MiniAppEntryLayout:mThemeBackgroudView	Landroid/widget/ImageView;
    //   56: iconst_0
    //   57: invokevirtual 503	android/widget/ImageView:setVisibility	(I)V
    //   60: aload_0
    //   61: getfield 160	com/tencent/mobileqq/mini/entry/MiniAppEntryLayout:mThemeBackgroudView	Landroid/widget/ImageView;
    //   64: ldc_w 508
    //   67: invokevirtual 511	android/widget/ImageView:setImageResource	(I)V
    //   70: goto -42 -> 28
    //   73: astore_1
    //   74: ldc 17
    //   76: iconst_1
    //   77: ldc_w 513
    //   80: aload_1
    //   81: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   84: return
    //   85: aload_0
    //   86: getfield 166	com/tencent/mobileqq/mini/entry/MiniAppEntryLayout:mDefaultStateView	Landroid/view/ViewGroup;
    //   89: iconst_0
    //   90: invokevirtual 516	android/view/ViewGroup:setBackgroundColor	(I)V
    //   93: goto -49 -> 44
    //   96: astore_1
    //   97: ldc 17
    //   99: iconst_1
    //   100: iconst_2
    //   101: anewarray 518	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: ldc_w 520
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_1
    //   113: invokestatic 526	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   116: aastore
    //   117: invokestatic 529	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   120: goto -76 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	MiniAppEntryLayout
    //   73	8	1	localThrowable	Throwable
    //   96	17	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	19	73	java/lang/Throwable
    //   19	28	73	java/lang/Throwable
    //   28	44	73	java/lang/Throwable
    //   44	51	73	java/lang/Throwable
    //   52	70	73	java/lang/Throwable
    //   85	93	73	java/lang/Throwable
    //   97	120	73	java/lang/Throwable
    //   28	44	96	java/lang/Exception
    //   85	93	96	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryLayout
 * JD-Core Version:    0.7.0.1
 */