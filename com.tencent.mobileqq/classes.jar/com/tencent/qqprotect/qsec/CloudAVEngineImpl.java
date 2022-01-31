package com.tencent.qqprotect.qsec;

import alhd;
import alhe;
import alhk;
import alhl;
import alhn;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.ims.QQProtectCommon.QQProtectQueryHead;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQuery;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQueryBody;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQueryEntry;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespBody;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespEntry;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.CommTvRpt;
import com.tencent.qqprotect.common.QPMiscUtils;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;

public class CloudAVEngineImpl
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile CloudAVEngineImpl jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl;
  private int jdField_a_of_type_Int = 1;
  private alhe jdField_a_of_type_Alhe = new alhe(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache.dat", 50);
  private alhk jdField_a_of_type_Alhk = new alhk(this, QSecFramework.a().getLooper());
  private QSecFramework.IGoingUpHandler jdField_a_of_type_ComTencentQqprotectQsecQSecFramework$IGoingUpHandler = new alhn(this, null);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public CloudAVEngineImpl()
  {
    QSecFramework.a(1, this.jdField_a_of_type_ComTencentQqprotectQsecQSecFramework$IGoingUpHandler);
    SecSvcHandlerHelper.a("QSec.AVEng", new alhd(this));
  }
  
  private int a(alhl paramalhl)
  {
    int j = 16;
    paramalhl = paramalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle;
    if (paramalhl.jdField_a_of_type_JavaLangString != null) {
      j = 16 + paramalhl.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (paramalhl.jdField_b_of_type_JavaLangString != null) {
      i = j + paramalhl.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (paramalhl.jdField_c_of_type_JavaLangString != null) {
      j = i + paramalhl.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (paramalhl.d != null) {
      i = j + paramalhl.d.length();
    }
    j = i;
    if (paramalhl.e != null) {
      j = i + paramalhl.e.length();
    }
    i = j;
    if (paramalhl.jdField_a_of_type_ArrayOfByte != null) {
      i = j + paramalhl.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  private alhl a(Object paramObject)
  {
    try
    {
      paramObject = (alhl)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = QPMiscUtils.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        alhl localalhl = (alhl)paramList.next();
        ICloudAVEngine.DetectBundle localDetectBundle = localalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localalhl.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.fileType.set(localDetectBundle.jdField_a_of_type_Int);
        localQSecCloudQueryEntry.scenarioType.set(localDetectBundle.jdField_b_of_type_Int);
        localQSecCloudQueryEntry.fileSize.set(localDetectBundle.jdField_c_of_type_Int);
        if (localDetectBundle.jdField_c_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.packageName.set(localDetectBundle.jdField_c_of_type_JavaLangString);
        }
        if (localDetectBundle.jdField_a_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileName.set(localDetectBundle.jdField_a_of_type_JavaLangString);
        }
        if (localDetectBundle.d != null) {
          localQSecCloudQueryEntry.appName.set(localDetectBundle.d);
        }
        if (localDetectBundle.jdField_b_of_type_JavaLangString != null) {
          localQSecCloudQueryEntry.fileMd5.set(localDetectBundle.jdField_b_of_type_JavaLangString);
        }
        if (localDetectBundle.e != null) {
          localQSecCloudQueryEntry.certMd5.set(localDetectBundle.e);
        }
        if (localDetectBundle.jdField_a_of_type_ArrayOfByte != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localDetectBundle.jdField_a_of_type_ArrayOfByte));
        }
        localQSecCloudQueryBody.queryEntry.add(localQSecCloudQueryEntry);
      }
      paramList = new QSecCloudAVEngineMsg.QSecCloudQuery();
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    paramList.head.set(localQQProtectQueryHead);
    paramList.body.set(localQSecCloudQueryBody);
    return paramList;
  }
  
  public static CloudAVEngineImpl a()
  {
    if (jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl == null) {
        jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl = new CloudAVEngineImpl();
      }
      return jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl;
    }
    finally {}
  }
  
  private void a()
  {
    this.d += 1;
    if (this.d >= 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Rpt to %d", new Object[] { Integer.valueOf(this.d) }));
      }
      this.d = 0;
      a(1);
    }
  }
  
  private void a(int paramInt)
  {
    CommTvRpt.a(2, paramInt);
  }
  
  private void a(int paramInt, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    alhl localalhl = (alhl)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + paramResultBundle.toString());
    }
    if (localalhl != null)
    {
      if ((paramResultBundle.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localalhl.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Alhe.a(localalhl.jdField_a_of_type_JavaLangString, paramResultBundle);
      }
      paramResultBundle.jdField_a_of_type_Boolean = false;
      a(localalhl, 3, paramResultBundle);
    }
  }
  
  private void a(alhl paramalhl)
  {
    if (paramalhl == null) {}
    String str;
    do
    {
      return;
      str = paramalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.a();
      paramalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { paramalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(alhl paramalhl, int paramInt, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if (paramalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$IAVEngineEventListener != null) {
      paramalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$IAVEngineEventListener.a(paramInt, paramalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle, paramResultBundle);
    }
  }
  
  private void a(Object paramObject)
  {
    int i;
    label398:
    do
    {
      int j;
      try
      {
        paramObject = (QSecCloudAVEngineMsg.QSecCloudRespBody)paramObject;
        j = -1;
        i = j;
        if (paramObject.status == null) {
          continue;
        }
        i = j;
        if (!paramObject.status.has()) {
          continue;
        }
        i = paramObject.status.get();
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if ((paramObject.version != null) && (paramObject.version.has())) {}
      for (i = paramObject.version.get(); (i == 1) && (paramObject.respEntry != null); i = 0)
      {
        paramObject = paramObject.respEntry.get();
        if (paramObject == null) {
          break;
        }
        Iterator localIterator = paramObject.iterator();
        int k;
        int m;
        int n;
        int i1;
        while (localIterator.hasNext())
        {
          paramObject = (QSecCloudAVEngineMsg.QSecCloudRespEntry)localIterator.next();
          if ((paramObject.entryId != null) && (paramObject.entryId.has()))
          {
            k = paramObject.entryId.get();
            if ((paramObject.attrType != null) && (paramObject.attrType.has()))
            {
              m = paramObject.attrType.get();
              if ((paramObject.category != null) && (paramObject.category.has()))
              {
                n = paramObject.category.get();
                if ((paramObject.subCategory != null) && (paramObject.subCategory.has()))
                {
                  i1 = paramObject.subCategory.get();
                  if ((paramObject.timeToLive == null) || (!paramObject.timeToLive.has())) {
                    break label398;
                  }
                }
              }
            }
          }
        }
        for (i = paramObject.timeToLive.get();; i = 0)
        {
          if ((paramObject.actionType != null) && (paramObject.actionType.has())) {}
          for (j = paramObject.actionType.get();; j = 0)
          {
            if (paramObject.extraInfo != null)
            {
              paramObject = paramObject.extraInfo.get();
              if (paramObject == null) {}
            }
            for (paramObject = paramObject.toByteArray();; paramObject = null)
            {
              ICloudAVEngine.ResultBundle localResultBundle = new ICloudAVEngine.ResultBundle();
              localResultBundle.jdField_a_of_type_Int = m;
              localResultBundle.jdField_b_of_type_Int = n;
              localResultBundle.jdField_c_of_type_Int = i1;
              localResultBundle.d = j;
              if (i != 0) {
                localResultBundle.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
              }
              localResultBundle.jdField_a_of_type_ArrayOfByte = paramObject;
              a(k, localResultBundle);
              break;
              this.jdField_a_of_type_Alhe.a();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void a(List paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      alhl localalhl = (alhl)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localalhl.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localalhl.jdField_a_of_type_Int), localalhl);
      arrayOfInt[i] = localalhl.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Alhk.sendMessageDelayed(this.jdField_a_of_type_Alhk.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return SecSvcHandlerHelper.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
  }
  
  private void b()
  {
    LinkedList localLinkedList = new LinkedList();
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i < k) {}
      try
      {
        localObject = (alhl)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((alhl)localObject).jdField_c_of_type_Int;
        if (m + j > 1000)
        {
          localObject = a(localLinkedList);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QSec.AVEngine", 2, String.format("Pack size: %d, count: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localLinkedList.size()) }));
            }
            a(localLinkedList);
            a((QSecCloudAVEngineMsg.QSecCloudQuery)localObject);
          }
          this.jdField_c_of_type_Int -= j;
          this.jdField_b_of_type_Int -= localLinkedList.size();
          localLinkedList.clear();
          i -= 1;
          j = 0;
        }
        else
        {
          localLinkedList.add(localObject);
          j += m;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_Int = 0;
        localException.printStackTrace();
        return;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      if (localLinkedList.size() == 0) {
        break;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, String.format("Commit Left (%d:%d)", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) }));
        }
        localObject = a(localLinkedList);
        if (localObject != null)
        {
          a(localLinkedList);
          a((QSecCloudAVEngineMsg.QSecCloudQuery)localObject);
        }
        this.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_Int = 0;
        return;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(localLinkedList);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QSec.AVEngine", 2, String.format("Has %d(count: %d) left.", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(localLinkedList.size()) }));
      return;
      i += 1;
    }
  }
  
  private void b(alhl paramalhl)
  {
    if (paramalhl != null)
    {
      paramalhl.jdField_a_of_type_JavaLangString = paramalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + paramalhl.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramalhl.jdField_a_of_type_JavaLangString))
      {
        ICloudAVEngine.ResultBundle localResultBundle = this.jdField_a_of_type_Alhe.a(paramalhl.jdField_a_of_type_JavaLangString);
        if (localResultBundle != null)
        {
          localResultBundle.jdField_a_of_type_Boolean = true;
          a(paramalhl, 3, localResultBundle);
        }
      }
    }
    else
    {
      return;
    }
    c(paramalhl);
  }
  
  private void b(Object paramObject)
  {
    if (paramObject == null) {}
    int i;
    label133:
    do
    {
      return;
      for (;;)
      {
        int m;
        alhl localalhl;
        try
        {
          paramObject = (int[])paramObject;
          int k = paramObject.length;
          int j = 0;
          i = 0;
          if (j >= k) {
            break;
          }
          m = paramObject[j];
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Timeout entry id:" + m);
          }
          localalhl = (alhl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localalhl == null)
          {
            j += 1;
            continue;
          }
          if (localalhl.jdField_b_of_type_Int >= 2) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localalhl.jdField_b_of_type_Int += 1;
        e(localalhl);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localalhl, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(alhl paramalhl)
  {
    if (paramalhl != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      paramalhl.jdField_a_of_type_Int = i;
      paramalhl.jdField_b_of_type_Int = 0;
      e(paramalhl);
    }
  }
  
  private void d(alhl paramalhl)
  {
    if (paramalhl == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { paramalhl.toString() }));
    }
    if (TextUtils.isEmpty(paramalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString))
    {
      a(paramalhl);
      if (TextUtils.isEmpty(paramalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString))
      {
        a(paramalhl, 4, null);
        return;
      }
    }
    if (paramalhl.jdField_a_of_type_Boolean)
    {
      b(paramalhl);
      return;
    }
    c(paramalhl);
  }
  
  private void e(alhl paramalhl)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(paramalhl, 1, null);
    }
    do
    {
      return;
      if (paramalhl.jdField_c_of_type_Int == 0) {
        paramalhl.jdField_c_of_type_Int = a(paramalhl);
      }
      this.jdField_c_of_type_Int += paramalhl.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(paramalhl);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(paramalhl.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((paramalhl.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(ICloudAVEngine.DetectBundle paramDetectBundle, boolean paramBoolean1, boolean paramBoolean2, ICloudAVEngine.IAVEngineEventListener paramIAVEngineEventListener)
  {
    if (paramDetectBundle == null) {
      return 13;
    }
    alhl localalhl = new alhl(null);
    localalhl.jdField_a_of_type_Boolean = paramBoolean1;
    localalhl.jdField_b_of_type_Boolean = paramBoolean2;
    localalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle = paramDetectBundle;
    localalhl.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$IAVEngineEventListener = paramIAVEngineEventListener;
    if ((paramDetectBundle.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramDetectBundle.jdField_a_of_type_JavaLangString))) {
      paramDetectBundle.jdField_c_of_type_Int = ((int)new File(paramDetectBundle.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Alhk.sendMessage(this.jdField_a_of_type_Alhk.obtainMessage(1, localalhl));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Alhk.sendMessage(this.jdField_a_of_type_Alhk.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl
 * JD-Core Version:    0.7.0.1
 */