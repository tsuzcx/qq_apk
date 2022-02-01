package com.tencent.qqprotect.qsec;

import android.text.TextUtils;
import com.tencent.ims.QQProtectCommon.QQProtectQueryHead;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQuery;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQueryBody;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQueryEntry;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespBody;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespEntry;
import com.tencent.mobileqq.app.ThreadManager;
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
  private CloudAVEngineImpl.AVEngineCache jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl$AVEngineCache;
  private CloudAVEngineImpl.AVEngineHandler jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl$AVEngineHandler = new CloudAVEngineImpl.AVEngineHandler(this, ThreadManager.getFileThreadLooper());
  private QSecFramework.IGoingUpHandler jdField_a_of_type_ComTencentQqprotectQsecQSecFramework$IGoingUpHandler;
  private HashMap<Integer, CloudAVEngineImpl.CloudDetectEntry> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<CloudAVEngineImpl.CloudDetectEntry> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public CloudAVEngineImpl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("QSecCache2.dat");
    this.jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl$AVEngineCache = new CloudAVEngineImpl.AVEngineCache(localStringBuilder.toString(), 50);
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecFramework$IGoingUpHandler = new CloudAVEngineImpl.NativeRequestHandler(this, null);
    QSecFramework.a(1L, this.jdField_a_of_type_ComTencentQqprotectQsecQSecFramework$IGoingUpHandler);
    SecSvcHandlerHelper.a("QSec.AVEng", new CloudAVEngineImpl.1(this));
  }
  
  private int a(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    paramCloudDetectEntry = paramCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle;
    String str = paramCloudDetectEntry.jdField_a_of_type_JavaLangString;
    int j = 16;
    if (str != null) {
      j = 16 + paramCloudDetectEntry.jdField_a_of_type_JavaLangString.length();
    }
    int i = j;
    if (paramCloudDetectEntry.jdField_b_of_type_JavaLangString != null) {
      i = j + paramCloudDetectEntry.jdField_b_of_type_JavaLangString.length();
    }
    j = i;
    if (paramCloudDetectEntry.jdField_c_of_type_JavaLangString != null) {
      j = i + paramCloudDetectEntry.jdField_c_of_type_JavaLangString.length();
    }
    i = j;
    if (paramCloudDetectEntry.d != null) {
      i = j + paramCloudDetectEntry.d.length();
    }
    j = i;
    if (paramCloudDetectEntry.e != null) {
      j = i + paramCloudDetectEntry.e.length();
    }
    i = j;
    if (paramCloudDetectEntry.jdField_a_of_type_ArrayOfByte != null) {
      i = j + paramCloudDetectEntry.jdField_a_of_type_ArrayOfByte.length;
    }
    return i;
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<CloudAVEngineImpl.CloudDetectEntry> paramList)
  {
    try
    {
      QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead = QPMiscUtils.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CloudAVEngineImpl.CloudDetectEntry localCloudDetectEntry = (CloudAVEngineImpl.CloudDetectEntry)paramList.next();
        ICloudAVEngine.DetectBundle localDetectBundle = localCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localCloudDetectEntry.jdField_a_of_type_Int);
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
      paramList.head.set(localQQProtectQueryHead);
      paramList.body.set(localQSecCloudQueryBody);
      return paramList;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
    return null;
  }
  
  private CloudAVEngineImpl.CloudDetectEntry a(Object paramObject)
  {
    try
    {
      paramObject = (CloudAVEngineImpl.CloudDetectEntry)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static CloudAVEngineImpl a()
  {
    if (jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl == null) {
          jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl = new CloudAVEngineImpl();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl;
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
    CloudAVEngineImpl.CloudDetectEntry localCloudDetectEntry = (CloudAVEngineImpl.CloudDetectEntry)this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reply for id: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" result: ");
      localStringBuilder.append(paramResultBundle.toString());
      QLog.d("QSec.AVEngine", 2, localStringBuilder.toString());
    }
    if (localCloudDetectEntry != null)
    {
      if ((paramResultBundle.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(localCloudDetectEntry.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl$AVEngineCache.a(localCloudDetectEntry.jdField_a_of_type_JavaLangString, paramResultBundle);
      }
      paramResultBundle.jdField_a_of_type_Boolean = false;
      a(localCloudDetectEntry, 3, paramResultBundle);
    }
  }
  
  private void a(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    if (paramCloudDetectEntry == null) {
      return;
    }
    String str = paramCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.a();
    paramCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString = str;
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { paramCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_a_of_type_JavaLangString, str }));
    }
  }
  
  private void a(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry, int paramInt, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if (paramCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$IAVEngineEventListener != null) {
      paramCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$IAVEngineEventListener.a(paramInt, paramCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle, paramResultBundle);
    }
  }
  
  private void a(Object paramObject)
  {
    int j;
    int i;
    try
    {
      paramObject = (QSecCloudAVEngineMsg.QSecCloudRespBody)paramObject;
      j = -1;
      i = j;
      if (paramObject.status == null) {
        break label439;
      }
      i = j;
      if (!paramObject.status.has()) {
        break label439;
      }
      i = paramObject.status.get();
    }
    catch (Exception paramObject)
    {
      label67:
      Iterator localIterator;
      label95:
      Object localObject;
      int k;
      int m;
      int n;
      int i1;
      label276:
      paramObject.printStackTrace();
      return;
    }
    if ((paramObject.version != null) && (paramObject.version.has()))
    {
      i = paramObject.version.get();
      break label446;
      if (paramObject.respEntry != null)
      {
        paramObject = paramObject.respEntry.get();
        if (paramObject == null) {
          return;
        }
        localIterator = paramObject.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (QSecCloudAVEngineMsg.QSecCloudRespEntry)localIterator.next();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).entryId == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).entryId.has())) {
              continue;
            }
            k = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).entryId.get();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).attrType == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).attrType.has())) {
              continue;
            }
            m = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).attrType.get();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).category == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).category.has())) {
              continue;
            }
            n = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).category.get();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).subCategory == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).subCategory.has())) {
              continue;
            }
            i1 = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).subCategory.get();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).timeToLive == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).timeToLive.has())) {
              break label452;
            }
            i = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).timeToLive.get();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).actionType == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).actionType.has())) {
              break label457;
            }
            j = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).actionType.get();
          }
        }
      }
    }
    for (;;)
    {
      ICloudAVEngine.ResultBundle localResultBundle = null;
      paramObject = localResultBundle;
      if (((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).extraInfo != null)
      {
        localObject = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).extraInfo.get();
        paramObject = localResultBundle;
        if (localObject != null) {
          paramObject = ((ByteStringMicro)localObject).toByteArray();
        }
      }
      localResultBundle = new ICloudAVEngine.ResultBundle();
      localResultBundle.jdField_a_of_type_Int = m;
      localResultBundle.jdField_b_of_type_Int = n;
      localResultBundle.jdField_c_of_type_Int = i1;
      localResultBundle.d = j;
      if (i != 0) {
        localResultBundle.jdField_a_of_type_Long = (new Date().getTime() + i * 1000);
      }
      localResultBundle.jdField_a_of_type_ArrayOfByte = paramObject;
      a(k, localResultBundle);
      break label95;
      this.jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl$AVEngineCache.a();
      return;
      return;
      label439:
      if (i == 0) {
        break;
      }
      return;
      i = 0;
      label446:
      if (i == 1) {
        break label67;
      }
      return;
      label452:
      i = 0;
      break label276;
      label457:
      j = 0;
    }
  }
  
  private void a(List<CloudAVEngineImpl.CloudDetectEntry> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CloudAVEngineImpl.CloudDetectEntry localCloudDetectEntry = (CloudAVEngineImpl.CloudDetectEntry)paramList.next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Add to wait resp map: ");
        localStringBuilder.append(localCloudDetectEntry.toString());
        QLog.d("QSec.AVEngine", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localCloudDetectEntry.jdField_a_of_type_Int), localCloudDetectEntry);
      arrayOfInt[i] = localCloudDetectEntry.jdField_a_of_type_Int;
      i += 1;
    }
    paramList = this.jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl$AVEngineHandler;
    paramList.sendMessageDelayed(paramList.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return SecSvcHandlerHelper.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
  }
  
  private void b()
  {
    LinkedList localLinkedList = new LinkedList();
    int m = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < m) {}
      try
      {
        localObject = (CloudAVEngineImpl.CloudDetectEntry)this.jdField_a_of_type_JavaUtilList.get(i);
        int k = ((CloudAVEngineImpl.CloudDetectEntry)localObject).jdField_c_of_type_Int + j;
        if (k > 1000)
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
          j = k;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_Int = 0;
        localException.printStackTrace();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      if (localLinkedList.size() != 0)
      {
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
        if (QLog.isColorLevel())
        {
          QLog.d("QSec.AVEngine", 2, String.format("Has %d(count: %d) left.", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(localLinkedList.size()) }));
          return;
        }
      }
      return;
      i += 1;
    }
  }
  
  private void b(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    if (paramCloudDetectEntry != null)
    {
      paramCloudDetectEntry.jdField_a_of_type_JavaLangString = paramCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Lookup cache, key: ");
        ((StringBuilder)localObject).append(paramCloudDetectEntry.jdField_a_of_type_JavaLangString);
        QLog.d("QSec.AVEngine", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(paramCloudDetectEntry.jdField_a_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl$AVEngineCache.a(paramCloudDetectEntry.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          ((ICloudAVEngine.ResultBundle)localObject).jdField_a_of_type_Boolean = true;
          a(paramCloudDetectEntry, 3, (ICloudAVEngine.ResultBundle)localObject);
          return;
        }
      }
      c(paramCloudDetectEntry);
    }
  }
  
  private void b(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    try
    {
      paramObject = (int[])paramObject;
      int k = paramObject.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        int m = paramObject[i];
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Timeout entry id:");
          ((StringBuilder)localObject).append(m);
          QLog.d("QSec.AVEngine", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = (CloudAVEngineImpl.CloudDetectEntry)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
        if (localObject != null) {
          if (((CloudAVEngineImpl.CloudDetectEntry)localObject).jdField_b_of_type_Int < 1)
          {
            ((CloudAVEngineImpl.CloudDetectEntry)localObject).jdField_b_of_type_Int += 1;
            e((CloudAVEngineImpl.CloudDetectEntry)localObject);
            j = 1;
          }
          else
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("No retry chance for entry id: ");
              localStringBuilder.append(m);
              QLog.d("QSec.AVEngine", 2, localStringBuilder.toString());
            }
            a();
            this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
            a((CloudAVEngineImpl.CloudDetectEntry)localObject, 2, null);
          }
        }
        i += 1;
      }
      if (j != 0) {
        flushRequest();
      }
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void c(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    if (paramCloudDetectEntry != null)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      paramCloudDetectEntry.jdField_a_of_type_Int = i;
      paramCloudDetectEntry.jdField_b_of_type_Int = 0;
      e(paramCloudDetectEntry);
    }
  }
  
  private void d(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    if (paramCloudDetectEntry == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { paramCloudDetectEntry.toString() }));
    }
    if (TextUtils.isEmpty(paramCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString))
    {
      a(paramCloudDetectEntry);
      if (TextUtils.isEmpty(paramCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle.jdField_b_of_type_JavaLangString))
      {
        a(paramCloudDetectEntry, 4, null);
        return;
      }
    }
    if (paramCloudDetectEntry.jdField_a_of_type_Boolean)
    {
      b(paramCloudDetectEntry);
      return;
    }
    c(paramCloudDetectEntry);
  }
  
  private void e(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    if (this.jdField_b_of_type_Int >= 100)
    {
      a(paramCloudDetectEntry, 1, null);
      return;
    }
    if (paramCloudDetectEntry.jdField_c_of_type_Int == 0) {
      paramCloudDetectEntry.jdField_c_of_type_Int = a(paramCloudDetectEntry);
    }
    this.jdField_c_of_type_Int += paramCloudDetectEntry.jdField_c_of_type_Int;
    this.jdField_b_of_type_Int += 1;
    this.jdField_a_of_type_JavaUtilList.add(paramCloudDetectEntry);
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(paramCloudDetectEntry.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) }));
    }
    if ((paramCloudDetectEntry.jdField_b_of_type_Boolean == true) || (this.jdField_c_of_type_Int >= 1000)) {
      b();
    }
  }
  
  public int cloudDetect(ICloudAVEngine.DetectBundle paramDetectBundle, boolean paramBoolean1, boolean paramBoolean2, ICloudAVEngine.IAVEngineEventListener paramIAVEngineEventListener)
  {
    if (paramDetectBundle == null) {
      return 13;
    }
    CloudAVEngineImpl.CloudDetectEntry localCloudDetectEntry = new CloudAVEngineImpl.CloudDetectEntry(null);
    localCloudDetectEntry.jdField_a_of_type_Boolean = paramBoolean1;
    localCloudDetectEntry.jdField_b_of_type_Boolean = paramBoolean2;
    localCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$DetectBundle = paramDetectBundle;
    localCloudDetectEntry.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$IAVEngineEventListener = paramIAVEngineEventListener;
    if ((paramDetectBundle.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramDetectBundle.jdField_a_of_type_JavaLangString))) {
      paramDetectBundle.jdField_c_of_type_Int = ((int)new File(paramDetectBundle.jdField_a_of_type_JavaLangString).length());
    }
    paramDetectBundle = this.jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl$AVEngineHandler;
    paramDetectBundle.sendMessage(paramDetectBundle.obtainMessage(1, localCloudDetectEntry));
    return 0;
  }
  
  public void flushRequest()
  {
    CloudAVEngineImpl.AVEngineHandler localAVEngineHandler = this.jdField_a_of_type_ComTencentQqprotectQsecCloudAVEngineImpl$AVEngineHandler;
    localAVEngineHandler.sendMessage(localAVEngineHandler.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl
 * JD-Core Version:    0.7.0.1
 */