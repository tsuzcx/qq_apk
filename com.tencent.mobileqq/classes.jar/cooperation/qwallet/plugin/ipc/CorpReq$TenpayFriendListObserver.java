package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.os.ResultReceiver;
import anmu;
import bglf;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.HashMap;

class CorpReq$TenpayFriendListObserver
  extends anmu
{
  private static TenpayFriendListObserver _self;
  private HashMap<String, ResultReceiver> mRecieverMap = new HashMap();
  
  public static TenpayFriendListObserver getInstance()
  {
    if (_self == null) {
      _self = new TenpayFriendListObserver();
    }
    return _self;
  }
  
  public void add(String paramString, ResultReceiver paramResultReceiver)
  {
    this.mRecieverMap.put(paramString, paramResultReceiver);
  }
  
  void destroy()
  {
    _self = null;
    this.mRecieverMap.clear();
  }
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    Object localObject = QWalletHelper.getAppInterface();
    if ((!paramBoolean) || (paramString == null) || (localObject == null)) {}
    do
    {
      return;
      CorpResp localCorpResp = new CorpResp();
      localCorpResp.corpReqType = CorpReq.corpReqType;
      localCorpResp.userNick = bglf.c((QQAppInterface)localObject, paramString, false);
      localObject = new Bundle();
      localCorpResp.toBundle((Bundle)localObject);
      paramString = (ResultReceiver)this.mRecieverMap.remove(paramString);
    } while ((localObject == null) || (paramString == null));
    paramString.send(0, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpReq.TenpayFriendListObserver
 * JD-Core Version:    0.7.0.1
 */