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

public class ovj
  implements qnt
{
  ovj(ovi paramovi, ozq paramozq, opw paramopw, Container paramContainer) {}
  
  public void a()
  {
    int j = 1;
    QLog.d("NoteCardProteusItem", 1, "onItemResume");
    ovi.a(this.jdField_a_of_type_Ovi, true);
    if (ovi.a(this.jdField_a_of_type_Ovi) != null) {
      ovi.a(this.jdField_a_of_type_Ovi).a();
    }
    if (this.jdField_a_of_type_Ozq != null) {
      this.jdField_a_of_type_Ozq.a();
    }
    Object localObject = this.jdField_a_of_type_Opw.a().scripCmsInfo;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((ovi.a(this.jdField_a_of_type_Ovi)) && (orc.a() != 0))
    {
      i = orc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      int k = orc.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      if ((i < orc.b()) && (k < orc.c()))
      {
        ((pqi)localObject).a = 2;
        orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, i + 1);
        orc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, k + 1);
      }
    }
    if ((orc.a() == 1) && (orc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str) > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext();
      i = j;
      if (Build.VERSION.SDK_INT >= 23)
      {
        i = j;
        if (localObject != null) {
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label263;
          }
        }
      }
    }
    label263:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        ThreadManager.getUIHandler().postDelayed(new NoteCardProteusItem.1.1(this), 1000L);
      }
      ovi.b(this.jdField_a_of_type_Ovi, false);
      return;
    }
  }
  
  public void b()
  {
    QLog.d("NoteCardProteusItem", 1, "onItemPause");
    ovi.a(this.jdField_a_of_type_Ovi, false);
    if (this.jdField_a_of_type_Ozq != null) {
      this.jdField_a_of_type_Ozq.b();
    }
    ovi.b(this.jdField_a_of_type_Ovi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovj
 * JD-Core Version:    0.7.0.1
 */