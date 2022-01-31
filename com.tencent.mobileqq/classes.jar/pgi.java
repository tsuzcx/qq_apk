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

public class pgi
  implements raa
{
  pgi(pgh parampgh, plf paramplf, pau parampau, Container paramContainer) {}
  
  public void a()
  {
    int j = 1;
    QLog.d("NoteCardProteusItem", 1, "onItemResume");
    pgh.a(this.jdField_a_of_type_Pgh, true);
    if (pgh.a(this.jdField_a_of_type_Pgh) != null) {
      pgh.a(this.jdField_a_of_type_Pgh).a();
    }
    if (this.jdField_a_of_type_Plf != null) {
      this.jdField_a_of_type_Plf.a();
    }
    Object localObject = this.jdField_a_of_type_Pau.a().scripCmsInfo;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((pgh.a(this.jdField_a_of_type_Pgh)) && (pcb.a() != 0))
    {
      i = pcb.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      int k = pcb.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      if ((i < pcb.b()) && (k < pcb.c()))
      {
        ((qcb)localObject).a = 2;
        pcb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, i + 1);
        pcb.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, k + 1);
      }
    }
    if ((pcb.a() == 1) && (pcb.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str) > 0))
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
      pgh.b(this.jdField_a_of_type_Pgh, false);
      localObject = this.jdField_a_of_type_Pau.a();
      if (localObject != null)
      {
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        osj.a().b();
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("NoteCardProteusItem", 1, "onItemPause");
    pgh.a(this.jdField_a_of_type_Pgh, false);
    if (this.jdField_a_of_type_Plf != null) {
      this.jdField_a_of_type_Plf.b();
    }
    pgh.b(this.jdField_a_of_type_Pgh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgi
 * JD-Core Version:    0.7.0.1
 */