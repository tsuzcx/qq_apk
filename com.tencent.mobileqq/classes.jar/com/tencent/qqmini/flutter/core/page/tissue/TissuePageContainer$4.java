package com.tencent.qqmini.flutter.core.page.tissue;

import com.tencent.qqmini.flutter.core.NativeAppBrandRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

class TissuePageContainer$4
  implements Action<Object>
{
  TissuePageContainer$4(TissuePageContainer paramTissuePageContainer, String paramString) {}
  
  public Object perform(BaseRuntime paramBaseRuntime)
  {
    ((NativeAppBrandRuntime)paramBaseRuntime).flutterLoadData(this.val$jsonParams);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer.4
 * JD-Core Version:    0.7.0.1
 */