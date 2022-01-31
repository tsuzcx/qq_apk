package dov.com.qq.im.AECamera.qudong;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import bhcg;

class AEVideoShelfEditFragment$17
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
      localObject = (bhcg)AEVideoShelfEditFragment.a(this.this$0).getChildViewHolder((View)localObject);
    } while (localObject == null);
    ((bhcg)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.qudong.AEVideoShelfEditFragment.17
 * JD-Core Version:    0.7.0.1
 */