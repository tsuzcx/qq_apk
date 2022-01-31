import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public class ssy
  extends yiu
{
  private FolderRecommendTabFragment.FolderRecommendHeadItemView jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  private TopPanelViewNew jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew;
  private yda jdField_a_of_type_Yda;
  
  public ssy(FolderRecommendTabFragment paramFolderRecommendTabFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, yhy paramyhy)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  }
  
  public void loadData(yii paramyii)
  {
    if ((paramyii.c()) && (swy.b()) && (this.jdField_a_of_type_Yda != null)) {
      this.jdField_a_of_type_Yda.b();
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Yda != null) {
      this.jdField_a_of_type_Yda.c();
    }
  }
  
  public void onPrepareParams(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew = new TopPanelViewNew(getActivity());
    paramBundle = new FrameLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew.setLayoutParams(paramBundle);
    this.jdField_a_of_type_Yda = new yda(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew);
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = new FolderRecommendTabFragment.FolderRecommendHeadItemView(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment, getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelViewNew.setOnHideBtnClickListener(new ssz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ssy
 * JD-Core Version:    0.7.0.1
 */