package com.tencent.qqconnect.wtlogin;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.LastModifySupportDownloader;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.QrAgentLoginManager;
import com.tencent.open.agent.entity.QQLiteBridgeParam;
import com.tencent.open.agent.util.OpenEnvConfig;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.widget.ActionSheet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQLiteStatusMgr
{
  public static Object a(QQLiteBridgeParam paramQQLiteBridgeParam)
  {
    int i = paramQQLiteBridgeParam.jdField_a_of_type_Int;
    boolean bool = true;
    switch (i)
    {
    default: 
      return null;
    case 13: 
      b(paramQQLiteBridgeParam);
      return null;
    case 12: 
      return ProfileCardUtils.enterSnapshot(paramQQLiteBridgeParam.jdField_a_of_type_AndroidAppActivity, 257);
    case 11: 
      c(paramQQLiteBridgeParam);
      return null;
    case 10: 
      a(paramQQLiteBridgeParam);
      return null;
    case 9: 
      return paramQQLiteBridgeParam.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    case 8: 
      return b(paramQQLiteBridgeParam);
    case 7: 
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      if ((!GesturePWDUtils.getJumpLock(paramQQLiteBridgeParam.jdField_a_of_type_AndroidContentContext, str)) || (GesturePWDUtils.getAppForground(paramQQLiteBridgeParam.jdField_a_of_type_AndroidContentContext))) {
        bool = false;
      }
      return Boolean.valueOf(bool);
    case 6: 
      QrAgentLoginManager.a().a(paramQQLiteBridgeParam.jdField_a_of_type_AndroidOsBundle, true);
      return null;
    case 5: 
      return Boolean.valueOf(ForwardUtils.b());
    case 4: 
      return Boolean.valueOf(OpenEnvConfig.a());
    case 3: 
      return URLDrawableDecodeHandler.a;
    case 2: 
      return LastModifySupportDownloader.getCacheFilePath(paramQQLiteBridgeParam.jdField_b_of_type_JavaLangString);
    }
    return new EmptyDrawable(0, paramQQLiteBridgeParam.c, 100);
  }
  
  private static void a(QQLiteBridgeParam paramQQLiteBridgeParam)
  {
    String[] arrayOfString = MobileQQ.sMobileQQ.getResources().getStringArray(2130968636);
    paramQQLiteBridgeParam = paramQQLiteBridgeParam.jdField_a_of_type_ComTencentWidgetActionSheet;
    paramQQLiteBridgeParam.addButton(arrayOfString[24]);
    paramQQLiteBridgeParam.addButton(arrayOfString[13]);
    paramQQLiteBridgeParam.addCancelButton(arrayOfString[16]);
  }
  
  private static Object b(QQLiteBridgeParam paramQQLiteBridgeParam)
  {
    paramQQLiteBridgeParam = new CompressInfo(paramQQLiteBridgeParam.jdField_a_of_type_JavaLangString, 0);
    paramQQLiteBridgeParam.f = 0;
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramQQLiteBridgeParam);
    SSOLog.a("QQLiteStatusMgr", new Object[] { "uploadAvatar compressInfo:", paramQQLiteBridgeParam });
    return paramQQLiteBridgeParam.e;
  }
  
  private static void b(QQLiteBridgeParam paramQQLiteBridgeParam)
  {
    if (paramQQLiteBridgeParam.jdField_b_of_type_Int != 257) {
      return;
    }
    String str = BaseImageUtil.b(paramQQLiteBridgeParam.jdField_a_of_type_AndroidAppActivity, paramQQLiteBridgeParam.jdField_a_of_type_AndroidNetUri);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEdit(paramQQLiteBridgeParam.jdField_a_of_type_AndroidAppActivity, str, 103);
  }
  
  private static void c(QQLiteBridgeParam paramQQLiteBridgeParam)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", 103);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", 103);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("fromWhereClick", "FROM_PHOTO_LIST");
    paramQQLiteBridgeParam = paramQQLiteBridgeParam.jdField_a_of_type_AndroidAppActivity;
    int i = ProfileCardUtil.b(paramQQLiteBridgeParam);
    PhotoUtils.startPhotoListEdit(localIntent, paramQQLiteBridgeParam, PublicFragmentActivityForOpenSDK.class.getName(), i, i, 1080, 1080, FaceUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.QQLiteStatusMgr
 * JD-Core Version:    0.7.0.1
 */