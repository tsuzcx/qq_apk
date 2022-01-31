import android.view.View;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.EditVideoPoiSearch;
import com.tencent.biz.qqstory.takevideo.poilist.QQStoryPoiListAdapter;
import java.util.ArrayList;
import java.util.List;

public class okz
  implements LbsManager.POIListRequestCallback
{
  public okz(EditVideoPoiSearch paramEditVideoPoiSearch, String paramString) {}
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List paramList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = paramPOIListRequestSession;
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.isValidate()) {
      return;
    }
    if (paramInt == 0) {
      if (paramPOIListRequestSession.a()) {
        break label210;
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.d.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.a(bool);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.b()) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_JavaUtilArrayList, null);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.d.setVisibility(4);
        }
      }
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      StoryReportor.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okz
 * JD-Core Version:    0.7.0.1
 */