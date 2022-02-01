package dov.com.qq.im.ae.biz.qcircle;

import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class AECircleAlbumListFragment$2
  implements MessageQueue.IdleHandler
{
  AECircleAlbumListFragment$2(AECircleAlbumListFragment paramAECircleAlbumListFragment, int paramInt1, int paramInt2) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "load Scroll Position,index:" + this.jdField_a_of_type_Int + " top:" + this.b);
    }
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECircleAlbumListFragment.a.setSelectionFromTop(this.jdField_a_of_type_Int, this.b);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECircleAlbumListFragment.2
 * JD-Core Version:    0.7.0.1
 */