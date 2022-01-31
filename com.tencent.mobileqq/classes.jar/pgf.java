import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.MX3DynamicAvatarRecordActivity;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

public class pgf
  implements ActionSheet.OnButtonClickListener
{
  public pgf(NewerGuidePlugin paramNewerGuidePlugin, Activity paramActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView) {}
      paramView = DynamicAvatarRecordActivity.class;
      if (CameraCompatibleList.d(CameraCompatibleList.c)) {
        paramView = MX3DynamicAvatarRecordActivity.class;
      }
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, paramView);
      paramView.putExtra("param_source", 1);
      paramView.putExtra("param_from_newer_guide", true);
      this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.startActivityForResult(paramView, (byte)100);
      continue;
      paramView = ProfileCardUtil.a();
      paramInt = ProfileCardUtil.b(this.jdField_a_of_type_AndroidAppActivity);
      Intent localIntent = new Intent();
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, PhotoListActivity.class);
      localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
      localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      localIntent.putExtra("Business_Origin", 100);
      localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      localIntent.putExtra("PhotoConst.TARGET_PATH", paramView);
      localIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt);
      localIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt);
      localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
      localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      localIntent.putExtra("PhotoConst.32_Bit_Config", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      continue;
      if (!QavCameraUsage.b(BaseApplicationImpl.getContext()))
      {
        paramView = new File(AppConstants.aK + "photo/");
        if (!paramView.exists()) {
          paramView.mkdirs();
        }
        paramView = new File(AppConstants.aK + "photo/" + System.currentTimeMillis() + ".jpg");
        NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, Uri.fromFile(paramView));
        paramView = new Intent("android.media.action.IMAGE_CAPTURE");
        paramView.putExtra("output", NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin));
        paramView.putExtra("android.intent.extra.videoQuality", 100);
        this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.startActivityForResult(paramView, (byte)101);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgf
 * JD-Core Version:    0.7.0.1
 */