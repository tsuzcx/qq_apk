package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import QQService.PrivilegeInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.ProfileURLDrawableDownListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ProfileDiamondWallComponent
  extends AbsQQProfileContentComponent
{
  public static final int ANIMATOR_DENSITY = 500;
  public static final String REMIND_TIME = "iRemindTime";
  public static final int SHOW_ANIMATOR = 1;
  private static final String SP_ICON_TWINKLE = "sp_icon_twinkle";
  private static final String SP_SHOW_POP_BEGIN_TIME = "sp_show_pop_begin_time";
  private static final String TAG = "ProfileDiamondWallComponent";
  public static final String TIPS_TIMES = "iTipsTimes";
  private AnimatorHandler handler = new AnimatorHandler();
  private int isMedalExposure = 0;
  private float mDensity;
  private float mItemInfoWidth;
  View.OnClickListener mOnClickListener = new ProfileDiamondWallComponent.1(this);
  
  public ProfileDiamondWallComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private int attachMetalImageItemToContainer(List<PrivilegeInfo> paramList, LinearLayout paramLinearLayout, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, Drawable paramDrawable, boolean paramBoolean)
  {
    int i = 0;
    int k = 0;
    while (k < paramList.size())
    {
      PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)paramList.get(k);
      int j = i;
      if (!TextUtils.isEmpty(localPrivilegeInfo.strDeluxeIconUrl))
      {
        if (i == 0) {
          j = 0;
        } else {
          j = paramInt1;
        }
        i += 1;
        paramArrayOfInt[0] = (paramArrayOfInt[0] - paramInt2 - j);
        if (paramArrayOfInt[0] < 0)
        {
          paramInt1 = i;
          if (!QLog.isColorLevel()) {
            return paramInt1;
          }
          paramList = new StringBuilder();
          paramList.append("medal list layout is big =");
          paramList.append(localPrivilegeInfo.iIsBig);
          paramList.append(" icon index=");
          paramList.append(i);
          QLog.d("ProfileDiamondWallComponent", 1, paramList.toString());
          return i;
        }
        attachMetalImageToContainer(localPrivilegeInfo, localPrivilegeInfo.strDeluxeIconUrl, paramLinearLayout, paramInt2, paramInt3, j, paramDrawable, paramBoolean);
        j = i;
      }
      i = j;
      if (!TextUtils.isEmpty(localPrivilegeInfo.strIconUrl))
      {
        if (j == 0) {
          i = 0;
        } else {
          i = paramInt1;
        }
        j += 1;
        paramArrayOfInt[0] = (paramArrayOfInt[0] - paramInt2 - i);
        if (paramArrayOfInt[0] < 0)
        {
          if (QLog.isColorLevel())
          {
            paramList = new StringBuilder();
            paramList.append("medal list layout is big =");
            paramList.append(localPrivilegeInfo.iIsBig);
            paramList.append(" icon index=");
            paramList.append(j);
            QLog.d("ProfileDiamondWallComponent", 1, paramList.toString());
          }
          return j;
        }
        attachMetalImageToContainer(localPrivilegeInfo, localPrivilegeInfo.strIconUrl, paramLinearLayout, paramInt2, paramInt3, i, paramDrawable, paramBoolean);
        i = j;
      }
      k += 1;
    }
    paramInt1 = i;
    return paramInt1;
  }
  
  private void attachMetalImageToContainer(PrivilegeInfo paramPrivilegeInfo, String paramString, LinearLayout paramLinearLayout, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, boolean paramBoolean)
  {
    paramString = generateMedalLinerLayout(paramPrivilegeInfo, paramString, paramInt1, paramInt2, paramInt3, paramDrawable);
    paramLinearLayout.addView(paramString);
    if (!TextUtils.isEmpty(paramPrivilegeInfo.strJumpUrl))
    {
      paramString.setClickable(true);
      paramString.setTag(new DataTag(93, paramPrivilegeInfo));
      paramString.setOnClickListener(this.mOnClickListener);
    }
    else
    {
      paramString.setTag(null);
      paramString.setOnClickListener(null);
      paramString.setClickable(false);
    }
    paramLinearLayout = new StringBuilder();
    setDescription(paramLinearLayout, paramPrivilegeInfo);
    paramLinearLayout.append("徽章");
    paramString.setContentDescription(paramLinearLayout);
    reportClickEvent(paramPrivilegeInfo, getActionNameString(paramPrivilegeInfo, paramBoolean, ""));
  }
  
  private View generateMedalImageView(PrivilegeInfo paramPrivilegeInfo, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, Drawable paramDrawable)
  {
    URLImageView localURLImageView = new URLImageView(this.mActivity);
    Object localObject = new LinearLayout.LayoutParams((int)paramFloat1, (int)paramFloat2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)paramFloat3);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramDrawable = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, paramDrawable);
    if (paramDrawable != null)
    {
      ProfileCardUtils.setNightModeFilterForImageView((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), localURLImageView);
      if (paramDrawable.getStatus() == 2)
      {
        localURLImageView.setVisibility(8);
        paramDrawable.restartDownload();
      }
      if ((!TextUtils.isEmpty(paramPrivilegeInfo.strTipsIconUrl)) && ((paramDrawable.getCurrDrawable() instanceof ApngDrawable)))
      {
        localObject = ((ApngDrawable)paramDrawable.getCurrDrawable()).getImage();
        ((ApngImage)localObject).apngLoop = paramPrivilegeInfo.iTipsTimes;
        ((ApngImage)localObject).setDensity(500);
      }
      localURLImageView.setImageDrawable(paramDrawable);
      localURLImageView.setURLDrawableDownListener(new ProfileURLDrawableDownListener(localURLImageView, paramString, "showDiamondImage onLoadFailed iconUrl = "));
      return localURLImageView;
    }
    paramPrivilegeInfo = new StringBuilder();
    paramPrivilegeInfo.append("apn drawable get null!iconUrl:");
    paramPrivilegeInfo.append(paramString);
    QLog.e("QVipSettingMe.ProfileDiamondWallComponent", 1, paramPrivilegeInfo.toString());
    return localURLImageView;
  }
  
  private View generateMedalLinerLayout(PrivilegeInfo paramPrivilegeInfo, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, Drawable paramDrawable)
  {
    int i = VipInfoHandler.a(this.mQQAppInterface, this.mApp.getCurrentUin(), false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("generateMedalLinerLayout , info.strTipsIconUrl: %s info.iRemindTime: %s info.iTipsTimes: %s info.iIsRemind: %s", new Object[] { paramPrivilegeInfo.strTipsIconUrl, Integer.valueOf(paramPrivilegeInfo.iRemindTime), Integer.valueOf(paramPrivilegeInfo.iTipsTimes), Integer.valueOf(paramPrivilegeInfo.iIsRemind) }));
    }
    LinearLayout localLinearLayout = new LinearLayout(this.mActivity);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    Object localObject = paramPrivilegeInfo.strTipsIconUrl;
    if ((paramPrivilegeInfo.iIsRemind != 0) && (isNeedShowPop(paramPrivilegeInfo.iRemindTime, paramPrivilegeInfo.iType)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      float f = paramFloat2 / 2.0F;
      localLinearLayout.addView(generateMedalImageView(paramPrivilegeInfo, (String)localObject, paramFloat1, f, paramFloat3, paramDrawable));
      localLayoutParams.topMargin = ((int)-f);
      if (paramPrivilegeInfo.iType == 1) {
        reportAction("0X800B27B", i);
      }
    }
    paramString = generateMedalImageView(paramPrivilegeInfo, paramString, paramFloat1, paramFloat2, paramFloat3, paramDrawable);
    if (paramPrivilegeInfo.iIsRemind != 0)
    {
      this.handler.removeMessages(paramPrivilegeInfo.iType);
      paramDrawable = Message.obtain();
      paramDrawable.what = paramPrivilegeInfo.iType;
      paramDrawable.obj = paramString;
      paramDrawable.arg1 = 1;
      localObject = new Bundle();
      ((Bundle)localObject).putLong("iRemindTime", paramPrivilegeInfo.iRemindTime);
      ((Bundle)localObject).putInt("iTipsTimes", paramPrivilegeInfo.iTipsTimes);
      paramDrawable.setData((Bundle)localObject);
      this.handler.sendMessageDelayed(paramDrawable, 500L);
      if (paramPrivilegeInfo.iType == 1) {
        reportAction("0X800B27D", i);
      }
    }
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(paramString);
    return localLinearLayout;
  }
  
  private String getActionNameByType(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((this.isMedalExposure & paramInt) == 0)
    {
      if (paramBoolean) {
        paramString1 = paramString2;
      } else {
        paramString1 = paramString3;
      }
      this.isMedalExposure |= paramInt;
    }
    return paramString1;
  }
  
  private String getActionNameString(PrivilegeInfo paramPrivilegeInfo, boolean paramBoolean, String paramString)
  {
    int i = paramPrivilegeInfo.iType;
    if (i != 1)
    {
      if (i != 102)
      {
        if (i != 113) {
          return getActionNameByType(paramBoolean, paramString, 8, "0X800A136", "0X800A12E");
        }
        return getActionNameByType(paramBoolean, paramString, 4, "0X800A130", "0X800A128");
      }
      return getActionNameByType(paramBoolean, paramString, 2, "0X800A134", "0X800A12C");
    }
    return getActionNameByType(paramBoolean, paramString, 1, "0X800A132", "0X800A12A");
  }
  
  private boolean isNeedShowPop(long paramLong, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_icon_twinkle", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_show_pop_begin_time");
    localStringBuilder.append(paramInt);
    return paramLong != localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  private void reportAction(String paramString, int paramInt)
  {
    ReportController.b(this.mApp, "dc00898", "", this.mApp.getCurrentUin(), paramString, paramString, paramInt, 0, String.valueOf(paramInt), "", "", "");
  }
  
  private void reportClickEvent(PrivilegeInfo paramPrivilegeInfo, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i;
      if (paramPrivilegeInfo.iIsBig == 1)
      {
        if (paramPrivilegeInfo.isOpen) {
          i = 1;
        } else {
          i = 2;
        }
      }
      else if (paramPrivilegeInfo.isOpen) {
        i = 3;
      } else {
        i = 4;
      }
      if ((paramPrivilegeInfo.iType != 1) && (!paramString.equals("0X800A136"))) {
        paramPrivilegeInfo = "";
      } else {
        paramPrivilegeInfo = String.valueOf(VipInfoHandler.a(this.mQQAppInterface, this.mApp.getCurrentUin(), false));
      }
      ReportController.b(this.mApp, "dc00898", "", "", "qvip", paramString, i, 0, paramPrivilegeInfo, "", "", "");
    }
  }
  
  public static void saveShowPopTime(long paramLong, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("sp_icon_twinkle", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_show_pop_begin_time");
    localStringBuilder.append(paramInt);
    localEditor.putLong(localStringBuilder.toString(), paramLong).apply();
  }
  
  private void setDescription(StringBuilder paramStringBuilder, PrivilegeInfo paramPrivilegeInfo)
  {
    if (paramPrivilegeInfo == null) {
      return;
    }
    int i = paramPrivilegeInfo.iType;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 113)
              {
                switch (i)
                {
                default: 
                  return;
                case 105: 
                  paramStringBuilder.append("超级星钻");
                  return;
                case 104: 
                  paramStringBuilder.append("情侣黄钻");
                  return;
                case 103: 
                  paramStringBuilder.append("绿钻");
                  return;
                case 102: 
                  paramStringBuilder.append("黄钻");
                  return;
                }
                paramStringBuilder.append("红钻");
                return;
              }
              paramStringBuilder.append("大会员");
              return;
            }
            paramStringBuilder.append("腾讯图书VIP");
            return;
          }
          paramStringBuilder.append("好莱坞会员");
          return;
        }
        paramStringBuilder.append("超级会员");
        return;
      }
      paramStringBuilder.append("超级QQ");
      return;
    }
    paramStringBuilder.append("会员");
  }
  
  private void setDescription(StringBuilder paramStringBuilder, List<PrivilegeInfo> paramList)
  {
    if (paramStringBuilder != null)
    {
      if (paramList == null) {
        return;
      }
      int i = 0;
      while (i < paramList.size())
      {
        setDescription(paramStringBuilder, (PrivilegeInfo)paramList.get(i));
        i += 1;
      }
    }
  }
  
  private void showDiamondImage(List<PrivilegeInfo> paramList, LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    float f4 = this.mDensity;
    float f5 = f4 * 20.0F;
    float f6 = f4 * 20.0F;
    float f2 = f4 * 2.0F;
    float f7 = f4 * 5.0F;
    float f3 = f4 * 6.0F;
    float f1 = f4 * 8.0F;
    float f8 = f4 * 36.0F;
    if ((paramLinearLayout != null) && (paramList != null))
    {
      if (paramList.size() < 1) {
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      int j;
      while (i < paramList.size())
      {
        localObject = (PrivilegeInfo)paramList.get(i);
        if (((PrivilegeInfo)localObject).iIsBig == 1) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0) {
          localArrayList1.add(localObject);
        } else {
          localArrayList2.add(localObject);
        }
        i += 1;
      }
      ColorDrawable localColorDrawable = new ColorDrawable(16777215);
      Object localObject = new LinearLayout(this.mActivity);
      LinearLayout localLinearLayout = new LinearLayout(this.mActivity);
      paramList = new LinearLayout.LayoutParams(-2, -2);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout)localObject).setOrientation(0);
      ((LinearLayout)localObject).setLayoutParams(paramList);
      localLinearLayout.setOrientation(0);
      localLinearLayout.setLayoutParams(localLayoutParams);
      int[] arrayOfInt = new int[1];
      if (QzoneConfig.getInstance().getConfig("qqsetting", "usersummarycardmedalicon", 0) == 0) {
        i = 1;
      } else {
        i = 0;
      }
      int k;
      int m;
      if (i != 0)
      {
        arrayOfInt[0] = ((int)(this.mItemInfoWidth - f2));
        j = (int)f2;
        k = (int)f8;
        k = attachMetalImageItemToContainer(localArrayList1, localLinearLayout, j, arrayOfInt, k, k, localColorDrawable, paramBoolean);
        if (k > 0) {
          arrayOfInt[0] -= (int)f3;
        }
        if (k > 0) {
          j = (int)f1;
        } else {
          j = (int)f7;
        }
        m = attachMetalImageItemToContainer(localArrayList2, (LinearLayout)localObject, j, arrayOfInt, (int)f5, (int)f6, localColorDrawable, paramBoolean);
        paramLinearLayout.setOrientation(0);
        j = k;
        k = m;
      }
      else
      {
        arrayOfInt[0] = ((int)(this.mItemInfoWidth - f2));
        j = (int)f8;
        k = attachMetalImageItemToContainer(localArrayList1, localLinearLayout, 0, arrayOfInt, j, j, localColorDrawable, paramBoolean);
        arrayOfInt[0] = ((int)(this.mItemInfoWidth - f1 - f2));
        if (k > 0) {
          j = (int)(f4 * 16.0F);
        } else {
          j = (int)f7;
        }
        m = attachMetalImageItemToContainer(localArrayList2, (LinearLayout)localObject, j, arrayOfInt, (int)f5, (int)f6, localColorDrawable, paramBoolean);
        paramLinearLayout.setOrientation(1);
        j = k;
        k = m;
      }
      if (j > 0) {
        paramLinearLayout.addView(localLinearLayout);
      }
      if (k > 0)
      {
        if (j > 0) {
          if (i != 0) {
            paramList.leftMargin = ((int)f3);
          } else {
            paramList.leftMargin = ((int)f1);
          }
        }
        if (i != 0)
        {
          localLayoutParams.gravity = 16;
          paramList.gravity = 16;
        }
        else
        {
          paramList.topMargin = ((int)f2);
        }
        localLinearLayout.setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject).setLayoutParams(paramList);
        paramLinearLayout.addView((View)localObject);
      }
    }
  }
  
  public String getComponentName()
  {
    return "ProfileDiamondWallComponent";
  }
  
  public int getComponentType()
  {
    return 1019;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_diamond";
  }
  
  public boolean makeOrRefreshMedalAndDiamond(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if (paramProfileCardInfo == null) {
      localObject = null;
    } else {
      localObject = paramProfileCardInfo.card;
    }
    paramBoolean = true;
    boolean bool1 = true;
    boolean bool2 = true;
    if (localObject == null)
    {
      if (this.mViewContainer != null) {
        paramBoolean = bool2;
      } else {
        paramBoolean = false;
      }
      this.mViewContainer = null;
      return paramBoolean;
    }
    bool2 = Utils.b(paramProfileCardInfo.allInOne.uin) ^ true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("makeAccountLineThree, , diamond: %s", new Object[] { Boolean.valueOf(bool2) }));
    }
    if (!bool2)
    {
      if (this.mViewContainer == null) {
        paramBoolean = false;
      }
      this.mViewContainer = null;
      return paramBoolean;
    }
    if (this.mViewContainer == null)
    {
      this.mViewContainer = LayoutInflater.from(this.mActivity).inflate(2131561345, null);
      paramBoolean = bool1;
    }
    else
    {
      paramBoolean = false;
    }
    Object localObject = (ImageView)((View)this.mViewContainer).findViewById(2131362975);
    View localView = ((View)this.mViewContainer).findViewById(2131365686);
    if (bool2)
    {
      updateDiamondView(paramProfileCardInfo, localView);
      paramProfileCardInfo = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      paramProfileCardInfo.leftMargin = 0;
      localView.setLayoutParams(paramProfileCardInfo);
    }
    else
    {
      localView.setVisibility(8);
      ((View)this.mViewContainer).setTag(null);
    }
    if (bool2)
    {
      ((View)this.mViewContainer).setTag(new DataTag(26, null));
      ((View)this.mViewContainer).setOnClickListener(this.mOnClickListener);
    }
    updateItemTheme((View)this.mViewContainer, null, null, (ImageView)localObject);
    paramProfileCardInfo = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
    if (paramProfileCardInfo.isDiy())
    {
      ((View)this.mViewContainer).setBackgroundResource(2130839435);
      paramProfileCardInfo.updateMetalForDeepDiy((View)this.mViewContainer);
    }
    return paramBoolean;
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = this.mActivity.getResources();
    paramBundle = paramQBaseActivity.getDisplayMetrics();
    this.mDensity = paramBundle.density;
    float f1 = Math.min(paramBundle.widthPixels, paramBundle.heightPixels);
    float f2 = paramQBaseActivity.getDimensionPixelSize(2131297246) + paramQBaseActivity.getDimensionPixelSize(2131297597) + paramQBaseActivity.getDimensionPixelSize(2131297598);
    float f3 = this.mDensity;
    int i = paramQBaseActivity.getDimensionPixelSize(2131297594);
    int j = paramQBaseActivity.getDimensionPixelSize(2131297595);
    this.mItemInfoWidth = (f1 - f2 - (f3 * 7.0F + i + j));
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshMedalAndDiamond((ProfileCardInfo)this.mData, ((ProfileCardInfo)this.mData).isNetRet);
  }
  
  public void updateDiamondView(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null))
    {
      if (paramView == null) {
        return;
      }
      paramView.setVisibility(0);
      Object localObject3 = paramProfileCardInfo.card;
      Object localObject1 = ((Card)localObject3).getPrivilegeOpenInfo();
      Object localObject2 = ((Card)localObject3).getPrivilegeCloseInfo();
      TextView localTextView = (TextView)paramView.findViewById(2131373166);
      paramView = (LinearLayout)paramView.findViewById(2131365687);
      paramView.removeAllViews();
      StringBuilder localStringBuilder = new StringBuilder(24);
      localStringBuilder.append(this.mActivity.getString(2131693340));
      if ((paramProfileCardInfo.allInOne.pa != 0) && (!this.mApp.getCurrentAccountUin().equals(paramProfileCardInfo.allInOne.uin)))
      {
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          paramView.setVisibility(0);
          localTextView.setVisibility(8);
          showDiamondImage((List)localObject1, paramView, true);
          localStringBuilder.append("你的好友已开通");
          setDescription(localStringBuilder, (List)localObject1);
        }
        else
        {
          paramProfileCardInfo = ((Card)localObject3).privilegePromptStr;
          if (TextUtils.isEmpty(paramProfileCardInfo)) {
            localTextView.setText(this.mActivity.getString(2131699153));
          } else {
            localTextView.setText(paramProfileCardInfo);
          }
          localStringBuilder.append("TA还未开通任何服务特权");
          paramView.setVisibility(8);
          localTextView.setVisibility(0);
        }
      }
      else
      {
        paramProfileCardInfo = new ArrayList();
        localObject3 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if ((localObject1 != null) && ((((List)localObject1).size() > 0) || ((localObject2 != null) && (!((List)localObject2).isEmpty()))))
        {
          paramView.setVisibility(0);
          localTextView.setVisibility(8);
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)localIterator.next();
            if (localPrivilegeInfo.iIsBig == 1) {
              ((List)localObject3).add(localPrivilegeInfo);
            } else {
              localArrayList.add(localPrivilegeInfo);
            }
            localPrivilegeInfo.isOpen = true;
          }
          localStringBuilder.append("你已开通");
          setDescription(localStringBuilder, (List)localObject1);
        }
        else
        {
          paramView.setVisibility(8);
          localTextView.setVisibility(0);
          localTextView.setText(this.mActivity.getString(2131699154));
          localStringBuilder.append("你未开通特权服务，快去开通vip服务吧！");
        }
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject1 = ((List)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (PrivilegeInfo)((Iterator)localObject1).next();
            if (((PrivilegeInfo)localObject2).iIsBig == 1) {
              ((List)localObject3).add(localObject2);
            } else {
              localArrayList.add(localObject2);
            }
            ((PrivilegeInfo)localObject2).isOpen = false;
          }
        }
        paramProfileCardInfo.addAll((Collection)localObject3);
        paramProfileCardInfo.addAll(localArrayList);
        showDiamondImage(paramProfileCardInfo, paramView, false);
      }
      paramView.setContentDescription(localStringBuilder);
      updateItemTheme(localTextView, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.diamondwall.ProfileDiamondWallComponent
 * JD-Core Version:    0.7.0.1
 */