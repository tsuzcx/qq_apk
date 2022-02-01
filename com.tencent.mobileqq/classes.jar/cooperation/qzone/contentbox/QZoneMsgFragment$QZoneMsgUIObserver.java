package cooperation.qzone.contentbox;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

class QZoneMsgFragment$QZoneMsgUIObserver
  extends QZoneMsgObserver
{
  private static final String TAG = "QZoneMsgManager.QZoneMsgFragment";
  
  QZoneMsgFragment$QZoneMsgUIObserver(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  protected boolean onDataValid(boolean paramBoolean, Bundle paramBundle)
  {
    return true;
  }
  
  protected void onLikeFeed(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onLikeFeed start");
    }
    super.onLikeFeed(paramBoolean, paramBundle);
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBoolean = paramBundle.getBoolean("like_key");
      long l = paramBundle.getLong("entity_pushtime");
      this.this$0.adapter.updateLike(l, paramBoolean);
    }
  }
  
  protected void onLoadMoreMsg(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onLoadMoreMsg");
    }
    super.onLoadMoreMsg(paramBoolean, paramBundle);
    if (!paramBoolean)
    {
      QZLog.e("QZoneMsgManager.QZoneMsgFragment", "onLoadMoreMsg error");
      QZoneMsgFragment.access$700(this.this$0, paramBoolean);
      return;
    }
    paramBundle = (QZoneMsgEntityNew)paramBundle.getSerializable("key_response");
    if (paramBundle != null)
    {
      this.this$0.adapter.addMQMsgs(paramBundle.ArkNes_vec);
      QZoneMsgFragment.access$300(this.this$0);
      QZoneMsgFragment.access$802(this.this$0, paramBundle.hasmore);
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onLoadMoreMsg ，hasMore=" + QZoneMsgFragment.access$800(this.this$0));
    }
    for (;;)
    {
      QZoneMsgFragment.access$700(this.this$0, paramBoolean);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "onLoadMoreMsg ，rsp=null");
      }
    }
  }
  
  protected void onPreloadMsg(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onPreloadMsg");
    }
    super.onPreloadMsg(paramBoolean, paramBundle);
    if (!paramBoolean) {
      QZLog.e("QZoneMsgManager.QZoneMsgFragment", "onPreloadMsg error");
    }
    do
    {
      return;
      paramBundle = (QZoneMsgEntityNew)paramBundle.getSerializable("key_response");
      if (paramBundle != null)
      {
        QZoneMsgFragment.access$100(this.this$0, paramBundle);
        QZoneMsgFragment.access$802(this.this$0, paramBundle.hasmore);
        this.this$0.adapter.setMQMsgs(paramBundle.ArkNes_vec, 1);
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onPreloadMsg ，hasMore=" + QZoneMsgFragment.access$800(this.this$0));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "onPreloadMsg ，rsp=null");
  }
  
  protected void onReFreshMsg(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "onReFreshMsg start");
    super.onReFreshMsg(paramBoolean, paramBundle);
    if (!paramBoolean)
    {
      QZLog.e("QZoneMsgManager.QZoneMsgFragment", "onReFreshMsg error");
      QZoneMsgFragment.access$900(this.this$0, paramBoolean);
    }
    do
    {
      do
      {
        return;
        paramBundle = (QZoneMsgEntityNew)paramBundle.getSerializable("key_response");
        if (paramBundle == null) {
          break;
        }
        QZoneMsgFragment.access$100(this.this$0, paramBundle);
        QZoneMsgFragment.access$400(this.this$0).postDelayed(new QZoneMsgFragment.QZoneMsgUIObserver.1(this, paramBundle, paramBoolean), 500L);
        QZoneMsgFragment.access$002(this.this$0, true);
        QZoneMsgFragment.access$802(this.this$0, paramBundle.hasmore);
      } while (!QLog.isColorLevel());
      StringBuilder localStringBuilder = new StringBuilder().append("onReFreshMsg ，hasMore=").append(QZoneMsgFragment.access$800(this.this$0)).append(" ,ArkNes_vec size:");
      if (paramBundle.ArkNes_vec != null) {}
      for (paramBundle = String.valueOf(paramBundle.ArkNes_vec.size());; paramBundle = "null")
      {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, paramBundle);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "onReFreshMsg ，rsp=null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.QZoneMsgUIObserver
 * JD-Core Version:    0.7.0.1
 */