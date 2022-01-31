import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.av.utils.download.BaseDownloadAsyncTask;
import com.tencent.av.utils.download.DownloadParams;
import com.tencent.av.utils.download.DownloadResult;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class jrv
  extends BaseDownloadAsyncTask
{
  public jrv(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(DownloadParams paramDownloadParams)
  {
    AudioHelper.b("上传SelfNickName_rsp");
    String str = "";
    if (paramDownloadParams.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        paramDownloadParams = new String(paramDownloadParams.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (paramDownloadParams != null)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramDownloadParams);
            i = localJSONObject.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.a, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i);
            }
            paramDownloadParams = str;
            if (localJSONObject.has("result"))
            {
              localJSONObject = localJSONObject.getJSONObject("result");
              paramDownloadParams = str;
              if (localJSONObject.has("result_code")) {
                paramDownloadParams = localJSONObject.getString("result_code");
              }
            }
          }
          catch (JSONException paramDownloadParams)
          {
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.i(this.a.a, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
            paramDownloadParams = "";
            i = -2;
            continue;
            this.a.a(1, 0);
            this.a.finish();
            return;
          }
          if ((i == 0) && (paramDownloadParams.equals("0")))
          {
            this.a.b();
            return;
          }
        }
      }
      catch (Exception paramDownloadParams)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.a, 2, "onPostDownloadComplete :" + paramDownloadParams.toString());
        }
        paramDownloadParams = null;
        continue;
      }
      label248:
      paramDownloadParams = "";
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrv
 * JD-Core Version:    0.7.0.1
 */