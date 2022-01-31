import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment.ReportEventListener;
import com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public class lqd
  implements ViewPager.OnPageChangeListener
{
  public lqd(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ReadInJoyAtlasFragment.a(this.a).a(2, null);
    if (paramInt == 0)
    {
      this.a.b(1);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setVisibility(0);
    }
    for (;;)
    {
      return;
      if (paramInt == 1)
      {
        this.a.b(2);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.a();
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setVisibility(4);
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("exitType", 4);
        ((Bundle)localObject).putSerializable("lastShowImageModel", this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.b());
        ReadInJoyAtlasFragment.a(this.a).a(-2, (Bundle)localObject);
        localObject = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.a();
        List localList1 = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.b();
        List localList2 = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.c();
        long l1 = System.currentTimeMillis();
        if ((localObject == null) || (((List)localObject).size() <= 0) || (localList1.size() <= 0) || (localList2.size() <= 0)) {
          break;
        }
        paramInt = 0;
        while ((paramInt < ((List)localObject).size()) && (paramInt < localList1.size()) && (paramInt < localList2.size()))
        {
          String str1 = GalleryReportedUtils.a((String)((List)localObject).get(paramInt), System.currentTimeMillis());
          gallery.GalleryInfo localGalleryInfo = (gallery.GalleryInfo)localList2.get(paramInt);
          int i = ((Integer)localList1.get(paramInt)).intValue();
          long l2 = localGalleryInfo.uint64_article_id.get();
          String str2 = localGalleryInfo.bytes_row_key.get().toStringUtf8();
          String str3 = localGalleryInfo.bytes_report_exdata.get().toStringUtf8();
          int j = localGalleryInfo.int32_reason.get();
          PublicAccountReportUtils.a(null, "", "0X8008E2E", "0X8008E2E", 0, 0, "", l2 + "", j + "", str1, false);
          GalleryReportedUtils.a(7, ReadInJoyUtils.a(), j, 2, l1, i, str2, str3);
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqd
 * JD-Core Version:    0.7.0.1
 */