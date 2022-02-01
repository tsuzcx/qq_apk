import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class mbz
  extends mus
{
  public mbz(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(muv parammuv)
  {
    AudioHelper.b("上传SelfNickName_rsp");
    String str = "";
    if (parammuv.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        parammuv = new String(parammuv.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (parammuv != null)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(parammuv);
            i = localJSONObject.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.a, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i);
            }
            parammuv = str;
            if (localJSONObject.has("result"))
            {
              localJSONObject = localJSONObject.getJSONObject("result");
              parammuv = str;
              if (localJSONObject.has("result_code")) {
                parammuv = localJSONObject.getString("result_code");
              }
            }
          }
          catch (JSONException parammuv)
          {
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.i(this.a.a, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
            parammuv = "";
            i = -2;
            continue;
            this.a.a(1, 0);
            this.a.finish();
            return;
          }
          if ((i == 0) && (parammuv.equals("0")))
          {
            this.a.b();
            return;
          }
        }
      }
      catch (Exception parammuv)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.a, 2, "onPostDownloadComplete :" + parammuv.toString());
        }
        parammuv = null;
        continue;
      }
      label248:
      parammuv = "";
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mbz
 * JD-Core Version:    0.7.0.1
 */