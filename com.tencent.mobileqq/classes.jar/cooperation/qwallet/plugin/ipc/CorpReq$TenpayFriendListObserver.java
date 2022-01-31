package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.HashMap;

class CorpReq$TenpayFriendListObserver
  extends FriendListObserver
{
  private static TenpayFriendListObserver _self;
  private HashMap mRecieverMap = new HashMap();
  
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
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = QWalletHelper.getAppInterface();
      CorpResp localCorpResp = new CorpResp();
      localCorpResp.corpReqType = CorpReq.corpReqType;
      localCorpResp.userNick = ContactUtils.c((QQAppInterface)localObject, paramString, false);
      localObject = new Bundle();
      localCorpResp.toBundle((Bundle)localObject);
      paramString = (ResultReceiver)this.mRecieverMap.remove(paramString);
    } while ((localObject == null) || (paramString == null));
    paramString.send(0, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpReq.TenpayFriendListObserver
 * JD-Core Version:    0.7.0.1
 */