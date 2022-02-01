package com.tencent.mobileqq.profile;

import ProfileLogic.QC.setUserProfileRsp;
import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.SVIPObserver;

class CoverDetailFragment$3
  extends SVIPObserver
{
  CoverDetailFragment$3(CoverDetailFragment paramCoverDetailFragment) {}
  
  public void onDefaultCardRsp(boolean paramBoolean, Object paramObject)
  {
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramObject instanceof setUserProfileRsp))
      {
        int i = ((setUserProfileRsp)paramObject).ret;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("onDefaultCardRsp: [setUserProfileRsp] ret=");
          paramObject.append(i);
          QLog.d("Q.profilecard.FrdProfileCard.CoverDetailFragment", 0, paramObject.toString());
        }
        if (i == 0)
        {
          paramObject = new Intent();
          paramObject.putExtra("cover_id_key", CoverDetailFragment.e(this.a));
          localBaseActivity.setResult(-1, paramObject);
          localBaseActivity.finish();
          return;
        }
        CoverDetailFragment.a(this.a, localBaseActivity);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDefaultCardRsp: isSuccess=false, cmd=");
        localStringBuilder.append(paramObject);
        QLog.d("Q.profilecard.FrdProfileCard.CoverDetailFragment", 0, localStringBuilder.toString());
      }
      if ("profilelogic.setUserProfile".equals(paramObject)) {
        CoverDetailFragment.a(this.a, localBaseActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CoverDetailFragment.3
 * JD-Core Version:    0.7.0.1
 */