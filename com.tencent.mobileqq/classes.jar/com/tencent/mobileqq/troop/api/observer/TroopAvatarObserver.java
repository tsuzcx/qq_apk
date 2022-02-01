package com.tencent.mobileqq.troop.api.observer;

import android.util.Pair;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import java.util.List;

public class TroopAvatarObserver
  implements BusinessObserver
{
  public static final int TYPE_CMD_TROOP_AVATAR;
  public static final int TYPE_GET_TROOP_AVATAR;
  public static final int TYPE_NOTIFY_GET_NEW_TROOP_HEAD;
  private static int sNotificationTypeStart;
  
  static
  {
    int i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_GET_TROOP_AVATAR = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_CMD_TROOP_AVATAR = i;
    i = sNotificationTypeStart;
    sNotificationTypeStart = i + 1;
    TYPE_NOTIFY_GET_NEW_TROOP_HEAD = i;
  }
  
  private void onUpdate_cmdTroopAvatar(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_CMD_TROOP_AVATAR) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      Object localObject3 = (Object[])paramObject;
      paramInt = localObject3.length;
      int i = -1;
      Object localObject2 = null;
      Object localObject1;
      if (paramInt <= 5)
      {
        if ((localObject3[4] instanceof List)) {
          paramObject = (List)localObject3[4];
        } else {
          paramObject = null;
        }
        if ((localObject3[3] instanceof Integer)) {
          paramInt = ((Integer)localObject3[3]).intValue();
        } else {
          paramInt = -1;
        }
        if ((localObject3[2] instanceof String)) {
          localObject1 = (String)localObject3[2];
        } else {
          localObject1 = null;
        }
        if ((localObject3[1] instanceof Integer)) {
          i = ((Integer)localObject3[1]).intValue();
        }
        if ((localObject3[0] instanceof String)) {
          localObject2 = (String)localObject3[0];
        }
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = paramObject;
      }
      else
      {
        localObject1 = null;
        paramObject = localObject1;
        localObject3 = paramObject;
        i = -1;
        paramInt = -1;
        localObject2 = paramObject;
      }
      onCmdTroopAvatar(paramBoolean, (String)localObject1, i, (String)localObject2, paramInt, (List)localObject3);
    }
  }
  
  private void onUpdate_getTroopAvatar(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_GET_TROOP_AVATAR) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      Object localObject3 = (Object[])paramObject;
      paramInt = localObject3.length;
      int i = -1;
      Object localObject2 = null;
      Object localObject1;
      if (paramInt <= 5)
      {
        if ((localObject3[4] instanceof List)) {
          paramObject = (List)localObject3[4];
        } else {
          paramObject = null;
        }
        if ((localObject3[3] instanceof Integer)) {
          paramInt = ((Integer)localObject3[3]).intValue();
        } else {
          paramInt = -1;
        }
        if ((localObject3[2] instanceof String)) {
          localObject1 = (String)localObject3[2];
        } else {
          localObject1 = null;
        }
        if ((localObject3[1] instanceof Integer)) {
          i = ((Integer)localObject3[1]).intValue();
        }
        if ((localObject3[0] instanceof String)) {
          localObject2 = (String)localObject3[0];
        }
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = paramObject;
      }
      else
      {
        localObject1 = null;
        paramObject = localObject1;
        localObject3 = paramObject;
        i = -1;
        paramInt = -1;
        localObject2 = paramObject;
      }
      onGetTroopAvatar(paramBoolean, (String)localObject1, i, (String)localObject2, paramInt, (List)localObject3);
    }
  }
  
  private void onUpdate_notifyGetNewTroopHead(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TYPE_NOTIFY_GET_NEW_TROOP_HEAD) {
      return;
    }
    paramObject = (Pair)paramObject;
    onUpdateNewTroopFaceIcon(paramBoolean, ((Boolean)paramObject.first).booleanValue(), (String)paramObject.second);
  }
  
  protected void onCmdTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList) {}
  
  protected void onGetTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_getTroopAvatar(paramInt, paramBoolean, paramObject);
    onUpdate_cmdTroopAvatar(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetNewTroopHead(paramInt, paramBoolean, paramObject);
  }
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver
 * JD-Core Version:    0.7.0.1
 */