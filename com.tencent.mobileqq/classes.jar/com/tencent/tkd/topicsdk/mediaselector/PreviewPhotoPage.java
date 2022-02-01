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
  public static final PreviewPhotoPage.Companion a;
  private int a;
  @NotNull
  public View a;
  @NotNull
  public TextView a;
  @NotNull
  public ArrayList<String> a;
  private int b;
  @NotNull
  public ArrayList<String> b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPreviewPhotoPage$Companion = new PreviewPhotoPage.Companion(null);
  }
  
  private final void f()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectedPhotoList");
    }
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("photoList");
    }
    int i = ((ArrayList)localObject).indexOf(localArrayList.get(this.jdField_a_of_type_Int));
    if (this.jdField_b_of_type_Int == 1)
    {
      if (i >= 0)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("selectView");
        }
        ((TextView)localObject).setBackgroundResource(R.drawable.l);
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("selectView");
        }
        ((TextView)localObject).setBackgroundResource(R.drawable.m);
      }
    }
    else if (i >= 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectView");
      }
      ((TextView)localObject).setBackgroundResource(R.drawable.k);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectView");
      }
      ((TextView)localObject).setText((CharSequence)String.valueOf(i + 1));
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectView");
      }
      ((TextView)localObject).setBackgroundResource(R.drawable.m);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectView");
      }
      ((TextView)localObject).setText((CharSequence)"");
    }
    if (i < 0)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selectedPhotoList");
      }
      if (((ArrayList)localObject).size() >= this.jdField_b_of_type_Int)
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
        }
        ((View)localObject).setClickable(false);
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
        }
        ((View)localObject).setEnabled(false);
        return;
      }
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
    }
    ((View)localObject).setClickable(true);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
    }
    ((View)localObject).setEnabled(true);
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    int i = R.layout.E;
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
    this.jdField_b_of_type_JavaUtilArrayList = paramLayoutInflater;
    paramLayoutInflater = this.jdField_b_of_type_JavaUtilArrayList;
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
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList((Collection)paramLayoutInflater);
    }
    paramLayoutInflater = this.jdField_b_of_type_JavaUtilArrayList;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("photoList");
    }
    if (paramLayoutInflater.isEmpty())
    {
      TLog.d("PreviewPhotoPage", "open PreviewPhotoPage failed, photoList is Empty");
      paramLayoutInflater = a();
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
    this.jdField_a_of_type_Int = i;
    paramLayoutInflater = a();
    i = j;
    if (paramLayoutInflater != null) {
      i = paramLayoutInflater.getInt("max_select_num");
    }
    this.jdField_b_of_type_Int = i;
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
    this.jdField_a_of_type_JavaUtilArrayList = paramLayoutInflater;
    if (e())
    {
      paramLayoutInflater = paramViewGroup.findViewById(R.id.am);
      Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "view.findViewById<View>(R.id.previewElement)");
      ViewExtensionsKt.a(paramLayoutInflater);
    }
    paramLayoutInflater = paramViewGroup.findViewById(R.id.aH);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "view.findViewById(R.id.selectedView)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater);
    paramLayoutInflater = paramViewGroup.findViewById(R.id.aG);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "view.findViewById<View>(R.id.selectedLayout)");
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
    }
    paramLayoutInflater.setOnClickListener((View.OnClickListener)new PreviewPhotoPage.onCreateView.2(this));
    paramViewGroup.findViewById(R.id.Y).setOnClickListener((View.OnClickListener)new PreviewPhotoPage.onCreateView.3(this));
    paramLayoutInflater = (GalleryView)paramViewGroup.findViewById(R.id.M);
    paramLayoutInflater.setPicLoader((Function2)new PreviewPhotoPage.onCreateView.4(paramLayoutInflater));
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("photoList");
    }
    paramLayoutInflater.setPhotos((ArrayList)localObject, this.jdField_a_of_type_Int);
    paramLayoutInflater.setOnPageSelectListener((Function1)new PreviewPhotoPage.onCreateView.5(this));
    f();
    return paramViewGroup;
  }
  
  @NotNull
  public final ArrayList<String> a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectedPhotoList");
    }
    return localArrayList;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @NotNull
  public final ArrayList<String> b()
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("photoList");
    }
    return localArrayList;
  }
  
  public void e()
  {
    super.e();
    Intent localIntent = new Intent();
    Object localObject = new Bundle();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selectedPhotoList");
    }
    ((Bundle)localObject).putStringArrayList("selected_photo_list", localArrayList);
    localIntent.putExtras((Bundle)localObject);
    localObject = a();
    if (localObject != null) {
      ((Activity)localObject).setResult(2, localIntent);
    }
  }
  
  public boolean p_()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.PreviewPhotoPage
 * JD-Core Version:    0.7.0.1
 */