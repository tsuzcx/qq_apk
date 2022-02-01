package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.network.NetWorkManager.INetWorkChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$1", "Lcom/tencent/tkd/topicsdk/network/NetWorkManager$INetWorkChangeListener;", "onNetMobile2None", "", "onNetMobile2Wifi", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$1
  implements NetWorkManager.INetWorkChangeListener
{
  public void a()
  {
    Iterator localIterator = PublishManager.b(PublishManager.a).iterator();
    while (localIterator.hasNext()) {
      ((PublishManager.PublishTask)localIterator.next()).g();
    }
  }
  
  public void b()
  {
    Iterator localIterator = PublishManager.b(PublishManager.a).iterator();
    while (localIterator.hasNext()) {
      ((PublishManager.PublishTask)localIterator.next()).f();
    }
  }
  
  public void c()
  {
    Iterator localIterator = PublishManager.b(PublishManager.a).iterator();
    while (localIterator.hasNext()) {
      ((PublishManager.PublishTask)localIterator.next()).g();
    }
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    Iterator localIterator = PublishManager.b(PublishManager.a).iterator();
    while (localIterator.hasNext()) {
      ((PublishManager.PublishTask)localIterator.next()).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.1
 * JD-Core Version:    0.7.0.1
 */