package com.tencent.qqprotect.qsec;

import amec;
import amed;
import amej;
import amek;
import amem;
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
  private amed jdField_a_of_type_Amed = new amed(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache.dat", 50);
  private amej jdField_a_of_type_Amej = new amej(this, QSecFramework.a().getLooper());
  private QSecFramework.IGoingUpHandler jdField_a_of_type_ComTencentQqprotectQsecQSecFramework$IGoingUpHandler = new amem(this, null);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public CloudAVEngineImpl()
  {
    QSecFramework.a(1, this.jdField_a_of_type_ComTencentQqprotectQsecQSecFramework$IGoingUpHandler);
    SecSvcHandlerHelper.a("QSec.AVEng", new amec(this));
  }
  
  private int a(amek paramamek)
  {
    int j = 16;
    paramamek = paramamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle;
    if (paramamek.jdField_a_of_type_JavaLangString != null) {
      j = 16 + paramamek.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (paramamek.jdField_b_of_type_JavaLangString != null) {
      i = j + paramamek.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (paramamek.jdField_c_of_type_JavaLangString != null) {
      j = i + paramamek.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (paramamek.d != null) {
      i = j + paramamek.d.length();
    }
    j = i;
    if (paramamek.e != null) {
      j = i + paramamek.e.length();
    }
    i = j;
    if (paramamek.jdField_a_of_type_ArrayOfByte != null) {
      i = j + paramamek.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  private amek a(Object paramObject)
  {
    try
    {
      paramObject = (amek)paramObject;
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
        amek localamek = (amek)paramList.next();
        ICloudAVEngine.DetectBundle localDetectBundle = localamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localamek.jdField_a_of_type_Int);
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
    amek localamek = (amek)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + paramResultBundle.toString());
    }
    if (localamek != null)
    {
      if ((paramResultBundle.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localamek.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Amed.a(localamek.jdField_a_of_type_JavaLangString, paramResultBundle);
      }
      paramResultBundle.jdField_a_of_type_Boolean = false;
      a(localamek, 3, paramResultBundle);
    }
  }
  
  private void a(amek paramamek)
  {
    if (paramamek == null) {}
    String str;
    do
    {
      return;
      str = paramamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.a();
      paramamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { paramamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_a_of_type_JavaLangString, str }));
  }
  
  private void a(amek paramamek, int paramInt, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if (paramamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$IAVEngineEventListener != null) {
      paramamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$IAVEngineEventListener.a(paramInt, paramamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle, paramResultBundle);
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
              this.jdField_a_of_type_Amed.a();
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
      amek localamek = (amek)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localamek.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localamek.jdField_a_of_type_Int), localamek);
      arrayOfInt[i] = localamek.jdField_a_of_type_Int;
      i += 1;
    }
    this.jdField_a_of_type_Amej.sendMessageDelayed(this.jdField_a_of_type_Amej.obtainMessage(3, arrayOfInt), 30000L);
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
        localObject = (amek)this.jdField_a_of_type_JavaUtilList.get(i);
        int m = ((amek)localObject).jdField_c_of_type_Int;
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
  
  private void b(amek paramamek)
  {
    if (paramamek != null)
    {
      paramamek.jdField_a_of_type_JavaLangString = paramamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + paramamek.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramamek.jdField_a_of_type_JavaLangString))
      {
        ICloudAVEngine.ResultBundle localResultBundle = this.jdField_a_of_type_Amed.a(paramamek.jdField_a_of_type_JavaLangString);
        if (localResultBundle != null)
        {
          localResultBundle.jdField_a_of_type_Boolean = true;
          a(paramamek, 3, localResultBundle);
        }
      }
    }
    else
    {
      return;
    }
    c(paramamek);
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
        amek localamek;
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
          localamek = (amek)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          if (localamek == null)
          {
            j += 1;
            continue;
          }
          if (localamek.jdField_b_of_type_Int >= 2) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localamek.jdField_b_of_type_Int += 1;
        e(localamek);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        a();
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        a(localamek, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(amek paramamek)
  {
    if (paramamek != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      paramamek.jdField_a_of_type_Int = i;
      paramamek.jdField_b_of_type_Int = 0;
      e(paramamek);
    }
  }
  
  private void d(amek paramamek)
  {
    if (paramamek == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { paramamek.toString() }));
    }
    if (TextUtils.isEmpty(paramamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString))
    {
      a(paramamek);
      if (TextUtils.isEmpty(paramamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString))
      {
        a(paramamek, 4, null);
        return;
      }
    }
    if (paramamek.jdField_a_of_type_Boolean)
    {
      b(paramamek);
      return;
    }
    c(paramamek);
  }
  
  private void e(amek paramamek)
  {
    if (this.jdField_b_of_type_Int >= 100) {
      a(paramamek, 1, null);
    }
    do
    {
      return;
      if (paramamek.jdField_c_of_type_Int == 0) {
        paramamek.jdField_c_of_type_Int = a(paramamek);
      }
      this.jdField_c_of_type_Int += paramamek.jdField_c_of_type_Int;
      this.jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilList.add(paramamek);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(paramamek.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
    } while ((paramamek.jdField_b_of_type_Boolean != true) && (this.jdField_c_of_type_Int < 1000));
    b();
  }
  
  public int cloudDetect(ICloudAVEngine.DetectBundle paramDetectBundle, boolean paramBoolean1, boolean paramBoolean2, ICloudAVEngine.IAVEngineEventListener paramIAVEngineEventListener)
  {
    if (paramDetectBundle == null) {
      return 13;
    }
    amek localamek = new amek(null);
    localamek.jdField_a_of_type_Boolean = paramBoolean1;
    localamek.jdField_b_of_type_Boolean = paramBoolean2;
    localamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle = paramDetectBundle;
    localamek.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$IAVEngineEventListener = paramIAVEngineEventListener;
    if ((paramDetectBundle.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramDetectBundle.jdField_a_of_type_JavaLangString))) {
      paramDetectBundle.jdField_c_of_type_Int = ((int)new File(paramDetectBundle.jdField_a_of_type_JavaLangString).length());
    }
    this.jdField_a_of_type_Amej.sendMessage(this.jdField_a_of_type_Amej.obtainMessage(1, localamek));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Amej.sendMessage(this.jdField_a_of_type_Amej.obtainMessage(2));
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