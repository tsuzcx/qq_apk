package dov.com.qq.im.capture.music;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class QIMMusicConfigManager$LoadMusicStepTask
  implements INetEngineListener, Runnable
{
  final AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  final IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  final QIMMusicConfigManager jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager;
  final String b;
  final String c;
  
  QIMMusicConfigManager$LoadMusicStepTask(QIMMusicConfigManager paramQIMMusicConfigManager)
  {
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = paramQIMMusicConfigManager;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQIMMusicConfigManager.getApp();
    this.b = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    this.c = paramQIMMusicConfigManager.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = paramQIMMusicConfigManager.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  }
  
  String a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs").append("_").append("2000000228").append("_").append("TCOHANTCNlddnsTY").append("_").append("uZliVvhTJzkDPlHX").append("_").append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    String str = MD5.a((String)localObject).toLowerCase();
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "generate the sign string, pre=" + (String)localObject + ", md5=" + str);
    }
    return str;
  }
  
  String a(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (!paramMap.isEmpty())
    {
      paramString = paramMap.entrySet().iterator();
      int i = 1;
      if (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        if (i != 0)
        {
          localStringBuilder.append("?");
          i = 0;
        }
        for (;;)
        {
          localStringBuilder.append((String)paramMap.getKey()).append("=").append((String)paramMap.getValue());
          break;
          localStringBuilder.append("&");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "genQQMusicReqUrl url" + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  Map<String, String> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_type", String.valueOf(1));
    localHashMap.put("uin", paramString1);
    localHashMap.put("ticket_type", "skey");
    localHashMap.put("auth", paramString2);
    return localHashMap;
  }
  
  void a()
  {
    ThreadManager.executeOnSubThread(this);
  }
  
  public void onResp(NetResp paramNetResp) {}
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager.LoadMusicStepTask
 * JD-Core Version:    0.7.0.1
 */