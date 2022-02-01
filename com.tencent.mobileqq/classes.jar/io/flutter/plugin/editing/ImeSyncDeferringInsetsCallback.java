package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Insets;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import android.view.WindowInsets.Builder;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation.Callback;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi", "Override"})
@TargetApi(30)
@Keep
@RequiresApi(30)
@VisibleForTesting
class ImeSyncDeferringInsetsCallback
  extends WindowInsetsAnimation.Callback
  implements View.OnApplyWindowInsetsListener
{
  private boolean animating = false;
  private int deferredInsetTypes;
  private WindowInsets lastWindowInsets;
  private boolean needsSave = false;
  private int overlayInsetTypes;
  private View view;
  
  ImeSyncDeferringInsetsCallback(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    super(1);
    this.overlayInsetTypes = paramInt1;
    this.deferredInsetTypes = paramInt2;
    this.view = paramView;
  }
  
  void install()
  {
    this.view.setWindowInsetsAnimationCallback(this);
    this.view.setOnApplyWindowInsetsListener(this);
  }
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    this.view = paramView;
    if (this.needsSave)
    {
      this.lastWindowInsets = paramWindowInsets;
      this.needsSave = false;
    }
    if (this.animating) {
      return WindowInsets.CONSUMED;
    }
    return paramView.onApplyWindowInsets(paramWindowInsets);
  }
  
  public void onEnd(WindowInsetsAnimation paramWindowInsetsAnimation)
  {
    if ((this.animating) && ((paramWindowInsetsAnimation.getTypeMask() & this.deferredInsetTypes) != 0))
    {
      this.animating = false;
      if ((this.lastWindowInsets != null) && (this.view != null)) {
        this.view.dispatchApplyWindowInsets(this.lastWindowInsets);
      }
    }
  }
  
  public void onPrepare(WindowInsetsAnimation paramWindowInsetsAnimation)
  {
    if ((paramWindowInsetsAnimation.getTypeMask() & this.deferredInsetTypes) != 0)
    {
      this.animating = true;
      this.needsSave = true;
    }
  }
  
  public WindowInsets onProgress(WindowInsets paramWindowInsets, List<WindowInsetsAnimation> paramList)
  {
    if ((!this.animating) || (this.needsSave)) {}
    int i;
    do
    {
      return paramWindowInsets;
      paramList = paramList.iterator();
      i = 0;
      while (paramList.hasNext()) {
        if ((((WindowInsetsAnimation)paramList.next()).getTypeMask() & this.deferredInsetTypes) != 0) {
          i = 1;
        }
      }
    } while (i == 0);
    paramList = new WindowInsets.Builder(this.lastWindowInsets);
    Insets localInsets = Insets.of(0, 0, 0, Math.max(paramWindowInsets.getInsets(this.deferredInsetTypes).bottom - paramWindowInsets.getInsets(this.overlayInsetTypes).bottom, 0));
    paramList.setInsets(this.deferredInsetTypes, localInsets);
    this.view.onApplyWindowInsets(paramList.build());
    return paramWindowInsets;
  }
  
  void remove()
  {
    this.view.setWindowInsetsAnimationCallback(null);
    this.view.setOnApplyWindowInsetsListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.editing.ImeSyncDeferringInsetsCallback
 * JD-Core Version:    0.7.0.1
 */