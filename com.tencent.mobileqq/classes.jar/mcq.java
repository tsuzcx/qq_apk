import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class mcq
  extends mvj
{
  public mcq(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(mvm parammvm)
  {
    AudioHelper.b("上传SelfNickName_rsp");
    String str = "";
    if (parammvm.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        parammvm = new String(parammvm.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (parammvm != null)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(parammvm);
            i = localJSONObject.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.a, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i);
            }
            parammvm = str;
            if (localJSONObject.has("result"))
            {
              localJSONObject = localJSONObject.getJSONObject("result");
              parammvm = str;
              if (localJSONObject.has("result_code")) {
                parammvm = localJSONObject.getString("result_code");
              }
            }
          }
          catch (JSONException parammvm)
          {
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.i(this.a.a, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
            parammvm = "";
            i = -2;
            continue;
            this.a.a(1, 0);
            this.a.finish();
            return;
          }
          if ((i == 0) && (parammvm.equals("0")))
          {
            this.a.b();
            return;
          }
        }
      }
      catch (Exception parammvm)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.a, 2, "onPostDownloadComplete :" + parammvm.toString());
        }
        parammvm = null;
        continue;
      }
      label248:
      parammvm = "";
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mcq
 * JD-Core Version:    0.7.0.1
 */