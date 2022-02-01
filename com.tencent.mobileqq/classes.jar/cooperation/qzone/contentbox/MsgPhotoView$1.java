package cooperation.qzone.contentbox;

import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.contentbox.model.MsgOnClickListener;

class MsgPhotoView$1
  implements View.OnClickListener
{
  MsgPhotoView$1(MsgPhotoView paramMsgPhotoView) {}
  
  public void onClick(View paramView)
  {
    if (MsgPhotoView.access$000(this.this$0) != null)
    {
      if (paramView == MsgPhotoView.access$100(this.this$0))
      {
        MsgPhotoView.access$000(this.this$0).onClick(this.this$0.mData, paramView, 1);
        return;
      }
      if (paramView == MsgPhotoView.access$200(this.this$0))
      {
        MsgPhotoView.access$000(this.this$0).onClick(this.this$0.mData, paramView, 2);
        return;
      }
      if (paramView == MsgPhotoView.access$300(this.this$0))
      {
        MsgPhotoView.access$000(this.this$0).onClick(this.this$0.mData, paramView, 3);
        return;
      }
      if (paramView == MsgPhotoView.access$400(this.this$0))
      {
        MsgPhotoView.access$000(this.this$0).onClick(this.this$0.mData, paramView, 4);
        return;
      }
      MsgPhotoView.access$000(this.this$0).onClick(this.this$0.mData, paramView, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.1
 * JD-Core Version:    0.7.0.1
 */