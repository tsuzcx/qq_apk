import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.NoteCardProteusItem.1.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class qot
  implements syr
{
  qot(qos paramqos, qua paramqua, qfw paramqfw, Container paramContainer) {}
  
  public void a()
  {
    int j = 1;
    QLog.d("NoteCardProteusItem", 1, "onItemResume");
    qos.a(this.jdField_a_of_type_Qos, true);
    if (qos.a(this.jdField_a_of_type_Qos) != null) {
      qos.a(this.jdField_a_of_type_Qos).a();
    }
    if (this.jdField_a_of_type_Qua != null) {
      this.jdField_a_of_type_Qua.a();
    }
    Object localObject = this.jdField_a_of_type_Qfw.a().scripCmsInfo;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((qos.a(this.jdField_a_of_type_Qos)) && (qjw.a() != 0))
    {
      i = qjw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      int k = qjw.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      if ((i < qjw.b()) && (k < qjw.c()))
      {
        ((rqh)localObject).a = 2;
        qjw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, i + 1);
        qjw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, k + 1);
      }
    }
    if ((qjw.a() == 1) && (qjw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str) > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext();
      i = j;
      if (Build.VERSION.SDK_INT >= 23)
      {
        i = j;
        if (localObject != null) {
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label290;
          }
        }
      }
    }
    label290:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        ThreadManager.getUIHandler().postDelayed(new NoteCardProteusItem.1.1(this), 1000L);
      }
      qos.b(this.jdField_a_of_type_Qos, false);
      localObject = this.jdField_a_of_type_Qfw.a();
      if (localObject != null)
      {
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        pvm.a().b();
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("NoteCardProteusItem", 1, "onItemPause");
    qos.a(this.jdField_a_of_type_Qos, false);
    if (this.jdField_a_of_type_Qua != null) {
      this.jdField_a_of_type_Qua.b();
    }
    qos.b(this.jdField_a_of_type_Qos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qot
 * JD-Core Version:    0.7.0.1
 */