package com.tencent.mobileqq.kandian.biz.pts.nativemodule;

import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.pts.PTSFragment;
import com.tencent.pts.nativemodule.IPTSNavigateTo;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class PTSNavigateToModule
  implements IPTSNavigateTo
{
  public void navigateTo(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[navigateTo], url = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("PTSNavigateToModule", 1, ((StringBuilder)localObject).toString());
    paramString = Pattern.compile("\\/").split(paramString);
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[(paramString.length - 1)];
      localObject = new Intent();
      ((Intent)localObject).putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName", paramString);
      PublicFragmentActivity.a(BaseActivity.sTopActivity, (Intent)localObject, PTSFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSNavigateToModule
 * JD-Core Version:    0.7.0.1
 */