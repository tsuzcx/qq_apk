import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import java.util.ArrayList;

class pab
  implements View.OnClickListener
{
  pab(paa parampaa) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a.a(paramView, i);
    opn.a(this.a.a.getActivity(), "0X8009A71", this.a.a.a(), ((ozz)this.a.a.a.get(i)).a.mChannelCoverId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pab
 * JD-Core Version:    0.7.0.1
 */