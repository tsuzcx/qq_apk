package com.tencent.mobileqq.qassistant.audio;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.data.VoiceBean;
import com.tencent.mobileqq.qassistant.setting.QassistantConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class VoiceTimeTraceUtil
{
  private volatile VoiceCacheHolder jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder;
  private Map<VoiceBean, VoiceTimeTraceInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, String> b = new ConcurrentHashMap();
  
  public static VoiceTimeTraceUtil a()
  {
    return VoiceTimeTraceUtil.AudioTraceUtilHolder.a();
  }
  
  private String a(int paramInt)
  {
    String str = String.valueOf(paramInt).trim();
    if (str.startsWith("0"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("请求成功-");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    if (str.startsWith("3010"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("参数非法-");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    if (str.startsWith("3020"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("不支持类型或VoiceId非法-");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    if (str.startsWith("3030"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("语音包太大或空片-");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    if (str.startsWith("3040"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("解压缩失败-");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    if (str.startsWith("3050"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("资源不足拒绝服务-");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = str;
    if (str.startsWith("3060"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("引擎内部失败-");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private String b(int paramInt)
  {
    String str = String.valueOf(paramInt).trim();
    if (str.startsWith("0"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("请求成功-");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    if (str.startsWith("100"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("后台失败-");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    if (str.startsWith("101"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("微信消息体为空-");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    if (str.startsWith("102"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("微信错误-");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = str;
    if (str.startsWith("103"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("参数错误-");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a()) {
        return "";
      }
      ArrayList localArrayList = new ArrayList();
      paramString = AssistantUtils.a(paramString);
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(i);
        if ((((VoiceBean)localObject).d()) && (((VoiceBean)localObject).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
          localArrayList.add(this.jdField_a_of_type_JavaUtilMap.get(localObject));
        }
        i += 1;
      }
      if (localArrayList.isEmpty())
      {
        paramString = new StringBuilder();
        paramString.append("summaryTraceInfo, traceInfoList empty, cacheSize:");
        paramString.append(this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a());
        AssistantUtils.a("VoiceTimeTraceUtil", paramString.toString());
        return "";
      }
      long l1 = 0L;
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        localObject = (VoiceTimeTraceInfo)paramString.next();
        ((VoiceTimeTraceInfo)localObject).a();
        l1 += ((VoiceTimeTraceInfo)localObject).j;
      }
      l1 /= localArrayList.size();
      paramString = (VoiceTimeTraceInfo)localArrayList.get(localArrayList.size() - 1);
      Object localObject = (VoiceTimeTraceInfo)localArrayList.get(0);
      long l2 = paramString.g - ((VoiceTimeTraceInfo)localObject).jdField_a_of_type_Long;
      localObject = new StringBuilder("\n");
      ((StringBuilder)localObject).append("指令总耗时：");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("指令分片数：");
      ((StringBuilder)localObject).append(localArrayList.size());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("分片平均耗时：");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("ASR耗时：");
      ((StringBuilder)localObject).append(paramString.h);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("NLP耗时：");
      ((StringBuilder)localObject).append(paramString.i);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("尾分片总耗时：");
      ((StringBuilder)localObject).append(paramString.j);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("尾包本地耗时：");
      ((StringBuilder)localObject).append(paramString.k);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("尾包网络耗时：");
      ((StringBuilder)localObject).append(paramString.l);
      ((StringBuilder)localObject).append("\n");
      AssistantUtils.a("VoiceTimeTraceUtil", ((StringBuilder)localObject).toString().replace("\n", "， "));
      StringBuilder localStringBuilder = new StringBuilder("\n");
      localStringBuilder.append("语音指令ID：");
      localStringBuilder.append(paramString.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("\n");
      localStringBuilder.append("后台错误码：");
      localStringBuilder.append(b(paramString.jdField_a_of_type_Int));
      localStringBuilder.append("\n");
      localStringBuilder.append("微信错误码：");
      localStringBuilder.append(a(paramString.jdField_b_of_type_Int));
      localStringBuilder.append("\n");
      localStringBuilder.append("语音转文本：");
      localStringBuilder.append(paramString.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("\n");
      localStringBuilder.append("技能树意图：");
      localStringBuilder.append(paramString.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("\n");
      AssistantUtils.a("VoiceTimeTraceUtil", localStringBuilder.toString().replace("\n", "， "));
      AssistantUtils.a(paramString.a(), paramString.jdField_a_of_type_JavaLangString, paramString.jdField_b_of_type_JavaLangString, paramString.jdField_c_of_type_JavaLangString, localArrayList.size(), paramString.jdField_d_of_type_Int, l2, l1, paramString.h, paramString.i, paramString.j, paramString.k, paramString.l);
      paramString = new StringBuilder();
      paramString.append(localStringBuilder.toString().trim());
      paramString.append("\n");
      paramString.append(((StringBuilder)localObject).toString().trim());
      return paramString.toString();
    }
    return "";
  }
  
  public void a() {}
  
  public void a(Activity paramActivity)
  {
    if ((QassistantConfig.a()) && (paramActivity != null))
    {
      Object localObject = AssistantUtils.a();
      if ((localObject != null) && (((IVoiceAssistantCore)localObject).isVoicePanelShow())) {
        ((IVoiceAssistantCore)localObject).quiteVoicePanel(true, false);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("snapshotList:");
      ((StringBuilder)localObject).append(this.b.toString());
      AssistantUtils.a("VoiceTimeTraceUtil", ((StringBuilder)localObject).toString());
      if (this.b.isEmpty())
      {
        QQToast.a(paramActivity, "快照文件为空", 0).a();
        return;
      }
      if (this.b.get("SLK") != null) {
        FileUtils.isEmptyFile((String)this.b.get("SLK"));
      }
      if (this.b.get("PCM") != null) {
        FileUtils.isEmptyFile((String)this.b.get("PCM"));
      }
      if (this.b.get("BUF") != null) {
        FileUtils.isEmptyFile((String)this.b.get("BUF"));
      }
      localObject = new ArrayList(this.b.values().size());
      ThreadManager.getFileThreadHandler().post(new VoiceTimeTraceUtil.1(this, (List)localObject, paramActivity));
      return;
    }
    QQToast.a(paramActivity, "转发环境错误", 0).a();
  }
  
  public void a(VoiceCacheHolder paramVoiceCacheHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder = paramVoiceCacheHolder;
  }
  
  public void a(VoiceBean paramVoiceBean)
  {
    VoiceTimeTraceInfo localVoiceTimeTraceInfo2 = (VoiceTimeTraceInfo)this.jdField_a_of_type_JavaUtilMap.get(paramVoiceBean);
    VoiceTimeTraceInfo localVoiceTimeTraceInfo1 = localVoiceTimeTraceInfo2;
    if (localVoiceTimeTraceInfo2 == null) {
      localVoiceTimeTraceInfo1 = new VoiceTimeTraceInfo();
    }
    localVoiceTimeTraceInfo1.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramVoiceBean, localVoiceTimeTraceInfo1);
  }
  
  public void a(VoiceBean paramVoiceBean, int paramInt1, int paramInt2, int paramInt3)
  {
    VoiceTimeTraceInfo localVoiceTimeTraceInfo2 = (VoiceTimeTraceInfo)this.jdField_a_of_type_JavaUtilMap.get(paramVoiceBean);
    VoiceTimeTraceInfo localVoiceTimeTraceInfo1 = localVoiceTimeTraceInfo2;
    if (localVoiceTimeTraceInfo2 == null) {
      localVoiceTimeTraceInfo1 = new VoiceTimeTraceInfo();
    }
    localVoiceTimeTraceInfo1.jdField_a_of_type_Int = paramInt1;
    localVoiceTimeTraceInfo1.jdField_b_of_type_Int = paramInt2;
    localVoiceTimeTraceInfo1.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilMap.put(paramVoiceBean, localVoiceTimeTraceInfo1);
  }
  
  public void a(VoiceBean paramVoiceBean, long paramLong1, long paramLong2)
  {
    VoiceTimeTraceInfo localVoiceTimeTraceInfo2 = (VoiceTimeTraceInfo)this.jdField_a_of_type_JavaUtilMap.get(paramVoiceBean);
    VoiceTimeTraceInfo localVoiceTimeTraceInfo1 = localVoiceTimeTraceInfo2;
    if (localVoiceTimeTraceInfo2 == null) {
      localVoiceTimeTraceInfo1 = new VoiceTimeTraceInfo();
    }
    localVoiceTimeTraceInfo1.h = paramLong1;
    localVoiceTimeTraceInfo1.i = paramLong2;
    this.jdField_a_of_type_JavaUtilMap.put(paramVoiceBean, localVoiceTimeTraceInfo1);
  }
  
  public void a(VoiceBean paramVoiceBean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    VoiceTimeTraceInfo localVoiceTimeTraceInfo2 = (VoiceTimeTraceInfo)this.jdField_a_of_type_JavaUtilMap.get(paramVoiceBean);
    VoiceTimeTraceInfo localVoiceTimeTraceInfo1 = localVoiceTimeTraceInfo2;
    if (localVoiceTimeTraceInfo2 == null) {
      localVoiceTimeTraceInfo1 = new VoiceTimeTraceInfo();
    }
    localVoiceTimeTraceInfo1.g = System.currentTimeMillis();
    localVoiceTimeTraceInfo1.jdField_a_of_type_JavaLangString = paramString1;
    localVoiceTimeTraceInfo1.jdField_b_of_type_JavaLangString = paramString2;
    localVoiceTimeTraceInfo1.jdField_d_of_type_Int = paramInt;
    localVoiceTimeTraceInfo1.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaUtilMap.put(paramVoiceBean, localVoiceTimeTraceInfo1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString2);
    if ((((File)localObject).exists()) && (((File)localObject).length() > 0L) && (!this.b.containsKey(paramString1)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("put snapshot key: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", path: ");
      ((StringBuilder)localObject).append(paramString2);
      AssistantUtils.a("VoiceTimeTraceUtil", ((StringBuilder)localObject).toString());
      this.b.put(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void b()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((String)localEntry.getKey()).equalsIgnoreCase("SLK")) {
        FileUtils.deleteFile((String)localEntry.getValue());
      }
    }
    this.b.clear();
  }
  
  public void b(VoiceBean paramVoiceBean)
  {
    VoiceTimeTraceInfo localVoiceTimeTraceInfo2 = (VoiceTimeTraceInfo)this.jdField_a_of_type_JavaUtilMap.get(paramVoiceBean);
    VoiceTimeTraceInfo localVoiceTimeTraceInfo1 = localVoiceTimeTraceInfo2;
    if (localVoiceTimeTraceInfo2 == null) {
      localVoiceTimeTraceInfo1 = new VoiceTimeTraceInfo();
    }
    localVoiceTimeTraceInfo1.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramVoiceBean, localVoiceTimeTraceInfo1);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void c(VoiceBean paramVoiceBean)
  {
    VoiceTimeTraceInfo localVoiceTimeTraceInfo2 = (VoiceTimeTraceInfo)this.jdField_a_of_type_JavaUtilMap.get(paramVoiceBean);
    VoiceTimeTraceInfo localVoiceTimeTraceInfo1 = localVoiceTimeTraceInfo2;
    if (localVoiceTimeTraceInfo2 == null) {
      localVoiceTimeTraceInfo1 = new VoiceTimeTraceInfo();
    }
    localVoiceTimeTraceInfo1.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramVoiceBean, localVoiceTimeTraceInfo1);
  }
  
  public void d()
  {
    IVoiceAssistantCore localIVoiceAssistantCore = AssistantUtils.a();
    if ((localIVoiceAssistantCore != null) && (localIVoiceAssistantCore.getActivity() != null))
    {
      a(localIVoiceAssistantCore.getActivity());
      return;
    }
    AssistantUtils.a("VoiceTimeTraceUtil", "traceSnapshot, env Error");
  }
  
  public void d(VoiceBean paramVoiceBean)
  {
    VoiceTimeTraceInfo localVoiceTimeTraceInfo2 = (VoiceTimeTraceInfo)this.jdField_a_of_type_JavaUtilMap.get(paramVoiceBean);
    VoiceTimeTraceInfo localVoiceTimeTraceInfo1 = localVoiceTimeTraceInfo2;
    if (localVoiceTimeTraceInfo2 == null) {
      localVoiceTimeTraceInfo1 = new VoiceTimeTraceInfo();
    }
    localVoiceTimeTraceInfo1.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramVoiceBean, localVoiceTimeTraceInfo1);
  }
  
  public void e(VoiceBean paramVoiceBean)
  {
    VoiceTimeTraceInfo localVoiceTimeTraceInfo2 = (VoiceTimeTraceInfo)this.jdField_a_of_type_JavaUtilMap.get(paramVoiceBean);
    VoiceTimeTraceInfo localVoiceTimeTraceInfo1 = localVoiceTimeTraceInfo2;
    if (localVoiceTimeTraceInfo2 == null) {
      localVoiceTimeTraceInfo1 = new VoiceTimeTraceInfo();
    }
    localVoiceTimeTraceInfo1.e = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramVoiceBean, localVoiceTimeTraceInfo1);
  }
  
  public void f(VoiceBean paramVoiceBean)
  {
    VoiceTimeTraceInfo localVoiceTimeTraceInfo2 = (VoiceTimeTraceInfo)this.jdField_a_of_type_JavaUtilMap.get(paramVoiceBean);
    VoiceTimeTraceInfo localVoiceTimeTraceInfo1 = localVoiceTimeTraceInfo2;
    if (localVoiceTimeTraceInfo2 == null) {
      localVoiceTimeTraceInfo1 = new VoiceTimeTraceInfo();
    }
    localVoiceTimeTraceInfo1.f = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramVoiceBean, localVoiceTimeTraceInfo1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceTimeTraceUtil
 * JD-Core Version:    0.7.0.1
 */