import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.DiandianTopConfig;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class sxn
  implements View.OnClickListener
{
  public int a;
  
  private sxn(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDiandianHeaderController", 2, "onItemClick: " + this.jdField_a_of_type_Int);
    }
    DiandianTopConfig localDiandianTopConfig = (DiandianTopConfig)ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).get(this.jdField_a_of_type_Int);
    pay.a(paramView.getContext(), localDiandianTopConfig.jumpUrl);
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", pay.d);
        if (localDiandianTopConfig.type != 5) {
          continue;
        }
        localJSONObject.put("list_URL", localDiandianTopConfig.jumpUrl);
        localJSONObject.put("type", localDiandianTopConfig.type);
        odq.a(null, "", "0X80092FD", "0X80092FD", 0, 0, ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).size() + "", this.jdField_a_of_type_Int + 1 + "", localDiandianTopConfig.topicId + "", localJSONObject.toString(), false);
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ReadInJoyDiandianHeaderController", 2, localJSONException.toString());
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localJSONObject.put("list_URL", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxn
 * JD-Core Version:    0.7.0.1
 */