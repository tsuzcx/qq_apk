import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class rwc
{
  private Context jdField_a_of_type_AndroidContentContext;
  private qyo jdField_a_of_type_Qyo;
  
  public rwc(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qyo = new qyo(paramContext);
    b();
    a(paramViewGroup);
  }
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tips", RIJUGCAddAccountFragment.a() + " " + rwa.a());
      localJSONObject.put("edit_profile_text", rwa.c());
      localJSONObject.put("use_origin_account_text", rwa.b());
      localJSONObject.put("accountUin", pkh.a());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("RIJUGCPopupPtsLiteBuilder", 1, "[getJsonData] error, e = " + localJSONException);
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    Object localObject;
    do
    {
      return;
      localObject = raj.a().a("default_feeds", "ugc_account_popup");
      String str = a();
      localObject = new PTSItemData.Builder().withItemID("RIJUGCPopupPtsLiteBuilder").withPageName("ugc_account_popup").withFrameTreeJson((String)localObject).withJsonData(str).build();
      localObject = this.jdField_a_of_type_Qyo.a(null, (PTSItemData)localObject);
    } while (localObject == null);
    paramViewGroup.addView((View)localObject);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Qyo.a(new rwd(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qyo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwc
 * JD-Core Version:    0.7.0.1
 */