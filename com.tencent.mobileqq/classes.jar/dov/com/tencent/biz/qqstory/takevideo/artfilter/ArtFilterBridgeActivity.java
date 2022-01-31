package dov.com.tencent.biz.qqstory.takevideo.artfilter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import angq;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoDownload;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;

public class ArtFilterBridgeActivity
  extends BaseActivity
  implements VideoEnvironment.ShortVideoDownload
{
  int a = 0;
  volatile int b = 200;
  
  private void b() {}
  
  private void c()
  {
    QLog.d("ArtFilterBridgeActivity", 1, "doStartEditPic");
    Intent localIntent = new Intent(getIntent());
    int i = localIntent.getIntExtra("TEMP_PARAM", 0);
    if ((0 == 0) || (getIntent().getIntExtra("camera_type", -1) != -1)) {}
    for (boolean bool = true;; bool = false)
    {
      int j = localIntent.getIntExtra("EDIT_BUSI", 2);
      int k = localIntent.getIntExtra("sub_business_id", 0);
      int m = localIntent.getIntExtra("entrance_type", 99);
      String str = localIntent.getStringExtra("PATH");
      Object localObject1 = EditVideoParams.a(k);
      if (localObject1 == null) {
        localObject1 = new Bundle();
      }
      label391:
      for (;;)
      {
        ((Bundle)localObject1).putAll(getIntent().getExtras());
        ((Bundle)localObject1).putString("mCurrentTemplatePath", localIntent.getStringExtra("mCurrentTemplatePath"));
        ((Bundle)localObject1).putInt("entrance_type", m);
        ((Bundle)localObject1).putInt("pic_entrance_type", localIntent.getIntExtra("pic_entrance_type", 0));
        if (localIntent.hasExtra("extra_publish_text")) {
          ((Bundle)localObject1).putString("extra_publish_text", localIntent.getStringExtra("extra_publish_text"));
        }
        if (localIntent.hasExtra("extra_enable_flash_pic")) {
          ((Bundle)localObject1).putBoolean("extra_enable_flash_pic", localIntent.getBooleanExtra("extra_enable_flash_pic", false));
        }
        ((Bundle)localObject1).putParcelable("edit_send_session_info", localIntent.getParcelableExtra("edit_send_session_info"));
        try
        {
          localObject3 = (LocalMediaInfo)localIntent.getParcelableExtra("media_info");
          if (localObject3 != null) {
            break label391;
          }
          localObject3 = new LocalMediaInfo();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            Object localObject3;
            localIllegalArgumentException.printStackTrace();
            QLog.d("ArtFilterBridgeActivity", 2, " Can not find file by sourcePath: busiType=" + j + " isTakePhoto:" + bool + " subBusinessId:" + k);
            Object localObject2 = null;
          }
        }
        if (bool) {}
        for (localObject3 = new EditTakePhotoSource(str, 2, 0, 0);; localObject3 = new EditLocalPhotoSource(str, (LocalMediaInfo)localObject3))
        {
          localObject1 = new EditVideoParams(j, i, (EditVideoParams.EditSource)localObject3, (Bundle)localObject1);
          if (localObject1 != null) {
            localIntent.putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
          }
          localIntent.setClass(this, EditPicActivity.class);
          startActivityForResult(localIntent, 88);
          return;
        }
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterBridgeActivity", 2, "VideoSoDownloadProgress mVideoState=" + paramInt);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    c();
    ThreadManager.post(new angq(this), 8, null, true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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