import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class osr
  implements oui
{
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private List<ouo> jdField_a_of_type_JavaUtilList;
  
  public osr(ReadInJoyCommentListView paramReadInJoyCommentListView, List<ouo> paramList, ouc paramouc)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramouc.a(this);
  }
  
  private ouc a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getAdapter() instanceof bjqx)))
    {
      bjqx localbjqx = (bjqx)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getAdapter();
      if ((localbjqx.getWrappedAdapter() instanceof ouc)) {
        return (ouc)localbjqx.getWrappedAdapter();
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt1 < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(paramInt1) != null))
    {
      ((ouo)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).c = paramInt2;
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
      localObject = ((ouc)localObject).a(paramInt, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, true);
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
    ouo localouo = (ouo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localouo.c > 0) {
      return localouo.c;
    }
    localouo.c = b(paramInt);
    return localouo.c;
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
    localViewTreeObserver.addOnGlobalLayoutListener(new oss(this, paramInt, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osr
 * JD-Core Version:    0.7.0.1
 */