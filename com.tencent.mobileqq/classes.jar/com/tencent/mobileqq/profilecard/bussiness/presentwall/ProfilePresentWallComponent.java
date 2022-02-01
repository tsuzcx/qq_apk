package com.tencent.mobileqq.profilecard.bussiness.presentwall;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProfilePresentWallComponent
  extends AbsProfileContentComponent
{
  private static final String TAG = "ProfilePresentWallComponent";
  View.OnClickListener mOnClickListener = new ProfilePresentWallComponent.1(this);
  
  public ProfilePresentWallComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean makeOrRefreshPresent(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return false;
    }
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      ReportController.b(this.mApp, "", "", "", "0X800A1C6", "0X800A1C6", 0, 0, "", "", "", "");
      QZLog.d("cardInfo.allinone.pa", 2, new Object[] { Integer.valueOf(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a) });
      if ((paramCard.presentSwitch) && (!ProfileActivity.AllInOne.f(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        break label152;
      }
      if (this.mViewContainer == null) {
        break label147;
      }
    }
    label147:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mViewContainer = null;
      return paramBoolean;
      ReportController.b(this.mApp, "", "", "", "0X800A1C8", "0X800A1C8", 0, 0, "", "", "", "");
      break;
    }
    label152:
    View localView = LayoutInflater.from(this.mActivity).inflate(2131561517, null);
    this.mViewContainer = localView;
    Object localObject1 = (ViewGroup)localView.findViewById(2131369080);
    TextView localTextView = (TextView)localView.findViewById(2131379248);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131368771);
    Object localObject2 = (ImageView)localView.findViewById(2131369081);
    Object localObject3 = (ImageView)localView.findViewById(2131369082);
    Object localObject4 = (ImageView)localView.findViewById(2131369083);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131369084);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject2);
    localArrayList.add(localObject3);
    localArrayList.add(localObject4);
    localArrayList.add(localImageView2);
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    int i;
    int j;
    int k;
    if ((paramCard.showPresent) && (paramCard.presentUrl != null))
    {
      ((ViewGroup)localObject1).setVisibility(0);
      localObject2 = paramCard.presentUrl;
      localObject1 = this.mActivity.getResources();
      i = ((Resources)localObject1).getDimensionPixelSize(2131298426);
      j = ((Resources)localObject1).getDimensionPixelSize(2131297605);
      k = ((Resources)localObject1).getDimensionPixelSize(2131297602);
      localObject1 = ((Resources)localObject1).getDisplayMetrics();
      j = (int)(Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels) - j - k);
      k = (int)((j - i * 3 * 1.0F) / 3.0F);
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(localArrayList.size()), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      localObject1 = null;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        if (((List)localObject2).size() > 4)
        {
          i = 4;
          j = 0;
          label523:
          if (j >= i) {
            break label706;
          }
          localObject3 = (String)((List)localObject2).get(j);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label873;
          }
          if (ThemeUtil.isInNightMode(this.mApp)) {
            ((ImageView)localArrayList.get(j)).setColorFilter(1996488704);
          }
          if (localObject1 != null) {
            break label870;
          }
          localObject1 = new ColorDrawable(this.mActivity.getResources().getColor(2131165731));
        }
      }
    }
    label706:
    label864:
    label870:
    label873:
    for (;;)
    {
      try
      {
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = k;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = k;
        localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
        ((ImageView)localArrayList.get(j)).setImageDrawable((Drawable)localObject3);
        j += 1;
        break label523;
        i = ((List)localObject2).size();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, "makeOrRefreshPresent fail!", localException);
        }
        continue;
      }
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
      {
        localObject1 = HardCodeUtil.a(2131708449);
        if (TextUtils.isEmpty(paramCard.presentDesc)) {
          break label864;
        }
      }
      for (paramCard = ": " + paramCard.presentDesc;; paramCard = "")
      {
        localTextView.setText((String)localObject1 + HardCodeUtil.a(2131708456) + paramCard);
        localView.setTag(new DataTag(94, null));
        localView.setOnClickListener(this.mOnClickListener);
        localView.setContentDescription(this.mActivity.getString(2131691255));
        updateItemTheme(localTextView, null, localImageView1);
        return true;
        localObject1 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ArrayOfJavaLangString[0];
        break;
      }
    }
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
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshPresent(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d) | bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.presentwall.ProfilePresentWallComponent
 * JD-Core Version:    0.7.0.1
 */