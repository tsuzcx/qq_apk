package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewCreationRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewResizeRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewTouch;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.HashMap;

class PlatformViewsController$1
  implements PlatformViewsChannel.PlatformViewsHandler
{
  PlatformViewsController$1(PlatformViewsController paramPlatformViewsController) {}
  
  private void ensureValidAndroidVersion(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= paramInt) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Trying to use platform views with API ");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append(", required API level is: ");
    localStringBuilder.append(paramInt);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void clearFocus(int paramInt)
  {
    ensureValidAndroidVersion(20);
    ((VirtualDisplayController)this.this$0.vdControllers.get(Integer.valueOf(paramInt))).getView().clearFocus();
  }
  
  public void createAndroidViewForPlatformView(@NonNull PlatformViewsChannel.PlatformViewCreationRequest paramPlatformViewCreationRequest)
  {
    ensureValidAndroidVersion(19);
    if (PlatformViewsController.access$000(paramPlatformViewCreationRequest.direction))
    {
      PlatformViewFactory localPlatformViewFactory = PlatformViewsController.access$100(this.this$0).getFactory(paramPlatformViewCreationRequest.viewType);
      if (localPlatformViewFactory != null)
      {
        localObject = null;
        if (paramPlatformViewCreationRequest.params != null) {
          localObject = localPlatformViewFactory.getCreateArgsCodec().decodeMessage(paramPlatformViewCreationRequest.params);
        }
        localObject = localPlatformViewFactory.create(PlatformViewsController.access$200(this.this$0), paramPlatformViewCreationRequest.viewId, localObject);
        PlatformViewsController.access$300(this.this$0).put(paramPlatformViewCreationRequest.viewId, localObject);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Trying to create a platform view of unregistered type: ");
      ((StringBuilder)localObject).append(paramPlatformViewCreationRequest.viewType);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Trying to create a view with unknown direction value: ");
    ((StringBuilder)localObject).append(paramPlatformViewCreationRequest.direction);
    ((StringBuilder)localObject).append("(view id: ");
    ((StringBuilder)localObject).append(paramPlatformViewCreationRequest.viewId);
    ((StringBuilder)localObject).append(")");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  @TargetApi(17)
  public long createVirtualDisplayForPlatformView(@NonNull PlatformViewsChannel.PlatformViewCreationRequest paramPlatformViewCreationRequest)
  {
    ensureValidAndroidVersion(20);
    if (PlatformViewsController.access$000(paramPlatformViewCreationRequest.direction))
    {
      if (!this.this$0.vdControllers.containsKey(Integer.valueOf(paramPlatformViewCreationRequest.viewId)))
      {
        PlatformViewFactory localPlatformViewFactory = PlatformViewsController.access$100(this.this$0).getFactory(paramPlatformViewCreationRequest.viewType);
        if (localPlatformViewFactory != null)
        {
          localObject = null;
          if (paramPlatformViewCreationRequest.params != null) {
            localObject = localPlatformViewFactory.getCreateArgsCodec().decodeMessage(paramPlatformViewCreationRequest.params);
          }
          int i = PlatformViewsController.access$500(this.this$0, paramPlatformViewCreationRequest.logicalWidth);
          int j = PlatformViewsController.access$500(this.this$0, paramPlatformViewCreationRequest.logicalHeight);
          PlatformViewsController.access$600(this.this$0, i, j);
          TextureRegistry.SurfaceTextureEntry localSurfaceTextureEntry = PlatformViewsController.access$700(this.this$0).createSurfaceTexture();
          localObject = VirtualDisplayController.create(PlatformViewsController.access$200(this.this$0), PlatformViewsController.access$800(this.this$0), localPlatformViewFactory, localSurfaceTextureEntry, i, j, paramPlatformViewCreationRequest.viewId, localObject, new PlatformViewsController.1.1(this, paramPlatformViewCreationRequest));
          if (localObject != null)
          {
            if (PlatformViewsController.access$1000(this.this$0) != null) {
              ((VirtualDisplayController)localObject).onFlutterViewAttached(PlatformViewsController.access$1000(this.this$0));
            }
            this.this$0.vdControllers.put(Integer.valueOf(paramPlatformViewCreationRequest.viewId), localObject);
            localObject = ((VirtualDisplayController)localObject).getView();
            ((View)localObject).setLayoutDirection(paramPlatformViewCreationRequest.direction);
            PlatformViewsController.access$1100(this.this$0).put(((View)localObject).getContext(), localObject);
            return localSurfaceTextureEntry.id();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed creating virtual display for a ");
          ((StringBuilder)localObject).append(paramPlatformViewCreationRequest.viewType);
          ((StringBuilder)localObject).append(" with id: ");
          ((StringBuilder)localObject).append(paramPlatformViewCreationRequest.viewId);
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Trying to create a platform view of unregistered type: ");
        ((StringBuilder)localObject).append(paramPlatformViewCreationRequest.viewType);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Trying to create an already created platform view, view id: ");
      ((StringBuilder)localObject).append(paramPlatformViewCreationRequest.viewId);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Trying to create a view with unknown direction value: ");
    ((StringBuilder)localObject).append(paramPlatformViewCreationRequest.direction);
    ((StringBuilder)localObject).append("(view id: ");
    ((StringBuilder)localObject).append(paramPlatformViewCreationRequest.viewId);
    ((StringBuilder)localObject).append(")");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void disposeAndroidViewForPlatformView(int paramInt)
  {
    PlatformView localPlatformView = (PlatformView)PlatformViewsController.access$300(this.this$0).get(paramInt);
    FlutterMutatorView localFlutterMutatorView = (FlutterMutatorView)PlatformViewsController.access$400(this.this$0).get(paramInt);
    if (localPlatformView != null)
    {
      if (localFlutterMutatorView != null) {
        localFlutterMutatorView.removeView(localPlatformView.getView());
      }
      PlatformViewsController.access$300(this.this$0).remove(paramInt);
      localPlatformView.dispose();
    }
    if (localFlutterMutatorView != null)
    {
      ((ViewGroup)localFlutterMutatorView.getParent()).removeView(localFlutterMutatorView);
      PlatformViewsController.access$400(this.this$0).remove(paramInt);
    }
  }
  
  public void disposeVirtualDisplayForPlatformView(int paramInt)
  {
    ensureValidAndroidVersion(20);
    Object localObject = (VirtualDisplayController)this.this$0.vdControllers.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      if (PlatformViewsController.access$1200(this.this$0) != null) {
        PlatformViewsController.access$1200(this.this$0).clearPlatformViewClient(paramInt);
      }
      PlatformViewsController.access$1100(this.this$0).remove(((VirtualDisplayController)localObject).getView().getContext());
      ((VirtualDisplayController)localObject).dispose();
      this.this$0.vdControllers.remove(Integer.valueOf(paramInt));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Trying to dispose a platform view with unknown id: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void onTouch(@NonNull PlatformViewsChannel.PlatformViewTouch paramPlatformViewTouch)
  {
    int i = paramPlatformViewTouch.viewId;
    float f = PlatformViewsController.access$200(this.this$0).getResources().getDisplayMetrics().density;
    ensureValidAndroidVersion(20);
    MotionEvent localMotionEvent;
    if (this.this$0.vdControllers.containsKey(Integer.valueOf(i)))
    {
      localMotionEvent = this.this$0.toMotionEvent(f, paramPlatformViewTouch, true);
      ((VirtualDisplayController)this.this$0.vdControllers.get(Integer.valueOf(paramPlatformViewTouch.viewId))).dispatchTouchEvent(localMotionEvent);
    }
    do
    {
      return;
      if (PlatformViewsController.access$300(this.this$0).get(i) == null) {
        break;
      }
      localMotionEvent = this.this$0.toMotionEvent(f, paramPlatformViewTouch, false);
      paramPlatformViewTouch = ((PlatformView)PlatformViewsController.access$300(this.this$0).get(paramPlatformViewTouch.viewId)).getView();
    } while (paramPlatformViewTouch == null);
    paramPlatformViewTouch.dispatchTouchEvent(localMotionEvent);
    return;
    paramPlatformViewTouch = new StringBuilder();
    paramPlatformViewTouch.append("Sending touch to an unknown view with id: ");
    paramPlatformViewTouch.append(i);
    throw new IllegalStateException(paramPlatformViewTouch.toString());
  }
  
  public void resizePlatformView(@NonNull PlatformViewsChannel.PlatformViewResizeRequest paramPlatformViewResizeRequest, @NonNull Runnable paramRunnable)
  {
    ensureValidAndroidVersion(20);
    VirtualDisplayController localVirtualDisplayController = (VirtualDisplayController)this.this$0.vdControllers.get(Integer.valueOf(paramPlatformViewResizeRequest.viewId));
    if (localVirtualDisplayController != null)
    {
      int i = PlatformViewsController.access$500(this.this$0, paramPlatformViewResizeRequest.newLogicalWidth);
      int j = PlatformViewsController.access$500(this.this$0, paramPlatformViewResizeRequest.newLogicalHeight);
      PlatformViewsController.access$600(this.this$0, i, j);
      PlatformViewsController.access$1300(this.this$0, localVirtualDisplayController);
      localVirtualDisplayController.resize(i, j, new PlatformViewsController.1.2(this, localVirtualDisplayController, paramRunnable));
      return;
    }
    paramRunnable = new StringBuilder();
    paramRunnable.append("Trying to resize a platform view with unknown id: ");
    paramRunnable.append(paramPlatformViewResizeRequest.viewId);
    throw new IllegalStateException(paramRunnable.toString());
  }
  
  @TargetApi(17)
  public void setDirection(int paramInt1, int paramInt2)
  {
    if (PlatformViewsController.access$000(paramInt2))
    {
      ensureValidAndroidVersion(20);
      localObject = ((VirtualDisplayController)this.this$0.vdControllers.get(Integer.valueOf(paramInt1))).getView();
      if (localObject != null)
      {
        ((View)localObject).setLayoutDirection(paramInt2);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Sending touch to an unknown view with id: ");
      ((StringBuilder)localObject).append(paramInt2);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Trying to set unknown direction value: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("(view id: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(")");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewsController.1
 * JD-Core Version:    0.7.0.1
 */