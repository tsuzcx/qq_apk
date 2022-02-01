package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import java.util.ArrayList;
import java.util.Iterator;

class TroopPhotoController$2
  implements Runnable
{
  TroopPhotoController$2(TroopPhotoController paramTroopPhotoController, TroopUploadingThread.UploadState paramUploadState, AvatarInfo paramAvatarInfo, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopUploadingThread$UploadState.c;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo;
    ((AvatarInfo)localObject).jdField_a_of_type_Boolean = false;
    ((AvatarInfo)localObject).b = 1;
    ((AvatarInfo)localObject).c = false;
    this.this$0.c((AvatarInfo)localObject);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i >= 1)) {
      this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo);
    }
    localObject = this.this$0.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)((Iterator)localObject).next();
      if (localTroopClipPic.ts == this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo.jdField_a_of_type_Long) {
        this.this$0.a.remove(localTroopClipPic);
      }
    }
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo, this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopUploadingThread$UploadState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController.2
 * JD-Core Version:    0.7.0.1
 */