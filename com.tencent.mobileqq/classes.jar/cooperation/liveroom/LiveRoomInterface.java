package cooperation.liveroom;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;

public class LiveRoomInterface
  extends PluginRuntime
{
  private EntityManagerFactory emFactoryQQ;
  public AppInterface mAppInterface;
  
  public String getModuleId()
  {
    return "LiveRoomPlugin.apk";
  }
  
  public EntityManagerFactory getQQEntityManagerFactory()
  {
    Object localObject1 = getAccount();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if (this.emFactoryQQ == null)
      {
        localObject1 = new QQEntityManagerFactory((String)localObject1);
        ((QQEntityManagerFactory)localObject1).verifyAuthentication();
        this.emFactoryQQ = ((EntityManagerFactory)localObject1);
      }
      return this.emFactoryQQ;
    }
    finally {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomInterface
 * JD-Core Version:    0.7.0.1
 */