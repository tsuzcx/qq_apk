package com.tencent.mobileqq.relationx.friendclue;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class FriendClueConfigProcessor
  extends IQConfigProcessor<FriendClueConfig>
{
  @NonNull
  public FriendClueConfig a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueConfigProcessor", 2, String.format("migrateOldOrDefaultContent type=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    return new FriendClueConfig();
  }
  
  @Nullable
  public FriendClueConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    int i;
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = localObject3;
      if (paramArrayOfQConfItem.length > 0)
      {
        int j = paramArrayOfQConfItem.length;
        i = 0;
        localObject1 = localObject3;
        if (i < j)
        {
          localObject1 = paramArrayOfQConfItem[i];
          if (localObject1 == null) {
            break label179;
          }
        }
      }
    }
    label179:
    Object localObject2;
    for (localObject1 = ((QConfItem)localObject1).a;; localObject2 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendClueConfigProcessor", 2, String.format("onParsed content=\n%s", new Object[] { localObject1 }));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        try
        {
          FriendClueConfig localFriendClueConfig = new FriendClueConfig();
          localObject1 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject1).has("friendClueSwitch")) {
            localFriendClueConfig.a = ((JSONObject)localObject1).getBoolean("friendClueSwitch");
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendClueConfigProcessor", 2, String.format("onParsed friendClueConfig=%s", new Object[] { localFriendClueConfig }));
          }
          localObject1 = localFriendClueConfig;
          return localObject1;
        }
        catch (Exception localException)
        {
          QLog.d("FriendClueConfigProcessor", 1, "onParsed fail.", localException);
        }
      }
      i += 1;
      break;
    }
  }
  
  public void a(FriendClueConfig paramFriendClueConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueConfigProcessor", 2, String.format("onUpdate newConf=%s", new Object[] { paramFriendClueConfig }));
    }
  }
  
  public Class<FriendClueConfig> clazz()
  {
    return FriendClueConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueConfigProcessor", 2, String.format("onReqFailed failCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public int type()
  {
    return 677;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueConfigProcessor
 * JD-Core Version:    0.7.0.1
 */