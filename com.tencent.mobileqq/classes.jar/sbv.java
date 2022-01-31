import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class sbv
  implements View.OnClickListener
{
  sbv(sbu paramsbu) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ((ClipboardManager)paramView.getContext().getSystemService("clipboard")).setText(this.a.a.c.getString("id_attribute_text"));
      return;
    }
    catch (Exception paramView)
    {
      QLog.d("WebProteusViewCreator", 1, "showAsDropDown error,msg:" + paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sbv
 * JD-Core Version:    0.7.0.1
 */