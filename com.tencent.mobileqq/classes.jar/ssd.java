import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class ssd
  implements View.OnClickListener
{
  public ssd(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  public void onClick(View paramView)
  {
    if (yxv.a("service_account_folder_publish_feed_button", 2000L)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = amrk.a(this.a);; bool = true)
    {
      if (!bool)
      {
        bdgm.b(this.a);
        return;
      }
      paramView = new Intent();
      paramView.putExtra("postUin", ServiceAccountFolderActivityNew.a(this.a));
      paramView.putExtra("sourceFrom", 2);
      String str;
      if ((ServiceAccountFolderActivityNew.a(this.a) != null) && (ServiceAccountFolderActivityNew.a(this.a).user.youZhan.size() > 0))
      {
        if (((CertifiedAccountMeta.StYouZanShop)ServiceAccountFolderActivityNew.a(this.a).user.youZhan.get(0)).type.get() > 1)
        {
          bool = true;
          paramView.putExtra("has_shop", bool);
        }
      }
      else
      {
        bjdt.a(this.a.getActivity(), paramView, 0);
        str = ((CertifiedAccountMeta.StUser)ServiceAccountFolderActivityNew.a(this.a).user.get()).id.get();
        if (ServiceAccountFolderActivityNew.a(this.a) != 0) {
          break label217;
        }
      }
      label217:
      for (paramView = "auth_follow";; paramView = "auth_discover")
      {
        zaj.a(str, paramView, "post_clk", 0, 0, new String[] { "", "" });
        return;
        bool = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ssd
 * JD-Core Version:    0.7.0.1
 */