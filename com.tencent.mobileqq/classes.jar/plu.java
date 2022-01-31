import android.os.Bundle;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListRsp;
import tencent.im.oidb.oidb_0xc2f.RspBody;

public class plu
  extends mxg
{
  plu(plm paramplm) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "requestRecommendList onResult, errorCode = " + paramInt);
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new oidb_0xc2f.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        plm.a(this.a).mRecommendFollowInfos = qbx.a((oidb_0xc2f.GetFollowUserRecommendListRsp)paramBundle.msg_get_follow_user_recommend_list_rsp.get());
        if ((plm.a(this.a).mRecommendFollowInfos.a != null) && (plm.a(this.a).mRecommendFollowInfos.a.size() >= 3))
        {
          plm.a(this.a).a(plm.a(this.a).mRecommendFollowInfos.a);
          plm.a(this.a).isShowRecommendList = true;
          plm.a(this.a);
          plm.a(this.a).post(new ReadInJoySocializeRecommendFollowView.9.1(this));
          return;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoySocializeRecommendFollowView", 2, "requestRecommendList onResult, size < 3");
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ReadInJoySocializeRecommendFollowView", 1, "requestRecommendList onResult(), exception = " + paramArrayOfByte.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plu
 * JD-Core Version:    0.7.0.1
 */