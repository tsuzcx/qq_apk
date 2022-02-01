package com.tencent.mobileqq.ocr.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.Group;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.ResultItem;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SearchResult;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.ocr.OcrImageUtil;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.OcrDpc;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.OCRAccountUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class OCRServiceImpl
  implements IOCRService
{
  public static final int MAX_SOUGOU_SEARCHKEY_LENGTH = 300;
  private static final String PREF_AIO_SUPPORT = "is_aio_support";
  private static final String PREF_AIO_TEXT = "ocr_aio_text";
  private static final String PREF_CHAT_FILE_SUPPORT = "is_chat_file_support";
  private static final String PREF_QUESTION_RESULT_ENTER = "question_result_enter";
  private static final String PREF_QUESTION_SCAN_ENTER = "question_scan_enter";
  private static final String PREF_QZONE_SUPPORT = "is_qzone_support";
  private static final String PREF_SCAN_SUPPORT = "is_scan_support";
  private static final String SP_OCR = "ocr";
  private static final String TAG = "Q.ocr.OCRServiceImpl";
  private Object lock = new Object();
  public AppInterface mApp = null;
  EntityManager mEntityManager;
  public OcrConfig mOcrConfig;
  OCRObserver ocrObserver = new OCRServiceImpl.2(this);
  
  public static boolean isSupportQuestionResultEnter(String paramString)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("ocr");
    boolean bool = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).getBoolean("question_result_enter", false);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isSupportQuestionResultEnter:");
      paramString.append(bool);
      QLog.d("Q.ocr.OCRServiceImpl", 2, paramString.toString());
    }
    return bool;
  }
  
  public static boolean isSupportQuestionScanEnter(String paramString)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("ocr");
    boolean bool = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).getBoolean("question_scan_enter", false);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isSupportQuestionScanEnter:");
      paramString.append(bool);
      QLog.d("Q.ocr.OCRServiceImpl", 2, paramString.toString());
    }
    return bool;
  }
  
  public static void updateConfigToSp(String paramString, OcrConfig paramOcrConfig)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("ocr");
    paramString = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4).edit();
    boolean bool2 = false;
    if (paramOcrConfig == null)
    {
      paramString.putBoolean("is_aio_support", false);
      paramString.putBoolean("is_chat_file_support", false);
      paramString.putBoolean("is_qzone_support", false);
      paramString.putBoolean("is_scan_support", false);
      paramString.putBoolean("question_result_enter", false);
      paramString.putBoolean("question_scan_enter", false);
      paramString.putString("ocr_aio_text", "");
    }
    else
    {
      if (paramOcrConfig.aioOcrOpen == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramString.putBoolean("is_aio_support", bool1);
      if (paramOcrConfig.chatFileOcrOpen == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramString.putBoolean("is_chat_file_support", bool1);
      if (paramOcrConfig.qzoneOcrOpen == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramString.putBoolean("is_qzone_support", bool1);
      if (paramOcrConfig.scanOcrOpen == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramString.putBoolean("is_scan_support", bool1);
      if (!TextUtils.isEmpty(paramOcrConfig.iconText)) {
        paramString.putString("ocr_aio_text", paramOcrConfig.aioText);
      }
      if (paramOcrConfig.questionResultOpen == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramString.putBoolean("question_result_enter", bool1);
      boolean bool1 = bool2;
      if (paramOcrConfig.questionScanOpen == 1) {
        bool1 = true;
      }
      paramString.putBoolean("question_scan_enter", bool1);
    }
    paramString.commit();
  }
  
  public OCRTextSearchInfo.SearchResult constructTextRearchResult(List<OCRTextSearchInfo.SougouSearchInfo> paramList)
  {
    OCRTextSearchInfo.SearchResult localSearchResult = new OCRTextSearchInfo.SearchResult();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localSearchResult.a = new ArrayList();
      OCRTextSearchInfo.Group localGroup = new OCRTextSearchInfo.Group();
      localGroup.b = 2049;
      localGroup.a = HardCodeUtil.a(2131905632);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)paramList.next();
        OCRTextSearchInfo.ResultItem localResultItem = new OCRTextSearchInfo.ResultItem();
        localResultItem.a = localSougouSearchInfo;
        localGroup.e.add(localResultItem);
      }
      localSearchResult.a.add(localGroup);
    }
    return localSearchResult;
  }
  
  public void doSougouSearch(String paramString1, String paramString2, long paramLong)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      paramString2 = this.mApp;
      if (paramString2 == null) {
        return;
      }
      ((OCRHandler)paramString2.getBusinessHandler(OCRHandler.a)).notifyUI(3, false, new Object[] { Integer.valueOf(-2), paramString1, null });
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      String str = paramString2;
      if (paramString2.length() > 300) {
        str = paramString2.substring(0, 300);
      }
      paramString2 = this.mApp;
      if (paramString2 != null) {
        ((OCRHandler)paramString2.getBusinessHandler(OCRHandler.a)).a(paramString1, str, paramLong);
      }
    }
  }
  
  public OcrRecogResult findCache(String paramString)
  {
    OcrRecogResult localOcrRecogResult = OcrRecogResult.find(this.mEntityManager, paramString);
    if (localOcrRecogResult != null)
    {
      if (new File(paramString).lastModified() > localOcrRecogResult.saveTime)
      {
        OcrRecogResult.remove(this.mEntityManager, paramString);
        return null;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("findCache ");
        paramString.append(localOcrRecogResult);
        QLog.d("Q.ocr.OCRServiceImpl", 2, paramString.toString());
      }
      return localOcrRecogResult;
    }
    return null;
  }
  
  public String generateTextSearchSessionID()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OCRAccountUtil.a());
    localStringBuilder.append("_");
    localStringBuilder.append(SystemClock.uptimeMillis());
    return localStringBuilder.toString();
  }
  
  public String getAIOText(String paramString)
  {
    Object localObject = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("ocr");
    paramString = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 4).getString("ocr_aio_text", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAIOText ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.ocr", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public int getConfigVersion()
  {
    Object localObject = getOCRConfig(true);
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((OcrConfig)localObject).version;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getConfigVersion:");
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.ocr.OCRServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public OcrConfig getOCRConfig(boolean paramBoolean)
  {
    if ((this.mOcrConfig == null) && (paramBoolean))
    {
      loadConfigFromFile();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getOCRConfig:");
        localStringBuilder.append(this.mOcrConfig);
        QLog.d("Q.ocr.OCRServiceImpl", 2, localStringBuilder.toString());
      }
    }
    return this.mOcrConfig;
  }
  
  public boolean isQZoneSupportOcr(String paramString)
  {
    return isSupportOcr(paramString, 2);
  }
  
  public boolean isSupportOcr(String paramString, int paramInt)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool4 = false;
    if (bool1) {
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("ocr");
    localObject = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    if (paramInt == 1) {
      bool1 = ((SharedPreferences)localObject).getBoolean("is_aio_support", false);
    } else if (paramInt == 2) {
      bool1 = ((SharedPreferences)localObject).getBoolean("is_qzone_support", false);
    } else if (paramInt == 0) {
      bool1 = ((SharedPreferences)localObject).getBoolean("is_scan_support", false);
    } else if (paramInt == 7) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (OcrDpc.b().c == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportOcr, uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("form:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",isSupport:");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(",dpcSwitch:");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(",sdcard:");
      ((StringBuilder)localObject).append(OcrImageUtil.d);
      QLog.d("Q.ocr", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool3 = bool4;
    if (bool1)
    {
      bool3 = bool4;
      if (bool2)
      {
        bool3 = bool4;
        if (OcrImageUtil.d) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public void loadConfigFromFile()
  {
    synchronized (this.lock)
    {
      if ((this.mOcrConfig == null) && (this.mApp != null))
      {
        this.mOcrConfig = OcrConfig.readFromFile(this.mApp.getCurrentAccountUin());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadConfigFromFile,mOcrConfig =   ");
          localStringBuilder.append(this.mOcrConfig);
          QLog.d("Q.ocr.OCRServiceImpl", 2, localStringBuilder.toString());
        }
        if (this.mOcrConfig != null) {
          updateConfigToSp(this.mApp.getCurrentAccountUin(), this.mOcrConfig);
        }
      }
      return;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface))
    {
      this.mApp = ((AppInterface)paramAppRuntime);
      this.mApp.addDefaultObservers(this.ocrObserver);
      this.mEntityManager = paramAppRuntime.getEntityManagerFactory().createEntityManager();
      ThreadManager.post(new OCRServiceImpl.1(this), 5, null, false);
    }
  }
  
  public void onDestroy()
  {
    AppInterface localAppInterface = this.mApp;
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.ocrObserver);
    }
    this.mOcrConfig = null;
  }
  
  public void onGetOCRConfig(boolean paramBoolean, OcrConfig paramOcrConfig)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onGetOCRConfig, isSucc=");
        ((StringBuilder)???).append(paramBoolean);
        ((StringBuilder)???).append(", config = ");
        ((StringBuilder)???).append(paramOcrConfig);
        QLog.d("Q.ocr.OCRServiceImpl", 2, ((StringBuilder)???).toString());
      }
      if (paramBoolean) {
        synchronized (this.lock)
        {
          this.mOcrConfig = paramOcrConfig;
          if (this.mApp != null) {
            updateConfigToSp(this.mApp.getCurrentAccountUin(), this.mOcrConfig);
          }
        }
      }
      ThreadManager.post(new OCRServiceImpl.3(this, paramBoolean), 8, null, false);
      return;
    }
    finally {}
  }
  
  public void updateCache(OcrRecogResult paramOcrRecogResult)
  {
    if ((paramOcrRecogResult != null) && (!TextUtils.isEmpty(paramOcrRecogResult.filename)))
    {
      paramOcrRecogResult.saveTime = System.currentTimeMillis();
      OcrRecogResult.persistOrReplace(this.mEntityManager, paramOcrRecogResult);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateCache ");
        localStringBuilder.append(paramOcrRecogResult.filename);
        QLog.d("Q.ocr.OCRServiceImpl", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.OCRServiceImpl
 * JD-Core Version:    0.7.0.1
 */