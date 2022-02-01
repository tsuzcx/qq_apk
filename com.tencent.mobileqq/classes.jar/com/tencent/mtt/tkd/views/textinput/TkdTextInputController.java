package com.tencent.mtt.tkd.views.textinput;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;

@HippyController(name="tkdTextInput")
public class TkdTextInputController
  extends HippyTextInputController
{
  public static final String CLASS_NAME = "tkdTextInput";
  
  public View createViewImpl(Context paramContext)
  {
    return new TkdTextInput(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.textinput.TkdTextInputController
 * JD-Core Version:    0.7.0.1
 */