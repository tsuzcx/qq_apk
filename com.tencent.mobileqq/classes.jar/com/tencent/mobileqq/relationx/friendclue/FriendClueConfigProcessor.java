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
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int j = paramArrayOfQConfItem.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfQConfItem[i];
        if (localObject != null) {
          localObject = ((QConfItem)localObject).b;
        } else {
          localObject = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendClueConfigProcessor", 2, String.format("onParsed content=\n%s", new Object[] { localObject }));
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            FriendClueConfig localFriendClueConfig = new FriendClueConfig();
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("friendClueSwitch")) {
              localFriendClueConfig.a = ((JSONObject)localObject).getBoolean("friendClueSwitch");
            }
            if (QLog.isColorLevel()) {
              QLog.d("FriendClueConfigProcessor", 2, String.format("onParsed friendClueConfig=%s", new Object[] { localFriendClueConfig }));
            }
            return localFriendClueConfig;
          }
          catch (Exception localException)
          {
            QLog.d("FriendClueConfigProcessor", 1, "onParsed fail.", localException);
          }
        }
        i += 1;
      }
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueConfigProcessor
 * JD-Core Version:    0.7.0.1
 */