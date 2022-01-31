import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class rla
  implements rkh, rkj
{
  private Context jdField_a_of_type_AndroidContentContext;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private rmq jdField_a_of_type_Rmq = new rmq();
  
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
  
  private void a(Container paramContainer, RecommendAdData paramRecommendAdData)
  {
    Object localObject;
    if (paramContainer != null)
    {
      paramContainer = paramContainer.getVirtualView();
      if (paramContainer != null)
      {
        localObject = paramContainer.findViewBaseByName("id_recommend_title");
        if ((localObject != null) && (((ViewBase)localObject).getNativeView() != null) && ((((ViewBase)localObject).getNativeView() instanceof NativeTextImp)))
        {
          localObject = (NativeTextImp)((ViewBase)localObject).getNativeView();
          ((NativeTextImp)localObject).setLines(2);
          ((NativeTextImp)localObject).setGravity(51);
        }
        localObject = paramContainer.findViewBaseByName("id_recommend_category_download");
        if ((localObject == null) || (((ViewBase)localObject).getNativeView() == null) || (!(((ViewBase)localObject).getNativeView() instanceof NativeTextImp)) || (paramRecommendAdData.jdField_d_of_type_Int != 12) || (TextUtils.isEmpty(paramRecommendAdData.p))) {
          break label152;
        }
        localObject = (NativeTextImp)((ViewBase)localObject).getNativeView();
        if ((localObject == null) || (paramRecommendAdData.jdField_d_of_type_Boolean)) {
          break label133;
        }
        ((NativeTextImp)localObject).setVisibility(8);
      }
    }
    label133:
    label152:
    label200:
    for (;;)
    {
      return;
      if (nmc.a(BaseApplicationImpl.getContext(), paramRecommendAdData.p)) {
        ((NativeTextImp)localObject).setText("立即打开");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramRecommendAdData.L)) {
          break label200;
        }
        paramContainer = paramContainer.findViewBaseByName("id_recommend_account_name");
        if (paramContainer == null) {
          break;
        }
        paramContainer.getComLayoutParams().mLayoutMarginLeft = actj.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        return;
        ((NativeTextImp)localObject).setText("立即下载");
      }
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof RecommendAdData)) {
      i = 9;
    }
    return i;
  }
  
  public rkg a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pol();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
      olo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    paramBaseData = null;
    try
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.a);
      paramBaseData = paramViewGroup;
      olo.a(((Container)paramViewGroup).getVirtualView(), localProteusItemData.a.getViewBean());
      paramBaseData = paramViewGroup;
      str = localProteusItemData.b.toString();
      paramBaseData = paramViewGroup;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        boolean bool;
        String str = "error!! msg=" + paramViewGroup.toString();
      }
    }
    bool = false;
    paramViewGroup = paramBaseData;
    if (paramBaseData == null)
    {
      paramViewGroup = new View(paramContext);
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebFastProteusViewAdCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    }
    return new rlb(this, paramViewGroup, localProteusItemData);
  }
  
  public void a() {}
  
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
  
  public void b()
  {
    this.jdField_a_of_type_Rmq.a();
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_Rmq.b();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rla
 * JD-Core Version:    0.7.0.1
 */