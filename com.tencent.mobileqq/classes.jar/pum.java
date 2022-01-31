import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyShareFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class pum
  implements ViewBase.OnClickListener
{
  pum(puh parampuh) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    opy.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    paramViewBase = pug.a(this.a.jdField_a_of_type_Pug, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getData());
    if (paramViewBase == null)
    {
      QLog.e(pug.a(this.a.jdField_a_of_type_Pug), 1, "daily share info is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("share_info_intent", paramViewBase.toString());
    PublicFragmentActivity.a(pug.a(this.a.jdField_a_of_type_Pug).getContext(), localIntent, ReadInJoyDailyShareFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pum
 * JD-Core Version:    0.7.0.1
 */