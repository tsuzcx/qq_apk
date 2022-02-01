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
  private AtomicInteger a = new AtomicInteger(0);
  private AtomicInteger b = new AtomicInteger(0);
  private AtomicInteger c = new AtomicInteger(0);
  private AtomicInteger d = new AtomicInteger(0);
  private AtomicBoolean e = new AtomicBoolean(false);
  private volatile VoiceCacheHolder f;
  private volatile String g = AssistantUtils.e();
  private String h = "";
  private String i = "";
  private String j = "";
  private int k = -1;
  private int l = 0;
  private CommandDistributorHelper m;
  private IVoiceAssistantCore n;
  private IAudio2TextResultCallBack o;
  
  public AudioUploadThread(int paramInt, VoiceCacheHolder paramVoiceCacheHolder)
  {
    try
    {
      this.m = new CommandDistributorHelper();
      this.n = ((IVoiceAssistantCore)AssistantUtils.c().getRuntimeService(IVoiceAssistantCore.class, ""));
      this.k = paramInt;
      this.f = paramVoiceCacheHolder;
      this.e.set(true);
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
      int i1 = paramList.size();
      int i2 = 0;
      AssistantUtils.a("AudioUploadThread", String.format("confirmSendInterval, resList:%s, wordsList:%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(((List)localObject1).size()) }));
      if (((List)localObject1).isEmpty()) {
        return null;
      }
      localObject2 = AssistantUtils.a(2131917950);
      paramList = new StringBuilder("confirmSendInterval");
      localObject1 = ((List)localObject1).iterator();
      i1 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (cmd67.ASRWord)((Iterator)localObject1).next();
        localObject4 = ((cmd67.ASRWord)localObject3).word.get();
        ((cmd67.ASRWord)localObject3).confidence.get();
        int i5 = ((cmd67.ASRWord)localObject3).mbtm.get();
        int i4 = ((cmd67.ASRWord)localObject3).metm.get();
        paramList.append(", word_char:");
        paramList.append((String)localObject4);
        paramList.append(", mbtm:");
        paramList.append(i5);
        paramList.append(", metm:");
        paramList.append(i4);
        int i3 = i2;
        if (((String)localObject2).startsWith((String)localObject4)) {
          i3 = i5;
        }
        i2 = i3;
        if (((String)localObject2).endsWith((String)localObject4))
        {
          i1 = i4;
          i2 = i3;
        }
      }
      paramString = new ConfirmSendInfo(i2, i1, paramString);
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
    if ((paramVoiceBean1.g) && (paramVoiceBean2.g))
    {
      if (paramVoiceBean1.c != 3) {
        paramVoiceBean1.c = 0;
      }
      paramVoiceBean2.c = 0;
    }
    if ((paramVoiceBean1.g) && (!paramVoiceBean2.g)) {
      if (paramVoiceBean1.f())
      {
        if (paramVoiceBean1.c != 3) {
          paramVoiceBean1.c = 1;
        } else {
          paramVoiceBean1.c = 2;
        }
        paramVoiceBean2.c = 2;
      }
      else
      {
        paramVoiceBean1.c = 0;
        paramVoiceBean2.c = 1;
      }
    }
    if ((!paramVoiceBean1.g) && (paramVoiceBean2.g)) {
      if (paramVoiceBean1.c == 1)
      {
        paramVoiceBean2.c = 2;
      }
      else
      {
        paramVoiceBean1.c = 2;
        paramVoiceBean2.c = 3;
      }
    }
    if ((!paramVoiceBean1.g) && (!paramVoiceBean2.g))
    {
      if (paramVoiceBean1.c != 1) {
        paramVoiceBean1.c = 2;
      }
      paramVoiceBean2.c = 2;
    }
    VoiceTimeTraceUtil.a().d(paramVoiceBean1);
    VoiceTimeTraceUtil.a().d(paramVoiceBean2);
  }
  
  private void a(VoiceBean paramVoiceBean, byte[] paramArrayOfByte, long paramLong)
  {
    Object localObject1 = new cmd67.RspBody();
    ((cmd67.RspBody)localObject1).mergeFrom(paramArrayOfByte);
    Object localObject2 = (cmd67.VoiceAssistantResp)((cmd67.RspBody)localObject1).msg_voice_assistent_resp.get();
    int i3 = ((cmd67.VoiceAssistantResp)localObject2).int32_ret_code.get();
    int i4 = ((cmd67.VoiceAssistantResp)localObject2).int32_contact_count.get();
    localObject1 = ((cmd67.VoiceAssistantResp)localObject2).msg_user_info.get();
    paramArrayOfByte = (cmd67.VoiceAssistantASRResp)((cmd67.VoiceAssistantResp)localObject2).msg_asr_resp.get();
    int i5 = paramArrayOfByte.uint32_ret_code.get();
    String str1 = paramArrayOfByte.str_text.get();
    String str2 = paramArrayOfByte.str_voice_id.get();
    boolean bool1;
    if (paramArrayOfByte.uint32_is_final.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i6 = paramArrayOfByte.uint32_ack_offset.get();
    float f2 = paramArrayOfByte.time_use.get();
    Object localObject3 = (cmd67.VoiceAssistantNLPResp)((cmd67.VoiceAssistantResp)localObject2).msg_nlp_resp.get();
    int i1 = ((cmd67.VoiceAssistantNLPResp)localObject3).uint32_ret_code.get();
    localObject2 = ((cmd67.VoiceAssistantNLPResp)localObject3).msg_intents.get();
    List localList = ((cmd67.VoiceAssistantNLPResp)localObject3).msg_slots.get();
    String str3 = ((cmd67.VoiceAssistantNLPResp)localObject3).str_dialog_status.get();
    float f1 = ((cmd67.VoiceAssistantNLPResp)localObject3).time_use.get();
    localObject3 = a(paramArrayOfByte.reco_res.get(), str2);
    boolean bool2;
    if ((i3 == 0) && (i5 == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    AssistantUtils.a(bool2, this.h, i3, i5, i1);
    if (!bool2)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onError, continue Upload, errCode:");
      paramArrayOfByte.append(i3);
      paramArrayOfByte.append(", asrCode:");
      paramArrayOfByte.append(i5);
      paramArrayOfByte.append(", nlpCode:");
      paramArrayOfByte.append(i1);
      AssistantUtils.a("AudioUploadThread", paramArrayOfByte.toString());
    }
    AssistantUtils.a("AudioUploadThread", String.format("voiceId:%s, srvAckOffset:%s, retCode:%s, asrRetCode:%s, nlpRetCode:%s, dialStatus:%s, timeUsed1:%s, timeUsed2:%s contactCount:%s\ncontacts:%s, intents:%s, slots:%s, voiceText:%s", new Object[] { str2, Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i1), str3, Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(i4), Integer.valueOf(((List)localObject1).size()), Integer.valueOf(((List)localObject2).size()), Integer.valueOf(localList.size()), str1 }));
    int i2 = 0;
    while (i2 < ((List)localObject1).size())
    {
      paramArrayOfByte = (cmd67.UserInfo)((List)localObject1).get(i2);
      AssistantUtils.a("AudioUploadThread", String.format("UserInfo[uin:%s, wei:%s, contact:%s]", new Object[] { Long.valueOf(paramArrayOfByte.uint64_uin.get()), Float.valueOf(paramArrayOfByte.float_weight.get()), paramArrayOfByte.str_matched_contacts.get() }));
      i2 += 1;
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
    this.h = str2;
    this.i = str1;
    this.j = paramArrayOfByte;
    this.l = i6;
    VoiceTimeTraceUtil.a().a(paramVoiceBean, str2, str1, paramArrayOfByte, i4);
    VoiceTimeTraceUtil.a().a(paramVoiceBean, f2, f1);
    VoiceTimeTraceUtil.a().a(paramVoiceBean, i3, i5, i1);
    if (paramVoiceBean.b()) {
      AssistantUtils.a(VoiceTimeTraceUtil.a().a(str2));
    }
    if ((bool2) && (!bool3))
    {
      i1 = this.k;
      if ((i1 != 2) && (i1 != 1)) {
        break label789;
      }
      a((List)localObject2, (List)localObject1, localList, str3, (ConfirmSendInfo)localObject3, f2, f1, str2, bool1);
      label789:
      if (this.k == 4) {
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
      localVoiceAssistantRespInfo.c = paramList.str_content.get();
      localVoiceAssistantRespInfo.d = paramList.str_skill.get();
      localVoiceAssistantRespInfo.e = paramList.str_intent.get();
    }
    localVoiceAssistantRespInfo.a = paramString2;
    localVoiceAssistantRespInfo.b = this.i;
    localVoiceAssistantRespInfo.f = paramString1;
    localVoiceAssistantRespInfo.g = paramFloat1;
    localVoiceAssistantRespInfo.h = paramFloat2;
    localVoiceAssistantRespInfo.i = paramBoolean;
    paramList = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      paramString1 = (cmd67.Slot)paramList2.next();
      localVoiceAssistantRespInfo.getClass();
      paramList.add(new VoiceAssistantRespInfo.Slot(localVoiceAssistantRespInfo, paramString1.str_name.get(), paramString1.str_value.get(), paramString1.str_norm.get()));
    }
    localVoiceAssistantRespInfo.j = paramList;
    paramList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (cmd67.UserInfo)paramList1.next();
      paramList.add(new VoiceAssistantRespInfo.UserInfo(paramList2.uint64_uin.get(), paramList2.str_matched_contacts.get(), paramList2.float_weight.get(), paramList2.uint32_chat_type.get()));
    }
    localVoiceAssistantRespInfo.k = paramList;
    localVoiceAssistantRespInfo.l = paramConfirmSendInfo;
    paramList = this.m;
    if (paramList != null) {
      paramList.a(localVoiceAssistantRespInfo);
    }
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    return (this.h.equalsIgnoreCase(paramString1)) && (this.i.equalsIgnoreCase(paramString2)) && (this.j.equalsIgnoreCase(paramString3));
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
  
  private ITransactionCallback b(VoiceBean paramVoiceBean, String paramString)
  {
    return new AudioUploadThread.1(this, paramString, paramVoiceBean);
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
        if (paramVoiceBean.a != null)
        {
          if (paramVoiceBean.b <= 0) {
            return null;
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("out_");
          ((StringBuilder)localObject).append(paramVoiceBean.h);
          ((StringBuilder)localObject).append("_");
          ((StringBuilder)localObject).append(paramVoiceBean.d);
          localObject = AssistantUtils.b(((StringBuilder)localObject).toString(), "slk");
          FileUtils.deleteFile((String)localObject);
          FileOutputStream localFileOutputStream = new FileOutputStream((String)localObject);
          if (paramVoiceBean.a())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("write silk header:");
            localStringBuilder.append((String)localObject);
            AssistantUtils.a("AudioUploadThread", localStringBuilder.toString());
            localFileOutputStream.write(VoiceCacheHolder.a);
          }
          localFileOutputStream.write(paramVoiceBean.a, 0, paramVoiceBean.b);
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
    VoiceCacheHolder localVoiceCacheHolder = this.f;
    Object localObject = "interrupt AudioUploadThread";
    if (localVoiceCacheHolder != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("interrupt AudioUploadThread");
      ((StringBuilder)localObject).append(", buffer size:");
      ((StringBuilder)localObject).append(this.f.d());
      localObject = ((StringBuilder)localObject).toString();
    }
    AssistantUtils.a("AudioUploadThread", (String)localObject);
    this.e.set(false);
    if (isAlive()) {
      interrupt();
    }
  }
  
  public void a(VoiceBean paramVoiceBean, String paramString)
  {
    if (this.o != null)
    {
      paramVoiceBean = new Audio2TextResult(paramVoiceBean, paramString);
      this.o.a(paramVoiceBean);
    }
  }
  
  public void a(IAudio2TextResultCallBack paramIAudio2TextResultCallBack)
  {
    this.o = paramIAudio2TextResultCallBack;
  }
  
  protected int b(VoiceBean paramVoiceBean)
  {
    Object localObject1 = AssistantUtils.b();
    int i1 = 0;
    if (localObject1 == null)
    {
      AssistantUtils.a("AudioUploadThread", "transferBean when appInterface is null");
      return 0;
    }
    if ((paramVoiceBean.a != null) && (paramVoiceBean.b > 0))
    {
      Object localObject2 = a(paramVoiceBean);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("slk encode failure, bean: ");
        ((StringBuilder)localObject1).append(paramVoiceBean.c());
        AssistantUtils.a("AudioUploadThread", ((StringBuilder)localObject1).toString());
        return 0;
      }
      VoiceTimeTraceUtil.a().e(paramVoiceBean);
      int i2 = this.k;
      if (i2 == 1) {
        i1 = 2;
      } else if (i2 == 2) {
        i1 = 1;
      }
      if (this.n.isInSession()) {
        i1 = 2;
      }
      cmd67.ReqBody localReqBody = a(paramVoiceBean.h, this.d.get(), paramVoiceBean.a(), paramVoiceBean.b(), i1);
      localObject2 = new Transaction(AssistantUtils.c().getCurrentAccountUin(), 67, (String)localObject2, 0, a((String)localObject2), b(paramVoiceBean, (String)localObject2), localReqBody.toByteArray(), false);
      i1 = ((AppInterface)localObject1).getHwEngine().submitTransactionTask((Transaction)localObject2);
      if (i1 != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("submitTransactionTask onError, retcode:");
        ((StringBuilder)localObject1).append(i1);
        AssistantUtils.a("AudioUploadThread", ((StringBuilder)localObject1).toString());
      }
      VoiceTimeTraceUtil.a().f(paramVoiceBean);
      return paramVoiceBean.b;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("slk encode failure, bean: ");
    ((StringBuilder)localObject1).append(paramVoiceBean.c());
    AssistantUtils.a("AudioUploadThread", ((StringBuilder)localObject1).toString());
    return 0;
  }
  
  public void run()
  {
    while (this.e.get()) {
      if (this.f.d() - this.a.get() <= 2)
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
        int i1 = this.a.get();
        Object localObject;
        while (i1 < this.f.d() - 2)
        {
          localObject = this.f.a(i1);
          VoiceCacheHolder localVoiceCacheHolder = this.f;
          i1 += 1;
          a((VoiceBean)localObject, localVoiceCacheHolder.a(i1));
          this.a.set(i1);
        }
        i1 = this.b.get();
        while (i1 < this.a.get())
        {
          localObject = this.f.a(i1);
          if (((VoiceBean)localObject).a())
          {
            this.g = ((VoiceBean)localObject).h;
            this.d.set(0);
            this.c.set(0);
          }
          ((VoiceBean)localObject).d = this.c.getAndIncrement();
          ((VoiceBean)localObject).h = this.g;
          if (((VoiceBean)localObject).e())
          {
            AssistantUtils.a("AudioUploadThread", String.format("transferBean: %s, Offset:%s", new Object[] { ((VoiceBean)localObject).c(), Integer.valueOf(this.d.get()) }));
            int i2 = b((VoiceBean)localObject);
            localObject = this.d;
            ((AtomicInteger)localObject).set(((AtomicInteger)localObject).get() + i2);
          }
          localObject = this.b;
          i1 += 1;
          ((AtomicInteger)localObject).set(i1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioUploadThread
 * JD-Core Version:    0.7.0.1
 */