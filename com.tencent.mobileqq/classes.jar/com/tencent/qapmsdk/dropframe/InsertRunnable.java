package com.tencent.qapmsdk.dropframe;

import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import com.tencent.qapmsdk.base.dbpersist.DBHandler;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.dbpersist.table.DropFrameTable;
import com.tencent.qapmsdk.base.listener.IDropFrameListener;
import com.tencent.qapmsdk.base.listener.ListenerManager;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.common.util.AppInfo;

class InsertRunnable
  implements Runnable
{
  private DropFrameResultMeta item;
  private String scene;
  private String uin;
  
  InsertRunnable(String paramString1, String paramString2, DropFrameResultMeta paramDropFrameResultMeta)
  {
    this.uin = paramString1;
    this.scene = paramString2;
    this.item = paramDropFrameResultMeta;
  }
  
  public void run()
  {
    if (BaseInfo.dbHelper != null)
    {
      Object localObject = ListenerManager.dropFrameListener;
      if (localObject != null) {
        ((IDropFrameListener)localObject).onRecordData(this.item);
      }
      localObject = new DropFrameTable(BaseInfo.userMeta.appId, AppInfo.obtainProcessName(BaseInfo.app), BaseInfo.userMeta.version, this.uin, this.scene, this.item);
      BaseInfo.dbHelper.getDbHandler().insert((BaseTable)localObject, new InsertRunnable.1(this));
      this.item.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.InsertRunnable
 * JD-Core Version:    0.7.0.1
 */