import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class rnf
  implements biin
{
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rne.a, 2, "queryKingCardType()#callback postQuery, sucess=" + paramBoolean1 + " isKingCard=" + paramBoolean2 + " product=" + paramInt);
    }
    if (paramBoolean1)
    {
      rne.a(paramInt);
      try
      {
        JSONObject localJSONObject = rne.a();
        if (localJSONObject != null) {}
        try
        {
          rne.a().put("simCardType", rne.a());
          if (QLog.isColorLevel()) {
            QLog.d(rne.a, 2, "queryKingCardType()#callback postQuery, update jsonStr ");
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e(rne.a, 2, "queryKingCardType()#callback postQuery, update json error ", localJSONException);
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
 * Qualified Name:     rnf
 * JD-Core Version:    0.7.0.1
 */