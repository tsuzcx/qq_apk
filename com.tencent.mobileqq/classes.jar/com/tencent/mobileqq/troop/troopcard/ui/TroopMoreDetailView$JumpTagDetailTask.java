package com.tencent.mobileqq.troop.troopcard.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class TroopMoreDetailView$JumpTagDetailTask
  implements Runnable
{
  private final WeakReference<TroopMoreDetailView> a;
  
  public TroopMoreDetailView$JumpTagDetailTask(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void run()
  {
    TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.a.get();
    if (localTroopMoreDetailView == null) {
      return;
    }
    Activity localActivity = TroopMoreDetailView.a(localTroopMoreDetailView);
    if (localActivity == null) {
      return;
    }
    AppInterface localAppInterface = TroopMoreDetailView.b(localTroopMoreDetailView);
    if (localAppInterface == null) {
      return;
    }
    Object localObject1 = Long.toString(localTroopMoreDetailView.b.dwGroupClassExt);
    localObject1 = GroupCatalogTool.a(localActivity).a(localActivity, (String)localObject1);
    Object localObject2 = localTroopMoreDetailView.b.troopTags;
    Intent localIntent = new Intent(localActivity, ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopTagViewActivityClass());
    localIntent.putExtra("troopuin", localTroopMoreDetailView.b.troopUin);
    int i = 0;
    localIntent.putExtra("isAdmin", false);
    if (!TextUtils.isEmpty(localTroopMoreDetailView.b.mTroopClassExtText)) {}
    for (localObject1 = localTroopMoreDetailView.b.mTroopClassExtText;; localObject1 = ((GroupCatalogBean)localObject1).b)
    {
      i = 1;
      break label191;
      if ((localObject1 == null) || (TextUtils.isEmpty(((GroupCatalogBean)localObject1).b)) || (HardCodeUtil.a(2131912917).equals(((GroupCatalogBean)localObject1).b))) {
        break;
      }
    }
    localObject1 = "";
    label191:
    if (i != 0) {
      localIntent.putExtra("subclass", (String)localObject1);
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = new StringBuilder();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next());
        ((StringBuilder)localObject1).append("\n");
      }
      ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      localIntent.putExtra("tags", ((StringBuilder)localObject1).toString());
    }
    localIntent.putExtra("act_type", 1);
    localIntent.putExtra("uin", localAppInterface.getCurrentAccountUin());
    if (localTroopMoreDetailView.b.isOwnerOrAdim())
    {
      localActivity.startActivityForResult(localIntent, 98);
      return;
    }
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopMoreDetailView.JumpTagDetailTask
 * JD-Core Version:    0.7.0.1
 */