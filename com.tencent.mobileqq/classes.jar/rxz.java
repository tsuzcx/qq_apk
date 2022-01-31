import NS_KING_SOCIALIZE_META.stMetaTag;
import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;

public abstract class rxz
  extends bequ<stSimpleMetaFeed>
  implements View.OnClickListener, ryc
{
  private Context jdField_a_of_type_AndroidContentContext = a();
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private final RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private RecyclerViewWithHeaderFooter jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter;
  private rwm jdField_a_of_type_Rwm;
  private ryb jdField_a_of_type_Ryb = new rye(this);
  private final ImageView jdField_b_of_type_AndroidWidgetImageView;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private final TextView c;
  
  public rxz(@NonNull ViewGroup paramViewGroup, @NonNull rwm paramrwm, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_Rwm = paramrwm;
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = paramrwm.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)b(2131302892));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)b(2131312253));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)b(2131302893));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)b(2131312254));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)b(2131301550));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)b(2131301553));
    this.c = ((TextView)b(2131310889));
    this.itemView.setOnClickListener(this);
    a();
  }
  
  private int a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    float f1 = 1.333333F;
    int j = this.jdField_a_of_type_Rwm.d;
    int k = j / 2;
    int i = k;
    float f2 = f1;
    float f3;
    if (paramstSimpleMetaFeed != null)
    {
      paramstSimpleMetaFeed = paramstSimpleMetaFeed.waterFallCardStyle;
      i = k;
      f2 = f1;
      if (paramstSimpleMetaFeed != null)
      {
        f2 = paramstSimpleMetaFeed.ratioH;
        f3 = paramstSimpleMetaFeed.ratioW;
        if ((f2 == 0.0F) || (f3 == 0.0F)) {
          break label132;
        }
      }
    }
    label132:
    for (f2 /= f3;; f2 = 1.333333F)
    {
      if ((paramstSimpleMetaFeed.isFullSpan) && (f2 > 1.0F))
      {
        f1 = 0.5625F;
        if (!paramstSimpleMetaFeed.isFullSpan) {
          break label121;
        }
        i = j;
      }
      for (f2 = f1;; f2 = f1)
      {
        return (int)(i * f2);
        if (f2 > 2.0F) {
          break;
        }
        f1 = f2;
        break;
        label121:
        i = j / 2;
      }
    }
  }
  
  private ImageView a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_AndroidWidgetImageView;
    }
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  private TextView a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_AndroidWidgetTextView;
    }
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  private void a(RoundCornerImageView paramRoundCornerImageView, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramRoundCornerImageView == null) || (paramstSimpleMetaFeed == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.height = a(paramstSimpleMetaFeed);
    paramRoundCornerImageView.setLayoutParams(localLayoutParams);
    paramRoundCornerImageView.setCorner(this.jdField_a_of_type_Rwm.e);
  }
  
  protected View a(int paramInt)
  {
    int i;
    label14:
    ViewStub localViewStub;
    if (paramInt == 2)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label45;
      }
      i = 2131313275;
      localViewStub = (ViewStub)b(i);
      if (paramInt == 0) {
        break label51;
      }
    }
    label45:
    label51:
    for (paramInt = 2131494550;; paramInt = 2131494549)
    {
      localViewStub.setLayoutResource(paramInt);
      return localViewStub.inflate();
      paramInt = 0;
      break;
      i = 2131313274;
      break label14;
    }
  }
  
  public rwm a()
  {
    return this.jdField_a_of_type_Rwm;
  }
  
  protected abstract void a();
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  protected void a(int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    Object localObject = a(paramInt1);
    int i;
    if (localObject != null)
    {
      if (paramInt2 == 1)
      {
        i = 2130842495;
        ((ImageView)localObject).setImageResource(i);
        a((ImageView)localObject, this.jdField_a_of_type_Rwm.g);
      }
    }
    else
    {
      localObject = a(paramInt1);
      if (localObject != null) {
        if (paramInt2 != 1) {
          break label79;
        }
      }
    }
    label79:
    for (paramInt1 = paramstSimpleMetaFeed.playNum;; paramInt1 = paramstSimpleMetaFeed.ding_count)
    {
      qcn.a((TextView)localObject, paramInt1, "0");
      return;
      i = 2130845583;
      break;
    }
  }
  
  protected void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed.poster != null)
    {
      Object localObject = a(paramInt);
      if ((localObject instanceof RoundImageView))
      {
        RoundImageView localRoundImageView = (RoundImageView)localObject;
        String str = paramstSimpleMetaFeed.poster.avatar;
        sam.a(a(), localRoundImageView, str);
        a((ImageView)localObject, this.jdField_a_of_type_Rwm.f);
      }
      localObject = a(paramInt);
      if (localObject != null) {
        ((TextView)localObject).setText(paramstSimpleMetaFeed.poster.nick);
      }
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    super.a(paramstSimpleMetaFeed);
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    Object localObject = (StaggeredGridLayoutManager.LayoutParams)this.itemView.getLayoutParams();
    boolean bool;
    stH5OpInfo localstH5OpInfo;
    if ((paramstSimpleMetaFeed.waterFallCardStyle != null) && (paramstSimpleMetaFeed.waterFallCardStyle.isFullSpan))
    {
      bool = true;
      ((StaggeredGridLayoutManager.LayoutParams)localObject).setFullSpan(bool);
      a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, paramstSimpleMetaFeed);
      localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
      if ((localstH5OpInfo == null) || (localstH5OpInfo.id <= 0) || (localstH5OpInfo.tag == null) || (TextUtils.isEmpty(localstH5OpInfo.tag.title))) {
        break label375;
      }
      sai.a("weishi808", "h5Info:" + localstH5OpInfo);
      this.c.setText(localstH5OpInfo.tag.title);
      this.c.setBackgroundColor(Color.parseColor("#FF425A"));
      this.c.setVisibility(0);
      label160:
      sam.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, paramstSimpleMetaFeed);
      StringBuilder localStringBuilder = new StringBuilder().append("waterFallCardStyle=").append(paramstSimpleMetaFeed.waterFallCardStyle).append(", simpleMetaFeed.feedId=").append(paramstSimpleMetaFeed.id).append(", simpleMetaFeed.video_type=").append(paramstSimpleMetaFeed.video_type).append(", h5OpInfo.type=");
      if (localstH5OpInfo == null) {
        break label433;
      }
      localObject = Integer.valueOf(localstH5OpInfo.type);
      label237:
      localStringBuilder = localStringBuilder.append(localObject).append(", title='").append(paramstSimpleMetaFeed.feed_desc).append("', h5OpInfo.maskImgUrl=");
      if (localstH5OpInfo == null) {
        break label441;
      }
      localObject = localstH5OpInfo.maskImgUrl;
      label277:
      sai.a("AbsGridCardViewHolder", (String)localObject);
      if (paramstSimpleMetaFeed.video_type != 1) {
        break label464;
      }
      if ((localstH5OpInfo == null) || (localstH5OpInfo.type != 2)) {
        break label449;
      }
    }
    label433:
    label441:
    label449:
    for (int i = 8;; i = 0)
    {
      a(i);
      if ((rxf.a().a() != 2) || (localstH5OpInfo == null) || (TextUtils.isEmpty(localstH5OpInfo.maskImgUrl))) {
        break label454;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      sam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localstH5OpInfo.maskImgUrl);
      return;
      bool = false;
      break;
      label375:
      if (paramstSimpleMetaFeed.video_type == 6)
      {
        this.c.setText(ajjy.a(2131633924));
        this.c.setBackgroundColor(Color.parseColor("#FF425A"));
        this.c.setVisibility(0);
        break label160;
      }
      this.c.setVisibility(8);
      break label160;
      localObject = "h5OpInfo null";
      break label237;
      localObject = "h5OpInfo null";
      break label277;
    }
    label454:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
    return;
    label464:
    a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Rwm.jdField_a_of_type_Long < 2000L) {
      sai.d("weishi-adapter", "不要重复点击");
    }
    int i;
    stSimpleMetaFeed localstSimpleMetaFeed;
    do
    {
      return;
      this.jdField_a_of_type_Rwm.jdField_a_of_type_Long = System.currentTimeMillis();
      i = getAdapterPosition() - ((berm)this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.getAdapter()).a();
      sai.b("weishi-adapter", " ~~~~~~onClick: " + i);
      paramView = new ArrayList();
      if ((i >= this.jdField_a_of_type_Rwm.a()) || (i < 0))
      {
        sai.d("weishi-adapter", "跳转浮层发生了数组下标越界");
        return;
      }
      localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Rwm.a(i);
      if (localstSimpleMetaFeed == null)
      {
        sai.d("AbsGridCardViewHolder", "feed is null");
        return;
      }
      rzw.a(112, rzw.a(i, localstSimpleMetaFeed));
      saj.b();
      if (localstSimpleMetaFeed.video_type == 1)
      {
        this.jdField_a_of_type_Ryb.a(this.jdField_a_of_type_AndroidContentContext, localstSimpleMetaFeed, i);
        sai.b("AbsGridCardViewHolder", "点击了运营图片");
        return;
      }
      if (localstSimpleMetaFeed.video_type == 6)
      {
        this.jdField_a_of_type_Ryb.a(this.jdField_a_of_type_AndroidContentContext, i, localstSimpleMetaFeed);
        return;
      }
      rzu.a(localstSimpleMetaFeed, i, 112);
    } while (this.jdField_a_of_type_Ryb.a(this.jdField_a_of_type_AndroidContentContext, i, paramView, localstSimpleMetaFeed));
    this.jdField_a_of_type_Ryb.a(this.jdField_a_of_type_AndroidContentContext, i, paramView, localstSimpleMetaFeed);
    WSPublicAccReport.getInstance().feedsItemReport("gzh_click", sam.a(1), localstSimpleMetaFeed, rzu.a(localstSimpleMetaFeed, i), 1000001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxz
 * JD-Core Version:    0.7.0.1
 */