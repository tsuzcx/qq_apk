import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class mcc
  extends mui
{
  public mcc(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(mum parammum)
  {
    AudioHelper.b("上传SelfNickName_rsp");
    String str = "";
    if (parammum.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        parammum = new String(parammum.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (parammum != null)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(parammum);
            i = localJSONObject.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.a, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i);
            }
            parammum = str;
            if (localJSONObject.has("result"))
            {
              localJSONObject = localJSONObject.getJSONObject("result");
              parammum = str;
              if (localJSONObject.has("result_code")) {
                parammum = localJSONObject.getString("result_code");
              }
            }
          }
          catch (JSONException parammum)
          {
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.i(this.a.a, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
            parammum = "";
            i = -2;
            continue;
            this.a.a(1, 0);
            this.a.finish();
            return;
          }
          if ((i == 0) && (parammum.equals("0")))
          {
            this.a.b();
            return;
          }
        }
      }
      catch (Exception parammum)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.a, 2, "onPostDownloadComplete :" + parammum.toString());
        }
        parammum = null;
        continue;
      }
      label248:
      parammum = "";
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mcc
 * JD-Core Version:    0.7.0.1
 */