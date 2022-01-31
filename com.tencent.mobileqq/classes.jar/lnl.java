import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter.OnChildGalleryEventListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment.ReportEventListener;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModel;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImage;
import com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.gallery.gallery.PictureInfo;

public class lnl
  implements ReadInJoyAtlasViewPagerAdapter.OnChildGalleryEventListener
{
  public lnl(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void a(int paramInt, AtlasModelImage paramAtlasModelImage)
  {
    ReadInJoyAtlasFragment.a(this.a).a(3, null);
    if (ReadInJoyAtlasFragment.a(this.a) == 1)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.g();
      }
    }
    else {
      return;
    }
    this.a.f();
  }
  
  public void a(int paramInt, AtlasModelImage paramAtlasModelImage, AtlasModel paramAtlasModel)
  {
    if (paramAtlasModel != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("lastShowImageModel", paramAtlasModel);
      ReadInJoyAtlasFragment.a(this.a).a(-1, localBundle);
    }
    if (ReadInJoyAtlasFragment.a(this.a)) {
      ReadInJoyAtlasFragment.c(this.a, false);
    }
    for (;;)
    {
      if (paramAtlasModelImage != null)
      {
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.getVisibility() != 0) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setVisibility(0);
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setText(paramInt, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.a(), ReadInJoyAtlasFragment.a(this.a, paramAtlasModelImage));
        ReadInJoyAtlasFragment.a(this.a, paramInt);
        if ((paramAtlasModelImage.pictureInfo != null) && (paramAtlasModelImage.pictureInfo.bytes_pic_url.has())) {
          ReadInJoyAtlasFragment.f(this.a, paramAtlasModelImage.pictureInfo.bytes_pic_url.get().toStringUtf8());
        }
      }
      return;
      ReadInJoyAtlasFragment.a(this.a).a(2, null);
    }
  }
  
  public void b(int paramInt, AtlasModelImage paramAtlasModelImage)
  {
    paramAtlasModelImage = paramAtlasModelImage.pictureInfo.bytes_pic_url.get().toStringUtf8();
    ReadInJoyAtlasFragment.a(this.a, paramAtlasModelImage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnl
 * JD-Core Version:    0.7.0.1
 */