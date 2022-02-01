import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;

public class nzl
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private blir jdField_a_of_type_Blir;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public nzl(Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, ArrayList<DislikeInfo> paramArrayList)
  {
    if ((paramAdvertisementInfo == null) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Blir = ((blir)blji.a(this.jdField_a_of_type_AndroidAppActivity, null));
      Object localObject = new nzm(this);
      this.jdField_a_of_type_Blir.a((bljd)localObject);
      localObject = new ReadInJoyDisLikeDialogViewForAd(this.jdField_a_of_type_AndroidAppActivity);
      ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new nzn(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new nzo(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(paramArrayList);
      this.jdField_a_of_type_Blir.a((View)localObject, null);
      try
      {
        if (!this.jdField_a_of_type_Blir.isShowing())
        {
          if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.c()) && ((this.jdField_a_of_type_AndroidAppActivity instanceof Activity)))
          {
            this.jdField_a_of_type_Blir.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_Blir.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_Blir.setOnShowListener(new nzp(this));
          }
          this.jdField_a_of_type_Blir.show();
          return;
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzl
 * JD-Core Version:    0.7.0.1
 */