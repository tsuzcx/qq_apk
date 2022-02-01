package com.tencent.qqmini.flutter.core.page.tissue;

import com.tencent.qqmini.flutter.core.NativeAppBrandRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import java.util.Map;

class TissuePageContainer$5
  implements Action<Object>
{
  TissuePageContainer$5(TissuePageContainer paramTissuePageContainer, String paramString, Map paramMap) {}
  
  public Object perform(BaseRuntime paramBaseRuntime)
  {
    ((NativeAppBrandRuntime)paramBaseRuntime).sendMsgToFlutter(this.val$message, this.val$params);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer.5
 * JD-Core Version:    0.7.0.1
 */