package com.tencent.mobileqq.qassistant.audio;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.CommandDistributorHelper;
import com.tencent.mobileqq.qassistant.data.Audio2TextResult;
import com.tencent.mobileqq.qassistant.data.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssistantRespInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssistantRespInfo.Slot;
import com.tencent.mobileqq.qassistant.data.VoiceAssistantRespInfo.UserInfo;
import com.tencent.mobileqq.qassistant.data.VoiceBean;
import com.tencent.mobileqq.qassistant.listener.IAudio2TextResultCallBack;
import com.tencent.mobileqq.qassistant.proto.cmd67.ASRRecoRes;
import com.tencent.mobileqq.qassistant.proto.cmd67.ASRWord;
import com.tencent.mobileqq.qassistant.proto.cmd67.Intent;
import com.tencent.mobileqq.qassistant.proto.cmd67.ReqBody;
import com.tencent.mobileqq.qassistant.proto.cmd67.RspBody;
import com.tencent.mobileqq.qassistant.proto.cmd67.Slot;
import com.tencent.mobileqq.qassistant.proto.cmd67.UserInfo;
import com.tencent.mobileqq.qassistant.proto.cmd67.VoiceAssistantASRResp;
import com.tencent.mobileqq.qassistant.proto.cmd67.VoiceAssistantNLPResp;
import com.tencent.mobileqq.qassistant.proto.cmd67.VoiceAssistantResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class AudioUploadThread
  extends Thread
{
  private int jdField_a_of_type_Int = -1;
  private IVoiceAssistantCore jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
  private volatile VoiceCacheHolder jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder;
  private CommandDistributorHelper jdField_a_of_type_ComTencentMobileqqQassistantCoreCommandDistributorHelper;
  private IAudio2TextResultCallBack jdField_a_of_type_ComTencentMobileqqQassistantListenerIAudio2TextResultCallBack;
  private volatile String jdField_a_of_type_JavaLangString = AssistantUtils.a();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private String jdField_c_of_type_JavaLangString = "";
  private AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private String jdField_d_of_type_JavaLangString = "";
  private AtomicInteger jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public AudioUploadThread(int paramInt, VoiceCacheHolder paramVoiceCacheHolder)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreCommandDistributorHelper = new CommandDistributorHelper();
      this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore = ((IVoiceAssistantCore)AssistantUtils.a().getRuntimeService(IVoiceAssistantCore.class, ""));
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder = paramVoiceCacheHolder;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
    catch (Exception paramVoiceCacheHolder)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init exception:");
      localStringBuilder.append(paramVoiceCacheHolder);
      AssistantUtils.a("AudioUploadThread", localStringBuilder.toString());
      paramVoiceCacheHolder.printStackTrace();
    }
  }
  
  private ITransactionCallback a(VoiceBean paramVoiceBean, String paramString)
  {
    return new AudioUploadThread.1(this, paramString, paramVoiceBean);
  }
  
  private ConfirmSendInfo a(List<cmd67.ASRRecoRes> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      Object localObject1 = new ArrayList();
      Object localObject2 = paramList.iterator();
      Object localObject3;
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cmd67.ASRRecoRes)((Iterator)localObject2).next();
        localObject4 = ((cmd67.ASRRecoRes)localObject3).word.get();
        ((cmd67.ASRRecoRes)localObject3).text.get();
        ((cmd67.ASRRecoRes)localObject3).comment.get();
        ((cmd67.ASRRecoRes)localObject3).similarity.get();
        ((cmd67.ASRRecoRes)localObject3).confidence.get();
        ((List)localObject1).addAll((Collection)localObject4);
      }
      int i = paramList.size();
      int j = 0;
      AssistantUtils.a("AudioUploadThread", String.format("confirmSendInterval, resList:%s, wordsList:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(((List)localObject1).size()) }));
      if (((List)localObject1).isEmpty()) {
        return null;
      }
      localObject2 = AssistantUtils.a(2131720315);
      paramList = new StringBuilder("confirmSendInterval");
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (cmd67.ASRWord)((Iterator)localObject1).next();
        localObject4 = ((cmd67.ASRWord)localObject3).word.get();
        ((cmd67.ASRWord)localObject3).confidence.get();
        int n = ((cmd67.ASRWord)localObject3).mbtm.get();
        int m = ((cmd67.ASRWord)localObject3).metm.get();
        paramList.append(", word_char:");
        paramList.append((String)localObject4);
        paramList.append(", mbtm:");
        paramList.append(n);
        paramList.append(", metm:");
        paramList.append(m);
        int k = j;
        if (((String)localObject2).startsWith((String)localObject4)) {
          k = n;
        }
        j = k;
        if (((String)localObject2).endsWith((String)localObject4))
        {
          i = m;
          j = k;
        }
      }
      paramString = new ConfirmSendInfo(j, i, paramString);
      paramList.append(", header:");
      paramList.append(paramString.a);
      paramList.append(", tailor:");
      paramList.append(paramString.b);
      AssistantUtils.a("AudioUploadThread", paramList.toString());
      return paramString;
    }
    return null;
  }
  
  private void a(VoiceBean paramVoiceBean1, VoiceBean paramVoiceBean2)
  {
    if ((paramVoiceBean1.jdField_a_of_type_Boolean) && (paramVoiceBean2.jdField_a_of_type_Boolean))
    {
      if (paramVoiceBean1.jdField_b_of_type_Int != 3) {
        paramVoiceBean1.jdField_b_of_type_Int = 0;
      }
      paramVoiceBean2.jdField_b_of_type_Int = 0;
    }
    if ((paramVoiceBean1.jdField_a_of_type_Boolean) && (!paramVoiceBean2.jdField_a_of_type_Boolean)) {
      if (paramVoiceBean1.e())
      {
        if (paramVoiceBean1.jdField_b_of_type_Int != 3) {
          paramVoiceBean1.jdField_b_of_type_Int = 1;
        } else {
          paramVoiceBean1.jdField_b_of_type_Int = 2;
        }
        paramVoiceBean2.jdField_b_of_type_Int = 2;
      }
      else
      {
        paramVoiceBean1.jdField_b_of_type_Int = 0;
        paramVoiceBean2.jdField_b_of_type_Int = 1;
      }
    }
    if ((!paramVoiceBean1.jdField_a_of_type_Boolean) && (paramVoiceBean2.jdField_a_of_type_Boolean)) {
      if (paramVoiceBean1.jdField_b_of_type_Int == 1)
      {
        paramVoiceBean2.jdField_b_of_type_Int = 2;
      }
      else
      {
        paramVoiceBean1.jdField_b_of_type_Int = 2;
        paramVoiceBean2.jdField_b_of_type_Int = 3;
      }
    }
    if ((!paramVoiceBean1.jdField_a_of_type_Boolean) && (!paramVoiceBean2.jdField_a_of_type_Boolean))
    {
      if (paramVoiceBean1.jdField_b_of_type_Int != 1) {
        paramVoiceBean1.jdField_b_of_type_Int = 2;
      }
      paramVoiceBean2.jdField_b_of_type_Int = 2;
    }
    VoiceTimeTraceUtil.a().d(paramVoiceBean1);
    VoiceTimeTraceUtil.a().d(paramVoiceBean2);
  }
  
  private void a(VoiceBean paramVoiceBean, byte[] paramArrayOfByte, long paramLong)
  {
    Object localObject1 = new cmd67.RspBody();
    ((cmd67.RspBody)localObject1).mergeFrom(paramArrayOfByte);
    Object localObject2 = (cmd67.VoiceAssistantResp)((cmd67.RspBody)localObject1).msg_voice_assistent_resp.get();
    int k = ((cmd67.VoiceAssistantResp)localObject2).int32_ret_code.get();
    int m = ((cmd67.VoiceAssistantResp)localObject2).int32_contact_count.get();
    localObject1 = ((cmd67.VoiceAssistantResp)localObject2).msg_user_info.get();
    paramArrayOfByte = (cmd67.VoiceAssistantASRResp)((cmd67.VoiceAssistantResp)localObject2).msg_asr_resp.get();
    int n = paramArrayOfByte.uint32_ret_code.get();
    String str1 = paramArrayOfByte.str_text.get();
    String str2 = paramArrayOfByte.str_voice_id.get();
    boolean bool1;
    if (paramArrayOfByte.uint32_is_final.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i1 = paramArrayOfByte.uint32_ack_offset.get();
    float f2 = paramArrayOfByte.time_use.get();
    Object localObject3 = (cmd67.VoiceAssistantNLPResp)((cmd67.VoiceAssistantResp)localObject2).msg_nlp_resp.get();
    int i = ((cmd67.VoiceAssistantNLPResp)localObject3).uint32_ret_code.get();
    localObject2 = ((cmd67.VoiceAssistantNLPResp)localObject3).msg_intents.get();
    List localList = ((cmd67.VoiceAssistantNLPResp)localObject3).msg_slots.get();
    String str3 = ((cmd67.VoiceAssistantNLPResp)localObject3).str_dialog_status.get();
    float f1 = ((cmd67.VoiceAssistantNLPResp)localObject3).time_use.get();
    localObject3 = a(paramArrayOfByte.reco_res.get(), str2);
    boolean bool2;
    if ((k == 0) && (n == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    AssistantUtils.a(bool2, this.jdField_b_of_type_JavaLangString, k, n, i);
    if (!bool2)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onError, continue Upload, errCode:");
      paramArrayOfByte.append(k);
      paramArrayOfByte.append(", asrCode:");
      paramArrayOfByte.append(n);
      paramArrayOfByte.append(", nlpCode:");
      paramArrayOfByte.append(i);
      AssistantUtils.a("AudioUploadThread", paramArrayOfByte.toString());
    }
    AssistantUtils.a("AudioUploadThread", String.format("voiceId:%s, srvAckOffset:%s, retCode:%s, asrRetCode:%s, nlpRetCode:%s, dialStatus:%s, timeUsed1:%s, timeUsed2:%s contactCount:%s\ncontacts:%s, intents:%s, slots:%s, voiceText:%s", new Object[] { str2, Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(i), str3, Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(m), Integer.valueOf(((List)localObject1).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(localList.size()), str1 }));
    int j = 0;
    while (j < ((List)localObject1).size())
    {
      paramArrayOfByte = (cmd67.UserInfo)((List)localObject1).get(j);
      AssistantUtils.a("AudioUploadThread", String.format("UserInfo[uin:%s, wei:%s, contact:%s]", new Object[] { Long.valueOf(paramArrayOfByte.uint64_uin.get()), Float.valueOf(paramArrayOfByte.float_weight.get()), paramArrayOfByte.str_matched_contacts.get() }));
      j += 1;
    }
    if (((List)localObject2).size() > 0)
    {
      cmd67.Intent localIntent = (cmd67.Intent)((List)localObject2).get(0);
      if (localIntent != null)
      {
        float f3 = localIntent.confidence.get();
        paramArrayOfByte = localIntent.str_content.get();
        AssistantUtils.a("AudioUploadThread", String.format("[content:%s, confidence:%s, skill:%s, intent:%s]", new Object[] { paramArrayOfByte, Float.valueOf(f3), localIntent.str_skill.get(), localIntent.str_intent.get() }));
        break label641;
      }
    }
    paramArrayOfByte = "";
    label641:
    boolean bool3 = a(str2, str1, paramArrayOfByte);
    this.jdField_b_of_type_JavaLangString = str2;
    this.jdField_c_of_type_JavaLangString = str1;
    this.jdField_d_of_type_JavaLangString = paramArrayOfByte;
    this.jdField_b_of_type_Int = i1;
    VoiceTimeTraceUtil.a().a(paramVoiceBean, str2, str1, paramArrayOfByte, m);
    VoiceTimeTraceUtil.a().a(paramVoiceBean, f2, f1);
    VoiceTimeTraceUtil.a().a(paramVoiceBean, k, n, i);
    if (paramVoiceBean.b()) {
      AssistantUtils.a(VoiceTimeTraceUtil.a().a(str2));
    }
    if ((bool2) && (!bool3))
    {
      i = this.jdField_a_of_type_Int;
      if ((i != 2) && (i != 1)) {
        break label789;
      }
      a((List)localObject2, (List)localObject1, localList, str3, (ConfirmSendInfo)localObject3, f2, f1, str2, bool1);
      label789:
      if (this.jdField_a_of_type_Int == 4) {
        a(paramVoiceBean, str1);
      }
    }
  }
  
  private void a(List<cmd67.Intent> paramList, List<cmd67.UserInfo> paramList1, List<cmd67.Slot> paramList2, String paramString1, ConfirmSendInfo paramConfirmSendInfo, float paramFloat1, float paramFloat2, String paramString2, boolean paramBoolean)
  {
    VoiceAssistantRespInfo localVoiceAssistantRespInfo = new VoiceAssistantRespInfo();
    if (paramList.size() > 0)
    {
      paramList = (cmd67.Intent)paramList.get(0);
      localVoiceAssistantRespInfo.jdField_c_of_type_JavaLangString = paramList.str_content.get();
      localVoiceAssistantRespInfo.jdField_d_of_type_JavaLangString = paramList.str_skill.get();
      localVoiceAssistantRespInfo.e = paramList.str_intent.get();
    }
    localVoiceAssistantRespInfo.jdField_a_of_type_JavaLangString = paramString2;
    localVoiceAssistantRespInfo.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localVoiceAssistantRespInfo.f = paramString1;
    localVoiceAssistantRespInfo.jdField_a_of_type_Float = paramFloat1;
    localVoiceAssistantRespInfo.jdField_b_of_type_Float = paramFloat2;
    localVoiceAssistantRespInfo.jdField_a_of_type_Boolean = paramBoolean;
    paramList = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      paramString1 = (cmd67.Slot)paramList2.next();
      localVoiceAssistantRespInfo.getClass();
      paramList.add(new VoiceAssistantRespInfo.Slot(localVoiceAssistantRespInfo, paramString1.str_name.get(), paramString1.str_value.get(), paramString1.str_norm.get()));
    }
    localVoiceAssistantRespInfo.jdField_a_of_type_JavaUtilList = paramList;
    paramList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (cmd67.UserInfo)paramList1.next();
      paramList.add(new VoiceAssistantRespInfo.UserInfo(paramList2.uint64_uin.get(), paramList2.str_matched_contacts.get(), paramList2.float_weight.get(), paramList2.uint32_chat_type.get()));
    }
    localVoiceAssistantRespInfo.jdField_b_of_type_JavaUtilList = paramList;
    localVoiceAssistantRespInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataConfirmSendInfo = paramConfirmSendInfo;
    paramList = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreCommandDistributorHelper;
    if (paramList != null) {
      paramList.a(localVoiceAssistantRespInfo);
    }
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    return (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramString1)) && (this.jdField_c_of_type_JavaLangString.equalsIgnoreCase(paramString2)) && (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase(paramString3));
  }
  
  private byte[] a(String paramString)
  {
    try
    {
      localFile = new File(paramString);
      localObject = new FileInputStream(localFile);
      paramString = MD5.toMD5Byte((InputStream)localObject, localFile.length());
      ((FileInputStream)localObject).close();
      if ((paramString != null) && (paramString.length > 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file size:");
        ((StringBuilder)localObject).append(localFile.length());
        ((StringBuilder)localObject).append(", fixed md5:");
        ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(paramString));
        AssistantUtils.a("AudioUploadThread", ((StringBuilder)localObject).toString());
        return paramString;
      }
      paramString = MD5FileUtil.a(localFile);
      if (paramString == null) {
        break label177;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        File localFile;
        Object localObject;
        continue;
        label177:
        paramString = "";
      }
    }
    paramString = HexUtil.hexStr2Bytes(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file size:");
    ((StringBuilder)localObject).append(localFile.length());
    ((StringBuilder)localObject).append(", fixed md5:");
    ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(paramString));
    AssistantUtils.a("AudioUploadThread", ((StringBuilder)localObject).toString());
    return paramString;
    AssistantUtils.a("AudioUploadThread", "fix file md5 failed...");
    return null;
  }
  
  protected int a(VoiceBean paramVoiceBean)
  {
    Object localObject1 = AssistantUtils.a();
    int i = 0;
    if (localObject1 == null)
    {
      AssistantUtils.a("AudioUploadThread", "transferBean when appInterface is null");
      return 0;
    }
    if ((paramVoiceBean.jdField_a_of_type_ArrayOfByte != null) && (paramVoiceBean.jdField_a_of_type_Int > 0))
    {
      Object localObject2 = a(paramVoiceBean);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("slk encode failure, bean: ");
        ((StringBuilder)localObject1).append(paramVoiceBean.a());
        AssistantUtils.a("AudioUploadThread", ((StringBuilder)localObject1).toString());
        return 0;
      }
      VoiceTimeTraceUtil.a().e(paramVoiceBean);
      int j = this.jdField_a_of_type_Int;
      if (j == 1) {
        i = 2;
      } else if (j == 2) {
        i = 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.isInSession()) {
        i = 2;
      }
      cmd67.ReqBody localReqBody = a(paramVoiceBean.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), paramVoiceBean.a(), paramVoiceBean.b(), i);
      localObject2 = new Transaction(AssistantUtils.a().getCurrentAccountUin(), 67, (String)localObject2, 0, a((String)localObject2), a(paramVoiceBean, (String)localObject2), localReqBody.toByteArray(), false);
      i = ((AppInterface)localObject1).getHwEngine().submitTransactionTask((Transaction)localObject2);
      if (i != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("submitTransactionTask onError, retcode:");
        ((StringBuilder)localObject1).append(i);
        AssistantUtils.a("AudioUploadThread", ((StringBuilder)localObject1).toString());
      }
      VoiceTimeTraceUtil.a().f(paramVoiceBean);
      return paramVoiceBean.jdField_a_of_type_Int;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("slk encode failure, bean: ");
    ((StringBuilder)localObject1).append(paramVoiceBean.a());
    AssistantUtils.a("AudioUploadThread", ((StringBuilder)localObject1).toString());
    return 0;
  }
  
  protected cmd67.ReqBody a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected String a(VoiceBean paramVoiceBean)
  {
    if (paramVoiceBean != null) {
      try
      {
        if (paramVoiceBean.jdField_a_of_type_ArrayOfByte != null)
        {
          if (paramVoiceBean.jdField_a_of_type_Int <= 0) {
            return null;
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("out_");
          ((StringBuilder)localObject).append(paramVoiceBean.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(paramVoiceBean.c);
          localObject = AssistantUtils.a(((StringBuilder)localObject).toString(), "slk");
          FileUtils.deleteFile((String)localObject);
          FileOutputStream localFileOutputStream = new FileOutputStream((String)localObject);
          if (paramVoiceBean.a())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("write silk header:");
            localStringBuilder.append((String)localObject);
            AssistantUtils.a("AudioUploadThread", localStringBuilder.toString());
            localFileOutputStream.write(VoiceCacheHolder.jdField_a_of_type_ArrayOfByte);
          }
          localFileOutputStream.write(paramVoiceBean.jdField_a_of_type_ArrayOfByte, 0, paramVoiceBean.jdField_a_of_type_Int);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          return localObject;
        }
      }
      catch (IOException paramVoiceBean)
      {
        paramVoiceBean.printStackTrace();
      }
    }
    return null;
  }
  
  public void a()
  {
    VoiceCacheHolder localVoiceCacheHolder = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder;
    Object localObject = "interrupt AudioUploadThread";
    if (localVoiceCacheHolder != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("interrupt AudioUploadThread");
      ((StringBuilder)localObject).append(", buffer size:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a());
      localObject = ((StringBuilder)localObject).toString();
    }
    AssistantUtils.a("AudioUploadThread", (String)localObject);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (isAlive()) {
      interrupt();
    }
  }
  
  public void a(VoiceBean paramVoiceBean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIAudio2TextResultCallBack != null)
    {
      paramVoiceBean = new Audio2TextResult(paramVoiceBean, paramString);
      this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIAudio2TextResultCallBack.a(paramVoiceBean);
    }
  }
  
  public void a(IAudio2TextResultCallBack paramIAudio2TextResultCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIAudio2TextResultCallBack = paramIAudio2TextResultCallBack;
  }
  
  public void run()
  {
    while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 2)
      {
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      else
      {
        int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        Object localObject;
        while (i < this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a() - 2)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(i);
          VoiceCacheHolder localVoiceCacheHolder = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder;
          i += 1;
          a((VoiceBean)localObject, localVoiceCacheHolder.a(i));
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
        }
        i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        while (i < this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(i);
          if (((VoiceBean)localObject).a())
          {
            this.jdField_a_of_type_JavaLangString = ((VoiceBean)localObject).jdField_a_of_type_JavaLangString;
            this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
            this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          }
          ((VoiceBean)localObject).c = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          ((VoiceBean)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          if (((VoiceBean)localObject).d())
          {
            AssistantUtils.a("AudioUploadThread", String.format("transferBean: %s, Offset:%s", new Object[] { ((VoiceBean)localObject).a(), Integer.valueOf(this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) }));
            int j = a((VoiceBean)localObject);
            localObject = this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger;
            ((AtomicInteger)localObject).set(((AtomicInteger)localObject).get() + j);
          }
          localObject = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
          i += 1;
          ((AtomicInteger)localObject).set(i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioUploadThread
 * JD-Core Version:    0.7.0.1
 */