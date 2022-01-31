import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;

public class qmg
  extends RecyclerView.ViewHolder
{
  public final int a;
  public VideoFeedsAlphaMaskView a;
  public int b;
  public boolean b;
  public int c;
  
  public qmg(View paramView, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)paramView.findViewById(2131364547));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(qls paramqls, LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.getVisibility() != 0)) {
      return;
    }
    if (paramLinearLayoutManager.getOrientation() == 1)
    {
      if (i == 0) {
        break label118;
      }
      i = paramLinearLayoutManager.getDecoratedMeasuredHeight(this.itemView);
    }
    for (float f1 = Math.abs(paramLinearLayoutManager.getDecoratedTop(this.itemView) - (paramLinearLayoutManager.getHeight() / 2 - i / 2)) / i;; f1 = Math.abs(paramLinearLayoutManager.getDecoratedLeft(this.itemView) - (paramLinearLayoutManager.getWidth() / 2 - i / 2)) / i)
    {
      float f2 = Math.round(f1 * 100.0F) / 100.0F;
      f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(f1);
      return;
      i = 0;
      break;
      label118:
      i = paramLinearLayoutManager.getDecoratedMeasuredWidth(this.itemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmg
 * JD-Core Version:    0.7.0.1
 */