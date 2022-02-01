package com.tencent.mobileqq.hiboom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;

class FontBubbleManager$3
  implements DialogInterface.OnClickListener
{
  FontBubbleManager$3(FontBubbleManager paramFontBubbleManager, BaseChatPie paramBaseChatPie, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "/vas/h5pay");
    localActivityURIRequest.extra().putString("url", this.jdField_a_of_type_JavaLangString);
    QRoute.startUri(localActivityURIRequest, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubbleManager.3
 * JD-Core Version:    0.7.0.1
 */