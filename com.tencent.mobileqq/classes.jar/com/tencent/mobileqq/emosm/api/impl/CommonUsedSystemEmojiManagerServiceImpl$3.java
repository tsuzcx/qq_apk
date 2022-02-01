package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x13Rsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class CommonUsedSystemEmojiManagerServiceImpl$3
  implements Runnable
{
  CommonUsedSystemEmojiManagerServiceImpl$3(CommonUsedSystemEmojiManagerServiceImpl paramCommonUsedSystemEmojiManagerServiceImpl) {}
  
  public void run()
  {
    synchronized (this.this$0.lock)
    {
      Object localObject1 = MobileQQ.getContext().getFilesDir();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("commonusedSystemEmojiInfoFile_v3_");
      ((StringBuilder)localObject3).append(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
      File localFile = new File((File)localObject1, ((StringBuilder)localObject3).toString());
      EmosmPb.SubCmd0x13Rsp localSubCmd0x13Rsp = new EmosmPb.SubCmd0x13Rsp();
      localObject3 = this.this$0.getCacheInfo();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new ArrayList();
      }
      localSubCmd0x13Rsp.itemlist.set((List)localObject1);
      if ((QLog.isColorLevel()) && (((List)localObject1).size() > 0))
      {
        localObject3 = new StringBuilder("saveSystemEmojiInfoToFile : itemsInfo = ");
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)((List)localObject1).get(i);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(";type = ");
          localStringBuilder.append(localSmallYellowItem.type.get());
          ((StringBuilder)localObject3).append(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(";id = ");
          localStringBuilder.append(localSmallYellowItem.id.get());
          ((StringBuilder)localObject3).append(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(";ts = ");
          localStringBuilder.append(localSmallYellowItem.ts.get());
          ((StringBuilder)localObject3).append(localStringBuilder.toString());
          i += 1;
        }
        QLog.d("CommonUsedSystemEmojiManager", 2, ((StringBuilder)localObject3).toString());
      }
      FileUtils.pushData2File(localFile.getAbsolutePath(), localSubCmd0x13Rsp.toByteArray(), false);
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.CommonUsedSystemEmojiManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */