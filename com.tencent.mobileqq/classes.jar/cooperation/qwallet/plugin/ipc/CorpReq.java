package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qwallet.plugin.ICorpReq;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class CorpReq
  extends BaseReq
{
  public static final int CORPREQ_TYPE_AVATAR = 12;
  public static final int CORPREQ_TYPE_DELETEOB = 6;
  public static final int CORPREQ_TYPE_FACEFILEPATH = 1;
  public static final int CORPREQ_TYPE_GET_ENCRYPTION = 8;
  public static final int CORPREQ_TYPE_INVOKE_FORWARD = 9;
  public static final int CORPREQ_TYPE_INVOKE_SENDHB = 13;
  public static final int CORPREQ_TYPE_ISFRIEND = 2;
  public static final int CORPREQ_TYPE_OPEN_AIO = 10;
  public static final int CORPREQ_TYPE_PUT_ENCRYPTION = 7;
  public static final int CORPREQ_TYPE_TENWATCH = 4;
  public static final int CORPREQ_TYPE_TROOP_MEM_NICK = 5;
  public static final int CORPREQ_TYPE_TROOP_NICKNAME = 11;
  public static final int CORPREQ_TYPE_USERNICK = 3;
  public static int corpReqType;
  public static Bundle encryptionData;
  public int channel;
  public Bundle data;
  public int faceType;
  public String groupId;
  private ICorpReq mICorpReq = (ICorpReq)QRoute.api(ICorpReq.class);
  public String memUin;
  public ArrayList<String> memUinArrayList;
  public int subType;
  public String troopUin;
  public String uin;
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    corpReqType = paramBundle.getInt("_qwallet_ipc_CorpReq_corpReqType");
    this.faceType = paramBundle.getInt("_qwallet_ipc_CorpReq_faceType");
    this.uin = paramBundle.getString("_qwallet_ipc_CorpReq_uin");
    this.subType = paramBundle.getInt("_qwallet_ipc_CorpReq_subType");
    this.groupId = paramBundle.getString("_qwallet_ipc_CorpReq_groupId");
    this.channel = paramBundle.getInt("_qwallet_ipc_CorpReq_channel");
    this.troopUin = paramBundle.getString("_qwallet_ipc_CorpReq_troopUin");
    this.memUin = paramBundle.getString("_qwallet_ipc_CorpReq_memUin");
    this.memUinArrayList = paramBundle.getStringArrayList("_qwallet_ipc_CorpReq_memUinArrayList");
    this.data = paramBundle.getBundle("_qwallet_ipc_CorpReq_data");
    if (corpReqType == 7) {
      encryptionData = paramBundle.getBundle("_qwallet_ipc_CorpReq_encryptionData");
    }
  }
  
  public void onReceive()
  {
    int i = corpReqType;
    if (i == 4)
    {
      this.mICorpReq.onTenWatch(this.data);
      return;
    }
    if (i == 8)
    {
      doCallback(this.mICorpReq.onGetEncryption());
      return;
    }
    if (i == 8)
    {
      doCallback(this.mICorpReq.onGetEncryption());
      return;
    }
    Bundle localBundle;
    if (i == 9)
    {
      localBundle = this.mICorpReq.callForwardPage(this.data, this.fromReceiver);
      if (localBundle != null) {
        doCallback(localBundle);
      }
    }
    else
    {
      if (i == 10)
      {
        this.mICorpReq.openAio(this.data);
        return;
      }
      if (i == 11)
      {
        doCallback(this.mICorpReq.getGroupNickname(this.data));
        return;
      }
      if (i == 12)
      {
        localBundle = this.mICorpReq.getAvatar(this.data, new CorpReq.1(this));
        if (localBundle != null) {
          doCallback(localBundle);
        }
      }
      else
      {
        if (i == 13)
        {
          doCallback(this.mICorpReq.callSendHbPage(this.data, this.fromReceiver));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new CorpReq.2(this));
      }
    }
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putInt("_qwallet_ipc_CorpReq_corpReqType", corpReqType);
    paramBundle.putInt("_qwallet_ipc_CorpReq_faceType", this.faceType);
    paramBundle.putString("_qwallet_ipc_CorpReq_uin", this.uin);
    paramBundle.putInt("_qwallet_ipc_CorpReq_subType", this.subType);
    paramBundle.putString("_qwallet_ipc_CorpReq_groupId", this.groupId);
    paramBundle.putInt("_qwallet_ipc_CorpReq_channel", this.channel);
    paramBundle.putString("_qwallet_ipc_CorpReq_troopUin", this.troopUin);
    paramBundle.putString("_qwallet_ipc_CorpReq_memUin", this.memUin);
    paramBundle.putStringArrayList("_qwallet_ipc_CorpReq_memUinArrayList", this.memUinArrayList);
    paramBundle.putBundle("_qwallet_ipc_CorpReq_data", this.data);
    paramBundle.putBundle("_qwallet_ipc_CorpReq_encryptionData", encryptionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpReq
 * JD-Core Version:    0.7.0.1
 */