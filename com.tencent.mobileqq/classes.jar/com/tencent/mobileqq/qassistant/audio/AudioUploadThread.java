package com.tencent.mobileqq.qassistant.audio;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.CommandDistributorHelper;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantManager;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.Slot;
import com.tencent.mobileqq.qassistant.data.VoiceAssiatantRespInfo.UserInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.protofile.cmd67.cmd67.ASRRecoRes;
import com.tencent.protofile.cmd67.cmd67.ASRWord;
import com.tencent.protofile.cmd67.cmd67.Intent;
import com.tencent.protofile.cmd67.cmd67.ReqBody;
import com.tencent.protofile.cmd67.cmd67.RspBody;
import com.tencent.protofile.cmd67.cmd67.Slot;
import com.tencent.protofile.cmd67.cmd67.UserInfo;
import com.tencent.protofile.cmd67.cmd67.VoiceAssistantASRResp;
import com.tencent.protofile.cmd67.cmd67.VoiceAssistantNLPResp;
import com.tencent.protofile.cmd67.cmd67.VoiceAssistantReq;
import com.tencent.protofile.cmd67.cmd67.VoiceAssistantResp;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile VoiceCacheHolder jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder;
  private CommandDistributorHelper jdField_a_of_type_ComTencentMobileqqQassistantCoreCommandDistributorHelper;
  private VoiceAssistantManager jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = AssistantUtils.a();
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreCommandDistributorHelper = new CommandDistributorHelper();
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager = ((VoiceAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VOICE_ASSISTANT_MANAGER));
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder = paramVoiceCacheHolder;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
    catch (Exception paramVoiceCacheHolder)
    {
      AssistantUtils.a("AudioUploadThread", "init exception:" + paramVoiceCacheHolder);
      paramVoiceCacheHolder.printStackTrace();
    }
  }
  
  private ITransactionCallback a(VoiceBean paramVoiceBean, String paramString)
  {
    return new AudioUploadThread.1(this, paramString, paramVoiceBean);
  }
  
  private VoiceAssiatantRespInfo.ConfirmSendInfo a(List<cmd67.ASRRecoRes> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
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
    AssistantUtils.a("AudioUploadThread", String.format("confirmSendInterval, resList:%s, wordsList:%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(((List)localObject1).size()) }));
    if (((List)localObject1).isEmpty()) {
      return null;
    }
    localObject2 = HardCodeUtil.a(2131720600).trim();
    paramList = new StringBuilder("confirmSendInterval");
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j = 0;
    int k;
    if (((Iterator)localObject1).hasNext())
    {
      localObject3 = (cmd67.ASRWord)((Iterator)localObject1).next();
      localObject4 = ((cmd67.ASRWord)localObject3).word.get();
      ((cmd67.ASRWord)localObject3).confidence.get();
      int m = ((cmd67.ASRWord)localObject3).mbtm.get();
      k = ((cmd67.ASRWord)localObject3).metm.get();
      paramList.append(", word_char:").append((String)localObject4).append(", mbtm:").append(m).append(", metm:").append(k);
      if (!((String)localObject2).startsWith((String)localObject4)) {
        break label377;
      }
      j = m;
    }
    label377:
    for (;;)
    {
      if (((String)localObject2).endsWith((String)localObject4)) {
        i = k;
      }
      for (;;)
      {
        break;
        paramString = new VoiceAssiatantRespInfo.ConfirmSendInfo(j, i, paramString);
        paramList.append(", header:").append(paramString.a).append(", tailor:").append(paramString.b);
        AssistantUtils.a("AudioUploadThread", paramList.toString());
        return paramString;
      }
    }
  }
  
  private void a(VoiceBean paramVoiceBean, byte[] paramArrayOfByte, long paramLong)
  {
    Object localObject = new cmd67.RspBody();
    ((cmd67.RspBody)localObject).mergeFrom(paramArrayOfByte);
    localObject = (cmd67.VoiceAssistantResp)((cmd67.RspBody)localObject).msg_voice_assistent_resp.get();
    int j = ((cmd67.VoiceAssistantResp)localObject).int32_ret_code.get();
    int k = ((cmd67.VoiceAssistantResp)localObject).int32_contact_count.get();
    List localList1 = ((cmd67.VoiceAssistantResp)localObject).msg_user_info.get();
    paramArrayOfByte = (cmd67.VoiceAssistantASRResp)((cmd67.VoiceAssistantResp)localObject).msg_asr_resp.get();
    int m = paramArrayOfByte.uint32_ret_code.get();
    String str1 = paramArrayOfByte.str_text.get();
    String str2 = paramArrayOfByte.str_voice_id.get();
    boolean bool1;
    int n;
    float f1;
    int i1;
    List localList2;
    List localList3;
    String str3;
    float f2;
    VoiceAssiatantRespInfo.ConfirmSendInfo localConfirmSendInfo;
    if (paramArrayOfByte.uint32_is_final.get() == 1)
    {
      bool1 = true;
      n = paramArrayOfByte.uint32_ack_offset.get();
      f1 = paramArrayOfByte.time_use.get();
      localObject = (cmd67.VoiceAssistantNLPResp)((cmd67.VoiceAssistantResp)localObject).msg_nlp_resp.get();
      i1 = ((cmd67.VoiceAssistantNLPResp)localObject).uint32_ret_code.get();
      localList2 = ((cmd67.VoiceAssistantNLPResp)localObject).msg_intents.get();
      localList3 = ((cmd67.VoiceAssistantNLPResp)localObject).msg_slots.get();
      str3 = ((cmd67.VoiceAssistantNLPResp)localObject).str_dialog_status.get();
      f2 = ((cmd67.VoiceAssistantNLPResp)localObject).time_use.get();
      localConfirmSendInfo = a(paramArrayOfByte.reco_res.get(), str2);
      if ((j != 0) || (m != 0)) {
        break label516;
      }
    }
    label516:
    for (boolean bool2 = true;; bool2 = false)
    {
      AssistantUtils.a(bool2, this.jdField_b_of_type_JavaLangString, j, m, i1);
      if (!bool2) {
        AssistantUtils.a("AudioUploadThread", "onError, continue Upload, errCode:" + j + ", asrCode:" + m + ", nlpCode:" + i1);
      }
      AssistantUtils.a("AudioUploadThread", String.format("voiceId:%s, srvAckOffset:%s, retCode:%s, asrRetCode:%s, nlpRetCode:%s, dialStatus:%s, timeUsed1:%s, timeUsed2:%s contactCount:%s\ncontacts:%s, intents:%s, slots:%s, voiceText:%s", new Object[] { str2, Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i1), str3, Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(localList1.size()), Integer.valueOf(localList2.size()), Integer.valueOf(localList3.size()), str1 }));
      int i = 0;
      while (i < localList1.size())
      {
        paramArrayOfByte = (cmd67.UserInfo)localList1.get(i);
        AssistantUtils.a("AudioUploadThread", String.format("UserInfo[uin:%s, wei:%s, contact:%s]", new Object[] { Long.valueOf(paramArrayOfByte.uint64_uin.get()), Float.valueOf(paramArrayOfByte.float_weight.get()), paramArrayOfByte.str_matched_contacts.get() }));
        i += 1;
      }
      bool1 = false;
      break;
    }
    localObject = "";
    paramArrayOfByte = (byte[])localObject;
    if (localList2.size() > 0)
    {
      cmd67.Intent localIntent = (cmd67.Intent)localList2.get(0);
      paramArrayOfByte = (byte[])localObject;
      if (localIntent != null)
      {
        float f3 = localIntent.confidence.get();
        paramArrayOfByte = localIntent.str_content.get();
        AssistantUtils.a("AudioUploadThread", String.format("[content:%s, confidence:%s, skill:%s, intent:%s]", new Object[] { paramArrayOfByte, Float.valueOf(f3), localIntent.str_skill.get(), localIntent.str_intent.get() }));
      }
    }
    boolean bool3 = a(str2, str1, paramArrayOfByte);
    this.jdField_b_of_type_JavaLangString = str2;
    this.jdField_c_of_type_JavaLangString = str1;
    this.jdField_d_of_type_JavaLangString = paramArrayOfByte;
    this.jdField_b_of_type_Int = n;
    VoiceTimeTraceUtil.a().a(paramVoiceBean, str2, str1, paramArrayOfByte, k);
    VoiceTimeTraceUtil.a().a(paramVoiceBean, f1, f2);
    VoiceTimeTraceUtil.a().a(paramVoiceBean, j, m, i1);
    if (VoiceBeanCoordinator.b(paramVoiceBean.jdField_b_of_type_Int)) {
      AssistantUtils.a(VoiceTimeTraceUtil.a().a(str2));
    }
    if ((bool2) && (!bool3)) {
      a(localList2, localList1, localList3, str3, localConfirmSendInfo, f1, f2, str2, bool1);
    }
  }
  
  private void a(List<cmd67.Intent> paramList, List<cmd67.UserInfo> paramList1, List<cmd67.Slot> paramList2, String paramString1, VoiceAssiatantRespInfo.ConfirmSendInfo paramConfirmSendInfo, float paramFloat1, float paramFloat2, String paramString2, boolean paramBoolean)
  {
    VoiceAssiatantRespInfo localVoiceAssiatantRespInfo = new VoiceAssiatantRespInfo();
    if (paramList.size() > 0)
    {
      paramList = (cmd67.Intent)paramList.get(0);
      localVoiceAssiatantRespInfo.jdField_c_of_type_JavaLangString = paramList.str_content.get();
      localVoiceAssiatantRespInfo.jdField_d_of_type_JavaLangString = paramList.str_skill.get();
      localVoiceAssiatantRespInfo.e = paramList.str_intent.get();
    }
    localVoiceAssiatantRespInfo.jdField_a_of_type_JavaLangString = paramString2;
    localVoiceAssiatantRespInfo.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localVoiceAssiatantRespInfo.f = paramString1;
    localVoiceAssiatantRespInfo.jdField_a_of_type_Float = paramFloat1;
    localVoiceAssiatantRespInfo.jdField_b_of_type_Float = paramFloat2;
    localVoiceAssiatantRespInfo.jdField_a_of_type_Boolean = paramBoolean;
    paramList = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      paramString1 = (cmd67.Slot)paramList2.next();
      localVoiceAssiatantRespInfo.getClass();
      paramList.add(new VoiceAssiatantRespInfo.Slot(localVoiceAssiatantRespInfo, paramString1.str_name.get(), paramString1.str_value.get(), paramString1.str_norm.get()));
    }
    localVoiceAssiatantRespInfo.jdField_a_of_type_JavaUtilList = paramList;
    paramList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (cmd67.UserInfo)paramList1.next();
      paramList.add(new VoiceAssiatantRespInfo.UserInfo(paramList2.uint64_uin.get(), paramList2.str_matched_contacts.get(), paramList2.float_weight.get(), paramList2.uint32_chat_type.get()));
    }
    localVoiceAssiatantRespInfo.jdField_b_of_type_JavaUtilList = paramList;
    localVoiceAssiatantRespInfo.jdField_a_of_type_ComTencentMobileqqQassistantDataVoiceAssiatantRespInfo$ConfirmSendInfo = paramConfirmSendInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreCommandDistributorHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreCommandDistributorHelper.a(localVoiceAssiatantRespInfo);
    }
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    return (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramString1)) && (this.jdField_c_of_type_JavaLangString.equalsIgnoreCase(paramString2)) && (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase(paramString3));
  }
  
  private byte[] a(String paramString)
  {
    for (;;)
    {
      try
      {
        File localFile = new File(paramString);
        paramString = new FileInputStream(localFile);
        byte[] arrayOfByte = MD5.toMD5Byte(paramString, localFile.length());
        paramString.close();
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          AssistantUtils.a("AudioUploadThread", "file size:" + localFile.length() + ", fixed md5:" + HexUtil.bytes2HexStr(arrayOfByte));
          return arrayOfByte;
        }
        paramString = MD5FileUtil.a(localFile);
        if (paramString != null)
        {
          paramString = HexUtil.hexStr2Bytes(paramString);
          AssistantUtils.a("AudioUploadThread", "file size:" + localFile.length() + ", fixed md5:" + HexUtil.bytes2HexStr(paramString));
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        AssistantUtils.a("AudioUploadThread", "fix file md5 failed...");
        return null;
      }
      paramString = "";
    }
  }
  
  protected int a(VoiceBean paramVoiceBean)
  {
    int i = 1;
    if ((paramVoiceBean.jdField_a_of_type_ArrayOfByte == null) || (paramVoiceBean.jdField_a_of_type_Int <= 0))
    {
      AssistantUtils.a("AudioUploadThread", "slk encode failure, bean: " + paramVoiceBean.a());
      return 0;
    }
    Object localObject = a(paramVoiceBean);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AssistantUtils.a("AudioUploadThread", "slk encode failure, bean: " + paramVoiceBean.a());
      return 0;
    }
    VoiceTimeTraceUtil.a().e(paramVoiceBean);
    if (this.jdField_a_of_type_Int == 1)
    {
      i = 2;
      if (!this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a()) {
        break label265;
      }
      i = 2;
    }
    label265:
    for (;;)
    {
      boolean bool1 = VoiceBeanCoordinator.a(paramVoiceBean.jdField_b_of_type_Int);
      boolean bool2 = VoiceBeanCoordinator.b(paramVoiceBean.jdField_b_of_type_Int);
      cmd67.ReqBody localReqBody = a(paramVoiceBean.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), bool1, bool2, i);
      localObject = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 67, (String)localObject, 0, a((String)localObject), a(paramVoiceBean, (String)localObject), localReqBody.toByteArray(), false);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
      if (i != 0) {
        AssistantUtils.a("AudioUploadThread", "submitTransactionTask onError, retcode:" + i);
      }
      VoiceTimeTraceUtil.a().f(paramVoiceBean);
      return paramVoiceBean.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Int == 2) {
        break;
      }
      i = 0;
      break;
    }
  }
  
  protected cmd67.ReqBody a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    int i = 0;
    AssistantUtils.a("AudioUploadThread", "create req body, voiceId:" + paramString + ", offset:" + paramInt1 + ", isFir:" + paramBoolean1 + ", isEnd:" + paramBoolean2);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    cmd67.VoiceAssistantReq localVoiceAssistantReq = new cmd67.VoiceAssistantReq();
    localVoiceAssistantReq.uint64_uin.set(Long.parseLong(str));
    localVoiceAssistantReq.uint32_samples_per_sec.set(16000);
    localVoiceAssistantReq.uint32_bits_per_sample.set(16);
    localVoiceAssistantReq.uint32_voice_encode_type.set(6);
    localVoiceAssistantReq.uint32_voice_file_type.set(1);
    localVoiceAssistantReq.scene.set(paramInt2);
    localVoiceAssistantReq.str_voice_id.set(paramString);
    localVoiceAssistantReq.uint32_offset.set(paramInt1);
    paramString = localVoiceAssistantReq.uint32_is_first;
    if (paramBoolean1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString.set(paramInt1);
      paramString = localVoiceAssistantReq.uint32_is_end;
      paramInt1 = i;
      if (paramBoolean2) {
        paramInt1 = 1;
      }
      paramString.set(paramInt1);
      localVoiceAssistantReq.uint32_service_id.set(1);
      paramString = new cmd67.ReqBody();
      paramString.uint32_cmd.set(4);
      paramString.uint32_seq.set(-1);
      paramString.msg_voice_assistent_req.set(localVoiceAssistantReq);
      return paramString;
    }
  }
  
  protected String a(VoiceBean paramVoiceBean)
  {
    if (paramVoiceBean != null) {
      try
      {
        if ((paramVoiceBean.jdField_a_of_type_ArrayOfByte != null) && (paramVoiceBean.jdField_a_of_type_Int > 0))
        {
          String str = AssistantUtils.a("out_" + paramVoiceBean.jdField_a_of_type_JavaLangString + "_" + paramVoiceBean.c, "slk");
          FileUtils.e(str);
          FileOutputStream localFileOutputStream = new FileOutputStream(str);
          if (VoiceBeanCoordinator.a(paramVoiceBean.jdField_b_of_type_Int))
          {
            AssistantUtils.a("AudioUploadThread", "write silk header:" + str);
            localFileOutputStream.write(VoiceCacheHolder.jdField_a_of_type_ArrayOfByte);
          }
          localFileOutputStream.write(paramVoiceBean.jdField_a_of_type_ArrayOfByte, 0, paramVoiceBean.jdField_a_of_type_Int);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          return str;
        }
      }
      catch (IOException paramVoiceBean)
      {
        paramVoiceBean.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public void a()
  {
    String str = "interrupt AudioUploadThread";
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder != null) {
      str = "interrupt AudioUploadThread" + ", buffer size:" + this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a();
    }
    AssistantUtils.a("AudioUploadThread", str);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (isAlive()) {
      interrupt();
    }
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
        while (i < this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a() - 2)
        {
          VoiceBeanCoordinator.a(this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(i), this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(i + 1));
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i + 1);
          i += 1;
        }
        i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        while (i < this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
        {
          VoiceBean localVoiceBean = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(i);
          if (VoiceBeanCoordinator.a(localVoiceBean.jdField_b_of_type_Int))
          {
            this.jdField_a_of_type_JavaLangString = localVoiceBean.jdField_a_of_type_JavaLangString;
            this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
            this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          }
          localVoiceBean.c = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          localVoiceBean.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          if (localVoiceBean.b())
          {
            AssistantUtils.a("AudioUploadThread", String.format("transferBean: %s, Offset:%s", new Object[] { localVoiceBean.a(), Integer.valueOf(this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) }));
            int j = a(localVoiceBean);
            this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(j + this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          }
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i + 1);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioUploadThread
 * JD-Core Version:    0.7.0.1
 */