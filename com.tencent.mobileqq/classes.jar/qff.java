import android.content.Context;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.NetworkUtil;

public class qff
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private pvc jdField_a_of_type_Pvc;
  private int b;
  private int c;
  
  public qff(pvc parampvc, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Pvc = parampvc;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1112: 
    default: 
      return 0;
    case 1113: 
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    int k = this.jdField_a_of_type_Int;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pvc.a();
    int i;
    if (localArticleInfo != null)
    {
      if (!localArticleInfo.hasChannelInfo()) {
        break label148;
      }
      i = localArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(localArticleInfo.mArticleFriendLikeText)) {
        break label153;
      }
    }
    label148:
    label153:
    for (int j = 0;; j = 1)
    {
      String str = pay.d(localArticleInfo);
      odq.a(null, "CliOper", "", localArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(localArticleInfo.mFeedId), Long.toString(localArticleInfo.mArticleID), Integer.toString(localArticleInfo.mStrategyId), pay.a(localArticleInfo.mAlgorithmID, pay.a(localArticleInfo), k, i, j, NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext), str, localArticleInfo.mStrCircleId, localArticleInfo.innerUniqueID, pay.f(localArticleInfo), localArticleInfo), false);
      uhz.a(localArticleInfo, k);
      return;
      i = 0;
      break;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_Pvc == null) || (this.jdField_a_of_type_Pvc.a() == null) || (this.jdField_a_of_type_Pvc.a().mSmallMiniGameInfo == null)) {
      return;
    }
    String str = "";
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pvc.a();
    switch (this.c)
    {
    default: 
      paramViewBase = "";
    case 1115: 
    case 1112: 
    case 1113: 
    case 1114: 
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramViewBase)) && (!TextUtils.isEmpty(str)) && (!MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramViewBase, 2103, null)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("OnSmallGameCardClickListener", 0, "mini game url error jump by appid url = " + paramViewBase);
          }
          MiniAppLauncher.launchMiniAppById(this.jdField_a_of_type_AndroidContentContext, str, null, null, null, null, 2103);
        }
        a();
        return;
        obb.a(this.jdField_a_of_type_AndroidContentContext, localArticleInfo, this.jdField_a_of_type_Pvc.g(), this.b, obb.jdField_a_of_type_Int);
        paramViewBase = localArticleInfo.mSmallMiniGameInfo.b(this.b);
        str = localArticleInfo.mSmallMiniGameInfo.a(this.b);
        continue;
        int i = a(this.c);
        obb.a(this.jdField_a_of_type_AndroidContentContext, localArticleInfo, this.jdField_a_of_type_Pvc.g(), i, obb.jdField_a_of_type_Int);
        paramViewBase = localArticleInfo.mSmallMiniGameInfo.b(i);
        str = localArticleInfo.mSmallMiniGameInfo.a(i);
      }
    }
    nzz localnzz = new nzz().a(501L).b(50101L).c(5010105L).d(9L);
    if (localArticleInfo.mSmallMiniGameInfo.a()) {}
    for (paramViewBase = "3";; paramViewBase = "2")
    {
      paramViewBase = localnzz.h(paramViewBase).i(String.valueOf(this.b)).a();
      obb.a(this.jdField_a_of_type_AndroidContentContext, paramViewBase);
      pay.d(this.jdField_a_of_type_AndroidContentContext, localArticleInfo.mSmallMiniGameInfo.a);
      paramViewBase = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qff
 * JD-Core Version:    0.7.0.1
 */