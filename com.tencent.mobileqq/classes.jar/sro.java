import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.qqstory.album.view.AlbumImageView;
import java.util.List;

class sro
  extends Handler
{
  public sro(srk paramsrk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      ved.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop");
    } while ((srk.a(this.a) != 1) || (srk.a(this.a) == null));
    Object localObject = srk.a(this.a);
    int i = srk.a(this.a, (List)localObject, srk.c(this.a));
    int j = srk.a(this.a, (List)localObject, i + 1);
    if ((((List)localObject).size() <= 1) || (i == j) || (i < 0))
    {
      srk.b(this.a);
      ved.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, pick count not enougth , dont play loop");
      return;
    }
    srk.a(this.a, j);
    paramMessage = (spz)((List)localObject).get(i);
    localObject = (spz)((List)localObject).get(j);
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setVisibility(0);
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(paramMessage.a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, srk.a(this.a));
    this.a.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.setLocalDrawable(((spz)localObject).a, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, srk.a(this.a));
    paramMessage = AnimationUtils.loadAnimation(srk.a(this.a), 2130772219);
    paramMessage.setAnimationListener(new srp(this));
    this.a.jdField_b_of_type_ComTencentBizQqstoryAlbumViewAlbumImageView.startAnimation(paramMessage);
    ved.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, start play loop , ani index = %d , rear index = %d", Integer.valueOf(i), Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sro
 * JD-Core Version:    0.7.0.1
 */