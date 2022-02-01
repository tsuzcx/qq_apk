package com.tencent.mobileqq.friend.processor;

import com.tencent.mobileqq.apollo.ApolloProcessor;
import com.tencent.mobileqq.app.friendlist.processor.AddFriendProcessor;
import com.tencent.mobileqq.app.friendlist.processor.DiscussionProcessor;
import com.tencent.mobileqq.app.friendlist.processor.FriendStatusProcessor;
import com.tencent.mobileqq.app.friendlist.processor.IntimateInfoProcessor;
import com.tencent.mobileqq.app.friendlist.processor.ListenTogetherProcessor;
import com.tencent.mobileqq.app.friendlist.processor.MainProcessor;
import com.tencent.mobileqq.app.friendlist.processor.MutualMarkProcessor;
import com.tencent.mobileqq.app.friendlist.processor.OnlineStatusProcessor;
import com.tencent.mobileqq.app.friendlist.processor.QIMFriendProcessor;
import com.tencent.mobileqq.app.friendlist.processor.QidianProcessor;
import com.tencent.mobileqq.app.friendlist.processor.RichStatusProcessor;
import com.tencent.mobileqq.app.friendlist.processor.ShieldFriendProcessor;
import com.tencent.mobileqq.app.friendlist.processor.SpecialCareProcessor;
import com.tencent.mobileqq.app.friendlist.processor.VASProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class FriendBusinessProcessorFactory
{
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_FriendBusinessProcessor.yml", version=1)
  private static ArrayList<Class<? extends BaseFriendProcessor>> a = new ArrayList();
  private static ArrayList<BaseFriendProcessor> c = new ArrayList();
  private volatile boolean b = false;
  
  static
  {
    a.add(ApolloProcessor.class);
    a.add(DiscussionProcessor.class);
    a.add(FriendStatusProcessor.class);
    a.add(IntimateInfoProcessor.class);
    a.add(ListenTogetherProcessor.class);
    a.add(MainProcessor.class);
    a.add(MutualMarkProcessor.class);
    a.add(OnlineStatusProcessor.class);
    a.add(QidianProcessor.class);
    a.add(QIMFriendProcessor.class);
    a.add(RichStatusProcessor.class);
    a.add(ShieldFriendProcessor.class);
    a.add(SpecialCareProcessor.class);
    a.add(VASProcessor.class);
    a.add(AddFriendProcessor.class);
  }
  
  private void b(AppRuntime paramAppRuntime)
  {
    c.clear();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Class)localIterator.next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initBusinessProcessors| ");
        localStringBuilder.append(((Class)localObject1).getName());
        QLog.d("IMCore.friend.FriendBusinessProcessor", 2, localStringBuilder.toString());
      }
      Object localObject2;
      try
      {
        localObject1 = (BaseFriendProcessor)((Class)localObject1).getConstructor(new Class[] { AppRuntime.class }).newInstance(new Object[] { paramAppRuntime });
      }
      catch (Exception localException)
      {
        QLog.d("IMCore.friend.FriendBusinessProcessor", 1, "initBusinessProcessors fail.", localException);
        localObject2 = null;
      }
      if (localObject2 != null) {
        c.add(localObject2);
      }
    }
  }
  
  public ArrayList<BaseFriendProcessor> a(AppRuntime paramAppRuntime)
  {
    if (!this.b)
    {
      b(paramAppRuntime);
      this.b = true;
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.processor.FriendBusinessProcessorFactory
 * JD-Core Version:    0.7.0.1
 */