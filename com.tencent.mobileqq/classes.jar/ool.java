import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class ool
  implements BusinessObserver
{
  ool(ooi paramooi, boolean paramBoolean, long paramLong1, int paramInt1, String paramString1, int paramInt2, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    i = -1;
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      paramInt = i;
      if (paramBundle != null)
      {
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
      }
      try
      {
        paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "createComment ret=" + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (paramInt == 0) {
          break label381;
        }
        localObject = paramBundle.optString("msg");
        if (ooi.a(this.jdField_a_of_type_Ooi) != null)
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label289;
          }
          ooi.a(this.jdField_a_of_type_Ooi).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
        }
        for (;;)
        {
          String str1 = paramBundle.optJSONObject("data").optString("comment_id");
          ooi localooi = this.jdField_a_of_type_Ooi;
          String str2 = this.jdField_b_of_type_JavaLangString;
          if (!TextUtils.isEmpty(this.c)) {
            break;
          }
          paramBundle = this.d;
          label195:
          String str3 = this.e;
          String str4 = this.f;
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          ooi.a(localooi, str2, paramBundle, str3, str4, (String)localObject);
          QLog.d("ReadInJoyCommentSSOModule", 2, "commentSink   commentRowKey :" + this.c + "  rowKey :" + this.d);
          label274:
          szp.a(paramInt, 4, System.currentTimeMillis() - this.jdField_b_of_type_Long, null);
          return;
          label289:
          ooi.a(this.jdField_a_of_type_Ooi).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_b_of_type_Int);
        }
        localObject = paramBundle.getLocalizedMessage();
      }
      catch (Exception paramBundle) {}
    }
    catch (Exception paramBundle)
    {
      label521:
      label551:
      label733:
      for (;;)
      {
        Object localObject;
        label381:
        paramInt = i;
      }
    }
    if (ooi.a(this.jdField_a_of_type_Ooi) != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label733;
      }
      ooi.a(this.jdField_a_of_type_Ooi).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      paramBundle.printStackTrace();
      break label274;
      localObject = paramBundle.optString("msg");
      i = paramBundle.getInt("ret");
      if (ooi.a(this.jdField_a_of_type_Ooi) != null)
      {
        if (i == 0) {
          break label551;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label521;
        }
        ooi.a(this.jdField_a_of_type_Ooi).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
      }
      for (;;)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retCode", i);
        ((JSONObject)localObject).put("os", 1);
        ((JSONObject)localObject).put("consume_time", System.currentTimeMillis() - this.jdField_b_of_type_Long);
        nrt.a(null, "", "0X8009A35", "0X8009A35", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
        break;
        ooi.a(this.jdField_a_of_type_Ooi).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_b_of_type_Int);
        continue;
        localObject = paramBundle.getJSONObject("data").getString("comment_id");
        if (this.jdField_a_of_type_Boolean) {
          ooi.a(this.jdField_a_of_type_Ooi).a(this.jdField_a_of_type_Long, true, this.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
        } else {
          ooi.a(this.jdField_a_of_type_Ooi).a(this.jdField_a_of_type_Long, true, this.jdField_a_of_type_Int, (String)localObject, this.jdField_b_of_type_Int);
        }
      }
      paramBundle = this.c;
      break label195;
      paramInt = i;
      if (ooi.a(this.jdField_a_of_type_Ooi) == null) {
        break label274;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        ooi.a(this.jdField_a_of_type_Ooi).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
        paramInt = i;
        break label274;
      }
      ooi.a(this.jdField_a_of_type_Ooi).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, "", this.jdField_b_of_type_Int);
      paramInt = i;
      break label274;
      ooi.a(this.jdField_a_of_type_Ooi).a(this.jdField_a_of_type_Long, false, this.jdField_a_of_type_Int, (String)localObject, this.jdField_b_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ool
 * JD-Core Version:    0.7.0.1
 */