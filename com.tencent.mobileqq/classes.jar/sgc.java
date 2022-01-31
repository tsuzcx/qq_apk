import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.List;

public class sgc
  implements ajfe
{
  public void a() {}
  
  public void a(byte paramByte) {}
  
  public void a(int paramInt) {}
  
  public void a(StoryPushMsg paramStoryPushMsg) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, List<Object> paramList) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<UserInfo> paramList, boolean paramBoolean2, String paramString, List<String> paramList1) {}
  
  public void a(boolean paramBoolean, UserInfo paramUserInfo) {}
  
  public void a(boolean paramBoolean, QQStoryUserInfo paramQQStoryUserInfo) {}
  
  public void a(boolean paramBoolean, List<String> paramList) {}
  
  public void a(boolean paramBoolean1, List<QQStoryUserInfo> paramList, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString) {}
  
  public void a(boolean paramBoolean, sfx paramsfx) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    if (!paramBoolean1)
    {
      if (!paramBoolean2) {
        break label58;
      }
      paramString = "";
      if (paramInt != 0) {
        break label68;
      }
    }
    label58:
    label68:
    for (String str = ajjy.a(2131645173);; str = ajjy.a(2131645171))
    {
      bcec.a().a(paramString + str + ajjy.a(2131645174));
      return;
      paramString = ajjy.a(2131645172);
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean) {}
  
  public void d(boolean paramBoolean) {}
  
  public void e(boolean paramBoolean) {}
  
  public void f(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool = true;
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.protocol", 2, "QQStoryObserver onUpdate. type=" + paramInt + " isSuccess=" + paramBoolean);
    }
    switch (paramInt)
    {
    case 1008: 
    case 1013: 
    case 1014: 
    case 1025: 
    default: 
    case 1003: 
    case 1018: 
    case 1004: 
    case 1019: 
    case 1001: 
    case 1002: 
    case 1005: 
    case 1006: 
    case 1007: 
    case 1009: 
    case 1010: 
    case 1011: 
    case 1015: 
    case 1016: 
    case 1017: 
    case 1012: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1023: 
    case 1024: 
      label503:
      label509:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  a(((Integer)paramObject).intValue());
                  return;
                  b(((Integer)paramObject).intValue());
                  return;
                  a(paramBoolean);
                  return;
                  b(paramBoolean);
                  return;
                  paramObject = (Object[])paramObject;
                  if (paramBoolean)
                  {
                    a(paramBoolean, (List)paramObject[0], (byte[])paramObject[1], ((Boolean)paramObject[2]).booleanValue(), (String)paramObject[3]);
                    return;
                  }
                  a(false, null, null, true, null);
                  return;
                  paramObject = (Object[])paramObject;
                  a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
                  return;
                  a(paramBoolean, (QQStoryUserInfo)paramObject);
                  return;
                  a(paramBoolean, (List)paramObject);
                  return;
                  if (paramBoolean)
                  {
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, ((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
                    return;
                  }
                  a(paramBoolean, 0, null);
                  return;
                  Object localObject2 = (UserInfo)paramObject;
                  Object localObject3;
                  if (localObject2 != null)
                  {
                    localObject3 = (sqs)sqg.a(2);
                    localObject1 = ((sqs)localObject3).b(((UserInfo)localObject2).uid);
                    paramObject = localObject1;
                    if (localObject1 == null)
                    {
                      paramObject = new QQUserUIItem();
                      paramObject.uid = ((UserInfo)localObject2).uid;
                      paramObject.setUnionId(((UserInfo)localObject2).unionId);
                    }
                    if (((UserInfo)localObject2).type != 1) {
                      break label503;
                    }
                    bool = true;
                    paramObject.isVip = bool;
                    paramObject.headUrl = ((UserInfo)localObject2).headUrl;
                    paramObject.nickName = ((UserInfo)localObject2).nick;
                    paramObject.remark = ((UserInfo)localObject2).remark;
                    if (!((UserInfo)localObject2).isSubscribe) {
                      break label509;
                    }
                  }
                  for (paramInt = i;; paramInt = 0)
                  {
                    paramObject.isSubscribe = paramInt;
                    paramObject.symbolUrl = ((UserInfo)localObject2).authTypeIcon;
                    ((sqs)localObject3).a(paramObject);
                    a(paramBoolean, (UserInfo)localObject2);
                    return;
                    bool = false;
                    break;
                  }
                  if (paramBoolean)
                  {
                    localObject3 = (Object[])paramObject;
                    paramInt = ((Integer)localObject3[0]).intValue();
                    paramObject = (List)localObject3[1];
                    localObject1 = (Boolean)localObject3[2];
                    localObject2 = (String)localObject3[3];
                    localObject3 = (List)localObject3[4];
                    a(paramBoolean, paramInt, paramObject, ((Boolean)localObject1).booleanValue(), (String)localObject2, (List)localObject3);
                    return;
                  }
                  a(false, 0, null, false, null, null);
                  return;
                  Object localObject1 = (Object[])paramObject;
                  paramInt = ((Integer)localObject1[0]).intValue();
                  paramObject = (String)localObject1[1];
                  localObject1 = (Boolean)localObject1[2];
                  if (paramBoolean)
                  {
                    Bosses.get().postJob(new sgd(this, "QQStoryObserver", paramObject, (Boolean)localObject1, paramBoolean, paramInt));
                    return;
                  }
                  localObject1 = ((sqs)sqg.a(2)).b(paramObject);
                  if (localObject1 != null)
                  {
                    if (!((QQUserUIItem)localObject1).isSubscribe()) {}
                    for (paramBoolean = bool;; paramBoolean = false)
                    {
                      a(false, paramBoolean, paramInt, paramObject);
                      return;
                    }
                  }
                  a(false, false, paramInt, paramObject);
                  return;
                  if (paramBoolean)
                  {
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
                    return;
                  }
                  a(paramBoolean, 0, null);
                  return;
                  c(paramBoolean);
                  return;
                  if (paramBoolean)
                  {
                    a(true, (sfx)paramObject);
                    return;
                  }
                  a(false, null);
                  return;
                } while (!(paramObject instanceof StoryPushMsg));
                a((StoryPushMsg)paramObject);
                return;
              } while (!paramBoolean);
              d(((Boolean)paramObject).booleanValue());
              return;
            } while (!paramBoolean);
            b();
            return;
          } while (!paramBoolean);
          e(((Boolean)paramObject).booleanValue());
          return;
        } while (!paramBoolean);
        f(((Boolean)paramObject).booleanValue());
        return;
      } while (!paramBoolean);
      a(((Byte)paramObject).byteValue());
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sgc
 * JD-Core Version:    0.7.0.1
 */