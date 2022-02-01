import android.text.TextUtils;
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class mct
  extends mvq
{
  String jdField_a_of_type_JavaLangString;
  
  public mct(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(mvt parammvt)
  {
    mvt localmvt = null;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject8 = null;
    Object localObject2 = "";
    String str1 = "";
    String str3 = "";
    if (parammvt.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      Object localObject5;
      Object localObject4;
      try
      {
        parammvt = new String(parammvt.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (parammvt != null)
        {
          localObject5 = str1;
          localObject4 = localObject2;
          localObject3 = localObject1;
          try
          {
            parammvt = new JSONObject(parammvt);
            localObject5 = str1;
            localObject4 = localObject2;
            localObject3 = localObject1;
            i = parammvt.getInt("retcode");
            String str2 = str3;
            Object localObject7 = str1;
            Object localObject6 = localObject2;
            localObject5 = str1;
            localObject4 = localObject2;
            localObject3 = localObject1;
            if (parammvt.has("result"))
            {
              localObject5 = str1;
              localObject4 = localObject2;
              localObject3 = localObject1;
              JSONObject localJSONObject = parammvt.getJSONObject("result");
              parammvt = localObject8;
              localObject5 = str1;
              localObject4 = localObject2;
              localObject3 = localObject1;
              if (localJSONObject.has("result_code"))
              {
                localObject5 = str1;
                localObject4 = localObject2;
                localObject3 = localObject1;
                parammvt = localJSONObject.getString("result_code");
              }
              localObject1 = localObject2;
              localObject5 = str1;
              localObject4 = localObject2;
              localObject3 = parammvt;
              if (localJSONObject.has("disc_name_card"))
              {
                localObject5 = str1;
                localObject4 = localObject2;
                localObject3 = parammvt;
                localObject1 = localJSONObject.getString("disc_name_card");
              }
              localObject2 = str1;
              localObject5 = str1;
              localObject4 = localObject1;
              localObject3 = parammvt;
              if (localJSONObject.has("name_card_sender_uin"))
              {
                localObject5 = str1;
                localObject4 = localObject1;
                localObject3 = parammvt;
                localObject2 = localJSONObject.getString("name_card_sender_uin");
              }
              str2 = str3;
              localObject7 = localObject2;
              localObject6 = localObject1;
              localmvt = parammvt;
              localObject5 = localObject2;
              localObject4 = localObject1;
              localObject3 = parammvt;
              if (localJSONObject.has("name_card_sender_name"))
              {
                localObject5 = localObject2;
                localObject4 = localObject1;
                localObject3 = parammvt;
                str2 = localJSONObject.getString("name_card_sender_name");
                localmvt = parammvt;
                localObject6 = localObject1;
                localObject7 = localObject2;
              }
            }
            localObject2 = str2;
            localObject1 = localObject7;
            parammvt = localObject6;
            localObject3 = localmvt;
          }
          catch (JSONException parammvt)
          {
            localObject1 = localObject5;
            if (!QLog.isColorLevel()) {
              break label602;
            }
            QLog.d(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString, 2, "OnGetDiscNameCardTask.onPostDownloadComplete e = " + parammvt.toString());
            localObject2 = "";
            i = -2;
            parammvt = localObject4;
            continue;
          }
          QLog.w(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString, 1, "OnGetDiscNameCardTask.onPostDownloadComplete, result_code[" + (String)localObject3 + "], disc_name_card[" + parammvt + "], name_card_sender_uin[" + (String)localObject1 + "], name_card_sender_name[" + (String)localObject2 + "], retcode[" + i + "], mDiscID[" + this.jdField_a_of_type_JavaLangString + "]");
          ConferenceFlyTicketActivity.a(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.app.getCurrentUin(), (String)localObject1, (String)localObject2);
          if ((i == 0) && (TextUtils.equals((CharSequence)localObject3, "0")) && (!TextUtils.isEmpty(parammvt)) && (!parammvt.equals("null"))) {
            this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.a(parammvt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.app.getCurrentUin(), (String)localObject1, (String)localObject2);
          }
          return;
        }
      }
      catch (Exception parammvt)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString, 2, "OnGetDiscNameCardTask.onPostDownloadComplete e = " + parammvt.toString());
        }
        parammvt = null;
        continue;
      }
      label602:
      localObject2 = "";
      int i = -1;
      localObject1 = "";
      parammvt = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mct
 * JD-Core Version:    0.7.0.1
 */