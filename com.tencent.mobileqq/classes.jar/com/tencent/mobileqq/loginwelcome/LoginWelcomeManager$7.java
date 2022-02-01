package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.phonecontact.data.RecommendContactInfo;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import java.util.List;

class LoginWelcomeManager$7
  extends ContactBindObserver
{
  LoginWelcomeManager$7(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void onGetNewerGuideRecommended(List<RecommendContactInfo> paramList)
  {
    this.a.a(paramList);
  }
  
  protected void onGetNewerGuideRecommendedNotBind(List<RecommendContactInfo> paramList)
  {
    this.a.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.7
 * JD-Core Version:    0.7.0.1
 */