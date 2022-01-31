import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import org.json.JSONObject;

public class jku
  extends jkq
{
  public jku(RandomWebProtocol paramRandomWebProtocol, int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    super(paramRandomWebProtocol);
    boolean bool = RandomWebProtocol.b();
    paramRandomWebProtocol = new JSONObject();
    try
    {
      paramRandomWebProtocol.put("session_type", paramInt1).put("groupid", paramLong);
      if (4 == paramInt2) {
        paramRandomWebProtocol.put("peer_enuin", ChatActivityUtils.b(RandomWebProtocol.a(), paramString));
      }
    }
    catch (Exception paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
          continue;
          paramRandomWebProtocol = "https://play.mobile.qq.com/randchat/cgi-bin/chatplay/getroomowner";
        }
      } while (paramInt2 != 4);
      if (!bool) {
        break label139;
      }
    }
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_OrgJsonJSONObject = paramRandomWebProtocol;
    this.jdField_a_of_type_Boolean = bool;
    if (paramInt2 == 5) {
      if (bool)
      {
        paramRandomWebProtocol = "https://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/getroomowner";
        this.c = paramRandomWebProtocol;
        this.d = "[m] RequestMultiRoomOwner";
        return;
      }
    }
    label139:
    for (paramRandomWebProtocol = "https://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/multichatkick";; paramRandomWebProtocol = "https://play.mobile.qq.com/randchat/cgi-bin/chatplay/multichatkick")
    {
      this.c = paramRandomWebProtocol;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jku
 * JD-Core Version:    0.7.0.1
 */