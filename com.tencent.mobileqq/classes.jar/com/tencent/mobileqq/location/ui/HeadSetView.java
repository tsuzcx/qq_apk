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
import awit;
import awiz;
import awjj;
import awjr;
import awjs;
import awlt;
import awmp;
import awnf;
import awnj;
import blfw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mvk;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/location/ui/HeadSetView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "cancelShare", "Landroid/widget/ImageView;", "headAdapter", "Lcom/tencent/mobileqq/location/ui/headset/HeadAdapter;", "headSetViewModule", "Lcom/tencent/mobileqq/location/ui/HeadSetViewModule;", "listViewHeadSet", "Lcom/tencent/widget/HorizontalListView;", "minShare", "rootLayoutView", "Landroid/view/View;", "textSharingCount", "Landroid/widget/TextView;", "adjustForNotchScreen", "", "adjustNightMode", "findView", "T", "id", "", "(I)Landroid/view/View;", "init", "initHeadSetViewModule", "initListView", "initViews", "maxShownAvatarCount", "onResume", "setLocationController", "controller", "Lcom/tencent/mobileqq/location/ui/LocationShareController;", "roomKey", "Lcom/tencent/mobileqq/location/data/LocationRoom$RoomKey;", "fromPlusPanel", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class HeadSetView
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @JvmField
  @Nullable
  public awjs a;
  private awnf jdField_a_of_type_Awnf;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ImageView b;
  
  public HeadSetView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "BaseApplicationImpl.getApplication()");
    paramContext = paramContext.getRuntime();
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramContext);
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
    this.jdField_a_of_type_Awjs = new awjs(getContext());
  }
  
  private final void d()
  {
    View localView = a(2131376947);
    boolean bool = blfw.a();
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
        localObject = a(2131372072);
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
        localLayoutParams.height = LiuHaiUtils.jdField_a_of_type_Int;
        ((View)localObject).setLayoutParams(localLayoutParams);
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  private final void f()
  {
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131559351, (ViewGroup)this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)a(2131370222));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364267));
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    Context localContext;
    Object localObject;
    if (localImageView != null)
    {
      localImageView.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Awjs);
      localContext = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localObject = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getDrawable(2130845340);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…able.qq_loc_cancel_share)");
      localImageView.setImageDrawable(awjr.a(localContext, (Drawable)localObject));
    }
    awmp.a((View)this.jdField_a_of_type_AndroidWidgetImageView, "退出位置共享");
    this.b = ((ImageView)a(2131371138));
    localImageView = this.b;
    if (localImageView != null)
    {
      localImageView.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Awjs);
      localContext = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localObject = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getDrawable(2130845341);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…rawable.qq_loc_min_share)");
      localImageView.setImageDrawable(awjr.a(localContext, (Drawable)localObject));
    }
    awmp.a((View)this.b, "最小化位置共享");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378793));
    g();
  }
  
  private final void g()
  {
    this.jdField_a_of_type_Awnf = new awnf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    if (localObject != null) {
      ((HorizontalListView)localObject).setAdapter((ListAdapter)this.jdField_a_of_type_Awnf);
    }
    localObject = this.jdField_a_of_type_Awjs;
    if (localObject != null)
    {
      ((awjs)localObject).a(this.jdField_a_of_type_Awnf);
      ((awjs)localObject).a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public final int a()
  {
    View localView = a(2131370234);
    float f1 = mvk.a(getContext(), 40.0F);
    f1 = localView.getWidth() - f1;
    float f2 = mvk.a(getContext(), 48.0F);
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
    awnf localawnf = this.jdField_a_of_type_Awnf;
    if (localawnf != null) {
      localawnf.notifyDataSetChanged();
    }
  }
  
  public final void setLocationController(@Nullable awlt paramawlt, @NotNull awit paramawit, boolean paramBoolean)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramawit, "roomKey");
    awnf localawnf = this.jdField_a_of_type_Awnf;
    if (localawnf != null) {
      localawnf.a(paramawlt);
    }
    paramawlt = this.jdField_a_of_type_Awjs;
    if (paramawlt != null) {
      paramawlt.a(paramawit);
    }
    int i;
    if (!awiz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.a(paramawit))
    {
      i = 1;
      if (i == 1)
      {
        paramawlt = CollectionsKt.mutableListOf(new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() });
        localawnf = this.jdField_a_of_type_Awnf;
        if (localawnf != null) {
          localawnf.a(paramawlt);
        }
        if ((!paramBoolean) || (awnj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawit.a(), paramawit.a()))) {
          break label161;
        }
        i = j;
        label128:
        paramawit = this.jdField_a_of_type_AndroidWidgetTextView;
        if (paramawit != null) {
          if (i == 0) {
            break label167;
          }
        }
      }
    }
    label161:
    label167:
    for (paramawlt = (CharSequence)"正在发起...";; paramawlt = (CharSequence)"正在加入...")
    {
      paramawit.setText(paramawlt);
      return;
      i = 0;
      break;
      i = 0;
      break label128;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.HeadSetView
 * JD-Core Version:    0.7.0.1
 */