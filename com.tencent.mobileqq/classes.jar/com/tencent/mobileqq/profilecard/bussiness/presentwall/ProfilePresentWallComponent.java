package com.tencent.mobileqq.profilecard.bussiness.presentwall;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

public class ProfilePresentWallComponent
  extends AbsQQProfileContentComponent
  implements Handler.Callback
{
  private static final String TAG = "ProfilePresentWallComponent";
  View.OnClickListener mOnClickListener = new ProfilePresentWallComponent.1(this);
  MqqHandler mReportHandler = new CustomHandler(Looper.getMainLooper(), this);
  
  public ProfilePresentWallComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean makeOrRefreshPresent(Card paramCard, boolean paramBoolean)
  {
    boolean bool = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy();
    paramBoolean = true;
    if (bool)
    {
      if (this.mViewContainer == null) {
        paramBoolean = false;
      }
      this.mViewContainer = null;
      return paramBoolean;
    }
    if (paramCard == null) {
      return false;
    }
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
      ReportController.b(this.mApp, "", "", "", "0X800A1C6", "0X800A1C6", 0, 0, "", "", "", "");
    } else {
      ReportController.b(this.mApp, "", "", "", "0X800A1C8", "0X800A1C8", 0, 0, "", "", "", "");
    }
    QZLog.d("cardInfo.allinone.pa", 2, new Object[] { Integer.valueOf(((ProfileCardInfo)this.mData).allInOne.pa) });
    if ((paramCard.presentSwitch) && (!ProfilePAUtils.isNotShowPresent(((ProfileCardInfo)this.mData).allInOne)))
    {
      if ((((ProfileCardInfo)this.mData).allInOne.pa == 20) || (((ProfileCardInfo)this.mData).allInOne.pa == 21)) {
        troopMemberGiftWallReport(101);
      }
      View localView = LayoutInflater.from(this.mActivity).inflate(2131627714, null);
      this.mViewContainer = localView;
      Object localObject1 = (ViewGroup)localView.findViewById(2131435722);
      TextView localTextView = (TextView)localView.findViewById(2131447238);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131435403);
      Object localObject3 = (ImageView)localView.findViewById(2131435723);
      Object localObject4 = (ImageView)localView.findViewById(2131435724);
      Object localObject5 = (ImageView)localView.findViewById(2131435725);
      ImageView localImageView2 = (ImageView)localView.findViewById(2131435726);
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(localObject3);
      ((List)localObject2).add(localObject4);
      ((List)localObject2).add(localObject5);
      ((List)localObject2).add(localImageView2);
      localTextView.setSingleLine(true);
      localTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      if ((paramCard.showPresent) && (paramCard.presentUrl != null))
      {
        ((ViewGroup)localObject1).setVisibility(0);
        localObject3 = paramCard.presentUrl;
        localObject1 = this.mActivity.getResources();
        int j = ((Resources)localObject1).getDimensionPixelSize(2131299135);
        int i = ((Resources)localObject1).getDimensionPixelSize(2131298260);
        int k = ((Resources)localObject1).getDimensionPixelSize(2131298257);
        localObject1 = ((Resources)localObject1).getDisplayMetrics();
        int m = (int)(Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels) - i - k);
        k = (int)((m - j * 3 * 1.0F) / 3.0F);
        paramBoolean = QLog.isColorLevel();
        i = 4;
        if (paramBoolean) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(((List)localObject2).size()), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m) }));
        }
        if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
        {
          if (((List)localObject3).size() <= 4) {
            i = ((List)localObject3).size();
          }
          localObject1 = null;
          j = 0;
          while (j < i)
          {
            localObject4 = (String)((List)localObject3).get(j);
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              if (ThemeUtil.isInNightMode(this.mApp)) {
                ((ImageView)((List)localObject2).get(j)).setColorFilter(1996488704);
              }
              if (localObject1 == null) {
                localObject1 = new ColorDrawable(this.mActivity.getResources().getColor(2131166314));
              }
              try
              {
                localObject5 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((Drawable)localObject1);
                ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = ((Drawable)localObject1);
                ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = k;
                ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = k;
                localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject5);
                ((ImageView)((List)localObject2).get(j)).setImageDrawable((Drawable)localObject4);
              }
              catch (Exception localException)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.profilecard.FrdProfileCard", 2, "makeOrRefreshPresent fail!", localException);
                }
              }
            }
            j += 1;
          }
        }
      }
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        localObject1 = HardCodeUtil.a(2131906241);
      } else {
        localObject1 = ((ProfileCardInfo)this.mData).nameArray[0];
      }
      if (!TextUtils.isEmpty(paramCard.presentDesc))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(": ");
        ((StringBuilder)localObject2).append(paramCard.presentDesc);
        paramCard = ((StringBuilder)localObject2).toString();
      }
      else
      {
        paramCard = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131906248));
      ((StringBuilder)localObject2).append(paramCard);
      localTextView.setText(((StringBuilder)localObject2).toString());
      localView.setTag(new DataTag(94, null));
      localView.setOnClickListener(this.mOnClickListener);
      localView.setContentDescription(this.mActivity.getString(2131888122));
      updateItemTheme(localView, localTextView, null, localImageView1);
      return true;
    }
    paramBoolean = true;
    if (this.mViewContainer == null) {
      paramBoolean = false;
    }
    this.mViewContainer = null;
    return paramBoolean;
  }
  
  private void troopMemberGiftWallReport(int paramInt)
  {
    this.mReportHandler.removeMessages(paramInt);
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    this.mReportHandler.sendMessageDelayed(localMessage, 600L);
  }
  
  public String getComponentName()
  {
    return "ProfilePresentWallComponent";
  }
  
  public int getComponentType()
  {
    return 1018;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_present";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    MobileReportManager.getInstance().reportAction("giftwall", "4", "group_gift", "9", "", paramMessage.what, 1, System.currentTimeMillis());
    return false;
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshPresent(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.presentwall.ProfilePresentWallComponent
 * JD-Core Version:    0.7.0.1
 */