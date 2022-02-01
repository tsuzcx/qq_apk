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
  private static final String DEVELOP = HardCodeUtil.a(2131706819);
  private static final long DRAG_INSERT_DURA = 200L;
  private static final String EXPERIENCE = HardCodeUtil.a(2131706828);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteMiniApp, delete miniAppInfo: ");
      ((StringBuilder)localObject).append(paramMiniAppInfo.toString());
      QLog.i("MiniAppDesktopAdapter", 2, ((StringBuilder)localObject).toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gdtAdReport, exception: ");
      localStringBuilder.append(Log.getStackTraceString(localException));
      QLog.e("MiniAppDesktopAdapter", 1, localStringBuilder.toString());
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 >= 0)
    {
      bool1 = bool2;
      if (paramInt1 < getItemCount())
      {
        bool1 = bool2;
        if (paramInt2 >= 0)
        {
          if (paramInt2 >= getItemCount()) {
            return false;
          }
          DesktopItemInfo localDesktopItemInfo1 = (DesktopItemInfo)this.mData.get(paramInt1);
          DesktopItemInfo localDesktopItemInfo2 = (DesktopItemInfo)this.mData.get(paramInt2);
          bool1 = bool2;
          if (localDesktopItemInfo1.mModuleType == localDesktopItemInfo2.mModuleType) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTopMiniApp, miniAppInfo: ");
      ((StringBuilder)localObject).append(paramMiniAppInfo.toString());
      QLog.i("MiniAppDesktopAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Activity)this.mActivity.get();
    if (localObject == null) {
      return;
    }
    localObject = (MiniAppUserAppInfoListManager)((BaseActivity)localObject).app.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    if (localObject != null)
    {
      if (paramMiniAppInfo.topType == 0)
      {
        paramMiniAppInfo.topType = 1;
        paramMiniAppInfo.updateTimeStamp();
      }
      else
      {
        paramMiniAppInfo.topType = 0;
      }
      ((MiniAppUserAppInfoListManager)localObject).sendSetUserAppTopRequest(paramMiniAppInfo);
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
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("startMiniApp exception: ");
      paramMiniAppInfo.append(Log.getStackTraceString(paramActivity));
      QLog.e("MiniAppDesktopAdapter", 1, paramMiniAppInfo.toString());
    }
  }
  
  protected void doUpdateHolder(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt)
  {
    paramMicroAppViewHolder.desktopAppInfo = paramDesktopAppInfo;
    paramMicroAppViewHolder.itemView.setVisibility(0);
    if (paramDesktopAppInfo.isTemp)
    {
      paramMicroAppViewHolder.imageView.setImageResource(2130841022);
      paramMicroAppViewHolder.textView.setVisibility(4);
      paramMicroAppViewHolder.versionTypeMark.setVisibility(4);
      paramMicroAppViewHolder.recommendBadge.setVisibility(4);
      paramMicroAppViewHolder.redDot.setVisibility(4);
      return;
    }
    MiniAppInfo localMiniAppInfo = paramDesktopAppInfo.mMiniAppInfo;
    Object localObject2;
    if (((localMiniAppInfo.motionPics == null) || (localMiniAppInfo.motionPics.size() <= 0)) && (!TextUtils.isEmpty(localMiniAppInfo.apngUrl)))
    {
      paramMicroAppViewHolder.anpgImagView.setVisibility(0);
      localObject1 = paramMicroAppViewHolder.anpgImagView;
      localObject2 = localMiniAppInfo.apngUrl;
      localObject3 = new ColorDrawable(Color.parseColor("#00000000"));
      ((ImageView)localObject1).setImageDrawable(VasApngUtil.getApngURLDrawable((String)localObject2, new int[] { 32 }, (Drawable)localObject3));
    }
    else
    {
      paramMicroAppViewHolder.anpgImagView.setVisibility(8);
    }
    paramMicroAppViewHolder.imageView.setImageDrawable(MiniAppUtils.getIcon(this.mContext, localMiniAppInfo.iconUrl, true));
    paramMicroAppViewHolder.textView.setVisibility(0);
    paramMicroAppViewHolder.textView.setText(localMiniAppInfo.name);
    paramMicroAppViewHolder.setMiniAppInfo(localMiniAppInfo);
    paramMicroAppViewHolder.setModuleType(paramDesktopAppInfo.getModuleType());
    if (localMiniAppInfo.isSpecialMiniApp()) {
      paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(3));
    } else if (localMiniAppInfo.topType == 1) {
      paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(2));
    } else {
      paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(1));
    }
    if ((localMiniAppInfo.verType != 0) && (localMiniAppInfo.verType != 4))
    {
      if (localMiniAppInfo.verType == 1)
      {
        paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
        paramMicroAppViewHolder.versionTypeMark.setText(EXPERIENCE);
      }
      else
      {
        paramMicroAppViewHolder.versionTypeMark.setVisibility(8);
      }
    }
    else
    {
      paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
      paramMicroAppViewHolder.versionTypeMark.setText(DEVELOP);
    }
    int i = paramDesktopAppInfo.getModuleType();
    Object localObject3 = null;
    if (i == 2)
    {
      paramMicroAppViewHolder.recommendBadge.setVisibility(0);
      if (!TextUtils.isEmpty(localMiniAppInfo.recommendAppIconUrl)) {
        paramMicroAppViewHolder.recommendBadge.setImageDrawable(MiniAppUtils.getDrawable(localMiniAppInfo.recommendAppIconUrl, null));
      } else {
        paramMicroAppViewHolder.recommendBadge.setImageDrawable(null);
      }
      if ((!TextUtils.isEmpty(localMiniAppInfo.amsAdInfo)) && (!paramDesktopAppInfo.isFromCache())) {
        collectAdReport(paramMicroAppViewHolder.imageView, paramMicroAppViewHolder.textView, localMiniAppInfo, paramInt);
      }
    }
    else
    {
      paramMicroAppViewHolder.recommendBadge.setVisibility(8);
    }
    i = getRedDotCount(localMiniAppInfo.appId);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onBindViewHolder, canShowRedDot: ");
      ((StringBuilder)localObject1).append(this.mCanShowRedDot);
      ((StringBuilder)localObject1).append(", redDotNum : ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", name : ");
      ((StringBuilder)localObject1).append(localMiniAppInfo.name);
      ((StringBuilder)localObject1).append(", mRedDotSwitchState: ");
      ((StringBuilder)localObject1).append(this.mRedDotSwitchState);
      QLog.d("MiniAppDesktopAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = needShowRodDotCount(localMiniAppInfo.appId);
    if ((bool) && ((paramDesktopAppInfo.getModuleType() == 1) || (paramDesktopAppInfo.getModuleType() == 3)))
    {
      paramMicroAppViewHolder.redDot.setVisibility(0);
      CustomWidgetUtil.a(paramMicroAppViewHolder.redDot, 7, i, 0);
    }
    else
    {
      paramMicroAppViewHolder.redDot.setVisibility(8);
    }
    paramInt = 9999;
    if (paramDesktopAppInfo.getModuleType() == 1)
    {
      if (bool) {
        paramInt = 3020;
      } else {
        paramInt = 3001;
      }
    }
    else if (paramDesktopAppInfo.getModuleType() == 2) {
      paramInt = 3002;
    } else if (paramDesktopAppInfo.getModuleType() == 3) {
      if (bool) {
        paramInt = 3021;
      } else {
        paramInt = 3003;
      }
    }
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 != null)
    {
      localObject2 = (MiniAppExposureManager)((AppInterface)localObject1).getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
      localObject1 = (DesktopDataManager)((AppInterface)localObject1).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    if (localObject2 != null)
    {
      Object localObject5 = new MiniAppConfig(localMiniAppInfo);
      ((MiniAppConfig)localObject5).launchParam.scene = paramInt;
      Object localObject4 = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject5, "page_view", "expo");
      localObject5 = new MiniAppExposureManager.MiniAppRedDotExposureData((MiniAppConfig)localObject5, "page_view", "expo_scene", i);
      if (localMiniAppInfo.tianshuAdId > 0) {
        localObject3 = new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", String.valueOf(localMiniAppInfo.tianshuAdId), 101);
      }
      Object localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(localMiniAppInfo.appId);
      ((StringBuilder)localObject6).append("_");
      ((StringBuilder)localObject6).append(localMiniAppInfo.verType);
      ((StringBuilder)localObject6).append("_");
      ((StringBuilder)localObject6).append(paramDesktopAppInfo.getModuleType());
      localObject6 = ((StringBuilder)localObject6).toString();
      ((MiniAppExposureManager)localObject2).putReportDataToMap((String)localObject6, (MiniAppExposureManager.BaseExposureReport)localObject4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject6);
      ((StringBuilder)localObject4).append("_redDot");
      ((MiniAppExposureManager)localObject2).putReportDataToMap(((StringBuilder)localObject4).toString(), (MiniAppExposureManager.BaseExposureReport)localObject5);
      if (localObject3 != null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject6);
        ((StringBuilder)localObject4).append("_tianshu");
        ((MiniAppExposureManager)localObject2).putReportDataToMap(((StringBuilder)localObject4).toString(), (MiniAppExposureManager.BaseExposureReport)localObject3);
      }
    }
    if ((localObject1 != null) && (paramDesktopAppInfo.getModuleType() == 2) && (!paramDesktopAppInfo.mMiniAppInfo.isSpecialMiniApp())) {
      ((DesktopDataManager)localObject1).updateRecommendExposureNumber(paramDesktopAppInfo.mMiniAppInfo.appId);
    }
    if ((localMiniAppInfo.motionPics != null) && (localMiniAppInfo.motionPics.size() > 0))
    {
      setAnimationListener(paramMicroAppViewHolder);
      paramDesktopAppInfo = localMiniAppInfo.motionPics.iterator();
      while (paramDesktopAppInfo.hasNext())
      {
        localObject1 = (String)paramDesktopAppInfo.next();
        localObject2 = new ImageView(this.mContext);
        ((ImageView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ((ImageView)localObject2).setImageDrawable(MiniAppUtils.getIcon(this.mContext, (String)localObject1, true));
        ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER);
        paramMicroAppViewHolder.viewFlipper.addView((View)localObject2);
      }
      paramMicroAppViewHolder.picCount = localMiniAppInfo.motionPics.size();
    }
    paramMicroAppViewHolder.itemView.setOnClickListener(new MiniAppDesktopAdapter.4(this));
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
    if (paramInt >= 0)
    {
      if (paramInt >= this.mData.size()) {
        return 3;
      }
      if ((this.mData.get(paramInt) instanceof DesktopAppModuleInfo)) {
        return 1;
      }
      if ((this.mData.get(paramInt) instanceof DesktopAppGroupInfo)) {
        return 6;
      }
      if ((this.mData.get(paramInt) instanceof DesktopMostCommonlyUsedInfo)) {
        return 12;
      }
      if ((this.mData.get(paramInt) instanceof DesktopEmptyInfo)) {
        return 3;
      }
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
    return 3;
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
    if (this.mData.size() <= 0)
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("[MiniAppUserAppInfoListManager].onBindViewHolder, size = ");
      paramViewHolder.append(this.mData.size());
      QLog.e("MiniAppDesktopAdapter", 1, paramViewHolder.toString());
      return;
    }
    switch (getItemViewType(paramInt))
    {
    case 7: 
    default: 
    case 13: 
      ((MiniAppDesktopAdapter.HBEntryViewHolder)paramViewHolder).bindView((HBEntryBannerData)this.mData.get(paramInt));
      return;
    case 12: 
      ((MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder)paramViewHolder).bindView((DesktopMostCommonlyUsedInfo)this.mData.get(paramInt));
      return;
    case 11: 
      ((MiniAppDesktopAdapter.DittoViewHolder)paramViewHolder).bindView((DesktopDittoInfo)this.mData.get(paramInt));
      return;
    case 10: 
      ((MiniAppDesktopAdapter.FriendsPkViewHolder)paramViewHolder).bindView((Activity)this.mActivity.get(), (DesktopFriendsPkModuleInfo)this.mData.get(paramInt));
      return;
    case 9: 
      paramViewHolder = (MiniAppDesktopAdapter.PopularityListModuleViewHolder)paramViewHolder;
      DesktopPopularModuleInfo localDesktopPopularModuleInfo = (DesktopPopularModuleInfo)this.mData.get(paramInt);
      Activity localActivity = (Activity)this.mActivity.get();
      if (localActivity != null)
      {
        paramViewHolder.update(localDesktopPopularModuleInfo, localActivity);
        return;
      }
      break;
    case 8: 
      ((MiniAppDesktopAdapter.RecommendModuleViewHolder)paramViewHolder).bindView((Activity)this.mActivity.get(), (DesktopRecommendModuleInfo)this.mData.get(paramInt));
      return;
    case 6: 
      ((MiniAppDesktopAdapter.DesktopModuleListViewHolder)paramViewHolder).bindView((DesktopAppGroupInfo)this.mData.get(paramInt), 0);
      return;
    case 5: 
      ((MiniAppDesktopAdapter.SearchViewHolder)paramViewHolder).update((DesktopSearchInfo)this.mData.get(paramInt));
      return;
    case 4: 
      ((MiniAppDesktopAdapter.ModuleGuideViewHolder)paramViewHolder).update();
      return;
    case 2: 
      updateHolder((MiniAppDesktopAdapter.MicroAppViewHolder)paramViewHolder, (DesktopAppInfo)this.mData.get(paramInt), paramInt);
      return;
    case 1: 
      ((MiniAppDesktopAdapter.ModuleViewHolder)paramViewHolder).update((DesktopAppModuleInfo)this.mData.get(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      paramViewGroup = null;
    case 13: 
    case 12: 
    case 11: 
    case 10: 
    case 9: 
    case 8: 
    case 6: 
    case 5: 
    case 4: 
    case 3: 
      for (;;)
      {
        return paramViewGroup;
        paramViewGroup = new MiniAppDesktopAdapter.HBEntryViewHolder(this, new HBEntryBannerView(paramViewGroup.getContext()), this.mActivity);
        continue;
        this.mDesktopMostCommonlyUsedViewHolder = new MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559378, paramViewGroup, false), this.mActivity);
        paramViewGroup = this.mDesktopMostCommonlyUsedViewHolder;
        continue;
        paramViewGroup = new MiniAppDesktopAdapter.DittoViewHolder(new DesktopDittoAreaView((Context)this.mActivity.get()));
        this.mLifeCycleListenerList.add(paramViewGroup);
        return paramViewGroup;
        return new MiniAppDesktopAdapter.FriendsPkViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559374, paramViewGroup, false));
        if (Build.VERSION.SDK_INT > 21) {
          paramViewGroup = PopularityListLayoutKt.buildPopularityListLayout(paramViewGroup.getContext());
        } else {
          paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559379, paramViewGroup, false);
        }
        return new MiniAppDesktopAdapter.PopularityListModuleViewHolder(paramViewGroup);
        return new MiniAppDesktopAdapter.RecommendModuleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559380, paramViewGroup, false));
        return new MiniAppDesktopAdapter.DesktopModuleListViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559376, paramViewGroup, false), this.mContext, this.mRecyclerView.getDragDeleteListener());
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559381, paramViewGroup, false);
        return new MiniAppDesktopAdapter.SearchViewHolder(this.mActivity, paramViewGroup);
        return new MiniAppDesktopAdapter.ModuleGuideViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559377, paramViewGroup, false));
        paramViewGroup = new MiniAppDesktopAdapter.MicroAppViewHolder(new View(paramViewGroup.getContext()));
      }
    case 2: 
      return new MiniAppDesktopAdapter.MicroAppViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562378, paramViewGroup, false));
    }
    if (Build.VERSION.SDK_INT > 21) {
      paramViewGroup = ModeInfoLayoutKt.buildModuleInfoLayout(paramViewGroup.getContext());
    } else {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562380, paramViewGroup, false);
    }
    return new MiniAppDesktopAdapter.ModuleViewHolder(paramViewGroup, (Activity)this.mActivity.get());
  }
  
  public void onCustomMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < getItemCount())
    {
      Object localObject = this.mRecyclerView.findViewHolderForAdapterPosition(i);
      if ((localObject != null) && ((localObject instanceof MiniAppDesktopAdapter.MicroAppViewHolder)))
      {
        int j = ((View)((RecyclerView.ViewHolder)localObject).itemView.getParent()).getLeft();
        int k = ((View)((RecyclerView.ViewHolder)localObject).itemView.getParent()).getTop();
        int m = ((RecyclerView.ViewHolder)localObject).itemView.getLeft();
        int n = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
        if ((Math.abs(paramInt1 - (j + m)) <= ViewUtils.b(20.0F)) && (Math.abs(paramInt2 - (k + n)) <= ViewUtils.b(20.0F)))
        {
          if (this.mMoveItemRunnable.pendingMoveTargetIndex == i) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("target:");
          ((StringBuilder)localObject).append(i);
          QLog.i("XXX", 1, ((StringBuilder)localObject).toString());
          this.mMainHandler.removeCallbacks(this.mInsertItemRunnable);
          this.mInsertItemRunnable.setMoveAction((MiniAppDesktopAdapter.MicroAppViewHolder)paramViewHolder, i);
          this.mMainHandler.postDelayed(this.mInsertItemRunnable, 200L);
        }
      }
      i += 1;
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
    MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder localDesktopMostCommonlyUsedViewHolder = this.mDesktopMostCommonlyUsedViewHolder;
    if (localDesktopMostCommonlyUsedViewHolder != null)
    {
      if (localDesktopMostCommonlyUsedViewHolder.state == 0) {
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
    try
    {
      if ((this.mDragMirrorLayout != null) && (this.mDragMirrorImage != null) && (this.mDragViewHolder != null))
      {
        localObject = this.mDragViewHolder;
        if (localObject != paramViewHolder) {}
      }
    }
    catch (Throwable paramViewHolder)
    {
      Object localObject;
      int i;
      int j;
      label147:
      label229:
      QLog.e("MiniAppDesktopAdapter", 1, "onItemDraw exception!", paramViewHolder);
    }
    try
    {
      i = ((View)paramViewHolder.itemView.getParent()).getLeft();
      j = ((View)paramViewHolder.itemView.getParent()).getTop();
      localObject = (FrameLayout.LayoutParams)this.mDragMirrorLayout.getLayoutParams();
      i = i + paramViewHolder.itemView.getLeft() + (int)paramFloat1;
      j = j + paramViewHolder.itemView.getTop() + (int)paramFloat2 - ViewUtils.b(8.0F);
      this.currDragMoveLeft = i;
      this.currDragMoveTop = j;
      ((FrameLayout.LayoutParams)localObject).setMargins(i, j, 0, 0);
      this.mDragMirrorLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    catch (Throwable paramViewHolder)
    {
      break label147;
      k = 0;
      break label229;
    }
    paramViewHolder = (FrameLayout.LayoutParams)this.mDragMirrorLayout.getLayoutParams();
    this.currDragMoveLeft = ((int)(this.currDragMoveLeft + paramFloat1));
    this.currDragMoveTop = ((int)(this.currDragMoveTop + paramFloat2));
    i = this.currDragMoveLeft;
    j = this.currDragMoveTop;
    paramViewHolder.setMargins(this.currDragMoveLeft, this.currDragMoveTop, 0, 0);
    this.mDragMirrorLayout.setLayoutParams(paramViewHolder);
    if (this.mInsertTarget > 0)
    {
      k = 1;
      if ((k != 0) && (this.mDragMirrorMarkImage != null)) {
        this.mDragMirrorMarkImage.setVisibility(0);
      }
      if ((Math.abs(i - this.lastDragLeft) > ViewUtils.b(25.0F)) || (Math.abs(j - this.lastDragTop) > ViewUtils.b(25.0F)))
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("Desktop-Drag DragMirror left:");
        paramViewHolder.append(i);
        paramViewHolder.append(" top:");
        paramViewHolder.append(j);
        QLog.i("MiniAppDesktopAdapter", 1, paramViewHolder.toString());
        this.lastDragLeft = i;
        this.lastDragTop = j;
        try
        {
          if (this.mInsertTarget < 0)
          {
            paramViewHolder = this.mRecyclerView.findViewHolderForAdapterPosition(getItemCount() - 1);
            if ((paramViewHolder != null) && (Math.abs(i - paramViewHolder.itemView.getLeft()) >= ViewUtils.b(20.0F)) && (j - paramViewHolder.itemView.getTop() >= ViewUtils.b(30.0F)))
            {
              paramViewHolder = (DesktopItemInfo)this.mData.get(getItemCount() - 1);
              if ((paramViewHolder.dropEnable) && (!paramViewHolder.isTemp) && (!isSameModule(this.mDragIndex, getItemCount() - 1)))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Desktop-Drag into tail blank area from:");
                ((StringBuilder)localObject).append(this.mDragIndex);
                QLog.i("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject).toString());
                localObject = (DesktopAppInfo)this.mData.get(this.mDragIndex);
                new DesktopAppInfo(paramViewHolder.mModuleType, ((DesktopAppInfo)localObject).mMiniAppInfo).setIsTemp(true);
                this.lastDragMoveLeft = i;
                this.lastDragMoveTop = j;
                this.mMainHandler.removeCallbacks(this.mMoveItemRunnable);
                this.mMoveItemRunnable.setMoveTailAction(this.mDragIndex);
                this.mMainHandler.postDelayed(this.mMoveItemRunnable, 200L);
                return;
              }
            }
          }
        }
        catch (Throwable paramViewHolder)
        {
          QLog.e("MiniAppDesktopAdapter", 1, paramViewHolder, new Object[0]);
          return;
        }
      }
      return;
    }
  }
  
  public void onItemMoved(int paramInt1, int paramInt2)
  {
    if ((this.mMoveItemRunnable.moveFromIndex == paramInt1) && (this.mMoveItemRunnable.pendingMoveTargetIndex == paramInt2)) {
      return;
    }
    Object localObject = this.mDragMirrorLayout;
    int j = -1;
    int i;
    if (localObject != null)
    {
      i = this.mDragMirrorLayout.getLeft();
    }
    else
    {
      localObject = this.mDragViewHolder;
      if (localObject != null) {
        i = ((RecyclerView.ViewHolder)localObject).itemView.getLeft();
      } else {
        i = -1;
      }
    }
    if (this.mDragMirrorLayout != null)
    {
      j = this.mDragMirrorLayout.getTop();
    }
    else
    {
      localObject = this.mDragViewHolder;
      if (localObject != null) {
        j = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
      }
    }
    if ((Math.abs(j - this.lastDragMoveLeft) <= ViewUtils.b(20.0F)) && (Math.abs(j - this.lastDragMoveTop) <= ViewUtils.b(20.0F))) {
      return;
    }
    this.lastDragMoveLeft = i;
    this.lastDragMoveTop = j;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Desktop-Drag Moved from ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" target ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject).toString());
    this.mMainHandler.removeCallbacks(this.mMoveItemRunnable);
    this.mMoveItemRunnable.setMoveAction(paramInt1, paramInt2);
    this.mMainHandler.postDelayed(this.mMoveItemRunnable, 200L);
  }
  
  public void onItemPrepared(int paramInt)
  {
    super.onItemPrepared(paramInt);
  }
  
  public void onStartDesktopOpenAnimation() {}
  
  public void setData(List<DesktopItemInfo> paramList)
  {
    this.mData.clear();
    Object localObject;
    if ((paramList != null) && (paramList.size() != 0))
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
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
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateData. data = ");
      ((StringBuilder)localObject).append(paramList);
      QLog.i("MiniAppDesktopAdapter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setData(List<DesktopItemInfo> paramList, Map<String, Integer> paramMap)
  {
    this.mData.clear();
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.mData.addAll(paramList);
      this.mRedDotData.clear();
      this.mRedDotData.putAll(paramMap);
      this.mCanShowRedDot = MiniAppConfProcessor.d();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("updateData. data = ");
      paramMap.append(paramList);
      QLog.i("MiniAppDesktopAdapter", 2, paramMap.toString());
    }
  }
  
  public void setRedDotSwitchState(int paramInt)
  {
    this.mRedDotSwitchState = paramInt;
  }
  
  public void startAnimation()
  {
    MiniAppDesktopAdapter.OnAnimationListener localOnAnimationListener = this.mAnimListener;
    if (localOnAnimationListener != null) {
      localOnAnimationListener.startAnimation();
    }
  }
  
  public void stopAnimation()
  {
    MiniAppDesktopAdapter.OnAnimationListener localOnAnimationListener = this.mAnimListener;
    if (localOnAnimationListener != null) {
      localOnAnimationListener.stopAnimation();
    }
  }
  
  protected void updateHolder(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt)
  {
    doUpdateHolder(paramMicroAppViewHolder, paramDesktopAppInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter
 * JD-Core Version:    0.7.0.1
 */