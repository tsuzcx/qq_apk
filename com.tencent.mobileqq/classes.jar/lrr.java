import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class lrr
  extends mjm
{
  public lrr(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(mjq parammjq)
  {
    AudioHelper.b("上传SelfNickName_rsp");
    String str = "";
    if (parammjq.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        parammjq = new String(parammjq.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (parammjq != null)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(parammjq);
            i = localJSONObject.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.a, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i);
            }
            parammjq = str;
            if (localJSONObject.has("result"))
            {
              localJSONObject = localJSONObject.getJSONObject("result");
              parammjq = str;
              if (localJSONObject.has("result_code")) {
                parammjq = localJSONObject.getString("result_code");
              }
            }
          }
          catch (JSONException parammjq)
          {
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.i(this.a.a, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
            parammjq = "";
            i = -2;
            continue;
            this.a.a(1, 0);
            this.a.finish();
            return;
          }
          if ((i == 0) && (parammjq.equals("0")))
          {
            this.a.b();
            return;
          }
        }
      }
      catch (Exception parammjq)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.a, 2, "onPostDownloadComplete :" + parammjq.toString());
        }
        parammjq = null;
        continue;
      }
      label248:
      parammjq = "";
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lrr
 * JD-Core Version:    0.7.0.1
 */