import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;

public class sas
  implements xgx<CertifiedAccountRead.StGetMainPageRsp>
{
  public sas(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  private void a(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    CertifiedAccountMeta.StUser localStUser = (CertifiedAccountMeta.StUser)paramStGetMainPageRsp.user.get();
    ServiceAccountFolderActivityNew.a(this.a, localStUser.id.get());
    String str = localStUser.icon.get();
    if ((!TextUtils.isEmpty(paramStGetMainPageRsp.user.icon.get())) && (URLUtil.isNetworkUrl(str)))
    {
      ServiceAccountFolderActivityNew.a(this.a).setImageURL(str);
      ServiceAccountFolderActivityNew.a(this.a).setOnClickListener(new sat(this, localStUser));
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (paramBoolean)
    {
      if (paramStGetMainPageRsp != null)
      {
        ServiceAccountFolderActivityNew.a(this.a, paramStGetMainPageRsp);
        veg.c("ServiceAccountFolderActivityNew", "sendRequest GetMainPage success");
        a(paramStGetMainPageRsp);
        ServiceAccountFolderActivityNew.a(this.a);
        ServiceAccountFolderActivityNew.a(this.a, paramStGetMainPageRsp);
      }
      return;
    }
    veg.c("ServiceAccountFolderActivityNew", "sendRequest GetMainPage error retCode:" + paramLong + ",errMsg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sas
 * JD-Core Version:    0.7.0.1
 */