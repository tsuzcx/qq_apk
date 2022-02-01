package com.tencent.mobileqq.profilecard.bussiness.anonymous;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.manager.AnonymousRedPointUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
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
    int j = 0;
    boolean bool = isHost();
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAnonymousComponent", 0, String.format("buildRecyclerAdapterData() isHost=%b, hasQuestion=%b , hasAnswer=%b ,hasMoreQues=%b ,", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    }
    ArrayList localArrayList = new ArrayList();
    AnonymousQuestion localAnonymousQuestion = new AnonymousQuestion();
    if (bool)
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
          }
          return localArrayList;
        }
        localAnonymousQuestion.uiState = 2;
        localArrayList.add(localAnonymousQuestion);
        return localArrayList;
      }
      localAnonymousQuestion.uiState = 1;
      localArrayList.add(localAnonymousQuestion);
      return localArrayList;
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      localAnonymousQuestion.uiState = 5;
      localArrayList.add(localAnonymousQuestion);
      localArrayList.addAll(paramList);
      return localArrayList;
    }
    localAnonymousQuestion.uiState = 4;
    localArrayList.add(localAnonymousQuestion);
    return localArrayList;
  }
  
  private boolean isHost()
  {
    return ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0;
  }
  
  private boolean makeOrRefreshAnonymous(Card paramCard)
  {
    boolean bool4 = true;
    ProfileAnonymousAnswerInfo localProfileAnonymousAnswerInfo = (ProfileAnonymousAnswerInfo)((ProfileCardInfo)this.mData).a(ProfileAnonymousAnswerInfo.class);
    boolean bool2;
    label60:
    boolean bool5;
    if ((this.mConfigHelper == null) || (this.mConfigHelper.a(13)))
    {
      bool1 = true;
      if (ProfileSettingUtils.a.a(42425, paramCard, this.mApp) == 1) {
        break label183;
      }
      bool2 = true;
      bool5 = ProfileActivity.AllInOne.b(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      if ((paramCard == null) || (localProfileAnonymousAnswerInfo == null) || (!localProfileAnonymousAnswerInfo.needForbidEntry)) {
        break label188;
      }
    }
    label183:
    label188:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileAnonymousComponent", 0, String.format("makeOrRefreshAnonymous() configEnable=%b, visible=%b , isFriend=%b ,isForbidEntry=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool5), Boolean.valueOf(bool3) }));
      }
      if ((!bool3) && (bool1) && (bool2) && (bool5)) {
        break label194;
      }
      if (this.mViewContainer == null) {
        break label397;
      }
      this.mViewContainer = null;
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label60;
    }
    label194:
    Object localObject;
    label296:
    label307:
    String str;
    if (this.mViewContainer == null)
    {
      this.anonymousView = new AnonymousView(this.mActivity);
      this.anonymousView.setTitle(this.mActivity.getString(2131698562));
      paramCard = this.anonymousView;
      localObject = this.mApp;
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null)
      {
        bool1 = true;
        paramCard.initData((QQAppInterface)localObject, bool1, ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        this.mViewContainer = this.anonymousView;
        if (!isHost()) {
          break label361;
        }
        paramCard = "";
        if (!isHost()) {
          break label378;
        }
        localObject = "0X800B461";
        if (!isHost()) {
          break label385;
        }
        str = "0X800B461";
        label318:
        ReportController.b(null, "dc00898", "", paramCard, (String)localObject, str, 0, 0, "", "", "", "");
      }
    }
    for (boolean bool1 = bool4;; bool1 = false)
    {
      refreshAnonymousUI(localProfileAnonymousAnswerInfo, this.anonymousView);
      return bool1;
      bool1 = false;
      break;
      label361:
      paramCard = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      break label296;
      label378:
      localObject = "0X800B462";
      break label307;
      label385:
      str = "0X800B462";
      break label318;
    }
    label397:
    return false;
  }
  
  private void refreshAnonymousUI(ProfileAnonymousAnswerInfo paramProfileAnonymousAnswerInfo, AnonymousView paramAnonymousView)
  {
    updateItemTheme(paramAnonymousView, true);
    boolean bool1;
    boolean bool2;
    label39:
    boolean bool3;
    label63:
    int i;
    label78:
    int j;
    if ((paramProfileAnonymousAnswerInfo != null) && (paramProfileAnonymousAnswerInfo.mTotalQuestionCount > 0))
    {
      bool1 = true;
      if ((paramProfileAnonymousAnswerInfo == null) || (paramProfileAnonymousAnswerInfo.mAnonymousQuestions.size() <= 0)) {
        break label279;
      }
      bool2 = true;
      if ((!bool2) || (paramProfileAnonymousAnswerInfo.mTotalQuestionCount <= paramProfileAnonymousAnswerInfo.mAnonymousQuestions.size())) {
        break label285;
      }
      bool3 = true;
      label91:
      Object localObject;
      if (bool1)
      {
        if (!isHost()) {
          break label291;
        }
        i = 2131698565;
        if (!isHost()) {
          break label298;
        }
        j = paramProfileAnonymousAnswerInfo.mTotalQuestionCount;
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
        localObject = paramAnonymousView.getResources().getDrawable(2130850830);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
        paramAnonymousView.mTitleText.setCompoundDrawables(null, null, (Drawable)localObject, null);
        paramAnonymousView.mTitleText.setCompoundDrawablePadding(Utils.dp2px(4.0D));
      }
      if (paramProfileAnonymousAnswerInfo == null) {
        break label307;
      }
    }
    label279:
    label285:
    label291:
    label298:
    label307:
    for (paramProfileAnonymousAnswerInfo = paramProfileAnonymousAnswerInfo.mAnonymousQuestions;; paramProfileAnonymousAnswerInfo = new ArrayList())
    {
      paramAnonymousView.show(buildRecyclerAdapterData(paramProfileAnonymousAnswerInfo, bool1, bool2, bool3));
      updateItemTheme(null, null);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label39;
      bool3 = false;
      break label63;
      i = 2131698568;
      break label78;
      j = paramProfileAnonymousAnswerInfo.mAnsweredQuestionCount;
      break label91;
    }
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
  
  public void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    this.mApp.addObserver(this.anonymousObserver);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshAnonymous(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.anonymousObserver);
    if (this.anonymousView != null) {
      this.anonymousView.destroy();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousComponent
 * JD-Core Version:    0.7.0.1
 */