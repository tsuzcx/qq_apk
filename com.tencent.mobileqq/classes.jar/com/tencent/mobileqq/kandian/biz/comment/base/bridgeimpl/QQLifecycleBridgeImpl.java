package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.content.Intent;
import androidx.collection.ArraySet;
import com.tencent.image.AbstractGifImage;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;
import java.util.Iterator;
import java.util.Set;

public class QQLifecycleBridgeImpl
  implements QQLifecycleBridge
{
  private Set<QQLifecycleBridge> a;
  
  public void a(QQLifecycleBridge paramQQLifecycleBridge)
  {
    if (this.a == null) {
      this.a = new ArraySet();
    }
    this.a.add(paramQQLifecycleBridge);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQLifecycleBridge)((Iterator)localObject).next()).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onDestroy(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQLifecycleBridge)((Iterator)localObject).next()).onDestroy(paramBoolean);
      }
      this.a.clear();
    }
  }
  
  public void onPause()
  {
    AbstractGifImage.pauseAll();
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQLifecycleBridge)((Iterator)localObject).next()).onPause();
      }
    }
  }
  
  public void onResume()
  {
    AbstractGifImage.resumeAll();
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QQLifecycleBridge)((Iterator)localObject).next()).onResume();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQLifecycleBridgeImpl
 * JD-Core Version:    0.7.0.1
 */