package com.tencent.mobileqq.gallery.picocr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import mqq.manager.Manager;

public class PicOcrManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PicOcrManager.OCRReqContext jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext;
  protected TransProcessorHandler a;
  protected ITransFileController a;
  protected String a;
  private HashMap<String, PicOcrRspResult> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  
  public PicOcrManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new PicOcrManager.1(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
  }
  
  private void b(PicOcrObserver paramPicOcrObserver, PicOcrManager.OCRReqContext paramOCRReqContext)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramOCRReqContext.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    paramPicOcrObserver = new File(paramOCRReqContext.jdField_b_of_type_JavaLangString);
    long l = paramPicOcrObserver.length();
    int i;
    if (l < 6750000L)
    {
      paramOCRReqContext.a = paramPicOcrObserver.length();
      paramOCRReqContext.jdField_b_of_type_Int = ((BitmapFactory.Options)localObject).outWidth;
      paramOCRReqContext.jdField_c_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      paramOCRReqContext.e = paramOCRReqContext.d;
      paramOCRReqContext.jdField_c_of_type_JavaLangString = paramOCRReqContext.jdField_b_of_type_JavaLangString;
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "tryCompressIfNeeded:" + paramOCRReqContext.a() + ", oriLength:" + paramPicOcrObserver.length() / 1024L + ", oriSize:[" + j + "*" + k + "]");
      }
      paramOCRReqContext = new HashMap();
      paramOCRReqContext.put("param_type", i + "");
      paramOCRReqContext.put("param_length", paramPicOcrObserver.length() / 1024L + "");
      paramOCRReqContext.put("param_width", String.valueOf(j));
      paramOCRReqContext.put("param_height", String.valueOf(k));
      paramOCRReqContext.put("param_size", j * k + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressType", true, 0L, 0L, paramOCRReqContext, "");
      return;
      if (l > 13500000L) {}
      for (i = 2;; i = 1)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = PicOrcUtils.a(paramOCRReqContext.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject, 1, 4);
        if (localObject == null) {
          break label671;
        }
        int[] arrayOfInt = new int[2];
        paramOCRReqContext.jdField_c_of_type_JavaLangString = PicOrcUtils.a((Bitmap)localObject, paramOCRReqContext.jdField_b_of_type_JavaLangString, arrayOfInt);
        if (!FileUtils.b(paramOCRReqContext.jdField_c_of_type_JavaLangString)) {
          break label671;
        }
        paramOCRReqContext.jdField_b_of_type_Int = arrayOfInt[0];
        paramOCRReqContext.jdField_c_of_type_Int = arrayOfInt[1];
        paramOCRReqContext.a = new File(paramOCRReqContext.jdField_c_of_type_JavaLangString).length();
        paramOCRReqContext.e = PicOrcUtils.a(paramOCRReqContext.jdField_c_of_type_JavaLangString);
        localObject = new HashMap();
        ((HashMap)localObject).put("param_length", paramPicOcrObserver.length() / 1024L + "");
        ((HashMap)localObject).put("param_width", String.valueOf(j));
        ((HashMap)localObject).put("param_height", String.valueOf(k));
        ((HashMap)localObject).put("param_size", j * k + "");
        ((HashMap)localObject).put("param_complength", paramOCRReqContext.a / 1024L + "");
        ((HashMap)localObject).put("param_compwidth", String.valueOf(paramOCRReqContext.jdField_b_of_type_Int));
        ((HashMap)localObject).put("param_compheight", String.valueOf(paramOCRReqContext.jdField_c_of_type_Int));
        ((HashMap)localObject).put("param_compsize", paramOCRReqContext.jdField_b_of_type_Int * paramOCRReqContext.jdField_c_of_type_Int + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressInfo", true, 0L, 0L, (HashMap)localObject, "");
        i = 1;
        break;
      }
      label671:
      i = 0;
    }
  }
  
  public PicOcrRspResult a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return (PicOcrRspResult)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public void a(PicOcrManager.OCRReqContext paramOCRReqContext, PicOcrObserver paramPicOcrObserver)
  {
    ThreadManager.excute(new PicOcrManager.3(this, paramOCRReqContext, paramPicOcrObserver), 64, null, true);
  }
  
  public void a(PicOcrObserver paramPicOcrObserver, PicOcrManager.OCRReqContext paramOCRReqContext)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PicOcrManager", 2, "uploadOcrPic NetWork exception!");
      }
      paramPicOcrObserver.onUpdate(100, false, new PicOcrRspResult());
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext = paramOCRReqContext;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
        this.jdField_a_of_type_Boolean = true;
      }
      paramOCRReqContext.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("PicOcrManager", 2, "uploadOcrPic:" + paramOCRReqContext.a());
      }
      PicOcrManager.2 local2 = new PicOcrManager.2(this, paramPicOcrObserver, paramOCRReqContext);
      paramPicOcrObserver = new TransferRequest();
      paramPicOcrObserver.mFileType = 24;
      paramPicOcrObserver.mCommandId = 76;
      paramPicOcrObserver.mRichTag = "picorcupload";
      paramPicOcrObserver.mUpCallBack = local2;
      paramPicOcrObserver.mLocalPath = paramOCRReqContext.jdField_c_of_type_JavaLangString;
      paramPicOcrObserver.mSelfUin = this.jdField_a_of_type_JavaLangString;
      paramPicOcrObserver.mPeerUin = this.jdField_a_of_type_JavaLangString;
      paramPicOcrObserver.mUniseq = paramOCRReqContext.jdField_b_of_type_Long;
      paramPicOcrObserver.mIsUp = true;
      paramOCRReqContext = new Bdh_extinfo.CommFileExtReq();
      paramOCRReqContext.uint32_action_type.set(0);
      paramOCRReqContext.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      paramPicOcrObserver.mExtentionInfo = paramOCRReqContext.toByteArray();
    } while (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController == null);
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.transferAsync(paramPicOcrObserver);
  }
  
  public void a(String paramString, PicOcrRspResult paramPicOcrRspResult)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 10)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (str.equals(paramString));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(str);
      if ((TextUtils.isEmpty(paramString)) || (paramPicOcrRspResult == null)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramPicOcrRspResult);
      return;
      str = "";
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager
 * JD-Core Version:    0.7.0.1
 */