package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.tencent.common.app.AppInterface;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.mobileqq.activity.springfestival.HBEntryBannerData;
import com.tencent.mobileqq.activity.springfestival.HBEntryBannerView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppRedDotExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppGroupInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.DataChangeListener;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopEmptyGuideInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopEmptyInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopFriendsPkModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopMostCommonlyUsedInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopPopularModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopRecommendModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoAreaView;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.OnItemChangeListener;
import com.tencent.mobileqq.mini.entry.layout.ModeInfoLayoutKt;
import com.tencent.mobileqq.mini.entry.layout.PopularityListLayoutKt;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MiniAppDesktopAdapter
  extends DragAdapter
  implements DesktopChangeListener, DesktopDataManager.DataChangeListener, DragRecyclerView.OnItemChangeListener
{
  private static final String DEVELOP = HardCodeUtil.a(2131706797);
  private static final long DRAG_INSERT_DURA = 200L;
  private static final String EXPERIENCE = HardCodeUtil.a(2131706806);
  public static final int REFER_CONTACTS = 1;
  public static final int REFER_CONVERSATION = 0;
  public static final int REFER_LEBA = 2;
  private static final String TAG = "MiniAppDesktopAdapter";
  private static final int TYPE_MIMI_APP_SPECIAL = 3;
  private static final int TYPE_MINI_APP_NORMAL = 1;
  private static final int TYPE_MINI_APP_TOP = 2;
  private static int sMiniAppOpenedCount = 0;
  int currDragMoveLeft;
  int currDragMoveTop;
  boolean isDesktopOpened;
  int lastDragLeft;
  int lastDragMoveLeft;
  int lastDragMoveTop;
  int lastDragTop;
  private WeakReference<Activity> mActivity;
  private MiniAppDesktopAdapter.OnAnimationListener mAnimListener;
  private boolean mCanShowRedDot;
  private Context mContext;
  private boolean mDeletePrepared = false;
  private MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder mDesktopMostCommonlyUsedViewHolder = null;
  private RecyclerView.ViewHolder mDragViewHolder;
  private int mInsertFrom = -1;
  private MiniAppDesktopAdapter.InsertItemRunnable mInsertItemRunnable = new MiniAppDesktopAdapter.InsertItemRunnable(this, null);
  private int mInsertTarget = -1;
  private List<DesktopLifeCycleListener> mLifeCycleListenerList = new ArrayList();
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  private MiniAppDesktopAdapter.MoveItemRunnable mMoveItemRunnable = new MiniAppDesktopAdapter.MoveItemRunnable(this, null);
  private List<MiniAppInfo> mOrigData = new ArrayList();
  private Map<String, Integer> mRedDotData = new HashMap();
  private int mRedDotSwitchState;
  private int mRefer = 0;
  private GridLayoutManager.SpanSizeLookup mSpanSizeLookup;
  private Vibrator mVibrator;
  private int startDragX;
  private int startDragY;
  
  public MiniAppDesktopAdapter(Activity paramActivity, int paramInt, DragRecyclerView paramDragRecyclerView)
  {
    super(paramActivity.getApplicationContext(), paramDragRecyclerView);
    this.mContext = paramActivity.getApplicationContext();
    this.mActivity = new WeakReference(paramActivity);
    this.mRefer = paramInt;
    this.mSpanSizeLookup = new MiniAppDesktopAdapter.1(this);
    registerAdapterDataObserver(new MiniAppDesktopAdapter.2(this));
    this.mirrorZoomAnimation.setFillAfter(true);
    this.mirrorZoomAnimation.setDuration(200L);
    this.mirrorRevertAnimation.setDuration(200L);
    DittoUIEngine.g().init(this.mContext, new DesktopLog());
  }
  
  public static void clearMiniAppOpenedCount()
  {
    sMiniAppOpenedCount = 0;
  }
  
  private void collectAdReport(ImageView paramImageView, TextView paramTextView, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    paramImageView.addOnAttachStateChangeListener(new MiniAppDesktopAdapter.5(this, paramMiniAppInfo, paramInt));
    paramTextView.addOnAttachStateChangeListener(new MiniAppDesktopAdapter.6(this, paramMiniAppInfo, paramInt));
  }
  
  private void deleteMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppDesktopAdapter", 2, "deleteMiniApp, delete miniAppInfo: " + paramMiniAppInfo.toString());
    }
    Object localObject = (Activity)this.mActivity.get();
    if (localObject == null) {
      return;
    }
    ((Activity)localObject).getResources();
    localObject = (BaseActivity)localObject;
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)((BaseActivity)localObject).app.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendDelUserAppRequest(paramMiniAppInfo);
    }
    MiniCacheFreeManager.freeCache(((BaseActivity)localObject).app.getCurrentUin(), paramMiniAppInfo);
  }
  
  private void doVibrate()
  {
    try
    {
      if (this.mVibrator == null) {
        this.mVibrator = ((Vibrator)this.mContext.getSystemService("vibrator"));
      }
      this.mVibrator.vibrate(50L);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppDesktopAdapter", 1, "exception when doVibrate.", localThrowable);
    }
  }
  
  private void gdtAdReport()
  {
    try
    {
      ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).miniAppAdReport();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppDesktopAdapter", 1, "gdtAdReport, exception: " + Log.getStackTraceString(localException));
    }
  }
  
  public static int getMiniAppOpenedCount()
  {
    return sMiniAppOpenedCount;
  }
  
  private int getRedDotCount(String paramString)
  {
    paramString = (Integer)this.mRedDotData.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private boolean isSameModule(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= getItemCount()) || (paramInt2 < 0) || (paramInt2 >= getItemCount())) {
      return false;
    }
    DesktopItemInfo localDesktopItemInfo1 = (DesktopItemInfo)this.mData.get(paramInt1);
    DesktopItemInfo localDesktopItemInfo2 = (DesktopItemInfo)this.mData.get(paramInt2);
    return localDesktopItemInfo1.mModuleType == localDesktopItemInfo2.mModuleType;
  }
  
  private boolean needShowRodDotCount(String paramString)
  {
    return (this.mCanShowRedDot) && (this.mRedDotSwitchState == 1) && (getRedDotCount(paramString) > 0);
  }
  
  private void setAnimationListener(MiniAppDesktopAdapter.OnAnimationListener paramOnAnimationListener)
  {
    this.mAnimListener = paramOnAnimationListener;
  }
  
  private void setTopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppDesktopAdapter", 2, "setTopMiniApp, miniAppInfo: " + paramMiniAppInfo.toString());
    }
    Object localObject = (Activity)this.mActivity.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (MiniAppUserAppInfoListManager)((BaseActivity)localObject).app.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    } while (localObject == null);
    if (paramMiniAppInfo.topType == 0)
    {
      paramMiniAppInfo.topType = 1;
      paramMiniAppInfo.updateTimeStamp();
    }
    for (;;)
    {
      ((MiniAppUserAppInfoListManager)localObject).sendSetUserAppTopRequest(paramMiniAppInfo);
      return;
      paramMiniAppInfo.topType = 0;
    }
  }
  
  public static void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    try
    {
      sMiniAppOpenedCount += 1;
      MiniAppController.launchMiniAppByAppInfo(paramActivity, paramMiniAppInfo, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("MiniAppDesktopAdapter", 1, "startMiniApp exception: " + Log.getStackTraceString(paramActivity));
    }
  }
  
  protected void doUpdateHolder(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt)
  {
    paramMicroAppViewHolder.desktopAppInfo = paramDesktopAppInfo;
    paramMicroAppViewHolder.itemView.setVisibility(0);
    if (paramDesktopAppInfo.isTemp)
    {
      paramMicroAppViewHolder.imageView.setImageResource(2130841147);
      paramMicroAppViewHolder.textView.setVisibility(4);
      paramMicroAppViewHolder.versionTypeMark.setVisibility(4);
      paramMicroAppViewHolder.recommendBadge.setVisibility(4);
      paramMicroAppViewHolder.redDot.setVisibility(4);
      return;
    }
    MiniAppInfo localMiniAppInfo = paramDesktopAppInfo.mMiniAppInfo;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label228:
    int i;
    label263:
    label306:
    label339:
    boolean bool;
    if (((localMiniAppInfo.motionPics == null) || (localMiniAppInfo.motionPics.size() <= 0)) && (!TextUtils.isEmpty(localMiniAppInfo.apngUrl)))
    {
      paramMicroAppViewHolder.anpgImagView.setVisibility(0);
      localObject1 = paramMicroAppViewHolder.anpgImagView;
      localObject2 = localMiniAppInfo.apngUrl;
      localObject3 = new ColorDrawable(Color.parseColor("#00000000"));
      ((ImageView)localObject1).setImageDrawable(VasApngUtil.getApngURLDrawable((String)localObject2, new int[] { 32 }, (Drawable)localObject3));
      paramMicroAppViewHolder.imageView.setImageDrawable(MiniAppUtils.getIcon(this.mContext, localMiniAppInfo.iconUrl, true));
      paramMicroAppViewHolder.textView.setVisibility(0);
      paramMicroAppViewHolder.textView.setText(localMiniAppInfo.name);
      paramMicroAppViewHolder.setMiniAppInfo(localMiniAppInfo);
      paramMicroAppViewHolder.setModuleType(paramDesktopAppInfo.getModuleType());
      if (!localMiniAppInfo.isSpecialMiniApp()) {
        break label909;
      }
      paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(3));
      if ((localMiniAppInfo.verType != 0) && (localMiniAppInfo.verType != 4)) {
        break label946;
      }
      paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
      paramMicroAppViewHolder.versionTypeMark.setText(DEVELOP);
      if (paramDesktopAppInfo.getModuleType() != 2) {
        break label999;
      }
      paramMicroAppViewHolder.recommendBadge.setVisibility(0);
      if (TextUtils.isEmpty(localMiniAppInfo.recommendAppIconUrl)) {
        break label988;
      }
      paramMicroAppViewHolder.recommendBadge.setImageDrawable(MiniAppUtils.getDrawable(localMiniAppInfo.recommendAppIconUrl, null));
      if ((!TextUtils.isEmpty(localMiniAppInfo.amsAdInfo)) && (!paramDesktopAppInfo.isFromCache())) {
        collectAdReport(paramMicroAppViewHolder.imageView, paramMicroAppViewHolder.textView, localMiniAppInfo, paramInt);
      }
      i = getRedDotCount(localMiniAppInfo.appId);
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppDesktopAdapter", 2, "onBindViewHolder, canShowRedDot: " + this.mCanShowRedDot + ", redDotNum : " + i + ", name : " + localMiniAppInfo.name + ", mRedDotSwitchState: " + this.mRedDotSwitchState);
      }
      bool = needShowRodDotCount(localMiniAppInfo.appId);
      if ((!bool) || ((paramDesktopAppInfo.getModuleType() != 1) && (paramDesktopAppInfo.getModuleType() != 3))) {
        break label1011;
      }
      paramMicroAppViewHolder.redDot.setVisibility(0);
      CustomWidgetUtil.a(paramMicroAppViewHolder.redDot, 7, i, 0);
      label475:
      if (paramDesktopAppInfo.getModuleType() != 1) {
        break label1030;
      }
      if (!bool) {
        break label1023;
      }
      paramInt = 3020;
    }
    for (;;)
    {
      label492:
      localObject1 = MiniAppUtils.getAppInterface();
      if (localObject1 != null)
      {
        localObject2 = (MiniAppExposureManager)((AppInterface)localObject1).getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
        localObject1 = (DesktopDataManager)((AppInterface)localObject1).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
      }
      for (;;)
      {
        MiniAppExposureManager.MiniAppModuleExposureData localMiniAppModuleExposureData;
        MiniAppExposureManager.MiniAppRedDotExposureData localMiniAppRedDotExposureData;
        if (localObject2 != null)
        {
          localObject3 = new MiniAppConfig(localMiniAppInfo);
          ((MiniAppConfig)localObject3).launchParam.scene = paramInt;
          localMiniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject3, "page_view", "expo");
          localMiniAppRedDotExposureData = new MiniAppExposureManager.MiniAppRedDotExposureData((MiniAppConfig)localObject3, "page_view", "expo_scene", i);
          if (localMiniAppInfo.tianshuAdId <= 0) {
            break label1100;
          }
        }
        label909:
        label946:
        label1100:
        for (localObject3 = new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", String.valueOf(localMiniAppInfo.tianshuAdId), 101);; localObject3 = null)
        {
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(localMiniAppInfo.appId).append("_").append(localMiniAppInfo.verType).append("_").append(paramDesktopAppInfo.getModuleType());
          localObject4 = ((StringBuilder)localObject4).toString();
          ((MiniAppExposureManager)localObject2).putReportDataToMap((String)localObject4, localMiniAppModuleExposureData);
          ((MiniAppExposureManager)localObject2).putReportDataToMap((String)localObject4 + "_redDot", localMiniAppRedDotExposureData);
          if (localObject3 != null) {
            ((MiniAppExposureManager)localObject2).putReportDataToMap((String)localObject4 + "_tianshu", (MiniAppExposureManager.BaseExposureReport)localObject3);
          }
          if ((localObject1 != null) && (paramDesktopAppInfo.getModuleType() == 2) && (!paramDesktopAppInfo.mMiniAppInfo.isSpecialMiniApp())) {
            ((DesktopDataManager)localObject1).updateRecommendExposureNumber(paramDesktopAppInfo.mMiniAppInfo.appId);
          }
          if ((localMiniAppInfo.motionPics != null) && (localMiniAppInfo.motionPics.size() > 0))
          {
            setAnimationListener(paramMicroAppViewHolder);
            paramDesktopAppInfo = localMiniAppInfo.motionPics.iterator();
            for (;;)
            {
              if (paramDesktopAppInfo.hasNext())
              {
                localObject1 = (String)paramDesktopAppInfo.next();
                localObject2 = new ImageView(this.mContext);
                ((ImageView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                ((ImageView)localObject2).setImageDrawable(MiniAppUtils.getIcon(this.mContext, (String)localObject1, true));
                ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER);
                paramMicroAppViewHolder.viewFlipper.addView((View)localObject2);
                continue;
                paramMicroAppViewHolder.anpgImagView.setVisibility(8);
                break;
                if (localMiniAppInfo.topType == 1)
                {
                  paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(2));
                  break label228;
                }
                paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(1));
                break label228;
                if (localMiniAppInfo.verType == 1)
                {
                  paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
                  paramMicroAppViewHolder.versionTypeMark.setText(EXPERIENCE);
                  break label263;
                }
                paramMicroAppViewHolder.versionTypeMark.setVisibility(8);
                break label263;
                label988:
                paramMicroAppViewHolder.recommendBadge.setImageDrawable(null);
                break label306;
                label999:
                paramMicroAppViewHolder.recommendBadge.setVisibility(8);
                break label339;
                label1011:
                paramMicroAppViewHolder.redDot.setVisibility(8);
                break label475;
                label1023:
                paramInt = 3001;
                break label492;
                if (paramDesktopAppInfo.getModuleType() == 2)
                {
                  paramInt = 3002;
                  break label492;
                }
                if (paramDesktopAppInfo.getModuleType() != 3) {
                  break label1115;
                }
                if (bool) {}
                for (paramInt = 3021;; paramInt = 3003) {
                  break;
                }
              }
            }
            paramMicroAppViewHolder.picCount = localMiniAppInfo.motionPics.size();
          }
          paramMicroAppViewHolder.itemView.setOnClickListener(new MiniAppDesktopAdapter.4(this));
          return;
        }
        label1030:
        localObject1 = null;
        localObject2 = null;
      }
      label1115:
      paramInt = 9999;
    }
  }
  
  public int getItemCount()
  {
    return this.mData.size();
  }
  
  public MiniAppInfo getItemForPosition(int paramInt)
  {
    return null;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mData.size())) {}
    do
    {
      return 3;
      if ((this.mData.get(paramInt) instanceof DesktopAppModuleInfo)) {
        return 1;
      }
      if ((this.mData.get(paramInt) instanceof DesktopAppGroupInfo)) {
        return 6;
      }
      if ((this.mData.get(paramInt) instanceof DesktopMostCommonlyUsedInfo)) {
        return 12;
      }
    } while ((this.mData.get(paramInt) instanceof DesktopEmptyInfo));
    if ((this.mData.get(paramInt) instanceof DesktopEmptyGuideInfo)) {
      return 4;
    }
    if ((this.mData.get(paramInt) instanceof HBEntryBannerData)) {
      return 13;
    }
    if ((this.mData.get(paramInt) instanceof DesktopSearchInfo)) {
      return 5;
    }
    if ((this.mData.get(paramInt) instanceof DesktopRecommendModuleInfo)) {
      return 8;
    }
    if ((this.mData.get(paramInt) instanceof DesktopPopularModuleInfo)) {
      return 9;
    }
    if ((this.mData.get(paramInt) instanceof DesktopFriendsPkModuleInfo)) {
      return 10;
    }
    if ((this.mData.get(paramInt) instanceof DesktopDittoInfo)) {
      return 11;
    }
    return 2;
  }
  
  public Map<String, Integer> getRedDotDataMap()
  {
    return this.mRedDotData;
  }
  
  public GridLayoutManager.SpanSizeLookup getSpanSizeLookup()
  {
    return this.mSpanSizeLookup;
  }
  
  public boolean isItemDeleteable(int paramInt)
  {
    if (paramInt < 0) {
      return false;
    }
    return ((DesktopItemInfo)this.mData.get(paramInt)).deleteEnable;
  }
  
  public boolean isItemDragable(int paramInt)
  {
    if (paramInt < 0) {
      return false;
    }
    return ((DesktopItemInfo)this.mData.get(paramInt)).dragEnable;
  }
  
  public boolean isItemDropable(int paramInt)
  {
    if (paramInt < 0) {
      return false;
    }
    return ((DesktopItemInfo)this.mData.get(paramInt)).dropEnable;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.mData.size() <= 0) {
      QLog.e("MiniAppDesktopAdapter", 1, "[MiniAppUserAppInfoListManager].onBindViewHolder, size = " + this.mData.size());
    }
    DesktopPopularModuleInfo localDesktopPopularModuleInfo;
    Activity localActivity;
    do
    {
      return;
      switch (getItemViewType(paramInt))
      {
      case 3: 
      case 7: 
      default: 
        return;
      case 1: 
        ((MiniAppDesktopAdapter.ModuleViewHolder)paramViewHolder).update((DesktopAppModuleInfo)this.mData.get(paramInt));
        return;
      case 2: 
        updateHolder((MiniAppDesktopAdapter.MicroAppViewHolder)paramViewHolder, (DesktopAppInfo)this.mData.get(paramInt), paramInt);
        return;
      case 4: 
        ((MiniAppDesktopAdapter.ModuleGuideViewHolder)paramViewHolder).update();
        return;
      case 5: 
        ((MiniAppDesktopAdapter.SearchViewHolder)paramViewHolder).update((DesktopSearchInfo)this.mData.get(paramInt));
        return;
      case 6: 
        ((MiniAppDesktopAdapter.DesktopModuleListViewHolder)paramViewHolder).bindView((DesktopAppGroupInfo)this.mData.get(paramInt), 0);
        return;
      case 12: 
        ((MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder)paramViewHolder).bindView((DesktopMostCommonlyUsedInfo)this.mData.get(paramInt));
        return;
      case 8: 
        ((MiniAppDesktopAdapter.RecommendModuleViewHolder)paramViewHolder).bindView((Activity)this.mActivity.get(), (DesktopRecommendModuleInfo)this.mData.get(paramInt));
        return;
      case 10: 
        ((MiniAppDesktopAdapter.FriendsPkViewHolder)paramViewHolder).bindView((Activity)this.mActivity.get(), (DesktopFriendsPkModuleInfo)this.mData.get(paramInt));
        return;
      case 9: 
        paramViewHolder = (MiniAppDesktopAdapter.PopularityListModuleViewHolder)paramViewHolder;
        localDesktopPopularModuleInfo = (DesktopPopularModuleInfo)this.mData.get(paramInt);
        localActivity = (Activity)this.mActivity.get();
      }
    } while (localActivity == null);
    paramViewHolder.update(localDesktopPopularModuleInfo, localActivity);
    return;
    ((MiniAppDesktopAdapter.HBEntryViewHolder)paramViewHolder).bindView((HBEntryBannerData)this.mData.get(paramInt));
    return;
    ((MiniAppDesktopAdapter.DittoViewHolder)paramViewHolder).bindView((DesktopDittoInfo)this.mData.get(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      return null;
    case 1: 
      if (Build.VERSION.SDK_INT > 21) {}
      for (paramViewGroup = ModeInfoLayoutKt.buildModuleInfoLayout(paramViewGroup.getContext());; paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562544, paramViewGroup, false)) {
        return new MiniAppDesktopAdapter.ModuleViewHolder(paramViewGroup, (Activity)this.mActivity.get());
      }
    case 2: 
      return new MiniAppDesktopAdapter.MicroAppViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562542, paramViewGroup, false));
    case 3: 
      return new MiniAppDesktopAdapter.MicroAppViewHolder(new View(paramViewGroup.getContext()));
    case 4: 
      return new MiniAppDesktopAdapter.ModuleGuideViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559503, paramViewGroup, false));
    case 13: 
      return new MiniAppDesktopAdapter.HBEntryViewHolder(this, new HBEntryBannerView(paramViewGroup.getContext()), this.mActivity);
    case 5: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559507, paramViewGroup, false);
      return new MiniAppDesktopAdapter.SearchViewHolder(this.mActivity, paramViewGroup);
    case 6: 
      return new MiniAppDesktopAdapter.DesktopModuleListViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559502, paramViewGroup, false), this.mContext, this.mRecyclerView.getDragDeleteListener());
    case 12: 
      this.mDesktopMostCommonlyUsedViewHolder = new MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559504, paramViewGroup, false), this.mActivity);
      return this.mDesktopMostCommonlyUsedViewHolder;
    case 8: 
      return new MiniAppDesktopAdapter.RecommendModuleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559506, paramViewGroup, false));
    case 9: 
      if (Build.VERSION.SDK_INT > 21) {}
      for (paramViewGroup = PopularityListLayoutKt.buildPopularityListLayout(paramViewGroup.getContext());; paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559505, paramViewGroup, false)) {
        return new MiniAppDesktopAdapter.PopularityListModuleViewHolder(paramViewGroup);
      }
    case 10: 
      return new MiniAppDesktopAdapter.FriendsPkViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559500, paramViewGroup, false));
    }
    paramViewGroup = new MiniAppDesktopAdapter.DittoViewHolder(new DesktopDittoAreaView((Context)this.mActivity.get()));
    this.mLifeCycleListenerList.add(paramViewGroup);
    return paramViewGroup;
  }
  
  public void onCustomMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    int i = 0;
    RecyclerView.ViewHolder localViewHolder;
    if (i < getItemCount())
    {
      localViewHolder = this.mRecyclerView.findViewHolderForAdapterPosition(i);
      if ((localViewHolder != null) && ((localViewHolder instanceof MiniAppDesktopAdapter.MicroAppViewHolder))) {}
    }
    for (;;)
    {
      i += 1;
      break;
      int j = ((View)localViewHolder.itemView.getParent()).getLeft();
      int k = ((View)localViewHolder.itemView.getParent()).getTop();
      int m = localViewHolder.itemView.getLeft();
      int n = localViewHolder.itemView.getTop();
      if ((Math.abs(paramInt1 - (j + m)) <= ViewUtils.b(20.0F)) && (Math.abs(paramInt2 - (k + n)) <= ViewUtils.b(20.0F)))
      {
        if (this.mMoveItemRunnable.pendingMoveTargetIndex == i) {
          return;
        }
        QLog.i("XXX", 1, "target:" + i);
        this.mMainHandler.removeCallbacks(this.mInsertItemRunnable);
        this.mInsertItemRunnable.setMoveAction((MiniAppDesktopAdapter.MicroAppViewHolder)paramViewHolder, i);
        this.mMainHandler.postDelayed(this.mInsertItemRunnable, 200L);
      }
    }
  }
  
  public void onDataChanged()
  {
    setData(((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).getData());
  }
  
  public void onDesktopAccountChanged()
  {
    QLog.d("MiniAppDesktopAdapter", 1, "onDesktopAccountChanged");
    Iterator localIterator = this.mLifeCycleListenerList.iterator();
    while (localIterator.hasNext()) {
      ((DesktopLifeCycleListener)localIterator.next()).onAccountChanged();
    }
  }
  
  public void onDesktopClosed()
  {
    this.isDesktopOpened = false;
    QLog.d("MiniAppDesktopAdapter", 2, "onDesktopClosed");
    if (this.mDesktopMostCommonlyUsedViewHolder != null)
    {
      if (this.mDesktopMostCommonlyUsedViewHolder.state == 0) {
        this.mDesktopMostCommonlyUsedViewHolder.rejectFrequentlyRecommends();
      }
      this.mDesktopMostCommonlyUsedViewHolder = null;
    }
  }
  
  public void onDesktopDestroy()
  {
    QLog.d("MiniAppDesktopAdapter", 1, "onDesktopDestroy");
    Iterator localIterator = this.mLifeCycleListenerList.iterator();
    while (localIterator.hasNext()) {
      ((DesktopLifeCycleListener)localIterator.next()).onDestroy();
    }
    this.mLifeCycleListenerList.clear();
  }
  
  public void onDesktopOpened()
  {
    this.isDesktopOpened = true;
    QLog.d("MiniAppDesktopAdapter", 2, "onDesktopOpened");
    gdtAdReport();
    AppBrandLaunchManager.g().checkPreloadApp();
  }
  
  public void onDesktopResume()
  {
    QLog.d("MiniAppDesktopAdapter", 2, "onDesktopResume");
    ThreadManager.getUIHandler().postDelayed(new MiniAppDesktopAdapter.7(this), 300L);
  }
  
  public void onDragFinish(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onDragFinish(paramViewHolder, paramInt);
  }
  
  public void onItemDelete(int paramInt)
  {
    super.onItemDelete(paramInt);
  }
  
  public void onItemDraw(RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2)
  {
    for (;;)
    {
      try
      {
        Object localObject;
        if ((this.mDragMirrorLayout != null) && (this.mDragMirrorImage != null) && (this.mDragViewHolder != null))
        {
          localObject = this.mDragViewHolder;
          if (localObject != paramViewHolder) {}
        }
        try
        {
          j = ((View)paramViewHolder.itemView.getParent()).getLeft();
          i = ((View)paramViewHolder.itemView.getParent()).getTop();
          localObject = (FrameLayout.LayoutParams)this.mDragMirrorLayout.getLayoutParams();
          k = paramViewHolder.itemView.getLeft();
          j = (int)paramFloat1 + (j + k);
          i = paramViewHolder.itemView.getTop() + i + (int)paramFloat2 - ViewUtils.b(8.0F);
          this.currDragMoveLeft = j;
          this.currDragMoveTop = i;
          ((FrameLayout.LayoutParams)localObject).setMargins(j, i, 0, 0);
          this.mDragMirrorLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        catch (Throwable paramViewHolder)
        {
          try
          {
            if (this.mInsertTarget < 0)
            {
              paramViewHolder = this.mRecyclerView.findViewHolderForAdapterPosition(getItemCount() - 1);
              if ((paramViewHolder != null) && (Math.abs(j - paramViewHolder.itemView.getLeft()) >= ViewUtils.b(20.0F)) && (i - paramViewHolder.itemView.getTop() >= ViewUtils.b(30.0F)))
              {
                paramViewHolder = (DesktopItemInfo)this.mData.get(getItemCount() - 1);
                if ((paramViewHolder.dropEnable) && (!paramViewHolder.isTemp) && (!isSameModule(this.mDragIndex, getItemCount() - 1)))
                {
                  QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag into tail blank area from:" + this.mDragIndex);
                  localObject = (DesktopAppInfo)this.mData.get(this.mDragIndex);
                  new DesktopAppInfo(paramViewHolder.mModuleType, ((DesktopAppInfo)localObject).mMiniAppInfo).setIsTemp(true);
                  this.lastDragMoveLeft = j;
                  this.lastDragMoveTop = i;
                  this.mMainHandler.removeCallbacks(this.mMoveItemRunnable);
                  this.mMoveItemRunnable.setMoveTailAction(this.mDragIndex);
                  this.mMainHandler.postDelayed(this.mMoveItemRunnable, 200L);
                }
              }
            }
            return;
          }
          catch (Throwable paramViewHolder)
          {
            int j;
            int i;
            int k;
            QLog.e("MiniAppDesktopAdapter", 1, paramViewHolder, new Object[0]);
          }
          paramViewHolder = paramViewHolder;
          paramViewHolder = (FrameLayout.LayoutParams)this.mDragMirrorLayout.getLayoutParams();
          this.currDragMoveLeft = ((int)(this.currDragMoveLeft + paramFloat1));
          this.currDragMoveTop = ((int)(this.currDragMoveTop + paramFloat2));
          j = this.currDragMoveLeft;
          i = this.currDragMoveTop;
          paramViewHolder.setMargins(this.currDragMoveLeft, this.currDragMoveTop, 0, 0);
          this.mDragMirrorLayout.setLayoutParams(paramViewHolder);
          continue;
        }
        if (this.mInsertTarget > 0)
        {
          k = 1;
          if ((k != 0) && (this.mDragMirrorMarkImage != null)) {
            this.mDragMirrorMarkImage.setVisibility(0);
          }
          if ((Math.abs(j - this.lastDragLeft) > ViewUtils.b(25.0F)) || (Math.abs(i - this.lastDragTop) > ViewUtils.b(25.0F)))
          {
            QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag DragMirror left:" + j + " top:" + i);
            this.lastDragLeft = j;
            this.lastDragTop = i;
          }
        }
        k = 0;
      }
      catch (Throwable paramViewHolder)
      {
        QLog.e("MiniAppDesktopAdapter", 1, "onItemDraw exception!", paramViewHolder);
        return;
      }
    }
  }
  
  public void onItemMoved(int paramInt1, int paramInt2)
  {
    int j = -1;
    if ((this.mMoveItemRunnable.moveFromIndex == paramInt1) && (this.mMoveItemRunnable.pendingMoveTargetIndex == paramInt2)) {}
    label204:
    label224:
    for (;;)
    {
      return;
      int i;
      if (this.mDragMirrorLayout != null)
      {
        i = this.mDragMirrorLayout.getLeft();
        if (this.mDragMirrorLayout == null) {
          break label204;
        }
        j = this.mDragMirrorLayout.getTop();
      }
      for (;;)
      {
        if ((Math.abs(j - this.lastDragMoveLeft) <= ViewUtils.b(20.0F)) && (Math.abs(j - this.lastDragMoveTop) <= ViewUtils.b(20.0F))) {
          break label224;
        }
        this.lastDragMoveLeft = i;
        this.lastDragMoveTop = j;
        QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag Moved from " + paramInt1 + " target " + paramInt2);
        this.mMainHandler.removeCallbacks(this.mMoveItemRunnable);
        this.mMoveItemRunnable.setMoveAction(paramInt1, paramInt2);
        this.mMainHandler.postDelayed(this.mMoveItemRunnable, 200L);
        return;
        if (this.mDragViewHolder != null)
        {
          i = this.mDragViewHolder.itemView.getLeft();
          break;
        }
        i = -1;
        break;
        if (this.mDragViewHolder != null) {
          j = this.mDragViewHolder.itemView.getTop();
        }
      }
    }
  }
  
  public void onItemPrepared(int paramInt)
  {
    super.onItemPrepared(paramInt);
  }
  
  public void onStartDesktopOpenAnimation() {}
  
  public void setData(List<DesktopItemInfo> paramList)
  {
    this.mData.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniAppDesktopAdapter", 2, "updateData. data = " + paramList);
      }
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      Object localObject;
      if ((paramList.get(i) instanceof DesktopAppGroupInfo))
      {
        localObject = (DesktopAppGroupInfo)paramList.get(i);
        if (((DesktopAppGroupInfo)localObject).datas != null)
        {
          int j = ((DesktopAppGroupInfo)localObject).datas.size() - 1;
          while (j >= 0)
          {
            DesktopAppInfo localDesktopAppInfo = (DesktopAppInfo)((DesktopAppGroupInfo)localObject).datas.get(j);
            if ((localDesktopAppInfo != null) && (localDesktopAppInfo.isTemp)) {
              ((DesktopAppGroupInfo)localObject).datas.remove(j);
            }
            j -= 1;
          }
        }
      }
      else if ((paramList.get(i) instanceof DesktopAppInfo))
      {
        localObject = (DesktopAppInfo)paramList.get(i);
        if ((localObject != null) && (((DesktopAppInfo)localObject).isTemp)) {
          paramList.remove(i);
        }
      }
      i -= 1;
    }
    this.mData.addAll(paramList);
    ThreadManager.getUIHandler().post(new MiniAppDesktopAdapter.3(this));
  }
  
  public void setData(List<DesktopItemInfo> paramList, Map<String, Integer> paramMap)
  {
    this.mData.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniAppDesktopAdapter", 2, "updateData. data = " + paramList);
      }
      return;
    }
    this.mData.addAll(paramList);
    this.mRedDotData.clear();
    this.mRedDotData.putAll(paramMap);
    this.mCanShowRedDot = MiniAppConfProcessor.d();
  }
  
  public void setRedDotSwitchState(int paramInt)
  {
    this.mRedDotSwitchState = paramInt;
  }
  
  public void startAnimation()
  {
    if (this.mAnimListener != null) {
      this.mAnimListener.startAnimation();
    }
  }
  
  public void stopAnimation()
  {
    if (this.mAnimListener != null) {
      this.mAnimListener.stopAnimation();
    }
  }
  
  public void updateHolder(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt)
  {
    doUpdateHolder(paramMicroAppViewHolder, paramDesktopAppInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter
 * JD-Core Version:    0.7.0.1
 */