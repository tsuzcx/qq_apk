package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class CommonUsedSystemEmojiManagerProxy
  extends AbsManagerProxy<CommonUsedSystemEmojiManager>
{
  public static final String ACTION_COMMONUSEDSYSTEMEMOJI_INFO = "common_usedsystememoji_info";
  public static final String ACTION_COMMONUSEDSYSTEMEMOJI_SAVE_INFO = "common_usedsystememoji_saveInfo";
  public static final String COMMONUSED_INFO_DATA = "commonused_info_data";
  public static final String INFO_COUNT = "info_count";
  public static final String INFO_ID = "info_id";
  public static final String INFO_TS = "info_ts";
  public static final String INFO_TYPE = "info_type";
  public static final String TAG = "CommonUsedSystemEmojiManagerProxy";
  
  public CommonUsedSystemEmojiManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.COMMONUSED_SYSTEM_EMOJI_MANAGERT);
  }
  
  public static EIPCResult checkMatch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if ("common_usedsystememoji_info".equals(paramString)) {
      return onGetCommonUsedSystemEmojiInfo((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("common_usedsystememoji_saveInfo".equals(paramString)) {
      return onSaveSystemEmojiInfoToFile((QQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    return null;
  }
  
  public static EIPCResult onGetCommonUsedSystemEmojiInfo(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramString = ((CommonUsedSystemEmojiManager)paramQQAppInterface.getManager(QQManagerFactory.COMMONUSED_SYSTEM_EMOJI_MANAGERT)).getCommonUsedSystemEmojiInfo();
    paramQQAppInterface = new ArrayList();
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramBundle = (EmosmPb.SmallYellowItem)paramString.next();
        Bundle localBundle = new Bundle();
        localBundle.putInt("info_id", paramBundle.id.get());
        localBundle.putInt("info_type", paramBundle.type.get());
        localBundle.putInt("info_count", paramBundle.count.get());
        localBundle.putLong("info_ts", paramBundle.ts.get());
        paramQQAppInterface.add(localBundle);
      }
    }
    paramString = new Bundle();
    paramString.putParcelableArrayList("commonused_info_data", paramQQAppInterface);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onSaveSystemEmojiInfoToFile(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((CommonUsedSystemEmojiManager)paramQQAppInterface.getManager(QQManagerFactory.COMMONUSED_SYSTEM_EMOJI_MANAGERT)).saveSystemEmojiInfoToFile();
    return EIPCResult.createSuccessResult(null);
  }
  
  public List<EmosmPb.SmallYellowItem> getCommonUsedSystemEmojiInfo()
  {
    if (this.manager != null) {
      return ((CommonUsedSystemEmojiManager)this.manager).getCommonUsedSystemEmojiInfo();
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "common_usedsystememoji_info", null);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()))
    {
      localObject = ((EIPCResult)localObject).data.getParcelableArrayList("commonused_info_data").iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bundle localBundle = (Bundle)((Iterator)localObject).next();
        EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
        localSmallYellowItem.id.set(localBundle.getInt("info_id", 0));
        localSmallYellowItem.type.set(localBundle.getInt("info_type", 0));
        localSmallYellowItem.count.set(localBundle.getInt("info_count", 0));
        localSmallYellowItem.ts.set(localBundle.getLong("info_ts", 0L));
        localArrayList.add(localSmallYellowItem);
      }
      return localArrayList;
    }
    QLog.e("CommonUsedSystemEmojiManagerProxy", 4, "getCommonUsedSystemEmojiInfo fail.");
    return localArrayList;
  }
  
  public void saveSystemEmojiInfoToFile()
  {
    if (this.manager != null) {
      ((CommonUsedSystemEmojiManager)this.manager).saveSystemEmojiInfoToFile();
    }
    do
    {
      return;
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "common_usedsystememoji_saveInfo", null);
      if ((localEIPCResult == null) || (!localEIPCResult.isSuccess())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CommonUsedSystemEmojiManagerProxy", 4, "saveSystemEmojiInfoToFile suc.");
    return;
    QLog.e("CommonUsedSystemEmojiManagerProxy", 4, "saveSystemEmojiInfoToFile fail.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerProxy
 * JD-Core Version:    0.7.0.1
 */