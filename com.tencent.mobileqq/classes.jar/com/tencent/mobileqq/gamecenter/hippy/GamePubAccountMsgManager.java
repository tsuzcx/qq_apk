package com.tencent.mobileqq.gamecenter.hippy;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.share.GameShareUtil;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.manager.Manager;

public class GamePubAccountMsgManager
  extends Observable
  implements Manager
{
  private QQAppInterface a;
  
  public GamePubAccountMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public ArrayList<QQGameMsgInfo> a(String paramString, int paramInt)
  {
    int m = 0;
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    List localList = this.a.getMessageFacade().a(paramString, 1008, 10);
    int j;
    int k;
    if (localList != null)
    {
      j = localList.size();
      if (j <= 0) {
        break label139;
      }
      k = j - 1;
      label57:
      m = i;
      if (paramInt <= i) {
        break label139;
      }
      m = i;
      if (k < 0) {
        break label139;
      }
      Object localObject = (MessageRecord)localList.get(k);
      if (!"2747277822".equals(((MessageRecord)localObject).frienduin)) {
        break label193;
      }
      localObject = QQGameMsgInfo.parseMessageRecord((MessageRecord)localObject);
      if (localObject == null) {
        break label193;
      }
      localArrayList.add(localObject);
      i += 1;
    }
    label139:
    label193:
    for (;;)
    {
      k -= 1;
      break label57;
      j = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("GamePubAccountMsgManager", 1, "findMessage gameTroopUin=" + paramString + ",listSize=" + m + ",size=" + j);
      }
      return localArrayList;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GamePubAccountMsgManager", 1, "saveGalleryDataToMsg params=" + paramBundle);
    }
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.w("GamePubAccountMsgManager", 1, "saveGalleryDataToMsg params is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          String str1 = paramBundle.getString("game_source_pic_txt");
          String str2 = paramBundle.getString("game_source_pic_url");
          int i = paramBundle.getInt("game_source_type_pic", 0);
          int j = paramBundle.getInt("game_source_subtype_pic", 0);
          long l = paramBundle.getLong("uniseq");
          int k = paramBundle.getInt("is_troop");
          paramBundle = paramBundle.getString("friend_uin");
          paramBundle = this.a.getMessageFacade().b(paramBundle, k, l);
          if (paramBundle != null)
          {
            GameShareUtil.a("game_source_pic_txt", str1, paramBundle);
            GameShareUtil.a("game_source_pic_url", str2, paramBundle);
            GameShareUtil.a("game_source_type_pic", String.valueOf(i), paramBundle);
            GameShareUtil.a("game_source_subtype_pic", String.valueOf(j), paramBundle);
            ThreadManager.excute(new GamePubAccountMsgManager.1(this, paramBundle), 32, null, false);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("GamePubAccountMsgManager", 1, "saveGalleryDataToMsg exception", paramBundle);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GamePubAccountMsgManager", 1, "clearUnreadMsg gameTroopUin=" + paramString);
    }
    this.a.getConversationFacade().a(paramString, 1008, false);
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GamePubAccountMsgManager", 1, "onGameNewMsg mrList=" + paramList);
    }
    if (paramList != null) {
      try
      {
        if (paramList.size() > 0)
        {
          ArrayList localArrayList = new ArrayList();
          paramList = paramList.iterator();
          Object localObject;
          while (paramList.hasNext())
          {
            localObject = (MessageRecord)paramList.next();
            if ("2747277822".equals(((MessageRecord)localObject).frienduin))
            {
              if (QLog.isColorLevel()) {
                QLog.d("GamePubAccountMsgManager", 1, "enter qqgame message handle");
              }
              paramList = QQGameMsgInfo.parseMessageRecord((MessageRecord)localObject);
              if (paramList == null) {
                break label194;
              }
              localArrayList.add(paramList);
            }
          }
          while (localArrayList.size() > 0)
          {
            setChanged();
            notifyObservers(new GamePubAccountMessage("action_qgame_tool_messgae", localArrayList));
            paramList = new Intent("action_qgame_tool_messgae");
            paramList.setPackage(BaseApplicationImpl.getApplication().getPackageName());
            localObject = new Bundle();
            ((Bundle)localObject).putSerializable("key_get_msg", localArrayList);
            paramList.putExtras((Bundle)localObject);
            BaseApplicationImpl.getApplication().sendBroadcast(paramList);
            return;
            label194:
            if (QLog.isColorLevel()) {
              QLog.d("GamePubAccountMsgManager", 1, "parse qqgame message fail");
            }
          }
        }
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("GamePubAccountMsgManager", 1, "send qqgame message fail by:" + paramList.getMessage());
        }
      }
    }
  }
  
  public void onDestroy()
  {
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePubAccountMsgManager
 * JD-Core Version:    0.7.0.1
 */