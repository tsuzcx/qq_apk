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

public class sau
  extends BaseAdapter
  implements View.OnClickListener
{
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int = 0;
  private akig jdField_a_of_type_Akig;
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
  public ArrayList<scf> a;
  private sbk jdField_a_of_type_Sbk = new sav(this);
  private sbw jdField_a_of_type_Sbw;
  private scd jdField_a_of_type_Scd;
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  String jdField_b_of_type_JavaLangString = "";
  private ArrayList<scg> jdField_b_of_type_JavaUtilArrayList;
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
  
  public sau(Context paramContext, PublicAccountImageCollectionListView paramPublicAccountImageCollectionListView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView = paramPublicAccountImageCollectionListView;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.a(this.jdField_a_of_type_Sbk);
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
  
  private void a(ZImageView paramZImageView, rcw paramrcw, ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
    if ((paramrcw == null) || (paramrcw.jdField_a_of_type_JavaNetURL == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url is empty! use default preload image");
      }
      paramZImageView.setImageDrawable(localColorDrawable);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url = " + paramrcw.jdField_a_of_type_JavaNetURL + " reqWidth = " + paramrcw.jdField_a_of_type_Int + " reqHeight = " + paramrcw.jdField_b_of_type_Int);
    }
    if (axoa.a(paramrcw.jdField_a_of_type_JavaNetURL.toString()) != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        PublicAccountImageCollectionPreloadManager.a().a(true, paramInt);
      }
      for (;;)
      {
        long l = NetConnInfoCenter.getServerTimeMillis();
        paramZImageView.a(localColorDrawable).a(paramrcw, new sba(this, bool, l, paramImageProgressCircle));
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
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131629933));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841124));
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
    while ((TextUtils.isEmpty(this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString.equals("0"))) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838998));
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131629934));
  }
  
  private void g()
  {
    int j = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getLastVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getFirstVisiblePosition();
    int i = 0;
    if (i <= j - k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getChildAt(i);
      if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof sbc)))
      {
        localObject = (sbc)((View)localObject).getTag();
        if (((sbc)localObject).jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          break label97;
        }
        this.jdField_f_of_type_Boolean = false;
        ((sbc)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        label97:
        this.jdField_f_of_type_Boolean = true;
        ((sbc)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    if (this.jdField_f_of_type_Boolean)
    {
      d(true);
      return;
    }
    ndn.a(null, this.jdField_c_of_type_JavaLangString, "0X8007B92", "0X8007B92", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", false);
    d(false);
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) || (!(this.jdField_b_of_type_AndroidViewView.getTag() instanceof sbc))) {}
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
      localObject = (scf)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_d_of_type_Int - 1);
      str = ((scf)localObject).jdField_a_of_type_JavaLangString;
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
    ndn.a(null, this.jdField_c_of_type_JavaLangString, "0X8007B91", "0X8007B91", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, ((scf)localObject).jdField_a_of_type_JavaLangString, "2", false);
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
    if (this.jdField_a_of_type_Sbk != null) {
      this.jdField_a_of_type_Sbk = null;
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akig);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131642986) + str);
      return;
      label77:
      if (paramInt > 100000)
      {
        double d1 = paramInt / 100000.0D;
        str = new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString() + ajjy.a(2131643009);
      }
    }
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new sbd(this, null));
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
  
  public void a(ArrayList<scg> paramArrayList)
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
  
  void a(sbb paramsbb)
  {
    if (this.jdField_a_of_type_Scd == null)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover getPhotoCollectionInfo error");
        }
        paramsbb.f.setVisibility(0);
        a(paramsbb.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
        ((PublicAccountImageCollectionMainActivity)this.jdField_a_of_type_AndroidAppActivity).g();
        return;
      }
      paramsbb.f.setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_Scd.jdField_a_of_type_Sce != null) && (QLog.isColorLevel())) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover title =" + this.jdField_a_of_type_Scd.e + "; coverUrl =" + this.jdField_a_of_type_Scd.jdField_a_of_type_Sce.jdField_a_of_type_JavaLangString + "; accountName = " + this.jdField_a_of_type_Scd.jdField_a_of_type_Sce.jdField_b_of_type_JavaLangString + "; author=" + this.jdField_a_of_type_Scd.jdField_a_of_type_Sce.d + "; time =" + this.jdField_a_of_type_Scd.jdField_a_of_type_Sce.jdField_c_of_type_JavaLangString);
    }
    paramsbb.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramsbb.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Scd.e);
    Object localObject = "" + this.jdField_g_of_type_Int;
    if (this.jdField_g_of_type_Int > 1000000)
    {
      localObject = "100万+";
      paramsbb.e.setText(ajjy.a(2131642976) + (String)localObject);
      localObject = this.jdField_a_of_type_Scd.jdField_a_of_type_Sce;
      if (localObject != null)
      {
        paramsbb.d.setText(((sce)localObject).jdField_b_of_type_JavaLangString);
        paramsbb.b.setText(((sce)localObject).d);
        paramsbb.c.setText(((sce)localObject).jdField_c_of_type_JavaLangString);
        if (TextUtils.isEmpty(((sce)localObject).jdField_b_of_type_JavaLangString)) {
          break label636;
        }
        paramsbb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramsbb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString));
      }
    }
    for (;;)
    {
      rcw localrcw = new rcw();
      localrcw.jdField_a_of_type_JavaNetURL = a(((sce)localObject).jdField_a_of_type_JavaLangString);
      a(paramsbb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView, localrcw, paramsbb.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, 0);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString.equals("0")))
      {
        new RelativeLayout.LayoutParams(-1, -1).setMargins(aciy.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
        paramsbb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramsbb.e.setTextSize(2, 14.0F);
        paramsbb.d.setVisibility(8);
        paramsbb.b.setTextSize(2, 14.0F);
        paramsbb.c.setTextSize(2, 14.0F);
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
      localObject = new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString() + ajjy.a(2131643027);
      break;
      label636:
      paramsbb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  void a(sbc paramsbc, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageFeeds mPhotoItemInfo is null");
      }
    }
    scf localscf;
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
        localscf = (scf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
      } while ((localscf == null) || (localscf.jdField_a_of_type_Int == 0) || (this.jdField_f_of_type_Int == 0));
      if (localscf.jdField_b_of_type_Int / localscf.jdField_a_of_type_Int <= this.jdField_e_of_type_Int / this.jdField_f_of_type_Int) {
        break;
      }
      i = this.jdField_e_of_type_Int;
      localscf.jdField_a_of_type_Boolean = true;
      localObject = (RelativeLayout.LayoutParams)paramsbc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)paramsbc.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams1 = paramsbc.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.jdField_f_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).height = i;
      paramsbc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localURL = a(localscf.jdField_a_of_type_JavaLangString);
    } while (localURL == null);
    rcw localrcw = new rcw();
    localrcw.jdField_a_of_type_JavaNetURL = localURL;
    localrcw.jdField_a_of_type_Int = a(localscf)[0];
    localrcw.jdField_b_of_type_Int = a(localscf)[1];
    a(paramsbc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView, localrcw, paramsbc.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramsbc.jdField_a_of_type_Int);
    int j;
    if ((localscf.jdField_a_of_type_Int / localscf.jdField_b_of_type_Int > 1.3D) && (!TextUtils.isEmpty(localscf.jdField_b_of_type_JavaLangString)) && (!localscf.jdField_b_of_type_JavaLangString.equals(" ")))
    {
      j = 1;
      label290:
      if (j == 0) {
        break label594;
      }
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setMinHeight(aciy.a(97.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams1.height = (((RelativeLayout.LayoutParams)localObject).height + aciy.a(97.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      label348:
      if (i <= this.jdField_e_of_type_Int - (int)(88.0F * this.jdField_a_of_type_Float)) {
        break label616;
      }
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)(15.0F * this.jdField_a_of_type_Float), (int)(10.0F * this.jdField_a_of_type_Float), (int)(15.0F * this.jdField_a_of_type_Float), (int)(44.0F * this.jdField_a_of_type_Float));
      label409:
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      paramsbc.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams1);
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(3);
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
      localObject = paramInt + "/" + this.jdField_a_of_type_JavaUtilArrayList.size() + "  " + localscf.jdField_b_of_type_JavaLangString;
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if ((!TextUtils.isEmpty(localscf.jdField_b_of_type_JavaLangString)) && (!localscf.jdField_b_of_type_JavaLangString.equals(" "))) {
        break label662;
      }
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(0);
      label536:
      if (this.jdField_f_of_type_Boolean) {
        break label678;
      }
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new sax(this));
      return;
      i = this.jdField_f_of_type_Int * localscf.jdField_b_of_type_Int / localscf.jdField_a_of_type_Int;
      break;
      j = 0;
      break label290;
      label594:
      localLayoutParams1.height = ((RelativeLayout.LayoutParams)localObject).height;
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
      break label348;
      label616:
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)(15.0F * this.jdField_a_of_type_Float), (int)(10.0F * this.jdField_a_of_type_Float), (int)(15.0F * this.jdField_a_of_type_Float), (int)(10.0F * this.jdField_a_of_type_Float));
      break label409;
      label662:
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#66000000"));
      break label536;
      label678:
      paramsbc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(scd paramscd)
  {
    if (paramscd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo articleURl = " + paramscd.jdField_b_of_type_JavaLangString + "; puin=" + paramscd.jdField_c_of_type_JavaLangString + "; imageUrl=" + paramscd.d);
    }
    this.jdField_a_of_type_Scd = paramscd;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Scd.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Scd.jdField_a_of_type_JavaUtilArrayList;
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
        } while ((paramView.getTag() instanceof sbc));
        return false;
        bool1 = bool2;
      } while (paramInt != 0);
      if (paramView.getTag() == null) {
        break;
      }
      bool1 = bool2;
    } while ((paramView.getTag() instanceof sbb));
    return false;
  }
  
  public int[] a(scf paramscf)
  {
    int[] arrayOfInt = new int[2];
    if (paramscf != null)
    {
      if (paramscf.jdField_a_of_type_Int <= this.jdField_f_of_type_Int) {
        break label75;
      }
      arrayOfInt[0] = this.jdField_f_of_type_Int;
      if (paramscf.jdField_b_of_type_Int / paramscf.jdField_a_of_type_Int > this.jdField_e_of_type_Int / this.jdField_f_of_type_Int) {
        arrayOfInt[1] = this.jdField_e_of_type_Int;
      }
    }
    else
    {
      return arrayOfInt;
    }
    arrayOfInt[1] = (this.jdField_f_of_type_Int * paramscf.jdField_b_of_type_Int / paramscf.jdField_a_of_type_Int);
    return arrayOfInt;
    label75:
    arrayOfInt[0] = paramscf.jdField_a_of_type_Int;
    if (paramscf.jdField_b_of_type_Int > this.jdField_e_of_type_Int)
    {
      arrayOfInt[1] = this.jdField_e_of_type_Int;
      return arrayOfInt;
    }
    arrayOfInt[1] = paramscf.jdField_b_of_type_Int;
    return arrayOfInt;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Sbw != null) {
      this.jdField_a_of_type_Sbw.a(this.jdField_b_of_type_JavaUtilArrayList);
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
    if (this.jdField_a_of_type_Scd != null)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString);
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
    Object localObject = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      localObject = ((ajoy)localObject).a(this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString);
      if ((localObject != null) && (rtr.a(((AccountDetail)localObject).accountFlag) != -4)) {
        break label156;
      }
      localObject = new NewIntent(this.jdField_a_of_type_AndroidContentContext, ndt.class);
      ((NewIntent)localObject).putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      localFollowRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString));
      localFollowRequest.ext.set("21");
      ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new say(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
    }
    for (;;)
    {
      ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString, 21);
      return;
      label156:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akig);
      this.jdField_a_of_type_Akig = new akig(new saz(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akig);
      akil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_Scd.jdField_c_of_type_JavaLangString, 21);
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
          a((sbc)localObject2, paramInt);
        }
        break;
      }
    }
    for (;;)
    {
      paramView.setLongClickable(true);
      paramView.setOnTouchListener(new saw(this, paramInt));
      return paramView;
      localObject1 = (sbb)paramView.getTag();
      localObject2 = null;
      break;
      localObject2 = (sbc)paramView.getTag();
      ((sbc)localObject2).jdField_a_of_type_Int = paramInt;
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
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493863, paramViewGroup, false);
        localObject1 = paramView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = this.jdField_e_of_type_Int;
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = new sbb();
        ((sbb)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = ((ZImageView)paramView.findViewById(2131302208));
        ((sbb)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)paramView.findViewById(2131302209));
        ((sbb)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302210));
        ((sbb)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302215));
        ((sbb)localObject1).d = ((TextView)paramView.findViewById(2131302216));
        ((sbb)localObject1).c = ((TextView)paramView.findViewById(2131302211));
        ((sbb)localObject1).b = ((TextView)paramView.findViewById(2131302203));
        ((sbb)localObject1).b = ((TextView)paramView.findViewById(2131302203));
        ((sbb)localObject1).e = ((TextView)paramView.findViewById(2131302218));
        ((sbb)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131302213));
        ((sbb)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)paramView.findViewById(2131304145));
        ((sbb)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131302217);
        ((sbb)localObject1).f = ((TextView)paramView.findViewById(2131302212));
        ((sbb)localObject1).jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_AndroidWidgetButton = ((sbb)localObject1).jdField_a_of_type_AndroidWidgetButton;
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView = ((sbb)localObject1).jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView = ((sbb)localObject1).e;
        paramView.setTag(localObject1);
        break;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493864, paramViewGroup, false);
        localObject2 = new sbc();
        ((sbc)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)paramView.findViewById(2131306407));
        ((sbc)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = ((ZImageView)paramView.findViewById(2131306397));
        ((sbc)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302169));
        ((sbc)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)paramView.findViewById(2131304145));
        ((sbc)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131309746);
        ((sbc)localObject2).jdField_a_of_type_Int = paramInt;
        paramView.setTag(localObject2);
      }
      if (i != 0) {
        break label589;
      }
      a((sbb)localObject1);
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
          localObject2 = (scg)this.jdField_b_of_type_JavaUtilArrayList.get(i);
          localObject1 = (String)localObject1 + ((scg)localObject2).d + "&";
          i += 1;
        }
      }
    }
    for (;;)
    {
      ndn.a(null, this.jdField_c_of_type_JavaLangString, "0X8007B93", "0X8007B93", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1, "", false);
      this.jdField_g_of_type_Boolean = true;
      if (this.jdField_a_of_type_Sbw == null) {
        this.jdField_a_of_type_Sbw = new sbw(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Sbw != null)
      {
        paramView = this.jdField_a_of_type_Sbw.a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramViewGroup);
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
      ndn.a(null, this.jdField_c_of_type_JavaLangString, "0X8007B8E", "0X8007B8E", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", false);
      d();
    }
    while (paramView != this.jdField_a_of_type_AndroidViewView) {
      return;
    }
    ndn.a(null, this.jdField_c_of_type_JavaLangString, "0X8007B8D", "0X8007B8D", 0, 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "", false);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     sau
 * JD-Core Version:    0.7.0.1
 */