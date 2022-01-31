import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stVideoTag;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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

public abstract class tfj
  extends biac<stSimpleMetaFeed>
  implements View.OnClickListener, tfu
{
  private Context jdField_a_of_type_AndroidContentContext = a();
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private final RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private RecyclerViewWithHeaderFooter jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter;
  private tby jdField_a_of_type_Tby;
  private tft jdField_a_of_type_Tft = new tfw(this);
  private final ImageView jdField_b_of_type_AndroidWidgetImageView;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private final TextView c;
  
  public tfj(@NonNull ViewGroup paramViewGroup, @NonNull tby paramtby, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_Tby = paramtby;
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = paramtby.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)b(2131368709));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)b(2131378627));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)b(2131368710));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)b(2131378628));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)b(2131367291));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)b(2131367294));
    this.c = ((TextView)b(2131377208));
    this.itemView.setOnClickListener(this);
    a();
  }
  
  private int a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    float f1 = 1.333333F;
    int j = this.jdField_a_of_type_Tby.d;
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
  
  private void a(stVideoTag paramstVideoTag)
  {
    if ((paramstVideoTag == null) || (TextUtils.isEmpty(paramstVideoTag.text)))
    {
      this.c.setVisibility(8);
      return;
    }
    String str1;
    String str2;
    label78:
    GradientDrawable localGradientDrawable;
    if ((!TextUtils.isEmpty(paramstVideoTag.textColor)) && (paramstVideoTag.textColor.startsWith("#")))
    {
      str1 = paramstVideoTag.textColor;
      if ((TextUtils.isEmpty(paramstVideoTag.bgColor)) || (!paramstVideoTag.bgColor.startsWith("#"))) {
        break label187;
      }
      str2 = paramstVideoTag.bgColor;
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(tlu.a);
      if (!tlu.a(str2)) {
        break label213;
      }
      label103:
      localGradientDrawable.setColor(Color.parseColor(str2));
      this.c.setText(paramstVideoTag.text);
      paramstVideoTag = this.c;
      if (!tlu.a(str1)) {
        break label219;
      }
    }
    for (;;)
    {
      paramstVideoTag.setTextColor(Color.parseColor(str1));
      this.c.setBackgroundDrawable(localGradientDrawable);
      this.c.setVisibility(0);
      return;
      str1 = "#" + paramstVideoTag.textColor;
      break;
      label187:
      str2 = "#" + paramstVideoTag.bgColor;
      break label78;
      label213:
      str2 = "#80000000";
      break label103;
      label219:
      str1 = "#FFFFFF";
    }
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
    paramRoundCornerImageView.setCorner(this.jdField_a_of_type_Tby.e);
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
      i = 2131379794;
      localViewStub = (ViewStub)b(i);
      if (paramInt == 0) {
        break label51;
      }
    }
    label45:
    label51:
    for (paramInt = 2131560230;; paramInt = 2131560229)
    {
      localViewStub.setLayoutResource(paramInt);
      return localViewStub.inflate();
      paramInt = 0;
      break;
      i = 2131379793;
      break label14;
    }
  }
  
  public tby a()
  {
    return this.jdField_a_of_type_Tby;
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
    ImageView localImageView = a(paramInt1);
    int i;
    if (paramInt2 == 1)
    {
      i = paramstSimpleMetaFeed.playNum;
      if (localImageView != null)
      {
        if (i <= 0) {
          break label107;
        }
        localImageView.setVisibility(0);
        if (paramInt2 != 1) {
          break label100;
        }
        paramInt2 = 2130842758;
        label42:
        localImageView.setImageResource(paramInt2);
        a(localImageView, this.jdField_a_of_type_Tby.g);
      }
    }
    for (;;)
    {
      paramstSimpleMetaFeed = a(paramInt1);
      if (paramstSimpleMetaFeed != null)
      {
        if (i <= 0) {
          break label117;
        }
        paramstSimpleMetaFeed.setVisibility(0);
        rdm.a(paramstSimpleMetaFeed, i, "0");
      }
      return;
      i = paramstSimpleMetaFeed.ding_count;
      break;
      label100:
      paramInt2 = 2130846151;
      break label42;
      label107:
      localImageView.setVisibility(8);
    }
    label117:
    paramstSimpleMetaFeed.setVisibility(8);
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
        tlv.a(a(), localRoundImageView, str);
        a((ImageView)localObject, this.jdField_a_of_type_Tby.f);
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
      a(paramstSimpleMetaFeed.videoTag);
      tlv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, paramstSimpleMetaFeed, true);
      localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
      StringBuilder localStringBuilder = new StringBuilder().append("waterFallCardStyle=").append(paramstSimpleMetaFeed.waterFallCardStyle).append(", simpleMetaFeed.feedId=").append(paramstSimpleMetaFeed.id).append(", simpleMetaFeed.video_type=").append(paramstSimpleMetaFeed.video_type).append(", videoTag.tagId=");
      if (paramstSimpleMetaFeed.videoTag == null) {
        break label413;
      }
      localObject = Integer.valueOf(paramstSimpleMetaFeed.videoTag.tagId);
      label152:
      localStringBuilder = localStringBuilder.append(localObject).append(", videoTag.text=");
      if (paramstSimpleMetaFeed.videoTag == null) {
        break label421;
      }
      localObject = paramstSimpleMetaFeed.videoTag.text;
      label183:
      localStringBuilder = localStringBuilder.append((String)localObject).append(", videoTag.textColor=");
      if (paramstSimpleMetaFeed.videoTag == null) {
        break label429;
      }
      localObject = paramstSimpleMetaFeed.videoTag.textColor;
      label214:
      localStringBuilder = localStringBuilder.append((String)localObject).append(", videoTag.bgColor=");
      if (paramstSimpleMetaFeed.videoTag == null) {
        break label437;
      }
      localObject = paramstSimpleMetaFeed.videoTag.bgColor;
      label245:
      localStringBuilder = localStringBuilder.append((String)localObject).append(", h5OpInfo.type=");
      if (localstH5OpInfo == null) {
        break label445;
      }
      localObject = Integer.valueOf(localstH5OpInfo.type);
      label275:
      localStringBuilder = localStringBuilder.append(localObject).append(", title='").append(paramstSimpleMetaFeed.feed_desc).append("', h5OpInfo.maskImgUrl=");
      if (localstH5OpInfo == null) {
        break label453;
      }
      localObject = localstH5OpInfo.maskImgUrl;
      label315:
      tlo.a("AbsGridCardViewHolder", (String)localObject);
      if (paramstSimpleMetaFeed.video_type != 1) {
        break label476;
      }
      if ((localstH5OpInfo == null) || (localstH5OpInfo.type != 2)) {
        break label461;
      }
    }
    label413:
    label421:
    label429:
    label437:
    label445:
    label453:
    label461:
    for (int i = 8;; i = 0)
    {
      a(i);
      if ((tee.a().a() != 2) || (localstH5OpInfo == null) || (TextUtils.isEmpty(localstH5OpInfo.maskImgUrl))) {
        break label466;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      tlv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localstH5OpInfo.maskImgUrl);
      return;
      bool = false;
      break;
      localObject = "";
      break label152;
      localObject = "";
      break label183;
      localObject = "";
      break label214;
      localObject = "";
      break label245;
      localObject = "h5OpInfo null";
      break label275;
      localObject = "h5OpInfo null";
      break label315;
    }
    label466:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
    return;
    label476:
    a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Tby.jdField_a_of_type_Long < 2000L) {
      tlo.d("weishi-adapter", "不要重复点击");
    }
    int i;
    stSimpleMetaFeed localstSimpleMetaFeed;
    do
    {
      return;
      this.jdField_a_of_type_Tby.jdField_a_of_type_Long = System.currentTimeMillis();
      i = getAdapterPosition() - ((biau)this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.getAdapter()).a();
      tlo.b("weishi-adapter", " ~~~~~~onClick: " + i);
      paramView = new ArrayList();
      if ((i >= this.jdField_a_of_type_Tby.b()) || (i < 0))
      {
        tlo.d("weishi-adapter", "跳转浮层发生了数组下标越界");
        return;
      }
      localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Tby.a(i);
      if (localstSimpleMetaFeed == null)
      {
        tlo.d("AbsGridCardViewHolder", "feed is null");
        return;
      }
      tju.a(112, tju.a(i, localstSimpleMetaFeed));
      tlp.b();
      if (localstSimpleMetaFeed.video_type == 1)
      {
        this.jdField_a_of_type_Tft.a(this.jdField_a_of_type_AndroidContentContext, localstSimpleMetaFeed, i);
        tlo.b("AbsGridCardViewHolder", "点击了运营图片");
        return;
      }
      if (localstSimpleMetaFeed.video_type == 6)
      {
        this.jdField_a_of_type_Tft.a(this.jdField_a_of_type_AndroidContentContext, i, localstSimpleMetaFeed);
        return;
      }
      tjr.a(localstSimpleMetaFeed, i, 112);
    } while (this.jdField_a_of_type_Tft.a(this.jdField_a_of_type_AndroidContentContext, i, paramView, localstSimpleMetaFeed));
    this.jdField_a_of_type_Tft.a(this.jdField_a_of_type_AndroidContentContext, i, paramView, localstSimpleMetaFeed);
    WSPublicAccReport.getInstance().feedsItemReport("gzh_click", tlv.a(1), localstSimpleMetaFeed, tjr.a(localstSimpleMetaFeed, i), 1000001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tfj
 * JD-Core Version:    0.7.0.1
 */