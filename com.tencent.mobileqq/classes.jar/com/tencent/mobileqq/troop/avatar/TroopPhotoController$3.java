package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopPhotoController$3
  implements Runnable
{
  TroopPhotoController$3(TroopPhotoController paramTroopPhotoController, AvatarInfo paramAvatarInfo, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    if (!((TroopPhotoController)localObject).a(((TroopPhotoController)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
    }
    localObject = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)((Iterator)localObject).next();
      if (localTroopClipPic.ts == this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo.a) {
        this.this$0.jdField_a_of_type_JavaUtilArrayList.remove(localTroopClipPic);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo);
    this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo);
    TroopPhotoController.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController.3
 * JD-Core Version:    0.7.0.1
 */