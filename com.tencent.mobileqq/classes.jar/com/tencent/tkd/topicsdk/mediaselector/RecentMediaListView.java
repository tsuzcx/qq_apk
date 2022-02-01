package com.tencent.tkd.topicsdk.mediaselector;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View.MeasureSpec;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView;", "Landroid/widget/ListView;", "context", "Landroid/content/Context;", "allMedia", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lkotlin/collections/ArrayList;", "mediaMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/HashMap;)V", "adapter", "com/tencent/tkd/topicsdk/mediaselector/RecentMediaListView$adapter$1", "Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView$adapter$1;", "mMediaMapList", "Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView$Album;", "maxHeight", "", "onSelectCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "dirName", "dirPath", "mediaList", "", "getOnSelectCallback", "()Lkotlin/jvm/functions/Function3;", "setOnSelectCallback", "(Lkotlin/jvm/functions/Function3;)V", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Album", "RecentMediaListHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class RecentMediaListView
  extends ListView
{
  private int jdField_a_of_type_Int;
  private final RecentMediaListView.adapter.1 jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView$adapter$1;
  private final ArrayList<RecentMediaListView.Album> jdField_a_of_type_JavaUtilArrayList;
  @Nullable
  private Function3<? super String, ? super String, ? super ArrayList<Media>, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction3;
  
  public RecentMediaListView(@NotNull Context paramContext, @NotNull ArrayList<Media> paramArrayList, @NotNull HashMap<String, ArrayList<Media>> paramHashMap)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramHashMap.size());
    this.jdField_a_of_type_Int = (DisplayUtils.a.b(paramContext) * 3 / 4);
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    Object localObject2 = paramContext.getResources().getString(R.string.W);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources.getString(R.string.recent_item)");
    ((ArrayList)localObject1).add(new RecentMediaListView.Album((String)localObject2, "", paramArrayList));
    paramArrayList = paramHashMap.keySet();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayList, "mediaMap.keys");
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      localObject1 = (String)paramArrayList.next();
      localObject2 = (ArrayList)paramHashMap.get(localObject1);
      if (localObject2 != null)
      {
        String str = new File((String)localObject1).getName();
        ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        Intrinsics.checkExpressionValueIsNotNull(str, "name");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "path");
        localArrayList.add(new RecentMediaListView.Album(str, (String)localObject1, (ArrayList)localObject2));
      }
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView$adapter$1 = new RecentMediaListView.adapter.1(this, paramContext, paramContext);
  }
  
  @Nullable
  public final Function3<String, String, ArrayList<Media>, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction3;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setAdapter((ListAdapter)this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView$adapter$1);
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView$adapter$1.a((List)this.jdField_a_of_type_JavaUtilArrayList);
    setOnItemClickListener((AdapterView.OnItemClickListener)new RecentMediaListView.onAttachedToWindow.1(this));
    setDividerHeight(0);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getMeasuredHeight();
    int i = this.jdField_a_of_type_Int;
    if ((paramInt2 > i) && (i > -1)) {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.jdField_a_of_type_Int);
    }
  }
  
  public final void setOnSelectCallback(@Nullable Function3<? super String, ? super String, ? super ArrayList<Media>, Unit> paramFunction3)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction3 = paramFunction3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.RecentMediaListView
 * JD-Core Version:    0.7.0.1
 */