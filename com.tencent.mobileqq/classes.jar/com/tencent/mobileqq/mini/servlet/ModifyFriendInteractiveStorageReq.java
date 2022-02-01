package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StInteractiveTemplate;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ModifyFriendInteractiveStorageReq
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.ModifyFriendInteractiveStorage";
  public static final String TAG = "ModifyFriendInteractiveStorageReq";
  private static final String unikey = "ModifyFriendInteractiveStorageReq";
  private CloudStorage.StModifyFriendInteractiveStorageReq req;
  
  public ModifyFriendInteractiveStorageReq(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, boolean paramBoolean, CloudStorage.StInteractiveTemplate paramStInteractiveTemplate) {}
  
  public static CloudStorage.StModifyFriendInteractiveStorageRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new CloudStorage.StModifyFriendInteractiveStorageRsp();
    try
    {
      ((CloudStorage.StModifyFriendInteractiveStorageRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("ModifyFriendInteractiveStorageReq", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.ModifyFriendInteractiveStorageReq
 * JD-Core Version:    0.7.0.1
 */