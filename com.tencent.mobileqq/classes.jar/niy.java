import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode.GenShareThumbEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;
import java.io.IOException;

public class niy
  implements Runnable
{
  public niy(NewFriendsPlayMode paramNewFriendsPlayMode, long paramLong, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    SLog.d("Q.qqstory.player.NewFriendsPlayMode", "generateShareThumb run start: %d.", new Object[] { Long.valueOf(l - this.jdField_a_of_type_Long) });
    Object localObject2;
    Object localObject4;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoLocalThumbnailPath))
    {
      SLog.b("Q.qqstory.player.NewFriendsPlayMode", "video thumbnail has existed.");
      localObject1 = SafeBitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoLocalThumbnailPath);
      SLog.d("Q.qqstory.player.NewFriendsPlayMode", "generate share thumbnail step first cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      l = System.currentTimeMillis();
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath)) {
        localObject2 = FFmpegUtils.a((Bitmap)localObject1, SafeBitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath));
      }
      SLog.d("Q.qqstory.player.NewFriendsPlayMode", "generate share thumbnail step second cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      l = System.currentTimeMillis();
      localObject4 = FFmpegUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight);
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = FFmpegUtils.a((Bitmap)localObject2, (Bitmap)localObject4);
      }
      SLog.d("Q.qqstory.player.NewFriendsPlayMode", "generate share thumbnail step third cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      l = System.currentTimeMillis();
      localObject4 = FFmpegUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight);
      localObject2 = localObject1;
      if (localObject4 != null) {
        localObject2 = FFmpegUtils.a((Bitmap)localObject1, (Bitmap)localObject4);
      }
      SLog.d("Q.qqstory.player.NewFriendsPlayMode", "generate share thumbnail step forth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      l = System.currentTimeMillis();
      localObject4 = FFmpegUtils.a(VideoPlayModeBase.a(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mStoryType);
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = FFmpegUtils.a((Bitmap)localObject2, (Bitmap)localObject4);
      }
      SLog.d("Q.qqstory.player.NewFriendsPlayMode", "generate share thumbnail step fifth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      l = System.currentTimeMillis();
      localObject2 = PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, true);
      localObject4 = new File((String)localObject2);
    }
    for (;;)
    {
      try
      {
        ImageUtil.a((Bitmap)localObject1, (File)localObject4);
        ((Bitmap)localObject1).recycle();
      }
      catch (IOException localIOException1)
      {
        localObject1 = null;
      }
      try
      {
        SLog.a("Q.qqstory.player.NewFriendsPlayMode", "generate thumbnail success. shareThumbPath = %s.", localObject2);
        localObject1 = localObject2;
        SLog.d("Q.qqstory.player.NewFriendsPlayMode", "generate share thumbnail step sixth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        localObject2 = new NewFriendsPlayMode.GenShareThumbEvent(new ErrorMessage());
        ((NewFriendsPlayMode.GenShareThumbEvent)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        ((NewFriendsPlayMode.GenShareThumbEvent)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject2);
        return;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localObject1 = localObject3;
          Object localObject3 = localIOException2;
        }
      }
      localObject1 = UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalVideoPath, VideoPlayModeBase.a().getResources().getDisplayMetrics().widthPixels, VideoPlayModeBase.a().getResources().getDisplayMetrics().heightPixels);
      break;
      SLog.c("Q.qqstory.player.NewFriendsPlayMode", "generate thumbnail failed. e = %s.", localIOException1);
      localObject3 = new NewFriendsPlayMode.GenShareThumbEvent(new ErrorMessage(-1, "generate thumbnail failed." + localIOException1.getMessage()));
      Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     niy
 * JD-Core Version:    0.7.0.1
 */