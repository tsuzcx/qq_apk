import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyOperationManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinHandler;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.QQAppInterface;

public class miw
  implements Runnable
{
  public miw(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void run()
  {
    Object localObject = (ReadInJoyRefreshManager)this.a.a.getManager(269);
    RefreshData localRefreshData = ((ReadInJoyRefreshManager)localObject).a(this.a.a());
    int i = (int)(System.currentTimeMillis() / 1000L);
    ReadInJoySkinManager localReadInJoySkinManager;
    SkinData localSkinData;
    if ((localRefreshData != null) && (i >= localRefreshData.beginTime) && (i <= localRefreshData.endTime)) {
      if (RefreshRes.a(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((ReadInJoyRefreshManager)localObject).a(1, localRefreshData.id);
          ((ReadInJoyRefreshManager)localObject).a(true);
          localObject = (GuideData)((ReadInJoyOperationManager)this.a.a.getManager(270)).a("operation_guide");
          localReadInJoySkinManager = (ReadInJoySkinManager)this.a.a.getManager(260);
          localSkinData = localReadInJoySkinManager.a(this.a.a());
          if ((localSkinData == null) || (i < localSkinData.beginTime) || (i > localSkinData.endTime)) {
            break label270;
          }
          if (!CommonSkinRes.a(localSkinData.id)) {
            break label251;
          }
          localReadInJoySkinManager.a(1, localSkinData.id);
        }
      }
    }
    for (;;)
    {
      ((ReadInJoySkinHandler)this.a.a.a(121)).a(localSkinData, null, localRefreshData, (GuideData)localObject);
      return;
      ((ReadInJoyRefreshManager)localObject).a(0, "");
      break;
      ((ReadInJoyRefreshManager)localObject).a(0, "");
      ((ReadInJoyRefreshManager)localObject).a(localRefreshData);
      break;
      ((ReadInJoyRefreshManager)localObject).a(0, "");
      break;
      label251:
      localReadInJoySkinManager.a(0, "");
      localReadInJoySkinManager.a(localSkinData);
      continue;
      label270:
      localReadInJoySkinManager.a(0, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     miw
 * JD-Core Version:    0.7.0.1
 */