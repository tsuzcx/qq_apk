import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class qzd
  implements qxs, qxu
{
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private void a(Container paramContainer)
  {
    int i = 8;
    int j = 0;
    ViewBase localViewBase;
    if (paramContainer != null)
    {
      localViewBase = paramContainer.getVirtualView();
      if (localViewBase != null)
      {
        paramContainer = localViewBase.findViewBaseByName("id_large_video_icon");
        localViewBase = localViewBase.findViewBaseByName("id_video_bg");
        if (!NetworkState.isWifiConn()) {
          break label64;
        }
      }
    }
    for (;;)
    {
      if (paramContainer != null) {
        paramContainer.setVisibility(j);
      }
      if (localViewBase != null) {
        localViewBase.setVisibility(i);
      }
      return;
      label64:
      j = 8;
      i = 0;
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusItemData))
    {
      paramBaseData = (ProteusItemData)paramBaseData;
      if (paramBaseData.a != null)
      {
        paramBaseData = paramBaseData.a.getStyleName();
        Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramBaseData);
        if (localInteger != null) {
          return localInteger.intValue();
        }
        QLog.d("WebProteusViewCreator", 1, "getViewType error,styleName:" + paramBaseData);
      }
    }
    return -1;
  }
  
  public qxr a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pcw();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    paramViewGroup = null;
    try
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.a);
      paramViewGroup = (ViewGroup)localObject;
      oag.a(((Container)localObject).getVirtualView(), localProteusItemData.a.getViewBean());
      paramViewGroup = (ViewGroup)localObject;
      str = localProteusItemData.b.toString();
      paramViewGroup = (ViewGroup)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        boolean bool;
        String str = "error!! msg=" + localException.toString();
      }
    }
    bool = false;
    localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject = new View(paramContext);
      bool = true;
    }
    QLog.d("WebProteusViewCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    if ((paramBaseData instanceof ProteusAnimationItemData)) {
      ((ProteusAnimationItemData)paramBaseData).a((View)localObject);
    }
    return new qze(this, (View)localObject, localProteusItemData);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pcw();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
          oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
          paramContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getTemplateFactory().getNameTemplateMap().keySet();
          qxr.a = 31;
          int i = qxr.a + 1;
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            String str = (String)paramContext.next();
            if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str))
            {
              this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(i));
              i += 1;
            }
          }
          else
          {
            QLog.d("WebProteusViewCreator", 1, "VIEW_TYPE_COUNT=" + qxr.a + ",NAME_VIEWTYPE_MAP size=" + this.jdField_a_of_type_JavaUtilMap.size() + "type=" + i);
            qxr.a += this.jdField_a_of_type_JavaUtilMap.size() + 1;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("WebProteusViewCreator", 1, "initProteusTypeCount error,msg:" + paramContext.toString());
        return;
      }
    }
  }
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    switch (paramBaseData.p)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzd
 * JD-Core Version:    0.7.0.1
 */