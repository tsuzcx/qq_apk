import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class stb
  implements tft
{
  stb(ssz paramssz, List paramList) {}
  
  public void a()
  {
    QLog.e("Q.qqstory.msgTab.jobPullBasicInfo", 1, "pull video info failed");
    ssz.b(this.jdField_a_of_type_Ssz, new ErrorMessage(102, "pull video info failed"));
  }
  
  public void a(ArrayList<StoryVideoItem> paramArrayList)
  {
    if (paramArrayList == null)
    {
      urk.e("Q.qqstory.msgTab.jobPullBasicInfo", "video list empty !");
      ssz.a(this.jdField_a_of_type_Ssz, new ErrorMessage(102, "video list empty !"));
      return;
    }
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    Object localObject;
    while (paramArrayList.hasNext())
    {
      localObject = (StoryVideoItem)paramArrayList.next();
      localHashMap.put(((StoryVideoItem)localObject).mVid, localObject);
    }
    paramArrayList = new ArrayList();
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      localObject = (tfv)this.jdField_a_of_type_JavaUtilList.get(i);
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localHashMap.get(((tfv)localObject).b);
      if (localStoryVideoItem == null) {
        urk.e("Q.qqstory.msgTab.jobPullBasicInfo", "not found video!");
      }
      for (;;)
      {
        i += 1;
        break;
        ((tfv)localObject).a = localStoryVideoItem;
        paramArrayList.add(localObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullBasicInfo", 2, "pull video info succeed, info");
    }
    ssz.a(this.jdField_a_of_type_Ssz, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stb
 * JD-Core Version:    0.7.0.1
 */