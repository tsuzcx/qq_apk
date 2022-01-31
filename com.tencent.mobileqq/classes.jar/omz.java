import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

public class omz
  extends ond
  implements omw
{
  public Handler a;
  public View a;
  public ViewGroup a;
  public FrameLayout a;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public KandianUrlImageView a;
  public ReadInJoyHeadImageView a;
  public ReadInJoyNickNameTextView a;
  public ReadInJoyVideoInfoViewGroup a;
  public VideoViewGroup a;
  public LottieDrawable a;
  public qht a;
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
  
  public omz(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public omz(Context paramContext, oms paramoms)
  {
    super(paramContext, paramoms);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private SpannableString a()
  {
    return qzk.a().b(this.jdField_f_of_type_AndroidViewView.getContext());
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
      if (babp.l() - vct.a(this.jdField_f_of_type_AndroidViewView.getContext(), 54.0F) <= localObject[1] + vct.a(this.jdField_f_of_type_AndroidViewView.getContext(), 100.0F)) {
        break label198;
      }
      bool = true;
      if (!bool) {
        break label204;
      }
      j = localObject[1] - vct.a(this.jdField_f_of_type_AndroidViewView.getContext(), 75.0F);
      k = j;
      if (paramBoolean) {
        k = j - vct.a(this.jdField_f_of_type_AndroidViewView.getContext(), 15.0F);
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
      localReadInJoyListViewGroup.a(paramBoolean, (SpannableString)localObject, bool, k, (ArticleInfo)oms.a(this.jdField_a_of_type_Oms, this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoHandler.VideoFeedsViewHolder.1(this, localReadInJoyListViewGroup), 5000L);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.getLocationInWindow((int[])localObject);
      break;
      bool = false;
      break label85;
      j = localObject[1] - vct.a(this.jdField_f_of_type_AndroidViewView.getContext(), 172.0F);
      break label108;
    }
  }
  
  private SpannableString b()
  {
    return qzk.a().a(this.jdField_f_of_type_AndroidViewView.getContext());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494516, paramViewGroup, false);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131300579));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131313236));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131311534));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131302158));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131313169));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131296307));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131302061));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131309027));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131299841));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131306408));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302280));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302279));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302891));
    if (qzk.a().b()) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oet.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      }
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131313178));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131306045));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131313175));
      this.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131309395);
      this.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131313169);
      this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131308989);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramViewGroup.findViewById(2131303214));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131305410));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131305411));
      this.g = ((TextView)paramViewGroup.findViewById(2131303181));
      this.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131311586);
      this.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131311612);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131303389));
      this.h = ((TextView)paramViewGroup.findViewById(2131296504));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131303244));
      this.i = ((TextView)paramViewGroup.findViewById(2131296428));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296427));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131300597));
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
  
  public qht a()
  {
    return this.jdField_a_of_type_Qht;
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
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oet.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
  }
  
  public void a(qht paramqht, int paramInt1, int paramInt2)
  {
    try
    {
      ArticleInfo localArticleInfo = (ArticleInfo)oms.a(this.jdField_a_of_type_Oms, this.jdField_a_of_type_Int);
      if (localArticleInfo == null) {
        return;
      }
      if ((paramqht != null) && (paramqht.a != null) && (paramqht.a.innerUniqueID.equals(localArticleInfo.innerUniqueID)) && (paramInt1 >= paramInt2 - 7000L) && (qzk.a().a()) && (localArticleInfo.fusionBiuInfo != null) && (!localArticleInfo.fusionBiuInfo.b))
      {
        a(true);
        return;
      }
    }
    catch (NullPointerException paramqht)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyBaseAdapter", 1, paramqht.toString());
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    BaseArticleInfo localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, this.jdField_a_of_type_Int);
    if ((qzk.a().b()) && (localBaseArticleInfo.innerUniqueID.equals(paramString)) && (paramBoolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoHandler.VideoFeedsViewHolder.2(this));
      if (localBaseArticleInfo.fusionBiuInfo != null)
      {
        localBaseArticleInfo.fusionBiuInfo.a = 0L;
        localBaseArticleInfo.fusionBiuInfo.b = false;
        localBaseArticleInfo.fusionBiuInfoByte = localBaseArticleInfo.fusionBiuInfo.a();
        if ((localBaseArticleInfo instanceof ArticleInfo)) {
          ogy.a().a((ArticleInfo)localBaseArticleInfo);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    BaseArticleInfo localBaseArticleInfo = oms.a(this.jdField_a_of_type_Oms, this.jdField_a_of_type_Int);
    if ((qzk.a().b()) && (localBaseArticleInfo.innerUniqueID != null) && (localBaseArticleInfo.innerUniqueID.equals(paramString)))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (paramInt == 3) {
          a();
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841140);
      }
      if (localBaseArticleInfo.fusionBiuInfo != null)
      {
        localBaseArticleInfo.fusionBiuInfo.a = paramLong;
        localBaseArticleInfo.fusionBiuInfo.b = paramBoolean;
        localBaseArticleInfo.fusionBiuInfoByte = localBaseArticleInfo.fusionBiuInfo.a();
        if ((localBaseArticleInfo instanceof ArticleInfo)) {
          ogy.a().a((ArticleInfo)localBaseArticleInfo);
        }
      }
    }
  }
  
  public boolean a(View paramView)
  {
    if (!qcn.a(oms.a(this.jdField_a_of_type_Oms, paramView))) {}
    while (obj.a(paramView) < 80.0F) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omz
 * JD-Core Version:    0.7.0.1
 */