import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter.OnChildGalleryEventListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment.ReportEventListener;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyAtlasPageLoader;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModel;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImage;
import com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.gallery.gallery.GalleryInfo;
import tencent.im.oidb.gallery.gallery.PictureInfo;

public class lqf
  implements ReadInJoyAtlasViewPagerAdapter.OnChildGalleryEventListener
{
  public lqf(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasFragment.jdField_a_of_type_JavaLangString, 2, "start loadMoreData");
    }
    ReadInJoyAtlasFragment.a(this.a).b();
  }
  
  public void a(int paramInt, AtlasModel paramAtlasModel)
  {
    if ((paramAtlasModel != null) && ((paramAtlasModel instanceof AtlasModelImage)))
    {
      ReadInJoyAtlasFragment.a(this.a).a(3, null);
      if (ReadInJoyAtlasFragment.a(this.a) == 1)
      {
        if (!this.a.jdField_a_of_type_Boolean) {
          break label54;
        }
        this.a.f();
      }
    }
    return;
    label54:
    this.a.e();
  }
  
  public void a(int paramInt, AtlasModel paramAtlasModel1, AtlasModel paramAtlasModel2)
  {
    if ((paramAtlasModel1 != null) && ((paramAtlasModel1 instanceof AtlasModelImage)))
    {
      paramAtlasModel1 = (AtlasModelImage)paramAtlasModel1;
      if (paramAtlasModel2 != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("lastShowImageModel", paramAtlasModel2);
        ReadInJoyAtlasFragment.a(this.a).a(-1, localBundle);
      }
      if (ReadInJoyAtlasFragment.a(this.a)) {
        ReadInJoyAtlasFragment.c(this.a, false);
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.getVisibility() != 0) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setVisibility(0);
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setText(paramInt, (int)ReadInJoyAtlasFragment.a(this.a).uint64_pic_count.get(), ReadInJoyAtlasFragment.a(this.a, paramAtlasModel1));
        ReadInJoyAtlasFragment.a(this.a, paramInt);
        if ((paramAtlasModel1.pictureInfo != null) && (paramAtlasModel1.pictureInfo.bytes_pic_url.has())) {
          ReadInJoyAtlasFragment.a(this.a, paramAtlasModel1.pictureInfo.bytes_pic_url.get().toStringUtf8());
        }
        return;
        ReadInJoyAtlasFragment.a(this.a).a(2, null);
      }
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setText("");
    ReadInJoyAtlasFragment.a(this.a, paramInt);
  }
  
  public void b(int paramInt, AtlasModel paramAtlasModel)
  {
    if ((paramAtlasModel != null) && ((paramAtlasModel instanceof AtlasModelImage)))
    {
      paramAtlasModel = ((AtlasModelImage)paramAtlasModel).pictureInfo.bytes_pic_url.get().toStringUtf8();
      ReadInJoyAtlasFragment.a(this.a, paramAtlasModel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqf
 * JD-Core Version:    0.7.0.1
 */