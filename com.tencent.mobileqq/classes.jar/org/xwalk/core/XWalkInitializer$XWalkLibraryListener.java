package org.xwalk.core;

class XWalkInitializer$XWalkLibraryListener
  implements XWalkLibraryLoader.ActivateListener, XWalkLibraryLoader.DecompressListener
{
  private XWalkInitializer$XWalkLibraryListener(XWalkInitializer paramXWalkInitializer) {}
  
  public void onActivateCompleted()
  {
    XWalkInitializer.access$102(this.this$0, true);
    XWalkLibraryLoader.finishInit(XWalkInitializer.access$200(this.this$0));
    XWalkInitializer.access$000(this.this$0).onXWalkInitCompleted();
  }
  
  public void onActivateFailed()
  {
    XWalkInitializer.access$000(this.this$0).onXWalkInitFailed();
  }
  
  public void onActivateStarted() {}
  
  public void onDecompressCancelled()
  {
    XWalkInitializer.access$000(this.this$0).onXWalkInitCancelled();
  }
  
  public void onDecompressCompleted() {}
  
  public void onDecompressStarted() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkInitializer.XWalkLibraryListener
 * JD-Core Version:    0.7.0.1
 */