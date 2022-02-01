import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class mbu
  extends muk
{
  public mbu(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(mun parammun)
  {
    AudioHelper.b("上传SelfNickName_rsp");
    String str = "";
    if (parammun.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        parammun = new String(parammun.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (parammun != null)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(parammun);
            i = localJSONObject.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.a, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i);
            }
            parammun = str;
            if (localJSONObject.has("result"))
            {
              localJSONObject = localJSONObject.getJSONObject("result");
              parammun = str;
              if (localJSONObject.has("result_code")) {
                parammun = localJSONObject.getString("result_code");
              }
            }
          }
          catch (JSONException parammun)
          {
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.i(this.a.a, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
            parammun = "";
            i = -2;
            continue;
            this.a.a(1, 0);
            this.a.finish();
            return;
          }
          if ((i == 0) && (parammun.equals("0")))
          {
            this.a.b();
            return;
          }
        }
      }
      catch (Exception parammun)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.a, 2, "onPostDownloadComplete :" + parammun.toString());
        }
        parammun = null;
        continue;
      }
      label248:
      parammun = "";
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mbu
 * JD-Core Version:    0.7.0.1
 */