package cooperation.qzone;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.observer.AccountObserver;

final class QZoneShareManager$1
  extends AccountObserver
{
  QZoneShareManager$1(String paramString, BusinessObserver paramBusinessObserver) {}
  
  public void onChangeToken(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap = (RespondCustomSig)paramHashMap.get("login.chgTok");
      if (paramHashMap != null)
      {
        if (paramHashMap.SigList == null) {
          return;
        }
        int i = 0;
        while (i < paramHashMap.SigList.size())
        {
          Object localObject1 = (CustomSigContent)paramHashMap.SigList.get(i);
          if ((((CustomSigContent)localObject1).sResult == 0) && (((CustomSigContent)localObject1).ulSigType == 16L))
          {
            Object localObject2 = new String(((CustomSigContent)localObject1).SigContent);
            localObject1 = new OpenID();
            ((OpenID)localObject1).appID = this.val$appID;
            ((OpenID)localObject1).openID = ((String)localObject2);
            localObject2 = this.val$observer;
            if (localObject2 != null) {
              ((BusinessObserver)localObject2).onUpdate(1, true, localObject1);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneShareManager.1
 * JD-Core Version:    0.7.0.1
 */