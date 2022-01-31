package com.tencent.mobileqq.mini.entry.desktop;

import alud;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import aoom;
import bdoo;
import bduc;
import bhvv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopPopularModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopRecommendModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoAreaView;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView.OnItemChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MiniAppDesktopAdapter
  extends DragAdapter
  implements MiniAppDesktopLayout.DesktopChangeListener, DesktopDataManager.DataChangeListener, DragRecyclerView.OnItemChangeListener
{
  private static final String DEVELOP = alud.a(2131707178);
  private static final long DRAG_INSERT_DURA = 200L;
  private static final String EXPERIENCE = alud.a(2131707187);
  public static final int REFER_CONTACTS = 1;
  public static final int REFER_CONVERSATION = 0;
  public static final int REFER_LEBA = 2;
  private static final String TAG = "MiniAppDesktopAdapter";
  private static final int TYPE_MIMI_APP_SPECIAL = 3;
  private static final int TYPE_MINI_APP_NORMAL = 1;
  private static final int TYPE_MINI_APP_TOP = 2;
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
  private boolean mDeletePrepared;
  private RecyclerView.ViewHolder mDragViewHolder;
  private MiniAppDesktopAdapter.IntertItemRunnable mInsertItemRunnable = new MiniAppDesktopAdapter.IntertItemRunnable(this, null);
  private int mIntertFrom = -1;
  private int mIntertTarget = -1;
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
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)((BaseActivity)localObject).app.getManager(309);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendDelUserAppRequest(paramMiniAppInfo);
    }
    MiniCacheFreeManager.freeCache(((BaseActivity)localObject).app.c(), paramMiniAppInfo);
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
      ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).miniAppAdReport();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppDesktopAdapter", 1, "gdtAdReport, exception: " + Log.getStackTraceString(localException));
    }
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
      localObject = (MiniAppUserAppInfoListManager)((BaseActivity)localObject).app.getManager(309);
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
  
  protected void doUpdateHolder(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, DesktopAppInfo paramDesktopAppInfo, int paramInt)
  {
    paramMicroAppViewHolder.desktopAppInfo = paramDesktopAppInfo;
    paramMicroAppViewHolder.itemView.setVisibility(0);
    if (paramDesktopAppInfo.isTemp)
    {
      paramMicroAppViewHolder.imageView.setImageResource(2130840729);
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
    if (((localMiniAppInfo.motionPics == null) || (localMiniAppInfo.motionPics.size() <= 0)) && (!TextUtils.isEmpty(localMiniAppInfo.apngUrl)))
    {
      paramMicroAppViewHolder.anpgImagView.setVisibility(0);
      localObject1 = paramMicroAppViewHolder.anpgImagView;
      localObject2 = localMiniAppInfo.apngUrl;
      localObject3 = new ColorDrawable(Color.parseColor("#00000000"));
      ((ImageView)localObject1).setImageDrawable(bduc.a((String)localObject2, new int[] { 32 }, (Drawable)localObject3));
      paramMicroAppViewHolder.imageView.setImageDrawable(MiniAppUtils.getIcon(this.mContext, localMiniAppInfo.iconUrl, true));
      paramMicroAppViewHolder.textView.setVisibility(0);
      paramMicroAppViewHolder.textView.setText(localMiniAppInfo.name);
      paramMicroAppViewHolder.setMiniAppInfo(localMiniAppInfo);
      paramMicroAppViewHolder.setModuleType(paramDesktopAppInfo.getModuleType());
      if (!localMiniAppInfo.isSpecialMiniApp()) {
        break label981;
      }
      paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(3));
      label228:
      if ((localMiniAppInfo.verType != 0) && (localMiniAppInfo.verType != 4)) {
        break label1018;
      }
      paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
      paramMicroAppViewHolder.versionTypeMark.setText(DEVELOP);
      label263:
      if (paramDesktopAppInfo.getModuleType() != 2) {
        break label1071;
      }
      paramMicroAppViewHolder.recommendBadge.setVisibility(0);
      if (TextUtils.isEmpty(localMiniAppInfo.recommendAppIconUrl)) {
        break label1060;
      }
      paramMicroAppViewHolder.recommendBadge.setImageDrawable(MiniAppUtils.getDrawable(localMiniAppInfo.recommendAppIconUrl, null));
      label306:
      if ((!TextUtils.isEmpty(localMiniAppInfo.amsAdInfo)) && (!paramDesktopAppInfo.isFromCache())) {
        collectAdReport(paramMicroAppViewHolder.imageView, paramMicroAppViewHolder.textView, localMiniAppInfo, paramInt);
      }
      label339:
      localObject1 = (Integer)this.mRedDotData.get(localMiniAppInfo.appId);
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppDesktopAdapter", 2, "onBindViewHolder, canShowRedDot: " + this.mCanShowRedDot + ", redDotNum : " + localObject1 + ", name : " + localMiniAppInfo.name + ", mRedDotSwitchState: " + this.mRedDotSwitchState);
      }
      if ((!this.mCanShowRedDot) || (this.mRedDotSwitchState != 1) || (localObject1 == null) || (((Integer)localObject1).intValue() <= 0)) {
        break label1083;
      }
      paramMicroAppViewHolder.redDot.setVisibility(0);
      bhvv.a(paramMicroAppViewHolder.redDot, 7, ((Integer)localObject1).intValue(), 0);
      label482:
      if (paramDesktopAppInfo.getModuleType() != 1) {
        break label1095;
      }
      paramInt = 3001;
    }
    for (;;)
    {
      label494:
      localObject3 = MiniAppUtils.getAppInterface();
      localObject1 = null;
      if (localObject3 != null)
      {
        localObject2 = (MiniAppExposureManager)((AppInterface)localObject3).getManager(322);
        localObject1 = (DesktopDataManager)((AppInterface)localObject3).getManager(336);
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          localObject3 = new MiniAppConfig(localMiniAppInfo);
          ((MiniAppConfig)localObject3).launchParam.scene = paramInt;
          paramInt = getRedDotCount(localMiniAppInfo.appId);
          MiniAppExposureManager.MiniAppModuleExposureData localMiniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject3, "page_view", "expo");
          MiniAppExposureManager.MiniAppRedDotExposureData localMiniAppRedDotExposureData = new MiniAppExposureManager.MiniAppRedDotExposureData((MiniAppConfig)localObject3, "page_view", "expo_scene", paramInt);
          localObject3 = null;
          if (localMiniAppInfo.tianshuAdId > 0) {
            localObject3 = new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", String.valueOf(localMiniAppInfo.tianshuAdId), 101);
          }
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(localMiniAppInfo.appId).append("_").append(localMiniAppInfo.verType).append("_").append(paramDesktopAppInfo.getModuleType());
          localObject4 = ((StringBuilder)localObject4).toString();
          ((MiniAppExposureManager)localObject2).putReportDataToMap((String)localObject4, localMiniAppModuleExposureData);
          ((MiniAppExposureManager)localObject2).putReportDataToMap((String)localObject4 + "_redDot", localMiniAppRedDotExposureData);
          if (localObject3 != null) {
            ((MiniAppExposureManager)localObject2).putReportDataToMap((String)localObject4 + "_tianshu", (MiniAppExposureManager.BaseExposureReport)localObject3);
          }
        }
        if ((localObject1 != null) && (paramDesktopAppInfo.getModuleType() == 2) && (!paramDesktopAppInfo.mMiniAppInfo.isSpecialMiniApp())) {
          ((DesktopDataManager)localObject1).updateRecommendExposureNumber(paramDesktopAppInfo.mMiniAppInfo.appId);
        }
        if (paramMicroAppViewHolder.textView != null) {
          paramMicroAppViewHolder.textView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131166910));
        }
        if ((paramMicroAppViewHolder.imageView instanceof ThemeImageView))
        {
          ((ThemeImageView)paramMicroAppViewHolder.imageView).setSupportMaskView(true);
          paramMicroAppViewHolder.imageView.setBackgroundDrawable(null);
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
              label981:
              if (localMiniAppInfo.topType == 1)
              {
                paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(2));
                break label228;
              }
              paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(1));
              break label228;
              label1018:
              if (localMiniAppInfo.verType == 1)
              {
                paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
                paramMicroAppViewHolder.versionTypeMark.setText(EXPERIENCE);
                break label263;
              }
              paramMicroAppViewHolder.versionTypeMark.setVisibility(8);
              break label263;
              label1060:
              paramMicroAppViewHolder.recommendBadge.setImageDrawable(null);
              break label306;
              label1071:
              paramMicroAppViewHolder.recommendBadge.setVisibility(8);
              break label339;
              label1083:
              paramMicroAppViewHolder.redDot.setVisibility(8);
              break label482;
              label1095:
              if (paramDesktopAppInfo.getModuleType() == 2)
              {
                paramInt = 3002;
                break label494;
              }
              if (paramDesktopAppInfo.getModuleType() != 3) {
                break label1174;
              }
              paramInt = 3003;
              break label494;
            }
          }
          paramMicroAppViewHolder.picCount = localMiniAppInfo.motionPics.size();
        }
        paramMicroAppViewHolder.itemView.setOnClickListener(new MiniAppDesktopAdapter.3(this));
        paramMicroAppViewHolder.itemView.setOnLongClickListener(new MiniAppDesktopAdapter.4(this));
        return;
        localObject2 = null;
      }
      label1174:
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
    } while ((this.mData.get(paramInt) instanceof DesktopEmptyInfo));
    if ((this.mData.get(paramInt) instanceof DesktopEmptyGuideInfo)) {
      return 4;
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
      return new MiniAppDesktopAdapter.ModuleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562186, paramViewGroup, false), (Activity)this.mActivity.get());
    case 2: 
      return new MiniAppDesktopAdapter.MicroAppViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562184, paramViewGroup, false));
    case 3: 
      return new MiniAppDesktopAdapter.MicroAppViewHolder(new View(paramViewGroup.getContext()));
    case 4: 
      return new MiniAppDesktopAdapter.ModuleGuideViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559298, paramViewGroup, false));
    case 5: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559301, paramViewGroup, false);
      return new MiniAppDesktopAdapter.SearchViewHolder(this.mActivity, paramViewGroup);
    case 6: 
      return new MiniAppDesktopAdapter.DesktopModuleListViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559297, paramViewGroup, false), this.mContext, this.mRecyclerView.getDragDeleteListener());
    case 8: 
      return new MiniAppDesktopAdapter.RecommendModuleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559300, paramViewGroup, false));
    case 9: 
      return new MiniAppDesktopAdapter.PopularityListModuleViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559299, paramViewGroup, false));
    case 10: 
      return new MiniAppDesktopAdapter.FriendsPkViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559295, paramViewGroup, false));
    }
    return new MiniAppDesktopAdapter.DittoViewHolder(new DesktopDittoAreaView((Context)this.mActivity.get()));
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
      if ((Math.abs(paramInt1 - (j + m)) <= bdoo.b(20.0F)) && (Math.abs(paramInt2 - (k + n)) <= bdoo.b(20.0F)))
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
    setData(((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).getData());
  }
  
  public void onDesktopClosed()
  {
    this.isDesktopOpened = false;
    QLog.d("MiniAppDesktopAdapter", 2, "onDesktopClosed");
  }
  
  public void onDesktopOpened()
  {
    this.isDesktopOpened = true;
    QLog.d("MiniAppDesktopAdapter", 2, "onDesktopOpened");
    gdtAdReport();
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
          i = paramViewHolder.itemView.getTop() + i + (int)paramFloat2 - bdoo.b(8.0F);
          this.currDragMoveLeft = j;
          this.currDragMoveTop = i;
          ((FrameLayout.LayoutParams)localObject).setMargins(j, i, 0, 0);
          this.mDragMirrorLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        catch (Throwable paramViewHolder)
        {
          try
          {
            if (this.mIntertTarget < 0)
            {
              paramViewHolder = this.mRecyclerView.findViewHolderForAdapterPosition(getItemCount() - 1);
              if ((paramViewHolder != null) && (Math.abs(j - paramViewHolder.itemView.getLeft()) >= bdoo.b(20.0F)) && (i - paramViewHolder.itemView.getTop() >= bdoo.b(30.0F)))
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
        if (this.mIntertTarget > 0)
        {
          k = 1;
          if ((k != 0) && (this.mDragMirrorMarkImage != null)) {
            this.mDragMirrorMarkImage.setVisibility(0);
          }
          if ((Math.abs(j - this.lastDragLeft) > bdoo.b(25.0F)) || (Math.abs(i - this.lastDragTop) > bdoo.b(25.0F)))
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
    label220:
    label240:
    for (;;)
    {
      return;
      int i;
      if (this.mDragMirrorLayout != null)
      {
        i = this.mDragMirrorLayout.getLeft();
        if (this.mDragMirrorLayout == null) {
          break label220;
        }
        j = this.mDragMirrorLayout.getTop();
      }
      for (;;)
      {
        if ((Math.abs(j - this.lastDragMoveLeft) <= bdoo.b(20.0F)) && (Math.abs(j - this.lastDragMoveTop) <= bdoo.b(20.0F))) {
          break label240;
        }
        this.lastDragMoveLeft = i;
        this.lastDragMoveTop = j;
        QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag Moved from " + paramInt1 + " target " + paramInt2 + " dragPos:" + this.mDragViewHolder.getAdapterPosition());
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
    notifyDataSetChanged();
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
    this.mCanShowRedDot = aoom.h();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter
 * JD-Core Version:    0.7.0.1
 */