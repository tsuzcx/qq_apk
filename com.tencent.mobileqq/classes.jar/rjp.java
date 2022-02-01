import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class rjp
{
  private Context jdField_a_of_type_AndroidContentContext;
  private qmj jdField_a_of_type_Qmj;
  
  public rjp(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qmj = new qmj(paramContext);
    b();
    a(paramViewGroup);
  }
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tips", RIJUGCAddAccountFragment.a() + " " + rjn.a());
      localJSONObject.put("edit_profile_text", rjn.c());
      localJSONObject.put("use_origin_account_text", rjn.b());
      localJSONObject.put("accountUin", pay.a());
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
      localObject = qoe.a().a("default_feeds", "ugc_account_popup");
      String str = a();
      localObject = new PTSItemData.Builder().withItemID("RIJUGCPopupPtsLiteBuilder").withPageName("ugc_account_popup").withFrameTreeJson((String)localObject).withJsonData(str).build();
      localObject = this.jdField_a_of_type_Qmj.a(null, (PTSItemData)localObject);
    } while (localObject == null);
    paramViewGroup.addView((View)localObject);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Qmj.a(new rjq(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qmj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjp
 * JD-Core Version:    0.7.0.1
 */