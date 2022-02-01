import android.animation.AnimatorSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.ColumnEntranceAnimationHelper.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class qah
  implements blih
{
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  
  private boolean a(ReadInJoyXListView paramReadInJoyXListView)
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getLocationInWindow(arrayOfInt);
    int i = Utils.dp2px(100.0D);
    int j = arrayOfInt[1];
    QLog.i("ColumnEntranceAnimationHelper", 1, "listView.getHeight()：" + paramReadInJoyXListView.getHeight() + "minTop:" + i);
    return (j < paramReadInJoyXListView.getHeight()) && (j > i);
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView)
  {
    paramReadInJoyXListView.b(this);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null))
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new ColumnEntranceAnimationHelper.1(this, paramAbsListView);
      }
      paramAbsListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      paramAbsListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qah
 * JD-Core Version:    0.7.0.1
 */