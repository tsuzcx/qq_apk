import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class dh
  implements biet
{
  dh(dg paramdg) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.a.a.app.getDataLineMsgProxy(0).a(paramString);
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
            this.a.a.app.getMessageFacade().getDatalineMessageManager(0).c(((DataLineMsgRecord)localObject).msgId);
            this.a.a.a(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(true), Long.valueOf(((DataLineMsgRecord)localObject).filesize) });
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
                this.a.a.app.getMessageFacade().getDatalineMessageManager(0).c();
                this.a.a.a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
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
                dq.g(this.a.a.app);
                ((DataLineMsgRecord)localObject).issuc = true;
                ((DataLineMsgRecord)localObject).progress = 1.0F;
                ((DataLineMsgRecord)localObject).path = bies.a().a(((DataLineMsgRecord)localObject).strMoloKey);
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
                this.a.a.app.getDataLineMsgProxy(0).a(((DataLineMsgRecord)localObject).msgId, ((DataLineMsgRecord)localObject).path);
                this.a.a.app.getMessageFacade().getDatalineMessageManager(0).c();
                this.a.a.a(3, true, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
                this.a.a.a().getMessageFacade().getDatalineMessageManager(0).a(((DataLineMsgRecord)localObject).msgId);
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
                    this.a.a.app.getMessageFacade().getDatalineMessageManager(0).c(((DataLineMsgRecord)localObject).msgId);
                    this.a.a.app.getMessageFacade().getDatalineMessageManager(0).c();
                    this.a.a.a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
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
      dq.i(this.a.a.app);
      this.a.a.a(9, true, new Object[] { paramString });
      return;
    } while (!QLog.isColorLevel());
    label661:
    QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.WAIT(" + paramString + ")");
  }
  
  public void a(bieu parambieu, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if ((parambieu == null) || (paramInt1 == -25))
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.MoloHandler", 2, "onDownloadError( tm exit)");
      }
      paramString = this.a.a.a().getProxyManager().a(0).a();
      parambieu = this.a.a.a().getProxyManager().a(0).a(true);
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
            this.a.a.app.getMessageFacade().getDatalineMessageManager(0).c();
            this.a.a.a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path });
          }
        }
      }
      if (parambieu != null) {
        parambieu = parambieu.iterator();
      }
    }
    else
    {
      while (parambieu.hasNext())
      {
        paramString = ((DataLineMsgSet)parambieu.next()).values().iterator();
        while (paramString.hasNext())
        {
          localObject = (DataLineMsgRecord)paramString.next();
          if ((((DataLineMsgRecord)localObject).strMoloKey != null) && ((!((DataLineMsgRecord)localObject).issuc) || (((DataLineMsgRecord)localObject).progress != 1.0F)))
          {
            ((DataLineMsgRecord)localObject).issuc = false;
            this.a.a.app.getMessageFacade().getDatalineMessageManager(0).c();
            this.a.a.a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
          }
        }
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("dataline.MoloHandler", 2, "onDownloadError(" + parambieu.toString() + "), key[" + parambieu.a + "], errorCode" + paramInt1 + "], state[" + paramInt2);
        }
        parambieu = this.a.a.app.getDataLineMsgProxy(0).a(parambieu.a);
        if (parambieu != null) {
          break label460;
        }
      }
    }
    for (;;)
    {
      return;
      label460:
      parambieu = parambieu.iterator();
      while (parambieu.hasNext())
      {
        paramString = (DataLineMsgRecord)parambieu.next();
        dq.l(this.a.a.app);
        paramString.issuc = false;
        this.a.a.app.getMessageFacade().getDatalineMessageManager(0).c();
        this.a.a.a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramString.sessionid), paramString.path });
      }
    }
  }
  
  public void a(List<bieu> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bieu localbieu = (bieu)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("dataline.MoloHandler", 2, "onDownloadUpdatem key[" + localbieu.a + "], appName[" + localbieu.e + "], progress[" + localbieu.f);
      }
      Object localObject = this.a.a.app.getDataLineMsgProxy(0).a(localbieu.a);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
          float f = localbieu.f / 100.0F;
          if (localDataLineMsgRecord.progress < f) {
            localDataLineMsgRecord.progress = f;
          }
          this.a.a.a(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), Float.valueOf(f) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dh
 * JD-Core Version:    0.7.0.1
 */