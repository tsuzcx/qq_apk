package com.tencent.mobileqq.mini.entry;

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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MiniAppEntryAdapter
  extends RecyclerView.Adapter<MiniAppEntryAdapter.MicroAppViewHolder>
{
  private static final String DEVELOP = HardCodeUtil.a(2131904688);
  private static final String EXPERIENCE = HardCodeUtil.a(2131904683);
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
  private int topAppNum = 0;
  
  public MiniAppEntryAdapter(Activity paramActivity, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mRefer = paramInt;
  }
  
  private void deleteMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteMiniApp, delete miniAppInfo: ");
      ((StringBuilder)localObject).append(paramMiniAppInfo.toString());
      QLog.i("MiniAppEntryAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (BaseActivity)this.mActivity;
    MiniAppUserAppInfoListManager localMiniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager)((BaseActivity)localObject).app.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
    if (localMiniAppUserAppInfoListManager != null) {
      localMiniAppUserAppInfoListManager.sendDelUserAppRequest(paramMiniAppInfo);
    }
    MiniCacheFreeManager.freeCache(((BaseActivity)localObject).app.getCurrentUin(), paramMiniAppInfo);
  }
  
  private List<String> getMenuItems(MiniAppInfo paramMiniAppInfo)
  {
    Resources localResources = this.mActivity.getResources();
    ArrayList localArrayList = new ArrayList();
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.topType == 0)
      {
        localArrayList.add(localResources.getString(2131891803));
        localArrayList.add(localResources.getString(2131891747));
        return localArrayList;
      }
      if (paramMiniAppInfo.topType == 1)
      {
        localArrayList.add(localResources.getString(2131891746));
        localArrayList.add(localResources.getString(2131891747));
      }
    }
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
    int i = this.mRefer;
    String str;
    if (i == 1)
    {
      i = 2006;
      str = "contact";
    }
    else if (i == 2)
    {
      i = 2007;
      str = "more";
    }
    else
    {
      str = "message";
      i = 1001;
    }
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(paramMiniAppInfo);
    localMiniAppConfig.launchParam.scene = i;
    if (Utils.a(paramString, localResources.getString(2131891747)))
    {
      deleteMiniApp(paramMiniAppInfo);
      MiniProgramLpReportDC04239.reportDropDown(localMiniAppConfig, str, "delete");
      return;
    }
    if (Utils.a(paramString, localResources.getString(2131891803)))
    {
      if (((this.mSpecialData != null) || (this.mTopData != null)) && (this.topAppNum >= 11))
      {
        QQToast.makeText(this.mActivity, "最多仅支持置顶10个小程序", 0).show();
        return;
      }
      setTopMiniApp(paramMiniAppInfo);
      MiniProgramLpReportDC04239.reportDropDown(localMiniAppConfig, str, "settop_on");
      return;
    }
    if (Utils.a(paramString, localResources.getString(2131891746)))
    {
      setTopMiniApp(paramMiniAppInfo);
      MiniProgramLpReportDC04239.reportDropDown(localMiniAppConfig, str, "settop_off");
    }
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
        if (MiniAppUtils.isNightMode())
        {
          paramViewGroup.setImageResource(2130841835);
          return;
        }
        paramViewGroup.setImageResource(2130850321);
      }
    }
  }
  
  private void setTopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTopMiniApp, miniAppInfo: ");
      ((StringBuilder)localObject).append(paramMiniAppInfo.toString());
      QLog.i("MiniAppEntryAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (MiniAppUserAppInfoListManager)((BaseActivity)this.mActivity).app.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
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
  
  private static void updateMiniAppStorePlayAnimationTime()
  {
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.getPreferences().edit().putLong("key_mini_app_store_show_animation_time", System.currentTimeMillis()).apply();
    }
  }
  
  public int getItemCount()
  {
    List localList = this.mData;
    if ((localList != null) && (localList.size() != 0)) {
      return this.mData.size();
    }
    return 1;
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
      QQCustomMenu localQQCustomMenu = new QQCustomMenu();
      int i = 0;
      while (i < paramMiniAppInfo.size())
      {
        localQQCustomMenu.a(paramInt, (String)paramMiniAppInfo.get(i));
        i += 1;
      }
      this.mMenuPop = BubbleContextMenu.a(paramView, localQQCustomMenu, this.onMenuItemSelected, null);
    }
  }
  
  public void onBindViewHolder(MiniAppEntryAdapter.MicroAppViewHolder paramMicroAppViewHolder, int paramInt)
  {
    if (this.mData.size() <= 0)
    {
      paramMicroAppViewHolder = new StringBuilder();
      paramMicroAppViewHolder.append("[MiniAppUserAppInfoListManager].onBindViewHolder, size = ");
      paramMicroAppViewHolder.append(this.mData.size());
      QLog.e("MiniAppEntryAdapter", 1, paramMicroAppViewHolder.toString());
      return;
    }
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)this.mData.get(paramInt);
    paramMicroAppViewHolder.imageView.setImageDrawable(MiniAppUtils.getIcon(this.mActivity, localMiniAppInfo.iconUrl, true));
    paramMicroAppViewHolder.textView.setText(localMiniAppInfo.name);
    paramMicroAppViewHolder.setMiniAppInfo(localMiniAppInfo);
    Object localObject2 = MiniAppUtils.getAppInterface();
    if (localObject2 != null)
    {
      paramMicroAppViewHolder.textView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131168001));
      if ((paramMicroAppViewHolder.imageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramMicroAppViewHolder.imageView).setSupportMaskView(true);
      }
    }
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
    if (localMiniAppInfo.recommend == 1)
    {
      paramMicroAppViewHolder.recommendBadge.setVisibility(0);
      if (!TextUtils.isEmpty(localMiniAppInfo.recommendAppIconUrl)) {
        paramMicroAppViewHolder.recommendBadge.setImageDrawable(MiniAppUtils.getRecommendIconDrawable(this.mActivity, localMiniAppInfo.recommendAppIconUrl));
      } else {
        paramMicroAppViewHolder.recommendBadge.setImageResource(2130841840);
      }
    }
    else
    {
      paramMicroAppViewHolder.recommendBadge.setVisibility(8);
    }
    int i = this.topAppNum;
    if ((i > 0) && (paramInt == i - 1) && (this.mData.size() > this.topAppNum))
    {
      paramMicroAppViewHolder.dividerLine.setVisibility(0);
      setDividerLineColor(paramMicroAppViewHolder.dividerLine);
    }
    else
    {
      paramMicroAppViewHolder.dividerLine.setVisibility(8);
    }
    Object localObject1 = (Integer)this.mRedDotData.get(localMiniAppInfo.appId);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onBindViewHolder, canShowRedDot: ");
      ((StringBuilder)localObject3).append(this.mCanShowRedDot);
      ((StringBuilder)localObject3).append(", redDotNum : ");
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append(", name : ");
      ((StringBuilder)localObject3).append(localMiniAppInfo.name);
      QLog.d("MiniAppEntryAdapter", 1, ((StringBuilder)localObject3).toString());
    }
    if ((this.mCanShowRedDot) && (this.mRedDotSwitchState == 1) && (localObject1 != null) && (((Integer)localObject1).intValue() > 0))
    {
      paramMicroAppViewHolder.redDot.setVisibility(0);
      CustomWidgetUtil.a(paramMicroAppViewHolder.redDot, 7, ((Integer)localObject1).intValue(), 0);
    }
    else
    {
      paramMicroAppViewHolder.redDot.setVisibility(8);
    }
    int j = 1001;
    int k = this.mRefer;
    if (k == 0)
    {
      i = j;
      if (localMiniAppInfo.recommend == 1)
      {
        localMiniAppInfo.via = "1001_1";
        i = j;
      }
    }
    else if (k == 1)
    {
      if (localMiniAppInfo.recommend == 1) {
        localMiniAppInfo.via = "2006_1";
      } else if (localMiniAppInfo.topType == 1) {
        localMiniAppInfo.via = "2006_2";
      } else {
        localMiniAppInfo.via = "2006_3";
      }
      i = 2006;
    }
    else
    {
      i = j;
      if (k == 2)
      {
        if (localMiniAppInfo.recommend == 1) {
          localMiniAppInfo.via = "2007_1";
        } else if (localMiniAppInfo.topType == 1) {
          localMiniAppInfo.via = "2007_2";
        } else {
          localMiniAppInfo.via = "2007_3";
        }
        i = 2007;
      }
    }
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = (MiniAppExposureManager)((AppInterface)localObject2).getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
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
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = new ImageView(this.mActivity);
        ((ImageView)localObject3).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ((ImageView)localObject3).setImageDrawable(MiniAppUtils.getIcon(this.mActivity, (String)localObject2, true));
        ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER);
        paramMicroAppViewHolder.viewFlipper.addView((View)localObject3);
      }
      paramMicroAppViewHolder.picCount = localMiniAppInfo.motionPics.size();
    }
    paramMicroAppViewHolder.itemView.setOnClickListener(new MiniAppEntryAdapter.1(this));
    paramMicroAppViewHolder.itemView.setOnLongClickListener(new MiniAppEntryAdapter.2(this));
  }
  
  public MiniAppEntryAdapter.MicroAppViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new MiniAppEntryAdapter.MicroAppViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628809, paramViewGroup, false));
  }
  
  public void setData(List<MiniAppInfo> paramList, Map<String, Integer> paramMap)
  {
    this.mData.clear();
    this.mTopData.clear();
    this.mSpecialData.clear();
    if ((paramList != null) && (paramList.size() != 0))
    {
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
      this.mCanShowRedDot = MiniAppConfProcessor.g();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("setData. data = ");
      paramMap.append(paramList);
      QLog.i("MiniAppEntryAdapter", 2, paramMap.toString());
    }
  }
  
  public void setRedDotSwitchState(int paramInt)
  {
    this.mRedDotSwitchState = paramInt;
  }
  
  public void startAnimation()
  {
    MiniAppEntryAdapter.OnAnimationListener localOnAnimationListener = this.mAnimListener;
    if (localOnAnimationListener != null) {
      localOnAnimationListener.startAnimation();
    }
  }
  
  public void stopAnimation()
  {
    MiniAppEntryAdapter.OnAnimationListener localOnAnimationListener = this.mAnimListener;
    if (localOnAnimationListener != null) {
      localOnAnimationListener.stopAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter
 * JD-Core Version:    0.7.0.1
 */