package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.util.StateSet;
import android.widget.Button;

public class FadedButton
  extends Button
{
  public FadedButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (StateSet.stateSetMatches(PRESSED_WINDOW_FOCUSED_STATE_SET, arrayOfInt))
    {
      setAlpha(0.2588235F);
      return;
    }
    setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.FadedButton
 * JD-Core Version:    0.7.0.1
 */