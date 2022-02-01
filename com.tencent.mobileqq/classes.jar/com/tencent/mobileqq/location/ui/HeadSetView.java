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
import awpk;
import awpq;
import awqa;
import awqi;
import awqj;
import awsk;
import awtg;
import awtw;
import awua;
import blqj;
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
import mvd;
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
  public awqj a;
  private awtw jdField_a_of_type_Awtw;
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
    this.jdField_a_of_type_Awqj = new awqj(getContext());
  }
  
  private final void d()
  {
    View localView = a(2131376925);
    boolean bool = blqj.a();
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
        localObject = a(2131371915);
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
        localLayoutParams.height = LiuHaiUtils.jdField_a_of_type_Int;
        ((View)localObject).setLayoutParams(localLayoutParams);
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  private final void f()
  {
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131559295, (ViewGroup)this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)a(2131370053));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364168));
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    Context localContext;
    Object localObject;
    if (localImageView != null)
    {
      localImageView.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Awqj);
      localContext = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localObject = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getDrawable(2130845376);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…able.qq_loc_cancel_share)");
      localImageView.setImageDrawable(awqi.a(localContext, (Drawable)localObject));
    }
    awtg.a((View)this.jdField_a_of_type_AndroidWidgetImageView, "退出位置共享");
    this.b = ((ImageView)a(2131370985));
    localImageView = this.b;
    if (localImageView != null)
    {
      localImageView.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Awqj);
      localContext = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localObject = localImageView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getDrawable(2130845377);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…rawable.qq_loc_min_share)");
      localImageView.setImageDrawable(awqi.a(localContext, (Drawable)localObject));
    }
    awtg.a((View)this.b, "最小化位置共享");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378737));
    g();
  }
  
  private final void g()
  {
    this.jdField_a_of_type_Awtw = new awtw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    if (localObject != null) {
      ((HorizontalListView)localObject).setAdapter((ListAdapter)this.jdField_a_of_type_Awtw);
    }
    localObject = this.jdField_a_of_type_Awqj;
    if (localObject != null)
    {
      ((awqj)localObject).a(this.jdField_a_of_type_Awtw);
      ((awqj)localObject).a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public final int a()
  {
    View localView = a(2131370065);
    float f1 = mvd.a(getContext(), 40.0F);
    f1 = localView.getWidth() - f1;
    float f2 = mvd.a(getContext(), 48.0F);
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
    awtw localawtw = this.jdField_a_of_type_Awtw;
    if (localawtw != null) {
      localawtw.notifyDataSetChanged();
    }
  }
  
  public final void setLocationController(@Nullable awsk paramawsk, @NotNull awpk paramawpk, boolean paramBoolean)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramawpk, "roomKey");
    awtw localawtw = this.jdField_a_of_type_Awtw;
    if (localawtw != null) {
      localawtw.a(paramawsk);
    }
    paramawsk = this.jdField_a_of_type_Awqj;
    if (paramawsk != null) {
      paramawsk.a(paramawpk);
    }
    int i;
    if (!awpq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.a(paramawpk))
    {
      i = 1;
      if (i == 1)
      {
        paramawsk = CollectionsKt.mutableListOf(new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() });
        localawtw = this.jdField_a_of_type_Awtw;
        if (localawtw != null) {
          localawtw.a(paramawsk);
        }
        if ((!paramBoolean) || (awua.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawpk.a(), paramawpk.a()))) {
          break label161;
        }
        i = j;
        label128:
        paramawpk = this.jdField_a_of_type_AndroidWidgetTextView;
        if (paramawpk != null) {
          if (i == 0) {
            break label167;
          }
        }
      }
    }
    label161:
    label167:
    for (paramawsk = (CharSequence)"正在发起...";; paramawsk = (CharSequence)"正在加入...")
    {
      paramawpk.setText(paramawsk);
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