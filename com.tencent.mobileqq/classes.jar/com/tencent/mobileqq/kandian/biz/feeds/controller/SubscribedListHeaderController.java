package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SubscribedListHeaderController
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TemplateBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new VafContext();
  private TemplateFactory jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactory;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  public SubscribedListHeaderController(Activity paramActivity, FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactory = TemplateFactory.a("default_feeds", true);
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setTemplateFactory(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactory);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    a();
  }
  
  private void a()
  {
    try
    {
      String str = (String)RIJSPUtils.a("readinjoy_follow_subscribed_list_data_key", "");
      if (!TextUtils.isEmpty(str))
      {
        a(new JSONObject(str));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        return;
      }
    }
    try
    {
      TemplateBean localTemplateBean;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactory != null) {
        localTemplateBean = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactory.getTemplateBean(paramJSONObject);
      } else {
        localTemplateBean = null;
      }
      if (localTemplateBean == null)
      {
        QLog.d("SubscribedListHeaderController", 1, "templateBean is null");
        return;
      }
      if (this.jdField_a_of_type_OrgJsonJSONObject == null)
      {
        Container localContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localTemplateBean);
        if (localContainer == null) {
          return;
        }
        localContainer.setBackgroundResource(2130841773);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localContainer, -1, -1);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = localContainer;
      }
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localTemplateBean);
      ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new SubscribedListHeaderController.1(this, localTemplateBean));
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, localTemplateBean);
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = localTemplateBean;
      ProteusSupportUtil.a(localTemplateBean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), "expose_T");
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("update subscribed list data : ");
      paramJSONObject.append(this.jdField_a_of_type_OrgJsonJSONObject);
      QLog.d("SubscribedListHeaderController", 1, paramJSONObject.toString());
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.SubscribedListHeaderController
 * JD-Core Version:    0.7.0.1
 */