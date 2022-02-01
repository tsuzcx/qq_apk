import android.text.TextUtils;
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class mcp
  extends mvj
{
  String jdField_a_of_type_JavaLangString;
  
  public mcp(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(mvm parammvm)
  {
    mvm localmvm = null;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject8 = null;
    Object localObject2 = "";
    String str1 = "";
    String str3 = "";
    if (parammvm.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      Object localObject5;
      Object localObject4;
      try
      {
        parammvm = new String(parammvm.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
        if (parammvm != null)
        {
          localObject5 = str1;
          localObject4 = localObject2;
          localObject3 = localObject1;
          try
          {
            parammvm = new JSONObject(parammvm);
            localObject5 = str1;
            localObject4 = localObject2;
            localObject3 = localObject1;
            i = parammvm.getInt("retcode");
            String str2 = str3;
            Object localObject7 = str1;
            Object localObject6 = localObject2;
            localObject5 = str1;
            localObject4 = localObject2;
            localObject3 = localObject1;
            if (parammvm.has("result"))
            {
              localObject5 = str1;
              localObject4 = localObject2;
              localObject3 = localObject1;
              JSONObject localJSONObject = parammvm.getJSONObject("result");
              parammvm = localObject8;
              localObject5 = str1;
              localObject4 = localObject2;
              localObject3 = localObject1;
              if (localJSONObject.has("result_code"))
              {
                localObject5 = str1;
                localObject4 = localObject2;
                localObject3 = localObject1;
                parammvm = localJSONObject.getString("result_code");
              }
              localObject1 = localObject2;
              localObject5 = str1;
              localObject4 = localObject2;
              localObject3 = parammvm;
              if (localJSONObject.has("disc_name_card"))
              {
                localObject5 = str1;
                localObject4 = localObject2;
                localObject3 = parammvm;
                localObject1 = localJSONObject.getString("disc_name_card");
              }
              localObject2 = str1;
              localObject5 = str1;
              localObject4 = localObject1;
              localObject3 = parammvm;
              if (localJSONObject.has("name_card_sender_uin"))
              {
                localObject5 = str1;
                localObject4 = localObject1;
                localObject3 = parammvm;
                localObject2 = localJSONObject.getString("name_card_sender_uin");
              }
              str2 = str3;
              localObject7 = localObject2;
              localObject6 = localObject1;
              localmvm = parammvm;
              localObject5 = localObject2;
              localObject4 = localObject1;
              localObject3 = parammvm;
              if (localJSONObject.has("name_card_sender_name"))
              {
                localObject5 = localObject2;
                localObject4 = localObject1;
                localObject3 = parammvm;
                str2 = localJSONObject.getString("name_card_sender_name");
                localmvm = parammvm;
                localObject6 = localObject1;
                localObject7 = localObject2;
              }
            }
            localObject2 = str2;
            localObject1 = localObject7;
            parammvm = localObject6;
            localObject3 = localmvm;
          }
          catch (JSONException parammvm)
          {
            localObject1 = localObject5;
            if (!QLog.isColorLevel()) {
              break label602;
            }
            QLog.d(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString, 2, "OnGetDiscNameCardTask.onPostDownloadComplete e = " + parammvm.toString());
            localObject2 = "";
            i = -2;
            parammvm = localObject4;
            continue;
          }
          QLog.w(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString, 1, "OnGetDiscNameCardTask.onPostDownloadComplete, result_code[" + (String)localObject3 + "], disc_name_card[" + parammvm + "], name_card_sender_uin[" + (String)localObject1 + "], name_card_sender_name[" + (String)localObject2 + "], retcode[" + i + "], mDiscID[" + this.jdField_a_of_type_JavaLangString + "]");
          ConferenceFlyTicketActivity.a(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.app.c(), (String)localObject1, (String)localObject2);
          if ((i == 0) && (TextUtils.equals((CharSequence)localObject3, "0")) && (!TextUtils.isEmpty(parammvm)) && (!parammvm.equals("null"))) {
            this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.a(parammvm, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.app.c(), (String)localObject1, (String)localObject2);
          }
          return;
        }
      }
      catch (Exception parammvm)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString, 2, "OnGetDiscNameCardTask.onPostDownloadComplete e = " + parammvm.toString());
        }
        parammvm = null;
        continue;
      }
      label602:
      localObject2 = "";
      int i = -1;
      localObject1 = "";
      parammvm = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mcp
 * JD-Core Version:    0.7.0.1
 */