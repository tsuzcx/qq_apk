import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nxp
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TemplateBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new VafContext();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private sfq jdField_a_of_type_Sfq;
  
  public nxp(Activity paramActivity, FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    this.jdField_a_of_type_Sfq = sfq.a("default_feeds", true);
    opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setTemplateFactory(this.jdField_a_of_type_Sfq);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    a();
  }
  
  private void a()
  {
    try
    {
      String str = (String)bkbq.a("readinjoy_follow_subscribed_list_data_key", "");
      if (!TextUtils.isEmpty(str)) {
        a(new JSONObject(str));
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Sfq != null)
        {
          localTemplateBean = this.jdField_a_of_type_Sfq.getTemplateBean(paramJSONObject);
          if (localTemplateBean == null)
          {
            QLog.d("SubscribedListHeaderController", 1, "templateBean is null");
            return;
          }
          if (this.jdField_a_of_type_OrgJsonJSONObject == null)
          {
            Container localContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localTemplateBean);
            if (localContainer == null) {
              break;
            }
            localContainer.setBackgroundResource(2130841381);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localContainer, -1, -1);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = localContainer;
          }
          opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localTemplateBean);
          ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new nxq(this, localTemplateBean));
          opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, localTemplateBean);
          this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = localTemplateBean;
          opy.a(localTemplateBean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), "expose_T");
          QLog.d("SubscribedListHeaderController", 1, "update subscribed list data : " + this.jdField_a_of_type_OrgJsonJSONObject);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        return;
      }
      TemplateBean localTemplateBean = null;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nxp
 * JD-Core Version:    0.7.0.1
 */