import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mxx
  implements View.OnClickListener
{
  mxx(mxw parammxw) {}
  
  public void onClick(View paramView)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((mxz)paramView.getTag()).a;
    Object localObject2 = localFileManagerEntity.Uuid;
    mxw localmxw = this.a;
    Object localObject1 = localObject2;
    if (((String)localObject2).equalsIgnoreCase(mxw.a(this.a))) {
      localObject1 = null;
    }
    mxw.a(localmxw, (String)localObject1);
    this.a.notifyDataSetChanged();
    if (mxw.a(this.a) != null)
    {
      localObject2 = mxw.a(this.a);
      if (mxw.a(this.a) == null) {
        break label113;
      }
    }
    label113:
    for (localObject1 = localFileManagerEntity;; localObject1 = null)
    {
      ((mya)localObject2).a((FileManagerEntity)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxx
 * JD-Core Version:    0.7.0.1
 */