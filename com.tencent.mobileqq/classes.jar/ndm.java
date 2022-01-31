import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.now.NowVideoController.2;
import com.tencent.biz.now.NowVideoController.3;
import com.tencent.biz.now.NowVideoView;
import com.tencent.image.QQLiveDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ndm
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static ndm jdField_a_of_type_Ndm;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = new ndn(this, Looper.getMainLooper());
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  List<WeakReference<NowVideoView>> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public boolean b = true;
  
  public static ndm a()
  {
    if (jdField_a_of_type_Ndm == null) {}
    try
    {
      if (jdField_a_of_type_Ndm == null) {
        jdField_a_of_type_Ndm = new ndm();
      }
      return jdField_a_of_type_Ndm;
    }
    finally {}
  }
  
  private void e()
  {
    QLog.d("NowVideoController", 2, "Check play()");
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 0)) {
      return;
    }
    AbsListView localAbsListView = this.jdField_a_of_type_ComTencentWidgetAbsListView;
    int k = localAbsListView.getFirstVisiblePosition();
    int m = localAbsListView.getLastVisiblePosition();
    int i = k;
    label54:
    Object localObject;
    int j;
    if (i <= m)
    {
      localObject = localAbsListView.getChildAt(i - k);
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131376580);
        if ((localObject instanceof NowVideoView))
        {
          localObject = (NowVideoView)localObject;
          ((NowVideoView)localObject).getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
          ((NowVideoView)localObject).getHeight();
          if (jdField_a_of_type_AndroidGraphicsRect.height() <= 0) {
            break label156;
          }
          j = 1;
          label125:
          if (!a(((NowVideoView)localObject).getContext(), (NowVideoView)localObject)) {
            break label189;
          }
          if (j == 0) {
            break label161;
          }
          ((NowVideoView)localObject).a(true);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label54;
      break;
      label156:
      j = 0;
      break label125;
      label161:
      localObject = ((NowVideoView)localObject).a();
      if ((localObject != null) && (!((QQLiveDrawable)localObject).isPaused()))
      {
        ((QQLiveDrawable)localObject).pause();
        continue;
        label189:
        ((NowVideoView)localObject).a();
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoController", 2, "#requestPlayCheck():# ");
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1008) || (this.jdField_a_of_type_ComTencentWidgetAbsListView == null)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getLastVisiblePosition();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.postDelayed(new NowVideoController.3(this, i, j), paramLong);
  }
  
  public void a(NowVideoView paramNowVideoView)
  {
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramNowVideoView));
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentWidgetAbsListView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.b = true;
      e();
      return;
    }
    this.b = false;
  }
  
  public boolean a(Context paramContext, NowVideoView paramNowVideoView)
  {
    return bbev.h(paramContext);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoController", 2, "onNetWifi2Mobile(): ====>");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentWidgetAbsListView == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    d();
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((NowVideoView)localWeakReference.get()).e();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentWidgetAbsListView = null;
    this.b = true;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())) {}
    while ((this.jdField_a_of_type_ComTencentWidgetAbsListView == null) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getLastVisiblePosition();
    BaseActivity.sTopActivity.runOnUiThread(new NowVideoController.2(this, i, j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ndm
 * JD-Core Version:    0.7.0.1
 */