package com.tencent.mobileqq.troop.avatar;

class TroopAvatarController$4
  implements Runnable
{
  TroopAvatarController$4(TroopAvatarController paramTroopAvatarController, TroopUploadingThread.UploadState paramUploadState, AvatarInfo paramAvatarInfo, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopUploadingThread$UploadState.c;
    AvatarInfo localAvatarInfo = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo;
    localAvatarInfo.a = false;
    localAvatarInfo.b = 1;
    localAvatarInfo.jdField_c_of_type_Boolean = false;
    this.this$0.c(localAvatarInfo);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Int);
      localAvatarInfo = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo;
      localAvatarInfo.b = 1;
      localAvatarInfo.a = false;
      if (this.this$0.a(this.jdField_a_of_type_Int, localAvatarInfo)) {
        TroopAvatarController.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo);
      }
    }
    TroopAvatarController.a(this.this$0, null);
    TroopAvatarController.b(this.this$0, null);
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo, this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopUploadingThread$UploadState);
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */