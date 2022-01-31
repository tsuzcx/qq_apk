import android.content.Context;
import android.support.annotation.UiThread;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.10;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.11;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.5;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.6;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.8;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.9;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

public class qun
  implements Manager
{
  private awbw jdField_a_of_type_Awbw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new quo(this);
  private final ArrayList<UgcVideo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedHashMap<String, quk> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<qux> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final ArrayList<quw> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  
  public qun(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awbw = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private List<UgcVideo> a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.values();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      quk localquk = (quk)((Iterator)localObject).next();
      if (localquk.a().status == UgcVideo.STATUS_UPLOADING) {
        localArrayList.add(localquk.a());
      }
    }
    return localArrayList;
  }
  
  private List<UgcVideo> a(long paramLong, List<UgcVideo> paramList)
  {
    if (paramLong == 0L) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)paramList.next();
      if (localUgcVideo.columnId == paramLong) {
        localArrayList.add(localUgcVideo);
      }
    }
    return localArrayList;
  }
  
  public static qun a(QQAppInterface paramQQAppInterface)
  {
    return (qun)paramQQAppInterface.getManager(356);
  }
  
  private void b()
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.8(this), 32, null, false);
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToMobileEvent is doing");
      return;
    }
    List localList = a();
    if (localList.isEmpty())
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToMobileEvent, ugcVideoList isEmpty");
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      b((UgcVideo)((Iterator)localObject).next());
    }
    long l = qok.a(localList);
    localObject = BaseActivity.sTopActivity;
    if ((l > 0L) && (ors.v()) && (localObject != null))
    {
      qok.a((Context)localObject, l, new qup(this, localList), new quq(this));
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void f(UgcVideo paramUgcVideo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((qux)localIterator.next()).a(paramUgcVideo);
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
      if (localUgcVideo.status == UgcVideo.STATUS_UPLOADING) {
        b(localUgcVideo);
      }
    }
  }
  
  @UiThread
  public void a(long paramLong, @NotNull quv paramquv)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramquv.a(a(paramLong, this.jdField_a_of_type_JavaUtilArrayList));
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(new quu(this, paramLong, paramquv));
    b();
  }
  
  @UiThread
  public void a(UgcVideo paramUgcVideo)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "removeVideoTask, ugcVideo.seqId =" + paramUgcVideo.seqId);
    if (paramUgcVideo.status == UgcVideo.STATUS_UPLOADING) {
      b(paramUgcVideo);
    }
    paramUgcVideo.title = "";
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramUgcVideo.seqId);
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramUgcVideo);
    e(paramUgcVideo);
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.6(this, paramUgcVideo), 64, null, false);
  }
  
  @UiThread
  public final void a(@NotNull UgcVideo paramUgcVideo, boolean paramBoolean)
  {
    QLog.d("RIJUGC.RIJUgcVideoPublishManager", 1, "addVideoTask: ugcVideo.seqId = " + paramUgcVideo.seqId);
    quk localquk = (quk)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramUgcVideo.seqId);
    if (localquk == null)
    {
      localquk = new quk(paramUgcVideo);
      localquk.a(new qur(this));
      localquk.a(new qus(this));
      Object localObject1 = new qut(this, paramUgcVideo);
      Object localObject2 = new ohp(localquk, new ohl[] { new quh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localquk, (quj)localObject1), new qva(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localquk, (quj)localObject1, new qxi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) });
      localObject2 = new ohj(localquk, new ohl[] { new quy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localquk, (quj)localObject1), localObject2 });
      localObject1 = new qul(localquk, (quj)localObject1);
      localquk.a(new RIJUgcVideoPublishManager.5(this, paramUgcVideo));
      localquk.a(new ohl[] { localObject2, localObject1 }, paramBoolean);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramUgcVideo.seqId, localquk);
    }
    for (;;)
    {
      if (paramBoolean) {
        paramUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      }
      if ((paramUgcVideo.title != null) && (!paramUgcVideo.title.isEmpty()))
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramUgcVideo)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramUgcVideo);
        }
        c(paramUgcVideo);
      }
      return;
      localquk.a();
    }
  }
  
  @UiThread
  public void a(@NotNull qux paramqux)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramqux);
  }
  
  public void b(UgcVideo paramUgcVideo)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "pauseVideoTask, ugcVideo.seqId =" + paramUgcVideo.seqId);
    paramUgcVideo.status = UgcVideo.STATUS_PAUSE;
    quk localquk = (quk)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramUgcVideo.seqId);
    if (paramUgcVideo.startUploadingTime > 0L) {
      qok.a("pause", paramUgcVideo);
    }
    if (localquk != null) {
      localquk.b();
    }
  }
  
  @UiThread
  public void b(@NotNull qux paramqux)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramqux);
  }
  
  public void c(UgcVideo paramUgcVideo)
  {
    if ((paramUgcVideo.title != null) && (!paramUgcVideo.title.isEmpty()) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramUgcVideo))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ThreadManagerV2.excute(new RIJUgcVideoPublishManager.9(this, paramUgcVideo), 32, null, false);
      }
      return;
    }
  }
  
  public void d(UgcVideo paramUgcVideo)
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.10(this, paramUgcVideo), 32, null, false);
  }
  
  public void e(UgcVideo paramUgcVideo)
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.11(this, paramUgcVideo), 32, null, false);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Boolean = false;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qun
 * JD-Core Version:    0.7.0.1
 */