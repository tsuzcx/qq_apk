import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.ProteusPagerSnapHelper.1;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class qkr
  extends bjxh
  implements qkg
{
  private int jdField_a_of_type_Int = 3000;
  private ProteusRecycleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView;
  public Runnable a;
  private boolean jdField_a_of_type_Boolean;
  private int b = 1000;
  
  public qkr()
  {
    this.jdField_a_of_type_JavaLangRunnable = new ProteusPagerSnapHelper.1(this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a(LinearLayoutManager paramLinearLayoutManager)
  {
    int i = paramLinearLayoutManager.getChildCount();
    Object localObject;
    if (i == 0) {
      localObject = null;
    }
    OrientationHelper localOrientationHelper;
    do
    {
      View localView;
      do
      {
        return localObject;
        localOrientationHelper = a(paramLinearLayoutManager);
        localView = paramLinearLayoutManager.getChildAt(0);
        localObject = localView;
      } while (Math.abs(localOrientationHelper.getDecoratedStart(localView)) < 20);
      if (i <= 1) {
        break;
      }
      localObject = paramLinearLayoutManager.getChildAt(i - 1);
      i = localOrientationHelper.getDecoratedEnd((View)localObject);
    } while (Math.abs(localOrientationHelper.getTotalSpace() - i) < 20);
    return super.a(paramLinearLayoutManager);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.b(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.a(this);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      return;
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int);
  }
  
  public void a(@Nullable RecyclerViewCompat paramRecyclerViewCompat)
  {
    super.a(paramRecyclerViewCompat);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView = ((ProteusRecycleView)paramRecyclerViewCompat);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPolymericProteusRecycleView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qkr
 * JD-Core Version:    0.7.0.1
 */