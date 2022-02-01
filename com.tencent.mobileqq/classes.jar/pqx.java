import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.5;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.6;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.7;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;

public class pqx
  extends pqj
{
  private aoeg jdField_a_of_type_Aoeg = new pqy(this);
  private List<twi> jdField_a_of_type_JavaUtilList;
  private volatile boolean jdField_a_of_type_Boolean;
  private Handler b = new pqz(this, ThreadManager.getSubThreadLooper());
  
  public pqx(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qfo paramqfo, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqfo, paramHandler);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscriptionInfoModule.7(this, paramInt1, paramInt2));
  }
  
  public int a()
  {
    int i = 0;
    int j = 0;
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return j;
    }
    Iterator localIterator = twk.a().b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).iterator();
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      i = ((twi)localIterator.next()).b + i;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aoeg = null;
    if (this.b != null)
    {
      this.b.removeCallbacksAndMessages(null);
      this.b = null;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString)
  {
    int j;
    twi localtwi;
    if (!twk.a().a(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))
    {
      twk.a().b(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      ocd.a(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
      j = twk.a().a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localtwi = (twi)localIterator.next();
      } while ((localtwi.a == null) || (!localtwi.a.equals(paramString)));
    }
    for (int i = localtwi.b;; i = 0)
    {
      f();
      bdll.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CD", "0X80064CD", 0, 0, "" + i, "" + j, "", "");
      return;
    }
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface unFollowSubscribeAccount failed!");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new SubscriptionInfoModule.5(this, paramString, paramContext));
    paramContext = this.jdField_a_of_type_JavaUtilList.iterator();
    twi localtwi;
    do
    {
      if (!paramContext.hasNext()) {
        break;
      }
      localtwi = (twi)paramContext.next();
    } while ((localtwi.a == null) || (!localtwi.a.equals(paramString)));
    for (int i = localtwi.b;; i = 0)
    {
      bdll.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CF", "0X80064CF", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public void a(List<twi> paramList)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new SubscriptionInfoModule.3(this, paramList));
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    twk.a().c(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    int j = twk.a().a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    twi localtwi;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localtwi = (twi)localIterator.next();
    } while ((localtwi.a == null) || (!localtwi.a.equals(paramString)));
    for (int i = localtwi.b;; i = 0)
    {
      f();
      bdll.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CE", "0X80064CE", 0, 0, "" + i, "" + j, "", "");
      return;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
  }
  
  public void c(String paramString)
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface unFollowSubscribeAccount failed!");
      }
      return;
    }
    twk.a().a(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    f();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new SubscriptionInfoModule.6(this, paramString));
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1014);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    twi localtwi;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localtwi = (twi)((Iterator)localObject).next();
    } while ((localtwi.a == null) || (!localtwi.a.equals(paramString)));
    for (int i = localtwi.b;; i = 0)
    {
      bdll.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064D0", "0X80064D0", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public void d()
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface init model failed!");
      }
    }
    while (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new SubscriptionInfoModule.1(this));
  }
  
  public void e() {}
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new SubscriptionInfoModule.2(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface");
  }
  
  public void g()
  {
    a(((KandianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getManager(162)).a(1), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqx
 * JD-Core Version:    0.7.0.1
 */