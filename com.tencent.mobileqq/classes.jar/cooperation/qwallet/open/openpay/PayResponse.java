package cooperation.qwallet.open.openpay;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public class PayResponse
  extends BaseResponse
{
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("_mqqpay_payresp_paychanneltype", this.g);
    paramBundle.putString("_mqqpay_payresp_transactionid", this.h);
    paramBundle.putString("_mqqpay_payresp_paytime", this.i);
    paramBundle.putString("_mqqpay_payresp_totalfee", this.j);
    paramBundle.putString("_mqqpay_payresp_callbackurl", this.k);
    paramBundle.putString("_mqqpay_payresp_spdata", this.l);
    paramBundle.putString("_mqqpay_payapi_serialnumber", this.m);
    paramBundle.putString("_mqqpay_payapi_openid", this.n);
  }
  
  public String b()
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("name", "pay");
      localJSONObject1.put("identifier", this.m);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("code", this.c);
      localJSONObject2.put("message", this.d);
      ((JSONObject)localObject).put("action", localJSONObject1);
      ((JSONObject)localObject).put("params", localJSONObject2);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.open.openpay.PayResponse
 * JD-Core Version:    0.7.0.1
 */