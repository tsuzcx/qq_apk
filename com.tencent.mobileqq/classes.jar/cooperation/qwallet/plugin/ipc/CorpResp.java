package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;

public class CorpResp
  extends BaseResp
{
  public int callForwardRet;
  public int corpReqType;
  public Bundle encryptionData;
  public String faceFilePath;
  public boolean isFriend;
  public String memNick;
  public String memUin;
  public String troopMemNickJson;
  public String troopUin;
  public String userNick;
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.corpReqType = paramBundle.getInt("_qwallet_ipc_CorpResp_corpReqType");
    this.faceFilePath = paramBundle.getString("_qwallet_ipc_CorpReq_faceFilePath");
    this.isFriend = paramBundle.getBoolean("_qwallet_ipc_CorpReq_isFriend");
    this.userNick = paramBundle.getString("_qwallet_ipc_CorpReq_userNick");
    this.troopUin = paramBundle.getString("_qwallet_ipc_CorpReq_troopUin");
    this.memUin = paramBundle.getString("_qwallet_ipc_CorpReq_memUin");
    this.memNick = paramBundle.getString("_qwallet_ipc_CorpReq_memNick");
    this.troopMemNickJson = paramBundle.getString("_qwallet_ipc_CorpReq_troopMemNickJson");
    this.encryptionData = paramBundle.getBundle("_qwallet_ipc_CorpReq_encryptionData");
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putInt("_qwallet_ipc_CorpResp_corpReqType", this.corpReqType);
    paramBundle.putString("_qwallet_ipc_CorpReq_faceFilePath", this.faceFilePath);
    paramBundle.putBoolean("_qwallet_ipc_CorpReq_isFriend", this.isFriend);
    paramBundle.putString("_qwallet_ipc_CorpReq_userNick", this.userNick);
    paramBundle.putString("_qwallet_ipc_CorpReq_troopUin", this.troopUin);
    paramBundle.putString("_qwallet_ipc_CorpReq_memUin", this.memUin);
    paramBundle.putString("_qwallet_ipc_CorpReq_memNick", this.memNick);
    paramBundle.putString("_qwallet_ipc_CorpReq_troopMemNickJson", this.troopMemNickJson);
    paramBundle.putBundle("_qwallet_ipc_CorpReq_encryptionData", this.encryptionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpResp
 * JD-Core Version:    0.7.0.1
 */