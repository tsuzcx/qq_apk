import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;

public class nlx
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bfpc jdField_a_of_type_Bfpc;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public nlx(Activity paramActivity, AppInterface paramAppInterface)
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
      this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(this.jdField_a_of_type_AndroidAppActivity, null));
      Object localObject = new nly(this);
      this.jdField_a_of_type_Bfpc.a((bfpk)localObject);
      localObject = new ReadInJoyDisLikeDialogViewForAd(this.jdField_a_of_type_AndroidAppActivity);
      ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new nlz(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new nma(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(paramArrayList);
      this.jdField_a_of_type_Bfpc.a((View)localObject, null);
      try
      {
        if (!this.jdField_a_of_type_Bfpc.isShowing())
        {
          if ((bfnz.g()) && (!ShortVideoUtils.c()) && ((this.jdField_a_of_type_AndroidAppActivity instanceof Activity)))
          {
            this.jdField_a_of_type_Bfpc.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_Bfpc.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_Bfpc.setOnShowListener(new nmb(this));
          }
          this.jdField_a_of_type_Bfpc.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlx
 * JD-Core Version:    0.7.0.1
 */