import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyDoubleImageView.1;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyDoubleImageView.5;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;

public class ogr
  extends ViewBase
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private View jdField_a_of_type_AndroidViewView;
  private ReadInjoyCutImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView;
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private oeo jdField_a_of_type_Oeo = new oeo();
  private ogp jdField_a_of_type_Ogp;
  private ogq jdField_a_of_type_Ogq;
  private pgd jdField_a_of_type_Pgd;
  private int jdField_b_of_type_Int = -1;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
  private NativeReadInjoyImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private Boolean jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(true);
  private ogq jdField_b_of_type_Ogq;
  private int c = -1;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ogr(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private int a()
  {
    return this.jdField_a_of_type_Int - getComMeasuredHeight();
  }
  
  private int a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.a())))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.a().equals(paramArrayList.get(i))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  private Boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    float f1 = this.jdField_a_of_type_Ogq.d;
    float f2 = this.jdField_a_of_type_Ogq.c;
    float f3 = this.jdField_b_of_type_Ogq.d;
    float f4 = this.jdField_b_of_type_Ogq.c;
    if (f1 == f3)
    {
      if (paramFloat2 <= f1) {}
      for (;;)
      {
        return Boolean.valueOf(bool1);
        bool1 = false;
      }
    }
    if (f2 == f4)
    {
      if (paramFloat1 < f2) {}
      for (bool1 = bool2;; bool1 = false) {
        return Boolean.valueOf(bool1);
      }
    }
    float f5 = (f1 - f3) / (f2 - f4);
    if ((paramFloat2 - (f3 * f2 - f1 * f4) / (f2 - f4)) / f5 > paramFloat1) {}
    for (bool1 = bool3;; bool1 = false) {
      return Boolean.valueOf(bool1);
    }
  }
  
  private Boolean a(View paramView, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramView == null) {
      return Boolean.valueOf(false);
    }
    int j = paramView.getHeight();
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    paramView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    if (!paramBoolean) {}
    for (int i = this.jdField_a_of_type_AndroidGraphicsRect.height();; i = this.jdField_a_of_type_AndroidGraphicsRect.height() - this.f)
    {
      paramBoolean = bool;
      if (i > j >> 1) {
        paramBoolean = true;
      }
      return Boolean.valueOf(paramBoolean);
    }
  }
  
  private ogq a(String paramString)
  {
    paramString = paramString.split(",");
    if (paramString.length == 2)
    {
      float f1 = Float.parseFloat(paramString[0]);
      float f2 = Float.parseFloat(paramString[1]);
      float f3 = f1 / this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialWidth;
      float f4 = -f2 / this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialHeight;
      if ((f3 >= 0.0F) && (f3 <= 1.0F) && (f4 >= -1.0F) && (f4 <= 0.0F)) {
        return new ogq(f3, f4, f1, f2);
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.m = paramInt1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.materialGroup = paramInt2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickType = 2;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131559884, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368686));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368688));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView = ((ReadInjoyCutImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368687));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(8);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(8);
  }
  
  private void a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView != null)
    {
      localObject2 = paramView.getContext();
      paramView = (View)localObject1;
      for (localObject1 = localObject2;; localObject1 = ((ContextWrapper)localObject1).getBaseContext())
      {
        localObject2 = paramView;
        if (!(localObject1 instanceof ContextWrapper)) {
          break;
        }
        if ((localObject1 instanceof Activity)) {
          paramView = (Activity)localObject1;
        }
      }
    }
    if ((localObject2 != null) && (((Activity)localObject2).getWindow() != null))
    {
      paramView = ((Activity)localObject2).getWindow().getDecorView().findViewById(16908307);
      if (paramView != null)
      {
        this.jdField_a_of_type_Int = paramView.getTop();
        this.f = paramView.getMeasuredHeight();
      }
    }
    if ((this.jdField_a_of_type_Pgd != null) && (this.jdField_a_of_type_Pgd.a() != null) && (this.jdField_a_of_type_Pgd.a().a() != null))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Pgd.a().a().getPaddingTop();
      this.c = this.jdField_a_of_type_Pgd.a().a().getTop();
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Pgd.a().a().getBottom();
      }
    }
    for (;;)
    {
      this.d = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyDoubleImageView", 2, "initQQUIHeight cannot get listview's too and padding.");
      }
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = paramString.split("\\|");
    if (localObject.length == 2)
    {
      paramString = localObject[0];
      localObject = localObject[1];
      this.jdField_a_of_type_Ogq = a(paramString);
      this.jdField_b_of_type_Ogq = a((String)localObject);
    }
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.a(paramDrawable);
    }
    paramDrawable = URLDrawable.URLDrawableOptions.obtain();
    paramDrawable.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramDrawable = URLDrawable.getDrawable(paramString, paramDrawable);
    if ((paramDrawable != null) && (paramDrawable.getStatus() == 2)) {
      paramDrawable.restartDownload();
    }
    do
    {
      return;
      if ((paramDrawable != null) && (paramDrawable.getStatus() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInjoyDoubleImageView", 2, "status=URLDrawable.SUCCESSED:" + paramString);
        }
        this.jdField_a_of_type_Ogp = new ogp(paramDrawable.getCurrDrawable(), this.d, this.jdField_a_of_type_Int - (this.jdField_b_of_type_Int + this.c));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_Ogp);
        this.jdField_a_of_type_JavaLangString = paramString;
        return;
      }
    } while (paramDrawable == null);
    paramDrawable.setURLDrawableListener(new ogs(this, paramString));
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    if ((oee.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView, (String)paramArrayList.get(this.e), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setIsShowSrc(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(0);
      this.e = ((this.e + 1) % paramArrayList.size());
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)paramArrayList.get(this.e), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      if (!oee.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.getVideoCoverUrlWithSmartCut(false);
        if (localObject == null) {
          break label158;
        }
      }
    }
    label158:
    for (Object localObject = ((URL)localObject).getFile();; localObject = null)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)localObject, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractType == 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractImageList))) {
        a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractImageList, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.i == 1009) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList != null))
      {
        this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImgList;
        this.e = 0;
        a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.post(new ReadInjoyDoubleImageView.1(this));
      }
      return;
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Int == -1) || (this.jdField_b_of_type_Int == -1)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImg)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImg.equals(this.jdField_a_of_type_JavaLangString))) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImg, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.c)) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialWidth == 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialHeight == 0) || (this.jdField_a_of_type_JavaLangRunnable != null) || (this.jdField_a_of_type_Oeo.a() != null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView == null)) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.c);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setOnTouchListener(new ogt(this));
    if ((this.jdField_a_of_type_Ogq != null) && (this.jdField_b_of_type_Ogq != null)) {
      this.jdField_a_of_type_Oeo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView, this.jdField_a_of_type_Ogq, this.jdField_b_of_type_Ogq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.l, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.o);
    }
    this.jdField_a_of_type_Oeo.a(new ogu(this));
    this.jdField_a_of_type_JavaLangRunnable = new ReadInjoyDoubleImageView.5(this);
    this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getVisibility() == 0) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(8);
      b();
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setAlpha(paramFloat);
    if (paramFloat > 0.0F)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if (a() < 0) {}
    int i;
    do
    {
      return;
      i = paramInt2;
      if (paramInt2 < a())
      {
        i = paramInt2;
        if (paramInt3 == 2)
        {
          i = paramInt2;
          if (this.g + 1 != paramInt2)
          {
            i = paramInt2;
            if (this.g != 0)
            {
              i = paramInt2;
              if (Math.abs(paramInt2 - this.g) > 3)
              {
                i = paramInt2;
                if (paramDouble <= 0.0D)
                {
                  i = paramInt2;
                  if (paramInt2 <= this.g) {
                    i = this.g + 1;
                  }
                }
              }
            }
          }
        }
      }
      if (this.g != i) {
        this.g = i;
      }
    } while (this.jdField_a_of_type_Ogp == null);
    if (this.jdField_a_of_type_Ogp.getCallback() == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_Ogp);
    }
    paramInt2 = -(Math.abs(i) - Math.abs(this.jdField_b_of_type_Int));
    if (i <= 0) {
      paramInt2 = this.jdField_b_of_type_Int + Math.abs(i);
    }
    this.jdField_a_of_type_Ogp.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    float f3 = 0.0F;
    float f2 = 1.0F;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    do
    {
      return;
      switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractEffectType)
      {
      default: 
        return;
      }
    } while ((paramInt1 <= 0) || (paramInt2 <= 0));
    float f1 = paramInt3 / paramInt1;
    if (paramBoolean) {
      f1 = 1.0F - paramInt4 * 1.0F / paramInt1;
    }
    if (f1 < 0.0F) {
      f1 = f3;
    }
    for (;;)
    {
      if (f1 > 1.0F) {
        f1 = f2;
      }
      for (;;)
      {
        a(f1);
        return;
      }
    }
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: path is " + paramString);
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label80;
      }
      if (paramDrawable != null) {
        paramNativeReadInjoyImageView.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      paramNativeReadInjoyImageView.setImageSrc(paramString);
    }
    label80:
    do
    {
      return;
      paramString = ImageCommon.getDrawableResourceId(paramString);
    } while (paramString == null);
    QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: cant find in offline dir, try to load from resources");
    try
    {
      paramNativeReadInjoyImageView.setImageDrawable(paramNativeReadInjoyImageView.getResources().getDrawable(paramString.intValue()));
      return;
    }
    catch (Resources.NotFoundException paramNativeReadInjoyImageView)
    {
      QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: cant find in resources dir, do nothing");
    }
  }
  
  public void a(pgd parampgd)
  {
    this.jdField_a_of_type_Pgd = parampgd;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (oee.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
      d();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (oee.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.getHeight() != 0) && (this.jdField_a_of_type_JavaLangRunnable != null))
    {
      this.jdField_a_of_type_JavaLangBoolean = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView, paramBoolean);
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        break label90;
      }
      if (!this.jdField_b_of_type_JavaLangBoolean.booleanValue())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.post(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
    }
    return;
    label90:
    b();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView != null)
    {
      this.jdField_a_of_type_Oeo.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    c();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView != null)
    {
      this.jdField_a_of_type_Oeo.a();
      this.jdField_a_of_type_Oeo.a(null);
      this.jdField_a_of_type_Oeo = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setImageSrc(null);
    }
    if (this.jdField_a_of_type_Ogp != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(null);
      this.jdField_a_of_type_Ogp.a();
      this.jdField_a_of_type_Ogp = null;
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        try
        {
          if ((paramObject instanceof AdvertisementInfo))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
            return true;
          }
        }
        catch (Exception paramObject)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
          QLog.d("ReadInjoyDoubleImageView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ogr
 * JD-Core Version:    0.7.0.1
 */