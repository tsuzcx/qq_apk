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
  private final ViewPagerProxy a;
  private final ArrayList<String> b = new ArrayList();
  private View.OnClickListener c;
  private Function1<? super Integer, Unit> d;
  private PhotoView e;
  @Nullable
  private Function1<? super Integer, Unit> f;
  @Nullable
  private Function2<? super String, ? super ImageView, Unit> g;
  private PagerAdapterProxy h;
  
  public GalleryView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = ((PagerAdapterProxy)new GalleryView.mAdapter.1(this, paramContext));
    LayoutInflater.from(paramContext).inflate(R.layout.i, (ViewGroup)this);
    this.a = new ViewPagerProxy(paramContext, TopicSDK.a.a().b().p());
    addView(this.a.a(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.a.a(this.h);
    this.a.a((OnPageChangeListenerProxy)new GalleryView.1(this));
  }
  
  public final int getCurrentPage()
  {
    return this.a.b();
  }
  
  @Nullable
  public final Function1<Integer, Unit> getOnPageSelectListener()
  {
    return this.f;
  }
  
  @Nullable
  public final Function2<String, ImageView, Unit> getPicLoader()
  {
    return this.g;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.c();
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
  
  public final void setOnItemLongClickListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.d = paramFunction1;
  }
  
  public final void setOnPageSelectListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.f = paramFunction1;
  }
  
  public final void setPhotos(@NotNull ArrayList<String> paramArrayList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "list");
    this.b.clear();
    this.b.addAll((Collection)paramArrayList);
    this.h.b();
    this.a.a(paramInt);
  }
  
  public final void setPicLoader(@Nullable Function2<? super String, ? super ImageView, Unit> paramFunction2)
  {
    this.g = paramFunction2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.GalleryView
 * JD-Core Version:    0.7.0.1
 */