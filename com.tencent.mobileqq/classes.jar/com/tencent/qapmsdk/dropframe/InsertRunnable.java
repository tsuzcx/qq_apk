package com.tencent.qapmsdk.dropframe;

import com.tencent.qapmsdk.base.dbpersist.DBHandler;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.dbpersist.table.DropFrameTable;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.RecyclablePool;

class InsertRunnable
  implements Runnable
{
  private static final int DROPFRAME_POOL_SIZE = 5;
  private static RecyclablePool dropItemPool = new RecyclablePool(DropFrameResultMeta.class, 5);
  private DropFrameResultMeta item;
  private String scene;
  private String uin;
  
  InsertRunnable(String paramString1, String paramString2, DropFrameResultMeta paramDropFrameResultMeta)
  {
    this.uin = paramString1;
    this.scene = paramString2;
    paramString1 = (DropFrameResultMeta)dropItemPool.obtain(DropFrameResultMeta.class);
    paramString1.dropCount = paramDropFrameResultMeta.dropCount;
    paramString1.duration = paramDropFrameResultMeta.duration;
    paramString1.dropIntervals = paramDropFrameResultMeta.dropIntervals;
    paramString1.scene = paramDropFrameResultMeta.scene;
    paramString1.state = paramDropFrameResultMeta.state;
    this.item = paramString1;
  }
  
  public void run()
  {
    if (BaseInfo.dbHelper != null)
    {
      DropFrameTable localDropFrameTable = new DropFrameTable(BaseInfo.userMeta.appId, AppInfo.obtainProcessName(BaseInfo.app), BaseInfo.userMeta.version, this.uin, this.scene, this.item);
      BaseInfo.dbHelper.getDbHandler().insert(localDropFrameTable, new InsertRunnable.1(this));
      this.item.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.InsertRunnable
 * JD-Core Version:    0.7.0.1
 */