import com.tencent.biz.pubaccount.CustomWebView;
import org.json.JSONException;
import org.json.JSONObject;

class sfl
  implements bbll
{
  sfl(sfk paramsfk) {}
  
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
        if (this.a.jdField_a_of_type_Bcdb.a() != null) {
          this.a.jdField_a_of_type_Bcdb.a().callJs(sfn.h, new String[] { paramString.toString() });
        }
        axqw.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2F", "0X8005D2F", 0, 0, "1", "", "", "");
        if (this.a.jdField_a_of_type_Bblk != null) {
          this.a.jdField_a_of_type_Bblk.f();
        }
        this.a.jdField_a_of_type_Bblk = null;
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
          paramString.put("msg", ajyc.a(2131708776) + this.a.d() + ajyc.a(2131708770));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sfl
 * JD-Core Version:    0.7.0.1
 */