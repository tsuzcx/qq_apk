package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
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

public class CommonUsedSystemEmojiManagerServiceProxy
  extends AbsEmoRuntimeServiceProxy<ICommonUsedSystemEmojiManagerService>
{
  public static final String ACTION_COMMONUSEDSYSTEMEMOJI_INFO = "common_usedsystememoji_info";
  public static final String ACTION_COMMONUSEDSYSTEMEMOJI_SAVE_INFO = "common_usedsystememoji_saveInfo";
  public static final String COMMONUSED_INFO_DATA = "commonused_info_data";
  public static final String INFO_COUNT = "info_count";
  public static final String INFO_ID = "info_id";
  public static final String INFO_TS = "info_ts";
  public static final String INFO_TYPE = "info_type";
  public static final String TAG = "CommonUsedSystemEmojiManagerServiceProxy";
  
  public CommonUsedSystemEmojiManagerServiceProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, ICommonUsedSystemEmojiManagerService.class);
  }
  
  public static EIPCResult checkMatch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, int paramInt)
  {
    if ("common_usedsystememoji_info".equals(paramString)) {
      return onGetCommonUsedSystemEmojiInfo((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("common_usedsystememoji_saveInfo".equals(paramString)) {
      return onSaveSystemEmojiInfoToFile((BaseQQAppInterface)paramAppRuntime, paramString, paramBundle, paramInt);
    }
    return null;
  }
  
  public static EIPCResult onGetCommonUsedSystemEmojiInfo(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramString = ((ICommonUsedSystemEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).getCommonUsedSystemEmojiInfo();
    paramBaseQQAppInterface = new ArrayList();
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
        paramBaseQQAppInterface.add(localBundle);
      }
    }
    paramString = new Bundle();
    paramString.putParcelableArrayList("commonused_info_data", paramBaseQQAppInterface);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onSaveSystemEmojiInfoToFile(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((ICommonUsedSystemEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).saveSystemEmojiInfoToFile();
    return EIPCResult.createSuccessResult(null);
  }
  
  public List<EmosmPb.SmallYellowItem> getCommonUsedSystemEmojiInfo()
  {
    if (this.manager != null) {
      return ((ICommonUsedSystemEmojiManagerService)this.manager).getCommonUsedSystemEmojiInfo();
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
    QLog.e("CommonUsedSystemEmojiManagerServiceProxy", 4, "getCommonUsedSystemEmojiInfo fail.");
    return localArrayList;
  }
  
  public void saveSystemEmojiInfoToFile()
  {
    if (this.manager != null)
    {
      ((ICommonUsedSystemEmojiManagerService)this.manager).saveSystemEmojiInfoToFile();
      return;
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "common_usedsystememoji_saveInfo", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonUsedSystemEmojiManagerServiceProxy", 4, "saveSystemEmojiInfoToFile suc.");
      }
    }
    else {
      QLog.e("CommonUsedSystemEmojiManagerServiceProxy", 4, "saveSystemEmojiInfoToFile fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy
 * JD-Core Version:    0.7.0.1
 */