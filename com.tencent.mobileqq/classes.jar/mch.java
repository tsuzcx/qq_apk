import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class mch
  extends mul
{
  public mch(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(mup parammup)
  {
    AudioHelper.b("上传SelfNickName_rsp");
    String str = "";
    if (parammup.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        parammup = new String(parammup.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (parammup != null)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(parammup);
            i = localJSONObject.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.a, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i);
            }
            parammup = str;
            if (localJSONObject.has("result"))
            {
              localJSONObject = localJSONObject.getJSONObject("result");
              parammup = str;
              if (localJSONObject.has("result_code")) {
                parammup = localJSONObject.getString("result_code");
              }
            }
          }
          catch (JSONException parammup)
          {
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.i(this.a.a, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
            parammup = "";
            i = -2;
            continue;
            this.a.a(1, 0);
            this.a.finish();
            return;
          }
          if ((i == 0) && (parammup.equals("0")))
          {
            this.a.b();
            return;
          }
        }
      }
      catch (Exception parammup)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.a, 2, "onPostDownloadComplete :" + parammup.toString());
        }
        parammup = null;
        continue;
      }
      label248:
      parammup = "";
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mch
 * JD-Core Version:    0.7.0.1
 */