import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.util.GalleryShareHelper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lnb
  implements ActionSheet.OnButtonClickListener
{
  public lnb(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment, ActionSheet paramActionSheet, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    GalleryShareHelper localGalleryShareHelper = new GalleryShareHelper(ReadInJoyAtlasFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyAtlasFragment));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyAtlasFragment.getString(2131435871).equals(paramView)) {
      localGalleryShareHelper.a(ReadInJoyAtlasFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyAtlasFragment), this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyAtlasFragment.getString(2131435877).equals(paramView)) {
        localGalleryShareHelper.a(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnb
 * JD-Core Version:    0.7.0.1
 */