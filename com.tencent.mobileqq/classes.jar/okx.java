import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class okx
  implements omo
{
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private List<omt> jdField_a_of_type_JavaUtilList;
  
  public okx(ReadInJoyCommentListView paramReadInJoyCommentListView, List<omt> paramList, omg paramomg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramomg.a(this);
  }
  
  private omg a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getAdapter() instanceof bhxm)))
    {
      bhxm localbhxm = (bhxm)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getAdapter();
      if ((localbhxm.getWrappedAdapter() instanceof omg)) {
        return (omg)localbhxm.getWrappedAdapter();
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt1 < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(paramInt1) != null))
    {
      ((omt)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).c = paramInt2;
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, "setHeight | postion " + paramInt1 + " itemHeight " + paramInt2);
    }
  }
  
  private int b(int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getWidth();
    int i = Utils.dp2px(300.0D);
    j = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
    if ((Build.VERSION.SDK_INT <= 19) && (paramInt == 0)) {}
    Object localObject;
    do
    {
      return i;
      localObject = a();
    } while (localObject == null);
    try
    {
      localObject = ((omg)localObject).a(paramInt, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, true);
      ((View)localObject).measure(j, 0);
      j = ((View)localObject).getMeasuredHeight();
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, "getItemMeasureHeight index : " + paramInt + " height : " + j);
      return j;
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, localException, new Object[] { " index : " + paramInt });
    }
    return i;
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 0) || ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() <= paramInt))) {
      return -1;
    }
    omt localomt = (omt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localomt.c > 0) {
      return localomt.c;
    }
    localomt.c = b(paramInt);
    return localomt.c;
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramView == null) {
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, "onGetView view is null");
    }
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localViewTreeObserver = paramView.getViewTreeObserver();
    } while (localViewTreeObserver == null);
    localViewTreeObserver.addOnGlobalLayoutListener(new oky(this, paramInt, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okx
 * JD-Core Version:    0.7.0.1
 */