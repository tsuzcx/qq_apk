package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class SignatureManagerForTool
  extends Observable
{
  private static SignatureManagerForTool jdField_a_of_type_ComTencentMobileqqRichstatusSignatureManagerForTool;
  public RichStatus a;
  public EIPCResultCallback a;
  private ConcurrentHashMap<Integer, SignatureTemplateInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public RichStatus b;
  private EIPCResultCallback jdField_b_of_type_EipcEIPCResultCallback = new SignatureManagerForTool.2(this);
  private ConcurrentHashMap<Integer, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private SignatureManagerForTool()
  {
    this.jdField_a_of_type_EipcEIPCResultCallback = new SignatureManagerForTool.3(this);
  }
  
  public static SignatureManagerForTool a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqRichstatusSignatureManagerForTool == null) {
        jdField_a_of_type_ComTencentMobileqqRichstatusSignatureManagerForTool = new SignatureManagerForTool();
      }
      SignatureManagerForTool localSignatureManagerForTool = jdField_a_of_type_ComTencentMobileqqRichstatusSignatureManagerForTool;
      return localSignatureManagerForTool;
    }
    finally {}
  }
  
  public static String a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://gxh.vip.qq.com/xydata/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public SignatureTemplateInfo a(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public SignatureTemplateInfo a(int paramInt, boolean paramBoolean)
  {
    SignatureTemplateInfo localSignatureTemplateInfo2 = (SignatureTemplateInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject;
    if ((localSignatureTemplateInfo2 != null) && (!localSignatureTemplateInfo2.a.get()))
    {
      localObject = localSignatureTemplateInfo2;
      if (!paramBoolean) {}
    }
    else
    {
      SignatureTemplateInfo localSignatureTemplateInfo1 = localSignatureTemplateInfo2;
      if (localSignatureTemplateInfo2 == null)
      {
        localSignatureTemplateInfo1 = new SignatureTemplateInfo(Integer.toString(paramInt));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localSignatureTemplateInfo1);
      }
      localObject = localSignatureTemplateInfo1;
      if (paramInt != 0)
      {
        localSignatureTemplateInfo1.a.set(true);
        if (QLog.isColorLevel()) {
          QLog.e("Signature.TOOL", 2, "before getTemplateInfo info");
        }
        ThreadManager.excute(new SignatureManagerForTool.1(this, paramInt), 128, null, true);
        localObject = localSignatureTemplateInfo1;
      }
    }
    return localObject;
  }
  
  public String a(int paramInt)
  {
    String str = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", paramInt);
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.g, localBundle, this.jdField_b_of_type_EipcEIPCResultCallback);
    }
    return str;
  }
  
  public void a(RichStatus paramRichStatus)
  {
    if (paramRichStatus == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(paramRichStatus);
    paramRichStatus = new StringBuilder();
    paramRichStatus.append("updateHandleStatus: tpdId=");
    paramRichStatus.append(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    paramRichStatus.append(" fontId=");
    paramRichStatus.append(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId);
    QLog.d("Signature.TOOL", 2, paramRichStatus.toString());
  }
  
  public void b(RichStatus paramRichStatus)
  {
    if (paramRichStatus == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(paramRichStatus);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSaveStatus: tpdId=");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    localStringBuilder.append(" fontId=");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus.fontId);
    QLog.d("Signature.TOOL", 2, localStringBuilder.toString());
    a(paramRichStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureManagerForTool
 * JD-Core Version:    0.7.0.1
 */