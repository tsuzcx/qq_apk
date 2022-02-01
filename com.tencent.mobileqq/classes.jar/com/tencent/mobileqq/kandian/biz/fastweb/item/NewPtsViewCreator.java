package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.mobileqq.kandian.repo.pts.entity.PtsData;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/item/NewPtsViewCreator;", "Lcom/tencent/mobileqq/kandian/biz/pts/ItemCreator;", "()V", "eventListener", "Lcom/tencent/mobileqq/kandian/biz/fastweb/item/PtsItemViewEventListener;", "exposureItemData", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/pts/entity/PtsData;", "pageNameToViewTypeMap", "Ljava/util/HashMap;", "", "", "buildViewTypeMap", "", "createViewHolder", "Lcom/tencent/mobileqq/kandian/biz/fastweb/entity/BaseItemViewHolder;", "context", "Landroid/content/Context;", "data", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "parent", "Landroid/view/ViewGroup;", "getRatio2Json", "getViewType", "isSuitable", "", "triggerItemViewExposure", "allowRepeatReport", "Companion", "PTSLiteItemViewHolder", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class NewPtsViewCreator
  implements ItemCreator
{
  public static final NewPtsViewCreator.Companion a;
  private final PtsItemViewEventListener jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemPtsItemViewEventListener = new PtsItemViewEventListener();
  private final ArrayList<PtsData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemNewPtsViewCreator$Companion = new NewPtsViewCreator.Companion(null);
  }
  
  private final String a(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      paramString = new JSONObject(paramString);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("fontScale", FastWebPTSUtils.a());
      paramString.put("$RIJArticle", localObject);
      localObject = paramString.toString();
    }
    return localObject;
  }
  
  public int a(@Nullable BaseData paramBaseData)
  {
    Object localObject = paramBaseData;
    if (!(paramBaseData instanceof PtsData)) {
      localObject = null;
    }
    paramBaseData = (PtsData)localObject;
    if (paramBaseData != null)
    {
      localObject = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramBaseData.b);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getViewType] error, pageName = ");
      ((StringBuilder)localObject).append(paramBaseData.b);
      QLog.e("NewPtsViewCreator", 1, ((StringBuilder)localObject).toString());
    }
    return -1;
  }
  
  @Nullable
  public BaseItemViewHolder a(@Nullable Context paramContext, @Nullable BaseData paramBaseData, @Nullable ViewGroup paramViewGroup)
  {
    if (!(paramBaseData instanceof PtsData)) {
      paramViewGroup = null;
    } else {
      paramViewGroup = paramBaseData;
    }
    paramViewGroup = (PtsData)paramViewGroup;
    if (paramViewGroup != null)
    {
      if (paramViewGroup.a == null) {
        PtsData.a(paramViewGroup, null, 1, null);
      }
      paramContext = new PTSItemView(paramContext);
      paramViewGroup = paramViewGroup.a;
      if (paramViewGroup != null) {
        paramViewGroup.layoutToView(paramContext, (IPTSLiteEventListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemPtsItemViewEventListener, true);
      }
      paramViewGroup = paramContext.getLayoutParams();
      if (paramViewGroup != null) {
        paramContext.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(paramViewGroup));
      }
      return (BaseItemViewHolder)new NewPtsViewCreator.PTSLiteItemViewHolder(this, (View)paramContext, paramBaseData);
    }
    return null;
  }
  
  public final void a()
  {
    Object localObject1 = PTSStyleManager.a().a("native_article");
    if (localObject1 == null)
    {
      QLog.i("NewPtsViewCreator", 1, "[initPtsLiteTypeCount], pageNameList is null");
      return;
    }
    int i = BaseItemViewHolder.a + 1;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
      {
        Object localObject2 = (Map)this.jdField_a_of_type_JavaUtilHashMap;
        Intrinsics.checkExpressionValueIsNotNull(str, "pageName");
        ((Map)localObject2).put(str, Integer.valueOf(i));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[initPtsLiteTypeCount], pageName = ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(", viewType = ");
        ((StringBuilder)localObject2).append(i);
        QLog.i("NewPtsViewCreator", 1, ((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
    BaseItemViewHolder.a += this.jdField_a_of_type_JavaUtilHashMap.size() + 1;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[initPtsLiteTypeCount], view type count = ");
    ((StringBuilder)localObject1).append(BaseItemViewHolder.a);
    QLog.i("NewPtsViewCreator", 1, ((StringBuilder)localObject1).toString());
  }
  
  public final void a(boolean paramBoolean, @NotNull PtsData paramPtsData)
  {
    Intrinsics.checkParameterIsNotNull(paramPtsData, "data");
    if (paramBoolean)
    {
      paramPtsData = paramPtsData.a;
      if (paramPtsData != null) {
        paramPtsData.triggerExposureEvent();
      }
    }
    else if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramPtsData))
    {
      PTSComposer localPTSComposer = paramPtsData.a;
      if (localPTSComposer != null) {
        localPTSComposer.triggerExposureEvent();
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramPtsData);
    }
  }
  
  public boolean a(@Nullable BaseData paramBaseData)
  {
    return paramBaseData instanceof PtsData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.NewPtsViewCreator
 * JD-Core Version:    0.7.0.1
 */