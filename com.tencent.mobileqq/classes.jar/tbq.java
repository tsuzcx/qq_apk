import UserGrowth.stPublisherGuide;
import UserGrowth.stPublisherRsp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

public class tbq
  extends yhq
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private stPublisherRsp jdField_a_of_type_UserGrowthStPublisherRsp;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new tbr(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private final String jdField_a_of_type_JavaLangString = "WSPublisherDialog";
  private svv jdField_a_of_type_Svv;
  private TextView b;
  
  public tbq(Context paramContext)
  {
    this(paramContext, -1, -1);
  }
  
  public tbq(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131755918, paramInt1, paramInt2);
  }
  
  protected tbq(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
    paramContext = getWindow();
    if (paramContext == null)
    {
      tlo.b("WSPublisherDialog", 2, "ScrollMoreDialog() window == null.");
      return;
    }
    paramContext = paramContext.getAttributes();
    if (paramContext == null)
    {
      tlo.b("WSPublisherDialog", 2, "ScrollMoreDialog() params == null.");
      return;
    }
    paramContext.width = paramInt2;
    paramContext.height = paramInt3;
  }
  
  private URLDrawable a(String paramString, boolean paramBoolean)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = paramBoolean;
    paramString = URLDrawable.getDrawable(svu.a(paramString), (URLDrawable.URLDrawableOptions)localObject);
    if ((paramString.getCurrDrawable() instanceof GifDrawable))
    {
      localObject = ((GifDrawable)paramString.getCurrDrawable()).getImage();
      if (paramBoolean) {
        break label54;
      }
      paramString.setIndividualPause(true);
    }
    for (;;)
    {
      ((AbstractGifImage)localObject).reset();
      return paramString;
      label54:
      paramString.setIndividualPause(false);
    }
  }
  
  private void a(Drawable paramDrawable, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
      return;
    }
    paramDrawable = a(paramString, true);
    if (paramDrawable.getStatus() == 1)
    {
      if ((paramDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)paramDrawable.getCurrDrawable()).getImage();
        if ((localAbstractGifImage instanceof svv))
        {
          this.jdField_a_of_type_Svv = ((svv)localAbstractGifImage);
          ((svv)localAbstractGifImage).a(new tbu(this, paramString));
        }
      }
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLImageView, paramDrawable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
      return;
      paramDrawable.startDownload();
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (String str = "focus";; str = "feeds")
    {
      WSPublicAccReport.getInstance().reportPublisher(paramString1, str, paramString2, paramInt);
      return;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131559865, null, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380316));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380317));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380302));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380303));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380305));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380311);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    localRelativeLayout.setOnClickListener(this);
    a("gzh_exposure", "publish_popup", 0);
  }
  
  private void c()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_UserGrowthStPublisherRsp == null) {
      return;
    }
    tlv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_UserGrowthStPublisherRsp.weishiSchema, this.jdField_a_of_type_UserGrowthStPublisherRsp.h5Url, this.jdField_a_of_type_UserGrowthStPublisherRsp.miniAppSchema, 0, new tbs(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(stPublisherRsp paramstPublisherRsp)
  {
    this.jdField_a_of_type_UserGrowthStPublisherRsp = paramstPublisherRsp;
    paramstPublisherRsp = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841378);
    if ((this.jdField_a_of_type_UserGrowthStPublisherRsp != null) && (this.jdField_a_of_type_UserGrowthStPublisherRsp.guide != null))
    {
      String str = this.jdField_a_of_type_UserGrowthStPublisherRsp.guide.imageUrl;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPublisherRsp.guide.desc);
      this.b.setText(this.jdField_a_of_type_UserGrowthStPublisherRsp.guide.btnText);
      a(paramstPublisherRsp, str);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramstPublisherRsp);
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_Svv != null) {
      this.jdField_a_of_type_Svv.a();
    }
    AbstractGifImage.pauseAll();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131380305: 
      d();
      c();
      return;
    case 2131380311: 
      a("gzh_click", "publish_popup", 1000001);
      c();
      return;
    }
    a("gzh_click", "publish_popup", 1000005);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbq
 * JD-Core Version:    0.7.0.1
 */