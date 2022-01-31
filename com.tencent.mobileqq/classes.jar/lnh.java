import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImageList;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAllInOneBar;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public class lnh
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  public lnh(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (gallery.GalleryInfo)paramObject;
      ReadInJoyAtlasFragment.a(this.a, paramObject);
      this.a.a(1);
      long l;
      if (paramObject != null)
      {
        ReadInJoyAtlasFragment.a(this.a, paramObject.bytes_publisher_name.get().toStringUtf8());
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyAtlasFragment.c(this.a));
        l = paramObject.uint64_publisher_uin.get();
        ReadInJoyAtlasFragment.b(this.a, paramObject.bytes_subject.get().toStringUtf8());
        Object localObject = this.a;
        ReadInJoyAtlasManager.a();
        ReadInJoyAtlasFragment.c((ReadInJoyAtlasFragment)localObject, ReadInJoyAtlasManager.a(paramObject));
        localObject = paramObject.bytes_comments_url.get().toStringUtf8();
        ReadInJoyAtlasFragment.d(this.a, Long.toString(l));
        ReadInJoyAtlasFragment.a(this.a, paramObject.uint64_article_id.get());
        ReadInJoyAtlasFragment.b(this.a, paramObject.uint64_pic_count.get());
        ReadInJoyAtlasFragment.e(this.a, paramObject.bytes_report_exdata.get().toStringUtf8());
        Bundle localBundle = new Bundle();
        localBundle.putString("row_key", ReadInJoyAtlasFragment.a(this.a));
        localBundle.putByteArray("gallery_info", paramObject.toByteArray());
        localBundle.putInt("ability_mask", 7);
        localBundle.putString("comment_list_jump_url", (String)localObject);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.a(localBundle);
        localObject = ReadInJoyAtlasFragment.a(this.a).a(1, ReadInJoyAtlasFragment.d(this.a));
        if (localObject == null) {
          break label483;
        }
        this.a.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable((Bitmap)localObject));
        if (QLog.isColorLevel()) {
          QLog.d(ReadInJoyAtlasFragment.jdField_a_of_type_JavaLangString, 2, "mFaceDecoder.getBitmapFromCache() uin=" + ReadInJoyAtlasFragment.d(this.a) + " hit cache. time=" + System.currentTimeMillis());
        }
      }
      for (;;)
      {
        ReadInJoyAtlasFragment.a(this.a).a(l + "", 1, false);
        this.a.jdField_a_of_type_ComTencentImageURLImageView.setTag(Long.valueOf(l));
        ReadInJoyAtlasFragment.a(this.a, ReadInJoyAtlasManager.a().a(paramObject));
        paramObject = new AtlasModelImageList(ReadInJoyAtlasFragment.a(this.a));
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.a(paramObject);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.a(ReadInJoyAtlasFragment.e(this.a));
        if (this.a.jdField_a_of_type_Int != 1) {
          this.a.d();
        }
        ReadInJoyAtlasManager.a().b(ReadInJoyAtlasFragment.a(this.a), this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
        return;
        label483:
        ReadInJoyAtlasFragment.a(this.a).a(ReadInJoyAtlasFragment.d(this.a), 1, true, (byte)0);
        this.a.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(ImageUtil.b());
        if (QLog.isColorLevel()) {
          QLog.d(ReadInJoyAtlasFragment.jdField_a_of_type_JavaLangString, 2, "mFaceDecoder.getBitmapFromCache() uin=" + ReadInJoyAtlasFragment.d(this.a) + " not hit cache. time=" + System.currentTimeMillis());
        }
      }
    }
    paramObject = (String)paramObject;
    if ("阿嘞，内容被外星人带走啦~".equals(paramObject))
    {
      this.a.a(4, paramObject);
      return;
    }
    this.a.a(3, paramObject);
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
 * Qualified Name:     lnh
 * JD-Core Version:    0.7.0.1
 */