package com.tencent.mobileqq.friend.observer;

import android.os.Bundle;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import java.util.ArrayList;

public class FriendObserver
  implements IFriendObserver
{
  public static final String ADD_DIRECT = "addDirect";
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<AddBatchPhoneFriendResult> paramArrayList) {}
  
  protected void onAddFriendSecCheck(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onAddReqStatesChanged(boolean paramBoolean, String paramString) {}
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void onGetInfoWithOpenId(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    if (paramInt != 1)
    {
      if (paramInt != 15)
      {
        String str;
        if (paramInt != 33)
        {
          if (paramInt != 71)
          {
            if (paramInt != 73)
            {
              if (paramInt != 102)
              {
                if (paramInt != 107)
                {
                  if (paramInt != 117)
                  {
                    if (paramInt != 11)
                    {
                      if (paramInt != 12) {
                        return;
                      }
                      onUpdateAddFriendSetting(paramBoolean, (Bundle)paramObject);
                      return;
                    }
                    paramObject = (Bundle)paramObject;
                    str = paramObject.getString("uin");
                    paramInt = paramObject.getInt("resultCode", 1);
                    boolean bool2 = paramObject.getBoolean("addDirect", false);
                    if (paramInt == 0) {
                      bool1 = true;
                    } else {
                      bool1 = false;
                    }
                    onUpdateAddFriend(paramBoolean, bool1, bool2, str, paramObject);
                    return;
                  }
                  onAddFriendSecCheck(paramBoolean, (Bundle)paramObject);
                  return;
                }
                onAddBatchPhoneFriend(paramBoolean, (ArrayList)paramObject);
                return;
              }
              if ((paramObject instanceof String)) {
                onAddReqStatesChanged(paramBoolean, (String)paramObject);
              }
            }
            else
            {
              paramObject = (Bundle)paramObject;
              onGetInfoWithOpenId(paramBoolean, paramObject.getString("uin"), paramObject.getString("nick_name"));
            }
          }
          else
          {
            paramObject = (Bundle)paramObject;
            onQueryUinSafetyFlag(paramBoolean, paramObject.getLong("uin"), paramObject.getInt("safety_flag"));
          }
        }
        else
        {
          paramObject = (Bundle)paramObject;
          str = paramObject.getString("uin");
          if (paramBoolean)
          {
            onGetAutoInfo(true, str, paramObject.getString("nick_name"), paramObject.getInt("group_id", 0));
            return;
          }
          onGetAutoInfo(false, str, "", 0);
        }
      }
      else
      {
        onUpdateDelFriend(paramBoolean, paramObject);
      }
    }
    else
    {
      if ((!paramBoolean) || (!((Boolean)paramObject).booleanValue())) {
        bool1 = false;
      }
      onUpdateFriendList(paramBoolean, bool1);
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle) {}
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.observer.FriendObserver
 * JD-Core Version:    0.7.0.1
 */