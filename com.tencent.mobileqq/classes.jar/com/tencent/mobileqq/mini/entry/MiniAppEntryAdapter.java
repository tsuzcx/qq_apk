package com.tencent.mobileqq.mini.entry;

import alud;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.ViewFlipper;
import aoom;
import bdeu;
import bdft;
import bdpi;
import bhvv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MiniAppEntryAdapter
  extends RecyclerView.Adapter<MiniAppEntryAdapter.MicroAppViewHolder>
{
  private static final String DEVELOP = alud.a(2131707199);
  private static final String EXPERIENCE = alud.a(2131707194);
  public static final int REFER_CONTACTS = 1;
  public static final int REFER_CONVERSATION = 0;
  public static final int REFER_LEBA = 2;
  private static final String TAG = "MiniAppEntryAdapter";
  private static final int TYPE_MIMI_APP_SPECIAL = 3;
  private static final int TYPE_MINI_APP_NORMAL = 1;
  private static final int TYPE_MINI_APP_TOP = 2;
  private Activity mActivity;
  private MiniAppEntryAdapter.OnAnimationListener mAnimListener;
  private boolean mCanShowRedDot;
  private List<MiniAppInfo> mData = new ArrayList();
  protected BubblePopupWindow mMenuPop;
  private Map<String, Integer> mRedDotData = new HashMap();
  private int mRedDotSwitchState;
  private int mRefer = 0;
  private List<MiniAppInfo> mSpecialData = new ArrayList();
  private List<MiniAppInfo> mTopData = new ArrayList();
  View.OnClickListener onMenuItemSelected = new MiniAppEntryAdapter.3(this);
  private int topAppNum;
  
  public MiniAppEntryAdapter(Activity paramActivity, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mRefer = paramInt;
  }
  
  private void deleteMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppEntryAdapter", 2, "deleteMiniApp, delete miniAppInfo: " + paramMiniAppInfo.toString());
    }
    BaseActivity localBaseActivity = (BaseActivity)this.mActivity;
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)localBaseActivity.app.getManager(309);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendDelUserAppRequest(paramMiniAppInfo);
    }
    MiniCacheFreeManager.freeCache(localBaseActivity.app.c(), paramMiniAppInfo);
  }
  
  private List<String> getMenuItems(MiniAppInfo paramMiniAppInfo)
  {
    Resources localResources = this.mActivity.getResources();
    ArrayList localArrayList = new ArrayList();
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.topType != 0) {
        break label55;
      }
      localArrayList.add(localResources.getString(2131694433));
      localArrayList.add(localResources.getString(2131694407));
    }
    label55:
    while (paramMiniAppInfo.topType != 1) {
      return localArrayList;
    }
    localArrayList.add(localResources.getString(2131694406));
    localArrayList.add(localResources.getString(2131694407));
    return localArrayList;
  }
  
  private int getRedDotCount(String paramString)
  {
    paramString = (Integer)this.mRedDotData.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private void onMenuItemClick(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    Resources localResources = this.mActivity.getResources();
    String str = "message";
    int i = 1001;
    if (this.mRefer == 1) {
      str = "contact";
    }
    MiniAppConfig localMiniAppConfig;
    do
    {
      i = 2006;
      for (;;)
      {
        localMiniAppConfig = new MiniAppConfig(paramMiniAppInfo);
        localMiniAppConfig.launchParam.scene = i;
        if (!bdeu.a(paramString, localResources.getString(2131694407))) {
          break;
        }
        deleteMiniApp(paramMiniAppInfo);
        MiniProgramLpReportDC04239.reportDropDown(localMiniAppConfig, str, "delete");
        return;
        if (this.mRefer == 2)
        {
          str = "more";
          i = 2007;
        }
      }
      if (bdeu.a(paramString, localResources.getString(2131694433)))
      {
        if (((this.mSpecialData != null) || (this.mTopData != null)) && (this.topAppNum >= 11))
        {
          QQToast.a(this.mActivity, "最多仅支持置顶10个小程序", 0).a();
          return;
        }
        setTopMiniApp(paramMiniAppInfo);
        MiniProgramLpReportDC04239.reportDropDown(localMiniAppConfig, str, "settop_on");
        return;
      }
    } while (!bdeu.a(paramString, localResources.getString(2131694406)));
    setTopMiniApp(paramMiniAppInfo);
    MiniProgramLpReportDC04239.reportDropDown(localMiniAppConfig, str, "settop_off");
  }
  
  private void setAnimationListener(MiniAppEntryAdapter.OnAnimationListener paramOnAnimationListener)
  {
    this.mAnimListener = paramOnAnimationListener;
  }
  
  private void setDividerLineColor(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      paramViewGroup = paramViewGroup.getChildAt(0);
      if ((paramViewGroup instanceof ImageView))
      {
        paramViewGroup = (ImageView)paramViewGroup;
        if (!MiniAppUtils.isNightMode()) {
          break label36;
        }
        paramViewGroup.setImageResource(2130840757);
      }
    }
    return;
    label36:
    paramViewGroup.setImageResource(2130847922);
  }
  
  private void setTopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppEntryAdapter", 2, "setTopMiniApp, miniAppInfo: " + paramMiniAppInfo.toString());
    }
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)((BaseActivity)this.mActivity).app.getManager(309);
    if (localMiniAppUserAppInfoListManager != null)
    {
      if (paramMiniAppInfo.topType != 0) {
        break label81;
      }
      paramMiniAppInfo.topType = 1;
      paramMiniAppInfo.updateTimeStamp();
    }
    for (;;)
    {
      localMiniAppUserAppInfoListManager.sendSetUserAppTopRequest(paramMiniAppInfo);
      return;
      label81:
      paramMiniAppInfo.topType = 0;
    }
  }
  
  private static void updateMiniAppStorePlayAnimationTime()
  {
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.getPreferences().edit().putLong("key_mini_app_store_show_animation_time", System.currentTimeMillis()).apply();
    }
  }
  
  public int getItemCount()
  {
    if ((this.mData == null) || (this.mData.size() == 0)) {
      return 1;
    }
    return this.mData.size();
  }
  
  public MiniAppInfo getItemForPosition(int paramInt)
  {
    if ((paramInt < this.mData.size()) && (paramInt >= 0)) {
      return (MiniAppInfo)this.mData.get(paramInt);
    }
    return null;
  }
  
  public Map<String, Integer> getRedDotDataMap()
  {
    return this.mRedDotData;
  }
  
  public void handleLongClick(View paramView, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    paramMiniAppInfo = getMenuItems(paramMiniAppInfo);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.size() > 0))
    {
      bdpi localbdpi = new bdpi();
      int i = 0;
      while (i < paramMiniAppInfo.size())
      {
        localbdpi.a(paramInt, (String)paramMiniAppInfo.get(i));
        i += 1;
      }
      this.mMenuPop = bdft.a(paramView, localbdpi, this.onMenuItemSelected, null);
    }
  }
  
  public void onBindViewHolder(MiniAppEntryAdapter.MicroAppViewHolder paramMicroAppViewHolder, int paramInt)
  {
    if (this.mData.size() <= 0)
    {
      QLog.e("MiniAppEntryAdapter", 1, "[MiniAppUserAppInfoListManager].onBindViewHolder, size = " + this.mData.size());
      return;
    }
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)this.mData.get(paramInt);
    paramMicroAppViewHolder.imageView.setImageDrawable(MiniAppUtils.getIcon(this.mActivity, localMiniAppInfo.iconUrl, true));
    paramMicroAppViewHolder.textView.setText(localMiniAppInfo.name);
    paramMicroAppViewHolder.setMiniAppInfo(localMiniAppInfo);
    Object localObject2 = MiniAppUtils.getAppInterface();
    if (localObject2 != null)
    {
      if (paramMicroAppViewHolder.textView != null) {
        paramMicroAppViewHolder.textView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131166910));
      }
      if ((paramMicroAppViewHolder.imageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramMicroAppViewHolder.imageView).setSupportMaskView(true);
      }
    }
    label211:
    Object localObject1;
    label258:
    label307:
    label437:
    int i;
    if (localMiniAppInfo.isSpecialMiniApp())
    {
      paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(3));
      if ((localMiniAppInfo.verType != 0) && (localMiniAppInfo.verType != 4)) {
        break label694;
      }
      paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
      paramMicroAppViewHolder.versionTypeMark.setText(DEVELOP);
      if (localMiniAppInfo.recommend != 1) {
        break label749;
      }
      paramMicroAppViewHolder.recommendBadge.setVisibility(0);
      if (TextUtils.isEmpty(localMiniAppInfo.recommendAppIconUrl)) {
        break label736;
      }
      paramMicroAppViewHolder.recommendBadge.setImageDrawable(MiniAppUtils.getRecommendIconDrawable(this.mActivity, localMiniAppInfo.recommendAppIconUrl));
      if ((this.topAppNum <= 0) || (paramInt != this.topAppNum - 1) || (this.mData.size() <= this.topAppNum)) {
        break label761;
      }
      paramMicroAppViewHolder.dividerLine.setVisibility(0);
      setDividerLineColor(paramMicroAppViewHolder.dividerLine);
      localObject1 = (Integer)this.mRedDotData.get(localMiniAppInfo.appId);
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppEntryAdapter", 1, "onBindViewHolder, canShowRedDot: " + this.mCanShowRedDot + ", redDotNum : " + localObject1 + ", name : " + localMiniAppInfo.name);
      }
      if ((!this.mCanShowRedDot) || (this.mRedDotSwitchState != 1) || (localObject1 == null) || (((Integer)localObject1).intValue() <= 0)) {
        break label773;
      }
      paramMicroAppViewHolder.redDot.setVisibility(0);
      bhvv.a(paramMicroAppViewHolder.redDot, 7, ((Integer)localObject1).intValue(), 0);
      if (this.mRefer != 0) {
        break label785;
      }
      if (localMiniAppInfo.recommend != 1) {
        break label954;
      }
      localMiniAppInfo.via = "1001_1";
      i = 1001;
    }
    for (;;)
    {
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = (MiniAppExposureManager)((AppInterface)localObject2).getManager(322);
      }
      if (localObject1 != null)
      {
        localObject2 = new MiniAppConfig(localMiniAppInfo);
        ((MiniAppConfig)localObject2).launchParam.scene = i;
        ((MiniAppExposureManager)localObject1).addReportItem(new MiniAppExposureManager.MiniAppExposureData((MiniAppConfig)localObject2, paramInt, String.valueOf(getRedDotCount(localMiniAppInfo.appId))));
      }
      if ((localMiniAppInfo.motionPics != null) && (localMiniAppInfo.motionPics.size() > 0))
      {
        setAnimationListener(paramMicroAppViewHolder);
        localObject1 = localMiniAppInfo.motionPics.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            ImageView localImageView = new ImageView(this.mActivity);
            localImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            localImageView.setImageDrawable(MiniAppUtils.getIcon(this.mActivity, (String)localObject2, true));
            localImageView.setScaleType(ImageView.ScaleType.CENTER);
            paramMicroAppViewHolder.viewFlipper.addView(localImageView);
            continue;
            if (localMiniAppInfo.topType == 1)
            {
              paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(2));
              break;
            }
            paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(1));
            break;
            label694:
            if (localMiniAppInfo.verType == 1)
            {
              paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
              paramMicroAppViewHolder.versionTypeMark.setText(EXPERIENCE);
              break label211;
            }
            paramMicroAppViewHolder.versionTypeMark.setVisibility(8);
            break label211;
            label736:
            paramMicroAppViewHolder.recommendBadge.setImageResource(2130840760);
            break label258;
            label749:
            paramMicroAppViewHolder.recommendBadge.setVisibility(8);
            break label258;
            label761:
            paramMicroAppViewHolder.dividerLine.setVisibility(8);
            break label307;
            label773:
            paramMicroAppViewHolder.redDot.setVisibility(8);
            break label437;
            label785:
            if (this.mRefer == 1)
            {
              if (localMiniAppInfo.recommend == 1) {
                localMiniAppInfo.via = "2006_1";
              }
              for (;;)
              {
                i = 2006;
                break;
                if (localMiniAppInfo.topType == 1) {
                  localMiniAppInfo.via = "2006_2";
                } else {
                  localMiniAppInfo.via = "2006_3";
                }
              }
            }
            if (this.mRefer != 2) {
              break label954;
            }
            if (localMiniAppInfo.recommend == 1) {
              localMiniAppInfo.via = "2007_1";
            }
            for (;;)
            {
              i = 2007;
              break;
              if (localMiniAppInfo.topType == 1) {
                localMiniAppInfo.via = "2007_2";
              } else {
                localMiniAppInfo.via = "2007_3";
              }
            }
          }
        }
        paramMicroAppViewHolder.picCount = localMiniAppInfo.motionPics.size();
      }
      paramMicroAppViewHolder.itemView.setOnClickListener(new MiniAppEntryAdapter.1(this));
      paramMicroAppViewHolder.itemView.setOnLongClickListener(new MiniAppEntryAdapter.2(this));
      return;
      label954:
      i = 1001;
    }
  }
  
  public MiniAppEntryAdapter.MicroAppViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new MiniAppEntryAdapter.MicroAppViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562184, paramViewGroup, false));
  }
  
  public void setData(List<MiniAppInfo> paramList, Map<String, Integer> paramMap)
  {
    this.mData.clear();
    this.mTopData.clear();
    this.mSpecialData.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniAppEntryAdapter", 2, "setData. data = " + paramList);
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramList.next();
      if (localMiniAppInfo.isSpecialMiniApp())
      {
        if (localMiniAppInfo.topType != 1) {
          localMiniAppInfo.topType = 1;
        }
        this.mSpecialData.add(localMiniAppInfo);
      }
      else if (localMiniAppInfo.topType == 1)
      {
        this.mTopData.add(localMiniAppInfo);
      }
      else
      {
        localArrayList.add(localMiniAppInfo);
      }
    }
    this.mData.addAll(this.mSpecialData);
    this.mData.addAll(this.mTopData);
    this.mData.addAll(localArrayList);
    this.topAppNum = (this.mSpecialData.size() + this.mTopData.size());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter
 * JD-Core Version:    0.7.0.1
 */