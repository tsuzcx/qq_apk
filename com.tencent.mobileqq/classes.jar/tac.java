import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class tac
  implements View.OnClickListener
{
  tac(tab paramtab) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ((ClipboardManager)paramView.getContext().getSystemService("clipboard")).setText(this.a.a.c.getString("id_attribute_text"));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("WebProteusViewCreator", 1, "showAsDropDown error,msg:" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tac
 * JD-Core Version:    0.7.0.1
 */