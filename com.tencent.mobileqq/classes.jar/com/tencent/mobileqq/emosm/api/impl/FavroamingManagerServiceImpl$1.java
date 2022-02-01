package com.tencent.mobileqq.emosm.api.impl;

import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class FavroamingManagerServiceImpl$1
  extends TransProcessorHandler
{
  FavroamingManagerServiceImpl$1(FavroamingManagerServiceImpl paramFavroamingManagerServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    if (localObject != null)
    {
      if (((FileMsg)localObject).commandId != this.a.getUploadProcessorID()) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1008) {}
      switch (i)
      {
      default: 
      case 1005: 
        paramMessage = new StringBuilder();
        paramMessage.append("upload fav error:");
        paramMessage.append(((FileMsg)localObject).serverPath);
        QLog.i("FavroamingManager", 1, paramMessage.toString());
        i = -1;
        if (FavroamingManagerServiceImpl.access$200(this.a) != null) {
          i = NetworkUtil.getNetworkType(FavroamingManagerServiceImpl.access$300(this.a).getApplication());
        }
        paramMessage = new StringBuilder();
        paramMessage.append(i);
        paramMessage.append("");
        VasReportUtils.a("emotionType", "emotionActionFav", "4", "", "", paramMessage.toString(), ((FileMsg)localObject).serverPath, "", "", "");
        return;
      case 1004: 
        paramMessage = new StringBuilder();
        paramMessage.append("upload fav cancel:");
        paramMessage.append(((FileMsg)localObject).serverPath);
        QLog.i("FavroamingManager", 1, paramMessage.toString());
        return;
      case 1003: 
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("finish uploadFace favEmoticon resId=");
          paramMessage.append(((FileMsg)localObject).serverPath);
          QLog.d("FavroamingManager", 2, paramMessage.toString());
        }
        if (this.a.uploadCount.incrementAndGet() >= this.a.needUploadCount)
        {
          this.a.notifyFavEmoticonUploaded();
          return;
        }
        break;
      case 1001: 
        if (QLog.isColorLevel())
        {
          QLog.d("FavroamingManager", 2, "start uploadFace favEmoticon");
          return;
          if (FavroamingManagerServiceImpl.access$000(this.a) == null)
          {
            QLog.e("FavroamingManager", 1, "app is null");
            return;
          }
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("STATUS_SEND_AND_SAVE_FINISHED resId=");
            paramMessage.append(((FileMsg)localObject).serverPath);
            QLog.d("FavroamingManager", 2, paramMessage.toString());
          }
          paramMessage = ((IFavroamingDBManagerService)this.a.getDBManager()).updateUpload(((FileMsg)localObject).serverPath);
          localObject = (FavEmoRoamingHandler)FavroamingManagerServiceImpl.access$100(this.a).getBusinessHandler(FavEmoRoamingHandler.a);
          if ((localObject != null) && (paramMessage != null) && (!paramMessage.isMarkFace))
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramMessage);
            ((FavEmoRoamingHandler)localObject).a(localArrayList, 1);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */