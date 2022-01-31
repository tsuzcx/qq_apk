package dov.com.qq.im.ae.play;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import bleh;

class AEVideoShelfEditFragment$20
  implements Runnable
{
  public void run()
  {
    if (AEVideoShelfEditFragment.a(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = AEVideoShelfEditFragment.a(this.this$0).getLayoutManager();
        } while (!(localObject instanceof LinearLayoutManager));
        int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
        localObject = AEVideoShelfEditFragment.a(this.this$0).getChildAt(this.a - i);
      } while (localObject == null);
      localObject = (bleh)AEVideoShelfEditFragment.a(this.this$0).getChildViewHolder((View)localObject);
    } while (localObject == null);
    ((bleh)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment.20
 * JD-Core Version:    0.7.0.1
 */