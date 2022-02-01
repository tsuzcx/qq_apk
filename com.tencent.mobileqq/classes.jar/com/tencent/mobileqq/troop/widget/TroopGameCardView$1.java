package com.tencent.mobileqq.troop.widget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopGameInfo;
import com.tencent.qphone.base.util.QLog;

class TroopGameCardView$1
  extends TroopBusinessObserver
{
  TroopGameCardView$1(TroopGameCardView paramTroopGameCardView) {}
  
  public void onGetTroopGameGameCard(boolean paramBoolean, String paramString, TroopGameInfo paramTroopGameInfo)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onGetTroopGameGameCard. isSuccess = ").append(paramBoolean).append(", hasGameInfo = ");
      if (paramTroopGameInfo != null)
      {
        bool = true;
        QLog.d("TroopGameCardView", 2, bool);
      }
    }
    else
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        ((QQAppInterface)localObject).removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      }
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        break label103;
      }
    }
    label103:
    do
    {
      return;
      bool = false;
      break;
      if (this.a.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        TroopGameCardView.a(this.a, paramTroopGameInfo);
        this.a.a(paramBoolean, paramTroopGameInfo);
        this.a.a(TroopGameCardView.a(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopGameCardView", 2, "onGetTroopGameGameCard. troopUin doesn't match.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopGameCardView.1
 * JD-Core Version:    0.7.0.1
 */