package com.tencent.mobileqq.profile;

import ProfileLogic.QC.readUserInfoRsp;
import ProfileLogic.QC.setUserFlagRsp;
import ProfileLogic.QC.setUserProfileRsp;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

class CustomCoverFragment$1
  extends SVIPObserver
{
  CustomCoverFragment$1(CustomCoverFragment paramCustomCoverFragment) {}
  
  public void onDefaultCardRsp(boolean paramBoolean, Object paramObject)
  {
    CustomCoverFragment.a(this.a).b();
    Object localObject1 = this.a.getBaseActivity();
    if (localObject1 == null) {
      return;
    }
    int i = 0;
    boolean bool = true;
    Object localObject2;
    if (paramBoolean)
    {
      if ((paramObject instanceof readUserInfoRsp))
      {
        this.a.stopTitleProgress();
        paramObject = (readUserInfoRsp)paramObject;
        if (CustomCoverFragment.b(this.a))
        {
          localObject1 = this.a;
          if (paramObject.flag == 1) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          CustomCoverFragment.a((CustomCoverFragment)localObject1, paramBoolean);
        }
        CustomCoverFragment.a(this.a, paramObject.itemid);
        CustomCoverFragment.b(this.a, paramObject.index);
        CustomCoverFragment.c(this.a, paramObject.listend);
        if (!TextUtils.isEmpty(paramObject.urlprefix)) {
          ProfileCardManager.c = paramObject.urlprefix;
        }
        CustomCoverFragment.a(this.a, paramObject.itemlist);
        if (CustomCoverFragment.c(this.a) != null) {
          if (CustomCoverFragment.d(this.a).size() == 0)
          {
            CustomCoverFragment.c(this.a).setVisibility(8);
            CustomCoverFragment.c(this.a, 2);
          }
          else
          {
            CustomCoverFragment.c(this.a).setVisibility(0);
          }
        }
        if (CustomCoverFragment.e(this.a) != null) {
          CustomCoverFragment.e(this.a).sendEmptyMessage(101);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onDefaultCardRsp: [readUserInfoRsp] selId=");
          ((StringBuilder)localObject1).append(CustomCoverFragment.f(this.a));
          ((StringBuilder)localObject1).append(" reqIndex=");
          ((StringBuilder)localObject1).append(CustomCoverFragment.g(this.a));
          ((StringBuilder)localObject1).append(" footerState=");
          ((StringBuilder)localObject1).append(CustomCoverFragment.h(this.a));
          ((StringBuilder)localObject1).append(" flag=");
          if (paramObject.flag == 1) {
            paramBoolean = bool;
          } else {
            paramBoolean = false;
          }
          ((StringBuilder)localObject1).append(paramBoolean);
          ((StringBuilder)localObject1).append(" itemList=");
          if (paramObject.itemlist != null) {
            i = paramObject.itemlist.size();
          }
          ((StringBuilder)localObject1).append(i);
          QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else if ((paramObject instanceof setUserProfileRsp))
      {
        i = ((setUserProfileRsp)paramObject).ret;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("onDefaultCardRsp: [setUserProfileRsp] ret=");
          paramObject.append(i);
          QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, paramObject.toString());
        }
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("onDefaultCardRsp: [setUserProfileRsp] selId=");
            paramObject.append(CustomCoverFragment.f(this.a));
            QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, paramObject.toString());
          }
          paramObject = new Intent();
          paramObject.putExtra("req_code_key", 2002);
          localObject2 = this.a;
          paramObject.putExtra("card_url_key", ((CustomCoverFragment)localObject2).a(CustomCoverFragment.i((CustomCoverFragment)localObject2)));
          ((BaseActivity)localObject1).setResult(-1, paramObject);
          ((BaseActivity)localObject1).finish();
          return;
        }
        if (this.a.getActivity() != null) {
          QQToast.makeText(this.a.getActivity(), 1, 2131917575, 0).show();
        }
      }
      else if ((paramObject instanceof setUserFlagRsp))
      {
        i = ((setUserFlagRsp)paramObject).ret;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("onDefaultCardRsp: [setUserFlagRsp] ret=");
          paramObject.append(i);
          QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, paramObject.toString());
        }
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("onDefaultCardRsp: [setUserFlagRsp] setFlag=");
            paramObject.append(CustomCoverFragment.j(this.a));
            QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, paramObject.toString());
          }
          CustomCoverFragment.b(this.a, true);
          QQToast.makeText((Context)localObject1, 0, 2131917578, 0).show();
          if (CustomCoverFragment.j(this.a))
          {
            paramObject = this.a;
            CustomCoverFragment.a(paramObject, CustomCoverFragment.j(paramObject));
            return;
          }
          paramObject = this.a;
          CustomCoverFragment.a(paramObject, CustomCoverFragment.j(paramObject));
          if (CustomCoverFragment.e(this.a) != null) {
            CustomCoverFragment.e(this.a).sendEmptyMessage(101);
          }
        }
        else if (this.a.getActivity() != null)
        {
          QQToast.makeText(this.a.getActivity(), 1, 2131917575, 0).show();
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDefaultCardRsp: isSuccess=false, cmd=");
        ((StringBuilder)localObject2).append(paramObject);
        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, ((StringBuilder)localObject2).toString());
      }
      if ("profilelogic.readUserInfo".equals(paramObject))
      {
        CustomCoverFragment.c(this.a, 1);
        this.a.stopTitleProgress();
        QQToast.makeText((Context)localObject1, 1, 2131917225, 0).show();
        return;
      }
      QQToast.makeText((Context)localObject1, 1, 2131917575, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.1
 * JD-Core Version:    0.7.0.1
 */