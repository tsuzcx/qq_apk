import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class mer
  extends mxc
{
  public mer(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(mxf parammxf)
  {
    AudioHelper.b("上传SelfNickName_rsp");
    String str = "";
    if (parammxf.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        parammxf = new String(parammxf.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (parammxf != null)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(parammxf);
            i = localJSONObject.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.a, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i);
            }
            parammxf = str;
            if (localJSONObject.has("result"))
            {
              localJSONObject = localJSONObject.getJSONObject("result");
              parammxf = str;
              if (localJSONObject.has("result_code")) {
                parammxf = localJSONObject.getString("result_code");
              }
            }
          }
          catch (JSONException parammxf)
          {
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.i(this.a.a, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
            parammxf = "";
            i = -2;
            continue;
            this.a.a(1, 0);
            this.a.finish();
            return;
          }
          if ((i == 0) && (parammxf.equals("0")))
          {
            this.a.b();
            return;
          }
        }
      }
      catch (Exception parammxf)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.a, 2, "onPostDownloadComplete :" + parammxf.toString());
        }
        parammxf = null;
        continue;
      }
      label248:
      parammxf = "";
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mer
 * JD-Core Version:    0.7.0.1
 */