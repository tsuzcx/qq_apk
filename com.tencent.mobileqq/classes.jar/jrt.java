import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.av.utils.download.BaseDownloadAsyncTask;
import com.tencent.av.utils.download.DownloadParams;
import com.tencent.av.utils.download.DownloadResult;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class jrt
  extends BaseDownloadAsyncTask
{
  public jrt(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(DownloadParams paramDownloadParams)
  {
    String str3 = "";
    if (paramDownloadParams.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        String str1 = new String(paramDownloadParams.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (str1 != null)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(str1);
            i = localJSONObject.getInt("retcode");
            if (QLog.isColorLevel()) {
              QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "OnAfterCreateDiscussionAsyncTask.onPostDownloadComplete : retcode = " + i);
            }
            str1 = str3;
            if (localJSONObject.has("result"))
            {
              localJSONObject = localJSONObject.getJSONObject("result");
              str1 = str3;
              if (localJSONObject.has("result_code")) {
                str1 = localJSONObject.getString("result_code");
              }
            }
          }
          catch (JSONException localJSONException)
          {
            Object localObject;
            if (!QLog.isColorLevel()) {
              break label368;
            }
            QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
            str2 = "";
            i = -2;
            continue;
            this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.c(Long.parseLong(this.a.h));
            this.a.a(1, 0);
            return;
          }
          QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "OnAfterCreateDiscussionAsyncTask, IsSucc[" + paramDownloadParams.a.jdField_a_of_type_Boolean + "], retcode[" + i + "], result_code[" + str1 + "], mDiscID[" + this.a.h + "]");
          if ((i == 0) && (str1.equals("0")))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.a.h), this.a.c);
            this.a.a(this.a.h, this.a.c);
            this.a.finish();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onPostDownloadComplete :" + localException.toString());
        }
        localObject = null;
        continue;
      }
      label368:
      String str2 = "";
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrt
 * JD-Core Version:    0.7.0.1
 */