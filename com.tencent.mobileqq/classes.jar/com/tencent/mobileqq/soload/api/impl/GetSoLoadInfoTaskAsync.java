package com.tencent.mobileqq.soload.api.impl;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.RelatedFileInfo;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.soload.config.SoConfigManager;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import com.tencent.mobileqq.soload.util.SoReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class GetSoLoadInfoTaskAsync
  extends AbsGetSoLoadInfoTask
{
  private static final Map<String, List<OnGetSoLoadInfoListener>> j = new HashMap();
  private static final Map<String, Long> k = new HashMap();
  private static final AtomicBoolean l = new AtomicBoolean(false);
  private static final byte[] m = new byte[0];
  private static final BroadcastReceiver n = new GetSoLoadInfoTaskAsync.5();
  
  public GetSoLoadInfoTaskAsync(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    super(paramLoadParam, paramLoadItem);
    f();
  }
  
  private void a(OnSoGetPathListener paramOnSoGetPathListener)
  {
    if ((this.h != null) && (this.h.relatedFileInfo != null))
    {
      String str1 = this.h.relatedFileInfo.url;
      String str2 = this.h.relatedFileInfo.md5;
      boolean bool;
      if (this.a.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
        bool = true;
      } else {
        bool = false;
      }
      SoLoadUtils.a(str1, str2, bool, paramOnSoGetPathListener);
    }
  }
  
  private void a(LoadParam.LoadItem paramLoadItem)
  {
    SoLocalInfo localSoLocalInfo = SoLoadUtils.a(paramLoadItem, this.h);
    boolean bool2 = a(localSoLocalInfo);
    boolean bool3 = a(localSoLocalInfo, this.h);
    boolean bool1;
    if (((this.b.lops.flag & 0x4) != 0) && (this.a.mCallType != LoadParam.CALL_TYPE_ASYNC_BY_SYNC)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleSoAndRelatedFile] isSoExist=");
      localStringBuilder.append(bool2);
      localStringBuilder.append(",rfolderOk=");
      localStringBuilder.append(bool3);
      localStringBuilder.append(",isWeak:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",loadItemName:");
      localStringBuilder.append(paramLoadItem.name);
      localStringBuilder.append(",filePath:");
      localStringBuilder.append(localSoLocalInfo.mSoPath);
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, localStringBuilder.toString());
    }
    this.e = (bool2 ^ true);
    if (!bool2)
    {
      b(new GetSoLoadInfoTaskAsync.3(this, paramLoadItem, bool3, bool1, localSoLocalInfo));
      return;
    }
    a(bool3, bool1, localSoLocalInfo, localSoLocalInfo.mSoPath, localSoLocalInfo.mSoCRC, 1);
  }
  
  private void a(LoadParam.LoadItem paramLoadItem, SoInfo paramSoInfo)
  {
    if (!a(paramSoInfo))
    {
      b(2);
      return;
    }
    paramSoInfo = SoLoadUtils.a(this.b.name, this.h.ver);
    if ((paramSoInfo != null) && (paramSoInfo.d()))
    {
      if (QLog.isColorLevel())
      {
        paramLoadItem = new StringBuilder();
        paramLoadItem.append("[handleConfig] InLoadCrashProtectMode, crashInfo=");
        paramLoadItem.append(paramSoInfo);
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, paramLoadItem.toString());
      }
      this.i = "loadcrash";
      b(8);
      return;
    }
    if ((paramSoInfo != null) && (paramSoInfo.g()))
    {
      a(paramLoadItem, paramSoInfo);
      return;
    }
    a(paramLoadItem);
  }
  
  private void a(LoadParam.LoadItem paramLoadItem, SoCrashInfo paramSoCrashInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleConfig] isNeedReqForCrash, crashInfo=");
      ((StringBuilder)localObject).append(paramSoCrashInfo);
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h.ver;
    SoConfigManager.a().a(paramLoadItem.name, paramSoCrashInfo, new GetSoLoadInfoTaskAsync.2(this, (String)localObject, paramSoCrashInfo, paramLoadItem));
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (a(paramString2, paramLong, this.b, this.h, paramInt))
    {
      this.g = paramString1;
      this.f = paramString2;
      b(0);
      return;
    }
    b(10);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, SoLocalInfo paramSoLocalInfo, String paramString, long paramLong, int paramInt)
  {
    if (paramBoolean1)
    {
      a(paramSoLocalInfo.mRFileFolder, paramString, paramLong, paramInt);
      return;
    }
    if (paramBoolean2)
    {
      a(null);
      a(null, paramString, paramLong, paramInt);
      return;
    }
    a(new GetSoLoadInfoTaskAsync.4(this, paramString, paramLong, paramInt));
  }
  
  private void b(int paramInt)
  {
    SoLoadInfo localSoLoadInfo = a(paramInt);
    synchronized (m)
    {
      Object localObject3 = (List)j.get(this.b.name);
      j.remove(this.b.name);
      k.remove(this.b.name);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onSoResult] loadItemName:");
        localStringBuilder.append(this.b.name);
        localStringBuilder.append(",resCode:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",LOADING_SO_NAMES:");
        localStringBuilder.append(j);
        localStringBuilder.append(",LOADING_SO_TIMES:");
        localStringBuilder.append(k);
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, localStringBuilder.toString());
      }
      if (localObject3 != null)
      {
        ??? = ((List)localObject3).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (OnGetSoLoadInfoListener)((Iterator)???).next();
          if (localObject3 != null) {
            ((OnGetSoLoadInfoListener)localObject3).onGetLoadInfo(localSoLoadInfo);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private void b(OnSoGetPathListener paramOnSoGetPathListener)
  {
    if (this.a != null)
    {
      if (this.h != null)
      {
        String str1 = this.h.url;
        String str2 = this.h.md5;
        boolean bool;
        if (this.a.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
          bool = true;
        } else {
          bool = false;
        }
        SoLoadUtils.a(str1, str2, bool, paramOnSoGetPathListener);
      }
      SoReportUtil.a(this.a, this.a.mReportSeq, null, "load.item.download.start", null, 0, null);
    }
  }
  
  private boolean b(OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener)
  {
    long l2;
    boolean bool2;
    boolean bool1;
    long l1;
    label347:
    synchronized (m)
    {
      l2 = System.currentTimeMillis();
      Object localObject = j.entrySet().iterator();
      Map.Entry localEntry;
      String str;
      do
      {
        boolean bool3 = ((Iterator)localObject).hasNext();
        bool2 = false;
        bool1 = bool2;
        if (!bool3) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject).next();
        str = (String)localEntry.getKey();
      } while ((TextUtils.isEmpty(str)) || (!TextUtils.equals(str, this.b.name)));
      ((List)localEntry.getValue()).add(paramOnGetSoLoadInfoListener);
      if (k.get(this.b.name) != null)
      {
        l1 = ((Long)k.get(this.b.name)).longValue();
        break label347;
        if (j.get(this.b.name) == null)
        {
          localObject = new LinkedList();
          ((List)localObject).add(paramOnGetSoLoadInfoListener);
          j.put(this.b.name, localObject);
        }
        if (!bool1) {
          k.put(this.b.name, Long.valueOf(l2));
        }
        if (QLog.isColorLevel())
        {
          paramOnGetSoLoadInfoListener = new StringBuilder();
          paramOnGetSoLoadInfoListener.append("[insertInSameNameReqList] loadItemName:");
          paramOnGetSoLoadInfoListener.append(this.b.name);
          paramOnGetSoLoadInfoListener.append(",LOADING_SO_NAMES:");
          paramOnGetSoLoadInfoListener.append(j);
          paramOnGetSoLoadInfoListener.append(",LOADING_SO_TIMES:");
          paramOnGetSoLoadInfoListener.append(k);
          paramOnGetSoLoadInfoListener.append(",mergeReq:");
          paramOnGetSoLoadInfoListener.append(bool1);
          QLog.i("SoLoadWidget.GetSoTaskAsync", 2, paramOnGetSoLoadInfoListener.toString());
        }
        return bool1;
      }
    }
  }
  
  private void f()
  {
    if ((MobileQQ.sMobileQQ != null) && (!l.getAndSet(true)))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqq.intent.action.EXIT_");
      localStringBuilder.append(MobileQQ.sMobileQQ.getPackageName());
      localIntentFilter.addAction(localStringBuilder.toString());
      try
      {
        MobileQQ.sMobileQQ.registerReceiver(n, localIntentFilter);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SoLoadWidget.GetSoTaskAsync", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void a(OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "not main process get loadInfo by IPC");
      }
      SoLoadUtils.a(this.a, this.b, paramOnGetSoLoadInfoListener);
      return;
    }
    if (b(paramOnGetSoLoadInfoListener))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "insert into same req list");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "<<<getSoInfo in main process<<<");
    }
    SoReportUtil.a(this.a, this.a.mReportSeq, null, "load.item.getconfig.start", this.b.name, 0, null);
    SoConfigManager.a().a(this.b.name, new GetSoLoadInfoTaskAsync.1(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskAsync
 * JD-Core Version:    0.7.0.1
 */