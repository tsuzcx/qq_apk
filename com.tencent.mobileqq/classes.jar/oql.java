import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class oql
{
  private static volatile oql a;
  
  public static Object a(GdtAd paramGdtAd)
  {
    if ((paramGdtAd == null) || (paramGdtAd.getGdtAdLoader() == null) || (paramGdtAd.getGdtAdLoader().a() == null)) {
      return null;
    }
    if ((paramGdtAd.getGdtAdLoader().a().a.pos_ads_info == null) || (paramGdtAd.getGdtAdLoader().a().a.pos_ads_info.get(0) == null)) {
      return null;
    }
    if ((((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAd.getGdtAdLoader().a().a.pos_ads_info.get(0)).ads_info == null) || (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAd.getGdtAdLoader().a().a.pos_ads_info.get(0)).ads_info.get(0) == null)) {
      return null;
    }
    return acqx.a((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAd.getGdtAdLoader().a().a.pos_ads_info.get(0)).ads_info.get(0));
  }
  
  public static oql a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new oql();
      }
      return a;
    }
    finally {}
  }
  
  public GdtHandler.Params a(boolean paramBoolean, Activity paramActivity)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.c = 1;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localParams.jdField_a_of_type_Boolean = paramBoolean;
    return localParams;
  }
  
  public qq_ad_get.QQAdGet a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    Object localObject1 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_rate.set(paramInt2);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_check.set(ackg.a(paramLong2, paramLong3, paramInt2));
    Object localObject2 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).share_info.set((MessageMicro)localObject1);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).deep_link_version.set(1);
    localObject1 = new qq_ad_get.QQAdGet.PositionInfo();
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_id.set(paramString);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).ad_count.set(1);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_ext.set((MessageMicro)localObject2);
    paramString = new qq_ad_get.QQAdGet.ContextInfo();
    paramString.public_id.set(paramLong2);
    paramString.article_id.set(paramLong3);
    paramString.source_from.set(paramInt1);
    localObject2 = new qq_ad_get.QQAdGet.UserInfo();
    ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(paramLong1);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localQQAdGet.position_info.add((MessageMicro)localObject1);
    localQQAdGet.context_info.set(paramString);
    localQQAdGet.user_info.set((MessageMicro)localObject2);
    return localQQAdGet;
  }
  
  public void a(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = (qq_ad_get.QQAdGetRsp.AdInfo)acqx.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramString1));
      GdtMotiveVideoPageData localGdtMotiveVideoPageData = acqv.a(paramString1, acqv.a(paramInt1));
      if (localGdtMotiveVideoPageData != null)
      {
        String str = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
        paramString1 = str;
        if (TextUtils.isEmpty(str)) {
          paramString1 = paramActivity.getIntent().getStringExtra("big_brother_source_key");
        }
        localGdtMotiveVideoPageData.refId = paramString1;
        if (paramInt2 > 0) {
          localGdtMotiveVideoPageData.setVideoCountDown(paramInt2);
        }
        if (!TextUtils.isEmpty(paramString3)) {
          localGdtMotiveVideoPageData.setRewardText(paramString3);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MotiveAdUtils", 2, "showMotiveAd : orientation = " + paramInt1 + "rewardTime + = " + paramInt2 + "refId = " + paramString1 + "rewardText=" + paramString3);
        }
        GdtMotiveVideoFragment.a(paramActivity, GdtMotiveVideoFragment.class, localGdtMotiveVideoPageData, paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("MotiveAdUtils", 1, "showMotiveAd e", paramString1);
        paramString1 = null;
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, acko paramacko)
  {
    try
    {
      Object localObject = new acof();
      ((acof)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(Long.parseLong(ampj.a().getCurrentAccountUin()), paramString, paramLong1, paramLong2, paramInt1, paramInt2);
      ((acof)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(true, paramActivity);
      localObject = new GdtMotiveVideoAd((acof)localObject);
      ((GdtMotiveVideoAd)localObject).setListener(new WeakReference(paramacko));
      ((GdtMotiveVideoAd)localObject).load(paramActivity);
      if (QLog.isColorLevel()) {
        QLog.d("MotiveAdUtils", 2, "getMotiveAd : posId = " + paramString + "publicId = " + paramLong1 + "articleId = " + paramLong2 + "sourceFrom = " + paramInt1 + "shareRate = " + paramInt2);
      }
      return;
    }
    catch (Throwable paramActivity)
    {
      for (;;)
      {
        QLog.e("MotiveAdUtils", 1, paramActivity, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oql
 * JD-Core Version:    0.7.0.1
 */