import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class rnz
  implements View.OnClickListener
{
  public rnz(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  public void onClick(View paramView)
  {
    if (wpl.a("service_account_folder_publish_feed_button", 2000L)) {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("postUin", ServiceAccountFolderActivityNew.a(this.a));
    paramView.putExtra("sourceFrom", 2);
    boolean bool;
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
      bfpr.a(this.a.getActivity(), paramView, 0);
      str = ((CertifiedAccountMeta.StUser)ServiceAccountFolderActivityNew.a(this.a).user.get()).id.get();
      if (ServiceAccountFolderActivityNew.a(this.a) != 0) {
        break label188;
      }
    }
    label188:
    for (paramView = "auth_follow";; paramView = "auth_discover")
    {
      wye.a(str, paramView, "post_clk", 0, 0, new String[] { "", "" });
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnz
 * JD-Core Version:    0.7.0.1
 */