import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.qqshop.qqshop.SQQSHPAccoutRelation;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientRsp;
import tencent.im.oidb.qqshop.qqshop.SQQSHPNewUserRecmd;

class ngg
  implements BusinessObserver
{
  ngg(ngf paramngf) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("extra_cmd");
    if (paramBoolean)
    {
      if (!"SQQShopFolderSvc.GetShopBindUin".equals(localObject)) {
        break label205;
      }
      paramBundle = paramBundle.getByteArray("extra_data");
      localObject = new qqshop.SQQSHPClientRsp();
    }
    for (;;)
    {
      label205:
      try
      {
        ((qqshop.SQQSHPClientRsp)localObject).mergeFrom(paramBundle);
        paramBundle = ((qqshop.SQQSHPClientRsp)localObject).bindlist.get();
        paramInt = 0;
        if (paramInt < paramBundle.size())
        {
          localObject = (qqshop.SQQSHPAccoutRelation)paramBundle.get(paramInt);
          String str = String.valueOf(((qqshop.SQQSHPAccoutRelation)localObject).puin.get());
          long l = ((qqshop.SQQSHPAccoutRelation)localObject).binduin.get();
          this.a.c.put(str, Integer.valueOf(((qqshop.SQQSHPAccoutRelation)localObject).distance.get()));
          this.a.d.put(str, String.valueOf(l));
          paramInt += 1;
          continue;
        }
        if ((this.a.a != null) && (this.a.a.a != null) && (this.a.a.b == 1)) {
          this.a.a.a.notifyDataSetChanged();
        }
        return;
      }
      catch (Exception paramBundle) {}
      if ("SQQShopFolderSvc.GetFolderInfo".equals(localObject))
      {
        paramBundle = paramBundle.getByteArray("extra_data");
        localObject = new qqshop.SQQSHPClientRsp();
        try
        {
          ((qqshop.SQQSHPClientRsp)localObject).mergeFrom(paramBundle);
          if (((qqshop.SQQSHPClientRsp)localObject).newusrrecmd.has())
          {
            paramBundle = (qqshop.SQQSHPNewUserRecmd)((qqshop.SQQSHPClientRsp)localObject).newusrrecmd.get();
            if ((paramBundle.recmdflag.has()) && (paramBundle.recmdflag.get() == 1))
            {
              paramBundle = paramBundle.recmdurl.get();
              if ((!TextUtils.isEmpty(paramBundle)) && (this.a.a != null))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("EcshopCacheTool", 2, "newusrrecmd url:" + paramBundle);
                }
                localObject = new Intent(this.a.a.getActivity(), QQBrowserActivity.class);
                ((Intent)localObject).putExtra("url", paramBundle);
                ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
                this.a.a.startActivity((Intent)localObject);
                this.a.a.getActivity().overridePendingTransition(2130771979, 0);
                awqx.b(null, "CliOper", "", "", "Shop_newuser", "Pv_shopnewuserpage", 0, 0, "", "", "", "");
                return;
              }
            }
          }
        }
        catch (Exception paramBundle) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngg
 * JD-Core Version:    0.7.0.1
 */