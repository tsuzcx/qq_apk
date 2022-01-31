import android.text.TextUtils;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView.ILoadMoreDataListener;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper.OnLoadMoreListener;

public class nxd
  implements LoadingMoreHelper.OnLoadMoreListener
{
  public nxd(ShareGroupInnerListView paramShareGroupInnerListView) {}
  
  public void a()
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView$ILoadMoreDataListener != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView$ILoadMoreDataListener.a(this.a.jdField_a_of_type_JavaLangString);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView$ILoadMoreDataListener != null) {
      return this.a.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupInnerListView$ILoadMoreDataListener.a(this.a.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxd
 * JD-Core Version:    0.7.0.1
 */