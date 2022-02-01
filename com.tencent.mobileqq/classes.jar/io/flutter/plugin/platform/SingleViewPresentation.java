package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;

@TargetApi(17)
@Keep
class SingleViewPresentation
  extends Presentation
{
  private final AccessibilityEventsDelegate accessibilityEventsDelegate;
  private FrameLayout container;
  private Object createParams;
  private final View.OnFocusChangeListener focusChangeListener;
  private SingleViewPresentation.AccessibilityDelegatingFrameLayout rootView;
  private boolean startFocused = false;
  private SingleViewPresentation.PresentationState state;
  private final PlatformViewFactory viewFactory;
  private int viewId;
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, SingleViewPresentation.PresentationState paramPresentationState, View.OnFocusChangeListener paramOnFocusChangeListener, boolean paramBoolean)
  {
    super(new SingleViewPresentation.ImmContext(paramContext), paramDisplay);
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.viewFactory = null;
    this.state = paramPresentationState;
    this.focusChangeListener = paramOnFocusChangeListener;
    getWindow().setFlags(8, 8);
    this.startFocused = paramBoolean;
  }
  
  public SingleViewPresentation(Context paramContext, Display paramDisplay, PlatformViewFactory paramPlatformViewFactory, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, int paramInt, Object paramObject, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    super(new SingleViewPresentation.ImmContext(paramContext), paramDisplay);
    this.viewFactory = paramPlatformViewFactory;
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.viewId = paramInt;
    this.createParams = paramObject;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.state = new SingleViewPresentation.PresentationState();
    getWindow().setFlags(8, 8);
  }
  
  public SingleViewPresentation.PresentationState detachState()
  {
    this.container.removeAllViews();
    this.rootView.removeAllViews();
    return this.state;
  }
  
  public PlatformView getView()
  {
    if (SingleViewPresentation.PresentationState.access$200(this.state) == null) {
      return null;
    }
    return SingleViewPresentation.PresentationState.access$200(this.state);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (SingleViewPresentation.PresentationState.access$000(this.state) == null) {
      SingleViewPresentation.PresentationState.access$002(this.state, new SingleViewPresentation.FakeWindowViewGroup(getContext()));
    }
    if (SingleViewPresentation.PresentationState.access$100(this.state) == null)
    {
      paramBundle = (WindowManager)getContext().getSystemService("window");
      SingleViewPresentation.PresentationState.access$102(this.state, new SingleViewPresentation.WindowManagerHandler(paramBundle, SingleViewPresentation.PresentationState.access$000(this.state)));
    }
    this.container = new FrameLayout(getContext());
    paramBundle = new SingleViewPresentation.PresentationContext(getContext(), SingleViewPresentation.PresentationState.access$100(this.state));
    if (SingleViewPresentation.PresentationState.access$200(this.state) == null) {
      SingleViewPresentation.PresentationState.access$202(this.state, this.viewFactory.create(paramBundle, this.viewId, this.createParams));
    }
    paramBundle = SingleViewPresentation.PresentationState.access$200(this.state).getView();
    this.container.addView(paramBundle);
    this.rootView = new SingleViewPresentation.AccessibilityDelegatingFrameLayout(getContext(), this.accessibilityEventsDelegate, paramBundle);
    this.rootView.addView(this.container);
    this.rootView.addView(SingleViewPresentation.PresentationState.access$000(this.state));
    paramBundle.setOnFocusChangeListener(this.focusChangeListener);
    this.rootView.setFocusableInTouchMode(true);
    if (this.startFocused) {
      paramBundle.requestFocus();
    }
    for (;;)
    {
      setContentView(this.rootView);
      return;
      this.rootView.requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation
 * JD-Core Version:    0.7.0.1
 */