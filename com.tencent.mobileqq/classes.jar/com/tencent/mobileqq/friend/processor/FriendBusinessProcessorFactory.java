package com.tencent.mobileqq.friend.processor;

import com.tencent.mobileqq.app.friendlist.processor.ApolloProcessor;
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
  private static ArrayList<Class<? extends BaseFriendProcessor>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static ArrayList<BaseFriendProcessor> b = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add(ApolloProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(DiscussionProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(FriendStatusProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(IntimateInfoProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(ListenTogetherProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(MainProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(MutualMarkProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(OnlineStatusProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QidianProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QIMFriendProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(RichStatusProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(ShieldFriendProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(SpecialCareProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(VASProcessor.class);
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    b.clear();
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject1 = (Class)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("IMCore.friend.FriendBusinessProcessor", 2, "initBusinessProcessors| " + ((Class)localObject1).getName());
        }
        try
        {
          localObject1 = (BaseFriendProcessor)((Class)localObject1).getConstructor(new Class[] { AppRuntime.class }).newInstance(new Object[] { paramAppRuntime });
          if (localObject1 != null) {
            b.add(localObject1);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("IMCore.friend.FriendBusinessProcessor", 1, "initBusinessProcessors fail.", localException);
            Object localObject2 = null;
          }
        }
      }
    }
  }
  
  public ArrayList<BaseFriendProcessor> a(AppRuntime paramAppRuntime)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(paramAppRuntime);
      this.jdField_a_of_type_Boolean = true;
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.processor.FriendBusinessProcessorFactory
 * JD-Core Version:    0.7.0.1
 */