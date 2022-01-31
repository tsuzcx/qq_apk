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

public class not
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bhpy jdField_a_of_type_Bhpy;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public not(Activity paramActivity, AppInterface paramAppInterface)
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
      this.jdField_a_of_type_Bhpy = ((bhpy)bhql.a(this.jdField_a_of_type_AndroidAppActivity, null));
      Object localObject = new nou(this);
      this.jdField_a_of_type_Bhpy.a((bhqg)localObject);
      localObject = new ReadInJoyDisLikeDialogViewForAd(this.jdField_a_of_type_AndroidAppActivity);
      ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new nov(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new now(this, paramAdvertisementInfo));
      ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(paramArrayList);
      this.jdField_a_of_type_Bhpy.a((View)localObject, null);
      try
      {
        if (!this.jdField_a_of_type_Bhpy.isShowing())
        {
          if ((bhou.g()) && (!ShortVideoUtils.c()) && ((this.jdField_a_of_type_AndroidAppActivity instanceof Activity)))
          {
            this.jdField_a_of_type_Bhpy.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_Bhpy.getWindow().getDecorView().setSystemUiVisibility(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_Bhpy.setOnShowListener(new nox(this));
          }
          this.jdField_a_of_type_Bhpy.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     not
 * JD-Core Version:    0.7.0.1
 */