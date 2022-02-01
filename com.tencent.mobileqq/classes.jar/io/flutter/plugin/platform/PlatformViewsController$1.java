package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewCreationRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewResizeRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewTouch;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.HashMap;
import java.util.List;

class PlatformViewsController$1
  implements PlatformViewsChannel.PlatformViewsHandler
{
  PlatformViewsController$1(PlatformViewsController paramPlatformViewsController) {}
  
  private void ensureValidAndroidVersion()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Trying to use platform views with API ");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append(", required API level is: ");
    localStringBuilder.append(20);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void clearFocus(int paramInt)
  {
    ((VirtualDisplayController)this.this$0.vdControllers.get(Integer.valueOf(paramInt))).getView().clearFocus();
  }
  
  @TargetApi(17)
  public long createPlatformView(@NonNull PlatformViewsChannel.PlatformViewCreationRequest paramPlatformViewCreationRequest)
  {
    ensureValidAndroidVersion();
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
          int i = PlatformViewsController.access$200(this.this$0, paramPlatformViewCreationRequest.logicalWidth);
          int j = PlatformViewsController.access$200(this.this$0, paramPlatformViewCreationRequest.logicalHeight);
          PlatformViewsController.access$300(this.this$0, i, j);
          TextureRegistry.SurfaceTextureEntry localSurfaceTextureEntry = PlatformViewsController.access$400(this.this$0).createSurfaceTexture();
          localObject = VirtualDisplayController.create(PlatformViewsController.access$500(this.this$0), PlatformViewsController.access$600(this.this$0), localPlatformViewFactory, localSurfaceTextureEntry, i, j, paramPlatformViewCreationRequest.viewId, localObject, new PlatformViewsController.VirtualDisplayViewFocusListener(this.this$0, paramPlatformViewCreationRequest.viewId, PlatformViewsController.access$700(this.this$0)));
          if (localObject != null)
          {
            if (PlatformViewsController.access$800(this.this$0) != null) {
              ((VirtualDisplayController)localObject).onFlutterViewAttached(PlatformViewsController.access$800(this.this$0));
            }
            this.this$0.vdControllers.put(Integer.valueOf(paramPlatformViewCreationRequest.viewId), localObject);
            localObject = ((VirtualDisplayController)localObject).getView();
            ((View)localObject).setLayoutDirection(paramPlatformViewCreationRequest.direction);
            PlatformViewsController.access$900(this.this$0).put(((View)localObject).getContext(), localObject);
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
  
  public void disposePlatformView(int paramInt)
  {
    ensureValidAndroidVersion();
    Object localObject = (VirtualDisplayController)this.this$0.vdControllers.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      if (PlatformViewsController.access$1000(this.this$0) != null) {
        PlatformViewsController.access$1000(this.this$0).clearPlatformViewClient(paramInt);
      }
      PlatformViewsController.access$900(this.this$0).remove(((VirtualDisplayController)localObject).getView().getContext());
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
    ensureValidAndroidVersion();
    float f = PlatformViewsController.access$500(this.this$0).getResources().getDisplayMetrics().density;
    Object localObject = (MotionEvent.PointerProperties[])PlatformViewsController.access$1300(paramPlatformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[paramPlatformViewTouch.pointerCount]);
    MotionEvent.PointerCoords[] arrayOfPointerCoords = (MotionEvent.PointerCoords[])PlatformViewsController.access$1400(paramPlatformViewTouch.rawPointerCoords, f).toArray(new MotionEvent.PointerCoords[paramPlatformViewTouch.pointerCount]);
    if (this.this$0.vdControllers.containsKey(Integer.valueOf(paramPlatformViewTouch.viewId)))
    {
      ((VirtualDisplayController)this.this$0.vdControllers.get(Integer.valueOf(paramPlatformViewTouch.viewId))).getView().dispatchTouchEvent(MotionEvent.obtain(paramPlatformViewTouch.downTime.longValue(), paramPlatformViewTouch.eventTime.longValue(), paramPlatformViewTouch.action, paramPlatformViewTouch.pointerCount, (MotionEvent.PointerProperties[])localObject, arrayOfPointerCoords, paramPlatformViewTouch.metaState, paramPlatformViewTouch.buttonState, paramPlatformViewTouch.xPrecision, paramPlatformViewTouch.yPrecision, paramPlatformViewTouch.deviceId, paramPlatformViewTouch.edgeFlags, paramPlatformViewTouch.source, paramPlatformViewTouch.flags));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Sending touch to an unknown view with id: ");
    ((StringBuilder)localObject).append(paramPlatformViewTouch.viewId);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void resizePlatformView(@NonNull PlatformViewsChannel.PlatformViewResizeRequest paramPlatformViewResizeRequest, @NonNull Runnable paramRunnable)
  {
    ensureValidAndroidVersion();
    VirtualDisplayController localVirtualDisplayController = (VirtualDisplayController)this.this$0.vdControllers.get(Integer.valueOf(paramPlatformViewResizeRequest.viewId));
    if (localVirtualDisplayController != null)
    {
      int i = PlatformViewsController.access$200(this.this$0, paramPlatformViewResizeRequest.newLogicalWidth);
      int j = PlatformViewsController.access$200(this.this$0, paramPlatformViewResizeRequest.newLogicalHeight);
      PlatformViewsController.access$300(this.this$0, i, j);
      PlatformViewsController.access$1100(this.this$0, localVirtualDisplayController);
      localVirtualDisplayController.resize(i, j, new PlatformViewsController.1.1(this, localVirtualDisplayController, paramRunnable));
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
    ensureValidAndroidVersion();
    if (PlatformViewsController.access$000(paramInt2))
    {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewsController.1
 * JD-Core Version:    0.7.0.1
 */