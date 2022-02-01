package com.tencent.tkd.topicsdk.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.styleable;
import com.tencent.tkd.topicsdk.common.PermissionUtils;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.framework.events.StoragePermissionEvent;
import com.tencent.tkd.topicsdk.interfaces.IPermission.ISimpleCallback;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/AlbumPermissionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "needShowContentView", "", "getNeedShowContentView", "()Z", "onPermissionCallback", "Lcom/tencent/tkd/topicsdk/interfaces/IPermission$ISimpleCallback;", "getOnPermissionCallback", "()Lcom/tencent/tkd/topicsdk/interfaces/IPermission$ISimpleCallback;", "setOnPermissionCallback", "(Lcom/tencent/tkd/topicsdk/interfaces/IPermission$ISimpleCallback;)V", "requestPermissionBtn", "Landroid/view/View;", "storagePermissionObserver", "com/tencent/tkd/topicsdk/widget/AlbumPermissionView$storagePermissionObserver$1", "Lcom/tencent/tkd/topicsdk/widget/AlbumPermissionView$storagePermissionObserver$1;", "tipsView", "Landroid/widget/TextView;", "onAttachedToWindow", "", "onDetachedFromWindow", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class AlbumPermissionView
  extends LinearLayout
{
  public static final AlbumPermissionView.Companion a = new AlbumPermissionView.Companion(null);
  private View b;
  private TextView c;
  @Nullable
  private IPermission.ISimpleCallback d;
  private final AlbumPermissionView.storagePermissionObserver.1 e;
  
  public AlbumPermissionView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = false;
    if (paramAttributeSet != null) {
      bool = paramAttributeSet.getAttributeBooleanValue(R.styleable.b, false);
    }
    if (!bool) {
      LayoutInflater.from(paramContext).inflate(R.layout.t, (ViewGroup)this, true);
    } else {
      LayoutInflater.from(paramContext).inflate(R.layout.s, (ViewGroup)this, true);
    }
    setOrientation(1);
    setGravity(17);
    paramContext = findViewById(R.id.az);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_enable_album_permission)");
    this.b = paramContext;
    paramContext = findViewById(R.id.aG);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_tips)");
    this.c = ((TextView)paramContext);
    this.b.setOnClickListener((View.OnClickListener)new AlbumPermissionView.2(this));
    this.e = new AlbumPermissionView.storagePermissionObserver.1(this);
  }
  
  private final Activity getActivity()
  {
    Context localContext = getContext();
    Object localObject = localContext;
    if ((localContext instanceof Activity)) {
      return (Activity)localContext;
    }
    while ((localObject instanceof ContextWrapper)) {
      localObject = ((ContextWrapper)localObject).getBaseContext();
    }
    if (localObject != null) {
      return (Activity)localObject;
    }
    localObject = new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean getNeedShowContentView()
  {
    return PermissionUtils.a.a(getActivity());
  }
  
  @Nullable
  public final IPermission.ISimpleCallback getOnPermissionCallback()
  {
    return this.d;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    DispatchManager.a.a(StoragePermissionEvent.class, (IEventObserver)this.e);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    DispatchManager.a.b(StoragePermissionEvent.class, (IEventObserver)this.e);
  }
  
  public final void setOnPermissionCallback(@Nullable IPermission.ISimpleCallback paramISimpleCallback)
  {
    this.d = paramISimpleCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AlbumPermissionView
 * JD-Core Version:    0.7.0.1
 */