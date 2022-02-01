package com.tencent.mobileqq.kandian.repo.feeds;

class RIJArticleInfoRepo$20
  implements Runnable
{
  RIJArticleInfoRepo$20(RIJArticleInfoRepo paramRIJArticleInfoRepo, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher localReadInJoyLogicEngineEventDispatcher = ReadInJoyLogicEngineEventDispatcher.a();
    long l = this.a;
    int i = this.b;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localReadInJoyLogicEngineEventDispatcher.a(l, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo.20
 * JD-Core Version:    0.7.0.1
 */