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

public class oin
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bkzi jdField_a_of_type_Bkzi;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public oin(Activity paramActivity, AppInterface paramAppInterface)
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
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this.jdField_a_of_type_AndroidAppActivity, null));
      Object localObject = new oio(this);
      this.jdField_a_of_type_Bkzi.a((bkzu)localObject);
      localObject = new ReadInJoyDisLikeDialogViewForAd(this.jdField_a_of_type_AndroidAppActivity);
      ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new oip(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new oiq(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(paramArrayList);
      this.jdField_a_of_type_Bkzi.a((View)localObject, null);
      try
      {
        if (!this.jdField_a_of_type_Bkzi.isShowing())
        {
          if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.isInFullScreenBlackList()) && ((this.jdField_a_of_type_AndroidAppActivity instanceof Activity)))
          {
            this.jdField_a_of_type_Bkzi.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_Bkzi.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_Bkzi.setOnShowListener(new oir(this));
          }
          this.jdField_a_of_type_Bkzi.show();
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
 * Qualified Name:     oin
 * JD-Core Version:    0.7.0.1
 */