import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebPtsLiteViewCreator.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebPtsLiteViewCreator.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class svg
  implements sth, stm
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IPTSLiteEventListener jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  private HashMap<String, BaseData> jdField_a_of_type_JavaUtilHashMap;
  private List<String> jdField_a_of_type_JavaUtilList;
  private HashMap<String, Integer> b;
  
  public svg(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    g();
  }
  
  private PTSItemData a(BaseData paramBaseData)
  {
    paramBaseData = (ProteusItemData)paramBaseData;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramBaseData.Q, paramBaseData);
    return paramBaseData.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemData;
  }
  
  private void a(PTSItemData paramPTSItemData)
  {
    ThreadManager.executeOnSubThread(new WebPtsLiteViewCreator.3(this, paramPTSItemData));
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener = new svh(this);
  }
  
  public int a(BaseData paramBaseData)
  {
    paramBaseData = (ProteusItemData)paramBaseData;
    Integer localInteger = (Integer)this.b.get(paramBaseData.R);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    QLog.e("WebPtsLiteViewCreator", 1, "[getViewType] error, pageName = " + paramBaseData.R);
    return -1;
  }
  
  public stg a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    paramContext = new PTSItemView(paramContext);
    paramContext = ((ProteusItemData)paramBaseData).jdField_a_of_type_ComTencentPtsCorePTSComposer.layoutToView(paramContext, this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener, true);
    qnw.a.a(paramContext);
    if (paramContext.getLayoutParams() != null) {
      paramContext.setLayoutParams(new AbsListView.LayoutParams(paramContext.getLayoutParams()));
    }
    return new svi(this, paramContext, paramBaseData, null);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while ((!(paramBaseData instanceof ProteusItemData)) || (((ProteusItemData)paramBaseData).jdField_a_of_type_ComTencentPtsCorePTSComposer == null)) {
      return false;
    }
    return true;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    ThreadManager.executeOnSubThread(new WebPtsLiteViewCreator.1(this));
  }
  
  public void e() {}
  
  public void f()
  {
    Object localObject = qoe.a().a("native_article");
    if (localObject == null)
    {
      QLog.i("WebPtsLiteViewCreator", 1, "[initPtsLiteTypeCount], pageNameList is null");
      return;
    }
    int i = stg.a;
    localObject = ((List)localObject).iterator();
    i += 1;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.b.containsKey(str))
      {
        this.b.put(str, Integer.valueOf(i));
        QLog.i("WebPtsLiteViewCreator", 1, "[initPtsLiteTypeCount], pageName = " + str + ", viewType = " + i);
      }
      i += 1;
    }
    stg.a += this.b.size() + 1;
    QLog.i("WebPtsLiteViewCreator", 1, "[initPtsLiteTypeCount], view type count = " + stg.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svg
 * JD-Core Version:    0.7.0.1
 */