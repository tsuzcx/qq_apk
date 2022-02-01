package com.tencent.tkd.topicsdk.mediaselector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.tkd.R.drawable;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.ViewExtensionsKt;
import com.tencent.tkd.topicsdk.framework.BaseSDKPage;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/PreviewPhotoPage;", "Lcom/tencent/tkd/topicsdk/framework/BaseSDKPage;", "()V", "currentPosition", "", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "isTranslateStatusBar", "", "()Z", "maxSelectNum", "getMaxSelectNum", "setMaxSelectNum", "photoList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPhotoList", "()Ljava/util/ArrayList;", "setPhotoList", "(Ljava/util/ArrayList;)V", "selectLayout", "Landroid/view/View;", "getSelectLayout", "()Landroid/view/View;", "setSelectLayout", "(Landroid/view/View;)V", "selectView", "Landroid/widget/TextView;", "getSelectView", "()Landroid/widget/TextView;", "setSelectView", "(Landroid/widget/TextView;)V", "selectedPhotoList", "getSelectedPhotoList", "setSelectedPhotoList", "beforeActivityFinish", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateSelectedView", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PreviewPhotoPage
  extends BaseSDKPage
{
  public static final PreviewPhotoPage.Companion f = new PreviewPhotoPage.Companion(null);
  @NotNull
  public TextView a;
  @NotNull
  public View c;
  @NotNull
  public ArrayList<String> d;
  @NotNull
  public ArrayList<String> e;
  private int g;
  private int h;
  
  private final void q()
  {
    Object localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectedPhotoList");
    }
    ArrayList localArrayList = this.e;
    if (localArrayList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("photoList");
    }
    int i = ((ArrayList)localObject).indexOf(localArrayList.get(this.g));
    if (this.h == 1)
    {
      if (i >= 0)
      {
        localObject = this.a;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("selectView");
        }
        ((TextView)localObject).setBackgroundResource(R.drawable.g);
      }
      else
      {
        localObject = this.a;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("selectView");
        }
        ((TextView)localObject).setBackgroundResource(R.drawable.h);
      }
    }
    else if (i >= 0)
    {
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectView");
      }
      ((TextView)localObject).setBackgroundResource(R.drawable.f);
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectView");
      }
      ((TextView)localObject).setText((CharSequence)String.valueOf(i + 1));
    }
    else
    {
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectView");
      }
      ((TextView)localObject).setBackgroundResource(R.drawable.h);
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectView");
      }
      ((TextView)localObject).setText((CharSequence)"");
    }
    if (i < 0)
    {
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectedPhotoList");
      }
      if (((ArrayList)localObject).size() >= this.h)
      {
        localObject = this.c;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
        }
        ((View)localObject).setClickable(false);
        localObject = this.c;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
        }
        ((View)localObject).setEnabled(false);
        return;
      }
    }
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
    }
    ((View)localObject).setClickable(true);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
    }
    ((View)localObject).setEnabled(true);
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    int i = R.layout.A;
    int j = 0;
    paramViewGroup = paramLayoutInflater.inflate(i, paramViewGroup, false);
    paramLayoutInflater = a();
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater = paramLayoutInflater.getStringArrayList("photo_list");
      if (paramLayoutInflater != null) {}
    }
    else
    {
      paramLayoutInflater = new ArrayList();
    }
    this.e = paramLayoutInflater;
    paramLayoutInflater = this.e;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("photoList");
    }
    if (paramLayoutInflater.isEmpty())
    {
      localObject = MediaDataManager.a;
      paramLayoutInflater = a();
      if (paramLayoutInflater != null)
      {
        paramLayoutInflater = paramLayoutInflater.getString("photo_dir");
        if (paramLayoutInflater != null) {}
      }
      else
      {
        paramLayoutInflater = "";
      }
      localObject = (Iterable)((MediaDataManager)localObject).a(paramLayoutInflater);
      paramLayoutInflater = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramLayoutInflater.add(((Media)((Iterator)localObject).next()).getFilePath());
      }
      this.e = new ArrayList((Collection)paramLayoutInflater);
    }
    paramLayoutInflater = this.e;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("photoList");
    }
    if (paramLayoutInflater.isEmpty())
    {
      TLog.d("PreviewPhotoPage", "open PreviewPhotoPage failed, photoList is Empty");
      paramLayoutInflater = b();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.finish();
      }
      return paramViewGroup;
    }
    paramLayoutInflater = a();
    if (paramLayoutInflater != null) {
      i = paramLayoutInflater.getInt("position");
    } else {
      i = 0;
    }
    this.g = i;
    paramLayoutInflater = a();
    i = j;
    if (paramLayoutInflater != null) {
      i = paramLayoutInflater.getInt("max_select_num");
    }
    this.h = i;
    paramLayoutInflater = a();
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater = paramLayoutInflater.getStringArrayList("selected_photo_list");
      if (paramLayoutInflater != null) {}
    }
    else
    {
      paramLayoutInflater = new ArrayList();
    }
    this.d = paramLayoutInflater;
    if (h())
    {
      paramLayoutInflater = paramViewGroup.findViewById(R.id.P);
      Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "view.findViewById<View>(R.id.previewElement)");
      ViewExtensionsKt.b(paramLayoutInflater);
    }
    paramLayoutInflater = paramViewGroup.findViewById(R.id.aj);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "view.findViewById(R.id.selectedView)");
    this.a = ((TextView)paramLayoutInflater);
    paramLayoutInflater = paramViewGroup.findViewById(R.id.ai);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "view.findViewById<View>(R.id.selectedLayout)");
    this.c = paramLayoutInflater;
    paramLayoutInflater = this.c;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
    }
    paramLayoutInflater.setOnClickListener((View.OnClickListener)new PreviewPhotoPage.onCreateView.2(this));
    paramViewGroup.findViewById(R.id.D).setOnClickListener((View.OnClickListener)new PreviewPhotoPage.onCreateView.3(this));
    paramLayoutInflater = (GalleryView)paramViewGroup.findViewById(R.id.t);
    paramLayoutInflater.setPicLoader((Function2)new PreviewPhotoPage.onCreateView.4(paramLayoutInflater));
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("photoList");
    }
    paramLayoutInflater.setPhotos((ArrayList)localObject, this.g);
    paramLayoutInflater.setOnPageSelectListener((Function1)new PreviewPhotoPage.onCreateView.5(this));
    q();
    return paramViewGroup;
  }
  
  public final void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public void m()
  {
    super.m();
    Intent localIntent = new Intent();
    Object localObject = new Bundle();
    ArrayList localArrayList = this.d;
    if (localArrayList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectedPhotoList");
    }
    ((Bundle)localObject).putStringArrayList("selected_photo_list", localArrayList);
    localIntent.putExtras((Bundle)localObject);
    localObject = b();
    if (localObject != null) {
      ((Activity)localObject).setResult(2, localIntent);
    }
  }
  
  public final int n()
  {
    return this.g;
  }
  
  @NotNull
  public final ArrayList<String> o()
  {
    ArrayList localArrayList = this.d;
    if (localArrayList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectedPhotoList");
    }
    return localArrayList;
  }
  
  @NotNull
  public final ArrayList<String> p()
  {
    ArrayList localArrayList = this.e;
    if (localArrayList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("photoList");
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.PreviewPhotoPage
 * JD-Core Version:    0.7.0.1
 */