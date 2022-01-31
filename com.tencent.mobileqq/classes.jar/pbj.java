import com.tencent.biz.webviewplugin.HotchatPlugin;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import org.json.JSONObject;

public class pbj
  implements PopupMenuDialog.OnClickActionListener
{
  public pbj(HotchatPlugin paramHotchatPlugin, String paramString) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    JSONObject localJSONObject = new JSONObject();
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      try
      {
        localJSONObject.put("index", 0);
        this.jdField_a_of_type_ComTencentBizWebviewpluginHotchatPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception paramMenuItem)
      {
        paramMenuItem.printStackTrace();
        return;
      }
    }
    try
    {
      localJSONObject.put("index", 1);
      this.jdField_a_of_type_ComTencentBizWebviewpluginHotchatPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramMenuItem)
    {
      paramMenuItem.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbj
 * JD-Core Version:    0.7.0.1
 */