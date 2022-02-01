package com.tencent.mobileqq.filemanager.activity;

import com.tencent.mobileqq.troop.troopphoto.api.TroopPhotoObserver;
import com.tencent.qphone.base.util.QLog;

class FMActivity$FMTroopBusinessObserver
  extends TroopPhotoObserver
{
  boolean a = false;
  
  FMActivity$FMTroopBusinessObserver(FMActivity paramFMActivity) {}
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramString = new StringBuilder(150);
    paramString.append("onTroopPrivilege");
    paramString.append("| isSuccess = ");
    paramString.append(paramBoolean1);
    paramString.append("| isAdmin = ");
    paramString.append(paramBoolean2);
    paramString.append("| isAllUser_Photo = ");
    paramString.append(paramBoolean3);
    paramString.append("| isAllUser_File = ");
    paramString.append(paramBoolean4);
    if (QLog.isColorLevel()) {
      QLog.i("FMActivity<FileAssistant>", 2, paramString.toString());
    }
    if ((paramBoolean1) && (!paramBoolean4)) {
      this.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity.FMTroopBusinessObserver
 * JD-Core Version:    0.7.0.1
 */