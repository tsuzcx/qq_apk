import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;

public class rob
  implements wxx<CertifiedAccountRead.StGetMainPageRsp>
{
  public rob(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  private void a(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    ServiceAccountFolderActivityNew.a(this.a, ((CertifiedAccountMeta.StUser)paramStGetMainPageRsp.user.get()).id.get());
    String str = paramStGetMainPageRsp.user.icon.get();
    if ((!TextUtils.isEmpty(paramStGetMainPageRsp.user.icon.get())) && (URLUtil.isNetworkUrl(str)))
    {
      ServiceAccountFolderActivityNew.a(this.a).setImageURL(str);
      ServiceAccountFolderActivityNew.a(this.a).setOnClickListener(new roc(this));
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (paramBoolean)
    {
      if (paramStGetMainPageRsp != null)
      {
        ServiceAccountFolderActivityNew.a(this.a, paramStGetMainPageRsp);
        urk.c("ServiceAccountFolderActivityNew", "sendRequest GetMainPage success");
        a(paramStGetMainPageRsp);
        ServiceAccountFolderActivityNew.a(this.a);
      }
      return;
    }
    urk.c("ServiceAccountFolderActivityNew", "sendRequest GetMainPage error retCode:" + paramLong + ",errMsg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rob
 * JD-Core Version:    0.7.0.1
 */