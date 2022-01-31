import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.2;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.5;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainerHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.BindDataUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class pcj
  extends RecyclerView.Adapter
  implements PolymericContainer
{
  private static List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static int jdField_b_of_type_Int;
  private static Map<Long, List<ArticleInfo>> c = new HashMap();
  protected int a;
  private ProteusRecycleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView;
  private EventCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericEventCallback = new pcq(this);
  public PolymericContainerHelper a;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private String jdField_a_of_type_JavaLangString = "RecycleViewAdapterHelper";
  protected Map<String, Integer> a;
  protected opw a;
  private pcs jdField_a_of_type_Pcs;
  private pct jdField_a_of_type_Pct;
  private boolean jdField_a_of_type_Boolean = true;
  private List<BaseArticleInfo> jdField_b_of_type_JavaUtilList;
  protected Map<Integer, String> b;
  
  public pcj(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper = new PolymericContainerHelper();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
  }
  
  private View a()
  {
    View localView = new View(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext());
    localView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
    localView.setVisibility(8);
    return localView;
  }
  
  public static List<Integer> a()
  {
    return jdField_a_of_type_JavaUtilList;
  }
  
  public static List<ArticleInfo> a(long paramLong)
  {
    return (List)c.get(Long.valueOf(paramLong));
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject.toString());
      paramJSONObject.put("style_ID", "ReadInjoy_daily_check_share");
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, paramJSONObject, new Object[0]);
    }
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilList.clear();
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(jdField_b_of_type_Int));
  }
  
  private void a(int paramInt)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "addExportItem curPosition: " + paramInt + "  model :" + this.jdField_a_of_type_Opw);
    TemplateBean localTemplateBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.getCellData(paramInt);
    if ((this.jdField_a_of_type_Opw != null) && (this.jdField_a_of_type_Opw.a() != null) && (localTemplateBean != null)) {}
    try
    {
      if ((this.jdField_a_of_type_Opw.a().mGroupSubArticleList != null) && (this.jdField_a_of_type_Opw.a().mGroupSubArticleList.size() > paramInt) && (obz.s(this.jdField_a_of_type_Opw.a())) && (this.jdField_a_of_type_Opw.a().mNewPolymericInfo.jdField_a_of_type_Boolean)) {
        a((BaseArticleInfo)this.jdField_a_of_type_Opw.a().mGroupSubArticleList.get(paramInt), paramInt);
      }
      for (;;)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "addExportItem added curPosition: " + paramInt + "  data :" + localTemplateBean + "   " + localTemplateBean.getDataAttribute(null));
        Object localObject1;
        do
        {
          return;
          localObject2 = (List)c.get(Long.valueOf(this.jdField_a_of_type_Opw.a().mArticleID));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            c.put(Long.valueOf(this.jdField_a_of_type_Opw.a().mArticleID), localObject1);
          }
        } while (paramInt < ((List)localObject1).size());
        Object localObject2 = this.jdField_a_of_type_Opw.a().clone();
        ((ArticleInfo)localObject2).mProteusTemplateBean = localTemplateBean;
        ((List)localObject1).add(localObject2);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, localException.getMessage());
      }
    }
  }
  
  public static void a(long paramLong)
  {
    c.remove(Long.valueOf(paramLong));
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    Object localObject;
    ArticleInfo localArticleInfo;
    int j;
    int k;
    if ((paramBaseArticleInfo instanceof ArticleInfo))
    {
      localObject = this.jdField_a_of_type_Opw.a().getContext();
      localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
      j = getItemViewType(paramInt);
      k = (int)paramBaseArticleInfo.mChannelID;
      if (paramBaseArticleInfo.mChannelID != 3L) {
        break label108;
      }
    }
    label108:
    for (int i = 1;; i = 0)
    {
      localObject = new oqh((Context)localObject, localArticleInfo, j, k, i, paramInt, false, a(), null, this.jdField_a_of_type_Opw.a());
      this.jdField_a_of_type_Opw.a().a(paramBaseArticleInfo, (opw)localObject, System.currentTimeMillis(), paramInt);
      return;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.isComputingLayout())
    {
      paramRunnable.run();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.postDelayed(new RecycleViewAdapterHelper.5(this, paramRunnable), 100L);
  }
  
  private void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.childs.size();
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean)
    {
      int j = a();
      i = paramInt;
      if (j > 0) {
        i = paramInt % j;
      }
    }
    return i;
  }
  
  public void a(ProteusRecycleView paramProteusRecycleView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView = paramProteusRecycleView;
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void a(opw paramopw)
  {
    if (paramopw == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Opw = paramopw;
    } while (this.jdField_a_of_type_Opw.a() == null);
    a(this.jdField_a_of_type_Opw.a().mGroupSubArticleList);
  }
  
  public void a(pcs parampcs)
  {
    this.jdField_a_of_type_Pcs = parampcs;
  }
  
  public void a(pct parampct)
  {
    this.jdField_a_of_type_Pct = parampct;
    a(new RecycleViewAdapterHelper.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public EventCallback getEventCallback()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericEventCallback;
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_Boolean) && (a() > 1)) {
      return 2147483647;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.childs.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    paramInt = a(paramInt);
    TemplateBean localTemplateBean = (TemplateBean)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.childs.get(paramInt);
    Integer localInteger2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localTemplateBean.getStyleName());
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger1 = Integer.valueOf(this.jdField_a_of_type_Int);
      a(localTemplateBean.getStyleName(), localInteger1.intValue());
      this.jdField_a_of_type_Int += 1;
    }
    return localInteger1.intValue();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramInt = a(paramInt);
    Object localObject;
    if ((paramViewHolder instanceof pcu))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.getCellData(paramInt);
      if (localObject == null) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "data == null");
      }
    }
    do
    {
      do
      {
        return;
        a(paramInt);
        paramViewHolder = (pcu)paramViewHolder;
        Container localContainer = (Container)paramViewHolder.itemView;
        BindDataUtil.bindDynamicValueWithoutRecursion(localContainer, paramViewHolder.a, (TemplateBean)localObject);
        Layout.Params localParams = localContainer.getVirtualView().getComLayoutParams();
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localContainer.getLayoutParams();
        if ((localParams.mLayoutWidth > 0) && (localParams.mLayoutHeight > 0) && ((localLayoutParams.width != localParams.mLayoutWidth) || (localLayoutParams.height != localParams.mLayoutHeight)))
        {
          localLayoutParams.width = localParams.mLayoutWidth;
          localLayoutParams.height = localParams.mLayoutHeight;
          localContainer.setLayoutParams(localLayoutParams);
        }
        ViewFactory.findClickableViewListener(((Container)paramViewHolder.itemView).getVirtualView(), new pck(this, paramInt, (TemplateBean)localObject));
        return;
      } while (!(paramViewHolder instanceof pcr));
      paramViewHolder = (pcr)paramViewHolder;
      localObject = paramViewHolder.itemView.getLayoutParams();
    } while (localObject == null);
    ((ViewGroup.LayoutParams)localObject).width = 0;
    ((ViewGroup.LayoutParams)localObject).height = 0;
    paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (String)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getTemplateFactory().getTemplate(paramViewGroup);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (TemplateBean)localObject);
    if (localObject == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "styleName : " + paramViewGroup);
      rsk.a("error", "", paramViewGroup);
      a(new RecycleViewAdapterHelper.2(this));
      return new pcr(this, a());
    }
    paramViewGroup = ((Container)localObject).getVirtualView().getComLayoutParams();
    ((Container)localObject).setLayoutParams(new RecyclerView.LayoutParams(paramViewGroup.mLayoutWidth, paramViewGroup.mLayoutHeight));
    return new pcu(this, (Container)localObject, null);
  }
  
  public void setCellArray(BaseTemplateFactory paramBaseTemplateFactory, JSONArray paramJSONArray)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.setCellArray(paramBaseTemplateFactory, paramJSONArray);
  }
  
  public void setEventCallback(EventCallback paramEventCallback)
  {
    if (paramEventCallback == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericEventCallback = paramEventCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcj
 * JD-Core Version:    0.7.0.1
 */