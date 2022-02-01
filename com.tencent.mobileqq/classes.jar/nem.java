import android.text.TextUtils;
import com.tencent.avgame.session.AVGameSession;
import java.util.HashMap;
import java.util.Map;

public class nem
{
  private AVGameSession jdField_a_of_type_ComTencentAvgameSessionAVGameSession;
  private final Map<String, AVGameSession> jdField_a_of_type_JavaUtilMap = new HashMap(3);
  
  public AVGameSession a()
  {
    return this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession;
  }
  
  public AVGameSession a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      AVGameSession localAVGameSession = (AVGameSession)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      localObject = localAVGameSession;
      if (localAVGameSession == null)
      {
        localAVGameSession = new AVGameSession(paramInt, paramString);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localAVGameSession);
        if (this.jdField_a_of_type_JavaUtilMap.size() != 1)
        {
          localObject = localAVGameSession;
          if (!paramBoolean) {}
        }
        else
        {
          a(paramString);
          localObject = localAVGameSession;
        }
      }
    }
    return localObject;
  }
  
  public AVGameSession a(String paramString)
  {
    AVGameSession localAVGameSession = null;
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
      localAVGameSession = (AVGameSession)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return localAVGameSession;
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (!paramString.a))
    {
      if (this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession != null) {
        this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession.a = false;
      }
      paramString.a = true;
      this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession = paramString;
    }
  }
  
  public AVGameSession b(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      paramString = (AVGameSession)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if ((paramString != null) && (paramString == this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession))
      {
        this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession.a = false;
        this.jdField_a_of_type_ComTencentAvgameSessionAVGameSession = null;
      }
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nem
 * JD-Core Version:    0.7.0.1
 */