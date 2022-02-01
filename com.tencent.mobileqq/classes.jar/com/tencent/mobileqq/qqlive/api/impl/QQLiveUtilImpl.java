package com.tencent.mobileqq.qqlive.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qqlive.end.EndLiveHelper;
import com.tencent.mobileqq.qqlive.end.QQLiveEndFragment;
import com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment;
import com.tencent.mobileqq.qqlive.prepare.covercrop.QQLivePhotoCropFragment;
import com.tencent.qphone.base.util.QLog;

public class QQLiveUtilImpl
  implements IQQLiveUtil
{
  private static final String TAG = "QQLiveUtilImpl";
  
  public boolean checkAvEnable(Context paramContext)
  {
    String str1 = AVBizModuleFactory.getModuleByName("QQ直播").checkAVFocus();
    if (!"true".equals(str1))
    {
      String str2 = String.format(paramContext.getResources().getString(2131887170), new Object[] { str1 });
      ThreadManagerV2.getUIHandlerV2().post(new QQLiveUtilImpl.1(this, paramContext, str2));
      paramContext = new StringBuilder();
      paramContext.append("preCheckIsUserGamePlaying, res[");
      paramContext.append(str1);
      paramContext.append("]");
      QLog.e("QQLiveUtilImpl", 1, paramContext.toString());
      return false;
    }
    return true;
  }
  
  public void enterAnchorPrepareFragment(Context paramContext, boolean paramBoolean, Intent paramIntent)
  {
    QQLivePrepareFragment.a(paramContext, paramBoolean, paramIntent);
  }
  
  public void enterCropFragment(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("room_id", paramString2);
    QQLivePhotoCropFragment.a(paramActivity, localIntent, paramInt);
  }
  
  public void enterLiveEndFragment(Context paramContext, boolean paramBoolean, Intent paramIntent, QQLiveEndPageInfo paramQQLiveEndPageInfo)
  {
    QQLiveEndFragment.a(paramContext, paramBoolean, paramIntent, paramQQLiveEndPageInfo);
  }
  
  public IQQLiveEndView getAudienceEndLiveView(Context paramContext, IQQLiveSDK paramIQQLiveSDK, QQLiveEndPageInfo paramQQLiveEndPageInfo, EndLiveClickCallback paramEndLiveClickCallback)
  {
    return new EndLiveHelper().a(paramContext, paramIQQLiveSDK, paramQQLiveEndPageInfo, paramEndLiveClickCallback);
  }
  
  public IQQLiveEndView getEndLiveView(QBaseActivity paramQBaseActivity, IQQLiveSDK paramIQQLiveSDK, QQLiveEndPageInfo paramQQLiveEndPageInfo, EndLiveClickCallback paramEndLiveClickCallback)
  {
    return new EndLiveHelper().a(paramQBaseActivity, paramIQQLiveSDK, paramQQLiveEndPageInfo, paramEndLiveClickCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.QQLiveUtilImpl
 * JD-Core Version:    0.7.0.1
 */