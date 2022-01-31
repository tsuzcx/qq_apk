import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebPtsLiteViewCreator.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebPtsLiteViewCreator.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class sbx
  implements sai, sak
{
  private Context jdField_a_of_type_AndroidContentContext;
  private HashMap<String, BaseData> jdField_a_of_type_JavaUtilHashMap;
  private List<String> jdField_a_of_type_JavaUtilList;
  private pvs jdField_a_of_type_Pvs;
  private HashMap<String, Integer> b;
  
  public sbx(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Pvs = new pvs(paramContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    g();
  }
  
  private PTSItemData a(BaseData paramBaseData)
  {
    paramBaseData = (ProteusItemData)paramBaseData;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramBaseData.X, paramBaseData);
    return paramBaseData.a;
  }
  
  private void a(PTSItemData paramPTSItemData)
  {
    ThreadManager.executeOnSubThread(new WebPtsLiteViewCreator.3(this, paramPTSItemData));
  }
  
  private void g()
  {
    this.jdField_a_of_type_Pvs.a(new sby(this));
  }
  
  public int a(BaseData paramBaseData)
  {
    paramBaseData = (ProteusItemData)paramBaseData;
    Integer localInteger = (Integer)this.b.get(paramBaseData.Y);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    QLog.e("WebPtsLiteViewCreator", 1, "[getViewType] error, appName = " + paramBaseData.Y);
    return -1;
  }
  
  public sah a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    paramContext = a(paramBaseData);
    paramContext = this.jdField_a_of_type_Pvs.a(null, paramContext);
    if (paramContext.getLayoutParams() != null) {
      paramContext.setLayoutParams(new AbsListView.LayoutParams(paramContext.getLayoutParams()));
    }
    return new sbz(this, paramContext, paramBaseData, null);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while ((!(paramBaseData instanceof ProteusItemData)) || (TextUtils.isEmpty(((ProteusItemData)paramBaseData).Y))) {
      return false;
    }
    return true;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    ThreadManager.executeOnSubThread(new WebPtsLiteViewCreator.1(this));
    if (this.jdField_a_of_type_Pvs != null) {
      this.jdField_a_of_type_Pvs.a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Pvs != null) {
      this.jdField_a_of_type_Pvs.a();
    }
  }
  
  public void f()
  {
    Object localObject = pxa.a().a("native_article");
    if (localObject == null)
    {
      QLog.i("WebPtsLiteViewCreator", 1, "[initPtsLiteTypeCount], appNameList is null");
      return;
    }
    int i = sah.a;
    localObject = ((List)localObject).iterator();
    i += 1;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.b.containsKey(str))
      {
        this.b.put(str, Integer.valueOf(i));
        QLog.i("WebPtsLiteViewCreator", 1, "[initPtsLiteTypeCount], appName = " + str + ", viewType = " + i);
      }
      i += 1;
    }
    sah.a += this.b.size() + 1;
    QLog.i("WebPtsLiteViewCreator", 1, "[initPtsLiteTypeCount], view type count = " + sah.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sbx
 * JD-Core Version:    0.7.0.1
 */