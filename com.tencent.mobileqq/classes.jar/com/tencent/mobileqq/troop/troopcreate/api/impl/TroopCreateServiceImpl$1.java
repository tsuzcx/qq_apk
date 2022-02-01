package com.tencent.mobileqq.troop.troopcreate.api.impl;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService.NameForCompare;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.SearchResult;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.TroopSearchCallback;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class TroopCreateServiceImpl$1
  implements ITroopSearchService.TroopSearchCallback
{
  TroopCreateServiceImpl$1(TroopCreateServiceImpl paramTroopCreateServiceImpl, ArrayList paramArrayList1, Activity paramActivity, ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback, ArrayList paramArrayList2) {}
  
  public void a(ArrayList<ITroopSearchService.SearchResult> paramArrayList)
  {
    if (paramArrayList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((ITroopCreateService.NameForCompare)localIterator.next()).a);
      }
      TroopCreateServiceImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl).disPlayTroopName = ((ITroopNameHelperService)TroopCreateServiceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl).getRuntimeService(ITroopNameHelperService.class, "")).getNewName(localArrayList);
      new Handler(Looper.getMainLooper()).post(new TroopCreateServiceImpl.1.1(this, paramArrayList));
      return;
    }
    TroopCreateServiceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl).getHandler(ITroopSearchService.class).post(new TroopCreateServiceImpl.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */