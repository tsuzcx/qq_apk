package com.tencent.mobileqq.gamecenter.data;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDelSessionRecord;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.utils.GameMsgUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;

public class GameDelSessionDataHelper
  extends BaseDataHelper
  implements IDataVisitor
{
  public static final String b;
  private Map<String, GameDelSessionRecord> a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(GameCenterUnissoHandler.b);
    localStringBuilder.append("DelGameSessionDataHelper");
    b = localStringBuilder.toString();
  }
  
  public GameDelSessionDataHelper(EntityManager paramEntityManager)
  {
    super(paramEntityManager);
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  }
  
  public static void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[delGameSession], json:");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      paramString = new JSONArray(paramString);
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        b(paramString.optString(i));
        i += 1;
      }
      paramString = new Intent("action_qgame_messgae_change");
      paramString.setPackage(GameMsgUtil.a().getApplication().getPackageName());
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("is_update_publicaccount_only", true);
      paramString.putExtras((Bundle)localObject);
      GameMsgUtil.a().getApplication().sendBroadcast(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(b, 1, paramString, new Object[0]);
    }
  }
  
  public static void a(String paramString, IDataVisitor paramIDataVisitor)
  {
    ThreadManager.getSubThreadHandler().post(new GameDelSessionDataHelper.1(paramIDataVisitor, paramString));
  }
  
  private static void b(String paramString)
  {
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleDelSession], sessionId:");
    localStringBuilder.append(paramString);
    QLog.i(str, 1, localStringBuilder.toString());
    ThreadManager.getSubThreadHandler().post(new GameDelSessionDataHelper.2(paramString));
  }
  
  public void a()
  {
    try
    {
      QLog.i(b, 1, "[initCache]");
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(GameDelSessionRecord.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameDelSessionRecord)localObject2;
            if (!TextUtils.isEmpty(((GameDelSessionRecord)localObject2).mUin)) {
              this.jdField_a_of_type_JavaUtilMap.put(((GameDelSessionRecord)localObject2).mUin, localObject2);
            }
          }
        }
        localObject1 = b;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("delSession.size:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilMap.size());
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(b, 1, localThrowable.getMessage());
    }
  }
  
  public boolean b(Entity paramEntity)
  {
    QLog.i(b, 1, "[addDelItem]");
    try
    {
      if (!(paramEntity instanceof GameDelSessionRecord)) {
        return false;
      }
      GameDelSessionRecord localGameDelSessionRecord = (GameDelSessionRecord)paramEntity;
      if (TextUtils.isEmpty(localGameDelSessionRecord.mUin)) {
        return false;
      }
      if ((GameDelSessionRecord)this.jdField_a_of_type_JavaUtilMap.get(localGameDelSessionRecord.mUin) != null)
      {
        QLog.i(b, 1, "item already exists.");
        return false;
      }
      if (super.a(paramEntity))
      {
        this.jdField_a_of_type_JavaUtilMap.put(localGameDelSessionRecord.mUin, localGameDelSessionRecord);
        QLog.i(b, 1, "Add succeeds.");
        return true;
      }
      return false;
    }
    catch (Throwable paramEntity)
    {
      QLog.e(b, 1, paramEntity, new Object[0]);
    }
    return false;
  }
  
  public boolean c(Entity paramEntity)
  {
    if (!(paramEntity instanceof GameDelSessionRecord)) {
      return false;
    }
    try
    {
      Object localObject = (GameDelSessionRecord)paramEntity;
      if (TextUtils.isEmpty(((GameDelSessionRecord)localObject).mUin)) {
        return false;
      }
      if ((GameDelSessionRecord)this.jdField_a_of_type_JavaUtilMap.get(((GameDelSessionRecord)localObject).mUin) == null) {
        return false;
      }
      ((GameDelSessionRecord)localObject).setStatus(1001);
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[removeDelItem], start to remove. size:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap.size());
      QLog.i(str, 1, localStringBuilder.toString());
      if (a(this, paramEntity, "mUin=?", new String[] { ((GameDelSessionRecord)localObject).mUin }))
      {
        this.jdField_a_of_type_JavaUtilMap.remove(((GameDelSessionRecord)localObject).mUin);
        paramEntity = b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Remove succeeds. size:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilMap.size());
        QLog.i(paramEntity, 1, ((StringBuilder)localObject).toString());
        return true;
      }
      return false;
    }
    catch (Throwable paramEntity)
    {
      QLog.e(b, 1, paramEntity, new Object[0]);
    }
    return false;
  }
  
  public boolean d(Entity paramEntity)
  {
    if (!(paramEntity instanceof GameDelSessionRecord)) {
      return false;
    }
    paramEntity = (GameDelSessionRecord)paramEntity;
    return (GameDelSessionRecord)this.jdField_a_of_type_JavaUtilMap.get(paramEntity.mUin) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper
 * JD-Core Version:    0.7.0.1
 */