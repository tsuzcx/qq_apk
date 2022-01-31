import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import java.util.Iterator;
import java.util.List;

public class nrr
  extends BroadcastReceiver
{
  public nrr(ShopWebViewFragment paramShopWebViewFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          paramContext = paramIntent.getAction();
          localObject = paramIntent.getStringExtra("uin");
          Bitmap localBitmap = (Bitmap)paramIntent.getParcelableExtra("bitmap");
          if (!"action_decode_finish".equals(paramContext)) {
            break;
          }
          if ((this.a.jdField_a_of_type_Nrg != null) && (!TextUtils.isEmpty((CharSequence)localObject)) && (localBitmap != null)) {
            this.a.jdField_a_of_type_Nrg.a((String)localObject, localBitmap);
          }
        } while (this.a.jdField_a_of_type_Nrm == null);
        this.a.jdField_a_of_type_Nrm.a((String)localObject);
        return;
      } while (!"action_on_shop_msg_receive".equals(paramContext));
      this.a.jdField_a_of_type_JavaUtilList = paramIntent.getParcelableArrayListExtra("datas");
      paramContext = this.a.getActivity();
      if ((paramContext instanceof EcshopWebActivity)) {
        ((EcshopWebActivity)paramContext).jdField_a_of_type_JavaUtilList = this.a.jdField_a_of_type_JavaUtilList;
      }
      paramContext = paramIntent.getStringExtra("uin");
      paramIntent = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (paramIntent.hasNext())
      {
        localObject = (RecentShopParcel)paramIntent.next();
        if ((!TextUtils.isEmpty(((RecentShopParcel)localObject).a)) && (((RecentShopParcel)localObject).a.equals(paramContext))) {
          ((RecentShopParcel)localObject).b += 1;
        }
      }
    } while ((this.a.b != 1) || (this.a.jdField_a_of_type_Nrm == null));
    this.a.jdField_a_of_type_Nrm.a(this.a.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrr
 * JD-Core Version:    0.7.0.1
 */