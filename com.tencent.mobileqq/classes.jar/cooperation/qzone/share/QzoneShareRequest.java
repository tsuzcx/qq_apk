package cooperation.qzone.share;

import NS_MOBILE_OPERATION.operation_forward_req;
import NS_MOBILE_OPERATION.operation_forward_rsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QzoneShareRequest
  extends QzoneExternalRequest
{
  private static final String CMD_STRING = "forward";
  public JceStruct req;
  
  public QzoneShareRequest(String paramString1, String paramString2, int paramInt1, long paramLong1, String paramString3, String paramString4, String paramString5, ArrayList<String> paramArrayList, long paramLong2, String paramString6, int paramInt2, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong1);
    operation_forward_req localoperation_forward_req = new operation_forward_req();
    if (paramLong2 != 0L) {
      localoperation_forward_req.subid = ((int)paramLong2);
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    if (paramString2 != null) {
      localoperation_forward_req.srcId = paramString2;
    }
    if (paramInt1 > 0) {
      localoperation_forward_req.appid = paramInt1;
    }
    localoperation_forward_req.uin = paramLong1;
    if (paramLong1 > 0L) {
      localoperation_forward_req.ownUin = paramLong1;
    }
    if (paramString3 != null)
    {
      if (paramString3.length() > 200) {
        localoperation_forward_req.srcTitle = paramString3.substring(0, 200);
      }
    }
    else
    {
      if (paramString4 != null)
      {
        if (paramString4.length() <= 600) {
          break label257;
        }
        localoperation_forward_req.srcAbstract = paramString4.substring(0, 600);
      }
      label152:
      if (paramString5 != null) {
        if (paramString5.length() <= 1500) {
          break label267;
        }
      }
    }
    label257:
    label267:
    for (localoperation_forward_req.reason = paramString5.substring(0, 1500);; localoperation_forward_req.reason = paramString5)
    {
      if ((paramArrayList == null) || (paramArrayList.size() <= 9)) {
        break label277;
      }
      if (localoperation_forward_req.srcImages == null) {
        localoperation_forward_req.srcImages = new ArrayList();
      }
      paramInt1 = 0;
      while (paramInt1 < 9)
      {
        localoperation_forward_req.srcImages.add(paramArrayList.get(paramInt1));
        paramInt1 += 1;
      }
      localoperation_forward_req.srcTitle = paramString3;
      break;
      localoperation_forward_req.srcAbstract = paramString4;
      break label152;
    }
    label277:
    localoperation_forward_req.srcImages = paramArrayList;
    localoperation_forward_req.operatemask = 4;
    if (localoperation_forward_req.busi_param == null) {
      localoperation_forward_req.busi_param = new HashMap();
    }
    localoperation_forward_req.busi_param.put(Integer.valueOf(43), str);
    if (!TextUtils.isEmpty(paramString6)) {
      localoperation_forward_req.busi_param.put(Integer.valueOf(79), paramString6);
    }
    localoperation_forward_req.iUrlInfoFrm = paramInt2;
    localoperation_forward_req.xcxMapEx = paramMap1;
    localoperation_forward_req.stored_extend_info = paramMap2;
    this.req = localoperation_forward_req;
  }
  
  public static operation_forward_rsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = decode(paramArrayOfByte, "forward");
    if ((paramArrayOfByte instanceof operation_forward_rsp)) {
      return (operation_forward_rsp)paramArrayOfByte;
    }
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.forward";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "forward";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QzoneShareRequest
 * JD-Core Version:    0.7.0.1
 */