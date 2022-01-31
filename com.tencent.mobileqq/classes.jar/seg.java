import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class seg
  implements View.OnClickListener
{
  public int a;
  
  private seg(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDiandianHeaderController", 2, "onItemClick: " + this.jdField_a_of_type_Int);
    }
    DiandianTopConfig localDiandianTopConfig = (DiandianTopConfig)ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).get(this.jdField_a_of_type_Int);
    ors.a(paramView.getContext(), localDiandianTopConfig.jumpUrl);
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", ors.d);
      if (localDiandianTopConfig.type == 5) {
        paramView.put("list_URL", localDiandianTopConfig.jumpUrl);
      }
      for (;;)
      {
        paramView.put("type", localDiandianTopConfig.type);
        nrt.a(null, "", "0X80092FD", "0X80092FD", 0, 0, ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).size() + "", this.jdField_a_of_type_Int + 1 + "", localDiandianTopConfig.topicId + "", paramView.toString(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     seg
 * JD-Core Version:    0.7.0.1
 */