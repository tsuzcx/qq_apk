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
  public static final AlbumPermissionView.Companion a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private IPermission.ISimpleCallback jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPermission$ISimpleCallback;
  private final AlbumPermissionView.storagePermissionObserver.1 jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView$storagePermissionObserver$1;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView$Companion = new AlbumPermissionView.Companion(null);
  }
  
  public AlbumPermissionView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = false;
    if (paramAttributeSet != null) {
      bool = paramAttributeSet.getAttributeBooleanValue(R.styleable.a, false);
    }
    if (!bool) {
      LayoutInflater.from(paramContext).inflate(R.layout.y, (ViewGroup)this, true);
    } else {
      LayoutInflater.from(paramContext).inflate(R.layout.x, (ViewGroup)this, true);
    }
    setOrientation(1);
    setGravity(17);
    paramContext = findViewById(R.id.aY);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_enable_album_permission)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(R.id.bh);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_tips)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)new AlbumPermissionView.2(this));
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView$storagePermissionObserver$1 = new AlbumPermissionView.storagePermissionObserver.1(this);
  }
  
  private final Activity a()
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
  
  @Nullable
  public final IPermission.ISimpleCallback a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPermission$ISimpleCallback;
  }
  
  public final boolean a()
  {
    return PermissionUtils.a.a(a());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    DispatchManager.a.a(StoragePermissionEvent.class, (IEventObserver)this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView$storagePermissionObserver$1);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    DispatchManager.a.b(StoragePermissionEvent.class, (IEventObserver)this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetAlbumPermissionView$storagePermissionObserver$1);
  }
  
  public final void setOnPermissionCallback(@Nullable IPermission.ISimpleCallback paramISimpleCallback)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPermission$ISimpleCallback = paramISimpleCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AlbumPermissionView
 * JD-Core Version:    0.7.0.1
 */