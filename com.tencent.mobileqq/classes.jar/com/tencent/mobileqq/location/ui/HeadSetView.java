package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.ReportLocationHandler;
import com.tencent.mobileqq.location.ui.headset.HeadAdapter;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.HorizontalListView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/location/ui/HeadSetView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cancelShare", "Landroid/widget/ImageView;", "headAdapter", "Lcom/tencent/mobileqq/location/ui/headset/HeadAdapter;", "headSetViewModule", "Lcom/tencent/mobileqq/location/ui/HeadSetViewModule;", "listViewHeadSet", "Lcom/tencent/widget/HorizontalListView;", "minShare", "rootLayoutView", "Landroid/view/View;", "textSharingCount", "Landroid/widget/TextView;", "adjustForNotchScreen", "", "adjustNightMode", "findView", "T", "id", "", "(I)Landroid/view/View;", "init", "initHeadSetViewModule", "initListView", "initViews", "maxShownAvatarCount", "onResume", "setLocationController", "controller", "Lcom/tencent/mobileqq/location/ui/LocationShareController;", "roomKey", "Lcom/tencent/mobileqq/location/data/LocationRoom$RoomKey;", "fromPlusPanel", "", "qq-location-impl_release"}, k=1, mv={1, 1, 16})
public final class HeadSetView
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @JvmField
  @Nullable
  public HeadSetViewModule a;
  private HeadAdapter jdField_a_of_type_ComTencentMobileqqLocationUiHeadsetHeadAdapter;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ImageView b;
  
  public HeadSetView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final <T extends View> T a(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      return localView.findViewById(paramInt);
    }
    return null;
  }
  
  private final void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule = new HeadSetViewModule(getContext());
  }
  
  private final void d()
  {
    View localView = a(2131376809);
    boolean bool = QQUIDelegate.b();
    if (bool == true)
    {
      localView.setBackgroundColor(Color.parseColor("#CC000000"));
      return;
    }
    if (!bool) {
      localView.setBackgroundColor(Color.parseColor("#7F000000"));
    }
  }
  
  private final void e()
  {
    if ((getContext() instanceof Activity))
    {
      Object localObject = getContext();
      if (localObject != null)
      {
        LiuHaiUtils.a((Activity)localObject);
        if (LiuHaiUtils.jdField_a_of_type_Boolean)
        {
          localObject = a(2131371957);
          ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
          localLayoutParams.height = LiuHaiUtils.jdField_a_of_type_Int;
          ((View)localObject).setLayoutParams(localLayoutParams);
          ((View)localObject).setVisibility(0);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
    }
  }
  
  private final void f()
  {
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131559291, (ViewGroup)this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)a(2131370154));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364272));
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    Context localContext;
    Object localObject;
    if (localImageView != null)
    {
      localImageView.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule);
      localContext = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localObject = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getDrawable(2130845529);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…able.qq_loc_cancel_share)");
      localImageView.setImageDrawable(HeadSetViewKt.a(localContext, (Drawable)localObject));
    }
    MapUtils.a((View)this.jdField_a_of_type_AndroidWidgetImageView, "退出位置共享");
    this.b = ((ImageView)a(2131371038));
    localImageView = this.b;
    if (localImageView != null)
    {
      localImageView.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule);
      localContext = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localObject = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getDrawable(2130845530);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…rawable.qq_loc_min_share)");
      localImageView.setImageDrawable(HeadSetViewKt.a(localContext, (Drawable)localObject));
    }
    MapUtils.a((View)this.b, "最小化位置共享");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378588));
    g();
  }
  
  private final void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadsetHeadAdapter = new HeadAdapter(getContext(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    if (localObject != null) {
      ((HorizontalListView)localObject).setAdapter((ListAdapter)this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadsetHeadAdapter);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule;
    if (localObject != null)
    {
      ((HeadSetViewModule)localObject).a(this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadsetHeadAdapter);
      ((HeadSetViewModule)localObject).a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public final int a()
  {
    Object localObject = a(2131370166);
    float f1 = DisplayUtils.a(getContext(), 40.0F);
    f1 = ((View)localObject).getWidth() - f1;
    float f2 = DisplayUtils.a(getContext(), 48.0F);
    double d1 = f1;
    double d2 = f2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = Math.floor(d1 / d2);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" floor: ");
      ((StringBuilder)localObject).append(d1);
      ((StringBuilder)localObject).append(" avatarWidth: ");
      ((StringBuilder)localObject).append(f2);
      ((StringBuilder)localObject).append(" listViewContainerWidth: ");
      ((StringBuilder)localObject).append(f1);
      QLog.d("HeadSetView", 2, new Object[] { "maxShownAvatarCount: invoked. ", ((StringBuilder)localObject).toString() });
    }
    if (d1 > 4) {
      return 4;
    }
    return (int)d1;
  }
  
  public final void a()
  {
    c();
    f();
    e();
    d();
  }
  
  public final void b()
  {
    HeadAdapter localHeadAdapter = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadsetHeadAdapter;
    if (localHeadAdapter != null) {
      localHeadAdapter.notifyDataSetChanged();
    }
  }
  
  public final void setLocationController(@Nullable LocationShareController paramLocationShareController, @NotNull LocationRoom.RoomKey paramRoomKey, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramRoomKey, "roomKey");
    HeadAdapter localHeadAdapter = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadsetHeadAdapter;
    if (localHeadAdapter != null) {
      localHeadAdapter.a(paramLocationShareController);
    }
    paramLocationShareController = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule;
    if (paramLocationShareController != null) {
      paramLocationShareController.a(paramRoomKey);
    }
    boolean bool = LocationShareLocationManager.a().a.a(paramRoomKey);
    int i = 1;
    if ((bool ^ true) == true)
    {
      paramLocationShareController = MobileQQ.sMobileQQ.waitAppRuntime(null);
      Intrinsics.checkExpressionValueIsNotNull(paramLocationShareController, "runtime");
      paramLocationShareController = CollectionsKt.mutableListOf(new String[] { paramLocationShareController.getAccount() });
      localHeadAdapter = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadsetHeadAdapter;
      if (localHeadAdapter != null) {
        localHeadAdapter.a(paramLocationShareController);
      }
      if ((!paramBoolean) || (LocationProtoUtil.a(paramRoomKey.a(), paramRoomKey.a()))) {
        i = 0;
      }
      paramRoomKey = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramRoomKey != null)
      {
        if (i != 0) {
          paramLocationShareController = "正在发起...";
        } else {
          paramLocationShareController = "正在加入...";
        }
        paramRoomKey.setText((CharSequence)paramLocationShareController);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.HeadSetView
 * JD-Core Version:    0.7.0.1
 */