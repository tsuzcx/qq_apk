import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyShareFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class qxc
  implements ViewBase.OnClickListener
{
  qxc(qwy paramqwy) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    piv.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    paramViewBase = qwx.a(this.a.jdField_a_of_type_Qwx, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getData());
    if (paramViewBase == null)
    {
      QLog.e("RecycleViewAdapterHelper", 1, "daily share info is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("share_info_intent", paramViewBase.toString());
    PublicFragmentActivity.a(qwx.a(this.a.jdField_a_of_type_Qwx).getContext(), localIntent, ReadInJoyDailyShareFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxc
 * JD-Core Version:    0.7.0.1
 */