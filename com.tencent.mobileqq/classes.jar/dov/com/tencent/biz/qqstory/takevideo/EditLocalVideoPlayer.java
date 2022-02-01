package dov.com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.OnPlayRecycleListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPFrameListener;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import java.util.Arrays;

@TargetApi(14)
public class EditLocalVideoPlayer
  extends EditVideoPart
  implements TrimTextureVideoView.OnPlayRecycleListener, IMediaPlayer.OnPreparedListener, EditVideoPlayerExport, ImageViewVideoPlayer.IMPFrameListener, ImageViewVideoPlayer.IMPlayerEndListener
{
  protected int a;
  protected ImageView a;
  protected TextView a;
  protected TrimTextureVideoView a;
  protected MediaCodecThumbnailGenerator a;
  protected String a;
  protected boolean a;
  protected EditLocalVideoPlayer.PlayerContext[] a;
  protected int b;
  protected boolean b;
  
  public Bitmap a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    EditLocalVideoPlayer.PlayerContext localPlayerContext = this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[paramInt];
    if (localPlayerContext.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
      SLog.e("Q.qqstory.record.EditLocalVideoPlayer", "自己的bitmap被外边recycle了!");
    }
    return localPlayerContext.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    super.a();
    if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.d()) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.b())) {
      return;
    }
    Object localObject = (EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int k = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    int m = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    int n = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.d();
    this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext = new EditLocalVideoPlayer.PlayerContext[n];
    SLog.a("Q.qqstory.record.EditLocalVideoPlayer", "onCreate EditSource fragmentCount is %d", Integer.valueOf(n));
    int j = k;
    int i = 0;
    while (i < n)
    {
      this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i] = new EditLocalVideoPlayer.PlayerContext(i, null);
      EditLocalVideoPlayer.PlayerContext localPlayerContext = this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i];
      localPlayerContext.jdField_a_of_type_Int = j;
      localPlayerContext.jdField_b_of_type_Int = Math.min(j + 10000, m);
      if (i == n - 1) {
        localPlayerContext.jdField_b_of_type_Int = m;
      }
      j += 10000;
      i += 1;
    }
    this.jdField_a_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)a(2131367203));
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365359));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376483));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QQStoryFlowCallback.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
      localObject = QQStoryFlowCallback.jdField_a_of_type_AndroidGraphicsBitmap;
      if (!bool) {
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      SLog.b("Q.qqstory.record.EditLocalVideoPlayer", "onCreate mBackgroundImage.setImageBitmap()");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnRecyclePlayListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(this);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.jdField_a_of_type_JavaLangString);
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("extra_upload_temp_directory");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator = new MediaCodecThumbnailGenerator();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator.a(null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator.a(this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_b_of_type_Boolean, 480, k, 10000, n, false, new EditLocalVideoPlayer.1(this), new EditLocalVideoPlayer.2(this));
    a(EditVideoPlayerExport.class, this);
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, float paramFloat) {}
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      SLog.b("Q.qqstory.record.EditLocalVideoPlayer", "editVideoPrePublish(%d) -> %s", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[paramInt] + ",mNeedRotate=" + this.jdField_b_of_type_Boolean);
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = this.jdField_b_of_type_Boolean;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[paramInt].jdField_a_of_type_Int;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[paramInt].jdField_b_of_type_Int;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    switch (paramInt)
    {
    }
    b(false);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte) {}
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(TransferData paramTransferData) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()].jdField_a_of_type_Boolean = paramBoolean;
    b(false);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      default: 
        return true;
      case 1: 
        b(false);
        return true;
      case 2: 
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
        return true;
      }
      b(true);
      return true;
    }
    return false;
  }
  
  public void aK_()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
  }
  
  public void aM_()
  {
    super.aM_();
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
  }
  
  public void a_(IMediaPlayer paramIMediaPlayer)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new EditLocalVideoPlayer.3(this), 300L);
    }
    SLog.a("Q.qqstory.record.EditLocalVideoPlayer", "onPrepared %s", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  public void b()
  {
    EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
    if (localEditMusicExport != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayRecycle()");
      }
      localEditMusicExport.b();
    }
  }
  
  public void b(int paramInt) {}
  
  protected void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    if ((this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext == null) || (i >= this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext.length) || (this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i].jdField_b_of_type_Boolean))
    {
      SLog.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! resumePlay(%b): PlayerContext is illegal %s index=%d", new Object[] { Boolean.valueOf(paramBoolean), Arrays.toString(this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext), Integer.valueOf(i) });
      return;
    }
    EditLocalVideoPlayer.PlayerContext localPlayerContext = this.jdField_a_of_type_ArrayOfDovComTencentBizQqstoryTakevideoEditLocalVideoPlayer$PlayerContext[i];
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setPlayRange(localPlayerContext.jdField_a_of_type_Int, localPlayerContext.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b(localPlayerContext.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b(localPlayerContext.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(false);
  }
  
  public void c() {}
  
  public void d() {}
  
  public void f()
  {
    super.f();
    b(false);
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator.a();
  }
  
  public void i() {}
  
  public void j()
  {
    super.j();
  }
  
  public void k()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 8));
  }
  
  public void m()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoPlayer
 * JD-Core Version:    0.7.0.1
 */