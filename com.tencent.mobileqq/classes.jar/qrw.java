import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qrw
  implements View.OnClickListener
{
  qrw(qrv paramqrv) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Snh == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ArticleInfo localArticleInfo = ((pxk)this.a.jdField_a_of_type_JavaLangObject).a();
      if (localArticleInfo != null)
      {
        int i = ComponentContentGalleryBiu.a(localArticleInfo, this.a.jdField_a_of_type_Snh);
        soy localsoy = this.a.jdField_a_of_type_Snh.a();
        if (localsoy != null) {
          localsoy.a(this.a.jdField_a_of_type_AndroidContentContext, localArticleInfo, 0, localArticleInfo.innerUniqueID, i, this.a.jdField_a_of_type_Int, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qrw
 * JD-Core Version:    0.7.0.1
 */