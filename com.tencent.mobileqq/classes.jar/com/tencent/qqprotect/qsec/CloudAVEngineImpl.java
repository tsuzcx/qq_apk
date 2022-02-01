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
  private static volatile CloudAVEngineImpl k;
  private int a = 1;
  private int b;
  private int c;
  private boolean d;
  private List<CloudAVEngineImpl.CloudDetectEntry> e = new LinkedList();
  private HashMap<Integer, CloudAVEngineImpl.CloudDetectEntry> f = new HashMap();
  private CloudAVEngineImpl.AVEngineHandler g = new CloudAVEngineImpl.AVEngineHandler(this, ThreadManager.getFileThreadLooper());
  private CloudAVEngineImpl.AVEngineCache h;
  private QSecFramework.IGoingUpHandler i;
  private int j;
  
  public CloudAVEngineImpl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("QSecCache2.dat");
    this.h = new CloudAVEngineImpl.AVEngineCache(localStringBuilder.toString(), 50);
    this.i = new CloudAVEngineImpl.NativeRequestHandler(this, null);
    QSecFramework.a(1L, this.i);
    SecSvcHandlerHelper.a("QSec.AVEng", new CloudAVEngineImpl.1(this));
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
        ICloudAVEngine.DetectBundle localDetectBundle = localCloudDetectEntry.g;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localCloudDetectEntry.a);
        localQSecCloudQueryEntry.fileType.set(localDetectBundle.a);
        localQSecCloudQueryEntry.scenarioType.set(localDetectBundle.b);
        localQSecCloudQueryEntry.fileSize.set(localDetectBundle.c);
        if (localDetectBundle.f != null) {
          localQSecCloudQueryEntry.packageName.set(localDetectBundle.f);
        }
        if (localDetectBundle.d != null) {
          localQSecCloudQueryEntry.fileName.set(localDetectBundle.d);
        }
        if (localDetectBundle.g != null) {
          localQSecCloudQueryEntry.appName.set(localDetectBundle.g);
        }
        if (localDetectBundle.e != null) {
          localQSecCloudQueryEntry.fileMd5.set(localDetectBundle.e);
        }
        if (localDetectBundle.h != null) {
          localQSecCloudQueryEntry.certMd5.set(localDetectBundle.h);
        }
        if (localDetectBundle.i != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localDetectBundle.i));
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
  
  public static CloudAVEngineImpl a()
  {
    if (k == null) {
      try
      {
        if (k == null) {
          k = new CloudAVEngineImpl();
        }
      }
      finally {}
    }
    return k;
  }
  
  private void a(int paramInt)
  {
    CommTvRpt.a(2, paramInt);
  }
  
  private void a(int paramInt, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    CloudAVEngineImpl.CloudDetectEntry localCloudDetectEntry = (CloudAVEngineImpl.CloudDetectEntry)this.f.remove(Integer.valueOf(paramInt));
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
      if ((paramResultBundle.d != 0L) && (!TextUtils.isEmpty(localCloudDetectEntry.f))) {
        this.h.a(localCloudDetectEntry.f, paramResultBundle);
      }
      paramResultBundle.f = false;
      a(localCloudDetectEntry, 3, paramResultBundle);
    }
  }
  
  private void a(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    if (paramCloudDetectEntry == null) {
      return;
    }
    String str = paramCloudDetectEntry.g.a();
    paramCloudDetectEntry.g.e = str;
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { paramCloudDetectEntry.g.d, str }));
    }
  }
  
  private void a(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry, int paramInt, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if (paramCloudDetectEntry.h != null) {
      paramCloudDetectEntry.h.a(paramInt, paramCloudDetectEntry.g, paramResultBundle);
    }
  }
  
  private void a(Object paramObject)
  {
    int n;
    int m;
    try
    {
      paramObject = (QSecCloudAVEngineMsg.QSecCloudRespBody)paramObject;
      n = -1;
      m = n;
      if (paramObject.status == null) {
        break label439;
      }
      m = n;
      if (!paramObject.status.has()) {
        break label439;
      }
      m = paramObject.status.get();
    }
    catch (Exception paramObject)
    {
      label67:
      Iterator localIterator;
      label95:
      Object localObject;
      int i1;
      int i2;
      int i3;
      int i4;
      label276:
      paramObject.printStackTrace();
      return;
    }
    if ((paramObject.version != null) && (paramObject.version.has()))
    {
      m = paramObject.version.get();
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
            i1 = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).entryId.get();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).attrType == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).attrType.has())) {
              continue;
            }
            i2 = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).attrType.get();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).category == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).category.has())) {
              continue;
            }
            i3 = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).category.get();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).subCategory == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).subCategory.has())) {
              continue;
            }
            i4 = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).subCategory.get();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).timeToLive == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).timeToLive.has())) {
              break label452;
            }
            m = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).timeToLive.get();
            if ((((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).actionType == null) || (!((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).actionType.has())) {
              break label457;
            }
            n = ((QSecCloudAVEngineMsg.QSecCloudRespEntry)localObject).actionType.get();
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
      localResultBundle.a = i2;
      localResultBundle.b = i3;
      localResultBundle.c = i4;
      localResultBundle.e = n;
      if (m != 0) {
        localResultBundle.d = (new Date().getTime() + m * 1000);
      }
      localResultBundle.g = paramObject;
      a(i1, localResultBundle);
      break label95;
      this.h.a();
      return;
      return;
      label439:
      if (m == 0) {
        break;
      }
      return;
      m = 0;
      label446:
      if (m == 1) {
        break label67;
      }
      return;
      label452:
      m = 0;
      break label276;
      label457:
      n = 0;
    }
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return SecSvcHandlerHelper.a("QSec.AVEng", paramQSecCloudQuery.toByteArray());
  }
  
  private void b()
  {
    this.j += 1;
    if (this.j >= 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Rpt to %d", new Object[] { Integer.valueOf(this.j) }));
      }
      this.j = 0;
      a(1);
    }
  }
  
  private void b(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    if (paramCloudDetectEntry != null)
    {
      paramCloudDetectEntry.f = paramCloudDetectEntry.g.e;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Lookup cache, key: ");
        ((StringBuilder)localObject).append(paramCloudDetectEntry.f);
        QLog.d("QSec.AVEngine", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(paramCloudDetectEntry.f))
      {
        localObject = this.h.a(paramCloudDetectEntry.f);
        if (localObject != null)
        {
          ((ICloudAVEngine.ResultBundle)localObject).f = true;
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
      int i1 = paramObject.length;
      int m = 0;
      int n = 0;
      while (m < i1)
      {
        int i2 = paramObject[m];
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Timeout entry id:");
          ((StringBuilder)localObject).append(i2);
          QLog.d("QSec.AVEngine", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = (CloudAVEngineImpl.CloudDetectEntry)this.f.get(Integer.valueOf(i2));
        if (localObject != null) {
          if (((CloudAVEngineImpl.CloudDetectEntry)localObject).d < 1)
          {
            ((CloudAVEngineImpl.CloudDetectEntry)localObject).d += 1;
            f((CloudAVEngineImpl.CloudDetectEntry)localObject);
            n = 1;
          }
          else
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("No retry chance for entry id: ");
              localStringBuilder.append(i2);
              QLog.d("QSec.AVEngine", 2, localStringBuilder.toString());
            }
            b();
            this.f.remove(Integer.valueOf(i2));
            a((CloudAVEngineImpl.CloudDetectEntry)localObject, 2, null);
          }
        }
        m += 1;
      }
      if (n != 0) {
        flushRequest();
      }
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void b(List<CloudAVEngineImpl.CloudDetectEntry> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    int m = 0;
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
      this.f.put(Integer.valueOf(localCloudDetectEntry.a), localCloudDetectEntry);
      arrayOfInt[m] = localCloudDetectEntry.a;
      m += 1;
    }
    paramList = this.g;
    paramList.sendMessageDelayed(paramList.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  private CloudAVEngineImpl.CloudDetectEntry c(Object paramObject)
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
  
  private void c()
  {
    LinkedList localLinkedList = new LinkedList();
    int i2 = this.e.size();
    int m = 0;
    int n = 0;
    for (;;)
    {
      if (m < i2) {}
      try
      {
        localObject = (CloudAVEngineImpl.CloudDetectEntry)this.e.get(m);
        int i1 = ((CloudAVEngineImpl.CloudDetectEntry)localObject).e + n;
        if (i1 > 1000)
        {
          localObject = a(localLinkedList);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QSec.AVEngine", 2, String.format("Pack size: %d, count: %d", new Object[] { Integer.valueOf(n), Integer.valueOf(localLinkedList.size()) }));
            }
            b(localLinkedList);
            a((QSecCloudAVEngineMsg.QSecCloudQuery)localObject);
          }
          this.c -= n;
          this.b -= localLinkedList.size();
          localLinkedList.clear();
          m -= 1;
          n = 0;
        }
        else
        {
          localLinkedList.add(localObject);
          n = i1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        this.e.clear();
        this.c = 0;
        this.b = 0;
        localException.printStackTrace();
      }
      this.e.clear();
      if (localLinkedList.size() != 0)
      {
        if (this.d)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, String.format("Commit Left (%d:%d)", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.b) }));
          }
          localObject = a(localLinkedList);
          if (localObject != null)
          {
            b(localLinkedList);
            a((QSecCloudAVEngineMsg.QSecCloudQuery)localObject);
          }
          this.c = 0;
          this.b = 0;
          return;
        }
        this.e.addAll(localLinkedList);
        if (QLog.isColorLevel())
        {
          QLog.d("QSec.AVEngine", 2, String.format("Has %d(count: %d) left.", new Object[] { Integer.valueOf(this.c), Integer.valueOf(localLinkedList.size()) }));
          return;
        }
      }
      return;
      m += 1;
    }
  }
  
  private void c(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    if (paramCloudDetectEntry != null)
    {
      int m = this.a;
      this.a = (m + 1);
      paramCloudDetectEntry.a = m;
      paramCloudDetectEntry.d = 0;
      f(paramCloudDetectEntry);
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
    if (TextUtils.isEmpty(paramCloudDetectEntry.g.e))
    {
      a(paramCloudDetectEntry);
      if (TextUtils.isEmpty(paramCloudDetectEntry.g.e))
      {
        a(paramCloudDetectEntry, 4, null);
        return;
      }
    }
    if (paramCloudDetectEntry.b)
    {
      b(paramCloudDetectEntry);
      return;
    }
    c(paramCloudDetectEntry);
  }
  
  private int e(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    paramCloudDetectEntry = paramCloudDetectEntry.g;
    String str = paramCloudDetectEntry.d;
    int n = 16;
    if (str != null) {
      n = 16 + paramCloudDetectEntry.d.length();
    }
    int m = n;
    if (paramCloudDetectEntry.e != null) {
      m = n + paramCloudDetectEntry.e.length();
    }
    n = m;
    if (paramCloudDetectEntry.f != null) {
      n = m + paramCloudDetectEntry.f.length();
    }
    m = n;
    if (paramCloudDetectEntry.g != null) {
      m = n + paramCloudDetectEntry.g.length();
    }
    n = m;
    if (paramCloudDetectEntry.h != null) {
      n = m + paramCloudDetectEntry.h.length();
    }
    m = n;
    if (paramCloudDetectEntry.i != null) {
      m = n + paramCloudDetectEntry.i.length;
    }
    return m;
  }
  
  private void f(CloudAVEngineImpl.CloudDetectEntry paramCloudDetectEntry)
  {
    if (this.b >= 100)
    {
      a(paramCloudDetectEntry, 1, null);
      return;
    }
    if (paramCloudDetectEntry.e == 0) {
      paramCloudDetectEntry.e = e(paramCloudDetectEntry);
    }
    this.c += paramCloudDetectEntry.e;
    this.b += 1;
    this.e.add(paramCloudDetectEntry);
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(paramCloudDetectEntry.a), Integer.valueOf(this.b), Integer.valueOf(this.c) }));
    }
    if ((paramCloudDetectEntry.c == true) || (this.c >= 1000)) {
      c();
    }
  }
  
  public int cloudDetect(ICloudAVEngine.DetectBundle paramDetectBundle, boolean paramBoolean1, boolean paramBoolean2, ICloudAVEngine.IAVEngineEventListener paramIAVEngineEventListener)
  {
    if (paramDetectBundle == null) {
      return 13;
    }
    CloudAVEngineImpl.CloudDetectEntry localCloudDetectEntry = new CloudAVEngineImpl.CloudDetectEntry(null);
    localCloudDetectEntry.b = paramBoolean1;
    localCloudDetectEntry.c = paramBoolean2;
    localCloudDetectEntry.g = paramDetectBundle;
    localCloudDetectEntry.h = paramIAVEngineEventListener;
    if ((paramDetectBundle.c == 0) && (!TextUtils.isEmpty(paramDetectBundle.d))) {
      paramDetectBundle.c = ((int)new File(paramDetectBundle.d).length());
    }
    paramDetectBundle = this.g;
    paramDetectBundle.sendMessage(paramDetectBundle.obtainMessage(1, localCloudDetectEntry));
    return 0;
  }
  
  public void flushRequest()
  {
    CloudAVEngineImpl.AVEngineHandler localAVEngineHandler = this.g;
    localAVEngineHandler.sendMessage(localAVEngineHandler.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl
 * JD-Core Version:    0.7.0.1
 */