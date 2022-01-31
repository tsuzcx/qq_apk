package dov.com.qq.im;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.io.Serializable;

public class QIMAIOEffectCameraCaptureUnit$Session
  implements Serializable
{
  public String curFriendNick;
  public String curFriendUin;
  public int curType;
  public String troopUin;
  
  public QIMAIOEffectCameraCaptureUnit$Session(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.curFriendUin = paramString1;
    this.curFriendNick = paramString2;
    this.curType = paramInt;
    this.troopUin = paramString3;
  }
  
  public SessionInfo convertTo()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = this.curType;
    localSessionInfo.d = this.curFriendNick;
    localSessionInfo.jdField_a_of_type_JavaLangString = this.curFriendUin;
    localSessionInfo.b = this.troopUin;
    return localSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMAIOEffectCameraCaptureUnit.Session
 * JD-Core Version:    0.7.0.1
 */