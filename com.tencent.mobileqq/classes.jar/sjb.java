import UserGrowth.stAnnexation;
import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsButton;
import UserGrowth.stPopWindowsConfig;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.ArrayList;

public class sjb
  extends wov
  implements View.OnClickListener
{
  public final int a;
  private long jdField_a_of_type_Long;
  private stGlobalConfig jdField_a_of_type_UserGrowthStGlobalConfig;
  public stPopWindowsConfig a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final String jdField_a_of_type_JavaLangString = "RichBlockDialog";
  private boolean jdField_a_of_type_Boolean;
  public final int b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "weishi://main";
  public final int c;
  private TextView c;
  private int jdField_d_of_type_Int = 12;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int jdField_e_of_type_Int = 5;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private TextView f;
  
  public sjb(Context paramContext)
  {
    this(paramContext, -1, -1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private sjb(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131755901, paramInt1, paramInt2);
  }
  
  private sjb(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 3;
    c();
    paramContext = getWindow();
    if (paramContext == null)
    {
      sne.b("RichBlockDialog", 2, "ScrollMoreDialog() window == null.");
      return;
    }
    paramContext = paramContext.getAttributes();
    if (paramContext == null)
    {
      sne.b("RichBlockDialog", 2, "ScrollMoreDialog() params == null.");
      return;
    }
    paramContext.width = paramInt2;
    paramContext.height = paramInt3;
  }
  
  private int a()
  {
    switch (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type)
    {
    case 1: 
    default: 
      return 6;
    case 2: 
      return 401;
    }
    return 7;
  }
  
  private String a(int paramInt)
  {
    String str2 = String.format("%.3f", new Object[] { Double.valueOf(paramInt / 100.0D) });
    String str1 = str2;
    if (str2.indexOf(".") > 0) {
      str1 = str2.replaceAll("0+?$", "").replaceAll("[.]$", "");
    }
    return str1;
  }
  
  private void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1500L)
    {
      sne.a("RichBlockDialog", 1, "点击时间小于1.5秒，不做响应");
      return;
    }
    this.jdField_a_of_type_Long = l;
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button != null))
    {
      sms.c(112, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      smq.a(112, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      Object localObject2 = getContext();
      Object localObject1 = localObject2;
      if ((localObject2 instanceof ContextThemeWrapper)) {
        localObject1 = ((ContextThemeWrapper)localObject2).getBaseContext();
      }
      localObject2 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.schema_url;
      String str = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.h5url;
      sni.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, str, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, new sjc(this, (Context)localObject1));
    }
    e();
  }
  
  private void a(URLDrawable paramURLDrawable, String paramString, ImageView paramImageView)
  {
    if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title);
      }
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 1) {
        break label275;
      }
      if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money > 0))
      {
        paramURLDrawable = a(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramURLDrawable);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button.title))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button.title);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.text)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.text);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.remark)) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.remark);
      }
      show();
      sms.c(6, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      smq.a(6, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      WSPublicAccReport.getInstance().reportExposeRichBlockPop(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      a();
      sne.a("813", "onLoadSuccessed - " + paramString);
      return;
      label275:
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money + "");
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562209, null, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374649));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374653));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374650));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374652));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374651));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374647));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374646));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374654));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.f.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      sne.a("weishi-813", "展示图片");
      return;
    }
    sne.a("weishi-813", "展示红包");
  }
  
  private void e()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  public void a() {}
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    a();
    if (paramstGlobalConfig != null)
    {
      this.jdField_a_of_type_UserGrowthStGlobalConfig = paramstGlobalConfig;
      if ((paramstGlobalConfig.windows_config == null) || (paramstGlobalConfig.windows_config.size() <= 0)) {
        break label129;
      }
      paramstGlobalConfig = (stPopWindowsConfig)paramstGlobalConfig.windows_config.get(0);
      if (paramstGlobalConfig == null) {
        break label117;
      }
      if (paramstGlobalConfig.type != 1) {
        break label93;
      }
      this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
      sne.a("weishi-813", "阻断页rich化 type是：" + paramstGlobalConfig.type);
    }
    for (;;)
    {
      d();
      return;
      label93:
      if (paramstGlobalConfig.type == 2)
      {
        this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
        break;
      }
      this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
      break;
      label117:
      sne.a("weishi-813", "阻断页rich化 windowsConfig为null");
      continue;
      label129:
      sne.c("weishi-813", "瀑布流阻断页rich化 windowsConfig size为0");
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig == null) || (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 2))
    {
      sne.a("RichBlockDialog", "813不支持瀑布流红包和动图弹窗");
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url))
    {
      paramContext = getContext().getResources().getDrawable(2130841262);
      a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url, paramContext, paramContext, ajyc.a(2131713444));
      return;
    }
    e();
  }
  
  public void a(ImageView paramImageView, String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
  {
    skt.a(3);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = paramDrawable1;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable2;
    paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    paramString1.setURLDrawableListener(new sjd(this, paramString2, paramImageView));
    paramImageView.setImageDrawable(paramString1);
    paramString1.startDownload();
    if (1 != paramString1.getStatus())
    {
      paramString1.restartDownload();
      return;
    }
    a(paramString1, paramString2, paramImageView);
    sne.a("813", "onLoad ~~~~~~");
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void dismiss()
  {
    sne.b("RichBlockDialog", 2, "dismiss()");
    try
    {
      this.jdField_a_of_type_Boolean = false;
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      sne.d("RichBlockDialog", 2, localException.getLocalizedMessage());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      case 2131374648: 
      default: 
        return;
      case 2131374646: 
        sne.a("weishi-813", "点击了红包 提现");
        a(1);
        return;
      case 2131374647: 
        e();
      }
    } while (this.jdField_a_of_type_UserGrowthStPopWindowsConfig == null);
    sms.c(117, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
    smq.a(117, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000005, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
    return;
    sne.a("weishi-813", "点击了图片 背景图");
    a(2);
  }
  
  public void show()
  {
    sne.b("RichBlockDialog", 2, "show()");
    try
    {
      super.show();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      sne.d("RichBlockDialog", 2, localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjb
 * JD-Core Version:    0.7.0.1
 */