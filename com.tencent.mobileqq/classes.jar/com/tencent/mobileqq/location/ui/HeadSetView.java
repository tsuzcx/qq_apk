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
import com.tencent.mobileqq.location.net.LocationHandler;
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
    View localView = a(2131377356);
    boolean bool = QQUIDelegate.b();
    if (bool == true) {
      localView.setBackgroundColor(Color.parseColor("#CC000000"));
    }
    while (bool) {
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#7F000000"));
  }
  
  private final void e()
  {
    if ((getContext() instanceof Activity))
    {
      Object localObject = getContext();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      LiuHaiUtils.a((Activity)localObject);
      if (LiuHaiUtils.jdField_a_of_type_Boolean)
      {
        localObject = a(2131372375);
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
        localLayoutParams.height = LiuHaiUtils.jdField_a_of_type_Int;
        ((View)localObject).setLayoutParams(localLayoutParams);
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  private final void f()
  {
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131559416, (ViewGroup)this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)a(2131370494));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364374));
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
      localObject = ((Context)localObject).getResources().getDrawable(2130845656);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…able.qq_loc_cancel_share)");
      localImageView.setImageDrawable(HeadSetViewKt.a(localContext, (Drawable)localObject));
    }
    MapUtils.a((View)this.jdField_a_of_type_AndroidWidgetImageView, "退出位置共享");
    this.b = ((ImageView)a(2131371416));
    localImageView = this.b;
    if (localImageView != null)
    {
      localImageView.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule);
      localContext = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localObject = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getDrawable(2130845657);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…rawable.qq_loc_min_share)");
      localImageView.setImageDrawable(HeadSetViewKt.a(localContext, (Drawable)localObject));
    }
    MapUtils.a((View)this.b, "最小化位置共享");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379226));
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
    View localView = a(2131370506);
    float f1 = DisplayUtils.a(getContext(), 40.0F);
    f1 = localView.getWidth() - f1;
    float f2 = DisplayUtils.a(getContext(), 48.0F);
    double d = Math.floor(f1 / f2);
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetView", 2, new Object[] { "maxShownAvatarCount: invoked. ", " floor: " + d + " avatarWidth: " + f2 + " listViewContainerWidth: " + f1 });
    }
    if (d > 4) {
      return 4;
    }
    return (int)d;
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
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramRoomKey, "roomKey");
    HeadAdapter localHeadAdapter = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadsetHeadAdapter;
    if (localHeadAdapter != null) {
      localHeadAdapter.a(paramLocationShareController);
    }
    paramLocationShareController = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule;
    if (paramLocationShareController != null) {
      paramLocationShareController.a(paramRoomKey);
    }
    int i;
    if (!LocationHandler.a().a.a(paramRoomKey))
    {
      i = 1;
      if (i == 1)
      {
        paramLocationShareController = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intrinsics.checkExpressionValueIsNotNull(paramLocationShareController, "runtime");
        paramLocationShareController = CollectionsKt.mutableListOf(new String[] { paramLocationShareController.getAccount() });
        localHeadAdapter = this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadsetHeadAdapter;
        if (localHeadAdapter != null) {
          localHeadAdapter.a(paramLocationShareController);
        }
        if ((!paramBoolean) || (LocationProtoUtil.a(paramRoomKey.a(), paramRoomKey.a()))) {
          break label165;
        }
        i = j;
        label132:
        paramRoomKey = this.jdField_a_of_type_AndroidWidgetTextView;
        if (paramRoomKey != null) {
          if (i == 0) {
            break label171;
          }
        }
      }
    }
    label165:
    label171:
    for (paramLocationShareController = (CharSequence)"正在发起...";; paramLocationShareController = (CharSequence)"正在加入...")
    {
      paramRoomKey.setText(paramLocationShareController);
      return;
      i = 0;
      break;
      i = 0;
      break label132;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.HeadSetView
 * JD-Core Version:    0.7.0.1
 */