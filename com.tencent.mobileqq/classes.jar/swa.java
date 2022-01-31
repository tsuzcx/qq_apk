import android.view.View;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class swa
  extends CardObserver
{
  public swa(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListActivity", 2, "onCardDownload isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      if (paramObject.uin.equals(this.a.b)) {
        this.a.app.a(new swb(this, paramObject));
      }
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, List paramList, int paramInt, boolean paramBoolean2)
  {
    int i;
    if (QLog.isColorLevel())
    {
      String str = "onReqLikeRankingListResult success:" + paramBoolean1;
      paramString = new StringBuilder().append(", uin:").append(paramString).append(", size:");
      if (paramList == null)
      {
        i = 0;
        QLog.d("LikeRankingListActivity", 2, new Object[] { str, i + ", nextIndex: " + paramInt + ", isComplete:" + paramBoolean2 });
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label332;
      }
      if ((paramList == null) || ((paramList.size() <= 0) && (!paramBoolean2))) {
        break label275;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a(paramList, paramInt, paramBoolean2);
      if ((!paramBoolean2) || (paramList.size() != 0)) {
        break label249;
      }
      this.a.e.setVisibility(0);
      label165:
      this.a.jdField_a_of_type_Swi.a(paramList);
      if (this.a.jdField_a_of_type_Int == 0)
      {
        if (paramList.size() <= 0) {
          break label264;
        }
        this.a.a(String.valueOf(((LikeRankingInfo)paramList.get(0)).uin));
      }
    }
    for (;;)
    {
      paramString = this.a;
      if (paramBoolean2) {
        paramInt = -1;
      }
      paramString.jdField_a_of_type_Int = paramInt;
      return;
      i = paramList.size();
      break;
      label249:
      this.a.e.setVisibility(8);
      break label165;
      label264:
      this.a.a(null);
      continue;
      label275:
      this.a.a(null);
      this.a.jdField_a_of_type_Swi.a = false;
      this.a.jdField_a_of_type_Swi.notifyDataSetChanged();
      if (this.a.jdField_a_of_type_Swi.getCount() <= 1) {
        this.a.e.setVisibility(0);
      }
    }
    label332:
    this.a.jdField_a_of_type_Swi.a = false;
    this.a.jdField_a_of_type_Swi.notifyDataSetChanged();
    QQToast.a(BaseApplication.getContext(), 1, "获取排行榜失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     swa
 * JD-Core Version:    0.7.0.1
 */