package dov.com.qq.im.aeeditor.module.edit.multi.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.weseevideo.camera.mvauto.redo.ResourceModel;

public class MvVideoViewModel
  extends ViewModel
{
  public MutableLiveData<ResourceModel> a;
  private MoviePlayer a;
  private MutableLiveData<Long> b = new MutableLiveData();
  
  public MvVideoViewModel()
  {
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  public void a(long paramLong)
  {
    this.b.postValue(Long.valueOf(paramLong));
  }
  
  public void a(CMTime paramCMTime)
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.seekToTime(paramCMTime);
    }
  }
  
  public void a(MoviePlayer paramMoviePlayer)
  {
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = paramMoviePlayer;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
      return this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel
 * JD-Core Version:    0.7.0.1
 */