import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.PtsData;
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
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/NewPtsViewCreator;", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/ItemCreator;", "()V", "eventListener", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/PtsItemViewEventListener;", "exposureItemData", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/PtsData;", "pageNameToViewTypeMap", "Ljava/util/HashMap;", "", "", "buildViewTypeMap", "", "createViewHolder", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/item/BaseItemViewHolder;", "context", "Landroid/content/Context;", "data", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/BaseData;", "parent", "Landroid/view/ViewGroup;", "getRatio2Json", "getViewType", "isSuitable", "", "triggerItemViewExposure", "allowRepeatReport", "Companion", "PTSLiteItemViewHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tgt
  implements tgs
{
  public static final tgu a;
  private final ArrayList<PtsData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final tgy jdField_a_of_type_Tgy = new tgy();
  
  static
  {
    jdField_a_of_type_Tgu = new tgu(null);
  }
  
  private final String a(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      paramString = new JSONObject(paramString);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("fontScale", tjg.a());
      paramString.put("$RIJArticle", localObject);
      localObject = paramString.toString();
    }
    return localObject;
  }
  
  public int a(@NotNull BaseData paramBaseData)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseData, "data");
    paramBaseData = (PtsData)paramBaseData;
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramBaseData.b);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    QLog.e("NewPtsViewCreator", 1, "[getViewType] error, pageName = " + paramBaseData.b);
    return -1;
  }
  
  @NotNull
  public tgr a(@NotNull Context paramContext, @NotNull BaseData paramBaseData, @NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramBaseData, "data");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = (PtsData)paramBaseData;
    if (paramViewGroup.a == null) {
      PtsData.a(paramViewGroup, null, 1, null);
    }
    paramContext = new PTSItemView(paramContext);
    paramViewGroup = paramViewGroup.a;
    if (paramViewGroup != null) {
      paramViewGroup.layoutToView(paramContext, (IPTSLiteEventListener)this.jdField_a_of_type_Tgy, true);
    }
    paramViewGroup = paramContext.getLayoutParams();
    if (paramViewGroup != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(paramViewGroup));
    }
    return (tgr)new tgv(this, (View)paramContext, paramBaseData);
  }
  
  public final void a()
  {
    Object localObject = raj.a().a("native_article");
    if (localObject == null)
    {
      QLog.i("NewPtsViewCreator", 1, "[initPtsLiteTypeCount], pageNameList is null");
      return;
    }
    int i = tgr.a;
    localObject = ((List)localObject).iterator();
    i += 1;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
      {
        Map localMap = (Map)this.jdField_a_of_type_JavaUtilHashMap;
        Intrinsics.checkExpressionValueIsNotNull(str, "pageName");
        localMap.put(str, Integer.valueOf(i));
        QLog.i("NewPtsViewCreator", 1, "[initPtsLiteTypeCount], pageName = " + str + ", viewType = " + i);
      }
      i += 1;
    }
    tgr.a += this.jdField_a_of_type_JavaUtilHashMap.size() + 1;
    QLog.i("NewPtsViewCreator", 1, "[initPtsLiteTypeCount], view type count = " + tgr.a);
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
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramPtsData)) {
      return;
    }
    PTSComposer localPTSComposer = paramPtsData.a;
    if (localPTSComposer != null) {
      localPTSComposer.triggerExposureEvent();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramPtsData);
  }
  
  public boolean a(@NotNull BaseData paramBaseData)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseData, "data");
    return paramBaseData instanceof PtsData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tgt
 * JD-Core Version:    0.7.0.1
 */