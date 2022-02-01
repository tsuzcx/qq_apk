package com.tencent.mobileqq.ocr.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.gallery.picocr.PicOrcUtils;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.ocr.api.IPicOcrService;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.OCRAccountUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import mqq.app.AppRuntime;

public class PicOcrServiceImpl
  implements IPicOcrService
{
  public static final int CACHE_SIZE = 10;
  public static final String TAG = "PicOcrServiceImpl";
  boolean addHandler = false;
  private AppInterface mApp;
  protected ITransFileController mFileController;
  private OCRReqContext mReqContext;
  private HashMap<String, PicOcrRspResult> mResultCache = new HashMap();
  protected TransProcessorHandler mTransProcessorHandler = new PicOcrServiceImpl.1(this, ThreadManager.getSubThreadLooper());
  protected String uin;
  
  private void tryCompressIfNeeded(PicOcrObserver paramPicOcrObserver, OCRReqContext paramOCRReqContext)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramOCRReqContext.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
    int k = ((BitmapFactory.Options)localObject1).outWidth;
    int m = ((BitmapFactory.Options)localObject1).outHeight;
    paramPicOcrObserver = new File(paramOCRReqContext.jdField_b_of_type_JavaLangString);
    long l = paramPicOcrObserver.length();
    int j = 0;
    int i;
    if (l < 6750000L)
    {
      paramOCRReqContext.a = paramPicOcrObserver.length();
      paramOCRReqContext.jdField_b_of_type_Int = ((BitmapFactory.Options)localObject1).outWidth;
      paramOCRReqContext.jdField_c_of_type_Int = ((BitmapFactory.Options)localObject1).outHeight;
      paramOCRReqContext.e = paramOCRReqContext.d;
      paramOCRReqContext.jdField_c_of_type_JavaLangString = paramOCRReqContext.jdField_b_of_type_JavaLangString;
      i = j;
    }
    else
    {
      if (l > 13500000L) {
        i = 2;
      } else {
        i = 1;
      }
      ((BitmapFactory.Options)localObject1).inSampleSize = i;
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      localObject1 = PicOrcUtils.a(paramOCRReqContext.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject1, 1, 4);
      i = j;
      if (localObject1 != null)
      {
        Object localObject2 = new int[2];
        paramOCRReqContext.jdField_c_of_type_JavaLangString = PicOrcUtils.a((Bitmap)localObject1, paramOCRReqContext.jdField_b_of_type_JavaLangString, (int[])localObject2);
        i = j;
        if (FileUtils.fileExistsAndNotEmpty(paramOCRReqContext.jdField_c_of_type_JavaLangString))
        {
          paramOCRReqContext.jdField_b_of_type_Int = localObject2[0];
          paramOCRReqContext.jdField_c_of_type_Int = localObject2[1];
          paramOCRReqContext.a = new File(paramOCRReqContext.jdField_c_of_type_JavaLangString).length();
          paramOCRReqContext.e = PicOrcUtils.a(paramOCRReqContext.jdField_c_of_type_JavaLangString);
          localObject1 = new HashMap();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramPicOcrObserver.length() / 1024L);
          ((StringBuilder)localObject2).append("");
          ((HashMap)localObject1).put("param_length", ((StringBuilder)localObject2).toString());
          ((HashMap)localObject1).put("param_width", String.valueOf(k));
          ((HashMap)localObject1).put("param_height", String.valueOf(m));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(k * m);
          ((StringBuilder)localObject2).append("");
          ((HashMap)localObject1).put("param_size", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramOCRReqContext.a / 1024L);
          ((StringBuilder)localObject2).append("");
          ((HashMap)localObject1).put("param_complength", ((StringBuilder)localObject2).toString());
          ((HashMap)localObject1).put("param_compwidth", String.valueOf(paramOCRReqContext.jdField_b_of_type_Int));
          ((HashMap)localObject1).put("param_compheight", String.valueOf(paramOCRReqContext.jdField_c_of_type_Int));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramOCRReqContext.jdField_b_of_type_Int * paramOCRReqContext.jdField_c_of_type_Int);
          ((StringBuilder)localObject2).append("");
          ((HashMap)localObject1).put("param_compsize", ((StringBuilder)localObject2).toString());
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject1, "");
          i = 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tryCompressIfNeeded:");
      ((StringBuilder)localObject1).append(paramOCRReqContext.a());
      ((StringBuilder)localObject1).append(", oriLength:");
      ((StringBuilder)localObject1).append(paramPicOcrObserver.length() / 1024L);
      ((StringBuilder)localObject1).append(", oriSize:[");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append("*");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append("]");
      QLog.e("PicOcrServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    paramOCRReqContext = new HashMap();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append("");
    paramOCRReqContext.put("param_type", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramPicOcrObserver.length() / 1024L);
    ((StringBuilder)localObject1).append("");
    paramOCRReqContext.put("param_length", ((StringBuilder)localObject1).toString());
    paramOCRReqContext.put("param_width", String.valueOf(k));
    paramOCRReqContext.put("param_height", String.valueOf(m));
    paramPicOcrObserver = new StringBuilder();
    paramPicOcrObserver.append(k * m);
    paramPicOcrObserver.append("");
    paramOCRReqContext.put("param_size", paramPicOcrObserver.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressType", true, 0L, 0L, paramOCRReqContext, "");
  }
  
  public PicOcrRspResult getCacheOcrResult(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mResultCache.containsKey(paramString))) {
      return (PicOcrRspResult)this.mResultCache.get(paramString);
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mFileController = ((ITransFileController)paramAppRuntime.getRuntimeService(ITransFileController.class, ""));
    if ((paramAppRuntime instanceof AppInterface)) {
      this.mApp = ((AppInterface)paramAppRuntime);
    }
    this.uin = OCRAccountUtil.a();
  }
  
  public void onDestroy()
  {
    ITransFileController localITransFileController = this.mFileController;
    if (localITransFileController != null)
    {
      localITransFileController.removeHandle(this.mTransProcessorHandler);
      this.mTransProcessorHandler = null;
    }
  }
  
  public void putOcrResult(String paramString, PicOcrRspResult paramPicOcrRspResult)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.mResultCache.size() >= 10)
    {
      Iterator localIterator = this.mResultCache.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!str.equals(paramString)) {
          break label69;
        }
      }
      String str = "";
      label69:
      this.mResultCache.remove(str);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramPicOcrRspResult != null)) {
      this.mResultCache.put(paramString, paramPicOcrRspResult);
    }
  }
  
  public void requestOcr(OCRReqContext paramOCRReqContext, PicOcrObserver paramPicOcrObserver)
  {
    ThreadManager.excute(new PicOcrServiceImpl.3(this, paramOCRReqContext, paramPicOcrObserver), 64, null, true);
  }
  
  public void uploadOcrPic(PicOcrObserver paramPicOcrObserver, OCRReqContext paramOCRReqContext)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrServiceImpl", 2, "uploadOcrPic NetWork exception!");
      }
      paramPicOcrObserver.onUpdate(100, false, new PicOcrRspResult());
      return;
    }
    this.mReqContext = paramOCRReqContext;
    if (!this.addHandler)
    {
      localObject = this.mTransProcessorHandler;
      if ((localObject != null) && (this.mFileController != null))
      {
        ((TransProcessorHandler)localObject).addFilter(new Class[] { BDHCommonUploadProcessor.class });
        this.mFileController.addHandle(this.mTransProcessorHandler);
        this.addHandler = true;
      }
    }
    paramOCRReqContext.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uploadOcrPic:");
      ((StringBuilder)localObject).append(paramOCRReqContext.a());
      QLog.i("PicOcrServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new PicOcrServiceImpl.2(this, paramPicOcrObserver, paramOCRReqContext);
    paramPicOcrObserver = new TransferRequest();
    paramPicOcrObserver.mFileType = 24;
    paramPicOcrObserver.mCommandId = 76;
    paramPicOcrObserver.mRichTag = "picorcupload";
    paramPicOcrObserver.mUpCallBack = ((UpCallBack)localObject);
    paramPicOcrObserver.mLocalPath = paramOCRReqContext.jdField_c_of_type_JavaLangString;
    localObject = this.uin;
    paramPicOcrObserver.mSelfUin = ((String)localObject);
    paramPicOcrObserver.mPeerUin = ((String)localObject);
    paramPicOcrObserver.mUniseq = paramOCRReqContext.jdField_b_of_type_Long;
    paramPicOcrObserver.mIsUp = true;
    paramOCRReqContext = new Bdh_extinfo.CommFileExtReq();
    paramOCRReqContext.uint32_action_type.set(0);
    paramOCRReqContext.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
    paramPicOcrObserver.mExtentionInfo = paramOCRReqContext.toByteArray();
    paramOCRReqContext = this.mFileController;
    if (paramOCRReqContext != null) {
      paramOCRReqContext.transferAsync(paramPicOcrObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.PicOcrServiceImpl
 * JD-Core Version:    0.7.0.1
 */