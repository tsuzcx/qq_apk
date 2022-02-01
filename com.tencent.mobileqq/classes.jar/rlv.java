import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class rlv
{
  private Context jdField_a_of_type_AndroidContentContext;
  private qnw jdField_a_of_type_Qnw;
  
  public rlv(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qnw = new qnw(paramContext);
    b();
    a(paramViewGroup);
  }
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tips", RIJUGCAddAccountFragment.a() + " " + rlt.a());
      localJSONObject.put("edit_profile_text", rlt.c());
      localJSONObject.put("use_origin_account_text", rlt.b());
      localJSONObject.put("accountUin", pha.a());
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
    Object localObject = qpn.a().a("default_feeds", "ugc_account_popup");
    String str = a();
    localObject = new PTSItemData.Builder().withItemID("RIJUGCPopupPtsLiteBuilder").withPageName("ugc_account_popup").withFrameTreeJson((String)localObject).withJsonData(str).build();
    paramViewGroup.addView(this.jdField_a_of_type_Qnw.a(null, (PTSItemData)localObject));
  }
  
  private void b()
  {
    this.jdField_a_of_type_Qnw.a(new rlw(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qnw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlv
 * JD-Core Version:    0.7.0.1
 */