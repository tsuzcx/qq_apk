import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.ColumnEntranceAnimationHelper.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class ppy
  implements bhpo
{
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  
  public ppy(ViewBase paramViewBase)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = paramViewBase;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView();
    ((View)localObject).setScaleX(0.0F);
    ((View)localObject).setScaleY(0.0F);
    paramViewBase = ObjectAnimator.ofFloat(localObject, "ScaleX", new float[] { 0.0F, 1.0F, 0.8F, 1.2F, 1.0F });
    localObject = ObjectAnimator.ofFloat(localObject, "ScaleY", new float[] { 0.0F, 1.0F, 0.8F, 1.2F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { paramViewBase, localObject });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new AccelerateInterpolator(1.5F));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(300L);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, Container paramContainer, pgd parampgd)
  {
    if ((paramBaseArticleInfo.isShowColumnAnimation) && (!paramBaseArticleInfo.isColumnAnimationPlay))
    {
      paramBaseArticleInfo.isShowColumnAnimation = false;
      paramContainer = paramContainer.getVirtualView().findViewBaseByName("id_column_root");
      if (paramContainer != null) {}
    }
    else
    {
      return;
    }
    paramContainer.setVisibility(8);
    parampgd = (ReadInJoyXListView)parampgd.a().a();
    if (paramContainer.getTag() != null) {
      parampgd.b((ppy)paramContainer.getTag());
    }
    ppy localppy = new ppy(paramContainer);
    localppy.a(paramBaseArticleInfo);
    parampgd.a(localppy);
    paramContainer.setTag(localppy);
    localppy.onScrollStateChanged(parampgd, 0);
  }
  
  private boolean a(ReadInJoyXListView paramReadInJoyXListView)
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getLocationInWindow(arrayOfInt);
    int i = Utils.dp2px(100.0D);
    int j = arrayOfInt[1];
    QLog.i("ColumnEntranceAnimationHelper", 1, "listView.getHeight()：" + paramReadInJoyXListView.getHeight() + "minTop:" + i);
    return (j < paramReadInJoyXListView.getHeight()) && (j > i);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ppy
 * JD-Core Version:    0.7.0.1
 */