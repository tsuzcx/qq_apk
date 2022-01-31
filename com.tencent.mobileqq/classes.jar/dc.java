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

class dc
  implements bfre
{
  dc(db paramdb) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.a.a.app.a(0).a(paramString);
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
            this.a.a.app.a().a(0).c(((DataLineMsgRecord)localObject).msgId);
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
                this.a.a.app.a().a(0).c();
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
                dl.g(this.a.a.app);
                ((DataLineMsgRecord)localObject).issuc = true;
                ((DataLineMsgRecord)localObject).progress = 1.0F;
                ((DataLineMsgRecord)localObject).path = bfrd.a().a(((DataLineMsgRecord)localObject).strMoloKey);
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
                this.a.a.app.a(0).a(((DataLineMsgRecord)localObject).msgId, ((DataLineMsgRecord)localObject).path);
                this.a.a.app.a().a(0).c();
                this.a.a.a(3, true, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
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
                    this.a.a.app.a().a(0).c(((DataLineMsgRecord)localObject).msgId);
                    this.a.a.app.a().a(0).c();
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
      dl.i(this.a.a.app);
      this.a.a.a(9, true, new Object[] { paramString });
      return;
    } while (!QLog.isColorLevel());
    label661:
    QLog.d("dataline.MoloHandler", 2, "OnDownloadListener.WAIT(" + paramString + ")");
  }
  
  public void a(bfrf parambfrf, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if ((parambfrf == null) || (paramInt1 == -25))
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.MoloHandler", 2, "onDownloadError( tm exit)");
      }
      paramString = this.a.a.a().a().a(0).a();
      parambfrf = this.a.a.a().a().a(0).a(true);
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
            this.a.a.app.a().a(0).c();
            this.a.a.a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path });
          }
        }
      }
      if (parambfrf != null) {
        parambfrf = parambfrf.iterator();
      }
    }
    else
    {
      while (parambfrf.hasNext())
      {
        paramString = ((DataLineMsgSet)parambfrf.next()).values().iterator();
        while (paramString.hasNext())
        {
          localObject = (DataLineMsgRecord)paramString.next();
          if ((((DataLineMsgRecord)localObject).strMoloKey != null) && ((!((DataLineMsgRecord)localObject).issuc) || (((DataLineMsgRecord)localObject).progress != 1.0F)))
          {
            ((DataLineMsgRecord)localObject).issuc = false;
            this.a.a.app.a().a(0).c();
            this.a.a.a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path });
          }
        }
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("dataline.MoloHandler", 2, "onDownloadError(" + parambfrf.toString() + "), key[" + parambfrf.a + "], errorCode" + paramInt1 + "], state[" + paramInt2);
        }
        parambfrf = this.a.a.app.a(0).a(parambfrf.a);
        if (parambfrf != null) {
          break label460;
        }
      }
    }
    for (;;)
    {
      return;
      label460:
      parambfrf = parambfrf.iterator();
      while (parambfrf.hasNext())
      {
        paramString = (DataLineMsgRecord)parambfrf.next();
        dl.l(this.a.a.app);
        paramString.issuc = false;
        this.a.a.app.a().a(0).c();
        this.a.a.a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramString.sessionid), paramString.path });
      }
    }
  }
  
  public void a(List<bfrf> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bfrf localbfrf = (bfrf)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("dataline.MoloHandler", 2, "onDownloadUpdatem key[" + localbfrf.a + "], appName[" + localbfrf.e + "], progress[" + localbfrf.f);
      }
      Object localObject = this.a.a.app.a(0).a(localbfrf.a);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
          float f = localbfrf.f / 100.0F;
          if (localDataLineMsgRecord.progress < f) {
            localDataLineMsgRecord.progress = f;
          }
          this.a.a.a(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), Float.valueOf(f) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dc
 * JD-Core Version:    0.7.0.1
 */