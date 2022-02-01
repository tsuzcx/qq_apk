package com.tencent.mobileqq.flutter.channel.zanranking;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ZanRankingIpcServer
  extends QIPCModule
  implements Handler.Callback
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  Set<ZanRankingIpcServer.GetCoverTask> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  private ZanRankingIpcServer()
  {
    super("ZanRankingIpcServer");
  }
  
  public static ZanRankingIpcServer a()
  {
    return ZanRankingIpcServer.Holder.a();
  }
  
  private EIPCResult a(ArrayList<String> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    FriendsManager localFriendsManager = (FriendsManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.FRIENDS_MANAGER);
    Iterator localIterator = paramArrayList.iterator();
    Object localObject;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = localFriendsManager.e(str);
      if (localObject == null)
      {
        localObject = "";
        label83:
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label133;
        }
        localObject = str;
      }
    }
    label133:
    for (;;)
    {
      localArrayList.add(localObject);
      break;
      localObject = ((Friends)localObject).getFriendNick();
      break label83;
      localBundle.putStringArrayList("uins", paramArrayList);
      localBundle.putStringArrayList("nicks", localArrayList);
      return EIPCResult.createSuccessResult(localBundle);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onAccountChange()
  {
    super.onAccountChange();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((ZanRankingIpcServer.GetCoverTask)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZanRankingIpcServer", 2, "onCall, params=" + paramBundle + ", action=" + paramString + ", callBackId=" + paramInt);
    }
    if (paramBundle == null) {
      QLog.d("ZanRankingIpcServer", 1, "onCall, param is null, action=" + paramString + ", callBackId=" + paramInt);
    }
    do
    {
      return null;
      if ("action_get_card_cover".equals(paramString))
      {
        paramBundle.putInt("callbackId", paramInt);
        paramString = new ZanRankingIpcServer.GetCoverTask(this, paramBundle);
        this.jdField_a_of_type_AndroidOsHandler.post(paramString);
        return null;
      }
    } while (!"action_get_frd_nicks".equals(paramString));
    return a(paramBundle.getStringArrayList("uins"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcServer
 * JD-Core Version:    0.7.0.1
 */