package dov.com.qq.im.ae.download.old;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AEOldShortVideoResDownload
  implements AEOldShortVideoResStatus.ISVConfig
{
  private static String jdField_a_of_type_JavaLangString = "AEOldShortVideoResDownload_";
  private static ConcurrentHashMap<Integer, AEOldShortVideoResDownload> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public int a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AEOldShortVideoResDownload.ResDownloadCallBack jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload$ResDownloadCallBack;
  boolean jdField_a_of_type_Boolean;
  
  private AEOldShortVideoResDownload(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(jdField_a_of_type_JavaLangString);
    paramQQAppInterface.append(this.jdField_a_of_type_Int);
    jdField_a_of_type_JavaLangString = paramQQAppInterface.toString();
    this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload$ResDownloadCallBack = new AEOldShortVideoResDownload.ResDownloadCallBack(jdField_a_of_type_JavaLangString, this);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a()
  {
    ConcurrentHashMap localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, @Nullable AEOldShortVideoResStatus.ISVConfig_V2 paramISVConfig_V2)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLogin] - BEGIN -");
    boolean bool = VideoEnvironment.supportShortVideoRecordAndPlay();
    if (!bool)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (paramISVConfig_V2 != null) {
        paramISVConfig_V2.b(-1, -6);
      }
      paramQQAppInterface = jdField_a_of_type_JavaLangString;
      paramISVConfig_V2 = new StringBuilder();
      paramISVConfig_V2.append("[startDownload215ConfigWithoutLogin] - END -, supportShortVideo=");
      paramISVConfig_V2.append(bool);
      AEQLog.b(paramQQAppInterface, paramISVConfig_V2.toString());
      return;
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 3)
    {
      if (paramISVConfig_V2 != null) {
        paramISVConfig_V2.b(-1, -1);
      }
      paramQQAppInterface = jdField_a_of_type_JavaLangString;
      paramISVConfig_V2 = new StringBuilder();
      paramISVConfig_V2.append("[startDownload215ConfigWithoutLogin] - END -, reach to max session size=");
      paramISVConfig_V2.append(jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      AEQLog.b(paramQQAppInterface, paramISVConfig_V2.toString());
      return;
    }
    paramQQAppInterface = new AEOldShortVideoResDownload(paramQQAppInterface, true);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int), paramQQAppInterface);
    paramQQAppInterface.a(paramISVConfig_V2);
    AEQLog.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLogin] - END -");
  }
  
  private void a(@Nullable AEOldShortVideoResStatus.ISVConfig_V2 paramISVConfig_V2)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLoginInternal] - BEGIN -");
    AEOldShortVideoResManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new AEOldShortVideoResDownload.2(this, paramISVConfig_V2));
    AEQLog.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLoginInternal] - END -");
  }
  
  private boolean a()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131713970), null);
      AEOldShortVideoResManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return bool;
    }
    VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131713909), null);
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    try
    {
      if (!VideoEnvironment.supportShortVideoRecordAndPlay())
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        return false;
      }
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 3)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("reach to max session size=");
        paramQQAppInterface.append(jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        VideoEnvironment.LogDownLoad("ShortVideoResDownload", paramQQAppInterface.toString(), null);
        return false;
      }
      paramQQAppInterface = new AEOldShortVideoResDownload(paramQQAppInterface, paramBoolean);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int), paramQQAppInterface);
      paramBoolean = paramQQAppInterface.a();
      if (!paramBoolean) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int));
      }
      return paramBoolean;
    }
    finally {}
  }
  
  private static void b(AEOldShortVideoResDownload paramAEOldShortVideoResDownload)
  {
    if (paramAEOldShortVideoResDownload != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramAEOldShortVideoResDownload.jdField_a_of_type_Int));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onConfigResult | result=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(",serverError=");
    ((StringBuilder)localObject2).append(paramInt2);
    VideoEnvironment.LogDownLoad((String)localObject1, ((StringBuilder)localObject2).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onConfigResult| result= RESULT_FAILED error=");
      ((StringBuilder)localObject2).append(paramInt2);
      VideoEnvironment.LogDownLoad((String)localObject1, ((StringBuilder)localObject2).toString(), null);
      b(this);
      return;
    }
    if (paramInt2 != 0)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onConfigResult| uncompress config error=");
      ((StringBuilder)localObject2).append(paramInt2);
      VideoEnvironment.LogDownLoad((String)localObject1, ((StringBuilder)localObject2).toString(), null);
      b(this);
      return;
    }
    localObject1 = new ArrayList(1);
    paramInt1 = AEOldShortVideoResManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject1);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| check config success...", null);
      localObject2 = this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload$ResDownloadCallBack;
      ((AEOldShortVideoResDownload.ResDownloadCallBack)localObject2).jdField_a_of_type_Boolean = false;
      AEOldShortVideoResManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject1, (AEOldShortVideoResManager.INet_ShortVideoResource)localObject2);
      VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| mDownloadFilterSo=false", null);
      if ((this.jdField_a_of_type_Boolean) && (PtvFilterSoLoad.c()))
      {
        localObject2 = this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload$ResDownloadCallBack;
        ((AEOldShortVideoResDownload.ResDownloadCallBack)localObject2).b = false;
        AEOldShortVideoResManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject1, (AEOldShortVideoResManager.INet_ShortVideoResource)localObject2);
      }
      this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload$ResDownloadCallBack.b();
      return;
    }
    localObject1 = jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onConfigResult| check config error=");
    ((StringBuilder)localObject2).append(paramInt1);
    VideoEnvironment.LogDownLoad((String)localObject1, ((StringBuilder)localObject2).toString(), null);
    b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResDownload
 * JD-Core Version:    0.7.0.1
 */