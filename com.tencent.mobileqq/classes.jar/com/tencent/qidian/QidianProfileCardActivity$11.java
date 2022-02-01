package com.tencent.qidian;

import android.text.TextUtils;
import com.tencent.qidian.data.CompanyShowCaseInfo;

class QidianProfileCardActivity$11
  implements PhotoWallViewForQiDianProfile.PhotoWallCallback
{
  QidianProfileCardActivity$11(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void a(CompanyShowCaseInfo paramCompanyShowCaseInfo)
  {
    if (paramCompanyShowCaseInfo != null)
    {
      paramCompanyShowCaseInfo = paramCompanyShowCaseInfo.b;
      if (!TextUtils.isEmpty(paramCompanyShowCaseInfo)) {
        QidianProfileCardActivity.a(this.a, paramCompanyShowCaseInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.11
 * JD-Core Version:    0.7.0.1
 */