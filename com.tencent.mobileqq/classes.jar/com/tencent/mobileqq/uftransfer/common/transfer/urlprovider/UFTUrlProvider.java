package com.tencent.mobileqq.uftransfer.common.transfer.urlprovider;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTUrlProvider
{
  protected int a;
  protected long a;
  protected final IUFTRetryCallback a;
  protected final UFTHttpUrlProcessor a;
  protected UFTUrlProvider.UrlRetryContent a;
  protected String a;
  protected int b;
  protected boolean b;
  protected int c = 6;
  protected int d = 3;
  protected int e = 3;
  
  public UFTUrlProvider(AppRuntime paramAppRuntime, List<String> paramList, String paramString, long paramLong, boolean paramBoolean, IUFTRetryCallback paramIUFTRetryCallback)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent = new UFTUrlProvider.UrlRetryContent(this);
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTHttpUrlProcessor = new UFTHttpUrlProcessor(paramAppRuntime, paramList, paramString, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderIUFTRetryCallback = paramIUFTRetryCallback;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private String c()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTHttpUrlProcessor.a();
    if (str != null)
    {
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent.a();
    }
    return str;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    int i = 0;
    int j;
    do
    {
      str = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTHttpUrlProcessor.a();
      if (str == null) {
        break;
      }
      if (!TextUtils.isEmpty(str)) {
        break label41;
      }
      j = i + 1;
      i = j;
    } while (j < 8);
    String str = null;
    label41:
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_b_of_type_Boolean = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] initProvider init:");
    localStringBuilder.append(str);
    UFTLog.b("[UFTTransfer] UFTUrlProvider", 1, localStringBuilder.toString());
    return str;
  }
  
  protected String a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (a(paramInt))
    {
      localObject = c();
      if ((TextUtils.isEmpty((CharSequence)localObject)) && (a(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent)))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent, paramInt, paramBoolean);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append("] selectUrl:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent.toString());
        ((StringBuilder)localObject).append(" no more url, use cur errurl retry");
        UFTLog.b("[UFTTransfer] UFTUrlProvider", 1, ((StringBuilder)localObject).toString());
        return paramString;
      }
      return localObject;
    }
    if (a(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent, paramInt, paramBoolean);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] selectUrl:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent.toString());
      ((StringBuilder)localObject).append(" use cur errurl retry");
      UFTLog.b("[UFTTransfer] UFTUrlProvider", 1, ((StringBuilder)localObject).toString());
      return paramString;
    }
    return c();
  }
  
  protected void a(UFTUrlProvider.UrlRetryContent paramUrlRetryContent, int paramInt, boolean paramBoolean)
  {
    if (9056 == paramInt)
    {
      if (paramUrlRetryContent.jdField_b_of_type_Int < this.d)
      {
        paramUrlRetryContent.jdField_b_of_type_Int += 1;
      }
      else
      {
        paramUrlRetryContent.jdField_b_of_type_Int = 0;
        paramUrlRetryContent.jdField_a_of_type_Int += 1;
      }
    }
    else if (paramBoolean)
    {
      if (paramUrlRetryContent.c < this.e)
      {
        paramUrlRetryContent.c += 1;
      }
      else
      {
        paramUrlRetryContent.c = 0;
        paramUrlRetryContent.jdField_a_of_type_Int += 1;
      }
    }
    else {
      paramUrlRetryContent.jdField_a_of_type_Int += 1;
    }
    paramUrlRetryContent.d += 1;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equals(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent;
      paramString.jdField_a_of_type_Int = 0;
      paramString.jdField_b_of_type_Int = 0;
      paramString.jdField_a_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent.jdField_a_of_type_Boolean) {
      return false;
    }
    return (paramInt == 9052) || (paramInt == 9050) || (paramInt == 9055) || (paramInt == 9053) || (paramInt == 9054);
  }
  
  protected boolean a(UFTUrlProvider.UrlRetryContent paramUrlRetryContent)
  {
    if (paramUrlRetryContent == null) {
      return false;
    }
    return paramUrlRetryContent.jdField_a_of_type_Int < this.c;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      String str = a(paramString, paramInt, paramBoolean);
      if (TextUtils.isEmpty(str))
      {
        this.jdField_b_of_type_Boolean = true;
        paramString = new StringBuilder();
        paramString.append("[");
        paramString.append(this.jdField_a_of_type_Long);
        paramString.append("] reqUrlRetryOnErr fail. all retry over or has err. errCode:");
        paramString.append(paramInt);
        paramString.append(" svrRetryErr:");
        paramString.append(paramBoolean);
        paramString.append(b());
        UFTLog.d("[UFTTransfer] UFTUrlProvider", 1, paramString.toString());
        return false;
      }
      long l = 100L;
      if (9056 != paramInt) {
        l = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderIUFTRetryCallback.a();
      }
      UFTLogicThread.a().a(new UFTUrlProvider.1(this, str), l);
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Int += 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("] reqUrlRetryOnErr suc, delay:");
      localStringBuilder.append(l);
      localStringBuilder.append(" errCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" svrRetryErr:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" strErrUrl:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" selectUrl:");
      localStringBuilder.append(str);
      localStringBuilder.append(b());
      UFTLog.b("[UFTTransfer] UFTUrlProvider", 1, localStringBuilder.toString());
      return true;
    }
    this.jdField_b_of_type_Boolean = true;
    paramString = new StringBuilder();
    paramString.append("[");
    paramString.append(this.jdField_a_of_type_Long);
    paramString.append("] reqUrlRetryOnErr fail. strErrUrl is no match");
    UFTLog.d("[UFTTransfer] UFTUrlProvider", 1, paramString.toString());
    return false;
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("totalRetries:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" UrlChgedT:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUrlproviderUFTUrlProvider$UrlRetryContent.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider
 * JD-Core Version:    0.7.0.1
 */