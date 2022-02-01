package com.tencent.mobileqq.troop.avatar;

class TroopAvatarController$4
  implements Runnable
{
  TroopAvatarController$4(TroopAvatarController paramTroopAvatarController, TroopUploadingThread.UploadState paramUploadState, AvatarInfo paramAvatarInfo, int paramInt) {}
  
  public void run()
  {
    int i = this.a.c;
    AvatarInfo localAvatarInfo = this.b;
    localAvatarInfo.g = false;
    localAvatarInfo.e = 1;
    localAvatarInfo.j = false;
    this.this$0.c(localAvatarInfo);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.b.d = String.valueOf(this.c);
      localAvatarInfo = this.b;
      localAvatarInfo.e = 1;
      localAvatarInfo.g = false;
      if (this.this$0.a(this.c, localAvatarInfo)) {
        TroopAvatarController.a(this.this$0, this.b);
      }
      if (this.this$0.t == 2) {
        TroopAvatarController.a(this.this$0, this.b);
      }
    }
    TroopAvatarController.a(this.this$0, null);
    TroopAvatarController.b(this.this$0, null);
    this.this$0.a(this.b, this.a);
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */