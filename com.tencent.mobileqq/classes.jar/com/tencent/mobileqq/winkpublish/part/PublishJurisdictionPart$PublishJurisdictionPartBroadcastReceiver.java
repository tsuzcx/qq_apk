package com.tencent.mobileqq.winkpublish.part;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

class PublishJurisdictionPart$PublishJurisdictionPartBroadcastReceiver
  extends BroadcastReceiver
{
  public PublishJurisdictionPart$PublishJurisdictionPartBroadcastReceiver(PublishJurisdictionPart paramPublishJurisdictionPart) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (TextUtils.equals(paramIntent.getAction(), "ACTION_USER_PUBLISH_DISABLE_INFO")) {
      try
      {
        Object localObject = paramIntent.getBundleExtra("disableRightInfo");
        paramContext = ((Bundle)localObject).getString("disableNickName");
        paramIntent = ((Bundle)localObject).getString("disableGroupName");
        String str1 = ((Bundle)localObject).getString("disableUinId");
        String str2 = ((Bundle)localObject).getString("disableGroupId");
        localObject = ((Bundle)localObject).getString("disableUinNumber");
        this.a.a(paramContext, paramIntent, str1, str2, (String)localObject);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishJurisdictionPart.PublishJurisdictionPartBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */