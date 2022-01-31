import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cz
{
  ajgm jdField_a_of_type_Ajgm;
  private bcji jdField_a_of_type_Bcji = new da(this);
  
  public cz(ajgm paramajgm)
  {
    this.jdField_a_of_type_Ajgm = paramajgm;
    bcjh.a().a(this.jdField_a_of_type_Bcji);
  }
  
  private long a(String paramString)
  {
    try
    {
      paramString = paramString.toUpperCase();
      int i = paramString.indexOf('G');
      if (i != -1) {
        return (Float.parseFloat(paramString.substring(0, i)) * 1024.0F * 1024.0F * 1024.0F);
      }
      i = paramString.indexOf('M');
      if (i != -1) {
        return (Float.parseFloat(paramString.substring(0, i)) * 1024.0F * 1024.0F);
      }
      i = paramString.indexOf('K');
      if (i != -1) {
        return (Float.parseFloat(paramString.substring(0, i)) * 1024.0F);
      }
      i = paramString.indexOf('B');
      if (i != -1)
      {
        float f = Float.parseFloat(paramString.substring(0, i));
        return f;
      }
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public int a(String paramString)
  {
    dj.j(this.jdField_a_of_type_Ajgm.app);
    int i = bcjh.a().a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy open(" + paramString + "):" + i);
    }
    return i;
  }
  
  public DataLineMsgRecord a(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    Object localObject = null;
    bcjh.a().a(this.jdField_a_of_type_Bcji);
    for (;;)
    {
      try
      {
        bcjj localbcjj = bcjh.a().a(paramArrayOfByte);
        paramArrayOfByte = localObject;
        if (localbcjj != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("dataline.MoloHandler", 2, "dealWith new pkgEntry:" + localbcjj.e);
          }
          long l = this.jdField_a_of_type_Ajgm.a(0).longValue();
          paramArrayOfByte = new DataLineMsgRecord();
          paramArrayOfByte.msg = this.jdField_a_of_type_Ajgm.a().getApp().getString(2131628257);
          paramArrayOfByte.msgtype = -2335;
          paramArrayOfByte.sessionid = l;
          paramArrayOfByte.isread = false;
          paramArrayOfByte.path = null;
          paramArrayOfByte.thumbPath = null;
          paramArrayOfByte.filename = localbcjj.e;
          paramArrayOfByte.filesize = a(localbcjj.h);
          paramArrayOfByte.issuc = false;
          paramArrayOfByte.vipBubbleID = this.jdField_a_of_type_Ajgm.b();
          paramArrayOfByte.time = awao.a();
          paramArrayOfByte.strMoloKey = localbcjj.a;
          paramArrayOfByte.strMoloSource = localbcjj.i;
          paramArrayOfByte.strMoloIconUrl = localbcjj.g;
          paramArrayOfByte.strMoloSrcIconUrl = localbcjj.j;
          if (localbcjj.b != 1) {
            break label299;
          }
          bool1 = true;
          paramArrayOfByte.bIsApkFile = bool1;
          if (apck.a(paramArrayOfByte.filename) != 0) {
            break label304;
          }
          bool1 = bool2;
          paramArrayOfByte.bIsMoloImage = bool1;
          paramArrayOfByte.fileMsgStatus = 1L;
        }
      }
      catch (Exception localException)
      {
        paramArrayOfByte = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("dataline.MoloHandler", 2, "PCPushProxy.parse Exception:" + localException.toString());
        return null;
      }
      return paramArrayOfByte;
      label299:
      boolean bool1 = false;
      continue;
      label304:
      bool1 = false;
    }
  }
  
  public void a()
  {
    bcjh.a().b(this.jdField_a_of_type_Bcji);
  }
  
  public void a(int paramInt)
  {
    bcjh.a().a(paramInt);
  }
  
  public boolean a()
  {
    Object localObject2 = this.jdField_a_of_type_Ajgm.a().a().a(0).a();
    Object localObject1 = this.jdField_a_of_type_Ajgm.a().a().a(0).a(true);
    localObject2 = ((DataLineMsgSetList)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((DataLineMsgSet)((Iterator)localObject2).next()).values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject3).next();
        if (localDataLineMsgRecord.strMoloKey != null) {
          c(localDataLineMsgRecord.strMoloKey);
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((DataLineMsgSetList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (DataLineMsgRecord)((Iterator)localObject2).next();
          if (((DataLineMsgRecord)localObject3).strMoloKey != null) {
            c(((DataLineMsgRecord)localObject3).strMoloKey);
          }
        }
      }
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = bcjh.a().a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy start(" + paramString + "):" + bool);
    }
    if (bool)
    {
      paramString = this.jdField_a_of_type_Ajgm.app.a(0).a(paramString);
      if (paramString == null) {
        return bool;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramString.next();
        localDataLineMsgRecord.issuc = true;
        localDataLineMsgRecord.fileMsgStatus = 0L;
        this.jdField_a_of_type_Ajgm.app.a().a(0).c(localDataLineMsgRecord.msgId);
        this.jdField_a_of_type_Ajgm.a(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(true), Long.valueOf(localDataLineMsgRecord.filesize) });
      }
    }
    return bool;
  }
  
  public void b(int paramInt)
  {
    bcjh.a().b(paramInt);
  }
  
  public boolean b()
  {
    Object localObject2 = this.jdField_a_of_type_Ajgm.a().a().a(0).a();
    Object localObject1 = this.jdField_a_of_type_Ajgm.a().a().a(0).a(true);
    localObject2 = ((DataLineMsgSetList)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((DataLineMsgSet)((Iterator)localObject2).next()).values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject3).next();
        if (localDataLineMsgRecord.strMoloKey != null) {
          d(localDataLineMsgRecord.strMoloKey);
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((DataLineMsgSetList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (DataLineMsgRecord)((Iterator)localObject2).next();
          if (((DataLineMsgRecord)localObject3).strMoloKey != null) {
            d(((DataLineMsgRecord)localObject3).strMoloKey);
          }
        }
      }
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    dj.h(this.jdField_a_of_type_Ajgm.app);
    bcjh.a().b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy install : " + paramString);
    }
    return true;
  }
  
  public boolean c(String paramString)
  {
    bcjh.a().a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy pause(" + paramString + ")");
    }
    return true;
  }
  
  public boolean d(String paramString)
  {
    bcjh.a().c(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy delete(" + paramString + ")");
    }
    return true;
  }
  
  public boolean e(String paramString)
  {
    boolean bool = bcjh.a().b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy isInstalled(" + paramString + "):" + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     cz
 * JD-Core Version:    0.7.0.1
 */