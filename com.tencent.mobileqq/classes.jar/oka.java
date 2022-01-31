import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class oka
  implements BusinessObserver
{
  oka(ojx paramojx, boolean paramBoolean, long paramLong1, int paramInt1, String paramString1, int paramInt2, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          return;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "createComment ret=" + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (paramInt != 0)
        {
          localObject = paramBundle.optString("msg");
          if (this.jdField_a_of_type_Boolean) {
            ojx.a(this.jdField_a_of_type_Ojx).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
          }
          for (;;)
          {
            String str1 = paramBundle.optJSONObject("data").optString("comment_id");
            ojx localojx = this.jdField_a_of_type_Ojx;
            String str2 = this.jdField_b_of_type_JavaLangString;
            if (!TextUtils.isEmpty(this.c)) {
              break;
            }
            paramBundle = this.d;
            label179:
            String str3 = this.e;
            String str4 = this.f;
            localObject = str1;
            if (str1 == null) {
              localObject = "";
            }
            ojx.a(localojx, str2, paramBundle, str3, str4, (String)localObject);
            QLog.d("ReadInJoyCommentSSOModule", 2, "commentSink   commentRowKey :" + this.c + "  rowKey :" + this.d);
            return;
            ojx.a(this.jdField_a_of_type_Ojx).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_b_of_type_Int);
          }
          ojx.a(this.jdField_a_of_type_Ojx).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
        }
      }
      catch (Exception paramBundle)
      {
        localObject = paramBundle.getLocalizedMessage();
        if (!this.jdField_a_of_type_Boolean) {}
      }
    }
    for (;;)
    {
      paramBundle.printStackTrace();
      return;
      localObject = paramBundle.optString("msg");
      paramInt = paramBundle.getInt("ret");
      if (paramInt != 0) {
        if (this.jdField_a_of_type_Boolean) {
          ojx.a(this.jdField_a_of_type_Ojx).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
        }
      }
      for (;;)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retCode", paramInt);
        ((JSONObject)localObject).put("os", 1);
        ((JSONObject)localObject).put("consume_time", System.currentTimeMillis() - this.jdField_b_of_type_Long);
        noo.a(null, "", "0X8009A35", "0X8009A35", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
        break;
        ojx.a(this.jdField_a_of_type_Ojx).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_b_of_type_Int);
        continue;
        localObject = paramBundle.getJSONObject("data").getString("comment_id");
        if (this.jdField_a_of_type_Boolean) {
          ojx.a(this.jdField_a_of_type_Ojx).a(this.jdField_a_of_type_Long, true, this.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
        } else {
          ojx.a(this.jdField_a_of_type_Ojx).a(this.jdField_a_of_type_Long, true, this.jdField_a_of_type_Int, (String)localObject, this.jdField_b_of_type_Int);
        }
      }
      paramBundle = this.c;
      break label179;
      if (this.jdField_a_of_type_Boolean)
      {
        ojx.a(this.jdField_a_of_type_Ojx).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
        return;
      }
      ojx.a(this.jdField_a_of_type_Ojx).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, "", this.jdField_b_of_type_Int);
      return;
      ojx.a(this.jdField_a_of_type_Ojx).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_b_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oka
 * JD-Core Version:    0.7.0.1
 */