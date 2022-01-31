package dov.com.qq.im.capture.music;

import aysa;
import aysc;
import aysy;
import aysz;
import bflg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class QIMMusicConfigManager$LoadMusicStepTask
  implements aysc, Runnable
{
  final aysa jdField_a_of_type_Aysa;
  final AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  final QIMMusicConfigManager jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager;
  final String b;
  final String c;
  
  QIMMusicConfigManager$LoadMusicStepTask(QIMMusicConfigManager paramQIMMusicConfigManager)
  {
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = paramQIMMusicConfigManager;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQIMMusicConfigManager.a();
    this.b = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    this.c = paramQIMMusicConfigManager.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Aysa = paramQIMMusicConfigManager.jdField_a_of_type_Aysa;
  }
  
  String a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs").append("_").append("2000000025").append("_").append("SApgehUTVGxZKBQZTt").append("_").append("QmnkKmaTHNDozKdIUA").append("_").append(paramLong);
    localObject = ((StringBuilder)localObject).toString();
    String str = bflg.a((String)localObject).toLowerCase();
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
  
  public void onResp(aysz paramaysz) {}
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager.LoadMusicStepTask
 * JD-Core Version:    0.7.0.1
 */