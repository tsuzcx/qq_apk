import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DownloadStatusChangeEvent;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;
import java.io.IOException;

public final class nrh
  implements Runnable
{
  public nrh(StoryVideoItem paramStoryVideoItem, String paramString, int paramInt) {}
  
  public void run()
  {
    String str2 = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, true);
    File localFile = new File(str2);
    Object localObject1 = UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath, PlayModeUtils.a().getResources().getDisplayMetrics().widthPixels, PlayModeUtils.a().getResources().getDisplayMetrics().heightPixels);
    if ((!FileUtils.c(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath)) || (localObject1 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "storyVideoItem.mLocalVideoPath: " + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath + " or retriever.getFrameAtTime == null");
      }
      localObject1 = new PlayModeUtils.DownloadStatusChangeEvent(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject1);
      return;
    }
    Object localObject2 = FFmpegUtils.a(PlayModeUtils.a(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight, this.jdField_a_of_type_Int);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "download water mark failed");
    }
    Object localObject3 = FFmpegUtils.b(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    localObject1 = FFmpegUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    String str1 = FFmpegUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    while ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      str1 = QQStoryConstant.q;
      str1 = str1 + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid + System.currentTimeMillis() + "_max.png";
      if (!FFmpegUtils.a((String)localObject3, (String)localObject1, str1))
      {
        localObject1 = new PlayModeUtils.DownloadStatusChangeEvent(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject1);
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg maxMask videoVote failed");
        return;
        localObject1 = str1;
      }
      else
      {
        localObject1 = str1;
      }
    }
    while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject3 = localObject2;
      if (FFmpegUtils.a((String)localObject1, (String)localObject2, (String)localObject2)) {
        break label433;
      }
      localObject1 = new PlayModeUtils.DownloadStatusChangeEvent(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg failed");
      return;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = localObject3;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject3 = localObject1;
      label433:
      localObject1 = UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath, PlayModeUtils.a().getResources().getDisplayMetrics().widthPixels, PlayModeUtils.a().getResources().getDisplayMetrics().heightPixels);
      if (localObject1 != null) {
        break;
      }
      localObject1 = new PlayModeUtils.DownloadStatusChangeEvent(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "getLocalVideoThumbnail failed");
      return;
      localObject1 = localObject2;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = SafeBitmapFactory.decodeFile((String)localObject3);
      localObject2 = BitmapUtils.b((Bitmap)localObject1, (Bitmap)localObject3);
      ((Bitmap)localObject1).recycle();
      ((Bitmap)localObject3).recycle();
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        ImageUtil.a((Bitmap)localObject1, new File(str2));
        ((Bitmap)localObject1).recycle();
        FileUtils.b(PlayModeUtils.a(), localFile);
        localObject1 = new PlayModeUtils.DownloadStatusChangeEvent(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((PlayModeUtils.DownloadStatusChangeEvent)localObject1).b = str2;
        Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject1);
        return;
      }
      catch (IOException localIOException)
      {
        localObject2 = new PlayModeUtils.DownloadStatusChangeEvent(this.jdField_a_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject2);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "FFmpegUtils combineTwoImg IOException " + localIOException.getMessage());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrh
 * JD-Core Version:    0.7.0.1
 */