package dov.com.tencent.biz.qqstory.takevideo.artfilter;

import ajjy;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import java.util.HashMap;

public class ArtFilterBridgeActivity
  extends BaseActivity
{
  int a = 0;
  volatile int b = 200;
  
  private void a()
  {
    QLog.d("ArtFilterBridgeActivity", 1, "doStartEditPic");
    Intent localIntent = new Intent(getIntent());
    long l = localIntent.getLongExtra("TEMP_PARAM", 0L);
    if (getIntent().getIntExtra("camera_type", -1) != -1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      int i = localIntent.getIntExtra("EDIT_BUSI", 2);
      int j = localIntent.getIntExtra("sub_business_id", 0);
      int k = localIntent.getIntExtra("entrance_type", 99);
      int m = localIntent.getIntExtra("camera_mode", 0);
      String str = localIntent.getStringExtra("PATH");
      Bundle localBundle = EditVideoParams.a(j);
      if (localBundle == null) {
        localBundle = new Bundle();
      }
      label620:
      for (;;)
      {
        localBundle.putAll(getIntent().getExtras());
        localBundle.putString("mCurrentTemplatePath", localIntent.getStringExtra("mCurrentTemplatePath"));
        localBundle.putInt("entrance_type", k);
        localBundle.putInt("pic_entrance_type", localIntent.getIntExtra("pic_entrance_type", 0));
        boolean bool2 = localIntent.getBooleanExtra("go_publish_activity", false);
        if (bool2) {
          localBundle.putString("extra_publish_text", ajjy.a(2131634959));
        }
        if (localIntent.hasExtra("troop_uin")) {
          localBundle.putString("troop_uin", localIntent.getStringExtra("troop_uin"));
        }
        if (localIntent.hasExtra("extra_enable_flash_pic")) {
          localBundle.putBoolean("extra_enable_flash_pic", localIntent.getBooleanExtra("extra_enable_flash_pic", false));
        }
        if (localIntent.hasExtra("key_enable_edit_title_bar")) {
          localBundle.putBoolean("key_enable_edit_title_bar", localIntent.getBooleanExtra("key_enable_edit_title_bar", false));
        }
        if (localIntent.hasExtra("key_multi_edit_pic")) {
          localBundle.putBoolean("key_multi_edit_pic", localIntent.getBooleanExtra("key_multi_edit_pic", false));
        }
        localBundle.putParcelable("edit_send_session_info", localIntent.getParcelableExtra("edit_send_session_info"));
        localBundle.putString("extra_text_filter_text", localIntent.getStringExtra("extra_text_filter_text"));
        double d1 = getIntent().getDoubleExtra("key_latitude", 4.9E-324D);
        double d2 = getIntent().getDoubleExtra("key_longtitude", 4.9E-324D);
        try
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localIntent.getParcelableExtra("media_info");
          localObject1 = localLocalMediaInfo;
          if (localLocalMediaInfo == null)
          {
            HashMap localHashMap = (HashMap)localIntent.getSerializableExtra("user_params");
            localObject1 = localLocalMediaInfo;
            if (localHashMap != null) {
              localObject1 = (LocalMediaInfo)localHashMap.get("param_localmediainfo");
            }
          }
          if (localObject1 != null) {
            break label620;
          }
          localObject1 = new LocalMediaInfo();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            Object localObject1;
            QLog.d("ArtFilterBridgeActivity", 2, " Can not find file by sourcePath: busiType=" + i + " isTakePhoto:" + bool1 + " subBusinessId:" + j, localIllegalArgumentException);
            Object localObject2 = null;
          }
        }
        if (bool1) {}
        for (localObject1 = new EditTakePhotoSource(str, 2, 0, 0, d2, d1);; localObject1 = new EditLocalPhotoSource(str, (LocalMediaInfo)localObject1))
        {
          localObject1 = new EditVideoParams(i, l, (EditVideoParams.EditSource)localObject1, localBundle);
          if (localObject1 != null)
          {
            ((EditVideoParams)localObject1).b = m;
            ((EditVideoParams)localObject1).e = localBundle.getInt("extra_edit_video_from");
            localIntent.putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
          }
          if (!bool2) {
            localIntent.setClass(this, EditPicActivity.class);
          }
          if (i == 3) {
            localIntent.setClass(this, QzoneEditPictureActivity.class);
          }
          localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", getIntent().getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
          startActivityForResult(localIntent, 88);
          return;
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    ThreadManager.excute(new ArtFilterBridgeActivity.1(this), 64, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("mark_from_artfilter_bridge_activity", true);
    super.setResult(paramInt2, localIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterBridgeActivity
 * JD-Core Version:    0.7.0.1
 */