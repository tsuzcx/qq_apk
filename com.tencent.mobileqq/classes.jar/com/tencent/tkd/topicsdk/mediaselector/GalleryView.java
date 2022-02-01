package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bm.library.PhotoView;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.framework.PagerAdapterProxy;
import com.tencent.tkd.topicsdk.framework.ViewPagerProxy;
import com.tencent.tkd.topicsdk.interfaces.OnPageChangeListenerProxy;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/GalleryView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentPage", "", "getCurrentPage", "()I", "isZoom", "", "()Z", "mAdapter", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "mCurrentPhotoView", "Lcom/bm/library/PhotoView;", "mList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnItemLongClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "onPageSelectListener", "getOnPageSelectListener", "()Lkotlin/jvm/functions/Function1;", "setOnPageSelectListener", "(Lkotlin/jvm/functions/Function1;)V", "picLoader", "Lkotlin/Function2;", "path", "Landroid/widget/ImageView;", "imageView", "getPicLoader", "()Lkotlin/jvm/functions/Function2;", "setPicLoader", "(Lkotlin/jvm/functions/Function2;)V", "viewPagerProxy", "Lcom/tencent/tkd/topicsdk/framework/ViewPagerProxy;", "onDetachedFromWindow", "setOnClickListener", "l", "setOnItemLongClickListener", "listener", "setPhotos", "list", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class GalleryView
  extends RelativeLayout
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private PhotoView jdField_a_of_type_ComBmLibraryPhotoView;
  private PagerAdapterProxy jdField_a_of_type_ComTencentTkdTopicsdkFrameworkPagerAdapterProxy;
  private final ViewPagerProxy jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Function1<? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  @Nullable
  private Function2<? super String, ? super ImageView, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  @Nullable
  private Function1<? super Integer, Unit> b;
  
  public GalleryView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkPagerAdapterProxy = ((PagerAdapterProxy)new GalleryView.mAdapter.1(this, paramContext));
    LayoutInflater.from(paramContext).inflate(R.layout.n, (ViewGroup)this);
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy = new ViewPagerProxy(paramContext, TopicSDK.a.a().a().a());
    addView(this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy.a(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy.a(this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkPagerAdapterProxy);
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy.a((OnPageChangeListenerProxy)new GalleryView.1(this));
  }
  
  @Nullable
  public final Function1<Integer, Unit> a()
  {
    return this.b;
  }
  
  @Nullable
  public final Function2<String, ImageView, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy.a();
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public final void setOnItemLongClickListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setOnPageSelectListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.b = paramFunction1;
  }
  
  public final void setPhotos(@NotNull ArrayList<String> paramArrayList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "list");
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)paramArrayList);
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkPagerAdapterProxy.a();
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy.a(paramInt);
  }
  
  public final void setPicLoader(@Nullable Function2<? super String, ? super ImageView, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.GalleryView
 * JD-Core Version:    0.7.0.1
 */