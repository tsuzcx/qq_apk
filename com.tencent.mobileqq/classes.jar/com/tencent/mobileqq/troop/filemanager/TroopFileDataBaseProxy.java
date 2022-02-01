package com.tencent.mobileqq.troop.filemanager;

import android.content.ContentValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;
import mqq.app.AppRuntime;

public class TroopFileDataBaseProxy
  extends BaseProxy
{
  public TroopFileDataBaseProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  private ContentValues a(Entity paramEntity)
  {
    ContentValues localContentValues = new ContentValues();
    List localList = TableBuilder.getValidField(paramEntity.getClass());
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = (Field)localList.get(i);
      String str = ((Field)localObject2).getName();
      if (!((Field)localObject2).isAccessible()) {
        ((Field)localObject2).setAccessible(true);
      }
      Object localObject1 = null;
      try
      {
        localObject2 = ((Field)localObject2).get(paramEntity);
        localObject1 = localObject2;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      if ((localObject1 instanceof Integer)) {
        localContentValues.put(str, (Integer)localObject1);
      } else if ((localObject1 instanceof Long)) {
        localContentValues.put(str, (Long)localObject1);
      } else if ((localObject1 instanceof String)) {
        localContentValues.put(str, (String)localObject1);
      } else if ((localObject1 instanceof byte[])) {
        localContentValues.put(str, (byte[])localObject1);
      } else if ((localObject1 instanceof Short)) {
        localContentValues.put(str, (Short)localObject1);
      } else if ((localObject1 instanceof Boolean)) {
        localContentValues.put(str, (Boolean)localObject1);
      } else if ((localObject1 instanceof Double)) {
        localContentValues.put(str, (Double)localObject1);
      } else if ((localObject1 instanceof Float)) {
        localContentValues.put(str, (Float)localObject1);
      } else if ((localObject1 instanceof Byte)) {
        localContentValues.put(str, (Byte)localObject1);
      }
      i += 1;
    }
    return localContentValues;
  }
  
  public List<TroopFileTansferItemEntity> a(long paramLong)
  {
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    Object localObject = new TroopFileTansferItemEntity();
    ((TroopFileTansferItemEntity)localObject).troopuin = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(((TroopFileTansferItemEntity)localObject).getTableName());
    localStringBuilder.append(" where troopuin = ?");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    return localEntityManager.rawQuery(TroopFileTansferItemEntity.class, (String)localObject, new String[] { localStringBuilder.toString() });
  }
  
  public void a(long paramLong, UUID paramUUID)
  {
    if (paramUUID == null) {
      return;
    }
    int i = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramUUID.toString());
    ((StringBuilder)localObject).append("] deleteItem");
    TroopFileTransferUtil.Log.c("TroopFileDataBaseProxy", i, ((StringBuilder)localObject).toString());
    localObject = new TroopFileTansferItemEntity();
    ((TroopFileTansferItemEntity)localObject).troopuin = paramLong;
    localObject = ((TroopFileTansferItemEntity)localObject).getTableName();
    String str = paramUUID.toString();
    paramUUID = new TroopFileDataBaseProxy.3(this, paramUUID);
    a((String)localObject, "_sId=?", new String[] { str }, paramUUID);
  }
  
  public void a(TroopFileTansferItemEntity paramTroopFileTansferItemEntity)
  {
    if (paramTroopFileTansferItemEntity != null)
    {
      if (paramTroopFileTansferItemEntity.Id == null) {
        return;
      }
      int i = TroopFileTransferUtil.Log.b;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(paramTroopFileTansferItemEntity.Id.toString());
      ((StringBuilder)localObject).append("] updateItem transStatus[");
      ((StringBuilder)localObject).append(paramTroopFileTansferItemEntity.Status);
      ((StringBuilder)localObject).append("] FilePath[");
      ((StringBuilder)localObject).append(paramTroopFileTansferItemEntity.FilePath);
      ((StringBuilder)localObject).append("]");
      TroopFileTransferUtil.Log.c("TroopFileDataBaseProxy", i, ((StringBuilder)localObject).toString());
      i = paramTroopFileTansferItemEntity.Status;
      int j = paramTroopFileTansferItemEntity.Status;
      if ((j != 0) && (j != 1))
      {
        if (j == 8) {
          i = 10;
        }
      }
      else {
        i = 3;
      }
      paramTroopFileTansferItemEntity.preupdate();
      localObject = a(paramTroopFileTansferItemEntity);
      ((ContentValues)localObject).put("Status", Integer.valueOf(i));
      ((ContentValues)localObject).put("_sStatus", TroopFileInfo.FileStatus.c(i));
      String str1 = paramTroopFileTansferItemEntity.getTableName();
      String str2 = paramTroopFileTansferItemEntity.Id.toString();
      paramTroopFileTansferItemEntity = new TroopFileDataBaseProxy.2(this, paramTroopFileTansferItemEntity);
      a(str1, (ContentValues)localObject, "_sId=?", new String[] { str2 }, paramTroopFileTansferItemEntity);
    }
  }
  
  public void a(TroopFileTansferItemEntity paramTroopFileTansferItemEntity, ProxyListener paramProxyListener)
  {
    int i = TroopFileTransferUtil.Log.b;
    paramProxyListener = new StringBuilder();
    paramProxyListener.append("[");
    paramProxyListener.append(paramTroopFileTansferItemEntity.Id.toString());
    paramProxyListener.append("] addItem status[");
    paramProxyListener.append(paramTroopFileTansferItemEntity.getStatus());
    paramProxyListener.append("]");
    TroopFileTransferUtil.Log.c("TroopFileDataBaseProxy", i, paramProxyListener.toString());
    paramProxyListener = new TroopFileDataBaseProxy.1(this, paramTroopFileTansferItemEntity);
    if (paramTroopFileTansferItemEntity.getStatus() == 1000)
    {
      this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramTroopFileTansferItemEntity.getTableName(), paramTroopFileTansferItemEntity, 0, paramProxyListener);
      return;
    }
    if (paramTroopFileTansferItemEntity.getStatus() == 1001)
    {
      this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramTroopFileTansferItemEntity.getTableName(), paramTroopFileTansferItemEntity, 1, paramProxyListener);
      return;
    }
    i = TroopFileTransferUtil.Log.b;
    paramProxyListener = new StringBuilder();
    paramProxyListener.append("Item status[");
    paramProxyListener.append(String.valueOf(paramTroopFileTansferItemEntity.getStatus()));
    paramProxyListener.append("] is wrong");
    TroopFileTransferUtil.Log.a("TroopFileDataBaseProxy", i, paramProxyListener.toString());
  }
  
  protected void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.proxyManager.addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
  }
  
  public void destroy() {}
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy
 * JD-Core Version:    0.7.0.1
 */