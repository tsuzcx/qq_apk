package dov.com.qq.im.ae.play;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEPlayShowGridViewHolder$2
  implements View.OnClickListener
{
  AEPlayShowGridViewHolder$2(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mPlayMaterial != null) && (AEPlayShowGridViewHolder.access$000(this.this$0) != null)) {
      AEPlayShowGridViewHolder.access$000(this.this$0).onItemClicked(paramView, this.this$0.mPlayMaterial, AEPlayShowGridViewHolder.access$100(this.this$0));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.2
 * JD-Core Version:    0.7.0.1
 */