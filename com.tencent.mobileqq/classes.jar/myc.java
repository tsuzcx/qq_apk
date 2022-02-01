import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class myc
  implements View.OnClickListener
{
  myc(myb parammyb) {}
  
  public void onClick(View paramView)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((mye)paramView.getTag()).a;
    Object localObject2 = localFileManagerEntity.Uuid;
    myb localmyb = this.a;
    Object localObject1 = localObject2;
    if (((String)localObject2).equalsIgnoreCase(myb.a(this.a))) {
      localObject1 = null;
    }
    myb.a(localmyb, (String)localObject1);
    this.a.notifyDataSetChanged();
    if (myb.a(this.a) != null)
    {
      localObject2 = myb.a(this.a);
      if (myb.a(this.a) == null) {
        break label113;
      }
    }
    label113:
    for (localObject1 = localFileManagerEntity;; localObject1 = null)
    {
      ((myf)localObject2).a((FileManagerEntity)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myc
 * JD-Core Version:    0.7.0.1
 */