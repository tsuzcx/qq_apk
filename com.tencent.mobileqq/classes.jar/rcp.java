import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class rcp
{
  private Context jdField_a_of_type_AndroidContentContext;
  private qgi jdField_a_of_type_Qgi;
  
  public rcp(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qgi = new qgi(paramContext);
    b();
    a(paramViewGroup);
  }
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tips", RIJUGCAddAccountFragment.a() + " " + rcn.a());
      localJSONObject.put("edit_profile_text", rcn.c());
      localJSONObject.put("use_origin_account_text", rcn.b());
      localJSONObject.put("accountUin", ozs.a());
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
    if (paramViewGroup == null) {
      return;
    }
    Object localObject = qib.a().a("default_feeds", "ugc_account_popup");
    String str = a();
    localObject = new PTSItemData.Builder().withItemID("RIJUGCPopupPtsLiteBuilder").withPageName("ugc_account_popup").withFrameTreeJson((String)localObject).withJsonData(str).build();
    paramViewGroup.addView(this.jdField_a_of_type_Qgi.a(null, (PTSItemData)localObject));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Qgi.a(new rcq(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qgi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rcp
 * JD-Core Version:    0.7.0.1
 */