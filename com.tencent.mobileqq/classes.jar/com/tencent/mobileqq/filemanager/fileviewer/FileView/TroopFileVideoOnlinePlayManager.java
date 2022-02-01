package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import tencent.im.oidb.cmd0x6e7.oidb_0x6e7.ReqBody;

public class TroopFileVideoOnlinePlayManager
{
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString4 = new StringBuffer("http://");
    paramString4.append(paramString1);
    paramString4.append("/ftn_handler/");
    paramString4.append(paramString2);
    paramString4.append("/?fname=");
    paramString4.append(HexUtil.string2HexString(paramString3));
    paramString4.append(paramString5);
    return paramString4.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileVideoOnlinePlayManager.TroopFileWhiteListCallback paramTroopFileWhiteListCallback)
  {
    if (paramLong < 0L) {
      return;
    }
    oidb_0x6e7.ReqBody localReqBody = new oidb_0x6e7.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    localReqBody.str_app_src.set("android");
    localReqBody.str_version.set("8.8.17");
    ProtoUtils.b(paramQQAppInterface, new TroopFileVideoOnlinePlayManager.1(paramTroopFileWhiteListCallback), localReqBody.toByteArray(), "OidbSvc.oidb_0x6e7", 1767, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopFileVideoOnlinePlayManager
 * JD-Core Version:    0.7.0.1
 */