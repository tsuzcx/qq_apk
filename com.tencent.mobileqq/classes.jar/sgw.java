import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class sgw
  implements bhzi
{
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(sgv.a, 2, "queryKingCardType()#callback postQuery, sucess=" + paramBoolean1 + " isKingCard=" + paramBoolean2 + " product=" + paramInt);
    }
    if (paramBoolean1)
    {
      sgv.a(paramInt);
      try
      {
        JSONObject localJSONObject = sgv.a();
        if (localJSONObject != null) {}
        try
        {
          sgv.a().put("simCardType", sgv.a());
          if (QLog.isColorLevel()) {
            QLog.d(sgv.a, 2, "queryKingCardType()#callback postQuery, update jsonStr ");
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e(sgv.a, 2, "queryKingCardType()#callback postQuery, update json error ", localJSONException);
            }
          }
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgw
 * JD-Core Version:    0.7.0.1
 */