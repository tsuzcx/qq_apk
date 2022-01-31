package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_SEARCH.SEARCH.StAppSearchItem;
import NS_MINI_APP_SEARCH.SEARCH.StLocalSearchDataRsp;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class MiniAppLocalSearchManager$2
  implements MiniAppCmdInterface
{
  MiniAppLocalSearchManager$2(MiniAppLocalSearchManager paramMiniAppLocalSearchManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = paramJSONObject.opt("response");
      if (paramJSONObject != null)
      {
        Object localObject = (SEARCH.StLocalSearchDataRsp)paramJSONObject;
        int i = ((SEARCH.StLocalSearchDataRsp)localObject).status.get();
        MiniAppLocalSearchManager.access$202(this.this$0, (COMM.StCommonExt)((SEARCH.StLocalSearchDataRsp)localObject).extInfo.get());
        if (i == 1)
        {
          paramJSONObject = new ArrayList();
          localObject = ((SEARCH.StLocalSearchDataRsp)localObject).items.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            SEARCH.StAppSearchItem localStAppSearchItem = (SEARCH.StAppSearchItem)((Iterator)localObject).next();
            paramJSONObject.add(new MiniAppLocalSearchEntity(localStAppSearchItem.appid.get(), localStAppSearchItem.appname.get(), localStAppSearchItem.appIcon.get(), localStAppSearchItem.desc.get(), localStAppSearchItem.showMask.get()));
          }
          MiniAppLocalSearchManager.access$300(this.this$0, paramJSONObject);
        }
      }
      return;
    }
    QLog.e("MiniAppLocalSearchManager", 2, "onCmdListener, isSuc = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager.2
 * JD-Core Version:    0.7.0.1
 */