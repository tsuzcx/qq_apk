import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyAtlasPageLoader;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public class lpy
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  public lpy(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, Object paramObject)
  {
    int i = 1;
    if (paramInt == 1)
    {
      if (i == 0) {
        break label161;
      }
      ReadInJoyAtlasFragment.a(this.a, paramBoolean, paramObject);
      label22:
      if (!paramBoolean) {
        break label173;
      }
      paramObject = (gallery.GalleryInfo)paramObject;
      paramBoolean = ReadinjoyAtlasPageLoader.a(paramObject);
      if (QLog.isColorLevel()) {
        QLog.d(ReadInJoyAtlasFragment.jdField_a_of_type_JavaLangString, 2, "handleAtlasList succ, pageIndex=" + paramInt + " pageSize=" + paramObject.rpt_msg_pic_info.get().size() + " isEnd:" + paramBoolean + " totalCount:" + paramObject.uint64_pic_count.get() + " gallery size:" + this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.a());
      }
      if (paramBoolean) {
        ReadInJoyAtlasManager.a().a(ReadInJoyAtlasFragment.a(this.a), this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
      }
    }
    label161:
    label173:
    while (!QLog.isColorLevel())
    {
      return;
      i = 0;
      break;
      ReadInJoyAtlasFragment.b(this.a, paramBoolean, paramObject);
      break label22;
    }
    QLog.d(ReadInJoyAtlasFragment.jdField_a_of_type_JavaLangString, 2, "handleAtlasList failed, pageIndex:" + paramInt + " result:" + paramObject.toString());
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (paramList != null)
    {
      paramList = ReadInJoyAtlasManager.a().a(paramList);
      if (paramList != null) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.a(paramList, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpy
 * JD-Core Version:    0.7.0.1
 */