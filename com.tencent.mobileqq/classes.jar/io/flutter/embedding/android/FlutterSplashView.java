package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

final class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  @NonNull
  private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener = new FlutterSplashView.1(this);
  @NonNull
  private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterSplashView.2(this);
  @Nullable
  private FlutterView flutterView;
  @NonNull
  private final Runnable onTransitionComplete = new FlutterSplashView.3(this);
  @Nullable
  private String previousCompletedSplashIsolate;
  @Nullable
  private SplashScreen splashScreen;
  @Nullable
  private Bundle splashScreenState;
  @Nullable
  private View splashScreenView;
  @Nullable
  private String transitioningIsolateId;
  
  public FlutterSplashView(@NonNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public FlutterSplashView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlutterSplashView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSaveEnabled(true);
  }
  
  private boolean hasSplashCompleted()
  {
    FlutterView localFlutterView = this.flutterView;
    if (localFlutterView != null)
    {
      if (localFlutterView.isAttachedToFlutterEngine()) {
        return (this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null) && (this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.previousCompletedSplashIsolate));
      }
      throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }
    throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
  }
  
  private boolean isSplashScreenNeededNow()
  {
    FlutterView localFlutterView = this.flutterView;
    return (localFlutterView != null) && (localFlutterView.isAttachedToFlutterEngine()) && (!this.flutterView.hasRenderedFirstFrame()) && (!hasSplashCompleted());
  }
  
  private boolean isSplashScreenTransitionNeededNow()
  {
    Object localObject = this.flutterView;
    if ((localObject != null) && (((FlutterView)localObject).isAttachedToFlutterEngine()))
    {
      localObject = this.splashScreen;
      if ((localObject != null) && (((SplashScreen)localObject).doesSplashViewRememberItsTransition()) && (wasPreviousSplashTransitionInterrupted())) {
        return true;
      }
    }
    return false;
  }
  
  private void transitionToFlutter()
  {
    this.transitioningIsolateId = this.flutterView.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Transitioning splash screen to a Flutter UI. Isolate: ");
    localStringBuilder.append(this.transitioningIsolateId);
    Log.v(str, localStringBuilder.toString());
    this.splashScreen.transitionToFlutter(this.onTransitionComplete);
  }
  
  private boolean wasPreviousSplashTransitionInterrupted()
  {
    FlutterView localFlutterView = this.flutterView;
    if (localFlutterView != null)
    {
      if (localFlutterView.isAttachedToFlutterEngine()) {
        return (this.flutterView.hasRenderedFirstFrame()) && (!hasSplashCompleted());
      }
      throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }
    throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
  }
  
  public void displayFlutterViewWithSplash(@NonNull FlutterView paramFlutterView, @Nullable SplashScreen paramSplashScreen)
  {
    Object localObject = this.flutterView;
    if (localObject != null)
    {
      ((FlutterView)localObject).removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
      removeView(this.flutterView);
    }
    localObject = this.splashScreenView;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.flutterView = paramFlutterView;
    addView(paramFlutterView);
    this.splashScreen = paramSplashScreen;
    if (paramSplashScreen != null)
    {
      if (isSplashScreenNeededNow())
      {
        Log.v(TAG, "Showing splash screen UI.");
        this.splashScreenView = paramSplashScreen.createSplashView(getContext(), this.splashScreenState);
        addView(this.splashScreenView);
        paramFlutterView.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
        return;
      }
      if (isSplashScreenTransitionNeededNow())
      {
        Log.v(TAG, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
        this.splashScreenView = paramSplashScreen.createSplashView(getContext(), this.splashScreenState);
        addView(this.splashScreenView);
        transitionToFlutter();
        return;
      }
      if (!paramFlutterView.isAttachedToFlutterEngine())
      {
        Log.v(TAG, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
        paramFlutterView.addFlutterEngineAttachmentListener(this.flutterEngineAttachmentListener);
      }
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (FlutterSplashView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.previousCompletedSplashIsolate = FlutterSplashView.SavedState.access$600(paramParcelable);
    this.splashScreenState = FlutterSplashView.SavedState.access$700(paramParcelable);
  }
  
  @Nullable
  protected Parcelable onSaveInstanceState()
  {
    FlutterSplashView.SavedState localSavedState = new FlutterSplashView.SavedState(super.onSaveInstanceState());
    FlutterSplashView.SavedState.access$602(localSavedState, this.previousCompletedSplashIsolate);
    Object localObject = this.splashScreen;
    if (localObject != null) {
      localObject = ((SplashScreen)localObject).saveSplashScreenState();
    } else {
      localObject = null;
    }
    FlutterSplashView.SavedState.access$702(localSavedState, (Bundle)localObject);
    return localSavedState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView
 * JD-Core Version:    0.7.0.1
 */