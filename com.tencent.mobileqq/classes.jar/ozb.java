import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.troopgift.GridListViewPager;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftAioPanelData.CoinInfo;
import com.tencent.biz.troopgift.TroopGiftAioPanelData.OperationInfo;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.OnGetGiveGiftCallback;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ozb
  implements TroopGiftPanel.OnGetGiveGiftCallback
{
  public ozb(TroopGiftPanel paramTroopGiftPanel, boolean paramBoolean) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a(paramList);
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.a))) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo.a);
    }
    if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.a)))
    {
      paramList = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo.a;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(paramList, localURLDrawableOptions));
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramList = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_d_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 0;
        paramList.setVisibility(i);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_d_of_type_Int != 2) {
          break label569;
        }
        ReportController.b(null, "dc00899", "Grp_flower", "", "C2C", "exp_opr", 0, 0, "", "", "", "");
        label246:
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.size() >= 2)
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.c = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_Int;
          ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.c)).jdField_a_of_type_Boolean = true;
        }
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.b == null)) {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_b_of_type_Int = 0;
        }
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.c == -1)) {
          break label846;
        }
      }
    }
    for (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.c));; this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.b.get(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int))) {
      label569:
      label846:
      do
      {
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData == null) && (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null)) {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = ((TroopGiftAioItemData)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList.get(0));
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ArrayOfComTencentBizTroopgiftGridListViewPager[0].setData(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_a_of_type_JavaUtilArrayList);
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData.jdField_b_of_type_Int != 0)) {
          break label1030;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(0);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e < 4) {
          break label917;
        }
        NearbyFlowerManager.a("gift_store", "exp_chose", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() + "", "", "");
        return;
        i = 8;
        break;
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_d_of_type_Int == 6)
        {
          ReportController.b(null, "dc00899", "Grp_flower", "", "discuss_grp", "exp_opr", 0, 0, "", "", "", "");
          break label246;
        }
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_d_of_type_Int == 7)
        {
          ReportController.b(null, "dc00899", "Grp_flower", "", "temp_c2c", "exp_opr", 0, 0, "", "", "", "");
          break label246;
        }
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.e >= 4)
        {
          NearbyFlowerManager.a("gift_store", "exp_oper", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b() + "", "", "");
          break label246;
        }
        if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a())) {}
        for (i = 2;; i = 1)
        {
          ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_opr", i, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
          break;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break label246;
      } while ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_b_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData == null) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.jdField_d_of_type_Int == -1));
    }
    label917:
    if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a())) {}
    for (int i = 2;; i = 1)
    {
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_num", i, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_b_of_type_JavaLangString, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
      return;
    }
    label1030:
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozb
 * JD-Core Version:    0.7.0.1
 */