import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class qzi
  implements View.OnClickListener
{
  qzi(qzh paramqzh) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ((ClipboardManager)paramView.getContext().getSystemService("clipboard")).setText(this.a.a.b.getString("id_attribute_text"));
      return;
    }
    catch (Exception paramView)
    {
      QLog.d("WebProteusViewCreator", 1, "showAsDropDown error,msg:" + paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzi
 * JD-Core Version:    0.7.0.1
 */