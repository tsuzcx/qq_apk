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

public class pwx
  implements sdz
{
  pwx(pww parampww, qby paramqby, ppu paramppu, Container paramContainer) {}
  
  public void a()
  {
    int j = 1;
    QLog.d("NoteCardProteusItem", 1, "onItemResume");
    pww.a(this.jdField_a_of_type_Pww, true);
    if (pww.a(this.jdField_a_of_type_Pww) != null) {
      pww.a(this.jdField_a_of_type_Pww).a();
    }
    if (this.jdField_a_of_type_Qby != null) {
      this.jdField_a_of_type_Qby.a();
    }
    Object localObject = this.jdField_a_of_type_Ppu.a().scripCmsInfo;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((pww.a(this.jdField_a_of_type_Pww)) && (prz.a() != 0))
    {
      i = prz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      int k = prz.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      if ((i < prz.b()) && (k < prz.c()))
      {
        ((qxc)localObject).a = 2;
        prz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, i + 1);
        prz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, k + 1);
      }
    }
    if ((prz.a() == 1) && (prz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str) > 0))
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
      pww.b(this.jdField_a_of_type_Pww, false);
      localObject = this.jdField_a_of_type_Ppu.a();
      if (localObject != null)
      {
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        pfd.a().b();
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("NoteCardProteusItem", 1, "onItemPause");
    pww.a(this.jdField_a_of_type_Pww, false);
    if (this.jdField_a_of_type_Qby != null) {
      this.jdField_a_of_type_Qby.b();
    }
    pww.b(this.jdField_a_of_type_Pww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwx
 * JD-Core Version:    0.7.0.1
 */