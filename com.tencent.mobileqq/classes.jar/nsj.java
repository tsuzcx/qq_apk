import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity.12.1;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class nsj
  implements BusinessObserver
{
  public nsj(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "follow isSuccess:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.d(2131694775);
    }
    for (;;)
    {
      EqqAccountDetailActivity.c(this.a);
      if (EqqAccountDetailActivity.d(this.a) == 0) {
        EqqAccountDetailActivity.d(this.a);
      }
      EqqAccountDetailActivity.b(this.a).postDelayed(new EqqAccountDetailActivity.12.1(this), 1000L);
      return;
      Object localObject = new JSONObject();
      ((FriendListHandler)EqqAccountDetailActivity.j(this.a).getBusinessHandler(1)).getFriendGroupList(true, false);
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin);
        ((JSONObject)localObject).put("name", this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
        ((JSONObject)localObject).put("summary", this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.summary);
        ((JSONObject)localObject).put("certified", this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.certifiedGrade);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.mp.qq.com");
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("article.mp.qq.com");
        autn.a("follow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label555;
        }
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            continue;
          }
          localObject = new mobileqq_mp.FollowResponse();
          ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
          if (paramInt == 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType = 1;
            EqqAccountDetailActivity.a(this.a).setEnabled(false);
            EqqAccountDetailActivity.b(this.a);
            this.a.i();
            EqqAccountDetailActivity.c(this.a);
            AccountDetailActivity.a(EqqAccountDetailActivity.k(this.a), EqqAccountDetailActivity.k(this.a), EqqAccountDetailActivity.a(this.a));
            if ((TextUtils.isEmpty(this.a.b)) || (TextUtils.isEmpty(this.a.c))) {
              continue;
            }
            bcef.b(EqqAccountDetailActivity.l(this.a), "CliOper", "", "", this.a.b, this.a.c, 0, 0, "", "", EqqAccountDetailActivity.m(this.a).getCurrentAccountUin(), EqqAccountDetailActivity.l(this.a));
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "----[follow report done]----");
          }
        }
        catch (Exception paramBundle) {}
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (paramInt == 58)
        {
          this.a.d(2131694772);
          continue;
        }
        if (paramInt == 65)
        {
          this.a.d(2131694749);
          continue;
        }
        if (paramInt == 20)
        {
          this.a.d(2131694750);
          continue;
        }
        this.a.d(2131694775);
      }
      continue;
      label555:
      this.a.d(2131694775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsj
 * JD-Core Version:    0.7.0.1
 */