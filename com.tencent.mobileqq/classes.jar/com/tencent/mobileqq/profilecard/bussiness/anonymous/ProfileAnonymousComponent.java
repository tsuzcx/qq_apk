package com.tencent.mobileqq.profilecard.bussiness.anonymous;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousRedPointUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ProfileAnonymousComponent
  extends AbsProfileContentComponent
{
  public static final String TAG = "ProfileAnonymousComponent";
  private AnonymousObserver anonymousObserver = new ProfileAnonymousComponent.1(this);
  private AnonymousView anonymousView;
  
  public ProfileAnonymousComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private List<AnonymousQuestion> buildRecyclerAdapterData(List<AnonymousQuestion> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool1 = isHost();
    boolean bool2 = QLog.isColorLevel();
    int j = 0;
    if (bool2) {
      QLog.d("ProfileAnonymousComponent", 2, String.format("buildRecyclerAdapterData() isHost=%b, hasQuestion=%b , hasAnswer=%b ,hasMoreQues=%b ,", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    }
    ArrayList localArrayList = new ArrayList();
    AnonymousQuestion localAnonymousQuestion = new AnonymousQuestion();
    if (bool1)
    {
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localArrayList.addAll(paramList);
          int i;
          if (paramList.size() <= 10)
          {
            i = j;
            if (paramList.size() == 10)
            {
              i = j;
              if (!paramBoolean3) {}
            }
          }
          else
          {
            i = 1;
          }
          if (i != 0)
          {
            localAnonymousQuestion.uiState = 3;
            localArrayList.add(localAnonymousQuestion);
            return localArrayList;
          }
        }
        else
        {
          localAnonymousQuestion.uiState = 2;
          localArrayList.add(localAnonymousQuestion);
          return localArrayList;
        }
      }
      else
      {
        localAnonymousQuestion.uiState = 1;
        localArrayList.add(localAnonymousQuestion);
        return localArrayList;
      }
    }
    else
    {
      if ((paramBoolean1) && (paramBoolean2))
      {
        localAnonymousQuestion.uiState = 5;
        localArrayList.add(localAnonymousQuestion);
        localArrayList.addAll(paramList);
        return localArrayList;
      }
      localAnonymousQuestion.uiState = 4;
      localArrayList.add(localAnonymousQuestion);
    }
    return localArrayList;
  }
  
  private boolean isHost()
  {
    return ((ProfileCardInfo)this.mData).allInOne.pa == 0;
  }
  
  private boolean makeOrRefreshAnonymous(Card paramCard)
  {
    ProfileAnonymousAnswerInfo localProfileAnonymousAnswerInfo = (ProfileAnonymousAnswerInfo)((ProfileCardInfo)this.mData).getBusinessInfo(ProfileAnonymousAnswerInfo.class);
    Object localObject = this.mConfigHelper;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    if ((localObject != null) && (!this.mConfigHelper.isSwitchEnable(13))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2;
    if (((IProfileSettingApi)QRoute.api(IProfileSettingApi.class)).getProfileDisplaySettingStateFromCard(42425, paramCard, this.mApp) != 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool7 = ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo)this.mData).allInOne);
    boolean bool3;
    if ((paramCard != null) && (localProfileAnonymousAnswerInfo != null) && (localProfileAnonymousAnswerInfo.needForbidEntry)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAnonymousComponent", 2, String.format("makeOrRefreshAnonymous() configEnable=%b, visible=%b , isFriend=%b ,isForbidEntry=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool7), Boolean.valueOf(bool3) }));
    }
    if ((!bool3) && (bool1) && (bool2) && (bool7))
    {
      bool1 = bool5;
      if (this.mViewContainer == null)
      {
        this.anonymousView = new AnonymousView(this.mActivity);
        this.anonymousView.setTitle(this.mActivity.getString(2131698628));
        paramCard = this.anonymousView;
        localObject = this.mApp;
        bool1 = bool4;
        if (((ProfileCardInfo)this.mData).currentTemplate != null) {
          bool1 = true;
        }
        paramCard.initData((AppInterface)localObject, bool1, ((ProfileCardInfo)this.mData).allInOne.uin);
        this.mViewContainer = this.anonymousView;
        if (isHost()) {
          paramCard = "";
        } else {
          paramCard = ((ProfileCardInfo)this.mData).allInOne.uin;
        }
        if (isHost()) {
          localObject = "0X800B461";
        } else {
          localObject = "0X800B462";
        }
        String str;
        if (isHost()) {
          str = "0X800B461";
        } else {
          str = "0X800B462";
        }
        ReportController.b(null, "dc00898", "", paramCard, (String)localObject, str, 0, 0, "", "", "", "");
        bool1 = true;
      }
      refreshAnonymousUI(localProfileAnonymousAnswerInfo, this.anonymousView);
      return bool1;
    }
    boolean bool1 = bool6;
    if (this.mViewContainer != null)
    {
      this.mViewContainer = null;
      bool1 = true;
    }
    return bool1;
  }
  
  private void refreshAnonymousUI(ProfileAnonymousAnswerInfo paramProfileAnonymousAnswerInfo, AnonymousView paramAnonymousView)
  {
    updateItemTheme(paramAnonymousView, true);
    boolean bool1;
    if ((paramProfileAnonymousAnswerInfo != null) && (paramProfileAnonymousAnswerInfo.mTotalQuestionCount > 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((paramProfileAnonymousAnswerInfo != null) && (paramProfileAnonymousAnswerInfo.mAnonymousQuestions.size() > 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((bool2) && (paramProfileAnonymousAnswerInfo.mTotalQuestionCount > paramProfileAnonymousAnswerInfo.mAnonymousQuestions.size())) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    Object localObject;
    if (bool1)
    {
      int i;
      if (isHost()) {
        i = 2131698631;
      } else {
        i = 2131698634;
      }
      int j;
      if (isHost()) {
        j = paramProfileAnonymousAnswerInfo.mTotalQuestionCount;
      } else {
        j = paramProfileAnonymousAnswerInfo.mAnsweredQuestionCount;
      }
      if (j > 0)
      {
        localObject = String.format(this.mActivity.getString(i), new Object[] { Integer.valueOf(j) });
        TextView localTextView = new TextView(this.mActivity);
        localTextView.setText((CharSequence)localObject);
        paramAnonymousView.mTitleExtContainer.removeAllViews();
        paramAnonymousView.mTitleExtContainer.addView(localTextView);
        paramAnonymousView.mTitleExtContainer.setVisibility(0);
        updateItemTheme(null, localTextView);
      }
    }
    if ((AnonymousRedPointUtils.showProfileRedPointGuide(this.mApp)) && (isHost()))
    {
      localObject = paramAnonymousView.getResources().getDrawable(2130850766);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      paramAnonymousView.mTitleText.setCompoundDrawables(null, null, (Drawable)localObject, null);
      paramAnonymousView.mTitleText.setCompoundDrawablePadding(Utils.a(4.0F, paramAnonymousView.getResources()));
    }
    if (paramProfileAnonymousAnswerInfo != null) {
      paramProfileAnonymousAnswerInfo = paramProfileAnonymousAnswerInfo.mAnonymousQuestions;
    } else {
      paramProfileAnonymousAnswerInfo = new ArrayList();
    }
    paramAnonymousView.show(buildRecyclerAdapterData(paramProfileAnonymousAnswerInfo, bool1, bool2, bool3));
    updateItemTheme(null, null);
  }
  
  public String getComponentName()
  {
    return "ProfileAnonymousComponent";
  }
  
  public int getComponentType()
  {
    return 1026;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_anonymous";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4660) && (this.mDelegate != null)) {
      this.mDelegate.requestUpdateCard();
    }
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mApp.addObserver(this.anonymousObserver);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshAnonymous(((ProfileCardInfo)this.mData).card);
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.anonymousObserver);
    AnonymousView localAnonymousView = this.anonymousView;
    if (localAnonymousView != null) {
      localAnonymousView.destroy();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousComponent
 * JD-Core Version:    0.7.0.1
 */