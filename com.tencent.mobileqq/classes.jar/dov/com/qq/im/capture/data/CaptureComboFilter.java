package dov.com.qq.im.capture.data;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import antu;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CaptureComboFilter
  extends CaptureComboBase
  implements INetEngine.INetEngineListener
{
  public float a;
  FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  public float b;
  public boolean b;
  
  public CaptureComboFilter(FilterDesc paramFilterDesc)
  {
    super(paramFilterDesc);
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
  }
  
  public static int a(Context paramContext, List paramList, CaptureSet paramCaptureSet, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 0) {
      a(paramContext, paramList);
    }
    do
    {
      return 0;
      if ((paramInt == 2) || (paramInt == 4))
      {
        if (paramInt == 2) {}
        for (;;)
        {
          b(paramList, bool1);
          return 0;
          bool1 = false;
        }
      }
    } while ((paramInt != 1) && (paramInt != 3));
    if (paramInt == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      a(paramList, bool1);
      return 0;
    }
  }
  
  public static void a(Context paramContext, List paramList)
  {
    VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
    QQFilterRenderManager localQQFilterRenderManager = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.jdField_b_of_type_Int);
    if (localQQFilterRenderManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForCapture QQFilterRenderManager null");
      }
      return;
    }
    paramContext = new ArrayList();
    paramList = paramList.iterator();
    FilterDesc localFilterDesc;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.e.equals("EMPTY")) {
        paramContext = null;
      }
    }
    for (;;)
    {
      label82:
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder().append("applyFiltersForCapture filters:");
        if (paramContext != null) {
          break label173;
        }
      }
      label173:
      for (int i = 0;; i = paramContext.size())
      {
        QLog.d("QCombo", 2, i);
        localVideoFilterTools.a(null);
        localQQFilterRenderManager.a(paramContext);
        return;
        if (localFilterDesc.jdField_b_of_type_Int == 9)
        {
          paramContext.clear();
          paramContext.add(localFilterDesc);
          break label82;
        }
        paramContext.add(localFilterDesc);
        break;
      }
    }
  }
  
  public static void a(List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    FilterDesc localFilterDesc;
    boolean bool;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc.e.equals("EMPTY"))
      {
        bool = true;
        localArrayList.clear();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder().append("applyFiltersForEditPic filters:");
        if (localArrayList != null) {
          break label131;
        }
      }
      label131:
      for (int i = 0;; i = localArrayList.size())
      {
        QLog.d("QCombo", 2, i);
        new antu(bool, localArrayList, paramBoolean).a(new Void[0]);
        return;
        localArrayList.add(localFilterDesc);
        break;
      }
      bool = false;
    }
  }
  
  public static boolean a(ComboSet paramComboSet, int paramInt)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramComboSet != null)
    {
      ComboSet localComboSet = VideoFilterTools.a().a[paramInt];
      boolean bool1 = bool3;
      if (paramComboSet != null)
      {
        bool1 = bool3;
        if (localComboSet != null)
        {
          bool1 = bool3;
          if (paramComboSet.b().equals(localComboSet.b())) {
            bool1 = true;
          }
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("QCombo", 2, "isApplying :" + paramComboSet);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public static void b(List paramList, boolean paramBoolean)
  {
    VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
    QQFilterRenderManager localQQFilterRenderManager = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.c);
    if (localQQFilterRenderManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "applyFiltersForEditVideo null manager");
      }
      return;
    }
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    FilterDesc localFilterDesc;
    if (paramList.hasNext())
    {
      localFilterDesc = (FilterDesc)paramList.next();
      if (!localFilterDesc.e.equals("EMPTY")) {}
    }
    for (paramList = null;; paramList = (List)localObject)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("applyFiltersForEditVideo filters:");
        if (paramList != null) {
          break label156;
        }
      }
      label156:
      for (int i = 0;; i = paramList.size())
      {
        QLog.d("QCombo", 2, i);
        localQQFilterRenderManager.a(paramList);
        localVideoFilterTools.a(null);
        localQQFilterRenderManager.a(90, 0, null);
        return;
        ((List)localObject).add(localFilterDesc);
        break;
      }
    }
  }
  
  public float a()
  {
    float f2;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)
    {
      f2 = 1.0F;
      return f2;
    }
    int i = 0;
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    if (this.jdField_b_of_type_Boolean) {
      i += 1;
    }
    for (;;)
    {
      if (i == 0) {
        return 1.0F;
      }
      float f1 = 0.0F;
      float f3 = 1.0F / i;
      if (this.jdField_a_of_type_Boolean) {
        f1 = 0.0F + this.jdField_a_of_type_Float * f3;
      }
      f2 = f1;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      return f1 + f3 * this.jdField_b_of_type_Float;
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Float == 1.0F) && (this.jdField_b_of_type_Float == 1.0F)) {}
    String str;
    do
    {
      return 3;
      if ((this.jdField_a_of_type_Float >= 0.0F) || (this.jdField_b_of_type_Float >= 0.0F)) {
        return 1;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.c))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.a(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString);
        File localFile = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "preDownloadResource " + str + " exist: " + localFile.exists());
        }
        if (!localFile.exists()) {
          return 2;
        }
      }
      str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.b(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString);
    } while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(str)) || (!VideoFilterListDownloader.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc)));
    return 2;
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) {}
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (CaptureComboFilter.UserData)paramNetReq.a();
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, " onUpdateProgeress curOffset " + paramLong1 + ", totalLen " + paramLong2);
    }
    if (paramNetReq == null) {}
    do
    {
      return;
      if (paramNetReq.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_Float = ((float)paramLong1 * 1.0F / (float)paramLong2);
        return;
      }
    } while (paramNetReq.jdField_a_of_type_Int != 2);
    this.jdField_b_of_type_Float = ((float)paramLong1 * 1.0F / (float)paramLong2);
  }
  
  public void a(NetResp paramNetResp)
  {
    Object localObject = (CaptureComboFilter.UserData)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "onResp userData " + localObject);
    }
    if (localObject != null)
    {
      if (((CaptureComboFilter.UserData)localObject).jdField_a_of_type_Int != 1) {
        break label217;
      }
      localObject = ((CaptureComboFilter.UserData)localObject).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
      if (paramNetResp.jdField_a_of_type_Int == 0) {
        break label174;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "download IconFile failed. errorCode: " + paramNetResp.jdField_b_of_type_Int + ", errorMsg: " + paramNetResp.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).c);
      }
      if (this.jdField_a_of_type_Float == 1.0F) {
        this.jdField_a_of_type_Float = 0.99F;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0)
      {
        if ((this.jdField_a_of_type_Float != 1.0F) || (this.jdField_b_of_type_Float != 1.0F)) {
          break;
        }
        b();
      }
      return;
      label174:
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "download iconFile success. file: " + ((FilterDesc)localObject).c);
      }
      this.jdField_a_of_type_Float = 1.0F;
      continue;
      label217:
      if (((CaptureComboFilter.UserData)localObject).jdField_a_of_type_Int == 2)
      {
        localObject = ((CaptureComboFilter.UserData)localObject).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
        if (paramNetResp.jdField_a_of_type_Int != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "download file failed. errorCode: " + paramNetResp.jdField_b_of_type_Int + ", errorMsg: " + paramNetResp.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).jdField_a_of_type_JavaLangString);
          }
        }
        else if (!((FilterDesc)localObject).jdField_b_of_type_JavaLangString.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "download file failed: md5 is not match.");
          }
          FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
          if (this.jdField_b_of_type_Float == 1.0F) {
            this.jdField_b_of_type_Float = 0.99F;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "download resFile success. file: " + ((FilterDesc)localObject).jdField_a_of_type_JavaLangString);
          }
          try
          {
            localObject = CaptureVideoFilterManager.jdField_b_of_type_JavaLangString;
            FileUtils.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c, (String)localObject, false);
            FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
            this.jdField_b_of_type_Float = 1.0F;
          }
          catch (IOException paramNetResp)
          {
            paramNetResp.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "unzip file failed.");
            }
          }
          if (this.jdField_b_of_type_Float == 1.0F) {
            this.jdField_b_of_type_Float = 0.99F;
          }
        }
      }
    }
    a(1);
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "download: " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.d + ", iconurl: " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.c + ", resurl:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.c))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.a(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString);
      Object localObject2 = new File((String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "preDownloadResource " + (String)localObject1 + " exist: " + ((File)localObject2).exists());
      }
      if (!((File)localObject2).exists())
      {
        localObject2 = new HttpNetReq();
        ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
        ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.c;
        ((HttpNetReq)localObject2).jdField_a_of_type_Int = 0;
        ((HttpNetReq)localObject2).c = ((String)localObject1);
        localObject1 = new CaptureComboFilter.UserData();
        ((CaptureComboFilter.UserData)localObject1).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
        ((CaptureComboFilter.UserData)localObject1).jdField_a_of_type_Int = 1;
        ((HttpNetReq)localObject2).a(localObject1);
        AVNetEngine.a().a((NetReq)localObject2);
        this.jdField_a_of_type_Float = 0.0F;
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.b(CaptureVideoFilterManager.jdField_b_of_type_JavaLangString);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break label483;
      }
      boolean bool = VideoFilterListDownloader.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "preDownloadResource " + (String)localObject1 + "params.json" + " beNeedDownload: " + bool);
      }
      if (bool)
      {
        localObject1 = new HttpNetReq();
        ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
        ((HttpNetReq)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.jdField_a_of_type_JavaLangString;
        ((HttpNetReq)localObject1).jdField_a_of_type_Int = 0;
        ((HttpNetReq)localObject1).c = (CaptureVideoFilterManager.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.e + ".zip");
        localObject2 = new CaptureComboFilter.UserData();
        ((CaptureComboFilter.UserData)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
        ((CaptureComboFilter.UserData)localObject2).jdField_a_of_type_Int = 2;
        ((HttpNetReq)localObject1).a(localObject2);
        AVNetEngine.a().a((NetReq)localObject1);
        this.jdField_b_of_type_Float = 0.0F;
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Float == 0.0F) || (this.jdField_b_of_type_Float == 0.0F)) {
        a();
      }
      return super.b();
      this.jdField_a_of_type_Float = 1.0F;
      break;
      label483:
      this.jdField_b_of_type_Float = 1.0F;
    }
  }
  
  public String toString()
  {
    return "Filter@" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.e + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureComboFilter
 * JD-Core Version:    0.7.0.1
 */