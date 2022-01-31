import com.tencent.biz.pubaccount.CustomWebView;
import org.json.JSONException;
import org.json.JSONObject;

class sxc
  implements bdkt
{
  sxc(sxb paramsxb) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    paramString = new JSONObject();
    if (paramInt1 == 8) {}
    for (;;)
    {
      try
      {
        paramString.put("retCode", -1);
        paramString.put("msg", "fail");
        paramString.put("localId", this.a.d());
        if (this.a.jdField_a_of_type_Becq.a() != null) {
          this.a.jdField_a_of_type_Becq.a().callJs(sxe.h, new String[] { paramString.toString() });
        }
        azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2F", "0X8005D2F", 0, 0, "1", "", "", "");
        if (this.a.jdField_a_of_type_Bdks != null) {
          this.a.jdField_a_of_type_Bdks.f();
        }
        this.a.jdField_a_of_type_Bdks = null;
        return;
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      if (paramInt1 == 4) {
        try
        {
          paramString.put("retCode", 0);
          paramString.put("msg", alpo.a(2131709159) + this.a.d() + alpo.a(2131709153));
          paramString.put("localId", this.a.d());
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sxc
 * JD-Core Version:    0.7.0.1
 */