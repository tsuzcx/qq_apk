package com.tencent.mobileqq.mini.entry;

import agtk;
import ajjy;
import amda;
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
import azzz;
import baay;
import bakh;
import bbmy;
import beih;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.HongBaoResBuilder;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
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
  private static final String DEVELOP = ajjy.a(2131641019);
  private static final String EXPERIENCE = ajjy.a(2131641014);
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
    ThreadManagerV2.excute(new MiniAppEntryAdapter.4(this, localBaseActivity, paramMiniAppInfo), 16, null, true);
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
      localArrayList.add(localResources.getString(2131628631));
      localArrayList.add(localResources.getString(2131628617));
    }
    label55:
    while (paramMiniAppInfo.topType != 1) {
      return localArrayList;
    }
    localArrayList.add(localResources.getString(2131628616));
    localArrayList.add(localResources.getString(2131628617));
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
        if (!azzz.a(paramString, localResources.getString(2131628617))) {
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
      if (azzz.a(paramString, localResources.getString(2131628631)))
      {
        if (((this.mSpecialData != null) || (this.mTopData != null)) && (this.topAppNum >= 11))
        {
          bbmy.a(this.mActivity, "最多仅支持置顶10个小程序", 0).a();
          return;
        }
        setTopMiniApp(paramMiniAppInfo);
        MiniProgramLpReportDC04239.reportDropDown(localMiniAppConfig, str, "settop_on");
        return;
      }
    } while (!azzz.a(paramString, localResources.getString(2131628616)));
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
        paramViewGroup.setImageResource(2130840611);
      }
    }
    return;
    label36:
    paramViewGroup.setImageResource(2130847245);
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
      bakh localbakh = new bakh();
      int i = 0;
      while (i < paramMiniAppInfo.size())
      {
        localbakh.a(paramInt, (String)paramMiniAppInfo.get(i));
        i += 1;
      }
      this.mMenuPop = baay.a(paramView, localbakh, this.onMenuItemSelected, null);
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
    Object localObject3 = MiniAppUtils.getAppInterface();
    Object localObject1;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject1 = (agtk)((AppInterface)localObject3).getManager(342);
      if ((localObject1 == null) || (!((agtk)localObject1).h())) {
        break label769;
      }
      DesktopDataManager localDesktopDataManager = (DesktopDataManager)((AppInterface)localObject3).getManager(336);
      localObject2 = ((agtk)localObject1).a();
      localObject1 = localObject2;
      if (localDesktopDataManager != null)
      {
        localObject1 = localObject2;
        if (localDesktopDataManager.getHongBaoResBuilder() != null) {
          localObject1 = localDesktopDataManager.getHongBaoResBuilder();
        }
      }
      if ((localObject1 != null) && (((DesktopDataManager.HongBaoResBuilder)localObject1).getTextColor() != 2147483647) && (paramMicroAppViewHolder.textView != null)) {
        paramMicroAppViewHolder.textView.setTextColor(((DesktopDataManager.HongBaoResBuilder)localObject1).getTextColor());
      }
      if ((paramMicroAppViewHolder.imageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramMicroAppViewHolder.imageView).setSupportMaskView(false);
      }
    }
    label259:
    label294:
    label341:
    int i;
    if (localMiniAppInfo.isSpecialMiniApp())
    {
      paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(3));
      if ((localMiniAppInfo.verType != 0) && (localMiniAppInfo.verType != 4)) {
        break label856;
      }
      paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
      paramMicroAppViewHolder.versionTypeMark.setText(DEVELOP);
      if (localMiniAppInfo.recommend != 1) {
        break label911;
      }
      paramMicroAppViewHolder.recommendBadge.setVisibility(0);
      if (TextUtils.isEmpty(localMiniAppInfo.recommendAppIconUrl)) {
        break label898;
      }
      paramMicroAppViewHolder.recommendBadge.setImageDrawable(MiniAppUtils.getRecommendIconDrawable(this.mActivity, localMiniAppInfo.recommendAppIconUrl));
      if ((this.topAppNum <= 0) || (paramInt != this.topAppNum - 1) || (this.mData.size() <= this.topAppNum)) {
        break label923;
      }
      paramMicroAppViewHolder.dividerLine.setVisibility(0);
      setDividerLineColor(paramMicroAppViewHolder.dividerLine);
      label390:
      localObject1 = (Integer)this.mRedDotData.get(localMiniAppInfo.appId);
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppEntryAdapter", 1, "onBindViewHolder, canShowRedDot: " + this.mCanShowRedDot + ", redDotNum : " + localObject1 + ", name : " + localMiniAppInfo.name);
      }
      if ((!this.mCanShowRedDot) || (this.mRedDotSwitchState != 1) || (localObject1 == null) || (((Integer)localObject1).intValue() <= 0)) {
        break label935;
      }
      paramMicroAppViewHolder.redDot.setVisibility(0);
      beih.a(paramMicroAppViewHolder.redDot, 7, ((Integer)localObject1).intValue(), 0);
      label520:
      if (localMiniAppInfo.reportData == null) {
        localMiniAppInfo.reportData = new HashMap();
      }
      if (this.mRefer != 0) {
        break label947;
      }
      if (localMiniAppInfo.recommend != 1) {
        break label1170;
      }
      localMiniAppInfo.reportData.put("via", "1001_1");
      i = 1001;
    }
    for (;;)
    {
      localObject1 = null;
      if (localObject3 != null) {
        localObject1 = (MiniAppExposureManager)((AppInterface)localObject3).getManager(322);
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
            localObject3 = new ImageView(this.mActivity);
            ((ImageView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            ((ImageView)localObject3).setImageDrawable(MiniAppUtils.getIcon(this.mActivity, (String)localObject2, true));
            ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER);
            paramMicroAppViewHolder.viewFlipper.addView((View)localObject3);
            continue;
            label769:
            if (paramMicroAppViewHolder.textView != null) {
              paramMicroAppViewHolder.textView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131101267));
            }
            if (!(paramMicroAppViewHolder.imageView instanceof ThemeImageView)) {
              break;
            }
            ((ThemeImageView)paramMicroAppViewHolder.imageView).setSupportMaskView(true);
            break;
            if (localMiniAppInfo.topType == 1)
            {
              paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(2));
              break label259;
            }
            paramMicroAppViewHolder.itemView.setTag(Integer.valueOf(1));
            break label259;
            label856:
            if (localMiniAppInfo.verType == 1)
            {
              paramMicroAppViewHolder.versionTypeMark.setVisibility(0);
              paramMicroAppViewHolder.versionTypeMark.setText(EXPERIENCE);
              break label294;
            }
            paramMicroAppViewHolder.versionTypeMark.setVisibility(8);
            break label294;
            label898:
            paramMicroAppViewHolder.recommendBadge.setImageResource(2130840614);
            break label341;
            label911:
            paramMicroAppViewHolder.recommendBadge.setVisibility(8);
            break label341;
            label923:
            paramMicroAppViewHolder.dividerLine.setVisibility(8);
            break label390;
            label935:
            paramMicroAppViewHolder.redDot.setVisibility(8);
            break label520;
            label947:
            if (this.mRefer == 1)
            {
              if (localMiniAppInfo.recommend == 1) {
                localMiniAppInfo.reportData.put("via", "2006_1");
              }
              for (;;)
              {
                i = 2006;
                break;
                if (localMiniAppInfo.topType == 1) {
                  localMiniAppInfo.reportData.put("via", "2006_2");
                } else {
                  localMiniAppInfo.reportData.put("via", "2006_3");
                }
              }
            }
            if (this.mRefer != 2) {
              break label1170;
            }
            if (localMiniAppInfo.recommend == 1) {
              localMiniAppInfo.reportData.put("via", "2007_1");
            }
            for (;;)
            {
              i = 2007;
              break;
              if (localMiniAppInfo.topType == 1) {
                localMiniAppInfo.reportData.put("via", "2007_2");
              } else {
                localMiniAppInfo.reportData.put("via", "2007_3");
              }
            }
          }
        }
        paramMicroAppViewHolder.picCount = localMiniAppInfo.motionPics.size();
      }
      paramMicroAppViewHolder.itemView.setOnClickListener(new MiniAppEntryAdapter.1(this));
      paramMicroAppViewHolder.itemView.setOnLongClickListener(new MiniAppEntryAdapter.2(this));
      return;
      label1170:
      i = 1001;
    }
  }
  
  public MiniAppEntryAdapter.MicroAppViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new MiniAppEntryAdapter.MicroAppViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496376, paramViewGroup, false));
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
    this.mCanShowRedDot = amda.h();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter
 * JD-Core Version:    0.7.0.1
 */