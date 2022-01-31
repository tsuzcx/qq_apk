package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import andx;
import andy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class EditVideoMultiSegment
  extends EditVideoPart
  implements IEventReceiver, EditMultiSegmentExport
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long d;
  
  public EditVideoMultiSegment(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private long a(long paramLong)
  {
    int k = 0;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return paramLong;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue() > paramLong) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break label102;
        }
        if (i != 0) {
          break;
        }
        return 0L;
      }
      i += 1;
    }
    return ((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue();
    label102:
    return ((Long)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
  }
  
  private void b(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "seekPlayer, pos:" + paramLong);
    }
    boolean bool2;
    long l2;
    long l1;
    boolean bool1;
    Object localObject;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new andy(this), 3000L);
      bool2 = false;
      l2 = 0L;
      l1 = l2;
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        l1 = l2;
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilList.size() != 0)
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label261;
          }
          bool1 = bool2;
          l1 = l2;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "seekplayer, pos: " + paramLong + " keyPos:" + l1 + " curseek:" + this.jdField_b_of_type_Long + " useIFrame:" + this.jdField_b_of_type_Boolean + "  bNext:" + bool1);
      }
      localObject = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localObject != null)
      {
        if (!bool1) {
          break label330;
        }
        ((EditVideoPlayerExport)localObject).b(paramLong, paramBoolean);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = paramLong;
      this.jdField_a_of_type_Boolean = true;
      localObject = (EditMusicExport)a(EditMusicExport.class);
      if (localObject != null) {
        ((EditMusicExport)localObject).a(paramLong);
      }
      return;
      label261:
      l1 = l2;
      bool1 = bool2;
      if (paramLong < this.jdField_b_of_type_Long) {
        break;
      }
      l2 = a(paramLong);
      l1 = l2;
      bool1 = bool2;
      if (l2 >= this.jdField_b_of_type_Long) {
        break;
      }
      l1 = l2;
      bool1 = bool2;
      if (this.jdField_b_of_type_Long > paramLong) {
        break;
      }
      bool1 = true;
      l1 = l2;
      break;
      label330:
      ((EditVideoPlayerExport)localObject).a(paramLong, paramBoolean);
    }
  }
  
  private void j()
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("keyFrames{");
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      localStringBuilder.append('}');
    }
    for (;;)
    {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, localStringBuilder.toString());
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((Long)localIterator.next());
        localStringBuilder.append(",");
      }
      localStringBuilder.append('}');
    }
  }
  
  public int a()
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      return localEditVideoPlayerExport.a();
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "onCreate");
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    a(EditMultiSegmentExport.class, this);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditLocalVideoSource))
    {
      long l = ((EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a).a * -1;
      SegmentKeeper.b(l);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "local video, adjusttime::" + l);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "seek, current state is seeking, pos:" + paramLong);
      }
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(paramLong, paramBoolean);
      return;
    }
    ThreadManager.getUIHandler().post(new andx(this, paramLong, paramBoolean));
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    j();
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.a(paramMessage);
    case 13: 
      this.d = ((Long)paramMessage.obj).longValue();
      this.jdField_a_of_type_Boolean = false;
      return true;
    }
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public void ay_()
  {
    Object localObject = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (localObject != null) {
      ((EditVideoPlayerExport)localObject).l();
    }
    localObject = (EditMusicExport)a(EditMusicExport.class);
    if (localObject != null) {
      ((EditMusicExport)localObject).c();
    }
  }
  
  public void c()
  {
    Object localObject = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    if (localObject != null) {
      ((EditVideoPlayerExport)localObject).m();
    }
    localObject = (EditMusicExport)a(EditMusicExport.class);
    if (localObject != null) {
      ((EditMusicExport)localObject).ar_();
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean) {}
    EditVideoPlayerExport localEditVideoPlayerExport;
    do
    {
      return;
      localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    } while (localEditVideoPlayerExport == null);
    this.jdField_b_of_type_Boolean = localEditVideoPlayerExport.a(this.d);
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "onDestroy");
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoMultiSegment
 * JD-Core Version:    0.7.0.1
 */