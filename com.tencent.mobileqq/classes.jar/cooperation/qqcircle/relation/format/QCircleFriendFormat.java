package cooperation.qqcircle.relation.format;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.Entity;
import cooperation.qqcircle.relation.entitys.QCircleFriendEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcooperation.qqcircle.relation.entitys.QCircleFriendEntity;>;
import java.util.Map;

public class QCircleFriendFormat
{
  public static Map<String, List<Entity>> format(List<QCircleFriendEntity> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      QCircleFriendEntity localQCircleFriendEntity = (QCircleFriendEntity)localIterator.next();
      String str = localQCircleFriendEntity.mGroupName;
      Object localObject = (List)localHashMap.get(str);
      paramList = (List<QCircleFriendEntity>)localObject;
      if (localObject == null)
      {
        paramList = new ArrayList();
        localHashMap.put(str, paramList);
      }
      localObject = new Friends();
      ((Friends)localObject).uin = String.valueOf(localQCircleFriendEntity.mUin);
      ((Friends)localObject).name = localQCircleFriendEntity.mName;
      ((Friends)localObject).remark = localQCircleFriendEntity.mName;
      paramList.add(localObject);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.relation.format.QCircleFriendFormat
 * JD-Core Version:    0.7.0.1
 */