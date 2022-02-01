package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic.SearchResult;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic.TroopSearchCallback;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class TroopCreateLogic$1
  implements TroopSearchLogic.TroopSearchCallback
{
  TroopCreateLogic$1(TroopCreateLogic paramTroopCreateLogic, ArrayList paramArrayList1, BaseActivity paramBaseActivity, TroopCreateLogic.TroopCreateCallback paramTroopCreateCallback, ArrayList paramArrayList2) {}
  
  public void a(ArrayList<TroopSearchLogic.SearchResult> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (paramArrayList.size() > 0)
    {
      paramArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        paramArrayList.add(((TroopCreateLogic.NameForCompare)localIterator.next()).a);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.c = ((ITroopNameHelperService)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopNameHelperService.class, "")).getNewName(paramArrayList);
      new Handler(Looper.getMainLooper()).post(new TroopCreateLogic.1.1(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopCreateLogic.class).post(new TroopCreateLogic.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic.1
 * JD-Core Version:    0.7.0.1
 */