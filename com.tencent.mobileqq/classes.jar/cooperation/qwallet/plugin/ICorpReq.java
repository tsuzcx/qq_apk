package cooperation.qwallet.plugin;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qwallet.plugin.ipc.CorpReq.ICallBack;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface ICorpReq
  extends QRouteApi
{
  public abstract Bundle callForwardPage(Bundle paramBundle, ResultReceiver paramResultReceiver);
  
  public abstract Bundle callSendHbPage(Bundle paramBundle, ResultReceiver paramResultReceiver);
  
  public abstract void deleteUserNickOB();
  
  public abstract Bundle getAvatar(Bundle paramBundle, CorpReq.ICallBack paramICallBack);
  
  public abstract Bundle getGroupNickname(Bundle paramBundle);
  
  public abstract Bundle onGetEncryption();
  
  public abstract Bundle onGetFaceFilePath(int paramInt1, String paramString, int paramInt2);
  
  public abstract Bundle onIsFriend(String paramString);
  
  public abstract void onTenWatch(Bundle paramBundle);
  
  public abstract Bundle onTroopMemNick(String paramString1, String paramString2, ArrayList<String> paramArrayList, CorpReq.ICallBack paramICallBack);
  
  public abstract Bundle onUserNcik(String paramString1, int paramInt, String paramString2, ResultReceiver paramResultReceiver);
  
  public abstract void openAio(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.ICorpReq
 * JD-Core Version:    0.7.0.1
 */