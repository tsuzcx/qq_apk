package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;

class AIOEmoticonPanelHelper$1
  implements DialogInterface.OnClickListener
{
  AIOEmoticonPanelHelper$1(AIOEmoticonPanelHelper paramAIOEmoticonPanelHelper, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QRoute.startUri(new ActivityURIRequest(this.val$context, "/base/activity/FavEmosmManageActivity"), null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper.1
 * JD-Core Version:    0.7.0.1
 */