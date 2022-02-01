import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lqi
  extends lqm
{
  private final String jdField_a_of_type_JavaLangString = "MultipleTextureSource-" + Integer.toHexString(hashCode());
  private List<Frame> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  protected void a() {}
  
  public void a(List<lqj> paramList, long paramLong)
  {
    ArrayList localArrayList1 = new ArrayList(paramList.size());
    int i = 0;
    if (i < paramList.size())
    {
      lqj locallqj = (lqj)paramList.get(i);
      label131:
      ArrayList localArrayList2;
      if (i >= this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new Frame();
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "render: create cached frame#" + Integer.toHexString(localObject.hashCode()));
        ((Frame)localObject).setSizedTexture(locallqj.jdField_a_of_type_Int, locallqj.b, locallqj.c);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        if (!locallqj.a()) {
          break label257;
        }
        localArrayList2 = new ArrayList(1);
        lqq locallqq = new lqq();
        locallqq.jdField_a_of_type_JavaUtilList = locallqj.jdField_a_of_type_JavaUtilList;
        localArrayList2.add(locallqq);
      }
      label257:
      for (Object localObject = lqp.a((Frame)localObject, localArrayList2);; localObject = lqp.a((Frame)localObject))
      {
        localArrayList1.add(localObject);
        i += 1;
        break;
        localObject = (Frame)this.jdField_a_of_type_JavaUtilList.get(i);
        ((Frame)this.jdField_a_of_type_JavaUtilList.get(i)).setSizedTexture(locallqj.jdField_a_of_type_Int, locallqj.b, locallqj.c);
        break label131;
      }
    }
    b(localArrayList1, paramLong);
  }
  
  protected void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Frame)this.jdField_a_of_type_JavaUtilList.get(i)).clear();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy: cached frame#" + Integer.toHexString(((Frame)this.jdField_a_of_type_JavaUtilList.get(i)).hashCode()));
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    FrameBufferCache.getInstance().destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lqi
 * JD-Core Version:    0.7.0.1
 */