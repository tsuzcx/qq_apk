import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.1;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;

public class sjf
  extends bfzc<stSimpleMetaFeed, bfzf<stSimpleMetaFeed>>
{
  public static int b;
  public int a;
  public long a;
  public RockDownloadListenerWrapper a;
  private WSRedDotPushMsg jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg;
  public RecyclerViewWithHeaderFooter a;
  private sjg jdField_a_of_type_Sjg;
  public skm a;
  public int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  
  public sjf(Context paramContext, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = paramRecyclerViewWithHeaderFooter;
    this.d = axlk.e(paramContext);
    this.e = axlk.a(3.0F);
    this.f = axlk.a(18.0F);
    this.g = axlk.a(14.0F);
  }
  
  public int a(int paramInt)
  {
    Object localObject = a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (stSimpleMetaFeed)((List)localObject).get(paramInt);
      if ((localObject != null) && (((stSimpleMetaFeed)localObject).waterFallCardStyle != null)) {
        return ((stSimpleMetaFeed)localObject).waterFallCardStyle.cardType;
      }
    }
    return 1;
  }
  
  public bfzf<stSimpleMetaFeed> a(ViewGroup paramViewGroup, int paramInt)
  {
    return skw.a(paramInt, paramViewGroup, this);
  }
  
  public RockDownloadListenerWrapper a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = new WSRecommendAdapter.1(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper;
  }
  
  public WSRedDotPushMsg a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg;
  }
  
  public skm a()
  {
    if (this.jdField_a_of_type_Skm == null) {
      this.jdField_a_of_type_Skm = skn.a(100, 2);
    }
    return this.jdField_a_of_type_Skm;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + this.c;
    if ((i < 0) || (i >= a().size())) {
      snb.c("weishi-ding", "点赞position越界:" + i);
    }
    stSimpleMetaFeed localstSimpleMetaFeed;
    do
    {
      return;
      localstSimpleMetaFeed = (stSimpleMetaFeed)a(i);
    } while (localstSimpleMetaFeed == null);
    paramInt1 = localstSimpleMetaFeed.ding_count;
    if (paramInt2 == 1) {
      paramInt1 += 1;
    }
    for (;;)
    {
      localstSimpleMetaFeed.ding_count = paramInt1;
      localstSimpleMetaFeed.is_ding = paramInt2;
      notifyItemChanged(i);
      snb.b("weishi-ding", "第" + i + "个条目的点赞改变了~~~");
      return;
      paramInt1 -= 1;
    }
  }
  
  public void a(bfzf<stSimpleMetaFeed> parambfzf)
  {
    if (this.jdField_a_of_type_Sjg != null) {
      this.jdField_a_of_type_Sjg.a(parambfzf);
    }
  }
  
  public void a(bfzf<stSimpleMetaFeed> parambfzf, int paramInt)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)a(paramInt);
    if (localstSimpleMetaFeed != null) {
      parambfzf.a(localstSimpleMetaFeed);
    }
  }
  
  public void a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg = paramWSRedDotPushMsg;
  }
  
  public void a(List<stSimpleMetaFeed> paramList)
  {
    List localList = a();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public void a(sjg paramsjg)
  {
    this.jdField_a_of_type_Sjg = paramsjg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjf
 * JD-Core Version:    0.7.0.1
 */