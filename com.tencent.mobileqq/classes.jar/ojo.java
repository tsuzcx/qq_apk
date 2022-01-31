import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import java.util.ArrayList;

class ojo
  implements View.OnClickListener
{
  ojo(ojn paramojn) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a.a(paramView, i);
    nzv.a(this.a.a.getActivity(), "0X8009A71", this.a.a.a(), ((ojm)this.a.a.a.get(i)).a.mChannelCoverId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojo
 * JD-Core Version:    0.7.0.1
 */