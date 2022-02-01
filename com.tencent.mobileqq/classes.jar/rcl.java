import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;

public class rcl
  implements PTSComposer.IPTSUpdateDataListener
{
  public rcl(BaseArticleInfo paramBaseArticleInfo) {}
  
  public void onDataUpdated(String paramString)
  {
    QLog.i("Q.readinjoy.BaseArticleInfo", 1, "[onDataUpdated] jsonData = " + paramString);
    PTSItemData localPTSItemData = this.a.ptsItemData;
    if (localPTSItemData != null)
    {
      this.a.ptsItemData = new PTSItemData.Builder().withPageName(localPTSItemData.getPageName()).withItemID(localPTSItemData.getItemID()).withJsonData(paramString).withFrameTreeJson(localPTSItemData.getFrameTreeJson()).build();
      this.a.ptsItemDataBytes = qoa.a(this.a.ptsItemData);
      paramString = pay.a();
      if (paramString != null)
      {
        paramString = (pks)paramString.getManager(163);
        if ((paramString != null) && ((this.a instanceof ArticleInfo))) {
          paramString.a().b((ArticleInfo)this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rcl
 * JD-Core Version:    0.7.0.1
 */