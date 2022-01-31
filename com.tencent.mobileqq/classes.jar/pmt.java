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

public class pmt
  implements rpx
{
  pmt(pms parampms, prj paramprj, pgd parampgd, Container paramContainer) {}
  
  public void a()
  {
    int j = 1;
    QLog.d("NoteCardProteusItem", 1, "onItemResume");
    pms.a(this.jdField_a_of_type_Pms, true);
    if (pms.a(this.jdField_a_of_type_Pms) != null) {
      pms.a(this.jdField_a_of_type_Pms).a();
    }
    if (this.jdField_a_of_type_Prj != null) {
      this.jdField_a_of_type_Prj.a();
    }
    Object localObject = this.jdField_a_of_type_Pgd.a().scripCmsInfo;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((pms.a(this.jdField_a_of_type_Pms)) && (pid.a() != 0))
    {
      i = pid.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      int k = pid.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      if ((i < pid.b()) && (k < pid.c()))
      {
        ((qlx)localObject).a = 2;
        pid.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, i + 1);
        pid.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, k + 1);
      }
    }
    if ((pid.a() == 1) && (pid.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str) > 0))
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
      pms.b(this.jdField_a_of_type_Pms, false);
      localObject = this.jdField_a_of_type_Pgd.a();
      if (localObject != null)
      {
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        oxb.a().b();
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("NoteCardProteusItem", 1, "onItemPause");
    pms.a(this.jdField_a_of_type_Pms, false);
    if (this.jdField_a_of_type_Prj != null) {
      this.jdField_a_of_type_Prj.b();
    }
    pms.b(this.jdField_a_of_type_Pms);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pmt
 * JD-Core Version:    0.7.0.1
 */