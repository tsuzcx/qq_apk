package com.tencent.mobileqq.forward;

import ajvk;
import android.text.TextUtils;
import android.util.Pair;
import aqdz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class ForwardPreviewTroopMemberController$1
  implements Runnable
{
  public ForwardPreviewTroopMemberController$1(aqdz paramaqdz, String paramString) {}
  
  public void run()
  {
    Object localObject1 = ((ajvk)aqdz.a(this.this$0).getManager(53)).a(this.a);
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      Iterator localIterator = ((Map)localObject1).values().iterator();
      while (localIterator.hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
        if (localDiscussionMemberInfo != null)
        {
          Object localObject2 = localDiscussionMemberInfo.inteRemark;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localDiscussionMemberInfo.memberName;
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = localDiscussionMemberInfo.memberUin;
          }
          localArrayList.add(new Pair(localDiscussionMemberInfo.memberUin, localObject2));
        }
      }
    }
    QLog.i("Forward.Preview.Dialog", 1, "loadDiscussionMember discussion mem list size is: " + localArrayList.size());
    ThreadManager.getUIHandler().post(new ForwardPreviewTroopMemberController.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.1
 * JD-Core Version:    0.7.0.1
 */