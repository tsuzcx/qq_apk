import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyOperationManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinHandler;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.mobileqq.app.QQAppInterface;

public class ldp
  implements Runnable
{
  public ldp(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    Object localObject = (ReadInJoyRefreshManager)this.a.app.getManager(269);
    RefreshData localRefreshData = ((ReadInJoyRefreshManager)localObject).a(this.a.getActivity());
    int i = (int)(System.currentTimeMillis() / 1000L);
    ReadInJoySkinManager localReadInJoySkinManager;
    SkinData localSkinData;
    if ((localRefreshData != null) && (i >= localRefreshData.beginTime) && (i <= localRefreshData.endTime)) {
      if (RefreshRes.a(localRefreshData.id)) {
        if (localRefreshData.isShown)
        {
          ((ReadInJoyRefreshManager)localObject).a(1, localRefreshData.id);
          ((ReadInJoyRefreshManager)localObject).a(true);
          localObject = (GuideData)((ReadInJoyOperationManager)this.a.app.getManager(270)).a("operation_guide");
          localReadInJoySkinManager = (ReadInJoySkinManager)this.a.app.getManager(260);
          localSkinData = localReadInJoySkinManager.a(this.a);
          if ((localSkinData == null) || (i < localSkinData.beginTime) || (i > localSkinData.endTime)) {
            break label293;
          }
          if (!CommonSkinRes.a(localSkinData.id)) {
            break label274;
          }
          localReadInJoySkinManager.a(1, localSkinData.id);
        }
      }
    }
    for (;;)
    {
      localReadInJoySkinManager.a(this.a);
      this.a.app.addObserver(ReadInJoyNewFeedsActivity.a(this.a));
      ((ReadInJoySkinHandler)this.a.app.a(121)).a(localSkinData, null, localRefreshData, (GuideData)localObject);
      return;
      ((ReadInJoyRefreshManager)localObject).a(0, "");
      break;
      ((ReadInJoyRefreshManager)localObject).a(0, "");
      ((ReadInJoyRefreshManager)localObject).a(localRefreshData);
      break;
      ((ReadInJoyRefreshManager)localObject).a(0, "");
      break;
      label274:
      localReadInJoySkinManager.a(localSkinData);
      localReadInJoySkinManager.a(0, "");
      continue;
      label293:
      localReadInJoySkinManager.a(0, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldp
 * JD-Core Version:    0.7.0.1
 */