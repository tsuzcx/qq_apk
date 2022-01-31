import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr.WriteCommentCallback;
import org.json.JSONObject;

class pbg
  implements TroopTopicMgr.WriteCommentCallback
{
  pbg(paz parampaz, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, JSONObject paramJSONObject)
  {
    if (paramInt == 0) {}
    paramJSONObject = new Bundle();
    paramJSONObject.putInt("reqType", this.jdField_a_of_type_Int);
    paramJSONObject.putInt("seq", this.b);
    paramJSONObject.putInt("errorCode", paramInt);
    this.jdField_a_of_type_Paz.a.a(60, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbg
 * JD-Core Version:    0.7.0.1
 */