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
        if (CustomCoverFragment.a(this.a))
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
          ProfileCardManager.a = paramObject.urlprefix;
        }
        CustomCoverFragment.a(this.a, paramObject.itemlist);
        if (CustomCoverFragment.a(this.a) != null) {
          if (CustomCoverFragment.a(this.a).size() == 0)
          {
            CustomCoverFragment.a(this.a).setVisibility(8);
            CustomCoverFragment.c(this.a, 2);
          }
          else
          {
            CustomCoverFragment.a(this.a).setVisibility(0);
          }
        }
        if (CustomCoverFragment.a(this.a) != null) {
          CustomCoverFragment.a(this.a).sendEmptyMessage(101);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onDefaultCardRsp: [readUserInfoRsp] selId=");
          ((StringBuilder)localObject1).append(CustomCoverFragment.a(this.a));
          ((StringBuilder)localObject1).append(" reqIndex=");
          ((StringBuilder)localObject1).append(CustomCoverFragment.b(this.a));
          ((StringBuilder)localObject1).append(" footerState=");
          ((StringBuilder)localObject1).append(CustomCoverFragment.c(this.a));
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
            paramObject.append(CustomCoverFragment.a(this.a));
            QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, paramObject.toString());
          }
          paramObject = new Intent();
          paramObject.putExtra("req_code_key", 2002);
          localObject2 = this.a;
          paramObject.putExtra("card_url_key", ((CustomCoverFragment)localObject2).a(CustomCoverFragment.d((CustomCoverFragment)localObject2)));
          ((BaseActivity)localObject1).setResult(-1, paramObject);
          ((BaseActivity)localObject1).finish();
          return;
        }
        if (this.a.getActivity() != null) {
          QQToast.a(this.a.getActivity(), 1, 2131719970, 0).a();
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
            paramObject.append(CustomCoverFragment.b(this.a));
            QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, paramObject.toString());
          }
          CustomCoverFragment.a(this.a, true);
          QQToast.a((Context)localObject1, 0, 2131719973, 0).a();
          if (CustomCoverFragment.b(this.a))
          {
            paramObject = this.a;
            CustomCoverFragment.a(paramObject, CustomCoverFragment.b(paramObject));
            return;
          }
          paramObject = this.a;
          CustomCoverFragment.a(paramObject, CustomCoverFragment.b(paramObject));
          if (CustomCoverFragment.a(this.a) != null) {
            CustomCoverFragment.a(this.a).sendEmptyMessage(101);
          }
        }
        else if (this.a.getActivity() != null)
        {
          QQToast.a(this.a.getActivity(), 1, 2131719970, 0).a();
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
        QQToast.a((Context)localObject1, 1, 2131719628, 0).a();
        return;
      }
      QQToast.a((Context)localObject1, 1, 2131719970, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.1
 * JD-Core Version:    0.7.0.1
 */