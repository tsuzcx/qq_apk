import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class mcu
  extends mvq
{
  public mcu(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(mvt parammvt)
  {
    AudioHelper.b("上传SelfNickName_rsp");
    String str = "";
    if (parammvt.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        parammvt = new String(parammvt.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (parammvt != null)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(parammvt);
            i = localJSONObject.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.a, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i);
            }
            parammvt = str;
            if (localJSONObject.has("result"))
            {
              localJSONObject = localJSONObject.getJSONObject("result");
              parammvt = str;
              if (localJSONObject.has("result_code")) {
                parammvt = localJSONObject.getString("result_code");
              }
            }
          }
          catch (JSONException parammvt)
          {
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.i(this.a.a, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
            parammvt = "";
            i = -2;
            continue;
            this.a.a(1, 0);
            this.a.finish();
            return;
          }
          if ((i == 0) && (parammvt.equals("0")))
          {
            this.a.b();
            return;
          }
        }
      }
      catch (Exception parammvt)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.a, 2, "onPostDownloadComplete :" + parammvt.toString());
        }
        parammvt = null;
        continue;
      }
      label248:
      parammvt = "";
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mcu
 * JD-Core Version:    0.7.0.1
 */