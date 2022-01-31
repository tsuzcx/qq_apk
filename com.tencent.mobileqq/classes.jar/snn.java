import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import mqq.app.NewIntent;

public class snn
  extends BaseAdapter
  implements View.OnClickListener
{
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int = 0;
  private akwr jdField_a_of_type_Akwr;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private LruCache<String, URL> jdField_a_of_type_AndroidUtilLruCache;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private PublicAccountImageCollectionListView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString = "";
  public ArrayList<soy> a;
  private sod jdField_a_of_type_Sod = new sno(this);
  private sop jdField_a_of_type_Sop;
  private sow jdField_a_of_type_Sow;
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  String jdField_b_of_type_JavaLangString = "";
  private ArrayList<soz> jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean = false;
  final int jdField_c_of_type_Int = 2;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  
  public snn(Context paramContext, PublicAccountImageCollectionListView paramPublicAccountImageCollectionListView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView = paramPublicAccountImageCollectionListView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.a(this.jdField_a_of_type_Sod);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getResources().getDisplayMetrics().density;
    if (a()) {}
    for (this.jdField_e_of_type_Int = (a()[1] - a());; this.jdField_e_of_type_Int = a()[1])
    {
      this.jdField_f_of_type_Int = a()[0];
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setScreenHeight(this.jdField_e_of_type_Int);
      this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(15);
      a(paramContext);
      return;
    }
  }
  
  private int a()
  {
    Resources localResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
    return localResources.getDimensionPixelSize(localResources.getIdentifier("status_bar_height", "dimen", "android"));
  }
  
  private void a(ZImageView paramZImageView, rph paramrph, ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
    if ((paramrph == null) || (paramrph.jdField_a_of_type_JavaNetURL == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url is empty! use default preload image");
      }
      paramZImageView.setImageDrawable(localColorDrawable);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url = " + paramrph.jdField_a_of_type_JavaNetURL + " reqWidth = " + paramrph.jdField_a_of_type_Int + " reqHeight = " + paramrph.jdField_b_of_type_Int);
    }
    if (ayoi.a(paramrph.jdField_a_of_type_JavaNetURL.toString()) != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        PublicAccountImageCollectionPreloadManager.a().a(true, paramInt);
      }
      for (;;)
      {
        long l = NetConnInfoCenter.getServerTimeMillis();
        paramZImageView.a(localColorDrawable).a(paramrph, new snt(this, bool, l, paramImageProgressCircle));
        return;
        PublicAccountImageCollectionPreloadManager.a().a(false, paramInt);
      }
    }
  }
  
  private void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  private void a(ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    if (paramImageProgressCircle.getVisibility() != 0) {
      paramImageProgressCircle.setVisibility(0);
    }
    paramImageProgressCircle.setProgress(paramInt / 100);
  }
  
  private boolean a()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  private int[] a()
  {
    int[] arrayOfInt = new int[2];
    Display localDisplay = this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localDisplay, new Object[] { localDisplayMetrics });
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfInt;
  }
  
  private void b(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695615));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841198));
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label24;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    label24:
    while ((TextUtils.isEmpty(this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString.equals("0"))) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839026));
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695616));
  }
  
  private void g()
  {
    int j = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getLastVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getFirstVisiblePosition();
    int i = 0;
    if (i <= j - k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getChildAt(i);
      if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof snv)))
      {
        localObject = (snv)((View)localObject).getTag();
        if (((snv)localObject).jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          break label97;
        }
        this.jdField_f_of_type_Boolean = false;
        ((snv)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        label97:
        this.jdField_f_of_type_Boolean = true;
        ((snv)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    if (this.jdField_f_of_type_Boolean)
    {
      d(true);
      return;
    }
    nol.a(null, this.jdField_c_of_type_JavaLangString, "0X8007B92", "0X8007B92", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", false);
    d(false);
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) || (!(this.jdField_b_of_type_AndroidViewView.getTag() instanceof snv))) {}
    Intent localIntent;
    Object localObject;
    float[] arrayOfFloat;
    String str;
    int i;
    int j;
    int k;
    int m;
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.a(this.jdField_b_of_type_AndroidViewView).booleanValue());
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountImageCollectionActivity.class);
        localObject = ((ZImageView)((ViewGroup)this.jdField_b_of_type_AndroidViewView).getChildAt(0)).getImageMatrix();
        arrayOfFloat = new float[9];
        ((Matrix)localObject).getValues(arrayOfFloat);
      } while (this.jdField_a_of_type_JavaUtilArrayList == null);
      localObject = (soy)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_d_of_type_Int - 1);
      str = ((soy)localObject).jdField_a_of_type_JavaLangString;
      i = a(localObject)[0];
      j = a(localObject)[1];
      ZImageView localZImageView = (ZImageView)((ViewGroup)this.jdField_b_of_type_AndroidViewView).getChildAt(0);
      k = localZImageView.getWidth();
      m = localZImageView.getHeight();
    } while (TextUtils.isEmpty(str));
    localIntent.putExtra("doubleBitMapPath", str);
    localIntent.putExtra("urlImageHeight", j);
    localIntent.putExtra("urlImageWidth", i);
    localIntent.putExtra("urlImageWidthReal", k);
    localIntent.putExtra("urlImageHeightReal", m);
    localIntent.putExtra("imageMatrix", arrayOfFloat);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    nol.a(null, this.jdField_c_of_type_JavaLangString, "0X8007B91", "0X8007B91", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, ((soy)localObject).jdField_a_of_type_JavaLangString, "2", false);
  }
  
  public URL a(String paramString)
  {
    URL localURL2 = (URL)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    Object localObject2 = localURL2;
    if (localURL2 == null) {}
    try
    {
      URL localURL1 = new URL(paramString);
      localObject2 = localURL2;
      if (localURL1 != null)
      {
        this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localURL1);
        localObject2 = localURL1;
      }
      return localObject2;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionAdapter", 2, "getURLPath ERROR e = " + localMalformedURLException.getMessage());
        }
        Object localObject1 = null;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
    if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
      this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
    }
    if (this.jdField_a_of_type_Sod != null) {
      this.jdField_a_of_type_Sod = null;
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akwr);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    String str;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      str = "" + paramInt;
      if (paramInt <= 1000000) {
        break label77;
      }
      str = "100万+";
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131708782) + str);
      return;
      label77:
      if (paramInt > 100000)
      {
        double d1 = paramInt / 100000.0D;
        str = new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString() + ajya.a(2131708805);
      }
    }
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new snw(this, null));
  }
  
  void a(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "showMoreDescription");
    }
    paramView = (TextView)paramView;
    if (!this.jdField_e_of_type_Boolean)
    {
      paramView.setMaxLines(2147483647);
      paramView.setEllipsize(null);
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    paramView.setMaxLines(3);
    paramView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList<soz> paramArrayList)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setRecommendItemInfos is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setRecommendItemInfos size = " + paramArrayList.size());
    }
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setRecommendInfo(this.jdField_b_of_type_JavaUtilArrayList);
  }
  
  void a(snu paramsnu)
  {
    if (this.jdField_a_of_type_Sow == null)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover getPhotoCollectionInfo error");
        }
        paramsnu.f.setVisibility(0);
        a(paramsnu.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
        ((PublicAccountImageCollectionMainActivity)this.jdField_a_of_type_AndroidAppActivity).g();
        return;
      }
      paramsnu.f.setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_Sow.jdField_a_of_type_Sox != null) && (QLog.isColorLevel())) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover title =" + this.jdField_a_of_type_Sow.e + "; coverUrl =" + this.jdField_a_of_type_Sow.jdField_a_of_type_Sox.jdField_a_of_type_JavaLangString + "; accountName = " + this.jdField_a_of_type_Sow.jdField_a_of_type_Sox.jdField_b_of_type_JavaLangString + "; author=" + this.jdField_a_of_type_Sow.jdField_a_of_type_Sox.d + "; time =" + this.jdField_a_of_type_Sow.jdField_a_of_type_Sox.jdField_c_of_type_JavaLangString);
    }
    paramsnu.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramsnu.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Sow.e);
    Object localObject = "" + this.jdField_g_of_type_Int;
    if (this.jdField_g_of_type_Int > 1000000)
    {
      localObject = "100万+";
      paramsnu.e.setText(ajya.a(2131708772) + (String)localObject);
      localObject = this.jdField_a_of_type_Sow.jdField_a_of_type_Sox;
      if (localObject != null)
      {
        paramsnu.d.setText(((sox)localObject).jdField_b_of_type_JavaLangString);
        paramsnu.b.setText(((sox)localObject).d);
        paramsnu.c.setText(((sox)localObject).jdField_c_of_type_JavaLangString);
        if (TextUtils.isEmpty(((sox)localObject).jdField_b_of_type_JavaLangString)) {
          break label636;
        }
        paramsnu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramsnu.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString));
      }
    }
    for (;;)
    {
      rph localrph = new rph();
      localrph.jdField_a_of_type_JavaNetURL = a(((sox)localObject).jdField_a_of_type_JavaLangString);
      a(paramsnu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView, localrph, paramsnu.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, 0);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString.equals("0")))
      {
        new RelativeLayout.LayoutParams(-1, -1).setMargins(actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
        paramsnu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramsnu.e.setTextSize(2, 14.0F);
        paramsnu.d.setVisibility(8);
        paramsnu.b.setTextSize(2, 14.0F);
        paramsnu.c.setTextSize(2, 14.0F);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      }
      if (!this.jdField_b_of_type_Boolean) {
        ((PublicAccountImageCollectionMainActivity)this.jdField_a_of_type_AndroidAppActivity).h();
      }
      this.jdField_b_of_type_Boolean = true;
      return;
      if (this.jdField_g_of_type_Int <= 100000) {
        break;
      }
      double d1 = this.jdField_g_of_type_Int / 100000.0D;
      localObject = new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString() + ajya.a(2131708823);
      break;
      label636:
      paramsnu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  void a(snv paramsnv, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageFeeds mPhotoItemInfo is null");
      }
    }
    soy localsoy;
    int i;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    ViewGroup.LayoutParams localLayoutParams1;
    URL localURL;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt < 1) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size()));
        localsoy = (soy)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
      } while ((localsoy == null) || (localsoy.jdField_a_of_type_Int == 0) || (this.jdField_f_of_type_Int == 0));
      if (localsoy.jdField_b_of_type_Int / localsoy.jdField_a_of_type_Int <= this.jdField_e_of_type_Int / this.jdField_f_of_type_Int) {
        break;
      }
      i = this.jdField_e_of_type_Int;
      localsoy.jdField_a_of_type_Boolean = true;
      localObject = (RelativeLayout.LayoutParams)paramsnv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)paramsnv.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams1 = paramsnv.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.jdField_f_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).height = i;
      paramsnv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localURL = a(localsoy.jdField_a_of_type_JavaLangString);
    } while (localURL == null);
    rph localrph = new rph();
    localrph.jdField_a_of_type_JavaNetURL = localURL;
    localrph.jdField_a_of_type_Int = a(localsoy)[0];
    localrph.jdField_b_of_type_Int = a(localsoy)[1];
    a(paramsnv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView, localrph, paramsnv.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramsnv.jdField_a_of_type_Int);
    int j;
    if ((localsoy.jdField_a_of_type_Int / localsoy.jdField_b_of_type_Int > 1.3D) && (!TextUtils.isEmpty(localsoy.jdField_b_of_type_JavaLangString)) && (!localsoy.jdField_b_of_type_JavaLangString.equals(" ")))
    {
      j = 1;
      label290:
      if (j == 0) {
        break label594;
      }
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setMinHeight(actj.a(97.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams1.height = (((RelativeLayout.LayoutParams)localObject).height + actj.a(97.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      label348:
      if (i <= this.jdField_e_of_type_Int - (int)(88.0F * this.jdField_a_of_type_Float)) {
        break label616;
      }
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)(15.0F * this.jdField_a_of_type_Float), (int)(10.0F * this.jdField_a_of_type_Float), (int)(15.0F * this.jdField_a_of_type_Float), (int)(44.0F * this.jdField_a_of_type_Float));
      label409:
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      paramsnv.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams1);
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(3);
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
      localObject = paramInt + "/" + this.jdField_a_of_type_JavaUtilArrayList.size() + "  " + localsoy.jdField_b_of_type_JavaLangString;
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if ((!TextUtils.isEmpty(localsoy.jdField_b_of_type_JavaLangString)) && (!localsoy.jdField_b_of_type_JavaLangString.equals(" "))) {
        break label662;
      }
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(0);
      label536:
      if (this.jdField_f_of_type_Boolean) {
        break label678;
      }
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new snq(this));
      return;
      i = this.jdField_f_of_type_Int * localsoy.jdField_b_of_type_Int / localsoy.jdField_a_of_type_Int;
      break;
      j = 0;
      break label290;
      label594:
      localLayoutParams1.height = ((RelativeLayout.LayoutParams)localObject).height;
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
      break label348;
      label616:
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)(15.0F * this.jdField_a_of_type_Float), (int)(10.0F * this.jdField_a_of_type_Float), (int)(15.0F * this.jdField_a_of_type_Float), (int)(10.0F * this.jdField_a_of_type_Float));
      break label409;
      label662:
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#66000000"));
      break label536;
      label678:
      paramsnv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(sow paramsow)
  {
    if (paramsow == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo articleURl = " + paramsow.jdField_b_of_type_JavaLangString + "; puin=" + paramsow.jdField_c_of_type_JavaLangString + "; imageUrl=" + paramsow.d);
    }
    this.jdField_a_of_type_Sow = paramsow;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Sow.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Sow.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setPhotoCollectionInfo(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setGetPhotoCollectionInfoError isError = " + paramBoolean);
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  boolean a(int paramInt, View paramView)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramView == null) {
      bool1 = false;
    }
    label38:
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramInt != 1) {
            break label38;
          }
          if (paramView.getTag() == null) {
            break;
          }
          bool1 = bool2;
        } while ((paramView.getTag() instanceof snv));
        return false;
        bool1 = bool2;
      } while (paramInt != 0);
      if (paramView.getTag() == null) {
        break;
      }
      bool1 = bool2;
    } while ((paramView.getTag() instanceof snu));
    return false;
  }
  
  public int[] a(soy paramsoy)
  {
    int[] arrayOfInt = new int[2];
    if (paramsoy != null)
    {
      if (paramsoy.jdField_a_of_type_Int <= this.jdField_f_of_type_Int) {
        break label75;
      }
      arrayOfInt[0] = this.jdField_f_of_type_Int;
      if (paramsoy.jdField_b_of_type_Int / paramsoy.jdField_a_of_type_Int > this.jdField_e_of_type_Int / this.jdField_f_of_type_Int) {
        arrayOfInt[1] = this.jdField_e_of_type_Int;
      }
    }
    else
    {
      return arrayOfInt;
    }
    arrayOfInt[1] = (this.jdField_f_of_type_Int * paramsoy.jdField_b_of_type_Int / paramsoy.jdField_a_of_type_Int);
    return arrayOfInt;
    label75:
    arrayOfInt[0] = paramsoy.jdField_a_of_type_Int;
    if (paramsoy.jdField_b_of_type_Int > this.jdField_e_of_type_Int)
    {
      arrayOfInt[1] = this.jdField_e_of_type_Int;
      return arrayOfInt;
    }
    arrayOfInt[1] = paramsoy.jdField_b_of_type_Int;
    return arrayOfInt;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Sop != null) {
      this.jdField_a_of_type_Sop.a(this.jdField_b_of_type_JavaUtilArrayList);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setGetRecommendInfoError isError = " + paramBoolean);
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Sow != null)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString);
      localIntent.setFlags(67108864);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setIsFollowed isFollowed = " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    f();
  }
  
  void d()
  {
    Object localObject = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      localObject = ((akdh)localObject).a(this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString);
      if ((localObject != null) && (sgg.a(((AccountDetail)localObject).accountFlag) != -4)) {
        break label156;
      }
      localObject = new NewIntent(this.jdField_a_of_type_AndroidContentContext, nor.class);
      ((NewIntent)localObject).putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      localFollowRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString));
      localFollowRequest.ext.set("21");
      ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new snr(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
    }
    for (;;)
    {
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString, 21);
      return;
      label156:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akwr);
      this.jdField_a_of_type_Akwr = new akwr(new sns(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akwr);
      akww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_Sow.jdField_c_of_type_JavaLangString, 21);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    View localView1 = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getParent()).getChildAt(1);
    View localView2 = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getParent()).getChildAt(2);
    if ((localView2 == null) || (localView1 == null)) {
      return;
    }
    if (paramBoolean)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(0);
      return;
    }
    localView2.setVisibility(8);
    localView1.setVisibility(8);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size() + 2;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == getCount() - 1) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    this.jdField_d_of_type_Int = 0;
    int i = getItemViewType(paramInt);
    if (a(i, paramView)) {
      switch (i)
      {
      default: 
        localObject1 = null;
        localObject2 = null;
        if (i == 1) {
          a((snv)localObject2, paramInt);
        }
        break;
      }
    }
    for (;;)
    {
      paramView.setLongClickable(true);
      paramView.setOnTouchListener(new snp(this, paramInt));
      return paramView;
      localObject1 = (snu)paramView.getTag();
      localObject2 = null;
      break;
      localObject2 = (snv)paramView.getTag();
      ((snv)localObject2).jdField_a_of_type_Int = paramInt;
      paramView.setTag(localObject2);
      localObject1 = null;
      break;
      switch (i)
      {
      default: 
        localObject2 = localObject3;
      }
      for (;;)
      {
        break;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559431, paramViewGroup, false);
        localObject1 = paramView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = this.jdField_e_of_type_Int;
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = new snu();
        ((snu)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = ((ZImageView)paramView.findViewById(2131367827));
        ((snu)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)paramView.findViewById(2131367828));
        ((snu)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367829));
        ((snu)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367834));
        ((snu)localObject1).d = ((TextView)paramView.findViewById(2131367835));
        ((snu)localObject1).c = ((TextView)paramView.findViewById(2131367830));
        ((snu)localObject1).b = ((TextView)paramView.findViewById(2131367822));
        ((snu)localObject1).b = ((TextView)paramView.findViewById(2131367822));
        ((snu)localObject1).e = ((TextView)paramView.findViewById(2131367837));
        ((snu)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131367832));
        ((snu)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)paramView.findViewById(2131369817));
        ((snu)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367836);
        ((snu)localObject1).f = ((TextView)paramView.findViewById(2131367831));
        ((snu)localObject1).jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_AndroidWidgetButton = ((snu)localObject1).jdField_a_of_type_AndroidWidgetButton;
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView = ((snu)localObject1).jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView = ((snu)localObject1).e;
        paramView.setTag(localObject1);
        break;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559432, paramViewGroup, false);
        localObject2 = new snv();
        ((snv)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)paramView.findViewById(2131372104));
        ((snv)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = ((ZImageView)paramView.findViewById(2131372094));
        ((snv)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367787));
        ((snv)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)paramView.findViewById(2131369817));
        ((snv)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375503);
        ((snv)localObject2).jdField_a_of_type_Int = paramInt;
        paramView.setTag(localObject2);
      }
      if (i != 0) {
        break label589;
      }
      a((snu)localObject1);
    }
    label589:
    if (i == 2) {
      if (!this.jdField_g_of_type_Boolean)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          break label788;
        }
        localObject1 = "";
        i = 0;
        while ((this.jdField_b_of_type_JavaUtilArrayList.size() > i) && (i < 6))
        {
          localObject2 = (soz)this.jdField_b_of_type_JavaUtilArrayList.get(i);
          localObject1 = (String)localObject1 + ((soz)localObject2).d + "&";
          i += 1;
        }
      }
    }
    for (;;)
    {
      nol.a(null, this.jdField_c_of_type_JavaLangString, "0X8007B93", "0X8007B93", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1, "", false);
      this.jdField_g_of_type_Boolean = true;
      if (this.jdField_a_of_type_Sop == null) {
        this.jdField_a_of_type_Sop = new sop(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Sop != null)
      {
        paramView = this.jdField_a_of_type_Sop.a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramViewGroup);
        break;
      }
      break;
      label788:
      localObject1 = "";
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      nol.a(null, this.jdField_c_of_type_JavaLangString, "0X8007B8E", "0X8007B8E", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", false);
      d();
    }
    while (paramView != this.jdField_a_of_type_AndroidViewView) {
      return;
    }
    nol.a(null, this.jdField_c_of_type_JavaLangString, "0X8007B8D", "0X8007B8D", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", false);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     snn
 * JD-Core Version:    0.7.0.1
 */