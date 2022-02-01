package cooperation.weiyun.sdk.download;

import android.text.TextUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class DownloadJobContext
{
  private long jdField_a_of_type_Long;
  private HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  private final DownloadFile jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile;
  private final DownloadJobContext.StatusInfo jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobContext$StatusInfo;
  private WyDownloader.IDownloadStatusListener jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadStatusListener;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  
  private DownloadJobContext(String paramString1, String paramString2, DownloadFile paramDownloadFile, DownloadJobContext.StatusInfo paramStatusInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile = paramDownloadFile;
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobContext$StatusInfo = paramStatusInfo;
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
  
  public static DownloadJobContext a(String paramString1, DownloadFile paramDownloadFile, String paramString2, DownloadJobContext.StatusInfo paramStatusInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramDownloadFile == null) || (paramStatusInfo == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }
    return new DownloadJobContext(paramString1, IOUtils.getDirPathNoSeparator(paramString2), paramDownloadFile, paramStatusInfo);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public HttpNetReq a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  }
  
  public DownloadFile a()
  {
    return this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadFile;
  }
  
  public DownloadJobContext.StatusInfo a()
  {
    return this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobContext$StatusInfo;
  }
  
  public WyDownloader.IDownloadStatusListener a()
  {
    return this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadStatusListener;
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
  
  public void a(WyDownloader.IDownloadStatusListener paramIDownloadStatusListener)
  {
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadStatusListener = paramIDownloadStatusListener;
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
  
  public DownloadJobContext.StatusInfo b()
  {
    return this.jdField_a_of_type_CooperationWeiyunSdkDownloadDownloadJobContext$StatusInfo.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.DownloadJobContext
 * JD-Core Version:    0.7.0.1
 */