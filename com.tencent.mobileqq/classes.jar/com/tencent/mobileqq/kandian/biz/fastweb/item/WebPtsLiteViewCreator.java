package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.fastweb.IStateChangeListener;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteItemViewUtil;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteItemViewUtil.Companion;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
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

public class WebPtsLiteViewCreator
  implements IStateChangeListener, ItemCreator
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IPTSLiteEventListener jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  private HashMap<String, BaseData> jdField_a_of_type_JavaUtilHashMap;
  private List<String> jdField_a_of_type_JavaUtilList;
  private HashMap<String, Integer> b;
  
  public WebPtsLiteViewCreator(Context paramContext)
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
    this.jdField_a_of_type_JavaUtilHashMap.put(paramBaseData.ae, paramBaseData);
    return paramBaseData.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemData;
  }
  
  private void a(PTSItemData paramPTSItemData)
  {
    ThreadManager.executeOnSubThread(new WebPtsLiteViewCreator.3(this, paramPTSItemData));
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener = new WebPtsLiteViewCreator.2(this);
  }
  
  public int a(BaseData paramBaseData)
  {
    paramBaseData = (ProteusItemData)paramBaseData;
    Object localObject = (Integer)this.b.get(paramBaseData.af);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getViewType] error, pageName = ");
    ((StringBuilder)localObject).append(paramBaseData.af);
    QLog.e("WebPtsLiteViewCreator", 1, ((StringBuilder)localObject).toString());
    return -1;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    paramContext = new PTSItemView(paramContext);
    paramContext = ((ProteusItemData)paramBaseData).jdField_a_of_type_ComTencentPtsCorePTSComposer.layoutToView(paramContext, this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener, true);
    PTSLiteItemViewUtil.a.a(paramContext);
    if (paramContext.getLayoutParams() != null) {
      paramContext.setLayoutParams(new AbsListView.LayoutParams(paramContext.getLayoutParams()));
    }
    return new WebPtsLiteViewCreator.PTSLiteItemViewHolder(this, paramContext, paramBaseData, null);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    boolean bool2 = false;
    if (paramBaseData == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((paramBaseData instanceof ProteusItemData))
    {
      bool1 = bool2;
      if (((ProteusItemData)paramBaseData).jdField_a_of_type_ComTencentPtsCorePTSComposer != null) {
        bool1 = true;
      }
    }
    return bool1;
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
    Object localObject = PTSStyleManager.a().a("native_article");
    if (localObject == null)
    {
      QLog.i("WebPtsLiteViewCreator", 1, "[initPtsLiteTypeCount], pageNameList is null");
      return;
    }
    int i = BaseItemViewHolder.a + 1;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.b.containsKey(str))
      {
        this.b.put(str, Integer.valueOf(i));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initPtsLiteTypeCount], pageName = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", viewType = ");
        localStringBuilder.append(i);
        QLog.i("WebPtsLiteViewCreator", 1, localStringBuilder.toString());
      }
      i += 1;
    }
    BaseItemViewHolder.a += this.b.size() + 1;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initPtsLiteTypeCount], view type count = ");
    ((StringBuilder)localObject).append(BaseItemViewHolder.a);
    QLog.i("WebPtsLiteViewCreator", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebPtsLiteViewCreator
 * JD-Core Version:    0.7.0.1
 */