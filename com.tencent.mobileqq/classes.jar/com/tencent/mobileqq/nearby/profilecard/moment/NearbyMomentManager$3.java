package com.tencent.mobileqq.nearby.profilecard.moment;

class NearbyMomentManager$3
  implements NearbyMomentProtocol.DeleteFeedCallback
{
  NearbyMomentManager$3(NearbyMomentManager paramNearbyMomentManager, DeleteFeedCallback paramDeleteFeedCallback) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.b.f(paramString);
    DeleteFeedCallback localDeleteFeedCallback = this.a;
    if (localDeleteFeedCallback != null) {
      localDeleteFeedCallback.a(paramBoolean, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.3
 * JD-Core Version:    0.7.0.1
 */