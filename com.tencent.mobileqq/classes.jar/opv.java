import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

final class opv
  implements bkhe
{
  opv(ReadInJoyCommentListView paramReadInJoyCommentListView, syi paramsyi) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Syi != null) {
      this.jdField_a_of_type_Syi.a(paramAbsListView);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((opu.a() == null) || (opu.a().size() == 0)) {}
    for (;;)
    {
      return;
      paramInt = opu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      int i = paramAbsListView.getFirstVisiblePosition();
      int j = paramAbsListView.getLastVisiblePosition();
      paramAbsListView = opu.a().iterator();
      while (paramAbsListView.hasNext())
      {
        Object localObject = (opw)paramAbsListView.next();
        int k = ((opw)localObject).jdField_a_of_type_Int;
        localObject = (ReadInJoyArticleBottomVideoView)((opw)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((k >= i - paramInt) && (k <= j - paramInt))
        {
          if (localObject != null) {
            ((ReadInJoyArticleBottomVideoView)localObject).n();
          }
        }
        else if (localObject != null) {
          ((ReadInJoyArticleBottomVideoView)localObject).q();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opv
 * JD-Core Version:    0.7.0.1
 */