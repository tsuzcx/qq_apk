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

public class tax
  extends ydh
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
  
  public tax(Context paramContext)
  {
    this(paramContext, -1, -1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private tax(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131755918, paramInt1, paramInt2);
  }
  
  private tax(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 3;
    b();
    paramContext = getWindow();
    if (paramContext == null)
    {
      tlo.b("RichBlockDialog", 2, "ScrollMoreDialog() window == null.");
      return;
    }
    paramContext = paramContext.getAttributes();
    if (paramContext == null)
    {
      tlo.b("RichBlockDialog", 2, "ScrollMoreDialog() params == null.");
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
      tlo.a("RichBlockDialog", 1, "点击时间小于1.5秒，不做响应");
      return;
    }
    this.jdField_a_of_type_Long = l;
    Context localContext;
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button != null))
    {
      tju.c(112, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      tjr.a(112, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      localContext = getContext();
      if (!(localContext instanceof ContextThemeWrapper)) {
        break label164;
      }
      localContext = ((ContextThemeWrapper)localContext).getBaseContext();
    }
    label164:
    for (;;)
    {
      String str1 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.schema_url;
      String str2 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.h5url;
      tlv.a(this.jdField_a_of_type_AndroidContentContext, str1, str2, "", this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, new tay(this, localContext));
      d();
      return;
    }
  }
  
  private void a(URLDrawable paramURLDrawable, String paramString, ImageView paramImageView)
  {
    if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title);
      }
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 1) {
        break label282;
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
      tju.c(6, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      tjr.a(6, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      WSPublicAccReport.getInstance().reportExposeRichBlockPop(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.trace_id);
      a();
      tlo.a("813", "onLoadSuccessed - " + paramString);
      return;
      label282:
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money + "");
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562400, null, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375109));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375113));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375110));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375112));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375111));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375107));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375106));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375114));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.f.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      tlo.a("weishi-813", "展示图片");
      return;
    }
    tlo.a("weishi-813", "展示红包");
  }
  
  private void d()
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
      tlo.a("weishi-813", "阻断页rich化 type是：" + paramstGlobalConfig.type);
    }
    for (;;)
    {
      c();
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
      tlo.a("weishi-813", "阻断页rich化 windowsConfig为null");
      continue;
      label129:
      tlo.c("weishi-813", "瀑布流阻断页rich化 windowsConfig size为0");
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig == null) || (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 2))
    {
      tlo.a("RichBlockDialog", "813不支持瀑布流红包和动图弹窗");
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url))
    {
      paramContext = getContext().getResources().getDrawable(2130841377);
      a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url, paramContext, paramContext, alpo.a(2131713827));
      return;
    }
    d();
  }
  
  public void a(ImageView paramImageView, String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
  {
    tfd.a(3);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = paramDrawable1;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable2;
    paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    paramString1.setURLDrawableListener(new taz(this, paramString2, paramImageView));
    paramImageView.setImageDrawable(paramString1);
    paramString1.startDownload();
    if (1 != paramString1.getStatus())
    {
      paramString1.restartDownload();
      return;
    }
    a(paramString1, paramString2, paramImageView);
    tlo.a("813", "onLoad ~~~~~~");
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void dismiss()
  {
    tlo.b("RichBlockDialog", 2, "dismiss()");
    try
    {
      this.jdField_a_of_type_Boolean = false;
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      tlo.d("RichBlockDialog", 2, localException.getLocalizedMessage());
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
      case 2131375108: 
      default: 
        return;
      case 2131375106: 
        tlo.a("weishi-813", "点击了红包 提现");
        a(1);
        return;
      case 2131375107: 
        d();
      }
    } while (this.jdField_a_of_type_UserGrowthStPopWindowsConfig == null);
    tju.c(117, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
    tjr.a(117, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000005, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.trace_id);
    return;
    tlo.a("weishi-813", "点击了图片 背景图");
    a(2);
  }
  
  public void show()
  {
    tlo.b("RichBlockDialog", 2, "show()");
    try
    {
      super.show();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      tlo.d("RichBlockDialog", 2, localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tax
 * JD-Core Version:    0.7.0.1
 */