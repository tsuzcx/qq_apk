import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class sbr
  extends sah
{
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  public sbr(sbq paramsbq, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
  }
  
  private void a(Context paramContext, ProteusItemData paramProteusItemData)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new sbs(this, paramProteusItemData, paramContext));
  }
  
  private void a(View paramView, BaseData paramBaseData)
  {
    if ((paramView == null) || (paramBaseData == null)) {}
    for (;;)
    {
      return;
      try
      {
        ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
        if (((ProteusItemData)paramBaseData).v == 1)
        {
          paramView.setOnLongClickListener(new sbu(this, paramView, localProteusItemData));
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.d("WebProteusViewCreator", 1, "addLongClickListener error,msg:" + paramView.toString());
      }
    }
  }
  
  private boolean a()
  {
    return !bdem.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0");
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) || (paramBaseData2 == null)) {}
    for (;;)
    {
      return;
      if (!(paramBaseData2 instanceof ProteusItemData)) {
        continue;
      }
      paramBaseData1 = (ProteusItemData)paramBaseData2;
      TemplateBean localTemplateBean = paramBaseData1.a;
      if (localTemplateBean != null) {
        sbq.a(this.jdField_a_of_type_Sbq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
      }
      try
      {
        localTemplateBean.bindData(paramBaseData1.c);
        opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramBaseData1.a.getViewBean());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData1;
        label77:
        a(sbq.a(this.jdField_a_of_type_Sbq), paramBaseData1);
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, paramBaseData2);
        if (!(paramBaseData2 instanceof ProteusAnimationItemData)) {
          continue;
        }
        ((ProteusAnimationItemData)paramBaseData2).a(this.jdField_a_of_type_AndroidViewView);
        return;
      }
      catch (Exception localException)
      {
        break label77;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sbr
 * JD-Core Version:    0.7.0.1
 */