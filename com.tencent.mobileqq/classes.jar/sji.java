import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter.1;
import com.tencent.biz.pubaccount.weishi_new.download.RockDownloadListenerWrapper;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.List;

public class sji
  extends bfyl<stSimpleMetaFeed, bfyo<stSimpleMetaFeed>>
{
  public static int b;
  public int a;
  public long a;
  public RockDownloadListenerWrapper a;
  private WSRedDotPushMsg jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg;
  public RecyclerViewWithHeaderFooter a;
  private sjj jdField_a_of_type_Sjj;
  public skp a;
  public int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  
  public sji(Context paramContext, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = paramRecyclerViewWithHeaderFooter;
    this.d = axli.e(paramContext);
    this.e = axli.a(3.0F);
    this.f = axli.a(18.0F);
    this.g = axli.a(14.0F);
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
  
  public bfyo<stSimpleMetaFeed> a(ViewGroup paramViewGroup, int paramInt)
  {
    return skz.a(paramInt, paramViewGroup, this);
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
  
  public skp a()
  {
    if (this.jdField_a_of_type_Skp == null) {
      this.jdField_a_of_type_Skp = skq.a(100, 2);
    }
    return this.jdField_a_of_type_Skp;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 + this.c;
    if ((i < 0) || (i >= a().size())) {
      sne.c("weishi-ding", "点赞position越界:" + i);
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
      sne.b("weishi-ding", "第" + i + "个条目的点赞改变了~~~");
      return;
      paramInt1 -= 1;
    }
  }
  
  public void a(bfyo<stSimpleMetaFeed> parambfyo)
  {
    if (this.jdField_a_of_type_Sjj != null) {
      this.jdField_a_of_type_Sjj.a(parambfyo);
    }
  }
  
  public void a(bfyo<stSimpleMetaFeed> parambfyo, int paramInt)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)a(paramInt);
    if (localstSimpleMetaFeed != null) {
      parambfyo.a(localstSimpleMetaFeed);
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
  
  public void a(sjj paramsjj)
  {
    this.jdField_a_of_type_Sjj = paramsjj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sji
 * JD-Core Version:    0.7.0.1
 */