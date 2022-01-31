import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.VideoFeedsViewHolder.1;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.VideoFeedsViewHolder.2;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.VideoFeedsViewHolder.3;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.VideoFeedsViewHolder.4;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

public class oyo
  extends oys
  implements oyl
{
  public Handler a;
  public View a;
  public ViewGroup a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public KandianUrlImageView a;
  public ReadInJoyHeadImageView a;
  public ReadInJoyNickNameTextView a;
  public ReadInJoyVideoInfoViewGroup a;
  public VideoViewGroup a;
  public RoundAngleFrameLayout a;
  public LottieDrawable a;
  public qty a;
  public boolean a;
  public View b;
  public ViewGroup b;
  public ImageView b;
  public LinearLayout b;
  public TextView b;
  public KandianUrlImageView b;
  public View c;
  public ImageView c;
  public TextView c;
  public View d;
  public ImageView d;
  public TextView d;
  public View e;
  public ImageView e;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  
  public oyo(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public oyo(Context paramContext, oyh paramoyh)
  {
    super(paramContext, paramoyh);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private SpannableString a()
  {
    return rmc.a().b(this.jdField_f_of_type_AndroidViewView.getContext());
  }
  
  private View a()
  {
    for (View localView = this.jdField_f_of_type_AndroidViewView; (localView != null) && (!(localView instanceof ReadInJoyListViewGroup)); localView = (View)localView.getParent()) {}
    return localView;
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    ReadInJoyListViewGroup localReadInJoyListViewGroup = (ReadInJoyListViewGroup)localObject;
    localObject = new int[2];
    boolean bool;
    label85:
    int j;
    label108:
    int k;
    if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.getLocationInWindow((int[])localObject);
      if (bbct.l() - vpp.b(this.jdField_f_of_type_AndroidViewView.getContext(), 54.0F) <= localObject[1] + vpp.b(this.jdField_f_of_type_AndroidViewView.getContext(), 100.0F)) {
        break label198;
      }
      bool = true;
      if (!bool) {
        break label204;
      }
      j = localObject[1] - vpp.b(this.jdField_f_of_type_AndroidViewView.getContext(), 75.0F);
      k = j;
      if (paramBoolean) {
        k = j - vpp.b(this.jdField_f_of_type_AndroidViewView.getContext(), 15.0F);
      }
      if (!paramBoolean) {
        break label225;
      }
    }
    label198:
    label204:
    label225:
    for (localObject = a();; localObject = b())
    {
      localReadInJoyListViewGroup.a(paramBoolean, (SpannableString)localObject, bool, k, (ArticleInfo)oyh.a(this.jdField_a_of_type_Oyh, this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoHandler.VideoFeedsViewHolder.1(this, localReadInJoyListViewGroup), 5000L);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.getLocationInWindow((int[])localObject);
      break;
      bool = false;
      break label85;
      j = localObject[1] - vpp.b(this.jdField_f_of_type_AndroidViewView.getContext(), 172.0F);
      break label108;
    }
  }
  
  private SpannableString b()
  {
    return rmc.a().a(this.jdField_f_of_type_AndroidViewView.getContext());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560088, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131366181));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRoundAngleFrameLayout = ((RoundAngleFrameLayout)paramViewGroup.findViewById(2131379072));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377350));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367776));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131379004));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131361843));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131367679));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131374768));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365421));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131372105));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367900));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367899));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368515));
    if (rmc.a().b()) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oqe.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      }
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379013));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371742));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131379010));
      this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131375142);
      this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131379004);
      this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131374730);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramViewGroup.findViewById(2131368880));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131371103));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371104));
      this.g = ((TextView)paramViewGroup.findViewById(2131368849));
      this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131377400);
      this.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131377425);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131369056));
      this.h = ((TextView)paramViewGroup.findViewById(2131362045));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131368911));
      this.i = ((TextView)paramViewGroup.findViewById(2131361970));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131361969));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131366199));
      paramViewGroup.setTag(this);
      return paramViewGroup;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyBaseAdapter", 1, localException.toString());
        }
      }
    }
  }
  
  public qty a()
  {
    return this.jdField_a_of_type_Qty;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_c_of_type_AndroidWidgetImageView.invalidate();
      this.jdField_c_of_type_AndroidWidgetImageView.setScaleX(1.68F);
      this.jdField_c_of_type_AndroidWidgetImageView.setScaleY(1.68F);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(0);
      this.jdField_a_of_type_Boolean = true;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getComposition();
      long l = 1249L;
      if (localObject != null) {
        l = ((LottieComposition)localObject).getDuration();
      }
      localObject = new VideoHandler.VideoFeedsViewHolder.3(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject, l);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoHandler.VideoFeedsViewHolder.4(this), ((float)l * 0.3F));
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oqe.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
  }
  
  public void a(qty paramqty, int paramInt1, int paramInt2)
  {
    try
    {
      ArticleInfo localArticleInfo = (ArticleInfo)oyh.a(this.jdField_a_of_type_Oyh, this.jdField_a_of_type_Int);
      if (localArticleInfo == null) {
        return;
      }
      if ((paramqty != null) && (paramqty.a != null) && (paramqty.a.innerUniqueID.equals(localArticleInfo.innerUniqueID)) && (paramInt1 >= paramInt2 - 7000L) && (rmc.a().a()) && (localArticleInfo.fusionBiuInfo != null) && (!localArticleInfo.fusionBiuInfo.b))
      {
        a(true);
        return;
      }
    }
    catch (NullPointerException paramqty)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyBaseAdapter", 1, paramqty.toString());
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    BaseArticleInfo localBaseArticleInfo = oyh.a(this.jdField_a_of_type_Oyh, this.jdField_a_of_type_Int);
    if ((rmc.a().b()) && (localBaseArticleInfo.innerUniqueID.equals(paramString)) && (paramBoolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoHandler.VideoFeedsViewHolder.2(this));
      if (localBaseArticleInfo.fusionBiuInfo != null)
      {
        localBaseArticleInfo.fusionBiuInfo.a = 0L;
        localBaseArticleInfo.fusionBiuInfo.b = false;
        localBaseArticleInfo.fusionBiuInfoByte = localBaseArticleInfo.fusionBiuInfo.a();
        if ((localBaseArticleInfo instanceof ArticleInfo)) {
          osj.a().a((ArticleInfo)localBaseArticleInfo);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    BaseArticleInfo localBaseArticleInfo = oyh.a(this.jdField_a_of_type_Oyh, this.jdField_a_of_type_Int);
    if ((rmc.a().b()) && (localBaseArticleInfo.innerUniqueID != null) && (localBaseArticleInfo.innerUniqueID.equals(paramString)))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (paramInt == 3) {
          a();
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841217);
      }
      if (localBaseArticleInfo.fusionBiuInfo != null)
      {
        localBaseArticleInfo.fusionBiuInfo.a = paramLong;
        localBaseArticleInfo.fusionBiuInfo.b = paramBoolean;
        localBaseArticleInfo.fusionBiuInfoByte = localBaseArticleInfo.fusionBiuInfo.a();
        if ((localBaseArticleInfo instanceof ArticleInfo)) {
          osj.a().a((ArticleInfo)localBaseArticleInfo);
        }
      }
    }
  }
  
  public boolean a(View paramView)
  {
    if (!qol.a(oyh.a(this.jdField_a_of_type_Oyh, paramView))) {}
    while (omu.a(paramView) < 80.0F) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyo
 * JD-Core Version:    0.7.0.1
 */