package com.tencent.mobileqq.profilecard.vas.component.taglabel;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.AdaptiveLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class VasProfileTagLabelComponent
  extends AbsQQProfileContentComponent
  implements View.OnClickListener
{
  private static final int MAX_TAGS_NUM = 7;
  private static final String TAG = "VasProfileTagLabelComponent";
  private TextView[] mTagLabels;
  
  public VasProfileTagLabelComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean isTagTemplateProfile()
  {
    Object localObject = this.mData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((ProfileCardInfo)this.mData).curUseStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_TAG) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean makeOrRefreshTagLabel(Card paramCard)
  {
    boolean bool2 = isTagTemplateProfile();
    boolean bool1 = false;
    if ((bool2) && (!((ProfileCardInfo)this.mData).isTroopMemberCard))
    {
      Object localObject1 = (View)this.mViewContainer;
      if (localObject1 == null)
      {
        localObject1 = this.mActivity.getLayoutInflater().inflate(2131627729, null);
        this.mViewContainer = localObject1;
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      Object localObject2 = this.mActivity.getResources();
      Object localObject3 = (AdaptiveLayout)((View)localObject1).findViewById(2131446811);
      int j = ((Resources)localObject2).getDimensionPixelSize(2131299347);
      int i;
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        i = 8;
      } else {
        i = 7;
      }
      int k;
      if (this.mTagLabels == null)
      {
        ((AdaptiveLayout)localObject3).setGap(j, j);
        this.mTagLabels = new TextView[i];
        k = ((Resources)localObject2).getDimensionPixelSize(2131299345);
        int m = ((Resources)localObject2).getDimensionPixelSize(2131299348);
        int n = ((Resources)localObject2).getDimensionPixelSize(2131299351);
        j = 0;
        while (j < i)
        {
          localObject1 = new TextView(this.mActivity);
          this.mTagLabels[j] = localObject1;
          ((TextView)localObject1).setBackgroundResource(2130848925);
          ((TextView)localObject1).setPadding(m, m, m, m);
          ((TextView)localObject1).setTextSize(0, k);
          ((TextView)localObject1).setTextColor(-16777216);
          ((TextView)localObject1).setGravity(17);
          if (7 == j)
          {
            k = ((Resources)localObject2).getDimensionPixelSize(2131299352);
            ((TextView)localObject1).setTextSize(0, k);
            ((TextView)localObject1).setText("+");
            ((TextView)localObject1).setPadding(n, 0, n, 0);
            ((TextView)localObject1).setTag(new DataTag(47, null));
            ((TextView)localObject1).setOnClickListener(this);
          }
          else
          {
            ((TextView)localObject1).setVisibility(8);
          }
          ((AdaptiveLayout)localObject3).addView((View)localObject1);
          j += 1;
        }
      }
      localObject1 = paramCard.getLabelList();
      if ((localObject3 != null) && (localObject1 != null))
      {
        k = Math.min(((List)localObject1).size(), 7);
        j = 0;
        while (j < i)
        {
          localObject2 = this.mTagLabels[j];
          if (j < k)
          {
            ((TextView)localObject2).setText(((ProfileLabelInfo)((List)localObject1).get(j)).labelName);
            ((TextView)localObject2).setVisibility(0);
          }
          else if (j < 7)
          {
            ((TextView)localObject2).setVisibility(8);
          }
          if (((TextView)localObject2).getVisibility() == 0)
          {
            localObject3 = ((TextView)localObject2).getBackground();
            if ((localObject3 instanceof GradientDrawable))
            {
              localObject3 = (GradientDrawable)localObject3;
              if (paramCard.backgroundColor == 1L)
              {
                ((GradientDrawable)localObject3).setColor(-2130706433);
                ((GradientDrawable)localObject3).setStroke(1, 855638016);
                ((TextView)localObject2).setTextColor(-16777216);
              }
              else
              {
                ((GradientDrawable)localObject3).setColor(-2147483648);
                ((GradientDrawable)localObject3).setStroke(1, 872415231);
                ((TextView)localObject2).setTextColor(-1);
              }
            }
          }
          j += 1;
        }
      }
      return bool1;
    }
    if (this.mViewContainer != null)
    {
      this.mViewContainer = null;
      bool1 = true;
    }
    return bool1;
  }
  
  public String getComponentName()
  {
    return "VasProfileTagLabelComponent";
  }
  
  public int getComponentType()
  {
    return 1033;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_tag_label";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1004)
    {
      paramIntent = ((FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.mApp.getCurrentAccountUin());
      if (paramIntent != null)
      {
        ((ProfileCardInfo)this.mData).card = paramIntent;
        this.mDelegate.notifyCardUpdate();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (((localObject instanceof DataTag)) && (((DataTag)localObject).a == 47))
    {
      try
      {
        localObject = new Intent(this.mActivity, ProfileLabelEditorActivity.class);
        ((Intent)localObject).putExtra("uin", ((ProfileCardInfo)this.mData).allInOne.uin);
        this.mActivity.startActivityForResult((Intent)localObject, 1004);
      }
      catch (Exception localException)
      {
        QLog.e("VasProfileTagLabelComponent", 1, "start label editor fail.", localException);
      }
      ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "2", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshTagLabel(paramProfileCardInfo.card) | bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.taglabel.VasProfileTagLabelComponent
 * JD-Core Version:    0.7.0.1
 */