import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class qky
  implements bbxm
{
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qkx.a, 2, "queryKingCardType()#callback postQuery, sucess=" + paramBoolean1 + " isKingCard=" + paramBoolean2 + " product=" + paramInt);
    }
    if (paramBoolean1)
    {
      qkx.a(paramInt);
      try
      {
        JSONObject localJSONObject = qkx.b();
        if (localJSONObject != null) {}
        try
        {
          qkx.b().put("simCardType", qkx.a());
          if (QLog.isColorLevel()) {
            QLog.d(qkx.a, 2, "queryKingCardType()#callback postQuery, update jsonStr ");
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e(qkx.a, 2, "queryKingCardType()#callback postQuery, update json error ", localJSONException);
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
 * Qualified Name:     qky
 * JD-Core Version:    0.7.0.1
 */