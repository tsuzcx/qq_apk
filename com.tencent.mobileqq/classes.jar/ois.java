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

public class ois
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TemplateBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new VafContext();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private suz jdField_a_of_type_Suz;
  
  public ois(Activity paramActivity, FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(paramActivity);
    this.jdField_a_of_type_Suz = suz.a("default_feeds", true);
    oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setTemplateFactory(this.jdField_a_of_type_Suz);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    a();
  }
  
  private void a()
  {
    try
    {
      String str = (String)bnrf.a("readinjoy_follow_subscribed_list_data_key", "");
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
        if (this.jdField_a_of_type_Suz != null)
        {
          localTemplateBean = this.jdField_a_of_type_Suz.getTemplateBean(paramJSONObject);
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
            localContainer.setBackgroundResource(2130841693);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localContainer, -1, -1);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = localContainer;
          }
          oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localTemplateBean);
          ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new oit(this, localTemplateBean));
          oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, localTemplateBean);
          this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = localTemplateBean;
          oyj.a(localTemplateBean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), "expose_T");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ois
 * JD-Core Version:    0.7.0.1
 */