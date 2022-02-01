package com.tencent.timi.game.net.api;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.NewIntent;

public class BaseTimiGameServlet$CreateReqIntentUtil
{
  public static NewIntent a(MessageMicro paramMessageMicro, Class<? extends BaseTimiGameServlet> paramClass)
  {
    paramClass = new NewIntent(BaseApplication.getContext(), paramClass);
    paramClass.putExtra("bytes", paramMessageMicro.toByteArray());
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil
 * JD-Core Version:    0.7.0.1
 */