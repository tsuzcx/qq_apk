package dov.com.tencent.biz.qqstory.takevideo;

import anbs;
import anbt;
import anbu;
import anbv;
import anbw;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.music.humrecognition.BubbleTextView;
import dov.com.qq.im.capture.music.humrecognition.HumObserver;
import dov.com.qq.im.capture.music.humrecognition.HumUtils;
import dov.com.qq.im.capture.music.humrecognition.humming.OriginalBgmRecognizer;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;
import java.io.File;

public class EditRecognitionPart
  extends EditVideoPart
  implements Handler.Callback, HumObserver
{
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new anbu(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private MusicDownloadListener jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = new anbt(this);
  private QimMusicPlayer jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
  private BubbleTextView jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView;
  private OriginalBgmRecognizer jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHummingOriginalBgmRecognizer;
  private RecognitionManager jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager = (RecognitionManager)QIMManager.a().c(10);
  public boolean a;
  private WeakReferenceHandler jdField_b_of_type_ComTencentUtilWeakReferenceHandler;
  private boolean jdField_b_of_type_Boolean;
  
  public EditRecognitionPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.d == 7)) {
      return;
    }
    ((QIMMusicConfigManager)QIMManager.a().c(2)).a(paramMusicItemInfo, true);
  }
  
  private void j()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 1, 0));
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "popupRecognitionBubble: invoked. info: mHumMusicItemInfo = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    Object localObject = "点击替换成高品质音乐：" + System.getProperty("line.separator") + HumUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.a();
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.measure(0, 0);
    int i = this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.getMeasuredWidth() / 2;
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131364435);
    ((RelativeLayout.LayoutParams)localObject).setMargins(372 - i, 0, 0, 4);
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView, (ViewGroup.LayoutParams)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EditRecognitionPart", 2, "popupRecognitionBubble: Failed. info: exception = ", localThrowable);
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "removeRecognitionBubble: invoked.");
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EditRecognitionPart", 2, "removeRecognitionBubble: Failed. info: exception = ", localThrowable);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo))
    {
      j();
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setVisibility(8);
      l();
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager.b(this);
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_a_of_type_Boolean)
      {
        String str = "无法下载音乐。" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_a_of_type_JavaLangString + " 无版权";
        QQToast.a(a(), 0, str, 0).a();
        if (QLog.isColorLevel()) {
          QLog.d("EditRecognitionPart", 2, "url:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.c + " playable:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_a_of_type_Boolean);
        }
      }
      else
      {
        this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener);
      }
    }
  }
  
  public float a()
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a();
    float f1;
    if (localLocalMediaInfo == null) {
      f1 = 0.0F;
    }
    float f2;
    do
    {
      return f1;
      f2 = (float)Math.floor(localLocalMediaInfo.mDuration);
      f1 = f2;
    } while (!QLog.isColorLevel());
    QLog.i("EditRecognitionPart", 2, "getAudioDuration: invoked. info: duration = " + f2);
    return f2;
  }
  
  public File a()
  {
    String str = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a();
    if (!TextUtils.isEmpty(str)) {
      return new File(str);
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onCreate: ");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131363390));
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView = new BubbleTextView(a());
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setPadding(UIUtils.a(a(), 10.0F), UIUtils.a(a(), 10.0F), UIUtils.a(a(), 10.0F), UIUtils.a(a(), 10.0F));
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager.a(this);
    if (this.jdField_a_of_type_Boolean)
    {
      ToastUtil.a().a("开始识别当前视频的背景音");
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(110);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onActivityResult: invoked. info: requestCode = " + paramInt1 + " resultCode = " + paramInt2 + "data = " + paramIntent);
    }
    if ((paramInt1 == 131) && (paramInt2 == -1) && (paramIntent != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.c();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    l();
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramMusicItemInfo;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
    if (paramMusicItemInfo != null) {
      this.jdField_b_of_type_Boolean = true;
    }
    ToastUtil.a().a("识别结束。结果：" + paramMusicItemInfo);
  }
  
  public void aC_()
  {
    super.aC_();
  }
  
  public void aD_()
  {
    super.aD_();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onPause: ");
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.d();
  }
  
  public void av_()
  {
    super.av_();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onStop: mIsFinishRecognition = " + this.jdField_b_of_type_Boolean);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void c()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a((Activity)a(), 2131439180);
    localQQCustomDialog.setNegativeButton(2131432998, new anbv(this));
    localQQCustomDialog.setPositiveButton(2131432999, new anbw(this));
    localQQCustomDialog.show();
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "onDestroy: ");
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionRecognizeRecognitionManager.b(this);
    if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return false;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((MusicItemInfo)paramMessage.obj);
        if (QLog.isColorLevel()) {
          QLog.i("EditRecognitionPart", 2, "handleMessage: invoked. info: no match. mHumMusicItemInfo = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.d == 7));
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionBubbleTextView.setOnClickListener(new anbs(this));
      k();
      this.jdField_b_of_type_Boolean = true;
      return false;
    }
    j();
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoButton.c();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditRecognitionPart
 * JD-Core Version:    0.7.0.1
 */