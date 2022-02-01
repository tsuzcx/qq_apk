import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.event.AddCommentLinkEvent;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLinkView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import com.tencent.tkd.comment.publisher.qq.util.QQViewCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class pdj
  implements SimpleEventReceiver, phg
{
  @Deprecated
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  @Deprecated
  private CommentLinkView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView;
  private List<BaseCommentData.CommentLinkData> jdField_a_of_type_JavaUtilList;
  
  private pdj(pdd parampdd) {}
  
  private void a(Context paramContext)
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    Bundle localBundle = new Bundle();
    int j = pdd.a(this.jdField_a_of_type_Pdd).g;
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      pqx.a(paramContext, "https://viola.qq.com/js/commLinkSelector.js?_rij_violaUrl=1&v_tid=6&v_bundleName=commLinkSelector&hideNav=1&v_nav_immer=1&v_bid=3740&remainLinkCount=" + (j - i), localBundle);
      return;
    }
  }
  
  @Deprecated
  private void a(BaseCommentData.CommentLinkData paramCommentLinkData) {}
  
  private void b(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if (paramCommentLinkData == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(pdd.a(this.jdField_a_of_type_Pdd).g);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramCommentLinkData);
    TkdCommentLinkData localTkdCommentLinkData = new TkdCommentLinkData();
    localTkdCommentLinkData.type = paramCommentLinkData.type;
    localTkdCommentLinkData.iconUrl = paramCommentLinkData.iconUrl;
    localTkdCommentLinkData.linkUrl = paramCommentLinkData.linkUrl;
    localTkdCommentLinkData.wording = paramCommentLinkData.wording;
    pdd.a(this.jdField_a_of_type_Pdd).onAddLink(localTkdCommentLinkData);
  }
  
  void a()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  @Deprecated
  void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  void b()
  {
    Object localObject = pdd.a(this.jdField_a_of_type_Pdd).getCommentLinkData();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      this.jdField_a_of_type_JavaUtilList = null;
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TkdCommentLinkData localTkdCommentLinkData = (TkdCommentLinkData)((Iterator)localObject).next();
        BaseCommentData.CommentLinkData localCommentLinkData = new BaseCommentData.CommentLinkData();
        localCommentLinkData.wording = localTkdCommentLinkData.wording;
        localCommentLinkData.iconUrl = localTkdCommentLinkData.iconUrl;
        localCommentLinkData.linkUrl = localTkdCommentLinkData.linkUrl;
        localCommentLinkData.type = localTkdCommentLinkData.type;
        this.jdField_a_of_type_JavaUtilList.add(localCommentLinkData);
      }
    }
  }
  
  @Deprecated
  public void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView.setVisibility(8);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AddCommentLinkEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AddCommentLinkEvent))
    {
      a(((AddCommentLinkEvent)paramSimpleBaseEvent).linkData);
      b(((AddCommentLinkEvent)paramSimpleBaseEvent).linkData);
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdj
 * JD-Core Version:    0.7.0.1
 */