import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class mtq
  implements View.OnClickListener
{
  public int a;
  
  private mtq(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDiandianHeaderController", 2, "onItemClick: " + this.jdField_a_of_type_Int);
    }
    DiandianTopConfig localDiandianTopConfig = (DiandianTopConfig)ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).get(this.jdField_a_of_type_Int);
    ReadInJoyUtils.a(paramView.getContext(), localDiandianTopConfig.jumpUrl);
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", ReadInJoyUtils.d);
      if (localDiandianTopConfig.type == 5) {
        paramView.put("list_URL", localDiandianTopConfig.jumpUrl);
      }
      for (;;)
      {
        paramView.put("type", localDiandianTopConfig.type);
        PublicAccountReportUtils.a(null, "", "0X80092FD", "0X80092FD", 0, 0, ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).size() + "", this.jdField_a_of_type_Int + 1 + "", localDiandianTopConfig.topicId + "", paramView.toString(), false);
        return;
        paramView.put("list_URL", "0");
      }
      return;
    }
    catch (JSONException paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyDiandianHeaderController", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtq
 * JD-Core Version:    0.7.0.1
 */