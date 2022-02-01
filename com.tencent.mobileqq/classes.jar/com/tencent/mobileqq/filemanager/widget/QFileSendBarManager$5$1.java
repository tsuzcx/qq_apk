package com.tencent.mobileqq.filemanager.widget;

import android.os.AsyncTask;
import com.dataline.core.DirectForwarder;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class QFileSendBarManager$5$1
  extends AsyncTask<Void, Void, Void>
{
  QFileSendBarManager$5$1(QFileSendBarManager.5 param5) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = QFileSendBarManager.a(this.a.this$0);
    Object localObject1 = QFileSendBarManager.b(this.a.this$0);
    int i = QFileSendBarManager.a(this.a.this$0);
    if (i == 5)
    {
      TroopFileProxyActivity.a.addAll(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
      return null;
    }
    Object localObject2;
    if (paramVarArgs.equals(AppConstants.DATALINE_PC_UIN))
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
      paramVarArgs = (DataLineHandler)this.a.this$0.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      paramVarArgs.a((ArrayList)localObject1);
      localObject1 = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getRecentFiles().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if (((FileManagerEntity)localObject2).nFileType == 13) {
          paramVarArgs.a((FileManagerEntity)localObject2);
        } else if ((((FileManagerEntity)localObject2).getCloudType() == 2) && (((FileManagerEntity)localObject2).WeiYunFileId != null)) {
          paramVarArgs.a((FileManagerEntity)localObject2);
        } else {
          paramVarArgs.a().a((FileManagerEntity)localObject2);
        }
      }
      if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getFavFiles().size() > 0)
      {
        this.a.this$0.a.getFileManagerEngine().a().sendFavFiles(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getFavFiles(), AppConstants.DATALINE_PC_UIN, 6000, null);
        return null;
      }
    }
    else
    {
      if (i == 6002)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
        ((RouterHandler)this.a.this$0.a.getBusinessHandler(BusinessHandlerFactory.ROUTER_HANDLER)).a((ArrayList)localObject1, null, null, Long.parseLong(paramVarArgs));
        return null;
      }
      if (i == 9501)
      {
        localObject1 = (DeviceMsgHandle)this.a.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
        ((DeviceMsgHandle)localObject1).a().a(paramVarArgs, (List)localObject2);
        return null;
      }
      this.a.this$0.a.getFileManagerEngine().a(false, (String)localObject1, paramVarArgs, i);
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    QFileSendBarManager.c(this.a.this$0);
    ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).clearSelected();
    this.a.this$0.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QFileSendBarManager.5.1
 * JD-Core Version:    0.7.0.1
 */