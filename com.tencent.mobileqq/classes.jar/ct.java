import com.dataline.core.MoloHandler;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.open.pcpush.PCPushProxy;
import com.tencent.open.pcpush.PCPushProxy.OnDownloadListener;
import com.tencent.open.pcpush.PCPushProxy.PkgEntry;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ct
  implements PCPushProxy.OnDownloadListener
{
  public ct(MoloHandler paramMoloHandler) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.a.a.b.a(0).a(paramString);
    switch (paramInt)
    {
    }
    label435:
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.START(" + paramString + ")");
        }
        if (localObject != null)
        {
          paramString = ((List)localObject).iterator();
          while (paramString.hasNext())
          {
            localObject = (DataLineMsgRecord)paramString.next();
            ((DataLineMsgRecord)localObject).issuc = true;
            ((DataLineMsgRecord)localObject).fileMsgStatus = 0L;
            this.a.a.b.a().a(0).c(((DataLineMsgRecord)localObject).msgId);
            this.a.a.b(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(true), Long.valueOf(((DataLineMsgRecord)localObject).filesize) });
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.CANCEL(" + paramString + ")");
          }
          if (localObject != null)
          {
            paramString = ((List)localObject).iterator();
            while (paramString.hasNext())
            {
              localObject = (DataLineMsgRecord)paramString.next();
              if ((!((DataLineMsgRecord)localObject).issuc) || (((DataLineMsgRecord)localObject).progress != 1.0F))
              {
                ((DataLineMsgRecord)localObject).issuc = false;
                this.a.a.b.a().a(0).c();
                this.a.a.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
              }
            }
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.FINISH(" + paramString + ")");
            }
            if (localObject != null)
            {
              paramString = ((List)localObject).iterator();
              if (paramString.hasNext())
              {
                localObject = (DataLineMsgRecord)paramString.next();
                DataLineReportUtil.g(this.a.a.b);
                ((DataLineMsgRecord)localObject).issuc = true;
                ((DataLineMsgRecord)localObject).progress = 1.0F;
                ((DataLineMsgRecord)localObject).path = PCPushProxy.a().a(((DataLineMsgRecord)localObject).strMoloKey);
                if (QLog.isColorLevel())
                {
                  if (((DataLineMsgRecord)localObject).path == null) {
                    break label661;
                  }
                  QLog.d("dataline.MoloHandler", 2, "PCPushProxy.getDownloadPath(" + ((DataLineMsgRecord)localObject).strMoloKey + ") \"" + ((DataLineMsgRecord)localObject).path + "'");
                }
              }
              for (;;)
              {
                this.a.a.b.a(0).a(((DataLineMsgRecord)localObject).msgId, ((DataLineMsgRecord)localObject).path);
                this.a.a.b.a().a(0).c();
                this.a.a.b(3, true, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
                this.a.a.a().a().a(0).a(((DataLineMsgRecord)localObject).msgId);
                break label435;
                break;
                QLog.d("dataline.MoloHandler", 2, "PCPushProxy.getDownloadPath(" + ((DataLineMsgRecord)localObject).strMoloKey + ") NULL");
              }
              if (QLog.isColorLevel()) {
                QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.PAUSE(" + paramString + ")");
              }
              if (localObject != null)
              {
                paramString = ((List)localObject).iterator();
                while (paramString.hasNext())
                {
                  localObject = (DataLineMsgRecord)paramString.next();
                  if ((!((DataLineMsgRecord)localObject).issuc) || (((DataLineMsgRecord)localObject).progress != 1.0F))
                  {
                    ((DataLineMsgRecord)localObject).issuc = false;
                    ((DataLineMsgRecord)localObject).fileMsgStatus = 2L;
                    this.a.a.b.a().a(0).c(((DataLineMsgRecord)localObject).msgId);
                    this.a.a.b.a().a(0).c();
                    this.a.a.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
                  }
                }
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.INSTALLED(" + paramString + ")");
      }
      DataLineReportUtil.i(this.a.a.b);
      this.a.a.b(9, true, new Object[] { paramString });
      return;
    } while (!QLog.isColorLevel());
    label661:
    QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.WAIT(" + paramString + ")");
  }
  
  public void a(PCPushProxy.PkgEntry paramPkgEntry, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if ((paramPkgEntry == null) || (paramInt1 == -25))
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.MoloHandler", 2, "onDownloadError( tm exit)");
      }
      paramString = this.a.a.a().a().a(0).a();
      paramPkgEntry = this.a.a.a().a().a(0).a(true);
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = ((DataLineMsgSet)paramString.next()).values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
          if ((localDataLineMsgRecord.strMoloKey != null) && ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress != 1.0F)))
          {
            localDataLineMsgRecord.issuc = false;
            this.a.a.b.a().a(0).c();
            this.a.a.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path });
          }
        }
      }
      if (paramPkgEntry != null) {
        paramPkgEntry = paramPkgEntry.iterator();
      }
    }
    else
    {
      while (paramPkgEntry.hasNext())
      {
        paramString = ((DataLineMsgSet)paramPkgEntry.next()).values().iterator();
        while (paramString.hasNext())
        {
          localObject = (DataLineMsgRecord)paramString.next();
          if ((((DataLineMsgRecord)localObject).strMoloKey != null) && ((!((DataLineMsgRecord)localObject).issuc) || (((DataLineMsgRecord)localObject).progress != 1.0F)))
          {
            ((DataLineMsgRecord)localObject).issuc = false;
            this.a.a.b.a().a(0).c();
            this.a.a.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
          }
        }
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("dataline.MoloHandler", 2, "onDownloadError(" + paramPkgEntry.toString() + "), key[" + paramPkgEntry.a + "], errorCode" + paramInt1 + "], state[" + paramInt2);
        }
        paramPkgEntry = this.a.a.b.a(0).a(paramPkgEntry.a);
        if (paramPkgEntry != null) {
          break label460;
        }
      }
    }
    for (;;)
    {
      return;
      label460:
      paramPkgEntry = paramPkgEntry.iterator();
      while (paramPkgEntry.hasNext())
      {
        paramString = (DataLineMsgRecord)paramPkgEntry.next();
        DataLineReportUtil.l(this.a.a.b);
        paramString.issuc = false;
        this.a.a.b.a().a(0).c();
        this.a.a.b(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramString.sessionid), paramString.path });
      }
    }
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PCPushProxy.PkgEntry localPkgEntry = (PCPushProxy.PkgEntry)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("dataline.MoloHandler", 2, "onDownloadUpdatem key[" + localPkgEntry.a + "], appName[" + localPkgEntry.e + "], progress[" + localPkgEntry.f);
      }
      Object localObject = this.a.a.b.a(0).a(localPkgEntry.a);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
          float f = localPkgEntry.f / 100.0F;
          if (localDataLineMsgRecord.progress < f) {
            localDataLineMsgRecord.progress = f;
          }
          this.a.a.b(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), Float.valueOf(f) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ct
 * JD-Core Version:    0.7.0.1
 */