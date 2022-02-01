package com.tencent.mobileqq.qassistant.audio;

import android.text.TextUtils;
import anvx;
import bajb;
import bajd;
import baje;
import bajh;
import bajl;
import bakl;
import bakm;
import bakx;
import balh;
import bali;
import balj;
import balk;
import bkvq;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
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
  private volatile bajh jdField_a_of_type_Bajh;
  private bakm jdField_a_of_type_Bakm;
  private bakx jdField_a_of_type_Bakx;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile String jdField_a_of_type_JavaLangString = bakl.a();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private String jdField_c_of_type_JavaLangString = "";
  private AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private String jdField_d_of_type_JavaLangString = "";
  private AtomicInteger jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public AudioUploadThread(int paramInt, bajh parambajh)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = bakl.a();
      this.jdField_a_of_type_Bakm = new bakm();
      this.jdField_a_of_type_Bakx = ((bakx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VOICE_ASSISTANT_MANAGER));
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Bajh = parambajh;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
    catch (Exception parambajh)
    {
      bakl.a("AudioUploadThread", "init exception:" + parambajh);
      parambajh.printStackTrace();
    }
  }
  
  private bali a(List<cmd67.ASRRecoRes> paramList, String paramString)
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
    bakl.a("AudioUploadThread", String.format("confirmSendInterval, resList:%s, wordsList:%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(((List)localObject1).size()) }));
    if (((List)localObject1).isEmpty()) {
      return null;
    }
    localObject2 = anvx.a(2131720024).trim();
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
        break label376;
      }
      j = m;
    }
    label376:
    for (;;)
    {
      if (((String)localObject2).endsWith((String)localObject4)) {
        i = k;
      }
      for (;;)
      {
        break;
        paramString = new bali(j, i, paramString);
        paramList.append(", header:").append(paramString.a).append(", tailor:").append(paramString.b);
        bakl.a("AudioUploadThread", paramList.toString());
        return paramString;
      }
    }
  }
  
  private ITransactionCallback a(bajd parambajd, String paramString)
  {
    return new bajb(this, paramString, parambajd);
  }
  
  private void a(bajd parambajd, byte[] paramArrayOfByte, long paramLong)
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
    bali localbali;
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
      localbali = a(paramArrayOfByte.reco_res.get(), str2);
      if ((j != 0) || (m != 0)) {
        break label516;
      }
    }
    label516:
    for (boolean bool2 = true;; bool2 = false)
    {
      bakl.a(bool2, this.jdField_b_of_type_JavaLangString, j, m, i1);
      if (!bool2) {
        bakl.a("AudioUploadThread", "onError, continue Upload, errCode:" + j + ", asrCode:" + m + ", nlpCode:" + i1);
      }
      bakl.a("AudioUploadThread", String.format("voiceId:%s, srvAckOffset:%s, retCode:%s, asrRetCode:%s, nlpRetCode:%s, dialStatus:%s, timeUsed1:%s, timeUsed2:%s contactCount:%s\ncontacts:%s, intents:%s, slots:%s, voiceText:%s", new Object[] { str2, Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i1), str3, Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(localList1.size()), Integer.valueOf(localList2.size()), Integer.valueOf(localList3.size()), str1 }));
      int i = 0;
      while (i < localList1.size())
      {
        paramArrayOfByte = (cmd67.UserInfo)localList1.get(i);
        bakl.a("AudioUploadThread", String.format("UserInfo[uin:%s, wei:%s, contact:%s]", new Object[] { Long.valueOf(paramArrayOfByte.uint64_uin.get()), Float.valueOf(paramArrayOfByte.float_weight.get()), paramArrayOfByte.str_matched_contacts.get() }));
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
        bakl.a("AudioUploadThread", String.format("[content:%s, confidence:%s, skill:%s, intent:%s]", new Object[] { paramArrayOfByte, Float.valueOf(f3), localIntent.str_skill.get(), localIntent.str_intent.get() }));
      }
    }
    boolean bool3 = a(str2, str1, paramArrayOfByte);
    this.jdField_b_of_type_JavaLangString = str2;
    this.jdField_c_of_type_JavaLangString = str1;
    this.jdField_d_of_type_JavaLangString = paramArrayOfByte;
    this.jdField_b_of_type_Int = n;
    bajl.a().a(parambajd, str2, str1, paramArrayOfByte, k);
    bajl.a().a(parambajd, f1, f2);
    bajl.a().a(parambajd, j, m, i1);
    if (baje.b(parambajd.jdField_b_of_type_Int)) {
      bakl.a(bajl.a().a(str2));
    }
    if ((bool2) && (!bool3)) {
      a(localList2, localList1, localList3, str3, localbali, f1, f2, str2, bool1);
    }
  }
  
  private void a(List<cmd67.Intent> paramList, List<cmd67.UserInfo> paramList1, List<cmd67.Slot> paramList2, String paramString1, bali parambali, float paramFloat1, float paramFloat2, String paramString2, boolean paramBoolean)
  {
    balh localbalh = new balh();
    if (paramList.size() > 0)
    {
      paramList = (cmd67.Intent)paramList.get(0);
      localbalh.jdField_c_of_type_JavaLangString = paramList.str_content.get();
      localbalh.jdField_d_of_type_JavaLangString = paramList.str_skill.get();
      localbalh.e = paramList.str_intent.get();
    }
    localbalh.jdField_a_of_type_JavaLangString = paramString2;
    localbalh.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localbalh.f = paramString1;
    localbalh.jdField_a_of_type_Float = paramFloat1;
    localbalh.jdField_b_of_type_Float = paramFloat2;
    localbalh.jdField_a_of_type_Boolean = paramBoolean;
    paramList = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      paramString1 = (cmd67.Slot)paramList2.next();
      localbalh.getClass();
      paramList.add(new balj(localbalh, paramString1.str_name.get(), paramString1.str_value.get(), paramString1.str_norm.get()));
    }
    localbalh.jdField_a_of_type_JavaUtilList = paramList;
    paramList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (cmd67.UserInfo)paramList1.next();
      paramList.add(new balk(paramList2.uint64_uin.get(), paramList2.str_matched_contacts.get(), paramList2.float_weight.get(), paramList2.uint32_chat_type.get()));
    }
    localbalh.jdField_b_of_type_JavaUtilList = paramList;
    localbalh.jdField_a_of_type_Bali = parambali;
    if (this.jdField_a_of_type_Bakm != null) {
      this.jdField_a_of_type_Bakm.a(localbalh);
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
          bakl.a("AudioUploadThread", "file size:" + localFile.length() + ", fixed md5:" + HexUtil.bytes2HexStr(arrayOfByte));
          return arrayOfByte;
        }
        paramString = bkvq.a(localFile);
        if (paramString != null)
        {
          paramString = HexUtil.hexStr2Bytes(paramString);
          bakl.a("AudioUploadThread", "file size:" + localFile.length() + ", fixed md5:" + HexUtil.bytes2HexStr(paramString));
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        bakl.a("AudioUploadThread", "fix file md5 failed...");
        return null;
      }
      paramString = "";
    }
  }
  
  protected int a(bajd parambajd)
  {
    int i = 1;
    if ((parambajd.jdField_a_of_type_ArrayOfByte == null) || (parambajd.jdField_a_of_type_Int <= 0))
    {
      bakl.a("AudioUploadThread", "slk encode failure, bean: " + parambajd.a());
      return 0;
    }
    Object localObject = a(parambajd);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      bakl.a("AudioUploadThread", "slk encode failure, bean: " + parambajd.a());
      return 0;
    }
    bajl.a().e(parambajd);
    if (this.jdField_a_of_type_Int == 1)
    {
      i = 2;
      if (!this.jdField_a_of_type_Bakx.a()) {
        break label265;
      }
      i = 2;
    }
    label265:
    for (;;)
    {
      boolean bool1 = baje.a(parambajd.jdField_b_of_type_Int);
      boolean bool2 = baje.b(parambajd.jdField_b_of_type_Int);
      cmd67.ReqBody localReqBody = a(parambajd.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), bool1, bool2, i);
      localObject = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 67, (String)localObject, 0, a((String)localObject), a(parambajd, (String)localObject), localReqBody.toByteArray(), false);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
      if (i != 0) {
        bakl.a("AudioUploadThread", "submitTransactionTask onError, retcode:" + i);
      }
      bajl.a().f(parambajd);
      return parambajd.jdField_a_of_type_Int;
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
    bakl.a("AudioUploadThread", "create req body, voiceId:" + paramString + ", offset:" + paramInt1 + ", isFir:" + paramBoolean1 + ", isEnd:" + paramBoolean2);
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
  
  protected String a(bajd parambajd)
  {
    if (parambajd != null) {
      try
      {
        if ((parambajd.jdField_a_of_type_ArrayOfByte != null) && (parambajd.jdField_a_of_type_Int > 0))
        {
          String str = bakl.a("out_" + parambajd.jdField_a_of_type_JavaLangString + "_" + parambajd.c, "slk");
          FileUtils.deleteFile(str);
          FileOutputStream localFileOutputStream = new FileOutputStream(str);
          if (baje.a(parambajd.jdField_b_of_type_Int))
          {
            bakl.a("AudioUploadThread", "write silk header:" + str);
            localFileOutputStream.write(bajh.jdField_a_of_type_ArrayOfByte);
          }
          localFileOutputStream.write(parambajd.jdField_a_of_type_ArrayOfByte, 0, parambajd.jdField_a_of_type_Int);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          return str;
        }
      }
      catch (IOException parambajd)
      {
        parambajd.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public void a()
  {
    String str = "interrupt AudioUploadThread";
    if (this.jdField_a_of_type_Bajh != null) {
      str = "interrupt AudioUploadThread" + ", buffer size:" + this.jdField_a_of_type_Bajh.a();
    }
    bakl.a("AudioUploadThread", str);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (isAlive()) {
      interrupt();
    }
  }
  
  public void run()
  {
    while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (this.jdField_a_of_type_Bajh.a() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 2)
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
        while (i < this.jdField_a_of_type_Bajh.a() - 2)
        {
          baje.a(this.jdField_a_of_type_Bajh.a(i), this.jdField_a_of_type_Bajh.a(i + 1));
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i + 1);
          i += 1;
        }
        i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        while (i < this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
        {
          bajd localbajd = this.jdField_a_of_type_Bajh.a(i);
          if (baje.a(localbajd.jdField_b_of_type_Int))
          {
            this.jdField_a_of_type_JavaLangString = localbajd.jdField_a_of_type_JavaLangString;
            this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
            this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          }
          localbajd.c = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          localbajd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          if (localbajd.b())
          {
            bakl.a("AudioUploadThread", String.format("transferBean: %s, Offset:%s", new Object[] { localbajd.a(), Integer.valueOf(this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) }));
            int j = a(localbajd);
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