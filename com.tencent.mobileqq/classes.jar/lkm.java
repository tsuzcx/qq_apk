import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public class lkm
  implements View.OnClickListener
{
  public lkm(ReadInJoyAtlasViewPagerAdapter paramReadInJoyAtlasViewPagerAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(2131362469);
    if ((localObject instanceof gallery.GalleryInfo))
    {
      gallery.GalleryInfo localGalleryInfo = (gallery.GalleryInfo)localObject;
      localObject = localGalleryInfo.bytes_row_key.get().toStringUtf8();
      int i = localGalleryInfo.int32_reason.get();
      int j = ((Integer)paramView.getTag(2131362470)).intValue();
      ReadInJoyAtlasFragment.a(paramView.getContext(), (String)localObject, 0, 1, 2, j, i, 0);
      localGalleryInfo.bytes_gallery_url.get().toStringUtf8();
      ((BaseActivity)paramView.getContext()).overridePendingTransition(2131034284, 0);
      long l = localGalleryInfo.uint64_article_id.get();
      paramView = localGalleryInfo.bytes_report_exdata.get().toStringUtf8();
      paramView = GalleryReportedUtils.a(ReadInJoyAtlasViewPagerAdapter.a(this.a), ReadInJoyUtils.a() + "", 2, l, j, (String)localObject, paramView, 4, 0);
      PublicAccountReportUtils.a(null, "", "0X8008E2F", "0X8008E2F", 0, 0, "", l + "", i + "", paramView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkm
 * JD-Core Version:    0.7.0.1
 */