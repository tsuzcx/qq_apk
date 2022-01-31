import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr.DoLikeCallback;
import org.json.JSONObject;

class out
  implements TroopTopicMgr.DoLikeCallback
{
  out(ouo paramouo, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, JSONObject paramJSONObject)
  {
    paramJSONObject = new Bundle();
    paramJSONObject.putInt("reqType", this.jdField_a_of_type_Int);
    paramJSONObject.putInt("seq", this.b);
    paramJSONObject.putInt("errorCode", paramInt);
    this.jdField_a_of_type_Ouo.a.a(60, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     out
 * JD-Core Version:    0.7.0.1
 */