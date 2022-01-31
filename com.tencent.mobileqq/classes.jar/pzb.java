import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class pzb
  implements baue
{
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(pza.a, 2, "queryKingCardType()#callback postQuery, sucess=" + paramBoolean1 + " isKingCard=" + paramBoolean2 + " product=" + paramInt);
    }
    if (paramBoolean1)
    {
      pza.a(paramInt);
      try
      {
        JSONObject localJSONObject = pza.b();
        if (localJSONObject != null) {}
        try
        {
          pza.b().put("simCardType", pza.a());
          if (QLog.isColorLevel()) {
            QLog.d(pza.a, 2, "queryKingCardType()#callback postQuery, update jsonStr ");
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e(pza.a, 2, "queryKingCardType()#callback postQuery, update json error ", localJSONException);
            }
          }
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzb
 * JD-Core Version:    0.7.0.1
 */