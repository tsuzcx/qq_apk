package com.tencent.mtt.tkd.views.modal;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.modal.HippyModalHostManager;

@HippyController(name="tkdModal")
public class TkdModalHostManager
  extends HippyModalHostManager
{
  public static final String CLASS_NAME = "tkdModal";
  
  public View createViewImpl(Context paramContext)
  {
    paramContext = new TkdModalHostView(paramContext);
    paramContext.setOnRequestCloseListener(new TkdModalHostManager.1(this, paramContext));
    paramContext.setOnShowListener(new TkdModalHostManager.2(this, paramContext));
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.modal.TkdModalHostManager
 * JD-Core Version:    0.7.0.1
 */