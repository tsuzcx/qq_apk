package dov.com.qq.im.capture.control;

import bojv;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UpdateAllFullMusicInfoTask
  extends ParallGroup
{
  private QIMMusicConfigManager jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = (QIMMusicConfigManager)bojv.a(2);
  private ArrayList<FlowMusic> jdField_a_of_type_JavaUtilArrayList;
  private List<FlowMusic> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ArrayList<FlowMusic> b = new ArrayList();
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a.query(FlowMusic.class);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList((Collection)localObject);
    }
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size(); this.jdField_a_of_type_JavaUtilArrayList != null; i = 0)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FlowMusic localFlowMusic = (FlowMusic)((Iterator)localObject).next();
        if (localFlowMusic.albumUrl == null) {
          this.jdField_a_of_type_JavaUtilList.add(localFlowMusic);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpdateAllFullMusicInfoTask", 2, "load db, has load local, size=" + i);
    }
  }
  
  private void b()
  {
    if (!this.b.isEmpty())
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a.getTransaction();
      try
      {
        localEntityTransaction.begin();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          FlowMusic localFlowMusic = (FlowMusic)localIterator.next();
          this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a.update(localFlowMusic);
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
      localEntityTransaction.end();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(4, true, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public int a()
  {
    this.d = this.jdField_a_of_type_JavaUtilList.size();
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (FlowMusic)localIterator.next();
          if (this.jdField_a_of_type_Int != 8) {}
        }
        else
        {
          return 2;
        }
        Object localObject = new GetSingleFullMusicInfoTask((FlowMusic)localObject, null);
        ((AsyncStep)localObject).a = this;
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b((AsyncStep)localObject);
      }
    }
    b();
    return 7;
  }
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    try
    {
      if ((paramAsyncStep instanceof GetSingleFullMusicInfoTask))
      {
        FlowMusic localFlowMusic = ((GetSingleFullMusicInfoTask)paramAsyncStep).a;
        if ((localFlowMusic != null) && (((GetSingleFullMusicInfoTask)paramAsyncStep).b != null))
        {
          localFlowMusic.albumUrl = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.albumUrl;
          localFlowMusic.url = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.url;
          localFlowMusic.size = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.size;
          localFlowMusic.playable = ((GetSingleFullMusicInfoTask)paramAsyncStep).b.playable;
          this.b.add(localFlowMusic);
        }
      }
      paramInt = this.d - 1;
      this.d = paramInt;
      if (paramInt == 0)
      {
        b();
        a(7);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep);
      return;
    }
    finally {}
  }
  
  public void c()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.UpdateAllFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */