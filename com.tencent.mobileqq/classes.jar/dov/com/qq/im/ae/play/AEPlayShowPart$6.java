package dov.com.qq.im.ae.play;

import blux;
import java.util.List;

class AEPlayShowPart$6
  implements Runnable
{
  AEPlayShowPart$6(AEPlayShowPart paramAEPlayShowPart, String paramString, int paramInt) {}
  
  public void run()
  {
    if ("".equals(this.val$tabName)) {
      AEPlayShowPart.access$600(this.this$0, 0);
    }
    for (;;)
    {
      return;
      List localList = AEPlayShowPart.access$700(this.this$0).getmCategoryList();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          blux localblux = (blux)localList.get(i);
          if ((localblux != null) && (this.val$tabName != null) && (this.val$tabName.equals(localblux.b)))
          {
            AEPlayShowPart.access$600(this.this$0, i);
            if (AEPlayShowPart.access$700(this.this$0).getCurrentPageView() != null) {
              AEPlayShowPart.access$700(this.this$0).getCurrentPageView().scrollTo(this.val$scrollY);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.6
 * JD-Core Version:    0.7.0.1
 */