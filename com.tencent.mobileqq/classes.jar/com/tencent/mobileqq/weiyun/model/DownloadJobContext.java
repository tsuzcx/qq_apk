package com.tencent.mobileqq.weiyun.model;

import android.text.TextUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class DownloadJobContext
{
  private long jdField_a_of_type_Long;
  private HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  private IDownloadStatusListener jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIDownloadStatusListener;
  private final DownloadFile jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile;
  private final WeiyunDownloadStatusInfo jdField_a_of_type_ComTencentMobileqqWeiyunModelWeiyunDownloadStatusInfo;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  
  private DownloadJobContext(String paramString1, String paramString2, DownloadFile paramDownloadFile, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile = paramDownloadFile;
    this.jdField_a_of_type_ComTencentMobileqqWeiyunModelWeiyunDownloadStatusInfo = paramWeiyunDownloadStatusInfo;
  }
  
  public static HttpNetReq a(Object paramObject, String paramString1, String paramString2, String paramString3, boolean paramBoolean, INetEngineListener paramINetEngineListener)
  {
    return a(paramObject, paramString1, paramString2, paramString3, paramBoolean, paramINetEngineListener, null);
  }
  
  public static HttpNetReq a(Object paramObject, String paramString1, String paramString2, String paramString3, boolean paramBoolean, INetEngineListener paramINetEngineListener, String paramString4)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = paramINetEngineListener;
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localHttpNetReq.mReqProperties = new HashMap();
      localHttpNetReq.mReqProperties.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHttpNetReq.mTempPath = paramString4;
    }
    localHttpNetReq.mOutPath = paramString2;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.setUserData(paramObject);
    localHttpNetReq.mSupportBreakResume = paramBoolean;
    return localHttpNetReq;
  }
  
  public static DownloadJobContext a(String paramString1, DownloadFile paramDownloadFile, String paramString2, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramDownloadFile != null) && (paramWeiyunDownloadStatusInfo != null)) {
      return new DownloadJobContext(paramString1, IOUtils.getDirPathNoSeparator(paramString2), paramDownloadFile, paramWeiyunDownloadStatusInfo);
    }
    throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public HttpNetReq a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  }
  
  public IDownloadStatusListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIDownloadStatusListener;
  }
  
  public DownloadFile a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile;
  }
  
  public WeiyunDownloadStatusInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWeiyunModelWeiyunDownloadStatusInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(HttpNetReq paramHttpNetReq)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = paramHttpNetReq;
  }
  
  public void a(IDownloadStatusListener paramIDownloadStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIDownloadStatusListener = paramIDownloadStatusListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public WeiyunDownloadStatusInfo b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWeiyunModelWeiyunDownloadStatusInfo.a();
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.model.DownloadJobContext
 * JD-Core Version:    0.7.0.1
 */